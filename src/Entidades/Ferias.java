/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entidades;

import Forms.SwingColumn;
import java.sql.Date;

/**
 *
 * @author Airton Robson
 */
public class Ferias {
    
    private Integer id;
    @SwingColumn (description= "Nome")
    private Funcionario funcionario;
    private String data_inicio;
    @SwingColumn (description= "Data da volta")
    private String data_volta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_volta() {
        return data_volta;
    }

    public void setData_volta(String data_volta) {
        this.data_volta = data_volta;
    }
    
}
