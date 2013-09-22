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
     
     public String selecionaArquivo()
     {
         linhas = model.selecionaArquivo();
         return model.getPathArquivoValidar();
     }
     
     public String selecionaLayout()
     {
         layouts = model.selecionaLayout();
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
         return linhas.size();
     }
     
     public String getLinhaSelecionada()
     {
         return linhas.get(linhaSelecionada);
     }
}
