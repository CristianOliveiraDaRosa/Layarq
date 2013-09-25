/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package layarq.Objetos;

/**
 *
 * @author cristian.oliveira (www.cristianoliveira.com.br)
 */
public class Layout {
       public String linha;
       public String descricao;
       public int posicaoInicial;
       public int posicaoFinal;
       public int tamanho;
       private String tipoEsperado; //Tipo de valor esperado Alpha|Número
       
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
       
       public String getTipo()
       {   
           String valor = getValor();
           if(valor.equals("**FORA DA LINHA**"))
           {    
               return "Erro";
           }
           else if(!valor.isEmpty())
            try 
            { 
               Long.parseLong(valor); 
               return "Número";
            } 
            catch(NumberFormatException e) 
            { 
                return "Alpha"; 
            }
           return "";
       }
       
       public void setTipoEsperado(String pTipoEsperado)
       {
           if(pTipoEsperado.equals("N"))
               tipoEsperado = "Número";
           else
               tipoEsperado = "Alpha";
       }
       
       public String getTipoEsperado()
       {
           return tipoEsperado==null? "*": tipoEsperado; 
       }
       
       public String validaTipo()
       {
            if(getValor().equals("**FORA DA LINHA**"))
                return "ERRO";
            else if(tipoEsperado==null)
                return "";
            else
            {
                if(tipoEsperado.equals(getTipo()))
                    return "OK";
                else
                    return "ERRO";
            }
           
       }
}
