/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.task.laborer;

import dao.factory.FactoryDAO;
import model.dto.input.CertiticationInput;
import model.dto.output.CertificationResponse;
import model.dto.task.QueueTaskDTO;
import model.enuns.TaskResultState;

public class TaskLaborerCertificationServiceImpl extends TaskLaborerAbstract {

    public TaskLaborerCertificationServiceImpl(QueueTaskDTO task) {
        super(task);
    }

    @Override
    public void processar() {
        CertiticationInput input = (CertiticationInput) task.getInput();
        CertificationResponse resp = new CertificationResponse();
        try {
            resp.setCertification(FactoryDAO.newCustomerDAO().certify(input));
            resp.setState(TaskResultState.OK);
        } catch (Exception e) {
            resp.setState(TaskResultState.EXCEPTION);
            resp.setExceptionMessage(e.getMessage());
        } finally {
            this.task.setOutput(resp);
        }
    }

}
