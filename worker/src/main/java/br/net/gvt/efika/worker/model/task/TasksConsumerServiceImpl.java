/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.worker.model.task;

import br.net.gvt.efika.util.thread.EfikaThread;
import br.net.gvt.efika.worker.dao.factory.FactoryDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TasksConsumerServiceImpl implements TasksConsumerService {

    @Override
    public void consume() {
        try {
            FactoryDAO.createQueueDAO().consumePendingTasks().getTasks().forEach((t) -> {
                System.out.println(t.getTask().getDesc());
                EfikaThread et = new EfikaThread(new TasksConsumerThread(t));
                try {
                    et.join();
                    et.possuiException();
                } catch (Exception ex) {
                    Logger.getLogger(TasksConsumerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
