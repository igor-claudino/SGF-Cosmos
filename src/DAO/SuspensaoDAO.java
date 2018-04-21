/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Entidades.Advertencias;
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
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Airton Robson
 */
public class SuspensaoDAO {
    
    private Connection conectar;

    public SuspensaoDAO() throws SQLException, IOException {
        this.conectar = Conexao.getConnection();
    }
    
    public void novaSusp(Suspensoes susp) throws SQLException, ParseException, IOException{
        
        String sql = "insert into suspensoes (id_funcionario, descricao, data_inicio, data_volta) values(?,?,?,?)";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        FuncionarioDAO dao = new FuncionarioDAO();
        stmt.setInt(1,susp.getFuncionario().getId());
        stmt.setString(2, susp.getDescricao());
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        stmt.setDate(3, new Date(form.parse(susp.getData_inicio()).getTime()));
        Calendar calendarInicio = Calendar.getInstance();
        calendarInicio.setTime(new Date(form.parse(susp.getData_inicio()).getTime()));
        calendarInicio.add(Calendar.DAY_OF_MONTH, susp.getPeriodo());
        java.util.Date datavolta = calendarInicio.getTime();
        
        java.sql.Date date = new java.sql.Date(datavolta.getTime());
        
        stmt.setDate(4, date);
        stmt.execute();
        dao.AddSusp(susp.getFuncionario());
        JOptionPane.showMessageDialog(null, "Suspensão adicionada com sucesso!!");
        stmt.close();
        
    }
    
    public List<Suspensoes> List() throws SQLException, ParseException, IOException {
        String sql = "select * from suspensoes order by data_volta desc";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        List<Suspensoes> minhaList = new ArrayList<Suspensoes>();
        while(rs.next())
        {
            
            minhaList.add(populateSuspensoes(rs));
            
        }

        rs.close();
        stmt.close();
        return minhaList;

    }
    
    private static Suspensoes populateSuspensoes(ResultSet rs) throws SQLException, ParseException, IOException{
        
        Suspensoes toReturn = new Suspensoes();
        FuncionarioDAO dao = new FuncionarioDAO();
        SimpleDateFormat in= new SimpleDateFormat("yyyy-MM-dd");  
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy"); 
        toReturn.setFuncionario((Funcionario) dao.nomeToId(rs.getInt("id_funcionario")).get(0));
        toReturn.setId(rs.getInt("id"));
        toReturn.setData_inicio(out.format(in.parse(rs.getDate("data_inicio").toString())));
        toReturn.setData_volta(out.format(in.parse(rs.getDate("data_volta").toString())));
        toReturn.setDescricao(rs.getString("descricao"));
        
        
        return toReturn;
        
        
    }
    
    public void alterarSuspensao(Suspensoes susp) throws SQLException, ParseException, IOException{
        
        String sql = "update suspensoes set id_funcionario = ?, data_inicio = ?, data_volta = ?, descricao = ? where id = ?";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        FuncionarioDAO dao = new FuncionarioDAO();
        stmt.setInt(1, susp.getFuncionario().getId());
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        stmt.setDate(2, new Date(form.parse(susp.getData_inicio()).getTime()));
        stmt.setDate(3, new Date(form.parse(susp.getData_volta()).getTime()));
        stmt.setString(4, susp.getDescricao());
        stmt.setInt(5, susp.getId());
        
        
        stmt.execute();
        
        JOptionPane.showMessageDialog(null, "Suspensão alterada com sucesso!!");
    }
    
    public void excluirSusp(Suspensoes susp) throws SQLException{
        String sql = "delete from suspensoes where id = ?";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        
        stmt.setInt(1, susp.getId());
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Suspensão excluída com sucesso!!");
        stmt.close();
    }
    
}
