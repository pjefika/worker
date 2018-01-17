/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl.customer;

import dao.factory.FactoryDAO;
import dao.http.ContentType;
import dao.http.Urls;
import java.nio.charset.Charset;
import model.dto.cert.CustomerCertificationDTO;
import model.dto.input.CertiticationInput;
import util.JacksonMapper;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public CustomerCertificationDTO certify(CertiticationInput input) throws Exception {

        JacksonMapper<CustomerCertificationDTO> mapper = new JacksonMapper(CustomerCertificationDTO.class);
        return mapper.deserialize(FactoryDAO.createHttpDAO().post(Urls.CERTIFICATION.getUrl(),
                input,
                ContentType.JSON.getCont(), Charset.forName("UTF-8")));
    }
}
