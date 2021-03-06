/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import DAO.AdvertenciaDAO;
import Entidades.Advertencias;
import Entidades.Funcionario;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Airton Robson
 */
public class InformacoesAdvForm extends javax.swing.JFrame {

    /**
     * Creates new form NovaAdvertenciaForm
     */
    private final Advertencias ad1;
    private final AdvertenciaForm adf;

    public InformacoesAdvForm(java.awt.Frame parent, boolean modal, Advertencias adv, AdvertenciaForm select) {
        initComponents();
        definirQuebra();
        this.ad1 = adv;
        this.adf = select;
        carregarCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        ta_desc = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        la_func = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jb_concluir = new javax.swing.JButton();
        jb_cancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ff_data = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        ta_desc.setColumns(20);
        ta_desc.setRows(5);
        ta_desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ta_descKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(ta_desc);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Funcionário:");

        la_func.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Descrição:");

        jb_concluir.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jb_concluir.setText("Concluir");
        jb_concluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_concluirActionPerformed(evt);
            }
        });
        jb_concluir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_concluirKeyPressed(evt);
            }
        });

        jb_cancelar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jb_cancelar.setText("Cancelar");
        jb_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_cancelarActionPerformed(evt);
            }
        });
        jb_cancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jb_cancelarKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Data:");

        try {
            ff_data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ff_data.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ff_dataKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jb_concluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(95, 95, 95)
                .addComponent(jb_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ff_data, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(la_func, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(la_func, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ff_data, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(98, 98, 98)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_concluir, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jb_cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );

        setSize(new java.awt.Dimension(660, 513));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jb_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_cancelarActionPerformed
        try {
            // TODO add your handling code here:
            new AdvertenciaForm().show();
        } catch (ParseException ex) {
            Logger.getLogger(NovaAdvertenciaForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InformacoesAdvForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_jb_cancelarActionPerformed

    private void jb_concluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_concluirActionPerformed
        // TODO add your handling code here:
        ad1.setDescricao(ta_desc.getText());
        ad1.setData(ff_data.getText());
        try {
            AdvertenciaDAO dao = new AdvertenciaDAO();
            dao.alterarAdv(ad1);
            dispose();
            new AdvertenciaForm().show();
        } catch (SQLException ex) {
            Logger.getLogger(NovaAdvertenciaForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(NovaAdvertenciaForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InformacoesAdvForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jb_concluirActionPerformed

    private void ta_descKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ta_descKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_concluirActionPerformed(null);
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            jb_cancelarActionPerformed(null);
        }
    }//GEN-LAST:event_ta_descKeyPressed

    private void ff_dataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ff_dataKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_concluirActionPerformed(null);
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            jb_cancelarActionPerformed(null);
        }
    }//GEN-LAST:event_ff_dataKeyPressed

    private void jb_concluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_concluirKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_concluirActionPerformed(null);
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            jb_cancelarActionPerformed(null);
        }
    }//GEN-LAST:event_jb_concluirKeyPressed

    private void jb_cancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jb_cancelarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jb_concluirActionPerformed(null);
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            jb_cancelarActionPerformed(null);
        }
    }//GEN-LAST:event_jb_cancelarKeyPressed

    public void definirQuebra() {
        ta_desc.setLineWrap(true);
    }

    public void carregarCampos() {
        
        la_func.setText(ad1.getFuncionario().getNome());
        ta_desc.setText(ad1.getDescricao());
        ff_data.setText(ad1.getData());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField ff_data;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jb_cancelar;
    private javax.swing.JButton jb_concluir;
    private javax.swing.JLabel la_func;
    private javax.swing.JTextArea ta_desc;
    // End of variables declaration//GEN-END:variables
}
