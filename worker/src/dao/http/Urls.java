/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.http;

/**
 *
 * @author G0041775
 */
public enum Urls {

    CUSTOMERAPI_CADASTRO("http://10.40.195.81:8080/customerAPI/customer/findByParameter"),
    CUSTOMERAPI_CERTIFICATION("http://10.40.195.81:8080/customerAPI/certification/execByParam"),
    QUEUE_COMPLETE_TASK("http://localhost:8080/queueAPI/queue/completeTask"),
    QUEUE("http://localhost:8080/queueAPI/queue/"),
    AUTH("http://localhost:8080/efikaAuth/credencial/verificar");

    private final String valor;

    private Urls(String url) {
        valor = url;
    }

    public String getUrl() {
        return valor;
    }

    public String getValor() {
        return valor;
    }

    public static Urls find(String url) {
        return Urls.valueOf(url);
    }

}
