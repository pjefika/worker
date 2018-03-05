/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.net.gvt.efika.worker.util;

/**
 *
 * @author G0042204
 */
public class Teste {

    private String teste;

    public Teste() {
    }

    public Teste(String teste) {
        this.teste = teste;
    }

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }

    @Override
    public boolean equals(Object obj) {
        Teste t = (Teste) obj;
        return this.getTeste().equalsIgnoreCase(t.getTeste());
    }

}
