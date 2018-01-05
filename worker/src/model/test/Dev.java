/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.test;

/**
 *
 * @author G0042204
 */
public class Dev {

    private String teste;

    private Integer number;

    public Dev() {
    }

    public Dev(String teste, Integer number) {
        this.teste = teste;
        this.number = number;
    }
    
    

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

}
