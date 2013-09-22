/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package layarq.Objetos;

import HELPER.MessageHelper;
import com.sun.xml.internal.ws.api.message.Message;
import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;

/**
 *
 * @author cristian.oliveira
 */
public class Layout {
       public String linha;
       public String descricao;
       public int posicaoInicial;
       public int posicaoFinal;
       public int tamanho;
       
       public String getValor()
       {
           tamanho = (posicaoFinal-posicaoInicial)+1;
           int ini = posicaoInicial-1;
           
           String lin = "";
           try
           {
              if(linha==null || linha.isEmpty())
                 lin = "0";
              else 
              {   
                  lin = linha.substring(ini, posicaoFinal);
                  
              }
           }
           catch(StringIndexOutOfBoundsException e)
           {
              lin = "**FORA DA LINHA**";
           }
           return lin;
       }
}
