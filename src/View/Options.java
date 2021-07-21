/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Home;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeisson
 */
public class Options extends javax.swing.JFrame {

    ArrayList<JComponent> FTP;
    ArrayList<JComponent> Local;
    ArrayList<JComponent> Serial;
    private Home main;
    private View jf;

    public Options() {
    }
    
    public Options(Home a, View jf) {
        initComponents();
        this.main = a;
        this.jf=jf;
        this.FTP = new ArrayList<>();
        this.Local = new ArrayList<>();
        this.Serial = new ArrayList<>();
        this.FTP.add(this.txtServer);
        this.FTP.add(this.txtPort);
        this.FTP.add(this.txtUser);
        this.FTP.add(this.txtPassword);
        this.FTP.add(this.lblServerr);
        this.FTP.add(this.lblPort);
        this.FTP.add(this.lblUser);
        this.FTP.add(this.lblPassword);
        this.Local.add(this.txtPath);
        this.Local.add(this.lblPath);
        this.Serial.add(this.txtSerial);
        swapStateFTP(false);
        swapStateLocal(false);
        initUX();
    }
    
    public void initUX(){
        this.txtPath.setText(main.getPreference("PATH"));
        this.txtServer.setText(main.getPreference("SERVER"));
        this.txtPort.setText(main.getPreference("PORT"));
        this.txtUser.setText(main.getPreference("USER"));
        this.txtPassword.setText(main.getPreference("PASSWORD"));
        this.txtLicenseSDK.setText(main.getPreference("LICENSE"));
        this.txtSerial.setText(main.getPreference("SERIAL"));
        
        if (this.main.getPreference("CONNECTION").isEmpty()) {
            swapStateFTP(false);
            swapStateLocal(false);
        }
        if (this.main.getPreference("CONNECTION").equals("1")) {
            swapStateFTP(true);
        }
        if(this.main.getPreference("CONNECTION").equals("0")){
            swapStateLocal(true);
        }
    }
    
    void swapStateLocal(Boolean state){
        this.radioLocal.setSelected(state);
        for (JComponent a : Local) {
            a.setEnabled(state);
        }
    }
    
    void swapStateFTP(Boolean state){
        this.radioFTP.setSelected(state);
        for (JComponent a : FTP) {
            a.setEnabled(state);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitleSettings = new javax.swing.JLabel();
        btnSavePrefs = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        radioLocal = new javax.swing.JRadioButton();
        lblPath = new javax.swing.JLabel();
        txtPath = new javax.swing.JTextField();
        radioFTP = new javax.swing.JRadioButton();
        lblServerr = new javax.swing.JLabel();
        txtServer = new javax.swing.JTextField();
        lblPort = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        lblUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        lblLicSDK = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtLicenseSDK = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        txtSerial = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblTitleSettings.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTitleSettings.setText("Configuracion");

        btnSavePrefs.setText("Guardar");
        btnSavePrefs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSavePrefsActionPerformed(evt);
            }
        });

        radioLocal.setText("Guardar imagen localmente");
        radioLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioLocalActionPerformed(evt);
            }
        });

        lblPath.setText("Ruta:");

        txtPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPathActionPerformed(evt);
            }
        });

        radioFTP.setText("Guardar en servidor FTP");
        radioFTP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioFTPActionPerformed(evt);
            }
        });

        lblServerr.setText("Servidor:");

        lblPort.setText("Puerto:");

        lblUser.setText("Usuario:");

        lblPassword.setText("Contraseña:");

        lblLicSDK.setText("Licencia SDK:");

        txtLicenseSDK.setColumns(20);
        txtLicenseSDK.setLineWrap(true);
        txtLicenseSDK.setRows(5);
        jScrollPane1.setViewportView(txtLicenseSDK);

        jLabel1.setText("Serial:");

        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtSerial, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblServerr)
                                            .addComponent(lblPort))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtPort)
                                            .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblPassword)
                                            .addComponent(lblUser))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                            .addComponent(txtPassword))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addComponent(lblPath)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(radioFTP)
                            .addComponent(radioLocal)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblLicSDK)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioLocal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPath)
                    .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(radioFTP)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblServerr)
                    .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPort)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUser)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLicSDK)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSerial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitleSettings)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(btnSavePrefs)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblTitleSettings)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSavePrefs)
                .addGap(6, 6, 6))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void radioLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioLocalActionPerformed
        swapStateFTP(false);
        swapStateLocal(true);
        this.main.setPreference("CONNECTION", "0");
        
    }//GEN-LAST:event_radioLocalActionPerformed

    private void txtPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPathActionPerformed

    private void btnSavePrefsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSavePrefsActionPerformed
        this.main.setPreference("PATH", this.txtPath.getText());
        this.main.setPreference("SERVER", this.txtServer.getText());
        this.main.setPreference("PORT", this.txtPort.getText());
        this.main.setPreference("USER", this.txtUser.getText());
        this.main.setPreference("PASSWORD", String.valueOf(this.txtPassword.getPassword()));
        this.main.setPreference("LICENSE", this.txtLicenseSDK.getText());
        this.main.setPreference("SERIAL", this.txtSerial.getText());
        if (this.txtSerial.getText().isEmpty()) {
            this.main.setPreference("SERIAL", "");
        }
        jf.validateSerial();
        JOptionPane.showMessageDialog(null, "Configuracion actualizada");
    }//GEN-LAST:event_btnSavePrefsActionPerformed

    private void radioFTPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioFTPActionPerformed
        swapStateLocal(false);
        swapStateFTP(true);
        this.main.setPreference("CONNECTION", "1");
    }//GEN-LAST:event_radioFTPActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Options.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Options().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSavePrefs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblLicSDK;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPath;
    private javax.swing.JLabel lblPort;
    private javax.swing.JLabel lblServerr;
    private javax.swing.JLabel lblTitleSettings;
    private javax.swing.JLabel lblUser;
    private javax.swing.JRadioButton radioFTP;
    private javax.swing.JRadioButton radioLocal;
    private javax.swing.JTextArea txtLicenseSDK;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPath;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtSerial;
    private javax.swing.JTextField txtServer;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
