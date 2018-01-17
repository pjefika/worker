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
import java.nio.charset.Charset;
import model.dto.cert.CustomerCertificationDTO;
import model.dto.input.CertiticationInput;
import model.dto.output.CertificationResponse;
import model.dto.task.QueueTaskDTO;
import model.enuns.TaskResultState;

import util.JacksonMapper;

public class TaskLaborerCertificationServiceImpl extends TaskLaborerAbstract {

    public TaskLaborerCertificationServiceImpl(QueueTaskDTO task) {
        super(task);
    }

    @Override
    public void processar() {
        CertiticationInput input = (CertiticationInput) task.getInput();
        GenericRequest req = new GenericRequest(input.getInstancia(), input.getCustomer(), task.getExecutor());
        CertificationResponse ret = new CertificationResponse();
        try {
//            System.out.println("REQPARACUSTOMERAPI -> " + new JacksonMapper(GenericRequest.class).serialize(req));
            JacksonMapper<CustomerCertificationDTO> mapper = new JacksonMapper(CustomerCertificationDTO.class);
            ret.setCertification(mapper.deserialize(FactoryDAO.createHttpDAO().post(Urls.CUSTOMERAPI_CERTIFICATION.getUrl(),
                    req,
                    ContentType.JSON.getCont(), Charset.forName("UTF-8"))));
            ret.setState(TaskResultState.OK);
        } catch (Exception e) {
            ret.setExceptionMessage(e.getMessage());
            ret.setState(TaskResultState.EXCEPTION);
        }

        this.task.setOutput(ret);
//        System.out.println("RETORNOCUSTOMERAPI -> " + new JacksonMapper(CustomerCertificationDTO.class).serialize(ret));
    }

}
