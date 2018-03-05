/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.worker.worker;

import br.net.gvt.efika.worker.Worker;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author G0042204
 */
public class WorkerIT {

    public WorkerIT() {
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
     * Test of main method, of class Worker.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        System.setProperty("http.proxyHost", "http://GVT\\G0041775:Fofin54001@192.168.25.9");
        System.setProperty("http.proxyPort", "8080");
        Worker.main(args);
    }

}
