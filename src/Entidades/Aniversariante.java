/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Forms.SwingColumn;

/**
 *
 * @author Igor
 */
public class Aniversariante {
    
    @SwingColumn (description= "Nome")
    private String nome;
    @SwingColumn (description= "Data de Nascimento")
    private String data_nasc;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }
    
    
    
}
