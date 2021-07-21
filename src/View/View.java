package View;
import Model.CaptureImage;
import Model.Home;
import Model.PreferencesUtility;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class View extends javax.swing.JFrame {
    
    private Home main;
    final JFileChooser fc;
    
    public View() {
        initComponents();
        this.main = new Home(this);
        this.fc = new JFileChooser();
        validateSerial();
    }
    public void setImagePanel(byte[] imageDate){
        ImageIcon sign = new ImageIcon(imageDate);
        this.lblImage.setIcon(sign);
    }
    public void validateSerial(){
        String a = this.main.getPreference("SERIAL");
        if (a.isEmpty()) {
           this.lblSerial.setText("No");
           this.txtOrdenNumber.setText("");
           return;
        }
        int b = Integer.parseInt(a);
        this.lblSerial.setText(a);
        this.txtOrdenNumber.setText(String.valueOf(b));
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        canvas = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        btnCaptureEntryOrder = new javax.swing.JButton();
        txtOrdenNumber = new javax.swing.JTextField();
        lblOrden = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblSerial = new javax.swing.JLabel();
        btnCaptureExitOrder = new javax.swing.JButton();
        mainMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnCaptureEntry = new javax.swing.JMenuItem();
        btnCaptureExit = new javax.swing.JMenuItem();
        btnFondo = new javax.swing.JMenuItem();
        btnPreferences = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        btnClose = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Firmas");
        setResizable(false);

        lblTitle.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTitle.setText("Firmas Wacom 1.1");

        canvas.setBackground(new java.awt.Color(255, 255, 255));
        canvas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        canvas.setPreferredSize(new java.awt.Dimension(500, 250));

        javax.swing.GroupLayout canvasLayout = new javax.swing.GroupLayout(canvas);
        canvas.setLayout(canvasLayout);
        canvasLayout.setHorizontalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(canvasLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        canvasLayout.setVerticalGroup(
            canvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(canvasLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        btnCaptureEntryOrder.setText("ENTRADA");
        btnCaptureEntryOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaptureEntryOrderActionPerformed(evt);
            }
        });

        lblOrden.setText("NUMERO DE ORDEN:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Consecutivo:");

        lblSerial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSerial.setText("NO");

        btnCaptureExitOrder.setText("SALIDA");
        btnCaptureExitOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaptureExitOrderActionPerformed(evt);
            }
        });

        jMenu1.setText("Menu");

        btnCaptureEntry.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        btnCaptureEntry.setText("Capturar Entrada");
        btnCaptureEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaptureEntryActionPerformed(evt);
            }
        });
        jMenu1.add(btnCaptureEntry);

        btnCaptureExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        btnCaptureExit.setText("Capturar Salida");
        btnCaptureExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaptureExitActionPerformed(evt);
            }
        });
        jMenu1.add(btnCaptureExit);

        btnFondo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        btnFondo.setText("Cambiar fondo");
        btnFondo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFondoActionPerformed(evt);
            }
        });
        jMenu1.add(btnFondo);

        btnPreferences.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        btnPreferences.setText("Opciones");
        btnPreferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreferencesActionPerformed(evt);
            }
        });
        jMenu1.add(btnPreferences);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Reiniciar Opciones");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        btnClose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        btnClose.setText("Cerrar");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jMenu1.add(btnClose);

        mainMenu.add(jMenu1);

        setJMenuBar(mainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSerial)
                                .addGap(69, 69, 69))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(lblOrden)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtOrdenNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(canvas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCaptureEntryOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCaptureExitOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(jLabel1)
                    .addComponent(lblSerial))
                .addGap(18, 18, 18)
                .addComponent(canvas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOrdenNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrden))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCaptureEntryOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCaptureExitOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPreferencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreferencesActionPerformed
        new Options(this.main,this).setVisible(true);
    }//GEN-LAST:event_btnPreferencesActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnCaptureEntryOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaptureEntryOrderActionPerformed
        this.main.Capture(this.txtOrdenNumber.getText(),false);
        validateSerial();
    }//GEN-LAST:event_btnCaptureEntryOrderActionPerformed

    private void btnCaptureExitOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaptureExitOrderActionPerformed
        this.main.Capture(JOptionPane.showInputDialog("Ingrese numero de orden de salida"),true);
        validateSerial();
    }//GEN-LAST:event_btnCaptureExitOrderActionPerformed

    private void btnCaptureEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaptureEntryActionPerformed
        this.main.Capture(this.txtOrdenNumber.getText(), false);
        validateSerial();
    }//GEN-LAST:event_btnCaptureEntryActionPerformed

    private void btnCaptureExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaptureExitActionPerformed
        this.main.Capture(JOptionPane.showInputDialog("Ingrese orden de salida"),true);
        validateSerial();
    }//GEN-LAST:event_btnCaptureExitActionPerformed

    private void btnFondoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFondoActionPerformed
        this.fc.showOpenDialog(null);
        String path = this.fc.getSelectedFile().getAbsolutePath();
        this.main.setPreference("BACKGROUND",path);
        this.main.updateBackground(path);
        
    }//GEN-LAST:event_btnFondoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public static void main(String args[]) {
        System.out.println(System.getProperty("java.library.path"));
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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new View().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnCaptureEntry;
    private javax.swing.JButton btnCaptureEntryOrder;
    private javax.swing.JMenuItem btnCaptureExit;
    private javax.swing.JButton btnCaptureExitOrder;
    private javax.swing.JMenuItem btnClose;
    private javax.swing.JMenuItem btnFondo;
    private javax.swing.JMenuItem btnPreferences;
    private javax.swing.JPanel canvas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblOrden;
    private javax.swing.JLabel lblSerial;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JTextField txtOrdenNumber;
    // End of variables declaration//GEN-END:variables
}
