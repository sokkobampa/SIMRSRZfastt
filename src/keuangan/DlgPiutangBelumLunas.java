

package keuangan;

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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import simrskhanza.DlgPenanggungJawab;

/**
 *
 * @author perpustakaan
 */
public final class DlgPiutangBelumLunas extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    private Connection koneksi=koneksiDB.condb();
    private sekuel Sequel=new sekuel();
    private validasi Valid=new validasi();
    private PreparedStatement ps;
    private ResultSet rs;
    private DlgPenanggungJawab penjab=new DlgPenanggungJawab(null,false);
    private int row=0;
    private String koderekening="";
    private Jurnal jur=new Jurnal();

    /** Creates new form DlgLhtBiaya
     * @param parent
     * @param modal */
    public DlgPiutangBelumLunas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocation(8,1);
        setSize(885,674);

        Object[] rowRwJlDr={
            "P", "No.Rawat/No.tagihan", "Tgl.Piutang", "Pasien", "Status", "Total Piutang",
            "Uang Muka", "Cicilan", "Sisa Piutang", "Jatuh Tempo", "Cara Bayar", "Bayar", "Penjamin Piutang", "Keterangan Penjamin"
        };
        tabMode=new DefaultTableModel(null,rowRwJlDr){
             @Override public boolean isCellEditable(int rowIndex, int colIndex){
                boolean a = false;
                if ((colIndex==11)||(colIndex==0)) {
                    a=true;
                }
                return a;
             }
             Class[] types = new Class[] {
                java.lang.Boolean.class,java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class,
                java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class, java.lang.Object.class
             };
             @Override
             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
             }
        };
        
        tbPiutang.setModel(tabMode);
        tbPiutang.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbPiutang.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < 14; i++) {
            TableColumn column = tbPiutang.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(20);
            } else if (i == 1) {
                column.setPreferredWidth(120);
            } else if (i == 2) {
                column.setPreferredWidth(80);
            } else if (i == 3) {
                column.setPreferredWidth(170);
            } else if (i == 4) {
                column.setPreferredWidth(80);
            } else if (i == 5) {
                column.setPreferredWidth(90);
            } else if (i == 6) {
                column.setPreferredWidth(80);
            } else if (i == 7) {
                column.setPreferredWidth(90);
            } else if (i == 8) {
                column.setPreferredWidth(90);
            } else if (i == 9) {
                column.setPreferredWidth(80);
            } else if (i == 10) {
                column.setPreferredWidth(120);
            } else if (i == 11) {
                column.setPreferredWidth(90);
            } else if (i == 12) {
                column.setPreferredWidth(170);
            } else if (i == 13) {
                column.setPreferredWidth(250);
            }
        }
        tbPiutang.setDefaultRenderer(Object.class, new WarnaTable());

        TKd.setDocument(new batasInput((byte)20).getKata(TKd));
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
        
        penjab.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosing(WindowEvent e) {}
            @Override
            public void windowClosed(WindowEvent e) {
                if(penjab.getTable().getSelectedRow()!= -1){
                    kdpenjab.setText(penjab.getTable().getValueAt(penjab.getTable().getSelectedRow(),1).toString());
                    nmpenjab.setText(penjab.getTable().getValueAt(penjab.getTable().getSelectedRow(),2).toString());
                    tampil();
                }      
                kdpenjab.requestFocus();
            }
            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {penjab.emptTeks();}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });   
        
        penjab.getTable().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_SPACE){
                    penjab.dispose();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });
        
        Valid.loadCombo(nama_bayar,"nama_bayar","akun_bayar");

    }
    

     double sisapiutang=0,cicilan=0;

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TKd = new widget.TextBox();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        MnDetailPiutang = new javax.swing.JMenuItem();
        internalFrame1 = new widget.InternalFrame();
        Scroll = new widget.ScrollPane();
        tbPiutang = new widget.Table();
        panelisi4 = new widget.panelisi();
        label32 = new widget.Label();
        Tanggal = new widget.Tanggal();
        jLabel11 = new widget.Label();
        nama_bayar = new widget.ComboBox();
        jPanel1 = new javax.swing.JPanel();
        panelisi3 = new widget.panelisi();
        label19 = new widget.Label();
        kdpenjab = new widget.TextBox();
        nmpenjab = new widget.TextBox();
        BtnSeek2 = new widget.Button();
        label17 = new widget.Label();
        TCari = new widget.TextBox();
        BtnCari = new widget.Button();
        BtnAll = new widget.Button();
        panelisi1 = new widget.panelisi();
        jLabel10 = new javax.swing.JLabel();
        LCount = new javax.swing.JLabel();
        BtnBayar = new widget.Button();
        BtnPrint = new widget.Button();
        BtnKeluar = new widget.Button();

        TKd.setForeground(new java.awt.Color(255, 255, 255));
        TKd.setName("TKd"); // NOI18N

        jPopupMenu1.setName("jPopupMenu1"); // NOI18N

        MnDetailPiutang.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnDetailPiutang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        MnDetailPiutang.setText("Detail Piutang");
        MnDetailPiutang.setName("MnDetailPiutang"); // NOI18N
        MnDetailPiutang.setPreferredSize(new java.awt.Dimension(250, 28));
        MnDetailPiutang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnDetailPiutangActionPerformed(evt);
            }
        });
        jPopupMenu1.add(MnDetailPiutang);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3), "::[ Data Piutang Belum Lunas ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll.setComponentPopupMenu(jPopupMenu1);
        Scroll.setName("Scroll"); // NOI18N
        Scroll.setOpaque(true);

        tbPiutang.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbPiutang.setComponentPopupMenu(jPopupMenu1);
        tbPiutang.setName("tbPiutang"); // NOI18N
        tbPiutang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPiutangMouseClicked(evt);
            }
        });
        tbPiutang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbPiutangKeyPressed(evt);
            }
        });
        Scroll.setViewportView(tbPiutang);

        internalFrame1.add(Scroll, java.awt.BorderLayout.CENTER);

        panelisi4.setName("panelisi4"); // NOI18N
        panelisi4.setPreferredSize(new java.awt.Dimension(100, 44));
        panelisi4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        label32.setForeground(new java.awt.Color(0, 0, 0));
        label32.setText("Tanggal Bayar :");
        label32.setName("label32"); // NOI18N
        label32.setPreferredSize(new java.awt.Dimension(100, 23));
        panelisi4.add(label32);

        Tanggal.setDisplayFormat("dd-MM-yyyy");
        Tanggal.setName("Tanggal"); // NOI18N
        Tanggal.setPreferredSize(new java.awt.Dimension(100, 23));
        Tanggal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TanggalKeyPressed(evt);
            }
        });
        panelisi4.add(Tanggal);

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Akun Bayar :");
        jLabel11.setName("jLabel11"); // NOI18N
        jLabel11.setPreferredSize(new java.awt.Dimension(150, 23));
        panelisi4.add(jLabel11);

        nama_bayar.setForeground(new java.awt.Color(0, 0, 0));
        nama_bayar.setName("nama_bayar"); // NOI18N
        nama_bayar.setPreferredSize(new java.awt.Dimension(265, 23));
        nama_bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nama_bayarKeyPressed(evt);
            }
        });
        panelisi4.add(nama_bayar);

        internalFrame1.add(panelisi4, java.awt.BorderLayout.PAGE_START);

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(816, 100));
        jPanel1.setLayout(new java.awt.BorderLayout(1, 1));

        panelisi3.setName("panelisi3"); // NOI18N
        panelisi3.setPreferredSize(new java.awt.Dimension(100, 44));
        panelisi3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 4, 9));

        label19.setForeground(new java.awt.Color(0, 0, 0));
        label19.setText("Cara Bayar :");
        label19.setName("label19"); // NOI18N
        label19.setPreferredSize(new java.awt.Dimension(75, 23));
        panelisi3.add(label19);

        kdpenjab.setEditable(false);
        kdpenjab.setForeground(new java.awt.Color(0, 0, 0));
        kdpenjab.setName("kdpenjab"); // NOI18N
        kdpenjab.setPreferredSize(new java.awt.Dimension(60, 23));
        panelisi3.add(kdpenjab);

        nmpenjab.setEditable(false);
        nmpenjab.setForeground(new java.awt.Color(0, 0, 0));
        nmpenjab.setName("nmpenjab"); // NOI18N
        nmpenjab.setPreferredSize(new java.awt.Dimension(170, 23));
        panelisi3.add(nmpenjab);

        BtnSeek2.setForeground(new java.awt.Color(0, 0, 0));
        BtnSeek2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnSeek2.setMnemonic('3');
        BtnSeek2.setToolTipText("Alt+3");
        BtnSeek2.setName("BtnSeek2"); // NOI18N
        BtnSeek2.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnSeek2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeek2ActionPerformed(evt);
            }
        });
        BtnSeek2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnSeek2KeyPressed(evt);
            }
        });
        panelisi3.add(BtnSeek2);

        label17.setForeground(new java.awt.Color(0, 0, 0));
        label17.setText("Key Word :");
        label17.setName("label17"); // NOI18N
        label17.setPreferredSize(new java.awt.Dimension(75, 23));
        panelisi3.add(label17);

        TCari.setForeground(new java.awt.Color(0, 0, 0));
        TCari.setName("TCari"); // NOI18N
        TCari.setPreferredSize(new java.awt.Dimension(150, 23));
        TCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCariKeyPressed(evt);
            }
        });
        panelisi3.add(TCari);

        BtnCari.setForeground(new java.awt.Color(0, 0, 0));
        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari.setMnemonic('2');
        BtnCari.setText("Tampilkan Data");
        BtnCari.setToolTipText("Alt+2");
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
        panelisi3.add(BtnCari);

        BtnAll.setForeground(new java.awt.Color(0, 0, 0));
        BtnAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        BtnAll.setMnemonic('M');
        BtnAll.setText("Semua Data");
        BtnAll.setToolTipText("Alt+M");
        BtnAll.setName("BtnAll"); // NOI18N
        BtnAll.setPreferredSize(new java.awt.Dimension(120, 23));
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
        panelisi3.add(BtnAll);

        jPanel1.add(panelisi3, java.awt.BorderLayout.PAGE_START);

        panelisi1.setName("panelisi1"); // NOI18N
        panelisi1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 0, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Belum Dibayar :");
        jLabel10.setName("jLabel10"); // NOI18N
        jLabel10.setPreferredSize(new java.awt.Dimension(87, 23));
        panelisi1.add(jLabel10);

        LCount.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        LCount.setForeground(new java.awt.Color(153, 0, 51));
        LCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCount.setText("0");
        LCount.setName("LCount"); // NOI18N
        LCount.setPreferredSize(new java.awt.Dimension(250, 23));
        panelisi1.add(LCount);

        BtnBayar.setForeground(new java.awt.Color(0, 0, 0));
        BtnBayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/save-16x16.png"))); // NOI18N
        BtnBayar.setMnemonic('B');
        BtnBayar.setText("Bayar");
        BtnBayar.setToolTipText("Alt+B");
        BtnBayar.setName("BtnBayar"); // NOI18N
        BtnBayar.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBayarActionPerformed(evt);
            }
        });
        BtnBayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnBayarKeyPressed(evt);
            }
        });
        panelisi1.add(BtnBayar);

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
        BtnPrint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnPrintKeyPressed(evt);
            }
        });
        panelisi1.add(BtnPrint);

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
        panelisi1.add(BtnKeluar);

        jPanel1.add(panelisi1, java.awt.BorderLayout.CENTER);

        internalFrame1.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if (tabMode.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis. Tidak ada data yang bisa anda print...!!!!");
            //TCari.requestFocus();
        } else if (tabMode.getRowCount() != 0) {
            Sequel.AutoComitFalse();
            Sequel.queryu("delete from temporary");
            int row = tabMode.getRowCount();
            for (int i = 0; i < row; i++) {
                Sequel.menyimpan("temporary", "'0','"
                        + tabMode.getValueAt(i, 0).toString() + "','"
                        + tabMode.getValueAt(i, 1).toString() + "','"
                        + tabMode.getValueAt(i, 2).toString() + "','"
                        + tabMode.getValueAt(i, 3).toString() + "','"
                        + Valid.SetAngka(Double.parseDouble(tabMode.getValueAt(i, 4).toString())) + "','"
                        + Valid.SetAngka(Double.parseDouble(tabMode.getValueAt(i, 5).toString())) + "','"
                        + Valid.SetAngka(Double.parseDouble(tabMode.getValueAt(i, 6).toString())) + "','"
                        + Valid.SetAngka(Double.parseDouble(tabMode.getValueAt(i, 7).toString())) + "','"
                        + tabMode.getValueAt(i, 8).toString() + "','"
                        + tabMode.getValueAt(i, 12).toString() + "','"
                        + tabMode.getValueAt(i, 13).toString() + "','','','','','','','','','','','','','','','','','','','','','','','','','',''", "Piutang Pasien");
            }
            Sequel.menyimpan("temporary", "'0','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','',''", "Rekap Harian Tindakan Dokter");
            Sequel.menyimpan("temporary", "'0','TOTAL PIUTANG','',':','','','','','" + LCount.getText() + "','','','','','','','','','','','','','','','','','','','','','','','','','','','','',''", "Rekap Harian Tindakan Dokter");
            Sequel.AutoComitTrue();

            Map<String, Object> param = new HashMap<>();
            param.put("namars", akses.getnamars());
            param.put("alamatrs", akses.getalamatrs());
            param.put("kotars", akses.getkabupatenrs());
            param.put("propinsirs", akses.getpropinsirs());
            param.put("kontakrs", akses.getkontakrs());
            param.put("emailrs", akses.getemailrs());
            param.put("logo", Sequel.cariGambar("select logo from setting"));
            Valid.MyReport("rptRPiutangMasuk.jasper", "report", "::[ Rekap Piutang Masuk ]::",
                    "select no, temp1, temp2, temp3, temp4, temp5, temp6, temp7, temp8, temp9, temp10, temp11, temp12, temp13, temp14 from temporary order by no asc", param);
        }
        this.setCursor(Cursor.getDefaultCursor());
}//GEN-LAST:event_BtnPrintActionPerformed

    private void BtnPrintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPrintKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnPrintActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnBayar, BtnAll);
        }
}//GEN-LAST:event_BtnPrintKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
}//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            dispose();
        }else{Valid.pindah(evt,BtnAll,TKd);}
}//GEN-LAST:event_BtnKeluarKeyPressed

    private void BtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAllActionPerformed
        TCari.setText("");
        kdpenjab.setText("");
        nmpenjab.setText("");
        tampil();

}//GEN-LAST:event_BtnAllActionPerformed

    private void BtnAllKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAllKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnAllActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnPrint, BtnKeluar);
        }
}//GEN-LAST:event_BtnAllKeyPressed

    private void tbPiutangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPiutangMouseClicked
        if(tabMode.getRowCount()!=0){
            if(evt.getClickCount()==1){
                if(tbPiutang.getSelectedColumn()==0){
                    if(tbPiutang.getValueAt(tbPiutang.getSelectedRow(),0).toString().equals("true")){
                        tbPiutang.setValueAt(
                                Double.parseDouble(tbPiutang.getValueAt(tbPiutang.getSelectedRow(),5).toString())-
                                (Double.parseDouble(tbPiutang.getValueAt(tbPiutang.getSelectedRow(),6).toString())+
                                Double.parseDouble(tbPiutang.getValueAt(tbPiutang.getSelectedRow(),7).toString())+
                                Double.parseDouble(tbPiutang.getValueAt(tbPiutang.getSelectedRow(),11).toString())),
                                tbPiutang.getSelectedRow(),8);
                    }else if(tbPiutang.getValueAt(tbPiutang.getSelectedRow(),0).toString().equals("false")){
                        tbPiutang.setValueAt(
                                Double.parseDouble(tbPiutang.getValueAt(tbPiutang.getSelectedRow(),5).toString())-
                                (Double.parseDouble(tbPiutang.getValueAt(tbPiutang.getSelectedRow(),6).toString())+
                                Double.parseDouble(tbPiutang.getValueAt(tbPiutang.getSelectedRow(),7).toString())),
                                tbPiutang.getSelectedRow(),8);
                        tbPiutang.setValueAt(
                                Double.parseDouble(tbPiutang.getValueAt(tbPiutang.getSelectedRow(),5).toString())-
                                (Double.parseDouble(tbPiutang.getValueAt(tbPiutang.getSelectedRow(),6).toString())+
                                Double.parseDouble(tbPiutang.getValueAt(tbPiutang.getSelectedRow(),7).toString())),
                                tbPiutang.getSelectedRow(),11);
                    }
                }
                
            }
        }
}//GEN-LAST:event_tbPiutangMouseClicked

    private void tbPiutangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbPiutangKeyPressed
        if(tabMode.getRowCount()!=0){
            if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                    if(tbPiutang.getValueAt(tbPiutang.getSelectedRow(),0).toString().equals("true")){
                        tbPiutang.setValueAt(
                                Double.parseDouble(tbPiutang.getValueAt(tbPiutang.getSelectedRow(),5).toString())-
                                (Double.parseDouble(tbPiutang.getValueAt(tbPiutang.getSelectedRow(),6).toString())+
                                Double.parseDouble(tbPiutang.getValueAt(tbPiutang.getSelectedRow(),7).toString())+
                                Double.parseDouble(tbPiutang.getValueAt(tbPiutang.getSelectedRow(),11).toString())),
                                tbPiutang.getSelectedRow(),8);
                    }else if(tbPiutang.getValueAt(tbPiutang.getSelectedRow(),0).toString().equals("false")){
                        tbPiutang.setValueAt(
                                Double.parseDouble(tbPiutang.getValueAt(tbPiutang.getSelectedRow(),5).toString())-
                                (Double.parseDouble(tbPiutang.getValueAt(tbPiutang.getSelectedRow(),6).toString())+
                                Double.parseDouble(tbPiutang.getValueAt(tbPiutang.getSelectedRow(),7).toString())),
                                tbPiutang.getSelectedRow(),8);
                        tbPiutang.setValueAt(
                                Double.parseDouble(tbPiutang.getValueAt(tbPiutang.getSelectedRow(),5).toString())-
                                (Double.parseDouble(tbPiutang.getValueAt(tbPiutang.getSelectedRow(),6).toString())+
                                Double.parseDouble(tbPiutang.getValueAt(tbPiutang.getSelectedRow(),7).toString())),
                                tbPiutang.getSelectedRow(),11);
                    }
            }
        }
}//GEN-LAST:event_tbPiutangKeyPressed

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
        tampil();
    } else {
        Valid.pindah(evt, TKd, BtnAll);
    }
}//GEN-LAST:event_BtnCariKeyPressed

