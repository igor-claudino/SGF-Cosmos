/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entidades.Funcionario;
import Entidades.LicencaDoenca;
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
public class LicencaDoencaDAO {
    
    private Connection conectar;

    public LicencaDoencaDAO() throws SQLException, IOException {
        this.conectar = Conexao.getConnection();
    }
    
    public List<LicencaDoenca> List() throws SQLException, ParseException, IOException {
        String sql = "select * from licenca_doenca order by data_volta desc";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        List<LicencaDoenca> minhaList = new ArrayList<LicencaDoenca>();
        while(rs.next())
        {
            
            minhaList.add(populateLicDoe(rs));
            
        }

        rs.close();
        stmt.close();
        return minhaList;

    }
    
    private static LicencaDoenca populateLicDoe(ResultSet rs) throws SQLException, ParseException, IOException{
        
        LicencaDoenca toReturn = new LicencaDoenca();
        FuncionarioDAO dao = new FuncionarioDAO();
        SimpleDateFormat in= new SimpleDateFormat("yyyy-MM-dd");  
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy"); 
        toReturn.setFuncionario((Funcionario) dao.nomeToId(rs.getInt("id_funcionario")).get(0));
        toReturn.setId(rs.getInt("id"));
        toReturn.setData_inicio(out.format(in.parse(rs.getDate("data_inicio").toString())));
        toReturn.setData_volta(out.format(in.parse(rs.getDate("data_volta").toString())));
        
        
        return toReturn;
        
        
    }
    
    public void novaLicDoe(LicencaDoenca lic) throws SQLException, ParseException, IOException{
        
        String sql = "insert into licenca_doenca (id_funcionario, data_inicio, data_volta) values(?,?,?)";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        FuncionarioDAO dao = new FuncionarioDAO();
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        stmt.setInt(1, lic.getFuncionario().getId());
        stmt.setDate(2, new Date(form.parse(lic.getData_inicio()).getTime()));
        Calendar calendarInicio = Calendar.getInstance();
        calendarInicio.setTime(new Date(form.parse(lic.getData_inicio()).getTime()));
        calendarInicio.add(Calendar.DAY_OF_MONTH, lic.getPeriodo());
        java.util.Date datavolta = calendarInicio.getTime();
        
        java.sql.Date date = new java.sql.Date(datavolta.getTime());
        
        stmt.setDate(3, date);
        
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Licença adicionada com sucesso!!");
        
        stmt.close();
        
        
        
    }
    
    public void alterarLicDoe(LicencaDoenca lic) throws SQLException, ParseException, IOException{
        
        String sql = "update licenca_doenca set id_funcionario = ?, data_inicio = ?, data_volta = ? where id = ?";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        FuncionarioDAO dao = new FuncionarioDAO();
        stmt.setInt(1, lic.getFuncionario().getId());
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        stmt.setDate(2, new Date(form.parse(lic.getData_inicio()).getTime()));
        stmt.setDate(3, new Date(form.parse(lic.getData_volta()).getTime()));
        stmt.setInt(4, lic.getId());
        
        
        stmt.execute();
        
        JOptionPane.showMessageDialog(null, "Licença alterada com sucesso!!");
    }
    
    public void excluirLicDoe(LicencaDoenca licd) throws SQLException{
        String sql = "delete from licenca_doenca where id = ?";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        
        stmt.setInt(1, licd.getId());
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Licença excluída com sucesso!!");
        stmt.close();
    }
    
    
    
}
