/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.worker.dao.impl.queue;

import br.net.gvt.efika.queue.model.dto.task.PendingTasksResponseDTO;
import br.net.gvt.efika.queue.model.dto.task.QueueTaskDTO;
import br.net.gvt.efika.worker.dao.impl.queue.QueueDAOImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class QueueDAOImplIT {

    public QueueDAOImplIT() {
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
     * Test of consumePendingTasks method, of class QueueDAOImpl.
     */
    @Test
    public void testConsumePendingTasks() throws Exception {
//        System.out.println("consumePendingTasks");
//        try {
//            QueueDAOImpl instance = new QueueDAOImpl();
//            PendingTasksResponseDTO result = instance.consumePendingTasks();
//            assertTrue(result != null);
//        } catch (Exception e) {
//            e.printStackTrace();
//            fail(e.getMessage());
//        }

    }

    /**
     * Test of completeTask method, of class QueueDAOImpl.
     */
    @Test
    public void testCompleteTask() throws Exception {
        System.out.println("completeTask");
        QueueTaskDTO task = null;
        QueueDAOImpl instance = new QueueDAOImpl();
        QueueTaskDTO expResult = null;
        QueueTaskDTO result = instance.completeTask(task);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
