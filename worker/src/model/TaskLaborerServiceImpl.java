/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.factory.FactoryDAO;
import dao.http.ContentType;
import dao.http.Urls;
import io.swagger.model.GenericRequest;
import model.domain.queue.QueueTaskDTO;
import model.domain.queue.enuns.TasksEnum;
import util.JacksonMapper;

public class TaskLaborerServiceImpl implements TaskLaborerService {

    @Override
    public Object taskResult(QueueTaskDTO task) throws Exception {
        if (task.getTask() == TasksEnum.FULLTEST) {
            GenericRequest req = new GenericRequest(task.getInput().get(0).getValue().toString(), task.getExecutor());
            System.out.println("REQPARACUSTOMERAPI -> "+new JacksonMapper(GenericRequest.class).serialize(req));
            return FactoryDAO.createHttpDAO().post(Urls.FULLTESTPORINSTANCIA.getUrl(),
                    req,
                    ContentType.JSON.getCont());
        }
        return null;
    }

}
