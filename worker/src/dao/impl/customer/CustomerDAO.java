/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl.customer;

import io.swagger.model.GenericRequest;
import model.dto.cert.CustomerCertificationDTO;

/**
 *
 * @author G0042204
 */
public interface CustomerDAO {

    public CustomerCertificationDTO certify(GenericRequest input) throws Exception;

}
