/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.QueueDAO;
import dao.factory.FactoryDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.domain.queue.QueueTaskDTO;

/**
 *
 * @author G0042204
 */
public class TasksConsumerThread implements Runnable {

    private QueueTaskDTO task;

    private QueueDAO dao = FactoryDAO.createQueueDAO();

    public TasksConsumerThread(QueueTaskDTO task) {
        this.task = task;
    }

    @Override
    public void run() {
        try {
            System.out.println("run");
            task.setOutput("Ronaldo");
            dao.completeTask(task);
        } catch (Exception ex) {
            Logger.getLogger(TasksConsumerThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
