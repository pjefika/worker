package br.net.gvt.efika.worker.model.task;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.efika_customer.model.customer.enums.TecnologiaTv;
import br.net.gvt.efika.queue.model.dto.input.CadastroInput;
import br.net.gvt.efika.queue.model.dto.input.ManobraInput;
import br.net.gvt.efika.queue.model.dto.output.CadastroResponse;
import br.net.gvt.efika.queue.model.dto.output.ManobraResponse;
import br.net.gvt.efika.queue.model.dto.task.QueueTaskDTO;
import br.net.gvt.efika.queue.model.enuns.TaskResultState;
import br.net.gvt.efika.queue.model.enuns.TasksEnum;
import br.net.gvt.efika.util.dao.http.HttpDAO;
import br.net.gvt.efika.util.dao.http.Urls;
import br.net.gvt.efika.worker.dao.factory.FactoryDAO;
import br.net.gvt.efika.worker.io.swagger.model.GenericRequest;
import br.net.gvt.efika.worker.model.Analitico;
import br.net.gvt.efika.worker.model.FulltestManobraIn;
import br.net.gvt.efika.worker.model.WorkOrder;
import br.net.gvt.efika.worker.model.task.laborer.TaskLaborerAbstract;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.json.JsonObject;
import java.util.HashMap;

/**
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@telefonica.com
 * System Analyst
 * 41 9 9513-0230
 **/
public class TaskManobraService extends TaskLaborerAbstract{

    public TaskManobraService(QueueTaskDTO task) {
        super(task);
    }

