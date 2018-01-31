/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.task.laborer;

import br.net.gvt.efika.customer.EfikaCustomer;
import br.net.gvt.efika.worker.dao.factory.FactoryDAO;
import br.net.gvt.efika.worker.dao.http.ContentType;
import br.net.gvt.efika.worker.dao.http.Urls;
import io.swagger.model.GenericRequest;
import java.nio.charset.Charset;
import model.dto.input.CadastroInput;
import model.dto.output.CadastroResponse;
import model.dto.task.QueueTaskDTO;
import model.enuns.TaskResultState;
import util.JacksonMapper;

public class TaskLaborerCadastroServiceImpl extends TaskLaborerAbstract {

    public TaskLaborerCadastroServiceImpl(QueueTaskDTO task) {
        super(task);
    }

    @Override
    public void processar() {
        CadastroInput input = (CadastroInput) task.getInput();
        GenericRequest req = new GenericRequest(input.getInstancia(), task.getExecutor());
        CadastroResponse ret = new CadastroResponse();
        ret.setInstancia(input.getInstancia());
        try {
//            System.out.println("REQPARACUSTOMERAPI -> " + new JacksonMapper(GenericRequest.class).serialize(req));
            JacksonMapper<EfikaCustomer> mapper = new JacksonMapper(EfikaCustomer.class);
            ret.setCustomer(mapper.deserialize(FactoryDAO.createHttpDAO().post(Urls.CUSTOMERAPI_CADASTRO.getUrl(),
                    req,
                    ContentType.JSON.getCont(), Charset.forName("UTF-8"))));
            ret.setState(TaskResultState.OK);
        } catch (Exception e) {
            ret.setExceptionMessage(e.getMessage());
            ret.setState(TaskResultState.EXCEPTION);
        }

        this.task.setOutput(ret);
    }

}
