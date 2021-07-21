package Model;


import View.View;
import com.florentis.signature.SigCtl;
import com.florentis.signature.SigObj;
import com.florentis.signature.DynamicCapture;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;




public class CaptureImage {

    private SigCtl sigCtl = new SigCtl();
    private PreferencesUtility prefs;
    private View jf;
    
    public CaptureImage() {
    }
    
    public CaptureImage(String license, PreferencesUtility prefs, View jf) {
        this.jf=jf;
        this.prefs=prefs;
        sigCtl.licence(license);
    }
    
    private static void printMessage(String s) {
 	JOptionPane.showMessageDialog(null, s);
    }
    
    public void CaptureToFile(String name){
    String path = this.prefs.loadPreference("PATH");
    String filename = path+"/default.png";
    if(!name.isEmpty())
      filename = path+"/"+name+".png";
    try
      {
        DynamicCapture dc = new DynamicCapture();
        int rc = dc.capture(sigCtl, " ", " ", null, null);
        if(rc == 0){
          SigObj sig = sigCtl.signature();
          int flags = SigObj.outputFilename | SigObj.color1BPP | SigObj.backgroundTransparent;
          sig.renderBitmap(filename, 450, 250, "image/jpeg", 0.5f, 0x00000000, 0xffffff, 0.0f, 0.0f, flags );
          printMessage("Firma guardada como: " + filename);
        }
        else {
          switch(rc) {
            case 1:   printMessage("Cancelada");
                      break;
            case 100: printMessage("Tablet no encontrada");
                      break;
            case 103: printMessage("Licensia no valida");
                      break;
          }
        }
      }
      catch (Exception ex)
      {
        printMessage("Error: " + ex);    
      }
    }
    
    public byte[] CaptureToByte(String name){
    String filename = "default.png";
    if(!name.isEmpty())
      filename = name+".png";
    try
      {
        DynamicCapture dc = new DynamicCapture();
        int rc = dc.capture(sigCtl, " ", " ", null, null);
        if(rc == 0) {
          SigObj sig = sigCtl.signature();
          int flags = SigObj.outputBinary | SigObj.color24BPP;
          byte[] data = (byte[]) sig.renderBitmap(null, 450, 250, "image/jpeg", 0.5f, 0x00000000, 0xffffff, 0.0f, 0.0f, flags );
          return data;  
        }
        else {
          switch(rc) {
            case 1:   printMessage("Cancelada");
                      break;
            case 100: printMessage("Tablet no encontrada");
                      break;
            case 103: printMessage("Licensia no valida");
                      break;
          }
        }
      }
      catch (Exception ex)
      {
        printMessage("Error: " + ex);    
      }
    return null;
    }
    
}
