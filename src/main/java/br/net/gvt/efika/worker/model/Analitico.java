package br.net.gvt.efika.worker.model;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;

/**
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@telefonica.com
 * System Analyst
 * 41 9 9513-0230
 **/
public class Analitico {

    private EfikaCustomer cust;
    private String executor;
    private String motivo;

    public Analitico(EfikaCustomer cust, String executor, String motivo) {
        this.cust = cust;
        this.executor = executor;
        this.motivo = motivo;
    }

    public EfikaCustomer getCust() {
        return cust;
    }

    public void setCust(EfikaCustomer cust) {
        this.cust = cust;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
