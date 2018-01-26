/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl.customer;

import br.net.gvt.efika.model.certification.CustomerCertificationDTO;
import dao.factory.FactoryDAO;
import dao.http.ContentType;
import dao.http.Urls;
import fulltest.ValidacaoResult;
import io.swagger.model.GenericRequest;
import java.nio.charset.Charset;
import util.JacksonMapper;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public CustomerCertificationDTO certify(GenericRequest input) throws Exception {

        JacksonMapper<CustomerCertificationDTO> mapper = new JacksonMapper(CustomerCertificationDTO.class);
        return mapper.deserialize(FactoryDAO.createHttpDAO().post(Urls.CUSTOMERAPI_CERTIFICATION.getUrl(),
                input,
                ContentType.JSON.getCont(), Charset.forName("UTF-8")));
    }

    @Override
    public ValidacaoResult certifyRede(GenericRequest input) throws Exception {
        JacksonMapper<ValidacaoResult> mapper = new JacksonMapper(ValidacaoResult.class);
        return mapper.deserialize(FactoryDAO.createHttpDAO().post(Urls.CUSTOMERAPI_CONF_REDE.getUrl(),
                input,
                ContentType.JSON.getCont(), Charset.forName("UTF-8")));
    }
}
