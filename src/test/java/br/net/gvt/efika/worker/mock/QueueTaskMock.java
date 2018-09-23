/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.worker.mock;

import br.net.gvt.efika.queue.model.dto.input.AuthInput;
import br.net.gvt.efika.queue.model.dto.task.QueueTaskDTO;

/**
 *
 * @author G0042204
 */
public class QueueTaskMock {
    
    public static QueueTaskDTO mock(){
        QueueTaskDTO task = new QueueTaskDTO();
        
        AuthInput input = new AuthInput();
        input.setLogin("G00lsjfg");
        input.setSenha("D20m");
        input.setType("auth");
        task.setInput(input);
        
        
        return task;
    }
    
}
