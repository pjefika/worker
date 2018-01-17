/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.factory;

import model.TaskLaborerCadastroServiceImpl;
import model.TaskLaborerCertificationServiceImpl;
import model.TaskLaborerService;
import model.dto.task.QueueTaskDTO;
import model.enuns.TasksEnum;

/**
 *
 * @author G0042204
 */
public class LaborerServiceFactory {

    public static TaskLaborerService create(QueueTaskDTO task) throws Exception {

        if (task.getTask() == TasksEnum.CERTIFICATION) {
            return new TaskLaborerCertificationServiceImpl(task);
        }
        if (task.getTask() == TasksEnum.CADASTRO) {
            return new TaskLaborerCadastroServiceImpl(task);
        }
        throw new Exception("Tarefa não implementada.");
    }

}