    @Override
    public void processar() {
        ManobraInput input = (ManobraInput) task.getInput();
        GenericRequest req = new GenericRequest(input.getInstancia(), task.getExecutor());
        ManobraResponse ret = new ManobraResponse();
        ret.setInstancia(input.getInstancia());
        //ADD FULLTEST_MANOBRA
        /**
         * Nao foi possivel usar a classe padrao.
         * utilizei a classe unirest para realizar a entrega da sprint
         * porem precisamos padronizar ;)
         * beijos
         */
        try {

            //region TESTES DE JSON MANUAL
//            HashMap<String, Object> map = new HashMap<>();
//            EfikaCustomer nEfika = new EfikaCustomer();
//            nEfika.setDesignador("CTA-81HRZBDSJ-013");
//            nEfika.setInstancia("4130189422");
//            nEfika.setDesignadorAcesso("CTA-05998289-069");
//            map.put("executor", "A0079821");
//            map.put("cust", "{\"designador\":\"CTA-81E2J3HSS-013\",\"instancia\":\"4131543457\",\"designadorAcesso\":\"CTA-04887444-069\",\"designadorTv\":\"TV-CTA-81E2J3HST-050\",\"rede\":{\"tipo\":\"METALICA\",\"origem\":\"ONLINE\",\"planta\":\"VIVO2\",\"ipDslam\":\"10.200.30.177\",\"vendorDslam\":\"KEYMILE\",\"modeloDslam\":\"SUVD11\",\"idOnt\":null,\"terminal\":null,\"ipMulticast\":null,\"nrc\":null,\"slot\":3,\"porta\":37,\"sequencial\":1085,\"logica\":1085,\"rin\":74,\"vlanVoip\":1074,\"vlanVod\":3074,\"vlanMulticast\":4000,\"cvlan\":1185,\"bhs\":null},\"redeExterna\":{\"tipo\":null,\"origem\":null,\"planta\":null,\"splitter1n\":null,\"splitter2n\":null,\"caboAlim\":null,\"fibra1n\":null,\"fibra2n\":null},\"servicos\":{\"velDown\":51200,\"velUp\":5120,\"tipoTv\":\"DTH\",\"tipoLinha\":\"TDM\"},\"linha\":{\"tipo\":\"TDM\",\"dn\":\"4131543457\",\"central\":\"PRCTA_PVS01\"},\"radius\":{\"status\":\"ATIVO\",\"armario\":\"PRCTA_O1C50\",\"rin\":\"074\",\"velocidade\":\"51200 - 5120\",\"ipFixo\":\"-\",\"profile\":\"r5120b51200\",\"porta\":\"1085\",\"isIpFixo\":false},\"asserts\":[{\"asserts\":\"DIVERGENCIA_TBS_RADIUS\",\"value\":false,\"creationDate\":1537303698895},{\"asserts\":\"CIRCUITO_ATIVO\",\"value\":true,\"creationDate\":1537303698895},{\"asserts\":\"HAS_BLOQUEIO_RADIUS\",\"value\":false,\"creationDate\":1537303698895}],\"eventos\":[]}");
//            //map.put("cust", nEfika);
//            String body = "{\"cust\":{\"designador\":\"CTA-81E2J3HSS-013\",\"instancia\":\"4131543457\",\"designadorAcesso\":\"CTA-04887444-069\",\"designadorTv\":\"TV-CTA-81E2J3HST-050\",\"rede\":{\"tipo\":\"METALICA\",\"origem\":\"ONLINE\",\"planta\":\"VIVO2\",\"ipDslam\":\"10.200.30.177\",\"vendorDslam\":\"KEYMILE\",\"modeloDslam\":\"SUVD11\",\"idOnt\":null,\"terminal\":null,\"ipMulticast\":null,\"nrc\":null,\"slot\":3,\"porta\":37,\"sequencial\":1085,\"logica\":1085,\"rin\":74,\"vlanVoip\":1074,\"vlanVod\":3074,\"vlanMulticast\":4000,\"cvlan\":1185,\"bhs\":null},\"redeExterna\":{\"tipo\":null,\"origem\":null,\"planta\":null,\"splitter1n\":null,\"splitter2n\":null,\"caboAlim\":null,\"fibra1n\":null,\"fibra2n\":null},\"servicos\":{\"velDown\":51200,\"velUp\":5120,\"tipoTv\":\"DTH\",\"tipoLinha\":\"TDM\"},\"linha\":{\"tipo\":\"TDM\",\"dn\":\"4131543457\",\"central\":\"PRCTA_PVS01\"},\"radius\":{\"status\":\"ATIVO\",\"armario\":\"PRCTA_O1C50\",\"rin\":\"074\",\"velocidade\":\"51200 - 5120\",\"ipFixo\":\"-\",\"profile\":\"r5120b51200\",\"porta\":\"1085\",\"isIpFixo\":false},\"asserts\":[{\"asserts\":\"DIVERGENCIA_TBS_RADIUS\",\"value\":false,\"creationDate\":1537303698895},{\"asserts\":\"CIRCUITO_ATIVO\",\"value\":true,\"creationDate\":1537303698895},{\"asserts\":\"HAS_BLOQUEIO_RADIUS\",\"value\":false,\"creationDate\":1537303698895}],\"eventos\":[]},\"executor\":\"A0079821\"}";
//            JSONObject jBody = new JSONObject(map);
//            GenericRequest nReq = new GenericRequest();
//            nReq.setExecutor("A0079821");


            //nReq.setCustomer(nEfika);
//            String fullTestRes = FactoryDAO.createHttpCustomerDAO().post("http://10.40.198.168:7172/fulltestAPI/fulltest/manobra", body).toString();
//            System.out.println(fullTestRes);
//            String stealerRes = FactoryDAO.createHttpCustomerDAO().post(Urls.STEALER_MANOBRA.getUrl(), req).toString();
//            System.out.println(stealerRes);

            //endregion

            if(task.getTask() == TasksEnum.MANOBRA){
                //region Primeira chamada para o fulltest manobra
                Gson gson = new GsonBuilder()
                        .setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();

                FulltestManobraIn fulltestManobraIn = new FulltestManobraIn(input.getCustomer(), req.getExecutor());
                HttpResponse<String> res = Unirest.post(Urls.FULLTEST_MANOBRA.getUrl())
                            .header("Content-Type", "application/json")
                            .body(gson.toJson(fulltestManobraIn))
                            .asString();
                    System.out.println(res.getBody());


                JSONObject resFullTestManobra = new JSONObject(res.getBody());
                //endregion

                //region Segunda chamada para o fulltest e stealer
                WorkOrder stealerManobraIn = new WorkOrder(input.getWorkOrderId(), req.getExecutor(), input.getCustomer());
                res = Unirest.post(Urls.STEALER_MANOBRA_ASSERTS.getUrl())
                        .header("Content-Type", "application/json")
                        .body(gson.toJson(stealerManobraIn))
                        .asString();
                System.out.println(res.getBody());
                JSONArray stealerResJson = new JSONArray(res.getBody());

                res = Unirest.post(Urls.FULLTEST_MANOBRA_ASSERTS.getUrl())
                        .header("Content-Type", "application/json")
                        .body(resFullTestManobra.getJSONObject("cl"))
                        .asString();
                System.out.println(res.getBody());
                JSONArray fulltestResJson = new JSONArray(res.getBody());
                //endregion

                //region Terceira chamada para o analitico

                JSONObject custJson = new JSONObject(gson.toJson(input.getCustomer()));
                JSONArray custArray = custJson.getJSONArray("asserts");
                JSONArray newAsserts = new JSONArray();
                custJson.remove("asserts");
                for (int x = 0; x < custArray.length(); x++){
                    newAsserts.put(custArray.get(x));
                }
                for (int x = 0; x < stealerResJson.length(); x++){
                    newAsserts.put(stealerResJson.get(x));
                }
                for (int x = 0; x < fulltestResJson.length(); x++){
                    newAsserts.put(fulltestResJson.get(x));
                }

                custJson.put("asserts", newAsserts);

                JSONObject toAnalitico = new JSONObject();
                toAnalitico.put("executor", req.getExecutor());
                toAnalitico.put("motivo", input.getMotivo());
                toAnalitico.put("cust", custJson.toString());
                res = Unirest.post(Urls.FULLTEST_ANALITICO.getUrl())
                        .header("Content-Type", "application/json")
                        .body(toAnalitico)
                        .asString();
                System.out.println(res.getBody());
                ret.setState(TaskResultState.OK);

                //endregion

                //region Chamar HPNA
//                if(req.getCustomer().getServicos().getTipoTv() == TecnologiaTv.IPTV){
//                    map = new HashMap<>();
//                    map.put("executor", req.getExecutor());
//                    map.put("cust", input.getCustomer());
//                    jsonObj = new JSONObject(map);
//                    res = Unirest.post(Urls.CUSTOMERAPI_HPNA.getUrl())
//                            .header("Content-Type", "application/json")
//                            .body(jsonObj)
//                            .asJson();
//                    System.out.println(res.getBody());
                }
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