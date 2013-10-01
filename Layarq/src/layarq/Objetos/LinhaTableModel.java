/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package layarq.Objetos;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cristianoliveira
 */
public class LinhaTableModel extends AbstractTableModel{
    private String[] colunas = {"Linhas do Arquivo"};
    private ArrayList<String> dados = new ArrayList<String>();
    boolean hasTipoEsperado;
    int erros = 0;
    
    @Override
    public boolean isCellEditable(int row,
                              int column)
    {
        return true;
    }
    
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
        try {
            String dado = dados.get(pLinha);
            return dado;
        } catch (Exception e) {
            return "";
        }
    }
    
    @Override
    public void setValueAt(Object value, int pLinha, int pColuna) {
        dados.set(pLinha,(String) value);
        fireTableCellUpdated(pLinha, pColuna);
    }
    
    public void setDados(ArrayList<String> pDados)
    {
        dados = pDados;
    }
    
    public boolean hasDados()
    {
        return dados!=null;
    }
}
