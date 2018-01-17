/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl.auth;

import dao.factory.FactoryDAO;
import dao.http.ContentType;
import dao.http.HttpDAO;
import dao.http.Urls;
import model.dto.input.AuthInput;
import util.JacksonMapper;

public class EfikaAuthDAOmpl implements EfikaAuthDAO {

    private static final HttpDAO HTTP_DAO = FactoryDAO.createHttpDAO();

    @Override
    public Boolean verificarCredenciais(AuthInput cred) throws Exception {
        try {
            JacksonMapper<Boolean> mapper = new JacksonMapper(Boolean.class);
            return mapper.deserialize(HTTP_DAO.post(
                    Urls.AUTH.getValor(),
                    cred,
                    ContentType.JSON.getValor(), null));
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Falha ao consultar Serviço de Autenticação.");
        }

    }

}
