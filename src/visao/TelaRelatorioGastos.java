package visao;

import controle.ExcelExporter;
import controle.PDFExporter;
import controle.ProprietarioControle;
import controle.RegistraGastoControle;
import controle.TipoGastosControle;
import controle.VeiculoControle;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.GeraRelatorio;
import modelos.IPropietarioCRUD;
import modelos.RegistraGastos;
import modelos.IRegistraGastosCRUD;
import modelos.ITipoGastosCRUD;
import modelos.IVeiculoCRUD;
import modelos.Proprietario;

import modelos.Veiculo;

public class TelaRelatorioGastos extends javax.swing.JFrame {
    
    DefaultTableModel model;
    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
    //------------------------------------//
    ArrayList<Proprietario> listaDeProprietarios = null;
    ArrayList<Veiculo> listaDeVeiculos = null;
    ArrayList<RegistraGastos> listaRegistroGastos = null;
    ArrayList<GeraRelatorio> listaGeraRelatorio = null;
    //------------------------------------//
    IPropietarioCRUD proprietarioCRUD = null;
    IVeiculoCRUD veiculoCRUD = null;
    ITipoGastosCRUD tipoGastosCRUD = null;
    IRegistraGastosCRUD registraGastoCRUD = null;
    //------------------------------------//
    Proprietario objProprietario = null;
    RegistraGastos objRegistraGastos = null;
    Veiculo objVeiculo = null;

//    RegistraGastos registroGastos = null;
    /**
     * Creates new form TelaRegistroGastos
     */
    public TelaRelatorioGastos() {
        initComponents();
        this.setResizable(false);
        this.setTitle("SCGV - Sistema de Controle de Gastos Veicular - Relatório de gastos");
        this.setLocationRelativeTo(null);
        model = (DefaultTableModel) jTable_SaidaGastos.getModel();
        registraGastoCRUD = new RegistraGastoControle();
        proprietarioCRUD = new ProprietarioControle();
        veiculoCRUD = new VeiculoControle();
        tipoGastosCRUD = new TipoGastosControle();
        objRegistraGastos = new RegistraGastos();
        iniciaListas();
        preencherComboBoxProprietario();
        //MostrarGastos();
    }
    
    private void iniciaListas() {
        try {
            listaDeProprietarios = proprietarioCRUD.listagemDePropietario();
            listaDeVeiculos = veiculoCRUD.listagemDeVeiculos();
            tipoGastosCRUD.listagemDeGastos();
            listaRegistroGastos = registraGastoCRUD.listagemRegistroDeGastos();
            listaGeraRelatorio = new ArrayList<>();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + "ERRO INICIA LISTA");
        }
    }

    //Todos proprietarios serao listados nessa combox
    private void preencherComboBoxProprietario() {
        jComboBox_Proprietario.removeAllItems();
        jComboBox_Veiculo.removeAllItems();
        jComboBox_TipoDeGasto.removeAllItems();
        jComboBox_Proprietario.addItem("Selecione um proprietário");
        jComboBox_Proprietario.setSelectedIndex(0);
        for (Proprietario i : listaDeProprietarios) {
            jComboBox_Proprietario.addItem(i.getNomeCompleto());
        }
    }

