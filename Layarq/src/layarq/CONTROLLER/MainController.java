/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package layarq.CONTROLLER;
import java.util.ArrayList;
import layarq.MODEL.FileModel;
import layarq.Objetos.Layout;
import layarq.Objetos.LayoutTableModel;
import layarq.Objetos.LinhaTableModel;

/**
 *
 * @author cristian.oliveira (www.cristianoliveira.com.br)
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
         try{
            if(linhas.size()>0)
            {
                for (int i = 0; i < layouts.size(); i++) {
                    layouts.get(i).linha = linhas.get(linhaSelecionada);
                }
            }
         }catch(ArrayIndexOutOfBoundsException ie)
         {}
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
         if(linhaSelecionada>=0)
          return hasLinhas()? linhas.get(linhaSelecionada) : "";
         else
          return "";
     }
     
     public boolean hasLinhas()
     {
         return linhas!=null & linhas.size()>0;
     }
     
     public boolean hasLayout()
     {
         return layouts!=null & layouts.size()>0;
     }
     
     public LinhaTableModel getLinhaTableModel()
     {
         return model.getLinhaTableModel(linhas);
     }
     
     public int getLinhaDePosicao(int pPosicao)
     {
         try {
          for (int i = 0; i < layouts.size(); i++) {
             try {
                Layout lin = layouts.get(i);
                 System.err.println(lin.posicaoInicial+" <= "+pPosicao+" & "+pPosicao+" <= "+lin.posicaoFinal);
                if(lin.posicaoInicial <= pPosicao & pPosicao <= lin.posicaoFinal)
                    return i;
             } catch (Exception e) {
             } 
         }   
         } catch (NullPointerException e) {
         }
         return 0;
     }
}
