/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.worker.model.task;

import br.net.gvt.efika.queue.model.dto.task.QueueTaskDTO;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.net.gvt.efika.worker.model.factory.LaborerServiceFactory;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author G0042204
 */
public class TasksConsumerThread implements Runnable {

    private QueueTaskDTO task;

    public TasksConsumerThread(QueueTaskDTO task) {
        this.task = task;
    }

    @Override
    public void run() {
        try {
            LaborerServiceFactory.create(task).executar();
        } catch (Exception ex) {

            try {
                //TODO: Criar base no mongo e apontar url do mongodb se necessario
                MongoClient mongoClient = new MongoClient();
                MongoDatabase database = mongoClient.getDatabase("logs");
                Document document = new Document("error", ex.getMessage());
                MongoCollection<Document> collection = database.getCollection("log");

                collection.insertOne(document);
                mongoClient.close();
            }catch (Exception eM){
                eM.printStackTrace();
            }

            Logger.getLogger(TasksConsumerThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
