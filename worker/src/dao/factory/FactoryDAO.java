/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.factory;

import dao.AbstractMongoDAO;
import dao.impl.queue.QueueDAO;
import dao.impl.queue.QueueDAOImpl;
import dao.http.HttpDAO;
import dao.http.HttpDAOImpl;
import dao.impl.auth.EfikaAuthDAO;
import dao.impl.auth.EfikaAuthDAOmpl;
import dao.impl.customer.CustomerDAO;
import dao.impl.customer.CustomerDAOImpl;
import dao.impl.queue.QueueDAOMirrorImpl;
import model.dto.task.QueueTaskDTO;
import model.entity.QueueTaskMirror;

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

    public static AbstractMongoDAO<QueueTaskMirror> createQueueDAOMirrorImpl() {
        return new QueueDAOMirrorImpl();
    }

    public static EfikaAuthDAO newEfikaAuthDAO() {
        return new EfikaAuthDAOmpl();
    }

    public static CustomerDAO newCustomerDAO() {
        return new CustomerDAOImpl();
    }

}
