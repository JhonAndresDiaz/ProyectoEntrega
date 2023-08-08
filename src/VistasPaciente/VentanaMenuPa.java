
package VistasPaciente;

import Modelos.Paciente;
import Vistas.VentanaLogin;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author diazje
 */
public class VentanaMenuPa extends javax.swing.JFrame {
    
    int xMouse, yMouse;
    private Paciente paciente;

    /**
     * Creates new form VentanaMenu
     */
    public VentanaMenuPa(Paciente paciente) {
        initComponents();
        this.paciente = paciente;
        txtNombreMostrar.setText(paciente.getNombres() + " " + paciente.getApellidos());
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnEditarInfo = new javax.swing.JButton();
        btnCrearPQRS = new javax.swing.JButton();
        btnAgendarCita = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        salir = new javax.swing.JPanel();
        lblSalir = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreMostrar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        barraLateral = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        lblCerrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu Paciente");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEditarInfo.setBackground(new java.awt.Color(103, 160, 174));
        btnEditarInfo.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        btnEditarInfo.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarInfo.setText("Editar  mi información");
        btnEditarInfo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEditarInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditarInfoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditarInfoMouseExited(evt);
            }
        });
        btnEditarInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarInfoActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditarInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 560, 170, 45));

        btnCrearPQRS.setBackground(new java.awt.Color(103, 160, 174));
        btnCrearPQRS.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        btnCrearPQRS.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearPQRS.setText("Crear PQRS");
        btnCrearPQRS.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrearPQRS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCrearPQRS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrearPQRSMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrearPQRSMouseExited(evt);
            }
        });
        btnCrearPQRS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearPQRSActionPerformed(evt);
            }
        });
        jPanel2.add(btnCrearPQRS, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 560, 170, 45));

        btnAgendarCita.setBackground(new java.awt.Color(103, 160, 174));
        btnAgendarCita.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        btnAgendarCita.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendarCita.setText("Agendar cita");
        btnAgendarCita.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgendarCita.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgendarCita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgendarCitaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgendarCitaMouseExited(evt);
            }
        });
        btnAgendarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarCitaActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgendarCita, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 170, 45));

        btnHistorial.setBackground(new java.awt.Color(103, 160, 174));
        btnHistorial.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
        btnHistorial.setForeground(new java.awt.Color(255, 255, 255));
        btnHistorial.setText("Historial medico");
        btnHistorial.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHistorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHistorial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHistorialMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHistorialMouseExited(evt);
            }
        });
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });
        jPanel2.add(btnHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 170, 45));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agendarCitas__3_-removebg-preview.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 190, 151));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/png-transparent-medical-logo-med-removebg-preview.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 179, 142));

        jLabel6.setFont(new java.awt.Font("Roboto Black", 0, 35)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(103, 160, 174));
        jLabel6.setText("Menú Principal");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editarin (1).png"))); // NOI18N
        jLabel7.setText("jLabel7");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, 130, 130));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PQRS (1) (1).png"))); // NOI18N
        jLabel8.setText("jLabel7");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 100, 130));

        jPanel3.setBackground(new java.awt.Color(103, 160, 174));

        salir.setBackground(new java.awt.Color(103, 160, 174));

        lblSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrarsesion (2).png"))); // NOI18N
        lblSalir.setText("jLabel11");
        lblSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSalirMouseExited(evt);
            }
        });

        javax.swing.GroupLayout salirLayout = new javax.swing.GroupLayout(salir);
        salir.setLayout(salirLayout);
        salirLayout.setHorizontalGroup(
            salirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, salirLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        salirLayout.setVerticalGroup(
            salirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, salirLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblSalir))
        );

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Rol: Paciente");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 659, Short.MAX_VALUE)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 810, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(103, 160, 174));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Bienvenido");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 180, -1));

        txtNombreMostrar.setEditable(false);
        txtNombreMostrar.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        txtNombreMostrar.setForeground(new java.awt.Color(103, 160, 174));
        txtNombreMostrar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreMostrar.setBorder(null);
        jPanel2.add(txtNombreMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 180, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo280_1.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 280, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 810, 710));

        barraLateral.setBackground(new java.awt.Color(103, 160, 174));
        barraLateral.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barraLateralMouseDragged(evt);
            }
        });
        barraLateral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barraLateralMousePressed(evt);
            }
        });

        exitBtn.setBackground(new java.awt.Color(103, 160, 174));

        lblCerrar.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        lblCerrar.setForeground(new java.awt.Color(0, 0, 0));
        lblCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8-cerrar-ventana-40.png"))); // NOI18N
        lblCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblCerrarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitBtnLayout = new javax.swing.GroupLayout(exitBtn);
        exitBtn.setLayout(exitBtnLayout);
        exitBtnLayout.setHorizontalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblCerrar))
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exitBtnLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblCerrar))
        );

        javax.swing.GroupLayout barraLateralLayout = new javax.swing.GroupLayout(barraLateral);
        barraLateral.setLayout(barraLateralLayout);
        barraLateralLayout.setHorizontalGroup(
            barraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barraLateralLayout.createSequentialGroup()
                .addContainerGap(770, Short.MAX_VALUE)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        barraLateralLayout.setVerticalGroup(
            barraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, barraLateralLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jPanel1.add(barraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblCerrarMouseClicked

    private void lblCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseEntered
        exitBtn.setBackground(Color.red);
        lblCerrar.setForeground(Color.white);
    }//GEN-LAST:event_lblCerrarMouseEntered

    private void lblCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCerrarMouseExited
        exitBtn.setBackground(new Color(103, 160,174));
        lblCerrar.setForeground(Color.black);
    }//GEN-LAST:event_lblCerrarMouseExited

    private void barraLateralMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraLateralMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_barraLateralMouseDragged

    private void barraLateralMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barraLateralMousePressed
        xMouse = evt.getX();
        yMouse= evt.getY();
    }//GEN-LAST:event_barraLateralMousePressed

    private void btnEditarInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarInfoActionPerformed
        this.dispose();
        JFrame v2 = new VentanaEditarInformacion(paciente);
        v2.setVisible(true);
    }//GEN-LAST:event_btnEditarInfoActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        this.dispose();
        JFrame v2 = new VentanaHistorialMedico(paciente);
        v2.setVisible(true);
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnAgendarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarCitaActionPerformed
        this.dispose();
        JFrame v2 = new VentanaAgendarCita(paciente);
        v2.setVisible(true);
    }//GEN-LAST:event_btnAgendarCitaActionPerformed

    private void btnCrearPQRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearPQRSActionPerformed
        this.dispose();
        JFrame v2 = new VentanaCrearPeticion(paciente);
        v2.setVisible(true);
    }//GEN-LAST:event_btnCrearPQRSActionPerformed

    private void lblSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseClicked
        this.dispose();
        JFrame v2 = new VentanaLogin();
        v2.setVisible(true);
    }//GEN-LAST:event_lblSalirMouseClicked

    private void lblSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseEntered
        salir.setBackground(Color.red);
        lblSalir.setForeground(Color.white);
    }//GEN-LAST:event_lblSalirMouseEntered

    private void lblSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSalirMouseExited
        salir.setBackground(new Color(103, 160,174));
        lblSalir.setForeground(Color.black);
    }//GEN-LAST:event_lblSalirMouseExited

    private void btnAgendarCitaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendarCitaMouseEntered
        btnAgendarCita.setBackground(new Color(131, 176, 188));
    }//GEN-LAST:event_btnAgendarCitaMouseEntered

    private void btnHistorialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistorialMouseEntered
        btnHistorial.setBackground(new Color(131, 176, 188));
    }//GEN-LAST:event_btnHistorialMouseEntered

    private void btnCrearPQRSMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearPQRSMouseEntered
        btnCrearPQRS.setBackground(new Color(131, 176, 188));
    }//GEN-LAST:event_btnCrearPQRSMouseEntered

    private void btnEditarInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarInfoMouseEntered
        btnEditarInfo.setBackground(new Color(131, 176, 188));
    }//GEN-LAST:event_btnEditarInfoMouseEntered

    private void btnAgendarCitaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendarCitaMouseExited
        btnAgendarCita.setBackground(new Color(103, 160, 174));
    }//GEN-LAST:event_btnAgendarCitaMouseExited

    private void btnHistorialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistorialMouseExited
        btnHistorial.setBackground(new Color(103, 160, 174));
    }//GEN-LAST:event_btnHistorialMouseExited

    private void btnCrearPQRSMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearPQRSMouseExited
        btnCrearPQRS.setBackground(new Color(103, 160, 174));
    }//GEN-LAST:event_btnCrearPQRSMouseExited

    private void btnEditarInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarInfoMouseExited
        btnEditarInfo.setBackground(new Color(103, 160, 174));
    }//GEN-LAST:event_btnEditarInfoMouseExited

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
            java.util.logging.Logger.getLogger(VentanaMenuPa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMenuPa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMenuPa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMenuPa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barraLateral;
    private javax.swing.JButton btnAgendarCita;
    private javax.swing.JButton btnCrearPQRS;
    private javax.swing.JButton btnEditarInfo;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JPanel salir;
    private javax.swing.JTextField txtNombreMostrar;
    // End of variables declaration//GEN-END:variables
}
