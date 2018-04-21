/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.AptoFerias;
import Entidades.Ferias;
import Entidades.Funcionario;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Airton Robson
 */
public class FeriasDAO {

    private Connection conectar;

    public FeriasDAO() throws SQLException, IOException {
        this.conectar = Conexao.getConnection();
    }

    public void inserirFerias(Ferias ferias, int periodo) throws SQLException, ParseException, IOException {

        String sql = "insert into ferias (id_funcionario, data_inicio, data_volta) values(?,?,?)";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        FuncionarioDAO dao = new FuncionarioDAO();
        stmt.setInt(1, ferias.getFuncionario().getId());
        stmt.setDate(2, new Date(form.parse(ferias.getData_inicio()).getTime()));
        Calendar calendarInicio = Calendar.getInstance();
        calendarInicio.setTime(new Date(form.parse(ferias.getData_inicio()).getTime()));
        calendarInicio.add(Calendar.DAY_OF_MONTH, periodo);
        stmt.setDate(3, new Date(calendarInicio.getTimeInMillis()));
        
        dao.setEmFerias(ferias.getFuncionario());
        dao.setSeqferias(ferias.getFuncionario());
        dao.setDiasFerias(ferias.getFuncionario(), periodo);

        stmt.execute();
        JOptionPane.showMessageDialog(null, "Férias concedidas com sucesso!!");
    }
    
    public Ferias ListaFerias(int id) throws SQLException, ParseException{
        
        String sql = "select * from ferias where id_funcionario = ?";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        Ferias fer = new Ferias();
        SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        rs.next();
        fer.setData_inicio(out.format(in.parse(rs.getDate("data_inicio").toString())));
        fer.setData_volta(out.format(in.parse(rs.getDate("data_volta").toString())));
        
        return fer;
    }

    public List<AptoFerias> List() throws SQLException, ParseException, IOException {
        String sql = "select * from funcionarios order by admissao asc";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        List<AptoFerias> minhaList = new ArrayList<AptoFerias>();
        while (rs.next()) {
            //Início da gambiarra
            java.sql.Date data = new java.sql.Date(114, 7, 1);
            long var1 = new java.sql.Date(114, 8, 15).getTime();
            long var2 = data.getTime();
            long qc = var1 - var2;
            //Fim da gambiarra
            java.util.Date da = new java.util.Date();
            Calendar calendarInicio = Calendar.getInstance();

            if (rs.getDate("admissao") != null) {
                calendarInicio.setTime(rs.getDate("admissao"));
                calendarInicio.add(Calendar.YEAR, rs.getInt("seq_ferias"));
                long dataferias = calendarInicio.getTimeInMillis();
                java.sql.Date dataadm = rs.getDate("admissao");
                long hojeqc = da.getTime() + qc;
                if ((dataferias>= da.getTime() && dataferias<=hojeqc) || (rs.getString("status").equals("EM FÉRIAS") || rs.getString("status").equals("APTO A RECEBER FÉRIAS")) || rs.getInt("dias_ferias")!=0) {
                    minhaList.add(populateFerias(rs));
                }
                
            }
        }

        rs.close();
        stmt.close();
        return minhaList;

    }

    private AptoFerias populateFerias(ResultSet rs) throws SQLException, ParseException, IOException {

        AptoFerias toReturn = new AptoFerias();
        FuncionarioDAO dao = new FuncionarioDAO();

        toReturn.setFuncionario((Funcionario) dao.nomeToId(rs.getInt("id")).get(0));
        if(rs.getString("status").equals("EM FÉRIAS")){
                    toReturn.setStatus("EM FÉRIAS");
                    dao.setEmFerias(toReturn.getFuncionario());
                    SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
                    toReturn.setData_inicio(ListaFerias(rs.getInt("id")).getData_inicio());
                    toReturn.setData_volta(ListaFerias(rs.getInt("id")).getData_volta());
                }else{
            toReturn.setStatus("APTO A RECEBER FÉRIAS");
            dao.setAptidao(toReturn.getFuncionario());
            SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendarInicio = Calendar.getInstance();
        calendarInicio.setTime(new Date(rs.getDate("admissao").getTime()));
        calendarInicio.add(Calendar.YEAR, rs.getInt("seq_ferias"));
        java.sql.Date data = new java.sql.Date(calendarInicio.getTimeInMillis());
        toReturn.setData_inicio(out.format(in.parse(data.toString())));
        calendarInicio.setTime(data);
        calendarInicio.add(Calendar.DAY_OF_MONTH, 30);
        toReturn.setData_volta(out.format(in.parse(new java.sql.Date(calendarInicio.getTimeInMillis()).toString())));
        
        }
        
        return toReturn;

    }

    private void definirStatus(Funcionario func) throws SQLException {

        String sql = "update funcionarios set status = APTO A RECEBER FÉRIAS where id = " + func.getId();
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        stmt.execute();
        stmt.close();

    }
    
    public void encerrarFerias() throws SQLException, IOException{
        
        String sql = "select * from ferias";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
        if(System.currentTimeMillis()>rs.getDate("data_volta").getTime()){
            
            FuncionarioDAO dao = new FuncionarioDAO();
            Funcionario func = new Funcionario();
            
            func.setId(rs.getInt("id_funcionario"));
            dao.setTrabalho(func);
            
        }
            }
    }

}
