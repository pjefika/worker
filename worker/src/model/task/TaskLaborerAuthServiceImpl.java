/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.task;

import dao.factory.FactoryDAO;
import dao.impl.auth.EfikaAuthDAO;
import model.domain.queue.dto.QueueTaskDTO;


public class TaskLaborerAuthServiceImpl extends TaskLaborerAbstract {
    
    private EfikaAuthDAO dao = FactoryDAO.newEfikaAuthDAO();

    public TaskLaborerAuthServiceImpl(QueueTaskDTO task) {
        super(task);
    }

    @Override
    public void processar() throws Exception {
        // task.getInput();
        // this.task.setOutput();
    }

}
