/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entidades.Advertencias;
import Entidades.Aniversariante;
import Entidades.AptoFerias;
import Entidades.Atestados;
import Entidades.Funcionario;
import Entidades.Suspensoes;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Airton Robson
 */
public class FuncionarioDAO {
    
    private Connection conectar;

    public FuncionarioDAO() throws SQLException, IOException {
         this.conectar = Conexao.getConnection();
    }
    
    public void cadastrarFuncionario(Funcionario func) throws SQLException, ParseException{
        String sql = "insert into funcionarios (nome, funcao, est_civil, dependentes, endereco, telefone1, telefone2, cpf, rg, nome_pai, nome_mae, org_expeditor,"
                + " data_nasc, grau_instru, funcao_atual, pis, ctps, serie, admissao,loja_atual, data_expedicao, uniforme, calcado, sexo, seq_ferias) values(?, ?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement  stmt = (PreparedStatement) conectar.prepareCall(sql);
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        
        stmt.setString(1, func.getNome());
        stmt.setString(2, func.getFuncao());
        stmt.setString(3, func.getEst_civil());
        stmt.setString(4, func.getDependentes());
        stmt.setString(5, func.getEndereco());
        stmt.setString(6, func.getTelefone1());
        stmt.setString(7, func.getTelefone2());
        stmt.setString(8, func.getCpf());
        stmt.setString(9, func.getRg());
        stmt.setString(10, func.getNome_pai());
        stmt.setString(11, func.getNome_mae());
        stmt.setString(12, func.getOrg_expeditor());
        try{
        stmt.setDate(13, new Date(form.parse(func.getData_nasc()).getTime()));
        }catch(Exception ex){
         stmt.setDate(13, null);
        }
        stmt.setString(14, func.getGrau_instru());
        stmt.setString(15, func.getFuncao_atual());
        stmt.setString(16, func.getPis());
        stmt.setInt(17, func.getCtps());
        stmt.setString(18, func.getSerie());
        try{
        stmt.setDate(19, new Date (form.parse(func.getAdmissao()).getTime()));
        }catch(Exception ex){
            stmt.setDate(19, null);
        }
        stmt.setString(20, func.getLoja_atual());
        try{
        stmt.setDate(21, new Date (form.parse(func.getData_expedicao()).getTime()));
        }catch(Exception ex){
            stmt.setDate(21, null);
        }
        stmt.setString(22, func.getUniforme());
        stmt.setString(23, func.getCalcado());
        stmt.setString(24, func.getSexo());
        stmt.setInt(25, 1);
        
        
        
        stmt.execute();
        
        JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!!");
        
        stmt.close();
        
        
    }
    
    public List<Funcionario> List() throws SQLException, ParseException {
        String sql = "select * from funcionarios order by nome asc";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        List<Funcionario> minhaList = new ArrayList<Funcionario>();
        while(rs.next())
        {
            
            minhaList.add(populateFuncionario(rs));
            
        }

        rs.close();
        stmt.close();
        return minhaList;

    }
    
