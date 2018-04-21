package DAO;

import Entidades.Advertencias;
import Entidades.Funcionario;
import Forms.FeriasForm;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class AdvertenciaDAO {
    private Connection conectar;

    public AdvertenciaDAO() throws SQLException, IOException {
        this.conectar = Conexao.getConnection();
    }
    
    public List<Advertencias> List() throws SQLException, ParseException, IOException {
        String sql = "select * from advertencias order by data desc";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        List<Advertencias> minhaList = new ArrayList<Advertencias>();
        while(rs.next())
        {
            
            minhaList.add(populateAdvertencia(rs));
            
        }

        rs.close();
        stmt.close();
        return minhaList;

    }
    
    private static Advertencias populateAdvertencia(ResultSet rs) throws SQLException, ParseException, IOException{
        
        Advertencias toReturn = new Advertencias();
        FuncionarioDAO dao = new FuncionarioDAO();
        toReturn.setDescricao(rs.getString("descricao"));
        toReturn.setFuncionario((Funcionario) dao.nomeToId(rs.getInt("id_funcionario")).get(0));        
        toReturn.setId(rs.getInt("id"));
        SimpleDateFormat in= new SimpleDateFormat("yyyy-MM-dd");  
        SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");  
        toReturn.setData(out.format(in.parse(rs.getDate("data").toString()))); 
        
        
        
        return toReturn;
        
        
    }
    
    public void novaAdv(Advertencias adv) throws SQLException, ParseException, IOException{
        
        String sql = "insert into advertencias (id_funcionario, descricao, data) values(?,?,?)";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        FuncionarioDAO dao = new FuncionarioDAO();
        stmt.setInt(1,adv.getFuncionario().getId());
        stmt.setString(2, adv.getDescricao());
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        stmt.setDate(3, new Date(form.parse(adv.getData()).getTime()));
        
        dao.AddAdv(adv.getFuncionario());
        
        
        stmt.execute();
        
        if(adv.getFuncionario().getLoja_atual().equals("COSMOS")){
            try {
            // TODO add your handling code here:
            HashMap parametros = new HashMap();
            parametros.put("idFunc", adv.getFuncionario().getId());
            parametros.put("descAdv", adv.getDescricao());
            JasperReport jr = (JasperReport) JRLoader.loadObject("src/Reports/AdvFuncCosmos.jasper");
            JasperPrint jpPrint = JasperFillManager.fillReport(jr, parametros, conectar);
            JasperViewer jv = new JasperViewer(jpPrint, false);
            jv.setVisible(true);
            jv.toFront();
        } catch (JRException ex) {
            Logger.getLogger(FeriasForm.class.getName()).log(Level.SEVERE, null, ex);
        }    
        }else if(adv.getFuncionario().getLoja_atual().equals("MATRIZ")){
            try {
            // TODO add your handling code here:
            HashMap parametros = new HashMap();
            parametros.put("idFunc", adv.getFuncionario().getId());
            parametros.put("descAdv", adv.getDescricao());
            JasperReport jr = (JasperReport) JRLoader.loadObject("src/Reports/AdvFuncLA.jasper");
            JasperPrint jpPrint = JasperFillManager.fillReport(jr, parametros, conectar);
            JasperViewer jv = new JasperViewer(jpPrint, false);
            jv.setVisible(true);
            jv.toFront();
        } catch (JRException ex) {
            Logger.getLogger(FeriasForm.class.getName()).log(Level.SEVERE, null, ex);
        }    
        }else if(adv.getFuncionario().getLoja_atual().equals("FILIAL")){
            try {
            // TODO add your handling code here:
            HashMap parametros = new HashMap();
            parametros.put("idFunc", adv.getFuncionario().getId());
            parametros.put("descAdv", adv.getDescricao());
            JasperReport jr = (JasperReport) JRLoader.loadObject("src/Reports/AdvFuncLRaph.jasper");
            JasperPrint jpPrint = JasperFillManager.fillReport(jr, parametros, conectar);
            JasperViewer jv = new JasperViewer(jpPrint, false);
            jv.setVisible(true);
            jv.toFront();
        } catch (JRException ex) {
            Logger.getLogger(FeriasForm.class.getName()).log(Level.SEVERE, null, ex);
        }  
        }else if(adv.getFuncionario().getLoja_atual().equals("ROTISSERIA")){
            try {
            // TODO add your handling code here:
            HashMap parametros = new HashMap();
            parametros.put("idFunc", adv.getFuncionario().getId());
            parametros.put("descAdv", adv.getDescricao());
            JasperReport jr = (JasperReport) JRLoader.loadObject("src/Reports/AdvFuncRot.jasper");
            JasperPrint jpPrint = JasperFillManager.fillReport(jr, parametros, conectar);
            JasperViewer jv = new JasperViewer(jpPrint, false);
            jv.setVisible(true);
            jv.toFront();
        }catch (JRException ex) {
            Logger.getLogger(FeriasForm.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
        JOptionPane.showMessageDialog(null, "Advertências adicionada com sucesso!!");
        stmt.close();
        
    }
    
    public void alterarAdv(Advertencias adv) throws SQLException, ParseException{
        
        String sql = "update advertencias set descricao = ?, data = ? where id = ?";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        stmt.setString(1, adv.getDescricao());
        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
        stmt.setDate(2, new Date(form.parse(adv.getData()).getTime()));
        stmt.setInt(3, adv.getId());
        
        if(adv.getFuncionario().getLoja_atual().equals("COSMOS")){
            try {
            // TODO add your handling code here:
            HashMap parametros = new HashMap();
            parametros.put("idFunc", adv.getFuncionario().getId());
            parametros.put("descAdv", adv.getDescricao());
            JasperReport jr = (JasperReport) JRLoader.loadObject("src/Reports/AdvFuncCosmos.jasper");
            JasperPrint jpPrint = JasperFillManager.fillReport(jr, parametros, conectar);
            JasperViewer jv = new JasperViewer(jpPrint, false);
            jv.setVisible(true);
            jv.toFront();
        } catch (JRException ex) {
            Logger.getLogger(FeriasForm.class.getName()).log(Level.SEVERE, null, ex);
        }    
        }else if(adv.getFuncionario().getLoja_atual().equals("MATRIZ")){
            try {
            // TODO add your handling code here:
            HashMap parametros = new HashMap();
            parametros.put("idFunc", adv.getFuncionario().getId());
            parametros.put("descAdv", adv.getDescricao());
            JasperReport jr = (JasperReport) JRLoader.loadObject("src/Reports/AdvFuncLA.jasper");
            JasperPrint jpPrint = JasperFillManager.fillReport(jr, parametros, conectar);
            JasperViewer jv = new JasperViewer(jpPrint, false);
            jv.setVisible(true);
            jv.toFront();
        } catch (JRException ex) {
            Logger.getLogger(FeriasForm.class.getName()).log(Level.SEVERE, null, ex);
        }    
        }else if(adv.getFuncionario().getLoja_atual().equals("FILIAL")){
            try {
            // TODO add your handling code here:
            HashMap parametros = new HashMap();
            parametros.put("idFunc", adv.getFuncionario().getId());
            parametros.put("descAdv", adv.getDescricao());
            JasperReport jr = (JasperReport) JRLoader.loadObject("src/Reports/AdvFuncLRaph.jasper");
            JasperPrint jpPrint = JasperFillManager.fillReport(jr, parametros, conectar);
            JasperViewer jv = new JasperViewer(jpPrint, false);
            jv.setVisible(true);
            jv.toFront();
        } catch (JRException ex) {
            Logger.getLogger(FeriasForm.class.getName()).log(Level.SEVERE, null, ex);
        }  
        }else if(adv.getFuncionario().getLoja_atual().equals("ROTISSERIA")){
            try {
            // TODO add your handling code here:
            HashMap parametros = new HashMap();
            parametros.put("idFunc", adv.getFuncionario().getId());
            parametros.put("descAdv", adv.getDescricao());
            JasperReport jr = (JasperReport) JRLoader.loadObject("src/Reports/AdvFuncRot.jasper");
            JasperPrint jpPrint = JasperFillManager.fillReport(jr, parametros, conectar);
            JasperViewer jv = new JasperViewer(jpPrint, false);
            jv.setVisible(true);
            jv.toFront();
        }catch (JRException ex) {
            Logger.getLogger(FeriasForm.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
        
        stmt.execute();
        
        JOptionPane.showMessageDialog(null, "Advertências alterada com sucesso!!");
    }
    
    public void excluirAdv(Advertencias adv) throws SQLException{
        String sql = "delete from advertencias where id = ?";
        PreparedStatement stmt = this.conectar.prepareCall(sql);
        
        stmt.setInt(1, adv.getId());
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Advertência excluída com sucesso!!");
        stmt.close();
    }

}
