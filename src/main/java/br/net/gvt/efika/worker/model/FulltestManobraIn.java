package br.net.gvt.efika.worker.model;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;

/**
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@telefonica.com
 * System Analyst
 * 41 9 9513-0230
 **/
public class FulltestManobraIn {

    private EfikaCustomer cust;
    private String executor;

    public FulltestManobraIn(EfikaCustomer cust, String executor) {
        this.cust = cust;
        this.executor = executor;
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

}
