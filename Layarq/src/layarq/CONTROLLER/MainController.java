/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package layarq.CONTROLLER;
import java.awt.Component;
import java.util.ArrayList;
import layarq.MODEL.FileModel;
import layarq.Objetos.Layout;
import layarq.Objetos.LayoutTableModel;

/**
 *
 * @author cristian.oliveira
 */
public class MainController extends Controller {
    
     FileModel model = new FileModel();
     ArrayList<Layout> layouts = new ArrayList<Layout>();
     ArrayList<String> linhas  = new ArrayList<String>();
     int linhaSelecionada = 0;
     
     public String selecionaArquivo(String pStartPath)
     {
         linhas = model.selecionaArquivo(pStartPath);
         return model.getPathArquivoValidar();
     }
     
     public String selecionaLayout(String pStartPath)
     {
         layouts = model.selecionaLayout(pStartPath);
         return model.getPathArquivoLayout();
     }
     
     public LayoutTableModel getLayoutTableModel()
     {
         if(linhas.size()>0)
         {
             for (int i = 0; i < layouts.size(); i++) {
                 layouts.get(i).linha = linhas.get(linhaSelecionada);
             }
         }
         return model.getLayoutTableModel(layouts);
     }
     
     public void selecionaLinha(int pLinha)
     {
         linhaSelecionada = pLinha;
     }
     
     public int getQuantidadeLinhas()
     {
         return hasLinhas()? linhas.size() : 0;
     }
     
     public String getLinhaSelecionada()
     {
         return hasLinhas()? linhas.get(linhaSelecionada) : "";
     }
     
     public boolean hasLinhas()
     {
         return linhas!=null & linhas.size()>0;
     }
     
     public boolean hasLayout()
     {
         return layouts!=null & layouts.size()>0;
     }
}
