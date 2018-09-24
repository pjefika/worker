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
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueDAOImpl implements QueueDAO {

    @Override
    public List<QueueTaskDTO> consumePendingTasks() throws Exception {
        FactoryHttpDAOAbstract<QueueTaskDTO[]> fac = new FactoryHttpDAOAbstract<QueueTaskDTO[]>(QueueTaskDTO[].class);
//        return (PendingTasksResponseDTO) fac.createWithProxy().post(Urls.QUEUE_CONSUME_TASKS.getValor(), RequestFactory.queueRequest());
        QueueTaskDTO[] test = fac.createWithoutProxy().post(Urls.QUEUE_CONSUME_TASKS.getUrl(), RequestFactory.queueRequest());
        List<QueueTaskDTO> nList = Arrays.asList(test);
        return nList;
    }

    @Override
    public QueueTaskDTO completeTask(QueueTaskDTO task) throws Exception {
        FactoryHttpDAOAbstract<QueueTaskDTO> fac = new FactoryHttpDAOAbstract<>(QueueTaskDTO.class);
        return (QueueTaskDTO) fac.createWithoutProxy().post(Urls.QUEUE_COMPLETE_TASK.getUrl(), task);
    }

}
