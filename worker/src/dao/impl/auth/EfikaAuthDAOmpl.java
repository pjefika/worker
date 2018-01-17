/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl.auth;

import dao.factory.FactoryDAO;
import dao.http.ContentType;
import dao.http.Urls;
import model.dto.input.AuthInput;
import util.JacksonMapper;

public class EfikaAuthDAOmpl implements EfikaAuthDAO {

    @Override
    public Boolean verificarCredenciais(AuthInput cred) throws Exception {
        try {
            VerificarCredencialRequest req = new VerificarCredencialRequest();
            req.setLogin(cred.getLogin());
            req.setSenha(cred.getSenha());
            JacksonMapper<Boolean> mapper = new JacksonMapper(Boolean.class);
            return mapper.deserialize(FactoryDAO.createHttpDAO().post(
                    Urls.AUTH.getValor(),
                    req,
                    ContentType.JSON.getValor(), null));
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao consultar Serviço de Autenticação.");
        }

    }

}