    public List<Funcionario> ListMulheres() throws SQLException, ParseException {
        String sql = "select * from funcionarios where sexo = 'Feminino' order by nome asc";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        List<Funcionario> minhaList = new ArrayList<Funcionario>();
        while(rs.next())
        {
            
            minhaList.add(populateFuncionario(rs));
            
        }

        rs.close();
        stmt.close();
        return minhaList;

    }
       private static Funcionario populateFuncionario(ResultSet rs) throws SQLException, ParseException{
        
        Funcionario toReturn = new Funcionario();
        SimpleDateFormat in= new SimpleDateFormat("yyyy-MM-dd");  
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");  
        toReturn.setId(rs.getInt("id"));
        toReturn.setNome(rs.getString("nome"));
        toReturn.setFuncao(rs.getString("funcao"));
        toReturn.setEndereco(rs.getString("endereco"));
        try{
        toReturn.setTelefone1(rs.getString("telefone1"));
        }catch (Exception ex){
            toReturn.setTelefone1("(  )     -    ");
        }
        try{
        toReturn.setTelefone2(rs.getString("telefone2"));
        }catch(Exception ex){
            toReturn.setTelefone2("(  )     -    ");
        }
        toReturn.setCpf(rs.getString("cpf"));
        toReturn.setRg(rs.getString("rg"));
        try{
        toReturn.setData_nasc(out.format(in.parse(rs.getDate("data_nasc").toString())));    
        }catch(Exception ex){
            toReturn.setData_nasc("  /  /    ");
        }
        
           
        toReturn.setFuncao_atual(rs.getString("funcao_atual"));
        toReturn.setNum_advertencias(rs.getInt("num_advertencias"));
        toReturn.setNum_suspensoes(rs.getInt("num_suspensoes"));
        toReturn.setNum_atestados(rs.getInt("num_atestados"));
        toReturn.setLoja_atual(rs.getString("loja_atual"));
        try{
        toReturn.setAdmissao(out.format(in.parse(rs.getDate("admissao").toString())));
        }catch (Exception ex){
            toReturn.setAdmissao("  /  /    ");
        }
        try{
        toReturn.setCalcado(rs.getString("calcado"));
        }catch (Exception ex){
            toReturn.setCalcado("-");
        }
        toReturn.setCtps(rs.getInt("ctps"));
        try{
        toReturn.setData_expedicao(out.format(in.parse(rs.getDate("data_expedicao").toString())));
        }catch (Exception ex){
            toReturn.setData_expedicao("  /  /    ");
        }
        toReturn.setDependentes(rs.getString("dependentes"));
        toReturn.setEst_civil(rs.getString("est_civil"));
        toReturn.setGrau_instru(rs.getString("grau_instru"));
        toReturn.setNome_mae(rs.getString("nome_mae"));
        toReturn.setNome_pai(rs.getString("nome_pai"));
        toReturn.setOrg_expeditor(rs.getString("org_expeditor"));
        toReturn.setPis(rs.getString("pis"));
        toReturn.setSerie(rs.getString("serie"));
        toReturn.setSexo(rs.getString("sexo"));
        toReturn.setUniforme(rs.getString("uniforme"));
        
        toReturn.setCalcado(rs.getString("calcado"));
        toReturn.setStatus(rs.getString("status"));
        toReturn.setSeq_ferias(rs.getInt("seq_ferias"));
        toReturn.setDias_ferias(rs.getInt("dias_ferias"));
        return toReturn;
      }
      
    public List<Funcionario> ListAtest() throws SQLException, ParseException {
        String sql = "select * from funcionarios where atestado = 1";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        List<Funcionario> minhaList = new ArrayList<Funcionario>();
        while(rs.next())
        {
            
            
            minhaList.add(populateFuncionario(rs));
        
        }

        rs.close();
        stmt.close();
        return minhaList;

    }
    
    public List<Funcionario> ListSusp() throws SQLException, ParseException {
        String sql = "select * from funcionarios where suspensao = 1";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        List<Funcionario> minhaList = new ArrayList<Funcionario>();
        while(rs.next())
        {
            
            
            minhaList.add(populateFuncionario(rs));
        
        }

        rs.close();
        stmt.close();
        return minhaList;

    }
    
    public List<Funcionario> ListAdv(String nome) throws SQLException, ParseException {
        String sql = "select * from funcionarios where num_advertencias >=1 and nome like '%"+nome+"%'";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        List<Funcionario> minhaList = new ArrayList<Funcionario>();
        while(rs.next())
        {
            
            
            minhaList.add(populateFuncionario(rs));
        
        }

        rs.close();
        stmt.close();
        return minhaList;

    }
    public List<Funcionario> ListPesq(String nome, String especif) throws SQLException, ParseException {
        String sql;
        if(especif.equals("TODOS")){
        sql = "select * from funcionarios where nome like '%"+nome+"%'";    
        }else{
            sql = "select * from funcionarios where loja_atual = '"+especif+"' and nome like '%"+nome+"%' order by nome asc";
        } 
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        List<Funcionario> minhaList = new ArrayList<Funcionario>();
        while(rs.next())
        {
            
            
            minhaList.add(populateFuncionario(rs));
        
        }

        rs.close();
        stmt.close();
        return minhaList;

    }
    
    public List<Funcionario> ListPesqMlr(String nome) throws SQLException, ParseException {
        String sql = "select * from funcionarios where nome like '%"+nome+"%' and sexo = 'Feminino'";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        List<Funcionario> minhaList = new ArrayList<Funcionario>();
        while(rs.next())
        {
            
            
            minhaList.add(populateFuncionario(rs));
        
        }

        rs.close();
        stmt.close();
        return minhaList;

    }
    
