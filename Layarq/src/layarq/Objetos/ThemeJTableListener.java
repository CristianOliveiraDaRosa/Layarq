package layarq.Objetos;  
  
import java.awt.Color;  
import java.awt.Component;  
import java.awt.Font;  
  
import javax.swing.JTable;  
import javax.swing.table.DefaultTableCellRenderer;  
 
//Classe responsável pela lógica dos efeitos visuais da JTABLE
public class ThemeJTableListener   
    extends DefaultTableCellRenderer   
{  
  
    @Override  
    public Component getTableCellRendererComponent(  
        JTable table,  
        Object value,  
        boolean isSelected,  
        boolean hasFocus,  
        int row,  
        int column)  
    {  
        Component result = super.getTableCellRendererComponent(  
            table,  
            value,  
            isSelected,  
            hasFocus,  
            row,  
            column  
        );  
        
        if(value.equals("ERRO")) {
            result.setForeground(Color.red);
        }
        else
        {
            result.setForeground(Color.BLACK);
        }
        return result;  
    }
      
}  