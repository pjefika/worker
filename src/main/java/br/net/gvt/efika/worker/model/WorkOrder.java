package br.net.gvt.efika.worker.model;

import br.net.gvt.efika.efika_customer.model.customer.EfikaCustomer;

/**
 * Tiago Henrique Iwamoto
 * tiago.iwamoto@telefonica.com
 * System Analyst
 * 41 9 9513-0230
 **/
public class WorkOrder{

    private String workOrderId;
    private String executor;
    private EfikaCustomer cust;

    public WorkOrder(String workOrderId, String executor, EfikaCustomer cust) {
        this.workOrderId = workOrderId;
        this.executor = executor;
        this.cust = cust;
    }

    public String getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(String workOrderId) {
        this.workOrderId = workOrderId;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public EfikaCustomer getCust() {
        return cust;
    }

    public void setCust(EfikaCustomer cust) {
        this.cust = cust;
    }
}
