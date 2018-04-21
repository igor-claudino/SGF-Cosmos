package DAO;

import Entidades.Parametrodb;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao {
    
    static ConfiguracaoDAO conf = new ConfiguracaoDAO();
    static Parametrodb par = new Parametrodb();
    public static Connection getConnection() throws SQLException, IOException {
        try {
            par = conf.loadConf();
            Class.forName("com.mysql.jdbc.Driver");
            return (Connection) DriverManager.getConnection("jdbc:mysql://"+par.getUrl()+"/"+par.getDb(), par.getUser(), par.getSenha());
        } catch (Exception er) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, er);
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o BD!!");
            return null;
        }
        
    }
}
