/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.worker.dao.impl.queue;

import br.net.gvt.efika.queue.model.dto.task.PendingTasksResponseDTO;
import br.net.gvt.efika.queue.model.dto.task.QueueTaskDTO;
import br.net.gvt.efika.util.dao.http.Urls;
import br.net.gvt.efika.worker.dao.factory.FactoryDAO;
import br.net.gvt.efika.worker.request.RequestFactory;

public class QueueDAOImpl implements QueueDAO {

    @Override
    public PendingTasksResponseDTO consumePendingTasks() throws Exception {

        return (PendingTasksResponseDTO) FactoryDAO.createHttpPendingTaskResponseDAO().post(Urls.QUEUE_CONSUME_TASKS.getValor(), RequestFactory.queueRequest());
    }

    @Override
    public QueueTaskDTO completeTask(QueueTaskDTO task) throws Exception {

        return (QueueTaskDTO) FactoryDAO.createHttpQueueTaskDAO().post(Urls.QUEUE_COMPLETE_TASK.getValor(), task);
    }

}
