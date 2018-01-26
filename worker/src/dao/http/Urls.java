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
    //-10.40.195.81
    //-localhost
    CUSTOMERAPI_CADASTRO("http://localhost:8080/customerAPI/customer/findByParameter"),
    CUSTOMERAPI_CERTIFICATION("http://localhost:8080/customerAPI/certification/execByParam"),
    CUSTOMERAPI_CONF_REDE("http://localhost:8080/customerAPI/certification/confRede"),
//    QUEUE_COMPLETE_TASK("http://ec2-54-233-253-253.sa-east-1.compute.amazonaws.com:8080/queueAPI/queue/completeTask"),
//    QUEUE("http://ec2-54-233-253-253.sa-east-1.compute.amazonaws.com:8080/queueAPI/queue/"),
    QUEUE_COMPLETE_TASK("http://localhost:8080/queueAPI/queue/completeTask"),
    QUEUE("http://localhost:8080/queueAPI/queue/"),
    AUTH("http://10.40.198.168:8080/efikaAuth2/credencial/verificar");

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
