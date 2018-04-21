package Entidades;

import Forms.SwingColumn;

public class Advertencias {
    
    private Integer id;      
    @SwingColumn (description= "Nome")
    private Funcionario funcionario;
    @SwingColumn (description= "Descrição")
    private String descricao;
    @SwingColumn (description= "Data")
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
        
}