//    //Todos veiculos que pertencem ao proprietario selecionado serao listados nesesa combobox
    private void preencherComboBoxVeiculo(Proprietario p) {
        jComboBox_Veiculo.addItem("Selecione um veículo");
        jComboBox_Veiculo.setSelectedIndex(0);
        for (Veiculo i : listaDeVeiculos) {
            if (p.getCpf().equals(i.getCPFProprietario())) {
                jComboBox_Veiculo.addItem(i.getModelo());
            }
        }
    }
    
    private void preencherComboBoxTipoGastos(Veiculo v) {
        jComboBox_TipoDeGasto.addItem("Selecione um Gasto");
        jComboBox_TipoDeGasto.setSelectedIndex(0);
        if (v == null) {
            for (RegistraGastos i : listaRegistroGastos) {
                if (i.getCPFProprietario().equals(objProprietario.getCpf())) {
                    jComboBox_TipoDeGasto.addItem("" + i.getTipoDeGasto());
                }
            }
        } else {
            for (RegistraGastos i : listaRegistroGastos) {
                if (i.getCPFProprietario().equals(objProprietario.getCpf()) && v.getId().equals(i.getIdVeiculo())) {
                    boolean existe = false;
                    for(int j = 0; j < jComboBox_TipoDeGasto.getItemCount(); j++){
                        if(i.getTipoDeGasto().equals(jComboBox_TipoDeGasto.getItemAt(j))){
                            existe = true;
                            break;
                        }
                    }
                    if(!existe){
                        jComboBox_TipoDeGasto.addItem("" + i.getTipoDeGasto());
                    }
                }
            }
        }
    }

    /**
     * This method is called from within the cq1onstructor to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser_DataFinal = new com.raven.datechooser.DateChooser();
        dateChooser_DataInicial = new com.raven.datechooser.DateChooser();
        jPanel1 = new javax.swing.JPanel();
        jButton_Voltar = new javax.swing.JButton();
        jLabel_EmblemaGrupo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel_ID2 = new javax.swing.JLabel();
        jLabel_ID3 = new javax.swing.JLabel();
        jTextField_DataFinal = new javax.swing.JTextField();
        jLabel_ID6 = new javax.swing.JLabel();
        jLabel_ID8 = new javax.swing.JLabel();
        jTextField_DataInicial = new javax.swing.JTextField();
        jLabel_ID4 = new javax.swing.JLabel();
        jButton_Limpar = new javax.swing.JButton();
        jButton_Gerar = new javax.swing.JButton();
        jComboBox_Veiculo = new javax.swing.JComboBox<>();
        jComboBox_Proprietario = new javax.swing.JComboBox<>();
        jComboBox_TipoDeGasto = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jButton_exportarExcel = new javax.swing.JButton();
        jButton_exportarPDF = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_SaidaGastos = new javax.swing.JTable();

        dateChooser_DataFinal.setForeground(new java.awt.Color(0, 0, 204));
        dateChooser_DataFinal.setDateFormat("dd/MM/yyyy");
        dateChooser_DataFinal.setTextRefernce(jTextField_DataFinal);

        dateChooser_DataInicial.setForeground(new java.awt.Color(0, 0, 204));
        dateChooser_DataInicial.setDateFormat("dd/MM/yyyy");
        dateChooser_DataFinal.setTextRefernce(jTextField_DataInicial);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jButton_Voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/voltar-24.png"))); // NOI18N
        jButton_Voltar.setText("Voltar");
        jButton_Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_VoltarActionPerformed(evt);
            }
        });

        jLabel_EmblemaGrupo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_EmblemaGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/scgv.png"))); // NOI18N
        jLabel_EmblemaGrupo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_Voltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(509, 509, 509)
                    .addComponent(jLabel_EmblemaGrupo)
                    .addContainerGap(509, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButton_Voltar)
                .addContainerGap(65, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(jLabel_EmblemaGrupo)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Selecionar campos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 0))); // NOI18N

        jLabel_ID2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel_ID2.setText("Proprietario:");

        jLabel_ID3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel_ID3.setText("Veiculo:");

        jTextField_DataFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DataFinalActionPerformed(evt);
            }
        });

        jLabel_ID6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel_ID6.setText("Data inicial:");

        jLabel_ID8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel_ID8.setText("Data final:");

        jLabel_ID4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel_ID4.setText("Tipo de gasto:");

        jButton_Limpar.setText("Limpar");

        jButton_Gerar.setText("Gerar");
        jButton_Gerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GerarActionPerformed(evt);
            }
        });

        jComboBox_Veiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_VeiculoActionPerformed(evt);
            }
        });

        jComboBox_Proprietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_ProprietarioActionPerformed(evt);
            }
        });

        jComboBox_TipoDeGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_TipoDeGastoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_ID2)
                            .addComponent(jLabel_ID3)
                            .addComponent(jLabel_ID6)
                            .addComponent(jLabel_ID8))
                        .addGap(53, 53, 53))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel_ID4)
                        .addGap(42, 42, 42)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_DataInicial)
                    .addComponent(jTextField_DataFinal)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton_Limpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_Gerar))
                    .addComponent(jComboBox_Veiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox_Proprietario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox_TipoDeGasto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ID2)
                    .addComponent(jComboBox_Proprietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ID3)
                    .addComponent(jComboBox_Veiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel_ID4)
                    .addComponent(jComboBox_TipoDeGasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ID6)
                    .addComponent(jTextField_DataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ID8)
                    .addComponent(jTextField_DataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Limpar)
                    .addComponent(jButton_Gerar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gastos Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 0))); // NOI18N

        jButton_exportarExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/excel.png"))); // NOI18N
        jButton_exportarExcel.setText("Exportar");
        jButton_exportarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_exportarExcelActionPerformed(evt);
            }
        });

        jButton_exportarPDF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pdf.png"))); // NOI18N
        jButton_exportarPDF.setText("Exportar");
        jButton_exportarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_exportarPDFActionPerformed(evt);
            }
        });

        jTable_SaidaGastos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID do Gasto", "Proprietário", "Veículo", "Data", "Tipo de Gasto", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_SaidaGastos.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTable_SaidaGastosAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTable_SaidaGastos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_SaidaGastosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_SaidaGastos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(324, 324, 324)
                .addComponent(jButton_exportarExcel)
                .addGap(18, 18, 18)
                .addComponent(jButton_exportarPDF)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_exportarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_exportarExcel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_VoltarActionPerformed
        dispose();
        TelaPrincipal voltaTelaPrincipal = new TelaPrincipal();
        voltaTelaPrincipal.dispose();
        voltaTelaPrincipal.setLocationRelativeTo(this);
        voltaTelaPrincipal.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        voltaTelaPrincipal.setVisible(true);
    }//GEN-LAST:event_jButton_VoltarActionPerformed

    private void jTable_SaidaGastosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTable_SaidaGastosAncestorAdded

    }//GEN-LAST:event_jTable_SaidaGastosAncestorAdded

    private void jTable_SaidaGastosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_SaidaGastosMouseClicked

    }//GEN-LAST:event_jTable_SaidaGastosMouseClicked

    private void jTextField_DataFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DataFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DataFinalActionPerformed

    private void jComboBox_VeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_VeiculoActionPerformed
        jComboBox_TipoDeGasto.removeAllItems();
        if (jComboBox_Veiculo.getSelectedIndex() == 0) {
            preencherComboBoxTipoGastos(null);
        } else if (jComboBox_Veiculo.getSelectedIndex() > 0) {
            for (Veiculo i : listaDeVeiculos) {
                String v = jComboBox_Veiculo.getSelectedItem().toString();
                if (v.equals(i.getModelo()) && objProprietario.getCpf().equals(i.getCPFProprietario())) {
                    objVeiculo = i;
                    objRegistraGastos = null;
                    preencherComboBoxTipoGastos(i);
                }
            }
        }
    }//GEN-LAST:event_jComboBox_VeiculoActionPerformed

    private void jComboBox_ProprietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_ProprietarioActionPerformed
        jComboBox_Veiculo.removeAllItems();
        jComboBox_TipoDeGasto.removeAllItems();
        for (Proprietario i : listaDeProprietarios) {
            if (jComboBox_Proprietario.getSelectedItem().toString().equals(i.getNomeCompleto())) {
                objProprietario = i;
                preencherComboBoxVeiculo(i);
            }
        }
    }//GEN-LAST:event_jComboBox_ProprietarioActionPerformed

    private void jComboBox_TipoDeGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_TipoDeGastoActionPerformed

    }//GEN-LAST:event_jComboBox_TipoDeGastoActionPerformed

    private void jButton_GerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GerarActionPerformed
        try {
            Date DataInicial = formatador.parse(jTextField_DataInicial.getText());
            Date DataFinal = formatador.parse(jTextField_DataFinal.getText());
            for (RegistraGastos i : listaRegistroGastos) {
                Integer id = i.getId();
                String p_aux = i.getNomeProprietario();
                String v_aux = i.getVeiculo();
                String dataGasto = i.getData();
                String tipoDeGasto = i.getTipoDeGasto();
                Float valor = i.getValorGasto();
                listaGeraRelatorio.add(new GeraRelatorio(id, p_aux, v_aux, dataGasto, tipoDeGasto, valor));
            }
            Float total = 0f;
            model.setNumRows(0);
            for (GeraRelatorio i : listaGeraRelatorio) {
                if (i.getDataGasto().equals(DataInicial) || i.getDataGasto().equals(DataFinal)
                        || (i.getDataGasto().after(DataInicial) && i.getDataGasto().before(DataFinal))) {
                    if (jComboBox_Proprietario.getSelectedIndex() > 0) {                        
                        if (jComboBox_Veiculo.getSelectedIndex() > 0) {                            
                            if (jComboBox_TipoDeGasto.getSelectedIndex() > 0) {
                                if (i.getProprietario().equals(jComboBox_Proprietario.getSelectedItem().toString())
                                        && i.getVeiculo().equals(jComboBox_Veiculo.getSelectedItem().toString())
                                        && i.getTipoDeGasto().equals(jComboBox_TipoDeGasto.getSelectedItem().toString())) {
                                    total = i.getValorGasto() + total;
                                    model.addRow(i.toString().split(";"));
                                    System.out.println(i.toString());
                                }
                                
                            } else {
                                if (i.getProprietario().equals(jComboBox_Proprietario.getSelectedItem().toString())
                                        && i.getVeiculo().equals(jComboBox_Veiculo.getSelectedItem().toString())) {
                                    total = i.getValorGasto() + total;
                                    model.addRow(i.toString().split(";"));
                                    System.out.println(i.toString());
                                }                                
                            }
                        } else {
                            if (i.getProprietario().equals(jComboBox_Proprietario.getSelectedItem().toString())) {
                                total = i.getValorGasto() + total;
                                model.addRow(i.toString().split(";"));
                                System.out.println(i.toString());
                            }
                        }
                    } else {
                        total = i.getValorGasto() + total;
                        model.addRow(i.toString().split(";"));
                        System.out.println(i.toString());
                    }                    
                }                
            }
            String x = "" + ";" + "" + ";" + "" + ";" + "" + ";" + "" + ";" + "";
            model.addRow(x.split(";"));  
            
            x = "" + ";" + "" + ";" + "" + ";" + "" + ";" + "" + ";" + "";
            model.addRow(x.split(";"));  
            
            x = "" + ";" + "" + ";" + "" + ";" + "" + ";" + "Total:" + ";" + total;
            model.addRow(x.split(";"));            
            
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        //listaGeraRelatorio = null;
        listaGeraRelatorio = new ArrayList<>();
    }//GEN-LAST:event_jButton_GerarActionPerformed

    private void jButton_exportarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_exportarExcelActionPerformed
        ExcelExporter exporter = new ExcelExporter();
        try {
            exporter.exportToExcel(jTable_SaidaGastos);
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_jButton_exportarExcelActionPerformed

    private void jButton_exportarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_exportarPDFActionPerformed
        PDFExporter pdfExporter = new PDFExporter();
        try {
            pdfExporter.exportToPDF(jTable_SaidaGastos);
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_jButton_exportarPDFActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorioGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorioGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorioGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorioGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelatorioGastos().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.raven.datechooser.DateChooser dateChooser_DataFinal;
    private com.raven.datechooser.DateChooser dateChooser_DataInicial;
    private javax.swing.JButton jButton_Gerar;
    private javax.swing.JButton jButton_Limpar;
    private javax.swing.JButton jButton_Voltar;
    private javax.swing.JButton jButton_exportarExcel;
    private javax.swing.JButton jButton_exportarPDF;
    private javax.swing.JComboBox<String> jComboBox_Proprietario;
    private javax.swing.JComboBox<String> jComboBox_TipoDeGasto;
    private javax.swing.JComboBox<String> jComboBox_Veiculo;
    private javax.swing.JLabel jLabel_EmblemaGrupo;
    private javax.swing.JLabel jLabel_ID2;
    private javax.swing.JLabel jLabel_ID3;
    private javax.swing.JLabel jLabel_ID4;
    private javax.swing.JLabel jLabel_ID6;
    private javax.swing.JLabel jLabel_ID8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_SaidaGastos;
    private javax.swing.JTextField jTextField_DataFinal;
    private javax.swing.JTextField jTextField_DataInicial;
    // End of variables declaration//GEN-END:variables
}
