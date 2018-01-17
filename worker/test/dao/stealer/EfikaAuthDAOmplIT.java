/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.stealer;

import dao.impl.auth.EfikaAuthDAOmpl;
import dao.request.VerificarCredencialRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class EfikaAuthDAOmplIT {

    public EfikaAuthDAOmplIT() {
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
     * Test of verificarCredenciais method, of class EfikaAuthDAOmpl.
     */
    @Test
    public void testVerificarCredenciais() throws Exception {
        try {
            System.out.println("verificarCredenciais");
            VerificarCredencialRequest cred = new VerificarCredencialRequest();
            cred.setLogin("#######");
            cred.setSenha("#######");
            EfikaAuthDAOmpl instance = new EfikaAuthDAOmpl();
            Boolean expResult = true;
            Boolean result = instance.verificarCredenciais(cred);
            assertEquals(expResult, result);
        } catch (Exception e) {
            fail("The test case is a prototype.");

        }
    }

}
