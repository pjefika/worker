/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.worker.dao.impl.customer;

import br.net.gvt.efika.model.certification.CustomerCertificationDTO;
import br.net.gvt.efika.worker.dao.factory.FactoryDAO;
import br.net.gvt.efika.worker.dao.http.Urls;
import fulltest.ValidacaoResult;
import br.net.gvt.efika.worker.io.swagger.model.GenericRequest;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public CustomerCertificationDTO certify(GenericRequest input) throws Exception {

        return (CustomerCertificationDTO) FactoryDAO.createHttpCertificationDAO().post(Urls.CUSTOMERAPI_CERTIFICATION.getUrl(), input);
    }

    @Override
    public ValidacaoResult certifyRede(GenericRequest input) throws Exception {

        return (ValidacaoResult) FactoryDAO.createHttpValidacaoResultDAO().post(Urls.CUSTOMERAPI_CONF_REDE.getUrl(), input);
    }
}
