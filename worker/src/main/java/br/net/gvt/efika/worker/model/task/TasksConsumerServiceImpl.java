/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.worker.model.task;

import br.net.gvt.efika.queue.model.dto.task.QueueTaskDTO;
import br.net.gvt.efika.util.thread.EfikaThread;
import br.net.gvt.efika.worker.dao.factory.FactoryDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TasksConsumerServiceImpl implements TasksConsumerService {

    @Override
    public void consume() {
        try {
            FactoryDAO.createQueueDAO().consumePendingTasks().getTasks().forEach((t) -> {
            //tT.forEach(t -> {
                //System.out.println(t.getTask().getDesc());
                System.out.println(t.getTask());

                EfikaThread et = new EfikaThread(new TasksConsumerThread(t));
//                try {
//                    et.join();
//                    et.possuiException();
//                } catch (Exception ex) {
//                    Logger.getLogger(TasksConsumerServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
//                }
            });
        } catch (Exception e) {
            //TODO: Gravar erro de execucao do foreach
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
