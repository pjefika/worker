/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.worker.model.task.laborer;

import br.net.gvt.efika.queue.model.dto.input.CertiticationInput;
import br.net.gvt.efika.queue.model.dto.input.GenericQueueInput;
import br.net.gvt.efika.queue.model.dto.task.QueueTaskDTO;
import br.net.gvt.efika.queue.model.enuns.TasksEnum;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class TaskLaborerOntsDispServiceImplIT {

    public TaskLaborerOntsDispServiceImplIT() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of processar method, of class TaskLaborerOntsDispServiceImpl.
     */
    @Test
    public void testProcessar() {
        try {
            System.out.println("processar");
            QueueTaskDTO task = new QueueTaskDTO();
            task.setTask(TasksEnum.ONTS_DISP);
            CertiticationInput input = new CertiticationInput();
            input.setInstancia("1633351800");
            task.setInput(input);
            TaskLaborerOntsDispServiceImpl instance = new TaskLaborerOntsDispServiceImpl(task);
            instance.processar();

        } catch (Exception e) {
            fail(e.getMessage());

        }

    }

}
