package DAO;

import Entidades.Advertencias;
import Entidades.Atestados;
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
public class AtestadoDAO {
    
    private Connection conectar;

    public AtestadoDAO() throws SQLException, IOException {
        this.conectar = Conexao.getConnection();
    }
    
    public List<Atestados> List() throws SQLException, ParseException, IOException {
        String sql = "select * from atestados order by data_volta desc";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        List<Atestados> minhaList = new ArrayList<Atestados>();
        while(rs.next())
        {
            
            minhaList.add(populateAtestados(rs));
            
        }

        rs.close();
        stmt.close();
        return minhaList;

    }
    
    private static Atestados populateAtestados(ResultSet rs) throws SQLException, ParseException, IOException{
        
        Atestados toReturn = new Atestados();
        FuncionarioDAO dao = new FuncionarioDAO();
        SimpleDateFormat in= new SimpleDateFormat("yyyy-MM-dd");  
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy"); 
        toReturn.setFuncionario((Funcionario) dao.nomeToId(rs.getInt("id_funcionario")).get(0));
        toReturn.setId(rs.getInt("id"));
        toReturn.setData_inicio(out.format(in.parse(rs.getDate("data_inicio").toString())));
        toReturn.setData_volta(out.format(in.parse(rs.getDate("data_volta").toString())));
        
        
        return toReturn;
        
        
    }
    
    public void novoAtestado(Atestados atest) throws SQLException, ParseException, IOException{
        
        String sql = "insert into atestados (id_funcionario, data_inicio, data_volta) values(?,?,?)";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        FuncionarioDAO dao = new FuncionarioDAO();
        Funcionario func = new Funcionario();
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        
        
        stmt.setInt(1, atest.getFuncionario().getId());
        stmt.setDate(2, new Date(form.parse(atest.getData_inicio()).getTime()));
        Calendar calendarInicio = Calendar.getInstance();
        calendarInicio.setTime(new Date(form.parse(atest.getData_inicio()).getTime()));
        calendarInicio.add(Calendar.DAY_OF_MONTH, atest.getPeriodo());
        java.util.Date datavolta = calendarInicio.getTime();
        
        java.sql.Date date = new java.sql.Date(datavolta.getTime());
        
        stmt.setDate(3, date);
        
        stmt.execute();
        dao.AddAtest(atest.getFuncionario());
        JOptionPane.showMessageDialog(null, "Atestado adicionado com sucesso!!");
        
        stmt.close();
        
        
        
    }
    
    public void alterarAtestado(Atestados atest) throws SQLException, ParseException, IOException{
        
        String sql = "update atestados set data_inicio = ?, data_volta = ? where id = ?";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        FuncionarioDAO dao = new FuncionarioDAO();
        
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        stmt.setDate(1, new Date(form.parse(atest.getData_inicio()).getTime()));
        stmt.setDate(2, new Date(form.parse(atest.getData_volta()).getTime()));
        stmt.setInt(3, atest.getId());
        
        
        stmt.execute();
        
        JOptionPane.showMessageDialog(null, "Advertências alterada com sucesso!!");
    }
    
    public void excluirAtest(Atestados atest) throws SQLException{
        String sql = "delete from atestados where id = ?";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        
        stmt.setInt(1, atest.getId());
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Atestado excluído com sucesso!!");
        stmt.close();
    }
    
}
