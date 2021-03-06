/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Forms;

import DAO.AtestadoDAO;
import DAO.FeriasDAO;
import DAO.FuncionarioDAO;
import Entidades.Advertencias;
import Entidades.Atestados;
import Entidades.Ferias;
import Entidades.Funcionario;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Airton Robson
 */
public class AtestadoForm extends javax.swing.JFrame {

    /**
     * Creates new form AtestadoForm
     */
    List<Atestados> minhaList = new ArrayList<Atestados>();
    public AtestadoForm() throws ParseException, IOException {
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

        tf_pesq = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_func_atest = new javax.swing.JTable();
        jb_info = new javax.swing.JButton();
        jb_addatest = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(711, 491));
        setResizable(false);

        tf_pesq.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tf_pesq.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tf_pesqKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_pesqKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Nome:");

        tb_func_atest.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tb_func_atest);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jb_info.setText("Informações");
        jb_info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_infoActionPerformed(evt);
            }
        });
        jb_info.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_infoKeyPressed(evt);
            }
        });

        jb_addatest.setText("Adicionar Atestado ");
        jb_addatest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_addatestActionPerformed(evt);
            }
        });
        jb_addatest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_addatestKeyPressed(evt);
            }
        });

        jButton1.setText("Excluir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tf_pesq, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jb_info, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(jb_addatest, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_pesq, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jb_addatest, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                        .addComponent(jb_info, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(728, 509));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_addatestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_addatestActionPerformed
        try {
            // TODO add your handling code here:
            new SelecionarFuncAtestForm().show();
        } catch (IOException ex) {
            Logger.getLogger(AtestadoForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_jb_addatestActionPerformed

    private void jb_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_infoActionPerformed
        // TODO add your handling code here:
        Atestados atest = new Atestados();
        if (tb_func_atest.getSelectedRow() != -1) {
            
          atest = (Atestados) minhaList.get(tb_func_atest.getSelectedRow()); 
          
          InformacoesAtestForm dialog = new InformacoesAtestForm(this, true, atest, this);            
          dialog.setVisible(true);
          dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jb_infoActionPerformed

    private void jb_addatestKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_addatestKeyPressed
        // TODO add your handling code here:
         if (evt.getKeyCode() == KeyEvent.VK_F1) {
            
             jb_addatestActionPerformed(null);
            
        }
        else if(evt.getKeyCode() == KeyEvent.VK_F2){
            jb_infoActionPerformed(null);
        }
         else if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            dispose();
        }
    }//GEN-LAST:event_jb_addatestKeyPressed

    private void tf_pesqKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_pesqKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            
             jb_addatestActionPerformed(null);
            
        }
        else if(evt.getKeyCode() == KeyEvent.VK_F2){
            jb_infoActionPerformed(null);
        }
        else if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            dispose();
        }
    }//GEN-LAST:event_tf_pesqKeyPressed

    private void jb_infoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_infoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_F1) {
            
             jb_addatestActionPerformed(null);
            
        }
        else if(evt.getKeyCode() == KeyEvent.VK_F2){
            jb_infoActionPerformed(null);
        }
        else if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            dispose();
        }
    }//GEN-LAST:event_jb_infoKeyPressed

    private void tf_pesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_pesqKeyReleased
        // TODO add your handling code here:
        if (tf_pesq.getText().equals("")) {
            try {
                preencherTabela();
            } catch (ParseException ex) {
                System.out.println(ex);
            } catch (IOException ex) {
                Logger.getLogger(AtestadoForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            List<Atestados> filterList = new LinkedList<Atestados>();
            for (Atestados atestados : minhaList) {
                if (atestados.getFuncionario().getNome().contains(tf_pesq.getText().toUpperCase())) {
                    filterList.add(atestados);
                }
                
                try {
                    minhaList = filterList;
                    preencherTabela(minhaList);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro" + ex);
                }
            }
        }
    }//GEN-LAST:event_tf_pesqKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Atestados atest = new Atestados();
        AtestadoDAO dao;
        try {
            dao = new AtestadoDAO();
        
        if (tb_func_atest.getSelectedRow() == -1) {
           JOptionPane.showMessageDialog(null, "Selecione um registro", "Erro", JOptionPane.ERROR_MESSAGE);
           return;
       }
        
        
        if (JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir?", "confirmação", 
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        
            try {
                atest =(Atestados) minhaList.get(tb_func_atest.getSelectedRow());
                dao.excluirAtest(atest);
                tf_pesq.setText("");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro");
            }
        }
         } catch (SQLException ex) {
            Logger.getLogger(FuncionarioForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AtestadoForm.class.getName()).log(Level.SEVERE, null, ex);
        }                      
        try {
            preencherTabela();
        } catch (ParseException ex) {
            Logger.getLogger(AdvertenciaForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AtestadoForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AtestadoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtestadoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtestadoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtestadoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AtestadoForm().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(AtestadoForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(AtestadoForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
     public void preencherTabela() throws ParseException, IOException {
        try {
            AtestadoDAO dao = new AtestadoDAO();
            minhaList = dao.List();
            MyTableModel mtb = new MyTableModel(Atestados.class, minhaList, tb_func_atest);
            tb_func_atest.setModel(mtb);
            tb_func_atest.getColumnModel().getColumn(0).setPreferredWidth(300);
            tb_func_atest.getColumnModel().getColumn(1).setPreferredWidth(100);
            tb_func_atest.getColumnModel().getColumn(2).setPreferredWidth(100);
        } catch (SQLException ex) {
            Logger.getLogger(Atestados.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
     
     public void preencherTabela(List<Atestados> lista) throws ParseException {
        try {
            MyTableModel mtb = new MyTableModel(Atestados.class, lista, tb_func_atest);
            tb_func_atest.setModel(mtb);
            tb_func_atest.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_func_atest.getColumnModel().getColumn(1).setPreferredWidth(300);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_addatest;
    private javax.swing.JButton jb_info;
    private javax.swing.JTable tb_func_atest;
    private javax.swing.JTextField tf_pesq;
    // End of variables declaration//GEN-END:variables
}
