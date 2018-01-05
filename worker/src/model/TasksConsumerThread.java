/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import br.net.gvt.efika.asserts.AssertsEnum;
import br.net.gvt.efika.customer.CustomerAssert;
import br.net.gvt.efika.customer.EfikaCustomer;
import dao.QueueDAO;
import dao.factory.FactoryDAO;
import dao.http.ContentType;
import dao.http.Urls;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.domain.queue.Item;
import model.domain.queue.QueueTaskDTO;
import model.factory.FactoryService;

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
            List<Item> itens = new ArrayList<>();
            itens.add(new Item("resultado", FactoryService.createTaskLaborerService().taskResult(task)));
            System.out.println("run");
            dao.completeTask(task);
        } catch (Exception ex) {
            Logger.getLogger(TasksConsumerThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
