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
       private TipoDado tipoEsperado; //Tipo de valor esperado Alpha|Número
       public static enum TipoDado { ALPHA, NUMERO, INDENFIDO }
       
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
       
       public TipoDado getTipo()
       {   
           String valor = getValor();
           if(valor!=null & !valor.isEmpty())
            try 
            { 
               Long.parseLong(valor); 
               return TipoDado.NUMERO;
            } 
            catch(NumberFormatException e) 
            { 
                return TipoDado.ALPHA; 
            }
           return TipoDado.INDENFIDO;
       }
       
       public void setTipoEsperado(String pTipoEsperado)
       {
           if(pTipoEsperado.equals("N"))
               tipoEsperado = TipoDado.NUMERO;
           else if(pTipoEsperado.equals("A"))
               tipoEsperado = TipoDado.ALPHA;
           else
               tipoEsperado = TipoDado.INDENFIDO;
       }
       
       public TipoDado getTipoEsperado()
       {
           if(tipoEsperado==null)
               return TipoDado.INDENFIDO;
           else
               return tipoEsperado;
       }
       
       public String getStrTipoEsperado()
       {
           String strTipoEsperado = "*";
           if(tipoEsperado==null)
               return strTipoEsperado;
           else
               return tipoEsperado==TipoDado.ALPHA? "ALPHA": "NUMERO"; 
       }
       
       public String getErro()
       {
           String valor = getValor();
           TipoDado tipoObtido = getTipo();
           
            if(valor.equals("**FORA DA LINHA**"))
                return "LINHA MENOR";
            else if(getTipoEsperado()!=(TipoDado.INDENFIDO) &
                    getTipoEsperado()!=(tipoObtido))
            {
                if(getTipoEsperado().equals(TipoDado.ALPHA) & tipoObtido.equals(TipoDado.NUMERO))
                   return "ATENCAO";
                else
                   return "TIPO";
            }
            else if( valor.length()>0
                   & !Character.isWhitespace(valor.charAt(valor.length()-1)) //último caracter com valor
                   & Character.isWhitespace(valor.charAt(0)))             //Primeiro Caracter em branco
                return "ALINHAMENTO";
            else 
                return "";
            
       }
       
       public boolean hasErro()
       {
           String valor = getValor();
           TipoDado tipoObtido = getTipo();
           TipoDado tipoEsperado =getTipoEsperado();
           
            if(valor.equals("**FORA DA LINHA**"))
                return true;
            else if(tipoEsperado!=(TipoDado.INDENFIDO) &
                    tipoEsperado!=(tipoObtido))
            {
                return true;
            }
            else if( valor.length()>0
                   & !Character.isWhitespace(valor.charAt(valor.length()-1)) //último caracter com valor
                   & Character.isWhitespace(valor.charAt(0)))             //Primeiro Caracter em branco
                return true;
            else 
                return false;
       }
      
}
 