    public void editarFuncionario(Funcionario func) throws SQLException, ParseException{
        
        String sql = "update funcionarios set nome = ?, sexo = ?, funcao = ?, est_civil = ?, dependentes = ?, endereco = ?, "
                + "telefone1 = ?, telefone2 = ?, cpf = ?, rg = ?, nome_pai = ?, nome_mae = ?, org_expeditor = ?, data_nasc = ?, "
                + "grau_instru = ?, funcao_atual = ?, pis = ?, ctps = ?, serie = ?, admissao = ?, loja_atual = ?, "
                + "data_expedicao = ?, uniforme = ?, calcado = ? where id = ?";
        
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        
        stmt.setString(1, func.getNome());
        stmt.setString(2, func.getSexo());
        stmt.setString(3, func.getFuncao());
        stmt.setString(4, func.getEst_civil());
        stmt.setString(5, func.getDependentes());
        stmt.setString(6, func.getEndereco());
        stmt.setString(7, func.getTelefone1());
        stmt.setString(8, func.getTelefone2());
        stmt.setString(9, func.getCpf());
        stmt.setString(10, func.getRg());
        stmt.setString(11, func.getNome_pai());
        stmt.setString(12, func.getNome_mae());
        stmt.setString(13, func.getOrg_expeditor());
        try{
        stmt.setDate(14,new Date (form.parse(func.getData_nasc()).getTime()));
        }catch(Exception ex){
            stmt.setDate(14, null);
        }
        stmt.setString(15, func.getGrau_instru());
        stmt.setString(16, func.getFuncao_atual());
        stmt.setString(17, func.getPis());
        stmt.setInt(18, func.getCtps());
        stmt.setString(19, func.getSerie());
        try{
        stmt.setDate(20,new Date (form.parse(func.getAdmissao()).getTime()));
        }catch (Exception ex){
            stmt.setDate(20, null);
        }
        stmt.setString(21, func.getLoja_atual());
        try{
        stmt.setDate(22,new Date (form.parse(func.getData_expedicao()).getTime()));
        }catch(Exception ex){
         stmt.setDate(22, null);
        }   
        stmt.setString(23, func.getUniforme());
        stmt.setString(24, func.getCalcado());
        stmt.setInt(25, func.getId());
        
        stmt.execute();
        
        JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso!!");
        
        stmt.close();
        
    }
    
    public void excluirFuncionario(Funcionario func) throws SQLException{
     
        String sql = "delete from funcionarios where id = ?";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        
        stmt.setInt(1, func.getId());
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso!!");
        stmt.close();
    }
    
    public List<Funcionario> nomeToId(int id) throws SQLException, ParseException{
        
        String sql = "select * from funcionarios where id = ?";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
       List<Funcionario> minhaList = new ArrayList<Funcionario>();
        while(rs.next())
        {
            
            minhaList.add(populateFuncionario(rs));
            
        }

        rs.close();
        stmt.close();
        return minhaList;
        
    }
    
    public List<Funcionario> IdToNome(String nome) throws SQLException, ParseException{
        
        String sql = "select * from funcionarios where nome = ?";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        
        stmt.setString(1, nome);
        
        ResultSet rs = stmt.executeQuery();
       List<Funcionario> minhaList = new ArrayList<Funcionario>();
        while(rs.next())
        {
            
            minhaList.add(populateFuncionario(rs));
            
        }

        rs.close();
        stmt.close();
        return minhaList;
        
    }
    
    public void AddAdv(Funcionario func) throws SQLException, ParseException{
        
        String sql = "update funcionarios set num_advertencias = ? where id = ?";
        
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        
        func = (Funcionario) nomeToId(func.getId()).get(0);
        
        stmt.setInt(1, (func.getNum_advertencias()+1));
        stmt.setInt(2, func.getId());
        
        
        stmt.execute();
        
        
        
        stmt.close();
        
    }
    
    public void AddAtest(Funcionario func) throws SQLException, ParseException{
        
        String sql = "update funcionarios set num_atestados = ? where id = ?";
        
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        
        
        
        stmt.setInt(1, (func.getNum_atestados()+1));
        stmt.setInt(2, func.getId());
        
        
        stmt.execute();
        
        
        
        stmt.close();
        
    }
    
    public void AddSusp(Funcionario func) throws SQLException, ParseException{
        
        String sql = "update funcionarios set num_suspensoes = ? where id = ?";
        
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        
        func = (Funcionario) nomeToId(func.getId()).get(0);
        
        stmt.setInt(1, (func.getNum_suspensoes()+1));
        stmt.setInt(2, func.getId());
        
        
        stmt.execute();
        
        
        
        stmt.close();
        
    }
    
