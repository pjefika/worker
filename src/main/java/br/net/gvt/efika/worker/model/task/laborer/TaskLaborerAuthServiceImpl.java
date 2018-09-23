/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.worker.model.task.laborer;

import br.net.gvt.efika.queue.model.dto.input.AuthInput;
import br.net.gvt.efika.queue.model.dto.output.AuthResponse;
import br.net.gvt.efika.queue.model.dto.task.QueueTaskDTO;
import br.net.gvt.efika.queue.model.enuns.TaskResultState;
import br.net.gvt.efika.worker.dao.factory.FactoryDAO;
import br.net.gvt.efika.worker.dao.impl.auth.EfikaAuthDAO;

public class TaskLaborerAuthServiceImpl extends TaskLaborerAbstract {

    private EfikaAuthDAO dao = FactoryDAO.createEfikaAuthDAO();

    public TaskLaborerAuthServiceImpl(QueueTaskDTO task) {
        super(task);
    }

    @Override
    public void processar() {
        AuthResponse resp = new AuthResponse();
        try {
            resp.setMatch(dao.verificarCredenciais((AuthInput) task.getInput()));
            resp.setState(TaskResultState.OK);
        } catch (Exception e) {
            resp.setState(TaskResultState.EXCEPTION);
            resp.setExceptionMessage(e.getMessage());
        } finally {
            AuthInput input = (AuthInput) task.getInput();
            input.setSenha("");
            task.setInput(input);
            this.task.setOutput(resp);
        }
    }

}
