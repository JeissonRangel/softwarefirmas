package Model;

import java.io.File;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

/**
 *
 * @author Jeisson
 * This class is an util for saving user preferences on the local system choosen by the API
 * more datails about where this preferences are saved can be found on the Java Doc.
 */

public class PreferencesUtility {

    private Preferences prefs;
    
    public PreferencesUtility(){
        
        prefs = Preferences.userNodeForPackage(this.getClass());
        /*Using Preferences API for saving the preferences*/
        
    }
    public void setPreference(String prefName, String prefValue){
        /*This method sets the preference with the name and value given by the parameters*/
        prefs.put(prefName, prefValue);
    }
    
    public String loadPreference(String prefName){
        /*This method returns on String the value from the given name on the prefName paramenter*/
        /*In cae there is not such preference it returns null*/
        return prefs.get(prefName, "");
    }

    public void resetPreferences() throws BackingStoreException{
        /*This method deletes all the preferences for the node of this class*/
        prefs.flush();
    }
    
}
