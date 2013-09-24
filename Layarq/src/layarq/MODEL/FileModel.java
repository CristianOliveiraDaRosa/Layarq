/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package layarq.MODEL;

import HELPER.MessageHelper;
import com.sun.xml.internal.ws.api.message.Message;
import java.awt.Component;
import java.io.BufferedReader;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import layarq.Objetos.Layout;
import layarq.Objetos.LayoutTableModel;
/**
 *
 * @author cristian.oliveira
 */
public class FileModel extends Model{
    
    File arquivoLayout;
    File arquivoValidar;
    Layout layout = new Layout();
    
    public ArrayList<String> selecionaArquivo(String pStartPath)
    {
       final JFileChooser fc = new JFileChooser();
       if(pStartPath!=null)
         fc.setSelectedFile(new File(pStartPath));
       int returnVal = fc.showOpenDialog(null);
       if(returnVal==0)
           arquivoValidar = fc.getSelectedFile();
       return getLinhasArquivo(arquivoValidar);
    }
    
    public ArrayList<String> getLinhasArquivo(File pFile)
    {
        ArrayList<String> linhas = new ArrayList<String>();
        if(pFile!=null)
        try {
            BufferedReader br;
            br = new BufferedReader(new FileReader(arquivoValidar));
            String linha = "";
            while ((linha = br.readLine())!= null) {                
                linhas.add(linha);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Arquivo inválido");
        }
        return linhas;
    }
    
    public ArrayList<Layout> selecionaLayout(String pStartPath)
    {
        ArrayList<Layout> list = null;
        
       final JFileChooser fc = new JFileChooser();
       if(pStartPath!=null)
           fc.setSelectedFile(new File(pStartPath));
       int returnVal = fc.showOpenDialog(null);
        
        if (returnVal==0)
        {
            arquivoLayout = fc.getSelectedFile();
            list = geraLayoutsFromFile(arquivoLayout);
        }
        
        return list;
    }
    
    public ArrayList<Layout> geraLayoutsFromFile(File file)
    {
        ArrayList<Layout> list = new ArrayList<Layout>();
        try {
            BufferedReader br;
            br = new BufferedReader(new FileReader(arquivoLayout));
            String linha;
            while ((linha = br.readLine())!= null) {                
                if(!linha.isEmpty())
                {
                   Layout l = getLayoutFromLinha(linha);
                   if(l!=null)
                    list.add(l);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Arquivo inválido");
        }
        
        return list;
    }
    
    public Layout getLayoutFromLinha(String pLinha)
    {   
        Layout layout = new Layout();
        if(!pLinha.isEmpty())
        try {
            String[] dados = pLinha.split(";");
            
            layout.descricao      = dados[0];
            layout.posicaoInicial = Integer.parseInt(dados[1]);
            layout.posicaoFinal   = Integer.parseInt(dados[2]);
            
        } catch (Exception e) {
            return null;
        }
        
        return layout;
    }
    
    public LayoutTableModel getLayoutTableModel(ArrayList<Layout> pLayouts)
    {
         LayoutTableModel ltm = new LayoutTableModel();
         ltm.setLayouts(pLayouts);
         
         return ltm;
    }
    
    public String getPathArquivoLayout()
    {
        return arquivoLayout!=null?
                arquivoLayout.getAbsolutePath() : null;
    }
    
    public String getPathArquivoValidar()
    {
        return arquivoValidar!=null? 
                arquivoValidar.getAbsolutePath() : null;
    }
}
