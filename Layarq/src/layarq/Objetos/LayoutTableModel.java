/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package layarq.Objetos;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cristian.oliveira (www.cristianoliveira.com.br)
 */
public class LayoutTableModel extends AbstractTableModel{
    private String[] colunas = {"Descrição","Pos. Ini","Pos Fim","Tipo Esperado","Tamanho","Valor","Tipo Encontrado","Resultado"};
    private ArrayList<Layout> dados  = new ArrayList<Layout>();
    boolean hasTipoEsperado;
    int erros = 0;
    
    @Override
    public int getRowCount() {
        return hasDados()? dados.size() : 0;
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
     
    @Override
    public String getColumnName(int pColuna) {
        return colunas[pColuna];
    }
    
    public void setColumns(String[] pColunas)
    {
        colunas = pColunas;
    }
    
    @Override
    public Object getValueAt(int pLinha, int pColuna) {
        Layout dado = dados.get(pLinha);
        
        switch(pColuna)
        {
            case 0: return dado.descricao;
            case 1: return dado.posicaoInicial;
            case 2: return dado.posicaoFinal;
            case 3: return dado.getStrTipoEsperado();
            case 4: return dado.tamanho;
            case 5: return dado.getValor();
            case 6: return dado.getTipo();
            case 7: return dado.getErro();
                   default: return null;
        }
    }
    
    public Layout getLinha(int pLinha)
    {
        try {
            return hasDados()? dados.get(pLinha) : null;
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }
    
    @Override
    public void setValueAt(Object value, int pLinha, int pColuna) {
        dados.set(pLinha, (Layout) value);
        fireTableCellUpdated(pLinha, pColuna);
    }
    
    public void setLayouts(ArrayList<Layout> pLayouts)
    {
        dados = pLayouts;
    }
    
    public boolean hasDados()
    {
        return dados!=null;
    }
    
    public int getQuantidadeErros()
    {
        erros=0;
        for (int i = 0; i < dados.size(); i++) {
            Layout l = dados.get(i);
            if(l.hasErro())
                erros++;
        }
        return erros;
    }
    
    public boolean hasErros(int pLinha)
    {
        return dados.get(pLinha).hasErro();
    }
    
    public boolean hasErros()
    {
        return erros>0;
    }
    
    public boolean hasTipoEsperado()
    {
        return hasDados()? dados.get(0).getTipoEsperado()!= Layout.TipoDado.INDENFIDO : false;
    }
}
