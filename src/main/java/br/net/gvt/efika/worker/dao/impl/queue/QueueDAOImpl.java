/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.worker.dao.impl.queue;

import br.net.gvt.efika.queue.model.dto.task.PendingTasksResponseDTO;
import br.net.gvt.efika.queue.model.dto.task.QueueTaskDTO;
import br.net.gvt.efika.util.dao.http.Urls;
import br.net.gvt.efika.util.dao.http.factory.FactoryHttpDAOAbstract;
import br.net.gvt.efika.worker.request.RequestFactory;

public class QueueDAOImpl implements QueueDAO {

    @Override
    public PendingTasksResponseDTO consumePendingTasks() throws Exception {
        FactoryHttpDAOAbstract<PendingTasksResponseDTO> fac = new FactoryHttpDAOAbstract<>(PendingTasksResponseDTO.class);
//        return (PendingTasksResponseDTO) fac.createWithProxy().post(Urls.QUEUE_CONSUME_TASKS.getValor(), RequestFactory.queueRequest());
        return (PendingTasksResponseDTO) fac.createWithoutProxy().post("http://10.40.196.172:8089/queueAPI/queue/consumePendingTasks", RequestFactory.queueRequest());
    }

    @Override
    public QueueTaskDTO completeTask(QueueTaskDTO task) throws Exception {
        FactoryHttpDAOAbstract<QueueTaskDTO> fac = new FactoryHttpDAOAbstract<>(QueueTaskDTO.class);
        return (QueueTaskDTO) fac.createWithoutProxy().post("http://10.40.196.172:8089/queueAPI/queue/completeTask", task);
    }

}
