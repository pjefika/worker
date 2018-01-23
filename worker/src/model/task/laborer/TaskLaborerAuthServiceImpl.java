/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.task.laborer;

import dao.factory.FactoryDAO;
import dao.impl.auth.EfikaAuthDAO;
import model.dto.input.AuthInput;
import model.dto.output.AuthResponse;
import model.dto.task.QueueTaskDTO;
import model.enuns.TaskResultState;

public class TaskLaborerAuthServiceImpl extends TaskLaborerAbstract {

    private EfikaAuthDAO dao = FactoryDAO.newEfikaAuthDAO();

    public TaskLaborerAuthServiceImpl(QueueTaskDTO task) {
        super(task);
    }

    @Override
    public void processar() {
        AuthResponse resp = new AuthResponse();
        try {
            resp.setMatch(FactoryDAO.newEfikaAuthDAO().verificarCredenciais((AuthInput) task.getInput()));
            resp.setState(TaskResultState.OK);
            AuthInput input = (AuthInput) task.getInput();
            input.setSenha("");
            task.setInput(input);
        } catch (Exception e) {
            resp.setState(TaskResultState.EXCEPTION);
            resp.setExceptionMessage(e.getMessage());
        } finally {
            this.task.setOutput(resp);
        }
    }

}
