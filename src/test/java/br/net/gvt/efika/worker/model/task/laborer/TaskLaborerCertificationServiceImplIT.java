/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.worker.model.task.laborer;

import br.net.gvt.efika.queue.model.dto.task.QueueTaskDTO;
import br.net.gvt.efika.util.json.JacksonMapper;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author G0041775
 */
public class TaskLaborerCertificationServiceImplIT {

    public TaskLaborerCertificationServiceImplIT() {
    }

    @BeforeClass
    public static void setUpClass() {
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
     * Test of processar method, of class TaskLaborerCertificationServiceImpl.
     */
    @Test
    public void executar() throws Exception {
        System.out.println("executar");
        QueueTaskDTO t;
        t = (QueueTaskDTO) new JacksonMapper(QueueTaskDTO.class).deserialize("{  \n"
                + "   \"task\":\"CERTIFICATION\",\n"
                + "   \"input\":{  \n"
                + "      \"type\":\"certification\",\n"
                + "      \"instancia\":\"4133335556\"\n"
                + "   },\n"
                + "   \"executor\":\"G0041775\"\n"
                + "}");
        TaskLaborerService instance = new TaskLaborerCertificationServiceImpl(t);
        System.out.println("QueueTaskDTO:" + new JacksonMapper(QueueTaskDTO.class).serialize(instance.executar()));

        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}
