/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.factory;

import dao.QueueDAO;
import dao.QueueDAOImpl;
import dao.http.HttpDAO;
import dao.http.HttpDAOImpl;

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

}