private void MnDetailPiutangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnDetailPiutangActionPerformed
    if (tabMode.getRowCount() == 0) {
        JOptionPane.showMessageDialog(null, "Maaf, table masih kosong...!!!!");
        TCari.requestFocus();
    } else {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgBilingPiutang rincianpiutang = new DlgBilingPiutang(null, false);
        rincianpiutang.isRawat(tbPiutang.getValueAt(tbPiutang.getSelectedRow(), 1).toString(), 
                Double.parseDouble(tbPiutang.getValueAt(tbPiutang.getSelectedRow(), 6).toString()),
                Double.parseDouble(tbPiutang.getValueAt(tbPiutang.getSelectedRow(), 8).toString()),
                Double.parseDouble(tbPiutang.getValueAt(tbPiutang.getSelectedRow(), 5).toString()),
                Double.parseDouble(tbPiutang.getValueAt(tbPiutang.getSelectedRow(), 7).toString())
        );
        rincianpiutang.setSize(this.getWidth() - 40, this.getHeight() - 40);
        rincianpiutang.setLocationRelativeTo(this);
        rincianpiutang.setAlwaysOnTop(false);
        rincianpiutang.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }
}//GEN-LAST:event_MnDetailPiutangActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tampil();
    }//GEN-LAST:event_formWindowOpened

    private void BtnSeek2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSeek2ActionPerformed
        penjab.isCek();
        penjab.setSize(internalFrame1.getWidth()-40,internalFrame1.getHeight()-40);
        penjab.setLocationRelativeTo(internalFrame1);
        penjab.setAlwaysOnTop(false);
        penjab.setVisible(true);
    }//GEN-LAST:event_BtnSeek2ActionPerformed

    private void BtnSeek2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSeek2KeyPressed
        //Valid.pindah(evt,DTPCari2,TCari);
    }//GEN-LAST:event_BtnSeek2KeyPressed

    private void BtnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBayarActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if (tabMode.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis. Tidak ada data yang bisa anda print...!!!!");
        } else if (tabMode.getRowCount() != 0) {
            koderekening = Sequel.cariIsi("select kd_rek from akun_bayar where nama_bayar=?", nama_bayar.getSelectedItem().toString());
            Sequel.AutoComitFalse();
            row = tabMode.getRowCount();
            for (int i = 0; i < row; i++) {
                if (tabMode.getValueAt(i, 0).toString().equals("true")) {
                    if (Sequel.menyimpantf("bayar_piutang", "?,?,?,?,?,?,?,?", "Data", 8, new String[]{
                        Valid.SetTgl(Tanggal.getSelectedItem() + ""),
                        Sequel.cariIsi("select no_rkm_medis from reg_periksa where no_rawat=?", tabMode.getValueAt(i, 1).toString()),
                        tabMode.getValueAt(i, 11).toString(), "diverifikasi oleh " + akses.getkode(), tabMode.getValueAt(i, 1).toString(),
                        koderekening, Sequel.cariIsi("select now()"), tabMode.getValueAt(i, 8).toString()
                    }) == true) {
                        if (Double.parseDouble(tabMode.getValueAt(i, 8).toString()) <= 0) {
                            Sequel.mengedit("piutang_pasien", "no_rawat='" + tabMode.getValueAt(i, 1).toString() + "'", "status='Lunas'");
                        }
                        Sequel.queryu("delete from tampjurnal");
                        Sequel.menyimpan("tampjurnal", "'" + Sequel.cariIsi("select Bayar_Piutang_Pasien from set_akun") + "','BAYAR PIUTANG','0','" + tabMode.getValueAt(i, 11).toString() + "'", "Rekening");
                        Sequel.menyimpan("tampjurnal", "'" + koderekening + "','" + nama_bayar.getSelectedItem() + "','" + tabMode.getValueAt(i, 11).toString() + "','0'", "Rekening");
                        jur.simpanJurnal(tabMode.getValueAt(i, 1).toString(), Valid.SetTgl(Tanggal.getSelectedItem() + ""), "U", "BAYAR PIUTANG");
                    }
                }
            }
            Sequel.AutoComitTrue();
            tampil();
        }
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnBayarActionPerformed

    private void BtnBayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnBayarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnBayarKeyPressed

    private void nama_bayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nama_bayarKeyPressed
        Valid.pindah(evt,Tanggal,TCari);
    }//GEN-LAST:event_nama_bayarKeyPressed

    private void TanggalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TanggalKeyPressed
        Valid.pindah(evt,kdpenjab,nama_bayar);
    }//GEN-LAST:event_TanggalKeyPressed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            DlgPiutangBelumLunas dialog = new DlgPiutangBelumLunas(new javax.swing.JFrame(), true);
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
    private widget.Button BtnBayar;
    private widget.Button BtnCari;
    private widget.Button BtnKeluar;
    private widget.Button BtnPrint;
    private widget.Button BtnSeek2;
    private javax.swing.JLabel LCount;
    private javax.swing.JMenuItem MnDetailPiutang;
    private widget.ScrollPane Scroll;
    private widget.TextBox TCari;
    private widget.TextBox TKd;
    private widget.Tanggal Tanggal;
    private widget.InternalFrame internalFrame1;
    private javax.swing.JLabel jLabel10;
    private widget.Label jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private widget.TextBox kdpenjab;
    private widget.Label label17;
    private widget.Label label19;
    private widget.Label label32;
    private widget.ComboBox nama_bayar;
    private widget.TextBox nmpenjab;
    private widget.panelisi panelisi1;
    private widget.panelisi panelisi3;
    private widget.panelisi panelisi4;
    private widget.Table tbPiutang;
    // End of variables declaration//GEN-END:variables

    public void tampil(){
        Valid.tabelKosong(tabMode);
        try{
            sisapiutang=0;
            ps = koneksi.prepareStatement("select pp.no_rawat, pp.tgl_piutang, concat(pp.no_rkm_medis,' ',p.nm_pasien), "
                    + "pp.status, pp.totalpiutang, pp.uangmuka, pp.sisapiutang, pp.tgltempo, pj.png_jawab, pp.penjamin, pp.ket_penjamin "
                    + "FROM piutang_pasien pp INNER JOIN pasien p on p.no_rkm_medis=pp.no_rkm_medis "
                    + "INNER JOIN reg_periksa rp on rp.no_rawat=pp.no_rawat INNER JOIN penjab pj on pj.kd_pj=rp.kd_pj WHERE "
                    + "pp.status='Belum Lunas' and pj.png_jawab like ? and pp.no_rawat like ? or "
                    + "pp.status='Belum Lunas' and pj.png_jawab like ? and pp.no_rkm_medis like ? or "
                    + "pp.status='Belum Lunas' and pj.png_jawab like ? and p.nm_pasien like ? or "
                    + "pp.status='Belum Lunas' and pj.png_jawab like ? and pp.status like ? or "
                    + "pp.status='Belum Lunas' and pj.png_jawab like ? and pp.penjamin like ? order by pp.tgl_piutang");
            try {
                ps.setString(1, "%" + nmpenjab.getText() + "%");
                ps.setString(2, "%" + TCari.getText() + "%");
                ps.setString(3, "%" + nmpenjab.getText() + "%");
                ps.setString(4, "%" + TCari.getText() + "%");
                ps.setString(5, "%" + nmpenjab.getText() + "%");
                ps.setString(6, "%" + TCari.getText() + "%");
                ps.setString(7, "%" + nmpenjab.getText() + "%");
                ps.setString(8, "%" + TCari.getText() + "%");
                ps.setString(9, "%" + nmpenjab.getText() + "%");
                ps.setString(10, "%" + TCari.getText() + "%");
                rs=ps.executeQuery();
                while(rs.next()){
                    cicilan=Sequel.cariIsiAngka("SELECT ifnull(SUM(besar_cicilan),0) FROM bayar_piutang where no_rawat=?",rs.getString(1));
                    tabMode.addRow(new Object[]{
                        false, 
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDouble(5),
                        rs.getDouble(6),
                        cicilan,
                        (rs.getDouble(7) - cicilan),
                        rs.getString(8),
                        rs.getString(9), 
                        (rs.getDouble(7) - cicilan),
                        rs.getString("penjamin"),
                        rs.getString("ket_penjamin")
                    });
                    sisapiutang = sisapiutang + rs.getDouble(7) - cicilan;
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }
            
            LCount.setText(Valid.SetAngka(sisapiutang));
        }catch(SQLException e){
            System.out.println("Notifikasi : "+e);
        }
    }
}
