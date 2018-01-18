/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.task.laborer;

import dao.factory.FactoryDAO;
import io.swagger.model.GenericRequest;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dto.cert.CustomerCertificationDTO;
import model.dto.input.CertiticationInput;
import model.dto.output.CertificationResponse;
import model.dto.task.QueueTaskDTO;
import model.enuns.TaskResultState;
import util.JacksonMapper;

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
            System.out.println("EXCESSAO ->"+ e.getMessage());
            e.printStackTrace();
            resp.setState(TaskResultState.EXCEPTION);
            resp.setExceptionMessage(e.getMessage());
        } finally {
            this.task.setOutput(resp);
        }
    }

}
