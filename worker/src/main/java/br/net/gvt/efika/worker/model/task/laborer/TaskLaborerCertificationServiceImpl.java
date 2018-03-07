/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.worker.model.task.laborer;

import br.net.gvt.efika.customer.model.certification.CustomerCertificationDTO;
import br.net.gvt.efika.queue.model.dto.input.CertiticationInput;
import br.net.gvt.efika.queue.model.dto.output.CertificationResponse;
import br.net.gvt.efika.queue.model.dto.task.QueueTaskDTO;
import br.net.gvt.efika.queue.model.enuns.TaskResultState;
import br.net.gvt.efika.worker.dao.factory.FactoryDAO;
import br.net.gvt.efika.worker.io.swagger.model.GenericRequest;
import br.net.gvt.efika.worker.util.JacksonMapper;

public class TaskLaborerCertificationServiceImpl extends TaskLaborerAbstract {

    public TaskLaborerCertificationServiceImpl(QueueTaskDTO task) {
        super(task);
    }

    @Override
    public void processar() {
        CertiticationInput input = (CertiticationInput) task.getInput();
        GenericRequest req = new GenericRequest(input.getInstancia(), input.getCustomer(), task.getExecutor());
        CertificationResponse resp = new CertificationResponse();
  
        try {
            CustomerCertificationDTO cert = FactoryDAO.newCustomerDAO().certify(req);
            try {
                System.out.println("RESP ->" + new JacksonMapper(CustomerCertificationDTO.class).serialize(cert));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            resp.setCertification(cert);
            resp.setState(TaskResultState.OK);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setState(TaskResultState.EXCEPTION);
            resp.setExceptionMessage(e.getMessage());
        } finally {
            this.task.setOutput(resp);
        }
    }

}
