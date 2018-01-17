/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.task;

import dao.factory.FactoryDAO;
import model.domain.queue.dto.QueueTaskDTO;

/**
 *
 * @author G0042204
 */
public abstract class TaskLaborerAbstract implements TaskLaborerService {

    protected QueueTaskDTO task;

    public TaskLaborerAbstract(QueueTaskDTO task) {
        this.task = task;
    }

    public void finalizar() {
        try {
            FactoryDAO.createQueueDAO().completeTask(this.task);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void processar() throws Exception;

    @Override
    public QueueTaskDTO executar() throws Exception {
        this.processar();
        this.finalizar();
        return this.task;
    }

}
