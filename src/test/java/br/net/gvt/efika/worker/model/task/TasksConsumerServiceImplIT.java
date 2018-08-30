/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.worker.model.task;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class TasksConsumerServiceImplIT {

    public TasksConsumerServiceImplIT() {
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
     * Test of consume method, of class TasksConsumerServiceImpl.
     */
    @Test
    public void testConsume() {
        try {
            System.out.println("consume");
            TasksConsumerServiceImpl instance = new TasksConsumerServiceImpl();
            instance.consume();
            Thread.sleep(100000);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
