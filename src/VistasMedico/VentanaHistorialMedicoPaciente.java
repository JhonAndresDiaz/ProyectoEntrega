
package VistasMedico;

import Controladores.ControladorHistorialMedicoPaciente;
import Modelos.Consulta;
import Modelos.Medico;
import Modelos.Paciente;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

//AGREGAR EN LA TABLA MOTIVO Y NOMBRE DEL MEDICO QUE ATENDIÓ

/**
 *
 * @author diazje
 */
public class VentanaHistorialMedicoPaciente extends javax.swing.JFrame {

    int xMouse, yMouse;
    private Consulta consulta;
    private Medico medico;
    DefaultTableModel modelo;
    private ControladorHistorialMedicoPaciente controladorHistorial;

    public VentanaHistorialMedicoPaciente(Medico medico, Consulta consulta) {
        initComponents();
        this.consulta = consulta;
        this.medico = medico;
        this.controladorHistorial = new ControladorHistorialMedicoPaciente();
        modelo = (DefaultTableModel) tablaHistorial.getModel();
        txtNombresss.setText(consulta.getPaciente().getNombres() + " " + consulta.getPaciente().getApellidos());
        actualizarTablaFecha();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        barraLateral = new javax.swing.JPanel();
        exitBtn = new javax.swing.JPanel();
        lblCerrar = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHistorial = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtNombresss = new javax.swing.JTextField();
        btnVolver2 = new javax.swing.JPanel();
        lblRegresar2 = new javax.swing.JPanel();
        lblVolver2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                .addContainerGap(840, Short.MAX_VALUE)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        barraLateralLayout.setVerticalGroup(
            barraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraLateralLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(barraLateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, -1));

        tablaHistorial.setBackground(new java.awt.Color(255, 255, 255));
        tablaHistorial.setForeground(new java.awt.Color(103, 160, 174));
        tablaHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Medico", "Paciente", "Motivo", "Valoración", "Notas", "Diagnóstico"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaHistorial.setSelectionBackground(new java.awt.Color(103, 160, 174));
        tablaHistorial.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tablaHistorial);
        if (tablaHistorial.getColumnModel().getColumnCount() > 0) {
            tablaHistorial.getColumnModel().getColumn(0).setResizable(false);
            tablaHistorial.getColumnModel().getColumn(1).setResizable(false);
            tablaHistorial.getColumnModel().getColumn(2).setResizable(false);
            tablaHistorial.getColumnModel().getColumn(3).setResizable(false);
            tablaHistorial.getColumnModel().getColumn(4).setResizable(false);
            tablaHistorial.getColumnModel().getColumn(5).setResizable(false);
            tablaHistorial.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 850, 236));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(103, 160, 174));
        jLabel3.setText("Historial del paciente:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        txtNombresss.setEditable(false);
        txtNombresss.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        txtNombresss.setForeground(new java.awt.Color(103, 160, 174));
        txtNombresss.setBorder(null);
        jPanel1.add(txtNombresss, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 231, -1));

        btnVolver2.setBackground(new java.awt.Color(103, 160, 174));

        lblRegresar2.setBackground(new java.awt.Color(103, 160, 174));

        lblVolver2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Regresar.png"))); // NOI18N
        lblVolver2.setText("jLabel1");
        lblVolver2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVolver2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVolver2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblVolver2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblVolver2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout lblRegresar2Layout = new javax.swing.GroupLayout(lblRegresar2);
        lblRegresar2.setLayout(lblRegresar2Layout);
        lblRegresar2Layout.setHorizontalGroup(
            lblRegresar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblRegresar2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblVolver2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        lblRegresar2Layout.setVerticalGroup(
            lblRegresar2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lblRegresar2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblVolver2))
        );

        javax.swing.GroupLayout btnVolver2Layout = new javax.swing.GroupLayout(btnVolver2);
        btnVolver2.setLayout(btnVolver2Layout);
        btnVolver2Layout.setHorizontalGroup(
            btnVolver2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnVolver2Layout.createSequentialGroup()
                .addComponent(lblRegresar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnVolver2Layout.setVerticalGroup(
            btnVolver2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnVolver2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblRegresar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(btnVolver2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 880, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo280_1.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 260, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void lblVolver2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVolver2MouseClicked
        this.dispose();
        JFrame v2 = new VentanaGestionCita(medico);
        v2.setVisible(true);
    }//GEN-LAST:event_lblVolver2MouseClicked

    private void lblVolver2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVolver2MouseEntered
        lblRegresar2.setBackground(Color.red);
        lblVolver2.setForeground(Color.white);
    }//GEN-LAST:event_lblVolver2MouseEntered

    private void lblVolver2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVolver2MouseExited
        lblRegresar2.setBackground(new Color(103, 160,174));
        lblVolver2.setForeground(Color.black);
    }//GEN-LAST:event_lblVolver2MouseExited

    public void actualizarTablaFecha(){
        
        ArrayList<Consulta> consultas = controladorHistorial.conseguirConsultas(consulta.getPaciente());
        
        try{
            for (int i = 0; i < 3 ; i++) {
                for (int j = 0; j < modelo.getRowCount(); j++) {
                    modelo.removeRow(j);
                }
            }
        }catch(NullPointerException e){
        }
            try{
                for (int i = 0; i < consultas.size() ; i++) {                    
                      Consulta aux = consultas.get(i);
                      Object[] ob = {aux.getFechaAtencion(), aux.getMedico().getNombres() + " " + aux.getMedico().getApellidos(), aux.getPaciente().getNombres() + " " + aux.getPaciente().getApellidos(), aux.getMotivo(), aux.getValoracion(), aux.getNotas(), aux.getDiagnostico()};
                      modelo.addRow(ob);                     
                }
            }catch(NullPointerException e){        
        } 
    }
    
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
            java.util.logging.Logger.getLogger(VentanaHistorialMedicoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaHistorialMedicoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaHistorialMedicoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaHistorialMedicoPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel barraLateral;
    private javax.swing.JPanel btnVolver2;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JPanel lblRegresar2;
    private javax.swing.JLabel lblVolver2;
    private javax.swing.JTable tablaHistorial;
    private javax.swing.JTextField txtNombresss;
    // End of variables declaration//GEN-END:variables
}
