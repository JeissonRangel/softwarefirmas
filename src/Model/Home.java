package Model;

import View.View;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPSClient;

/**
 *
 * @author Jeisson
 */
public class Home {

    private CaptureImage capture;
    private WizardUpload uploader;
    private PreferencesUtility customs;
    private String server, port, user, password, license, connection, serial, background;
    private View jf;
    private FTPSClient ftp;
    
    public Home(View jf) {
        System.setProperty("jdk.tls.useExtendedMasterSecret", "false");
        this.jf = jf;
        this.customs = new PreferencesUtility();
        this.license=customs.loadPreference("LICENSE");
        this.server=customs.loadPreference("SERVER");
        this.port=customs.loadPreference("PORT");
        this.user=customs.loadPreference("USER");
        this.password=customs.loadPreference("PASSWORD");
        this.connection=customs.loadPreference("CONNECTION");
        this.serial=customs.loadPreference("SERIAL");
        this.background=customs.loadPreference("BACKGROUND");
        updateBackground(this.background);
        if (this.license.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Licensia de SDK no encontrada por favor registre una licencia en el panel de opciones");
        }
    }
    
    public void resetPreferences(){
        try {
            this.customs.resetPreferences();
        } catch (BackingStoreException ex) {
            JOptionPane.showMessageDialog(null, "Error: 001");
        }
    }
    
    public void updateBackground(String path){
        this.uploader = new WizardUpload(this.license);
        this.uploader.UploadBackground(path);
    }
    
    private Boolean validateFile(String name){
        try {
            FTPFile remoteFiles = ftp.mlistFile(name+".jpg");
            if (remoteFiles != null) {
                return true;
            }else{
                return false;
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error: "+ex);
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    private int connectFTP(String server, int port, String user, String password){
        this.ftp = new PatchedFTPSClient();
        try {
            this.ftp.connect(server,port);
            this.ftp.enterLocalPassiveMode();
            if (this.ftp.login(user, password)) {
                this.ftp.execPBSZ(0);
                this.ftp.execPROT("P");
                return 2;
            }else{
            return 1;
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    private Boolean sendToFTP(String name,byte[] img){
        this.ftp = new PatchedFTPSClient();
        try {
            int connection = this.connectFTP(this.server, Integer.parseInt(this.port), this.user, this.password);
            switch(connection){
                case 0: JOptionPane.showMessageDialog(null, "Algo malo paso");
                break;
                case 1: JOptionPane.showMessageDialog(null, "No se pudo conectar con el servidor");
                break;
                case 2:{
                    int over=0;
                    if (this.validateFile(name)) {
                        over = JOptionPane.showConfirmDialog(null, "¿Esta firma ya existe desea sobreescribirla?");
                    }
                    if (over==JOptionPane.OK_OPTION) {
                        this.ftp.setFileType(FTP.BINARY_FILE_TYPE);
                        this.ftp.storeFile(name+".jpg", new ByteArrayInputStream(img));
                        this.ftp.disconnect();
                        return true;
                    }else{
                        this.ftp.disconnect();
                        return false;
                    }
                }
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+e);
            return false;
        }
        return false;
    }
    
    private Boolean compareString(String s1, String s2){
        if (s1.equals(s2)) {
            return true;
        }
        return false;
    }
    
    public void Capture(String name, Boolean type){
        this.capture = new CaptureImage(this.license,this.customs,this.jf);
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un numero de orden valido");
            return;
        }
        int serial=0;
        String rname=name;
        String c = this.customs.loadPreference("CONNECTION");
        String s = this.customs.loadPreference("SERIAL");
        Boolean same = compareString(name, s);
        Boolean sb = s.isEmpty();
        if (!sb) {
            serial = Integer.parseInt(s);
        }
        if (type) {
            rname = "s"+name;
        }
        if (c.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese al panel de opciones antes");
        }
        if (c.equals("0")) {
            String path = this.customs.loadPreference("PATH");
            byte[] data = this.capture.CaptureToByte(rname);
            try {
                FileOutputStream fs = new FileOutputStream(path+"/"+rname+".jpg");
                fs.write(data);
                fs.close();
                if (!type && !sb && same) {
                    serial++;
                    this.customs.setPreference("SERIAL", String.valueOf(serial));
                }
                this.jf.setImagePanel(data);
                JOptionPane.showMessageDialog(null, "Firma guardada");
                updateBackground(this.background);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error de directorios");
            }
        }
        if (c.equals("1")) {
            byte[] data = this.capture.CaptureToByte(rname);
            if (data == null) {
                JOptionPane.showMessageDialog(null, "Fallo la captura de la firma");
                return;
            }
            if (!sendToFTP(rname, data)) {
                return;
            }
            if (!type && !sb && same) {
                serial++;
                this.customs.setPreference("SERIAL", String.valueOf(serial));
            }
            this.jf.setImagePanel(data);
            JOptionPane.showMessageDialog(null, "Firma guardada");
            updateBackground(this.background);
        }
    }
    
    public void setPreference(String prefName, String prefValue){
        this.customs.setPreference(prefName, prefValue);
    }
    
    public String getPreference(String prefName){
        return this.customs.loadPreference(prefName);
    }
}
