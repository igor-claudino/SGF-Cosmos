package Entidades;

import Forms.SwingColumn;

public class Funcionario {
    
    @SwingColumn (description= "Cód.")
    private Integer id;
    @SwingColumn (description= "Nome")
    private String nome;
    private String funcao;
    private String est_civil;
    private String sexo;
    private String dependentes;
    @SwingColumn (description= "Endereço")
    private String endereco;
    @SwingColumn (description= "Telefone 1")
    private String telefone1;
    @SwingColumn (description= "Telefone 2")
    private String telefone2;
    @SwingColumn (description= "CPF")
    private String cpf;
    @SwingColumn (description= "RG")
    private String rg;
    private String nome_pai;
    private String nome_mae;
    private String org_expeditor;
    private String data_nasc;
    private String grau_instru;
    private String funcao_atual;
    private String pis;
    @SwingColumn (description= "CTPS")
    private int ctps;
    private String serie;
    private String admissao;
    @SwingColumn (description= "Adv.")
    private int num_advertencias;
    private int advertencia;
    @SwingColumn (description= "Susp.")
    private int num_suspensoes;
    private int suspensao;
    @SwingColumn (description= "Atest.")
    private int num_atestados;
    private int atestado;
    private String loja_atual;
    private String data_expedicao;
    private String uniforme;
    private String calcado;
    private String status;
    private int seq_ferias;
    private int dias_ferias;

    public int getDias_ferias() {
        return dias_ferias;
    }

    public void setDias_ferias(int dias_ferias) {
        this.dias_ferias = dias_ferias;
    }
    
    public int getSeq_ferias() {
        return seq_ferias;
    }

    public void setSeq_ferias(int seq_ferias) {
        this.seq_ferias = seq_ferias;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getEst_civil() {
        return est_civil;
    }

    public void setEst_civil(String est_civil) {
        this.est_civil = est_civil;
    }

    public String getDependentes() {
        return dependentes;
    }

    public void setDependentes(String dependentes) {
        this.dependentes = dependentes;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1= telefone1;
    }
    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_pai() {
        return nome_pai;
    }

    public void setNome_pai(String nome_pai) {
        this.nome_pai = nome_pai;
    }

    public String getNome_mae() {
        return nome_mae;
    }

    public void setNome_mae(String nome_mae) {
        this.nome_mae = nome_mae;
    }

    public String getOrg_expeditor() {
        return org_expeditor;
    }

    public void setOrg_expeditor(String org_expeditor) {
        this.org_expeditor = org_expeditor;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc){
        
            this.data_nasc =data_nasc;
        
    }

    public String getGrau_instru() {
        return grau_instru;
    }

    public void setGrau_instru(String grau_instru) {
        this.grau_instru = grau_instru;
    }

    public String getFuncao_atual() {
        return funcao_atual;
    }

    public void setFuncao_atual(String funcao_atual) {
        this.funcao_atual = funcao_atual;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public int getCtps() {
        return ctps;
    }

    public void setCtps(int ctps) {
        this.ctps = ctps;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getAdmissao() {
        return admissao;
    }

    public void setAdmissao(String admissao) {
        
            this.admissao = admissao;
        
    }

    public int getNum_advertencias() {
        return num_advertencias;
    }

    public void setNum_advertencias(int num_advertencias) {
        this.num_advertencias = num_advertencias;
    }

    public int getNum_suspensoes() {
        return num_suspensoes;
    }

    public void setNum_suspensoes(int num_suspensoes) {
        this.num_suspensoes = num_suspensoes;
    }

    public int getNum_atestados() {
        return num_atestados;
    }

    public void setNum_atestados(int num_atestados) {
        this.num_atestados = num_atestados;
    }

    public int getAdvertencia() {
        return advertencia;
    }

    public void setAdvertencia(int advertencia) {
        this.advertencia = advertencia;
    }

    public int getSuspensao() {
        return suspensao;
    }

    public void setSuspensao(int suspensao) {
        this.suspensao = suspensao;
    }

    public int getAtestado() {
        return atestado;
    }

    public void setAtestado(int atestado) {
        this.atestado = atestado;
    }
    
    public String getLoja_atual() {
        return loja_atual;
    }

    public void setLoja_atual(String loja_atual) {
        this.loja_atual = loja_atual;
    }

    public String getData_expedicao() {
        return data_expedicao;
    }

    public void setData_expedicao(String data_expedicao) {
   
            this.data_expedicao = data_expedicao;
        
    }

    public String getUniforme() {
        return uniforme;
    }

    public void setUniforme(String uniforme) {
        this.uniforme = uniforme;
    }

    public String getCalcado() {
        return calcado;
    }

    public void setCalcado(String calcado) {
        this.calcado = calcado;
    }

    @Override
    public String toString() {
        return nome;
    }
        
}
