/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl.queue;

import dao.factory.FactoryDAO;
import dao.http.ContentType;
import dao.http.HttpDAO;
import dao.http.Urls;
import dao.request.RequestFactory;
import model.dto.task.PendingTasksResponseDTO;
import model.dto.task.QueueTaskDTO;
import util.JacksonMapper;

public class QueueDAOImpl implements QueueDAO {

    private static final HttpDAO HTTP_DAO = FactoryDAO.createHttpDAO();

    @Override
    public PendingTasksResponseDTO consumePendingTasks() throws Exception {
        JacksonMapper<PendingTasksResponseDTO> mapper = new JacksonMapper(PendingTasksResponseDTO.class);
        return mapper.deserialize(HTTP_DAO.post(
                Urls.QUEUE.getValor() + "consumePendingTasks",
                RequestFactory.queueRequest(),
                ContentType.JSON.getValor(), null));
    }

    @Override
    public QueueTaskDTO completeTask(QueueTaskDTO task) throws Exception {
        JacksonMapper<QueueTaskDTO> mapper = new JacksonMapper(QueueTaskDTO.class);
        return mapper.deserialize(HTTP_DAO.post(
                Urls.QUEUE_COMPLETE_TASK.getValor(),
                task,
                ContentType.JSON.getValor(), null));
    }

}
