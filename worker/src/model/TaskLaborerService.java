/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.domain.queue.QueueTaskDTO;

/**
 *
 * @author G0041775
 */
public interface TaskLaborerService {

    public Object taskResult(QueueTaskDTO task) throws Exception;

}