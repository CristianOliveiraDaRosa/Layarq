/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package layarq;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import layarq.VIEW.MainView;

/**
 *
 * @author cristian.oliveira
 */
public class Layarq {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try {
            // Set cross-platform Java L&F (also called "Metal")
             UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
    } 
    catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
    catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
       // handle exception
    }
        // TODO code application logic here
        new MainView().setVisible(true);
    }
}
