/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.task.factory;

import model.dto.task.QueueTaskDTO;
import model.enuns.TasksEnum;
import model.task.laborer.TaskLaborerCertificationServiceImpl;
import model.task.laborer.TaskLaborerAuthServiceImpl1;
import model.task.laborer.TaskLaborerService;

/**
 *
 * @author G0042204
 */
public class LaborerServiceFactory {

    public static TaskLaborerService create(QueueTaskDTO task) throws Exception {

        if (task.getTask() == TasksEnum.CERTIFICATION) {
            return new TaskLaborerCertificationServiceImpl(task);
        }

        if (task.getTask() == TasksEnum.AUTH) {
            return new TaskLaborerAuthServiceImpl1(task);
        }

        throw new Exception("Tarefa não implementada.");
    }

}
