/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.worker.dao.impl.customer;

import br.net.gvt.efika.customer.model.certification.CustomerCertificationDTO;
import br.net.gvt.efika.fulltest.model.fulltest.ValidacaoResult;
import br.net.gvt.efika.fulltest.model.telecom.properties.gpon.SerialOntGpon;
import br.net.gvt.efika.util.dao.http.Urls;
import br.net.gvt.efika.util.dao.http.factory.FactoryHttpDAOAbstract;
import br.net.gvt.efika.worker.io.swagger.model.GenericRequest;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public CustomerCertificationDTO certify(GenericRequest input) throws Exception {
        FactoryHttpDAOAbstract<CustomerCertificationDTO> fac = new FactoryHttpDAOAbstract<>(CustomerCertificationDTO.class);
        return (CustomerCertificationDTO) fac.createWithoutProxy().post(Urls.CUSTOMERAPI_CERTIFICATION.getValor(), input);
    }

    @Override
    public ValidacaoResult certifyRede(GenericRequest input) throws Exception {
        FactoryHttpDAOAbstract<ValidacaoResult> fac = new FactoryHttpDAOAbstract<>(ValidacaoResult.class);
        return (ValidacaoResult) fac.createWithoutProxy().post(Urls.CUSTOMERAPI_CONF_REDE.getValor(), input);
    }

    @Override
    public List<SerialOntGpon> getOntsDisp(GenericRequest input) throws Exception {
        FactoryHttpDAOAbstract<List> fac = new FactoryHttpDAOAbstract<>(List.class);
        return (List<SerialOntGpon>) fac.createWithoutProxy().post(Urls.CUSTOMERAPI_ONTS_DISP.getValor(), input);
    }

    @Override
    public ValidacaoResult setOntToOlt(GenericRequest input) throws Exception {
        FactoryHttpDAOAbstract<ValidacaoResult> fac = new FactoryHttpDAOAbstract<>(ValidacaoResult.class);
        return (ValidacaoResult) fac.createWithoutProxy().post(Urls.CUSTOMERAPI_SET_ONT.getValor(), input);
    }
}
