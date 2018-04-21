package Forms;

import DAO.AdvertenciaDAO;
import Entidades.Advertencias;
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

public class AdvertenciaForm extends javax.swing.JFrame {

    private String pesq;
    private String ant = "";
    private List<Advertencias> minhaList = new ArrayList<Advertencias>();

    public AdvertenciaForm() throws ParseException, IOException {
        initComponents();
        preencherTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_func_adv = new javax.swing.JTable();
        tf_pesq = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jb_info = new javax.swing.JButton();
        jb_addadv = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tb_func_adv.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_func_adv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_func_advKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tb_func_adv);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        jb_info.setText("Informações [F2]");
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

        jb_addadv.setText("Adicionar Advertência [F1]");
        jb_addadv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_addadvActionPerformed(evt);
            }
        });
        jb_addadv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_addadvKeyPressed(evt);
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
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_pesq, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jb_info, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                        .addGap(87, 87, 87)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jb_addadv, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                        .addGap(60, 60, 60)))
                .addGap(31, 31, 31))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_pesq, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jb_info, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb_addadv, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(747, 509));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_addadvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_addadvActionPerformed
        try {
            // TODO add your handling code here:
            new SelecionarFuncAdvtForm().show();
        } catch (IOException ex) {
            Logger.getLogger(AdvertenciaForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_jb_addadvActionPerformed

    private void jb_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_infoActionPerformed
        // TODO add your handling code here:
        Advertencias adv = new Advertencias();
        if (tb_func_adv.getSelectedRow() != -1) {

            adv = (Advertencias) minhaList.get(tb_func_adv.getSelectedRow());

            InformacoesAdvForm dialog = new InformacoesAdvForm(this, true, adv, this);
            dialog.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jb_infoActionPerformed

    private void tf_pesqKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_pesqKeyReleased

        if (tf_pesq.getText().equals("")) {
            try {
                preencherTabela();
            } catch (ParseException ex) {
                System.out.println(ex);
            } catch (IOException ex) {
                Logger.getLogger(AdvertenciaForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            List<Advertencias> filterList = new LinkedList<Advertencias>();
            for (Advertencias advertencias : minhaList) {
                if (advertencias.getFuncionario().getNome().contains(tf_pesq.getText().toUpperCase())) {
                    filterList.add(advertencias);
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

    private void tf_pesqKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_pesqKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_F1) {

            jb_addadvActionPerformed(null);

        } else if (evt.getKeyCode() == KeyEvent.VK_F2) {
            jb_infoActionPerformed(null);
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            dispose();
        }
    }//GEN-LAST:event_tf_pesqKeyPressed

    private void jb_infoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_infoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_F1) {

            jb_addadvActionPerformed(null);

        } else if (evt.getKeyCode() == KeyEvent.VK_F2) {
            jb_infoActionPerformed(null);
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            dispose();
        }
    }//GEN-LAST:event_jb_infoKeyPressed

    private void jb_addadvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_addadvKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_F1) {

            jb_addadvActionPerformed(null);

        } else if (evt.getKeyCode() == KeyEvent.VK_F2) {
            jb_infoActionPerformed(null);
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            dispose();
        }

    }//GEN-LAST:event_jb_addadvKeyPressed

    private void tb_func_advKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_func_advKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_F1) {

            jb_addadvActionPerformed(null);

        } else if (evt.getKeyCode() == KeyEvent.VK_F2) {
            jb_infoActionPerformed(null);
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            dispose();
        }
    }//GEN-LAST:event_tb_func_advKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Advertencias adv = new Advertencias();
        AdvertenciaDAO dao;
        try {
            dao = new AdvertenciaDAO();
        
        if (tb_func_adv.getSelectedRow() == -1) {
           JOptionPane.showMessageDialog(null, "Selecione um registro", "Erro", JOptionPane.ERROR_MESSAGE);
           return;
       }
        
        
        if (JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir?", "confirmação", 
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        
            try {
                adv =(Advertencias) minhaList.get(tb_func_adv.getSelectedRow());
                dao.excluirAdv(adv);
                tf_pesq.setText("");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro");
            }
        }
         } catch (SQLException ex) {
            Logger.getLogger(FuncionarioForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdvertenciaForm.class.getName()).log(Level.SEVERE, null, ex);
        }                      
        try {
            preencherTabela();
        } catch (ParseException ex) {
            Logger.getLogger(AdvertenciaForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdvertenciaForm.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(AdvertenciaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdvertenciaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdvertenciaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdvertenciaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AdvertenciaForm().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(AdvertenciaForm.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(AdvertenciaForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void preencherTabela() throws ParseException, IOException {
        try {
            AdvertenciaDAO dao = new AdvertenciaDAO();
            minhaList = dao.List();
            MyTableModel mtb = new MyTableModel(Advertencias.class, minhaList, tb_func_adv);
            tb_func_adv.setModel(mtb);
            tb_func_adv.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_func_adv.getColumnModel().getColumn(1).setPreferredWidth(300);

        } catch (SQLException ex) {
            Logger.getLogger(Advertencias.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void preencherTabela(List<Advertencias> lista) throws ParseException {
        try {
            MyTableModel mtb = new MyTableModel(Advertencias.class, lista, tb_func_adv);
            tb_func_adv.setModel(mtb);
            tb_func_adv.getColumnModel().getColumn(0).setPreferredWidth(200);
            tb_func_adv.getColumnModel().getColumn(1).setPreferredWidth(300);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb_addadv;
    private javax.swing.JButton jb_info;
    private javax.swing.JTable tb_func_adv;
    private javax.swing.JTextField tf_pesq;
    // End of variables declaration//GEN-END:variables
}
