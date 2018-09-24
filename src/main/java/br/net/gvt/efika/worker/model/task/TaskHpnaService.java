package br.net.gvt.efika.worker.model.task;

import br.net.gvt.efika.efika_customer.model.customer.enums.TecnologiaTv;
import br.net.gvt.efika.queue.model.dto.input.HpnaInput;
import br.net.gvt.efika.queue.model.dto.input.ManobraInput;
import br.net.gvt.efika.queue.model.dto.output.HpnaResponse;
import br.net.gvt.efika.queue.model.dto.output.ManobraResponse;
import br.net.gvt.efika.queue.model.dto.task.QueueTaskDTO;
import br.net.gvt.efika.queue.model.enuns.TaskResultState;
import br.net.gvt.efika.queue.model.enuns.TasksEnum;
import br.net.gvt.efika.util.dao.http.Urls;
import br.net.gvt.efika.worker.io.swagger.model.GenericRequest;
import br.net.gvt.efika.worker.model.FulltestManobraIn;
import br.net.gvt.efika.worker.model.WorkOrder;
import br.net.gvt.efika.worker.model.task.laborer.TaskLaborerAbstract;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@telefonica.com
 * System Analyst
 * 41 9 9513-0230
 **/
public class TaskHpnaService extends TaskLaborerAbstract{

    public TaskHpnaService(QueueTaskDTO task) {
        super(task);
    }

    @Override
    public void processar() {
        HpnaInput input = (HpnaInput) task.getInput();
        GenericRequest req = new GenericRequest(input.getInstancia(), task.getExecutor());
        HpnaResponse ret = new HpnaResponse();
        ret.setInstancia(input.getInstancia());
        //ADD FULLTEST_MANOBRA
        /**
         * Nao foi possivel usar a classe padrao.
         * utilizei a classe unirest para realizar a entrega da sprint
         * porem precisamos padronizar ;)
         * beijos
         */
        try {




                //region Chamar HPNA
            HashMap<String, Object> map = new HashMap<>();
            map.put("executor", req.getExecutor());
            map.put("cust", input.getCustomer());
            JSONObject jsonObj = new JSONObject(map);
            HttpResponse<String> res = Unirest.post(Urls.CUSTOMERAPI_HPNA.getUrl())
                    .header("Content-Type", "application/json")
                    .body(jsonObj)
                    .asString();
            System.out.println(res.getBody());
            Gson toHash = new Gson();
            ret.setResposta(toHash.fromJson(res.getBody(), HashMap.class));
                //endregion
//            }

        }catch (Exception e){
            ret.setExceptionMessage(e.getMessage());
            ret.setState(TaskResultState.EXCEPTION);
        }finally {
            this.task.setOutput(ret);
        }
    }
}