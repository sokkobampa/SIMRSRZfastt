package simrskhanza;
import laporan.*;
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
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import kepegawaian.DlgCariPegawai;

/**
 *
 * @author dosen
 */
public final class DlgRencanaKontrolUmum extends javax.swing.JDialog {    
    private Connection koneksi=koneksiDB.condb();
    private sekuel Sequel=new sekuel();
    private validasi Valid = new validasi();
    private String noRM = "", nmdpjp = "", nomorRW = "";
    private DlgCariPoli poli = new DlgCariPoli(null, false);
    public DlgCariDokter2 dokter = new DlgCariDokter2(null, false);
        
    /** Creates new form DlgPenyakit
     * @param parent
     * @param modal */
    
    public DlgRencanaKontrolUmum(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocation(10,2);
        setSize(628,674);  
        
        poli.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowClosed(WindowEvent e) {
                if (poli.getTable().getSelectedRow() != -1) {
                    kdpoli.setText(poli.getTable().getValueAt(poli.getTable().getSelectedRow(), 0).toString());
                    nmpoli.setText(poli.getTable().getValueAt(poli.getTable().getSelectedRow(), 1).toString());
                    kddokter.setText("");
                    nmdokter.setText("");
                    BtnDokter.requestFocus();
                }
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
        
        dokter.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {;
            }

            @Override
            public void windowClosing(WindowEvent e) {
            }

            @Override
            public void windowClosed(WindowEvent e) {
                if (dokter.getTable().getSelectedRow() != -1) {
                    kddokter.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 0).toString());
                    nmdokter.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(), 1).toString());
                    diagnosa.requestFocus();
                }
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });
        
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
        BtnPrint = new widget.Button();
        BtnKeluar = new widget.Button();
        PanelInput = new javax.swing.JPanel();
        FormInput = new widget.PanelBiasa();
        jLabel3 = new widget.Label();
        kddokter = new widget.TextBox();
        diagnosa = new widget.TextBox();
        jLabel9 = new widget.Label();
        BtnDokter = new widget.Button();
        nmdokter = new widget.TextBox();
        jLabel10 = new widget.Label();
        kdpoli = new widget.TextBox();
        nmpoli = new widget.TextBox();
        BtnPoli = new widget.Button();
        jLabel11 = new widget.Label();
        TanggalKontrol = new widget.Tanggal();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3), "::[ Surat Rencana Kontrol Pasien Non BPJS/UMUM ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(44, 55));
        jPanel3.setLayout(new java.awt.BorderLayout(1, 1));

        panelGlass8.setName("panelGlass8"); // NOI18N
        panelGlass8.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 8));

        BtnPrint.setForeground(new java.awt.Color(0, 0, 0));
        BtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b_print.png"))); // NOI18N
        BtnPrint.setMnemonic('T');
        BtnPrint.setText("Cetak Surat");
        BtnPrint.setToolTipText("Alt+T");
        BtnPrint.setName("BtnPrint"); // NOI18N
        BtnPrint.setPreferredSize(new java.awt.Dimension(120, 30));
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
        panelGlass8.add(BtnKeluar);

        jPanel3.add(panelGlass8, java.awt.BorderLayout.CENTER);

        internalFrame1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        PanelInput.setName("PanelInput"); // NOI18N
        PanelInput.setOpaque(false);
        PanelInput.setPreferredSize(new java.awt.Dimension(611, 140));
        PanelInput.setLayout(new java.awt.BorderLayout(1, 1));

        FormInput.setName("FormInput"); // NOI18N
        FormInput.setPreferredSize(new java.awt.Dimension(611, 100));
        FormInput.setLayout(null);

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Poliklinik : ");
        jLabel3.setName("jLabel3"); // NOI18N
        FormInput.add(jLabel3);
        jLabel3.setBounds(0, 42, 140, 23);

        kddokter.setEditable(false);
        kddokter.setForeground(new java.awt.Color(0, 0, 0));
        kddokter.setName("kddokter"); // NOI18N
        FormInput.add(kddokter);
        kddokter.setBounds(142, 72, 80, 23);

        diagnosa.setForeground(new java.awt.Color(0, 0, 0));
        diagnosa.setName("diagnosa"); // NOI18N
        FormInput.add(diagnosa);
        diagnosa.setBounds(142, 102, 425, 23);

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Dokter Tujuan : ");
        jLabel9.setName("jLabel9"); // NOI18N
        FormInput.add(jLabel9);
        jLabel9.setBounds(0, 72, 140, 23);

        BtnDokter.setForeground(new java.awt.Color(0, 0, 0));
        BtnDokter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/download24.png"))); // NOI18N
        BtnDokter.setMnemonic('2');
        BtnDokter.setToolTipText("Alt+2");
        BtnDokter.setName("BtnDokter"); // NOI18N
        BtnDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDokterActionPerformed(evt);
            }
        });
        FormInput.add(BtnDokter);
        BtnDokter.setBounds(567, 72, 28, 23);

        nmdokter.setEditable(false);
        nmdokter.setForeground(new java.awt.Color(0, 0, 0));
        nmdokter.setName("nmdokter"); // NOI18N
        FormInput.add(nmdokter);
        nmdokter.setBounds(226, 72, 340, 23);

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Diagnosa : ");
        jLabel10.setName("jLabel10"); // NOI18N
        FormInput.add(jLabel10);
        jLabel10.setBounds(0, 102, 140, 23);

        kdpoli.setEditable(false);
        kdpoli.setForeground(new java.awt.Color(0, 0, 0));
        kdpoli.setName("kdpoli"); // NOI18N
        FormInput.add(kdpoli);
        kdpoli.setBounds(142, 42, 80, 23);

        nmpoli.setEditable(false);
        nmpoli.setForeground(new java.awt.Color(0, 0, 0));
        nmpoli.setName("nmpoli"); // NOI18N
        FormInput.add(nmpoli);
        nmpoli.setBounds(226, 42, 340, 23);

        BtnPoli.setForeground(new java.awt.Color(0, 0, 0));
        BtnPoli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/download24.png"))); // NOI18N
        BtnPoli.setMnemonic('2');
        BtnPoli.setToolTipText("Alt+2");
        BtnPoli.setName("BtnPoli"); // NOI18N
        BtnPoli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPoliActionPerformed(evt);
            }
        });
        FormInput.add(BtnPoli);
        BtnPoli.setBounds(567, 42, 28, 23);

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Tgl. Rencana Kontrol : ");
        jLabel11.setName("jLabel11"); // NOI18N
        FormInput.add(jLabel11);
        jLabel11.setBounds(0, 12, 140, 23);

        TanggalKontrol.setEditable(false);
        TanggalKontrol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "19-07-2024" }));
        TanggalKontrol.setDisplayFormat("dd-MM-yyyy");
        TanggalKontrol.setName("TanggalKontrol"); // NOI18N
        TanggalKontrol.setOpaque(false);
        FormInput.add(TanggalKontrol);
        TanggalKontrol.setBounds(142, 12, 95, 23);

        PanelInput.add(FormInput, java.awt.BorderLayout.CENTER);

        internalFrame1.add(PanelInput, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
}//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        if (kdpoli.getText().trim().equals("")) {
            Valid.textKosong(kdpoli, "Poliklinik");
            BtnPoli.requestFocus();
        } else if (kddokter.getText().trim().equals("")) {
            Valid.textKosong(kddokter, "Dokter Tujuan");
            BtnDokter.requestFocus();
        } else if (diagnosa.getText().trim().equals("")) {
            Valid.textKosong(diagnosa, "Diagnosa");
            diagnosa.requestFocus();
        } else {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            Map<String, Object> param = new HashMap<>();
            param.put("namars", akses.getnamars());            
            param.put("logo", Sequel.cariGambar("select logo from setting"));
            param.put("poli", nmpoli.getText());
            param.put("dokter", nmdokter.getText());
            param.put("judul", Sequel.cariIsi("select p.png_jawab from reg_periksa r inner join penjab p on p.kd_pj=r.kd_pj "
                    + "where r.no_rawat='" + nomorRW + "'"));
            param.put("norm", noRM);
            param.put("nmpasien", Sequel.cariIsi("select nm_pasien from pasien where no_rkm_medis='" + noRM + "'"));
            param.put("tgllahir", Valid.SetTglINDONESIA(Sequel.cariIsi("select tgl_lahir from pasien where no_rkm_medis='" + noRM + "'")));
            param.put("diagnosa", diagnosa.getText());
            param.put("tglkontrol", Valid.SetTglINDONESIA(Valid.SetTgl(TanggalKontrol.getSelectedItem() + "")));
            param.put("dpjpnya", nmdpjp);
            Valid.MyReport("rptSuratKontrolUmum.jasper", "report", "::[ Cetak Surat Rencana Kontrol Pasien Non BPJS/UMUM ]::", 
                    "SELECT date(now()) tgl", param);
            this.setCursor(Cursor.getDefaultCursor());
            dispose();
        }        
}//GEN-LAST:event_BtnPrintActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        kddokter.setText("");
        diagnosa.setText("");
        BtnDokter.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void BtnDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDokterActionPerformed
        dokter.setPoli(nmpoli.getText());
        dokter.isCek();
        dokter.setHari(Valid.SetTgl(TanggalKontrol.getSelectedItem() + ""));
        dokter.tampil();
        dokter.TCari.requestFocus();
        dokter.setSize(1046, 341);
        dokter.setLocationRelativeTo(internalFrame1);
        dokter.setVisible(true);
        dokter.emptTeks();
    }//GEN-LAST:event_BtnDokterActionPerformed

    private void BtnPoliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPoliActionPerformed
        poli.isCek();
        poli.setSize(1074, 662);
        poli.setLocationRelativeTo(internalFrame1);
        poli.setVisible(true);
        poli.emptTeks();
    }//GEN-LAST:event_BtnPoliActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            DlgRencanaKontrolUmum dialog = new DlgRencanaKontrolUmum(new javax.swing.JFrame(), true);
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
    private widget.Button BtnDokter;
    private widget.Button BtnKeluar;
    private widget.Button BtnPoli;
    private widget.Button BtnPrint;
    private widget.PanelBiasa FormInput;
    private javax.swing.JPanel PanelInput;
    private widget.Tanggal TanggalKontrol;
    private widget.TextBox diagnosa;
    private widget.InternalFrame internalFrame1;
    private widget.Label jLabel10;
    private widget.Label jLabel11;
    private widget.Label jLabel3;
    private widget.Label jLabel9;
    private javax.swing.JPanel jPanel3;
    private widget.TextBox kddokter;
    private widget.TextBox kdpoli;
    private widget.TextBox nmdokter;
    private widget.TextBox nmpoli;
    private widget.panelisi panelGlass8;
    // End of variables declaration//GEN-END:variables

    public JTextField getTextField(){
        return kddokter;
    }
    
    public void setData(String jnsrwt, String kodepoli, String norm, String dpjp, String norw) {
        if (jnsrwt.equals("Ralan")) {
            kdpoli.setText(kodepoli);
            nmpoli.setText(Sequel.cariIsi("select nm_poli from poliklinik where kd_poli='" + kodepoli + "'"));
            nmdpjp = dpjp;            
            noRM = norm;
            kddokter.setText("");
            nmdokter.setText("");
            diagnosa.setText("");
            nomorRW = norw;
        } else if (jnsrwt.equals("Ranap")) {
            kdpoli.setText("");
            nmpoli.setText("");
            nmdpjp = dpjp;            
            noRM = norm;
            kddokter.setText("");
            nmdokter.setText("");
            diagnosa.setText("");
            nomorRW = norw;
        }
    }
}
