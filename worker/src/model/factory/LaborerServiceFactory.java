/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.factory;

import model.TaskLaborerFulltestServiceImpl;
import model.TaskLaborerService;
import model.domain.queue.dto.QueueTaskDTO;
import model.domain.queue.enuns.TasksEnum;

/**
 *
 * @author G0042204
 */
public class LaborerServiceFactory {

    public static TaskLaborerService create(QueueTaskDTO task) throws Exception {
        
         if (task.getTask() == TasksEnum.FULLTEST) {
             return new TaskLaborerFulltestServiceImpl(task);
         }
         throw new Exception("Tarefa não implementada.");
    }

}
