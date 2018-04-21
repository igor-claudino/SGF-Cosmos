/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import Forms.SwingColumn;

/**
 *
 * @author Airton Robson
 */
public class AptoFerias {
    
    
    @SwingColumn (description= "Nome")
    private Funcionario funcionario;
    @SwingColumn (description= "Status")
    private String status;
    @SwingColumn (description= "Data de início")
    private String data_inicio;
    @SwingColumn (description= "Data de volta")
    private String data_volta;

    public String getData_volta() {
        return data_volta;
    }

    public void setData_volta(String data_volta) {
        this.data_volta = data_volta;
    }
    
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }
    
    
    
}