    public int getDiasFerias(String nome) throws SQLException{
        
        String sql = "select * from funcionarios where nome= ?";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        stmt.setString(1, nome);
        
        ResultSet rs = stmt.executeQuery();
        
        rs.next();
        return rs.getInt("dias_ferias");
        
        
        
    }
    
    public void setAptidao(Funcionario func) throws SQLException{
        String sql = "update funcionarios set status = ? where id = ?";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        
        stmt.setString(1, "APTO A RECEBER FÉRIAS");
        stmt.setInt(2, func.getId());
        stmt.execute();
        stmt.close();
    }
    
    public void setEmFerias(Funcionario func) throws SQLException{
        String sql = "update funcionarios set status = ? where id = ?";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        
        stmt.setString(1, "EM FÉRIAS");
        stmt.setInt(2, func.getId());
        stmt.execute();
        stmt.close();
    }
    
    public void setTrabalho(Funcionario func) throws SQLException{
        String sql = "update funcionarios set status = ? where id = ?";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        
        stmt.setString(1, "-");
        stmt.setInt(2, func.getId());
        stmt.execute();
        stmt.close();
    }
    
    public void setSeqferias(Funcionario func) throws SQLException{
        String sql = "update funcionarios set seq_ferias = ? where id = ?";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        
        stmt.setInt(1, func.getSeq_ferias()+1);
        
        stmt.setInt(2, func.getId());
        stmt.execute();
        stmt.close();
    }
    
    public void setDiasFerias(Funcionario func, int periodo) throws SQLException{
        String sql = "update funcionarios set dias_ferias = ? where id = ?";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        
        stmt.setInt(1, func.getDias_ferias()-periodo);
        
        stmt.setInt(2, func.getId());
        stmt.execute();
        stmt.close();
    }
    
    public List<Funcionario> ListCosmos() throws SQLException, ParseException {
        String sql = "select * from funcionarios where loja_atual = 'COSMOS' order by nome asc";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        List<Funcionario> minhaList = new ArrayList<Funcionario>();
        while(rs.next())
        {
            
            minhaList.add(populateFuncionario(rs));
            
        }

        rs.close();
        stmt.close();
        return minhaList;

    }
    public List<Funcionario> ListFilial() throws SQLException, ParseException {
        String sql = "select * from funcionarios where loja_atual = 'FILIAL' order by nome asc";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        List<Funcionario> minhaList = new ArrayList<Funcionario>();
        while(rs.next())
        {
            
            minhaList.add(populateFuncionario(rs));
            
        }

        rs.close();
        stmt.close();
        return minhaList;

    }
    public List<Funcionario> ListMatriz() throws SQLException, ParseException {
        String sql = "select * from funcionarios where loja_atual = 'MATRIZ' order by nome asc";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        List<Funcionario> minhaList = new ArrayList<Funcionario>();
        while(rs.next())
        {
            
            minhaList.add(populateFuncionario(rs));
            
        }

        rs.close();
        stmt.close();
        return minhaList;

    }
    public List<Funcionario> ListRotisseria() throws SQLException, ParseException {
        String sql = "select * from funcionarios where loja_atual = 'ROTISSERIA' order by nome asc";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        List<Funcionario> minhaList = new ArrayList<Funcionario>();
        while(rs.next())
        {
            
            minhaList.add(populateFuncionario(rs));
            
        }

        rs.close();
        stmt.close();
        return minhaList;

    }
    
    public List<Aniversariante> ListAniversario(int mes) throws SQLException, ParseException {
        String sql = "select * from funcionarios where Month(data_nasc) = ?";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        stmt.setInt(1, mes);
        ResultSet rs = stmt.executeQuery();
        List<Aniversariante> minhaList = new ArrayList<Aniversariante>();
        while(rs.next())
        {
            
            minhaList.add(populateAniversariante(rs));
            
        }

        rs.close();
        stmt.close();
        return minhaList;

    }
    
    private static Aniversariante populateAniversariante(ResultSet rs) throws SQLException, ParseException{
        
        Aniversariante toReturn = new Aniversariante();
        SimpleDateFormat in= new SimpleDateFormat("yyyy-MM-dd");  
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        
        toReturn.setNome(rs.getString("nome"));
        toReturn.setData_nasc(out.format(in.parse(rs.getDate("data_nasc").toString())));
        
        return toReturn;
    }
}
