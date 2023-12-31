/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

import controle.ExcelExporter;
import controle.PDFExporter;
import controle.TipoGastosControle;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modelos.TipoGastos;
import modelos.ITipoGastosCRUD;
import util.ImageRenderer;

/**
 *
 * @author Gustavo Camargo
 */
public class TelaRegistroTipoGastos extends javax.swing.JFrame {

    ITipoGastosCRUD tipoGastosControle = null;
    File origemGlobal = null;

    /**
     * Creates new form TelaRegistroTipoGastos
     */
    public TelaRegistroTipoGastos() {
        initComponents();
        this.setResizable(false);
        this.setTitle("SCGV - Sistema de Controle de Gastos Veicular - Cadastro de Tipos de Gastos");
        this.setLocationRelativeTo(null);
//        this.setExtendedState(TelaRegistroGastos.MAXIMIZED_BOTH);
        tipoGastosControle = new TipoGastosControle();
        MostrarTipoDeGastos();
    }

    // Metodo limpar campos
    private void LimparCampos() {
        jTextField_ID.setText(null);
        jTextField_NomeGasto.setText(null);
        jTextArea_Descricao.setText(null);
    }

    // Metodo para buscar e preencher Tipos de Gastos na jTable em ordem crescente
    private void MostrarTipoDeGastos() {
        try {
            ArrayList<TipoGastos> listaDeTiposDeGastos = tipoGastosControle.listagemDeGastos();
            Collections.sort(listaDeTiposDeGastos, (TipoGastos o1, TipoGastos o2) -> {
                return o1.getId().compareTo(o2.getId());
            });
            DefaultTableModel model = (DefaultTableModel) jTable_SaidaTipoGastos.getModel();
            model.setNumRows(0);
            int x = 0;
            if (!listaDeTiposDeGastos.isEmpty()) {
                for (TipoGastos i : listaDeTiposDeGastos) {
                    String[] dados = i.toString().split(";");
                    model.addRow(dados);
                    String imagePath = dados[3];
                    ImageIcon imageIcon = new ImageIcon(imagePath);
                    Image image = imageIcon.getImage();
                    Image scaledImage = image.getScaledInstance(18, 18, Image.SCALE_SMOOTH);
                    ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
                    model.setValueAt(scaledImageIcon, x, 3);
                    jTable_SaidaTipoGastos.getColumnModel().getColumn(3).setCellRenderer(new ImageRenderer());
                    x++;
                }
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(rootPane, erro.getMessage());
        }
    }

    private void setImagemCNH(String caminhoLogo) {
        ImageIcon icon = new ImageIcon(caminhoLogo);
        //definindo um tamanho limite para a imagem 
        ImageIcon resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(210, 190, java.awt.Image.SCALE_SMOOTH));
        jLabel_LogoImagem.setIcon(resizedIcon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel_EmblemaGrupo = new javax.swing.JLabel();
        jButton_Voltar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel_ID5 = new javax.swing.JLabel();
        jLabel_Descricao2 = new javax.swing.JLabel();
        jTextField_NomeGasto = new javax.swing.JTextField();
        jTextField_ID = new javax.swing.JTextField();
        jLabel_Descricao1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_Descricao = new javax.swing.JTextArea();
        jButton_Selecionar = new javax.swing.JButton();
        jButton_Limpar = new javax.swing.JButton();
        jButton_Alterar = new javax.swing.JButton();
        jButton_Salvar = new javax.swing.JButton();
        jLabel_LogoImagem = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_SaidaTipoGastos = new javax.swing.JTable();
        jButton_exportarExcel1 = new javax.swing.JButton();
        jButton_exportarExcel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel_EmblemaGrupo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_EmblemaGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/scgv.png"))); // NOI18N
        jLabel_EmblemaGrupo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton_Voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/voltar-24.png"))); // NOI18N
        jButton_Voltar.setText("Voltar");
        jButton_Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_VoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_Voltar)
                .addGap(310, 310, 310)
                .addComponent(jLabel_EmblemaGrupo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_EmblemaGrupo)
                    .addComponent(jButton_Voltar))
                .addGap(408, 408, 408))
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastrar novo Tipo de Gasto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 0))); // NOI18N

        jLabel_ID5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel_ID5.setText("ID:");

        jLabel_Descricao2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel_Descricao2.setText("Nome:");

        jTextField_NomeGasto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_NomeGastoKeyTyped(evt);
            }
        });

        jTextField_ID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_IDKeyTyped(evt);
            }
        });

        jLabel_Descricao1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel_Descricao1.setText("Descrição:");

        jTextArea_Descricao.setColumns(20);
        jTextArea_Descricao.setRows(5);
        jScrollPane2.setViewportView(jTextArea_Descricao);

        jButton_Selecionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/selecionar-24.png"))); // NOI18N
        jButton_Selecionar.setText("Selecionar Ícone");
        jButton_Selecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SelecionarActionPerformed(evt);
            }
        });

        jButton_Limpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/limpar-24.png"))); // NOI18N
        jButton_Limpar.setText("Limpar");
        jButton_Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_LimparActionPerformed(evt);
            }
        });

        jButton_Alterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/alterar-24.png"))); // NOI18N
        jButton_Alterar.setText("Alterar");
        jButton_Alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AlterarActionPerformed(evt);
            }
        });

        jButton_Salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar-24.png"))); // NOI18N
        jButton_Salvar.setText("Salvar");
        jButton_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SalvarActionPerformed(evt);
            }
        });

        jLabel_LogoImagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_LogoImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo/sem-imagem.png"))); // NOI18N
        jLabel_LogoImagem.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Imagem", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 16))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton_Selecionar)
                    .addComponent(jLabel_LogoImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton_Limpar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Alterar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Salvar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_Descricao1)
                                    .addComponent(jLabel_Descricao2))
                                .addGap(29, 29, 29))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel_ID5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField_ID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField_NomeGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ID5)
                    .addComponent(jTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Descricao2)
                    .addComponent(jTextField_NomeGasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_Descricao1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel_LogoImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_Selecionar)
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Limpar)
                    .addComponent(jButton_Salvar)
                    .addComponent(jButton_Alterar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipos de Gastos Cadastrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14), new java.awt.Color(255, 255, 0))); // NOI18N

        jTable_SaidaTipoGastos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Descrição", "Icone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_SaidaTipoGastos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_SaidaTipoGastosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_SaidaTipoGastos);

        jButton_exportarExcel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pdf.png"))); // NOI18N
        jButton_exportarExcel1.setText("Exportar");
        jButton_exportarExcel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_exportarExcel1ActionPerformed(evt);
            }
        });

        jButton_exportarExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/excel.png"))); // NOI18N
        jButton_exportarExcel.setText("Exportar");
        jButton_exportarExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_exportarExcelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_exportarExcel)
                .addGap(111, 111, 111)
                .addComponent(jButton_exportarExcel1)
                .addGap(135, 135, 135))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_exportarExcel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_exportarExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(63, 63, 63))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_SelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SelecionarActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de Imagem", "jpg", "jpeg", "png", "gif");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            origemGlobal = fileChooser.getSelectedFile();
        }

        setImagemCNH(fileChooser.getSelectedFile().getPath());
    }//GEN-LAST:event_jButton_SelecionarActionPerformed

    private void jTextField_NomeGastoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_NomeGastoKeyTyped
        String caracteres = "0123456789";
        if (caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_NomeGastoKeyTyped

    private void jButton_VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_VoltarActionPerformed
        dispose();
        TelaRegistroGastos voltaTelaRegistroGastos = new TelaRegistroGastos();
        voltaTelaRegistroGastos.dispose();
        voltaTelaRegistroGastos.setLocationRelativeTo(this);
        voltaTelaRegistroGastos.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        voltaTelaRegistroGastos.setVisible(true);
    }//GEN-LAST:event_jButton_VoltarActionPerformed

    private void jButton_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SalvarActionPerformed
        try {
            Integer _id = -1;
            if (!jTextField_ID.getText().isBlank()) {
                _id = Integer.valueOf(jTextField_ID.getText());
            }
            TipoGastos tipoGasto = new TipoGastos(_id,
                    jTextField_NomeGasto.getText(),
                    jTextArea_Descricao.getText(),
                    origemGlobal);
            System.out.println(origemGlobal);
            tipoGastosControle.incluir(tipoGasto);
            origemGlobal = null;
            setImagemCNH(".\\src\\img\\tipoGastos\\sem-imagem.png");
            LimparCampos();
            MostrarTipoDeGastos();
            JOptionPane.showMessageDialog(rootPane, "Tipo de gasto cadastrado com sucesso !");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }//GEN-LAST:event_jButton_SalvarActionPerformed

    private void jTextField_IDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_IDKeyTyped
        try {
            String caracteres = "0123456789";
            if (!caracteres.contains(evt.getKeyChar() + "")) {
                evt.consume();
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }


    }//GEN-LAST:event_jTextField_IDKeyTyped

    private void jButton_AlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AlterarActionPerformed
        try {
            TipoGastos tipoDeGastos = new TipoGastos(
                    Integer.valueOf(jTextField_ID.getText()),
                    jTextField_NomeGasto.getText(),
                    jTextArea_Descricao.getText(),
                    origemGlobal);
            tipoGastosControle.alterar(tipoDeGastos);
            origemGlobal = null;
            setImagemCNH(".\\src\\img\\tipoGastos\\sem-imagem.png");
            MostrarTipoDeGastos();
            jTextField_ID.setEnabled(true);
            LimparCampos();
            JOptionPane.showMessageDialog(rootPane, "Tipo de gasto alterado com sucesso !");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButton_AlterarActionPerformed

    private void jTable_SaidaTipoGastosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_SaidaTipoGastosMouseClicked
        jTextField_ID.setEnabled(false);
        int linha = jTable_SaidaTipoGastos.getSelectedRow();

        jTextField_ID.setText((String) jTable_SaidaTipoGastos.getValueAt(linha, 0));
        try {
            TipoGastos tipoDeGastos = tipoGastosControle.consultar(Integer.valueOf(jTextField_ID.getText()));
            jTextField_ID.setText(tipoDeGastos.getId() + "");
            jTextField_NomeGasto.setText(tipoDeGastos.getNome());

            jTextArea_Descricao.setText(tipoDeGastos.getDescricao());
            origemGlobal = new File(tipoDeGastos.getIconGasto().getPath());
            setImagemCNH(tipoDeGastos.getIconGasto().getPath());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jTable_SaidaTipoGastosMouseClicked

    private void jButton_LimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_LimparActionPerformed
        jTextField_ID.setEnabled(true);
        origemGlobal = null;
        setImagemCNH(".\\src\\img\\tipoGastos\\sem-imagem.png");
        LimparCampos();
    }//GEN-LAST:event_jButton_LimparActionPerformed

    private void jButton_exportarExcel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_exportarExcel1ActionPerformed
        PDFExporter pdfExporter = new PDFExporter();
        try {
            pdfExporter.exportToPDF(jTable_SaidaTipoGastos);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jButton_exportarExcel1ActionPerformed

    private void jButton_exportarExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_exportarExcelActionPerformed
        ExcelExporter exporter = new ExcelExporter();
        try {
            exporter.exportToExcel(jTable_SaidaTipoGastos);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jButton_exportarExcelActionPerformed

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
            java.util.logging.Logger.getLogger(TelaRegistroTipoGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRegistroTipoGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRegistroTipoGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRegistroTipoGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRegistroTipoGastos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Alterar;
    private javax.swing.JButton jButton_Limpar;
    private javax.swing.JButton jButton_Salvar;
    private javax.swing.JButton jButton_Selecionar;
    private javax.swing.JButton jButton_Voltar;
    private javax.swing.JButton jButton_exportarExcel;
    private javax.swing.JButton jButton_exportarExcel1;
    private javax.swing.JLabel jLabel_Descricao1;
    private javax.swing.JLabel jLabel_Descricao2;
    private javax.swing.JLabel jLabel_EmblemaGrupo;
    private javax.swing.JLabel jLabel_ID5;
    private javax.swing.JLabel jLabel_LogoImagem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_SaidaTipoGastos;
    private javax.swing.JTextArea jTextArea_Descricao;
    private javax.swing.JTextField jTextField_ID;
    private javax.swing.JTextField jTextField_NomeGasto;
    // End of variables declaration//GEN-END:variables
}
