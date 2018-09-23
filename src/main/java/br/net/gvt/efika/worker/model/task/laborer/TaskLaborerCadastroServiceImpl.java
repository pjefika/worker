/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.worker.model.task.laborer;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;
import br.net.gvt.efika.queue.model.dto.input.CadastroInput;
import br.net.gvt.efika.queue.model.dto.output.CadastroResponse;
import br.net.gvt.efika.queue.model.dto.task.QueueTaskDTO;
import br.net.gvt.efika.queue.model.enuns.TaskResultState;
import br.net.gvt.efika.util.dao.http.Urls;
import br.net.gvt.efika.worker.dao.factory.FactoryDAO;
import br.net.gvt.efika.worker.io.swagger.model.GenericRequest;

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
            ret.setCustomer((EfikaCustomer) FactoryDAO.createHttpCustomerDAO().post(Urls.CUSTOMERAPI_CADASTRO.getUrl(), req));
            ret.setState(TaskResultState.OK);
        } catch (Exception e) {
            ret.setExceptionMessage(e.getMessage());
            ret.setState(TaskResultState.EXCEPTION);
        }

        this.task.setOutput(ret);
    }

}
