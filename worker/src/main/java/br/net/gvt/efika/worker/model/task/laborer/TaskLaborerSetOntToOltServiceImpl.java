/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.worker.model.task.laborer;

import br.net.gvt.efika.fulltest.model.fulltest.ValidacaoResult;
import br.net.gvt.efika.fulltest.model.telecom.properties.gpon.SerialOntGpon;
import br.net.gvt.efika.queue.model.dto.input.SetOntToOltInput;
import br.net.gvt.efika.queue.model.dto.output.SetOntToOltResponse;
import br.net.gvt.efika.queue.model.dto.task.QueueTaskDTO;
import br.net.gvt.efika.queue.model.enuns.TaskResultState;
import br.net.gvt.efika.worker.dao.factory.FactoryDAO;
import br.net.gvt.efika.worker.io.swagger.model.GenericRequest;

public class TaskLaborerSetOntToOltServiceImpl extends TaskLaborerAbstract {

    public TaskLaborerSetOntToOltServiceImpl(QueueTaskDTO task) {
        super(task);
    }

    @Override
    public void processar() {
        SetOntToOltInput input = (SetOntToOltInput) task.getInput();
        GenericRequest req = new GenericRequest(input.getSerial(), input.getCustomer(), task.getExecutor());
        SetOntToOltResponse resp = new SetOntToOltResponse();

        try {
            ValidacaoResult cert = FactoryDAO.newCustomerDAO().setOntToOlt(req);

            resp.setSerial((SerialOntGpon) cert.getResult());
            resp.setState(TaskResultState.OK);
        } catch (Exception e) {
            resp.setState(TaskResultState.EXCEPTION);
            resp.setExceptionMessage(e.getMessage());
        } finally {
            this.task.setOutput(resp);
        }
    }

}
