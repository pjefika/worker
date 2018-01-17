/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.factory;

import dao.impl.queue.QueueDAO;
import dao.impl.queue.QueueDAOImpl;
import dao.http.HttpDAO;
import dao.http.HttpDAOImpl;
import dao.impl.auth.EfikaAuthDAO;
import dao.impl.auth.EfikaAuthDAOmpl;

/**
 *
 * @author G0042204
 */
public class FactoryDAO {

    public static HttpDAO createHttpDAO() {
        return new HttpDAOImpl();
    }

    public static QueueDAO createQueueDAO() {
        return new QueueDAOImpl();
    }

    public static EfikaAuthDAO newEfikaAuthDAO() {
        return new EfikaAuthDAOmpl();
    }

}
