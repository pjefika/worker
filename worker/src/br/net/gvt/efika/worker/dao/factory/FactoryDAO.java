/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.worker.dao.factory;

import br.net.gvt.efika.customer.EfikaCustomer;
import br.net.gvt.efika.model.certification.CustomerCertificationDTO;
import br.net.gvt.efika.util.dao.http.HttpDAO;
import br.net.gvt.efika.util.dao.http.HttpDAOGenericImpl;
import dao.AbstractMongoDAO;
import dao.impl.queue.QueueDAO;
import dao.impl.queue.QueueDAOImpl;
import dao.impl.auth.EfikaAuthDAO;
import dao.impl.auth.EfikaAuthDAOmpl;
import dao.impl.customer.CustomerDAO;
import dao.impl.customer.CustomerDAOImpl;
import dao.impl.queue.QueueDAOMirrorImpl;
import fulltest.ValidacaoResult;
import model.dto.task.PendingTasksResponseDTO;
import model.dto.task.QueueTaskDTO;
import model.entity.QueueTaskMirror;

/**
 *
 * @author G0042204
 */
public class FactoryDAO {

    public static HttpDAO createHttpCertificationDAO() {
        return new HttpDAOGenericImpl<CustomerCertificationDTO>(CustomerCertificationDTO.class) {
        };
    }

    public static HttpDAO createHttpBooleanDAO() {
        return new HttpDAOGenericImpl<Boolean>(Boolean.class) {
        };
    }
//QueueTaskDTO

    public static HttpDAO createHttpValidacaoResultDAO() {
        return new HttpDAOGenericImpl<ValidacaoResult>(ValidacaoResult.class) {
        };
    }

    public static HttpDAO createHttpPendingTaskResponseDAO() {
        return new HttpDAOGenericImpl<PendingTasksResponseDTO>(PendingTasksResponseDTO.class) {
        };
    }

    public static HttpDAO createHttpQueueTaskDAO() {
        return new HttpDAOGenericImpl<QueueTaskDTO>(QueueTaskDTO.class) {
        };
    }

    public static HttpDAO createHttpCustomerDAO() {
        return new HttpDAOGenericImpl<EfikaCustomer>(EfikaCustomer.class) {
        };
    }

    public static QueueDAO createQueueDAO() {
        return new QueueDAOImpl();
    }

    public static AbstractMongoDAO<QueueTaskMirror> createQueueDAOMirrorImpl() {
        return new QueueDAOMirrorImpl();
    }

    public static EfikaAuthDAO createEfikaAuthDAO() {
        return new EfikaAuthDAOmpl();
    }

    public static CustomerDAO newCustomerDAO() {
        return new CustomerDAOImpl();
    }

}
