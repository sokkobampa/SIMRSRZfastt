/*
  By Mas Elkhanza
 */

package bridging;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fungsi.WarnaTable;
import fungsi.batasInput;
import fungsi.koneksiDB;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.akses;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.event.DocumentEvent;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

/**
 *
 * @author dosen
 */
public final class SatuSehatKirimProcedure extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    private sekuel Sequel = new sekuel();
    private validasi Valid = new validasi();
    private Connection koneksi = koneksiDB.condb();
    private PreparedStatement ps;
    private ResultSet rs;
    private int i = 0;
    private String link = "", json = "", idpasien = "", idpasienKirim = "";
    private ApiSatuSehat api = new ApiSatuSehat();
    private HttpHeaders headers;
    private HttpEntity requestEntity;
    private ObjectMapper mapper = new ObjectMapper();
    private JsonNode root;
    private JsonNode response;
    private SatuSehatCekNIK cekViaSatuSehat = new SatuSehatCekNIK();
    private StringBuilder htmlContent;   
    
    /** Creates new form DlgKamar
     * @param parent
     * @param modal */
    public SatuSehatKirimProcedure(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocation(10,2);
        setSize(628,674);

        tabMode=new DefaultTableModel(null,new String[]{
                "P","Tgl. Registrasi","No. Rawat","No. RM","Nama Pasien","No. KTP Pasien","Stts Rawat","Stts Lanjut",
                "Tanggal Pulang","ID Encounter","ICD 9","Nama Prosedur","ID Procedure"
            }){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){
                boolean a = false;
                if (colIndex==0) {
                    a=true;
                }
                return a;
             }
             Class[] types = new Class[] {
                 java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, 
                 java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, 
                 java.lang.String.class, java.lang.String.class, java.lang.String.class
             };
             @Override
             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
             }
        };

        tbProsedur.setModel(tabMode);
        tbProsedur.setPreferredScrollableViewportSize(new Dimension(500, 500));
        tbProsedur.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 13; i++) {
            TableColumn column = tbProsedur.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(20);
            } else if (i == 1) {
                column.setPreferredWidth(160);
            } else if (i == 2) {
                column.setPreferredWidth(105);
            } else if (i == 3) {
                column.setPreferredWidth(65);
            } else if (i == 4) {
                column.setPreferredWidth(220);
            } else if (i == 5) {
                column.setPreferredWidth(110);
            } else if (i == 6) {
                column.setPreferredWidth(125);
            } else if (i == 7) {
                column.setPreferredWidth(65);
            } else if (i == 8) {
                column.setPreferredWidth(170);
            } else if (i == 9) {
                column.setPreferredWidth(225);
            } else if (i == 10) {
                column.setPreferredWidth(65);
            } else if (i == 11) {
                column.setPreferredWidth(300);
            } else if (i == 12) {
                column.setPreferredWidth(225);
            }
        }
        tbProsedur.setDefaultRenderer(Object.class, new WarnaTable());
        
        TCari.setDocument(new batasInput((byte)100).getKata(TCari));
        
        if(koneksiDB.cariCepat().equals("aktif")){
            TCari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){
                @Override
                public void insertUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
                @Override
                public void removeUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
                @Override
                public void changedUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
            });
        } 
        
        try {
            link=koneksiDB.URLFHIRSATUSEHAT();
        } catch (Exception e) {
            System.out.println("Notif : "+e);
        }   
        
        HTMLEditorKit kit = new HTMLEditorKit();
        LoadHTML.setEditable(true);
        LoadHTML.setEditorKit(kit);
        StyleSheet styleSheet = kit.getStyleSheet();
        styleSheet.addRule(
                ".isi td{border-right: 1px solid #e2e7dd;font: 8.5px tahoma;height:12px;border-bottom: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"+
                ".isi2 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#323232;}"+
                ".isi3 td{border-right: 1px solid #e2e7dd;font: 8.5px tahoma;height:12px;border-top: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"+
                ".isi4 td{font: 11px tahoma;height:12px;border-top: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"+
                ".isi5 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#AA0000;}"+
                ".isi6 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#FF0000;}"+
                ".isi7 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#C8C800;}"+
                ".isi8 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#00AA00;}"+
                ".isi9 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#969696;}"
        );
        Document doc = kit.createDefaultDocument();
        LoadHTML.setDocument(doc);
    }
    
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        ppPilihSemua = new javax.swing.JMenuItem();
        ppPilihIdProcedureKosong = new javax.swing.JMenuItem();
        ppBersihkan = new javax.swing.JMenuItem();
        LoadHTML = new widget.editorpane();
        internalFrame1 = new widget.InternalFrame();
        Scroll = new widget.ScrollPane();
        tbProsedur = new widget.Table();
        jPanel3 = new javax.swing.JPanel();
        panelGlass8 = new widget.panelisi();
        jLabel7 = new widget.Label();
        LCount = new widget.Label();
        BtnAll = new widget.Button();
        BtnKirim = new widget.Button();
        BtnUpdate = new widget.Button();
        BtnPrint = new widget.Button();
        BtnKeluar = new widget.Button();
        panelGlass9 = new widget.panelisi();
        jLabel15 = new widget.Label();
        DTPCari1 = new widget.Tanggal();
        jLabel17 = new widget.Label();
        DTPCari2 = new widget.Tanggal();
        jLabel18 = new widget.Label();
        cmbData = new widget.ComboBox();
        jLabel16 = new widget.Label();
        TCari = new widget.TextBox();
        BtnCari = new widget.Button();

        jPopupMenu1.setName("jPopupMenu1"); // NOI18N

        ppPilihSemua.setBackground(new java.awt.Color(255, 255, 254));
        ppPilihSemua.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        ppPilihSemua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        ppPilihSemua.setText("Pilih Semua");
        ppPilihSemua.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppPilihSemua.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppPilihSemua.setName("ppPilihSemua"); // NOI18N
        ppPilihSemua.setPreferredSize(new java.awt.Dimension(170, 26));
        ppPilihSemua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppPilihSemuaActionPerformed(evt);
            }
        });
        jPopupMenu1.add(ppPilihSemua);

        ppPilihIdProcedureKosong.setBackground(new java.awt.Color(255, 255, 254));
        ppPilihIdProcedureKosong.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        ppPilihIdProcedureKosong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        ppPilihIdProcedureKosong.setText("Pilih ID Procedure Kosong");
        ppPilihIdProcedureKosong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppPilihIdProcedureKosong.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppPilihIdProcedureKosong.setName("ppPilihIdProcedureKosong"); // NOI18N
        ppPilihIdProcedureKosong.setPreferredSize(new java.awt.Dimension(170, 26));
        ppPilihIdProcedureKosong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppPilihIdProcedureKosongActionPerformed(evt);
            }
        });
        jPopupMenu1.add(ppPilihIdProcedureKosong);

        ppBersihkan.setBackground(new java.awt.Color(255, 255, 254));
        ppBersihkan.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        ppBersihkan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        ppBersihkan.setText("Hilangkan Pilihan");
        ppBersihkan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppBersihkan.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppBersihkan.setName("ppBersihkan"); // NOI18N
        ppBersihkan.setPreferredSize(new java.awt.Dimension(170, 26));
        ppBersihkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppBersihkanActionPerformed(evt);
            }
        });
        jPopupMenu1.add(ppBersihkan);

        LoadHTML.setBorder(null);
        LoadHTML.setName("LoadHTML"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);
        setIconImages(null);
        setUndecorated(true);
        setResizable(false);

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Pengiriman Data Procedure (ICD-9) Satu Sehat ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        internalFrame1.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll.setComponentPopupMenu(jPopupMenu1);
        Scroll.setName("Scroll"); // NOI18N
        Scroll.setOpaque(true);

        tbProsedur.setAutoCreateRowSorter(true);
        tbProsedur.setComponentPopupMenu(jPopupMenu1);
        tbProsedur.setName("tbProsedur"); // NOI18N
        Scroll.setViewportView(tbProsedur);

        internalFrame1.add(Scroll, java.awt.BorderLayout.CENTER);

        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(44, 100));
        jPanel3.setLayout(new java.awt.BorderLayout(1, 1));

        panelGlass8.setName("panelGlass8"); // NOI18N
        panelGlass8.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Record :");
        jLabel7.setName("jLabel7"); // NOI18N
        jLabel7.setPreferredSize(new java.awt.Dimension(53, 23));
        panelGlass8.add(jLabel7);

        LCount.setForeground(new java.awt.Color(0, 0, 0));
        LCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCount.setText("0");
        LCount.setName("LCount"); // NOI18N
        LCount.setPreferredSize(new java.awt.Dimension(60, 23));
        panelGlass8.add(LCount);

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

        BtnKirim.setForeground(new java.awt.Color(0, 0, 0));
        BtnKirim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/34.png"))); // NOI18N
        BtnKirim.setMnemonic('K');
        BtnKirim.setText("Kirim");
        BtnKirim.setToolTipText("Alt+K");
        BtnKirim.setName("BtnKirim"); // NOI18N
        BtnKirim.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKirimActionPerformed(evt);
            }
        });
        panelGlass8.add(BtnKirim);

        BtnUpdate.setForeground(new java.awt.Color(0, 0, 0));
        BtnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/edit_f2.png"))); // NOI18N
        BtnUpdate.setMnemonic('U');
        BtnUpdate.setText("Update");
        BtnUpdate.setToolTipText("Alt+U");
        BtnUpdate.setName("BtnUpdate"); // NOI18N
        BtnUpdate.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnUpdateActionPerformed(evt);
            }
        });
        panelGlass8.add(BtnUpdate);

        BtnPrint.setForeground(new java.awt.Color(0, 0, 0));
        BtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b_print.png"))); // NOI18N
        BtnPrint.setMnemonic('T');
        BtnPrint.setText("Cetak");
        BtnPrint.setToolTipText("Alt+T");
        BtnPrint.setName("BtnPrint"); // NOI18N
        BtnPrint.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
            }
        });
        panelGlass8.add(BtnPrint);

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

        jPanel3.add(panelGlass8, java.awt.BorderLayout.CENTER);

        panelGlass9.setName("panelGlass9"); // NOI18N
        panelGlass9.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Tgl. Registrasi :");
        jLabel15.setName("jLabel15"); // NOI18N
        jLabel15.setPreferredSize(new java.awt.Dimension(85, 23));
        panelGlass9.add(jLabel15);

        DTPCari1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "20-01-2024" }));
        DTPCari1.setDisplayFormat("dd-MM-yyyy");
        DTPCari1.setName("DTPCari1"); // NOI18N
        DTPCari1.setOpaque(false);
        DTPCari1.setPreferredSize(new java.awt.Dimension(95, 23));
        panelGlass9.add(DTPCari1);

        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("s.d.");
        jLabel17.setName("jLabel17"); // NOI18N
        jLabel17.setPreferredSize(new java.awt.Dimension(24, 23));
        panelGlass9.add(jLabel17);

        DTPCari2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "20-01-2024" }));
        DTPCari2.setDisplayFormat("dd-MM-yyyy");
        DTPCari2.setName("DTPCari2"); // NOI18N
        DTPCari2.setOpaque(false);
        DTPCari2.setPreferredSize(new java.awt.Dimension(95, 23));
        panelGlass9.add(DTPCari2);

        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Lihat Data :");
        jLabel18.setName("jLabel18"); // NOI18N
        jLabel18.setPreferredSize(new java.awt.Dimension(70, 23));
        panelGlass9.add(jLabel18);

        cmbData.setForeground(new java.awt.Color(0, 0, 0));
        cmbData.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Semua", "Belum/Gagal", "Berhasil" }));
        cmbData.setName("cmbData"); // NOI18N
        cmbData.setPreferredSize(new java.awt.Dimension(96, 23));
        panelGlass9.add(cmbData);

        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Key Word :");
        jLabel16.setName("jLabel16"); // NOI18N
        jLabel16.setPreferredSize(new java.awt.Dimension(70, 23));
        panelGlass9.add(jLabel16);

        TCari.setForeground(new java.awt.Color(0, 0, 0));
        TCari.setName("TCari"); // NOI18N
        TCari.setPreferredSize(new java.awt.Dimension(210, 23));
        TCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCariKeyPressed(evt);
            }
        });
        panelGlass9.add(TCari);

        BtnCari.setForeground(new java.awt.Color(0, 0, 0));
        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari.setMnemonic('6');
        BtnCari.setText("Tampilkan Data");
        BtnCari.setToolTipText("Alt+6");
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
        panelGlass9.add(BtnCari);

        jPanel3.add(panelGlass9, java.awt.BorderLayout.PAGE_START);

        internalFrame1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
    }//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            dispose();
        }else{Valid.pindah(evt,BtnPrint,BtnKeluar);}
    }//GEN-LAST:event_BtnKeluarKeyPressed

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        try{
            htmlContent = new StringBuilder();
            htmlContent.append(                             
                "<tr class='isi'>"+
                    "<td valign='middle' bgcolor='#FFFAFA' align='center'><b>Tanggal Registrasi</b></td>"+
                    "<td valign='middle' bgcolor='#FFFAFA' align='center'><b>No.Rawat</b></td>"+
                    "<td valign='middle' bgcolor='#FFFAFA' align='center'><b>No.RM</b></td>"+
                    "<td valign='middle' bgcolor='#FFFAFA' align='center'><b>Nama Pasien</b></td>"+
                    "<td valign='middle' bgcolor='#FFFAFA' align='center'><b>No.KTP Pasien</b></td>"+
                    "<td valign='middle' bgcolor='#FFFAFA' align='center'><b>Stts Rawat</b></td>"+
                    "<td valign='middle' bgcolor='#FFFAFA' align='center'><b>Stts Lanjut</b></td>"+
                    "<td valign='middle' bgcolor='#FFFAFA' align='center'><b>Tanggal Pulang</b></td>"+
                    "<td valign='middle' bgcolor='#FFFAFA' align='center'><b>ID Encounter</b></td>"+
                    "<td valign='middle' bgcolor='#FFFAFA' align='center'><b>ICD 9</b></td>"+
                    "<td valign='middle' bgcolor='#FFFAFA' align='center'><b>Nama Prosedur</b></td>"+
                    "<td valign='middle' bgcolor='#FFFAFA' align='center'><b>ID Procedure</b></td>"+
                "</tr>"
            );
            for (i = 0; i < tabMode.getRowCount(); i++) {
                htmlContent.append(
                    "<tr class='isi'>"+
                        "<td valign='top'>"+tbProsedur.getValueAt(i,1).toString()+"</td>"+
                        "<td valign='top'>"+tbProsedur.getValueAt(i,2).toString()+"</td>"+
                        "<td valign='top'>"+tbProsedur.getValueAt(i,3).toString()+"</td>"+
                        "<td valign='top'>"+tbProsedur.getValueAt(i,4).toString()+"</td>"+
                        "<td valign='top'>"+tbProsedur.getValueAt(i,5).toString()+"</td>"+
                        "<td valign='top'>"+tbProsedur.getValueAt(i,6).toString()+"</td>"+
                        "<td valign='top'>"+tbProsedur.getValueAt(i,7).toString()+"</td>"+
                        "<td valign='top'>"+tbProsedur.getValueAt(i,8).toString()+"</td>"+
                        "<td valign='top'>"+tbProsedur.getValueAt(i,9).toString()+"</td>"+
                        "<td valign='top'>"+tbProsedur.getValueAt(i,10).toString()+"</td>"+
                        "<td valign='top'>"+tbProsedur.getValueAt(i,11).toString()+"</td>"+
                        "<td valign='top'>"+tbProsedur.getValueAt(i,12).toString()+"</td>"+
                    "</tr>");
            }
            LoadHTML.setText(
                "<html>"+
                  "<table width='100%' border='0' align='center' cellpadding='1px' cellspacing='0' class='tbl_form'>"+
                   htmlContent.toString()+
                  "</table>"+
                "</html>"
            );

            File g = new File("file2.css");            
            BufferedWriter bg = new BufferedWriter(new FileWriter(g));
            bg.write(
                ".isi td{border-right: 1px solid #e2e7dd;font: 8.5px tahoma;height:12px;border-bottom: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"+
                ".isi2 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#323232;}"+
                ".isi3 td{border-right: 1px solid #e2e7dd;font: 8.5px tahoma;height:12px;border-top: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"+
                ".isi4 td{font: 11px tahoma;height:12px;border-top: 1px solid #e2e7dd;background: #ffffff;color:#323232;}"+
                ".isi5 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#AA0000;}"+
                ".isi6 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#FF0000;}"+
                ".isi7 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#C8C800;}"+
                ".isi8 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#00AA00;}"+
                ".isi9 td{font: 8.5px tahoma;border:none;height:12px;background: #ffffff;color:#969696;}"
            );
            bg.close();

            File f = new File("DataSatuSehatProcedure.html");            
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));            
            bw.write(LoadHTML.getText().replaceAll("<head>","<head>"+
                        "<link href=\"file2.css\" rel=\"stylesheet\" type=\"text/css\" />"+
                        "<table width='100%' border='0' align='center' cellpadding='3px' cellspacing='0' class='tbl_form'>"+
                            "<tr class='isi2'>"+
                                "<td valign='top' align='center'>"+
                                    "<font size='4' face='Tahoma'>"+akses.getnamars()+"</font><br>"+
                                    akses.getalamatrs()+", "+akses.getkabupatenrs()+", "+akses.getpropinsirs()+"<br>"+
                                    akses.getkontakrs()+", E-mail : "+akses.getemailrs()+"<br><br>"+
                                    "<font size='2' face='Tahoma'>DATA PENGIRIMAN SATU SEHAT PROCEDURE<br><br></font>"+        
                                "</td>"+
                           "</tr>"+
                        "</table>")
            );
            bw.close();                         
            Desktop.getDesktop().browse(f.toURI());
        }catch(Exception e){
            System.out.println("Notifikasi : "+e);
        }
        this.setCursor(Cursor.getDefaultCursor());   
    }//GEN-LAST:event_BtnPrintActionPerformed

    private void TCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            BtnCariActionPerformed(null);
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
            BtnCariActionPerformed(null);
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            BtnKeluar.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            tbProsedur.requestFocus();
        }
    }//GEN-LAST:event_TCariKeyPressed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        tampil();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnCariActionPerformed

    private void BtnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnCariActionPerformed(null);
        }else{
            Valid.pindah(evt,TCari,BtnPrint);
        }
    }//GEN-LAST:event_BtnCariKeyPressed

    private void BtnKirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKirimActionPerformed
        cekIdPasien();
        for (i = 0; i < tbProsedur.getRowCount(); i++) {
            if (tbProsedur.getValueAt(i, 0).toString().equals("true") 
                    && (!tbProsedur.getValueAt(i, 5).toString().equals("")) 
                    && (!tbProsedur.getValueAt(i, 9).toString().equals("")) 
                    && tbProsedur.getValueAt(i, 12).toString().equals("")) {
                try {
                    idpasienKirim = Sequel.cariIsi("select id_pasien from satu_sehat_mapping_pasien where no_rkm_medis='" + tbProsedur.getValueAt(i, 3).toString() + "'");
                    try {
                        headers = new HttpHeaders();
                        headers.setContentType(MediaType.APPLICATION_JSON);
                        headers.add("Authorization", "Bearer " + api.TokenSatuSehat());
                        json = "{" +
                                    "\"resourceType\": \"Procedure\"," +
                                    "\"status\": \"completed\","+
                                    "\"category\": {" +
                                        "\"coding\": [" +
                                            "{" +
                                                "\"system\": \"http://snomed.info/sct\"," +
                                                "\"code\": \"103693007\"," +
                                                "\"display\": \"Diagnostic procedure\"" +
                                            "}" +
                                        "]," +
                                        "\"text\":\"Diagnostic procedure\""+
                                    "}," +
                                    "\"code\": {" +
                                        "\"coding\": [" +
                                            "{" +
                                                "\"system\": \"http://hl7.org/fhir/sid/icd-9-cm\"," +
                                                "\"code\": \""+tbProsedur.getValueAt(i,10).toString()+"\"," +
                                                "\"display\": \""+tbProsedur.getValueAt(i,11).toString()+"\"" +
                                            "}" +
                                        "]" +
                                    "}," +
                                    "\"subject\": {" +
                                        "\"reference\": \"Patient/"+idpasienKirim+"\"," +
                                        "\"display\": \""+tbProsedur.getValueAt(i,4).toString()+"\"" +
                                    "}," +
                                    "\"encounter\": {" +
                                        "\"reference\": \"Encounter/"+tbProsedur.getValueAt(i,9).toString()+"\"," +
                                        "\"display\": \"Prosedur "+tbProsedur.getValueAt(i,4).toString()+" selama kunjungan/dirawat dari tanggal "+tbProsedur.getValueAt(i,1).toString()+" sampai "+tbProsedur.getValueAt(i,8).toString()+"\"" +
                                    "}," +
                                    "\"performedPeriod\": {" +
                                        "\"start\": \""+tbProsedur.getValueAt(i,1).toString()+"\","+
                                        "\"end\": \""+tbProsedur.getValueAt(i,8).toString()+"\""+
                                    "}"+
                                "}";
                        System.out.println("URL : " + link + "/Procedure");
                        System.out.println("Request JSON : " + json);
                        requestEntity = new HttpEntity(json, headers);
                        json = api.getRest().exchange(link + "/Procedure", HttpMethod.POST, requestEntity, String.class).getBody();
                        System.out.println("Result JSON : " + json);
                        root = mapper.readTree(json);
                        response = root.path("id");
                        if (!response.asText().equals("")) {
                            Sequel.menyimpanPesanGagalnyaDiTerminal("satu_sehat_procedure", "?,?,?,?", "Prosedur", 4, new String[]{
                                tbProsedur.getValueAt(i, 2).toString(), tbProsedur.getValueAt(i, 10).toString(), tbProsedur.getValueAt(i, 7).toString(), response.asText()
                            });
                        }
                    } catch (Exception e) {
                        System.out.println("Notifikasi Bridging : " + e);
                    }
                } catch (Exception e) {
                    System.out.println("Notifikasi : " + e);
                }
            }
        }
        tampil();
    }//GEN-LAST:event_BtnKirimActionPerformed

    private void ppPilihSemuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppPilihSemuaActionPerformed
        for (i = 0; i < tbProsedur.getRowCount(); i++) {
            tbProsedur.setValueAt(true, i, 0);
        }
    }//GEN-LAST:event_ppPilihSemuaActionPerformed

    private void ppBersihkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppBersihkanActionPerformed
        for (i = 0; i < tbProsedur.getRowCount(); i++) {
            tbProsedur.setValueAt(false, i, 0);
        }
    }//GEN-LAST:event_ppBersihkanActionPerformed

    private void BtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnUpdateActionPerformed
        cekIdPasien();
        for (i = 0; i < tbProsedur.getRowCount(); i++) {
            if (tbProsedur.getValueAt(i, 0).toString().equals("true") 
                    && (!tbProsedur.getValueAt(i, 5).toString().equals("")) 
                    && (!tbProsedur.getValueAt(i, 9).toString().equals("")) 
                    && (!tbProsedur.getValueAt(i, 12).toString().equals(""))) {
                try {
                    idpasienKirim = Sequel.cariIsi("select id_pasien from satu_sehat_mapping_pasien where no_rkm_medis='" + tbProsedur.getValueAt(i, 3).toString() + "'");
                    try {
                        headers = new HttpHeaders();
                        headers.setContentType(MediaType.APPLICATION_JSON);
                        headers.add("Authorization", "Bearer " + api.TokenSatuSehat());
                        json = "{" +
                                    "\"resourceType\": \"Procedure\"," +
                                    "\"id\": \""+tbProsedur.getValueAt(i,12).toString()+"\"," +
                                    "\"status\": \"completed\","+
                                    "\"category\": {" +
                                        "\"coding\": [" +
                                            "{" +
                                                "\"system\": \"http://snomed.info/sct\"," +
                                                "\"code\": \"103693007\"," +
                                                "\"display\": \"Diagnostic procedure\"" +
                                            "}" +
                                        "]," +
                                        "\"text\":\"Diagnostic procedure\""+
                                    "}," +
                                    "\"code\": {" +
                                        "\"coding\": [" +
                                            "{" +
                                                "\"system\": \"http://hl7.org/fhir/sid/icd-9-cm\"," +
                                                "\"code\": \""+tbProsedur.getValueAt(i,10).toString()+"\"," +
                                                "\"display\": \""+tbProsedur.getValueAt(i,11).toString()+"\"" +
                                            "}" +
                                        "]" +
                                    "}," +
                                    "\"subject\": {" +
                                        "\"reference\": \"Patient/"+idpasienKirim+"\"," +
                                        "\"display\": \""+tbProsedur.getValueAt(i,4).toString()+"\"" +
                                    "}," +
                                    "\"encounter\": {" +
                                        "\"reference\": \"Encounter/"+tbProsedur.getValueAt(i,9).toString()+"\"," +
                                        "\"display\": \"Prosedur "+tbProsedur.getValueAt(i,4).toString()+" selama kunjungan/dirawat dari tanggal "+tbProsedur.getValueAt(i,1).toString()+" sampai "+tbProsedur.getValueAt(i,8).toString()+"\"" +
                                    "}," +
                                    "\"performedPeriod\": {" +
                                        "\"start\": \""+tbProsedur.getValueAt(i,1).toString()+"\","+
                                        "\"end\": \""+tbProsedur.getValueAt(i,8).toString()+"\""+
                                    "}"+
                                "}";
                        System.out.println("URL : " + link + "/Procedure/" + tbProsedur.getValueAt(i, 12).toString());
                        System.out.println("Request JSON : " + json);
                        requestEntity = new HttpEntity(json, headers);
                        json = api.getRest().exchange(link + "/Procedure/" + tbProsedur.getValueAt(i, 12).toString(), HttpMethod.PUT, requestEntity, String.class).getBody();
                        System.out.println("Result JSON : " + json);
                    } catch (Exception e) {
                        System.out.println("Notifikasi Bridging : " + e);
                    }
                } catch (Exception e) {
                    System.out.println("Notifikasi : " + e);
                }
            }
        }
        tampil();
    }//GEN-LAST:event_BtnUpdateActionPerformed

    private void BtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAllActionPerformed
        TCari.setText("");
        tampil();
    }//GEN-LAST:event_BtnAllActionPerformed

    private void BtnAllKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAllKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            TCari.setText("");
            tampil();
        } else {
            Valid.pindah(evt, BtnPrint, BtnKeluar);
        }
    }//GEN-LAST:event_BtnAllKeyPressed

    private void ppPilihIdProcedureKosongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppPilihIdProcedureKosongActionPerformed
        for (i = 0; i < tbProsedur.getRowCount(); i++) {
            if (tbProsedur.getValueAt(i, 12).equals("")) {
                tbProsedur.setValueAt(true, i, 0);
            }
        }
    }//GEN-LAST:event_ppPilihIdProcedureKosongActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            SatuSehatKirimProcedure dialog = new SatuSehatKirimProcedure(new javax.swing.JFrame(), true);
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
    private widget.Button BtnCari;
    private widget.Button BtnKeluar;
    private widget.Button BtnKirim;
    private widget.Button BtnPrint;
    private widget.Button BtnUpdate;
    private widget.Tanggal DTPCari1;
    private widget.Tanggal DTPCari2;
    private widget.Label LCount;
    private widget.editorpane LoadHTML;
    private widget.ScrollPane Scroll;
    private widget.TextBox TCari;
    private widget.ComboBox cmbData;
    private widget.InternalFrame internalFrame1;
    private widget.Label jLabel15;
    private widget.Label jLabel16;
    private widget.Label jLabel17;
    private widget.Label jLabel18;
    private widget.Label jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private widget.panelisi panelGlass8;
    private widget.panelisi panelGlass9;
    private javax.swing.JMenuItem ppBersihkan;
    private javax.swing.JMenuItem ppPilihIdProcedureKosong;
    private javax.swing.JMenuItem ppPilihSemua;
    private widget.Table tbProsedur;
    // End of variables declaration//GEN-END:variables
    
    private void tampil() {
        Valid.tabelKosong(tabMode);
        try {
            if (cmbData.getSelectedIndex() == 0) {
                ps = koneksi.prepareStatement(
                        "SELECT rp.tgl_registrasi, rp.jam_reg, rp.no_rawat, rp.no_rkm_medis, p.nm_pasien, p.no_ktp, rp.stts, rp.status_lanjut, "
                        + "concat(rp.tgl_registrasi,'T',ADDTIME(rp.jam_reg,'02:00:00'),'+08:00') pulang, se.id_encounter, pp.kode, "
                        + "i.deskripsi_panjang, ifnull(ss.id_procedure,'') id_procedure FROM reg_periksa rp INNER JOIN pasien p ON rp.no_rkm_medis = p.no_rkm_medis "
                        + "INNER JOIN satu_sehat_encounter se ON se.no_rawat = rp.no_rawat INNER JOIN prosedur_pasien pp ON pp.no_rawat = rp.no_rawat "
                        + "INNER JOIN icd9 i ON pp.kode = i.kode LEFT JOIN satu_sehat_procedure ss ON ss.no_rawat = pp.no_rawat AND ss.kode = pp.kode AND ss.STATUS = pp.STATUS "
                        + "where (p.no_ktp<>'' or p.no_ktp<>'0' or p.no_ktp<>'-') and rp.tgl_registrasi between ? and ? "
                        + (TCari.getText().equals("") ? "" : "and (rp.no_rawat like ? or rp.no_rkm_medis like ? or "
                        + "p.nm_pasien like ? or p.no_ktp like ? or pp.kode like ? or i.deskripsi_panjang like ? or "
                        + "rp.stts like ? or rp.status_lanjut like ?)") + " order by rp.tgl_registrasi,rp.jam_reg,rp.no_rawat,pp.prioritas");
            } else if (cmbData.getSelectedIndex() == 1) {
                ps = koneksi.prepareStatement(
                        "SELECT rp.tgl_registrasi, rp.jam_reg, rp.no_rawat, rp.no_rkm_medis, p.nm_pasien, p.no_ktp, rp.stts, rp.status_lanjut, "
                        + "concat(rp.tgl_registrasi,'T',ADDTIME(rp.jam_reg,'02:00:00'),'+08:00') pulang, se.id_encounter, pp.kode, "
                        + "i.deskripsi_panjang, ifnull(ss.id_procedure,'') id_procedure FROM reg_periksa rp INNER JOIN pasien p ON rp.no_rkm_medis = p.no_rkm_medis "
                        + "INNER JOIN satu_sehat_encounter se ON se.no_rawat = rp.no_rawat INNER JOIN prosedur_pasien pp ON pp.no_rawat = rp.no_rawat "
                        + "INNER JOIN icd9 i ON pp.kode = i.kode LEFT JOIN satu_sehat_procedure ss ON ss.no_rawat = pp.no_rawat AND ss.kode = pp.kode AND ss.STATUS = pp.STATUS "
                        + "where (p.no_ktp<>'' or p.no_ktp<>'0' or p.no_ktp<>'-') and (ss.id_procedure is null or ss.id_procedure='') and rp.tgl_registrasi between ? and ? "
                        + (TCari.getText().equals("") ? "" : "and (rp.no_rawat like ? or rp.no_rkm_medis like ? or "
                        + "p.nm_pasien like ? or p.no_ktp like ? or pp.kode like ? or i.deskripsi_panjang like ? or "
                        + "rp.stts like ? or rp.status_lanjut like ?)") + " order by rp.tgl_registrasi,rp.jam_reg,rp.no_rawat,pp.prioritas");
            } else if (cmbData.getSelectedIndex() == 2) {
                ps = koneksi.prepareStatement(
                        "SELECT rp.tgl_registrasi, rp.jam_reg, rp.no_rawat, rp.no_rkm_medis, p.nm_pasien, p.no_ktp, rp.stts, rp.status_lanjut, "
                        + "concat(rp.tgl_registrasi,'T',ADDTIME(rp.jam_reg,'02:00:00'),'+08:00') pulang, se.id_encounter, pp.kode, "
                        + "i.deskripsi_panjang, ifnull(ss.id_procedure,'') id_procedure FROM reg_periksa rp INNER JOIN pasien p ON rp.no_rkm_medis = p.no_rkm_medis "
                        + "INNER JOIN satu_sehat_encounter se ON se.no_rawat = rp.no_rawat INNER JOIN prosedur_pasien pp ON pp.no_rawat = rp.no_rawat "
                        + "INNER JOIN icd9 i ON pp.kode = i.kode LEFT JOIN satu_sehat_procedure ss ON ss.no_rawat = pp.no_rawat AND ss.kode = pp.kode AND ss.STATUS = pp.STATUS "
                        + "where (p.no_ktp<>'' or p.no_ktp<>'0' or p.no_ktp<>'-') and ss.id_procedure<>'' and rp.tgl_registrasi between ? and ? "
                        + (TCari.getText().equals("") ? "" : "and (rp.no_rawat like ? or rp.no_rkm_medis like ? or "
                        + "p.nm_pasien like ? or p.no_ktp like ? or pp.kode like ? or i.deskripsi_panjang like ? or "
                        + "rp.stts like ? or rp.status_lanjut like ?)") + " order by rp.tgl_registrasi,rp.jam_reg,rp.no_rawat,pp.prioritas");
            }
            
            try {
                ps.setString(1, Valid.SetTgl(DTPCari1.getSelectedItem() + ""));
                ps.setString(2, Valid.SetTgl(DTPCari2.getSelectedItem() + ""));
                if (!TCari.getText().equals("")) {
                    ps.setString(3, "%" + TCari.getText() + "%");
                    ps.setString(4, "%" + TCari.getText() + "%");
                    ps.setString(5, "%" + TCari.getText() + "%");
                    ps.setString(6, "%" + TCari.getText() + "%");
                    ps.setString(7, "%" + TCari.getText() + "%");
                    ps.setString(8, "%" + TCari.getText() + "%");
                    ps.setString(9, "%" + TCari.getText() + "%");
                    ps.setString(10, "%" + TCari.getText() + "%");
                }
                rs = ps.executeQuery();
                while (rs.next()) {
                    tabMode.addRow(new Object[]{
                        false, rs.getString("tgl_registrasi") + "T" + rs.getString("jam_reg") + "+08:00", rs.getString("no_rawat"), rs.getString("no_rkm_medis"), rs.getString("nm_pasien"),
                        rs.getString("no_ktp"), rs.getString("stts"), rs.getString("status_lanjut"), rs.getString("pulang"), rs.getString("id_encounter"), rs.getString("kode"),
                        rs.getString("deskripsi_panjang"), rs.getString("id_procedure")
                    });
                }
            } catch (Exception e) {
                System.out.println("Notif : " + e);
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            }

            if (cmbData.getSelectedIndex() == 0) {
                ps = koneksi.prepareStatement(
                        "SELECT rp.tgl_registrasi, rp.jam_reg, rp.no_rawat, rp.no_rkm_medis, p.nm_pasien, p.no_ktp, rp.stts, rp.status_lanjut, concat(ki.tgl_keluar,'T',ki.jam_keluar,'+08:00') pulang, "
                        + "se.id_encounter, pp.kode, i.deskripsi_panjang, ifnull(ss.id_procedure,'') id_procedure FROM reg_periksa rp INNER JOIN pasien p ON rp.no_rkm_medis = p.no_rkm_medis "
                        + "INNER JOIN kamar_inap ki on ki.no_rawat=rp.no_rawat INNER JOIN satu_sehat_encounter se ON se.no_rawat = rp.no_rawat "
                        + "INNER JOIN prosedur_pasien pp ON pp.no_rawat = rp.no_rawat INNER JOIN icd9 i ON pp.kode = i.kode "
                        + "LEFT JOIN satu_sehat_procedure ss ON ss.no_rawat = pp.no_rawat AND ss.kode = pp.kode AND ss.STATUS = pp.STATUS "
                        + "where (p.no_ktp<>'' or p.no_ktp<>'0' or p.no_ktp<>'-') and ki.stts_pulang not in ('-','Pindah Kamar') and rp.tgl_registrasi between ? and ? "
                        + (TCari.getText().equals("") ? "" : "and (rp.no_rawat like ? or rp.no_rkm_medis like ? or "
                        + "p.nm_pasien like ? or p.no_ktp like ? or pp.kode like ? or i.deskripsi_panjang like ? or "
                        + "rp.stts like ? or rp.status_lanjut like ?)") + " order by rp.tgl_registrasi,rp.jam_reg,rp.no_rawat,pp.prioritas");
            } else if (cmbData.getSelectedIndex() == 1) {
                ps = koneksi.prepareStatement(
                        "SELECT rp.tgl_registrasi, rp.jam_reg, rp.no_rawat, rp.no_rkm_medis, p.nm_pasien, p.no_ktp, rp.stts, rp.status_lanjut, concat(ki.tgl_keluar,'T',ki.jam_keluar,'+08:00') pulang, "
                        + "se.id_encounter, pp.kode, i.deskripsi_panjang, ifnull(ss.id_procedure,'') id_procedure FROM reg_periksa rp INNER JOIN pasien p ON rp.no_rkm_medis = p.no_rkm_medis "
                        + "INNER JOIN kamar_inap ki on ki.no_rawat=rp.no_rawat INNER JOIN satu_sehat_encounter se ON se.no_rawat = rp.no_rawat "
                        + "INNER JOIN prosedur_pasien pp ON pp.no_rawat = rp.no_rawat INNER JOIN icd9 i ON pp.kode = i.kode "
                        + "LEFT JOIN satu_sehat_procedure ss ON ss.no_rawat = pp.no_rawat AND ss.kode = pp.kode AND ss.STATUS = pp.STATUS "
                        + "where (p.no_ktp<>'' or p.no_ktp<>'0' or p.no_ktp<>'-') and (ss.id_procedure is null or ss.id_procedure='') and ki.stts_pulang not in ('-','Pindah Kamar') and rp.tgl_registrasi between ? and ? "
                        + (TCari.getText().equals("") ? "" : "and (rp.no_rawat like ? or rp.no_rkm_medis like ? or "
                        + "p.nm_pasien like ? or p.no_ktp like ? or pp.kode like ? or i.deskripsi_panjang like ? or "
                        + "rp.stts like ? or rp.status_lanjut like ?)") + " order by rp.tgl_registrasi,rp.jam_reg,rp.no_rawat,pp.prioritas");
            } else if (cmbData.getSelectedIndex() == 2) {
                ps = koneksi.prepareStatement(
                        "SELECT rp.tgl_registrasi, rp.jam_reg, rp.no_rawat, rp.no_rkm_medis, p.nm_pasien, p.no_ktp, rp.stts, rp.status_lanjut, concat(ki.tgl_keluar,'T',ki.jam_keluar,'+08:00') pulang, "
                        + "se.id_encounter, pp.kode, i.deskripsi_panjang, ifnull(ss.id_procedure,'') id_procedure FROM reg_periksa rp INNER JOIN pasien p ON rp.no_rkm_medis = p.no_rkm_medis "
                        + "INNER JOIN kamar_inap ki on ki.no_rawat=rp.no_rawat INNER JOIN satu_sehat_encounter se ON se.no_rawat = rp.no_rawat "
                        + "INNER JOIN prosedur_pasien pp ON pp.no_rawat = rp.no_rawat INNER JOIN icd9 i ON pp.kode = i.kode "
                        + "LEFT JOIN satu_sehat_procedure ss ON ss.no_rawat = pp.no_rawat AND ss.kode = pp.kode AND ss.STATUS = pp.STATUS "
                        + "where (p.no_ktp<>'' or p.no_ktp<>'0' or p.no_ktp<>'-') and ss.id_procedure<>'' and ki.stts_pulang not in ('-','Pindah Kamar') and rp.tgl_registrasi between ? and ? "
                        + (TCari.getText().equals("") ? "" : "and (rp.no_rawat like ? or rp.no_rkm_medis like ? or "
                        + "p.nm_pasien like ? or p.no_ktp like ? or pp.kode like ? or i.deskripsi_panjang like ? or "
                        + "rp.stts like ? or rp.status_lanjut like ?)") + " order by rp.tgl_registrasi,rp.jam_reg,rp.no_rawat,pp.prioritas");
            }
            
            try {
                ps.setString(1, Valid.SetTgl(DTPCari1.getSelectedItem() + ""));
                ps.setString(2, Valid.SetTgl(DTPCari2.getSelectedItem() + ""));
                if (!TCari.getText().equals("")) {
                    ps.setString(3, "%" + TCari.getText() + "%");
                    ps.setString(4, "%" + TCari.getText() + "%");
                    ps.setString(5, "%" + TCari.getText() + "%");
                    ps.setString(6, "%" + TCari.getText() + "%");
                    ps.setString(7, "%" + TCari.getText() + "%");
                    ps.setString(8, "%" + TCari.getText() + "%");
                    ps.setString(9, "%" + TCari.getText() + "%");
                    ps.setString(10, "%" + TCari.getText() + "%");
                }
                rs = ps.executeQuery();
                while (rs.next()) {
                    tabMode.addRow(new Object[]{
                        false, rs.getString("tgl_registrasi") + "T" + rs.getString("jam_reg") + "+08:00", rs.getString("no_rawat"), rs.getString("no_rkm_medis"), rs.getString("nm_pasien"),
                        rs.getString("no_ktp"), rs.getString("stts"), rs.getString("status_lanjut"), rs.getString("pulang"), rs.getString("id_encounter"), rs.getString("kode"),
                        rs.getString("deskripsi_panjang"), rs.getString("id_procedure")
                    });
                }
            } catch (Exception e) {
                System.out.println("Notif : " + e);
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Notifikasi : " + e);
        }
        LCount.setText("" + tabMode.getRowCount());
    }

    public void isCek(){
        BtnKirim.setEnabled(akses.getsatu_sehat());
        BtnPrint.setEnabled(akses.getsatu_sehat());
    }
    
    private void cekIdPasien() {
        idpasien = "";
        try {
            for (i = 0; i < tbProsedur.getRowCount(); i++) {
                if (tbProsedur.getValueAt(i, 0).toString().equals("true")
                        && (!tbProsedur.getValueAt(i, 5).toString().equals("")
                        || tbProsedur.getValueAt(i, 5).toString().length() == 16)) {

                    idpasien = cekViaSatuSehat.tampilIDPasien(tbProsedur.getValueAt(i, 5).toString());
                    if (!idpasien.equals("")) {
                        if (Sequel.cariInteger("select count(-1) from satu_sehat_mapping_pasien where no_rkm_medis='" + tbProsedur.getValueAt(i, 3).toString() + "'") == 0) {
                            Sequel.menyimpan("satu_sehat_mapping_pasien", "?,?", "No. Rekam Medis", 2, new String[]{
                                tbProsedur.getValueAt(i, 3).toString(), idpasien
                            });
                        } else {
                            if (Sequel.cariIsi("select id_pasien from satu_sehat_mapping_pasien where no_rkm_medis='" + tbProsedur.getValueAt(i, 3).toString() + "'").equals("")) {
                                Sequel.mengedit("satu_sehat_mapping_pasien", "no_rkm_medis='" + tbProsedur.getValueAt(i, 3).toString() + "'", "id_pasien='" + idpasien + "'");
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Notifikasi : " + e);
        }
    }
}
