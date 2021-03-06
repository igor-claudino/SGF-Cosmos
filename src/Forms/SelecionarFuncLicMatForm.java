/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Forms;

import DAO.FuncionarioDAO;
import Entidades.Funcionario;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Airton Robson
 */
public class SelecionarFuncLicMatForm extends javax.swing.JFrame {

    /**
     * Creates new form SelecionarFuncAdvtForm
     */
    
    List<Funcionario> minhaList = new ArrayList<Funcionario>();
    String pesq = "";
    
    public SelecionarFuncLicMatForm() throws IOException {
        initComponents();
        preencherTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_func = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tf_nomePesq = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tb_func.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_func.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tb_funcMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tb_func);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Nome:");

        tf_nomePesq.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tf_nomePesq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_nomePesqKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(tf_nomePesq, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_nomePesq, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(546, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(201, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        setSize(new java.awt.Dimension(872, 670));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_nomePesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_nomePesqKeyReleased
        // TODO add your handling code here:
        pesq = tf_nomePesq.getText();
        String ant = "";
        try {
            FuncionarioDAO dao = new FuncionarioDAO();
            if(pesq.equals("")){
                preencherTabela();
            }else{
              minhaList =  dao.ListPesqMlr(pesq);
              preencherPesq(minhaList);
              ant = pesq;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioForm.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Funcionário não encontrado!!", "Erro", JOptionPane.ERROR_MESSAGE);
            tf_nomePesq.setText(ant);
        } catch (ParseException ex) {
            Logger.getLogger(FuncionarioForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SelecionarFuncLicMatForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tf_nomePesqKeyReleased

    private void tb_funcMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_funcMouseReleased
        // TODO add your handling code here:
        Funcionario func = new Funcionario();
        if (tb_func.getSelectedRow() != -1) {
            
          func = (Funcionario) minhaList.get(tb_func.getSelectedRow()); 
          
          NovaLicMatForm dialog = new NovaLicMatForm(this, true, func, this);            
          dialog.setVisible(true);
          dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tb_funcMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SelecionarFuncAdvtForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelecionarFuncAdvtForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelecionarFuncAdvtForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelecionarFuncAdvtForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SelecionarFuncAdvtForm().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(SelecionarFuncLicMatForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    public void preencherTabela() throws IOException {
        try {
            FuncionarioDAO dao = new FuncionarioDAO();
            minhaList = dao.ListMulheres();
            MyTableModel mtb = new MyTableModel(Funcionario.class, minhaList, tb_func);
            tb_func.setModel(mtb);
            tb_func.getColumnModel().getColumn(0).setPreferredWidth(40);
            tb_func.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_func.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_func.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_func.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_func.getColumnModel().getColumn(5).setPreferredWidth(120);
            tb_func.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_func.getColumnModel().getColumn(7).setPreferredWidth(40);
            tb_func.getColumnModel().getColumn(8).setPreferredWidth(40);
            tb_func.getColumnModel().getColumn(9).setPreferredWidth(40);
        } catch (SQLException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(FuncionarioForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }
    
    public void preencherPesq(List<Funcionario> func) throws IOException{
        try {
            FuncionarioDAO dao = new FuncionarioDAO();
            MyTableModel mtb = new MyTableModel(Funcionario.class, minhaList, tb_func);
            tb_func.setModel(mtb);
            tb_func.getColumnModel().getColumn(0).setPreferredWidth(40);
            tb_func.getColumnModel().getColumn(1).setPreferredWidth(300);
            tb_func.getColumnModel().getColumn(2).setPreferredWidth(300);
            tb_func.getColumnModel().getColumn(3).setPreferredWidth(100);
            tb_func.getColumnModel().getColumn(4).setPreferredWidth(100);
            tb_func.getColumnModel().getColumn(5).setPreferredWidth(120);
            tb_func.getColumnModel().getColumn(6).setPreferredWidth(120);
            tb_func.getColumnModel().getColumn(7).setPreferredWidth(40);
            tb_func.getColumnModel().getColumn(8).setPreferredWidth(40);
            tb_func.getColumnModel().getColumn(9).setPreferredWidth(40);
        } catch (SQLException ex) {
            Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_func;
    private javax.swing.JTextField tf_nomePesq;
    // End of variables declaration//GEN-END:variables
}
