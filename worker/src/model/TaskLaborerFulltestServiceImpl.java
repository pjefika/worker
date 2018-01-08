/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import br.net.gvt.efika.model.entity.fulltest.FullTest;
import dao.factory.FactoryDAO;
import dao.http.ContentType;
import dao.http.Urls;
import io.swagger.model.GenericRequest;
import model.domain.queue.dto.CustomerRequest;
import model.domain.queue.dto.FulltestResponse;
import model.domain.queue.dto.QueueTaskDTO;

import util.JacksonMapper;

public class TaskLaborerFulltestServiceImpl extends TaskLaborerAbstract {

    public TaskLaborerFulltestServiceImpl(QueueTaskDTO task) {
        super(task);
    }

    @Override
    public void processar() throws Exception {
        CustomerRequest input = (CustomerRequest) task.getInput();
        GenericRequest req = new GenericRequest(input.getInstancia(), task.getExecutor());
        System.out.println("REQPARACUSTOMERAPI -> " + new JacksonMapper(GenericRequest.class).serialize(req));
        FulltestResponse ret = new FulltestResponse();
        ret.setFulltest(new JacksonMapper<>(FullTest.class).deserialize(FactoryDAO.createHttpDAO().post(Urls.FULLTESTPORINSTANCIA.getUrl(),
                req,
                ContentType.JSON.getCont())));
        task.setOutput(ret);
    }

}
