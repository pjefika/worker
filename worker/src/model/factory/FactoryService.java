/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.factory;

import model.TasksConsumerService;
import model.TasksConsumerServiceImpl;
import model.TaskLaborerService;
import model.TaskLaborerServiceImpl;

/**
 *
 * @author G0042204
 */
public class FactoryService {

    public static TasksConsumerService createTasksConsumerService() {
        return new TasksConsumerServiceImpl();
    }
    
    public static TaskLaborerService createTaskLaborerService(){
        return new TaskLaborerServiceImpl();
    }

}
