/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.worker;

import br.net.gvt.efika.util.thread.EfikaThread;
import br.net.gvt.efika.worker.model.factory.FactoryService;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author G0042204
 */
public class Worker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        do {
            new EfikaThread(() -> {
                FactoryService.createTasksConsumerService().consume();
            });
            try {
                System.out.println("Sleep:" + Calendar.getInstance());
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }

}
