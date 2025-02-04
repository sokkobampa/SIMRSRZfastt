package rekammedis;

import fungsi.WarnaTable;
import fungsi.batasInput;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.akses;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author dosen
 */
public class DlgMasterNumdemonINM extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    private Connection koneksi = koneksiDB.condb();
    private sekuel Sequel = new sekuel();
    private validasi Valid = new validasi();
    private Properties prop = new Properties();
    private PreparedStatement ps;
    private ResultSet rs;
    private int i = 0, x = 0;
    private String kode = "", stts = "", kdINM = "";
    
    /** Creates new form DlgPemberianInfus
     * @param parent
     * @param modal */
    public DlgMasterNumdemonINM(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        tabMode = new DefaultTableModel(null, new String[]{
            "Kode Numdenom", "No. Urut", "Kode Indikator", "Nama Indikator", "Nama Numerator Denominator", "Ruang Perawatan/Gedung", "Status Data"}) {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        
        tbMutu.setModel(tabMode);
        tbMutu.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbMutu.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 7; i++) {
            TableColumn column = tbMutu.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(100);
            } else if (i == 1) {
                column.setPreferredWidth(60);
            } else if (i == 2) {
                column.setPreferredWidth(90);
            } else if (i == 3) {
                column.setPreferredWidth(450);
            } else if (i == 4) {
                column.setPreferredWidth(450);
            } else if (i == 5) {
                column.setPreferredWidth(200);
            } else if (i == 6) {
                column.setPreferredWidth(90);
            }
        }
        tbMutu.setDefaultRenderer(Object.class, new WarnaTable());

        TCari.setDocument(new batasInput((byte) 100).getKata(TCari));
        TnoUrut.setDocument(new batasInput((byte) 3).getOnlyAngka(TnoUrut));
        TnmNumdenom.setDocument(new batasInput((int) 255).getKata(TnmNumdenom));        
        
        if(koneksiDB.cariCepat().equals("aktif")){
            TCari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){
                @Override
                public void insertUpdate(DocumentEvent e) {tampil();}
                @Override
                public void removeUpdate(DocumentEvent e) {tampil();}
                @Override
                public void changedUpdate(DocumentEvent e) {tampil();}
            });
        } 
        
        ChkInput.setSelected(true);
        isForm();
    }
 
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        internalFrame1 = new widget.InternalFrame();
        jPanel3 = new javax.swing.JPanel();
        panelGlass8 = new widget.panelisi();
        BtnSimpan = new widget.Button();
        BtnBatal = new widget.Button();
        BtnGanti = new widget.Button();
        BtnAll = new widget.Button();
        BtnKeluar = new widget.Button();
        panelGlass10 = new widget.panelisi();
        jLabel6 = new widget.Label();
        TCari = new widget.TextBox();
        BtnCari = new widget.Button();
        jLabel7 = new widget.Label();
        LCount = new widget.Label();
        PanelInput = new javax.swing.JPanel();
        FormInput = new widget.PanelBiasa();
        jLabel4 = new widget.Label();
        kdNumdenom = new widget.TextBox();
        jLabel9 = new widget.Label();
        TnmNumdenom = new widget.TextBox();
        jLabel5 = new widget.Label();
        TnoUrut = new widget.TextBox();
        jLabel10 = new widget.Label();
        cmbIndikator = new widget.ComboBox();
        jLabel11 = new widget.Label();
        cmbStatus = new widget.ComboBox();
        jLabel12 = new widget.Label();
        cmbGedung = new widget.ComboBox();
        ChkInput = new widget.CekBox();
        internalFrame2 = new widget.InternalFrame();
        Scroll = new widget.ScrollPane();
        tbMutu = new widget.Table();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3), "::[ Master Numerator Denominator Indikator Nasional Mutu ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(44, 100));
        jPanel3.setLayout(new java.awt.BorderLayout(1, 1));

        panelGlass8.setName("panelGlass8"); // NOI18N
        panelGlass8.setPreferredSize(new java.awt.Dimension(55, 55));
        panelGlass8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        BtnSimpan.setForeground(new java.awt.Color(0, 0, 0));
        BtnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/save-16x16.png"))); // NOI18N
        BtnSimpan.setMnemonic('S');
        BtnSimpan.setText("Simpan");
        BtnSimpan.setToolTipText("Alt+S");
        BtnSimpan.setName("BtnSimpan"); // NOI18N
        BtnSimpan.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanActionPerformed(evt);
            }
        });
        BtnSimpan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnSimpanKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnSimpan);

        BtnBatal.setForeground(new java.awt.Color(0, 0, 0));
        BtnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Cancel-2-16x16.png"))); // NOI18N
        BtnBatal.setMnemonic('B');
        BtnBatal.setText("Baru");
        BtnBatal.setToolTipText("Alt+B");
        BtnBatal.setName("BtnBatal"); // NOI18N
        BtnBatal.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatalActionPerformed(evt);
            }
        });
        BtnBatal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnBatalKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnBatal);

        BtnGanti.setForeground(new java.awt.Color(0, 0, 0));
        BtnGanti.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/inventaris.png"))); // NOI18N
        BtnGanti.setMnemonic('G');
        BtnGanti.setText("Ganti");
        BtnGanti.setToolTipText("Alt+G");
        BtnGanti.setName("BtnGanti"); // NOI18N
        BtnGanti.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnGanti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGantiActionPerformed(evt);
            }
        });
        BtnGanti.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnGantiKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnGanti);

        BtnAll.setForeground(new java.awt.Color(0, 0, 0));
        BtnAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        BtnAll.setMnemonic('M');
        BtnAll.setText("Semua");
        BtnAll.setToolTipText("Alt+M");
        BtnAll.setName("BtnAll"); // NOI18N
        BtnAll.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAllActionPerformed(evt);
            }
        });
        BtnAll.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnAllKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnAll);

        BtnKeluar.setForeground(new java.awt.Color(0, 0, 0));
        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar.setMnemonic('K');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+K");
        BtnKeluar.setName("BtnKeluar"); // NOI18N
        BtnKeluar.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });
        BtnKeluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnKeluarKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnKeluar);

        jPanel3.add(panelGlass8, java.awt.BorderLayout.PAGE_END);

        panelGlass10.setName("panelGlass10"); // NOI18N
        panelGlass10.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Key Word :");
        jLabel6.setName("jLabel6"); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(70, 23));
        panelGlass10.add(jLabel6);

        TCari.setForeground(new java.awt.Color(0, 0, 0));
        TCari.setName("TCari"); // NOI18N
        TCari.setPreferredSize(new java.awt.Dimension(250, 23));
        TCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCariKeyPressed(evt);
            }
        });
        panelGlass10.add(TCari);

        BtnCari.setForeground(new java.awt.Color(0, 0, 0));
        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari.setMnemonic('2');
        BtnCari.setText("Tampilkan Data");
        BtnCari.setName("BtnCari"); // NOI18N
        BtnCari.setPreferredSize(new java.awt.Dimension(130, 23));
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });
        BtnCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCariKeyPressed(evt);
            }
        });
        panelGlass10.add(BtnCari);

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Record :");
        jLabel7.setName("jLabel7"); // NOI18N
        jLabel7.setPreferredSize(new java.awt.Dimension(65, 23));
        panelGlass10.add(jLabel7);

        LCount.setForeground(new java.awt.Color(0, 0, 0));
        LCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCount.setText("0");
        LCount.setName("LCount"); // NOI18N
        LCount.setPreferredSize(new java.awt.Dimension(50, 23));
        panelGlass10.add(LCount);

        jPanel3.add(panelGlass10, java.awt.BorderLayout.CENTER);

        internalFrame1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        PanelInput.setName("PanelInput"); // NOI18N
        PanelInput.setOpaque(false);
        PanelInput.setPreferredSize(new java.awt.Dimension(192, 148));
        PanelInput.setLayout(new java.awt.BorderLayout(1, 1));

        FormInput.setName("FormInput"); // NOI18N
        FormInput.setPreferredSize(new java.awt.Dimension(190, 107));
        FormInput.setLayout(null);

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Kode Numdenom : ");
        jLabel4.setName("jLabel4"); // NOI18N
        FormInput.add(jLabel4);
        jLabel4.setBounds(0, 10, 115, 23);

        kdNumdenom.setEditable(false);
        kdNumdenom.setForeground(new java.awt.Color(0, 0, 0));
        kdNumdenom.setName("kdNumdenom"); // NOI18N
        FormInput.add(kdNumdenom);
        kdNumdenom.setBounds(118, 10, 90, 23);

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Nama Numdenom : ");
        jLabel9.setName("jLabel9"); // NOI18N
        FormInput.add(jLabel9);
        jLabel9.setBounds(0, 94, 115, 23);

        TnmNumdenom.setForeground(new java.awt.Color(0, 0, 0));
        TnmNumdenom.setName("TnmNumdenom"); // NOI18N
        FormInput.add(TnmNumdenom);
        TnmNumdenom.setBounds(118, 94, 530, 23);

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("No. Urut :");
        jLabel5.setName("jLabel5"); // NOI18N
        FormInput.add(jLabel5);
        jLabel5.setBounds(210, 10, 60, 23);

        TnoUrut.setForeground(new java.awt.Color(0, 0, 0));
        TnoUrut.setName("TnoUrut"); // NOI18N
        TnoUrut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TnoUrutKeyPressed(evt);
            }
        });
        FormInput.add(TnoUrut);
        TnoUrut.setBounds(275, 10, 50, 23);

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Jenis INM : ");
        jLabel10.setName("jLabel10"); // NOI18N
        FormInput.add(jLabel10);
        jLabel10.setBounds(0, 66, 115, 23);

        cmbIndikator.setForeground(new java.awt.Color(0, 0, 0));
        cmbIndikator.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        cmbIndikator.setName("cmbIndikator"); // NOI18N
        cmbIndikator.setPreferredSize(new java.awt.Dimension(55, 28));
        FormInput.add(cmbIndikator);
        cmbIndikator.setBounds(118, 66, 490, 23);

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Status Data :");
        jLabel11.setName("jLabel11"); // NOI18N
        FormInput.add(jLabel11);
        jLabel11.setBounds(315, 38, 80, 23);

        cmbStatus.setForeground(new java.awt.Color(0, 0, 0));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aktif", "Non Aktif" }));
        cmbStatus.setName("cmbStatus"); // NOI18N
        cmbStatus.setPreferredSize(new java.awt.Dimension(55, 28));
        FormInput.add(cmbStatus);
        cmbStatus.setBounds(400, 38, 80, 23);

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Ruang Perawatan : ");
        jLabel12.setName("jLabel12"); // NOI18N
        FormInput.add(jLabel12);
        jLabel12.setBounds(0, 38, 115, 23);

        cmbGedung.setForeground(new java.awt.Color(0, 0, 0));
        cmbGedung.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "VK BERSALIN", "RAWAT JALAN", "IBS", "AR RAUDAH" }));
        cmbGedung.setName("cmbGedung"); // NOI18N
        cmbGedung.setPreferredSize(new java.awt.Dimension(55, 28));
        cmbGedung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cmbGedungMouseReleased(evt);
            }
        });
        cmbGedung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbGedungActionPerformed(evt);
            }
        });
        FormInput.add(cmbGedung);
        cmbGedung.setBounds(118, 38, 190, 23);

        PanelInput.add(FormInput, java.awt.BorderLayout.CENTER);

        ChkInput.setForeground(new java.awt.Color(0, 0, 0));
        ChkInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/143.png"))); // NOI18N
        ChkInput.setMnemonic('M');
        ChkInput.setText(".: Input Data");
        ChkInput.setBorderPainted(true);
        ChkInput.setBorderPaintedFlat(true);
        ChkInput.setFocusable(false);
        ChkInput.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ChkInput.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ChkInput.setName("ChkInput"); // NOI18N
        ChkInput.setPreferredSize(new java.awt.Dimension(192, 20));
        ChkInput.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/143.png"))); // NOI18N
        ChkInput.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/145.png"))); // NOI18N
        ChkInput.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/145.png"))); // NOI18N
        ChkInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkInputActionPerformed(evt);
            }
        });
        PanelInput.add(ChkInput, java.awt.BorderLayout.PAGE_END);

        internalFrame1.add(PanelInput, java.awt.BorderLayout.PAGE_START);

        internalFrame2.setBorder(null);
        internalFrame2.setName("internalFrame2"); // NOI18N
        internalFrame2.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll.setName("Scroll"); // NOI18N
        Scroll.setOpaque(true);

        tbMutu.setToolTipText("Silahkan klik untuk memilih data yang diperbaiki");
        tbMutu.setName("tbMutu"); // NOI18N
        tbMutu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMutuMouseClicked(evt);
            }
        });
        tbMutu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbMutuKeyPressed(evt);
            }
        });
        Scroll.setViewportView(tbMutu);

        internalFrame2.add(Scroll, java.awt.BorderLayout.CENTER);

        internalFrame1.add(internalFrame2, java.awt.BorderLayout.CENTER);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        if (kdNumdenom.getText().trim().equals("")) {
            Valid.textKosong(kdNumdenom, "kode numerator denominator/numdenom");
            kdNumdenom.requestFocus();
        } else if (TnoUrut.getText().trim().equals("")) {
            Valid.textKosong(TnoUrut, "no. urut");
            TnoUrut.requestFocus();
        } else if (TnmNumdenom.getText().trim().equals("")) {
            Valid.textKosong(TnmNumdenom, "nama numerator denominator/numdenom");
            TnmNumdenom.requestFocus();
        } else if (cmbGedung.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Silahkan pilih dulu salah satu gedung perawatanya...!!");
            cmbGedung.requestFocus();
        } else {
            if (cmbStatus.getSelectedIndex() == 0) {
                stts = "aktif";
            } else {
                stts = "non aktif";
            }
            kdNumdenom.setText(Valid.autoNomer("master_numdemon_indikator_nasional_mutu", "ND", 3));
            kdINM = Sequel.cariIsi("select kd_indikator from master_indikator_nasional_mutu where gedung='" + cmbGedung.getSelectedItem().toString() + "' and "
                    + "nm_indikator='" + cmbIndikator.getSelectedItem().toString() + "'");
            
            Sequel.menyimpan("master_numdemon_indikator_nasional_mutu", "'" + kdNumdenom.getText() + "','" + kdINM + "',"
                    + "'" + TnoUrut.getText() + "','" + TnmNumdenom.getText() + "','" + stts + "'", "Numerator Demonimator Indikator Nasional Mutu");
            emptTeks();
            BtnCariActionPerformed(null);
        }
}//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnSimpanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSimpanKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            BtnSimpanActionPerformed(null);
        } else {
            Valid.pindah(evt, kdNumdenom, BtnBatal);
        }
}//GEN-LAST:event_BtnSimpanKeyPressed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        emptTeks();
        ChkInput.setSelected(true);
        isForm(); 
}//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnBatalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnBatalKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            emptTeks();
        } else {
            Valid.pindah(evt, BtnSimpan, BtnGanti);
        }
}//GEN-LAST:event_BtnBatalKeyPressed

    private void BtnGantiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGantiActionPerformed
        if (kdNumdenom.getText().trim().equals("")) {
            Valid.textKosong(kdNumdenom, "kode numerator denominator/numdenom");
            kdNumdenom.requestFocus();
        } else if (TnoUrut.getText().trim().equals("")) {
            Valid.textKosong(TnoUrut, "no. urut");
            TnoUrut.requestFocus();
        } else if (TnmNumdenom.getText().trim().equals("")) {
            Valid.textKosong(TnmNumdenom, "nama numerator denominator/numdenom");
            TnmNumdenom.requestFocus();
        } else if (cmbGedung.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Silahkan pilih dulu salah satu gedung perawatanya...!!");
            cmbGedung.requestFocus();
        } else {
            if (tbMutu.getSelectedRow() > -1) {
                if (cmbStatus.getSelectedIndex() == 0) {
                    stts = "aktif";
                } else {
                    stts = "non aktif";
                }

                kdINM = Sequel.cariIsi("select kd_indikator from master_indikator_nasional_mutu where gedung='" + cmbGedung.getSelectedItem().toString() + "' and "
                        + "nm_indikator='" + cmbIndikator.getSelectedItem().toString() + "'");
                
                Sequel.mengedit("master_numdemon_indikator_nasional_mutu", "kd_numdemon='" + kode + "'",
                        "kd_numdemon='" + kdNumdenom.getText() + "', kd_indikator='" + kdINM + "', no_urut='" + TnoUrut.getText() + "', "
                        + "nm_numdemon='" + TnmNumdenom.getText() + "', status_data='" + stts + "'");
                emptTeks();                
                BtnCariActionPerformed(null);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Silahkan pilih dulu salah satu datanya pada tabel..!!");
                tbMutu.requestFocus();
            }            
        }
}//GEN-LAST:event_BtnGantiActionPerformed

    private void BtnGantiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnGantiKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnGantiActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnBatal, BtnKeluar);
        }
}//GEN-LAST:event_BtnGantiKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
}//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            dispose();
        }else{Valid.pindah(evt,BtnBatal,TCari);}
}//GEN-LAST:event_BtnKeluarKeyPressed

    private void TCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            BtnCariActionPerformed(null);
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
            BtnCari.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            BtnKeluar.requestFocus();
        }
}//GEN-LAST:event_TCariKeyPressed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        tampil();
}//GEN-LAST:event_BtnCariActionPerformed

    private void BtnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            BtnCariActionPerformed(null);
        } else {
            Valid.pindah(evt, TCari, BtnAll);
        }
}//GEN-LAST:event_BtnCariKeyPressed

    private void BtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAllActionPerformed
        TCari.setText("");
        BtnCariActionPerformed(null);
        emptTeks();        
}//GEN-LAST:event_BtnAllActionPerformed

    private void BtnAllKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAllKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            BtnCariActionPerformed(null);
            TCari.setText("");
        } else {
            Valid.pindah(evt, BtnCari, kdNumdenom);
        }
}//GEN-LAST:event_BtnAllKeyPressed

    private void tbMutuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMutuMouseClicked
        if(tabMode.getRowCount()!=0){
            try {
                getData();
            } catch (java.lang.NullPointerException e) {
            }
        }
}//GEN-LAST:event_tbMutuMouseClicked

    private void tbMutuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbMutuKeyPressed
        if(tabMode.getRowCount()!=0){
            if((evt.getKeyCode()==KeyEvent.VK_ENTER)||(evt.getKeyCode()==KeyEvent.VK_UP)||(evt.getKeyCode()==KeyEvent.VK_DOWN)){
                try {
                    getData();
                } catch (java.lang.NullPointerException e) {
                }
            }
        }
}//GEN-LAST:event_tbMutuKeyPressed

    private void ChkInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkInputActionPerformed
        isForm();
    }//GEN-LAST:event_ChkInputActionPerformed

    private void TnoUrutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TnoUrutKeyPressed
        Valid.pindah(evt, TnoUrut, cmbGedung);
    }//GEN-LAST:event_TnoUrutKeyPressed

    private void cmbGedungMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbGedungMouseReleased
        AutoCompleteDecorator.decorate(cmbGedung);
    }//GEN-LAST:event_cmbGedungMouseReleased

    private void cmbGedungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbGedungActionPerformed
        cmbIndikator.removeAllItems();
        Sequel.cariIsiComboDB("SELECT nm_indikator from master_indikator_nasional_mutu "
            + "WHERE gedung='" + cmbGedung.getSelectedItem().toString() + "' and status_data='aktif' order by no_urut", cmbIndikator);
    }//GEN-LAST:event_cmbGedungActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Sequel.cariIsiComboDB("SELECT nm_gedung FROM bangsal WHERE nm_gedung<>'-' and nm_gedung not like '%ar-rau%' and status='1' GROUP BY nm_gedung ORDER BY nm_gedung", cmbGedung);
        tampil();
    }//GEN-LAST:event_formWindowOpened

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            DlgMasterNumdemonINM dialog = new DlgMasterNumdemonINM(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.Button BtnAll;
    private widget.Button BtnBatal;
    private widget.Button BtnCari;
    private widget.Button BtnGanti;
    private widget.Button BtnKeluar;
    private widget.Button BtnSimpan;
    public widget.CekBox ChkInput;
    private widget.PanelBiasa FormInput;
    private widget.Label LCount;
    private javax.swing.JPanel PanelInput;
    private widget.ScrollPane Scroll;
    public widget.TextBox TCari;
    private widget.TextBox TnmNumdenom;
    private widget.TextBox TnoUrut;
    private widget.ComboBox cmbGedung;
    private widget.ComboBox cmbIndikator;
    private widget.ComboBox cmbStatus;
    private widget.InternalFrame internalFrame1;
    private widget.InternalFrame internalFrame2;
    private widget.Label jLabel10;
    private widget.Label jLabel11;
    private widget.Label jLabel12;
    private widget.Label jLabel4;
    private widget.Label jLabel5;
    private widget.Label jLabel6;
    private widget.Label jLabel7;
    private widget.Label jLabel9;
    private javax.swing.JPanel jPanel3;
    private widget.TextBox kdNumdenom;
    private widget.panelisi panelGlass10;
    private widget.panelisi panelGlass8;
    private widget.Table tbMutu;
    // End of variables declaration//GEN-END:variables

    public void tampil() {     
        Valid.tabelKosong(tabMode);
        try {
            ps = koneksi.prepareStatement("SELECT m1.*, m2.kd_indikator, m2.nm_indikator, m2.gedung FROM master_numdemon_indikator_nasional_mutu m1 "
                    +"inner join master_indikator_nasional_mutu m2 on m1.kd_indikator=m2.kd_indikator WHERE "
                    + "m2.kd_indikator like ? or "
                    + "m2.nm_indikator like ? or "
                    + "m1.kd_numdemon like ? or "
                    + "m1.nm_numdemon like ? or "
                    + "m2.gedung like ? or "
                    + "m1.status_data like ? ORDER BY m1.no_urut, m2.gedung");

            try {
                ps.setString(1, "%" + TCari.getText().trim() + "%");
                ps.setString(2, "%" + TCari.getText().trim() + "%");
                ps.setString(3, "%" + TCari.getText().trim() + "%");
                ps.setString(4, "%" + TCari.getText().trim() + "%");
                ps.setString(5, "%" + TCari.getText().trim() + "%");
                ps.setString(6, "%" + TCari.getText().trim() + "%");
                rs = ps.executeQuery();                
                while (rs.next()) {
                    tabMode.addRow(new String[]{                        
                        rs.getString("kd_numdemon"),
                        rs.getString("no_urut"),
                        rs.getString("kd_indikator"),
                        rs.getString("nm_indikator"),
                        rs.getString("nm_numdemon"),
                        rs.getString("gedung"),
                        rs.getString("status_data").toUpperCase()
                    });
                }                
            } catch (Exception e) {
                System.out.println("rekammedis.DlgMasterNumdemonINM.tampil() : " + e);
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            }
        } catch (SQLException e) {
            System.out.println("Notifikasi : " + e);
        }
        LCount.setText("" + tabMode.getRowCount());
    }
    
    public void emptTeks() {
        kdNumdenom.setText(Valid.autoNomer("master_numdemon_indikator_nasional_mutu", "ND", 3));
        TnoUrut.setText("");
        TnoUrut.requestFocus();
        TnmNumdenom.setText("");
        cmbGedung.setSelectedIndex(0);        
        cmbStatus.setSelectedIndex(0);
        kdINM = "";
        stts = "";
    }

    private void getData() {
        kode = "";
        stts = "";
        kdINM = "";
        
        if (tbMutu.getSelectedRow() != -1) {
            kode = tbMutu.getValueAt(tbMutu.getSelectedRow(), 0).toString();
            kdNumdenom.setText(tbMutu.getValueAt(tbMutu.getSelectedRow(), 0).toString());
            TnoUrut.setText(tbMutu.getValueAt(tbMutu.getSelectedRow(), 1).toString());
            kdINM = tbMutu.getValueAt(tbMutu.getSelectedRow(), 2).toString();            
            TnmNumdenom.setText(tbMutu.getValueAt(tbMutu.getSelectedRow(), 4).toString());
            cmbGedung.setSelectedItem(tbMutu.getValueAt(tbMutu.getSelectedRow(), 5).toString());
            cmbIndikator.setSelectedItem(tbMutu.getValueAt(tbMutu.getSelectedRow(), 3).toString());
            
            if (tbMutu.getValueAt(tbMutu.getSelectedRow(), 6).toString().equals("AKTIF")) {
                cmbStatus.setSelectedIndex(0);
            } else {
                cmbStatus.setSelectedIndex(1);
            }
        }
    }
    
    public void isForm(){
        if (ChkInput.isSelected() == true) {
            ChkInput.setVisible(false);
            PanelInput.setPreferredSize(new Dimension(WIDTH, 148));
            FormInput.setVisible(true);
            ChkInput.setVisible(true);
        } else if (ChkInput.isSelected() == false) {
            ChkInput.setVisible(false);
            PanelInput.setPreferredSize(new Dimension(WIDTH, 20));
            FormInput.setVisible(false);
            ChkInput.setVisible(true);
        }
    }
    
    public void isCek() {
        BtnSimpan.setEnabled(akses.getpegawai_admin());
        BtnGanti.setEnabled(akses.getpegawai_admin());
    }
}
