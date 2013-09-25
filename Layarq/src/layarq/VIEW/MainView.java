package layarq.VIEW;
import java.awt.Color;
import javax.swing.CellRendererPane;
import layarq.HELPERS.MessageHelper;
import javax.swing.JFrame;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import layarq.Objetos.LayoutTableModel;
import layarq.CONTROLLER.MainController;
import layarq.Objetos.Layout;
import layarq.Objetos.ThemeJTableListener;

/**
 *
 * @author cristian.oliveira (www.cristianoliveira.com.br)
 */
public class MainView extends View {

    MainController controller =  new MainController();
    LayoutTableModel layoutTableModel = new LayoutTableModel();
    /**
     * Creates new form MainView
     */
    public MainView() {
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        
        tblLayouts.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int r = tblLayouts.getSelectedRow();
                if(layoutTableModel!=null)
                try {
                    Layout valor = layoutTableModel.getLinha(r);
                    if(valor!=null
                      & valor.posicaoInicial+valor.posicaoFinal>0)
                    {   
                        txtLinhaSelecionada.requestFocus();
                        txtLinhaSelecionada.setCaretPosition(0);
                        txtLinhaSelecionada.setCaretPosition(valor.posicaoInicial-1);
                        txtLinhaSelecionada.setSelectionStart(valor.posicaoInicial-1);
                        txtLinhaSelecionada.setSelectionEnd(valor.posicaoFinal);
                    }
                } catch (java.lang.IllegalArgumentException i) {
                } catch (java.lang.NullPointerException np) {}
            }

    });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtArquivoLayout = new javax.swing.JTextField();
        btnSelecionarLayout = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLayouts = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtArquivoValidar = new javax.swing.JTextField();
        btnSelecionarArquivo = new javax.swing.JButton();
        cbxLinha = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        btnAnalisar = new javax.swing.JButton();
        txtLinhaSelecionada = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lbltamanhoLinha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblTotalLinhas = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblResultado = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Validador de Layout de Arquivo");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Selecione o Arquivo para Analisar");

        btnSelecionarLayout.setText("Selec.");
        btnSelecionarLayout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarLayoutActionPerformed(evt);
            }
        });

        tblLayouts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dados"
            }
        ));
        tblLayouts.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblLayouts);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Selecione o Layout");

        btnSelecionarArquivo.setText("Selec.");
        btnSelecionarArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarArquivoActionPerformed(evt);
            }
        });

        jLabel3.setText("Linha");

        btnAnalisar.setText("Analisar");
        btnAnalisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisarActionPerformed(evt);
            }
        });

        jLabel4.setText("Tamanho da Linha:");

        lbltamanhoLinha.setText("0");

        jLabel5.setText("Total de Linhas");

        lblTotalLinhas.setText("0");

        jLabel6.setText("Analise:");

        lblResultado.setText("(Resultado)");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Validador para Layout de Arquivos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(txtLinhaSelecionada)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAnalisar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbltamanhoLinha)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTotalLinhas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblResultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtArquivoLayout, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtArquivoValidar, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSelecionarArquivo)
                            .addComponent(btnSelecionarLayout)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelecionarArquivo)
                    .addComponent(txtArquivoValidar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelecionarLayout)
                    .addComponent(txtArquivoLayout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnAnalisar)
                    .addComponent(jLabel4)
                    .addComponent(lbltamanhoLinha)
                    .addComponent(jLabel5)
                    .addComponent(lblTotalLinhas)
                    .addComponent(jLabel6)
                    .addComponent(lblResultado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLinhaSelecionada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecionarLayoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarLayoutActionPerformed
        String startPath = txtArquivoLayout.getText();
        txtArquivoLayout.setText(controller.selecionaLayout(startPath));
        setJTable();
    }//GEN-LAST:event_btnSelecionarLayoutActionPerformed

    private void btnSelecionarArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarArquivoActionPerformed
        try 
        {
            String startPath = txtArquivoValidar.getText();
            txtArquivoValidar.setText(controller.selecionaArquivo(startPath));
            if(controller.hasLinhas())
            { 
                cbxLinha.setModel(new SpinnerNumberModel(1, 1, controller.getQuantidadeLinhas(),1));
                lblTotalLinhas.setText(controller.getQuantidadeLinhas()+"");
            }
            
        } catch (IllegalArgumentException e) {}
        
    }//GEN-LAST:event_btnSelecionarArquivoActionPerformed

    private void btnAnalisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisarActionPerformed
        int linha = (Integer)cbxLinha.getValue();
        controller.selecionaLinha(linha-1);
        txtLinhaSelecionada.setText(controller.getLinhaSelecionada());
        lbltamanhoLinha.setText(""+controller.getLinhaSelecionada().length());
        setJTable();
        
        int qtdeErros = layoutTableModel.getQuantidadeErros();
        if(qtdeErros>0)
        {
            lblResultado.setForeground(Color.RED);
            lblResultado.setText(qtdeErros==1? qtdeErros+" erro." : qtdeErros+" erros.");
        }
        else
        {
            lblResultado.setForeground(Color.BLUE);
            lblResultado.setText("Aparentemente sem erros...");
        }
    }//GEN-LAST:event_btnAnalisarActionPerformed
   
    public void setJTable()
    {
        try {
            layoutTableModel = controller.getLayoutTableModel();
            if(layoutTableModel!=null)
            tblLayouts.setModel(layoutTableModel);
            
            for (int i = 0; i < tblLayouts.getColumnCount(); i++) {
                tblLayouts.setDefaultRenderer(tblLayouts.getColumnClass(i), new ThemeJTableListener());
            }
            
        } catch (java.lang.NullPointerException npe) {
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalisar;
    private javax.swing.JButton btnSelecionarArquivo;
    private javax.swing.JButton btnSelecionarLayout;
    private javax.swing.JSpinner cbxLinha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JLabel lblTotalLinhas;
    private javax.swing.JLabel lbltamanhoLinha;
    private javax.swing.JTable tblLayouts;
    private javax.swing.JTextField txtArquivoLayout;
    private javax.swing.JTextField txtArquivoValidar;
    private javax.swing.JTextField txtLinhaSelecionada;
    // End of variables declaration//GEN-END:variables
}
