/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package layarq;

import javax.swing.JFrame;
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
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
    }
} catch (Exception e) {
    // If Nimbus is not available, you can set the GUI to another look and feel.
}
        
      // TODO code application logic here
        MainView tela = new MainView();
        tela.setExtendedState(JFrame.MAXIMIZED_BOTH);
        tela.setVisible(true);
    }
}
