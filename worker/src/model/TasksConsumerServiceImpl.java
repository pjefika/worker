/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.impl.QueueDAO;
import dao.factory.FactoryDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.thread.EfikaThread;

public class TasksConsumerServiceImpl implements TasksConsumerService {

    private QueueDAO dao = FactoryDAO.createQueueDAO();

    @Override
    public void consume() {
        try {
            dao.consumePendingTasks().getTasks().forEach((t) -> {
                System.out.println(t.getTask().getDesc());
                EfikaThread et = new EfikaThread(new TasksConsumerThread(t));
//                try {
//                    et.join();
//                    et.possuiException();
//                } catch (Exception ex) {
//                    Logger.getLogger(TasksConsumerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
