package Model;

import com.florentis.signature.WizCtl;
import javax.swing.JOptionPane;

class WizardUpload {

  private String license;

    public WizardUpload(String license) {
        this.license = license;
    }
  
  
    
  private static void print(String s) {
 	JOptionPane.showMessageDialog(null, s);
  }

  public void UploadBackground(String name){
  try
      {
        String filename = "";
        if(!name.isEmpty()) {
          filename = name;
        }
        WizCtl wizCtl = new WizCtl();
        wizCtl.licence(this.license);
        boolean rc = wizCtl.padConnect();
        if( rc != true ) {
          print("Tablet no conectada por favor conectela");
          System.exit(0);
        }

        if( filename.length() != 0 ) {
          wizCtl.addObject(7, "", "center", "middle", filename, null);
          wizCtl.addObject(8, "", 0, 0, null, null);
        }
        else {
          wizCtl.reset();
        }
        wizCtl.display();
        wizCtl.padDisconnect();
      }
      catch (Exception ex)
      {
        print("Error: " + ex);    
      }
  }
}
