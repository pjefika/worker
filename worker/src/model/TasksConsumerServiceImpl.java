/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.QueueDAO;
import dao.factory.FactoryDAO;
import util.thread.EfikaThread;

public class TasksConsumerServiceImpl implements TasksConsumerService {

    private QueueDAO dao = FactoryDAO.createQueueDAO();

    @Override
    public void consume() {
        try {
            dao.consumePendingTasks().getTasks().forEach((t) -> {
                System.out.println(t.getTask().getDesc());
                new EfikaThread(new TasksConsumerThread(t));
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
