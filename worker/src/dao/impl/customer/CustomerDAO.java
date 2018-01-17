/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl.customer;

import model.dto.cert.CustomerCertificationDTO;
import model.dto.input.CertiticationInput;



/**
 *
 * @author G0042204
 */
public interface CustomerDAO {

    public CustomerCertificationDTO certify(CertiticationInput input) throws Exception;


}
