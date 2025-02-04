/*
  Dilarang keras menggandakan/mengcopy/menyebarkan/membajak/mendecompile 
  Software ini dalam bentuk apapun tanpa seijin pembuat software
  (Khanza.Soft Media). Bagi yang sengaja membajak softaware ini ta
  npa ijin, kami sumpahi sial 1000 turunan, miskin sampai 500 turu
  nan. Selalu mendapat kecelakaan sampai 400 turunan. Anak pertama
  nya cacat tidak punya kaki sampai 300 turunan. Susah cari jodoh
  sampai umur 50 tahun sampai 200 turunan. Ya Alloh maafkan kami 
  karena telah berdoa buruk, semua ini kami lakukan karena kami ti
  dak pernah rela karya kami dibajak tanpa ijin.
 */
package simrskhanza;

import inventory.DlgResepObat;
import laporan.DlgDataHAIs;
import bridging.AplicareCekReferensiKamar;
import bridging.AplicareKetersediaanKamar;
import bridging.BPJSCekDataIndukKecelakaan;
import bridging.BPJSCekFingerPrin;
import bridging.BPJSCekKartu;
import bridging.BPJSCekKlaimJasaRaharja;
import bridging.BPJSCekNIK2;
import bridging.BPJSCekReferensiFaskes;
import bridging.BPJSCekReferensiPenyakit;
import bridging.BPJSCekReferensiPoli;
import bridging.BPJSCekNoRujukanPCare;
import bridging.BPJSCekNoRujukanRS;
import bridging.BPJSCekReferensiCaraKeluar;
import bridging.BPJSCekReferensiDiagnosaPRB;
import bridging.BPJSCekReferensiDokter;
import bridging.BPJSCekReferensiDokterDPJP;
import bridging.BPJSCekReferensiDokterHFIS;
import bridging.BPJSCekReferensiJadwalHFIS;
import bridging.BPJSCekReferensiKabupaten;
import bridging.BPJSCekReferensiKecamatan;
import bridging.BPJSCekReferensiKelasRawat;
import bridging.BPJSCekReferensiObatPRB;
import bridging.BPJSCekReferensiPascaPulang;
import bridging.BPJSCekReferensiPoliHFIS;
import bridging.BPJSCekReferensiPropinsi;
import bridging.BPJSCekReferensiProsedur;
import bridging.BPJSCekReferensiSpesialistik;
import bridging.BPJSCekReferensiRuangRawat;
import bridging.BPJSCekRiwayatRujukanPCare;
import bridging.BPJSCekRiwayatRujukanRS;
import bridging.BPJSCekRujukanKartuPCare;
import bridging.BPJSCekRujukanKartuRS;
import bridging.BPJSCekSEPInternal;
import bridging.BPJSCekSuplesiJasaRaharja;
import bridging.BPJSCekTanggalRujukan;
import bridging.BPJSDataNomorSuratKontrol;
import bridging.BPJSDataSEP;
import bridging.BPJSHistoriPelayanan;
import bridging.BPJSListSaranaRujukan;
import bridging.BPJSListSpesialistikRujukan;
import bridging.BPJSMonitoringKlaim;
import bridging.BPJSProgramPRB;
import bridging.BPJSRujukanKeluar;
import bridging.BPJSSuratKontrol;
import bridging.BPJSSPRI;
import bridging.CoronaDiagnosa;
import bridging.CoronaPasien;
import bridging.DlgDataKanker;
import bridging.DlgDataTB;
import bridging.INACBGCariCoderNIK;
import bridging.INACBGCoderNIK;
import bridging.PCareCekReferensiPenyakit;
import bridging.DlgSKDPBPJS;
import bridging.INACBGDaftarKlaim;
import bridging.INACBGPerawatanCorona;
import bridging.INACBGjknBelumDiklaim;
import bridging.KendaliMutuKendaliBiayaJKN;
import bridging.MobileJKNPembatalanPendaftaran;
import bridging.MobileJKNReferensiPendaftaran;
import bridging.PengajuanKlaimINACBGrz;
import bridging.SisruteCekReferensiAlasanRujuk;
import bridging.SisruteCekReferensiDiagnosa;
import bridging.SisruteCekReferensiFaskes;
import bridging.SisruteRujukanKeluar;
import bridging.SisruteRujukanMasukan;
import informasi.InformasiAnalisaKamin;
import laporan.DlgDkkSurveilansRalan;
import laporan.DlgFrekuensiPenyakitRanap;
import laporan.DlgFrekuensiPenyakitRalan;
import laporan.DlgDkkSurveilansRanap;
import laporan.DlgDkkPenyakitTidakMenularRalan;
import laporan.DlgDkkSurveilansPD3I;
import laporan.DlgJumlahMacamDiet;
import laporan.DlgJumlahPorsiDiet;
import laporan.DlgIndikatorNasionalMutu;
import setting.DlgUser;
import setting.DlgSetKamarInap;
import setting.DlgSetOtoLokasi;
import setting.DlgSetTarif;
import setting.DlgSetAplikasi;
import setting.DlgSetPenjabLab;
import setting.DlgSetOtoRalan;
import setting.DlgSetRM;
import setting.DlgSetHarga;
import setting.DlgBiayaSekaliMasuk;
import setting.DlgAdmin;
import setting.DlgBiayaHarian;
import inventory.DlgSuplier;
import fungsi.batasInput;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.akses;
import informasi.InformasiJadwal;
import informasi.InformasiKamar;
import informasi.InformasiKamarInap;
import informasi.InformasiTarifLab;
import informasi.InformasiTarifOperasi;
import informasi.InformasiTarifRadiologi;
import informasi.InformasiTarifRalan;
import informasi.InformasiTarifRanap;
import informasi.InformasiTarifINACBG;
import informasi.InformasiTelusurKunjunganPasien;
import inventaris.InventarisBarang;
import inventaris.InventarisKoleksi;
import inventaris.InventarisJenis;
import inventaris.InventarisKategori;
import inventaris.InventarisMerk;
import inventaris.InventarisProdusen;
import inventaris.InventarisRuang;
import inventaris.InventarisSirkulasi;
import inventaris.InventarisBarangCSSD;
import inventory.DlgCariPengambilanUTD;
import inventory.DlgCariPenjualan;
import inventory.DlgDaruratStok;
import inventory.DlgIndustriFarmasi;
import inventory.DlgInputStok;
import inventory.DlgKonversi;
import inventory.DlgMutasiBarang;
import inventory.DlgPembelian;
import inventory.DlgPemesanan;
import inventory.DlgPengambilanUTD;
import inventory.DlgPenjualan;
import inventory.DlgPiutang;
import inventory.DlgProyeksiBeriObat;
import inventory.DlgProyeksiBeriObat2;
import inventory.DlgProyeksiJual;
import inventory.DlgReturBeli;
import inventory.DlgReturJual;
import inventory.DlgReturObatPasien;
import inventory.DlgReturPiutang;
import inventory.DlgSirkulasiBarang;
import inventory.DlgSirkulasiBarang2;
import inventory.DlgStokPasien;
import ipsrs.DlgBarangIPSRS;
import ipsrs.DlgCariPengambilanPenunjangUTD;
import ipsrs.DlgJenisIPSRS;
import ipsrs.DlgPembelianIPSRS;
import ipsrs.DlgPengambilanPenunjangUTD;
import ipsrs.DlgPengeluaranIPSRS;
import ipsrs.DlgRBiayaHarianIPSRS;
import ipsrs.DlgRHPembelianIPSRS;
import ipsrs.DlgRHPengeluaranIPSRS;
import ipsrs.DlgSuplierIPSRS;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import keuangan.DlgAkunBayar;
import keuangan.DlgBayarPemesanan;
import keuangan.DlgBayarPiutang;
import keuangan.DlgBubes;
import keuangan.DlgCashflow;
import keuangan.DlgDetailPotongan;
import keuangan.DlgDetailTambahan;
import keuangan.DlgFeeVisitDokter;
import keuangan.DlgJnsPerawatanLab;
import keuangan.DlgJnsPerawatanOperasi;
import keuangan.DlgJnsPerawatanRadiologi;
import keuangan.DlgJnsPerawatanUTD;
import keuangan.DlgJurnal;
import keuangan.DlgJurnalHarian;
import keuangan.DlgLabaRugi;
import keuangan.DlgLhtBiaya;
import keuangan.DlgLhtPiutang;
import keuangan.DlgPaymentPoint;
import keuangan.DlgPemasukanLain;
import keuangan.DlgPembayaranRalan;
import keuangan.DlgPembayaranRanap;
import keuangan.DlgPengaturanRekening;
import keuangan.DlgPengeluaranHarian;
import keuangan.DlgPiutangBelumLunas;
import keuangan.DlgRBObatPercaraBayar;
import keuangan.DlgRekapPerShift;
import keuangan.DlgRekening;
import keuangan.DlgRekeningTahun;
import bridging.SatuSehatKirimClinicalImpression;
import bridging.SatuSehatKirimCondition;
import bridging.SatuSehatKirimDiet;
import bridging.SatuSehatKirimEncounter;
import bridging.SatuSehatKirimMedicationRequest;
import bridging.SatuSehatKirimMedicationDispense;
import bridging.SatuSehatKirimObservationTTV;
import bridging.SatuSehatKirimProcedure;
import bridging.SatuSehatKirimVaksin;
import bridging.SatuSehatMapingLokasi;
import bridging.SatuSehatMapingObatAlkes;
import bridging.SatuSehatMapingOrganisasi;
import bridging.SatuSehatMapingVaksin;
import bridging.SatuSehatReferensiPasien;
import bridging.SatuSehatReferensiPraktisi;
import fungsi.BackgroundMusic;
import grafikanalisa.GrafikDemografiRegistrasi;
import grafikanalisa.GrafikKunjunganPerBulan;
import grafikanalisa.GrafikKunjunganPerDokter;
import grafikanalisa.GrafikKunjunganPerPekerjaan;
import grafikanalisa.GrafikKunjunganPerPendidikan;
import grafikanalisa.GrafikKunjunganPerTahun;
import grafikanalisa.GrafikKunjunganPerTanggal;
import grafikanalisa.GrafikKunjunganPoli;
import grafikanalisa.GrafikStatusBatalRegPerBulan;
import grafikanalisa.GrafikStatusBatalRegPerTahun;
import grafikanalisa.GrafikStatusBatalRegPerTanggal;
import grafikanalisa.GrafikStatusRegPerBulan;
import grafikanalisa.GrafikStatusRegPerBulan2;
import grafikanalisa.GrafikStatusRegPerTahun;
import grafikanalisa.GrafikStatusRegPerTahun2;
import grafikanalisa.GrafikStatusRegPerTanggal;
import grafikanalisa.GrafikStatusRegPerTanggal2;
import inventory.DlgAturanPakai;
import inventory.DlgBarang;
import inventory.DlgCariJenis;
import inventory.DlgCariObat;
import inventory.DlgDaftarPermintaanResep;
import inventory.DlgGolongan;
import inventory.DlgKategori;
import inventory.DlgObatPerTanggal;
import inventory.DlgPelaksanaPemberiObat;
import inventory.DlgPemberianObat;
import inventory.DlgPemberianObatPasien;
import inventory.DlgPenjualanPerTanggal;
import inventory.DlgRiwayatBarangMedis;
import inventory.DlgSatuan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import kepegawaian.DlgCariPetugas;
import kepegawaian.DlgPegawai;
import kepegawaian.DlgPetugas;
import keuangan.DlgAkunPiutang;
import keuangan.DlgBilingRalan;
import keuangan.DlgBilingRanap;
import keuangan.DlgHutangObatBelumLunas;
import keuangan.DlgJnsPerawatanRalan;
import keuangan.DlgJnsPerawatanRanap;
import keuangan.DlgKamar;
import keuangan.DlgPiutangPercaraBayar;
import keuangan.DlgPiutangRalan;
import keuangan.DlgPiutangRanap;
import keuangan.DlgRincianPiutangPasien;
import keuangan.DlgTransaksiPanjar;
import laporan.DlgBulananHAIs;
import laporan.DlgBulananHAIsRalan;
import laporan.DlgBulananHAIsRanap;
import laporan.DlgDiagnosaPenyakit;
import laporan.DlgDkkPenyakitMenularRalan;
import laporan.DlgDkkPenyakitMenularRanap;
import laporan.DlgDkkPenyakitTidakMenularRanap;
import laporan.DlgHarianHAIs;
import laporan.DlgHarianHAIsRalan;
import laporan.DlgHarianHAIsRanap;
import laporan.DlgICD9;
import laporan.DlgKunjunganRalan;
import laporan.DlgKunjunganRanap;
import laporan.DlgLaporanFarmasi;
import laporan.DlgPelayananApotek;
import laporan.DlgPelayananRalan;
import laporan.DlgPenyakitPd3i;
import laporan.DlgRL4A;
import laporan.DlgRL4ASebab;
import laporan.DlgRL4B;
import laporan.DlgRL4BSebab;
import laporan.DlgRl32;
import laporan.DlgRl33;
import laporan.DlgRl34;
import laporan.DlgRl36;
import laporan.DlgRl37;
import laporan.DlgRl38;
import laporan.DlgSensusHarianPoli;
import permintaan.DlgCariPermintaanLab;
import permintaan.DlgCariPermintaanRadiologi;
import permintaan.DlgSuratIstirahatSakit;
import permintaan.DlgSuratJawabanKonsul;
import permintaan.DlgSuratKeteranganDisabilitas;
import permintaan.DlgSuratKeteranganDokter;
import permintaan.DlgSuratKeteranganNapza;
import permintaan.DlgSuratKeteranganRohani;
import permintaan.DlgSuratKeteranganSakit;
import permintaan.DlgSuratKonsulUnit;
import rekammedis.DlgAssesmenGiziUlang;
import rekammedis.DlgCPPT;
import rekammedis.DlgCatatanTindakanKeperawatan;
import rekammedis.DlgInputKodeICD;
import rekammedis.DlgMasterDTD;
import rekammedis.DlgMasterDiagnosaGizi;
import rekammedis.DlgMasterIndikatorMutu;
import rekammedis.DlgMasterJabatanKomite;
import rekammedis.DlgMasterJenisDokumenJangMed;
import rekammedis.DlgMasterKeluhanPsikologis;
import rekammedis.DlgMasterNumdemonINM;
import rekammedis.DlgMasterRencanaTritmenPsikologi;
import rekammedis.DlgMonevAsuhanGizi;
import rekammedis.DlgRekamPsikologisAnak;
import rekammedis.DlgRekamPsikologisDewasa;
import rekammedis.DlgRekamPsikologisPerkawinan;
import rekammedis.MasterDataDinkes;
import rekammedis.MasterMasalahKeperawatan;
import rekammedis.MasterFaktorResikoIGD;
import rekammedis.MasterResikoDecubitus;
import rekammedis.RMAsesmenKebidananRalan;
import rekammedis.RMAsesmenKeperawatanAnakRanap;
import rekammedis.RMAsesmenKeperawatanDewasaRanap;
import rekammedis.RMAsesmenKeperawatanPerioperatif;
import rekammedis.RMAsesmenMedikAnakRanap;
import rekammedis.RMPenilaianAwalKeperawatanIGDrz;
import rekammedis.RMPenilaianAwalKeperawatanKebidanan;
import rekammedis.RMPenilaianAwalKeperawatanRalan;
import rekammedis.RMPenilaianAwalMedikIGD;
import rekammedis.RMPenilaianAwalMedikObstetriRalan;
import rekammedis.RMPenilaianAwalMedisRalanGeriatri;
import rekammedis.RMPenilaianAwalMedisRalanMata;
import rekammedis.RMPenilaianAwalMedisRalanTHT;
import rekammedis.RMPenilaianTambahanGeriatri;
import rekammedis.RMTransferSerahTerimaIGD;
import rekammedis.RMTriaseIGD;
import rekammedis.RMAsesmenMedikDewasaRanap;
import rekammedis.RMAsesmenPraSedasi;
import rekammedis.RMAsesmenPreInduksi;
import rekammedis.RMAsesmenRestrain;
import rekammedis.RMAsesmenUlangResikoJatuhAnak;
import rekammedis.RMAsesmenUlangResikoJatuhDewasa;
import rekammedis.RMAsuhanGiziRanap;
import rekammedis.RMCeklisKesiapanAnestesi;
import rekammedis.RMCeklisPraOperasi;
import rekammedis.RMLembarObservasi;
import rekammedis.RMMonitoringEWSDewasa;
import rekammedis.RMMonitoringPEWSAnak;
import rekammedis.RMPasienUntukTindakan;
import rekammedis.RMPemantauanHarian24Jam;
import rekammedis.RMPengelolaanTransfusiDarah;
import rekammedis.RMPerencanaanPulang;
import rekammedis.RMProtokolKemoterapi;
import rekammedis.RMSkriningUlangGizi;
import rekammedis.RMTindakanKedokteran;
import setting.DlgClosingKasir;
import setting.DlgSetBridging;
import setting.DlgSetEmbalase;
import setting.DlgSetHargaKamar;
import setting.DlgSetHargaObatRalan;
import setting.DlgSetHargaObatRanap;
import setting.DlgSetKeterlambatan;
import setting.DlgSetNota;
import tranfusidarah.UTDCariPenyerahanDarah;
import tranfusidarah.UTDDonor;
import tranfusidarah.UTDMedisRusak;
import tranfusidarah.UTDCekalDarah;
import tranfusidarah.UTDKomponenDarah;
import tranfusidarah.UTDPemisahanDarah;
import tranfusidarah.UTDPenunjangRusak;
import tranfusidarah.UTDPenyerahanDarah;
import tranfusidarah.UTDStokDarah;
import simrskhanza.DlgInputPonek;
import simrskhanza.DlgPenanggungJawab;

/**
 *
 * @author perpustakaan
 */
public class frmUtama extends javax.swing.JFrame {
    private final Connection koneksi = koneksiDB.condb();
    private final sekuel Sequel = new sekuel();
    private final validasi Valid = new validasi();
    private static frmUtama myInstance;
    private PreparedStatement ps;
    private ResultSet rs;
    private final Properties prop = new Properties();
    private int jmlmenu = 0, grid = 0, tinggi = 0, i = 0;
    private String coder_nik = "", pilihpage = "", judulform = "", host = "", cek = "", cekApt = "";
    private final DlgKasirRalan kasirralan = new DlgKasirRalan(this, false);
    private final DlgKamarInap kamarinap = new DlgKamarInap(null, false);
    private final DlgIGD igd = new DlgIGD(this, false);  
    private BackgroundMusic music;
    
    /**
     * Creates new form frmUtama
     */
    private frmUtama() {
        super();
        initComponents();
        setIconImage(new ImageIcon(super.getClass().getResource("/picture/raza_icon.png")).getImage());

        this.setSize(screen.width, screen.height);
        //desktop.setPreferredSize(new Dimension(800,1000));
        //desktop.setAutoscrolls(true);
        edAdmin.setDocument(new batasInput((byte) 100).getKata(edAdmin));
        edPwd.setDocument(new batasInput((byte) 100).getKata(edPwd));
        PassLama.setDocument(new batasInput((byte) 100).getKata(PassLama));
        Passbaru1.setDocument(new batasInput((byte) 100).getKata(Passbaru1));
        PassBaru2.setDocument(new batasInput((byte) 100).getKata(PassBaru2));

        DlgLogin.setSize(344, 201);
        DlgLogin.setVisible(false);
        DlgLogin.setLocationRelativeTo(null);

        WindowInput.setSize(349, 180);
        WindowInput.setVisible(false);
        WindowInput.setLocationRelativeTo(null);

        INACBGCariCoderNIK cariNIK = new INACBGCariCoderNIK(this, false);
        
        lblTgl.setText(tanggal.getSelectedItem().toString());
        try {
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
        } catch (Exception e) {
            System.out.println("Notif Setting : " + e);
        }

        FlayMenu.setVisible(false);
        TCari.setVisible(false);
        if (koneksiDB.cariCepat().equals("aktif")) {
            TCari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    isTampil();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    isTampil();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    isTampil();
                }
            });
        }
        
        cekApotek();
        cekNotifApotek();
        cekNotifLab();
        cekNotifRad();
        
        otomatisRefreshNotifApt();
        akses.tRefreshNotifApotek.start();
        otomatisRefreshNotifLab();
        akses.tRefreshNotifLab.start();
        otomatisRefreshNotifRad();
        akses.tRefreshNotifRad.start();        
    }

    public static frmUtama getInstance() {
        if (myInstance == null) {
            myInstance = new frmUtama();
        }

        return myInstance;        
    }

    //private DlgMenu menu=new DlgMenu(this,false); 
    private final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DlgLogin = new javax.swing.JDialog();
        internalFrame2 = new widget.InternalFrame();
        internalFrame3 = new widget.InternalFrame();
        panelGlass1 = new usu.widget.glass.PanelGlass();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        edPwd = new widget.PasswordBox();
        edAdmin = new widget.TextBox();
        jLabel6 = new javax.swing.JLabel();
        BtnLogin = new widget.Button();
        BtnCancel = new widget.Button();
        WindowInput = new javax.swing.JDialog();
        internalFrame6 = new widget.InternalFrame();
        PassLama = new widget.TextBox();
        jLabel9 = new widget.Label();
        BtnClosePass = new widget.Button();
        BtnSimpanPass = new widget.Button();
        jLabel10 = new widget.Label();
        Passbaru1 = new widget.TextBox();
        jLabel12 = new widget.Label();
        PassBaru2 = new widget.TextBox();
        DlgHome = new javax.swing.JDialog();
        panelMenu = new widget.InternalFrame();
        panelisi2 = new widget.panelisi();
        label36 = new widget.Label();
        button1 = new widget.Button();
        label35 = new widget.Label();
        cmbMenu = new widget.ComboBox();
        TCari = new widget.TextBox();
        ChkInput = new widget.CekBox();
        scrollPane2 = new widget.ScrollPane();
        Panelmenu = new widget.panelGlass();
        btnICD = new widget.ButtonBig();
        btnObat = new widget.ButtonBig();
        btnObatPenyakit = new widget.ButtonBig();
        btnKamar = new widget.ButtonBig();
        btnTindakanRalan = new widget.ButtonBig();
        btnDokter = new widget.ButtonBig();
        btnPegawai = new widget.ButtonBig();
        btnPasien = new widget.ButtonBig();
        btnRegistrasi = new widget.ButtonBig();
        btnRalan = new widget.ButtonBig();
        btnKamarInap = new widget.ButtonBig();
        btnRanap = new widget.ButtonBig();
        btnResepObat = new widget.ButtonBig();
        btnRujukPasien = new widget.ButtonBig();
        btnBeriObat = new widget.ButtonBig();
        btnPasienMati = new widget.ButtonBig();
        btnAdmin = new widget.ButtonBig();
        btnUser = new widget.ButtonBig();
        btnAntrian = new widget.ButtonBig();
        btnSetupHarga = new widget.ButtonBig();
        btnSuplier = new widget.ButtonBig();
        btnJnsBarang = new widget.ButtonBig();
        btnKonversi = new widget.ButtonBig();
        btnSatuan = new widget.ButtonBig();
        btnCashFlow = new widget.ButtonBig();
        btnBubes = new widget.ButtonBig();
        btnPostingJurnal = new widget.ButtonBig();
        btnRekeningTahun = new widget.ButtonBig();
        btnRekening = new widget.ButtonBig();
        btnPembelian = new widget.ButtonBig();
        btnPenjualan = new widget.ButtonBig();
        btnPiutang = new widget.ButtonBig();
        btnBayarPiutang = new widget.ButtonBig();
        btnOpname = new widget.ButtonBig();
        btnReturBeli = new widget.ButtonBig();
        btnReturJual = new widget.ButtonBig();
        btnSirkulasi = new widget.ButtonBig();
        btnKeuntungan = new widget.ButtonBig();
        btnLabaRugi = new widget.ButtonBig();
        btnReturPiutang = new widget.ButtonBig();
        btnAnalisaKamar = new widget.ButtonBig();
        btnTagihanMasuk = new widget.ButtonBig();
        btnResume = new widget.ButtonBig();
        btnDiet = new widget.ButtonBig();
        btnKasir = new widget.ButtonBig();
        btnLahir = new widget.ButtonBig();
        btnSetBiayaHarian = new widget.ButtonBig();
        btnJenisInventaris = new widget.ButtonBig();
        btnKategoriInventaris = new widget.ButtonBig();
        btnLihatPiutang = new widget.ButtonBig();
        btnLaboratorium = new widget.ButtonBig();
        btnRalanMasuk = new widget.ButtonBig();
        btnSetupAplikasi = new widget.ButtonBig();
        btnSetOtoRalan = new widget.ButtonBig();
        btnRanapMasuk = new widget.ButtonBig();
        btnProdusenInventaris = new widget.ButtonBig();
        btnSetBiayaMasukSekali = new widget.ButtonBig();
        btnPaketOperasi = new widget.ButtonBig();
        btnTagihanOperasi = new widget.ButtonBig();
        BtnJadwal = new widget.ButtonBig();
        btnMerkInventaris = new widget.ButtonBig();
        btnRuangInventaris = new widget.ButtonBig();
        btnBarangInventaris = new widget.ButtonBig();
        btnInventaris = new widget.ButtonBig();
        btnSirkulasiInventaris = new widget.ButtonBig();
        btnFrekuensiRalan = new widget.ButtonBig();
        btnFrekuensiRanap = new widget.ButtonBig();
        btnSetupOtoLokasi = new widget.ButtonBig();
        btnRujukMasuk = new widget.ButtonBig();
        btnTracker = new widget.ButtonBig();
        btnTindakanRanap = new widget.ButtonBig();
        btnSetupJamInap = new widget.ButtonBig();
        btnStokObatPasien = new widget.ButtonBig();
        btnTarifLab = new widget.ButtonBig();
        btnSetPenjab = new widget.ButtonBig();
        btnReturPasien = new widget.ButtonBig();
        btnKeuntunganObatRanap = new widget.ButtonBig();
        btnPenggajian = new widget.ButtonBig();
        btnDeposit = new widget.ButtonBig();
        btnSetupRM = new widget.ButtonBig();
        btnResepPulang = new widget.ButtonBig();
        btnSetupTarif = new widget.ButtonBig();
        btnBarangIpsrs = new widget.ButtonBig();
        btnPembelianIpsrs = new widget.ButtonBig();
        btnPengeluaranIpsrs = new widget.ButtonBig();
        btnRHMasukIpsrs = new widget.ButtonBig();
        btnRHKeluarIpsrs = new widget.ButtonBig();
        btnRBiayaIpsrs = new widget.ButtonBig();
        btnTarifRadiologi = new widget.ButtonBig();
        btnPeriksaRadiologi = new widget.ButtonBig();
        btnSetupEmbalase = new widget.ButtonBig();
        btnPemesanan = new widget.ButtonBig();
        btnPengeluaran = new widget.ButtonBig();
        btnTambahanBiaya = new widget.ButtonBig();
        btnPotonganBiaya = new widget.ButtonBig();
        btnIGD = new widget.ButtonBig();
        btnSetObatRalan = new widget.ButtonBig();
        btnSetObatRanap = new widget.ButtonBig();
        btnPenyakitPD3I = new widget.ButtonBig();
        btnSurveilansPD3I = new widget.ButtonBig();
        btnSurveilansRalan = new widget.ButtonBig();
        btnDiagnosa = new widget.ButtonBig();
        btnSurveilansRanap = new widget.ButtonBig();
        btnPnyTakMenularRanap = new widget.ButtonBig();
        btnPnyTakMenularRalan = new widget.ButtonBig();
        btnKunjunganRalan = new widget.ButtonBig();
        btnRl32 = new widget.ButtonBig();
        btnRl33 = new widget.ButtonBig();
        btnRl37 = new widget.ButtonBig();
        btnRl38 = new widget.ButtonBig();
        btnSetupNota = new widget.ButtonBig();
        BtnDpjp = new widget.ButtonBig();
        btnMutasiBarang = new widget.ButtonBig();
        btnRl34 = new widget.ButtonBig();
        btnRl36 = new widget.ButtonBig();
        btnfee_visit_dokter = new widget.ButtonBig();
        btnakun_bayar = new widget.ButtonBig();
        btnbayar_pemesanan = new widget.ButtonBig();
        btnJenisIpsrs = new widget.ButtonBig();
        btnPemasukanLain = new widget.ButtonBig();
        btnPengaturanRekening = new widget.ButtonBig();
        btnClosingKasir = new widget.ButtonBig();
        btnKeterlambatanPresensi = new widget.ButtonBig();
        btnSetHargaKamar = new widget.ButtonBig();
        btnRekapPershift = new widget.ButtonBig();
        btnCekBPJSNik = new widget.ButtonBig();
        btnCekBPJSKartu = new widget.ButtonBig();
        btnObatPerCaraBayar = new widget.ButtonBig();
        btnKunjunganRanap = new widget.ButtonBig();
        btnPaymentPoint = new widget.ButtonBig();
        btnCekBPJSNomorRujukanPCare = new widget.ButtonBig();
        btnICD9 = new widget.ButtonBig();
        btnDaruratStok = new widget.ButtonBig();
        btnJurnalHarian = new widget.ButtonBig();
        btnSirkulasi2 = new widget.ButtonBig();
        btnCekBPJSDiagnosa = new widget.ButtonBig();
        btnCekBPJSPoli = new widget.ButtonBig();
        btnIndustriFarmasi = new widget.ButtonBig();
        btnPiutangBelumLunas = new widget.ButtonBig();
        btnCekBPJSFaskes = new widget.ButtonBig();
        btnBPJSSEP = new widget.ButtonBig();
        btnPengambilanUTD = new widget.ButtonBig();
        btnTarifUtd = new widget.ButtonBig();
        btnPengambilanUTD2 = new widget.ButtonBig();
        btnUTDMedisRusak = new widget.ButtonBig();
        btnPengambilanPenunjangUTD = new widget.ButtonBig();
        btnPengambilanPenunjangUTD2 = new widget.ButtonBig();
        btnUTDPenunjangRusak = new widget.ButtonBig();
        btnSuplierIPSRS = new widget.ButtonBig();
        btnUTDDonorDarah = new widget.ButtonBig();
        btnMonitoringKlaimBPJS = new widget.ButtonBig();
        btnUTDCekalDarah = new widget.ButtonBig();
        btnUTDKomponenDarah = new widget.ButtonBig();
        btnUTDStokDarah = new widget.ButtonBig();
        btnUTDPemisahanDarah = new widget.ButtonBig();
        btnRincianPiutangPasien = new widget.ButtonBig();
        btnKeuntunganObat2 = new widget.ButtonBig();
        btnUTDPenyerahanDarah = new widget.ButtonBig();
        btnHutangObat = new widget.ButtonBig();
        btnRiwayatBarangMedis = new widget.ButtonBig();
        btnSensusHarianPoli = new widget.ButtonBig();
        btnRl4a = new widget.ButtonBig();
        btnAplicareReferensiKamar = new widget.ButtonBig();
        btnAplicareKetersediaanKamar = new widget.ButtonBig();
        btnInaCBGCoderNIK = new widget.ButtonBig();
        btnAkunPiutang = new widget.ButtonBig();
        btnPiutangRalan = new widget.ButtonBig();
        btnPiutangRanap = new widget.ButtonBig();
        btnPiutangPerCaraBayar = new widget.ButtonBig();
        btnLamaPelayananRalan = new widget.ButtonBig();
        btnCatatanPasien = new widget.ButtonBig();
        btnRl4b = new widget.ButtonBig();
        btnRl4asebab = new widget.ButtonBig();
        btnRl4bsebab = new widget.ButtonBig();
        btnDataHAIs = new widget.ButtonBig();
        btnHarianHAIsRS = new widget.ButtonBig();
        btnBulananHAIsRS = new widget.ButtonBig();
        btnPerusahaan = new widget.ButtonBig();
        btnDaftarPermintaanResep = new widget.ButtonBig();
        btnLamaPelayananApotek = new widget.ButtonBig();
        btnGrafikKunjunganPoli = new widget.ButtonBig();
        btnGrafikKunjunganPerDokter = new widget.ButtonBig();
        btnGrafikKunjunganPerPekerjaan = new widget.ButtonBig();
        btnGrafikKunjunganPerPendidikan = new widget.ButtonBig();
        btnGrafikKunjunganPerTahun = new widget.ButtonBig();
        btnPnyMenularRanap = new widget.ButtonBig();
        btnPnyMenularRalan = new widget.ButtonBig();
        btnGrafikKunjunganPerBulan = new widget.ButtonBig();
        btnGrafikKunjunganPerTanggal = new widget.ButtonBig();
        btnGrafikDemografiRegistrasi = new widget.ButtonBig();
        btnGrafikStatusRegPerTahun = new widget.ButtonBig();
        btnGrafikStatusRegPerTahun2 = new widget.ButtonBig();
        btnGrafikStatusRegPerBulan = new widget.ButtonBig();
        btnGrafikStatusRegPerBulan2 = new widget.ButtonBig();
        btnGrafikStatusRegPerTanggal = new widget.ButtonBig();
        btnGrafikStatusRegPerTanggal2 = new widget.ButtonBig();
        btnGrafikStatusRegBatalPerTahun = new widget.ButtonBig();
        btnGrafikStatusRegBatalPerBulan = new widget.ButtonBig();
        btnCekPCareDiagnosa = new widget.ButtonBig();
        btnGrafikStatusRegBatalPerTanggal = new widget.ButtonBig();
        btnKategoriBarang = new widget.ButtonBig();
        btnGolonganBarang = new widget.ButtonBig();
        btnObatPerTanggal = new widget.ButtonBig();
        btnPenjualanPerTanggal = new widget.ButtonBig();
        btnSKDPbpjs = new widget.ButtonBig();
        btnRujukKeluarVclaim = new widget.ButtonBig();
        btnBookingReg = new widget.ButtonBig();
        btnBPJScekRiwayatRujukanPcare = new widget.ButtonBig();
        btnCekBPJSRiwayatRujukanRS = new widget.ButtonBig();
        btnCekBPJSRujukanKartuRS = new widget.ButtonBig();
        btnCekBPJSTanggalRujukan = new widget.ButtonBig();
        btnCekBPJSNomorRujukanRS = new widget.ButtonBig();
        btnCekBPJSRujukanKartuPCare = new widget.ButtonBig();
        btnCekReferensiKelasRawatBPJS = new widget.ButtonBig();
        btnCekReferensiProsedurBPJS = new widget.ButtonBig();
        btnCekReferensiDokterDPJPBPJS = new widget.ButtonBig();
        btnCekReferensiDokterBPJS = new widget.ButtonBig();
        btnCekReferensiSpesialistikBPJS = new widget.ButtonBig();
        btnCekReferensiRuangRawatBPJS = new widget.ButtonBig();
        btnCekReferensiCaraKeluarBPJS = new widget.ButtonBig();
        btnCekReferensiPascaPulangBPJS = new widget.ButtonBig();
        btnCekReferensiPropinsiBPJS = new widget.ButtonBig();
        btnCekReferensiKabupatenBPJS = new widget.ButtonBig();
        btnCekReferensiKecamatanBPJS = new widget.ButtonBig();
        btnPermintaanLab = new widget.ButtonBig();
        btnPermintaanRadiologi = new widget.ButtonBig();
        btnJumlahPorsiDiet = new widget.ButtonBig();
        btnJumlahMacamDiet = new widget.ButtonBig();
        btnMasterFaskes = new widget.ButtonBig();
        btnCekSisruteFaskes = new widget.ButtonBig();
        btnCekSisruteAlasanRujuk = new widget.ButtonBig();
        btnCekSisruteDiagnosa = new widget.ButtonBig();
        btnRujukanMasukSisrute = new widget.ButtonBig();
        btnRujukanKeluarSisrute = new widget.ButtonBig();
        btnBarangCSSD = new widget.ButtonBig();
        btnPasienPonek = new widget.ButtonBig();
        btnHarianHAIsRanap = new widget.ButtonBig();
        btnHarianHAIsRalan = new widget.ButtonBig();
        btnBulananHAIsRanap = new widget.ButtonBig();
        btnBulananHAIsRalan = new widget.ButtonBig();
        btnRingkasanPulangRanap = new widget.ButtonBig();
        btnLaporanFarmasi = new widget.ButtonBig();
        btnMasterMasalahKeperawatan = new widget.ButtonBig();
        btnPenilaianAwalKeperawatanRalan = new widget.ButtonBig();
        btnDataTriaseIGD = new widget.ButtonBig();
        btnMasterCaraBayar = new widget.ButtonBig();
        btnDataPersalinan = new widget.ButtonBig();
        btnPasienCorona = new widget.ButtonBig();
        btnDiagnosaPasienCorona = new widget.ButtonBig();
        btnPerawatanPasienCorona = new widget.ButtonBig();
        btnAsuhanGiziRanap = new widget.ButtonBig();
        btnAssesmenUlangGizi = new widget.ButtonBig();
        btnRencanaKontrolBPJS = new widget.ButtonBig();
        btnMonevAsuhanGizi = new widget.ButtonBig();
        btnBridgingEklaimINACBG = new widget.ButtonBig();
        btnPengajuanKlaimINACBGrz = new widget.ButtonBig();
        btnINACBGjknBelumDiklaim = new widget.ButtonBig();
        btnInputKodeICD = new widget.ButtonBig();
        btnKendaliMutuKendaliBiayaINACBG = new widget.ButtonBig();
        btnDashboardeResepRalan = new widget.ButtonBig();
        btnCekSEPInternalBPJS = new widget.ButtonBig();
        btnSPRIbpjsVclaim = new widget.ButtonBig();
        btnCekFingerPrinBPJS = new widget.ButtonBig();
        btnListSpesialistikRujukanBPJS = new widget.ButtonBig();
        btnListSaranaRujukanBPJS = new widget.ButtonBig();
        btnProgramPRBBPJS = new widget.ButtonBig();
        btnCekReferensiDiagnosaPRBBPJS = new widget.ButtonBig();
        btnCekReferensiObatPRBBPJS = new widget.ButtonBig();
        btnDataNomorSuratKontrolBPJS = new widget.ButtonBig();
        btnHistoriPelayananPesertaBPJS = new widget.ButtonBig();
        btnKlaimJaminanJasaRaharja = new widget.ButtonBig();
        btnDataSuplesiJasaRaharja = new widget.ButtonBig();
        btnDataSEPIndukKLLJasaRaharja = new widget.ButtonBig();
        btnCekReferensiPoliHFISBPJS = new widget.ButtonBig();
        btnCekReferensiJadwalHFISBPJS = new widget.ButtonBig();
        btnCekReferensiDokterHFISBPJS = new widget.ButtonBig();
        btnCekReferensiPendaftaranMobileJKNBPJS = new widget.ButtonBig();
        btnCekReferensiBatalDaftarMobileJKNBPJS = new widget.ButtonBig();
        btnKemenkesSITB = new widget.ButtonBig();
        btnMasterDTD = new widget.ButtonBig();
        btnAsesmenMedikObstetriRalan = new widget.ButtonBig();
        btnPenilaianAwalKeperawatanKebidananRalan = new widget.ButtonBig();
        btnIkhtisarPerawatanHIV = new widget.ButtonBig();
        btnKemenkesKanker = new widget.ButtonBig();
        btnSetingBridging = new widget.ButtonBig();
        btnPenilaianAwalMedisRalanTHT = new widget.ButtonBig();
        btnRekamPsikologisDewasa = new widget.ButtonBig();
        btnMasterKeluhanPsikologis = new widget.ButtonBig();
        btnMasterRencanaTritmenPsikologis = new widget.ButtonBig();
        btnDataJabatan = new widget.ButtonBig();
        btnMasterJabatanKomite = new widget.ButtonBig();
        btnRekamPsikologisAnak = new widget.ButtonBig();
        btnRekamPsikologiPerkawinan = new widget.ButtonBig();
        btnMasterAturanPakai = new widget.ButtonBig();
        btnMasterKasusPersalinanDinkes = new widget.ButtonBig();
        btnKasusPersalinanDinkes = new widget.ButtonBig();
        btnPenilaianTambahanGeriatri = new widget.ButtonBig();
        btnPenilaianAwalMedisRalanGeriatri = new widget.ButtonBig();
        btnMasterFaktorResikoJatuh = new widget.ButtonBig();
        btnAssesmenKeperawatanIGD = new widget.ButtonBig();
        btnAssesmenMedikIGD = new widget.ButtonBig();
        btnPenilaianAwalMedisRalanMata = new widget.ButtonBig();
        btnSuratIstirahatSakit = new widget.ButtonBig();
        btnSuratKeteranganSakit = new widget.ButtonBig();
        btnTransferSerahTerimaPasien = new widget.ButtonBig();
        btnSuratKeteranganNAPZA = new widget.ButtonBig();
        btnSuratKeteranganRohani = new widget.ButtonBig();
        btnSuratKeteranganDokter = new widget.ButtonBig();
        btnAsesmenMedikDewasaRanap = new widget.ButtonBig();
        btnPemberianObat = new widget.ButtonBig();
        btnCPPT = new widget.ButtonBig();
        btnSpirometri = new widget.ButtonBig();
        btnAsesmenKebidananRalan = new widget.ButtonBig();
        btnDashboardeResepRanap = new widget.ButtonBig();
        btnJadwalOperasi = new widget.ButtonBig();
        btnBangsal = new widget.ButtonBig();
        btnPersetujuanTindakan = new widget.ButtonBig();
        btnPetugasPelaksanaPemberianObat = new widget.ButtonBig();
        btnCatatanTindakanKeperawatan = new widget.ButtonBig();
        btnSuratKonsulUnitRanap = new widget.ButtonBig();
        btnSuratJawabanKonsulRanap = new widget.ButtonBig();
        btnMasterResikoDecubitus = new widget.ButtonBig();
        btnAsesmenKeperawatanDewasa = new widget.ButtonBig();
        btnReferensiDokterSatuSehat = new widget.ButtonBig();
        btnReferensiPasienSatuSehat = new widget.ButtonBig();
        btnMapingOrganisasiSatuSehat = new widget.ButtonBig();
        btnMapingLokasiSatuSehat = new widget.ButtonBig();
        btnMapingVaksinSatuSehat = new widget.ButtonBig();
        btnKirimEncounterSatuSehat = new widget.ButtonBig();
        btnKirimConditionSatuSehat = new widget.ButtonBig();
        btnKirimObservationSatuSehat = new widget.ButtonBig();
        btnKirimProsedurSatuSehat = new widget.ButtonBig();
        btnKirimImunisasiSatuSehat = new widget.ButtonBig();
        btnKirimClinicalSatuSehat = new widget.ButtonBig();
        btnKirimDietSatuSehat = new widget.ButtonBig();
        btnMapingObatSatuSehat = new widget.ButtonBig();
        btnPemantauanHarian24Jam = new widget.ButtonBig();
        btnKirimMedicationRequestSatuSehat = new widget.ButtonBig();
        btnKirimMedicationDispenseSatuSehat = new widget.ButtonBig();
        btnNotepad = new widget.ButtonBig();
        btnProtokolKemoterapi = new widget.ButtonBig();
        btnAsesmenUlangResikoJatuhDewasa = new widget.ButtonBig();
        btnPengelolaanTransfusiDarah = new widget.ButtonBig();
        btnMonitoringEWSDewasa = new widget.ButtonBig();
        btnMasterNomorDokumen = new widget.ButtonBig();
        btnAsesmenKeperawatanAnak = new widget.ButtonBig();
        btnAsesmenMedikAnakRanap = new widget.ButtonBig();
        btnMasterJenisDokumenJangMed = new widget.ButtonBig();
        btnAsesmenUlangResikoJatuhAnak = new widget.ButtonBig();
        btnMonitoringPediatricEWS = new widget.ButtonBig();
        btnAsesmenRestrain = new widget.ButtonBig();
        btnMasterDiagnosaGizi = new widget.ButtonBig();
        btnSkriningGiziUlang = new widget.ButtonBig();
        btnLembarObservasi = new widget.ButtonBig();
        btnTransaksiPanjar = new widget.ButtonBig();
        btnTransferPasienTindakan = new widget.ButtonBig();
        btnAsesmenPraSedasi = new widget.ButtonBig();
        btnMasterIndikatorNasionalMutu = new widget.ButtonBig();
        btnIndikatorNasionalMutu = new widget.ButtonBig();
        btnSuratKeteranganDisabilitas = new widget.ButtonBig();
        btnCeklisPraOperasi = new widget.ButtonBig();
        btnCeklisKesiapanAnestesi = new widget.ButtonBig();
        btnAsesmenPreInduksi = new widget.ButtonBig();
        btnMasterNumdenomINM = new widget.ButtonBig();
        btnAsesmenKeperawatanPerioperatif = new widget.ButtonBig();
        btnPerencanaanPulang = new widget.ButtonBig();
        tanggal = new widget.Tanggal();
        btnDataPenjualan = new widget.ButtonBig();
        btnInputPenjualan = new widget.ButtonBig();
        btnDataPenyerahanDarah = new widget.ButtonBig();
        internalFrame1 = new widget.InternalFrame();
        BtnMenu = new widget.ButtonBig();
        btnGantiPassword = new widget.ButtonBig();
        jSeparator4 = new javax.swing.JSeparator();
        BtnToolReg = new widget.ButtonBig();
        btnToolIGD = new widget.ButtonBig();
        jSeparator5 = new javax.swing.JSeparator();
        btnBridgingEklaim = new widget.ButtonBig();
        btnToolLab = new widget.ButtonBig();
        btnToolRad = new widget.ButtonBig();
        BtnToolJualObat = new widget.ButtonBig();
        BtnDasboard = new widget.ButtonBig();
        jSeparator9 = new javax.swing.JSeparator();
        BtnToolKamnap = new widget.ButtonBig();
        BtnToolKasir = new widget.ButtonBig();
        jSeparator7 = new javax.swing.JSeparator();
        BtnLog = new widget.ButtonBig();
        BtnClose = new widget.ButtonBig();
        internalFrame4 = new widget.InternalFrame();
        lblStts = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        kdUser = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblTgl = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        footer_lbl_update = new javax.swing.JLabel();
        PanelUtama = new javax.swing.JPanel();
        scrollPane1 = new widget.ScrollPane();
        PanelWall = new usu.widget.glass.PanelGlass();
        panelJudul = new usu.widget.glass.PanelGlass();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_update = new javax.swing.JLabel();
        Scroll21 = new widget.ScrollPane();
        ket_update = new widget.TextArea();
        jLabel13 = new javax.swing.JLabel();
        FlayMenu = new usu.widget.glass.PanelGlass();
        MenuBar = new widget.MenuBar();
        jMenu1 = new javax.swing.JMenu();
        MnJadwalDokterRalan = new javax.swing.JMenuItem();
        MnPasienRanap = new javax.swing.JMenuItem();
        MnTelusurKunjungan = new javax.swing.JMenuItem();
        MnPenggunaanKamarRanap = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        MnTarifLab = new javax.swing.JMenuItem();
        MnTarifRad = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        MnTarifRalan = new javax.swing.JMenuItem();
        MnTarifRanap = new javax.swing.JMenuItem();
        MnTarifKamar = new javax.swing.JMenuItem();
        MnTarifOperasi = new javax.swing.JMenuItem();
        MnTarifINACBG = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        DlgLogin.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        DlgLogin.setName("DlgLogin"); // NOI18N
        DlgLogin.setUndecorated(true);
        DlgLogin.setResizable(false);

        internalFrame2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(80, 120, 40)));
        internalFrame2.setName("internalFrame2"); // NOI18N
        internalFrame2.setWarnaAtas(new java.awt.Color(29, 188, 188));
        internalFrame2.setLayout(null);

        internalFrame3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, ":: Silahkan Anda Login ::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        internalFrame3.setName("internalFrame3"); // NOI18N
        internalFrame3.setWarnaAtas(new java.awt.Color(29, 188, 188));
        internalFrame3.setLayout(null);

        panelGlass1.setBackground(java.awt.Color.lightGray);
        panelGlass1.setOpaqueImage(false);
        panelGlass1.setRound(false);
        panelGlass1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("ID Admin :");
        jLabel4.setName("jLabel4"); // NOI18N
        panelGlass1.add(jLabel4);
        jLabel4.setBounds(2, 12, 80, 23);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Password :");
        jLabel5.setName("jLabel5"); // NOI18N
        panelGlass1.add(jLabel5);
        jLabel5.setBounds(2, 40, 80, 23);

        edPwd.setForeground(new java.awt.Color(0, 0, 0));
        edPwd.setToolTipText("Silahkan masukkan password");
        edPwd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        edPwd.setName("edPwd"); // NOI18N
        edPwd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edPwdKeyPressed(evt);
            }
        });
        panelGlass1.add(edPwd);
        edPwd.setBounds(85, 40, 220, 23);

        edAdmin.setForeground(new java.awt.Color(0, 0, 0));
        edAdmin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        edAdmin.setName("edAdmin"); // NOI18N
        edAdmin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edAdminKeyPressed(evt);
            }
        });
        panelGlass1.add(edAdmin);
        edAdmin.setBounds(85, 12, 220, 23);

        internalFrame3.add(panelGlass1);
        panelGlass1.setBounds(-1, 30, 342, 76);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/keys_security3.png"))); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N
        internalFrame3.add(jLabel6);
        jLabel6.setBounds(120, 5, 135, 145);

        BtnLogin.setForeground(new java.awt.Color(0, 0, 0));
        BtnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/lock.png"))); // NOI18N
        BtnLogin.setMnemonic('Z');
        BtnLogin.setText("Log-in");
        BtnLogin.setToolTipText("Alt+Z");
        BtnLogin.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnLogin.setName("BtnLogin"); // NOI18N
        BtnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLoginActionPerformed(evt);
            }
        });
        internalFrame3.add(BtnLogin);
        BtnLogin.setBounds(12, 125, 105, 32);

        BtnCancel.setForeground(new java.awt.Color(0, 0, 0));
        BtnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnCancel.setMnemonic('Y');
        BtnCancel.setText("Batal");
        BtnCancel.setToolTipText("Alt+Y");
        BtnCancel.setGlassColor(new java.awt.Color(255, 255, 255));
        BtnCancel.setName("BtnCancel"); // NOI18N
        BtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCancelActionPerformed(evt);
            }
        });
        internalFrame3.add(BtnCancel);
        BtnCancel.setBounds(222, 125, 105, 32);

        internalFrame2.add(internalFrame3);
        internalFrame3.setBounds(2, 15, 340, 170);

        DlgLogin.getContentPane().add(internalFrame2, java.awt.BorderLayout.CENTER);

        WindowInput.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        WindowInput.setModal(true);
        WindowInput.setName("WindowInput"); // NOI18N
        WindowInput.setUndecorated(true);
        WindowInput.setResizable(false);

        internalFrame6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 3), "::[ Ubah Password ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        internalFrame6.setName("internalFrame6"); // NOI18N
        internalFrame6.setWarnaBawah(new java.awt.Color(245, 250, 240));
        internalFrame6.setLayout(null);

        PassLama.setForeground(new java.awt.Color(0, 0, 0));
        PassLama.setHighlighter(null);
        PassLama.setName("PassLama"); // NOI18N
        internalFrame6.add(PassLama);
        PassLama.setBounds(128, 30, 190, 23);

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Password Lama :");
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N
        internalFrame6.add(jLabel9);
        jLabel9.setBounds(0, 30, 125, 23);

        BtnClosePass.setForeground(new java.awt.Color(0, 0, 0));
        BtnClosePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/cross.png"))); // NOI18N
        BtnClosePass.setMnemonic('2');
        BtnClosePass.setText("Tutup");
        BtnClosePass.setToolTipText("Alt+2");
        BtnClosePass.setName("BtnClosePass"); // NOI18N
        BtnClosePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClosePassActionPerformed(evt);
            }
        });
        BtnClosePass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnClosePassKeyPressed(evt);
            }
        });
        internalFrame6.add(BtnClosePass);
        BtnClosePass.setBounds(230, 130, 100, 30);

        BtnSimpanPass.setForeground(new java.awt.Color(0, 0, 0));
        BtnSimpanPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/save-16x16.png"))); // NOI18N
        BtnSimpanPass.setMnemonic('1');
        BtnSimpanPass.setText("Simpan");
        BtnSimpanPass.setToolTipText("Alt+1");
        BtnSimpanPass.setName("BtnSimpanPass"); // NOI18N
        BtnSimpanPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanPassActionPerformed(evt);
            }
        });
        BtnSimpanPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnSimpanPassKeyPressed(evt);
            }
        });
        internalFrame6.add(BtnSimpanPass);
        BtnSimpanPass.setBounds(20, 130, 100, 30);

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Password Baru :");
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N
        internalFrame6.add(jLabel10);
        jLabel10.setBounds(0, 60, 125, 23);

        Passbaru1.setForeground(new java.awt.Color(0, 0, 0));
        Passbaru1.setHighlighter(null);
        Passbaru1.setName("Passbaru1"); // NOI18N
        internalFrame6.add(Passbaru1);
        Passbaru1.setBounds(128, 60, 190, 23);

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Password Baru :");
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setName("jLabel12"); // NOI18N
        internalFrame6.add(jLabel12);
        jLabel12.setBounds(0, 90, 125, 23);

        PassBaru2.setForeground(new java.awt.Color(0, 0, 0));
        PassBaru2.setHighlighter(null);
        PassBaru2.setName("PassBaru2"); // NOI18N
        internalFrame6.add(PassBaru2);
        PassBaru2.setBounds(128, 90, 190, 23);

        WindowInput.getContentPane().add(internalFrame6, java.awt.BorderLayout.CENTER);

        DlgHome.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        DlgHome.setAlwaysOnTop(true);
        DlgHome.setIconImage(null);
        DlgHome.setName("DlgHome"); // NOI18N
        DlgHome.setUndecorated(true);
        DlgHome.setResizable(false);

        panelMenu.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 245, 225)), "::[ Menu Utama ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        panelMenu.setName("panelMenu"); // NOI18N
        panelMenu.setPreferredSize(new java.awt.Dimension(2412, 3653));
        panelMenu.setLayout(new java.awt.BorderLayout(1, 1));

        panelisi2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 245, 225)));
        panelisi2.setName("panelisi2"); // NOI18N
        panelisi2.setPreferredSize(new java.awt.Dimension(100, 39));
        panelisi2.setWarnaBawah(new java.awt.Color(252, 252, 248));
        panelisi2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 7));

        label36.setForeground(new java.awt.Color(0, 0, 0));
        label36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        label36.setName("label36"); // NOI18N
        label36.setPreferredSize(new java.awt.Dimension(1, 23));
        panelisi2.add(label36);

        button1.setForeground(new java.awt.Color(0, 0, 0));
        button1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        button1.setGlassColor(new java.awt.Color(255, 255, 255));
        button1.setMinimumSize(new java.awt.Dimension(28, 23));
        button1.setName("button1"); // NOI18N
        button1.setPreferredSize(new java.awt.Dimension(25, 23));
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        panelisi2.add(button1);

        label35.setForeground(new java.awt.Color(0, 0, 0));
        label35.setText("Tampilkan Menu :");
        label35.setName("label35"); // NOI18N
        label35.setPreferredSize(new java.awt.Dimension(105, 23));
        panelisi2.add(label35);

        cmbMenu.setForeground(new java.awt.Color(0, 0, 0));
        cmbMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "[A] Registrasi, Tagihan Ranap & Ralan, Pelayanan & Billing Pasien", "[B] Input Data Rekam Medis Elektronik Pasien", "[C] Manajemen & Kepegawaian Rumah Sakit", "[D] Transaksi Inventory Obat, BHP Medis, Alat Kesehatan Pasien", "[E] Transaksi Inventory Barang Non Medis dan Penunjang ( Lab & RO )", "[F] Aset & Inventaris Barang Rumah Sakit", "[G] Surat Menyurat", "[H] Manajemen Keuangan Rumah Sakit", "[I] Olah Data Penyakit, Laporan DKK, Laporal RL & Laporan Internal Rumah Sakit", "[J] Tarif Pelayanan & Keuangan Rumah Sakit", "[K] Bridging SEP, Aplicare, PCare, INACBG, Kemenkes & Pihak Ke 3", "[L] Olah Data Pasien", "[M] Unit Pelayanan Tranfusi Darah", "[N] Analisa, Dashboard & Info Grafik", "[O] Pengaturan Program Aplikasi HMS" }));
        cmbMenu.setName("cmbMenu"); // NOI18N
        cmbMenu.setPreferredSize(new java.awt.Dimension(470, 23));
        cmbMenu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMenuItemStateChanged(evt);
            }
        });
        panelisi2.add(cmbMenu);

        TCari.setForeground(new java.awt.Color(0, 0, 0));
        TCari.setName("TCari"); // NOI18N
        TCari.setPreferredSize(new java.awt.Dimension(470, 23));
        TCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCariKeyPressed(evt);
            }
        });
        panelisi2.add(TCari);

        ChkInput.setBorder(null);
        ChkInput.setForeground(new java.awt.Color(0, 0, 0));
        ChkInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/143.png"))); // NOI18N
        ChkInput.setMnemonic('C');
        ChkInput.setSelected(true);
        ChkInput.setText("Cari Menu");
        ChkInput.setToolTipText("Alt+C");
        ChkInput.setBorderPainted(true);
        ChkInput.setBorderPaintedFlat(true);
        ChkInput.setFocusable(false);
        ChkInput.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ChkInput.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ChkInput.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ChkInput.setName("ChkInput"); // NOI18N
        ChkInput.setOpaque(false);
        ChkInput.setPreferredSize(new java.awt.Dimension(100, 23));
        ChkInput.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/143.png"))); // NOI18N
        ChkInput.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        ChkInput.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        ChkInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkInputActionPerformed(evt);
            }
        });
        panelisi2.add(ChkInput);

        panelMenu.add(panelisi2, java.awt.BorderLayout.PAGE_START);

        scrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 245, 225)));
        scrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane2.setName("scrollPane2"); // NOI18N

        Panelmenu.setBorder(null);
        Panelmenu.setMinimumSize(new java.awt.Dimension(1975, 2826));
        Panelmenu.setName("Panelmenu"); // NOI18N
        Panelmenu.setLayout(new java.awt.GridLayout(0, 12));

        btnICD.setForeground(new java.awt.Color(0, 0, 0));
        btnICD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/icd_10.png"))); // NOI18N
        btnICD.setText("Master ICD 10");
        btnICD.setIconTextGap(0);
        btnICD.setName("btnICD"); // NOI18N
        btnICD.setPreferredSize(new java.awt.Dimension(200, 90));
        btnICD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnICDActionPerformed(evt);
            }
        });
        Panelmenu.add(btnICD);

        btnObat.setForeground(new java.awt.Color(0, 0, 0));
        btnObat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360815855_laboratory.png"))); // NOI18N
        btnObat.setText("Obat, Alkes & BHP");
        btnObat.setIconTextGap(0);
        btnObat.setName("btnObat"); // NOI18N
        btnObat.setPreferredSize(new java.awt.Dimension(200, 90));
        btnObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObatActionPerformed(evt);
            }
        });
        Panelmenu.add(btnObat);

        btnObatPenyakit.setForeground(new java.awt.Color(0, 0, 0));
        btnObatPenyakit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360484848_applications-science.png"))); // NOI18N
        btnObatPenyakit.setText("Obat Penyakit");
        btnObatPenyakit.setIconTextGap(0);
        btnObatPenyakit.setName("btnObatPenyakit"); // NOI18N
        btnObatPenyakit.setPreferredSize(new java.awt.Dimension(200, 90));
        btnObatPenyakit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObatPenyakitActionPerformed(evt);
            }
        });
        Panelmenu.add(btnObatPenyakit);

        btnKamar.setForeground(new java.awt.Color(0, 0, 0));
        btnKamar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/industry.png"))); // NOI18N
        btnKamar.setText("Kamar");
        btnKamar.setIconTextGap(0);
        btnKamar.setName("btnKamar"); // NOI18N
        btnKamar.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKamarActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKamar);

        btnTindakanRalan.setForeground(new java.awt.Color(0, 0, 0));
        btnTindakanRalan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/plaster.png"))); // NOI18N
        btnTindakanRalan.setText("Tarif Ralan");
        btnTindakanRalan.setIconTextGap(0);
        btnTindakanRalan.setName("btnTindakanRalan"); // NOI18N
        btnTindakanRalan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnTindakanRalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTindakanRalanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnTindakanRalan);

        btnDokter.setForeground(new java.awt.Color(0, 0, 0));
        btnDokter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/doctor2.png"))); // NOI18N
        btnDokter.setText("Dokter");
        btnDokter.setIconTextGap(0);
        btnDokter.setName("btnDokter"); // NOI18N
        btnDokter.setPreferredSize(new java.awt.Dimension(200, 90));
        btnDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDokterActionPerformed(evt);
            }
        });
        Panelmenu.add(btnDokter);

        btnPegawai.setForeground(new java.awt.Color(0, 0, 0));
        btnPegawai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/receptionist.png"))); // NOI18N
        btnPegawai.setText("Petugas");
        btnPegawai.setIconTextGap(0);
        btnPegawai.setName("btnPegawai"); // NOI18N
        btnPegawai.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPegawaiActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPegawai);

        btnPasien.setForeground(new java.awt.Color(0, 0, 0));
        btnPasien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/patient.png"))); // NOI18N
        btnPasien.setText("Pasien");
        btnPasien.setIconTextGap(0);
        btnPasien.setName("btnPasien"); // NOI18N
        btnPasien.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasienActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPasien);

        btnRegistrasi.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/checklist.png"))); // NOI18N
        btnRegistrasi.setText("Registrasi");
        btnRegistrasi.setIconTextGap(0);
        btnRegistrasi.setName("btnRegistrasi"); // NOI18N
        btnRegistrasi.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRegistrasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrasiActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRegistrasi);

        btnRalan.setForeground(new java.awt.Color(0, 0, 0));
        btnRalan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/folder.png"))); // NOI18N
        btnRalan.setText("Tindakan Ralan");
        btnRalan.setIconTextGap(0);
        btnRalan.setName("btnRalan"); // NOI18N
        btnRalan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRalanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRalan);

        btnKamarInap.setForeground(new java.awt.Color(0, 0, 0));
        btnKamarInap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Home.png"))); // NOI18N
        btnKamarInap.setText("Kamar Inap");
        btnKamarInap.setIconTextGap(0);
        btnKamarInap.setName("btnKamarInap"); // NOI18N
        btnKamarInap.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKamarInap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKamarInapActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKamarInap);

        btnRanap.setForeground(new java.awt.Color(0, 0, 0));
        btnRanap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/bedroom.png"))); // NOI18N
        btnRanap.setText("Tindakan Ranap");
        btnRanap.setIconTextGap(0);
        btnRanap.setName("btnRanap"); // NOI18N
        btnRanap.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRanap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRanapActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRanap);

        btnResepObat.setForeground(new java.awt.Color(0, 0, 0));
        btnResepObat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/stock_task.png"))); // NOI18N
        btnResepObat.setText("No. Resep");
        btnResepObat.setIconTextGap(0);
        btnResepObat.setName("btnResepObat"); // NOI18N
        btnResepObat.setPreferredSize(new java.awt.Dimension(200, 90));
        btnResepObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResepObatActionPerformed(evt);
            }
        });
        Panelmenu.add(btnResepObat);

        btnRujukPasien.setForeground(new java.awt.Color(0, 0, 0));
        btnRujukPasien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1485357758_Doctor.png"))); // NOI18N
        btnRujukPasien.setText("Rujukan Keluar");
        btnRujukPasien.setIconTextGap(0);
        btnRujukPasien.setName("btnRujukPasien"); // NOI18N
        btnRujukPasien.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRujukPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRujukPasienActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRujukPasien);

        btnBeriObat.setForeground(new java.awt.Color(0, 0, 0));
        btnBeriObat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/first_aid_kit.png"))); // NOI18N
        btnBeriObat.setText("Beri Obat/BHP");
        btnBeriObat.setIconTextGap(0);
        btnBeriObat.setName("btnBeriObat"); // NOI18N
        btnBeriObat.setPreferredSize(new java.awt.Dimension(200, 90));
        btnBeriObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBeriObatActionPerformed(evt);
            }
        });
        Panelmenu.add(btnBeriObat);

        btnPasienMati.setForeground(new java.awt.Color(0, 0, 0));
        btnPasienMati.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Ambulance.png"))); // NOI18N
        btnPasienMati.setText("Pasien Meninggal");
        btnPasienMati.setIconTextGap(0);
        btnPasienMati.setName("btnPasienMati"); // NOI18N
        btnPasienMati.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPasienMati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasienMatiActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPasienMati);

        btnAdmin.setForeground(new java.awt.Color(0, 0, 0));
        btnAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/users.png"))); // NOI18N
        btnAdmin.setText("Set Admin/Petugas Khusus/Pejabat");
        btnAdmin.setIconTextGap(0);
        btnAdmin.setName("btnAdmin"); // NOI18N
        btnAdmin.setPreferredSize(new java.awt.Dimension(200, 90));
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
            }
        });
        Panelmenu.add(btnAdmin);

        btnUser.setForeground(new java.awt.Color(0, 0, 0));
        btnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360484978_application-pgp-signature.png"))); // NOI18N
        btnUser.setText("Set User");
        btnUser.setIconTextGap(0);
        btnUser.setName("btnUser"); // NOI18N
        btnUser.setPreferredSize(new java.awt.Dimension(200, 90));
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });
        Panelmenu.add(btnUser);

        btnAntrian.setForeground(new java.awt.Color(0, 0, 0));
        btnAntrian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/demographic.png"))); // NOI18N
        btnAntrian.setText("Set Antrian");
        btnAntrian.setIconTextGap(0);
        btnAntrian.setName("btnAntrian"); // NOI18N
        btnAntrian.setPreferredSize(new java.awt.Dimension(200, 90));
        btnAntrian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAntrianActionPerformed(evt);
            }
        });
        Panelmenu.add(btnAntrian);

        btnSetupHarga.setForeground(new java.awt.Color(0, 0, 0));
        btnSetupHarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360487093_price.png"))); // NOI18N
        btnSetupHarga.setText("Set Harga Obat");
        btnSetupHarga.setIconTextGap(0);
        btnSetupHarga.setName("btnSetupHarga"); // NOI18N
        btnSetupHarga.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSetupHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetupHargaActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSetupHarga);

        btnSuplier.setForeground(new java.awt.Color(0, 0, 0));
        btnSuplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1485357959_truck.png"))); // NOI18N
        btnSuplier.setText("Suplier Obat/Alkes/BHP");
        btnSuplier.setIconTextGap(0);
        btnSuplier.setName("btnSuplier"); // NOI18N
        btnSuplier.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSuplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuplierActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSuplier);

        btnJnsBarang.setForeground(new java.awt.Color(0, 0, 0));
        btnJnsBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Card_file.png"))); // NOI18N
        btnJnsBarang.setText("Jenis Obat, Alkes & BHP");
        btnJnsBarang.setIconTextGap(0);
        btnJnsBarang.setName("btnJnsBarang"); // NOI18N
        btnJnsBarang.setPreferredSize(new java.awt.Dimension(200, 90));
        btnJnsBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJnsBarangActionPerformed(evt);
            }
        });
        Panelmenu.add(btnJnsBarang);

        btnKonversi.setForeground(new java.awt.Color(0, 0, 0));
        btnKonversi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/ark2.png"))); // NOI18N
        btnKonversi.setText("Konversi Satuan");
        btnKonversi.setIconTextGap(0);
        btnKonversi.setName("btnKonversi"); // NOI18N
        btnKonversi.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKonversi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKonversiActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKonversi);

        btnSatuan.setForeground(new java.awt.Color(0, 0, 0));
        btnSatuan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/bag1.png"))); // NOI18N
        btnSatuan.setText("Satuan Barang");
        btnSatuan.setIconTextGap(0);
        btnSatuan.setName("btnSatuan"); // NOI18N
        btnSatuan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSatuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSatuanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSatuan);

        btnCashFlow.setForeground(new java.awt.Color(0, 0, 0));
        btnCashFlow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360486845_23.png"))); // NOI18N
        btnCashFlow.setText("Cash Flow");
        btnCashFlow.setIconTextGap(0);
        btnCashFlow.setName("btnCashFlow"); // NOI18N
        btnCashFlow.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCashFlow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCashFlowActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCashFlow);

        btnBubes.setForeground(new java.awt.Color(0, 0, 0));
        btnBubes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/applications-office.png"))); // NOI18N
        btnBubes.setText("Buku Besar");
        btnBubes.setIconTextGap(0);
        btnBubes.setName("btnBubes"); // NOI18N
        btnBubes.setPreferredSize(new java.awt.Dimension(200, 90));
        btnBubes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBubesActionPerformed(evt);
            }
        });
        Panelmenu.add(btnBubes);

        btnPostingJurnal.setForeground(new java.awt.Color(0, 0, 0));
        btnPostingJurnal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360485642_edit-notes.png"))); // NOI18N
        btnPostingJurnal.setText("Posting Jurnal");
        btnPostingJurnal.setIconTextGap(0);
        btnPostingJurnal.setName("btnPostingJurnal"); // NOI18N
        btnPostingJurnal.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPostingJurnal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostingJurnalActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPostingJurnal);

        btnRekeningTahun.setForeground(new java.awt.Color(0, 0, 0));
        btnRekeningTahun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/money_bag.png"))); // NOI18N
        btnRekeningTahun.setText("Rekening Tahun");
        btnRekeningTahun.setIconTextGap(0);
        btnRekeningTahun.setName("btnRekeningTahun"); // NOI18N
        btnRekeningTahun.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRekeningTahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRekeningTahunActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRekeningTahun);

        btnRekening.setForeground(new java.awt.Color(0, 0, 0));
        btnRekening.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/kwrite.png"))); // NOI18N
        btnRekening.setText("Akun Rekening");
        btnRekening.setIconTextGap(0);
        btnRekening.setName("btnRekening"); // NOI18N
        btnRekening.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRekening.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRekeningActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRekening);

        btnPembelian.setForeground(new java.awt.Color(0, 0, 0));
        btnPembelian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360487067_calculator.png"))); // NOI18N
        btnPembelian.setText("Pengadaan Obat & BHP");
        btnPembelian.setIconTextGap(0);
        btnPembelian.setName("btnPembelian"); // NOI18N
        btnPembelian.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPembelianActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPembelian);

        btnPenjualan.setForeground(new java.awt.Color(0, 0, 0));
        btnPenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/cashbox.png"))); // NOI18N
        btnPenjualan.setText("Penjualan Obat & BHP");
        btnPenjualan.setIconTextGap(0);
        btnPenjualan.setName("btnPenjualan"); // NOI18N
        btnPenjualan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenjualanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPenjualan);

        btnPiutang.setForeground(new java.awt.Color(0, 0, 0));
        btnPiutang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/checklist.png"))); // NOI18N
        btnPiutang.setText("Piutang Obat & BHP");
        btnPiutang.setIconTextGap(0);
        btnPiutang.setName("btnPiutang"); // NOI18N
        btnPiutang.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPiutang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPiutangActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPiutang);

        btnBayarPiutang.setForeground(new java.awt.Color(0, 0, 0));
        btnBayarPiutang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1404046811_money.png"))); // NOI18N
        btnBayarPiutang.setText("Bayar Piutang");
        btnBayarPiutang.setIconTextGap(0);
        btnBayarPiutang.setName("btnBayarPiutang"); // NOI18N
        btnBayarPiutang.setPreferredSize(new java.awt.Dimension(200, 90));
        btnBayarPiutang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarPiutangActionPerformed(evt);
            }
        });
        Panelmenu.add(btnBayarPiutang);

        btnOpname.setForeground(new java.awt.Color(0, 0, 0));
        btnOpname.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360487078_shipping.png"))); // NOI18N
        btnOpname.setText("Stok Opname Obat & BHP");
        btnOpname.setIconTextGap(0);
        btnOpname.setName("btnOpname"); // NOI18N
        btnOpname.setPreferredSize(new java.awt.Dimension(200, 90));
        btnOpname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpnameActionPerformed(evt);
            }
        });
        Panelmenu.add(btnOpname);

        btnReturBeli.setForeground(new java.awt.Color(0, 0, 0));
        btnReturBeli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360816189_arrow_down.png"))); // NOI18N
        btnReturBeli.setText("Retur Ke Suplier");
        btnReturBeli.setIconTextGap(0);
        btnReturBeli.setName("btnReturBeli"); // NOI18N
        btnReturBeli.setPreferredSize(new java.awt.Dimension(200, 90));
        btnReturBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturBeliActionPerformed(evt);
            }
        });
        Panelmenu.add(btnReturBeli);

        btnReturJual.setForeground(new java.awt.Color(0, 0, 0));
        btnReturJual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360486142_shopping_cart.png"))); // NOI18N
        btnReturJual.setText("Retur Dari Pembeli");
        btnReturJual.setIconTextGap(0);
        btnReturJual.setName("btnReturJual"); // NOI18N
        btnReturJual.setPreferredSize(new java.awt.Dimension(200, 90));
        btnReturJual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturJualActionPerformed(evt);
            }
        });
        Panelmenu.add(btnReturJual);

        btnSirkulasi.setForeground(new java.awt.Color(0, 0, 0));
        btnSirkulasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360487125_system-restart-panel.png"))); // NOI18N
        btnSirkulasi.setText("Sirkulasi Obat, Alkes & BHP");
        btnSirkulasi.setIconTextGap(0);
        btnSirkulasi.setName("btnSirkulasi"); // NOI18N
        btnSirkulasi.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSirkulasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSirkulasiActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSirkulasi);

        btnKeuntungan.setForeground(new java.awt.Color(0, 0, 0));
        btnKeuntungan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/coins.png"))); // NOI18N
        btnKeuntungan.setText("Keuntungan Penjualan");
        btnKeuntungan.setIconTextGap(0);
        btnKeuntungan.setName("btnKeuntungan"); // NOI18N
        btnKeuntungan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKeuntungan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeuntunganActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKeuntungan);

        btnLabaRugi.setForeground(new java.awt.Color(0, 0, 0));
        btnLabaRugi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360486822_20.png"))); // NOI18N
        btnLabaRugi.setText("Keuangan");
        btnLabaRugi.setIconTextGap(0);
        btnLabaRugi.setName("btnLabaRugi"); // NOI18N
        btnLabaRugi.setPreferredSize(new java.awt.Dimension(200, 90));
        btnLabaRugi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLabaRugiActionPerformed(evt);
            }
        });
        Panelmenu.add(btnLabaRugi);

        btnReturPiutang.setForeground(new java.awt.Color(0, 0, 0));
        btnReturPiutang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/custom-reports.png"))); // NOI18N
        btnReturPiutang.setText("Retur Piutang Pembeli");
        btnReturPiutang.setIconTextGap(0);
        btnReturPiutang.setName("btnReturPiutang"); // NOI18N
        btnReturPiutang.setPreferredSize(new java.awt.Dimension(200, 90));
        btnReturPiutang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturPiutangActionPerformed(evt);
            }
        });
        Panelmenu.add(btnReturPiutang);

        btnAnalisaKamar.setForeground(new java.awt.Color(0, 0, 0));
        btnAnalisaKamar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1485357890_hospital.png"))); // NOI18N
        btnAnalisaKamar.setText("Informasi Kamar");
        btnAnalisaKamar.setIconTextGap(0);
        btnAnalisaKamar.setName("btnAnalisaKamar"); // NOI18N
        btnAnalisaKamar.setPreferredSize(new java.awt.Dimension(200, 90));
        btnAnalisaKamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisaKamarActionPerformed(evt);
            }
        });
        Panelmenu.add(btnAnalisaKamar);

        btnTagihanMasuk.setForeground(new java.awt.Color(0, 0, 0));
        btnTagihanMasuk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1404046800_Cash_register.png"))); // NOI18N
        btnTagihanMasuk.setText("Tagihan Masuk");
        btnTagihanMasuk.setIconTextGap(0);
        btnTagihanMasuk.setName("btnTagihanMasuk"); // NOI18N
        btnTagihanMasuk.setPreferredSize(new java.awt.Dimension(200, 90));
        btnTagihanMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTagihanMasukActionPerformed(evt);
            }
        });
        Panelmenu.add(btnTagihanMasuk);

        btnResume.setForeground(new java.awt.Color(0, 0, 0));
        btnResume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360816018_tests.png"))); // NOI18N
        btnResume.setText("Riwayat Perawatan");
        btnResume.setIconTextGap(0);
        btnResume.setName("btnResume"); // NOI18N
        btnResume.setPreferredSize(new java.awt.Dimension(200, 90));
        btnResume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResumeActionPerformed(evt);
            }
        });
        Panelmenu.add(btnResume);

        btnDiet.setForeground(new java.awt.Color(0, 0, 0));
        btnDiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360486936_pie-chart.png"))); // NOI18N
        btnDiet.setText("Diet Pasien");
        btnDiet.setIconTextGap(0);
        btnDiet.setName("btnDiet"); // NOI18N
        btnDiet.setPreferredSize(new java.awt.Dimension(200, 90));
        btnDiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDietActionPerformed(evt);
            }
        });
        Panelmenu.add(btnDiet);

        btnKasir.setForeground(new java.awt.Color(0, 0, 0));
        btnKasir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/cashbox.png"))); // NOI18N
        btnKasir.setText("Kasir Ralan");
        btnKasir.setIconTextGap(0);
        btnKasir.setName("btnKasir"); // NOI18N
        btnKasir.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKasirActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKasir);

        btnLahir.setForeground(new java.awt.Color(0, 0, 0));
        btnLahir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/baby-girl.png"))); // NOI18N
        btnLahir.setText("Kelahiran Bayi");
        btnLahir.setIconTextGap(0);
        btnLahir.setName("btnLahir"); // NOI18N
        btnLahir.setPreferredSize(new java.awt.Dimension(200, 90));
        btnLahir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLahirActionPerformed(evt);
            }
        });
        Panelmenu.add(btnLahir);

        btnSetBiayaHarian.setForeground(new java.awt.Color(0, 0, 0));
        btnSetBiayaHarian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360486845_23.png"))); // NOI18N
        btnSetBiayaHarian.setText("Biaya Harian");
        btnSetBiayaHarian.setIconTextGap(0);
        btnSetBiayaHarian.setName("btnSetBiayaHarian"); // NOI18N
        btnSetBiayaHarian.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSetBiayaHarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetBiayaHarianActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSetBiayaHarian);

        btnJenisInventaris.setForeground(new java.awt.Color(0, 0, 0));
        btnJenisInventaris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/cabinet.png"))); // NOI18N
        btnJenisInventaris.setText("Jenis");
        btnJenisInventaris.setIconTextGap(0);
        btnJenisInventaris.setName("btnJenisInventaris"); // NOI18N
        btnJenisInventaris.setPreferredSize(new java.awt.Dimension(200, 90));
        btnJenisInventaris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJenisInventarisActionPerformed(evt);
            }
        });
        Panelmenu.add(btnJenisInventaris);

        btnKategoriInventaris.setForeground(new java.awt.Color(0, 0, 0));
        btnKategoriInventaris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360487078_shipping.png"))); // NOI18N
        btnKategoriInventaris.setText("Kategori");
        btnKategoriInventaris.setIconTextGap(0);
        btnKategoriInventaris.setName("btnKategoriInventaris"); // NOI18N
        btnKategoriInventaris.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKategoriInventaris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKategoriInventarisActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKategoriInventaris);

        btnLihatPiutang.setForeground(new java.awt.Color(0, 0, 0));
        btnLihatPiutang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/checklist_pencil-o.png"))); // NOI18N
        btnLihatPiutang.setText("Piutang Pasien");
        btnLihatPiutang.setIconTextGap(0);
        btnLihatPiutang.setName("btnLihatPiutang"); // NOI18N
        btnLihatPiutang.setPreferredSize(new java.awt.Dimension(200, 90));
        btnLihatPiutang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLihatPiutangActionPerformed(evt);
            }
        });
        Panelmenu.add(btnLihatPiutang);

        btnLaboratorium.setForeground(new java.awt.Color(0, 0, 0));
        btnLaboratorium.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/sign-up.png"))); // NOI18N
        btnLaboratorium.setText("Periksa Lab");
        btnLaboratorium.setIconTextGap(0);
        btnLaboratorium.setName("btnLaboratorium"); // NOI18N
        btnLaboratorium.setPreferredSize(new java.awt.Dimension(200, 90));
        btnLaboratorium.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaboratoriumActionPerformed(evt);
            }
        });
        Panelmenu.add(btnLaboratorium);

        btnRalanMasuk.setForeground(new java.awt.Color(0, 0, 0));
        btnRalanMasuk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1404047007_02.png"))); // NOI18N
        btnRalanMasuk.setText("Pembayaran Ralan");
        btnRalanMasuk.setIconTextGap(0);
        btnRalanMasuk.setName("btnRalanMasuk"); // NOI18N
        btnRalanMasuk.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRalanMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRalanMasukActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRalanMasuk);

        btnSetupAplikasi.setForeground(new java.awt.Color(0, 0, 0));
        btnSetupAplikasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/local_network.png"))); // NOI18N
        btnSetupAplikasi.setText("Set Aplikasi");
        btnSetupAplikasi.setIconTextGap(0);
        btnSetupAplikasi.setName("btnSetupAplikasi"); // NOI18N
        btnSetupAplikasi.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSetupAplikasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetupAplikasiActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSetupAplikasi);

        btnSetOtoRalan.setForeground(new java.awt.Color(0, 0, 0));
        btnSetOtoRalan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/stethoscope (1).png"))); // NOI18N
        btnSetOtoRalan.setText("Set Oto Ralan");
        btnSetOtoRalan.setIconTextGap(0);
        btnSetOtoRalan.setName("btnSetOtoRalan"); // NOI18N
        btnSetOtoRalan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSetOtoRalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetOtoRalanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSetOtoRalan);

        btnRanapMasuk.setForeground(new java.awt.Color(0, 0, 0));
        btnRanapMasuk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1404047007_02.png"))); // NOI18N
        btnRanapMasuk.setText("Pembayaran Ranap");
        btnRanapMasuk.setIconTextGap(0);
        btnRanapMasuk.setName("btnRanapMasuk"); // NOI18N
        btnRanapMasuk.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRanapMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRanapMasukActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRanapMasuk);

        btnProdusenInventaris.setForeground(new java.awt.Color(0, 0, 0));
        btnProdusenInventaris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/industry.png"))); // NOI18N
        btnProdusenInventaris.setText("Produsen");
        btnProdusenInventaris.setIconTextGap(0);
        btnProdusenInventaris.setName("btnProdusenInventaris"); // NOI18N
        btnProdusenInventaris.setPreferredSize(new java.awt.Dimension(200, 90));
        btnProdusenInventaris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdusenInventarisActionPerformed(evt);
            }
        });
        Panelmenu.add(btnProdusenInventaris);

        btnSetBiayaMasukSekali.setForeground(new java.awt.Color(0, 0, 0));
        btnSetBiayaMasukSekali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360486845_23.png"))); // NOI18N
        btnSetBiayaMasukSekali.setText("Biaya Masuk Sekali");
        btnSetBiayaMasukSekali.setIconTextGap(0);
        btnSetBiayaMasukSekali.setName("btnSetBiayaMasukSekali"); // NOI18N
        btnSetBiayaMasukSekali.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSetBiayaMasukSekali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetBiayaMasukSekaliActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSetBiayaMasukSekali);

        btnPaketOperasi.setForeground(new java.awt.Color(0, 0, 0));
        btnPaketOperasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360487111_stock_paste.png"))); // NOI18N
        btnPaketOperasi.setText("Tarif Operasi/VK");
        btnPaketOperasi.setIconTextGap(0);
        btnPaketOperasi.setName("btnPaketOperasi"); // NOI18N
        btnPaketOperasi.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPaketOperasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaketOperasiActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPaketOperasi);

        btnTagihanOperasi.setForeground(new java.awt.Color(0, 0, 0));
        btnTagihanOperasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/surgeon.png"))); // NOI18N
        btnTagihanOperasi.setText("Operasi/VK");
        btnTagihanOperasi.setIconTextGap(0);
        btnTagihanOperasi.setName("btnTagihanOperasi"); // NOI18N
        btnTagihanOperasi.setPreferredSize(new java.awt.Dimension(200, 90));
        btnTagihanOperasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTagihanOperasiActionPerformed(evt);
            }
        });
        Panelmenu.add(btnTagihanOperasi);

        BtnJadwal.setForeground(new java.awt.Color(0, 0, 0));
        BtnJadwal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/doctor 3.png"))); // NOI18N
        BtnJadwal.setText("Jadwal Praktek");
        BtnJadwal.setIconTextGap(0);
        BtnJadwal.setName("BtnJadwal"); // NOI18N
        BtnJadwal.setPreferredSize(new java.awt.Dimension(200, 90));
        BtnJadwal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnJadwalActionPerformed(evt);
            }
        });
        Panelmenu.add(BtnJadwal);

        btnMerkInventaris.setForeground(new java.awt.Color(0, 0, 0));
        btnMerkInventaris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/bag1.png"))); // NOI18N
        btnMerkInventaris.setText("Merk");
        btnMerkInventaris.setIconTextGap(0);
        btnMerkInventaris.setName("btnMerkInventaris"); // NOI18N
        btnMerkInventaris.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMerkInventaris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMerkInventarisActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMerkInventaris);

        btnRuangInventaris.setForeground(new java.awt.Color(0, 0, 0));
        btnRuangInventaris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/bedroom.png"))); // NOI18N
        btnRuangInventaris.setText("Ruang");
        btnRuangInventaris.setIconTextGap(0);
        btnRuangInventaris.setName("btnRuangInventaris"); // NOI18N
        btnRuangInventaris.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRuangInventaris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRuangInventarisActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRuangInventaris);

        btnBarangInventaris.setForeground(new java.awt.Color(0, 0, 0));
        btnBarangInventaris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/fax.png"))); // NOI18N
        btnBarangInventaris.setText("Koleksi");
        btnBarangInventaris.setIconTextGap(0);
        btnBarangInventaris.setName("btnBarangInventaris"); // NOI18N
        btnBarangInventaris.setPreferredSize(new java.awt.Dimension(200, 90));
        btnBarangInventaris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarangInventarisActionPerformed(evt);
            }
        });
        Panelmenu.add(btnBarangInventaris);

        btnInventaris.setForeground(new java.awt.Color(0, 0, 0));
        btnInventaris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360486921_bar-code.png"))); // NOI18N
        btnInventaris.setText("Inventaris");
        btnInventaris.setIconTextGap(0);
        btnInventaris.setName("btnInventaris"); // NOI18N
        btnInventaris.setPreferredSize(new java.awt.Dimension(200, 90));
        btnInventaris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarisActionPerformed(evt);
            }
        });
        Panelmenu.add(btnInventaris);

        btnSirkulasiInventaris.setForeground(new java.awt.Color(0, 0, 0));
        btnSirkulasiInventaris.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360487125_system-restart-panel.png"))); // NOI18N
        btnSirkulasiInventaris.setText("Sirkulasi Inventaris");
        btnSirkulasiInventaris.setIconTextGap(0);
        btnSirkulasiInventaris.setName("btnSirkulasiInventaris"); // NOI18N
        btnSirkulasiInventaris.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSirkulasiInventaris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSirkulasiInventarisActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSirkulasiInventaris);

        btnFrekuensiRalan.setForeground(new java.awt.Color(0, 0, 0));
        btnFrekuensiRalan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Gnome-X-Office-Address-Book-48.png"))); // NOI18N
        btnFrekuensiRalan.setText("Frekuensi Penyakit Ralan");
        btnFrekuensiRalan.setIconTextGap(0);
        btnFrekuensiRalan.setName("btnFrekuensiRalan"); // NOI18N
        btnFrekuensiRalan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnFrekuensiRalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFrekuensiRalanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnFrekuensiRalan);

        btnFrekuensiRanap.setForeground(new java.awt.Color(0, 0, 0));
        btnFrekuensiRanap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/applications-office.png"))); // NOI18N
        btnFrekuensiRanap.setText("Frekuensi Penyakit Ranap");
        btnFrekuensiRanap.setIconTextGap(0);
        btnFrekuensiRanap.setName("btnFrekuensiRanap"); // NOI18N
        btnFrekuensiRanap.setPreferredSize(new java.awt.Dimension(200, 90));
        btnFrekuensiRanap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFrekuensiRanapActionPerformed(evt);
            }
        });
        Panelmenu.add(btnFrekuensiRanap);

        btnSetupOtoLokasi.setForeground(new java.awt.Color(0, 0, 0));
        btnSetupOtoLokasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/our_process_2.png"))); // NOI18N
        btnSetupOtoLokasi.setText("Set Oto Lokasi");
        btnSetupOtoLokasi.setIconTextGap(0);
        btnSetupOtoLokasi.setName("btnSetupOtoLokasi"); // NOI18N
        btnSetupOtoLokasi.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSetupOtoLokasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetupOtoLokasiActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSetupOtoLokasi);

        btnRujukMasuk.setForeground(new java.awt.Color(0, 0, 0));
        btnRujukMasuk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1404047834_application-vnd.ms-excel.png"))); // NOI18N
        btnRujukMasuk.setText("Rujukan Masuk");
        btnRujukMasuk.setIconTextGap(0);
        btnRujukMasuk.setName("btnRujukMasuk"); // NOI18N
        btnRujukMasuk.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRujukMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRujukMasukActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRujukMasuk);

        btnTracker.setForeground(new java.awt.Color(0, 0, 0));
        btnTracker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/receptionist.png"))); // NOI18N
        btnTracker.setText("Tracker Login");
        btnTracker.setIconTextGap(0);
        btnTracker.setName("btnTracker"); // NOI18N
        btnTracker.setPreferredSize(new java.awt.Dimension(200, 90));
        btnTracker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrackerActionPerformed(evt);
            }
        });
        Panelmenu.add(btnTracker);

        btnTindakanRanap.setForeground(new java.awt.Color(0, 0, 0));
        btnTindakanRanap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/doctor (2).png"))); // NOI18N
        btnTindakanRanap.setText("Tarif Ranap");
        btnTindakanRanap.setIconTextGap(0);
        btnTindakanRanap.setName("btnTindakanRanap"); // NOI18N
        btnTindakanRanap.setPreferredSize(new java.awt.Dimension(200, 90));
        btnTindakanRanap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTindakanRanapActionPerformed(evt);
            }
        });
        Panelmenu.add(btnTindakanRanap);

        btnSetupJamInap.setForeground(new java.awt.Color(0, 0, 0));
        btnSetupJamInap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Time.png"))); // NOI18N
        btnSetupJamInap.setText("Set Kamar Inap");
        btnSetupJamInap.setIconTextGap(0);
        btnSetupJamInap.setName("btnSetupJamInap"); // NOI18N
        btnSetupJamInap.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSetupJamInap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetupJamInapActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSetupJamInap);

        btnStokObatPasien.setForeground(new java.awt.Color(0, 0, 0));
        btnStokObatPasien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360487078_shipping.png"))); // NOI18N
        btnStokObatPasien.setText("Stok Obat Pasien");
        btnStokObatPasien.setIconTextGap(0);
        btnStokObatPasien.setName("btnStokObatPasien"); // NOI18N
        btnStokObatPasien.setPreferredSize(new java.awt.Dimension(200, 90));
        btnStokObatPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStokObatPasienActionPerformed(evt);
            }
        });
        Panelmenu.add(btnStokObatPasien);

        btnTarifLab.setForeground(new java.awt.Color(0, 0, 0));
        btnTarifLab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/address-book.png"))); // NOI18N
        btnTarifLab.setText("Tarif Lab");
        btnTarifLab.setIconTextGap(0);
        btnTarifLab.setName("btnTarifLab"); // NOI18N
        btnTarifLab.setPreferredSize(new java.awt.Dimension(200, 90));
        btnTarifLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarifLabActionPerformed(evt);
            }
        });
        Panelmenu.add(btnTarifLab);

        btnSetPenjab.setForeground(new java.awt.Color(0, 0, 0));
        btnSetPenjab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/user3.png"))); // NOI18N
        btnSetPenjab.setText("Set P.J. Unit Penunjang & Bridgingnya");
        btnSetPenjab.setIconTextGap(0);
        btnSetPenjab.setName("btnSetPenjab"); // NOI18N
        btnSetPenjab.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSetPenjab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetPenjabActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSetPenjab);

        btnReturPasien.setForeground(new java.awt.Color(0, 0, 0));
        btnReturPasien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360815295_medical_case.png"))); // NOI18N
        btnReturPasien.setText("Retur Obat Ranap");
        btnReturPasien.setIconTextGap(0);
        btnReturPasien.setName("btnReturPasien"); // NOI18N
        btnReturPasien.setPreferredSize(new java.awt.Dimension(200, 90));
        btnReturPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturPasienActionPerformed(evt);
            }
        });
        Panelmenu.add(btnReturPasien);

        btnKeuntunganObatRanap.setForeground(new java.awt.Color(0, 0, 0));
        btnKeuntunganObatRanap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/coins.png"))); // NOI18N
        btnKeuntunganObatRanap.setText("Keuntungan Beri Obat ");
        btnKeuntunganObatRanap.setIconTextGap(0);
        btnKeuntunganObatRanap.setName("btnKeuntunganObatRanap"); // NOI18N
        btnKeuntunganObatRanap.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKeuntunganObatRanap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeuntunganObatRanapActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKeuntunganObatRanap);

        btnPenggajian.setForeground(new java.awt.Color(0, 0, 0));
        btnPenggajian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1404046603_wallet.png"))); // NOI18N
        btnPenggajian.setText("Kepegawaian");
        btnPenggajian.setIconTextGap(0);
        btnPenggajian.setName("btnPenggajian"); // NOI18N
        btnPenggajian.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPenggajian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenggajianActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPenggajian);

        btnDeposit.setForeground(new java.awt.Color(0, 0, 0));
        btnDeposit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Money.png"))); // NOI18N
        btnDeposit.setText("Deposit Pasien");
        btnDeposit.setIconTextGap(0);
        btnDeposit.setName("btnDeposit"); // NOI18N
        btnDeposit.setPreferredSize(new java.awt.Dimension(200, 90));
        btnDeposit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDepositActionPerformed(evt);
            }
        });
        Panelmenu.add(btnDeposit);

        btnSetupRM.setForeground(new java.awt.Color(0, 0, 0));
        btnSetupRM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/patient (1).png"))); // NOI18N
        btnSetupRM.setText("Set Rekam Medis");
        btnSetupRM.setIconTextGap(0);
        btnSetupRM.setName("btnSetupRM"); // NOI18N
        btnSetupRM.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSetupRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetupRMActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSetupRM);

        btnResepPulang.setForeground(new java.awt.Color(0, 0, 0));
        btnResepPulang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360485642_edit-notes.png"))); // NOI18N
        btnResepPulang.setText("Resep Pulang");
        btnResepPulang.setIconTextGap(0);
        btnResepPulang.setName("btnResepPulang"); // NOI18N
        btnResepPulang.setPreferredSize(new java.awt.Dimension(200, 90));
        btnResepPulang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResepPulangActionPerformed(evt);
            }
        });
        Panelmenu.add(btnResepPulang);

        btnSetupTarif.setForeground(new java.awt.Color(0, 0, 0));
        btnSetupTarif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/x-office-address-book.png"))); // NOI18N
        btnSetupTarif.setText("Set Penggunaan Tarif");
        btnSetupTarif.setIconTextGap(0);
        btnSetupTarif.setName("btnSetupTarif"); // NOI18N
        btnSetupTarif.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSetupTarif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetupTarifActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSetupTarif);

        btnBarangIpsrs.setForeground(new java.awt.Color(0, 0, 0));
        btnBarangIpsrs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360487078_shipping.png"))); // NOI18N
        btnBarangIpsrs.setText("Barang");
        btnBarangIpsrs.setIconTextGap(0);
        btnBarangIpsrs.setName("btnBarangIpsrs"); // NOI18N
        btnBarangIpsrs.setPreferredSize(new java.awt.Dimension(200, 90));
        btnBarangIpsrs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarangIpsrsActionPerformed(evt);
            }
        });
        Panelmenu.add(btnBarangIpsrs);

        btnPembelianIpsrs.setForeground(new java.awt.Color(0, 0, 0));
        btnPembelianIpsrs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/inventory-maintenance.png"))); // NOI18N
        btnPembelianIpsrs.setText("Pengadaan Barang");
        btnPembelianIpsrs.setIconTextGap(0);
        btnPembelianIpsrs.setName("btnPembelianIpsrs"); // NOI18N
        btnPembelianIpsrs.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPembelianIpsrs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPembelianIpsrsActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPembelianIpsrs);

        btnPengeluaranIpsrs.setForeground(new java.awt.Color(0, 0, 0));
        btnPengeluaranIpsrs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/shopping-basket-full.png"))); // NOI18N
        btnPengeluaranIpsrs.setText("Stok Keluar");
        btnPengeluaranIpsrs.setIconTextGap(0);
        btnPengeluaranIpsrs.setName("btnPengeluaranIpsrs"); // NOI18N
        btnPengeluaranIpsrs.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPengeluaranIpsrs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPengeluaranIpsrsActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPengeluaranIpsrs);

        btnRHMasukIpsrs.setForeground(new java.awt.Color(0, 0, 0));
        btnRHMasukIpsrs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/shopping_cart.png"))); // NOI18N
        btnRHMasukIpsrs.setText("Rekap Pengadaan");
        btnRHMasukIpsrs.setIconTextGap(0);
        btnRHMasukIpsrs.setName("btnRHMasukIpsrs"); // NOI18N
        btnRHMasukIpsrs.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRHMasukIpsrs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRHMasukIpsrsActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRHMasukIpsrs);

        btnRHKeluarIpsrs.setForeground(new java.awt.Color(0, 0, 0));
        btnRHKeluarIpsrs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360816018_tests.png"))); // NOI18N
        btnRHKeluarIpsrs.setText("Rekap Stok Keluar");
        btnRHKeluarIpsrs.setIconTextGap(0);
        btnRHKeluarIpsrs.setName("btnRHKeluarIpsrs"); // NOI18N
        btnRHKeluarIpsrs.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRHKeluarIpsrs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRHKeluarIpsrsActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRHKeluarIpsrs);

        btnRBiayaIpsrs.setForeground(new java.awt.Color(0, 0, 0));
        btnRBiayaIpsrs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360486845_23.png"))); // NOI18N
        btnRBiayaIpsrs.setText("Biaya Pengadaan");
        btnRBiayaIpsrs.setIconTextGap(0);
        btnRBiayaIpsrs.setName("btnRBiayaIpsrs"); // NOI18N
        btnRBiayaIpsrs.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRBiayaIpsrs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRBiayaIpsrsActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRBiayaIpsrs);

        btnTarifRadiologi.setForeground(new java.awt.Color(0, 0, 0));
        btnTarifRadiologi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1410153940_radiology.png"))); // NOI18N
        btnTarifRadiologi.setText("Tarif Radiologi");
        btnTarifRadiologi.setIconTextGap(0);
        btnTarifRadiologi.setName("btnTarifRadiologi"); // NOI18N
        btnTarifRadiologi.setPreferredSize(new java.awt.Dimension(200, 90));
        btnTarifRadiologi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarifRadiologiActionPerformed(evt);
            }
        });
        Panelmenu.add(btnTarifRadiologi);

        btnPeriksaRadiologi.setForeground(new java.awt.Color(0, 0, 0));
        btnPeriksaRadiologi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Print.png"))); // NOI18N
        btnPeriksaRadiologi.setText("Periksa Radiologi");
        btnPeriksaRadiologi.setIconTextGap(0);
        btnPeriksaRadiologi.setName("btnPeriksaRadiologi"); // NOI18N
        btnPeriksaRadiologi.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPeriksaRadiologi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriksaRadiologiActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPeriksaRadiologi);

        btnSetupEmbalase.setForeground(new java.awt.Color(0, 0, 0));
        btnSetupEmbalase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Money.png"))); // NOI18N
        btnSetupEmbalase.setText("Set Embalase & Tuslah");
        btnSetupEmbalase.setIconTextGap(0);
        btnSetupEmbalase.setName("btnSetupEmbalase"); // NOI18N
        btnSetupEmbalase.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSetupEmbalase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetupEmbalaseActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSetupEmbalase);

        btnPemesanan.setForeground(new java.awt.Color(0, 0, 0));
        btnPemesanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/kwrite.png"))); // NOI18N
        btnPemesanan.setText("Pemesanan Obat & BHP");
        btnPemesanan.setIconTextGap(0);
        btnPemesanan.setName("btnPemesanan"); // NOI18N
        btnPemesanan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPemesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPemesananActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPemesanan);

        btnPengeluaran.setForeground(new java.awt.Color(0, 0, 0));
        btnPengeluaran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1404047106_emblem-money.png"))); // NOI18N
        btnPengeluaran.setText("Pengeluaran Harian");
        btnPengeluaran.setIconTextGap(0);
        btnPengeluaran.setName("btnPengeluaran"); // NOI18N
        btnPengeluaran.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPengeluaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPengeluaranActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPengeluaran);

        btnTambahanBiaya.setForeground(new java.awt.Color(0, 0, 0));
        btnTambahanBiaya.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1404046786_Money.png"))); // NOI18N
        btnTambahanBiaya.setText("Tambahan Biaya Pasien");
        btnTambahanBiaya.setIconTextGap(0);
        btnTambahanBiaya.setName("btnTambahanBiaya"); // NOI18N
        btnTambahanBiaya.setPreferredSize(new java.awt.Dimension(200, 90));
        btnTambahanBiaya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahanBiayaActionPerformed(evt);
            }
        });
        Panelmenu.add(btnTambahanBiaya);

        btnPotonganBiaya.setForeground(new java.awt.Color(0, 0, 0));
        btnPotonganBiaya.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1404046786_Money.png"))); // NOI18N
        btnPotonganBiaya.setText("Potongan Biaya Pasien");
        btnPotonganBiaya.setIconTextGap(0);
        btnPotonganBiaya.setName("btnPotonganBiaya"); // NOI18N
        btnPotonganBiaya.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPotonganBiaya.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPotonganBiayaActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPotonganBiaya);

        btnIGD.setForeground(new java.awt.Color(0, 0, 0));
        btnIGD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/checklist.png"))); // NOI18N
        btnIGD.setText("IGD/UGD");
        btnIGD.setIconTextGap(0);
        btnIGD.setName("btnIGD"); // NOI18N
        btnIGD.setPreferredSize(new java.awt.Dimension(200, 90));
        btnIGD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIGDActionPerformed(evt);
            }
        });
        Panelmenu.add(btnIGD);

        btnSetObatRalan.setForeground(new java.awt.Color(0, 0, 0));
        btnSetObatRalan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360487093_price.png"))); // NOI18N
        btnSetObatRalan.setText("Set Obat Ralan");
        btnSetObatRalan.setIconTextGap(0);
        btnSetObatRalan.setName("btnSetObatRalan"); // NOI18N
        btnSetObatRalan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSetObatRalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetObatRalanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSetObatRalan);

        btnSetObatRanap.setForeground(new java.awt.Color(0, 0, 0));
        btnSetObatRanap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360487093_price.png"))); // NOI18N
        btnSetObatRanap.setText("Set Obat Ranap");
        btnSetObatRanap.setIconTextGap(0);
        btnSetObatRanap.setName("btnSetObatRanap"); // NOI18N
        btnSetObatRanap.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSetObatRanap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetObatRanapActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSetObatRanap);

        btnPenyakitPD3I.setForeground(new java.awt.Color(0, 0, 0));
        btnPenyakitPD3I.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Gnome-X-Office-Address-Book-48.png"))); // NOI18N
        btnPenyakitPD3I.setText("Penyakit AFP & PD3I");
        btnPenyakitPD3I.setIconTextGap(0);
        btnPenyakitPD3I.setName("btnPenyakitPD3I"); // NOI18N
        btnPenyakitPD3I.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPenyakitPD3I.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenyakitPD3IActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPenyakitPD3I);

        btnSurveilansPD3I.setForeground(new java.awt.Color(0, 0, 0));
        btnSurveilansPD3I.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Gnome-X-Office-Address-Book-48.png"))); // NOI18N
        btnSurveilansPD3I.setText("Surveilans AFP & PD3I");
        btnSurveilansPD3I.setIconTextGap(0);
        btnSurveilansPD3I.setName("btnSurveilansPD3I"); // NOI18N
        btnSurveilansPD3I.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSurveilansPD3I.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSurveilansPD3IActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSurveilansPD3I);

        btnSurveilansRalan.setForeground(new java.awt.Color(0, 0, 0));
        btnSurveilansRalan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Gnome-X-Office-Address-Book-48.png"))); // NOI18N
        btnSurveilansRalan.setText("Surveilans Ralan");
        btnSurveilansRalan.setIconTextGap(0);
        btnSurveilansRalan.setName("btnSurveilansRalan"); // NOI18N
        btnSurveilansRalan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSurveilansRalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSurveilansRalanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSurveilansRalan);

        btnDiagnosa.setForeground(new java.awt.Color(0, 0, 0));
        btnDiagnosa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/health.png"))); // NOI18N
        btnDiagnosa.setText("Diagnosa Pasien");
        btnDiagnosa.setIconTextGap(0);
        btnDiagnosa.setName("btnDiagnosa"); // NOI18N
        btnDiagnosa.setPreferredSize(new java.awt.Dimension(200, 90));
        btnDiagnosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiagnosaActionPerformed(evt);
            }
        });
        Panelmenu.add(btnDiagnosa);

        btnSurveilansRanap.setForeground(new java.awt.Color(0, 0, 0));
        btnSurveilansRanap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Gnome-X-Office-Address-Book-48.png"))); // NOI18N
        btnSurveilansRanap.setText("Surveilans Ranap");
        btnSurveilansRanap.setIconTextGap(0);
        btnSurveilansRanap.setName("btnSurveilansRanap"); // NOI18N
        btnSurveilansRanap.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSurveilansRanap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSurveilansRanapActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSurveilansRanap);

        btnPnyTakMenularRanap.setForeground(new java.awt.Color(0, 0, 0));
        btnPnyTakMenularRanap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Gnome-X-Office-Address-Book-48.png"))); // NOI18N
        btnPnyTakMenularRanap.setText("Pny Tdk Menular Ranap");
        btnPnyTakMenularRanap.setIconTextGap(0);
        btnPnyTakMenularRanap.setName("btnPnyTakMenularRanap"); // NOI18N
        btnPnyTakMenularRanap.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPnyTakMenularRanap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPnyTakMenularRanapActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPnyTakMenularRanap);

        btnPnyTakMenularRalan.setForeground(new java.awt.Color(0, 0, 0));
        btnPnyTakMenularRalan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Gnome-X-Office-Address-Book-48.png"))); // NOI18N
        btnPnyTakMenularRalan.setText("Pny Tdk Menular Ralan");
        btnPnyTakMenularRalan.setIconTextGap(0);
        btnPnyTakMenularRalan.setName("btnPnyTakMenularRalan"); // NOI18N
        btnPnyTakMenularRalan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPnyTakMenularRalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPnyTakMenularRalanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPnyTakMenularRalan);

        btnKunjunganRalan.setForeground(new java.awt.Color(0, 0, 0));
        btnKunjunganRalan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Gnome-X-Office-Address-Book-48.png"))); // NOI18N
        btnKunjunganRalan.setText("Kunjungan Ralan");
        btnKunjunganRalan.setIconTextGap(0);
        btnKunjunganRalan.setName("btnKunjunganRalan"); // NOI18N
        btnKunjunganRalan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKunjunganRalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKunjunganRalanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKunjunganRalan);

        btnRl32.setForeground(new java.awt.Color(0, 0, 0));
        btnRl32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Gnome-X-Office-Address-Book-48.png"))); // NOI18N
        btnRl32.setText("RL 3.2 Rawat Darurat");
        btnRl32.setIconTextGap(0);
        btnRl32.setName("btnRl32"); // NOI18N
        btnRl32.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRl32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRl32ActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRl32);

        btnRl33.setForeground(new java.awt.Color(0, 0, 0));
        btnRl33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Gnome-X-Office-Address-Book-48.png"))); // NOI18N
        btnRl33.setText("RL 3.3 Gigi dan Mulut");
        btnRl33.setIconTextGap(0);
        btnRl33.setName("btnRl33"); // NOI18N
        btnRl33.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRl33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRl33ActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRl33);

        btnRl37.setForeground(new java.awt.Color(0, 0, 0));
        btnRl37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Gnome-X-Office-Address-Book-48.png"))); // NOI18N
        btnRl37.setText("RL 3.7 Radiologi");
        btnRl37.setIconTextGap(0);
        btnRl37.setName("btnRl37"); // NOI18N
        btnRl37.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRl37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRl37ActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRl37);

        btnRl38.setForeground(new java.awt.Color(0, 0, 0));
        btnRl38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Gnome-X-Office-Address-Book-48.png"))); // NOI18N
        btnRl38.setText("RL 3.8 Laboratorium");
        btnRl38.setIconTextGap(0);
        btnRl38.setName("btnRl38"); // NOI18N
        btnRl38.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRl38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRl38ActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRl38);

        btnSetupNota.setForeground(new java.awt.Color(0, 0, 0));
        btnSetupNota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360485642_edit-notes.png"))); // NOI18N
        btnSetupNota.setText("Set Billing / Nota / Kertas");
        btnSetupNota.setIconTextGap(0);
        btnSetupNota.setName("btnSetupNota"); // NOI18N
        btnSetupNota.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSetupNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetupNotaActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSetupNota);

        BtnDpjp.setForeground(new java.awt.Color(0, 0, 0));
        BtnDpjp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/doctor2.png"))); // NOI18N
        BtnDpjp.setText("DPJP Ranap");
        BtnDpjp.setIconTextGap(0);
        BtnDpjp.setName("BtnDpjp"); // NOI18N
        BtnDpjp.setPreferredSize(new java.awt.Dimension(200, 90));
        BtnDpjp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDpjpActionPerformed(evt);
            }
        });
        Panelmenu.add(BtnDpjp);

        btnMutasiBarang.setForeground(new java.awt.Color(0, 0, 0));
        btnMutasiBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360485642_edit-notes.png"))); // NOI18N
        btnMutasiBarang.setText("Mutasi Obat & BHP");
        btnMutasiBarang.setIconTextGap(0);
        btnMutasiBarang.setName("btnMutasiBarang"); // NOI18N
        btnMutasiBarang.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMutasiBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMutasiBarangActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMutasiBarang);

        btnRl34.setForeground(new java.awt.Color(0, 0, 0));
        btnRl34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Gnome-X-Office-Address-Book-48.png"))); // NOI18N
        btnRl34.setText("RL 3.4 Kebidanan");
        btnRl34.setIconTextGap(0);
        btnRl34.setName("btnRl34"); // NOI18N
        btnRl34.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRl34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRl34ActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRl34);

        btnRl36.setForeground(new java.awt.Color(0, 0, 0));
        btnRl36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Gnome-X-Office-Address-Book-48.png"))); // NOI18N
        btnRl36.setText("RL 3.6 Pembedahan");
        btnRl36.setIconTextGap(0);
        btnRl36.setName("btnRl36"); // NOI18N
        btnRl36.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRl36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRl36ActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRl36);

        btnfee_visit_dokter.setForeground(new java.awt.Color(0, 0, 0));
        btnfee_visit_dokter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360485865_schedule.png"))); // NOI18N
        btnfee_visit_dokter.setText("Visite Dokter Rawat Inap");
        btnfee_visit_dokter.setIconTextGap(0);
        btnfee_visit_dokter.setName("btnfee_visit_dokter"); // NOI18N
        btnfee_visit_dokter.setPreferredSize(new java.awt.Dimension(200, 90));
        btnfee_visit_dokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfee_visit_dokterActionPerformed(evt);
            }
        });
        Panelmenu.add(btnfee_visit_dokter);

        btnakun_bayar.setForeground(new java.awt.Color(0, 0, 0));
        btnakun_bayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/checklist.png"))); // NOI18N
        btnakun_bayar.setText("Akun Bayar");
        btnakun_bayar.setIconTextGap(0);
        btnakun_bayar.setName("btnakun_bayar"); // NOI18N
        btnakun_bayar.setPreferredSize(new java.awt.Dimension(200, 90));
        btnakun_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnakun_bayarActionPerformed(evt);
            }
        });
        Panelmenu.add(btnakun_bayar);

        btnbayar_pemesanan.setForeground(new java.awt.Color(0, 0, 0));
        btnbayar_pemesanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/cashbox.png"))); // NOI18N
        btnbayar_pemesanan.setText("Bayar Pesan Obat/BHP");
        btnbayar_pemesanan.setIconTextGap(0);
        btnbayar_pemesanan.setName("btnbayar_pemesanan"); // NOI18N
        btnbayar_pemesanan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnbayar_pemesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbayar_pemesananActionPerformed(evt);
            }
        });
        Panelmenu.add(btnbayar_pemesanan);

        btnJenisIpsrs.setForeground(new java.awt.Color(0, 0, 0));
        btnJenisIpsrs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/cabinet.png"))); // NOI18N
        btnJenisIpsrs.setText("Jenis Barang");
        btnJenisIpsrs.setIconTextGap(0);
        btnJenisIpsrs.setName("btnJenisIpsrs"); // NOI18N
        btnJenisIpsrs.setPreferredSize(new java.awt.Dimension(200, 90));
        btnJenisIpsrs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJenisIpsrsActionPerformed(evt);
            }
        });
        Panelmenu.add(btnJenisIpsrs);

        btnPemasukanLain.setForeground(new java.awt.Color(0, 0, 0));
        btnPemasukanLain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360486845_23.png"))); // NOI18N
        btnPemasukanLain.setText("Pemasukan Lain-Lain");
        btnPemasukanLain.setIconTextGap(0);
        btnPemasukanLain.setName("btnPemasukanLain"); // NOI18N
        btnPemasukanLain.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPemasukanLain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPemasukanLainActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPemasukanLain);

        btnPengaturanRekening.setForeground(new java.awt.Color(0, 0, 0));
        btnPengaturanRekening.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/gtk-stock-book.png"))); // NOI18N
        btnPengaturanRekening.setText("Pengaturan Rekening");
        btnPengaturanRekening.setIconTextGap(0);
        btnPengaturanRekening.setName("btnPengaturanRekening"); // NOI18N
        btnPengaturanRekening.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPengaturanRekening.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPengaturanRekeningActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPengaturanRekening);

        btnClosingKasir.setForeground(new java.awt.Color(0, 0, 0));
        btnClosingKasir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360485865_schedule.png"))); // NOI18N
        btnClosingKasir.setText("Closing Kasir");
        btnClosingKasir.setIconTextGap(0);
        btnClosingKasir.setName("btnClosingKasir"); // NOI18N
        btnClosingKasir.setPreferredSize(new java.awt.Dimension(200, 90));
        btnClosingKasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClosingKasirActionPerformed(evt);
            }
        });
        Panelmenu.add(btnClosingKasir);

        btnKeterlambatanPresensi.setForeground(new java.awt.Color(0, 0, 0));
        btnKeterlambatanPresensi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Time.png"))); // NOI18N
        btnKeterlambatanPresensi.setText("Set Keterlambatan Presensi");
        btnKeterlambatanPresensi.setIconTextGap(0);
        btnKeterlambatanPresensi.setName("btnKeterlambatanPresensi"); // NOI18N
        btnKeterlambatanPresensi.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKeterlambatanPresensi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeterlambatanPresensiActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKeterlambatanPresensi);

        btnSetHargaKamar.setForeground(new java.awt.Color(0, 0, 0));
        btnSetHargaKamar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/bedroom.png"))); // NOI18N
        btnSetHargaKamar.setText("Set Harga Kamar");
        btnSetHargaKamar.setIconTextGap(0);
        btnSetHargaKamar.setName("btnSetHargaKamar"); // NOI18N
        btnSetHargaKamar.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSetHargaKamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetHargaKamarActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSetHargaKamar);

        btnRekapPershift.setForeground(new java.awt.Color(0, 0, 0));
        btnRekapPershift.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/checklist.png"))); // NOI18N
        btnRekapPershift.setText("Rekap Uang Pershift");
        btnRekapPershift.setIconTextGap(0);
        btnRekapPershift.setName("btnRekapPershift"); // NOI18N
        btnRekapPershift.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRekapPershift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRekapPershiftActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRekapPershift);

        btnCekBPJSNik.setForeground(new java.awt.Color(0, 0, 0));
        btnCekBPJSNik.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekBPJSNik.setText("Cek NIK BPJS VClaim");
        btnCekBPJSNik.setIconTextGap(0);
        btnCekBPJSNik.setName("btnCekBPJSNik"); // NOI18N
        btnCekBPJSNik.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekBPJSNik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekBPJSNikActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekBPJSNik);

        btnCekBPJSKartu.setForeground(new java.awt.Color(0, 0, 0));
        btnCekBPJSKartu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekBPJSKartu.setText("Cek No.Kartu BPJS VClaim");
        btnCekBPJSKartu.setIconTextGap(0);
        btnCekBPJSKartu.setName("btnCekBPJSKartu"); // NOI18N
        btnCekBPJSKartu.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekBPJSKartu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekBPJSKartuActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekBPJSKartu);

        btnObatPerCaraBayar.setForeground(new java.awt.Color(0, 0, 0));
        btnObatPerCaraBayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360815855_laboratory.png"))); // NOI18N
        btnObatPerCaraBayar.setText("Obat Per Cara Bayar");
        btnObatPerCaraBayar.setIconTextGap(0);
        btnObatPerCaraBayar.setName("btnObatPerCaraBayar"); // NOI18N
        btnObatPerCaraBayar.setPreferredSize(new java.awt.Dimension(200, 90));
        btnObatPerCaraBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObatPerCaraBayarActionPerformed(evt);
            }
        });
        Panelmenu.add(btnObatPerCaraBayar);

        btnKunjunganRanap.setForeground(new java.awt.Color(0, 0, 0));
        btnKunjunganRanap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Gnome-X-Office-Address-Book-48.png"))); // NOI18N
        btnKunjunganRanap.setText("Kunjungan Ranap");
        btnKunjunganRanap.setIconTextGap(0);
        btnKunjunganRanap.setName("btnKunjunganRanap"); // NOI18N
        btnKunjunganRanap.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKunjunganRanap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKunjunganRanapActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKunjunganRanap);

        btnPaymentPoint.setForeground(new java.awt.Color(0, 0, 0));
        btnPaymentPoint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/coins.png"))); // NOI18N
        btnPaymentPoint.setText("Payment Point");
        btnPaymentPoint.setIconTextGap(0);
        btnPaymentPoint.setName("btnPaymentPoint"); // NOI18N
        btnPaymentPoint.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPaymentPoint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentPointActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPaymentPoint);

        btnCekBPJSNomorRujukanPCare.setForeground(new java.awt.Color(0, 0, 0));
        btnCekBPJSNomorRujukanPCare.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/pcare.png"))); // NOI18N
        btnCekBPJSNomorRujukanPCare.setText("Cek No. Rujukan PCare di VClaim");
        btnCekBPJSNomorRujukanPCare.setIconTextGap(0);
        btnCekBPJSNomorRujukanPCare.setName("btnCekBPJSNomorRujukanPCare"); // NOI18N
        btnCekBPJSNomorRujukanPCare.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekBPJSNomorRujukanPCare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekBPJSNomorRujukanPCareActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekBPJSNomorRujukanPCare);

        btnICD9.setForeground(new java.awt.Color(0, 0, 0));
        btnICD9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/icd_10.png"))); // NOI18N
        btnICD9.setText("Master ICD-9-CM");
        btnICD9.setIconTextGap(0);
        btnICD9.setName("btnICD9"); // NOI18N
        btnICD9.setPreferredSize(new java.awt.Dimension(200, 90));
        btnICD9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnICD9ActionPerformed(evt);
            }
        });
        Panelmenu.add(btnICD9);

        btnDaruratStok.setForeground(new java.awt.Color(0, 0, 0));
        btnDaruratStok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360487078_shipping.png"))); // NOI18N
        btnDaruratStok.setText("Darurat Stok");
        btnDaruratStok.setIconTextGap(0);
        btnDaruratStok.setName("btnDaruratStok"); // NOI18N
        btnDaruratStok.setPreferredSize(new java.awt.Dimension(200, 90));
        btnDaruratStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaruratStokActionPerformed(evt);
            }
        });
        Panelmenu.add(btnDaruratStok);

        btnJurnalHarian.setForeground(new java.awt.Color(0, 0, 0));
        btnJurnalHarian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360485865_schedule.png"))); // NOI18N
        btnJurnalHarian.setText("Jurnal Harian");
        btnJurnalHarian.setIconTextGap(0);
        btnJurnalHarian.setName("btnJurnalHarian"); // NOI18N
        btnJurnalHarian.setPreferredSize(new java.awt.Dimension(200, 90));
        btnJurnalHarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJurnalHarianActionPerformed(evt);
            }
        });
        Panelmenu.add(btnJurnalHarian);

        btnSirkulasi2.setForeground(new java.awt.Color(0, 0, 0));
        btnSirkulasi2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360487125_system-restart-panel.png"))); // NOI18N
        btnSirkulasi2.setText("Sirkulasi Obat, Alkes & BHP 2");
        btnSirkulasi2.setIconTextGap(0);
        btnSirkulasi2.setName("btnSirkulasi2"); // NOI18N
        btnSirkulasi2.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSirkulasi2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSirkulasi2ActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSirkulasi2);

        btnCekBPJSDiagnosa.setForeground(new java.awt.Color(0, 0, 0));
        btnCekBPJSDiagnosa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekBPJSDiagnosa.setText("Referensi Diagnosa BPJS VClaim");
        btnCekBPJSDiagnosa.setIconTextGap(0);
        btnCekBPJSDiagnosa.setName("btnCekBPJSDiagnosa"); // NOI18N
        btnCekBPJSDiagnosa.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekBPJSDiagnosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekBPJSDiagnosaActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekBPJSDiagnosa);

        btnCekBPJSPoli.setForeground(new java.awt.Color(0, 0, 0));
        btnCekBPJSPoli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekBPJSPoli.setText("Referensi Poli BPJS VClaim");
        btnCekBPJSPoli.setIconTextGap(0);
        btnCekBPJSPoli.setName("btnCekBPJSPoli"); // NOI18N
        btnCekBPJSPoli.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekBPJSPoli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekBPJSPoliActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekBPJSPoli);

        btnIndustriFarmasi.setForeground(new java.awt.Color(0, 0, 0));
        btnIndustriFarmasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360486910_company.png"))); // NOI18N
        btnIndustriFarmasi.setText("Industri Farmasi");
        btnIndustriFarmasi.setIconTextGap(0);
        btnIndustriFarmasi.setName("btnIndustriFarmasi"); // NOI18N
        btnIndustriFarmasi.setPreferredSize(new java.awt.Dimension(200, 90));
        btnIndustriFarmasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIndustriFarmasiActionPerformed(evt);
            }
        });
        Panelmenu.add(btnIndustriFarmasi);

        btnPiutangBelumLunas.setForeground(new java.awt.Color(0, 0, 0));
        btnPiutangBelumLunas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/checklist_pencil-o.png"))); // NOI18N
        btnPiutangBelumLunas.setText("Piutang Belum Lunas");
        btnPiutangBelumLunas.setIconTextGap(0);
        btnPiutangBelumLunas.setName("btnPiutangBelumLunas"); // NOI18N
        btnPiutangBelumLunas.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPiutangBelumLunas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPiutangBelumLunasActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPiutangBelumLunas);

        btnCekBPJSFaskes.setForeground(new java.awt.Color(0, 0, 0));
        btnCekBPJSFaskes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekBPJSFaskes.setText("Referensi Faskes BPJS VClaim");
        btnCekBPJSFaskes.setIconTextGap(0);
        btnCekBPJSFaskes.setName("btnCekBPJSFaskes"); // NOI18N
        btnCekBPJSFaskes.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekBPJSFaskes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekBPJSFaskesActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekBPJSFaskes);

        btnBPJSSEP.setForeground(new java.awt.Color(0, 0, 0));
        btnBPJSSEP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnBPJSSEP.setText("Data Bridging SEP BPJS");
        btnBPJSSEP.setIconTextGap(0);
        btnBPJSSEP.setName("btnBPJSSEP"); // NOI18N
        btnBPJSSEP.setPreferredSize(new java.awt.Dimension(200, 90));
        btnBPJSSEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBPJSSEPActionPerformed(evt);
            }
        });
        Panelmenu.add(btnBPJSSEP);

        btnPengambilanUTD.setForeground(new java.awt.Color(0, 0, 0));
        btnPengambilanUTD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360487078_shipping.png"))); // NOI18N
        btnPengambilanUTD.setText("Pengambilan BHP UTD");
        btnPengambilanUTD.setIconTextGap(0);
        btnPengambilanUTD.setName("btnPengambilanUTD"); // NOI18N
        btnPengambilanUTD.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPengambilanUTD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPengambilanUTDActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPengambilanUTD);

        btnTarifUtd.setForeground(new java.awt.Color(0, 0, 0));
        btnTarifUtd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1481001686_injection_blood.png"))); // NOI18N
        btnTarifUtd.setText("Tarif UTD");
        btnTarifUtd.setIconTextGap(0);
        btnTarifUtd.setName("btnTarifUtd"); // NOI18N
        btnTarifUtd.setPreferredSize(new java.awt.Dimension(200, 90));
        btnTarifUtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarifUtdActionPerformed(evt);
            }
        });
        Panelmenu.add(btnTarifUtd);

        btnPengambilanUTD2.setForeground(new java.awt.Color(0, 0, 0));
        btnPengambilanUTD2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360487078_shipping.png"))); // NOI18N
        btnPengambilanUTD2.setText("Pengambilan BHP Medis");
        btnPengambilanUTD2.setIconTextGap(0);
        btnPengambilanUTD2.setName("btnPengambilanUTD2"); // NOI18N
        btnPengambilanUTD2.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPengambilanUTD2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPengambilanUTD2ActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPengambilanUTD2);

        btnUTDMedisRusak.setForeground(new java.awt.Color(0, 0, 0));
        btnUTDMedisRusak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360486858_stock-market.png"))); // NOI18N
        btnUTDMedisRusak.setText("BHP Medis Rusak");
        btnUTDMedisRusak.setIconTextGap(0);
        btnUTDMedisRusak.setName("btnUTDMedisRusak"); // NOI18N
        btnUTDMedisRusak.setPreferredSize(new java.awt.Dimension(200, 90));
        btnUTDMedisRusak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUTDMedisRusakActionPerformed(evt);
            }
        });
        Panelmenu.add(btnUTDMedisRusak);

        btnPengambilanPenunjangUTD.setForeground(new java.awt.Color(0, 0, 0));
        btnPengambilanPenunjangUTD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1481002155_skills.png"))); // NOI18N
        btnPengambilanPenunjangUTD.setText("Pengambilan UTD");
        btnPengambilanPenunjangUTD.setIconTextGap(0);
        btnPengambilanPenunjangUTD.setName("btnPengambilanPenunjangUTD"); // NOI18N
        btnPengambilanPenunjangUTD.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPengambilanPenunjangUTD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPengambilanPenunjangUTDActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPengambilanPenunjangUTD);

        btnPengambilanPenunjangUTD2.setForeground(new java.awt.Color(0, 0, 0));
        btnPengambilanPenunjangUTD2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1481002155_skills.png"))); // NOI18N
        btnPengambilanPenunjangUTD2.setText("Pengambilan BHP Non Medis");
        btnPengambilanPenunjangUTD2.setIconTextGap(0);
        btnPengambilanPenunjangUTD2.setName("btnPengambilanPenunjangUTD2"); // NOI18N
        btnPengambilanPenunjangUTD2.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPengambilanPenunjangUTD2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPengambilanPenunjangUTD2ActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPengambilanPenunjangUTD2);

        btnUTDPenunjangRusak.setForeground(new java.awt.Color(0, 0, 0));
        btnUTDPenunjangRusak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/inventory-maintenance.png"))); // NOI18N
        btnUTDPenunjangRusak.setText("BHP Non Medis Rusak");
        btnUTDPenunjangRusak.setIconTextGap(0);
        btnUTDPenunjangRusak.setName("btnUTDPenunjangRusak"); // NOI18N
        btnUTDPenunjangRusak.setPreferredSize(new java.awt.Dimension(200, 90));
        btnUTDPenunjangRusak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUTDPenunjangRusakActionPerformed(evt);
            }
        });
        Panelmenu.add(btnUTDPenunjangRusak);

        btnSuplierIPSRS.setForeground(new java.awt.Color(0, 0, 0));
        btnSuplierIPSRS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1481002123_wheelchair.png"))); // NOI18N
        btnSuplierIPSRS.setText("Suplier Non Medis");
        btnSuplierIPSRS.setIconTextGap(0);
        btnSuplierIPSRS.setName("btnSuplierIPSRS"); // NOI18N
        btnSuplierIPSRS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSuplierIPSRS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuplierIPSRSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSuplierIPSRS);

        btnUTDDonorDarah.setForeground(new java.awt.Color(0, 0, 0));
        btnUTDDonorDarah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1481001706_heart_beat.png"))); // NOI18N
        btnUTDDonorDarah.setText("Donor Darah");
        btnUTDDonorDarah.setIconTextGap(0);
        btnUTDDonorDarah.setName("btnUTDDonorDarah"); // NOI18N
        btnUTDDonorDarah.setPreferredSize(new java.awt.Dimension(200, 90));
        btnUTDDonorDarah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUTDDonorDarahActionPerformed(evt);
            }
        });
        Panelmenu.add(btnUTDDonorDarah);

        btnMonitoringKlaimBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnMonitoringKlaimBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnMonitoringKlaimBPJS.setText("Monitoring Klaim BPJS VClaim");
        btnMonitoringKlaimBPJS.setIconTextGap(0);
        btnMonitoringKlaimBPJS.setName("btnMonitoringKlaimBPJS"); // NOI18N
        btnMonitoringKlaimBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMonitoringKlaimBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonitoringKlaimBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMonitoringKlaimBPJS);

        btnUTDCekalDarah.setForeground(new java.awt.Color(0, 0, 0));
        btnUTDCekalDarah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360487093_price.png"))); // NOI18N
        btnUTDCekalDarah.setText("Pencekalan Darah");
        btnUTDCekalDarah.setIconTextGap(0);
        btnUTDCekalDarah.setName("btnUTDCekalDarah"); // NOI18N
        btnUTDCekalDarah.setPreferredSize(new java.awt.Dimension(200, 90));
        btnUTDCekalDarah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUTDCekalDarahActionPerformed(evt);
            }
        });
        Panelmenu.add(btnUTDCekalDarah);

        btnUTDKomponenDarah.setForeground(new java.awt.Color(0, 0, 0));
        btnUTDKomponenDarah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1481001686_injection_blood.png"))); // NOI18N
        btnUTDKomponenDarah.setText("Komponen Darah");
        btnUTDKomponenDarah.setIconTextGap(0);
        btnUTDKomponenDarah.setName("btnUTDKomponenDarah"); // NOI18N
        btnUTDKomponenDarah.setPreferredSize(new java.awt.Dimension(200, 90));
        btnUTDKomponenDarah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUTDKomponenDarahActionPerformed(evt);
            }
        });
        Panelmenu.add(btnUTDKomponenDarah);

        btnUTDStokDarah.setForeground(new java.awt.Color(0, 0, 0));
        btnUTDStokDarah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1481001585_blood_drop.png"))); // NOI18N
        btnUTDStokDarah.setText("Stok Darah");
        btnUTDStokDarah.setIconTextGap(0);
        btnUTDStokDarah.setName("btnUTDStokDarah"); // NOI18N
        btnUTDStokDarah.setPreferredSize(new java.awt.Dimension(200, 90));
        btnUTDStokDarah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUTDStokDarahActionPerformed(evt);
            }
        });
        Panelmenu.add(btnUTDStokDarah);

        btnUTDPemisahanDarah.setForeground(new java.awt.Color(0, 0, 0));
        btnUTDPemisahanDarah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360815855_laboratory.png"))); // NOI18N
        btnUTDPemisahanDarah.setText("Pemisahan Darah");
        btnUTDPemisahanDarah.setIconTextGap(0);
        btnUTDPemisahanDarah.setName("btnUTDPemisahanDarah"); // NOI18N
        btnUTDPemisahanDarah.setPreferredSize(new java.awt.Dimension(200, 90));
        btnUTDPemisahanDarah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUTDPemisahanDarahActionPerformed(evt);
            }
        });
        Panelmenu.add(btnUTDPemisahanDarah);

        btnRincianPiutangPasien.setForeground(new java.awt.Color(0, 0, 0));
        btnRincianPiutangPasien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/checklist_pencil-o.png"))); // NOI18N
        btnRincianPiutangPasien.setText("Rincian Piutang Pasien");
        btnRincianPiutangPasien.setIconTextGap(0);
        btnRincianPiutangPasien.setName("btnRincianPiutangPasien"); // NOI18N
        btnRincianPiutangPasien.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRincianPiutangPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRincianPiutangPasienActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRincianPiutangPasien);

        btnKeuntunganObat2.setForeground(new java.awt.Color(0, 0, 0));
        btnKeuntunganObat2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/coins.png"))); // NOI18N
        btnKeuntunganObat2.setText("Keuntungan Beri Obat 2");
        btnKeuntunganObat2.setIconTextGap(0);
        btnKeuntunganObat2.setName("btnKeuntunganObat2"); // NOI18N
        btnKeuntunganObat2.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKeuntunganObat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeuntunganObat2ActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKeuntunganObat2);

        btnUTDPenyerahanDarah.setForeground(new java.awt.Color(0, 0, 0));
        btnUTDPenyerahanDarah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/health.png"))); // NOI18N
        btnUTDPenyerahanDarah.setText("Penyerahan Darah");
        btnUTDPenyerahanDarah.setIconTextGap(0);
        btnUTDPenyerahanDarah.setName("btnUTDPenyerahanDarah"); // NOI18N
        btnUTDPenyerahanDarah.setPreferredSize(new java.awt.Dimension(200, 90));
        btnUTDPenyerahanDarah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUTDPenyerahanDarahActionPerformed(evt);
            }
        });
        Panelmenu.add(btnUTDPenyerahanDarah);

        btnHutangObat.setForeground(new java.awt.Color(0, 0, 0));
        btnHutangObat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/cashbox.png"))); // NOI18N
        btnHutangObat.setText("Hutang Obat & BHP");
        btnHutangObat.setIconTextGap(0);
        btnHutangObat.setName("btnHutangObat"); // NOI18N
        btnHutangObat.setPreferredSize(new java.awt.Dimension(200, 90));
        btnHutangObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHutangObatActionPerformed(evt);
            }
        });
        Panelmenu.add(btnHutangObat);

        btnRiwayatBarangMedis.setForeground(new java.awt.Color(0, 0, 0));
        btnRiwayatBarangMedis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/gnome-searchtool.png"))); // NOI18N
        btnRiwayatBarangMedis.setText("Riwayat Obat, Alkes & BHP");
        btnRiwayatBarangMedis.setIconTextGap(0);
        btnRiwayatBarangMedis.setName("btnRiwayatBarangMedis"); // NOI18N
        btnRiwayatBarangMedis.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRiwayatBarangMedis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRiwayatBarangMedisActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRiwayatBarangMedis);

        btnSensusHarianPoli.setForeground(new java.awt.Color(0, 0, 0));
        btnSensusHarianPoli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/custom-reports.png"))); // NOI18N
        btnSensusHarianPoli.setText("Sensus Harian Poli");
        btnSensusHarianPoli.setIconTextGap(0);
        btnSensusHarianPoli.setName("btnSensusHarianPoli"); // NOI18N
        btnSensusHarianPoli.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSensusHarianPoli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSensusHarianPoliActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSensusHarianPoli);

        btnRl4a.setForeground(new java.awt.Color(0, 0, 0));
        btnRl4a.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1491582089_Finance_financial_report.png"))); // NOI18N
        btnRl4a.setText("RL 4A Morbiditas Ranap");
        btnRl4a.setIconTextGap(0);
        btnRl4a.setName("btnRl4a"); // NOI18N
        btnRl4a.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRl4a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRl4aActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRl4a);

        btnAplicareReferensiKamar.setForeground(new java.awt.Color(0, 0, 0));
        btnAplicareReferensiKamar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/bedroom.png"))); // NOI18N
        btnAplicareReferensiKamar.setText("Referensi Kamar Aplicare");
        btnAplicareReferensiKamar.setIconTextGap(0);
        btnAplicareReferensiKamar.setName("btnAplicareReferensiKamar"); // NOI18N
        btnAplicareReferensiKamar.setPreferredSize(new java.awt.Dimension(200, 90));
        btnAplicareReferensiKamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicareReferensiKamarActionPerformed(evt);
            }
        });
        Panelmenu.add(btnAplicareReferensiKamar);

        btnAplicareKetersediaanKamar.setForeground(new java.awt.Color(0, 0, 0));
        btnAplicareKetersediaanKamar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1485357524_Company.png"))); // NOI18N
        btnAplicareKetersediaanKamar.setText("Ketersediaan Kamar Aplicare");
        btnAplicareKetersediaanKamar.setIconTextGap(0);
        btnAplicareKetersediaanKamar.setName("btnAplicareKetersediaanKamar"); // NOI18N
        btnAplicareKetersediaanKamar.setPreferredSize(new java.awt.Dimension(200, 90));
        btnAplicareKetersediaanKamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAplicareKetersediaanKamarActionPerformed(evt);
            }
        });
        Panelmenu.add(btnAplicareKetersediaanKamar);

        btnInaCBGCoderNIK.setForeground(new java.awt.Color(0, 0, 0));
        btnInaCBGCoderNIK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/inacbg_eklaim.png"))); // NOI18N
        btnInaCBGCoderNIK.setText("Coder NIK INACBG");
        btnInaCBGCoderNIK.setIconTextGap(0);
        btnInaCBGCoderNIK.setName("btnInaCBGCoderNIK"); // NOI18N
        btnInaCBGCoderNIK.setPreferredSize(new java.awt.Dimension(200, 90));
        btnInaCBGCoderNIK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInaCBGCoderNIKActionPerformed(evt);
            }
        });
        Panelmenu.add(btnInaCBGCoderNIK);

        btnAkunPiutang.setForeground(new java.awt.Color(0, 0, 0));
        btnAkunPiutang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1404046603_wallet.png"))); // NOI18N
        btnAkunPiutang.setText("Akun Piutang");
        btnAkunPiutang.setIconTextGap(0);
        btnAkunPiutang.setName("btnAkunPiutang"); // NOI18N
        btnAkunPiutang.setPreferredSize(new java.awt.Dimension(200, 90));
        btnAkunPiutang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAkunPiutangActionPerformed(evt);
            }
        });
        Panelmenu.add(btnAkunPiutang);

        btnPiutangRalan.setForeground(new java.awt.Color(0, 0, 0));
        btnPiutangRalan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1404047007_02.png"))); // NOI18N
        btnPiutangRalan.setText("Piutang Ralan");
        btnPiutangRalan.setIconTextGap(0);
        btnPiutangRalan.setName("btnPiutangRalan"); // NOI18N
        btnPiutangRalan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPiutangRalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPiutangRalanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPiutangRalan);

        btnPiutangRanap.setForeground(new java.awt.Color(0, 0, 0));
        btnPiutangRanap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1404047007_02.png"))); // NOI18N
        btnPiutangRanap.setText("Piutang Ranap");
        btnPiutangRanap.setIconTextGap(0);
        btnPiutangRanap.setName("btnPiutangRanap"); // NOI18N
        btnPiutangRanap.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPiutangRanap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPiutangRanapActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPiutangRanap);

        btnPiutangPerCaraBayar.setForeground(new java.awt.Color(0, 0, 0));
        btnPiutangPerCaraBayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/checklist_pencil-o.png"))); // NOI18N
        btnPiutangPerCaraBayar.setText("Piutang Per Cara Bayar");
        btnPiutangPerCaraBayar.setIconTextGap(0);
        btnPiutangPerCaraBayar.setName("btnPiutangPerCaraBayar"); // NOI18N
        btnPiutangPerCaraBayar.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPiutangPerCaraBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPiutangPerCaraBayarActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPiutangPerCaraBayar);

        btnLamaPelayananRalan.setForeground(new java.awt.Color(0, 0, 0));
        btnLamaPelayananRalan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Gnome-X-Office-Address-Book-48.png"))); // NOI18N
        btnLamaPelayananRalan.setText("Durasi Waktu Pelayanan Ralan");
        btnLamaPelayananRalan.setIconTextGap(0);
        btnLamaPelayananRalan.setName("btnLamaPelayananRalan"); // NOI18N
        btnLamaPelayananRalan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnLamaPelayananRalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamaPelayananRalanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnLamaPelayananRalan);

        btnCatatanPasien.setForeground(new java.awt.Color(0, 0, 0));
        btnCatatanPasien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/kwrite.png"))); // NOI18N
        btnCatatanPasien.setText("Catatan Pasien");
        btnCatatanPasien.setIconTextGap(0);
        btnCatatanPasien.setName("btnCatatanPasien"); // NOI18N
        btnCatatanPasien.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCatatanPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatatanPasienActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCatatanPasien);

        btnRl4b.setForeground(new java.awt.Color(0, 0, 0));
        btnRl4b.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1491582089_Finance_financial_report.png"))); // NOI18N
        btnRl4b.setText("RL 4B Morbiditas Ralan");
        btnRl4b.setIconTextGap(0);
        btnRl4b.setName("btnRl4b"); // NOI18N
        btnRl4b.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRl4b.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRl4bActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRl4b);

        btnRl4asebab.setForeground(new java.awt.Color(0, 0, 0));
        btnRl4asebab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1491582089_Finance_financial_report.png"))); // NOI18N
        btnRl4asebab.setText("RL 4A Sebab Morbiditas Ralan");
        btnRl4asebab.setIconTextGap(0);
        btnRl4asebab.setName("btnRl4asebab"); // NOI18N
        btnRl4asebab.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRl4asebab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRl4asebabActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRl4asebab);

        btnRl4bsebab.setForeground(new java.awt.Color(0, 0, 0));
        btnRl4bsebab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1491582089_Finance_financial_report.png"))); // NOI18N
        btnRl4bsebab.setText("RL 4B Sebab Morbiditas Ralan");
        btnRl4bsebab.setIconTextGap(0);
        btnRl4bsebab.setName("btnRl4bsebab"); // NOI18N
        btnRl4bsebab.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRl4bsebab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRl4bsebabActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRl4bsebab);

        btnDataHAIs.setForeground(new java.awt.Color(0, 0, 0));
        btnDataHAIs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360816018_tests.png"))); // NOI18N
        btnDataHAIs.setText("Data HAIs");
        btnDataHAIs.setIconTextGap(0);
        btnDataHAIs.setName("btnDataHAIs"); // NOI18N
        btnDataHAIs.setPreferredSize(new java.awt.Dimension(200, 90));
        btnDataHAIs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataHAIsActionPerformed(evt);
            }
        });
        Panelmenu.add(btnDataHAIs);

        btnHarianHAIsRS.setForeground(new java.awt.Color(0, 0, 0));
        btnHarianHAIsRS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/custom-reports.png"))); // NOI18N
        btnHarianHAIsRS.setText("Harian HAIs Rumah Sakit");
        btnHarianHAIsRS.setIconTextGap(0);
        btnHarianHAIsRS.setName("btnHarianHAIsRS"); // NOI18N
        btnHarianHAIsRS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnHarianHAIsRS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHarianHAIsRSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnHarianHAIsRS);

        btnBulananHAIsRS.setForeground(new java.awt.Color(0, 0, 0));
        btnBulananHAIsRS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/if_house_shelf_1378832.png"))); // NOI18N
        btnBulananHAIsRS.setText("Bulanan HAIs Rumah Sakit");
        btnBulananHAIsRS.setIconTextGap(0);
        btnBulananHAIsRS.setName("btnBulananHAIsRS"); // NOI18N
        btnBulananHAIsRS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnBulananHAIsRS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBulananHAIsRSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnBulananHAIsRS);

        btnPerusahaan.setForeground(new java.awt.Color(0, 0, 0));
        btnPerusahaan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1485357524_Company.png"))); // NOI18N
        btnPerusahaan.setText("Instansi/Perusahaan Pasien");
        btnPerusahaan.setIconTextGap(0);
        btnPerusahaan.setName("btnPerusahaan"); // NOI18N
        btnPerusahaan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPerusahaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerusahaanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPerusahaan);

        btnDaftarPermintaanResep.setForeground(new java.awt.Color(0, 0, 0));
        btnDaftarPermintaanResep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360485894_add-notes.png"))); // NOI18N
        btnDaftarPermintaanResep.setText("Daftar Resep Dokter");
        btnDaftarPermintaanResep.setIconTextGap(0);
        btnDaftarPermintaanResep.setName("btnDaftarPermintaanResep"); // NOI18N
        btnDaftarPermintaanResep.setPreferredSize(new java.awt.Dimension(200, 90));
        btnDaftarPermintaanResep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftarPermintaanResepActionPerformed(evt);
            }
        });
        Panelmenu.add(btnDaftarPermintaanResep);

        btnLamaPelayananApotek.setForeground(new java.awt.Color(0, 0, 0));
        btnLamaPelayananApotek.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Gnome-X-Office-Address-Book-48.png"))); // NOI18N
        btnLamaPelayananApotek.setText("Lama Pelayanan Apotek");
        btnLamaPelayananApotek.setIconTextGap(0);
        btnLamaPelayananApotek.setName("btnLamaPelayananApotek"); // NOI18N
        btnLamaPelayananApotek.setPreferredSize(new java.awt.Dimension(200, 90));
        btnLamaPelayananApotek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamaPelayananApotekActionPerformed(evt);
            }
        });
        Panelmenu.add(btnLamaPelayananApotek);

        btnGrafikKunjunganPoli.setForeground(new java.awt.Color(0, 0, 0));
        btnGrafikKunjunganPoli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1491582015_11.png"))); // NOI18N
        btnGrafikKunjunganPoli.setText("Kunjungan Reg Per Poli");
        btnGrafikKunjunganPoli.setIconTextGap(0);
        btnGrafikKunjunganPoli.setName("btnGrafikKunjunganPoli"); // NOI18N
        btnGrafikKunjunganPoli.setPreferredSize(new java.awt.Dimension(200, 90));
        btnGrafikKunjunganPoli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrafikKunjunganPoliActionPerformed(evt);
            }
        });
        Panelmenu.add(btnGrafikKunjunganPoli);

        btnGrafikKunjunganPerDokter.setForeground(new java.awt.Color(0, 0, 0));
        btnGrafikKunjunganPerDokter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1491582015_11.png"))); // NOI18N
        btnGrafikKunjunganPerDokter.setText("Kunjungan Reg Per Dokter");
        btnGrafikKunjunganPerDokter.setIconTextGap(0);
        btnGrafikKunjunganPerDokter.setName("btnGrafikKunjunganPerDokter"); // NOI18N
        btnGrafikKunjunganPerDokter.setPreferredSize(new java.awt.Dimension(200, 90));
        btnGrafikKunjunganPerDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrafikKunjunganPerDokterActionPerformed(evt);
            }
        });
        Panelmenu.add(btnGrafikKunjunganPerDokter);

        btnGrafikKunjunganPerPekerjaan.setForeground(new java.awt.Color(0, 0, 0));
        btnGrafikKunjunganPerPekerjaan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1491582015_11.png"))); // NOI18N
        btnGrafikKunjunganPerPekerjaan.setText("Kunjungan Reg Per Pekerjaan");
        btnGrafikKunjunganPerPekerjaan.setIconTextGap(0);
        btnGrafikKunjunganPerPekerjaan.setName("btnGrafikKunjunganPerPekerjaan"); // NOI18N
        btnGrafikKunjunganPerPekerjaan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnGrafikKunjunganPerPekerjaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrafikKunjunganPerPekerjaanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnGrafikKunjunganPerPekerjaan);

        btnGrafikKunjunganPerPendidikan.setForeground(new java.awt.Color(0, 0, 0));
        btnGrafikKunjunganPerPendidikan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1491582080_6.png"))); // NOI18N
        btnGrafikKunjunganPerPendidikan.setText("Kunjungan Reg Per Pendidikan");
        btnGrafikKunjunganPerPendidikan.setIconTextGap(0);
        btnGrafikKunjunganPerPendidikan.setName("btnGrafikKunjunganPerPendidikan"); // NOI18N
        btnGrafikKunjunganPerPendidikan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnGrafikKunjunganPerPendidikan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrafikKunjunganPerPendidikanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnGrafikKunjunganPerPendidikan);

        btnGrafikKunjunganPerTahun.setForeground(new java.awt.Color(0, 0, 0));
        btnGrafikKunjunganPerTahun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1491582015_11.png"))); // NOI18N
        btnGrafikKunjunganPerTahun.setText("Kunjungan Reg Per Tahun");
        btnGrafikKunjunganPerTahun.setIconTextGap(0);
        btnGrafikKunjunganPerTahun.setName("btnGrafikKunjunganPerTahun"); // NOI18N
        btnGrafikKunjunganPerTahun.setPreferredSize(new java.awt.Dimension(200, 90));
        btnGrafikKunjunganPerTahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrafikKunjunganPerTahunActionPerformed(evt);
            }
        });
        Panelmenu.add(btnGrafikKunjunganPerTahun);

        btnPnyMenularRanap.setForeground(new java.awt.Color(0, 0, 0));
        btnPnyMenularRanap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Gnome-X-Office-Address-Book-48.png"))); // NOI18N
        btnPnyMenularRanap.setText("Pny Menular Ranap");
        btnPnyMenularRanap.setIconTextGap(0);
        btnPnyMenularRanap.setName("btnPnyMenularRanap"); // NOI18N
        btnPnyMenularRanap.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPnyMenularRanap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPnyMenularRanapActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPnyMenularRanap);

        btnPnyMenularRalan.setForeground(new java.awt.Color(0, 0, 0));
        btnPnyMenularRalan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Gnome-X-Office-Address-Book-48.png"))); // NOI18N
        btnPnyMenularRalan.setText("Pny Menular Ralan");
        btnPnyMenularRalan.setIconTextGap(0);
        btnPnyMenularRalan.setName("btnPnyMenularRalan"); // NOI18N
        btnPnyMenularRalan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPnyMenularRalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPnyMenularRalanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPnyMenularRalan);

        btnGrafikKunjunganPerBulan.setForeground(new java.awt.Color(0, 0, 0));
        btnGrafikKunjunganPerBulan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1491582080_6.png"))); // NOI18N
        btnGrafikKunjunganPerBulan.setText("Kunjungan Reg Per Bulan");
        btnGrafikKunjunganPerBulan.setIconTextGap(0);
        btnGrafikKunjunganPerBulan.setName("btnGrafikKunjunganPerBulan"); // NOI18N
        btnGrafikKunjunganPerBulan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnGrafikKunjunganPerBulan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrafikKunjunganPerBulanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnGrafikKunjunganPerBulan);

        btnGrafikKunjunganPerTanggal.setForeground(new java.awt.Color(0, 0, 0));
        btnGrafikKunjunganPerTanggal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1491582015_11.png"))); // NOI18N
        btnGrafikKunjunganPerTanggal.setText("Kunjungan Reg Per Tanggal");
        btnGrafikKunjunganPerTanggal.setIconTextGap(0);
        btnGrafikKunjunganPerTanggal.setName("btnGrafikKunjunganPerTanggal"); // NOI18N
        btnGrafikKunjunganPerTanggal.setPreferredSize(new java.awt.Dimension(200, 90));
        btnGrafikKunjunganPerTanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrafikKunjunganPerTanggalActionPerformed(evt);
            }
        });
        Panelmenu.add(btnGrafikKunjunganPerTanggal);

        btnGrafikDemografiRegistrasi.setForeground(new java.awt.Color(0, 0, 0));
        btnGrafikDemografiRegistrasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1491582080_6.png"))); // NOI18N
        btnGrafikDemografiRegistrasi.setText("Demografi Registrasi");
        btnGrafikDemografiRegistrasi.setIconTextGap(0);
        btnGrafikDemografiRegistrasi.setName("btnGrafikDemografiRegistrasi"); // NOI18N
        btnGrafikDemografiRegistrasi.setPreferredSize(new java.awt.Dimension(200, 90));
        btnGrafikDemografiRegistrasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrafikDemografiRegistrasiActionPerformed(evt);
            }
        });
        Panelmenu.add(btnGrafikDemografiRegistrasi);

        btnGrafikStatusRegPerTahun.setForeground(new java.awt.Color(0, 0, 0));
        btnGrafikStatusRegPerTahun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1491582015_11.png"))); // NOI18N
        btnGrafikStatusRegPerTahun.setText("Registrasi Lama Per Tahun");
        btnGrafikStatusRegPerTahun.setIconTextGap(0);
        btnGrafikStatusRegPerTahun.setName("btnGrafikStatusRegPerTahun"); // NOI18N
        btnGrafikStatusRegPerTahun.setPreferredSize(new java.awt.Dimension(200, 90));
        btnGrafikStatusRegPerTahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrafikStatusRegPerTahunActionPerformed(evt);
            }
        });
        Panelmenu.add(btnGrafikStatusRegPerTahun);

        btnGrafikStatusRegPerTahun2.setForeground(new java.awt.Color(0, 0, 0));
        btnGrafikStatusRegPerTahun2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1491582080_6.png"))); // NOI18N
        btnGrafikStatusRegPerTahun2.setText("Registrasi Baru Per Tahun");
        btnGrafikStatusRegPerTahun2.setIconTextGap(0);
        btnGrafikStatusRegPerTahun2.setName("btnGrafikStatusRegPerTahun2"); // NOI18N
        btnGrafikStatusRegPerTahun2.setPreferredSize(new java.awt.Dimension(200, 90));
        btnGrafikStatusRegPerTahun2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrafikStatusRegPerTahun2ActionPerformed(evt);
            }
        });
        Panelmenu.add(btnGrafikStatusRegPerTahun2);

        btnGrafikStatusRegPerBulan.setForeground(new java.awt.Color(0, 0, 0));
        btnGrafikStatusRegPerBulan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1491582015_11.png"))); // NOI18N
        btnGrafikStatusRegPerBulan.setText("Registrasi Lama Per Bulan");
        btnGrafikStatusRegPerBulan.setIconTextGap(0);
        btnGrafikStatusRegPerBulan.setName("btnGrafikStatusRegPerBulan"); // NOI18N
        btnGrafikStatusRegPerBulan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnGrafikStatusRegPerBulan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrafikStatusRegPerBulanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnGrafikStatusRegPerBulan);

        btnGrafikStatusRegPerBulan2.setForeground(new java.awt.Color(0, 0, 0));
        btnGrafikStatusRegPerBulan2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1491582080_6.png"))); // NOI18N
        btnGrafikStatusRegPerBulan2.setText("Registrasi Baru Per Bulan");
        btnGrafikStatusRegPerBulan2.setIconTextGap(0);
        btnGrafikStatusRegPerBulan2.setName("btnGrafikStatusRegPerBulan2"); // NOI18N
        btnGrafikStatusRegPerBulan2.setPreferredSize(new java.awt.Dimension(200, 90));
        btnGrafikStatusRegPerBulan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrafikStatusRegPerBulan2ActionPerformed(evt);
            }
        });
        Panelmenu.add(btnGrafikStatusRegPerBulan2);

        btnGrafikStatusRegPerTanggal.setForeground(new java.awt.Color(0, 0, 0));
        btnGrafikStatusRegPerTanggal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1491582080_6.png"))); // NOI18N
        btnGrafikStatusRegPerTanggal.setText("Registrasi Lama Per Tanggal");
        btnGrafikStatusRegPerTanggal.setIconTextGap(0);
        btnGrafikStatusRegPerTanggal.setName("btnGrafikStatusRegPerTanggal"); // NOI18N
        btnGrafikStatusRegPerTanggal.setPreferredSize(new java.awt.Dimension(200, 90));
        btnGrafikStatusRegPerTanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrafikStatusRegPerTanggalActionPerformed(evt);
            }
        });
        Panelmenu.add(btnGrafikStatusRegPerTanggal);

        btnGrafikStatusRegPerTanggal2.setForeground(new java.awt.Color(0, 0, 0));
        btnGrafikStatusRegPerTanggal2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1491582015_11.png"))); // NOI18N
        btnGrafikStatusRegPerTanggal2.setText("Registrasi Baru Per Tanggal");
        btnGrafikStatusRegPerTanggal2.setIconTextGap(0);
        btnGrafikStatusRegPerTanggal2.setName("btnGrafikStatusRegPerTanggal2"); // NOI18N
        btnGrafikStatusRegPerTanggal2.setPreferredSize(new java.awt.Dimension(200, 90));
        btnGrafikStatusRegPerTanggal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrafikStatusRegPerTanggal2ActionPerformed(evt);
            }
        });
        Panelmenu.add(btnGrafikStatusRegPerTanggal2);

        btnGrafikStatusRegBatalPerTahun.setForeground(new java.awt.Color(0, 0, 0));
        btnGrafikStatusRegBatalPerTahun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1491582080_6.png"))); // NOI18N
        btnGrafikStatusRegBatalPerTahun.setText("Batal Periksa Per Tahun");
        btnGrafikStatusRegBatalPerTahun.setIconTextGap(0);
        btnGrafikStatusRegBatalPerTahun.setName("btnGrafikStatusRegBatalPerTahun"); // NOI18N
        btnGrafikStatusRegBatalPerTahun.setPreferredSize(new java.awt.Dimension(200, 90));
        btnGrafikStatusRegBatalPerTahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrafikStatusRegBatalPerTahunActionPerformed(evt);
            }
        });
        Panelmenu.add(btnGrafikStatusRegBatalPerTahun);

        btnGrafikStatusRegBatalPerBulan.setForeground(new java.awt.Color(0, 0, 0));
        btnGrafikStatusRegBatalPerBulan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1491582015_11.png"))); // NOI18N
        btnGrafikStatusRegBatalPerBulan.setText("Batal Periksa Per Bulan");
        btnGrafikStatusRegBatalPerBulan.setIconTextGap(0);
        btnGrafikStatusRegBatalPerBulan.setName("btnGrafikStatusRegBatalPerBulan"); // NOI18N
        btnGrafikStatusRegBatalPerBulan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnGrafikStatusRegBatalPerBulan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrafikStatusRegBatalPerBulanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnGrafikStatusRegBatalPerBulan);

        btnCekPCareDiagnosa.setForeground(new java.awt.Color(0, 0, 0));
        btnCekPCareDiagnosa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Gnome-X-Office-Address-Book-48.png"))); // NOI18N
        btnCekPCareDiagnosa.setText("Referensi Diagnosa PCare");
        btnCekPCareDiagnosa.setIconTextGap(0);
        btnCekPCareDiagnosa.setName("btnCekPCareDiagnosa"); // NOI18N
        btnCekPCareDiagnosa.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekPCareDiagnosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekPCareDiagnosaActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekPCareDiagnosa);

        btnGrafikStatusRegBatalPerTanggal.setForeground(new java.awt.Color(0, 0, 0));
        btnGrafikStatusRegBatalPerTanggal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1491582080_6.png"))); // NOI18N
        btnGrafikStatusRegBatalPerTanggal.setText("Batal Periksa Per Tanggal");
        btnGrafikStatusRegBatalPerTanggal.setIconTextGap(0);
        btnGrafikStatusRegBatalPerTanggal.setName("btnGrafikStatusRegBatalPerTanggal"); // NOI18N
        btnGrafikStatusRegBatalPerTanggal.setPreferredSize(new java.awt.Dimension(200, 90));
        btnGrafikStatusRegBatalPerTanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrafikStatusRegBatalPerTanggalActionPerformed(evt);
            }
        });
        Panelmenu.add(btnGrafikStatusRegBatalPerTanggal);

        btnKategoriBarang.setForeground(new java.awt.Color(0, 0, 0));
        btnKategoriBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/address-book.png"))); // NOI18N
        btnKategoriBarang.setText("Kategori Obat, Alkes & BHP");
        btnKategoriBarang.setIconTextGap(0);
        btnKategoriBarang.setName("btnKategoriBarang"); // NOI18N
        btnKategoriBarang.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKategoriBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKategoriBarangActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKategoriBarang);

        btnGolonganBarang.setForeground(new java.awt.Color(0, 0, 0));
        btnGolonganBarang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360485894_add-notes.png"))); // NOI18N
        btnGolonganBarang.setText("Golongan Obat, Alkes & BHP");
        btnGolonganBarang.setIconTextGap(0);
        btnGolonganBarang.setName("btnGolonganBarang"); // NOI18N
        btnGolonganBarang.setPreferredSize(new java.awt.Dimension(200, 90));
        btnGolonganBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGolonganBarangActionPerformed(evt);
            }
        });
        Panelmenu.add(btnGolonganBarang);

        btnObatPerTanggal.setForeground(new java.awt.Color(0, 0, 0));
        btnObatPerTanggal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360485865_schedule.png"))); // NOI18N
        btnObatPerTanggal.setText("Obat/Alkes/BHP Per Tanggal");
        btnObatPerTanggal.setIconTextGap(0);
        btnObatPerTanggal.setName("btnObatPerTanggal"); // NOI18N
        btnObatPerTanggal.setPreferredSize(new java.awt.Dimension(200, 90));
        btnObatPerTanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObatPerTanggalActionPerformed(evt);
            }
        });
        Panelmenu.add(btnObatPerTanggal);

        btnPenjualanPerTanggal.setForeground(new java.awt.Color(0, 0, 0));
        btnPenjualanPerTanggal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360485865_schedule.png"))); // NOI18N
        btnPenjualanPerTanggal.setText("Penjualan Bebas Per Tanggal");
        btnPenjualanPerTanggal.setIconTextGap(0);
        btnPenjualanPerTanggal.setName("btnPenjualanPerTanggal"); // NOI18N
        btnPenjualanPerTanggal.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPenjualanPerTanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenjualanPerTanggalActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPenjualanPerTanggal);

        btnSKDPbpjs.setForeground(new java.awt.Color(0, 0, 0));
        btnSKDPbpjs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnSKDPbpjs.setText("SKDP BPJS VClaim");
        btnSKDPbpjs.setIconTextGap(0);
        btnSKDPbpjs.setName("btnSKDPbpjs"); // NOI18N
        btnSKDPbpjs.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSKDPbpjs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSKDPbpjsActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSKDPbpjs);

        btnRujukKeluarVclaim.setForeground(new java.awt.Color(0, 0, 0));
        btnRujukKeluarVclaim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnRujukKeluarVclaim.setText("Rujukan Keluar BPJS VClaim");
        btnRujukKeluarVclaim.setIconTextGap(0);
        btnRujukKeluarVclaim.setName("btnRujukKeluarVclaim"); // NOI18N
        btnRujukKeluarVclaim.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRujukKeluarVclaim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRujukKeluarVclaimActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRujukKeluarVclaim);

        btnBookingReg.setForeground(new java.awt.Color(0, 0, 0));
        btnBookingReg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/if_Address Book_32590.png"))); // NOI18N
        btnBookingReg.setText("Booking Registrasi");
        btnBookingReg.setIconTextGap(0);
        btnBookingReg.setName("btnBookingReg"); // NOI18N
        btnBookingReg.setPreferredSize(new java.awt.Dimension(200, 90));
        btnBookingReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookingRegActionPerformed(evt);
            }
        });
        Panelmenu.add(btnBookingReg);

        btnBPJScekRiwayatRujukanPcare.setForeground(new java.awt.Color(0, 0, 0));
        btnBPJScekRiwayatRujukanPcare.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/pcare.png"))); // NOI18N
        btnBPJScekRiwayatRujukanPcare.setText("Riwayat Rujukan PCare di VClaim");
        btnBPJScekRiwayatRujukanPcare.setIconTextGap(0);
        btnBPJScekRiwayatRujukanPcare.setName("btnBPJScekRiwayatRujukanPcare"); // NOI18N
        btnBPJScekRiwayatRujukanPcare.setPreferredSize(new java.awt.Dimension(200, 90));
        btnBPJScekRiwayatRujukanPcare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBPJScekRiwayatRujukanPcareActionPerformed(evt);
            }
        });
        Panelmenu.add(btnBPJScekRiwayatRujukanPcare);

        btnCekBPJSRiwayatRujukanRS.setForeground(new java.awt.Color(0, 0, 0));
        btnCekBPJSRiwayatRujukanRS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekBPJSRiwayatRujukanRS.setText("Riwayat Rujukan RS di VClaim");
        btnCekBPJSRiwayatRujukanRS.setIconTextGap(0);
        btnCekBPJSRiwayatRujukanRS.setName("btnCekBPJSRiwayatRujukanRS"); // NOI18N
        btnCekBPJSRiwayatRujukanRS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekBPJSRiwayatRujukanRS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekBPJSRiwayatRujukanRSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekBPJSRiwayatRujukanRS);

        btnCekBPJSRujukanKartuRS.setForeground(new java.awt.Color(0, 0, 0));
        btnCekBPJSRujukanKartuRS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekBPJSRujukanKartuRS.setText("Cek Rujukan Kartu RS di VClaim");
        btnCekBPJSRujukanKartuRS.setIconTextGap(0);
        btnCekBPJSRujukanKartuRS.setName("btnCekBPJSRujukanKartuRS"); // NOI18N
        btnCekBPJSRujukanKartuRS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekBPJSRujukanKartuRS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekBPJSRujukanKartuRSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekBPJSRujukanKartuRS);

        btnCekBPJSTanggalRujukan.setForeground(new java.awt.Color(0, 0, 0));
        btnCekBPJSTanggalRujukan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekBPJSTanggalRujukan.setText("Daftar Rujukan Khusus di VClaim");
        btnCekBPJSTanggalRujukan.setIconTextGap(0);
        btnCekBPJSTanggalRujukan.setName("btnCekBPJSTanggalRujukan"); // NOI18N
        btnCekBPJSTanggalRujukan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekBPJSTanggalRujukan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekBPJSTanggalRujukanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekBPJSTanggalRujukan);

        btnCekBPJSNomorRujukanRS.setForeground(new java.awt.Color(0, 0, 0));
        btnCekBPJSNomorRujukanRS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekBPJSNomorRujukanRS.setText("Cek No.Rujukan RS di VClaim");
        btnCekBPJSNomorRujukanRS.setIconTextGap(0);
        btnCekBPJSNomorRujukanRS.setName("btnCekBPJSNomorRujukanRS"); // NOI18N
        btnCekBPJSNomorRujukanRS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekBPJSNomorRujukanRS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekBPJSNomorRujukanRSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekBPJSNomorRujukanRS);

        btnCekBPJSRujukanKartuPCare.setForeground(new java.awt.Color(0, 0, 0));
        btnCekBPJSRujukanKartuPCare.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/pcare.png"))); // NOI18N
        btnCekBPJSRujukanKartuPCare.setText("Cek Rujukan Kartu PCare di VClaim");
        btnCekBPJSRujukanKartuPCare.setIconTextGap(0);
        btnCekBPJSRujukanKartuPCare.setName("btnCekBPJSRujukanKartuPCare"); // NOI18N
        btnCekBPJSRujukanKartuPCare.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekBPJSRujukanKartuPCare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekBPJSRujukanKartuPCareActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekBPJSRujukanKartuPCare);

        btnCekReferensiKelasRawatBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnCekReferensiKelasRawatBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekReferensiKelasRawatBPJS.setText("Referensi Kelas Rawat VClaim");
        btnCekReferensiKelasRawatBPJS.setIconTextGap(0);
        btnCekReferensiKelasRawatBPJS.setName("btnCekReferensiKelasRawatBPJS"); // NOI18N
        btnCekReferensiKelasRawatBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekReferensiKelasRawatBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekReferensiKelasRawatBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekReferensiKelasRawatBPJS);

        btnCekReferensiProsedurBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnCekReferensiProsedurBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekReferensiProsedurBPJS.setText("Referensi Prosedur VClaim");
        btnCekReferensiProsedurBPJS.setIconTextGap(0);
        btnCekReferensiProsedurBPJS.setName("btnCekReferensiProsedurBPJS"); // NOI18N
        btnCekReferensiProsedurBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekReferensiProsedurBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekReferensiProsedurBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekReferensiProsedurBPJS);

        btnCekReferensiDokterDPJPBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnCekReferensiDokterDPJPBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekReferensiDokterDPJPBPJS.setText("Referensi Dokter DPJP VClaim");
        btnCekReferensiDokterDPJPBPJS.setIconTextGap(0);
        btnCekReferensiDokterDPJPBPJS.setName("btnCekReferensiDokterDPJPBPJS"); // NOI18N
        btnCekReferensiDokterDPJPBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekReferensiDokterDPJPBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekReferensiDokterDPJPBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekReferensiDokterDPJPBPJS);

        btnCekReferensiDokterBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnCekReferensiDokterBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekReferensiDokterBPJS.setText("Referensi Dokter VClaim");
        btnCekReferensiDokterBPJS.setIconTextGap(0);
        btnCekReferensiDokterBPJS.setName("btnCekReferensiDokterBPJS"); // NOI18N
        btnCekReferensiDokterBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekReferensiDokterBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekReferensiDokterBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekReferensiDokterBPJS);

        btnCekReferensiSpesialistikBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnCekReferensiSpesialistikBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekReferensiSpesialistikBPJS.setText("Referensi Spesialistik VClaim");
        btnCekReferensiSpesialistikBPJS.setIconTextGap(0);
        btnCekReferensiSpesialistikBPJS.setName("btnCekReferensiSpesialistikBPJS"); // NOI18N
        btnCekReferensiSpesialistikBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekReferensiSpesialistikBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekReferensiSpesialistikBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekReferensiSpesialistikBPJS);

        btnCekReferensiRuangRawatBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnCekReferensiRuangRawatBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekReferensiRuangRawatBPJS.setText("Referensi Ruang Rawat VClaim");
        btnCekReferensiRuangRawatBPJS.setIconTextGap(0);
        btnCekReferensiRuangRawatBPJS.setName("btnCekReferensiRuangRawatBPJS"); // NOI18N
        btnCekReferensiRuangRawatBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekReferensiRuangRawatBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekReferensiRuangRawatBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekReferensiRuangRawatBPJS);

        btnCekReferensiCaraKeluarBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnCekReferensiCaraKeluarBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekReferensiCaraKeluarBPJS.setText("Referensi Cara Keluar VClaim");
        btnCekReferensiCaraKeluarBPJS.setIconTextGap(0);
        btnCekReferensiCaraKeluarBPJS.setName("btnCekReferensiCaraKeluarBPJS"); // NOI18N
        btnCekReferensiCaraKeluarBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekReferensiCaraKeluarBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekReferensiCaraKeluarBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekReferensiCaraKeluarBPJS);

        btnCekReferensiPascaPulangBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnCekReferensiPascaPulangBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekReferensiPascaPulangBPJS.setText("Referensi Pasca Pulang VClaim");
        btnCekReferensiPascaPulangBPJS.setIconTextGap(0);
        btnCekReferensiPascaPulangBPJS.setName("btnCekReferensiPascaPulangBPJS"); // NOI18N
        btnCekReferensiPascaPulangBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekReferensiPascaPulangBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekReferensiPascaPulangBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekReferensiPascaPulangBPJS);

        btnCekReferensiPropinsiBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnCekReferensiPropinsiBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekReferensiPropinsiBPJS.setText("Referensi Propinsi VClaim");
        btnCekReferensiPropinsiBPJS.setIconTextGap(0);
        btnCekReferensiPropinsiBPJS.setName("btnCekReferensiPropinsiBPJS"); // NOI18N
        btnCekReferensiPropinsiBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekReferensiPropinsiBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekReferensiPropinsiBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekReferensiPropinsiBPJS);

        btnCekReferensiKabupatenBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnCekReferensiKabupatenBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekReferensiKabupatenBPJS.setText("Referensi Kabupaten VClaim");
        btnCekReferensiKabupatenBPJS.setIconTextGap(0);
        btnCekReferensiKabupatenBPJS.setName("btnCekReferensiKabupatenBPJS"); // NOI18N
        btnCekReferensiKabupatenBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekReferensiKabupatenBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekReferensiKabupatenBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekReferensiKabupatenBPJS);

        btnCekReferensiKecamatanBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnCekReferensiKecamatanBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekReferensiKecamatanBPJS.setText("Referensi Kecamatan VClaim");
        btnCekReferensiKecamatanBPJS.setIconTextGap(0);
        btnCekReferensiKecamatanBPJS.setName("btnCekReferensiKecamatanBPJS"); // NOI18N
        btnCekReferensiKecamatanBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekReferensiKecamatanBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekReferensiKecamatanBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekReferensiKecamatanBPJS);

        btnPermintaanLab.setForeground(new java.awt.Color(0, 0, 0));
        btnPermintaanLab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/if_laboratory_44676.png"))); // NOI18N
        btnPermintaanLab.setText("Permintaan Lab");
        btnPermintaanLab.setIconTextGap(0);
        btnPermintaanLab.setName("btnPermintaanLab"); // NOI18N
        btnPermintaanLab.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPermintaanLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPermintaanLabActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPermintaanLab);

        btnPermintaanRadiologi.setForeground(new java.awt.Color(0, 0, 0));
        btnPermintaanRadiologi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/if_Thorax_X-Ray_Black_63791.png"))); // NOI18N
        btnPermintaanRadiologi.setText("Permintaan Radiologi");
        btnPermintaanRadiologi.setIconTextGap(0);
        btnPermintaanRadiologi.setName("btnPermintaanRadiologi"); // NOI18N
        btnPermintaanRadiologi.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPermintaanRadiologi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPermintaanRadiologiActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPermintaanRadiologi);

        btnJumlahPorsiDiet.setForeground(new java.awt.Color(0, 0, 0));
        btnJumlahPorsiDiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/iconfinder_bibimbub_3377053.png"))); // NOI18N
        btnJumlahPorsiDiet.setText("Rekap Bulanan Porsi Diet");
        btnJumlahPorsiDiet.setIconTextGap(0);
        btnJumlahPorsiDiet.setName("btnJumlahPorsiDiet"); // NOI18N
        btnJumlahPorsiDiet.setPreferredSize(new java.awt.Dimension(200, 90));
        btnJumlahPorsiDiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJumlahPorsiDietActionPerformed(evt);
            }
        });
        Panelmenu.add(btnJumlahPorsiDiet);

        btnJumlahMacamDiet.setForeground(new java.awt.Color(0, 0, 0));
        btnJumlahMacamDiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/iconfinder_ramen_3377055.png"))); // NOI18N
        btnJumlahMacamDiet.setText("Rekap Bulanan Macam Diet");
        btnJumlahMacamDiet.setIconTextGap(0);
        btnJumlahMacamDiet.setName("btnJumlahMacamDiet"); // NOI18N
        btnJumlahMacamDiet.setPreferredSize(new java.awt.Dimension(200, 90));
        btnJumlahMacamDiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJumlahMacamDietActionPerformed(evt);
            }
        });
        Panelmenu.add(btnJumlahMacamDiet);

        btnMasterFaskes.setForeground(new java.awt.Color(0, 0, 0));
        btnMasterFaskes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360815935_contacts.png"))); // NOI18N
        btnMasterFaskes.setText("Master Data Faskes/Perujuk");
        btnMasterFaskes.setIconTextGap(0);
        btnMasterFaskes.setName("btnMasterFaskes"); // NOI18N
        btnMasterFaskes.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMasterFaskes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterFaskesActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMasterFaskes);

        btnCekSisruteFaskes.setForeground(new java.awt.Color(0, 0, 0));
        btnCekSisruteFaskes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/industry.png"))); // NOI18N
        btnCekSisruteFaskes.setText("Referensi Faskes Sisrute");
        btnCekSisruteFaskes.setIconTextGap(0);
        btnCekSisruteFaskes.setName("btnCekSisruteFaskes"); // NOI18N
        btnCekSisruteFaskes.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekSisruteFaskes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekSisruteFaskesActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekSisruteFaskes);

        btnCekSisruteAlasanRujuk.setForeground(new java.awt.Color(0, 0, 0));
        btnCekSisruteAlasanRujuk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/if_todo_list_add_17451.png"))); // NOI18N
        btnCekSisruteAlasanRujuk.setText("Referensi Alasan Rujuk Sisrute");
        btnCekSisruteAlasanRujuk.setIconTextGap(0);
        btnCekSisruteAlasanRujuk.setName("btnCekSisruteAlasanRujuk"); // NOI18N
        btnCekSisruteAlasanRujuk.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekSisruteAlasanRujuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekSisruteAlasanRujukActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekSisruteAlasanRujuk);

        btnCekSisruteDiagnosa.setForeground(new java.awt.Color(0, 0, 0));
        btnCekSisruteDiagnosa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Gnome-X-Office-Address-Book-48.png"))); // NOI18N
        btnCekSisruteDiagnosa.setText("Referensi Diagnosa Sisrute");
        btnCekSisruteDiagnosa.setIconTextGap(0);
        btnCekSisruteDiagnosa.setName("btnCekSisruteDiagnosa"); // NOI18N
        btnCekSisruteDiagnosa.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekSisruteDiagnosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekSisruteDiagnosaActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekSisruteDiagnosa);

        btnRujukanMasukSisrute.setForeground(new java.awt.Color(0, 0, 0));
        btnRujukanMasukSisrute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/iconfinder_analysis_60159.png"))); // NOI18N
        btnRujukanMasukSisrute.setText("Rujukan Masuk Sisrute");
        btnRujukanMasukSisrute.setIconTextGap(0);
        btnRujukanMasukSisrute.setName("btnRujukanMasukSisrute"); // NOI18N
        btnRujukanMasukSisrute.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRujukanMasukSisrute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRujukanMasukSisruteActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRujukanMasukSisrute);

        btnRujukanKeluarSisrute.setForeground(new java.awt.Color(0, 0, 0));
        btnRujukanKeluarSisrute.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1485357758_Doctor.png"))); // NOI18N
        btnRujukanKeluarSisrute.setText("Rujukan Keluar Sisrute");
        btnRujukanKeluarSisrute.setIconTextGap(0);
        btnRujukanKeluarSisrute.setName("btnRujukanKeluarSisrute"); // NOI18N
        btnRujukanKeluarSisrute.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRujukanKeluarSisrute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRujukanKeluarSisruteActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRujukanKeluarSisrute);

        btnBarangCSSD.setForeground(new java.awt.Color(0, 0, 0));
        btnBarangCSSD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/if_order-history_49596.png"))); // NOI18N
        btnBarangCSSD.setText("Barang CSSD");
        btnBarangCSSD.setIconTextGap(0);
        btnBarangCSSD.setName("btnBarangCSSD"); // NOI18N
        btnBarangCSSD.setPreferredSize(new java.awt.Dimension(200, 90));
        btnBarangCSSD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarangCSSDActionPerformed(evt);
            }
        });
        Panelmenu.add(btnBarangCSSD);

        btnPasienPonek.setForeground(new java.awt.Color(0, 0, 0));
        btnPasienPonek.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/checklist.png"))); // NOI18N
        btnPasienPonek.setText("Pasien Ponek (Obgyn)");
        btnPasienPonek.setIconTextGap(0);
        btnPasienPonek.setName("btnPasienPonek"); // NOI18N
        btnPasienPonek.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPasienPonek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasienPonekActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPasienPonek);

        btnHarianHAIsRanap.setForeground(new java.awt.Color(0, 0, 0));
        btnHarianHAIsRanap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1485357758_Doctor.png"))); // NOI18N
        btnHarianHAIsRanap.setText("Harian HAIs Rawat Inap");
        btnHarianHAIsRanap.setIconTextGap(0);
        btnHarianHAIsRanap.setName("btnHarianHAIsRanap"); // NOI18N
        btnHarianHAIsRanap.setPreferredSize(new java.awt.Dimension(200, 90));
        btnHarianHAIsRanap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHarianHAIsRanapActionPerformed(evt);
            }
        });
        Panelmenu.add(btnHarianHAIsRanap);

        btnHarianHAIsRalan.setForeground(new java.awt.Color(0, 0, 0));
        btnHarianHAIsRalan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/patient (1).png"))); // NOI18N
        btnHarianHAIsRalan.setText("Harian HAIs Rawat Jalan");
        btnHarianHAIsRalan.setIconTextGap(0);
        btnHarianHAIsRalan.setName("btnHarianHAIsRalan"); // NOI18N
        btnHarianHAIsRalan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnHarianHAIsRalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHarianHAIsRalanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnHarianHAIsRalan);

        btnBulananHAIsRanap.setForeground(new java.awt.Color(0, 0, 0));
        btnBulananHAIsRanap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/kwrite.png"))); // NOI18N
        btnBulananHAIsRanap.setText("Bulanan HAIs Rawat Inap");
        btnBulananHAIsRanap.setIconTextGap(0);
        btnBulananHAIsRanap.setName("btnBulananHAIsRanap"); // NOI18N
        btnBulananHAIsRanap.setPreferredSize(new java.awt.Dimension(200, 90));
        btnBulananHAIsRanap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBulananHAIsRanapActionPerformed(evt);
            }
        });
        Panelmenu.add(btnBulananHAIsRanap);

        btnBulananHAIsRalan.setForeground(new java.awt.Color(0, 0, 0));
        btnBulananHAIsRalan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/stock_task.png"))); // NOI18N
        btnBulananHAIsRalan.setText("Bulanan HAIs Rawat Jalan");
        btnBulananHAIsRalan.setIconTextGap(0);
        btnBulananHAIsRalan.setName("btnBulananHAIsRalan"); // NOI18N
        btnBulananHAIsRalan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnBulananHAIsRalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBulananHAIsRalanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnBulananHAIsRalan);

        btnRingkasanPulangRanap.setForeground(new java.awt.Color(0, 0, 0));
        btnRingkasanPulangRanap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360816018_tests.png"))); // NOI18N
        btnRingkasanPulangRanap.setText("Ringkasan Pulang Ranap");
        btnRingkasanPulangRanap.setIconTextGap(0);
        btnRingkasanPulangRanap.setName("btnRingkasanPulangRanap"); // NOI18N
        btnRingkasanPulangRanap.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRingkasanPulangRanap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRingkasanPulangRanapActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRingkasanPulangRanap);

        btnLaporanFarmasi.setForeground(new java.awt.Color(0, 0, 0));
        btnLaporanFarmasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360816018_tests.png"))); // NOI18N
        btnLaporanFarmasi.setText("Laporan Farmasi");
        btnLaporanFarmasi.setIconTextGap(0);
        btnLaporanFarmasi.setName("btnLaporanFarmasi"); // NOI18N
        btnLaporanFarmasi.setPreferredSize(new java.awt.Dimension(200, 90));
        btnLaporanFarmasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLaporanFarmasiActionPerformed(evt);
            }
        });
        Panelmenu.add(btnLaporanFarmasi);

        btnMasterMasalahKeperawatan.setForeground(new java.awt.Color(0, 0, 0));
        btnMasterMasalahKeperawatan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/iconfinder_Notebook_3387299.png"))); // NOI18N
        btnMasterMasalahKeperawatan.setText("Master Masalah Keperawatan");
        btnMasterMasalahKeperawatan.setIconTextGap(0);
        btnMasterMasalahKeperawatan.setName("btnMasterMasalahKeperawatan"); // NOI18N
        btnMasterMasalahKeperawatan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMasterMasalahKeperawatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterMasalahKeperawatanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMasterMasalahKeperawatan);

        btnPenilaianAwalKeperawatanRalan.setForeground(new java.awt.Color(0, 0, 0));
        btnPenilaianAwalKeperawatanRalan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/iconfinder_basket_8726.png"))); // NOI18N
        btnPenilaianAwalKeperawatanRalan.setText("Penilaian Awal Keperawatan Ralan");
        btnPenilaianAwalKeperawatanRalan.setIconTextGap(0);
        btnPenilaianAwalKeperawatanRalan.setName("btnPenilaianAwalKeperawatanRalan"); // NOI18N
        btnPenilaianAwalKeperawatanRalan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPenilaianAwalKeperawatanRalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenilaianAwalKeperawatanRalanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPenilaianAwalKeperawatanRalan);

        btnDataTriaseIGD.setForeground(new java.awt.Color(0, 0, 0));
        btnDataTriaseIGD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/iconfinder_h2_19724.png"))); // NOI18N
        btnDataTriaseIGD.setText("Data Triase IGD");
        btnDataTriaseIGD.setIconTextGap(0);
        btnDataTriaseIGD.setName("btnDataTriaseIGD"); // NOI18N
        btnDataTriaseIGD.setPreferredSize(new java.awt.Dimension(200, 90));
        btnDataTriaseIGD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataTriaseIGDActionPerformed(evt);
            }
        });
        Panelmenu.add(btnDataTriaseIGD);

        btnMasterCaraBayar.setForeground(new java.awt.Color(0, 0, 0));
        btnMasterCaraBayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1485357524_Company.png"))); // NOI18N
        btnMasterCaraBayar.setText("Master Penanggung Jawab/Cara Bayar");
        btnMasterCaraBayar.setIconTextGap(0);
        btnMasterCaraBayar.setName("btnMasterCaraBayar"); // NOI18N
        btnMasterCaraBayar.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMasterCaraBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterCaraBayarActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMasterCaraBayar);

        btnDataPersalinan.setForeground(new java.awt.Color(0, 0, 0));
        btnDataPersalinan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1481002413_surgeon.png"))); // NOI18N
        btnDataPersalinan.setText("Data Persalinan Pasien");
        btnDataPersalinan.setIconTextGap(0);
        btnDataPersalinan.setName("btnDataPersalinan"); // NOI18N
        btnDataPersalinan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnDataPersalinan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataPersalinanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnDataPersalinan);

        btnPasienCorona.setForeground(new java.awt.Color(0, 0, 0));
        btnPasienCorona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/iconfinder_fever-illness-sick-temperature-thermomete_5994873.png"))); // NOI18N
        btnPasienCorona.setText("Pasien Corona");
        btnPasienCorona.setIconTextGap(0);
        btnPasienCorona.setName("btnPasienCorona"); // NOI18N
        btnPasienCorona.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPasienCorona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasienCoronaActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPasienCorona);

        btnDiagnosaPasienCorona.setForeground(new java.awt.Color(0, 0, 0));
        btnDiagnosaPasienCorona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/iconfinder_Dna-genetics-genomic-strand-virus_5994869.png"))); // NOI18N
        btnDiagnosaPasienCorona.setText("Diagnosa Pasien Corona");
        btnDiagnosaPasienCorona.setIconTextGap(0);
        btnDiagnosaPasienCorona.setName("btnDiagnosaPasienCorona"); // NOI18N
        btnDiagnosaPasienCorona.setPreferredSize(new java.awt.Dimension(200, 90));
        btnDiagnosaPasienCorona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiagnosaPasienCoronaActionPerformed(evt);
            }
        });
        Panelmenu.add(btnDiagnosaPasienCorona);

        btnPerawatanPasienCorona.setForeground(new java.awt.Color(0, 0, 0));
        btnPerawatanPasienCorona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/iconfinder_Night-sleep-sleeping-health_5994844.png"))); // NOI18N
        btnPerawatanPasienCorona.setText("Perawatan Pasien Corona");
        btnPerawatanPasienCorona.setIconTextGap(0);
        btnPerawatanPasienCorona.setName("btnPerawatanPasienCorona"); // NOI18N
        btnPerawatanPasienCorona.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPerawatanPasienCorona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerawatanPasienCoronaActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPerawatanPasienCorona);

        btnAsuhanGiziRanap.setForeground(new java.awt.Color(0, 0, 0));
        btnAsuhanGiziRanap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/iconfinder_TextEdit_37595.png"))); // NOI18N
        btnAsuhanGiziRanap.setText("Asuhan Gizi Rawat Inap");
        btnAsuhanGiziRanap.setIconTextGap(0);
        btnAsuhanGiziRanap.setName("btnAsuhanGiziRanap"); // NOI18N
        btnAsuhanGiziRanap.setPreferredSize(new java.awt.Dimension(200, 90));
        btnAsuhanGiziRanap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsuhanGiziRanapActionPerformed(evt);
            }
        });
        Panelmenu.add(btnAsuhanGiziRanap);

        btnAssesmenUlangGizi.setForeground(new java.awt.Color(0, 0, 0));
        btnAssesmenUlangGizi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/iconfinder_basket_8726.png"))); // NOI18N
        btnAssesmenUlangGizi.setText("Asesmen Ulang Gizi Rawat Inap");
        btnAssesmenUlangGizi.setIconTextGap(0);
        btnAssesmenUlangGizi.setName("btnAssesmenUlangGizi"); // NOI18N
        btnAssesmenUlangGizi.setPreferredSize(new java.awt.Dimension(200, 90));
        btnAssesmenUlangGizi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssesmenUlangGiziActionPerformed(evt);
            }
        });
        Panelmenu.add(btnAssesmenUlangGizi);

        btnRencanaKontrolBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnRencanaKontrolBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnRencanaKontrolBPJS.setText("Rencana Kontrol BPJS VClaim");
        btnRencanaKontrolBPJS.setIconTextGap(0);
        btnRencanaKontrolBPJS.setName("btnRencanaKontrolBPJS"); // NOI18N
        btnRencanaKontrolBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRencanaKontrolBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRencanaKontrolBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRencanaKontrolBPJS);

        btnMonevAsuhanGizi.setForeground(new java.awt.Color(0, 0, 0));
        btnMonevAsuhanGizi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/if_order-history_49596.png"))); // NOI18N
        btnMonevAsuhanGizi.setText("Monitoring & Evaluasi Asuhan Gizi");
        btnMonevAsuhanGizi.setIconTextGap(0);
        btnMonevAsuhanGizi.setName("btnMonevAsuhanGizi"); // NOI18N
        btnMonevAsuhanGizi.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMonevAsuhanGizi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonevAsuhanGiziActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMonevAsuhanGizi);

        btnBridgingEklaimINACBG.setForeground(new java.awt.Color(0, 0, 0));
        btnBridgingEklaimINACBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/inacbg_eklaim.png"))); // NOI18N
        btnBridgingEklaimINACBG.setText("Bridging Eklaim INACBG");
        btnBridgingEklaimINACBG.setIconTextGap(0);
        btnBridgingEklaimINACBG.setName("btnBridgingEklaimINACBG"); // NOI18N
        btnBridgingEklaimINACBG.setPreferredSize(new java.awt.Dimension(200, 90));
        btnBridgingEklaimINACBG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBridgingEklaimINACBGActionPerformed(evt);
            }
        });
        Panelmenu.add(btnBridgingEklaimINACBG);

        btnPengajuanKlaimINACBGrz.setForeground(new java.awt.Color(0, 0, 0));
        btnPengajuanKlaimINACBGrz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/inacbg_eklaim.png"))); // NOI18N
        btnPengajuanKlaimINACBGrz.setText("Pengajuan Klaim INACBG");
        btnPengajuanKlaimINACBGrz.setIconTextGap(0);
        btnPengajuanKlaimINACBGrz.setName("btnPengajuanKlaimINACBGrz"); // NOI18N
        btnPengajuanKlaimINACBGrz.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPengajuanKlaimINACBGrz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPengajuanKlaimINACBGrzActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPengajuanKlaimINACBGrz);

        btnINACBGjknBelumDiklaim.setForeground(new java.awt.Color(0, 0, 0));
        btnINACBGjknBelumDiklaim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/inacbg_eklaim.png"))); // NOI18N
        btnINACBGjknBelumDiklaim.setText("Pasien JKN Belum Selesai Proses Klaim");
        btnINACBGjknBelumDiklaim.setIconTextGap(0);
        btnINACBGjknBelumDiklaim.setName("btnINACBGjknBelumDiklaim"); // NOI18N
        btnINACBGjknBelumDiklaim.setPreferredSize(new java.awt.Dimension(200, 90));
        btnINACBGjknBelumDiklaim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnINACBGjknBelumDiklaimActionPerformed(evt);
            }
        });
        Panelmenu.add(btnINACBGjknBelumDiklaim);

        btnInputKodeICD.setForeground(new java.awt.Color(0, 0, 0));
        btnInputKodeICD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/icd_10.png"))); // NOI18N
        btnInputKodeICD.setText("Input Kode ICD Rawat Jalan");
        btnInputKodeICD.setIconTextGap(0);
        btnInputKodeICD.setName("btnInputKodeICD"); // NOI18N
        btnInputKodeICD.setPreferredSize(new java.awt.Dimension(200, 90));
        btnInputKodeICD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInputKodeICDActionPerformed(evt);
            }
        });
        Panelmenu.add(btnInputKodeICD);

        btnKendaliMutuKendaliBiayaINACBG.setForeground(new java.awt.Color(0, 0, 0));
        btnKendaliMutuKendaliBiayaINACBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/inacbg_eklaim.png"))); // NOI18N
        btnKendaliMutuKendaliBiayaINACBG.setText("Kendali Mutu Kendali Biaya INACBG");
        btnKendaliMutuKendaliBiayaINACBG.setIconTextGap(0);
        btnKendaliMutuKendaliBiayaINACBG.setName("btnKendaliMutuKendaliBiayaINACBG"); // NOI18N
        btnKendaliMutuKendaliBiayaINACBG.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKendaliMutuKendaliBiayaINACBG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKendaliMutuKendaliBiayaINACBGActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKendaliMutuKendaliBiayaINACBG);

        btnDashboardeResepRalan.setForeground(new java.awt.Color(0, 0, 0));
        btnDashboardeResepRalan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/monitor.png"))); // NOI18N
        btnDashboardeResepRalan.setText("Dashboard e-Resep Rawat Jalan");
        btnDashboardeResepRalan.setIconTextGap(0);
        btnDashboardeResepRalan.setName("btnDashboardeResepRalan"); // NOI18N
        btnDashboardeResepRalan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnDashboardeResepRalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardeResepRalanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnDashboardeResepRalan);

        btnCekSEPInternalBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnCekSEPInternalBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekSEPInternalBPJS.setText("Cek SEP Internal BPJS VClaim");
        btnCekSEPInternalBPJS.setIconTextGap(0);
        btnCekSEPInternalBPJS.setName("btnCekSEPInternalBPJS"); // NOI18N
        btnCekSEPInternalBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekSEPInternalBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekSEPInternalBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekSEPInternalBPJS);

        btnSPRIbpjsVclaim.setForeground(new java.awt.Color(0, 0, 0));
        btnSPRIbpjsVclaim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnSPRIbpjsVclaim.setText("SPRI BPJS VClaim");
        btnSPRIbpjsVclaim.setIconTextGap(0);
        btnSPRIbpjsVclaim.setName("btnSPRIbpjsVclaim"); // NOI18N
        btnSPRIbpjsVclaim.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSPRIbpjsVclaim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSPRIbpjsVclaimActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSPRIbpjsVclaim);

        btnCekFingerPrinBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnCekFingerPrinBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekFingerPrinBPJS.setText("Cek Finger Print BPJS VClaim");
        btnCekFingerPrinBPJS.setIconTextGap(0);
        btnCekFingerPrinBPJS.setName("btnCekFingerPrinBPJS"); // NOI18N
        btnCekFingerPrinBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekFingerPrinBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekFingerPrinBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekFingerPrinBPJS);

        btnListSpesialistikRujukanBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnListSpesialistikRujukanBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnListSpesialistikRujukanBPJS.setText("List Spesialistik Rujukan BPJS VClaim");
        btnListSpesialistikRujukanBPJS.setIconTextGap(0);
        btnListSpesialistikRujukanBPJS.setName("btnListSpesialistikRujukanBPJS"); // NOI18N
        btnListSpesialistikRujukanBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnListSpesialistikRujukanBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListSpesialistikRujukanBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnListSpesialistikRujukanBPJS);

        btnListSaranaRujukanBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnListSaranaRujukanBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnListSaranaRujukanBPJS.setText("List Sarana Rujukan BPJS VClaim");
        btnListSaranaRujukanBPJS.setIconTextGap(0);
        btnListSaranaRujukanBPJS.setName("btnListSaranaRujukanBPJS"); // NOI18N
        btnListSaranaRujukanBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnListSaranaRujukanBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListSaranaRujukanBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnListSaranaRujukanBPJS);

        btnProgramPRBBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnProgramPRBBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnProgramPRBBPJS.setText("Program PRB BPJS VClaim");
        btnProgramPRBBPJS.setIconTextGap(0);
        btnProgramPRBBPJS.setName("btnProgramPRBBPJS"); // NOI18N
        btnProgramPRBBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnProgramPRBBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProgramPRBBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnProgramPRBBPJS);

        btnCekReferensiDiagnosaPRBBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnCekReferensiDiagnosaPRBBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekReferensiDiagnosaPRBBPJS.setText("Cek Referensi Diagnosa PRB BPJS VClaim");
        btnCekReferensiDiagnosaPRBBPJS.setIconTextGap(0);
        btnCekReferensiDiagnosaPRBBPJS.setName("btnCekReferensiDiagnosaPRBBPJS"); // NOI18N
        btnCekReferensiDiagnosaPRBBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekReferensiDiagnosaPRBBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekReferensiDiagnosaPRBBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekReferensiDiagnosaPRBBPJS);

        btnCekReferensiObatPRBBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnCekReferensiObatPRBBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekReferensiObatPRBBPJS.setText("Cek Referensi Obat PRB BPJS VClaim");
        btnCekReferensiObatPRBBPJS.setIconTextGap(0);
        btnCekReferensiObatPRBBPJS.setName("btnCekReferensiObatPRBBPJS"); // NOI18N
        btnCekReferensiObatPRBBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekReferensiObatPRBBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekReferensiObatPRBBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekReferensiObatPRBBPJS);

        btnDataNomorSuratKontrolBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnDataNomorSuratKontrolBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnDataNomorSuratKontrolBPJS.setText("Data No. Surat Kontrol/SPRI BPJS VClaim");
        btnDataNomorSuratKontrolBPJS.setIconTextGap(0);
        btnDataNomorSuratKontrolBPJS.setName("btnDataNomorSuratKontrolBPJS"); // NOI18N
        btnDataNomorSuratKontrolBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnDataNomorSuratKontrolBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataNomorSuratKontrolBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnDataNomorSuratKontrolBPJS);

        btnHistoriPelayananPesertaBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnHistoriPelayananPesertaBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnHistoriPelayananPesertaBPJS.setText("Histori Pelayanan Peserta BPJS VClaim");
        btnHistoriPelayananPesertaBPJS.setIconTextGap(0);
        btnHistoriPelayananPesertaBPJS.setName("btnHistoriPelayananPesertaBPJS"); // NOI18N
        btnHistoriPelayananPesertaBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnHistoriPelayananPesertaBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoriPelayananPesertaBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnHistoriPelayananPesertaBPJS);

        btnKlaimJaminanJasaRaharja.setForeground(new java.awt.Color(0, 0, 0));
        btnKlaimJaminanJasaRaharja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/jasa_raharja.png"))); // NOI18N
        btnKlaimJaminanJasaRaharja.setText("Klaim Jaminan Jasa Raharja VClaim");
        btnKlaimJaminanJasaRaharja.setIconTextGap(0);
        btnKlaimJaminanJasaRaharja.setName("btnKlaimJaminanJasaRaharja"); // NOI18N
        btnKlaimJaminanJasaRaharja.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKlaimJaminanJasaRaharja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKlaimJaminanJasaRaharjaActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKlaimJaminanJasaRaharja);

        btnDataSuplesiJasaRaharja.setForeground(new java.awt.Color(0, 0, 0));
        btnDataSuplesiJasaRaharja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/jasa_raharja.png"))); // NOI18N
        btnDataSuplesiJasaRaharja.setText("Data Suplesi Jasa Raharja VClaim");
        btnDataSuplesiJasaRaharja.setIconTextGap(0);
        btnDataSuplesiJasaRaharja.setName("btnDataSuplesiJasaRaharja"); // NOI18N
        btnDataSuplesiJasaRaharja.setPreferredSize(new java.awt.Dimension(200, 90));
        btnDataSuplesiJasaRaharja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataSuplesiJasaRaharjaActionPerformed(evt);
            }
        });
        Panelmenu.add(btnDataSuplesiJasaRaharja);

        btnDataSEPIndukKLLJasaRaharja.setForeground(new java.awt.Color(0, 0, 0));
        btnDataSEPIndukKLLJasaRaharja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/jasa_raharja.png"))); // NOI18N
        btnDataSEPIndukKLLJasaRaharja.setText("Data SEP Induk KLL Jasa Raharja VClaim");
        btnDataSEPIndukKLLJasaRaharja.setIconTextGap(0);
        btnDataSEPIndukKLLJasaRaharja.setName("btnDataSEPIndukKLLJasaRaharja"); // NOI18N
        btnDataSEPIndukKLLJasaRaharja.setPreferredSize(new java.awt.Dimension(200, 90));
        btnDataSEPIndukKLLJasaRaharja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataSEPIndukKLLJasaRaharjaActionPerformed(evt);
            }
        });
        Panelmenu.add(btnDataSEPIndukKLLJasaRaharja);

        btnCekReferensiPoliHFISBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnCekReferensiPoliHFISBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekReferensiPoliHFISBPJS.setText("Cek Referensi Poliklinik HFIS BPJS VClaim");
        btnCekReferensiPoliHFISBPJS.setIconTextGap(0);
        btnCekReferensiPoliHFISBPJS.setName("btnCekReferensiPoliHFISBPJS"); // NOI18N
        btnCekReferensiPoliHFISBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekReferensiPoliHFISBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekReferensiPoliHFISBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekReferensiPoliHFISBPJS);

        btnCekReferensiJadwalHFISBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnCekReferensiJadwalHFISBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekReferensiJadwalHFISBPJS.setText("Cek Referensi Jadwal HFIS BPJS VClaim");
        btnCekReferensiJadwalHFISBPJS.setIconTextGap(0);
        btnCekReferensiJadwalHFISBPJS.setName("btnCekReferensiJadwalHFISBPJS"); // NOI18N
        btnCekReferensiJadwalHFISBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekReferensiJadwalHFISBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekReferensiJadwalHFISBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekReferensiJadwalHFISBPJS);

        btnCekReferensiDokterHFISBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnCekReferensiDokterHFISBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/vclaim.png"))); // NOI18N
        btnCekReferensiDokterHFISBPJS.setText("Cek Referensi Dokter HFIS BPJS VClaim");
        btnCekReferensiDokterHFISBPJS.setIconTextGap(0);
        btnCekReferensiDokterHFISBPJS.setName("btnCekReferensiDokterHFISBPJS"); // NOI18N
        btnCekReferensiDokterHFISBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekReferensiDokterHFISBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekReferensiDokterHFISBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekReferensiDokterHFISBPJS);

        btnCekReferensiPendaftaranMobileJKNBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnCekReferensiPendaftaranMobileJKNBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/mobile1.png"))); // NOI18N
        btnCekReferensiPendaftaranMobileJKNBPJS.setText("Cek Referensi Pendaftaran Mobile JKN BPJS VClaim");
        btnCekReferensiPendaftaranMobileJKNBPJS.setIconTextGap(0);
        btnCekReferensiPendaftaranMobileJKNBPJS.setName("btnCekReferensiPendaftaranMobileJKNBPJS"); // NOI18N
        btnCekReferensiPendaftaranMobileJKNBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekReferensiPendaftaranMobileJKNBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekReferensiPendaftaranMobileJKNBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekReferensiPendaftaranMobileJKNBPJS);

        btnCekReferensiBatalDaftarMobileJKNBPJS.setForeground(new java.awt.Color(0, 0, 0));
        btnCekReferensiBatalDaftarMobileJKNBPJS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/mobile2.png"))); // NOI18N
        btnCekReferensiBatalDaftarMobileJKNBPJS.setText("Cek Batal Pendaftaran Mobile JKN BPJS VClaim");
        btnCekReferensiBatalDaftarMobileJKNBPJS.setIconTextGap(0);
        btnCekReferensiBatalDaftarMobileJKNBPJS.setName("btnCekReferensiBatalDaftarMobileJKNBPJS"); // NOI18N
        btnCekReferensiBatalDaftarMobileJKNBPJS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCekReferensiBatalDaftarMobileJKNBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekReferensiBatalDaftarMobileJKNBPJSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCekReferensiBatalDaftarMobileJKNBPJS);

        btnKemenkesSITB.setForeground(new java.awt.Color(0, 0, 0));
        btnKemenkesSITB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/kemenkes.png"))); // NOI18N
        btnKemenkesSITB.setText("Kemenkes Data SITB");
        btnKemenkesSITB.setIconTextGap(0);
        btnKemenkesSITB.setName("btnKemenkesSITB"); // NOI18N
        btnKemenkesSITB.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKemenkesSITB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKemenkesSITBActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKemenkesSITB);

        btnMasterDTD.setForeground(new java.awt.Color(0, 0, 0));
        btnMasterDTD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/icd_10.png"))); // NOI18N
        btnMasterDTD.setText("Daftar Tabulasi Diagnosa (DTD)");
        btnMasterDTD.setIconTextGap(0);
        btnMasterDTD.setName("btnMasterDTD"); // NOI18N
        btnMasterDTD.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMasterDTD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterDTDActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMasterDTD);

        btnAsesmenMedikObstetriRalan.setForeground(new java.awt.Color(0, 0, 0));
        btnAsesmenMedikObstetriRalan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/pregnant_woman.png"))); // NOI18N
        btnAsesmenMedikObstetriRalan.setText("Asesmen Medik Obstetri Ralan");
        btnAsesmenMedikObstetriRalan.setIconTextGap(0);
        btnAsesmenMedikObstetriRalan.setName("btnAsesmenMedikObstetriRalan"); // NOI18N
        btnAsesmenMedikObstetriRalan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnAsesmenMedikObstetriRalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsesmenMedikObstetriRalanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnAsesmenMedikObstetriRalan);

        btnPenilaianAwalKeperawatanKebidananRalan.setForeground(new java.awt.Color(0, 0, 0));
        btnPenilaianAwalKeperawatanKebidananRalan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/pregnant_woman.png"))); // NOI18N
        btnPenilaianAwalKeperawatanKebidananRalan.setText("Penilaian Awal Keperawatan Kebidanan Ralan");
        btnPenilaianAwalKeperawatanKebidananRalan.setIconTextGap(0);
        btnPenilaianAwalKeperawatanKebidananRalan.setName("btnPenilaianAwalKeperawatanKebidananRalan"); // NOI18N
        btnPenilaianAwalKeperawatanKebidananRalan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPenilaianAwalKeperawatanKebidananRalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenilaianAwalKeperawatanKebidananRalanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPenilaianAwalKeperawatanKebidananRalan);

        btnIkhtisarPerawatanHIV.setForeground(new java.awt.Color(0, 0, 0));
        btnIkhtisarPerawatanHIV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/hiv.png"))); // NOI18N
        btnIkhtisarPerawatanHIV.setText("Ikhtisar Perawatan HIV & Terapi ART");
        btnIkhtisarPerawatanHIV.setIconTextGap(0);
        btnIkhtisarPerawatanHIV.setName("btnIkhtisarPerawatanHIV"); // NOI18N
        btnIkhtisarPerawatanHIV.setPreferredSize(new java.awt.Dimension(200, 90));
        btnIkhtisarPerawatanHIV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIkhtisarPerawatanHIVActionPerformed(evt);
            }
        });
        Panelmenu.add(btnIkhtisarPerawatanHIV);

        btnKemenkesKanker.setForeground(new java.awt.Color(0, 0, 0));
        btnKemenkesKanker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/kemenkes.png"))); // NOI18N
        btnKemenkesKanker.setText("Kemenkes Data Penyakit Kanker");
        btnKemenkesKanker.setIconTextGap(0);
        btnKemenkesKanker.setName("btnKemenkesKanker"); // NOI18N
        btnKemenkesKanker.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKemenkesKanker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKemenkesKankerActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKemenkesKanker);

        btnSetingBridging.setForeground(new java.awt.Color(0, 0, 0));
        btnSetingBridging.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/icons8-settings-64.png"))); // NOI18N
        btnSetingBridging.setText("Set Bridging");
        btnSetingBridging.setIconTextGap(0);
        btnSetingBridging.setName("btnSetingBridging"); // NOI18N
        btnSetingBridging.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSetingBridging.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetingBridgingActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSetingBridging);

        btnPenilaianAwalMedisRalanTHT.setForeground(new java.awt.Color(0, 0, 0));
        btnPenilaianAwalMedisRalanTHT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/5868953_coronavirus_covid-19_nose_secretion_snot_icon.png"))); // NOI18N
        btnPenilaianAwalMedisRalanTHT.setText("Penilaian Awal Medis Rawat Jalan THT");
        btnPenilaianAwalMedisRalanTHT.setIconTextGap(0);
        btnPenilaianAwalMedisRalanTHT.setName("btnPenilaianAwalMedisRalanTHT"); // NOI18N
        btnPenilaianAwalMedisRalanTHT.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPenilaianAwalMedisRalanTHT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenilaianAwalMedisRalanTHTActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPenilaianAwalMedisRalanTHT);

        btnRekamPsikologisDewasa.setForeground(new java.awt.Color(0, 0, 0));
        btnRekamPsikologisDewasa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/psikologi.png"))); // NOI18N
        btnRekamPsikologisDewasa.setText("Rekam Psikologis Umum/Dewasa");
        btnRekamPsikologisDewasa.setIconTextGap(0);
        btnRekamPsikologisDewasa.setName("btnRekamPsikologisDewasa"); // NOI18N
        btnRekamPsikologisDewasa.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRekamPsikologisDewasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRekamPsikologisDewasaActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRekamPsikologisDewasa);

        btnMasterKeluhanPsikologis.setForeground(new java.awt.Color(0, 0, 0));
        btnMasterKeluhanPsikologis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/psikologi.png"))); // NOI18N
        btnMasterKeluhanPsikologis.setText("Master Keluhan Permasalahan Psikologis");
        btnMasterKeluhanPsikologis.setIconTextGap(0);
        btnMasterKeluhanPsikologis.setName("btnMasterKeluhanPsikologis"); // NOI18N
        btnMasterKeluhanPsikologis.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMasterKeluhanPsikologis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterKeluhanPsikologisActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMasterKeluhanPsikologis);

        btnMasterRencanaTritmenPsikologis.setForeground(new java.awt.Color(0, 0, 0));
        btnMasterRencanaTritmenPsikologis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/psikologi.png"))); // NOI18N
        btnMasterRencanaTritmenPsikologis.setText("Master Rencana Tritmen Psikologis");
        btnMasterRencanaTritmenPsikologis.setIconTextGap(0);
        btnMasterRencanaTritmenPsikologis.setName("btnMasterRencanaTritmenPsikologis"); // NOI18N
        btnMasterRencanaTritmenPsikologis.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMasterRencanaTritmenPsikologis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterRencanaTritmenPsikologisActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMasterRencanaTritmenPsikologis);

        btnDataJabatan.setForeground(new java.awt.Color(0, 0, 0));
        btnDataJabatan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/user3.png"))); // NOI18N
        btnDataJabatan.setText("Data Jabatan");
        btnDataJabatan.setIconTextGap(0);
        btnDataJabatan.setName("btnDataJabatan"); // NOI18N
        btnDataJabatan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnDataJabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataJabatanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnDataJabatan);

        btnMasterJabatanKomite.setForeground(new java.awt.Color(0, 0, 0));
        btnMasterJabatanKomite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/users.png"))); // NOI18N
        btnMasterJabatanKomite.setText("Master Jabatan Komite");
        btnMasterJabatanKomite.setIconTextGap(0);
        btnMasterJabatanKomite.setName("btnMasterJabatanKomite"); // NOI18N
        btnMasterJabatanKomite.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMasterJabatanKomite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterJabatanKomiteActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMasterJabatanKomite);

        btnRekamPsikologisAnak.setForeground(new java.awt.Color(0, 0, 0));
        btnRekamPsikologisAnak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/psikologi.png"))); // NOI18N
        btnRekamPsikologisAnak.setText("Rekam Psikologis Anak/Remaja");
        btnRekamPsikologisAnak.setIconTextGap(0);
        btnRekamPsikologisAnak.setName("btnRekamPsikologisAnak"); // NOI18N
        btnRekamPsikologisAnak.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRekamPsikologisAnak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRekamPsikologisAnakActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRekamPsikologisAnak);

        btnRekamPsikologiPerkawinan.setForeground(new java.awt.Color(0, 0, 0));
        btnRekamPsikologiPerkawinan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/psikologi.png"))); // NOI18N
        btnRekamPsikologiPerkawinan.setText("Rekam Psikologi Perkawinan");
        btnRekamPsikologiPerkawinan.setIconTextGap(0);
        btnRekamPsikologiPerkawinan.setName("btnRekamPsikologiPerkawinan"); // NOI18N
        btnRekamPsikologiPerkawinan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnRekamPsikologiPerkawinan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRekamPsikologiPerkawinanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnRekamPsikologiPerkawinan);

        btnMasterAturanPakai.setForeground(new java.awt.Color(0, 0, 0));
        btnMasterAturanPakai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360485030_receipt.png"))); // NOI18N
        btnMasterAturanPakai.setText("Master Aturan Pakai");
        btnMasterAturanPakai.setIconTextGap(0);
        btnMasterAturanPakai.setName("btnMasterAturanPakai"); // NOI18N
        btnMasterAturanPakai.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMasterAturanPakai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterAturanPakaiActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMasterAturanPakai);

        btnMasterKasusPersalinanDinkes.setForeground(new java.awt.Color(0, 0, 0));
        btnMasterKasusPersalinanDinkes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/kab_banjar.png"))); // NOI18N
        btnMasterKasusPersalinanDinkes.setText("Master Kasus Persalinan (DINKES)");
        btnMasterKasusPersalinanDinkes.setIconTextGap(0);
        btnMasterKasusPersalinanDinkes.setName("btnMasterKasusPersalinanDinkes"); // NOI18N
        btnMasterKasusPersalinanDinkes.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMasterKasusPersalinanDinkes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterKasusPersalinanDinkesActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMasterKasusPersalinanDinkes);

        btnKasusPersalinanDinkes.setForeground(new java.awt.Color(0, 0, 0));
        btnKasusPersalinanDinkes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/kab_banjar.png"))); // NOI18N
        btnKasusPersalinanDinkes.setText("Data Kasus Persalinan (DINKES)");
        btnKasusPersalinanDinkes.setIconTextGap(0);
        btnKasusPersalinanDinkes.setName("btnKasusPersalinanDinkes"); // NOI18N
        btnKasusPersalinanDinkes.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKasusPersalinanDinkes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKasusPersalinanDinkesActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKasusPersalinanDinkes);

        btnPenilaianTambahanGeriatri.setForeground(new java.awt.Color(0, 0, 0));
        btnPenilaianTambahanGeriatri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/6141440_boy_man_old_people_elderly and kid_icon.png"))); // NOI18N
        btnPenilaianTambahanGeriatri.setText("Penilaian Tambahan Pasien Geriatri");
        btnPenilaianTambahanGeriatri.setIconTextGap(0);
        btnPenilaianTambahanGeriatri.setName("btnPenilaianTambahanGeriatri"); // NOI18N
        btnPenilaianTambahanGeriatri.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPenilaianTambahanGeriatri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenilaianTambahanGeriatriActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPenilaianTambahanGeriatri);

        btnPenilaianAwalMedisRalanGeriatri.setForeground(new java.awt.Color(0, 0, 0));
        btnPenilaianAwalMedisRalanGeriatri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/5964799_ill_old man_patient_sick_sore throat_icon.png"))); // NOI18N
        btnPenilaianAwalMedisRalanGeriatri.setText("Awal Medis Ralan Geriatri");
        btnPenilaianAwalMedisRalanGeriatri.setIconTextGap(0);
        btnPenilaianAwalMedisRalanGeriatri.setName("btnPenilaianAwalMedisRalanGeriatri"); // NOI18N
        btnPenilaianAwalMedisRalanGeriatri.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPenilaianAwalMedisRalanGeriatri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenilaianAwalMedisRalanGeriatriActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPenilaianAwalMedisRalanGeriatri);

        btnMasterFaktorResikoJatuh.setForeground(new java.awt.Color(0, 0, 0));
        btnMasterFaktorResikoJatuh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/if_address-book_285679.png"))); // NOI18N
        btnMasterFaktorResikoJatuh.setText("Master Faktor Resiko Jatuh");
        btnMasterFaktorResikoJatuh.setIconTextGap(0);
        btnMasterFaktorResikoJatuh.setName("btnMasterFaktorResikoJatuh"); // NOI18N
        btnMasterFaktorResikoJatuh.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMasterFaktorResikoJatuh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterFaktorResikoJatuhActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMasterFaktorResikoJatuh);

        btnAssesmenKeperawatanIGD.setForeground(new java.awt.Color(0, 0, 0));
        btnAssesmenKeperawatanIGD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/iconfinder_AMBULANCE-transport-health_care-transportation-urgency_6007988.png"))); // NOI18N
        btnAssesmenKeperawatanIGD.setText("Assesmen Keperawatan IGD");
        btnAssesmenKeperawatanIGD.setIconTextGap(0);
        btnAssesmenKeperawatanIGD.setName("btnAssesmenKeperawatanIGD"); // NOI18N
        btnAssesmenKeperawatanIGD.setPreferredSize(new java.awt.Dimension(200, 90));
        btnAssesmenKeperawatanIGD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssesmenKeperawatanIGDActionPerformed(evt);
            }
        });
        Panelmenu.add(btnAssesmenKeperawatanIGD);

        btnAssesmenMedikIGD.setForeground(new java.awt.Color(0, 0, 0));
        btnAssesmenMedikIGD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/iconfinder_AMBULANCE-transport-health_care-transportation-urgency_6007988.png"))); // NOI18N
        btnAssesmenMedikIGD.setText("Assesmen Medik IGD");
        btnAssesmenMedikIGD.setIconTextGap(0);
        btnAssesmenMedikIGD.setName("btnAssesmenMedikIGD"); // NOI18N
        btnAssesmenMedikIGD.setPreferredSize(new java.awt.Dimension(200, 90));
        btnAssesmenMedikIGD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssesmenMedikIGDActionPerformed(evt);
            }
        });
        Panelmenu.add(btnAssesmenMedikIGD);

        btnPenilaianAwalMedisRalanMata.setForeground(new java.awt.Color(0, 0, 0));
        btnPenilaianAwalMedisRalanMata.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1459441_eye_holidays_anatomy_halloween_icon.png"))); // NOI18N
        btnPenilaianAwalMedisRalanMata.setText("Awal Medis Ralan Mata");
        btnPenilaianAwalMedisRalanMata.setIconTextGap(0);
        btnPenilaianAwalMedisRalanMata.setName("btnPenilaianAwalMedisRalanMata"); // NOI18N
        btnPenilaianAwalMedisRalanMata.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPenilaianAwalMedisRalanMata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenilaianAwalMedisRalanMataActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPenilaianAwalMedisRalanMata);

        btnSuratIstirahatSakit.setForeground(new java.awt.Color(0, 0, 0));
        btnSuratIstirahatSakit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/kwrite.png"))); // NOI18N
        btnSuratIstirahatSakit.setText("Surat Istirahat Sakit");
        btnSuratIstirahatSakit.setIconTextGap(0);
        btnSuratIstirahatSakit.setName("btnSuratIstirahatSakit"); // NOI18N
        btnSuratIstirahatSakit.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSuratIstirahatSakit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuratIstirahatSakitActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSuratIstirahatSakit);

        btnSuratKeteranganSakit.setForeground(new java.awt.Color(0, 0, 0));
        btnSuratKeteranganSakit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/iconfinder_TextEdit_37595.png"))); // NOI18N
        btnSuratKeteranganSakit.setText("Surat Keterangan Sakit");
        btnSuratKeteranganSakit.setIconTextGap(0);
        btnSuratKeteranganSakit.setName("btnSuratKeteranganSakit"); // NOI18N
        btnSuratKeteranganSakit.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSuratKeteranganSakit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuratKeteranganSakitActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSuratKeteranganSakit);

        btnTransferSerahTerimaPasien.setForeground(new java.awt.Color(0, 0, 0));
        btnTransferSerahTerimaPasien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360816189_arrow_down.png"))); // NOI18N
        btnTransferSerahTerimaPasien.setText("Transfer & Serah Terima Pasien");
        btnTransferSerahTerimaPasien.setIconTextGap(0);
        btnTransferSerahTerimaPasien.setName("btnTransferSerahTerimaPasien"); // NOI18N
        btnTransferSerahTerimaPasien.setPreferredSize(new java.awt.Dimension(200, 90));
        btnTransferSerahTerimaPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferSerahTerimaPasienActionPerformed(evt);
            }
        });
        Panelmenu.add(btnTransferSerahTerimaPasien);

        btnSuratKeteranganNAPZA.setForeground(new java.awt.Color(0, 0, 0));
        btnSuratKeteranganNAPZA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360816018_tests.png"))); // NOI18N
        btnSuratKeteranganNAPZA.setText("Surat Keterangan NAPZA");
        btnSuratKeteranganNAPZA.setIconTextGap(0);
        btnSuratKeteranganNAPZA.setName("btnSuratKeteranganNAPZA"); // NOI18N
        btnSuratKeteranganNAPZA.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSuratKeteranganNAPZA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuratKeteranganNAPZAActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSuratKeteranganNAPZA);

        btnSuratKeteranganRohani.setForeground(new java.awt.Color(0, 0, 0));
        btnSuratKeteranganRohani.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/if_todo_list_add_17451.png"))); // NOI18N
        btnSuratKeteranganRohani.setText("Surat Keterangan Kes. Rohani");
        btnSuratKeteranganRohani.setIconTextGap(0);
        btnSuratKeteranganRohani.setName("btnSuratKeteranganRohani"); // NOI18N
        btnSuratKeteranganRohani.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSuratKeteranganRohani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuratKeteranganRohaniActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSuratKeteranganRohani);

        btnSuratKeteranganDokter.setForeground(new java.awt.Color(0, 0, 0));
        btnSuratKeteranganDokter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/if_order-history_49596.png"))); // NOI18N
        btnSuratKeteranganDokter.setText("Surat Keterangan Dokter");
        btnSuratKeteranganDokter.setIconTextGap(0);
        btnSuratKeteranganDokter.setName("btnSuratKeteranganDokter"); // NOI18N
        btnSuratKeteranganDokter.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSuratKeteranganDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuratKeteranganDokterActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSuratKeteranganDokter);

        btnAsesmenMedikDewasaRanap.setForeground(new java.awt.Color(0, 0, 0));
        btnAsesmenMedikDewasaRanap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/mp_viewer.png"))); // NOI18N
        btnAsesmenMedikDewasaRanap.setText("Asesmen Medik Dewasa Rawat Inap");
        btnAsesmenMedikDewasaRanap.setIconTextGap(0);
        btnAsesmenMedikDewasaRanap.setName("btnAsesmenMedikDewasaRanap"); // NOI18N
        btnAsesmenMedikDewasaRanap.setPreferredSize(new java.awt.Dimension(200, 90));
        btnAsesmenMedikDewasaRanap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsesmenMedikDewasaRanapActionPerformed(evt);
            }
        });
        Panelmenu.add(btnAsesmenMedikDewasaRanap);

        btnPemberianObat.setForeground(new java.awt.Color(0, 0, 0));
        btnPemberianObat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1481001686_injection_blood.png"))); // NOI18N
        btnPemberianObat.setText("Pemberian Obat Pasien");
        btnPemberianObat.setIconTextGap(0);
        btnPemberianObat.setName("btnPemberianObat"); // NOI18N
        btnPemberianObat.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPemberianObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPemberianObatActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPemberianObat);

        btnCPPT.setForeground(new java.awt.Color(0, 0, 0));
        btnCPPT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360486822_20.png"))); // NOI18N
        btnCPPT.setText("CPPT");
        btnCPPT.setIconTextGap(0);
        btnCPPT.setName("btnCPPT"); // NOI18N
        btnCPPT.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCPPT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCPPTActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCPPT);

        btnSpirometri.setForeground(new java.awt.Color(0, 0, 0));
        btnSpirometri.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/spirometry.png"))); // NOI18N
        btnSpirometri.setText("Spirometri");
        btnSpirometri.setIconTextGap(0);
        btnSpirometri.setName("btnSpirometri"); // NOI18N
        btnSpirometri.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSpirometri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpirometriActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSpirometri);

        btnAsesmenKebidananRalan.setForeground(new java.awt.Color(0, 0, 0));
        btnAsesmenKebidananRalan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/pregnant_woman.png"))); // NOI18N
        btnAsesmenKebidananRalan.setText("Asesmen Kebidanan Rawat Jalan");
        btnAsesmenKebidananRalan.setIconTextGap(0);
        btnAsesmenKebidananRalan.setName("btnAsesmenKebidananRalan"); // NOI18N
        btnAsesmenKebidananRalan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnAsesmenKebidananRalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsesmenKebidananRalanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnAsesmenKebidananRalan);

        btnDashboardeResepRanap.setForeground(new java.awt.Color(0, 0, 0));
        btnDashboardeResepRanap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/monitor_hijau.png"))); // NOI18N
        btnDashboardeResepRanap.setText("Dashboard e-Resep Rawat Inap");
        btnDashboardeResepRanap.setIconTextGap(0);
        btnDashboardeResepRanap.setName("btnDashboardeResepRanap"); // NOI18N
        btnDashboardeResepRanap.setPreferredSize(new java.awt.Dimension(200, 90));
        btnDashboardeResepRanap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDashboardeResepRanapActionPerformed(evt);
            }
        });
        Panelmenu.add(btnDashboardeResepRanap);

        btnJadwalOperasi.setForeground(new java.awt.Color(0, 0, 0));
        btnJadwalOperasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Edit-Male-User.png"))); // NOI18N
        btnJadwalOperasi.setText("Jadwal Operasi");
        btnJadwalOperasi.setIconTextGap(0);
        btnJadwalOperasi.setName("btnJadwalOperasi"); // NOI18N
        btnJadwalOperasi.setPreferredSize(new java.awt.Dimension(200, 90));
        btnJadwalOperasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJadwalOperasiActionPerformed(evt);
            }
        });
        Panelmenu.add(btnJadwalOperasi);

        btnBangsal.setForeground(new java.awt.Color(0, 0, 0));
        btnBangsal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/Home.png"))); // NOI18N
        btnBangsal.setText("Bangsal Rawat Inap");
        btnBangsal.setIconTextGap(0);
        btnBangsal.setName("btnBangsal"); // NOI18N
        btnBangsal.setPreferredSize(new java.awt.Dimension(200, 90));
        btnBangsal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBangsalActionPerformed(evt);
            }
        });
        Panelmenu.add(btnBangsal);

        btnPersetujuanTindakan.setForeground(new java.awt.Color(0, 0, 0));
        btnPersetujuanTindakan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/iconfinder_basket_8726.png"))); // NOI18N
        btnPersetujuanTindakan.setText("Persetujuan/Penolakan Tindakan");
        btnPersetujuanTindakan.setIconTextGap(0);
        btnPersetujuanTindakan.setName("btnPersetujuanTindakan"); // NOI18N
        btnPersetujuanTindakan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPersetujuanTindakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersetujuanTindakanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPersetujuanTindakan);

        btnPetugasPelaksanaPemberianObat.setForeground(new java.awt.Color(0, 0, 0));
        btnPetugasPelaksanaPemberianObat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/surgeon.png"))); // NOI18N
        btnPetugasPelaksanaPemberianObat.setText("Petugas Pelaksana Pemberian Obat");
        btnPetugasPelaksanaPemberianObat.setIconTextGap(0);
        btnPetugasPelaksanaPemberianObat.setName("btnPetugasPelaksanaPemberianObat"); // NOI18N
        btnPetugasPelaksanaPemberianObat.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPetugasPelaksanaPemberianObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPetugasPelaksanaPemberianObatActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPetugasPelaksanaPemberianObat);

        btnCatatanTindakanKeperawatan.setForeground(new java.awt.Color(0, 0, 0));
        btnCatatanTindakanKeperawatan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/checklist_pencil-o.png"))); // NOI18N
        btnCatatanTindakanKeperawatan.setText("Catatan Tindakan Keperawatan");
        btnCatatanTindakanKeperawatan.setIconTextGap(0);
        btnCatatanTindakanKeperawatan.setName("btnCatatanTindakanKeperawatan"); // NOI18N
        btnCatatanTindakanKeperawatan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCatatanTindakanKeperawatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatatanTindakanKeperawatanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCatatanTindakanKeperawatan);

        btnSuratKonsulUnitRanap.setForeground(new java.awt.Color(0, 0, 0));
        btnSuratKonsulUnitRanap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/email_open.png"))); // NOI18N
        btnSuratKonsulUnitRanap.setText("Surat Konsul Antar Unit Ranap");
        btnSuratKonsulUnitRanap.setIconTextGap(0);
        btnSuratKonsulUnitRanap.setName("btnSuratKonsulUnitRanap"); // NOI18N
        btnSuratKonsulUnitRanap.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSuratKonsulUnitRanap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuratKonsulUnitRanapActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSuratKonsulUnitRanap);

        btnSuratJawabanKonsulRanap.setForeground(new java.awt.Color(0, 0, 0));
        btnSuratJawabanKonsulRanap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/kwrite.png"))); // NOI18N
        btnSuratJawabanKonsulRanap.setText("Surat Jawaban Konsul Unit");
        btnSuratJawabanKonsulRanap.setIconTextGap(0);
        btnSuratJawabanKonsulRanap.setName("btnSuratJawabanKonsulRanap"); // NOI18N
        btnSuratJawabanKonsulRanap.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSuratJawabanKonsulRanap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuratJawabanKonsulRanapActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSuratJawabanKonsulRanap);

        btnMasterResikoDecubitus.setForeground(new java.awt.Color(0, 0, 0));
        btnMasterResikoDecubitus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/decubitus_matters.png"))); // NOI18N
        btnMasterResikoDecubitus.setText("Master Data Resiko Decubitus");
        btnMasterResikoDecubitus.setIconTextGap(0);
        btnMasterResikoDecubitus.setName("btnMasterResikoDecubitus"); // NOI18N
        btnMasterResikoDecubitus.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMasterResikoDecubitus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterResikoDecubitusActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMasterResikoDecubitus);

        btnAsesmenKeperawatanDewasa.setForeground(new java.awt.Color(0, 0, 0));
        btnAsesmenKeperawatanDewasa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/iconfinder_30-Doctor_5929214.png"))); // NOI18N
        btnAsesmenKeperawatanDewasa.setText("Asesmen Keperawatan Dewasa Ranap");
        btnAsesmenKeperawatanDewasa.setIconTextGap(0);
        btnAsesmenKeperawatanDewasa.setName("btnAsesmenKeperawatanDewasa"); // NOI18N
        btnAsesmenKeperawatanDewasa.setPreferredSize(new java.awt.Dimension(200, 90));
        btnAsesmenKeperawatanDewasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsesmenKeperawatanDewasaActionPerformed(evt);
            }
        });
        Panelmenu.add(btnAsesmenKeperawatanDewasa);

        btnReferensiDokterSatuSehat.setForeground(new java.awt.Color(0, 0, 0));
        btnReferensiDokterSatuSehat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/satusehat.png"))); // NOI18N
        btnReferensiDokterSatuSehat.setText("Referensi Praktisi Satu Sehat");
        btnReferensiDokterSatuSehat.setIconTextGap(0);
        btnReferensiDokterSatuSehat.setName("btnReferensiDokterSatuSehat"); // NOI18N
        btnReferensiDokterSatuSehat.setPreferredSize(new java.awt.Dimension(200, 90));
        btnReferensiDokterSatuSehat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReferensiDokterSatuSehatActionPerformed(evt);
            }
        });
        Panelmenu.add(btnReferensiDokterSatuSehat);

        btnReferensiPasienSatuSehat.setForeground(new java.awt.Color(0, 0, 0));
        btnReferensiPasienSatuSehat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/satusehat.png"))); // NOI18N
        btnReferensiPasienSatuSehat.setText("Referensi Pasien Satu Sehat");
        btnReferensiPasienSatuSehat.setIconTextGap(0);
        btnReferensiPasienSatuSehat.setName("btnReferensiPasienSatuSehat"); // NOI18N
        btnReferensiPasienSatuSehat.setPreferredSize(new java.awt.Dimension(200, 90));
        btnReferensiPasienSatuSehat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReferensiPasienSatuSehatActionPerformed(evt);
            }
        });
        Panelmenu.add(btnReferensiPasienSatuSehat);

        btnMapingOrganisasiSatuSehat.setForeground(new java.awt.Color(0, 0, 0));
        btnMapingOrganisasiSatuSehat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/satusehat.png"))); // NOI18N
        btnMapingOrganisasiSatuSehat.setText("Mapping Organisasi Satu Sehat");
        btnMapingOrganisasiSatuSehat.setIconTextGap(0);
        btnMapingOrganisasiSatuSehat.setName("btnMapingOrganisasiSatuSehat"); // NOI18N
        btnMapingOrganisasiSatuSehat.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMapingOrganisasiSatuSehat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMapingOrganisasiSatuSehatActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMapingOrganisasiSatuSehat);

        btnMapingLokasiSatuSehat.setForeground(new java.awt.Color(0, 0, 0));
        btnMapingLokasiSatuSehat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/satusehat.png"))); // NOI18N
        btnMapingLokasiSatuSehat.setText("Mapping Lokasi Satu Sehat");
        btnMapingLokasiSatuSehat.setIconTextGap(0);
        btnMapingLokasiSatuSehat.setName("btnMapingLokasiSatuSehat"); // NOI18N
        btnMapingLokasiSatuSehat.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMapingLokasiSatuSehat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMapingLokasiSatuSehatActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMapingLokasiSatuSehat);

        btnMapingVaksinSatuSehat.setForeground(new java.awt.Color(0, 0, 0));
        btnMapingVaksinSatuSehat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/satusehat.png"))); // NOI18N
        btnMapingVaksinSatuSehat.setText("Mapping Vaksin Satu Sehat");
        btnMapingVaksinSatuSehat.setIconTextGap(0);
        btnMapingVaksinSatuSehat.setName("btnMapingVaksinSatuSehat"); // NOI18N
        btnMapingVaksinSatuSehat.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMapingVaksinSatuSehat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMapingVaksinSatuSehatActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMapingVaksinSatuSehat);

        btnKirimEncounterSatuSehat.setForeground(new java.awt.Color(0, 0, 0));
        btnKirimEncounterSatuSehat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/satusehat.png"))); // NOI18N
        btnKirimEncounterSatuSehat.setText("Kirim Encounter Satu Sehat");
        btnKirimEncounterSatuSehat.setIconTextGap(0);
        btnKirimEncounterSatuSehat.setName("btnKirimEncounterSatuSehat"); // NOI18N
        btnKirimEncounterSatuSehat.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKirimEncounterSatuSehat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKirimEncounterSatuSehatActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKirimEncounterSatuSehat);

        btnKirimConditionSatuSehat.setForeground(new java.awt.Color(0, 0, 0));
        btnKirimConditionSatuSehat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/satusehat.png"))); // NOI18N
        btnKirimConditionSatuSehat.setText("Kirim Condition (ICD-10) Satu Sehat");
        btnKirimConditionSatuSehat.setIconTextGap(0);
        btnKirimConditionSatuSehat.setName("btnKirimConditionSatuSehat"); // NOI18N
        btnKirimConditionSatuSehat.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKirimConditionSatuSehat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKirimConditionSatuSehatActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKirimConditionSatuSehat);

        btnKirimObservationSatuSehat.setForeground(new java.awt.Color(0, 0, 0));
        btnKirimObservationSatuSehat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/satusehat.png"))); // NOI18N
        btnKirimObservationSatuSehat.setText("Kirim Observation-TTV Satu Sehat");
        btnKirimObservationSatuSehat.setIconTextGap(0);
        btnKirimObservationSatuSehat.setName("btnKirimObservationSatuSehat"); // NOI18N
        btnKirimObservationSatuSehat.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKirimObservationSatuSehat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKirimObservationSatuSehatActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKirimObservationSatuSehat);

        btnKirimProsedurSatuSehat.setForeground(new java.awt.Color(0, 0, 0));
        btnKirimProsedurSatuSehat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/satusehat.png"))); // NOI18N
        btnKirimProsedurSatuSehat.setText("Kirim Prosedure (ICD-9) Satu Sehat");
        btnKirimProsedurSatuSehat.setIconTextGap(0);
        btnKirimProsedurSatuSehat.setName("btnKirimProsedurSatuSehat"); // NOI18N
        btnKirimProsedurSatuSehat.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKirimProsedurSatuSehat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKirimProsedurSatuSehatActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKirimProsedurSatuSehat);

        btnKirimImunisasiSatuSehat.setForeground(new java.awt.Color(0, 0, 0));
        btnKirimImunisasiSatuSehat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/satusehat.png"))); // NOI18N
        btnKirimImunisasiSatuSehat.setText("Kirim Imunisasi Satu Sehat");
        btnKirimImunisasiSatuSehat.setIconTextGap(0);
        btnKirimImunisasiSatuSehat.setName("btnKirimImunisasiSatuSehat"); // NOI18N
        btnKirimImunisasiSatuSehat.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKirimImunisasiSatuSehat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKirimImunisasiSatuSehatActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKirimImunisasiSatuSehat);

        btnKirimClinicalSatuSehat.setForeground(new java.awt.Color(0, 0, 0));
        btnKirimClinicalSatuSehat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/satusehat.png"))); // NOI18N
        btnKirimClinicalSatuSehat.setText("Kirim Clinical Impression Satu Sehat");
        btnKirimClinicalSatuSehat.setIconTextGap(0);
        btnKirimClinicalSatuSehat.setName("btnKirimClinicalSatuSehat"); // NOI18N
        btnKirimClinicalSatuSehat.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKirimClinicalSatuSehat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKirimClinicalSatuSehatActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKirimClinicalSatuSehat);

        btnKirimDietSatuSehat.setForeground(new java.awt.Color(0, 0, 0));
        btnKirimDietSatuSehat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/satusehat.png"))); // NOI18N
        btnKirimDietSatuSehat.setText("Kirim Diet Satu Sehat");
        btnKirimDietSatuSehat.setIconTextGap(0);
        btnKirimDietSatuSehat.setName("btnKirimDietSatuSehat"); // NOI18N
        btnKirimDietSatuSehat.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKirimDietSatuSehat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKirimDietSatuSehatActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKirimDietSatuSehat);

        btnMapingObatSatuSehat.setForeground(new java.awt.Color(0, 0, 0));
        btnMapingObatSatuSehat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/satusehat.png"))); // NOI18N
        btnMapingObatSatuSehat.setText("Mapping Obat/Alkes Satu Sehat");
        btnMapingObatSatuSehat.setIconTextGap(0);
        btnMapingObatSatuSehat.setName("btnMapingObatSatuSehat"); // NOI18N
        btnMapingObatSatuSehat.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMapingObatSatuSehat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMapingObatSatuSehatActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMapingObatSatuSehat);

        btnPemantauanHarian24Jam.setForeground(new java.awt.Color(0, 0, 0));
        btnPemantauanHarian24Jam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360486822_20.png"))); // NOI18N
        btnPemantauanHarian24Jam.setText("Pemantauan Harian Pasien 24 Jam");
        btnPemantauanHarian24Jam.setIconTextGap(0);
        btnPemantauanHarian24Jam.setName("btnPemantauanHarian24Jam"); // NOI18N
        btnPemantauanHarian24Jam.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPemantauanHarian24Jam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPemantauanHarian24JamActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPemantauanHarian24Jam);

        btnKirimMedicationRequestSatuSehat.setForeground(new java.awt.Color(0, 0, 0));
        btnKirimMedicationRequestSatuSehat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/satusehat.png"))); // NOI18N
        btnKirimMedicationRequestSatuSehat.setText("Kirim Medication Request Satu Sehat");
        btnKirimMedicationRequestSatuSehat.setIconTextGap(0);
        btnKirimMedicationRequestSatuSehat.setName("btnKirimMedicationRequestSatuSehat"); // NOI18N
        btnKirimMedicationRequestSatuSehat.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKirimMedicationRequestSatuSehat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKirimMedicationRequestSatuSehatActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKirimMedicationRequestSatuSehat);

        btnKirimMedicationDispenseSatuSehat.setForeground(new java.awt.Color(0, 0, 0));
        btnKirimMedicationDispenseSatuSehat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/satusehat.png"))); // NOI18N
        btnKirimMedicationDispenseSatuSehat.setText("Kirim Medication Dispense Satu Sehat");
        btnKirimMedicationDispenseSatuSehat.setIconTextGap(0);
        btnKirimMedicationDispenseSatuSehat.setName("btnKirimMedicationDispenseSatuSehat"); // NOI18N
        btnKirimMedicationDispenseSatuSehat.setPreferredSize(new java.awt.Dimension(200, 90));
        btnKirimMedicationDispenseSatuSehat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKirimMedicationDispenseSatuSehatActionPerformed(evt);
            }
        });
        Panelmenu.add(btnKirimMedicationDispenseSatuSehat);

        btnNotepad.setForeground(new java.awt.Color(0, 0, 0));
        btnNotepad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360485642_edit-notes.png"))); // NOI18N
        btnNotepad.setText("Notepad SIMRS");
        btnNotepad.setIconTextGap(0);
        btnNotepad.setName("btnNotepad"); // NOI18N
        btnNotepad.setPreferredSize(new java.awt.Dimension(200, 90));
        btnNotepad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotepadActionPerformed(evt);
            }
        });
        Panelmenu.add(btnNotepad);

        btnProtokolKemoterapi.setForeground(new java.awt.Color(0, 0, 0));
        btnProtokolKemoterapi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/iconfinder_30-Doctor_5929214.png"))); // NOI18N
        btnProtokolKemoterapi.setText("Protokol Kemoterapi");
        btnProtokolKemoterapi.setIconTextGap(0);
        btnProtokolKemoterapi.setName("btnProtokolKemoterapi"); // NOI18N
        btnProtokolKemoterapi.setPreferredSize(new java.awt.Dimension(200, 90));
        btnProtokolKemoterapi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProtokolKemoterapiActionPerformed(evt);
            }
        });
        Panelmenu.add(btnProtokolKemoterapi);

        btnAsesmenUlangResikoJatuhDewasa.setForeground(new java.awt.Color(0, 0, 0));
        btnAsesmenUlangResikoJatuhDewasa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/patient (1).png"))); // NOI18N
        btnAsesmenUlangResikoJatuhDewasa.setText("Ases. Ulang Resiko Jatuh Dewasa");
        btnAsesmenUlangResikoJatuhDewasa.setIconTextGap(0);
        btnAsesmenUlangResikoJatuhDewasa.setName("btnAsesmenUlangResikoJatuhDewasa"); // NOI18N
        btnAsesmenUlangResikoJatuhDewasa.setPreferredSize(new java.awt.Dimension(200, 90));
        btnAsesmenUlangResikoJatuhDewasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsesmenUlangResikoJatuhDewasaActionPerformed(evt);
            }
        });
        Panelmenu.add(btnAsesmenUlangResikoJatuhDewasa);

        btnPengelolaanTransfusiDarah.setForeground(new java.awt.Color(0, 0, 0));
        btnPengelolaanTransfusiDarah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1481001585_blood_drop.png"))); // NOI18N
        btnPengelolaanTransfusiDarah.setText("Pengelolaan Transfusi Darah");
        btnPengelolaanTransfusiDarah.setIconTextGap(0);
        btnPengelolaanTransfusiDarah.setName("btnPengelolaanTransfusiDarah"); // NOI18N
        btnPengelolaanTransfusiDarah.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPengelolaanTransfusiDarah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPengelolaanTransfusiDarahActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPengelolaanTransfusiDarah);

        btnMonitoringEWSDewasa.setForeground(new java.awt.Color(0, 0, 0));
        btnMonitoringEWSDewasa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/iconfinder_dialog-warning_118940.png"))); // NOI18N
        btnMonitoringEWSDewasa.setText("Monitoring EWS Dewasa");
        btnMonitoringEWSDewasa.setIconTextGap(0);
        btnMonitoringEWSDewasa.setName("btnMonitoringEWSDewasa"); // NOI18N
        btnMonitoringEWSDewasa.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMonitoringEWSDewasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonitoringEWSDewasaActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMonitoringEWSDewasa);

        btnMasterNomorDokumen.setForeground(new java.awt.Color(0, 0, 0));
        btnMasterNomorDokumen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/if_book_285636.png"))); // NOI18N
        btnMasterNomorDokumen.setText("Master Nomor Dokumen");
        btnMasterNomorDokumen.setIconTextGap(0);
        btnMasterNomorDokumen.setName("btnMasterNomorDokumen"); // NOI18N
        btnMasterNomorDokumen.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMasterNomorDokumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterNomorDokumenActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMasterNomorDokumen);

        btnAsesmenKeperawatanAnak.setForeground(new java.awt.Color(0, 0, 0));
        btnAsesmenKeperawatanAnak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/iconfinder_30-Doctor_5929214.png"))); // NOI18N
        btnAsesmenKeperawatanAnak.setText("Asesmen Keperawatan Anak Ranap");
        btnAsesmenKeperawatanAnak.setIconTextGap(0);
        btnAsesmenKeperawatanAnak.setName("btnAsesmenKeperawatanAnak"); // NOI18N
        btnAsesmenKeperawatanAnak.setPreferredSize(new java.awt.Dimension(200, 90));
        btnAsesmenKeperawatanAnak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsesmenKeperawatanAnakActionPerformed(evt);
            }
        });
        Panelmenu.add(btnAsesmenKeperawatanAnak);

        btnAsesmenMedikAnakRanap.setForeground(new java.awt.Color(0, 0, 0));
        btnAsesmenMedikAnakRanap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/mp_viewer.png"))); // NOI18N
        btnAsesmenMedikAnakRanap.setText("Asesmen Medik Anak Rawat Inap");
        btnAsesmenMedikAnakRanap.setIconTextGap(0);
        btnAsesmenMedikAnakRanap.setName("btnAsesmenMedikAnakRanap"); // NOI18N
        btnAsesmenMedikAnakRanap.setPreferredSize(new java.awt.Dimension(200, 90));
        btnAsesmenMedikAnakRanap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsesmenMedikAnakRanapActionPerformed(evt);
            }
        });
        Panelmenu.add(btnAsesmenMedikAnakRanap);

        btnMasterJenisDokumenJangMed.setForeground(new java.awt.Color(0, 0, 0));
        btnMasterJenisDokumenJangMed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/applications-office.png"))); // NOI18N
        btnMasterJenisDokumenJangMed.setText("Master Jenis Dokumen JangMed");
        btnMasterJenisDokumenJangMed.setIconTextGap(0);
        btnMasterJenisDokumenJangMed.setName("btnMasterJenisDokumenJangMed"); // NOI18N
        btnMasterJenisDokumenJangMed.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMasterJenisDokumenJangMed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterJenisDokumenJangMedActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMasterJenisDokumenJangMed);

        btnAsesmenUlangResikoJatuhAnak.setForeground(new java.awt.Color(0, 0, 0));
        btnAsesmenUlangResikoJatuhAnak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/patient (1).png"))); // NOI18N
        btnAsesmenUlangResikoJatuhAnak.setText("Ases. Ulang Resiko Jatuh Anak");
        btnAsesmenUlangResikoJatuhAnak.setIconTextGap(0);
        btnAsesmenUlangResikoJatuhAnak.setName("btnAsesmenUlangResikoJatuhAnak"); // NOI18N
        btnAsesmenUlangResikoJatuhAnak.setPreferredSize(new java.awt.Dimension(200, 90));
        btnAsesmenUlangResikoJatuhAnak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsesmenUlangResikoJatuhAnakActionPerformed(evt);
            }
        });
        Panelmenu.add(btnAsesmenUlangResikoJatuhAnak);

        btnMonitoringPediatricEWS.setForeground(new java.awt.Color(0, 0, 0));
        btnMonitoringPediatricEWS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/iconfinder_dialog-warning_118940.png"))); // NOI18N
        btnMonitoringPediatricEWS.setText("Monitoring Pediatric EWS");
        btnMonitoringPediatricEWS.setIconTextGap(0);
        btnMonitoringPediatricEWS.setName("btnMonitoringPediatricEWS"); // NOI18N
        btnMonitoringPediatricEWS.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMonitoringPediatricEWS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonitoringPediatricEWSActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMonitoringPediatricEWS);

        btnAsesmenRestrain.setForeground(new java.awt.Color(0, 0, 0));
        btnAsesmenRestrain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/mp_viewer.png"))); // NOI18N
        btnAsesmenRestrain.setText("Asesmen Restrain Rawat Inap");
        btnAsesmenRestrain.setIconTextGap(0);
        btnAsesmenRestrain.setName("btnAsesmenRestrain"); // NOI18N
        btnAsesmenRestrain.setPreferredSize(new java.awt.Dimension(200, 90));
        btnAsesmenRestrain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsesmenRestrainActionPerformed(evt);
            }
        });
        Panelmenu.add(btnAsesmenRestrain);

        btnMasterDiagnosaGizi.setForeground(new java.awt.Color(0, 0, 0));
        btnMasterDiagnosaGizi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1360815935_contacts.png"))); // NOI18N
        btnMasterDiagnosaGizi.setText("Master Diagnosa Gizi");
        btnMasterDiagnosaGizi.setIconTextGap(0);
        btnMasterDiagnosaGizi.setName("btnMasterDiagnosaGizi"); // NOI18N
        btnMasterDiagnosaGizi.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMasterDiagnosaGizi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterDiagnosaGiziActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMasterDiagnosaGizi);

        btnSkriningGiziUlang.setForeground(new java.awt.Color(0, 0, 0));
        btnSkriningGiziUlang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/if_order-history_49596.png"))); // NOI18N
        btnSkriningGiziUlang.setText("Skrining Gizi Ulang");
        btnSkriningGiziUlang.setIconTextGap(0);
        btnSkriningGiziUlang.setName("btnSkriningGiziUlang"); // NOI18N
        btnSkriningGiziUlang.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSkriningGiziUlang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkriningGiziUlangActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSkriningGiziUlang);

        btnLembarObservasi.setForeground(new java.awt.Color(0, 0, 0));
        btnLembarObservasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/checklist_pencil-o.png"))); // NOI18N
        btnLembarObservasi.setText("Lembar Observasi Pasien");
        btnLembarObservasi.setIconTextGap(0);
        btnLembarObservasi.setName("btnLembarObservasi"); // NOI18N
        btnLembarObservasi.setPreferredSize(new java.awt.Dimension(200, 90));
        btnLembarObservasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLembarObservasiActionPerformed(evt);
            }
        });
        Panelmenu.add(btnLembarObservasi);

        btnTransaksiPanjar.setForeground(new java.awt.Color(0, 0, 0));
        btnTransaksiPanjar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1404046811_money.png"))); // NOI18N
        btnTransaksiPanjar.setText("Transaksi Panjar Pasien");
        btnTransaksiPanjar.setIconTextGap(0);
        btnTransaksiPanjar.setName("btnTransaksiPanjar"); // NOI18N
        btnTransaksiPanjar.setPreferredSize(new java.awt.Dimension(200, 90));
        btnTransaksiPanjar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransaksiPanjarActionPerformed(evt);
            }
        });
        Panelmenu.add(btnTransaksiPanjar);

        btnTransferPasienTindakan.setForeground(new java.awt.Color(0, 0, 0));
        btnTransferPasienTindakan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1481002123_wheelchair.png"))); // NOI18N
        btnTransferPasienTindakan.setText("Transfer Pasien Untuk Tindakan");
        btnTransferPasienTindakan.setIconTextGap(0);
        btnTransferPasienTindakan.setName("btnTransferPasienTindakan"); // NOI18N
        btnTransferPasienTindakan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnTransferPasienTindakan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferPasienTindakanActionPerformed(evt);
            }
        });
        Panelmenu.add(btnTransferPasienTindakan);

        btnAsesmenPraSedasi.setForeground(new java.awt.Color(0, 0, 0));
        btnAsesmenPraSedasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/anastesi2.png"))); // NOI18N
        btnAsesmenPraSedasi.setText("Asesmen Pra Sedasi");
        btnAsesmenPraSedasi.setIconTextGap(0);
        btnAsesmenPraSedasi.setName("btnAsesmenPraSedasi"); // NOI18N
        btnAsesmenPraSedasi.setPreferredSize(new java.awt.Dimension(200, 90));
        btnAsesmenPraSedasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsesmenPraSedasiActionPerformed(evt);
            }
        });
        Panelmenu.add(btnAsesmenPraSedasi);

        btnMasterIndikatorNasionalMutu.setForeground(new java.awt.Color(0, 0, 0));
        btnMasterIndikatorNasionalMutu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/if_address-book_285679.png"))); // NOI18N
        btnMasterIndikatorNasionalMutu.setText("Master Indikator Mutu Nasional");
        btnMasterIndikatorNasionalMutu.setIconTextGap(0);
        btnMasterIndikatorNasionalMutu.setName("btnMasterIndikatorNasionalMutu"); // NOI18N
        btnMasterIndikatorNasionalMutu.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMasterIndikatorNasionalMutu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterIndikatorNasionalMutuActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMasterIndikatorNasionalMutu);

        btnIndikatorNasionalMutu.setForeground(new java.awt.Color(0, 0, 0));
        btnIndikatorNasionalMutu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1491582089_Finance_financial_report.png"))); // NOI18N
        btnIndikatorNasionalMutu.setText("Indikator Nasional Mutu (INM)");
        btnIndikatorNasionalMutu.setIconTextGap(0);
        btnIndikatorNasionalMutu.setName("btnIndikatorNasionalMutu"); // NOI18N
        btnIndikatorNasionalMutu.setPreferredSize(new java.awt.Dimension(200, 90));
        btnIndikatorNasionalMutu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIndikatorNasionalMutuActionPerformed(evt);
            }
        });
        Panelmenu.add(btnIndikatorNasionalMutu);

        btnSuratKeteranganDisabilitas.setForeground(new java.awt.Color(0, 0, 0));
        btnSuratKeteranganDisabilitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1481002123_wheelchair.png"))); // NOI18N
        btnSuratKeteranganDisabilitas.setText("Surat Keterangan Dokter (Disabilitas)");
        btnSuratKeteranganDisabilitas.setIconTextGap(0);
        btnSuratKeteranganDisabilitas.setName("btnSuratKeteranganDisabilitas"); // NOI18N
        btnSuratKeteranganDisabilitas.setPreferredSize(new java.awt.Dimension(200, 90));
        btnSuratKeteranganDisabilitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuratKeteranganDisabilitasActionPerformed(evt);
            }
        });
        Panelmenu.add(btnSuratKeteranganDisabilitas);

        btnCeklisPraOperasi.setForeground(new java.awt.Color(0, 0, 0));
        btnCeklisPraOperasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/checklist.png"))); // NOI18N
        btnCeklisPraOperasi.setText("Checklist Pra Operasi");
        btnCeklisPraOperasi.setIconTextGap(0);
        btnCeklisPraOperasi.setName("btnCeklisPraOperasi"); // NOI18N
        btnCeklisPraOperasi.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCeklisPraOperasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCeklisPraOperasiActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCeklisPraOperasi);

        btnCeklisKesiapanAnestesi.setForeground(new java.awt.Color(0, 0, 0));
        btnCeklisKesiapanAnestesi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/checklist.png"))); // NOI18N
        btnCeklisKesiapanAnestesi.setText("Checklist Kesiapan Anestesi");
        btnCeklisKesiapanAnestesi.setIconTextGap(0);
        btnCeklisKesiapanAnestesi.setName("btnCeklisKesiapanAnestesi"); // NOI18N
        btnCeklisKesiapanAnestesi.setPreferredSize(new java.awt.Dimension(200, 90));
        btnCeklisKesiapanAnestesi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCeklisKesiapanAnestesiActionPerformed(evt);
            }
        });
        Panelmenu.add(btnCeklisKesiapanAnestesi);

        btnAsesmenPreInduksi.setForeground(new java.awt.Color(0, 0, 0));
        btnAsesmenPreInduksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/anastesi1.png"))); // NOI18N
        btnAsesmenPreInduksi.setText("Asesmen Pre Induksi");
        btnAsesmenPreInduksi.setIconTextGap(0);
        btnAsesmenPreInduksi.setName("btnAsesmenPreInduksi"); // NOI18N
        btnAsesmenPreInduksi.setPreferredSize(new java.awt.Dimension(200, 90));
        btnAsesmenPreInduksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsesmenPreInduksiActionPerformed(evt);
            }
        });
        Panelmenu.add(btnAsesmenPreInduksi);

        btnMasterNumdenomINM.setForeground(new java.awt.Color(0, 0, 0));
        btnMasterNumdenomINM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/if_address-book_285679.png"))); // NOI18N
        btnMasterNumdenomINM.setText("Master Numerator Denominator INM");
        btnMasterNumdenomINM.setIconTextGap(0);
        btnMasterNumdenomINM.setName("btnMasterNumdenomINM"); // NOI18N
        btnMasterNumdenomINM.setPreferredSize(new java.awt.Dimension(200, 90));
        btnMasterNumdenomINM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasterNumdenomINMActionPerformed(evt);
            }
        });
        Panelmenu.add(btnMasterNumdenomINM);

        btnAsesmenKeperawatanPerioperatif.setForeground(new java.awt.Color(0, 0, 0));
        btnAsesmenKeperawatanPerioperatif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/iconfinder_TextEdit_37595.png"))); // NOI18N
        btnAsesmenKeperawatanPerioperatif.setText("Assesmen Keperawatan Perioperatif");
        btnAsesmenKeperawatanPerioperatif.setIconTextGap(0);
        btnAsesmenKeperawatanPerioperatif.setName("btnAsesmenKeperawatanPerioperatif"); // NOI18N
        btnAsesmenKeperawatanPerioperatif.setPreferredSize(new java.awt.Dimension(200, 90));
        btnAsesmenKeperawatanPerioperatif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsesmenKeperawatanPerioperatifActionPerformed(evt);
            }
        });
        Panelmenu.add(btnAsesmenKeperawatanPerioperatif);

        btnPerencanaanPulang.setForeground(new java.awt.Color(0, 0, 0));
        btnPerencanaanPulang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/folder.png"))); // NOI18N
        btnPerencanaanPulang.setText("Perencanaan Pulang (Discharge Planning)");
        btnPerencanaanPulang.setIconTextGap(0);
        btnPerencanaanPulang.setName("btnPerencanaanPulang"); // NOI18N
        btnPerencanaanPulang.setPreferredSize(new java.awt.Dimension(200, 90));
        btnPerencanaanPulang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPerencanaanPulangActionPerformed(evt);
            }
        });
        Panelmenu.add(btnPerencanaanPulang);

        scrollPane2.setViewportView(Panelmenu);

        panelMenu.add(scrollPane2, java.awt.BorderLayout.CENTER);

        DlgHome.getContentPane().add(panelMenu, java.awt.BorderLayout.CENTER);

        tanggal.setEditable(false);
        tanggal.setForeground(new java.awt.Color(50, 70, 50));
        tanggal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "06/10/2024" }));
        tanggal.setDisplayFormat("dd/MM/yyyy");
        tanggal.setName("tanggal"); // NOI18N
        tanggal.setOpaque(false);

        btnDataPenjualan.setForeground(new java.awt.Color(0, 0, 0));
        btnDataPenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/1485357971_desktop_computer.png"))); // NOI18N
        btnDataPenjualan.setText("Data Penjualan Obat & BHP");
        btnDataPenjualan.setIconTextGap(0);
        btnDataPenjualan.setName("btnDataPenjualan"); // NOI18N
        btnDataPenjualan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnDataPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataPenjualanActionPerformed(evt);
            }
        });

        btnInputPenjualan.setForeground(new java.awt.Color(0, 0, 0));
        btnInputPenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/cashbox.png"))); // NOI18N
        btnInputPenjualan.setText("Input Penjualan Obat & BHP");
        btnInputPenjualan.setIconTextGap(0);
        btnInputPenjualan.setName("btnInputPenjualan"); // NOI18N
        btnInputPenjualan.setPreferredSize(new java.awt.Dimension(200, 90));
        btnInputPenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInputPenjualanActionPerformed(evt);
            }
        });

        btnDataPenyerahanDarah.setForeground(new java.awt.Color(0, 0, 0));
        btnDataPenyerahanDarah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/kwrite.png"))); // NOI18N
        btnDataPenyerahanDarah.setText("Data Penyerahan Darah");
        btnDataPenyerahanDarah.setIconTextGap(0);
        btnDataPenyerahanDarah.setName("btnDataPenyerahanDarah"); // NOI18N
        btnDataPenyerahanDarah.setPreferredSize(new java.awt.Dimension(200, 90));
        btnDataPenyerahanDarah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataPenyerahanDarahActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("::[ Khanza Hospital Management System 2017 ]::");
        setIconImages(null);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                formComponentMoved(evt);
            }
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(225, 235, 205)));
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setPreferredSize(new java.awt.Dimension(40, 44));
        internalFrame1.setVerifyInputWhenFocusTarget(false);
        internalFrame1.setWarnaAtas(new java.awt.Color(153, 153, 153));
        internalFrame1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 1));

        BtnMenu.setForeground(new java.awt.Color(0, 0, 0));
        BtnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/menu.png"))); // NOI18N
        BtnMenu.setMnemonic('M');
        BtnMenu.setText("Menu");
        BtnMenu.setToolTipText("Alt+M");
        BtnMenu.setEnabled(false);
        BtnMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnMenu.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnMenu.setIconTextGap(3);
        BtnMenu.setMargin(new java.awt.Insets(1, 2, 1, 0));
        BtnMenu.setName("BtnMenu"); // NOI18N
        BtnMenu.setPreferredSize(new java.awt.Dimension(68, 40));
        BtnMenu.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMenuActionPerformed(evt);
            }
        });
        internalFrame1.add(BtnMenu);

        btnGantiPassword.setForeground(new java.awt.Color(0, 0, 0));
        btnGantiPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/loginorg.png"))); // NOI18N
        btnGantiPassword.setMnemonic('G');
        btnGantiPassword.setText("Ganti Password");
        btnGantiPassword.setToolTipText("Alt+G");
        btnGantiPassword.setEnabled(false);
        btnGantiPassword.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGantiPassword.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGantiPassword.setIconTextGap(3);
        btnGantiPassword.setMargin(new java.awt.Insets(1, 2, 1, 0));
        btnGantiPassword.setName("btnGantiPassword"); // NOI18N
        btnGantiPassword.setPreferredSize(new java.awt.Dimension(125, 40));
        btnGantiPassword.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGantiPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGantiPasswordActionPerformed(evt);
            }
        });
        internalFrame1.add(btnGantiPassword);

        jSeparator4.setBackground(new java.awt.Color(150, 170, 125));
        jSeparator4.setForeground(new java.awt.Color(170, 190, 145));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setName("jSeparator4"); // NOI18N
        jSeparator4.setOpaque(true);
        jSeparator4.setPreferredSize(new java.awt.Dimension(1, 38));
        internalFrame1.add(jSeparator4);

        BtnToolReg.setForeground(new java.awt.Color(0, 0, 0));
        BtnToolReg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/PatientFile.png"))); // NOI18N
        BtnToolReg.setMnemonic('R');
        BtnToolReg.setText("Registrasi");
        BtnToolReg.setToolTipText("Alt+R");
        BtnToolReg.setEnabled(false);
        BtnToolReg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnToolReg.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnToolReg.setIconTextGap(3);
        BtnToolReg.setMargin(new java.awt.Insets(1, 2, 1, 0));
        BtnToolReg.setName("BtnToolReg"); // NOI18N
        BtnToolReg.setPreferredSize(new java.awt.Dimension(88, 40));
        BtnToolReg.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnToolReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnToolRegActionPerformed(evt);
            }
        });
        internalFrame1.add(BtnToolReg);

        btnToolIGD.setForeground(new java.awt.Color(0, 0, 0));
        btnToolIGD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Doctor.png"))); // NOI18N
        btnToolIGD.setMnemonic('D');
        btnToolIGD.setText("IGD/UGD");
        btnToolIGD.setToolTipText("Alt+D");
        btnToolIGD.setEnabled(false);
        btnToolIGD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnToolIGD.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnToolIGD.setIconTextGap(3);
        btnToolIGD.setMargin(new java.awt.Insets(1, 2, 1, 0));
        btnToolIGD.setName("btnToolIGD"); // NOI18N
        btnToolIGD.setPreferredSize(new java.awt.Dimension(84, 40));
        btnToolIGD.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        btnToolIGD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToolIGDActionPerformed(evt);
            }
        });
        internalFrame1.add(btnToolIGD);

        jSeparator5.setBackground(new java.awt.Color(150, 170, 125));
        jSeparator5.setForeground(new java.awt.Color(170, 190, 145));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator5.setName("jSeparator5"); // NOI18N
        jSeparator5.setOpaque(true);
        jSeparator5.setPreferredSize(new java.awt.Dimension(1, 38));
        internalFrame1.add(jSeparator5);

        btnBridgingEklaim.setForeground(new java.awt.Color(0, 0, 0));
        btnBridgingEklaim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/inacbg_eklaim_kecil.png"))); // NOI18N
        btnBridgingEklaim.setMnemonic('E');
        btnBridgingEklaim.setText("Eklaim INACBG");
        btnBridgingEklaim.setToolTipText("Alt+E");
        btnBridgingEklaim.setEnabled(false);
        btnBridgingEklaim.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBridgingEklaim.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnBridgingEklaim.setIconTextGap(3);
        btnBridgingEklaim.setMargin(new java.awt.Insets(1, 2, 1, 0));
        btnBridgingEklaim.setName("btnBridgingEklaim"); // NOI18N
        btnBridgingEklaim.setPreferredSize(new java.awt.Dimension(110, 40));
        btnBridgingEklaim.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBridgingEklaim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBridgingEklaimActionPerformed(evt);
            }
        });
        internalFrame1.add(btnBridgingEklaim);

        btnToolLab.setForeground(new java.awt.Color(0, 0, 0));
        btnToolLab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/addressbook-edit24.png"))); // NOI18N
        btnToolLab.setMnemonic('O');
        btnToolLab.setText("Laboratorium");
        btnToolLab.setToolTipText("Alt+O");
        btnToolLab.setEnabled(false);
        btnToolLab.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnToolLab.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnToolLab.setIconTextGap(3);
        btnToolLab.setMargin(new java.awt.Insets(1, 2, 1, 0));
        btnToolLab.setName("btnToolLab"); // NOI18N
        btnToolLab.setPreferredSize(new java.awt.Dimension(100, 40));
        btnToolLab.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        btnToolLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToolLabActionPerformed(evt);
            }
        });
        internalFrame1.add(btnToolLab);

        btnToolRad.setForeground(new java.awt.Color(0, 0, 0));
        btnToolRad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Surgeon.png"))); // NOI18N
        btnToolRad.setMnemonic('A');
        btnToolRad.setText("Radiologi");
        btnToolRad.setToolTipText("Alt+A");
        btnToolRad.setEnabled(false);
        btnToolRad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnToolRad.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnToolRad.setIconTextGap(3);
        btnToolRad.setMargin(new java.awt.Insets(1, 2, 1, 0));
        btnToolRad.setName("btnToolRad"); // NOI18N
        btnToolRad.setPreferredSize(new java.awt.Dimension(84, 40));
        btnToolRad.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        btnToolRad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToolRadActionPerformed(evt);
            }
        });
        internalFrame1.add(btnToolRad);

        BtnToolJualObat.setForeground(new java.awt.Color(0, 0, 0));
        BtnToolJualObat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/shopping-cart-insert24.png"))); // NOI18N
        BtnToolJualObat.setMnemonic('j');
        BtnToolJualObat.setText("Penjualan");
        BtnToolJualObat.setToolTipText("Alt+J");
        BtnToolJualObat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnToolJualObat.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnToolJualObat.setIconTextGap(3);
        BtnToolJualObat.setMargin(new java.awt.Insets(1, 2, 1, 0));
        BtnToolJualObat.setName("BtnToolJualObat"); // NOI18N
        BtnToolJualObat.setPreferredSize(new java.awt.Dimension(88, 40));
        BtnToolJualObat.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnToolJualObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnToolJualObatActionPerformed(evt);
            }
        });
        internalFrame1.add(BtnToolJualObat);

        BtnDasboard.setForeground(new java.awt.Color(0, 0, 0));
        BtnDasboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Pills.png"))); // NOI18N
        BtnDasboard.setMnemonic('S');
        BtnDasboard.setText("Dashboard e-Resep");
        BtnDasboard.setToolTipText("Alt+S");
        BtnDasboard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnDasboard.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnDasboard.setIconTextGap(3);
        BtnDasboard.setMargin(new java.awt.Insets(1, 2, 1, 0));
        BtnDasboard.setName("BtnDasboard"); // NOI18N
        BtnDasboard.setPreferredSize(new java.awt.Dimension(137, 40));
        BtnDasboard.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnDasboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDasboardActionPerformed(evt);
            }
        });
        internalFrame1.add(BtnDasboard);

        jSeparator9.setBackground(new java.awt.Color(150, 170, 125));
        jSeparator9.setForeground(new java.awt.Color(170, 190, 145));
        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator9.setName("jSeparator9"); // NOI18N
        jSeparator9.setOpaque(true);
        jSeparator9.setPreferredSize(new java.awt.Dimension(1, 38));
        internalFrame1.add(jSeparator9);

        BtnToolKamnap.setForeground(new java.awt.Color(0, 0, 0));
        BtnToolKamnap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/home24.png"))); // NOI18N
        BtnToolKamnap.setMnemonic('P');
        BtnToolKamnap.setText("Rawat Inap");
        BtnToolKamnap.setToolTipText("Alt+P");
        BtnToolKamnap.setEnabled(false);
        BtnToolKamnap.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnToolKamnap.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnToolKamnap.setIconTextGap(3);
        BtnToolKamnap.setMargin(new java.awt.Insets(1, 2, 1, 0));
        BtnToolKamnap.setName("BtnToolKamnap"); // NOI18N
        BtnToolKamnap.setPreferredSize(new java.awt.Dimension(96, 40));
        BtnToolKamnap.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnToolKamnap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnToolKamnapActionPerformed(evt);
            }
        });
        internalFrame1.add(BtnToolKamnap);

        BtnToolKasir.setForeground(new java.awt.Color(0, 0, 0));
        BtnToolKasir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/addressbook-edit24.png"))); // NOI18N
        BtnToolKasir.setMnemonic('W');
        BtnToolKasir.setText("Rawat Jalan");
        BtnToolKasir.setToolTipText("Alt+W");
        BtnToolKasir.setEnabled(false);
        BtnToolKasir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnToolKasir.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnToolKasir.setIconTextGap(3);
        BtnToolKasir.setMargin(new java.awt.Insets(1, 2, 1, 0));
        BtnToolKasir.setName("BtnToolKasir"); // NOI18N
        BtnToolKasir.setPreferredSize(new java.awt.Dimension(94, 40));
        BtnToolKasir.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnToolKasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnToolKasirActionPerformed(evt);
            }
        });
        internalFrame1.add(BtnToolKasir);

        jSeparator7.setBackground(new java.awt.Color(150, 170, 125));
        jSeparator7.setForeground(new java.awt.Color(170, 190, 145));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator7.setName("jSeparator7"); // NOI18N
        jSeparator7.setOpaque(true);
        jSeparator7.setPreferredSize(new java.awt.Dimension(1, 38));
        internalFrame1.add(jSeparator7);

        BtnLog.setForeground(new java.awt.Color(0, 0, 0));
        BtnLog.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/login2.png"))); // NOI18N
        BtnLog.setMnemonic('L');
        BtnLog.setText("Log In");
        BtnLog.setToolTipText("Alt+L");
        BtnLog.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnLog.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnLog.setIconTextGap(3);
        BtnLog.setMargin(new java.awt.Insets(1, 2, 1, 0));
        BtnLog.setName("BtnLog"); // NOI18N
        BtnLog.setPreferredSize(new java.awt.Dimension(75, 40));
        BtnLog.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLogActionPerformed(evt);
            }
        });
        internalFrame1.add(BtnLog);

        BtnClose.setForeground(new java.awt.Color(0, 0, 0));
        BtnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Delete.png"))); // NOI18N
        BtnClose.setMnemonic('U');
        BtnClose.setText("Keluar");
        BtnClose.setToolTipText("Alt+U");
        BtnClose.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BtnClose.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        BtnClose.setIconTextGap(3);
        BtnClose.setMargin(new java.awt.Insets(1, 2, 1, 0));
        BtnClose.setName("BtnClose"); // NOI18N
        BtnClose.setPreferredSize(new java.awt.Dimension(80, 40));
        BtnClose.setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCloseActionPerformed(evt);
            }
        });
        internalFrame1.add(BtnClose);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.PAGE_START);

        internalFrame4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(225, 235, 205)));
        internalFrame4.setName("internalFrame4"); // NOI18N
        internalFrame4.setPreferredSize(new java.awt.Dimension(330, 25));
        internalFrame4.setWarnaBawah(new java.awt.Color(153, 153, 153));
        internalFrame4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 0));

        lblStts.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lblStts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStts.setText("Status Admin :");
        lblStts.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblStts.setName("lblStts"); // NOI18N
        lblStts.setPreferredSize(new java.awt.Dimension(100, 23));
        internalFrame4.add(lblStts);

        jSeparator1.setBackground(new java.awt.Color(170, 190, 145));
        jSeparator1.setForeground(new java.awt.Color(170, 190, 145));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setName("jSeparator1"); // NOI18N
        jSeparator1.setOpaque(true);
        jSeparator1.setPreferredSize(new java.awt.Dimension(1, 20));
        internalFrame4.add(jSeparator1);

        kdUser.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        kdUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        kdUser.setText("Kode Admin :");
        kdUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        kdUser.setName("kdUser"); // NOI18N
        kdUser.setPreferredSize(new java.awt.Dimension(90, 23));
        internalFrame4.add(kdUser);

        lblUser.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setText("Log Out");
        lblUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblUser.setName("lblUser"); // NOI18N
        lblUser.setPreferredSize(new java.awt.Dimension(250, 23));
        internalFrame4.add(lblUser);

        jSeparator2.setBackground(new java.awt.Color(170, 190, 145));
        jSeparator2.setForeground(new java.awt.Color(170, 190, 145));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setName("jSeparator2"); // NOI18N
        jSeparator2.setOpaque(true);
        jSeparator2.setPreferredSize(new java.awt.Dimension(1, 20));
        internalFrame4.add(jSeparator2);

        lblTgl.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lblTgl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTgl.setText("Tanggal");
        lblTgl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblTgl.setName("lblTgl"); // NOI18N
        lblTgl.setPreferredSize(new java.awt.Dimension(100, 23));
        internalFrame4.add(lblTgl);

        jSeparator6.setBackground(new java.awt.Color(170, 190, 145));
        jSeparator6.setForeground(new java.awt.Color(170, 190, 145));
        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator6.setName("jSeparator6"); // NOI18N
        jSeparator6.setOpaque(true);
        jSeparator6.setPreferredSize(new java.awt.Dimension(1, 20));
        internalFrame4.add(jSeparator6);

        footer_lbl_update.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        footer_lbl_update.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        footer_lbl_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/file-edit-16x16.png"))); // NOI18N
        footer_lbl_update.setText("-");
        footer_lbl_update.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        footer_lbl_update.setIconTextGap(3);
        footer_lbl_update.setName("footer_lbl_update"); // NOI18N
        footer_lbl_update.setPreferredSize(new java.awt.Dimension(540, 23));
        internalFrame4.add(footer_lbl_update);

        getContentPane().add(internalFrame4, java.awt.BorderLayout.PAGE_END);

        PanelUtama.setName("PanelUtama"); // NOI18N
        PanelUtama.setOpaque(false);
        PanelUtama.setLayout(new java.awt.BorderLayout());

        scrollPane1.setBorder(null);
        scrollPane1.setName("scrollPane1"); // NOI18N

        PanelWall.setBackground(new java.awt.Color(29, 29, 29));
        PanelWall.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/wallpaper.jpg"))); // NOI18N
        PanelWall.setBackgroundImageType(usu.widget.constan.BackgroundConstan.BACKGROUND_IMAGE_STRECT);
        PanelWall.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 0, 0, 0));
        PanelWall.setPreferredSize(new java.awt.Dimension(200, 200));
        PanelWall.setRound(false);
        PanelWall.setWarna(new java.awt.Color(110, 110, 110));
        PanelWall.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PanelWallMouseMoved(evt);
            }
        });
        PanelWall.setLayout(new java.awt.BorderLayout());

        panelJudul.setBackground(new java.awt.Color(255, 255, 255));
        panelJudul.setOpaqueImage(false);
        panelJudul.setPreferredSize(new java.awt.Dimension(200, 245));
        panelJudul.setRound(false);
        panelJudul.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Your Businis Solution");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel11.setName("jLabel11"); // NOI18N
        jLabel11.setPreferredSize(new java.awt.Dimension(430, 30));
        panelJudul.add(jLabel11);
        jLabel11.setBounds(210, 180, 680, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/LOGO_RAZA_png.png"))); // NOI18N
        jLabel8.setText("Khanza HMS+, Hospital Management System");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel8.setName("jLabel8"); // NOI18N
        jLabel8.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        panelJudul.add(jLabel8);
        jLabel8.setBounds(120, 140, 820, 100);

        lbl_update.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_update.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_update.setText("-");
        lbl_update.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbl_update.setName("lbl_update"); // NOI18N
        lbl_update.setPreferredSize(new java.awt.Dimension(430, 30));
        panelJudul.add(lbl_update);
        lbl_update.setBounds(210, 205, 680, 20);

        Scroll21.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Scroll21.setName("Scroll21"); // NOI18N
        Scroll21.setPreferredSize(new java.awt.Dimension(172, 130));

        ket_update.setEditable(false);
        ket_update.setColumns(20);
        ket_update.setForeground(new java.awt.Color(0, 0, 153));
        ket_update.setRows(5);
        ket_update.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        ket_update.setName("ket_update"); // NOI18N
        ket_update.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ket_updateKeyPressed(evt);
            }
        });
        Scroll21.setViewportView(ket_update);

        panelJudul.add(Scroll21);
        Scroll21.setBounds(25, 10, 720, 135);

        jLabel13.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/yaski_icon.png"))); // NOI18N
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel13.setName("jLabel13"); // NOI18N
        jLabel13.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        panelJudul.add(jLabel13);
        jLabel13.setBounds(25, 140, 100, 100);

        PanelWall.add(panelJudul, java.awt.BorderLayout.PAGE_END);

        FlayMenu.setBackground(new java.awt.Color(255, 255, 255));
        FlayMenu.setOpaqueImage(false);
        FlayMenu.setPreferredSize(new java.awt.Dimension(200, 110));
        FlayMenu.setRound(false);
        FlayMenu.setLayout(new java.awt.GridLayout(1, 0, 4, 5));
        PanelWall.add(FlayMenu, java.awt.BorderLayout.PAGE_START);

        scrollPane1.setViewportView(PanelWall);

        PanelUtama.add(scrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(PanelUtama, java.awt.BorderLayout.CENTER);

        MenuBar.setBorder(null);
        MenuBar.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        MenuBar.setName("MenuBar"); // NOI18N
        MenuBar.setPreferredSize(new java.awt.Dimension(227, 30));

        jMenu1.setBackground(new java.awt.Color(20, 0, 20));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/barralan.png"))); // NOI18N
        jMenu1.setMnemonic('I');
        jMenu1.setText("Informasi");
        jMenu1.setToolTipText("Alt+I");
        jMenu1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenu1.setName("jMenu1"); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(120, 30));

        MnJadwalDokterRalan.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnJadwalDokterRalan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Preview.png"))); // NOI18N
        MnJadwalDokterRalan.setText("Jadwal Dokter Rawat Jalan");
        MnJadwalDokterRalan.setName("MnJadwalDokterRalan"); // NOI18N
        MnJadwalDokterRalan.setPreferredSize(new java.awt.Dimension(200, 35));
        MnJadwalDokterRalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnJadwalDokterRalanActionPerformed(evt);
            }
        });
        jMenu1.add(MnJadwalDokterRalan);

        MnPasienRanap.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnPasienRanap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Preview.png"))); // NOI18N
        MnPasienRanap.setText("Pasien Kamar Inap");
        MnPasienRanap.setName("MnPasienRanap"); // NOI18N
        MnPasienRanap.setPreferredSize(new java.awt.Dimension(200, 35));
        MnPasienRanap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnPasienRanapActionPerformed(evt);
            }
        });
        jMenu1.add(MnPasienRanap);

        MnTelusurKunjungan.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnTelusurKunjungan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Preview.png"))); // NOI18N
        MnTelusurKunjungan.setText("Telusur Kunjungan Pasien");
        MnTelusurKunjungan.setName("MnTelusurKunjungan"); // NOI18N
        MnTelusurKunjungan.setPreferredSize(new java.awt.Dimension(200, 35));
        MnTelusurKunjungan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnTelusurKunjunganActionPerformed(evt);
            }
        });
        jMenu1.add(MnTelusurKunjungan);

        MnPenggunaanKamarRanap.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnPenggunaanKamarRanap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Preview.png"))); // NOI18N
        MnPenggunaanKamarRanap.setText("Penggunaan Kamar Inap");
        MnPenggunaanKamarRanap.setName("MnPenggunaanKamarRanap"); // NOI18N
        MnPenggunaanKamarRanap.setPreferredSize(new java.awt.Dimension(200, 35));
        MnPenggunaanKamarRanap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnPenggunaanKamarRanapActionPerformed(evt);
            }
        });
        jMenu1.add(MnPenggunaanKamarRanap);

        MenuBar.add(jMenu1);

        jMenu2.setBackground(new java.awt.Color(20, 0, 20));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/search_page.png"))); // NOI18N
        jMenu2.setMnemonic('I');
        jMenu2.setText("Tarif Penunjang Medis");
        jMenu2.setToolTipText("Alt+I");
        jMenu2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenu2.setName("jMenu2"); // NOI18N
        jMenu2.setPreferredSize(new java.awt.Dimension(170, 30));

        MnTarifLab.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnTarifLab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Preview.png"))); // NOI18N
        MnTarifLab.setText("Tarif Laboratorium");
        MnTarifLab.setName("MnTarifLab"); // NOI18N
        MnTarifLab.setPreferredSize(new java.awt.Dimension(170, 35));
        MnTarifLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnTarifLabActionPerformed(evt);
            }
        });
        jMenu2.add(MnTarifLab);

        MnTarifRad.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnTarifRad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Preview.png"))); // NOI18N
        MnTarifRad.setText("Tarif Radiologi");
        MnTarifRad.setName("MnTarifRad"); // NOI18N
        MnTarifRad.setPreferredSize(new java.awt.Dimension(170, 35));
        MnTarifRad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnTarifRadActionPerformed(evt);
            }
        });
        jMenu2.add(MnTarifRad);

        MenuBar.add(jMenu2);

        jMenu3.setBackground(new java.awt.Color(20, 0, 20));
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/search_page.png"))); // NOI18N
        jMenu3.setMnemonic('I');
        jMenu3.setText("Tarif Pelayanan Kesehatan");
        jMenu3.setToolTipText("Alt+I");
        jMenu3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenu3.setName("jMenu3"); // NOI18N
        jMenu3.setPreferredSize(new java.awt.Dimension(190, 30));

        MnTarifRalan.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnTarifRalan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Preview.png"))); // NOI18N
        MnTarifRalan.setText("Tarif Rawat Jalan");
        MnTarifRalan.setName("MnTarifRalan"); // NOI18N
        MnTarifRalan.setPreferredSize(new java.awt.Dimension(190, 35));
        MnTarifRalan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnTarifRalanActionPerformed(evt);
            }
        });
        jMenu3.add(MnTarifRalan);

        MnTarifRanap.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnTarifRanap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Preview.png"))); // NOI18N
        MnTarifRanap.setText("Tarif Rawat Inap");
        MnTarifRanap.setName("MnTarifRanap"); // NOI18N
        MnTarifRanap.setPreferredSize(new java.awt.Dimension(190, 35));
        MnTarifRanap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnTarifRanapActionPerformed(evt);
            }
        });
        jMenu3.add(MnTarifRanap);

        MnTarifKamar.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnTarifKamar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Preview.png"))); // NOI18N
        MnTarifKamar.setText("Tarif Kamar");
        MnTarifKamar.setName("MnTarifKamar"); // NOI18N
        MnTarifKamar.setPreferredSize(new java.awt.Dimension(190, 35));
        MnTarifKamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnTarifKamarActionPerformed(evt);
            }
        });
        jMenu3.add(MnTarifKamar);

        MnTarifOperasi.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnTarifOperasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Preview.png"))); // NOI18N
        MnTarifOperasi.setText("Tarif Operasi & VK");
        MnTarifOperasi.setName("MnTarifOperasi"); // NOI18N
        MnTarifOperasi.setPreferredSize(new java.awt.Dimension(190, 35));
        MnTarifOperasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnTarifOperasiActionPerformed(evt);
            }
        });
        jMenu3.add(MnTarifOperasi);

        MnTarifINACBG.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnTarifINACBG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Preview.png"))); // NOI18N
        MnTarifINACBG.setText("Tarif INACBG's Klaim BPJS");
        MnTarifINACBG.setName("MnTarifINACBG"); // NOI18N
        MnTarifINACBG.setPreferredSize(new java.awt.Dimension(190, 35));
        MnTarifINACBG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnTarifINACBGActionPerformed(evt);
            }
        });
        jMenu3.add(MnTarifINACBG);

        MenuBar.add(jMenu3);

        jMenu4.setBackground(new java.awt.Color(20, 0, 20));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/63.png"))); // NOI18N
        jMenu4.setMnemonic('T');
        jMenu4.setText("Tentang Program");
        jMenu4.setToolTipText("Alt+T");
        jMenu4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jMenu4.setName("jMenu4"); // NOI18N
        jMenu4.setPreferredSize(new java.awt.Dimension(160, 30));
        jMenu4.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu4MenuSelected(evt);
            }
        });
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        MenuBar.add(jMenu4);

        setJMenuBar(MenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        DlgHome.dispose();
        System.exit(0);
    }//GEN-LAST:event_formWindowClosed

    private void BtnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCloseActionPerformed
        isTutup();
        DlgHome.dispose();
        int jawab = JOptionPane.showConfirmDialog(null, "Yakin anda mau keluar dari program ini ????", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (jawab == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_BtnCloseActionPerformed

    private void BtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCancelActionPerformed
        edAdmin.setText("");
        edPwd.setText("");
        DlgLogin.dispose();
    }//GEN-LAST:event_BtnCancelActionPerformed

    private void BtnLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLogActionPerformed
        FlayMenu.setVisible(false);
        akses.setpenjualan_obatfalse();
        akses.setpenjualan_obatfalse();
        akses.setutd_penyerahan_darahfalse();
        akses.setresep_dokterfalse();

        switch (BtnLog.getText().trim()) {
            case "Log Out":
                BtnToolReg.setEnabled(false);
                BtnToolKamnap.setEnabled(false);
                BtnToolKasir.setEnabled(false);
                btnToolLab.setEnabled(false);
                btnToolRad.setEnabled(false);
                btnToolIGD.setEnabled(false);
                btnGantiPassword.setEnabled(false);
                btnBridgingEklaim.setEnabled(false);
                edAdmin.setText("");
                edPwd.setText("");
                BtnLog.setText("Log In");
                lblStts.setText("Status Admin : ");
                lblUser.setText("Log Out");
                kdUser.setText("");
                ket_update.setText("");
                lbl_update.setText("Modified by. UNIT SIMRS RAZA - Vs. " + Sequel.cariIsi("select versi_update from history_update order by kode desc limit 1") + " [Activated]");
                footer_lbl_update.setText(" Didesain & dibuat oleh Khanza.Soft Media - vs. " + Sequel.cariIsi("select versi_update from history_update order by kode desc limit 1") + "");
                BtnMenu.setEnabled(false);
                isTutup();
                break;
            case "Log In":
                DlgLogin.setVisible(true);
                edAdmin.requestFocus();
                break;
        }
    }//GEN-LAST:event_BtnLogActionPerformed

    private void BtnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLoginActionPerformed
        if (edAdmin.getText().trim().equals("")) {
            Valid.textKosong(edAdmin, "ID User");
        } else if (edPwd.getText().trim().equals("")) {
            Valid.textKosong(edPwd, "Password");
        } else {
            try {
                akses.setData(edAdmin.getText(), edPwd.getText());
                if (edAdmin.getText().equals("admin") && edPwd.getText().equals("satu")) {
                    BtnMenu.setEnabled(true);
                    BtnToolReg.setEnabled(true);
                    BtnToolKamnap.setEnabled(true);
                    BtnToolKasir.setEnabled(true);
                    btnToolLab.setEnabled(true);
                    btnToolIGD.setEnabled(true);
                    btnToolRad.setEnabled(true);
                    btnBridgingEklaim.setEnabled(true);
                    btnGantiPassword.setEnabled(false);

                    DlgLogin.dispose();
                    BtnLog.setText("Log Out");
                    lblStts.setText("Admin : ");
                    lblUser.setText("Admin Utama");
                    kdUser.setText("Kode Utama :");
                    ket_update.setText(Sequel.cariIsi("select concat('Tgl. ',date_format(tgl_update,'%d-%m-%Y'),', Jam : ',DATE_FORMAT(jam_update,'%H:%i %p'),' ',keterangan) ket from history_update order by kode desc limit 1"));
                } else if (akses.getjml1() >= 1) {
                    BtnMenu.setEnabled(true);
                    BtnToolReg.setEnabled(true);
                    BtnToolKamnap.setEnabled(true);
                    BtnToolKasir.setEnabled(true);
                    btnToolLab.setEnabled(true);
                    btnToolIGD.setEnabled(true);
                    btnToolRad.setEnabled(true);
                    btnBridgingEklaim.setEnabled(true);
                    btnGantiPassword.setEnabled(false);

                    DlgLogin.dispose();
                    BtnLog.setText("Log Out");
                    lblStts.setText("Admin : ");
                    lblUser.setText("Admin Utama");
                    kdUser.setText("Kode Utama :");
                    ket_update.setText(Sequel.cariIsi("select concat('Tgl. ',date_format(tgl_update,'%d-%m-%Y'),', Jam : ',DATE_FORMAT(jam_update,'%H:%i %p'),' ',keterangan) ket from history_update order by kode desc limit 1"));
                } else if (akses.getjml2() >= 1) {
                    BtnMenu.setEnabled(true);
                    DlgLogin.dispose();
                    BtnLog.setText("Log Out");
                    lblStts.setText("Admin : ");
                    lblUser.setText(akses.getnamauser());
                    kdUser.setText(akses.getkode());
                    btnGantiPassword.setEnabled(true);
                    BtnToolReg.setEnabled(akses.getregistrasi());
                    BtnToolKamnap.setEnabled(akses.getkamar_inap());
                    BtnToolKasir.setEnabled(akses.getkasir_ralan());
                    btnToolLab.setEnabled(akses.getperiksa_lab());
                    btnToolRad.setEnabled(akses.getperiksa_radiologi());
                    btnToolIGD.setEnabled(akses.getigd());
                    btnBridgingEklaim.setEnabled(akses.getinacbg_klaim_raza());
                    Sequel.menyimpan("tracker", "'" + edAdmin.getText() + "',current_date(),current_time()", "Login");
                    ket_update.setText(Sequel.cariIsi("select concat('Tgl. ',date_format(tgl_update,'%d-%m-%Y'),', Jam : ',DATE_FORMAT(jam_update,'%H:%i %p'),' ',keterangan) ket from history_update order by kode desc limit 1"));
                } else if ((akses.getjml1() == 0) && (akses.getjml2() == 0)) {
                    JOptionPane.showMessageDialog(null, "Maaf, Gagal login. ID User atau password ada yang salah ...!");
                    BtnToolReg.setEnabled(false);
                    BtnToolKamnap.setEnabled(false);
                    BtnToolKasir.setEnabled(false);
                    btnGantiPassword.setEnabled(false);
                    btnToolLab.setEnabled(false);
                    btnToolIGD.setEnabled(false);
                    btnToolRad.setEnabled(false);
                    btnBridgingEklaim.setEnabled(false);
                    edAdmin.setText("");
                    edPwd.setText("");

                    BtnMenu.setEnabled(false);

                    edAdmin.requestFocus();
                    BtnLog.setText("Log In");
                    lblStts.setText("Status Admin : ");
                    lblUser.setText("Log Out");
                    ket_update.setText("");
                }
            } catch (Exception e) {
                System.out.println("Notifikasi : " + e);
            }
        }
    }//GEN-LAST:event_BtnLoginActionPerformed

    private void BtnToolKamnapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnToolKamnapActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));        
        kamarinap.isCek();
        kamarinap.emptTeks();
        kamarinap.setCariKosong();
        kamarinap.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        kamarinap.setLocationRelativeTo(PanelUtama);
        kamarinap.setVisible(true);
        kamarinap.UserValid();
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnToolKamnapActionPerformed

private void edPwdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edPwdKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        BtnLoginActionPerformed(null);
    } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
        edAdmin.requestFocus();
    } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
        BtnLogin.requestFocus();
    }
}//GEN-LAST:event_edPwdKeyPressed

private void BtnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMenuActionPerformed
    this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    isTutup();
    try {
        if (prop.getProperty("MENUTRANSPARAN").equals("yes")) {
            //com.sun.awt.AWTUtilities.setWindowOpacity(DlgHome,0.6f);
        } else {
            //com.sun.awt.AWTUtilities.setWindowOpacity(DlgHome,0.93f);
        }
    } catch (Exception e) {

    }

    DlgHome.setSize(PanelUtama.getWidth() - 45, PanelUtama.getHeight() - 45);
    isTampil();
    DlgHome.setLocationRelativeTo(PanelUtama);
    DlgHome.setVisible(true);

    if (TCari.isVisible() == true) {
        TCari.setText("");
        TCari.requestFocus();
    } else {
        cmbMenu.requestFocus();
    }

    this.setCursor(Cursor.getDefaultCursor());
}//GEN-LAST:event_BtnMenuActionPerformed

private void BtnToolKasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnToolKasirActionPerformed
    this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    isTutup();
    akses.tRefreshAntrian.start();
    kasirralan.isCek();
    kasirralan.empttext();
    kasirralan.tampilkasir();
    kasirralan.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
    kasirralan.setLocationRelativeTo(PanelUtama);
    kasirralan.setVisible(true);
    DlgHome.dispose();
    this.setCursor(Cursor.getDefaultCursor());
}//GEN-LAST:event_BtnToolKasirActionPerformed

private void BtnToolRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnToolRegActionPerformed
    this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    isTutup();    
    DlgReg reg = new DlgReg(null, false);
    reg.emptTeks();
    reg.isCek();
    reg.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
    reg.setLocationRelativeTo(PanelUtama);
    reg.setVisible(true);
    reg.TabRawat.setSelectedIndex(0);
    this.setCursor(Cursor.getDefaultCursor());
}//GEN-LAST:event_BtnToolRegActionPerformed

private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
    if (this.getState() == 1) {
        isTutup();
    }
}//GEN-LAST:event_formWindowStateChanged

private void BtnClosePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClosePassActionPerformed
    WindowInput.dispose();
}//GEN-LAST:event_BtnClosePassActionPerformed

private void BtnClosePassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnClosePassKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        WindowInput.dispose();
    } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
        PassBaru2.requestFocus();
    } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
        PassLama.requestFocus();
    }
}//GEN-LAST:event_BtnClosePassKeyPressed

private void BtnSimpanPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanPassActionPerformed
    if (PassLama.getText().trim().equals("")) {
        Valid.textKosong(PassLama, "Password Lama");
    } else if (Passbaru1.getText().trim().equals("")) {
        Valid.textKosong(Passbaru1, "Password Baru");
    } else if (PassBaru2.getText().trim().equals("")) {
        Valid.textKosong(PassBaru2, "Password Baru");
    } else if (!edPwd.getText().trim().equals(PassLama.getText())) {
        JOptionPane.showMessageDialog(null, "Maaf, Password lama salah...!!!");
        PassLama.requestFocus();
    } else if (!Passbaru1.getText().trim().equals(PassBaru2.getText())) {
        JOptionPane.showMessageDialog(null, "Maaf, Password Baru 1 dan Password Baru 2 tidak sesuai...!!!");
        PassBaru2.requestFocus();
    } else {
        Sequel.queryu("update user set password=AES_ENCRYPT('" + PassBaru2.getText() + "','windi')  where id_user=AES_ENCRYPT('" + kdUser.getText() + "','nur')");
        WindowInput.setVisible(false);
    }
}//GEN-LAST:event_BtnSimpanPassActionPerformed

private void BtnSimpanPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSimpanPassKeyPressed
    Valid.pindah(evt, PassLama, PassBaru2);
}//GEN-LAST:event_BtnSimpanPassKeyPressed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        DlgHome.dispose();
    }//GEN-LAST:event_button1ActionPerformed

    private void cmbMenuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMenuItemStateChanged
        isTampil();
    }//GEN-LAST:event_cmbMenuItemStateChanged

    private void btnICDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnICDActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        isTutup();
        DlgCariPenyakit penyakit=new DlgCariPenyakit(null,false);
        penyakit.isCek();
        penyakit.emptTeks();
        penyakit.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        penyakit.setLocationRelativeTo(PanelUtama);
        penyakit.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnICDActionPerformed

    private void btnObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObatActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        isTutup();
        DlgBarang barang = new DlgBarang(null, false);        
        barang.isCek();
        barang.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        barang.setLocationRelativeTo(PanelUtama);
        barang.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnObatActionPerformed

    private void btnObatPenyakitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObatPenyakitActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgObatPenyakit obatpenyakit = new DlgObatPenyakit(this, false);
        obatpenyakit.isCek();
        obatpenyakit.emptTeks();
        obatpenyakit.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        obatpenyakit.setLocationRelativeTo(PanelUtama);
        obatpenyakit.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnObatPenyakitActionPerformed

    private void btnKamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKamarActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        isTutup();
        DlgKamar kamar = new DlgKamar(null, false);
        kamar.emptTeks();
        kamar.isCek();
        kamar.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        kamar.setLocationRelativeTo(PanelUtama);
        kamar.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnKamarActionPerformed

    private void btnTindakanRalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTindakanRalanActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgJnsPerawatanRalan perawatan = new DlgJnsPerawatanRalan(null, false);
        perawatan.emptTeks();
        perawatan.isCek();
        perawatan.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        perawatan.setLocationRelativeTo(PanelUtama);
        perawatan.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnTindakanRalanActionPerformed

    private void btnDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDokterActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgDokter dokter=new DlgDokter(null,false);
        dokter.emptTeks();
        dokter.isCek();
        dokter.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        dokter.setLocationRelativeTo(PanelUtama);
        dokter.setAlwaysOnTop(false);
        dokter.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnDokterActionPerformed

    private void btnPegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPegawaiActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPetugas petugas=new DlgPetugas(null,false);
        petugas.isCek();
        petugas.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        petugas.setLocationRelativeTo(PanelUtama);
        petugas.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPegawaiActionPerformed

    private void btnPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasienActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPasien pasien = new DlgPasien(null, false);
        pasien.emptTeks();
        pasien.isCek();
        pasien.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        pasien.setLocationRelativeTo(PanelUtama);
        pasien.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPasienActionPerformed

    private void btnRegistrasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrasiActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgReg reg = new DlgReg(null, false);
        reg.tampil();
        reg.emptTeks();
        reg.isCek();
        reg.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        reg.setLocationRelativeTo(PanelUtama);
        reg.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRegistrasiActionPerformed

    private void btnRalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRalanActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRawatJalan dlgrwjl = new DlgRawatJalan(null, false);
        dlgrwjl.tampilDrPr();
        dlgrwjl.isCek();
        dlgrwjl.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        dlgrwjl.setLocationRelativeTo(PanelUtama);
        dlgrwjl.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRalanActionPerformed

    private void btnKamarInapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKamarInapActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgKamarInap kamarinap = new DlgKamarInap(null, false);
        kamarinap.isCek();
        kamarinap.emptTeks();
        kamarinap.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        kamarinap.setLocationRelativeTo(PanelUtama);
        kamarinap.setVisible(true);
        kamarinap.UserValid();
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnKamarInapActionPerformed

    private void btnRanapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRanapActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRawatInap rawatinap = new DlgRawatInap(null, false);
        rawatinap.tampilDr();
        rawatinap.isCek();
        rawatinap.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        rawatinap.setLocationRelativeTo(PanelUtama);
        rawatinap.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRanapActionPerformed

    private void btnResepObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResepObatActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgResepObat resep = new DlgResepObat(this, false);
        resep.tampil();
        resep.emptTeks();
        resep.isCek();
        resep.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        resep.setLocationRelativeTo(PanelUtama);
        resep.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnResepObatActionPerformed

    private void btnRujukPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRujukPasienActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRujuk rujuk = new DlgRujuk(this, false);
        rujuk.tampilLain();
        rujuk.emptTeks();
        rujuk.isCek();
        rujuk.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        rujuk.setLocationRelativeTo(PanelUtama);
        rujuk.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRujukPasienActionPerformed

    private void btnBeriObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBeriObatActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPemberianObat beriobat = new DlgPemberianObat(null, false);
        beriobat.tampilPO();
        beriobat.isCek();
        beriobat.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        beriobat.setLocationRelativeTo(PanelUtama);
        beriobat.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnBeriObatActionPerformed

    private void btnPasienMatiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasienMatiActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPasienMati pasienmati = new DlgPasienMati(this, false);
        pasienmati.emptTeks();
        pasienmati.isCek();
        pasienmati.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        pasienmati.setLocationRelativeTo(PanelUtama);
        pasienmati.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPasienMatiActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed

        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgAdmin admin = new DlgAdmin(this, false);
        admin.tampil();
        admin.emptTeks();
        admin.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        admin.setLocationRelativeTo(PanelUtama);
        admin.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnAdminActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgUser user = new DlgUser(this, false);
        user.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        user.setLocationRelativeTo(PanelUtama);
        user.setVisible(true);
        user.emptTeks();
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnAntrianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAntrianActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRunTeks runteks = new DlgRunTeks(this, false);
        runteks.emptTeks();
        runteks.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        runteks.setLocationRelativeTo(PanelUtama);
        runteks.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnAntrianActionPerformed

    private void btnSetupHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetupHargaActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSetHarga setharga = new DlgSetHarga(this, false);
        setharga.emptTeks();
        setharga.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        setharga.setLocationRelativeTo(PanelUtama);
        setharga.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSetupHargaActionPerformed

    private void btnSuplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuplierActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSuplier suplier = new DlgSuplier(this, false);
        suplier.isCek();
        suplier.emptTeks();
        suplier.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        suplier.setLocationRelativeTo(PanelUtama);
        suplier.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSuplierActionPerformed

    private void btnJnsBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJnsBarangActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgCariJenis jenis = new DlgCariJenis(null, false);
        jenis.isCek();
        jenis.emptTeks();
        jenis.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        jenis.setLocationRelativeTo(PanelUtama);
        jenis.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnJnsBarangActionPerformed

    private void btnKonversiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKonversiActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgKonversi konversi = new DlgKonversi(this, false);
        konversi.isCek();
        konversi.emptTeks();
        konversi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        konversi.setLocationRelativeTo(PanelUtama);
        konversi.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnKonversiActionPerformed

    private void btnSatuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSatuanActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSatuan satuan=new DlgSatuan(null,false);
        satuan.emptTeks();
        satuan.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        satuan.setLocationRelativeTo(PanelUtama);
        satuan.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSatuanActionPerformed

    private void btnCashFlowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCashFlowActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgCashflow bubes = new DlgCashflow(this, false);
        bubes.isCek();
        bubes.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        bubes.setLocationRelativeTo(PanelUtama);
        bubes.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCashFlowActionPerformed

    private void btnBubesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBubesActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgBubes bubes = new DlgBubes(this, false);
        bubes.isCek();
        bubes.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        bubes.setLocationRelativeTo(PanelUtama);
        bubes.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnBubesActionPerformed

    private void btnPostingJurnalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostingJurnalActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgJurnal jurnal = new DlgJurnal(this, false);
        jurnal.tampil();
        jurnal.isCek();
        jurnal.emptTeks();
        jurnal.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        jurnal.setLocationRelativeTo(PanelUtama);
        jurnal.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPostingJurnalActionPerformed

    private void btnRekeningTahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRekeningTahunActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRekeningTahun rekeningtahun = new DlgRekeningTahun(this, false);
        rekeningtahun.tampil();
        rekeningtahun.isCek();
        rekeningtahun.emptTeks();
        rekeningtahun.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        rekeningtahun.setLocationRelativeTo(PanelUtama);
        rekeningtahun.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRekeningTahunActionPerformed

    private void btnRekeningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRekeningActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRekening rekening = new DlgRekening(this, false);
        rekening.tampil();
        rekening.isCek();
        rekening.emptTeks();
        rekening.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        rekening.setLocationRelativeTo(PanelUtama);
        rekening.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRekeningActionPerformed

    private void btnPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPembelianActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPembelian pembelian = new DlgPembelian(this, false);
        pembelian.isCek();
        pembelian.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        pembelian.setLocationRelativeTo(PanelUtama);
        pembelian.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPembelianActionPerformed

    private void btnPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenjualanActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPenjualan penjualan = new DlgPenjualan(this, false);
        penjualan.isCek();
        penjualan.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        penjualan.setLocationRelativeTo(PanelUtama);
        penjualan.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPenjualanActionPerformed

    private void btnPiutangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPiutangActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPiutang piutang = new DlgPiutang(this, false);
        piutang.emptTeks();
        piutang.isCek();
        piutang.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        piutang.setLocationRelativeTo(PanelUtama);
        piutang.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPiutangActionPerformed

    private void btnBayarPiutangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarPiutangActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgBayarPiutang bayarpiutang = new DlgBayarPiutang(this, false);
        bayarpiutang.tampil();
        bayarpiutang.emptTeks();
        bayarpiutang.isCek();
        bayarpiutang.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        bayarpiutang.setLocationRelativeTo(PanelUtama);
        bayarpiutang.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnBayarPiutangActionPerformed

    private void btnOpnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpnameActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgInputStok opname = new DlgInputStok(this, false);
        opname.tampil();
        opname.isCek();
        opname.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        opname.setLocationRelativeTo(PanelUtama);
        opname.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnOpnameActionPerformed

    private void btnReturBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturBeliActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgReturBeli returbeli = new DlgReturBeli(this, false);
        returbeli.isCek();
        returbeli.emptTeks();
        returbeli.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        returbeli.setLocationRelativeTo(PanelUtama);
        returbeli.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnReturBeliActionPerformed

    private void btnReturJualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturJualActionPerformed
        akses.setform("DlgReturJual");
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgReturJual returjual = new DlgReturJual(this, false);
        returjual.emptTeks();
        returjual.isCek();
        returjual.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        returjual.setLocationRelativeTo(PanelUtama);
        returjual.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnReturJualActionPerformed

    private void btnSirkulasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSirkulasiActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSirkulasiBarang sirkulasi = new DlgSirkulasiBarang(this, false);
        sirkulasi.isCek();
        sirkulasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        sirkulasi.setLocationRelativeTo(PanelUtama);
        sirkulasi.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSirkulasiActionPerformed

    private void btnKeuntunganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeuntunganActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgProyeksiJual projul = new DlgProyeksiJual(this, false);
        projul.isCek();
        projul.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        projul.setLocationRelativeTo(PanelUtama);
        projul.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnKeuntunganActionPerformed

    private void btnLabaRugiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLabaRugiActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgLabaRugi labrug = new DlgLabaRugi(this, false);
        labrug.isCek();
        labrug.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        labrug.setLocationRelativeTo(PanelUtama);
        labrug.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnLabaRugiActionPerformed

    private void btnReturPiutangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturPiutangActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgReturPiutang returpiutang = new DlgReturPiutang(this, false);
        returpiutang.isCek();
        returpiutang.emptTeks();
        returpiutang.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        returpiutang.setLocationRelativeTo(PanelUtama);
        returpiutang.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnReturPiutangActionPerformed

    private void btnAnalisaKamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisaKamarActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        InformasiAnalisaKamin analisakamin = new InformasiAnalisaKamin(this, false);
        analisakamin.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        analisakamin.setLocationRelativeTo(PanelUtama);
        analisakamin.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnAnalisaKamarActionPerformed

    private void btnTagihanMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTagihanMasukActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgLhtBiaya billing = new DlgLhtBiaya(this, false);
        billing.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        billing.setLocationRelativeTo(PanelUtama);
        billing.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnTagihanMasukActionPerformed

    private void btnResumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResumeActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgResumePerawatan resume = new DlgResumePerawatan(this, false);
        resume.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        resume.setLocationRelativeTo(PanelUtama);
        resume.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnResumeActionPerformed

    private void btnDietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDietActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPemberianDiet diet = new DlgPemberianDiet(this, false);
        diet.ChkInput.setSelected(false);
        diet.isForm();
        diet.isCek();
        diet.TabDiet.setSelectedIndex(0);
        diet.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        diet.setLocationRelativeTo(PanelUtama);
        diet.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnDietActionPerformed

    private void btnKasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKasirActionPerformed
        BtnToolKasirActionPerformed(evt);
    }//GEN-LAST:event_btnKasirActionPerformed

    private void btnLahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLahirActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgIKBBayi lahir = new DlgIKBBayi(this, false);
        lahir.tampil();
        lahir.isCek();
        lahir.emptTeks();
        lahir.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        lahir.setLocationRelativeTo(PanelUtama);
        lahir.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnLahirActionPerformed

    private void btnSetBiayaHarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetBiayaHarianActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgBiayaHarian biayaharian = new DlgBiayaHarian(this, false);
        biayaharian.emptTeks();
        biayaharian.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        biayaharian.setLocationRelativeTo(PanelUtama);
        biayaharian.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSetBiayaHarianActionPerformed

    private void btnJenisInventarisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJenisInventarisActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        InventarisJenis jnsinventaris = new InventarisJenis(this, false);
        jnsinventaris.emptTeks();
        jnsinventaris.tampil();
        jnsinventaris.isCek();
        jnsinventaris.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        jnsinventaris.setLocationRelativeTo(PanelUtama);
        jnsinventaris.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnJenisInventarisActionPerformed

    private void btnKategoriInventarisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKategoriInventarisActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        InventarisKategori ktginventaris = new InventarisKategori(this, false);
        ktginventaris.tampil();
        ktginventaris.isCek();
        ktginventaris.emptTeks();
        ktginventaris.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        ktginventaris.setLocationRelativeTo(PanelUtama);
        ktginventaris.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnKategoriInventarisActionPerformed

    private void btnLihatPiutangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLihatPiutangActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgLhtPiutang billing = new DlgLhtPiutang(this, false);
        billing.tampil();
        billing.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        billing.setLocationRelativeTo(PanelUtama);
        billing.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnLihatPiutangActionPerformed

    private void btnLaboratoriumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaboratoriumActionPerformed
        isTutup();
        DlgCariPeriksaLab produsen = new DlgCariPeriksaLab(this, false);
        produsen.isCek();
        produsen.ketAktif.setText(Sequel.cariIsi("select if(aktivasi_LIS='1','TELAH DIAKTIFKAN','NON AKTIF') cek from set_pjlab limit 1"));
        produsen.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        produsen.setLocationRelativeTo(PanelUtama);
        produsen.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnLaboratoriumActionPerformed

    private void btnRalanMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRalanMasukActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPembayaranRalan billing = new DlgPembayaranRalan(this, false);
        billing.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        billing.setLocationRelativeTo(PanelUtama);
        billing.setVisible(true);
        billing.fokus();
        billing.tampil();
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRalanMasukActionPerformed

    private void btnSetupAplikasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetupAplikasiActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSetAplikasi aplikasi = new DlgSetAplikasi(this, false);
        aplikasi.emptTeks();
        aplikasi.emptUpdate();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSetupAplikasiActionPerformed

    private void btnSetOtoRalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetOtoRalanActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSetOtoRalan aplikasi = new DlgSetOtoRalan(this, false);
        aplikasi.emptTeks();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSetOtoRalanActionPerformed

    private void btnRanapMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRanapMasukActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPembayaranRanap billing = new DlgPembayaranRanap(this, false);
        billing.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        billing.setLocationRelativeTo(PanelUtama);
        billing.setVisible(true);
        billing.fokus();
        billing.tampil();
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRanapMasukActionPerformed

    private void btnProdusenInventarisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdusenInventarisActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        InventarisProdusen produsen = new InventarisProdusen(this, false);
        produsen.tampil();
        produsen.emptTeks();
        produsen.isCek();
        produsen.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        produsen.setLocationRelativeTo(PanelUtama);
        produsen.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnProdusenInventarisActionPerformed

    private void btnSetBiayaMasukSekaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetBiayaMasukSekaliActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgBiayaSekaliMasuk biayaharian = new DlgBiayaSekaliMasuk(this, false);
        biayaharian.emptTeks();
        biayaharian.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        biayaharian.setLocationRelativeTo(PanelUtama);
        biayaharian.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSetBiayaMasukSekaliActionPerformed

    private void btnPaketOperasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaketOperasiActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgJnsPerawatanOperasi produsen = new DlgJnsPerawatanOperasi(this, false);
        produsen.emptTeks();
        produsen.isCek();
        produsen.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        produsen.setLocationRelativeTo(PanelUtama);
        produsen.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPaketOperasiActionPerformed

    private void btnTagihanOperasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTagihanOperasiActionPerformed
        isTutup();
        DlgCariTagihanOperasi produsen = new DlgCariTagihanOperasi(this, false);
        produsen.isCek();
        produsen.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        produsen.setLocationRelativeTo(PanelUtama);
        produsen.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnTagihanOperasiActionPerformed

    private void BtnJadwalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnJadwalActionPerformed
        isTutup();
        DlgJadwal jadwal = new DlgJadwal(this, false);
        jadwal.emptTeks();
        jadwal.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        jadwal.setLocationRelativeTo(PanelUtama);
        jadwal.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnJadwalActionPerformed

    private void btnMerkInventarisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMerkInventarisActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        InventarisMerk ktginventaris = new InventarisMerk(this, false);
        ktginventaris.tampil();
        ktginventaris.isCek();
        ktginventaris.emptTeks();
        ktginventaris.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        ktginventaris.setLocationRelativeTo(PanelUtama);
        ktginventaris.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMerkInventarisActionPerformed

    private void btnRuangInventarisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRuangInventarisActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        InventarisRuang ktginventaris = new InventarisRuang(this, false);
        ktginventaris.tampil();
        ktginventaris.isCek();
        ktginventaris.emptTeks();
        ktginventaris.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        ktginventaris.setLocationRelativeTo(PanelUtama);
        ktginventaris.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRuangInventarisActionPerformed

    private void btnBarangInventarisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarangInventarisActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        InventarisBarang ktginventaris = new InventarisBarang(this, false);
        ktginventaris.tampil();
        ktginventaris.isCek();
        ktginventaris.emptTeks();
        ktginventaris.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        ktginventaris.setLocationRelativeTo(PanelUtama);
        ktginventaris.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnBarangInventarisActionPerformed

    private void btnInventarisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarisActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        InventarisKoleksi ktginventaris = new InventarisKoleksi(this, false);
        ktginventaris.tampil();
        ktginventaris.isCek();
        ktginventaris.emptTeks();
        ktginventaris.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        ktginventaris.setLocationRelativeTo(PanelUtama);
        ktginventaris.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnInventarisActionPerformed

    private void btnSirkulasiInventarisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSirkulasiInventarisActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        InventarisSirkulasi ktginventaris = new InventarisSirkulasi(this, false);
        ktginventaris.tampil();
        ktginventaris.isCek();
        ktginventaris.emptTeks();
        ktginventaris.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        ktginventaris.setLocationRelativeTo(PanelUtama);
        ktginventaris.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSirkulasiInventarisActionPerformed

    private void btnFrekuensiRalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFrekuensiRalanActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgFrekuensiPenyakitRalan ktginventaris = new DlgFrekuensiPenyakitRalan(this, false);
        ktginventaris.isCek();
        ktginventaris.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        ktginventaris.setLocationRelativeTo(PanelUtama);
        ktginventaris.setVisible(true);
        ktginventaris.UserValid();
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnFrekuensiRalanActionPerformed

    private void btnFrekuensiRanapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFrekuensiRanapActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgFrekuensiPenyakitRanap ktginventaris = new DlgFrekuensiPenyakitRanap(this, false);
        ktginventaris.isCek();
        ktginventaris.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        ktginventaris.setLocationRelativeTo(PanelUtama);
        ktginventaris.setVisible(true);
        ktginventaris.UserValid();
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnFrekuensiRanapActionPerformed

    private void btnSetupOtoLokasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetupOtoLokasiActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSetOtoLokasi ktginventaris = new DlgSetOtoLokasi(this, false);
        ktginventaris.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        ktginventaris.setLocationRelativeTo(PanelUtama);
        ktginventaris.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSetupOtoLokasiActionPerformed

    private void btnRujukMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRujukMasukActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRujukMasuk rujukmasuk = new DlgRujukMasuk(null, false);
        rujukmasuk.tampil();
        rujukmasuk.emptTeks();
        rujukmasuk.isCek();
        rujukmasuk.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        rujukmasuk.setLocationRelativeTo(PanelUtama);
        rujukmasuk.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRujukMasukActionPerformed

    private void btnTrackerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrackerActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPenelusuranLogin rbpoli = new DlgPenelusuranLogin(this, false);
        rbpoli.isCek();
        rbpoli.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        rbpoli.setLocationRelativeTo(PanelUtama);
        rbpoli.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnTrackerActionPerformed

    private void btnTindakanRanapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTindakanRanapActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgJnsPerawatanRanap perawatan=new DlgJnsPerawatanRanap(null,false);
        perawatan.emptTeks();
        perawatan.isCek();
        perawatan.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        perawatan.setLocationRelativeTo(PanelUtama);
        perawatan.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnTindakanRanapActionPerformed

    private void btnSetupJamInapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetupJamInapActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSetKamarInap form = new DlgSetKamarInap(this, false);
        form.tampil();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSetupJamInapActionPerformed

    private void btnStokObatPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStokObatPasienActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgStokPasien opname = new DlgStokPasien(this, false);
        opname.isCek();
        opname.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        opname.setLocationRelativeTo(PanelUtama);
        opname.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnStokObatPasienActionPerformed

    private void btnTarifLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTarifLabActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgJnsPerawatanLab tariflab = new DlgJnsPerawatanLab(this, false);
        tariflab.emptTeks();
        tariflab.isCek();
        tariflab.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        tariflab.setLocationRelativeTo(PanelUtama);
        tariflab.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnTarifLabActionPerformed

    private void btnSetPenjabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetPenjabActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSetPenjabLab aplikasi = new DlgSetPenjabLab(this, false);
        aplikasi.emptTeks();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSetPenjabActionPerformed

    private void btnReturPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturPasienActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgReturObatPasien returpasien = new DlgReturObatPasien(this, false);
        returpasien.isCek();
        returpasien.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        returpasien.setLocationRelativeTo(PanelUtama);
        returpasien.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnReturPasienActionPerformed

    private void btnKeuntunganObatRanapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeuntunganObatRanapActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgProyeksiBeriObat projul = new DlgProyeksiBeriObat(this, false);
        projul.isCek();
        projul.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        projul.setLocationRelativeTo(PanelUtama);
        projul.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnKeuntunganObatRanapActionPerformed

    private void btnPenggajianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenggajianActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPegawai pegawai = new DlgPegawai(this, false);
        pegawai.ChkInput.setSelected(true);
        pegawai.isForm();
        pegawai.isCek();
        pegawai.emptTeks();
        pegawai.TCari.setText("");
        pegawai.TCari.requestFocus();
        pegawai.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        pegawai.setLocationRelativeTo(PanelUtama);
        pegawai.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPenggajianActionPerformed

    private void btnDepositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDepositActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgDeposit deposit = new DlgDeposit(this, false);
        deposit.tampil();
        deposit.isCek();
        deposit.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        deposit.setLocationRelativeTo(PanelUtama);
        deposit.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnDepositActionPerformed

    private void btnSetupRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetupRMActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSetRM aplikasi = new DlgSetRM(this, false);
        aplikasi.emptTeks();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSetupRMActionPerformed

    private void btnResepPulangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResepPulangActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgResepPulang reseppulang = new DlgResepPulang(this, false);
        reseppulang.tampil();
        reseppulang.isCek();
        reseppulang.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        reseppulang.setLocationRelativeTo(PanelUtama);
        reseppulang.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnResepPulangActionPerformed

    private void btnSetupTarifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetupTarifActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSetTarif aplikasi = new DlgSetTarif(this, false);
        aplikasi.emptTeks();
        aplikasi.tampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSetupTarifActionPerformed

    private void btnToolLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToolLabActionPerformed
        isTutup();
        FlayMenu.removeAll();
        FlayMenu.add(btnPermintaanLab);
        FlayMenu.add(btnLaboratorium);
        btnPermintaanLab.setEnabled(akses.getperiksa_lab());
        btnLaboratorium.setEnabled(akses.getperiksa_lab());
        FlayMenu.setVisible(true);
    }//GEN-LAST:event_btnToolLabActionPerformed

    private void MnTarifKamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnTarifKamarActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgHome.dispose();
        InformasiKamar belum = new InformasiKamar(this, true);
        belum.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        belum.setLocationRelativeTo(PanelUtama);
        belum.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_MnTarifKamarActionPerformed

    private void MnPasienRanapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnPasienRanapActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgHome.dispose();
        InformasiKamarInap informasikamar = new InformasiKamarInap(this, false);
        informasikamar.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        informasikamar.setLocationRelativeTo(PanelUtama);
        informasikamar.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_MnPasienRanapActionPerformed

    private void MnJadwalDokterRalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnJadwalDokterRalanActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgHome.dispose();
        InformasiJadwal belum = new InformasiJadwal(this, true);
        belum.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        belum.setLocationRelativeTo(PanelUtama);
        belum.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_MnJadwalDokterRalanActionPerformed

    private void MnTarifRalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnTarifRalanActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgHome.dispose();
        InformasiTarifRalan belum = new InformasiTarifRalan(this, true);
        belum.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        belum.setLocationRelativeTo(PanelUtama);
        belum.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_MnTarifRalanActionPerformed

    private void MnTarifLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnTarifLabActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgHome.dispose();
        InformasiTarifLab belum = new InformasiTarifLab(this, true);
        belum.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        belum.setLocationRelativeTo(PanelUtama);
        belum.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_MnTarifLabActionPerformed

    private void MnTarifOperasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnTarifOperasiActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgHome.dispose();
        InformasiTarifOperasi belum = new InformasiTarifOperasi(this, true);
        belum.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        belum.setLocationRelativeTo(PanelUtama);
        belum.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_MnTarifOperasiActionPerformed

    private void MnTarifRanapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnTarifRanapActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgHome.dispose();
        InformasiTarifRanap belum = new InformasiTarifRanap(this, true);
        belum.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        belum.setLocationRelativeTo(PanelUtama);
        belum.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_MnTarifRanapActionPerformed

    private void btnBarangIpsrsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarangIpsrsActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgBarangIPSRS ipsrs = new DlgBarangIPSRS(this, false);
        ipsrs.emptTeks();
        ipsrs.onCari();
        ipsrs.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        ipsrs.setLocationRelativeTo(PanelUtama);
        ipsrs.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnBarangIpsrsActionPerformed

    private void btnPembelianIpsrsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPembelianIpsrsActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPembelianIPSRS pembelian = new DlgPembelianIPSRS(this, false);
        pembelian.isCek();
        pembelian.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        pembelian.setLocationRelativeTo(PanelUtama);
        pembelian.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPembelianIpsrsActionPerformed

    private void btnPengeluaranIpsrsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPengeluaranIpsrsActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPengeluaranIPSRS pengeluaran = new DlgPengeluaranIPSRS(this, false);
        pengeluaran.isCek();
        pengeluaran.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        pengeluaran.setLocationRelativeTo(PanelUtama);
        pengeluaran.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPengeluaranIpsrsActionPerformed

    private void btnRHMasukIpsrsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRHMasukIpsrsActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRHPembelianIPSRS rhipsrs = new DlgRHPembelianIPSRS(this, false);
        rhipsrs.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        rhipsrs.setLocationRelativeTo(PanelUtama);
        rhipsrs.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRHMasukIpsrsActionPerformed

    private void btnRHKeluarIpsrsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRHKeluarIpsrsActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRHPengeluaranIPSRS rhkeluaripsrs = new DlgRHPengeluaranIPSRS(this, false);
        rhkeluaripsrs.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        rhkeluaripsrs.setLocationRelativeTo(PanelUtama);
        rhkeluaripsrs.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRHKeluarIpsrsActionPerformed

    private void btnRBiayaIpsrsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRBiayaIpsrsActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRBiayaHarianIPSRS rhkeluaripsrs = new DlgRBiayaHarianIPSRS(this, false);
        rhkeluaripsrs.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        rhkeluaripsrs.setLocationRelativeTo(PanelUtama);
        rhkeluaripsrs.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRBiayaIpsrsActionPerformed

    private void btnTarifRadiologiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTarifRadiologiActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgJnsPerawatanRadiologi tarifrad = new DlgJnsPerawatanRadiologi(this, false);
        tarifrad.emptTeks();
        tarifrad.isCek();
        tarifrad.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        tarifrad.setLocationRelativeTo(PanelUtama);
        tarifrad.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnTarifRadiologiActionPerformed

    private void MnTarifRadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnTarifRadActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgHome.dispose();
        InformasiTarifRadiologi belum = new InformasiTarifRadiologi(this, false);
        belum.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        belum.setLocationRelativeTo(PanelUtama);
        belum.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_MnTarifRadActionPerformed

    private void btnPeriksaRadiologiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriksaRadiologiActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        isTutup();
        DlgCariPeriksaRadiologi produsen = new DlgCariPeriksaRadiologi(this, false);
        //produsen.emptTeks();
        produsen.isCek();
        produsen.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        produsen.setLocationRelativeTo(PanelUtama);
        produsen.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPeriksaRadiologiActionPerformed

    private void btnToolIGDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToolIGDActionPerformed
        btnIGDActionPerformed(evt);
    }//GEN-LAST:event_btnToolIGDActionPerformed

    private void btnSetupEmbalaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetupEmbalaseActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSetEmbalase ktginventaris = new DlgSetEmbalase(this, false);
        ktginventaris.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        ktginventaris.setLocationRelativeTo(PanelUtama);
        ktginventaris.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSetupEmbalaseActionPerformed

    private void btnPemesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPemesananActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPemesanan pembelian = new DlgPemesanan(this, false);
        pembelian.isCek();
        pembelian.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        pembelian.setLocationRelativeTo(PanelUtama);
        pembelian.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPemesananActionPerformed

    private void btnPengeluaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPengeluaranActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPengeluaranHarian pembelian = new DlgPengeluaranHarian(this, false);
        pembelian.emptTeks();
        pembelian.isCek();
        pembelian.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        pembelian.setLocationRelativeTo(PanelUtama);
        pembelian.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPengeluaranActionPerformed

    private void btnTambahanBiayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahanBiayaActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgDetailTambahan pembelian = new DlgDetailTambahan(this, false);
        pembelian.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        pembelian.setLocationRelativeTo(PanelUtama);
        pembelian.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnTambahanBiayaActionPerformed

    private void btnPotonganBiayaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPotonganBiayaActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgDetailPotongan pembelian = new DlgDetailPotongan(this, false);
        pembelian.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        pembelian.setLocationRelativeTo(PanelUtama);
        pembelian.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPotonganBiayaActionPerformed

    private void btnIGDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIGDActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));              
        igd.emptTeks();
        igd.isCek();
        igd.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        igd.setLocationRelativeTo(PanelUtama);
        igd.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnIGDActionPerformed

    private void btnToolRadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToolRadActionPerformed
        isTutup();
        FlayMenu.removeAll();
        FlayMenu.add(btnPermintaanRadiologi);
        FlayMenu.add(btnPeriksaRadiologi);
        btnPermintaanRadiologi.setEnabled(akses.getperiksa_radiologi());
        btnPeriksaRadiologi.setEnabled(akses.getperiksa_radiologi());
        FlayMenu.setVisible(true);
    }//GEN-LAST:event_btnToolRadActionPerformed

    private void btnSetObatRalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetObatRalanActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSetHargaObatRalan aplikasi = new DlgSetHargaObatRalan(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSetObatRalanActionPerformed

    private void btnSetObatRanapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetObatRanapActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSetHargaObatRanap aplikasi = new DlgSetHargaObatRanap(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSetObatRanapActionPerformed

    private void btnPenyakitPD3IActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenyakitPD3IActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPenyakitPd3i aplikasi = new DlgPenyakitPd3i(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPenyakitPD3IActionPerformed

    private void btnSurveilansPD3IActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSurveilansPD3IActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgDkkSurveilansPD3I aplikasi = new DlgDkkSurveilansPD3I(this, false);
        aplikasi.tampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSurveilansPD3IActionPerformed

    private void btnSurveilansRalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSurveilansRalanActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgDkkSurveilansRalan aplikasi = new DlgDkkSurveilansRalan(this, false);
        aplikasi.tampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSurveilansRalanActionPerformed

    private void btnDiagnosaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiagnosaActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgDiagnosaPenyakit diagnosa = new DlgDiagnosaPenyakit(null, false);
        diagnosa.tampilDiagStatistik();
        diagnosa.tampilDiagInadrg();
        diagnosa.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        diagnosa.setLocationRelativeTo(PanelUtama);
        diagnosa.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnDiagnosaActionPerformed

    private void btnSurveilansRanapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSurveilansRanapActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgDkkSurveilansRanap aplikasi = new DlgDkkSurveilansRanap(this, false);
        aplikasi.tampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSurveilansRanapActionPerformed

    private void btnPnyTakMenularRanapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPnyTakMenularRanapActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgDkkPenyakitTidakMenularRanap aplikasi = new DlgDkkPenyakitTidakMenularRanap(this, false);
        aplikasi.tampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPnyTakMenularRanapActionPerformed

    private void btnPnyTakMenularRalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPnyTakMenularRalanActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgDkkPenyakitTidakMenularRalan aplikasi = new DlgDkkPenyakitTidakMenularRalan(this, false);
        aplikasi.tampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPnyTakMenularRalanActionPerformed

    private void btnKunjunganRalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKunjunganRalanActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgKunjunganRalan aplikasi = new DlgKunjunganRalan(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        aplikasi.UserValid();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnKunjunganRalanActionPerformed

    private void btnRl32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRl32ActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRl32 aplikasi = new DlgRl32(this, false);
        aplikasi.tampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRl32ActionPerformed

    private void btnRl33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRl33ActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRl33 aplikasi = new DlgRl33(this, false);
        aplikasi.tampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRl33ActionPerformed

    private void btnRl37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRl37ActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRl37 aplikasi = new DlgRl37(this, false);
        aplikasi.tampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRl37ActionPerformed

    private void btnRl38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRl38ActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRl38 aplikasi = new DlgRl38(this, false);
        aplikasi.tampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRl38ActionPerformed

    private void btnBridgingEklaimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBridgingEklaimActionPerformed
        isTutup();
        FlayMenu.removeAll();
        FlayMenu.add(btnBridgingEklaimINACBG);
        FlayMenu.add(btnINACBGjknBelumDiklaim);
        btnBridgingEklaimINACBG.setEnabled(akses.getinacbg_klaim_raza());
        btnINACBGjknBelumDiklaim.setEnabled(akses.getjkn_belum_diproses_klaim());
        FlayMenu.setVisible(true);
    }//GEN-LAST:event_btnBridgingEklaimActionPerformed

    private void btnSetupNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetupNotaActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSetNota aplikasi = new DlgSetNota(this, false);
        aplikasi.emptTeks();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSetupNotaActionPerformed

    private void BtnDpjpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDpjpActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgDpjp aplikasi = new DlgDpjp(this, false);
        aplikasi.isCek();
        aplikasi.tampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_BtnDpjpActionPerformed

    private void btnMutasiBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMutasiBarangActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgMutasiBarang aplikasi = new DlgMutasiBarang(this, false);
        aplikasi.isCek();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMutasiBarangActionPerformed

    private void MnPenggunaanKamarRanapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnPenggunaanKamarRanapActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgHome.dispose();
        InformasiAnalisaKamin analisakamin = new InformasiAnalisaKamin(this, false);
        analisakamin.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        analisakamin.setLocationRelativeTo(PanelUtama);
        analisakamin.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_MnPenggunaanKamarRanapActionPerformed

    private void btnRl34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRl34ActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRl34 aplikasi = new DlgRl34(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        aplikasi.fokus();
        aplikasi.tampil();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRl34ActionPerformed

    private void btnRl36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRl36ActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRl36 aplikasi = new DlgRl36(this, false);
        aplikasi.tampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRl36ActionPerformed

    private void btnfee_visit_dokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfee_visit_dokterActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgFeeVisitDokter feevisitdokter = new DlgFeeVisitDokter(this, false);
        feevisitdokter.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        feevisitdokter.setLocationRelativeTo(PanelUtama);
        feevisitdokter.setVisible(true);
        feevisitdokter.empttext();
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnfee_visit_dokterActionPerformed

    private void btnakun_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnakun_bayarActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgAkunBayar feeperiksaralan = new DlgAkunBayar(this, false);
        feeperiksaralan.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        feeperiksaralan.setLocationRelativeTo(PanelUtama);
        feeperiksaralan.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnakun_bayarActionPerformed

    private void btnbayar_pemesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbayar_pemesananActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgBayarPemesanan bayarpesan = new DlgBayarPemesanan(this, false);
        bayarpesan.tampil();
        bayarpesan.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        bayarpesan.setLocationRelativeTo(PanelUtama);
        bayarpesan.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnbayar_pemesananActionPerformed

    private void btnJenisIpsrsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJenisIpsrsActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgJenisIPSRS aplikasi = new DlgJenisIPSRS(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnJenisIpsrsActionPerformed

    private void btnPemasukanLainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPemasukanLainActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPemasukanLain aplikasi = new DlgPemasukanLain(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPemasukanLainActionPerformed

    private void btnPengaturanRekeningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPengaturanRekeningActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPengaturanRekening aplikasi = new DlgPengaturanRekening(this, false);
        aplikasi.isCek();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPengaturanRekeningActionPerformed

    private void btnClosingKasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClosingKasirActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        isTutup();
        DlgClosingKasir ckas = new DlgClosingKasir(this, false);
        ckas.isCek();
        ckas.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        ckas.setLocationRelativeTo(PanelUtama);
        ckas.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnClosingKasirActionPerformed

    private void btnKeterlambatanPresensiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeterlambatanPresensiActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSetKeterlambatan keterlambatan = new DlgSetKeterlambatan(this, false);
        keterlambatan.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        keterlambatan.setLocationRelativeTo(PanelUtama);
        keterlambatan.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnKeterlambatanPresensiActionPerformed

    private void btnSetHargaKamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetHargaKamarActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSetHargaKamar hargakamar = new DlgSetHargaKamar(this, false);
        hargakamar.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        hargakamar.setLocationRelativeTo(PanelUtama);
        hargakamar.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSetHargaKamarActionPerformed

    private void btnRekapPershiftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRekapPershiftActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRekapPerShift aplikasi = new DlgRekapPerShift(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRekapPershiftActionPerformed

    private void btnCekBPJSNikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekBPJSNikActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekNIK2 form = new BPJSCekNIK2(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekBPJSNikActionPerformed

    private void btnCekBPJSKartuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekBPJSKartuActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekKartu form = new BPJSCekKartu(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekBPJSKartuActionPerformed

    private void btnObatPerCaraBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObatPerCaraBayarActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRBObatPercaraBayar rbpoli = new DlgRBObatPercaraBayar(this, false);
        rbpoli.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        rbpoli.setLocationRelativeTo(PanelUtama);
        rbpoli.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnObatPerCaraBayarActionPerformed

    private void btnKunjunganRanapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKunjunganRanapActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgKunjunganRanap aplikasi = new DlgKunjunganRanap(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        aplikasi.UserValid();
        aplikasi.tampil();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnKunjunganRanapActionPerformed

    private void btnPaymentPointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentPointActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPaymentPoint aplikasi = new DlgPaymentPoint(this, false);
        aplikasi.tampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPaymentPointActionPerformed

    private void btnCekBPJSNomorRujukanPCareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekBPJSNomorRujukanPCareActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekNoRujukanPCare form = new BPJSCekNoRujukanPCare(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekBPJSNomorRujukanPCareActionPerformed

    private void btnICD9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnICD9ActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgICD9 aplikasi = new DlgICD9(this, false);
        aplikasi.emptTeks();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnICD9ActionPerformed

    private void btnDaruratStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaruratStokActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgDaruratStok aplikasi = new DlgDaruratStok(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnDaruratStokActionPerformed

    private void btnJurnalHarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJurnalHarianActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgJurnalHarian jh = new DlgJurnalHarian(this, false);
        jh.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        jh.setLocationRelativeTo(PanelUtama);
        jh.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnJurnalHarianActionPerformed

    private void btnSirkulasi2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSirkulasi2ActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSirkulasiBarang2 sirkulasi = new DlgSirkulasiBarang2(this, false);
        sirkulasi.isCek();
        sirkulasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        sirkulasi.setLocationRelativeTo(PanelUtama);
        sirkulasi.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSirkulasi2ActionPerformed

    private void btnCekBPJSDiagnosaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekBPJSDiagnosaActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekReferensiPenyakit form = new BPJSCekReferensiPenyakit(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekBPJSDiagnosaActionPerformed

    private void btnCekBPJSPoliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekBPJSPoliActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekReferensiPoli form = new BPJSCekReferensiPoli(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekBPJSPoliActionPerformed

    private void btnIndustriFarmasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIndustriFarmasiActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgIndustriFarmasi suplier = new DlgIndustriFarmasi(this, false);
        suplier.isCek();
        suplier.emptTeks();
        suplier.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        suplier.setLocationRelativeTo(PanelUtama);
        suplier.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnIndustriFarmasiActionPerformed

    private void btnPiutangBelumLunasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPiutangBelumLunasActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPiutangBelumLunas rbpaketbhp = new DlgPiutangBelumLunas(this, false);
        rbpaketbhp.tampil();
        rbpaketbhp.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        rbpaketbhp.setLocationRelativeTo(PanelUtama);
        rbpaketbhp.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPiutangBelumLunasActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        Window[] wins = Window.getWindows();
        for (Window win : wins) {
            if (win instanceof JDialog) {
                DlgHome.setSize(PanelUtama.getWidth() - 45, PanelUtama.getHeight() - 45);
                Panelmenu.repaint();
                DlgHome.setLocationRelativeTo(PanelUtama);
            }
        }
    }//GEN-LAST:event_formComponentResized

    private void formComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentMoved
        Window[] wins = Window.getWindows();
        for (Window win : wins) {
            if (win instanceof JDialog) {
                win.setLocationRelativeTo(PanelUtama);
                win.toFront();
            }
        }

        setToolbar();
    }//GEN-LAST:event_formComponentMoved

    private void BtnToolJualObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnToolJualObatActionPerformed
        isTutup();
        FlayMenu.removeAll();
        FlayMenu.add(btnInputPenjualan);
        FlayMenu.add(btnDataPenjualan);
        FlayMenu.add(btnDataPenyerahanDarah);
        FlayMenu.add(btnDaftarPermintaanResep);
        btnInputPenjualan.setEnabled(akses.getpenjualan_obat());
        btnDataPenjualan.setEnabled(akses.getpenjualan_obat());
        btnDataPenyerahanDarah.setEnabled(akses.getutd_penyerahan_darah());
        btnDaftarPermintaanResep.setEnabled(akses.getresep_dokter());
        FlayMenu.setVisible(true);
    }//GEN-LAST:event_BtnToolJualObatActionPerformed

    private void PanelWallMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelWallMouseMoved
        setToolbar();
        Window[] wins = Window.getWindows();
        for (Window win : wins) {
            if (win instanceof JDialog) {
                win.setLocationRelativeTo(PanelUtama);
                win.toFront();
            }
        }

    }//GEN-LAST:event_PanelWallMouseMoved

    private void btnCekBPJSFaskesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekBPJSFaskesActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekReferensiFaskes form = new BPJSCekReferensiFaskes(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekBPJSFaskesActionPerformed

    private void btnBPJSSEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBPJSSEPActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSDataSEP form = new BPJSDataSEP(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        form.emptTeks();
        form.isCek();
        form.cekLAYAN();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnBPJSSEPActionPerformed

    private void btnPengambilanUTDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPengambilanUTDActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPengambilanUTD form = new DlgPengambilanUTD(this, false);
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPengambilanUTDActionPerformed

    private void btnTarifUtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTarifUtdActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgJnsPerawatanUTD tarifutd = new DlgJnsPerawatanUTD(this, false);
        tarifutd.emptTeks();
        tarifutd.isCek();
        tarifutd.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        tarifutd.setLocationRelativeTo(PanelUtama);
        tarifutd.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnTarifUtdActionPerformed

    private void btnPengambilanUTD2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPengambilanUTD2ActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgCariPengambilanUTD form = new DlgCariPengambilanUTD(this, false);
        form.setHapus();
        form.tampil();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPengambilanUTD2ActionPerformed

    private void btnUTDMedisRusakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUTDMedisRusakActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        UTDMedisRusak form = new UTDMedisRusak(this, false);
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnUTDMedisRusakActionPerformed

    private void btnPengambilanPenunjangUTDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPengambilanPenunjangUTDActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPengambilanPenunjangUTD form = new DlgPengambilanPenunjangUTD(this, false);
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPengambilanPenunjangUTDActionPerformed

    private void btnPengambilanPenunjangUTD2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPengambilanPenunjangUTD2ActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgCariPengambilanPenunjangUTD form = new DlgCariPengambilanPenunjangUTD(this, false);
        form.setHapus();
        form.tampil();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPengambilanPenunjangUTD2ActionPerformed

    private void btnUTDPenunjangRusakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUTDPenunjangRusakActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        UTDPenunjangRusak form = new UTDPenunjangRusak(this, false);
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnUTDPenunjangRusakActionPerformed

    private void btnSuplierIPSRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuplierIPSRSActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSuplierIPSRS suplier = new DlgSuplierIPSRS(this, false);
        suplier.isCek();
        suplier.emptTeks();
        suplier.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        suplier.setLocationRelativeTo(PanelUtama);
        suplier.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSuplierIPSRSActionPerformed

    private void btnUTDDonorDarahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUTDDonorDarahActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        UTDDonor form = new UTDDonor(this, false);
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnUTDDonorDarahActionPerformed

    private void btnMonitoringKlaimBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonitoringKlaimBPJSActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSMonitoringKlaim form = new BPJSMonitoringKlaim(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        form.emptTeks();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMonitoringKlaimBPJSActionPerformed

    private void btnUTDCekalDarahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUTDCekalDarahActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        UTDCekalDarah form = new UTDCekalDarah(this, false);
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnUTDCekalDarahActionPerformed

    private void btnUTDKomponenDarahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUTDKomponenDarahActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        UTDKomponenDarah form = new UTDKomponenDarah(this, false);
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnUTDKomponenDarahActionPerformed

    private void btnUTDStokDarahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUTDStokDarahActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        UTDStokDarah form = new UTDStokDarah(this, false);
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnUTDStokDarahActionPerformed

    private void btnUTDPemisahanDarahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUTDPemisahanDarahActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        UTDPemisahanDarah form = new UTDPemisahanDarah(this, false);
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnUTDPemisahanDarahActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setToolbar();
    }//GEN-LAST:event_formWindowOpened

    private void btnRincianPiutangPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRincianPiutangPasienActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRincianPiutangPasien billing = new DlgRincianPiutangPasien(this, false);
        billing.tampil();
        billing.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        billing.setLocationRelativeTo(PanelUtama);
        billing.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRincianPiutangPasienActionPerformed

    private void btnKeuntunganObat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeuntunganObat2ActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgProyeksiBeriObat2 projul = new DlgProyeksiBeriObat2(this, false);
        projul.isCek();
        projul.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        projul.setLocationRelativeTo(PanelUtama);
        projul.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnKeuntunganObat2ActionPerformed

    private void btnUTDPenyerahanDarahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUTDPenyerahanDarahActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        UTDPenyerahanDarah form = new UTDPenyerahanDarah(this, false);
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnUTDPenyerahanDarahActionPerformed

    private void btnHutangObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHutangObatActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgHutangObatBelumLunas form = new DlgHutangObatBelumLunas(this, false);
        form.tampil();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnHutangObatActionPerformed

    private void btnRiwayatBarangMedisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRiwayatBarangMedisActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRiwayatBarangMedis sirkulasi = new DlgRiwayatBarangMedis(this, false);
        sirkulasi.isCek();
        sirkulasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        sirkulasi.setLocationRelativeTo(PanelUtama);
        sirkulasi.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRiwayatBarangMedisActionPerformed

    private void btnInputPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInputPenjualanActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPenjualan penjualan = new DlgPenjualan(this, false);
        penjualan.isCek();
        penjualan.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        penjualan.setLocationRelativeTo(PanelUtama);
        penjualan.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnInputPenjualanActionPerformed

    private void btnDataPenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataPenjualanActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgCariPenjualan penjualan = new DlgCariPenjualan(this, false);
        penjualan.emptTeks();
        penjualan.isCek();
        penjualan.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        penjualan.setLocationRelativeTo(PanelUtama);
        penjualan.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnDataPenjualanActionPerformed

    private void btnDataPenyerahanDarahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataPenyerahanDarahActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        UTDCariPenyerahanDarah carijual = new UTDCariPenyerahanDarah(null, false);
        carijual.emptTeks();
        carijual.isCek();
        carijual.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        carijual.setLocationRelativeTo(PanelUtama);
        carijual.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnDataPenyerahanDarahActionPerformed

    private void btnSensusHarianPoliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSensusHarianPoliActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSensusHarianPoli aplikasi = new DlgSensusHarianPoli(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        aplikasi.UserValid();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSensusHarianPoliActionPerformed

    private void btnRl4aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRl4aActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRL4A aplikasi = new DlgRL4A(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRl4aActionPerformed

    private void btnAplicareReferensiKamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicareReferensiKamarActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        AplicareCekReferensiKamar form = new AplicareCekReferensiKamar(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnAplicareReferensiKamarActionPerformed

    private void btnAplicareKetersediaanKamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAplicareKetersediaanKamarActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        AplicareKetersediaanKamar form = new AplicareKetersediaanKamar(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnAplicareKetersediaanKamarActionPerformed

    private void btnInaCBGCoderNIKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInaCBGCoderNIKActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        INACBGCoderNIK inacbg = new INACBGCoderNIK(this, false);
        inacbg.emptTeks();
        inacbg.isCek();
        inacbg.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        inacbg.setLocationRelativeTo(PanelUtama);
        inacbg.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnInaCBGCoderNIKActionPerformed

    private void btnAkunPiutangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAkunPiutangActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgAkunPiutang form = new DlgAkunPiutang(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnAkunPiutangActionPerformed

    private void btnPiutangRalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPiutangRalanActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPiutangRalan billing = new DlgPiutangRalan(this, false);
        billing.tampil();
        billing.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        billing.setLocationRelativeTo(PanelUtama);
        billing.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPiutangRalanActionPerformed

    private void btnPiutangRanapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPiutangRanapActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPiutangRanap billing = new DlgPiutangRanap(this, false);
        billing.tampil();
        billing.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        billing.setLocationRelativeTo(PanelUtama);
        billing.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPiutangRanapActionPerformed

    private void ChkInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkInputActionPerformed
        if (ChkInput.isSelected() == true) {
            cmbMenu.setVisible(true);
            cmbMenu.requestFocus();
            TCari.setVisible(false);
        } else {
            cmbMenu.setVisible(false);
            TCari.setVisible(true);
            TCari.requestFocus();
        }
        isTampil();
    }//GEN-LAST:event_ChkInputActionPerformed

    private void TCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            isTampil();
        }
    }//GEN-LAST:event_TCariKeyPressed

    private void btnPiutangPerCaraBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPiutangPerCaraBayarActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPiutangPercaraBayar rbpaketbhp = new DlgPiutangPercaraBayar(this, false);
        rbpaketbhp.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        rbpaketbhp.setLocationRelativeTo(PanelUtama);
        rbpaketbhp.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPiutangPerCaraBayarActionPerformed

    private void btnLamaPelayananRalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamaPelayananRalanActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPelayananRalan aplikasi = new DlgPelayananRalan(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        aplikasi.UserValid();
        aplikasi.tampil();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnLamaPelayananRalanActionPerformed

    private void btnCatatanPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatatanPasienActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgLhtCatatanPasien aplikasi = new DlgLhtCatatanPasien(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCatatanPasienActionPerformed

    private void btnRl4bActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRl4bActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRL4B aplikasi = new DlgRL4B(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRl4bActionPerformed

    private void btnRl4asebabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRl4asebabActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRL4ASebab aplikasi = new DlgRL4ASebab(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRl4asebabActionPerformed

    private void btnRl4bsebabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRl4bsebabActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRL4BSebab aplikasi = new DlgRL4BSebab(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRl4bsebabActionPerformed

    private void btnDataHAIsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataHAIsActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgDataHAIs aplikasi = new DlgDataHAIs(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.isCek();
        aplikasi.tampil();
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnDataHAIsActionPerformed

    private void btnHarianHAIsRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHarianHAIsRSActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgHarianHAIs aplikasi = new DlgHarianHAIs(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnHarianHAIsRSActionPerformed

    private void btnBulananHAIsRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBulananHAIsRSActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgBulananHAIs aplikasi = new DlgBulananHAIs(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnBulananHAIsRSActionPerformed

    private void btnPerusahaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerusahaanActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPerusahaan aplikasi = new DlgPerusahaan(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.isCek();
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPerusahaanActionPerformed

    private void btnDaftarPermintaanResepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaftarPermintaanResepActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgDaftarPermintaanResep daftar = new DlgDaftarPermintaanResep(null, false);
        daftar.emptTeks();
        daftar.isCek();
        daftar.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        daftar.setLocationRelativeTo(PanelUtama);
        daftar.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnDaftarPermintaanResepActionPerformed

    private void btnLamaPelayananApotekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamaPelayananApotekActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPelayananApotek aplikasi = new DlgPelayananApotek(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnLamaPelayananApotekActionPerformed

    private void btnGrafikKunjunganPoliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrafikKunjunganPoliActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        GrafikKunjunganPoli aplikasi = new GrafikKunjunganPoli(this, true);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnGrafikKunjunganPoliActionPerformed

    private void btnGrafikKunjunganPerDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrafikKunjunganPerDokterActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        GrafikKunjunganPerDokter aplikasi = new GrafikKunjunganPerDokter(this, true);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnGrafikKunjunganPerDokterActionPerformed

    private void btnGrafikKunjunganPerPekerjaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrafikKunjunganPerPekerjaanActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        GrafikKunjunganPerPekerjaan aplikasi = new GrafikKunjunganPerPekerjaan(this, true);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnGrafikKunjunganPerPekerjaanActionPerformed

    private void btnGrafikKunjunganPerPendidikanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrafikKunjunganPerPendidikanActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        GrafikKunjunganPerPendidikan aplikasi = new GrafikKunjunganPerPendidikan(this, true);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnGrafikKunjunganPerPendidikanActionPerformed

    private void btnGrafikKunjunganPerTahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrafikKunjunganPerTahunActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        GrafikKunjunganPerTahun aplikasi = new GrafikKunjunganPerTahun(this, true);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnGrafikKunjunganPerTahunActionPerformed

    private void btnPnyMenularRanapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPnyMenularRanapActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgDkkPenyakitMenularRanap aplikasi = new DlgDkkPenyakitMenularRanap(this, false);
        aplikasi.tampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPnyMenularRanapActionPerformed

    private void btnPnyMenularRalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPnyMenularRalanActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgDkkPenyakitMenularRalan aplikasi = new DlgDkkPenyakitMenularRalan(this, false);
        aplikasi.tampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPnyMenularRalanActionPerformed

    private void btnGrafikKunjunganPerBulanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrafikKunjunganPerBulanActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        GrafikKunjunganPerBulan aplikasi = new GrafikKunjunganPerBulan(this, true);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnGrafikKunjunganPerBulanActionPerformed

    private void btnGrafikKunjunganPerTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrafikKunjunganPerTanggalActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        GrafikKunjunganPerTanggal aplikasi = new GrafikKunjunganPerTanggal(this, true);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnGrafikKunjunganPerTanggalActionPerformed

    private void btnGrafikDemografiRegistrasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrafikDemografiRegistrasiActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        GrafikDemografiRegistrasi aplikasi = new GrafikDemografiRegistrasi(this, true);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnGrafikDemografiRegistrasiActionPerformed

    private void btnGrafikStatusRegPerTahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrafikStatusRegPerTahunActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        GrafikStatusRegPerTahun aplikasi = new GrafikStatusRegPerTahun(this, true);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnGrafikStatusRegPerTahunActionPerformed

    private void btnGrafikStatusRegPerTahun2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrafikStatusRegPerTahun2ActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        GrafikStatusRegPerTahun2 aplikasi = new GrafikStatusRegPerTahun2(this, true);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnGrafikStatusRegPerTahun2ActionPerformed

    private void btnGrafikStatusRegPerBulanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrafikStatusRegPerBulanActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        GrafikStatusRegPerBulan aplikasi = new GrafikStatusRegPerBulan(this, true);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnGrafikStatusRegPerBulanActionPerformed

    private void btnGrafikStatusRegPerBulan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrafikStatusRegPerBulan2ActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        GrafikStatusRegPerBulan2 aplikasi = new GrafikStatusRegPerBulan2(this, true);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnGrafikStatusRegPerBulan2ActionPerformed

    private void btnGrafikStatusRegPerTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrafikStatusRegPerTanggalActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        GrafikStatusRegPerTanggal aplikasi = new GrafikStatusRegPerTanggal(this, true);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnGrafikStatusRegPerTanggalActionPerformed

    private void btnGrafikStatusRegPerTanggal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrafikStatusRegPerTanggal2ActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        GrafikStatusRegPerTanggal2 aplikasi = new GrafikStatusRegPerTanggal2(this, true);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnGrafikStatusRegPerTanggal2ActionPerformed

    private void btnGrafikStatusRegBatalPerTahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrafikStatusRegBatalPerTahunActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        GrafikStatusBatalRegPerTahun aplikasi = new GrafikStatusBatalRegPerTahun(this, true);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnGrafikStatusRegBatalPerTahunActionPerformed

    private void btnGrafikStatusRegBatalPerBulanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrafikStatusRegBatalPerBulanActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        GrafikStatusBatalRegPerBulan aplikasi = new GrafikStatusBatalRegPerBulan(this, true);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnGrafikStatusRegBatalPerBulanActionPerformed

    private void btnCekPCareDiagnosaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekPCareDiagnosaActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        PCareCekReferensiPenyakit form = new PCareCekReferensiPenyakit(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekPCareDiagnosaActionPerformed

    private void btnGrafikStatusRegBatalPerTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrafikStatusRegBatalPerTanggalActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        GrafikStatusBatalRegPerTanggal aplikasi = new GrafikStatusBatalRegPerTanggal(this, true);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnGrafikStatusRegBatalPerTanggalActionPerformed

    private void btnKategoriBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKategoriBarangActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgKategori form = new DlgKategori(this, false);
        form.isCek();
        form.emptTeks();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnKategoriBarangActionPerformed

    private void btnGolonganBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGolonganBarangActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgGolongan form = new DlgGolongan(this, false);
        form.isCek();
        form.emptTeks();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnGolonganBarangActionPerformed

    private void btnObatPerTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObatPerTanggalActionPerformed
        isTutup();
        DlgObatPerTanggal form = new DlgObatPerTanggal(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnObatPerTanggalActionPerformed

    private void btnPenjualanPerTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenjualanPerTanggalActionPerformed
        isTutup();
        DlgPenjualanPerTanggal form = new DlgPenjualanPerTanggal(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPenjualanPerTanggalActionPerformed

    private void btnSKDPbpjsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSKDPbpjsActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        isTutup();
        DlgSKDPBPJS form = new DlgSKDPBPJS(null, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        form.fokus();
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSKDPbpjsActionPerformed

    private void btnRujukKeluarVclaimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRujukKeluarVclaimActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        isTutup();
        BPJSRujukanKeluar form = new BPJSRujukanKeluar(null, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        form.tampil();
        form.isCek();
        form.TCari.requestFocus();
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRujukKeluarVclaimActionPerformed

    private void btnBookingRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookingRegActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        isTutup();
        DlgBookingRegistrasi form = new DlgBookingRegistrasi(null, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.ChkInput.setSelected(true);
        form.isForm();
        form.setVisible(true);
        form.tampil();
        form.isCek();
        form.TCari.requestFocus();
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnBookingRegActionPerformed

    private void btnBPJScekRiwayatRujukanPcareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBPJScekRiwayatRujukanPcareActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        isTutup();
        BPJSCekRiwayatRujukanPCare form = new BPJSCekRiwayatRujukanPCare(null, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        form.fokus();
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnBPJScekRiwayatRujukanPcareActionPerformed

    private void btnCekBPJSRiwayatRujukanRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekBPJSRiwayatRujukanRSActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekRiwayatRujukanRS form = new BPJSCekRiwayatRujukanRS(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        form.fokus();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekBPJSRiwayatRujukanRSActionPerformed

    private void btnCekBPJSRujukanKartuRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekBPJSRujukanKartuRSActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekRujukanKartuRS form = new BPJSCekRujukanKartuRS(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        form.fokus();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekBPJSRujukanKartuRSActionPerformed

    private void btnCekBPJSTanggalRujukanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekBPJSTanggalRujukanActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekTanggalRujukan form = new BPJSCekTanggalRujukan(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        form.fokus();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekBPJSTanggalRujukanActionPerformed

    private void btnCekBPJSNomorRujukanRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekBPJSNomorRujukanRSActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekNoRujukanRS form = new BPJSCekNoRujukanRS(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        form.fokus();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekBPJSNomorRujukanRSActionPerformed

    private void btnCekBPJSRujukanKartuPCareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekBPJSRujukanKartuPCareActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekRujukanKartuPCare form = new BPJSCekRujukanKartuPCare(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        form.fokus();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekBPJSRujukanKartuPCareActionPerformed

    private void btnCekReferensiKelasRawatBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekReferensiKelasRawatBPJSActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekReferensiKelasRawat form = new BPJSCekReferensiKelasRawat(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        form.Kelas.requestFocus();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekReferensiKelasRawatBPJSActionPerformed

    private void btnCekReferensiProsedurBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekReferensiProsedurBPJSActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekReferensiProsedur form = new BPJSCekReferensiProsedur(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        form.fokus();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekReferensiProsedurBPJSActionPerformed

    private void btnCekReferensiDokterDPJPBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekReferensiDokterDPJPBPJSActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekReferensiDokterDPJP form = new BPJSCekReferensiDokterDPJP(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekReferensiDokterDPJPBPJSActionPerformed

    private void btnCekReferensiDokterBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekReferensiDokterBPJSActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekReferensiDokter form = new BPJSCekReferensiDokter(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        form.fokus();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekReferensiDokterBPJSActionPerformed

    private void btnCekReferensiSpesialistikBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekReferensiSpesialistikBPJSActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekReferensiSpesialistik form = new BPJSCekReferensiSpesialistik(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        form.fokus();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekReferensiSpesialistikBPJSActionPerformed

    private void btnCekReferensiRuangRawatBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekReferensiRuangRawatBPJSActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekReferensiRuangRawat form = new BPJSCekReferensiRuangRawat(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        form.fokus();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekReferensiRuangRawatBPJSActionPerformed

    private void btnCekReferensiCaraKeluarBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekReferensiCaraKeluarBPJSActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekReferensiCaraKeluar form = new BPJSCekReferensiCaraKeluar(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        form.fokus();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekReferensiCaraKeluarBPJSActionPerformed

    private void btnCekReferensiPascaPulangBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekReferensiPascaPulangBPJSActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekReferensiPascaPulang form = new BPJSCekReferensiPascaPulang(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        form.fokus();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekReferensiPascaPulangBPJSActionPerformed

    private void btnCekReferensiPropinsiBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekReferensiPropinsiBPJSActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekReferensiPropinsi form = new BPJSCekReferensiPropinsi(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        form.fokus();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekReferensiPropinsiBPJSActionPerformed

    private void btnCekReferensiKabupatenBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekReferensiKabupatenBPJSActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekReferensiKabupaten form = new BPJSCekReferensiKabupaten(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekReferensiKabupatenBPJSActionPerformed

    private void btnCekReferensiKecamatanBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekReferensiKecamatanBPJSActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekReferensiKecamatan form = new BPJSCekReferensiKecamatan(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekReferensiKecamatanBPJSActionPerformed

    private void btnPermintaanLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPermintaanLabActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgCariPermintaanLab form=new DlgCariPermintaanLab(this,false);
        form.isCek("");        
        form.setSize(PanelUtama.getWidth(),PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPermintaanLabActionPerformed

    private void btnPermintaanRadiologiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPermintaanRadiologiActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgCariPermintaanRadiologi form=new DlgCariPermintaanRadiologi(this,false);
        form.isCek();
        form.setSize(PanelUtama.getWidth(),PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPermintaanRadiologiActionPerformed

    private void btnJumlahPorsiDietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJumlahPorsiDietActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgJumlahPorsiDiet aplikasi = new DlgJumlahPorsiDiet(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnJumlahPorsiDietActionPerformed

    private void btnJumlahMacamDietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJumlahMacamDietActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgJumlahMacamDiet aplikasi = new DlgJumlahMacamDiet(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnJumlahMacamDietActionPerformed

    private void btnMasterFaskesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterFaskesActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgMasterFaskes aplikasi = new DlgMasterFaskes(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.tampil();
        aplikasi.emptTeks();
        aplikasi.TCari.requestFocus();
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMasterFaskesActionPerformed

    private void MnTarifINACBGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnTarifINACBGActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgHome.dispose();
        InformasiTarifINACBG belum = new InformasiTarifINACBG(this, true);
        belum.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        belum.setLocationRelativeTo(PanelUtama);
        belum.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_MnTarifINACBGActionPerformed

    private void MnTelusurKunjunganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnTelusurKunjunganActionPerformed
        if (akses.getkode().equals("Admin Utama") || (akses.gettelusurpasien())) {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            DlgHome.dispose();
            InformasiTelusurKunjunganPasien telusur = new InformasiTelusurKunjunganPasien(this, true);
            telusur.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
            telusur.setLocationRelativeTo(PanelUtama);
            telusur.setVisible(true);
            telusur.TCari.setText("");
            telusur.TCari.requestFocus();
            this.setCursor(Cursor.getDefaultCursor());
        } else {
            JOptionPane.showMessageDialog(null, "Hanya untuk petugas yang memiliki hak akses saja bisa membuka fitur ini...!!!!");
        }
    }//GEN-LAST:event_MnTelusurKunjunganActionPerformed

    private void btnCekSisruteFaskesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekSisruteFaskesActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        SisruteCekReferensiFaskes form = new SisruteCekReferensiFaskes(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        form.tcari.requestFocus();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekSisruteFaskesActionPerformed

    private void btnCekSisruteAlasanRujukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekSisruteAlasanRujukActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        SisruteCekReferensiAlasanRujuk form = new SisruteCekReferensiAlasanRujuk(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        form.tcari.requestFocus();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekSisruteAlasanRujukActionPerformed

    private void btnCekSisruteDiagnosaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekSisruteDiagnosaActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        SisruteCekReferensiDiagnosa form = new SisruteCekReferensiDiagnosa(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        form.tcari.requestFocus();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekSisruteDiagnosaActionPerformed

    private void btnRujukanMasukSisruteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRujukanMasukSisruteActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        SisruteRujukanMasukan form = new SisruteRujukanMasukan(this, false);
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        form.TCari.requestFocus();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRujukanMasukSisruteActionPerformed

    private void btnRujukanKeluarSisruteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRujukanKeluarSisruteActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        SisruteRujukanKeluar form = new SisruteRujukanKeluar(this, false);
        form.isCek();
        form.tutupInput();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRujukanKeluarSisruteActionPerformed

    private void btnBarangCSSDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarangCSSDActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        InventarisBarangCSSD form = new InventarisBarangCSSD(this, false);
        form.emptTeks();
        form.tampil();
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnBarangCSSDActionPerformed

    private void btnPasienPonekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasienPonekActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgInputPonek form = new DlgInputPonek(this, false);
        form.emptTeks();
        form.tampil();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPasienPonekActionPerformed

    private void btnHarianHAIsRanapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHarianHAIsRanapActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgHarianHAIsRanap aplikasi = new DlgHarianHAIsRanap(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnHarianHAIsRanapActionPerformed

    private void btnHarianHAIsRalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHarianHAIsRalanActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgHarianHAIsRalan aplikasi = new DlgHarianHAIsRalan(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnHarianHAIsRalanActionPerformed

    private void btnBulananHAIsRanapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBulananHAIsRanapActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgBulananHAIsRanap aplikasi = new DlgBulananHAIsRanap(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnBulananHAIsRanapActionPerformed

    private void btnBulananHAIsRalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBulananHAIsRalanActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgBulananHAIsRalan aplikasi = new DlgBulananHAIsRalan(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnBulananHAIsRalanActionPerformed

    private void btnRingkasanPulangRanapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRingkasanPulangRanapActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRingkasanPulangRanap aplikasi = new DlgRingkasanPulangRanap(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        aplikasi.emptTeks();
        aplikasi.tampil();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRingkasanPulangRanapActionPerformed

    private void btnLaporanFarmasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLaporanFarmasiActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgLaporanFarmasi aplikasi = new DlgLaporanFarmasi(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        aplikasi.ChkInput.setSelected(true);
        aplikasi.isForm();
        aplikasi.emptTeks();
        aplikasi.tampil();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnLaporanFarmasiActionPerformed

    private void ket_updateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ket_updateKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ket_updateKeyPressed

    private void btnMasterMasalahKeperawatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterMasalahKeperawatanActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        MasterMasalahKeperawatan form = new MasterMasalahKeperawatan(this, false);
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMasterMasalahKeperawatanActionPerformed

    private void btnPenilaianAwalKeperawatanRalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenilaianAwalKeperawatanRalanActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMPenilaianAwalKeperawatanRalan aplikasi = new RMPenilaianAwalKeperawatanRalan(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();        
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPenilaianAwalKeperawatanRalanActionPerformed

    private void btnDataTriaseIGDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataTriaseIGDActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMTriaseIGD form = new RMTriaseIGD(this, false);
        form.isCek();
        form.emptTeks();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnDataTriaseIGDActionPerformed

    private void btnMasterCaraBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterCaraBayarActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPenanggungJawab form = new DlgPenanggungJawab(this, false);
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMasterCaraBayarActionPerformed

    private void btnDataPersalinanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataPersalinanActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPasienPersalinan form = new DlgPasienPersalinan(this, false);
        form.isCek();
        form.emptPersalinan();
        form.ChkInput.setSelected(false);
        form.isForm();
        form.tampil();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnDataPersalinanActionPerformed

    private void btnPasienCoronaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasienCoronaActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        CoronaPasien form = new CoronaPasien(this, false);
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPasienCoronaActionPerformed

    private void btnDiagnosaPasienCoronaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiagnosaPasienCoronaActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        CoronaDiagnosa form = new CoronaDiagnosa(this, false);
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnDiagnosaPasienCoronaActionPerformed

    private void btnPerawatanPasienCoronaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerawatanPasienCoronaActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        INACBGPerawatanCorona form = new INACBGPerawatanCorona(this, false);
        form.isCek();
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPerawatanPasienCoronaActionPerformed

    private void btnAsuhanGiziRanapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsuhanGiziRanapActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMAsuhanGiziRanap asesGizi = new RMAsuhanGiziRanap(this, false);
        asesGizi.isCek();
        asesGizi.emptTeks();
        asesGizi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        asesGizi.setLocationRelativeTo(PanelUtama);
        asesGizi.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnAsuhanGiziRanapActionPerformed

    private void btnAssesmenUlangGiziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssesmenUlangGiziActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgAssesmenGiziUlang asesGiziulang = new DlgAssesmenGiziUlang(this, false);
        asesGiziulang.isCek();
        asesGiziulang.emptTeks();
        asesGiziulang.TCari.setText("");
        asesGiziulang.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        asesGiziulang.setLocationRelativeTo(PanelUtama);
        asesGiziulang.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnAssesmenUlangGiziActionPerformed

    private void btnRencanaKontrolBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRencanaKontrolBPJSActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSSuratKontrol surkon = new BPJSSuratKontrol(null, false);
        surkon.isCek();
        surkon.emptTeks();
        surkon.TCari.setText("");
        surkon.ChkInput.setSelected(false);
        surkon.isForm();
        surkon.tampil();
        surkon.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        surkon.setLocationRelativeTo(PanelUtama);
        surkon.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRencanaKontrolBPJSActionPerformed

    private void btnMonevAsuhanGiziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonevAsuhanGiziActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgMonevAsuhanGizi monevGZ = new DlgMonevAsuhanGizi(this, false);
        monevGZ.isCek();
        monevGZ.emptTeks();
        monevGZ.TCari.setText("");
        monevGZ.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        monevGZ.setLocationRelativeTo(PanelUtama);
        monevGZ.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMonevAsuhanGiziActionPerformed

    private void btnBridgingEklaimINACBGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBridgingEklaimINACBGActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        INACBGDaftarKlaim eklaimRZ = new INACBGDaftarKlaim(this, false);
        eklaimRZ.isCek();
        eklaimRZ.emptTeks();
        eklaimRZ.Chktgl.setSelected(true);
        eklaimRZ.Chktgl.setText("Tgl. Klaim : ");
        eklaimRZ.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        eklaimRZ.setLocationRelativeTo(PanelUtama);
        eklaimRZ.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnBridgingEklaimINACBGActionPerformed

    private void btnPengajuanKlaimINACBGrzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPengajuanKlaimINACBGrzActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        PengajuanKlaimINACBGrz ajukan = new PengajuanKlaimINACBGrz(this, false);
        ajukan.isCek();
        ajukan.emptTeksJKN();
        ajukan.emptTeksLAINNYA();
        ajukan.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        ajukan.setLocationRelativeTo(PanelUtama);
        ajukan.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPengajuanKlaimINACBGrzActionPerformed

    private void btnINACBGjknBelumDiklaimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnINACBGjknBelumDiklaimActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        INACBGjknBelumDiklaim jknbelum = new INACBGjknBelumDiklaim(this, false);
        jknbelum.isCek();
        jknbelum.emptText();
        jknbelum.tampil();
        jknbelum.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        jknbelum.setLocationRelativeTo(PanelUtama);
        jknbelum.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnINACBGjknBelumDiklaimActionPerformed

    private void btnInputKodeICDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInputKodeICDActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgInputKodeICD input_kode = new DlgInputKodeICD(this, false);
        input_kode.ChkInput.setSelected(true);
        input_kode.isForm();
        input_kode.isCek();
        input_kode.emptTeks();
        input_kode.tampil();
        input_kode.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        input_kode.setLocationRelativeTo(PanelUtama);
        input_kode.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnInputKodeICDActionPerformed

    private void btnKendaliMutuKendaliBiayaINACBGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKendaliMutuKendaliBiayaINACBGActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        KendaliMutuKendaliBiayaJKN kendaliJKN = new KendaliMutuKendaliBiayaJKN(this, false);
        kendaliJKN.emptTeks();
        kendaliJKN.tampilRalan();
        kendaliJKN.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        kendaliJKN.setLocationRelativeTo(PanelUtama);
        kendaliJKN.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnKendaliMutuKendaliBiayaINACBGActionPerformed

    private void btnDashboardeResepRalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardeResepRalanActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgDashboardEresep eResep = new DlgDashboardEresep(this, false);
        eResep.emptTeks();
        eResep.tampil();
        eResep.isCek();
        eResep.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        eResep.setLocationRelativeTo(PanelUtama);
        eResep.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnDashboardeResepRalanActionPerformed

    private void btnCekSEPInternalBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekSEPInternalBPJSActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekSEPInternal sepInternal = new BPJSCekSEPInternal(this, false);
        sepInternal.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        sepInternal.setLocationRelativeTo(PanelUtama);
        sepInternal.setVisible(true);
        sepInternal.NoSEP.setText("");
        sepInternal.NoSEP.requestFocus();
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekSEPInternalBPJSActionPerformed

    private void btnSPRIbpjsVclaimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSPRIbpjsVclaimActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSSPRI spri = new BPJSSPRI(null, false);
        spri.isCek();
        spri.emptTeks();
        spri.TCari.setText("");
        spri.ChkInput.setSelected(false);
        spri.isForm();
        spri.tampil();
        spri.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        spri.setLocationRelativeTo(PanelUtama);
        spri.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSPRIbpjsVclaimActionPerformed

    private void btnCekFingerPrinBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekFingerPrinBPJSActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekFingerPrin finger = new BPJSCekFingerPrin(this, false);
        finger.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        finger.setLocationRelativeTo(PanelUtama);
        finger.setVisible(true);
        finger.tglPel.requestFocus();
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekFingerPrinBPJSActionPerformed

    private void btnListSpesialistikRujukanBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListSpesialistikRujukanBPJSActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSListSpesialistikRujukan list = new BPJSListSpesialistikRujukan(this, false);
        list.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        list.setLocationRelativeTo(PanelUtama);
        list.setVisible(true);
        list.tglRujukan.requestFocus();
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnListSpesialistikRujukanBPJSActionPerformed

    private void btnListSaranaRujukanBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListSaranaRujukanBPJSActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSListSaranaRujukan sarana = new BPJSListSaranaRujukan(this, false);
        sarana.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        sarana.setLocationRelativeTo(PanelUtama);
        sarana.setVisible(true);
        sarana.btnPPKRujukan.requestFocus();
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnListSaranaRujukanBPJSActionPerformed

    private void btnProgramPRBBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProgramPRBBPJSActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSProgramPRB prb = new BPJSProgramPRB(this, false);
        prb.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        prb.setLocationRelativeTo(PanelUtama);
        prb.setVisible(true);
        prb.isCek();
        prb.ChkInput.setSelected(false);
        prb.isForm();
        prb.emptTeks();
        prb.tampil();
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnProgramPRBBPJSActionPerformed

    private void btnCekReferensiDiagnosaPRBBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekReferensiDiagnosaPRBBPJSActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekReferensiDiagnosaPRB diagnosaPRB = new BPJSCekReferensiDiagnosaPRB(this, false);
        diagnosaPRB.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        diagnosaPRB.setLocationRelativeTo(PanelUtama);
        diagnosaPRB.setVisible(true);
        diagnosaPRB.TCari.requestFocus();
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekReferensiDiagnosaPRBBPJSActionPerformed

    private void btnCekReferensiObatPRBBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekReferensiObatPRBBPJSActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekReferensiObatPRB obatPRB = new BPJSCekReferensiObatPRB(this, false);
        obatPRB.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        obatPRB.setLocationRelativeTo(PanelUtama);
        obatPRB.setVisible(true);
        obatPRB.TCari.requestFocus();
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekReferensiObatPRBBPJSActionPerformed

    private void btnDataNomorSuratKontrolBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataNomorSuratKontrolBPJSActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSDataNomorSuratKontrol nomor = new BPJSDataNomorSuratKontrol(this, false);
        nomor.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        nomor.setLocationRelativeTo(PanelUtama);
        nomor.setVisible(true);
        nomor.isCek();
        nomor.TCari.requestFocus();
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnDataNomorSuratKontrolBPJSActionPerformed

    private void btnHistoriPelayananPesertaBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoriPelayananPesertaBPJSActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSHistoriPelayanan histori = new BPJSHistoriPelayanan(this, false);
        histori.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        histori.setLocationRelativeTo(PanelUtama);
        histori.setVisible(true);
        histori.NoKartu.requestFocus();
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnHistoriPelayananPesertaBPJSActionPerformed

    private void btnKlaimJaminanJasaRaharjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKlaimJaminanJasaRaharjaActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekKlaimJasaRaharja raharja = new BPJSCekKlaimJasaRaharja(this, false);
        raharja.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        raharja.setLocationRelativeTo(PanelUtama);
        raharja.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnKlaimJaminanJasaRaharjaActionPerformed

    private void btnDataSuplesiJasaRaharjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataSuplesiJasaRaharjaActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekSuplesiJasaRaharja suplesi = new BPJSCekSuplesiJasaRaharja(this, false);
        suplesi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        suplesi.setLocationRelativeTo(PanelUtama);
        suplesi.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnDataSuplesiJasaRaharjaActionPerformed

    private void btnDataSEPIndukKLLJasaRaharjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataSEPIndukKLLJasaRaharjaActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekDataIndukKecelakaan kll = new BPJSCekDataIndukKecelakaan(this, false);
        kll.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        kll.setLocationRelativeTo(PanelUtama);
        kll.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnDataSEPIndukKLLJasaRaharjaActionPerformed

    private void btnCekReferensiPoliHFISBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekReferensiPoliHFISBPJSActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekReferensiPoliHFIS polihfis = new BPJSCekReferensiPoliHFIS(this, false);
        polihfis.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        polihfis.setLocationRelativeTo(PanelUtama);
        polihfis.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekReferensiPoliHFISBPJSActionPerformed

    private void btnCekReferensiJadwalHFISBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekReferensiJadwalHFISBPJSActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekReferensiJadwalHFIS jadwalhfis = new BPJSCekReferensiJadwalHFIS(this, false);
        jadwalhfis.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        jadwalhfis.setLocationRelativeTo(PanelUtama);
        jadwalhfis.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekReferensiJadwalHFISBPJSActionPerformed

    private void btnCekReferensiDokterHFISBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekReferensiDokterHFISBPJSActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        BPJSCekReferensiDokterHFIS dokterhfis = new BPJSCekReferensiDokterHFIS(this, false);
        dokterhfis.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        dokterhfis.setLocationRelativeTo(PanelUtama);
        dokterhfis.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekReferensiDokterHFISBPJSActionPerformed

    private void btnCekReferensiPendaftaranMobileJKNBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekReferensiPendaftaranMobileJKNBPJSActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        MobileJKNReferensiPendaftaran mobilejkndaftar = new MobileJKNReferensiPendaftaran(this, false);
        mobilejkndaftar.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        mobilejkndaftar.setLocationRelativeTo(PanelUtama);
        mobilejkndaftar.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekReferensiPendaftaranMobileJKNBPJSActionPerformed

    private void btnCekReferensiBatalDaftarMobileJKNBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekReferensiBatalDaftarMobileJKNBPJSActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        MobileJKNPembatalanPendaftaran mobilejknbatal = new MobileJKNPembatalanPendaftaran(this, false);
        mobilejknbatal.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        mobilejknbatal.setLocationRelativeTo(PanelUtama);
        mobilejknbatal.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCekReferensiBatalDaftarMobileJKNBPJSActionPerformed

    private void btnKemenkesSITBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKemenkesSITBActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgDataTB aplikasi = new DlgDataTB(this, false);
        aplikasi.emptTeks();
        aplikasi.isCek();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnKemenkesSITBActionPerformed

    private void btnMasterDTDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterDTDActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgMasterDTD dtd = new DlgMasterDTD(this, false);
        dtd.emptTeks();
        dtd.isCek();
        dtd.ChkInput.setSelected(false);
        dtd.isForm();
        dtd.TabStatus.setSelectedIndex(0);
        dtd.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        dtd.setLocationRelativeTo(PanelUtama);
        dtd.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMasterDTDActionPerformed

    private void btnAsesmenMedikObstetriRalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsesmenMedikObstetriRalanActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMPenilaianAwalMedikObstetriRalan aplikasi = new RMPenilaianAwalMedikObstetriRalan(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setTampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnAsesmenMedikObstetriRalanActionPerformed

    private void btnPenilaianAwalKeperawatanKebidananRalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenilaianAwalKeperawatanKebidananRalanActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMPenilaianAwalKeperawatanKebidanan aplikasi = new RMPenilaianAwalKeperawatanKebidanan(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setTampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPenilaianAwalKeperawatanKebidananRalanActionPerformed

    private void btnIkhtisarPerawatanHIVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIkhtisarPerawatanHIVActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgIkhtisarPerawatanHIVart hiv = new DlgIkhtisarPerawatanHIVart(this, false);
        hiv.isCek();
        hiv.emptText();
        hiv.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        hiv.setLocationRelativeTo(PanelUtama);
        hiv.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnIkhtisarPerawatanHIVActionPerformed

    private void btnKemenkesKankerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKemenkesKankerActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgDataKanker aplikasi = new DlgDataKanker(this, false);
        aplikasi.emptTeks();
        aplikasi.isCek();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnKemenkesKankerActionPerformed

    private void btnSetingBridgingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetingBridgingActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSetBridging setbrid = new DlgSetBridging(this, false);
        setbrid.tampil();
        setbrid.emptTeks();
        setbrid.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        setbrid.setLocationRelativeTo(PanelUtama);
        setbrid.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSetingBridgingActionPerformed

    private void btnPenilaianAwalMedisRalanTHTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenilaianAwalMedisRalanTHTActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMPenilaianAwalMedisRalanTHT aplikasi = new RMPenilaianAwalMedisRalanTHT(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setTampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPenilaianAwalMedisRalanTHTActionPerformed

    private void btnRekamPsikologisDewasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRekamPsikologisDewasaActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRekamPsikologisDewasa aplikasi = new DlgRekamPsikologisDewasa(this, false);
        aplikasi.isCek();
        aplikasi.emptText();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRekamPsikologisDewasaActionPerformed

    private void btnMasterKeluhanPsikologisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterKeluhanPsikologisActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgMasterKeluhanPsikologis psikologis = new DlgMasterKeluhanPsikologis(this, false);
        psikologis.cekKategori.setText("");
        psikologis.isCek();
        psikologis.emptTeks();        
        psikologis.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        psikologis.setLocationRelativeTo(PanelUtama);
        psikologis.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMasterKeluhanPsikologisActionPerformed

    private void edAdminKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edAdminKeyPressed
        Valid.pindah(evt, BtnCancel, edPwd);
    }//GEN-LAST:event_edAdminKeyPressed

    private void btnMasterRencanaTritmenPsikologisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterRencanaTritmenPsikologisActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgMasterRencanaTritmenPsikologi psikologis = new DlgMasterRencanaTritmenPsikologi(this, false);
        psikologis.isCek();
        psikologis.emptTeks();        
        psikologis.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        psikologis.setLocationRelativeTo(PanelUtama);
        psikologis.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMasterRencanaTritmenPsikologisActionPerformed

    private void btnDataJabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataJabatanActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgJabatan jabatan = new DlgJabatan(this, false);
        jabatan.isCek();
        jabatan.emptTeks();        
        jabatan.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        jabatan.setLocationRelativeTo(PanelUtama);
        jabatan.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnDataJabatanActionPerformed

    private void btnMasterJabatanKomiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterJabatanKomiteActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgMasterJabatanKomite komite = new DlgMasterJabatanKomite(this, false);
        komite.isCek();
        komite.emptTeks(); 
        komite.ChkInput.setSelected(true);
        komite.isForm();
        komite.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        komite.setLocationRelativeTo(PanelUtama);
        komite.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMasterJabatanKomiteActionPerformed

    private void btnRekamPsikologisAnakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRekamPsikologisAnakActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRekamPsikologisAnak aplikasi = new DlgRekamPsikologisAnak(this, false);
        aplikasi.isCek();
        aplikasi.emptText();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRekamPsikologisAnakActionPerformed

    private void btnRekamPsikologiPerkawinanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRekamPsikologiPerkawinanActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgRekamPsikologisPerkawinan aplikasi = new DlgRekamPsikologisPerkawinan(this, false);
        aplikasi.isCek();
        aplikasi.emptText();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnRekamPsikologiPerkawinanActionPerformed

    private void btnMasterAturanPakaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterAturanPakaiActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgAturanPakai aplikasi = new DlgAturanPakai(this, false);
        aplikasi.emptTeks();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMasterAturanPakaiActionPerformed

    private void btnMasterKasusPersalinanDinkesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterKasusPersalinanDinkesActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        MasterDataDinkes aplikasi = new MasterDataDinkes(this, false);        
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMasterKasusPersalinanDinkesActionPerformed

    private void btnKasusPersalinanDinkesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKasusPersalinanDinkesActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgDinkesPersalinan aplikasi = new DlgDinkesPersalinan(this, false);        
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.isCek();
        aplikasi.ChkInput.setSelected(false);
        aplikasi.isForm();
        aplikasi.emptteks();
        aplikasi.tampil();
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnKasusPersalinanDinkesActionPerformed

    private void btnPenilaianTambahanGeriatriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenilaianTambahanGeriatriActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMPenilaianTambahanGeriatri aplikasi = new RMPenilaianTambahanGeriatri(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setTampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPenilaianTambahanGeriatriActionPerformed

    private void btnPenilaianAwalMedisRalanGeriatriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenilaianAwalMedisRalanGeriatriActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMPenilaianAwalMedisRalanGeriatri aplikasi = new RMPenilaianAwalMedisRalanGeriatri(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setTampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPenilaianAwalMedisRalanGeriatriActionPerformed

    private void btnMasterFaktorResikoJatuhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterFaktorResikoJatuhActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        MasterFaktorResikoIGD form = new MasterFaktorResikoIGD(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMasterFaktorResikoJatuhActionPerformed

    private void btnAssesmenKeperawatanIGDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssesmenKeperawatanIGDActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMPenilaianAwalKeperawatanIGDrz aplikasi = new RMPenilaianAwalKeperawatanIGDrz(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setTampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnAssesmenKeperawatanIGDActionPerformed

    private void btnAssesmenMedikIGDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssesmenMedikIGDActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMPenilaianAwalMedikIGD aplikasi = new RMPenilaianAwalMedikIGD(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setTampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnAssesmenMedikIGDActionPerformed

    private void btnPenilaianAwalMedisRalanMataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenilaianAwalMedisRalanMataActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMPenilaianAwalMedisRalanMata aplikasi = new RMPenilaianAwalMedisRalanMata(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setTampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPenilaianAwalMedisRalanMataActionPerformed

    private void btnSuratIstirahatSakitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuratIstirahatSakitActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSuratIstirahatSakit aplikasi = new DlgSuratIstirahatSakit(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();        
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSuratIstirahatSakitActionPerformed

    private void btnSuratKeteranganSakitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuratKeteranganSakitActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSuratKeteranganSakit aplikasi = new DlgSuratKeteranganSakit(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();        
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSuratKeteranganSakitActionPerformed

    private void btnTransferSerahTerimaPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferSerahTerimaPasienActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMTransferSerahTerimaIGD aplikasi = new RMTransferSerahTerimaIGD(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnTransferSerahTerimaPasienActionPerformed

    private void btnSuratKeteranganNAPZAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuratKeteranganNAPZAActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSuratKeteranganNapza aplikasi = new DlgSuratKeteranganNapza(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();        
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSuratKeteranganNAPZAActionPerformed

    private void btnSuratKeteranganRohaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuratKeteranganRohaniActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSuratKeteranganRohani aplikasi = new DlgSuratKeteranganRohani(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();        
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSuratKeteranganRohaniActionPerformed

    private void btnSuratKeteranganDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuratKeteranganDokterActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSuratKeteranganDokter aplikasi = new DlgSuratKeteranganDokter(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSuratKeteranganDokterActionPerformed

    private void btnAsesmenMedikDewasaRanapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsesmenMedikDewasaRanapActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMAsesmenMedikDewasaRanap aplikasi = new RMAsesmenMedikDewasaRanap(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setTampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnAsesmenMedikDewasaRanapActionPerformed

    private void btnGantiPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGantiPasswordActionPerformed
        if (btnGantiPassword.isEnabled() == false) {
            PassLama.setText("");
            Passbaru1.setText("");
            PassBaru2.setText("");
        } else {
            isTutup();
            PassLama.setText("");
            Passbaru1.setText("");
            PassBaru2.setText("");
            WindowInput.setVisible(true);
        }
    }//GEN-LAST:event_btnGantiPasswordActionPerformed

    private void btnPemberianObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPemberianObatActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPemberianObatPasien aplikasi = new DlgPemberianObatPasien(this, false);
        aplikasi.isCek();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPemberianObatActionPerformed

    private void btnCPPTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCPPTActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgCPPT aplikasi = new DlgCPPT(this, false);
        aplikasi.isCek();
        aplikasi.setUtama();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCPPTActionPerformed

    private void btnSpirometriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpirometriActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSpirometri aplikasi = new DlgSpirometri(this, false);
        aplikasi.isCek();
        aplikasi.ChkInput.setSelected(false);
        aplikasi.isForm(); 
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSpirometriActionPerformed

    private void btnAsesmenKebidananRalanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsesmenKebidananRalanActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMAsesmenKebidananRalan aplikasi = new RMAsesmenKebidananRalan(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnAsesmenKebidananRalanActionPerformed

    private void btnDashboardeResepRanapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDashboardeResepRanapActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgDashboardEresepRanap eResep = new DlgDashboardEresepRanap(this, false);
        eResep.emptTeks();
        eResep.tampilAwal();
        eResep.isCek();
        eResep.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        eResep.setLocationRelativeTo(PanelUtama);
        eResep.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnDashboardeResepRanapActionPerformed

    private void BtnDasboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDasboardActionPerformed
        isTutup();
        FlayMenu.removeAll();
        FlayMenu.add(btnDashboardeResepRalan);
        FlayMenu.add(btnDashboardeResepRanap);
        btnDashboardeResepRalan.setEnabled(akses.getdashboard_eResep());
        btnDashboardeResepRanap.setEnabled(akses.getdashboard_eResep());
        FlayMenu.setVisible(true);
    }//GEN-LAST:event_BtnDasboardActionPerformed

    private void btnJadwalOperasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJadwalOperasiActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgJadwalOperasi jadwal = new DlgJadwalOperasi(this, false);
        jadwal.emptTeks();        
        jadwal.isCek();
        jadwal.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        jadwal.setLocationRelativeTo(PanelUtama);
        jadwal.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnJadwalOperasiActionPerformed

    private void btnBangsalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBangsalActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgBangsal bangsal = new DlgBangsal(this, false);
        bangsal.emptTeks();
        bangsal.isCek();
        bangsal.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        bangsal.setLocationRelativeTo(PanelUtama);
        bangsal.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnBangsalActionPerformed

    private void btnPersetujuanTindakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersetujuanTindakanActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMTindakanKedokteran tindakan = new RMTindakanKedokteran(this, false);
        tindakan.emptTeks();
        tindakan.isCek();
        tindakan.tampil();
        tindakan.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        tindakan.setLocationRelativeTo(PanelUtama);
        tindakan.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPersetujuanTindakanActionPerformed

    private void btnPetugasPelaksanaPemberianObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPetugasPelaksanaPemberianObatActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgPelaksanaPemberiObat aplikasi = new DlgPelaksanaPemberiObat(this, false);
        aplikasi.emptTeks();
        aplikasi.isCek();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPetugasPelaksanaPemberianObatActionPerformed

    private void btnCatatanTindakanKeperawatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatatanTindakanKeperawatanActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgCatatanTindakanKeperawatan aplikasi = new DlgCatatanTindakanKeperawatan(this, false);
        aplikasi.emptTeks();
        aplikasi.isCek();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCatatanTindakanKeperawatanActionPerformed

    private void btnSuratKonsulUnitRanapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuratKonsulUnitRanapActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSuratKonsulUnit aplikasi = new DlgSuratKonsulUnit(this, false);
        aplikasi.emptTeks();
        aplikasi.isCek();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSuratKonsulUnitRanapActionPerformed

    private void btnSuratJawabanKonsulRanapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuratJawabanKonsulRanapActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSuratJawabanKonsul aplikasi = new DlgSuratJawabanKonsul(this, false);
        aplikasi.emptTeks();
        aplikasi.isCek();
        aplikasi.isiCombo();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSuratJawabanKonsulRanapActionPerformed

    private void jMenu4MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu4MenuSelected
        isTutup();
        DlgHome.dispose();
        DlgAbout About = new DlgAbout(this, true);
        About.setSize(PanelWall.getWidth(), PanelWall.getHeight());
        About.setLocationRelativeTo(PanelWall);
        About.setVisible(true);
    }//GEN-LAST:event_jMenu4MenuSelected

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        isTutup();
        DlgHome.dispose();
        DlgAbout About = new DlgAbout(this, true);
        About.setSize(PanelWall.getWidth(), PanelWall.getHeight());
        About.setLocationRelativeTo(PanelWall);
        About.setVisible(true);
    }//GEN-LAST:event_jMenu4MouseClicked

    private void btnMasterResikoDecubitusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterResikoDecubitusActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        MasterResikoDecubitus form = new MasterResikoDecubitus(this, false);
        form.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        form.setLocationRelativeTo(PanelUtama);
        form.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMasterResikoDecubitusActionPerformed

    private void btnAsesmenKeperawatanDewasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsesmenKeperawatanDewasaActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMAsesmenKeperawatanDewasaRanap aplikasi = new RMAsesmenKeperawatanDewasaRanap(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnAsesmenKeperawatanDewasaActionPerformed

    private void btnReferensiDokterSatuSehatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReferensiDokterSatuSehatActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        SatuSehatReferensiPraktisi aplikasi=new SatuSehatReferensiPraktisi(this,false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnReferensiDokterSatuSehatActionPerformed

    private void btnReferensiPasienSatuSehatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReferensiPasienSatuSehatActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        SatuSehatReferensiPasien aplikasi = new SatuSehatReferensiPasien(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnReferensiPasienSatuSehatActionPerformed

    private void btnMapingOrganisasiSatuSehatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMapingOrganisasiSatuSehatActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        SatuSehatMapingOrganisasi aplikasi = new SatuSehatMapingOrganisasi(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMapingOrganisasiSatuSehatActionPerformed

    private void btnMapingLokasiSatuSehatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMapingLokasiSatuSehatActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        SatuSehatMapingLokasi aplikasi = new SatuSehatMapingLokasi(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMapingLokasiSatuSehatActionPerformed

    private void btnMapingVaksinSatuSehatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMapingVaksinSatuSehatActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        SatuSehatMapingVaksin aplikasi = new SatuSehatMapingVaksin(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMapingVaksinSatuSehatActionPerformed

    private void btnKirimEncounterSatuSehatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKirimEncounterSatuSehatActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        SatuSehatKirimEncounter aplikasi = new SatuSehatKirimEncounter(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnKirimEncounterSatuSehatActionPerformed

    private void btnKirimConditionSatuSehatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKirimConditionSatuSehatActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        SatuSehatKirimCondition aplikasi = new SatuSehatKirimCondition(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnKirimConditionSatuSehatActionPerformed

    private void btnKirimObservationSatuSehatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKirimObservationSatuSehatActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        SatuSehatKirimObservationTTV aplikasi = new SatuSehatKirimObservationTTV(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnKirimObservationSatuSehatActionPerformed

    private void btnKirimProsedurSatuSehatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKirimProsedurSatuSehatActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        SatuSehatKirimProcedure aplikasi = new SatuSehatKirimProcedure(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnKirimProsedurSatuSehatActionPerformed

    private void btnKirimImunisasiSatuSehatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKirimImunisasiSatuSehatActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        SatuSehatKirimVaksin aplikasi = new SatuSehatKirimVaksin(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnKirimImunisasiSatuSehatActionPerformed

    private void btnKirimClinicalSatuSehatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKirimClinicalSatuSehatActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        SatuSehatKirimClinicalImpression aplikasi = new SatuSehatKirimClinicalImpression(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnKirimClinicalSatuSehatActionPerformed

    private void btnKirimDietSatuSehatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKirimDietSatuSehatActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        SatuSehatKirimDiet aplikasi = new SatuSehatKirimDiet(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnKirimDietSatuSehatActionPerformed

    private void btnMapingObatSatuSehatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMapingObatSatuSehatActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        SatuSehatMapingObatAlkes aplikasi = new SatuSehatMapingObatAlkes(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMapingObatSatuSehatActionPerformed

    private void btnPemantauanHarian24JamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPemantauanHarian24JamActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMPemantauanHarian24Jam aplikasi = new RMPemantauanHarian24Jam(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPemantauanHarian24JamActionPerformed

    private void btnKirimMedicationRequestSatuSehatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKirimMedicationRequestSatuSehatActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        SatuSehatKirimMedicationRequest aplikasi = new SatuSehatKirimMedicationRequest(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnKirimMedicationRequestSatuSehatActionPerformed

    private void btnKirimMedicationDispenseSatuSehatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKirimMedicationDispenseSatuSehatActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        SatuSehatKirimMedicationDispense aplikasi = new SatuSehatKirimMedicationDispense(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnKirimMedicationDispenseSatuSehatActionPerformed

    private void btnNotepadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotepadActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgNotepad aplikasi = new DlgNotepad(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setData(akses.getkode());
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnNotepadActionPerformed

    private void btnProtokolKemoterapiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProtokolKemoterapiActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMProtokolKemoterapi aplikasi = new RMProtokolKemoterapi(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.emptTeks();
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnProtokolKemoterapiActionPerformed

    private void btnAsesmenUlangResikoJatuhDewasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsesmenUlangResikoJatuhDewasaActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMAsesmenUlangResikoJatuhDewasa aplikasi = new RMAsesmenUlangResikoJatuhDewasa(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.emptTeks();
        aplikasi.isCek();
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnAsesmenUlangResikoJatuhDewasaActionPerformed

    private void btnPengelolaanTransfusiDarahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPengelolaanTransfusiDarahActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMPengelolaanTransfusiDarah aplikasi = new RMPengelolaanTransfusiDarah(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.emptTeks();
        aplikasi.isCek();
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPengelolaanTransfusiDarahActionPerformed

    private void btnMonitoringEWSDewasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonitoringEWSDewasaActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMMonitoringEWSDewasa aplikasi = new RMMonitoringEWSDewasa(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.emptTeks();
        aplikasi.isCek();
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMonitoringEWSDewasaActionPerformed

    private void btnMasterNomorDokumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterNomorDokumenActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgMasterNomorDokumen aplikasi = new DlgMasterNomorDokumen(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.emptTeks();
        aplikasi.isCek();
        aplikasi.ChkInput.setSelected(true);
        aplikasi.isForm();
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMasterNomorDokumenActionPerformed

    private void btnAsesmenKeperawatanAnakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsesmenKeperawatanAnakActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMAsesmenKeperawatanAnakRanap aplikasi = new RMAsesmenKeperawatanAnakRanap(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnAsesmenKeperawatanAnakActionPerformed

    private void btnAsesmenMedikAnakRanapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsesmenMedikAnakRanapActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMAsesmenMedikAnakRanap aplikasi = new RMAsesmenMedikAnakRanap(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setTampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnAsesmenMedikAnakRanapActionPerformed

    private void btnMasterJenisDokumenJangMedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterJenisDokumenJangMedActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgMasterJenisDokumenJangMed aplikasi = new DlgMasterJenisDokumenJangMed(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMasterJenisDokumenJangMedActionPerformed

    private void btnAsesmenUlangResikoJatuhAnakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsesmenUlangResikoJatuhAnakActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMAsesmenUlangResikoJatuhAnak aplikasi = new RMAsesmenUlangResikoJatuhAnak(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.emptTeks();
        aplikasi.isCek();
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnAsesmenUlangResikoJatuhAnakActionPerformed

    private void btnMonitoringPediatricEWSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonitoringPediatricEWSActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMMonitoringPEWSAnak aplikasi = new RMMonitoringPEWSAnak(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.emptTeks();
        aplikasi.isCek();
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMonitoringPediatricEWSActionPerformed

    private void btnAsesmenRestrainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsesmenRestrainActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMAsesmenRestrain aplikasi = new RMAsesmenRestrain(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setTampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnAsesmenRestrainActionPerformed

    private void btnMasterDiagnosaGiziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterDiagnosaGiziActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgMasterDiagnosaGizi aplikasi = new DlgMasterDiagnosaGizi(this, false);
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.emptTeks();        
        aplikasi.TCari.requestFocus();
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMasterDiagnosaGiziActionPerformed

    private void btnSkriningGiziUlangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkriningGiziUlangActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMSkriningUlangGizi gizi = new RMSkriningUlangGizi(this, false);
        gizi.isCek();
        gizi.emptTeks();        
        gizi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        gizi.setLocationRelativeTo(PanelUtama);
        gizi.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSkriningGiziUlangActionPerformed

    private void btnLembarObservasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLembarObservasiActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMLembarObservasi aplikasi = new RMLembarObservasi(this, false);
        aplikasi.isCek();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnLembarObservasiActionPerformed

    private void btnTransaksiPanjarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransaksiPanjarActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgTransaksiPanjar aplikasi = new DlgTransaksiPanjar(this, false);
        aplikasi.emptTeks();
        aplikasi.isCek();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnTransaksiPanjarActionPerformed

    private void btnTransferPasienTindakanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferPasienTindakanActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMPasienUntukTindakan aplikasi = new RMPasienUntukTindakan(this, false);
        aplikasi.isCek();
        aplikasi.emptTeksSebelum();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnTransferPasienTindakanActionPerformed

    private void btnAsesmenPraSedasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsesmenPraSedasiActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMAsesmenPraSedasi aplikasi = new RMAsesmenPraSedasi(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnAsesmenPraSedasiActionPerformed

    private void btnMasterIndikatorNasionalMutuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterIndikatorNasionalMutuActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgMasterIndikatorMutu mutu = new DlgMasterIndikatorMutu(this, false);
        mutu.isCek();
        mutu.emptTeks();        
        mutu.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        mutu.setLocationRelativeTo(PanelUtama);
        mutu.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMasterIndikatorNasionalMutuActionPerformed

    private void btnIndikatorNasionalMutuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIndikatorNasionalMutuActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgIndikatorNasionalMutu mutu = new DlgIndikatorNasionalMutu(this, false);
        mutu.emptTeks();        
        mutu.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        mutu.setLocationRelativeTo(PanelUtama);
        mutu.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnIndikatorNasionalMutuActionPerformed

    private void btnSuratKeteranganDisabilitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuratKeteranganDisabilitasActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgSuratKeteranganDisabilitas aplikasi = new DlgSuratKeteranganDisabilitas(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setTampil();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnSuratKeteranganDisabilitasActionPerformed

    private void btnCeklisPraOperasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCeklisPraOperasiActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMCeklisPraOperasi aplikasi = new RMCeklisPraOperasi(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCeklisPraOperasiActionPerformed

    private void btnCeklisKesiapanAnestesiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCeklisKesiapanAnestesiActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMCeklisKesiapanAnestesi aplikasi = new RMCeklisKesiapanAnestesi(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnCeklisKesiapanAnestesiActionPerformed

    private void btnAsesmenPreInduksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsesmenPreInduksiActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMAsesmenPreInduksi aplikasi = new RMAsesmenPreInduksi(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnAsesmenPreInduksiActionPerformed

    private void btnMasterNumdenomINMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasterNumdenomINMActionPerformed
        isTutup();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgMasterNumdemonINM mutu = new DlgMasterNumdemonINM(this, false);
        mutu.isCek();
        mutu.emptTeks();        
        mutu.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        mutu.setLocationRelativeTo(PanelUtama);
        mutu.setVisible(true);
        DlgHome.dispose();
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnMasterNumdenomINMActionPerformed

    private void btnAsesmenKeperawatanPerioperatifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsesmenKeperawatanPerioperatifActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMAsesmenKeperawatanPerioperatif aplikasi = new RMAsesmenKeperawatanPerioperatif(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnAsesmenKeperawatanPerioperatifActionPerformed

    private void btnPerencanaanPulangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPerencanaanPulangActionPerformed
        isTutup();
        DlgHome.dispose();
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        RMPerencanaanPulang aplikasi = new RMPerencanaanPulang(this, false);
        aplikasi.isCek();
        aplikasi.emptTeks();
        aplikasi.setSize(PanelUtama.getWidth(), PanelUtama.getHeight());
        aplikasi.setLocationRelativeTo(PanelUtama);
        aplikasi.setVisible(true);
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_btnPerencanaanPulangActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new frmUtama().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.Button BtnCancel;
    private widget.ButtonBig BtnClose;
    private widget.Button BtnClosePass;
    private widget.ButtonBig BtnDasboard;
    private widget.ButtonBig BtnDpjp;
    private widget.ButtonBig BtnJadwal;
    private widget.ButtonBig BtnLog;
    private widget.Button BtnLogin;
    private widget.ButtonBig BtnMenu;
    private widget.Button BtnSimpanPass;
    private widget.ButtonBig BtnToolJualObat;
    private widget.ButtonBig BtnToolKamnap;
    private widget.ButtonBig BtnToolKasir;
    private widget.ButtonBig BtnToolReg;
    private widget.CekBox ChkInput;
    private javax.swing.JDialog DlgHome;
    private javax.swing.JDialog DlgLogin;
    private usu.widget.glass.PanelGlass FlayMenu;
    private widget.MenuBar MenuBar;
    private javax.swing.JMenuItem MnJadwalDokterRalan;
    private javax.swing.JMenuItem MnPasienRanap;
    private javax.swing.JMenuItem MnPenggunaanKamarRanap;
    private javax.swing.JMenuItem MnTarifINACBG;
    private javax.swing.JMenuItem MnTarifKamar;
    private javax.swing.JMenuItem MnTarifLab;
    private javax.swing.JMenuItem MnTarifOperasi;
    private javax.swing.JMenuItem MnTarifRad;
    private javax.swing.JMenuItem MnTarifRalan;
    private javax.swing.JMenuItem MnTarifRanap;
    private javax.swing.JMenuItem MnTelusurKunjungan;
    private javax.swing.JPanel PanelUtama;
    private usu.widget.glass.PanelGlass PanelWall;
    private widget.panelGlass Panelmenu;
    private widget.TextBox PassBaru2;
    private widget.TextBox PassLama;
    private widget.TextBox Passbaru1;
    private widget.ScrollPane Scroll21;
    private widget.TextBox TCari;
    private javax.swing.JDialog WindowInput;
    private widget.ButtonBig btnAdmin;
    private widget.ButtonBig btnAkunPiutang;
    private widget.ButtonBig btnAnalisaKamar;
    private widget.ButtonBig btnAntrian;
    private widget.ButtonBig btnAplicareKetersediaanKamar;
    private widget.ButtonBig btnAplicareReferensiKamar;
    private widget.ButtonBig btnAsesmenKebidananRalan;
    private widget.ButtonBig btnAsesmenKeperawatanAnak;
    private widget.ButtonBig btnAsesmenKeperawatanDewasa;
    private widget.ButtonBig btnAsesmenKeperawatanPerioperatif;
    private widget.ButtonBig btnAsesmenMedikAnakRanap;
    private widget.ButtonBig btnAsesmenMedikDewasaRanap;
    private widget.ButtonBig btnAsesmenMedikObstetriRalan;
    private widget.ButtonBig btnAsesmenPraSedasi;
    private widget.ButtonBig btnAsesmenPreInduksi;
    private widget.ButtonBig btnAsesmenRestrain;
    private widget.ButtonBig btnAsesmenUlangResikoJatuhAnak;
    private widget.ButtonBig btnAsesmenUlangResikoJatuhDewasa;
    private widget.ButtonBig btnAssesmenKeperawatanIGD;
    private widget.ButtonBig btnAssesmenMedikIGD;
    private widget.ButtonBig btnAssesmenUlangGizi;
    private widget.ButtonBig btnAsuhanGiziRanap;
    private widget.ButtonBig btnBPJSSEP;
    private widget.ButtonBig btnBPJScekRiwayatRujukanPcare;
    private widget.ButtonBig btnBangsal;
    private widget.ButtonBig btnBarangCSSD;
    private widget.ButtonBig btnBarangInventaris;
    private widget.ButtonBig btnBarangIpsrs;
    private widget.ButtonBig btnBayarPiutang;
    private widget.ButtonBig btnBeriObat;
    private widget.ButtonBig btnBookingReg;
    private widget.ButtonBig btnBridgingEklaim;
    private widget.ButtonBig btnBridgingEklaimINACBG;
    private widget.ButtonBig btnBubes;
    private widget.ButtonBig btnBulananHAIsRS;
    private widget.ButtonBig btnBulananHAIsRalan;
    private widget.ButtonBig btnBulananHAIsRanap;
    private widget.ButtonBig btnCPPT;
    private widget.ButtonBig btnCashFlow;
    private widget.ButtonBig btnCatatanPasien;
    private widget.ButtonBig btnCatatanTindakanKeperawatan;
    private widget.ButtonBig btnCekBPJSDiagnosa;
    private widget.ButtonBig btnCekBPJSFaskes;
    private widget.ButtonBig btnCekBPJSKartu;
    private widget.ButtonBig btnCekBPJSNik;
    private widget.ButtonBig btnCekBPJSNomorRujukanPCare;
    private widget.ButtonBig btnCekBPJSNomorRujukanRS;
    private widget.ButtonBig btnCekBPJSPoli;
    private widget.ButtonBig btnCekBPJSRiwayatRujukanRS;
    private widget.ButtonBig btnCekBPJSRujukanKartuPCare;
    private widget.ButtonBig btnCekBPJSRujukanKartuRS;
    private widget.ButtonBig btnCekBPJSTanggalRujukan;
    private widget.ButtonBig btnCekFingerPrinBPJS;
    private widget.ButtonBig btnCekPCareDiagnosa;
    private widget.ButtonBig btnCekReferensiBatalDaftarMobileJKNBPJS;
    private widget.ButtonBig btnCekReferensiCaraKeluarBPJS;
    private widget.ButtonBig btnCekReferensiDiagnosaPRBBPJS;
    private widget.ButtonBig btnCekReferensiDokterBPJS;
    private widget.ButtonBig btnCekReferensiDokterDPJPBPJS;
    private widget.ButtonBig btnCekReferensiDokterHFISBPJS;
    private widget.ButtonBig btnCekReferensiJadwalHFISBPJS;
    private widget.ButtonBig btnCekReferensiKabupatenBPJS;
    private widget.ButtonBig btnCekReferensiKecamatanBPJS;
    private widget.ButtonBig btnCekReferensiKelasRawatBPJS;
    private widget.ButtonBig btnCekReferensiObatPRBBPJS;
    private widget.ButtonBig btnCekReferensiPascaPulangBPJS;
    private widget.ButtonBig btnCekReferensiPendaftaranMobileJKNBPJS;
    private widget.ButtonBig btnCekReferensiPoliHFISBPJS;
    private widget.ButtonBig btnCekReferensiPropinsiBPJS;
    private widget.ButtonBig btnCekReferensiProsedurBPJS;
    private widget.ButtonBig btnCekReferensiRuangRawatBPJS;
    private widget.ButtonBig btnCekReferensiSpesialistikBPJS;
    private widget.ButtonBig btnCekSEPInternalBPJS;
    private widget.ButtonBig btnCekSisruteAlasanRujuk;
    private widget.ButtonBig btnCekSisruteDiagnosa;
    private widget.ButtonBig btnCekSisruteFaskes;
    private widget.ButtonBig btnCeklisKesiapanAnestesi;
    private widget.ButtonBig btnCeklisPraOperasi;
    private widget.ButtonBig btnClosingKasir;
    private widget.ButtonBig btnDaftarPermintaanResep;
    private widget.ButtonBig btnDaruratStok;
    private widget.ButtonBig btnDashboardeResepRalan;
    private widget.ButtonBig btnDashboardeResepRanap;
    private widget.ButtonBig btnDataHAIs;
    private widget.ButtonBig btnDataJabatan;
    private widget.ButtonBig btnDataNomorSuratKontrolBPJS;
    private widget.ButtonBig btnDataPenjualan;
    private widget.ButtonBig btnDataPenyerahanDarah;
    private widget.ButtonBig btnDataPersalinan;
    private widget.ButtonBig btnDataSEPIndukKLLJasaRaharja;
    private widget.ButtonBig btnDataSuplesiJasaRaharja;
    private widget.ButtonBig btnDataTriaseIGD;
    private widget.ButtonBig btnDeposit;
    private widget.ButtonBig btnDiagnosa;
    private widget.ButtonBig btnDiagnosaPasienCorona;
    private widget.ButtonBig btnDiet;
    private widget.ButtonBig btnDokter;
    private widget.ButtonBig btnFrekuensiRalan;
    private widget.ButtonBig btnFrekuensiRanap;
    private widget.ButtonBig btnGantiPassword;
    private widget.ButtonBig btnGolonganBarang;
    private widget.ButtonBig btnGrafikDemografiRegistrasi;
    private widget.ButtonBig btnGrafikKunjunganPerBulan;
    private widget.ButtonBig btnGrafikKunjunganPerDokter;
    private widget.ButtonBig btnGrafikKunjunganPerPekerjaan;
    private widget.ButtonBig btnGrafikKunjunganPerPendidikan;
    private widget.ButtonBig btnGrafikKunjunganPerTahun;
    private widget.ButtonBig btnGrafikKunjunganPerTanggal;
    private widget.ButtonBig btnGrafikKunjunganPoli;
    private widget.ButtonBig btnGrafikStatusRegBatalPerBulan;
    private widget.ButtonBig btnGrafikStatusRegBatalPerTahun;
    private widget.ButtonBig btnGrafikStatusRegBatalPerTanggal;
    private widget.ButtonBig btnGrafikStatusRegPerBulan;
    private widget.ButtonBig btnGrafikStatusRegPerBulan2;
    private widget.ButtonBig btnGrafikStatusRegPerTahun;
    private widget.ButtonBig btnGrafikStatusRegPerTahun2;
    private widget.ButtonBig btnGrafikStatusRegPerTanggal;
    private widget.ButtonBig btnGrafikStatusRegPerTanggal2;
    private widget.ButtonBig btnHarianHAIsRS;
    private widget.ButtonBig btnHarianHAIsRalan;
    private widget.ButtonBig btnHarianHAIsRanap;
    private widget.ButtonBig btnHistoriPelayananPesertaBPJS;
    private widget.ButtonBig btnHutangObat;
    private widget.ButtonBig btnICD;
    private widget.ButtonBig btnICD9;
    private widget.ButtonBig btnIGD;
    private widget.ButtonBig btnINACBGjknBelumDiklaim;
    private widget.ButtonBig btnIkhtisarPerawatanHIV;
    private widget.ButtonBig btnInaCBGCoderNIK;
    private widget.ButtonBig btnIndikatorNasionalMutu;
    private widget.ButtonBig btnIndustriFarmasi;
    private widget.ButtonBig btnInputKodeICD;
    private widget.ButtonBig btnInputPenjualan;
    private widget.ButtonBig btnInventaris;
    private widget.ButtonBig btnJadwalOperasi;
    private widget.ButtonBig btnJenisInventaris;
    private widget.ButtonBig btnJenisIpsrs;
    private widget.ButtonBig btnJnsBarang;
    private widget.ButtonBig btnJumlahMacamDiet;
    private widget.ButtonBig btnJumlahPorsiDiet;
    private widget.ButtonBig btnJurnalHarian;
    private widget.ButtonBig btnKamar;
    private widget.ButtonBig btnKamarInap;
    private widget.ButtonBig btnKasir;
    private widget.ButtonBig btnKasusPersalinanDinkes;
    private widget.ButtonBig btnKategoriBarang;
    private widget.ButtonBig btnKategoriInventaris;
    private widget.ButtonBig btnKemenkesKanker;
    private widget.ButtonBig btnKemenkesSITB;
    private widget.ButtonBig btnKendaliMutuKendaliBiayaINACBG;
    private widget.ButtonBig btnKeterlambatanPresensi;
    private widget.ButtonBig btnKeuntungan;
    private widget.ButtonBig btnKeuntunganObat2;
    private widget.ButtonBig btnKeuntunganObatRanap;
    private widget.ButtonBig btnKirimClinicalSatuSehat;
    private widget.ButtonBig btnKirimConditionSatuSehat;
    private widget.ButtonBig btnKirimDietSatuSehat;
    private widget.ButtonBig btnKirimEncounterSatuSehat;
    private widget.ButtonBig btnKirimImunisasiSatuSehat;
    private widget.ButtonBig btnKirimMedicationDispenseSatuSehat;
    private widget.ButtonBig btnKirimMedicationRequestSatuSehat;
    private widget.ButtonBig btnKirimObservationSatuSehat;
    private widget.ButtonBig btnKirimProsedurSatuSehat;
    private widget.ButtonBig btnKlaimJaminanJasaRaharja;
    private widget.ButtonBig btnKonversi;
    private widget.ButtonBig btnKunjunganRalan;
    private widget.ButtonBig btnKunjunganRanap;
    private widget.ButtonBig btnLabaRugi;
    private widget.ButtonBig btnLaboratorium;
    private widget.ButtonBig btnLahir;
    private widget.ButtonBig btnLamaPelayananApotek;
    private widget.ButtonBig btnLamaPelayananRalan;
    private widget.ButtonBig btnLaporanFarmasi;
    private widget.ButtonBig btnLembarObservasi;
    private widget.ButtonBig btnLihatPiutang;
    private widget.ButtonBig btnListSaranaRujukanBPJS;
    private widget.ButtonBig btnListSpesialistikRujukanBPJS;
    private widget.ButtonBig btnMapingLokasiSatuSehat;
    private widget.ButtonBig btnMapingObatSatuSehat;
    private widget.ButtonBig btnMapingOrganisasiSatuSehat;
    private widget.ButtonBig btnMapingVaksinSatuSehat;
    private widget.ButtonBig btnMasterAturanPakai;
    private widget.ButtonBig btnMasterCaraBayar;
    private widget.ButtonBig btnMasterDTD;
    private widget.ButtonBig btnMasterDiagnosaGizi;
    private widget.ButtonBig btnMasterFaktorResikoJatuh;
    private widget.ButtonBig btnMasterFaskes;
    private widget.ButtonBig btnMasterIndikatorNasionalMutu;
    private widget.ButtonBig btnMasterJabatanKomite;
    private widget.ButtonBig btnMasterJenisDokumenJangMed;
    private widget.ButtonBig btnMasterKasusPersalinanDinkes;
    private widget.ButtonBig btnMasterKeluhanPsikologis;
    private widget.ButtonBig btnMasterMasalahKeperawatan;
    private widget.ButtonBig btnMasterNomorDokumen;
    private widget.ButtonBig btnMasterNumdenomINM;
    private widget.ButtonBig btnMasterRencanaTritmenPsikologis;
    private widget.ButtonBig btnMasterResikoDecubitus;
    private widget.ButtonBig btnMerkInventaris;
    private widget.ButtonBig btnMonevAsuhanGizi;
    private widget.ButtonBig btnMonitoringEWSDewasa;
    private widget.ButtonBig btnMonitoringKlaimBPJS;
    private widget.ButtonBig btnMonitoringPediatricEWS;
    private widget.ButtonBig btnMutasiBarang;
    private widget.ButtonBig btnNotepad;
    private widget.ButtonBig btnObat;
    private widget.ButtonBig btnObatPenyakit;
    private widget.ButtonBig btnObatPerCaraBayar;
    private widget.ButtonBig btnObatPerTanggal;
    private widget.ButtonBig btnOpname;
    private widget.ButtonBig btnPaketOperasi;
    private widget.ButtonBig btnPasien;
    private widget.ButtonBig btnPasienCorona;
    private widget.ButtonBig btnPasienMati;
    private widget.ButtonBig btnPasienPonek;
    private widget.ButtonBig btnPaymentPoint;
    private widget.ButtonBig btnPegawai;
    private widget.ButtonBig btnPemantauanHarian24Jam;
    private widget.ButtonBig btnPemasukanLain;
    private widget.ButtonBig btnPembelian;
    private widget.ButtonBig btnPembelianIpsrs;
    private widget.ButtonBig btnPemberianObat;
    private widget.ButtonBig btnPemesanan;
    private widget.ButtonBig btnPengajuanKlaimINACBGrz;
    private widget.ButtonBig btnPengambilanPenunjangUTD;
    private widget.ButtonBig btnPengambilanPenunjangUTD2;
    private widget.ButtonBig btnPengambilanUTD;
    private widget.ButtonBig btnPengambilanUTD2;
    private widget.ButtonBig btnPengaturanRekening;
    private widget.ButtonBig btnPengelolaanTransfusiDarah;
    private widget.ButtonBig btnPengeluaran;
    private widget.ButtonBig btnPengeluaranIpsrs;
    private widget.ButtonBig btnPenggajian;
    private widget.ButtonBig btnPenilaianAwalKeperawatanKebidananRalan;
    private widget.ButtonBig btnPenilaianAwalKeperawatanRalan;
    private widget.ButtonBig btnPenilaianAwalMedisRalanGeriatri;
    private widget.ButtonBig btnPenilaianAwalMedisRalanMata;
    private widget.ButtonBig btnPenilaianAwalMedisRalanTHT;
    private widget.ButtonBig btnPenilaianTambahanGeriatri;
    private widget.ButtonBig btnPenjualan;
    private widget.ButtonBig btnPenjualanPerTanggal;
    private widget.ButtonBig btnPenyakitPD3I;
    private widget.ButtonBig btnPerawatanPasienCorona;
    private widget.ButtonBig btnPerencanaanPulang;
    private widget.ButtonBig btnPeriksaRadiologi;
    private widget.ButtonBig btnPermintaanLab;
    private widget.ButtonBig btnPermintaanRadiologi;
    private widget.ButtonBig btnPersetujuanTindakan;
    private widget.ButtonBig btnPerusahaan;
    private widget.ButtonBig btnPetugasPelaksanaPemberianObat;
    private widget.ButtonBig btnPiutang;
    private widget.ButtonBig btnPiutangBelumLunas;
    private widget.ButtonBig btnPiutangPerCaraBayar;
    private widget.ButtonBig btnPiutangRalan;
    private widget.ButtonBig btnPiutangRanap;
    private widget.ButtonBig btnPnyMenularRalan;
    private widget.ButtonBig btnPnyMenularRanap;
    private widget.ButtonBig btnPnyTakMenularRalan;
    private widget.ButtonBig btnPnyTakMenularRanap;
    private widget.ButtonBig btnPostingJurnal;
    private widget.ButtonBig btnPotonganBiaya;
    private widget.ButtonBig btnProdusenInventaris;
    private widget.ButtonBig btnProgramPRBBPJS;
    private widget.ButtonBig btnProtokolKemoterapi;
    private widget.ButtonBig btnRBiayaIpsrs;
    private widget.ButtonBig btnRHKeluarIpsrs;
    private widget.ButtonBig btnRHMasukIpsrs;
    private widget.ButtonBig btnRalan;
    private widget.ButtonBig btnRalanMasuk;
    private widget.ButtonBig btnRanap;
    private widget.ButtonBig btnRanapMasuk;
    private widget.ButtonBig btnReferensiDokterSatuSehat;
    private widget.ButtonBig btnReferensiPasienSatuSehat;
    private widget.ButtonBig btnRegistrasi;
    private widget.ButtonBig btnRekamPsikologiPerkawinan;
    private widget.ButtonBig btnRekamPsikologisAnak;
    private widget.ButtonBig btnRekamPsikologisDewasa;
    private widget.ButtonBig btnRekapPershift;
    private widget.ButtonBig btnRekening;
    private widget.ButtonBig btnRekeningTahun;
    private widget.ButtonBig btnRencanaKontrolBPJS;
    private widget.ButtonBig btnResepObat;
    private widget.ButtonBig btnResepPulang;
    private widget.ButtonBig btnResume;
    private widget.ButtonBig btnReturBeli;
    private widget.ButtonBig btnReturJual;
    private widget.ButtonBig btnReturPasien;
    private widget.ButtonBig btnReturPiutang;
    private widget.ButtonBig btnRincianPiutangPasien;
    private widget.ButtonBig btnRingkasanPulangRanap;
    private widget.ButtonBig btnRiwayatBarangMedis;
    private widget.ButtonBig btnRl32;
    private widget.ButtonBig btnRl33;
    private widget.ButtonBig btnRl34;
    private widget.ButtonBig btnRl36;
    private widget.ButtonBig btnRl37;
    private widget.ButtonBig btnRl38;
    private widget.ButtonBig btnRl4a;
    private widget.ButtonBig btnRl4asebab;
    private widget.ButtonBig btnRl4b;
    private widget.ButtonBig btnRl4bsebab;
    private widget.ButtonBig btnRuangInventaris;
    private widget.ButtonBig btnRujukKeluarVclaim;
    private widget.ButtonBig btnRujukMasuk;
    private widget.ButtonBig btnRujukPasien;
    private widget.ButtonBig btnRujukanKeluarSisrute;
    private widget.ButtonBig btnRujukanMasukSisrute;
    private widget.ButtonBig btnSKDPbpjs;
    private widget.ButtonBig btnSPRIbpjsVclaim;
    private widget.ButtonBig btnSatuan;
    private widget.ButtonBig btnSensusHarianPoli;
    private widget.ButtonBig btnSetBiayaHarian;
    private widget.ButtonBig btnSetBiayaMasukSekali;
    private widget.ButtonBig btnSetHargaKamar;
    private widget.ButtonBig btnSetObatRalan;
    private widget.ButtonBig btnSetObatRanap;
    private widget.ButtonBig btnSetOtoRalan;
    private widget.ButtonBig btnSetPenjab;
    private widget.ButtonBig btnSetingBridging;
    private widget.ButtonBig btnSetupAplikasi;
    private widget.ButtonBig btnSetupEmbalase;
    private widget.ButtonBig btnSetupHarga;
    private widget.ButtonBig btnSetupJamInap;
    private widget.ButtonBig btnSetupNota;
    private widget.ButtonBig btnSetupOtoLokasi;
    private widget.ButtonBig btnSetupRM;
    private widget.ButtonBig btnSetupTarif;
    private widget.ButtonBig btnSirkulasi;
    private widget.ButtonBig btnSirkulasi2;
    private widget.ButtonBig btnSirkulasiInventaris;
    private widget.ButtonBig btnSkriningGiziUlang;
    private widget.ButtonBig btnSpirometri;
    private widget.ButtonBig btnStokObatPasien;
    private widget.ButtonBig btnSuplier;
    private widget.ButtonBig btnSuplierIPSRS;
    private widget.ButtonBig btnSuratIstirahatSakit;
    private widget.ButtonBig btnSuratJawabanKonsulRanap;
    private widget.ButtonBig btnSuratKeteranganDisabilitas;
    private widget.ButtonBig btnSuratKeteranganDokter;
    private widget.ButtonBig btnSuratKeteranganNAPZA;
    private widget.ButtonBig btnSuratKeteranganRohani;
    private widget.ButtonBig btnSuratKeteranganSakit;
    private widget.ButtonBig btnSuratKonsulUnitRanap;
    private widget.ButtonBig btnSurveilansPD3I;
    private widget.ButtonBig btnSurveilansRalan;
    private widget.ButtonBig btnSurveilansRanap;
    private widget.ButtonBig btnTagihanMasuk;
    private widget.ButtonBig btnTagihanOperasi;
    private widget.ButtonBig btnTambahanBiaya;
    private widget.ButtonBig btnTarifLab;
    private widget.ButtonBig btnTarifRadiologi;
    private widget.ButtonBig btnTarifUtd;
    private widget.ButtonBig btnTindakanRalan;
    private widget.ButtonBig btnTindakanRanap;
    private widget.ButtonBig btnToolIGD;
    private widget.ButtonBig btnToolLab;
    private widget.ButtonBig btnToolRad;
    private widget.ButtonBig btnTracker;
    private widget.ButtonBig btnTransaksiPanjar;
    private widget.ButtonBig btnTransferPasienTindakan;
    private widget.ButtonBig btnTransferSerahTerimaPasien;
    private widget.ButtonBig btnUTDCekalDarah;
    private widget.ButtonBig btnUTDDonorDarah;
    private widget.ButtonBig btnUTDKomponenDarah;
    private widget.ButtonBig btnUTDMedisRusak;
    private widget.ButtonBig btnUTDPemisahanDarah;
    private widget.ButtonBig btnUTDPenunjangRusak;
    private widget.ButtonBig btnUTDPenyerahanDarah;
    private widget.ButtonBig btnUTDStokDarah;
    private widget.ButtonBig btnUser;
    private widget.ButtonBig btnakun_bayar;
    private widget.ButtonBig btnbayar_pemesanan;
    private widget.ButtonBig btnfee_visit_dokter;
    private widget.Button button1;
    private widget.ComboBox cmbMenu;
    private widget.TextBox edAdmin;
    private widget.PasswordBox edPwd;
    public javax.swing.JLabel footer_lbl_update;
    private widget.InternalFrame internalFrame1;
    private widget.InternalFrame internalFrame2;
    private widget.InternalFrame internalFrame3;
    private widget.InternalFrame internalFrame4;
    private widget.InternalFrame internalFrame6;
    private widget.Label jLabel10;
    private javax.swing.JLabel jLabel11;
    private widget.Label jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private widget.Label jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel kdUser;
    private widget.TextArea ket_update;
    private widget.Label label35;
    private widget.Label label36;
    private javax.swing.JLabel lblStts;
    private javax.swing.JLabel lblTgl;
    private javax.swing.JLabel lblUser;
    public javax.swing.JLabel lbl_update;
    private usu.widget.glass.PanelGlass panelGlass1;
    private usu.widget.glass.PanelGlass panelJudul;
    private widget.InternalFrame panelMenu;
    private widget.panelisi panelisi2;
    private widget.ScrollPane scrollPane1;
    private widget.ScrollPane scrollPane2;
    private widget.Tanggal tanggal;
    // End of variables declaration//GEN-END:variables

    public void isTampil() {
        Panelmenu.removeAll();
        if (ChkInput.isSelected() == true) {
            isCombo();
        } else {
            if (TCari.getText().equals("")) {
                isCariKosong();
            } else if (!TCari.getText().equals("")) {
                isCariIsi();
            }
        }

        if (jmlmenu <= 1) {
            grid = 1;
        } else if (jmlmenu <= 4) {
            grid = 2;
        } else if (jmlmenu <= 9) {
            grid = 3;
        } else if (jmlmenu <= 16) {
            grid = 4;
        } else if (jmlmenu > 16) {
            grid = 5;
        }

        if (jmlmenu <= 20) {
            tinggi = scrollPane2.getHeight() - 5;
        } else if (jmlmenu <= 25) {
            tinggi = scrollPane2.getHeight() + (scrollPane2.getHeight() / 4);
        } else if (jmlmenu > 25) {
            tinggi = 1;
            for (i = 25; i < jmlmenu; i++) {
                if (i % 5 == 0) {
                    tinggi++;
                }
            }
            tinggi = scrollPane2.getHeight() + ((scrollPane2.getHeight() / 4) * tinggi);
        }

        Panelmenu.setLayout(new GridLayout(0, grid));
        Panelmenu.setPreferredSize(new Dimension(scrollPane2.getWidth() - 10, tinggi));
        Panelmenu.revalidate();
        Panelmenu.repaint();
        DlgHome.setVisible(true);
    }

    public void isWall() {
        try {
            ps = koneksi.prepareStatement("select nama_instansi, alamat_instansi, kabupaten, propinsi, aktifkan, wallpaper,kontak,email,logo from setting");
            try {
                rs = ps.executeQuery();
                while (rs.next()) {
                    jLabel8.setText(rs.getString(1));
                    this.setTitle("SIM " + rs.getString("nama_instansi"));
                    jLabel11.setText(rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getString(4) + " ");
                    akses.setnamars(rs.getString("nama_instansi"));
                    akses.setalamatrs(rs.getString("alamat_instansi"));
                    akses.setkabupatenrs(rs.getString("kabupaten"));
                    akses.setpropinsirs(rs.getString("propinsi"));
                    akses.setkontakrs(rs.getString("kontak"));
                    akses.setemailrs(rs.getString("email"));

                    if (rs.getString(5).equals("Yes")) {
                        Blob blob = rs.getBlob(6);
                        PanelWall.setBackgroundImage(new javax.swing.ImageIcon(blob.getBytes(1, (int) (blob.length()))));
                        repaint();
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Notifikasi : Silahkan Set Aplikasi " + e);
        }
    }

    private void isTutup() {
        if (akses.getform().equals("DlgKasirRalan")) {
            akses.tRefreshAntrian.stop();
            akses.tRefreshPoli.stop();
        }
        
        if (akses.getform().equals("DlgReg")) {
            akses.tRefreshAntri.stop();
        }
        
        if (akses.getform().equals("DlgDashboardEresep")) {
            DlgDashboardEresep dash = new DlgDashboardEresep(this, false);
            dash.tEresep.stop();
        }
        
        FlayMenu.setVisible(false);
        akses.setform("frmUtama");
        Window[] wins = Window.getWindows();
        for (Window win : wins) {
            if (win instanceof JDialog) {
                win.dispose();
            }
        }
    }

    private void setToolbar() {
        setExtendedState(MAXIMIZED_BOTH);
        if (internalFrame1.getWidth() < (BtnMenu.getWidth() + btnGantiPassword.getWidth() + BtnToolReg.getWidth() 
                + btnToolIGD.getWidth() + btnBridgingEklaim.getWidth() +  btnToolLab.getWidth()
                + btnToolRad.getWidth() + BtnToolJualObat.getWidth() + BtnToolKamnap.getWidth()
                + BtnToolKasir.getWidth() + BtnLog.getWidth() + BtnClose.getWidth() + 8)) {
            internalFrame1.setSize(new Dimension(PanelUtama.getWidth(), 90));
        } else {
            internalFrame1.setSize(new Dimension(PanelUtama.getWidth(), 44));
        }
    }

    private void isCombo() {
        if (cmbMenu.getSelectedIndex() == 0) {
            jmlmenu = 0;
            if (akses.getinformasi_kamar() == true) {
                Panelmenu.add(btnAnalisaKamar);
                jmlmenu++;
            }

            if (akses.getjadwal_praktek() == true) {
                Panelmenu.add(BtnJadwal);
                jmlmenu++;
            }
            
            if (akses.getoperasi() == true) {
                Panelmenu.add(btnJadwalOperasi);
                jmlmenu++;
            }

            if (akses.getbooking_registrasi() == true) {
                Panelmenu.add(btnBookingReg);
                jmlmenu++;
            }

            if (akses.getpermintaan_lab() == true) {
                Panelmenu.add(btnPermintaanLab);
                jmlmenu++;
            }

            if (akses.getpermintaan_radiologi() == true) {
                Panelmenu.add(btnPermintaanRadiologi);
                jmlmenu++;
            }

            if (akses.getregistrasi() == true) {
                Panelmenu.add(btnRegistrasi);
                jmlmenu++;
            }

            if (akses.getigd() == true) {
                Panelmenu.add(btnIGD);
                jmlmenu++;
            }

            if (akses.gettindakan_ralan() == true) {
                Panelmenu.add(btnRalan);
                jmlmenu++;
            }

            if (akses.getkamar_inap() == true) {
                Panelmenu.add(btnKamarInap);
                jmlmenu++;
            }

            if (akses.getdpjp_ranap() == true) {
                Panelmenu.add(BtnDpjp);
                jmlmenu++;
            }

            if (akses.gettindakan_ranap() == true) {
                Panelmenu.add(btnRanap);
                jmlmenu++;
            }

            if (akses.getoperasi() == true) {
                Panelmenu.add(btnTagihanOperasi);
                jmlmenu++;
            }

            if (akses.getrujukan_keluar() == true) {
                Panelmenu.add(btnRujukPasien);
                jmlmenu++;
            }

            if (akses.getrujukan_masuk() == true) {
                Panelmenu.add(btnRujukMasuk);
                jmlmenu++;
            }

            if (akses.getberi_obat() == true) {
                Panelmenu.add(btnBeriObat);
                jmlmenu++;
            }

            if (akses.getresep_pulang() == true) {
                Panelmenu.add(btnResepPulang);
                jmlmenu++;
            }

            if (akses.getresep_obat() == true) {
                Panelmenu.add(btnResepObat);
                jmlmenu++;
            }

            if (akses.getdiet_pasien() == true) {
                Panelmenu.add(btnDiet);
                jmlmenu++;
            }

            if (akses.getperiksa_lab() == true) {
                Panelmenu.add(btnLaboratorium);
                jmlmenu++;
            }

            if (akses.getperiksa_radiologi() == true) {
                Panelmenu.add(btnPeriksaRadiologi);
                jmlmenu++;
            }

            if (akses.getkasir_ralan() == true) {
                Panelmenu.add(btnKasir);
                jmlmenu++;
            }

            if (akses.getdeposit_pasien() == true) {
                Panelmenu.add(btnDeposit);
                jmlmenu++;
            }
        } else if (cmbMenu.getSelectedIndex() == 1) {
            jmlmenu = 0;
            if (akses.getcppt() == true) {
                Panelmenu.add(btnPerencanaanPulang);
                jmlmenu++;
            }
            
            if (akses.getkegiatan_operasi() == true) {
                Panelmenu.add(btnAsesmenKeperawatanPerioperatif);
                jmlmenu++;
            }
            
            if (akses.getkegiatan_operasi() == true) {
                Panelmenu.add(btnCeklisPraOperasi);
                jmlmenu++;
            }
            
            if (akses.getkegiatan_operasi() == true) {
                Panelmenu.add(btnCeklisKesiapanAnestesi);
                jmlmenu++;
            }
            
            if (akses.getpemberian_obat() == true) {
                Panelmenu.add(btnTransferSerahTerimaPasien);
                jmlmenu++;
            }
            
            if (akses.getcppt()== true) {
                Panelmenu.add(btnCPPT);
                jmlmenu++;
            }
            
            if (akses.getcppt()== true) {
                Panelmenu.add(btnTransferPasienTindakan);
                jmlmenu++;
            }
            
            if (akses.getcppt()== true) {
                Panelmenu.add(btnLembarObservasi);
                jmlmenu++;
            }
            
            if (akses.getringkasanpulangranap() == true) {
                Panelmenu.add(btnRingkasanPulangRanap);
                jmlmenu++;
            }
            
            if (akses.getresep_dokter()== true) {
                Panelmenu.add(btnAsesmenPraSedasi);
                jmlmenu++;
            }
            
            if (akses.getresep_dokter()== true) {
                Panelmenu.add(btnAsesmenPreInduksi);
                jmlmenu++;
            }
            
            if (akses.getasesmen_medik_dewasa_ranap()== true) {
                Panelmenu.add(btnAsesmenMedikDewasaRanap);
                jmlmenu++;
            }
            
            if (akses.getasesmen_medik_anak_ranap()== true) {
                Panelmenu.add(btnAsesmenMedikAnakRanap);
                jmlmenu++;
            }
            
            if (akses.getcppt()== true) {
                Panelmenu.add(btnAsesmenRestrain);
                jmlmenu++;
            }
            
            if (akses.getcppt() == true) {
                Panelmenu.add(btnPemantauanHarian24Jam);
                jmlmenu++;
            }
            
            if (akses.getcppt() == true) {
                Panelmenu.add(btnPersetujuanTindakan);
                jmlmenu++;
            }
            
            if (akses.getcppt() == true) {
                Panelmenu.add(btnCatatanTindakanKeperawatan);
                jmlmenu++;
            }
            
            if (akses.getassesmen_gizi_harian() == true) {
                Panelmenu.add(btnAsuhanGiziRanap);
                jmlmenu++;
            }
            
            if (akses.getassesmen_gizi_harian() == true) {
                Panelmenu.add(btnSkriningGiziUlang);
                jmlmenu++;
            }

            if (akses.getassesmen_gizi_ulang() == true) {
                Panelmenu.add(btnAssesmenUlangGizi);
                jmlmenu++;
            }

            if (akses.getmonev_asuhan_gizi() == true) {
                Panelmenu.add(btnMonevAsuhanGizi);
                jmlmenu++;
            }
            
            if (akses.getcppt()== true) {
                Panelmenu.add(btnMonitoringEWSDewasa);
                jmlmenu++;
            }
            
            if (akses.getcppt()== true) {
                Panelmenu.add(btnMonitoringPediatricEWS);
                jmlmenu++;
            }
            
            if (akses.getcppt()== true) {
                Panelmenu.add(btnPengelolaanTransfusiDarah);
                jmlmenu++;
            }
            
            if (akses.getcppt()== true) {
                Panelmenu.add(btnAsesmenUlangResikoJatuhDewasa);
                jmlmenu++;
            }
            
            if (akses.getcppt()== true) {
                Panelmenu.add(btnAsesmenUlangResikoJatuhAnak);
                jmlmenu++;
            }
            
            if (akses.getkemoterapi() == true) {
                Panelmenu.add(btnProtokolKemoterapi);
                jmlmenu++;
            }
            
            if (akses.getpenilaian_awal_keperawatan_kebidanan()== true) {
                Panelmenu.add(btnAsesmenKebidananRalan);
                jmlmenu++;
            }
            
            if (akses.getpenilaian_awal_medis_ralan_mata() == true) {
                Panelmenu.add(btnPenilaianAwalMedisRalanMata);
                jmlmenu++;
            }
            
            if (akses.getcppt() == true) {
                Panelmenu.add(btnAsesmenKeperawatanDewasa);
                jmlmenu++;
            }
            
            if (akses.getcppt() == true) {
                Panelmenu.add(btnAsesmenKeperawatanAnak);
                jmlmenu++;
            }
            
            if (akses.getresep_dokter() == true) {
                Panelmenu.add(btnAssesmenMedikIGD);
                jmlmenu++;
            }
            
            if (akses.getpenilaian_awal_keperawatan_ralan() == true) {
                Panelmenu.add(btnAssesmenKeperawatanIGD);
                jmlmenu++;
            }
            
            if (akses.getpenilaian_awal_medis_ralan_tht() == true) {
                Panelmenu.add(btnPenilaianAwalMedisRalanTHT);
                jmlmenu++;
            }

            if (akses.getpenilaian_awal_keperawatan_ralan() == true) {
                Panelmenu.add(btnPenilaianAwalKeperawatanRalan);
                jmlmenu++;
            }

            if (akses.getpenilaian_awal_medis_ralan_kebidanan() == true) {
                Panelmenu.add(btnAsesmenMedikObstetriRalan);
                jmlmenu++;
            }

            if (akses.getpenilaian_awal_keperawatan_kebidanan() == true) {
                Panelmenu.add(btnPenilaianAwalKeperawatanKebidananRalan);
                jmlmenu++;
            }
            
            if (akses.getdata_triase_igd() == true) {
                Panelmenu.add(btnDataTriaseIGD);
                jmlmenu++;
            }
            
            if (akses.getpenilaian_pasien_geriatri() == true) {
                Panelmenu.add(btnPenilaianTambahanGeriatri);
                jmlmenu++;
            }
            
            if (akses.getpenilaian_pasien_geriatri() == true) {
                Panelmenu.add(btnPenilaianAwalMedisRalanGeriatri);
                jmlmenu++;
            }
        } else if (cmbMenu.getSelectedIndex() == 2) {
            jmlmenu = 0;
            Panelmenu.add(btnNotepad);
            jmlmenu++;
            
            if (akses.getadmin()== true) {
                Panelmenu.add(btnMasterNomorDokumen);
                jmlmenu++;
            }
            
            if (akses.getpetugas() == true) {
                Panelmenu.add(btnPegawai);
                jmlmenu++;
            }

            if (akses.getdokter() == true) {
                Panelmenu.add(btnDokter);
                jmlmenu++;
            }

            if (akses.getpegawai_admin() == true) {
                Panelmenu.add(btnDataJabatan);
                jmlmenu++;
            }
            
            if (akses.getpegawai_admin() == true) {
                Panelmenu.add(btnMasterJabatanKomite);
                jmlmenu++;
            }

            if ((akses.getpegawai_admin() == true) || (akses.getpegawai_user() == true)) {
                Panelmenu.add(btnPenggajian);
                jmlmenu++;
            }
        } else if (cmbMenu.getSelectedIndex() == 3) {
            jmlmenu = 0;
            if (akses.getpemberian_obat()== true) {
                Panelmenu.add(btnPemberianObat);
                jmlmenu++;
            }
            
            if (akses.getpemberian_obat()== true) {
                Panelmenu.add(btnPetugasPelaksanaPemberianObat);
                jmlmenu++;
            }
            
            if (akses.getindustrifarmasi() == true) {
                Panelmenu.add(btnIndustriFarmasi);
                jmlmenu++;
            }

            if (akses.getsuplier() == true) {
                Panelmenu.add(btnSuplier);
                jmlmenu++;
            }

            if (akses.getsatuan_barang() == true) {
                Panelmenu.add(btnSatuan);
                jmlmenu++;
            }

            if (akses.getkonversi_satuan() == true) {
                Panelmenu.add(btnKonversi);
                jmlmenu++;
            }

            if (akses.getdashboard_eResep() == true) {
                Panelmenu.add(btnDashboardeResepRalan);
                jmlmenu++;
            }
            
            if (akses.getdashboard_eResep() == true) {
                Panelmenu.add(btnDashboardeResepRanap);
                jmlmenu++;
            }

            if (akses.getjenis_barang() == true) {
                Panelmenu.add(btnJnsBarang);
                jmlmenu++;
            }

            if (akses.getkategori_barang() == true) {
                Panelmenu.add(btnKategoriBarang);
                jmlmenu++;
            }

            if (akses.getgolongan_barang() == true) {
                Panelmenu.add(btnGolonganBarang);
                jmlmenu++;
            }

            if (akses.getobat() == true) {
                Panelmenu.add(btnObat);
                jmlmenu++;
            }
            
            if (akses.getresep_obat() == true) {
                Panelmenu.add(btnMasterAturanPakai);
                jmlmenu++;
            }

            if (akses.getstok_opname_obat() == true) {
                Panelmenu.add(btnOpname);
                jmlmenu++;
            }

            if (akses.getmutasi_barang() == true) {
                Panelmenu.add(btnMutasiBarang);
                jmlmenu++;
            }

            if (akses.getlaporanfarmasi() == true) {
                Panelmenu.add(btnLaporanFarmasi);
                jmlmenu++;
            }

            if (akses.getstok_obat_pasien() == true) {
                Panelmenu.add(btnStokObatPasien);
                jmlmenu++;
            }

            if (akses.getpengadaan_obat() == true) {
                Panelmenu.add(btnPembelian);
                jmlmenu++;
            }

            if (akses.getpemesanan_obat() == true) {
                Panelmenu.add(btnPemesanan);
                jmlmenu++;
            }

            if (akses.getpenjualan_obat() == true) {
                Panelmenu.add(btnPenjualan);
                jmlmenu++;
            }

            if (akses.getresep_dokter() == true) {
                Panelmenu.add(btnDaftarPermintaanResep);
                jmlmenu++;
            }

            if (akses.getpiutang_obat() == true) {
                Panelmenu.add(btnPiutang);
                jmlmenu++;
            }

            if (akses.getretur_ke_suplier() == true) {
                Panelmenu.add(btnReturBeli);
                jmlmenu++;
            }

            if (akses.getretur_dari_pembeli() == true) {
                Panelmenu.add(btnReturJual);
                jmlmenu++;
            }

            if (akses.getretur_obat_ranap() == true) {
                Panelmenu.add(btnReturPasien);
                jmlmenu++;
            }

            if (akses.getretur_piutang_pasien() == true) {
                Panelmenu.add(btnReturPiutang);
                jmlmenu++;
            }

            if (akses.getpengambilan_utd() == true) {
                Panelmenu.add(btnPengambilanUTD);
                jmlmenu++;
            }

            if (akses.getkeuntungan_penjualan() == true) {
                Panelmenu.add(btnKeuntungan);
                jmlmenu++;
            }

            if (akses.getkeuntungan_beri_obat() == true) {
                Panelmenu.add(btnKeuntunganObatRanap);
                jmlmenu++;
            }

            if (akses.getkeuntungan_beri_obat_nonpiutang() == true) {
                Panelmenu.add(btnKeuntunganObat2);
                jmlmenu++;
            }

            if (akses.getsirkulasi_obat() == true) {
                Panelmenu.add(btnSirkulasi);
                jmlmenu++;
            }

            if (akses.getsirkulasi_obat2() == true) {
                Panelmenu.add(btnSirkulasi2);
                jmlmenu++;
            }

            if (akses.getpemberian_obat_pertanggal() == true) {
                Panelmenu.add(btnObatPerTanggal);
                jmlmenu++;
            }

            if (akses.getpenjualan_obat_pertanggal() == true) {
                Panelmenu.add(btnPenjualanPerTanggal);
                jmlmenu++;
            }

            if (akses.getriwayat_obat_alkes_bhp() == true) {
                Panelmenu.add(btnRiwayatBarangMedis);
                jmlmenu++;
            }

            if (akses.getdarurat_stok() == true) {
                Panelmenu.add(btnDaruratStok);
                jmlmenu++;
            }
        } else if (cmbMenu.getSelectedIndex() == 4) {
            jmlmenu = 0;
            if (akses.getsatuan_barang() == true) {
                Panelmenu.add(btnSatuan);
                jmlmenu++;
            }

            if (akses.getipsrs_jenis_barang() == true) {
                Panelmenu.add(btnJenisIpsrs);
                jmlmenu++;
            }

            if (akses.getipsrs_barang() == true) {
                Panelmenu.add(btnBarangIpsrs);
                jmlmenu++;
            }

            if (akses.getsuplier_penunjang() == true) {
                Panelmenu.add(btnSuplierIPSRS);
                jmlmenu++;
            }

            if (akses.getipsrs_pengadaan_barang() == true) {
                Panelmenu.add(btnPembelianIpsrs);
                jmlmenu++;
            }

            if (akses.getipsrs_stok_keluar() == true) {
                Panelmenu.add(btnPengeluaranIpsrs);
                jmlmenu++;
            }

            if (akses.getipsrs_pengeluaran_harian() == true) {
                Panelmenu.add(btnRBiayaIpsrs);
                jmlmenu++;
            }

            if (akses.getipsrs_rekap_pengadaan() == true) {
                Panelmenu.add(btnRHMasukIpsrs);
                jmlmenu++;
            }

            if (akses.getipsrs_rekap_stok_keluar() == true) {
                Panelmenu.add(btnRHKeluarIpsrs);
                jmlmenu++;
            }

            if (akses.getpengambilan_penunjang_utd() == true) {
                Panelmenu.add(btnPengambilanPenunjangUTD);
                jmlmenu++;
            }

        } else if (cmbMenu.getSelectedIndex() == 5) {
            jmlmenu = 0;
            if (akses.getadmin()== true) {
                Panelmenu.add(btnBangsal);
                jmlmenu++;
            }
            
            if (akses.getinventaris_jenis() == true) {
                Panelmenu.add(btnJenisInventaris);
                jmlmenu++;
            }

            if (akses.getbarang_cssd() == true) {
                Panelmenu.add(btnBarangCSSD);
                jmlmenu++;
            }

            if (akses.getinventaris_kategori() == true) {
                Panelmenu.add(btnKategoriInventaris);
                jmlmenu++;
            }

            if (akses.getinventaris_merk() == true) {
                Panelmenu.add(btnMerkInventaris);
                jmlmenu++;
            }

            if (akses.getinventaris_ruang() == true) {
                Panelmenu.add(btnRuangInventaris);
                jmlmenu++;
            }

            if (akses.getinventaris_produsen() == true) {
                Panelmenu.add(btnProdusenInventaris);
                jmlmenu++;
            }

            if (akses.getinventaris_koleksi() == true) {
                Panelmenu.add(btnBarangInventaris);
                jmlmenu++;
            }

            if (akses.getinventaris_inventaris() == true) {
                Panelmenu.add(btnInventaris);
                jmlmenu++;
            }

            if (akses.getinventaris_sirkulasi() == true) {
                Panelmenu.add(btnSirkulasiInventaris);
                jmlmenu++;
            }
        } else if (cmbMenu.getSelectedIndex() == 6) {
            jmlmenu = 0;
            if (akses.getpermintaan_lab()== true) {
                Panelmenu.add(btnSuratKonsulUnitRanap);
                jmlmenu++;
            }
            
            if (akses.getpermintaan_lab()== true) {
                Panelmenu.add(btnSuratJawabanKonsulRanap);
                jmlmenu++;
            }
            
            if (akses.getsurat_keterangan_kir_mcu() == true) {
                Panelmenu.add(btnSuratKeteranganDokter);
                jmlmenu++;
            }
            
            if (akses.getsurat_keterangan_kir_mcu() == true) {
                Panelmenu.add(btnSuratKeteranganDisabilitas);
                jmlmenu++;
            }
            
            if (akses.getsurat_keterangan_kir_mcu() == true) {
                Panelmenu.add(btnSuratKeteranganRohani);
                jmlmenu++;
            }
            
            if (akses.getsurat_keterangan_kir_mcu() == true) {
                Panelmenu.add(btnSuratKeteranganNAPZA);
                jmlmenu++;
            }
            
            if (akses.getsurat_sakit() == true) {
                Panelmenu.add(btnSuratIstirahatSakit);
                jmlmenu++;
            }
            
            if (akses.getsurat_sakit() == true) {
                Panelmenu.add(btnSuratKeteranganSakit);
                jmlmenu++;
            }
        } else if (cmbMenu.getSelectedIndex() == 7) {
            jmlmenu = 0;
            if (akses.getbilling_ranap() == true) {
                Panelmenu.add(btnTransaksiPanjar);
                jmlmenu++;
            }
            
            if (akses.getobat_per_cara_bayar() == true) {
                Panelmenu.add(btnObatPerCaraBayar);
                jmlmenu++;
            }

            if (akses.getfee_visit_dokter() == true) {
                Panelmenu.add(btnfee_visit_dokter);
                jmlmenu++;
            }

            if (akses.getpembayaran_ralan() == true) {
                Panelmenu.add(btnRalanMasuk);
                jmlmenu++;
            }

            if (akses.getpembayaran_ranap() == true) {
                Panelmenu.add(btnRanapMasuk);
                jmlmenu++;
            }

            if (akses.getpiutang_pasien() == true) {
                Panelmenu.add(btnLihatPiutang);
                jmlmenu++;
            }

            if (akses.getpiutang_ralan() == true) {
                Panelmenu.add(btnPiutangRalan);
                jmlmenu++;
            }

            if (akses.getpiutang_ranap() == true) {
                Panelmenu.add(btnPiutangRanap);
                jmlmenu++;
            }

            if (akses.gettagihan_masuk() == true) {
                Panelmenu.add(btnTagihanMasuk);
                jmlmenu++;
            }

            if (akses.gettambahan_biaya() == true) {
                Panelmenu.add(btnTambahanBiaya);
                jmlmenu++;
            }

            if (akses.getpotongan_biaya() == true) {
                Panelmenu.add(btnPotonganBiaya);
                jmlmenu++;
            }

            if (akses.getdeposit_pasien() == true) {
                Panelmenu.add(btnDeposit);
                jmlmenu++;
            }

            if (akses.getrekap_per_shift() == true) {
                Panelmenu.add(btnRekapPershift);
                jmlmenu++;
            }

            if (akses.getpayment_point() == true) {
                Panelmenu.add(btnPaymentPoint);
                jmlmenu++;
            }
        } else if (cmbMenu.getSelectedIndex() == 8) {
            jmlmenu = 0;
            if (akses.geticd9() == true) {
                Panelmenu.add(btnICD9);
                jmlmenu++;
            }
            
            if (akses.getrekam_psikologis() == true) {
                Panelmenu.add(btnRekamPsikologisDewasa);
                jmlmenu++;
            }
            
            if (akses.getrekam_psikologis() == true) {
                Panelmenu.add(btnRekamPsikologisAnak);
                jmlmenu++;
            }
            
            if (akses.getrekam_psikologis() == true) {
                Panelmenu.add(btnRekamPsikologiPerkawinan);
                jmlmenu++;
            }

            if (akses.getpenyakit() == true) {
                Panelmenu.add(btnICD);
                jmlmenu++;
            }

            if (akses.getpenyakit() == true) {
                Panelmenu.add(btnMasterDTD);
                jmlmenu++;
            }
            
            if (akses.getrekam_psikologis() == true) {
                Panelmenu.add(btnMasterKeluhanPsikologis);
                jmlmenu++;
            }

            if (akses.getrekam_psikologis() == true) {
                Panelmenu.add(btnMasterRencanaTritmenPsikologis);
                jmlmenu++;
            }
            
            if (akses.getpenyakit_pd3i() == true) {
                Panelmenu.add(btnPenyakitPD3I);
                jmlmenu++;
            }

            if (akses.getsurveilans_pd3i() == true) {
                Panelmenu.add(btnSurveilansPD3I);
                jmlmenu++;
            }

            if (akses.getsurveilans_ralan() == true) {
                Panelmenu.add(btnSurveilansRalan);
                jmlmenu++;
            }

            if (akses.getsurveilans_ranap() == true) {
                Panelmenu.add(btnSurveilansRanap);
                jmlmenu++;
            }

            if (akses.getpny_takmenular_ralan() == true) {
                Panelmenu.add(btnPnyTakMenularRalan);
                jmlmenu++;
            }

            if (akses.getpny_takmenular_ranap() == true) {
                Panelmenu.add(btnPnyTakMenularRanap);
                jmlmenu++;
            }

            if (akses.getpenyakit_menular_ralan() == true) {
                Panelmenu.add(btnPnyMenularRalan);
                jmlmenu++;
            }

            if (akses.getpenyakit_menular_ranap() == true) {
                Panelmenu.add(btnPnyMenularRanap);
                jmlmenu++;
            }

            if (akses.getobat_penyakit() == true) {
                Panelmenu.add(btnObatPenyakit);
                jmlmenu++;
            }

            if (akses.getpenyakit_ralan() == true) {
                Panelmenu.add(btnFrekuensiRalan);
                jmlmenu++;
            }

            if (akses.getpenyakit_ranap() == true) {
                Panelmenu.add(btnFrekuensiRanap);
                jmlmenu++;
            }

            if (akses.getkunjungan_ralan() == true) {
                Panelmenu.add(btnKunjunganRalan);
                jmlmenu++;
            }

            if (akses.getkunjungan_ranap() == true) {
                Panelmenu.add(btnKunjunganRanap);
                jmlmenu++;
            }

            if (akses.getsensus_harian_poli() == true) {
                Panelmenu.add(btnSensusHarianPoli);
                jmlmenu++;
            }

            if (akses.getrl32() == true) {
                Panelmenu.add(btnRl32);
                jmlmenu++;
            }

            if (akses.getrl33() == true) {
                Panelmenu.add(btnRl33);
                jmlmenu++;
            }

            if (akses.getrl34() == true) {
                Panelmenu.add(btnRl34);
                jmlmenu++;
            }

            if (akses.getrl36() == true) {
                Panelmenu.add(btnRl36);
                jmlmenu++;
            }

            if (akses.getrl37() == true) {
                Panelmenu.add(btnRl37);
                jmlmenu++;
            }

            if (akses.getrl38() == true) {
                Panelmenu.add(btnRl38);
                jmlmenu++;
            }

            if (akses.getrl4a() == true) {
                Panelmenu.add(btnRl4a);
                jmlmenu++;
            }

            if (akses.getrl4b() == true) {
                Panelmenu.add(btnRl4b);
                jmlmenu++;
            }

            if (akses.getrl4asebab() == true) {
                Panelmenu.add(btnRl4asebab);
                jmlmenu++;
            }

            if (akses.getrl4bsebab() == true) {
                Panelmenu.add(btnRl4bsebab);
                jmlmenu++;
            }

            if (akses.getlama_pelayanan_ralan() == true) {
                Panelmenu.add(btnLamaPelayananRalan);
                jmlmenu++;
            }

            if (akses.getlama_pelayanan_apotek() == true) {
                Panelmenu.add(btnLamaPelayananApotek);
                jmlmenu++;
            }

            if (akses.getharian_HAIs() == true) {
                Panelmenu.add(btnHarianHAIsRS);
                jmlmenu++;
            }

            if (akses.getharianhaisinap() == true) {
                Panelmenu.add(btnHarianHAIsRanap);
                jmlmenu++;
            }

            if (akses.getharianhaisjalan() == true) {
                Panelmenu.add(btnHarianHAIsRalan);
                jmlmenu++;
            }

            if (akses.getbulanan_HAIs() == true) {
                Panelmenu.add(btnBulananHAIsRS);
                jmlmenu++;
            }

            if (akses.getbulananhaisinap() == true) {
                Panelmenu.add(btnBulananHAIsRanap);
                jmlmenu++;
            }

            if (akses.getbulananhaisjalan() == true) {
                Panelmenu.add(btnBulananHAIsRalan);
                jmlmenu++;
            }

            if (akses.getjumlah_macam_diet() == true) {
                Panelmenu.add(btnJumlahMacamDiet);
                jmlmenu++;
            }

            if (akses.getjumlah_porsi_diet() == true) {
                Panelmenu.add(btnJumlahPorsiDiet);
                jmlmenu++;
            }

            if (akses.getdata_persalinan() == true) {
                Panelmenu.add(btnDataPersalinan);
                jmlmenu++;
            }
        } else if (cmbMenu.getSelectedIndex() == 9) {
            jmlmenu = 0;
            if (akses.getkamar() == true) {
                Panelmenu.add(btnKamar);
                jmlmenu++;
            }

            if (akses.gettarif_ralan() == true) {
                Panelmenu.add(btnTindakanRalan);
                jmlmenu++;
            }

            if (akses.gettarif_ranap() == true) {
                Panelmenu.add(btnTindakanRanap);
                jmlmenu++;
            }

            if (akses.gettarif_lab() == true) {
                Panelmenu.add(btnTarifLab);
                jmlmenu++;
            }

            if (akses.gettarif_radiologi() == true) {
                Panelmenu.add(btnTarifRadiologi);
                jmlmenu++;
            }

            if (akses.gettarif_operasi() == true) {
                Panelmenu.add(btnPaketOperasi);
                jmlmenu++;
            }

            if (akses.gettarif_utd() == true) {
                Panelmenu.add(btnTarifUtd);
                jmlmenu++;
            }

            if (akses.getakun_rekening() == true) {
                Panelmenu.add(btnRekening);
                jmlmenu++;
            }

            if (akses.getrekening_tahun() == true) {
                Panelmenu.add(btnRekeningTahun);
                jmlmenu++;
            }

            if (akses.getakun_bayar() == true) {
                Panelmenu.add(btnakun_bayar);
                jmlmenu++;
            }

            if (akses.getakun_piutang() == true) {
                Panelmenu.add(btnAkunPiutang);
                jmlmenu++;
            }

            if (akses.getpengaturan_rekening() == true) {
                Panelmenu.add(btnPengaturanRekening);
                jmlmenu++;
            }

            if (akses.getpengeluaran() == true) {
                Panelmenu.add(btnPengeluaran);
                jmlmenu++;
            }

            if (akses.getpemasukan_lain() == true) {
                Panelmenu.add(btnPemasukanLain);
                jmlmenu++;
            }

            if (akses.getdeposit_pasien() == true) {
                Panelmenu.add(btnDeposit);
                jmlmenu++;
            }

            if (akses.getpiutang_pasien() == true) {
                Panelmenu.add(btnLihatPiutang);
                jmlmenu++;
            }

            if (akses.getrincian_piutang_pasien() == true) {
                Panelmenu.add(btnRincianPiutangPasien);
                jmlmenu++;
            }

            if (akses.getpiutang_pasien2() == true) {
                Panelmenu.add(btnPiutangBelumLunas);
                jmlmenu++;
            }

            if (akses.getdetail_piutang_penjab() == true) {
                Panelmenu.add(btnPiutangPerCaraBayar);
                jmlmenu++;
            }

            if (akses.getbayar_piutang() == true) {
                Panelmenu.add(btnBayarPiutang);
                jmlmenu++;
            }

            if (akses.gethutang_obat() == true) {
                Panelmenu.add(btnHutangObat);
                jmlmenu++;
            }

            if (akses.getbayar_pemesanan_obat() == true) {
                Panelmenu.add(btnbayar_pemesanan);
                jmlmenu++;
            }

            if (akses.getposting_jurnal() == true) {
                Panelmenu.add(btnPostingJurnal);
                jmlmenu++;
            }

            if (akses.getjurnal_harian() == true) {
                Panelmenu.add(btnJurnalHarian);
                jmlmenu++;
            }

            if (akses.getbuku_besar() == true) {
                Panelmenu.add(btnBubes);
                jmlmenu++;
            }

            if (akses.getcashflow() == true) {
                Panelmenu.add(btnCashFlow);
                jmlmenu++;
            }

            if (akses.getkeuangan() == true) {
                Panelmenu.add(btnLabaRugi);
                jmlmenu++;
            }

        } else if (cmbMenu.getSelectedIndex() == 10) {
            jmlmenu = 0;
            if (akses.getsatu_sehat() == true) {
                Panelmenu.add(btnReferensiDokterSatuSehat);
                jmlmenu++;
            }
            
            if (akses.getsatu_sehat() == true) {
                Panelmenu.add(btnReferensiPasienSatuSehat);
                jmlmenu++;
            }
            
            if (akses.getadmin() == true) {
                Panelmenu.add(btnMapingOrganisasiSatuSehat);
                jmlmenu++;
            }
            
            if (akses.getadmin() == true) {
                Panelmenu.add(btnMapingLokasiSatuSehat);
                jmlmenu++;
            }
            
            if (akses.getadmin() == true) {
                Panelmenu.add(btnMapingVaksinSatuSehat);
                jmlmenu++;
            }
            
            if (akses.getadmin() == true) {
                Panelmenu.add(btnMapingObatSatuSehat);
                jmlmenu++;
            }
            
            if (akses.getsatu_sehat() == true) {
                Panelmenu.add(btnKirimEncounterSatuSehat);
                jmlmenu++;
            }
            
            if (akses.getsatu_sehat() == true) {
                Panelmenu.add(btnKirimConditionSatuSehat);
                jmlmenu++;
            }
            
            if (akses.getsatu_sehat() == true) {
                Panelmenu.add(btnKirimObservationSatuSehat);
                jmlmenu++;
            }
            
            if (akses.getsatu_sehat() == true) {
                Panelmenu.add(btnKirimProsedurSatuSehat);
                jmlmenu++;
            }
            
            if (akses.getsatu_sehat() == true) {
                Panelmenu.add(btnKirimImunisasiSatuSehat);
                jmlmenu++;
            }
            
            if (akses.getsatu_sehat() == true) {
                Panelmenu.add(btnKirimClinicalSatuSehat);
                jmlmenu++;
            }
            
            if (akses.getsatu_sehat() == true) {
                Panelmenu.add(btnKirimDietSatuSehat);
                jmlmenu++;
            }
            
            if (akses.getsatu_sehat() == true) {
                Panelmenu.add(btnKirimMedicationRequestSatuSehat);
                jmlmenu++;
            }
            
            if (akses.getsatu_sehat() == true) {
                Panelmenu.add(btnKirimMedicationDispenseSatuSehat);
                jmlmenu++;
            }
            
            if (akses.getsisrute_rujukan_masuk() == true) {
                Panelmenu.add(btnRujukanMasukSisrute);
                jmlmenu++;
            }

            if (akses.getkemenkes_sitt() == true) {
                Panelmenu.add(btnKemenkesSITB);
                jmlmenu++;
            }

            if (akses.getkemenkes_kanker() == true) {
                Panelmenu.add(btnKemenkesKanker);
                jmlmenu++;
            }

            if (akses.getRencanaKontrolJKN() == true) {
                Panelmenu.add(btnRencanaKontrolBPJS);
                jmlmenu++;
            }

            if (akses.getkendali_mutu_kendali_biaya_inacbg() == true) {
                Panelmenu.add(btnKendaliMutuKendaliBiayaINACBG);
                jmlmenu++;
            }

            if (akses.getjkn_belum_diproses_klaim() == true) {
                Panelmenu.add(btnINACBGjknBelumDiklaim);
                jmlmenu++;
            }

            if (akses.getinacbg_klaim_raza() == true) {
                Panelmenu.add(btnBridgingEklaimINACBG);
                jmlmenu++;
            }

            if (akses.getpengajuan_klaim_raza() == true) {
                Panelmenu.add(btnPengajuanKlaimINACBGrz);
                jmlmenu++;
            }

            if (akses.getsisrute_rujukan_keluar() == true) {
                Panelmenu.add(btnRujukanKeluarSisrute);
                jmlmenu++;
            }

            if (akses.getsisrute_referensi_alasanrujuk() == true) {
                Panelmenu.add(btnCekSisruteAlasanRujuk);
                jmlmenu++;
            }

            if (akses.getsisrute_referensi_diagnosa() == true) {
                Panelmenu.add(btnCekSisruteDiagnosa);
                jmlmenu++;
            }

            if (akses.getsisrute_referensi_faskes() == true) {
                Panelmenu.add(btnCekSisruteFaskes);
                jmlmenu++;
            }

            if (akses.getbpjs_sep() == true) {
                Panelmenu.add(btnListSaranaRujukanBPJS);
                jmlmenu++;
            }

            if (akses.getbpjs_sep() == true) {
                Panelmenu.add(btnCekReferensiPoliHFISBPJS);
                jmlmenu++;
            }

            if (akses.getbpjs_sep() == true) {
                Panelmenu.add(btnCekReferensiJadwalHFISBPJS);
                jmlmenu++;
            }

            if (akses.getbpjs_sep() == true) {
                Panelmenu.add(btnCekReferensiDokterHFISBPJS);
                jmlmenu++;
            }

            if (akses.getbpjs_sep() == true) {
                Panelmenu.add(btnCekReferensiPendaftaranMobileJKNBPJS);
                jmlmenu++;
            }

            if (akses.getbpjs_sep() == true) {
                Panelmenu.add(btnCekReferensiBatalDaftarMobileJKNBPJS);
                jmlmenu++;
            }

            if (akses.getbpjs_sep() == true) {
                Panelmenu.add(btnKlaimJaminanJasaRaharja);
                jmlmenu++;
            }

            if (akses.getbpjs_sep() == true) {
                Panelmenu.add(btnDataSuplesiJasaRaharja);
                jmlmenu++;
            }

            if (akses.getbpjs_sep() == true) {
                Panelmenu.add(btnDataSEPIndukKLLJasaRaharja);
                jmlmenu++;
            }

            if (akses.getbpjs_sep() == true) {
                Panelmenu.add(btnDataNomorSuratKontrolBPJS);
                jmlmenu++;
            }

            if (akses.getbpjs_sep() == true) {
                Panelmenu.add(btnHistoriPelayananPesertaBPJS);
                jmlmenu++;
            }

            if (akses.getbpjs_sep() == true) {
                Panelmenu.add(btnProgramPRBBPJS);
                jmlmenu++;
            }

            if (akses.getbpjs_sep() == true) {
                Panelmenu.add(btnCekReferensiObatPRBBPJS);
                jmlmenu++;
            }

            if (akses.getskdp_bpjs() == true) {
                Panelmenu.add(btnSKDPbpjs);
                jmlmenu++;
            }

            if (akses.getSPRIJKN() == true) {
                Panelmenu.add(btnSPRIbpjsVclaim);
                jmlmenu++;
            }

            if (akses.getbpjs_rujukan_keluar() == true) {
                Panelmenu.add(btnRujukKeluarVclaim);
                jmlmenu++;
            }

            if (akses.getbpjs_cek_tgl_rujukan() == true) {
                Panelmenu.add(btnCekBPJSTanggalRujukan);
                jmlmenu++;
            }

            if (akses.getbpjs_cek_no_rujukan_rs() == true) {
                Panelmenu.add(btnCekBPJSNomorRujukanRS);
                jmlmenu++;
            }

            if (akses.getbpjs_cek_rujukan_kartu_pcare() == true) {
                Panelmenu.add(btnCekBPJSRujukanKartuPCare);
                jmlmenu++;
            }

            if (akses.getbpjs_cek_kartu() == true) {
                Panelmenu.add(btnCekFingerPrinBPJS);
                jmlmenu++;
            }

            if (akses.getbpjs_cek_kartu() == true) {
                Panelmenu.add(btnCekBPJSKartu);
                jmlmenu++;
            }

            if (akses.getbpjs_cek_nik() == true) {
                Panelmenu.add(btnCekBPJSNik);
                jmlmenu++;
            }

            if (akses.getbpjs_sep() == true) {
                Panelmenu.add(btnListSpesialistikRujukanBPJS);
                jmlmenu++;
            }

            if (akses.getbpjs_sep() == true) {
                Panelmenu.add(btnCekReferensiDiagnosaPRBBPJS);
                jmlmenu++;
            }

            if (akses.getbpjsSEPinternal() == true) {
                Panelmenu.add(btnCekSEPInternalBPJS);
                jmlmenu++;
            }

            if (akses.getbpjs_cek_riwayat_rujukan_pcare() == true) {
                Panelmenu.add(btnBPJScekRiwayatRujukanPcare);
                jmlmenu++;
            }

            if (akses.getbpjs_cek_riwayat_rujukan_rs() == true) {
                Panelmenu.add(btnCekBPJSRiwayatRujukanRS);
                jmlmenu++;
            }

            if (akses.getbpjs_cek_rujukan_kartu_rs() == true) {
                Panelmenu.add(btnCekBPJSRujukanKartuRS);
                jmlmenu++;
            }

            if (akses.getbpjs_cek_nomor_rujukan() == true) {
                Panelmenu.add(btnCekBPJSNomorRujukanPCare);
                jmlmenu++;
            }

            if (akses.getbpjs_referensi_diagnosa() == true) {
                Panelmenu.add(btnCekBPJSDiagnosa);
                jmlmenu++;
            }

            if (akses.getbpjs_cek_referensi_propinsi() == true) {
                Panelmenu.add(btnCekReferensiPropinsiBPJS);
                jmlmenu++;
            }

            if (akses.getbpjs_cek_referensi_kabupaten() == true) {
                Panelmenu.add(btnCekReferensiKabupatenBPJS);
                jmlmenu++;
            }

            if (akses.getbpjs_cek_referensi_kecamatan() == true) {
                Panelmenu.add(btnCekReferensiKecamatanBPJS);
                jmlmenu++;
            }

            if (akses.getbpjs_cek_referensi_pasca_pulang() == true) {
                Panelmenu.add(btnCekReferensiPascaPulangBPJS);
                jmlmenu++;
            }

            if (akses.getbpjs_cek_referensi_cara_keluar() == true) {
                Panelmenu.add(btnCekReferensiCaraKeluarBPJS);
                jmlmenu++;
            }

            if (akses.getbpjs_cek_referensi_ruang_rawat() == true) {
                Panelmenu.add(btnCekReferensiRuangRawatBPJS);
                jmlmenu++;
            }

            if (akses.getbpjs_cek_referensi_spesialistik() == true) {
                Panelmenu.add(btnCekReferensiSpesialistikBPJS);
                jmlmenu++;
            }

            if (akses.getbpjs_cek_referensi_dpjp() == true) {
                Panelmenu.add(btnCekReferensiDokterDPJPBPJS);
                jmlmenu++;
            }

            if (akses.getbpjs_cek_referensi_dokter() == true) {
                Panelmenu.add(btnCekReferensiDokterBPJS);
                jmlmenu++;
            }

            if (akses.getbpjs_cek_referensi_prosedur() == true) {
                Panelmenu.add(btnCekReferensiProsedurBPJS);
                jmlmenu++;
            }

            if (akses.getbpjs_cek_referensi_kelas_rawat() == true) {
                Panelmenu.add(btnCekReferensiKelasRawatBPJS);
                jmlmenu++;
            }

            if (akses.getbpjs_referensi_poli() == true) {
                Panelmenu.add(btnCekBPJSPoli);
                jmlmenu++;
            }

            if (akses.getbpjs_referensi_faskes() == true) {
                Panelmenu.add(btnCekBPJSFaskes);
                jmlmenu++;
            }

            if (akses.getbpjs_sep() == true) {
                Panelmenu.add(btnBPJSSEP);
                jmlmenu++;
            }

            if (akses.getbpjs_monitoring_klaim() == true) {
                Panelmenu.add(btnMonitoringKlaimBPJS);
                jmlmenu++;
            }

            if (akses.getaplicare_referensi_kamar() == true) {
                Panelmenu.add(btnAplicareReferensiKamar);
                jmlmenu++;
            }

            if (akses.getaplicare_ketersediaan_kamar() == true) {
                Panelmenu.add(btnAplicareKetersediaanKamar);
                jmlmenu++;
            }

            if (akses.getinacbg_coder_nik() == true) {
                Panelmenu.add(btnInaCBGCoderNIK);
                jmlmenu++;
            }

            if (akses.getpcare_cek_penyakit() == true) {
                Panelmenu.add(btnCekPCareDiagnosa);
                jmlmenu++;
            }

            if (akses.getpasien_corona() == true) {
                Panelmenu.add(btnPasienCorona);
                jmlmenu++;
            }

            if (akses.getdiagnosa_pasien_corona() == true) {
                Panelmenu.add(btnDiagnosaPasienCorona);
                jmlmenu++;
            }

            if (akses.getperawatan_pasien_corona() == true) {
                Panelmenu.add(btnPerawatanPasienCorona);
                jmlmenu++;
            }

        } else if (cmbMenu.getSelectedIndex() == 11) {
            jmlmenu = 0;
            if (akses.getkemenkes_sitt()== true) {
                Panelmenu.add(btnSpirometri);
                jmlmenu++;
            }
            
            if (akses.getadmin()== true) {
                Panelmenu.add(btnMasterIndikatorNasionalMutu);
                jmlmenu++;
            }
            
            if (akses.getadmin()== true) {
                Panelmenu.add(btnMasterNumdenomINM);
                jmlmenu++;
            }
                    
            if (akses.getadmin()== true) {
                Panelmenu.add(btnMasterJenisDokumenJangMed);
                jmlmenu++;
            }
            
            if (akses.getadmin() == true) {
                Panelmenu.add(btnMasterResikoDecubitus);
                jmlmenu++;
            }
            
            if (akses.getdata_triase_igd() == true) {
                Panelmenu.add(btnMasterFaktorResikoJatuh);
                jmlmenu++;
            }
            
            if (akses.getperusahaan_pasien() == true) {
                Panelmenu.add(btnPerusahaan);
                jmlmenu++;
            }

            if (akses.getpasien() == true) {
                Panelmenu.add(btnPasien);
                jmlmenu++;
            }

            if (akses.getkelahiran_bayi() == true) {
                Panelmenu.add(btnLahir);
                jmlmenu++;
            }

            if (akses.getcatatan_pasien() == true) {
                Panelmenu.add(btnCatatanPasien);
                jmlmenu++;
            }

            if (akses.getdata_ponek() == true) {
                Panelmenu.add(btnPasienPonek);
                jmlmenu++;
            }

            if (akses.getpasien_meninggal() == true) {
                Panelmenu.add(btnPasienMati);
                jmlmenu++;
            }
            
            if (akses.getadmin() == true) {
                Panelmenu.add(btnMasterKasusPersalinanDinkes);
                jmlmenu++;
            }
            
            if (akses.getdata_persalinan() == true) {
                Panelmenu.add(btnKasusPersalinanDinkes);
                jmlmenu++;
            }

            if (akses.getdiagnosa_pasien() == true) {
                Panelmenu.add(btnDiagnosa);
                jmlmenu++;
            }

            if (akses.getinput_kode_icd() == true) {
                Panelmenu.add(btnInputKodeICD);
                jmlmenu++;
            }

            if (akses.getdata_HAIs() == true) {
                Panelmenu.add(btnDataHAIs);
                jmlmenu++;
            }

            if (akses.getresume_pasien() == true) {
                Panelmenu.add(btnResume);
                jmlmenu++;
            }

            if (akses.getmaster_masalah_keperawatan() == true) {
                Panelmenu.add(btnMasterMasalahKeperawatan);
                jmlmenu++;
            }

            if (akses.getikhtisar_perawatan_hiv() == true) {
                Panelmenu.add(btnIkhtisarPerawatanHIV);
                jmlmenu++;
            }

            if (akses.getmaster_faskes() == true) {
                Panelmenu.add(btnMasterFaskes);
                jmlmenu++;
            }
            
            if (akses.getassesmen_gizi_harian() == true) {
                Panelmenu.add(btnMasterDiagnosaGizi);
                jmlmenu++;
            }

            if (akses.getmaster_cara_bayar() == true) {
                Panelmenu.add(btnMasterCaraBayar);
                jmlmenu++;
            }
        } else if (cmbMenu.getSelectedIndex() == 12) {
            jmlmenu = 0;
            if (akses.getpengambilan_utd2() == true) {
                Panelmenu.add(btnPengambilanUTD2);
                jmlmenu++;
            }

            if (akses.getutd_medis_rusak() == true) {
                Panelmenu.add(btnUTDMedisRusak);
                jmlmenu++;
            }

            if (akses.getpengambilan_penunjang_utd2() == true) {
                Panelmenu.add(btnPengambilanPenunjangUTD2);
                jmlmenu++;
            }

            if (akses.getutd_penunjang_rusak() == true) {
                Panelmenu.add(btnUTDPenunjangRusak);
                jmlmenu++;
            }

            if (akses.getutd_komponen_darah() == true) {
                Panelmenu.add(btnUTDKomponenDarah);
                jmlmenu++;
            }

            if (akses.getutd_donor() == true) {
                Panelmenu.add(btnUTDDonorDarah);
                jmlmenu++;
            }

            if (akses.getutd_cekal_darah() == true) {
                Panelmenu.add(btnUTDCekalDarah);
                jmlmenu++;
            }

            if (akses.getutd_pemisahan_darah() == true) {
                Panelmenu.add(btnUTDPemisahanDarah);
                jmlmenu++;
            }

            if (akses.getutd_stok_darah() == true) {
                Panelmenu.add(btnUTDStokDarah);
                jmlmenu++;
            }

            if (akses.getutd_penyerahan_darah() == true) {
                Panelmenu.add(btnUTDPenyerahanDarah);
                jmlmenu++;
            }
        } else if (cmbMenu.getSelectedIndex() == 13) {
            jmlmenu = 0;
            Panelmenu.add(btnIndikatorNasionalMutu);
            jmlmenu++;
            
            if (akses.getgrafik_kunjungan_poli() == true) {
                Panelmenu.add(btnGrafikKunjunganPoli);
                jmlmenu++;
            }

            if (akses.getgrafik_kunjungan_perdokter() == true) {
                Panelmenu.add(btnGrafikKunjunganPerDokter);
                jmlmenu++;
            }

            if (akses.getgrafik_kunjungan_perpekerjaan() == true) {
                Panelmenu.add(btnGrafikKunjunganPerPekerjaan);
                jmlmenu++;
            }

            if (akses.getgrafik_kunjungan_perpendidikan() == true) {
                Panelmenu.add(btnGrafikKunjunganPerPendidikan);
                jmlmenu++;
            }

            if (akses.getgrafik_kunjungan_pertahun() == true) {
                Panelmenu.add(btnGrafikKunjunganPerTahun);
                jmlmenu++;
            }

            if (akses.getgrafik_kunjungan_perbulan() == true) {
                Panelmenu.add(btnGrafikKunjunganPerBulan);
                jmlmenu++;
            }

            if (akses.getgrafik_kunjungan_pertanggal() == true) {
                Panelmenu.add(btnGrafikKunjunganPerTanggal);
                jmlmenu++;
            }

            if (akses.getgrafik_kunjungan_demografi() == true) {
                Panelmenu.add(btnGrafikDemografiRegistrasi);
                jmlmenu++;
            }

            if (akses.getgrafik_kunjungan_statusdaftartahun() == true) {
                Panelmenu.add(btnGrafikStatusRegPerTahun);
                jmlmenu++;
            }

            if (akses.getgrafik_kunjungan_statusdaftartahun2() == true) {
                Panelmenu.add(btnGrafikStatusRegPerTahun2);
                jmlmenu++;
            }

            if (akses.getgrafik_kunjungan_statusdaftarbulan() == true) {
                Panelmenu.add(btnGrafikStatusRegPerBulan);
                jmlmenu++;
            }

            if (akses.getgrafik_kunjungan_statusdaftarbulan2() == true) {
                Panelmenu.add(btnGrafikStatusRegPerBulan2);
                jmlmenu++;
            }

            if (akses.getgrafik_kunjungan_statusdaftartanggal() == true) {
                Panelmenu.add(btnGrafikStatusRegPerTanggal);
                jmlmenu++;
            }

            if (akses.getgrafik_kunjungan_statusdaftartanggal2() == true) {
                Panelmenu.add(btnGrafikStatusRegPerTanggal2);
                jmlmenu++;
            }

            if (akses.getgrafik_kunjungan_statusbataltahun() == true) {
                Panelmenu.add(btnGrafikStatusRegBatalPerTahun);
                jmlmenu++;
            }

            if (akses.getgrafik_kunjungan_statusbatalbulan() == true) {
                Panelmenu.add(btnGrafikStatusRegBatalPerBulan);
                jmlmenu++;
            }

            if (akses.getgrafik_kunjungan_statusbataltanggal() == true) {
                Panelmenu.add(btnGrafikStatusRegBatalPerTanggal);
                jmlmenu++;
            }
        } else if (cmbMenu.getSelectedIndex() == 14) {
            jmlmenu = 0;
            if (akses.getaplikasi() == true) {
                Panelmenu.add(btnSetupAplikasi);
                jmlmenu++;
            }

            if (akses.getadmin() == true) {
                Panelmenu.add(btnAdmin);
                jmlmenu++;
            }

            if (akses.getset_bridging() == true) {
                Panelmenu.add(btnSetingBridging);
                jmlmenu++;
            }

            if (akses.getsetup_pjlab() == true) {
                Panelmenu.add(btnSetPenjab);
                jmlmenu++;
            }

            if (akses.getsetup_otolokasi() == true) {
                Panelmenu.add(btnSetupOtoLokasi);
                jmlmenu++;
            }

            if (akses.getsetup_jam_kamin() == true) {
                Panelmenu.add(btnSetupJamInap);
                jmlmenu++;
            }

            if (akses.getset_harga_kamar() == true) {
                Panelmenu.add(btnSetHargaKamar);
                jmlmenu++;
            }

            if (akses.getsetup_embalase() == true) {
                Panelmenu.add(btnSetupEmbalase);
                jmlmenu++;
            }

            if (akses.getuser() == true) {
                Panelmenu.add(btnUser);
                jmlmenu++;
            }

            if (akses.gettracer_login() == true) {
                Panelmenu.add(btnTracker);
                jmlmenu++;
            }

            if (akses.getdisplay() == true) {
                Panelmenu.add(btnAntrian);
                jmlmenu++;
            }

            if (akses.getset_harga_obat() == true) {
                Panelmenu.add(btnSetupHarga);
                jmlmenu++;
            }

            if (akses.getset_harga_obat_ralan() == true) {
                Panelmenu.add(btnSetObatRalan);
                jmlmenu++;
            }

            if (akses.getset_harga_obat_ranap() == true) {
                Panelmenu.add(btnSetObatRanap);
                jmlmenu++;
            }

            if (akses.getset_penggunaan_tarif() == true) {
                Panelmenu.add(btnSetupTarif);
                jmlmenu++;
            }

            if (akses.getset_oto_ralan() == true) {
                Panelmenu.add(btnSetOtoRalan);
                jmlmenu++;
            }

            if (akses.getbiaya_harian() == true) {
                Panelmenu.add(btnSetBiayaHarian);
                jmlmenu++;
            }

            if (akses.getbiaya_masuk_sekali() == true) {
                Panelmenu.add(btnSetBiayaMasukSekali);
                jmlmenu++;
            }

            if (akses.getset_no_rm() == true) {
                Panelmenu.add(btnSetupRM);
                jmlmenu++;
            }

            if (akses.getset_nota() == true) {
                Panelmenu.add(btnSetupNota);
                jmlmenu++;
            }

            if (akses.getclosing_kasir() == true) {
                Panelmenu.add(btnClosingKasir);
                jmlmenu++;
            }

            if (akses.getketerlambatan_presensi() == true) {
                Panelmenu.add(btnKeterlambatanPresensi);
                jmlmenu++;
            }
        }
    }

    private void isCariKosong() {
        jmlmenu = 0;
        Panelmenu.add(btnIndikatorNasionalMutu);
        jmlmenu++;

        if (akses.getadmin() == true) {
            Panelmenu.add(btnMasterNomorDokumen);
            jmlmenu++;
        }

        if (akses.getsatu_sehat() == true) {
            Panelmenu.add(btnReferensiDokterSatuSehat);
            jmlmenu++;
        }
        
        if (akses.getsatu_sehat() == true) {
            Panelmenu.add(btnReferensiPasienSatuSehat);
            jmlmenu++;
        }
        
        if (akses.getadmin() == true) {
            Panelmenu.add(btnMapingOrganisasiSatuSehat);
            jmlmenu++;
        }
        
        if (akses.getadmin() == true) {
            Panelmenu.add(btnMapingLokasiSatuSehat);
            jmlmenu++;
        }
        
        if (akses.getadmin() == true) {
            Panelmenu.add(btnMapingVaksinSatuSehat);
            jmlmenu++;
        }
        
        if (akses.getadmin() == true) {
            Panelmenu.add(btnMapingObatSatuSehat);
            jmlmenu++;
        }
        
        if (akses.getsatu_sehat() == true) {
            Panelmenu.add(btnKirimEncounterSatuSehat);
            jmlmenu++;
        }
        
        if (akses.getsatu_sehat() == true) {
            Panelmenu.add(btnKirimConditionSatuSehat);
            jmlmenu++;
        }
        
        if (akses.getsatu_sehat() == true) {
            Panelmenu.add(btnKirimObservationSatuSehat);
            jmlmenu++;
        }
        
        if (akses.getsatu_sehat() == true) {
            Panelmenu.add(btnKirimProsedurSatuSehat);
            jmlmenu++;
        }

        if (akses.getsatu_sehat() == true) {
            Panelmenu.add(btnKirimImunisasiSatuSehat);
            jmlmenu++;
        }
        
        if (akses.getsatu_sehat() == true) {
            Panelmenu.add(btnKirimClinicalSatuSehat);
            jmlmenu++;
        }
        
        if (akses.getsatu_sehat() == true) {
            Panelmenu.add(btnKirimDietSatuSehat);
            jmlmenu++;
        }

        if (akses.getsatu_sehat() == true) {
            Panelmenu.add(btnKirimMedicationRequestSatuSehat);
            jmlmenu++;
        }
        
        if (akses.getsatu_sehat() == true) {
            Panelmenu.add(btnKirimMedicationDispenseSatuSehat);
            jmlmenu++;
        }
        
        if (akses.getpermintaan_lab() == true) {
            Panelmenu.add(btnSuratKonsulUnitRanap);
            jmlmenu++;
        }

        if (akses.getpermintaan_lab() == true) {
            Panelmenu.add(btnSuratJawabanKonsulRanap);
            jmlmenu++;
        }
        
        if (akses.getkegiatan_operasi() == true) {
            Panelmenu.add(btnAsesmenKeperawatanPerioperatif);
            jmlmenu++;
        }
        
        if (akses.getkegiatan_operasi() == true) {
            Panelmenu.add(btnCeklisPraOperasi);
            jmlmenu++;
        }
        
        if (akses.getkegiatan_operasi() == true) {
            Panelmenu.add(btnCeklisKesiapanAnestesi);
            jmlmenu++;
        }
        
        if (akses.getcppt() == true) {
            Panelmenu.add(btnPemantauanHarian24Jam);
            jmlmenu++;
        }
        
        if (akses.getcppt() == true) {
            Panelmenu.add(btnPerencanaanPulang);
            jmlmenu++;
        }

        if (akses.getcppt() == true) {
            Panelmenu.add(btnAsesmenUlangResikoJatuhDewasa);
            jmlmenu++;
        }
        
        if (akses.getresep_dokter() == true) {
            Panelmenu.add(btnAsesmenPraSedasi);
            jmlmenu++;
        }
        
        if (akses.getresep_dokter() == true) {
            Panelmenu.add(btnAsesmenPreInduksi);
            jmlmenu++;
        }
        
        if (akses.getcppt() == true) {
            Panelmenu.add(btnAsesmenUlangResikoJatuhAnak);
            jmlmenu++;
        }

        if (akses.getcppt() == true) {
            Panelmenu.add(btnMonitoringEWSDewasa);
            jmlmenu++;
        }

        if (akses.getcppt() == true) {
            Panelmenu.add(btnMonitoringPediatricEWS);
            jmlmenu++;
        }
        
        if (akses.getcppt() == true) {
            Panelmenu.add(btnPersetujuanTindakan);
            jmlmenu++;
        }

        if (akses.getcppt() == true) {
            Panelmenu.add(btnCatatanTindakanKeperawatan);
            jmlmenu++;
        }
        
        Panelmenu.add(btnNotepad);
        jmlmenu++;
        
        if (akses.getadmin() == true) {
            Panelmenu.add(btnBangsal);
            jmlmenu++;
        }

        if (akses.getoperasi() == true) {
            Panelmenu.add(btnJadwalOperasi);
            jmlmenu++;
        }
        
        if (akses.getpenilaian_awal_keperawatan_kebidanan() == true) {
            Panelmenu.add(btnAsesmenKebidananRalan);
            jmlmenu++;
        }
        
        if (akses.getkemenkes_sitt() == true) {
            Panelmenu.add(btnSpirometri);
            jmlmenu++;
        }
        
        if (akses.getkemoterapi() == true) {
            Panelmenu.add(btnProtokolKemoterapi);
            jmlmenu++;
        }

        if (akses.getcppt() == true) {
            Panelmenu.add(btnTransferPasienTindakan);
            jmlmenu++;
        }

        if (akses.getcppt() == true) {
            Panelmenu.add(btnCPPT);
            jmlmenu++;
        }
        
        if (akses.getcppt() == true) {
            Panelmenu.add(btnLembarObservasi);
            jmlmenu++;
        }
      
        if (akses.getcppt() == true) {
            Panelmenu.add(btnPengelolaanTransfusiDarah);
            jmlmenu++;
        }

        if (akses.getpemberian_obat() == true) {
            Panelmenu.add(btnPemberianObat);
            jmlmenu++;
        }

        if (akses.getpemberian_obat() == true) {
            Panelmenu.add(btnPetugasPelaksanaPemberianObat);
            jmlmenu++;
        }
        
        if (akses.getasesmen_medik_dewasa_ranap() == true) {
            Panelmenu.add(btnAsesmenMedikDewasaRanap);
            jmlmenu++;
        }
        
        if (akses.getasesmen_medik_anak_ranap() == true) {
            Panelmenu.add(btnAsesmenMedikAnakRanap);
            jmlmenu++;
        }

        if (akses.getcppt() == true) {
            Panelmenu.add(btnAsesmenRestrain);
            jmlmenu++;
        }
        
        if (akses.getsurat_keterangan_kir_mcu() == true) {
            Panelmenu.add(btnSuratKeteranganDokter);
            jmlmenu++;
        }

        if (akses.getsurat_keterangan_kir_mcu() == true) {
            Panelmenu.add(btnSuratKeteranganDisabilitas);
            jmlmenu++;
        }
        
        if (akses.getsurat_keterangan_kir_mcu() == true) {
            Panelmenu.add(btnSuratKeteranganRohani);
            jmlmenu++;
        }
        
        if (akses.getsurat_keterangan_kir_mcu() == true) {
            Panelmenu.add(btnSuratKeteranganNAPZA);
            jmlmenu++;
        }
        
        if (akses.getsurat_sakit() == true) {
            Panelmenu.add(btnSuratIstirahatSakit);
            jmlmenu++;
        }
        
        if (akses.getsurat_sakit() == true) {
            Panelmenu.add(btnSuratKeteranganSakit);
            jmlmenu++;
        }
        
        if (akses.getsisrute_rujukan_masuk() == true) {
            Panelmenu.add(btnRujukanMasukSisrute);
            jmlmenu++;
        }

        if (akses.getkemenkes_sitt() == true) {
            Panelmenu.add(btnKemenkesSITB);
            jmlmenu++;
        }

        if (akses.getset_bridging() == true) {
            Panelmenu.add(btnSetingBridging);
            jmlmenu++;
        }

        if (akses.getkemenkes_kanker() == true) {
            Panelmenu.add(btnKemenkesKanker);
            jmlmenu++;
        }

        if (akses.getsisrute_rujukan_keluar() == true) {
            Panelmenu.add(btnRujukanKeluarSisrute);
            jmlmenu++;
        }

        if (akses.getsisrute_referensi_alasanrujuk() == true) {
            Panelmenu.add(btnCekSisruteAlasanRujuk);
            jmlmenu++;
        }

        if (akses.getsisrute_referensi_diagnosa() == true) {
            Panelmenu.add(btnCekSisruteDiagnosa);
            jmlmenu++;
        }
        
        if (akses.getrekam_psikologis() == true) {
            Panelmenu.add(btnRekamPsikologisDewasa);
            jmlmenu++;
        }
        
        if (akses.getrekam_psikologis() == true) {
            Panelmenu.add(btnRekamPsikologisAnak);
            jmlmenu++;
        }
        
        if (akses.getrekam_psikologis() == true) {
            Panelmenu.add(btnRekamPsikologiPerkawinan);
            jmlmenu++;
        }

        if (akses.getRencanaKontrolJKN() == true) {
            Panelmenu.add(btnRencanaKontrolBPJS);
            jmlmenu++;
        }

        if (akses.getkendali_mutu_kendali_biaya_inacbg() == true) {
            Panelmenu.add(btnKendaliMutuKendaliBiayaINACBG);
            jmlmenu++;
        }

        if (akses.getjkn_belum_diproses_klaim() == true) {
            Panelmenu.add(btnINACBGjknBelumDiklaim);
            jmlmenu++;
        }

        if (akses.getinacbg_klaim_raza() == true) {
            Panelmenu.add(btnBridgingEklaimINACBG);
            jmlmenu++;
        }

        if (akses.getpengajuan_klaim_raza() == true) {
            Panelmenu.add(btnPengajuanKlaimINACBGrz);
            jmlmenu++;
        }
        
        if (akses.getadmin() == true) {
            Panelmenu.add(btnMasterJenisDokumenJangMed);
            jmlmenu++;
        }
        
        if (akses.getadmin() == true) {
            Panelmenu.add(btnMasterIndikatorNasionalMutu);
            jmlmenu++;
        }
        
        if (akses.getadmin() == true) {
            Panelmenu.add(btnMasterNumdenomINM);
            jmlmenu++;
        }
        
        if (akses.getresep_obat() == true) {
            Panelmenu.add(btnMasterAturanPakai);
            jmlmenu++;
        }
        
        if (akses.getrekam_psikologis() == true) {
            Panelmenu.add(btnMasterKeluhanPsikologis);
            jmlmenu++;
        }
        
        if (akses.getrekam_psikologis() == true) {
            Panelmenu.add(btnMasterRencanaTritmenPsikologis);
            jmlmenu++;
        }
        
        if (akses.getcppt() == true) {
            Panelmenu.add(btnAsesmenKeperawatanDewasa);
            jmlmenu++;
        }
        
        if (akses.getcppt() == true) {
            Panelmenu.add(btnAsesmenKeperawatanAnak);
            jmlmenu++;
        }
                
        if (akses.getresep_dokter() == true) {
            Panelmenu.add(btnAssesmenMedikIGD);
            jmlmenu++;
        }

        if (akses.getpenilaian_awal_keperawatan_ralan() == true) {
            Panelmenu.add(btnAssesmenKeperawatanIGD);
            jmlmenu++;
        }
        
        if (akses.getpemberian_obat() == true) {
            Panelmenu.add(btnTransferSerahTerimaPasien);
            jmlmenu++;
        }
        
        if (akses.getadmin() == true) {
            Panelmenu.add(btnMasterResikoDecubitus);
            jmlmenu++;
        }
        
        if (akses.getdata_triase_igd() == true) {
            Panelmenu.add(btnMasterFaktorResikoJatuh);
            jmlmenu++;
        }
        
        if (akses.getmaster_masalah_keperawatan() == true) {
            Panelmenu.add(btnMasterMasalahKeperawatan);
            jmlmenu++;
        }

        if (akses.getikhtisar_perawatan_hiv() == true) {
            Panelmenu.add(btnIkhtisarPerawatanHIV);
            jmlmenu++;
        }
        
        if (akses.getpenilaian_pasien_geriatri() == true) {
            Panelmenu.add(btnPenilaianTambahanGeriatri);
            jmlmenu++;
        }
        
        if (akses.getpenilaian_pasien_geriatri() == true) {
            Panelmenu.add(btnPenilaianAwalMedisRalanGeriatri);
            jmlmenu++;
        }
        
        if (akses.getpenilaian_awal_medis_ralan_mata() == true) {
            Panelmenu.add(btnPenilaianAwalMedisRalanMata);
            jmlmenu++;
        }

        if (akses.getpenilaian_awal_medis_ralan_tht() == true) {
            Panelmenu.add(btnPenilaianAwalMedisRalanTHT);
            jmlmenu++;
        }

        if (akses.getpenilaian_awal_keperawatan_ralan() == true) {
            Panelmenu.add(btnPenilaianAwalKeperawatanRalan);
            jmlmenu++;
        }

        if (akses.getpenilaian_awal_medis_ralan_kebidanan() == true) {
            Panelmenu.add(btnAsesmenMedikObstetriRalan);
            jmlmenu++;
        }

        if (akses.getpenilaian_awal_keperawatan_kebidanan() == true) {
            Panelmenu.add(btnPenilaianAwalKeperawatanKebidananRalan);
            jmlmenu++;
        }
        
        if (akses.getadmin() == true) {
            Panelmenu.add(btnMasterKasusPersalinanDinkes);
            jmlmenu++;
        }
        
        if (akses.getdata_persalinan() == true) {
            Panelmenu.add(btnKasusPersalinanDinkes);
            jmlmenu++;
        }

        if (akses.getdata_triase_igd() == true) {
            Panelmenu.add(btnDataTriaseIGD);
            jmlmenu++;
        }

        if (akses.getmaster_cara_bayar() == true) {
            Panelmenu.add(btnMasterCaraBayar);
            jmlmenu++;
        }

        if (akses.getsisrute_referensi_faskes() == true) {
            Panelmenu.add(btnCekSisruteFaskes);
            jmlmenu++;
        }

        if (akses.getinput_kode_icd() == true) {
            Panelmenu.add(btnInputKodeICD);
            jmlmenu++;
        }

        if (akses.getbpjs_sep() == true) {
            Panelmenu.add(btnProgramPRBBPJS);
            jmlmenu++;
        }

        if (akses.getbpjs_sep() == true) {
            Panelmenu.add(btnCekReferensiPendaftaranMobileJKNBPJS);
            jmlmenu++;
        }

        if (akses.getbpjs_sep() == true) {
            Panelmenu.add(btnCekReferensiBatalDaftarMobileJKNBPJS);
            jmlmenu++;
        }

        if (akses.getbpjs_sep() == true) {
            Panelmenu.add(btnCekReferensiPoliHFISBPJS);
            jmlmenu++;
        }

        if (akses.getbpjs_sep() == true) {
            Panelmenu.add(btnCekReferensiJadwalHFISBPJS);
            jmlmenu++;
        }

        if (akses.getbpjs_sep() == true) {
            Panelmenu.add(btnCekReferensiDokterHFISBPJS);
            jmlmenu++;
        }

        if (akses.getbpjs_sep() == true) {
            Panelmenu.add(btnHistoriPelayananPesertaBPJS);
            jmlmenu++;
        }

        if (akses.getbpjs_sep() == true) {
            Panelmenu.add(btnKlaimJaminanJasaRaharja);
            jmlmenu++;
        }

        if (akses.getbpjs_sep() == true) {
            Panelmenu.add(btnDataSuplesiJasaRaharja);
            jmlmenu++;
        }

        if (akses.getbpjs_sep() == true) {
            Panelmenu.add(btnDataSEPIndukKLLJasaRaharja);
            jmlmenu++;
        }

        if (akses.getbpjs_sep() == true) {
            Panelmenu.add(btnListSaranaRujukanBPJS);
            jmlmenu++;
        }

        if (akses.getbpjs_sep() == true) {
            Panelmenu.add(btnCekReferensiDiagnosaPRBBPJS);
            jmlmenu++;
        }

        if (akses.getbpjs_sep() == true) {
            Panelmenu.add(btnDataNomorSuratKontrolBPJS);
            jmlmenu++;
        }

        if (akses.getbpjsSEPinternal() == true) {
            Panelmenu.add(btnCekSEPInternalBPJS);
            jmlmenu++;
        }

        if (akses.getbarang_cssd() == true) {
            Panelmenu.add(btnBarangCSSD);
            jmlmenu++;
        }
        
        if (akses.getpegawai_admin() == true) {
            Panelmenu.add(btnDataJabatan);
            jmlmenu++;
        }
        
        if (akses.getpegawai_admin() == true) {
            Panelmenu.add(btnMasterJabatanKomite);
            jmlmenu++;
        }

        if (akses.getinformasi_kamar() == true) {
            Panelmenu.add(btnAnalisaKamar);
            jmlmenu++;
        }

        if (akses.getdashboard_eResep() == true) {
            Panelmenu.add(btnDashboardeResepRalan);
            jmlmenu++;
        }
        
        if (akses.getdashboard_eResep() == true) {
            Panelmenu.add(btnDashboardeResepRanap);
            jmlmenu++;
        }

        if (akses.getjadwal_praktek() == true) {
            Panelmenu.add(BtnJadwal);
            jmlmenu++;
        }

        if (akses.getpermintaan_lab() == true) {
            Panelmenu.add(btnPermintaanLab);
            jmlmenu++;
        }

        if (akses.getpermintaan_radiologi() == true) {
            Panelmenu.add(btnPermintaanRadiologi);
            jmlmenu++;
        }

        if (akses.getassesmen_gizi_harian() == true) {
            Panelmenu.add(btnAsuhanGiziRanap);
            jmlmenu++;
        }
        
        if (akses.getassesmen_gizi_harian() == true) {
            Panelmenu.add(btnSkriningGiziUlang);
            jmlmenu++;
        }

        if (akses.getassesmen_gizi_ulang() == true) {
            Panelmenu.add(btnAssesmenUlangGizi);
            jmlmenu++;
        }

        if (akses.getmonev_asuhan_gizi() == true) {
            Panelmenu.add(btnMonevAsuhanGizi);
            jmlmenu++;
        }

        if (akses.getdata_ponek() == true) {
            Panelmenu.add(btnPasienPonek);
            jmlmenu++;
        }

        if (akses.getpasien_corona() == true) {
            Panelmenu.add(btnPasienCorona);
            jmlmenu++;
        }

        if (akses.getdiagnosa_pasien_corona() == true) {
            Panelmenu.add(btnDiagnosaPasienCorona);
            jmlmenu++;
        }

        if (akses.getperawatan_pasien_corona() == true) {
            Panelmenu.add(btnPerawatanPasienCorona);
            jmlmenu++;
        }

        if (akses.getharianhaisinap() == true) {
            Panelmenu.add(btnHarianHAIsRanap);
            jmlmenu++;
        }

        if (akses.getharianhaisjalan() == true) {
            Panelmenu.add(btnHarianHAIsRalan);
            jmlmenu++;
        }

        if (akses.getbulananhaisinap() == true) {
            Panelmenu.add(btnBulananHAIsRanap);
            jmlmenu++;
        }

        if (akses.getbulananhaisjalan() == true) {
            Panelmenu.add(btnBulananHAIsRalan);
            jmlmenu++;
        }

        if (akses.getbpjs_sep() == true) {
            Panelmenu.add(btnListSpesialistikRujukanBPJS);
            jmlmenu++;
        }

        if (akses.getbpjs_sep() == true) {
            Panelmenu.add(btnCekReferensiObatPRBBPJS);
            jmlmenu++;
        }

        if (akses.getbpjs_cek_referensi_propinsi() == true) {
            Panelmenu.add(btnCekReferensiPropinsiBPJS);
            jmlmenu++;
        }

        if (akses.getringkasanpulangranap() == true) {
            Panelmenu.add(btnRingkasanPulangRanap);
            jmlmenu++;
        }

        if (akses.getjumlah_macam_diet() == true) {
            Panelmenu.add(btnJumlahMacamDiet);
            jmlmenu++;
        }

        if (akses.getjumlah_porsi_diet() == true) {
            Panelmenu.add(btnJumlahPorsiDiet);
            jmlmenu++;
        }

        if (akses.getbpjs_cek_referensi_kabupaten() == true) {
            Panelmenu.add(btnCekReferensiKabupatenBPJS);
            jmlmenu++;
        }

        if (akses.getbpjs_cek_referensi_kecamatan() == true) {
            Panelmenu.add(btnCekReferensiKecamatanBPJS);
            jmlmenu++;
        }

        if (akses.getbpjs_cek_referensi_pasca_pulang() == true) {
            Panelmenu.add(btnCekReferensiPascaPulangBPJS);
            jmlmenu++;
        }

        if (akses.getbpjs_cek_referensi_cara_keluar() == true) {
            Panelmenu.add(btnCekReferensiCaraKeluarBPJS);
            jmlmenu++;
        }

        if (akses.getmaster_faskes() == true) {
            Panelmenu.add(btnMasterFaskes);
            jmlmenu++;
        }

        if (akses.getassesmen_gizi_harian() == true) {
            Panelmenu.add(btnMasterDiagnosaGizi);
            jmlmenu++;
        }

        if (akses.getbpjs_cek_kartu() == true) {
            Panelmenu.add(btnCekFingerPrinBPJS);
            jmlmenu++;
        }

        if (akses.getSPRIJKN() == true) {
            Panelmenu.add(btnSPRIbpjsVclaim);
            jmlmenu++;
        }

        if (akses.getbpjs_cek_referensi_ruang_rawat() == true) {
            Panelmenu.add(btnCekReferensiRuangRawatBPJS);
            jmlmenu++;
        }

        if (akses.getbpjs_cek_referensi_spesialistik() == true) {
            Panelmenu.add(btnCekReferensiSpesialistikBPJS);
            jmlmenu++;
        }

        if (akses.getbpjs_cek_referensi_dokter() == true) {
            Panelmenu.add(btnCekReferensiDokterBPJS);
            jmlmenu++;
        }

        if (akses.getbpjs_cek_tgl_rujukan() == true) {
            Panelmenu.add(btnCekBPJSTanggalRujukan);
            jmlmenu++;
        }

        if (akses.getbpjs_cek_referensi_dpjp() == true) {
            Panelmenu.add(btnCekReferensiDokterDPJPBPJS);
            jmlmenu++;
        }

        if (akses.getbpjs_cek_referensi_prosedur() == true) {
            Panelmenu.add(btnCekReferensiProsedurBPJS);
            jmlmenu++;
        }

        if (akses.getbpjs_cek_referensi_kelas_rawat() == true) {
            Panelmenu.add(btnCekReferensiKelasRawatBPJS);
            jmlmenu++;
        }

        if (akses.getbpjs_cek_no_rujukan_rs() == true) {
            Panelmenu.add(btnCekBPJSNomorRujukanRS);
            jmlmenu++;
        }

        if (akses.getbpjs_cek_rujukan_kartu_pcare() == true) {
            Panelmenu.add(btnCekBPJSRujukanKartuPCare);
            jmlmenu++;
        }

        if (akses.getbpjs_cek_riwayat_rujukan_pcare() == true) {
            Panelmenu.add(btnBPJScekRiwayatRujukanPcare);
            jmlmenu++;
        }

        if (akses.getbpjs_cek_riwayat_rujukan_rs() == true) {
            Panelmenu.add(btnCekBPJSRiwayatRujukanRS);
            jmlmenu++;
        }

        if (akses.getbpjs_cek_rujukan_kartu_rs() == true) {
            Panelmenu.add(btnCekBPJSRujukanKartuRS);
            jmlmenu++;
        }

        if (akses.getregistrasi() == true) {
            Panelmenu.add(btnRegistrasi);
            jmlmenu++;
        }

        if (akses.getbooking_registrasi() == true) {
            Panelmenu.add(btnBookingReg);
            jmlmenu++;
        }

        if (akses.getdata_persalinan() == true) {
            Panelmenu.add(btnDataPersalinan);
            jmlmenu++;
        }

        if (akses.getlaporanfarmasi() == true) {
            Panelmenu.add(btnLaporanFarmasi);
            jmlmenu++;
        }

        if (akses.getigd() == true) {
            Panelmenu.add(btnIGD);
            jmlmenu++;
        }

        if (akses.gettindakan_ralan() == true) {
            Panelmenu.add(btnRalan);
            jmlmenu++;
        }

        if (akses.getbpjs_rujukan_keluar() == true) {
            Panelmenu.add(btnRujukKeluarVclaim);
            jmlmenu++;
        }

        if (akses.getkamar_inap() == true) {
            Panelmenu.add(btnKamarInap);
            jmlmenu++;
        }

        if (akses.getdpjp_ranap() == true) {
            Panelmenu.add(BtnDpjp);
            jmlmenu++;
        }

        if (akses.gettindakan_ranap() == true) {
            Panelmenu.add(btnRanap);
            jmlmenu++;
        }

        if (akses.getoperasi() == true) {
            Panelmenu.add(btnTagihanOperasi);
            jmlmenu++;
        }

        if (akses.getrujukan_keluar() == true) {
            Panelmenu.add(btnRujukPasien);
            jmlmenu++;
        }

        if (akses.getrujukan_masuk() == true) {
            Panelmenu.add(btnRujukMasuk);
            jmlmenu++;
        }

        if (akses.getberi_obat() == true) {
            Panelmenu.add(btnBeriObat);
            jmlmenu++;
        }

        if (akses.getresep_pulang() == true) {
            Panelmenu.add(btnResepPulang);
            jmlmenu++;
        }

        if (akses.getresep_obat() == true) {
            Panelmenu.add(btnResepObat);
            jmlmenu++;
        }

        if (akses.getdiet_pasien() == true) {
            Panelmenu.add(btnDiet);
            jmlmenu++;
        }

        if (akses.getperiksa_lab() == true) {
            Panelmenu.add(btnLaboratorium);
            jmlmenu++;
        }

        if (akses.getperiksa_radiologi() == true) {
            Panelmenu.add(btnPeriksaRadiologi);
            jmlmenu++;
        }
        
        if (akses.getbilling_ranap() == true) {
            Panelmenu.add(btnTransaksiPanjar);
            jmlmenu++;
        }

        if (akses.getkasir_ralan() == true) {
            Panelmenu.add(btnKasir);
            jmlmenu++;
        }

        if (akses.getdeposit_pasien() == true) {
            Panelmenu.add(btnDeposit);
            jmlmenu++;
        }

        if (akses.getpiutang_pasien() == true) {
            Panelmenu.add(btnLihatPiutang);
            jmlmenu++;
        }

        if (akses.getpetugas() == true) {
            Panelmenu.add(btnPegawai);
            jmlmenu++;
        }

        if (akses.getdokter() == true) {
            Panelmenu.add(btnDokter);
            jmlmenu++;
        }

        if ((akses.getpegawai_admin() == true) || (akses.getpegawai_user() == true)) {
            Panelmenu.add(btnPenggajian);
            jmlmenu++;
        }

        if (akses.getindustrifarmasi() == true) {
            Panelmenu.add(btnIndustriFarmasi);
            jmlmenu++;
        }

        if (akses.getsuplier() == true) {
            Panelmenu.add(btnSuplier);
            jmlmenu++;
        }

        if (akses.getsatuan_barang() == true) {
            Panelmenu.add(btnSatuan);
            jmlmenu++;
        }

        if (akses.getkonversi_satuan() == true) {
            Panelmenu.add(btnKonversi);
            jmlmenu++;
        }

        if (akses.getjenis_barang() == true) {
            Panelmenu.add(btnJnsBarang);
            jmlmenu++;
        }

        if (akses.getkategori_barang() == true) {
            Panelmenu.add(btnKategoriBarang);
            jmlmenu++;
        }

        if (akses.getgolongan_barang() == true) {
            Panelmenu.add(btnGolonganBarang);
            jmlmenu++;
        }

        if (akses.getobat() == true) {
            Panelmenu.add(btnObat);
            jmlmenu++;
        }

        if (akses.getstok_opname_obat() == true) {
            Panelmenu.add(btnOpname);
            jmlmenu++;
        }

        if (akses.getmutasi_barang() == true) {
            Panelmenu.add(btnMutasiBarang);
            jmlmenu++;
        }

        if (akses.getstok_obat_pasien() == true) {
            Panelmenu.add(btnStokObatPasien);
            jmlmenu++;
        }

        if (akses.getpengadaan_obat() == true) {
            Panelmenu.add(btnPembelian);
            jmlmenu++;
        }

        if (akses.getpemesanan_obat() == true) {
            Panelmenu.add(btnPemesanan);
            jmlmenu++;
        }

        if (akses.getpenjualan_obat() == true) {
            Panelmenu.add(btnPenjualan);
            jmlmenu++;
        }

        if (akses.getresep_dokter() == true) {
            Panelmenu.add(btnDaftarPermintaanResep);
            jmlmenu++;
        }

        if (akses.getpiutang_obat() == true) {
            Panelmenu.add(btnPiutang);
            jmlmenu++;
        }

        if (akses.getretur_ke_suplier() == true) {
            Panelmenu.add(btnReturBeli);
            jmlmenu++;
        }

        if (akses.getretur_dari_pembeli() == true) {
            Panelmenu.add(btnReturJual);
            jmlmenu++;
        }

        if (akses.getretur_obat_ranap() == true) {
            Panelmenu.add(btnReturPasien);
            jmlmenu++;
        }

        if (akses.getretur_piutang_pasien() == true) {
            Panelmenu.add(btnReturPiutang);
            jmlmenu++;
        }

        if (akses.getpengambilan_utd() == true) {
            Panelmenu.add(btnPengambilanUTD);
            jmlmenu++;
        }

        if (akses.getkeuntungan_penjualan() == true) {
            Panelmenu.add(btnKeuntungan);
            jmlmenu++;
        }

        if (akses.getkeuntungan_beri_obat() == true) {
            Panelmenu.add(btnKeuntunganObatRanap);
            jmlmenu++;
        }

        if (akses.getkeuntungan_beri_obat_nonpiutang() == true) {
            Panelmenu.add(btnKeuntunganObat2);
            jmlmenu++;
        }

        if (akses.getsirkulasi_obat() == true) {
            Panelmenu.add(btnSirkulasi);
            jmlmenu++;
        }

        if (akses.getsirkulasi_obat2() == true) {
            Panelmenu.add(btnSirkulasi2);
            jmlmenu++;
        }

        if (akses.getpemberian_obat_pertanggal() == true) {
            Panelmenu.add(btnObatPerTanggal);
            jmlmenu++;
        }

        if (akses.getpenjualan_obat_pertanggal() == true) {
            Panelmenu.add(btnPenjualanPerTanggal);
            jmlmenu++;
        }

        if (akses.getriwayat_obat_alkes_bhp() == true) {
            Panelmenu.add(btnRiwayatBarangMedis);
            jmlmenu++;
        }

        if (akses.getdarurat_stok() == true) {
            Panelmenu.add(btnDaruratStok);
            jmlmenu++;
        }

        if (akses.getsatuan_barang() == true) {
            Panelmenu.add(btnSatuan);
            jmlmenu++;
        }

        if (akses.getipsrs_jenis_barang() == true) {
            Panelmenu.add(btnJenisIpsrs);
            jmlmenu++;
        }

        if (akses.getipsrs_barang() == true) {
            Panelmenu.add(btnBarangIpsrs);
            jmlmenu++;
        }

        if (akses.getsuplier_penunjang() == true) {
            Panelmenu.add(btnSuplierIPSRS);
            jmlmenu++;
        }

        if (akses.getipsrs_pengadaan_barang() == true) {
            Panelmenu.add(btnPembelianIpsrs);
            jmlmenu++;
        }

        if (akses.getipsrs_stok_keluar() == true) {
            Panelmenu.add(btnPengeluaranIpsrs);
            jmlmenu++;
        }

        if (akses.getipsrs_pengeluaran_harian() == true) {
            Panelmenu.add(btnRBiayaIpsrs);
            jmlmenu++;
        }

        if (akses.getipsrs_rekap_pengadaan() == true) {
            Panelmenu.add(btnRHMasukIpsrs);
            jmlmenu++;
        }

        if (akses.getipsrs_rekap_stok_keluar() == true) {
            Panelmenu.add(btnRHKeluarIpsrs);
            jmlmenu++;
        }

        if (akses.getpengambilan_penunjang_utd() == true) {
            Panelmenu.add(btnPengambilanPenunjangUTD);
            jmlmenu++;
        }

        if (akses.getinventaris_jenis() == true) {
            Panelmenu.add(btnJenisInventaris);
            jmlmenu++;
        }

        if (akses.getinventaris_kategori() == true) {
            Panelmenu.add(btnKategoriInventaris);
            jmlmenu++;
        }

        if (akses.getinventaris_merk() == true) {
            Panelmenu.add(btnMerkInventaris);
            jmlmenu++;
        }

        if (akses.getinventaris_ruang() == true) {
            Panelmenu.add(btnRuangInventaris);
            jmlmenu++;
        }

        if (akses.getinventaris_produsen() == true) {
            Panelmenu.add(btnProdusenInventaris);
            jmlmenu++;
        }

        if (akses.getinventaris_koleksi() == true) {
            Panelmenu.add(btnBarangInventaris);
            jmlmenu++;
        }

        if (akses.getinventaris_inventaris() == true) {
            Panelmenu.add(btnInventaris);
            jmlmenu++;
        }

        if (akses.getinventaris_sirkulasi() == true) {
            Panelmenu.add(btnSirkulasiInventaris);
            jmlmenu++;
        }

        if (akses.getobat_per_cara_bayar() == true) {
            Panelmenu.add(btnObatPerCaraBayar);
            jmlmenu++;
        }

        if (akses.getfee_visit_dokter() == true) {
            Panelmenu.add(btnfee_visit_dokter);
            jmlmenu++;
        }

        if (akses.getpembayaran_ralan() == true) {
            Panelmenu.add(btnRalanMasuk);
            jmlmenu++;
        }

        if (akses.getpembayaran_ranap() == true) {
            Panelmenu.add(btnRanapMasuk);
            jmlmenu++;
        }

        if (akses.getpiutang_ralan() == true) {
            Panelmenu.add(btnPiutangRalan);
            jmlmenu++;
        }

        if (akses.getpiutang_ranap() == true) {
            Panelmenu.add(btnPiutangRanap);
            jmlmenu++;
        }

        if (akses.gettagihan_masuk() == true) {
            Panelmenu.add(btnTagihanMasuk);
            jmlmenu++;
        }

        if (akses.gettambahan_biaya() == true) {
            Panelmenu.add(btnTambahanBiaya);
            jmlmenu++;
        }

        if (akses.getpotongan_biaya() == true) {
            Panelmenu.add(btnPotonganBiaya);
            jmlmenu++;
        }

        if (akses.getdeposit_pasien() == true) {
            Panelmenu.add(btnDeposit);
            jmlmenu++;
        }

        if (akses.getrekap_per_shift() == true) {
            Panelmenu.add(btnRekapPershift);
            jmlmenu++;
        }

        if (akses.getpayment_point() == true) {
            Panelmenu.add(btnPaymentPoint);
            jmlmenu++;
        }

        if (akses.geticd9() == true) {
            Panelmenu.add(btnICD9);
            jmlmenu++;
        }

        if (akses.getpenyakit() == true) {
            Panelmenu.add(btnICD);
            jmlmenu++;
        }

        if (akses.getpenyakit() == true) {
            Panelmenu.add(btnMasterDTD);
            jmlmenu++;
        }

        if (akses.getpenyakit_pd3i() == true) {
            Panelmenu.add(btnPenyakitPD3I);
            jmlmenu++;
        }

        if (akses.getsurveilans_pd3i() == true) {
            Panelmenu.add(btnSurveilansPD3I);
            jmlmenu++;
        }

        if (akses.getsurveilans_ralan() == true) {
            Panelmenu.add(btnSurveilansRalan);
            jmlmenu++;
        }

        if (akses.getsurveilans_ranap() == true) {
            Panelmenu.add(btnSurveilansRanap);
            jmlmenu++;
        }

        if (akses.getpny_takmenular_ralan() == true) {
            Panelmenu.add(btnPnyTakMenularRalan);
            jmlmenu++;
        }

        if (akses.getpny_takmenular_ranap() == true) {
            Panelmenu.add(btnPnyTakMenularRanap);
            jmlmenu++;
        }

        if (akses.getpenyakit_menular_ralan() == true) {
            Panelmenu.add(btnPnyMenularRalan);
            jmlmenu++;
        }

        if (akses.getpenyakit_menular_ranap() == true) {
            Panelmenu.add(btnPnyMenularRanap);
            jmlmenu++;
        }

        if (akses.getskdp_bpjs() == true) {
            Panelmenu.add(btnSKDPbpjs);
            jmlmenu++;
        }

        if (akses.getobat_penyakit() == true) {
            Panelmenu.add(btnObatPenyakit);
            jmlmenu++;
        }

        if (akses.getpenyakit_ralan() == true) {
            Panelmenu.add(btnFrekuensiRalan);
            jmlmenu++;
        }

        if (akses.getpenyakit_ranap() == true) {
            Panelmenu.add(btnFrekuensiRanap);
            jmlmenu++;
        }

        if (akses.getkunjungan_ralan() == true) {
            Panelmenu.add(btnKunjunganRalan);
            jmlmenu++;
        }

        if (akses.getkunjungan_ranap() == true) {
            Panelmenu.add(btnKunjunganRanap);
            jmlmenu++;
        }

        if (akses.getsensus_harian_poli() == true) {
            Panelmenu.add(btnSensusHarianPoli);
            jmlmenu++;
        }

        if (akses.getrl32() == true) {
            Panelmenu.add(btnRl32);
            jmlmenu++;
        }

        if (akses.getrl33() == true) {
            Panelmenu.add(btnRl33);
            jmlmenu++;
        }

        if (akses.getrl34() == true) {
            Panelmenu.add(btnRl34);
            jmlmenu++;
        }

        if (akses.getrl36() == true) {
            Panelmenu.add(btnRl36);
            jmlmenu++;
        }

        if (akses.getrl37() == true) {
            Panelmenu.add(btnRl37);
            jmlmenu++;
        }

        if (akses.getrl38() == true) {
            Panelmenu.add(btnRl38);
            jmlmenu++;
        }

        if (akses.getrl4a() == true) {
            Panelmenu.add(btnRl4a);
            jmlmenu++;
        }

        if (akses.getrl4b() == true) {
            Panelmenu.add(btnRl4b);
            jmlmenu++;
        }

        if (akses.getrl4asebab() == true) {
            Panelmenu.add(btnRl4asebab);
            jmlmenu++;
        }

        if (akses.getrl4bsebab() == true) {
            Panelmenu.add(btnRl4bsebab);
            jmlmenu++;
        }

        if (akses.getlama_pelayanan_ralan() == true) {
            Panelmenu.add(btnLamaPelayananRalan);
            jmlmenu++;
        }

        if (akses.getlama_pelayanan_apotek() == true) {
            Panelmenu.add(btnLamaPelayananApotek);
            jmlmenu++;
        }

        if (akses.getharian_HAIs() == true) {
            Panelmenu.add(btnHarianHAIsRS);
            jmlmenu++;
        }

        if (akses.getbulanan_HAIs() == true) {
            Panelmenu.add(btnBulananHAIsRS);
            jmlmenu++;
        }

        if (akses.getkamar() == true) {
            Panelmenu.add(btnKamar);
            jmlmenu++;
        }

        if (akses.gettarif_ralan() == true) {
            Panelmenu.add(btnTindakanRalan);
            jmlmenu++;
        }

        if (akses.gettarif_ranap() == true) {
            Panelmenu.add(btnTindakanRanap);
            jmlmenu++;
        }

        if (akses.gettarif_lab() == true) {
            Panelmenu.add(btnTarifLab);
            jmlmenu++;
        }

        if (akses.gettarif_radiologi() == true) {
            Panelmenu.add(btnTarifRadiologi);
            jmlmenu++;
        }

        if (akses.gettarif_operasi() == true) {
            Panelmenu.add(btnPaketOperasi);
            jmlmenu++;
        }

        if (akses.gettarif_utd() == true) {
            Panelmenu.add(btnTarifUtd);
            jmlmenu++;
        }

        if (akses.getakun_rekening() == true) {
            Panelmenu.add(btnRekening);
            jmlmenu++;
        }

        if (akses.getrekening_tahun() == true) {
            Panelmenu.add(btnRekeningTahun);
            jmlmenu++;
        }

        if (akses.getakun_bayar() == true) {
            Panelmenu.add(btnakun_bayar);
            jmlmenu++;
        }

        if (akses.getakun_piutang() == true) {
            Panelmenu.add(btnAkunPiutang);
            jmlmenu++;
        }

        if (akses.getpengaturan_rekening() == true) {
            Panelmenu.add(btnPengaturanRekening);
            jmlmenu++;
        }

        if (akses.getpengeluaran() == true) {
            Panelmenu.add(btnPengeluaran);
            jmlmenu++;
        }

        if (akses.getpemasukan_lain() == true) {
            Panelmenu.add(btnPemasukanLain);
            jmlmenu++;
        }

        if (akses.getdeposit_pasien() == true) {
            Panelmenu.add(btnDeposit);
            jmlmenu++;
        }

        if (akses.getpiutang_pasien() == true) {
            Panelmenu.add(btnLihatPiutang);
            jmlmenu++;
        }

        if (akses.getrincian_piutang_pasien() == true) {
            Panelmenu.add(btnRincianPiutangPasien);
            jmlmenu++;
        }

        if (akses.getpiutang_pasien2() == true) {
            Panelmenu.add(btnPiutangBelumLunas);
            jmlmenu++;
        }

        if (akses.getdetail_piutang_penjab() == true) {
            Panelmenu.add(btnPiutangPerCaraBayar);
            jmlmenu++;
        }

        if (akses.getbayar_piutang() == true) {
            Panelmenu.add(btnBayarPiutang);
            jmlmenu++;
        }

        if (akses.gethutang_obat() == true) {
            Panelmenu.add(btnHutangObat);
            jmlmenu++;
        }

        if (akses.getbayar_pemesanan_obat() == true) {
            Panelmenu.add(btnbayar_pemesanan);
            jmlmenu++;
        }

        if (akses.getposting_jurnal() == true) {
            Panelmenu.add(btnPostingJurnal);
            jmlmenu++;
        }

        if (akses.getjurnal_harian() == true) {
            Panelmenu.add(btnJurnalHarian);
            jmlmenu++;
        }

        if (akses.getbuku_besar() == true) {
            Panelmenu.add(btnBubes);
            jmlmenu++;
        }

        if (akses.getcashflow() == true) {
            Panelmenu.add(btnCashFlow);
            jmlmenu++;
        }

        if (akses.getkeuangan() == true) {
            Panelmenu.add(btnLabaRugi);
            jmlmenu++;
        }

        if (akses.getbpjs_cek_kartu() == true) {
            Panelmenu.add(btnCekBPJSKartu);
            jmlmenu++;
        }

        if (akses.getbpjs_cek_nik() == true) {
            Panelmenu.add(btnCekBPJSNik);
            jmlmenu++;
        }

        if (akses.getbpjs_cek_nomor_rujukan() == true) {
            Panelmenu.add(btnCekBPJSNomorRujukanPCare);
            jmlmenu++;
        }

        if (akses.getbpjs_referensi_diagnosa() == true) {
            Panelmenu.add(btnCekBPJSDiagnosa);
            jmlmenu++;
        }

        if (akses.getbpjs_referensi_poli() == true) {
            Panelmenu.add(btnCekBPJSPoli);
            jmlmenu++;
        }

        if (akses.getbpjs_referensi_faskes() == true) {
            Panelmenu.add(btnCekBPJSFaskes);
            jmlmenu++;
        }

        if (akses.getbpjs_sep() == true) {
            Panelmenu.add(btnBPJSSEP);
            jmlmenu++;
        }

        if (akses.getbpjs_monitoring_klaim() == true) {
            Panelmenu.add(btnMonitoringKlaimBPJS);
            jmlmenu++;
        }

        if (akses.getaplicare_referensi_kamar() == true) {
            Panelmenu.add(btnAplicareReferensiKamar);
            jmlmenu++;
        }

        if (akses.getaplicare_ketersediaan_kamar() == true) {
            Panelmenu.add(btnAplicareKetersediaanKamar);
            jmlmenu++;
        }

        if (akses.getinacbg_coder_nik() == true) {
            Panelmenu.add(btnInaCBGCoderNIK);
            jmlmenu++;
        }

        if (akses.getpcare_cek_penyakit() == true) {
            Panelmenu.add(btnCekPCareDiagnosa);
            jmlmenu++;
        }

        if (akses.getperusahaan_pasien() == true) {
            Panelmenu.add(btnPerusahaan);
            jmlmenu++;
        }

        if (akses.getpasien() == true) {
            Panelmenu.add(btnPasien);
            jmlmenu++;
        }

        if (akses.getkelahiran_bayi() == true) {
            Panelmenu.add(btnLahir);
            jmlmenu++;
        }

        if (akses.getcatatan_pasien() == true) {
            Panelmenu.add(btnCatatanPasien);
            jmlmenu++;
        }

        if (akses.getpasien_meninggal() == true) {
            Panelmenu.add(btnPasienMati);
            jmlmenu++;
        }

        if (akses.getdiagnosa_pasien() == true) {
            Panelmenu.add(btnDiagnosa);
            jmlmenu++;
        }

        if (akses.getdata_HAIs() == true) {
            Panelmenu.add(btnDataHAIs);
            jmlmenu++;
        }

        if (akses.getresume_pasien() == true) {
            Panelmenu.add(btnResume);
            jmlmenu++;
        }

        if (akses.getpengambilan_utd2() == true) {
            Panelmenu.add(btnPengambilanUTD2);
            jmlmenu++;
        }

        if (akses.getutd_medis_rusak() == true) {
            Panelmenu.add(btnUTDMedisRusak);
            jmlmenu++;
        }

        if (akses.getpengambilan_penunjang_utd2() == true) {
            Panelmenu.add(btnPengambilanPenunjangUTD2);
            jmlmenu++;
        }

        if (akses.getutd_penunjang_rusak() == true) {
            Panelmenu.add(btnUTDPenunjangRusak);
            jmlmenu++;
        }

        if (akses.getutd_komponen_darah() == true) {
            Panelmenu.add(btnUTDKomponenDarah);
            jmlmenu++;
        }

        if (akses.getutd_donor() == true) {
            Panelmenu.add(btnUTDDonorDarah);
            jmlmenu++;
        }

        if (akses.getutd_cekal_darah() == true) {
            Panelmenu.add(btnUTDCekalDarah);
            jmlmenu++;
        }

        if (akses.getutd_pemisahan_darah() == true) {
            Panelmenu.add(btnUTDPemisahanDarah);
            jmlmenu++;
        }

        if (akses.getutd_stok_darah() == true) {
            Panelmenu.add(btnUTDStokDarah);
            jmlmenu++;
        }

        if (akses.getutd_penyerahan_darah() == true) {
            Panelmenu.add(btnUTDPenyerahanDarah);
            jmlmenu++;
        }

        if (akses.getgrafik_kunjungan_poli() == true) {
            Panelmenu.add(btnGrafikKunjunganPoli);
            jmlmenu++;
        }

        if (akses.getgrafik_kunjungan_perdokter() == true) {
            Panelmenu.add(btnGrafikKunjunganPerDokter);
            jmlmenu++;
        }

        if (akses.getgrafik_kunjungan_perpekerjaan() == true) {
            Panelmenu.add(btnGrafikKunjunganPerPekerjaan);
            jmlmenu++;
        }

        if (akses.getgrafik_kunjungan_perpendidikan() == true) {
            Panelmenu.add(btnGrafikKunjunganPerPendidikan);
            jmlmenu++;
        }

        if (akses.getgrafik_kunjungan_pertahun() == true) {
            Panelmenu.add(btnGrafikKunjunganPerTahun);
            jmlmenu++;
        }

        if (akses.getgrafik_kunjungan_perbulan() == true) {
            Panelmenu.add(btnGrafikKunjunganPerBulan);
            jmlmenu++;
        }

        if (akses.getgrafik_kunjungan_pertanggal() == true) {
            Panelmenu.add(btnGrafikKunjunganPerTanggal);
            jmlmenu++;
        }

        if (akses.getgrafik_kunjungan_demografi() == true) {
            Panelmenu.add(btnGrafikDemografiRegistrasi);
            jmlmenu++;
        }

        if (akses.getgrafik_kunjungan_statusdaftartahun() == true) {
            Panelmenu.add(btnGrafikStatusRegPerTahun);
            jmlmenu++;
        }

        if (akses.getgrafik_kunjungan_statusdaftartahun2() == true) {
            Panelmenu.add(btnGrafikStatusRegPerTahun2);
            jmlmenu++;
        }

        if (akses.getgrafik_kunjungan_statusdaftarbulan() == true) {
            Panelmenu.add(btnGrafikStatusRegPerBulan);
            jmlmenu++;
        }

        if (akses.getgrafik_kunjungan_statusdaftarbulan2() == true) {
            Panelmenu.add(btnGrafikStatusRegPerBulan2);
            jmlmenu++;
        }

        if (akses.getgrafik_kunjungan_statusdaftartanggal() == true) {
            Panelmenu.add(btnGrafikStatusRegPerTanggal);
            jmlmenu++;
        }

        if (akses.getgrafik_kunjungan_statusdaftartanggal2() == true) {
            Panelmenu.add(btnGrafikStatusRegPerTanggal2);
            jmlmenu++;
        }

        if (akses.getgrafik_kunjungan_statusbataltahun() == true) {
            Panelmenu.add(btnGrafikStatusRegBatalPerTahun);
            jmlmenu++;
        }

        if (akses.getgrafik_kunjungan_statusbatalbulan() == true) {
            Panelmenu.add(btnGrafikStatusRegBatalPerBulan);
            jmlmenu++;
        }

        if (akses.getgrafik_kunjungan_statusbataltanggal() == true) {
            Panelmenu.add(btnGrafikStatusRegBatalPerTanggal);
            jmlmenu++;
        }

        if (akses.getaplikasi() == true) {
            Panelmenu.add(btnSetupAplikasi);
            jmlmenu++;
        }

        if (akses.getadmin() == true) {
            Panelmenu.add(btnAdmin);
            jmlmenu++;
        }

        if (akses.getsetup_pjlab() == true) {
            Panelmenu.add(btnSetPenjab);
            jmlmenu++;
        }

        if (akses.getsetup_otolokasi() == true) {
            Panelmenu.add(btnSetupOtoLokasi);
            jmlmenu++;
        }

        if (akses.getsetup_jam_kamin() == true) {
            Panelmenu.add(btnSetupJamInap);
            jmlmenu++;
        }

        if (akses.getset_harga_kamar() == true) {
            Panelmenu.add(btnSetHargaKamar);
            jmlmenu++;
        }

        if (akses.getsetup_embalase() == true) {
            Panelmenu.add(btnSetupEmbalase);
            jmlmenu++;
        }

        if (akses.getuser() == true) {
            Panelmenu.add(btnUser);
            jmlmenu++;
        }

        if (akses.gettracer_login() == true) {
            Panelmenu.add(btnTracker);
            jmlmenu++;
        }

        if (akses.getdisplay() == true) {
            Panelmenu.add(btnAntrian);
            jmlmenu++;
        }

        if (akses.getset_harga_obat() == true) {
            Panelmenu.add(btnSetupHarga);
            jmlmenu++;
        }

        if (akses.getset_harga_obat_ralan() == true) {
            Panelmenu.add(btnSetObatRalan);
            jmlmenu++;
        }

        if (akses.getset_harga_obat_ranap() == true) {
            Panelmenu.add(btnSetObatRanap);
            jmlmenu++;
        }

        if (akses.getset_penggunaan_tarif() == true) {
            Panelmenu.add(btnSetupTarif);
            jmlmenu++;
        }

        if (akses.getset_oto_ralan() == true) {
            Panelmenu.add(btnSetOtoRalan);
            jmlmenu++;
        }

        if (akses.getbiaya_harian() == true) {
            Panelmenu.add(btnSetBiayaHarian);
            jmlmenu++;
        }

        if (akses.getbiaya_masuk_sekali() == true) {
            Panelmenu.add(btnSetBiayaMasukSekali);
            jmlmenu++;
        }

        if (akses.getset_no_rm() == true) {
            Panelmenu.add(btnSetupRM);
            jmlmenu++;
        }

        if (akses.getset_nota() == true) {
            Panelmenu.add(btnSetupNota);
            jmlmenu++;
        }

        if (akses.getclosing_kasir() == true) {
            Panelmenu.add(btnClosingKasir);
            jmlmenu++;
        }

        if (akses.getketerlambatan_presensi() == true) {
            Panelmenu.add(btnKeterlambatanPresensi);
            jmlmenu++;
        }
    }

    private void isCariIsi() {
        jmlmenu = 0;
        if (btnIndikatorNasionalMutu.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
            Panelmenu.add(btnIndikatorNasionalMutu);
            jmlmenu++;
        }
        
        if (btnMasterJenisDokumenJangMed.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
            Panelmenu.add(btnMasterJenisDokumenJangMed);
            jmlmenu++;
        }
        
        if (btnMasterNomorDokumen.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
            Panelmenu.add(btnMasterNomorDokumen);
            jmlmenu++;
        }
        
        if (btnNotepad.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
            Panelmenu.add(btnNotepad);
            jmlmenu++;
        }
        
        if (akses.getsatu_sehat()== true) {
            if (btnReferensiDokterSatuSehat.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnReferensiDokterSatuSehat);
                jmlmenu++;
            }
        }
        
        if (akses.getsatu_sehat()== true) {
            if (btnReferensiPasienSatuSehat.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnReferensiPasienSatuSehat);
                jmlmenu++;
            }
        }
        
        if (akses.getadmin()== true) {
            if (btnMapingOrganisasiSatuSehat.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnMapingOrganisasiSatuSehat);
                jmlmenu++;
            }
        }
        
        if (akses.getadmin()== true) {
            if (btnMapingLokasiSatuSehat.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnMapingLokasiSatuSehat);
                jmlmenu++;
            }
        }
        
        if (akses.getadmin()== true) {
            if (btnMapingVaksinSatuSehat.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnMapingVaksinSatuSehat);
                jmlmenu++;
            }
        }
        
        if (akses.getadmin()== true) {
            if (btnMapingObatSatuSehat.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnMapingObatSatuSehat);
                jmlmenu++;
            }
        }
        
        if (akses.getsatu_sehat()== true) {
            if (btnKirimEncounterSatuSehat.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKirimEncounterSatuSehat);
                jmlmenu++;
            }
        }
        
        if (akses.getsatu_sehat()== true) {
            if (btnKirimConditionSatuSehat.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKirimConditionSatuSehat);
                jmlmenu++;
            }
        }
        
        if (akses.getsatu_sehat()== true) {
            if (btnKirimObservationSatuSehat.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKirimObservationSatuSehat);
                jmlmenu++;
            }
        }
        
        if (akses.getsatu_sehat()== true) {
            if (btnKirimProsedurSatuSehat.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKirimProsedurSatuSehat);
                jmlmenu++;
            }
        }
        
        if (akses.getsatu_sehat()== true) {
            if (btnKirimImunisasiSatuSehat.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKirimImunisasiSatuSehat);
                jmlmenu++;
            }
        }
        
        if (akses.getsatu_sehat()== true) {
            if (btnKirimClinicalSatuSehat.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKirimClinicalSatuSehat);
                jmlmenu++;
            }
        }
        
        if (akses.getsatu_sehat()== true) {
            if (btnKirimDietSatuSehat.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKirimDietSatuSehat);
                jmlmenu++;
            }
        }
        
        if (akses.getsatu_sehat()== true) {
            if (btnKirimMedicationRequestSatuSehat.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKirimMedicationRequestSatuSehat);
                jmlmenu++;
            }
        }
        
        if (akses.getsatu_sehat()== true) {
            if (btnKirimMedicationDispenseSatuSehat.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKirimMedicationDispenseSatuSehat);
                jmlmenu++;
            }
        }
        
        if (akses.getpermintaan_lab()== true) {
            if (btnSuratKonsulUnitRanap.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSuratKonsulUnitRanap);
                jmlmenu++;
            }
        }
        
        if (akses.getpermintaan_lab()== true) {
            if (btnSuratJawabanKonsulRanap.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSuratJawabanKonsulRanap);
                jmlmenu++;
            }
        }
        
        if (akses.getkegiatan_operasi()== true) {
            if (btnAsesmenKeperawatanPerioperatif.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnAsesmenKeperawatanPerioperatif);
                jmlmenu++;
            }
        }
        
        if (akses.getkegiatan_operasi()== true) {
            if (btnCeklisPraOperasi.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCeklisPraOperasi);
                jmlmenu++;
            }
        }
        
        if (akses.getkegiatan_operasi()== true) {
            if (btnCeklisKesiapanAnestesi.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCeklisKesiapanAnestesi);
                jmlmenu++;
            }
        }
        
        if (akses.getcppt()== true) {
            if (btnPerencanaanPulang.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPerencanaanPulang);
                jmlmenu++;
            }
        }
        
        if (akses.getcppt()== true) {
            if (btnLembarObservasi.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnLembarObservasi);
                jmlmenu++;
            }
        }
        
        if (akses.getcppt()== true) {
            if (btnPemantauanHarian24Jam.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPemantauanHarian24Jam);
                jmlmenu++;
            }
        }
        
        if (akses.getresep_dokter()== true) {
            if (btnAsesmenPraSedasi.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnAsesmenPraSedasi);
                jmlmenu++;
            }
        }
        
        if (akses.getresep_dokter()== true) {
            if (btnAsesmenPreInduksi.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnAsesmenPreInduksi);
                jmlmenu++;
            }
        }
        
        if (akses.getcppt()== true) {
            if (btnAsesmenUlangResikoJatuhDewasa.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnAsesmenUlangResikoJatuhDewasa);
                jmlmenu++;
            }
        }
        
        if (akses.getcppt()== true) {
            if (btnAsesmenUlangResikoJatuhAnak.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnAsesmenUlangResikoJatuhAnak);
                jmlmenu++;
            }
        }
        
        if (akses.getcppt()== true) {
            if (btnPersetujuanTindakan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPersetujuanTindakan);
                jmlmenu++;
            }
        }
        
        if (akses.getcppt()== true) {
            if (btnMonitoringEWSDewasa.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnMonitoringEWSDewasa);
                jmlmenu++;
            }
        }
        
        if (akses.getcppt()== true) {
            if (btnMonitoringPediatricEWS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnMonitoringPediatricEWS);
                jmlmenu++;
            }
        }
        
        if (akses.getcppt()== true) {
            if (btnCatatanTindakanKeperawatan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCatatanTindakanKeperawatan);
                jmlmenu++;
            }
        }
        
        if (akses.getadmin()== true) {
            if (btnBangsal.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnBangsal);
                jmlmenu++;
            }
        }
        
        if (akses.getkemoterapi()== true) {
            if (btnProtokolKemoterapi.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnProtokolKemoterapi);
                jmlmenu++;
            }
        }
        
        if (akses.getoperasi()== true) {
            if (btnJadwalOperasi.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnJadwalOperasi);
                jmlmenu++;
            }
        }
        
        if (akses.getpenilaian_awal_keperawatan_kebidanan()== true) {
            if (btnAsesmenKebidananRalan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnAsesmenKebidananRalan);
                jmlmenu++;
            }
        }
        
        if (akses.getkemenkes_sitt()== true) {
            if (btnSpirometri.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSpirometri);
                jmlmenu++;
            }
        }
        
        if (akses.getcppt()== true) {
            if (btnTransferPasienTindakan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnTransferPasienTindakan);
                jmlmenu++;
            }
        }
        
        if (akses.getcppt()== true) {
            if (btnCPPT.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCPPT);
                jmlmenu++;
            }
        }
        
        if (akses.getcppt()== true) {
            if (btnPengelolaanTransfusiDarah.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPengelolaanTransfusiDarah);
                jmlmenu++;
            }
        }
        
        if (akses.getpemberian_obat()== true) {
            if (btnPemberianObat.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPemberianObat);
                jmlmenu++;
            }
        }
        
        if (akses.getpemberian_obat()== true) {
            if (btnPetugasPelaksanaPemberianObat.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPetugasPelaksanaPemberianObat);
                jmlmenu++;
            }
        }
        
        if (akses.getasesmen_medik_dewasa_ranap()== true) {
            if (btnAsesmenMedikDewasaRanap.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnAsesmenMedikDewasaRanap);
                jmlmenu++;
            }
        }
        
        if (akses.getasesmen_medik_anak_ranap()== true) {
            if (btnAsesmenMedikAnakRanap.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnAsesmenMedikAnakRanap);
                jmlmenu++;
            }
        }
        
        if (akses.getcppt()== true) {
            if (btnAsesmenRestrain.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnAsesmenRestrain);
                jmlmenu++;
            }
        }
        
        if (akses.getsurat_keterangan_kir_mcu() == true) {
            if (btnSuratKeteranganDokter.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSuratKeteranganDokter);
                jmlmenu++;
            }
        }
        
        if (akses.getsurat_keterangan_kir_mcu() == true) {
            if (btnSuratKeteranganDisabilitas.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSuratKeteranganDisabilitas);
                jmlmenu++;
            }
        }
        
        if (akses.getsurat_keterangan_kir_mcu() == true) {
            if (btnSuratKeteranganRohani.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSuratKeteranganRohani);
                jmlmenu++;
            }
        }
        
        if (akses.getsurat_keterangan_kir_mcu() == true) {
            if (btnSuratKeteranganNAPZA.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSuratKeteranganNAPZA);
                jmlmenu++;
            }
        }
        
        if (akses.getsurat_sakit() == true) {
            if (btnSuratIstirahatSakit.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSuratIstirahatSakit);
                jmlmenu++;
            }
        }
        
        if (akses.getsurat_sakit() == true) {
            if (btnSuratKeteranganSakit.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSuratKeteranganSakit);
                jmlmenu++;
            }
        }
        
        if (akses.getsisrute_referensi_alasanrujuk() == true) {
            if (btnCekSisruteAlasanRujuk.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekSisruteAlasanRujuk);
                jmlmenu++;
            }
        }

        if (akses.getset_bridging() == true) {
            if (btnSetingBridging.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSetingBridging);
                jmlmenu++;
            }
        }

        if (akses.getkemenkes_sitt() == true) {
            if (btnKemenkesSITB.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKemenkesSITB);
                jmlmenu++;
            }
        }

        if (akses.getkemenkes_kanker() == true) {
            if (btnKemenkesKanker.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKemenkesKanker);
                jmlmenu++;
            }
        }

        if (akses.getsisrute_referensi_diagnosa() == true) {
            if (btnCekSisruteDiagnosa.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekSisruteDiagnosa);
                jmlmenu++;
            }
        }

        if (akses.getsisrute_referensi_faskes() == true) {
            if (btnCekSisruteFaskes.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekSisruteFaskes);
                jmlmenu++;
            }
        }

        if (akses.getsisrute_rujukan_keluar() == true) {
            if (btnRujukanKeluarSisrute.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRujukanKeluarSisrute);
                jmlmenu++;
            }
        }

        if (akses.getsisrute_rujukan_masuk() == true) {
            if (btnRujukanMasukSisrute.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRujukanMasukSisrute);
                jmlmenu++;
            }
        }
        
        if (akses.getadmin()== true) {
            if (btnMasterIndikatorNasionalMutu.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnMasterIndikatorNasionalMutu);
                jmlmenu++;
            }
        }
        
        if (akses.getadmin()== true) {
            if (btnMasterNumdenomINM.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnMasterNumdenomINM);
                jmlmenu++;
            }
        }
        
        if (akses.getresep_obat() == true) {
            if (btnMasterAturanPakai.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnMasterAturanPakai);
                jmlmenu++;
            }
        }
        
        if (akses.getpenilaian_pasien_geriatri() == true) {
            if (btnPenilaianTambahanGeriatri.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPenilaianTambahanGeriatri);
                jmlmenu++;
            }
        }
        
        if (akses.getpenilaian_pasien_geriatri() == true) {
            if (btnPenilaianAwalMedisRalanGeriatri.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPenilaianAwalMedisRalanGeriatri);
                jmlmenu++;
            }
        }
        
        if (akses.getcppt()== true) {
            if (btnAsesmenKeperawatanDewasa.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnAsesmenKeperawatanDewasa);
                jmlmenu++;
            }
        }
        
        if (akses.getcppt()== true) {
            if (btnAsesmenKeperawatanAnak.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnAsesmenKeperawatanAnak);
                jmlmenu++;
            }
        }
        
        if (akses.getresep_dokter()== true) {
            if (btnAssesmenMedikIGD.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnAssesmenMedikIGD);
                jmlmenu++;
            }
        }
        
        if (akses.getpenilaian_awal_keperawatan_ralan()== true) {
            if (btnAssesmenKeperawatanIGD.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnAssesmenKeperawatanIGD);
                jmlmenu++;
            }
        }
        
        if (akses.getpemberian_obat()== true) {
            if (btnTransferSerahTerimaPasien.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnTransferSerahTerimaPasien);
                jmlmenu++;
            }
        }
        
        if (akses.getadmin()== true) {
            if (btnMasterResikoDecubitus.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnMasterResikoDecubitus);
                jmlmenu++;
            }
        }
        
        if (akses.getdata_triase_igd()== true) {
            if (btnMasterFaktorResikoJatuh.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnMasterFaktorResikoJatuh);
                jmlmenu++;
            }
        }
        
        if (akses.getrekam_psikologis() == true) {
            if (btnRekamPsikologisDewasa.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRekamPsikologisDewasa);
                jmlmenu++;
            }
        }
        
        if (akses.getrekam_psikologis() == true) {
            if (btnRekamPsikologisAnak.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRekamPsikologisAnak);
                jmlmenu++;
            }
        }
        
        if (akses.getrekam_psikologis() == true) {
            if (btnRekamPsikologiPerkawinan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRekamPsikologiPerkawinan);
                jmlmenu++;
            }
        }
        
        if (akses.getrekam_psikologis() == true) {
            if (btnMasterKeluhanPsikologis.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnMasterKeluhanPsikologis);
                jmlmenu++;
            }
        }
        
        if (akses.getrekam_psikologis() == true) {
            if (btnMasterRencanaTritmenPsikologis.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnMasterRencanaTritmenPsikologis);
                jmlmenu++;
            }
        }

        if (akses.getRencanaKontrolJKN() == true) {
            if (btnRencanaKontrolBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRencanaKontrolBPJS);
                jmlmenu++;
            }
        }

        if (akses.getjkn_belum_diproses_klaim() == true) {
            if (btnINACBGjknBelumDiklaim.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnINACBGjknBelumDiklaim);
                jmlmenu++;
            }
        }

        if (akses.getbpjsSEPinternal() == true) {
            if (btnCekSEPInternalBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekSEPInternalBPJS);
                jmlmenu++;
            }
        }

        if (akses.getSPRIJKN() == true) {
            if (btnSPRIbpjsVclaim.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSPRIbpjsVclaim);
                jmlmenu++;
            }
        }

        if (akses.getinacbg_klaim_raza() == true) {
            if (btnBridgingEklaimINACBG.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnBridgingEklaimINACBG);
                jmlmenu++;
            }
        }

        if (akses.getpengajuan_klaim_raza() == true) {
            if (btnPengajuanKlaimINACBGrz.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPengajuanKlaimINACBGrz);
                jmlmenu++;
            }
        }

        if (akses.getdashboard_eResep() == true) {
            if (btnDashboardeResepRalan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnDashboardeResepRalan);
                jmlmenu++;
            }
        }
        
        if (akses.getdashboard_eResep() == true) {
            if (btnDashboardeResepRanap.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnDashboardeResepRanap);
                jmlmenu++;
            }
        }

        if (akses.getikhtisar_perawatan_hiv() == true) {
            if (btnIkhtisarPerawatanHIV.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnIkhtisarPerawatanHIV);
                jmlmenu++;
            }
        }

        if (akses.getinformasi_kamar() == true) {
            if (btnAnalisaKamar.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnAnalisaKamar);
                jmlmenu++;
            }
        }
        
        if (akses.getadmin() == true) {
            if (btnMasterKasusPersalinanDinkes.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnMasterKasusPersalinanDinkes);
                jmlmenu++;
            }
        }
        
        if (akses.getdata_persalinan() == true) {
            if (btnKasusPersalinanDinkes.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKasusPersalinanDinkes);
                jmlmenu++;
            }
        }

        if (akses.getmaster_masalah_keperawatan() == true) {
            if (btnMasterMasalahKeperawatan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnMasterMasalahKeperawatan);
                jmlmenu++;
            }
        }
        
        if (akses.getpenilaian_awal_medis_ralan_mata() == true) {
            if (btnPenilaianAwalMedisRalanMata.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPenilaianAwalMedisRalanMata);
                jmlmenu++;
            }
        }

        if (akses.getpenilaian_awal_medis_ralan_tht() == true) {
            if (btnPenilaianAwalMedisRalanTHT.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPenilaianAwalMedisRalanTHT);
                jmlmenu++;
            }
        }

        if (akses.getpenilaian_awal_keperawatan_ralan() == true) {
            if (btnPenilaianAwalKeperawatanRalan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPenilaianAwalKeperawatanRalan);
                jmlmenu++;
            }
        }

        if (akses.getpenilaian_awal_medis_ralan_kebidanan() == true) {
            if (btnAsesmenMedikObstetriRalan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnAsesmenMedikObstetriRalan);
                jmlmenu++;
            }
        }

        if (akses.getpenilaian_awal_keperawatan_kebidanan() == true) {
            if (btnPenilaianAwalKeperawatanKebidananRalan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPenilaianAwalKeperawatanKebidananRalan);
                jmlmenu++;
            }
        }
        
        if (akses.getpegawai_admin() == true) {
            if (btnDataJabatan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnDataJabatan);
                jmlmenu++;
            }
        }
        
        if (akses.getpegawai_admin() == true) {
            if (btnMasterJabatanKomite.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnMasterJabatanKomite);
                jmlmenu++;
            }
        }

        if (akses.getdata_triase_igd() == true) {
            if (btnDataTriaseIGD.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnDataTriaseIGD);
                jmlmenu++;
            }
        }

        if (akses.getmaster_cara_bayar() == true) {
            if (btnMasterCaraBayar.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnMasterCaraBayar);
                jmlmenu++;
            }
        }

        if (akses.getjadwal_praktek() == true) {
            if (BtnJadwal.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(BtnJadwal);
                jmlmenu++;
            }
        }

        if (akses.getdata_persalinan() == true) {
            if (btnDataPersalinan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnDataPersalinan);
                jmlmenu++;
            }
        }

        if (akses.getjumlah_macam_diet() == true) {
            if (btnJumlahMacamDiet.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnJumlahMacamDiet);
                jmlmenu++;
            }
        }

        if (akses.getassesmen_gizi_harian() == true) {
            if (btnAsuhanGiziRanap.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnAsuhanGiziRanap);
                jmlmenu++;
            }
        }
        
        if (akses.getassesmen_gizi_harian() == true) {
            if (btnSkriningGiziUlang.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSkriningGiziUlang);
                jmlmenu++;
            }
        }

        if (akses.getassesmen_gizi_ulang() == true) {
            if (btnAssesmenUlangGizi.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnAssesmenUlangGizi);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_cek_kartu() == true) {
            if (btnCekFingerPrinBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekFingerPrinBPJS);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_sep() == true) {
            if (btnCekReferensiPoliHFISBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekReferensiPoliHFISBPJS);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_sep() == true) {
            if (btnCekReferensiJadwalHFISBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekReferensiJadwalHFISBPJS);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_sep() == true) {
            if (btnCekReferensiDokterHFISBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekReferensiDokterHFISBPJS);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_sep() == true) {
            if (btnCekReferensiPendaftaranMobileJKNBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekReferensiPendaftaranMobileJKNBPJS);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_sep() == true) {
            if (btnCekReferensiBatalDaftarMobileJKNBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekReferensiBatalDaftarMobileJKNBPJS);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_sep() == true) {
            if (btnListSaranaRujukanBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnListSaranaRujukanBPJS);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_sep() == true) {
            if (btnKlaimJaminanJasaRaharja.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKlaimJaminanJasaRaharja);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_sep() == true) {
            if (btnDataSuplesiJasaRaharja.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnDataSuplesiJasaRaharja);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_sep() == true) {
            if (btnDataSEPIndukKLLJasaRaharja.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnDataSEPIndukKLLJasaRaharja);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_sep() == true) {
            if (btnHistoriPelayananPesertaBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnHistoriPelayananPesertaBPJS);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_sep() == true) {
            if (btnDataNomorSuratKontrolBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnDataNomorSuratKontrolBPJS);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_sep() == true) {
            if (btnCekReferensiObatPRBBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekReferensiObatPRBBPJS);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_sep() == true) {
            if (btnCekReferensiDiagnosaPRBBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekReferensiDiagnosaPRBBPJS);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_sep() == true) {
            if (btnProgramPRBBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnProgramPRBBPJS);
                jmlmenu++;
            }
        }

        if (akses.getmonev_asuhan_gizi() == true) {
            if (btnMonevAsuhanGizi.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnMonevAsuhanGizi);
                jmlmenu++;
            }
        }

        if (akses.getjumlah_porsi_diet() == true) {
            if (btnJumlahPorsiDiet.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnJumlahPorsiDiet);
                jmlmenu++;
            }
        }

        if (akses.getpermintaan_lab() == true) {
            if (btnPermintaanLab.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPermintaanLab);
                jmlmenu++;
            }
        }

        if (akses.getpermintaan_radiologi() == true) {
            if (btnPermintaanRadiologi.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPermintaanRadiologi);
                jmlmenu++;
            }
        }

        if (akses.getlaporanfarmasi() == true) {
            if (btnLaporanFarmasi.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnLaporanFarmasi);
                jmlmenu++;
            }
        }

        if (akses.getkendali_mutu_kendali_biaya_inacbg() == true) {
            if (btnKendaliMutuKendaliBiayaINACBG.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKendaliMutuKendaliBiayaINACBG);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_sep() == true) {
            if (btnListSpesialistikRujukanBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnListSpesialistikRujukanBPJS);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_cek_referensi_propinsi() == true) {
            if (btnCekReferensiPropinsiBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekReferensiPropinsiBPJS);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_cek_referensi_kabupaten() == true) {
            if (btnCekReferensiKabupatenBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekReferensiKabupatenBPJS);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_cek_referensi_kecamatan() == true) {
            if (btnCekReferensiKecamatanBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekReferensiKecamatanBPJS);
                jmlmenu++;
            }
        }

        if (akses.getmaster_faskes() == true) {
            if (btnMasterFaskes.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnMasterFaskes);
                jmlmenu++;
            }
        }
        
        if (akses.getassesmen_gizi_harian() == true) {
            if (btnMasterDiagnosaGizi.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnMasterDiagnosaGizi);
                jmlmenu++;
            }
        }

        if (akses.getringkasanpulangranap() == true) {
            if (btnRingkasanPulangRanap.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRingkasanPulangRanap);
                jmlmenu++;
            }
        }

        if (akses.getharianhaisinap() == true) {
            if (btnHarianHAIsRanap.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnHarianHAIsRanap);
                jmlmenu++;
            }
        }

        if (akses.getharianhaisjalan() == true) {
            if (btnHarianHAIsRalan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnHarianHAIsRalan);
                jmlmenu++;
            }
        }

        if (akses.getbulananhaisinap() == true) {
            if (btnBulananHAIsRanap.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnBulananHAIsRanap);
                jmlmenu++;
            }
        }

        if (akses.getbulananhaisjalan() == true) {
            if (btnBulananHAIsRalan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnBulananHAIsRalan);
                jmlmenu++;
            }
        }

        if (akses.getbarang_cssd() == true) {
            if (btnBarangCSSD.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnBarangCSSD);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_cek_referensi_pasca_pulang() == true) {
            if (btnCekReferensiPascaPulangBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekReferensiPascaPulangBPJS);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_cek_referensi_cara_keluar() == true) {
            if (btnCekReferensiCaraKeluarBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekReferensiCaraKeluarBPJS);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_cek_referensi_ruang_rawat() == true) {
            if (btnCekReferensiRuangRawatBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekReferensiRuangRawatBPJS);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_cek_referensi_spesialistik() == true) {
            if (btnCekReferensiSpesialistikBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekReferensiSpesialistikBPJS);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_cek_referensi_dokter() == true) {
            if (btnCekReferensiDokterBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekReferensiDokterBPJS);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_cek_referensi_prosedur() == true) {
            if (btnCekReferensiProsedurBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekReferensiProsedurBPJS);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_cek_referensi_dpjp() == true) {
            if (btnCekReferensiDokterDPJPBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekReferensiDokterDPJPBPJS);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_cek_referensi_kelas_rawat() == true) {
            if (btnCekReferensiKelasRawatBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekReferensiKelasRawatBPJS);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_cek_tgl_rujukan() == true) {
            if (btnCekBPJSTanggalRujukan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekBPJSTanggalRujukan);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_cek_no_rujukan_rs() == true) {
            if (btnCekBPJSNomorRujukanRS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekBPJSNomorRujukanRS);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_cek_rujukan_kartu_pcare() == true) {
            if (btnCekBPJSRujukanKartuPCare.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekBPJSRujukanKartuPCare);
                jmlmenu++;
            }
        }

        if (akses.getinput_kode_icd() == true) {
            if (btnInputKodeICD.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnInputKodeICD);
                jmlmenu++;
            }
        }

        if (akses.getdata_ponek() == true) {
            if (btnPasienPonek.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPasienPonek);
                jmlmenu++;
            }
        }

        if (akses.getpasien_corona() == true) {
            if (btnPasienCorona.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPasienCorona);
                jmlmenu++;
            }
        }

        if (akses.getdiagnosa_pasien_corona() == true) {
            if (btnDiagnosaPasienCorona.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnDiagnosaPasienCorona);
                jmlmenu++;
            }
        }

        if (akses.getperawatan_pasien_corona() == true) {
            if (btnPerawatanPasienCorona.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPerawatanPasienCorona);
                jmlmenu++;
            }
        }

        if (akses.getbooking_registrasi() == true) {
            if (btnBookingReg.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnBookingReg);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_cek_riwayat_rujukan_pcare() == true) {
            if (btnBPJScekRiwayatRujukanPcare.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnBPJScekRiwayatRujukanPcare);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_cek_riwayat_rujukan_rs() == true) {
            if (btnCekBPJSRiwayatRujukanRS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekBPJSRiwayatRujukanRS);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_cek_rujukan_kartu_rs() == true) {
            if (btnCekBPJSRujukanKartuRS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekBPJSRujukanKartuRS);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_rujukan_keluar() == true) {
            if (btnRujukKeluarVclaim.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRujukKeluarVclaim);
                jmlmenu++;
            }
        }

        if (akses.getregistrasi() == true) {
            if (btnRegistrasi.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRegistrasi);
                jmlmenu++;
            }
        }

        if (akses.getigd() == true) {
            if (btnIGD.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnIGD);
                jmlmenu++;
            }
        }

        if (akses.gettindakan_ralan() == true) {
            if (btnRalan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRalan);
                jmlmenu++;
            }
        }

        if (akses.getkamar_inap() == true) {
            if (btnKamarInap.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKamarInap);
                jmlmenu++;
            }
        }

        if (akses.getdpjp_ranap() == true) {
            if (BtnDpjp.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(BtnDpjp);
                jmlmenu++;
            }
        }

        if (akses.gettindakan_ranap() == true) {
            if (btnRanap.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRanap);
                jmlmenu++;
            }
        }

        if (akses.getskdp_bpjs() == true) {
            if (btnSKDPbpjs.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSKDPbpjs);
                jmlmenu++;
            }
        }

        if (akses.getoperasi() == true) {
            if (btnTagihanOperasi.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnTagihanOperasi);
                jmlmenu++;
            }
        }

        if (akses.getrujukan_keluar() == true) {
            if (btnRujukPasien.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRujukPasien);
                jmlmenu++;
            }
        }

        if (akses.getrujukan_masuk() == true) {
            if (btnRujukMasuk.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRujukMasuk);
                jmlmenu++;
            }
        }

        if (akses.getberi_obat() == true) {
            if (btnBeriObat.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnBeriObat);
                jmlmenu++;
            }
        }

        if (akses.getresep_pulang() == true) {
            if (btnResepPulang.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnResepPulang);
                jmlmenu++;
            }
        }

        if (akses.getresep_obat() == true) {
            if (btnResepObat.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnResepObat);
                jmlmenu++;
            }
        }

        if (akses.getdiet_pasien() == true) {
            if (btnDiet.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnDiet);
                jmlmenu++;
            }
        }

        if (akses.getperiksa_lab() == true) {
            if (btnLaboratorium.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnLaboratorium);
                jmlmenu++;
            }
        }

        if (akses.getperiksa_radiologi() == true) {
            if (btnPeriksaRadiologi.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPeriksaRadiologi);
                jmlmenu++;
            }
        }

        if (akses.getkasir_ralan() == true) {
            if (btnKasir.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKasir);
                jmlmenu++;
            }
        }
        
        if (akses.getbilling_ranap() == true) {
            if (btnTransaksiPanjar.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnTransaksiPanjar);
                jmlmenu++;
            }
        }

        if (akses.getdeposit_pasien() == true) {
            if (btnDeposit.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnDeposit);
                jmlmenu++;
            }
        }

        if (akses.getpiutang_pasien() == true) {
            if (btnLihatPiutang.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnLihatPiutang);
                jmlmenu++;
            }
        }

        if (akses.getpetugas() == true) {
            if (btnPegawai.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPegawai);
                jmlmenu++;
            }
        }

        if (akses.getdokter() == true) {
            if (btnDokter.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnDokter);
                jmlmenu++;
            }
        }

        if ((akses.getpegawai_admin() == true) || (akses.getpegawai_user() == true)) {
            if (btnPenggajian.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPenggajian);
                jmlmenu++;
            }
        }

        if (akses.getindustrifarmasi() == true) {
            if (btnIndustriFarmasi.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnIndustriFarmasi);
                jmlmenu++;
            }
        }

        if (akses.getsuplier() == true) {
            if (btnSuplier.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSuplier);
                jmlmenu++;
            }
        }

        if (akses.getsatuan_barang() == true) {
            if (btnSatuan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSatuan);
                jmlmenu++;
            }
        }

        if (akses.getkonversi_satuan() == true) {
            if (btnKonversi.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKonversi);
                jmlmenu++;
            }
        }

        if (akses.getjenis_barang() == true) {
            if (btnJnsBarang.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnJnsBarang);
                jmlmenu++;
            }
        }

        if (akses.getkategori_barang() == true) {
            if (btnKategoriBarang.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKategoriBarang);
                jmlmenu++;
            }
        }

        if (akses.getgolongan_barang() == true) {
            if (btnGolonganBarang.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnGolonganBarang);
                jmlmenu++;
            }
        }

        if (akses.getobat() == true) {
            if (btnObat.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnObat);
                jmlmenu++;
            }
        }

        if (akses.getstok_opname_obat() == true) {
            if (btnOpname.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnOpname);
                jmlmenu++;
            }
        }

        if (akses.getmutasi_barang() == true) {
            if (btnMutasiBarang.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnMutasiBarang);
                jmlmenu++;
            }
        }

        if (akses.getstok_obat_pasien() == true) {
            if (btnStokObatPasien.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnStokObatPasien);
                jmlmenu++;
            }
        }

        if (akses.getpengadaan_obat() == true) {
            if (btnPembelian.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPembelian);
                jmlmenu++;
            }
        }

        if (akses.getpemesanan_obat() == true) {
            if (btnPemesanan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPemesanan);
                jmlmenu++;
            }
        }

        if (akses.getpenjualan_obat() == true) {
            if (btnPenjualan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPenjualan);
                jmlmenu++;
            }
        }

        if (akses.getresep_dokter() == true) {
            if (btnDaftarPermintaanResep.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnDaftarPermintaanResep);
                jmlmenu++;
            }
        }

        if (akses.getpiutang_obat() == true) {
            if (btnPiutang.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPiutang);
                jmlmenu++;
            }

        }

        if (akses.getretur_ke_suplier() == true) {
            if (btnReturBeli.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnReturBeli);
                jmlmenu++;
            }
        }

        if (akses.getretur_dari_pembeli() == true) {
            if (btnReturJual.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnReturJual);
                jmlmenu++;
            }
        }

        if (akses.getretur_obat_ranap() == true) {
            if (btnReturPasien.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnReturPasien);
                jmlmenu++;
            }
        }

        if (akses.getretur_piutang_pasien() == true) {
            if (btnReturPiutang.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnReturPiutang);
                jmlmenu++;
            }
        }

        if (akses.getpengambilan_utd() == true) {
            if (btnPengambilanUTD.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPengambilanUTD);
                jmlmenu++;
            }
        }

        if (akses.getkeuntungan_penjualan() == true) {
            if (btnKeuntungan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKeuntungan);
                jmlmenu++;
            }
        }

        if (akses.getkeuntungan_beri_obat() == true) {
            if (btnKeuntunganObatRanap.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKeuntunganObatRanap);
                jmlmenu++;
            }
        }

        if (akses.getkeuntungan_beri_obat_nonpiutang() == true) {
            if (btnKeuntunganObat2.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKeuntunganObat2);
                jmlmenu++;
            }
        }

        if (akses.getsirkulasi_obat() == true) {
            if (btnSirkulasi.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSirkulasi);
                jmlmenu++;
            }
        }

        if (akses.getsirkulasi_obat2() == true) {
            if (btnSirkulasi2.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSirkulasi2);
                jmlmenu++;
            }
        }

        if (akses.getpemberian_obat_pertanggal() == true) {
            if (btnObatPerTanggal.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnObatPerTanggal);
                jmlmenu++;
            }
        }

        if (akses.getpenjualan_obat_pertanggal() == true) {
            if (btnPenjualanPerTanggal.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPenjualanPerTanggal);
                jmlmenu++;
            }
        }

        if (akses.getriwayat_obat_alkes_bhp() == true) {
            if (btnRiwayatBarangMedis.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRiwayatBarangMedis);
                jmlmenu++;
            }
        }

        if (akses.getdarurat_stok() == true) {
            if (btnDaruratStok.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnDaruratStok);
                jmlmenu++;
            }
        }

        if (akses.getsatuan_barang() == true) {
            if (btnSatuan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSatuan);
                jmlmenu++;
            }
        }

        if (akses.getipsrs_jenis_barang() == true) {
            if (btnJenisIpsrs.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnJenisIpsrs);
                jmlmenu++;
            }
        }

        if (akses.getipsrs_barang() == true) {
            if (btnBarangIpsrs.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnBarangIpsrs);
                jmlmenu++;
            }
        }

        if (akses.getsuplier_penunjang() == true) {
            if (btnSuplierIPSRS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSuplierIPSRS);
                jmlmenu++;
            }
        }

        if (akses.getipsrs_pengadaan_barang() == true) {
            if (btnPembelianIpsrs.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPembelianIpsrs);
                jmlmenu++;
            }
        }

        if (akses.getipsrs_stok_keluar() == true) {
            if (btnPengeluaranIpsrs.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPengeluaranIpsrs);
                jmlmenu++;
            }
        }

        if (akses.getipsrs_pengeluaran_harian() == true) {
            if (btnRBiayaIpsrs.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRBiayaIpsrs);
                jmlmenu++;
            }
        }

        if (akses.getipsrs_rekap_pengadaan() == true) {
            if (btnRHMasukIpsrs.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRHMasukIpsrs);
                jmlmenu++;
            }
        }

        if (akses.getipsrs_rekap_stok_keluar() == true) {
            if (btnRHKeluarIpsrs.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRHKeluarIpsrs);
                jmlmenu++;
            }
        }

        if (akses.getpengambilan_penunjang_utd() == true) {
            if (btnPengambilanPenunjangUTD.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPengambilanPenunjangUTD);
                jmlmenu++;
            }
        }

        if (akses.getinventaris_jenis() == true) {
            if (btnJenisInventaris.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnJenisInventaris);
                jmlmenu++;
            }
        }

        if (akses.getinventaris_kategori() == true) {
            if (btnKategoriInventaris.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKategoriInventaris);
                jmlmenu++;
            }
        }

        if (akses.getinventaris_merk() == true) {
            if (btnMerkInventaris.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnMerkInventaris);
                jmlmenu++;
            }
        }

        if (akses.getinventaris_ruang() == true) {
            if (btnRuangInventaris.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRuangInventaris);
                jmlmenu++;
            }
        }

        if (akses.getinventaris_produsen() == true) {
            if (btnProdusenInventaris.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnProdusenInventaris);
                jmlmenu++;
            }
        }

        if (akses.getinventaris_koleksi() == true) {
            if (btnBarangInventaris.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnBarangInventaris);
                jmlmenu++;
            }
        }

        if (akses.getinventaris_inventaris() == true) {
            if (btnInventaris.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnInventaris);
                jmlmenu++;
            }
        }

        if (akses.getinventaris_sirkulasi() == true) {
            if (btnSirkulasiInventaris.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSirkulasiInventaris);
                jmlmenu++;
            }
        }

        if (akses.getobat_per_cara_bayar() == true) {
            if (btnObatPerCaraBayar.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnObatPerCaraBayar);
                jmlmenu++;
            }
        }

        if (akses.getfee_visit_dokter() == true) {
            if (btnfee_visit_dokter.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnfee_visit_dokter);
                jmlmenu++;
            }
        }

        if (akses.getpembayaran_ralan() == true) {
            if (btnRalanMasuk.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRalanMasuk);
                jmlmenu++;
            }
        }

        if (akses.getpembayaran_ranap() == true) {
            if (btnRanapMasuk.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRanapMasuk);
                jmlmenu++;
            }
        }

        if (akses.getpiutang_ralan() == true) {
            if (btnPiutangRalan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPiutangRalan);
                jmlmenu++;
            }
        }

        if (akses.getpiutang_ranap() == true) {
            if (btnPiutangRanap.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPiutangRanap);
                jmlmenu++;
            }
        }

        if (akses.gettagihan_masuk() == true) {
            if (btnTagihanMasuk.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnTagihanMasuk);
                jmlmenu++;
            }
        }

        if (akses.gettambahan_biaya() == true) {
            if (btnTambahanBiaya.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnTambahanBiaya);
                jmlmenu++;
            }
        }

        if (akses.getpotongan_biaya() == true) {
            if (btnPotonganBiaya.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPotonganBiaya);
                jmlmenu++;
            }
        }

        if (akses.getdeposit_pasien() == true) {
            if (btnDeposit.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnDeposit);
                jmlmenu++;
            }
        }

        if (akses.getrekap_per_shift() == true) {
            if (btnRekapPershift.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRekapPershift);
                jmlmenu++;
            }
        }

        if (akses.getpayment_point() == true) {
            if (btnPaymentPoint.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPaymentPoint);
                jmlmenu++;
            }
        }

        if (akses.geticd9() == true) {
            if (btnICD9.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnICD9);
                jmlmenu++;
            }
        }

        if (akses.getpenyakit() == true) {
            if (btnICD.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnICD);
                jmlmenu++;
            }
        }

        if (akses.getpenyakit() == true) {
            if (btnMasterDTD.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnMasterDTD);
                jmlmenu++;
            }
        }

        if (akses.getpenyakit_pd3i() == true) {
            if (btnPenyakitPD3I.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPenyakitPD3I);
                jmlmenu++;
            }
        }

        if (akses.getsurveilans_pd3i() == true) {
            if (btnSurveilansPD3I.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSurveilansPD3I);
                jmlmenu++;
            }
        }

        if (akses.getsurveilans_ralan() == true) {
            if (btnSurveilansRalan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSurveilansRalan);
                jmlmenu++;
            }
        }

        if (akses.getsurveilans_ranap() == true) {
            if (btnSurveilansRanap.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSurveilansRanap);
                jmlmenu++;
            }
        }

        if (akses.getpny_takmenular_ralan() == true) {
            if (btnPnyTakMenularRalan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPnyTakMenularRalan);
                jmlmenu++;
            }
        }

        if (akses.getpny_takmenular_ranap() == true) {
            if (btnPnyTakMenularRanap.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPnyTakMenularRanap);
                jmlmenu++;
            }
        }

        if (akses.getpenyakit_menular_ralan() == true) {
            if (btnPnyMenularRalan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPnyMenularRalan);
                jmlmenu++;
            }
        }

        if (akses.getpenyakit_menular_ranap() == true) {
            if (btnPnyMenularRanap.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPnyMenularRanap);
                jmlmenu++;
            }
        }

        if (akses.getobat_penyakit() == true) {
            if (btnObatPenyakit.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnObatPenyakit);
                jmlmenu++;
            }
        }

        if (akses.getpenyakit_ralan() == true) {
            if (btnFrekuensiRalan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnFrekuensiRalan);
                jmlmenu++;
            }
        }

        if (akses.getpenyakit_ranap() == true) {
            if (btnFrekuensiRanap.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnFrekuensiRanap);
                jmlmenu++;
            }
        }

        if (akses.getkunjungan_ralan() == true) {
            if (btnKunjunganRalan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKunjunganRalan);
                jmlmenu++;
            }
        }

        if (akses.getkunjungan_ranap() == true) {
            if (btnKunjunganRanap.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKunjunganRanap);
                jmlmenu++;
            }
        }

        if (akses.getsensus_harian_poli() == true) {
            if (btnSensusHarianPoli.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSensusHarianPoli);
                jmlmenu++;
            }
        }

        if (akses.getrl32() == true) {
            if (btnRl32.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRl32);
                jmlmenu++;
            }
        }

        if (akses.getrl33() == true) {
            if (btnRl33.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRl33);
                jmlmenu++;
            }
        }

        if (akses.getrl34() == true) {
            if (btnRl34.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRl34);
                jmlmenu++;
            }
        }

        if (akses.getrl36() == true) {
            if (btnRl36.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRl36);
                jmlmenu++;
            }
        }

        if (akses.getrl37() == true) {
            if (btnRl37.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRl37);
                jmlmenu++;
            }
        }

        if (akses.getrl38() == true) {
            if (btnRl38.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRl38);
                jmlmenu++;
            }
        }

        if (akses.getrl4a() == true) {
            if (btnRl4a.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRl4a);
                jmlmenu++;
            }
        }

        if (akses.getrl4b() == true) {
            if (btnRl4b.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRl4b);
                jmlmenu++;
            }
        }

        if (akses.getrl4asebab() == true) {
            if (btnRl4asebab.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRl4asebab);
                jmlmenu++;
            }
        }

        if (akses.getrl4bsebab() == true) {
            if (btnRl4bsebab.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRl4bsebab);
                jmlmenu++;
            }
        }

        if (akses.getlama_pelayanan_ralan() == true) {
            if (btnLamaPelayananRalan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnLamaPelayananRalan);
                jmlmenu++;
            }
        }

        if (akses.getlama_pelayanan_apotek() == true) {
            if (btnLamaPelayananApotek.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnLamaPelayananApotek);
                jmlmenu++;
            }
        }

        if (akses.getharian_HAIs() == true) {
            if (btnHarianHAIsRS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnHarianHAIsRS);
                jmlmenu++;
            }
        }

        if (akses.getbulanan_HAIs() == true) {
            if (btnBulananHAIsRS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnBulananHAIsRS);
                jmlmenu++;
            }
        }

        if (akses.getkamar() == true) {
            if (btnKamar.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKamar);
                jmlmenu++;
            }
        }

        if (akses.gettarif_ralan() == true) {
            if (btnTindakanRalan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnTindakanRalan);
                jmlmenu++;
            }
        }

        if (akses.gettarif_ranap() == true) {
            if (btnTindakanRanap.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnTindakanRanap);
                jmlmenu++;
            }
        }

        if (akses.gettarif_lab() == true) {
            if (btnTarifLab.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnTarifLab);
                jmlmenu++;
            }
        }

        if (akses.gettarif_radiologi() == true) {
            if (btnTarifRadiologi.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnTarifRadiologi);
                jmlmenu++;
            }
        }

        if (akses.gettarif_operasi() == true) {
            if (btnPaketOperasi.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPaketOperasi);
                jmlmenu++;
            }
        }

        if (akses.gettarif_utd() == true) {
            if (btnTarifUtd.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnTarifUtd);
                jmlmenu++;
            }
        }

        if (akses.getakun_rekening() == true) {
            if (btnRekening.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRekening);
                jmlmenu++;
            }
        }

        if (akses.getrekening_tahun() == true) {
            if (btnRekeningTahun.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRekeningTahun);
                jmlmenu++;
            }
        }

        if (akses.getakun_bayar() == true) {
            if (btnakun_bayar.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnakun_bayar);
                jmlmenu++;
            }
        }

        if (akses.getakun_piutang() == true) {
            if (btnAkunPiutang.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnAkunPiutang);
                jmlmenu++;
            }
        }

        if (akses.getpengaturan_rekening() == true) {
            if (btnPengaturanRekening.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPengaturanRekening);
                jmlmenu++;
            }
        }

        if (akses.getpengeluaran() == true) {
            if (btnPengeluaran.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPengeluaran);
                jmlmenu++;
            }
        }

        if (akses.getpemasukan_lain() == true) {
            if (btnPemasukanLain.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPemasukanLain);
                jmlmenu++;
            }
        }

        if (akses.getdeposit_pasien() == true) {
            if (btnDeposit.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnDeposit);
                jmlmenu++;
            }
        }

        if (akses.getpiutang_pasien() == true) {
            if (btnLihatPiutang.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnLihatPiutang);
                jmlmenu++;
            }
        }

        if (akses.getrincian_piutang_pasien() == true) {
            if (btnRincianPiutangPasien.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnRincianPiutangPasien);
                jmlmenu++;
            }
        }

        if (akses.getpiutang_pasien2() == true) {
            if (btnPiutangBelumLunas.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPiutangBelumLunas);
                jmlmenu++;
            }
        }

        if (akses.getdetail_piutang_penjab() == true) {
            if (btnPiutangPerCaraBayar.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPiutangPerCaraBayar);
                jmlmenu++;
            }
        }

        if (akses.getbayar_piutang() == true) {
            if (btnBayarPiutang.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnBayarPiutang);
                jmlmenu++;
            }
        }

        if (akses.gethutang_obat() == true) {
            if (btnHutangObat.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnHutangObat);
                jmlmenu++;
            }
        }

        if (akses.getbayar_pemesanan_obat() == true) {
            if (btnbayar_pemesanan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnbayar_pemesanan);
                jmlmenu++;
            }
        }

        if (akses.getposting_jurnal() == true) {
            if (btnPostingJurnal.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPostingJurnal);
                jmlmenu++;
            }
        }

        if (akses.getjurnal_harian() == true) {
            if (btnJurnalHarian.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnJurnalHarian);
                jmlmenu++;
            }
        }

        if (akses.getbuku_besar() == true) {
            if (btnBubes.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnBubes);
                jmlmenu++;
            }
        }

        if (akses.getcashflow() == true) {
            if (btnCashFlow.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCashFlow);
                jmlmenu++;
            }
        }

        if (akses.getkeuangan() == true) {
            if (btnLabaRugi.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnLabaRugi);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_cek_kartu() == true) {
            if (btnCekBPJSKartu.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekBPJSKartu);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_cek_nik() == true) {
            if (btnCekBPJSNik.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekBPJSNik);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_cek_nomor_rujukan() == true) {
            if (btnCekBPJSNomorRujukanPCare.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekBPJSNomorRujukanPCare);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_referensi_diagnosa() == true) {
            if (btnCekBPJSDiagnosa.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekBPJSDiagnosa);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_referensi_poli() == true) {
            if (btnCekBPJSPoli.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekBPJSPoli);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_referensi_faskes() == true) {
            if (btnCekBPJSFaskes.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekBPJSFaskes);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_sep() == true) {
            if (btnBPJSSEP.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnBPJSSEP);
                jmlmenu++;
            }
        }

        if (akses.getbpjs_monitoring_klaim() == true) {
            if (btnMonitoringKlaimBPJS.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnMonitoringKlaimBPJS);
                jmlmenu++;
            }
        }

        if (akses.getaplicare_referensi_kamar() == true) {
            if (btnAplicareReferensiKamar.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnAplicareReferensiKamar);
                jmlmenu++;
            }
        }

        if (akses.getaplicare_ketersediaan_kamar() == true) {
            if (btnAplicareKetersediaanKamar.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnAplicareKetersediaanKamar);
                jmlmenu++;
            }
        }

        if (akses.getinacbg_coder_nik() == true) {
            if (btnInaCBGCoderNIK.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnInaCBGCoderNIK);
                jmlmenu++;
            }
        }

        if (akses.getpcare_cek_penyakit() == true) {
            if (btnCekPCareDiagnosa.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCekPCareDiagnosa);
                jmlmenu++;
            }
        }

        if (akses.getperusahaan_pasien() == true) {
            if (btnPerusahaan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPerusahaan);
                jmlmenu++;
            }
        }

        if (akses.getpasien() == true) {
            if (btnPasien.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPasien);
                jmlmenu++;
            }
        }

        if (akses.getkelahiran_bayi() == true) {
            if (btnLahir.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnLahir);
                jmlmenu++;
            }
        }

        if (akses.getcatatan_pasien() == true) {
            if (btnCatatanPasien.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnCatatanPasien);
                jmlmenu++;
            }
        }

        if (akses.getpasien_meninggal() == true) {
            if (btnPasienMati.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPasienMati);
                jmlmenu++;
            }
        }

        if (akses.getdiagnosa_pasien() == true) {
            if (btnDiagnosa.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnDiagnosa);
                jmlmenu++;
            }
        }

        if (akses.getdata_HAIs() == true) {
            if (btnDataHAIs.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnDataHAIs);
                jmlmenu++;
            }
        }

        if (akses.getresume_pasien() == true) {
            if (btnResume.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnResume);
                jmlmenu++;
            }
        }

        if (akses.getpengambilan_utd2() == true) {
            if (btnPengambilanUTD2.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPengambilanUTD2);
                jmlmenu++;
            }
        }

        if (akses.getutd_medis_rusak() == true) {
            if (btnUTDMedisRusak.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnUTDMedisRusak);
                jmlmenu++;
            }
        }

        if (akses.getpengambilan_penunjang_utd2() == true) {
            if (btnPengambilanPenunjangUTD2.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnPengambilanPenunjangUTD2);
                jmlmenu++;
            }
        }

        if (akses.getutd_penunjang_rusak() == true) {
            if (btnUTDPenunjangRusak.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnUTDPenunjangRusak);
                jmlmenu++;
            }
        }

        if (akses.getutd_komponen_darah() == true) {
            if (btnUTDKomponenDarah.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnUTDKomponenDarah);
                jmlmenu++;
            }
        }

        if (akses.getutd_donor() == true) {
            if (btnUTDDonorDarah.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnUTDDonorDarah);
                jmlmenu++;
            }
        }

        if (akses.getutd_cekal_darah() == true) {
            if (btnUTDCekalDarah.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnUTDCekalDarah);
                jmlmenu++;
            }
        }

        if (akses.getutd_pemisahan_darah() == true) {
            if (btnUTDPemisahanDarah.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnUTDPemisahanDarah);
                jmlmenu++;
            }
        }

        if (akses.getutd_stok_darah() == true) {
            if (btnUTDStokDarah.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnUTDStokDarah);
                jmlmenu++;
            }
        }

        if (akses.getutd_penyerahan_darah() == true) {
            if (btnUTDPenyerahanDarah.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnUTDPenyerahanDarah);
                jmlmenu++;
            }
        }

        if (akses.getgrafik_kunjungan_poli() == true) {
            if (btnGrafikKunjunganPoli.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnGrafikKunjunganPoli);
                jmlmenu++;
            }
        }

        if (akses.getgrafik_kunjungan_perdokter() == true) {
            if (btnGrafikKunjunganPerDokter.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnGrafikKunjunganPerDokter);
                jmlmenu++;
            }
        }

        if (akses.getgrafik_kunjungan_perpekerjaan() == true) {
            if (btnGrafikKunjunganPerPekerjaan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnGrafikKunjunganPerPekerjaan);
                jmlmenu++;
            }
        }

        if (akses.getgrafik_kunjungan_perpendidikan() == true) {
            if (btnGrafikKunjunganPerPendidikan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnGrafikKunjunganPerPendidikan);
                jmlmenu++;
            }
        }

        if (akses.getgrafik_kunjungan_pertahun() == true) {
            if (btnGrafikKunjunganPerTahun.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnGrafikKunjunganPerTahun);
                jmlmenu++;
            }
        }

        if (akses.getgrafik_kunjungan_perbulan() == true) {
            if (btnGrafikKunjunganPerBulan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnGrafikKunjunganPerBulan);
                jmlmenu++;
            }
        }

        if (akses.getgrafik_kunjungan_pertanggal() == true) {
            if (btnGrafikKunjunganPerTanggal.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnGrafikKunjunganPerTanggal);
                jmlmenu++;
            }
        }

        if (akses.getgrafik_kunjungan_demografi() == true) {
            if (btnGrafikDemografiRegistrasi.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnGrafikDemografiRegistrasi);
                jmlmenu++;
            }
        }

        if (akses.getgrafik_kunjungan_statusdaftartahun() == true) {
            if (btnGrafikStatusRegPerTahun.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnGrafikStatusRegPerTahun);
                jmlmenu++;
            }
        }

        if (akses.getgrafik_kunjungan_statusdaftartahun2() == true) {
            if (btnGrafikStatusRegPerTahun2.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnGrafikStatusRegPerTahun2);
                jmlmenu++;
            }
        }

        if (akses.getgrafik_kunjungan_statusdaftarbulan() == true) {
            if (btnGrafikStatusRegPerBulan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnGrafikStatusRegPerBulan);
                jmlmenu++;
            }
        }

        if (akses.getgrafik_kunjungan_statusdaftarbulan2() == true) {
            if (btnGrafikStatusRegPerBulan2.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnGrafikStatusRegPerBulan2);
                jmlmenu++;
            }
        }

        if (akses.getgrafik_kunjungan_statusdaftartanggal() == true) {
            if (btnGrafikStatusRegPerTanggal.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnGrafikStatusRegPerTanggal);
                jmlmenu++;
            }
        }

        if (akses.getgrafik_kunjungan_statusdaftartanggal2() == true) {
            if (btnGrafikStatusRegPerTanggal2.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnGrafikStatusRegPerTanggal2);
                jmlmenu++;
            }
        }

        if (akses.getgrafik_kunjungan_statusbataltahun() == true) {
            if (btnGrafikStatusRegBatalPerTahun.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnGrafikStatusRegBatalPerTahun);
                jmlmenu++;
            }
        }

        if (akses.getgrafik_kunjungan_statusbatalbulan() == true) {
            if (btnGrafikStatusRegBatalPerBulan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnGrafikStatusRegBatalPerBulan);
                jmlmenu++;
            }
        }

        if (akses.getgrafik_kunjungan_statusbataltanggal() == true) {
            if (btnGrafikStatusRegBatalPerTanggal.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnGrafikStatusRegBatalPerTanggal);
                jmlmenu++;
            }
        }

        if (akses.getaplikasi() == true) {
            if (btnSetupAplikasi.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSetupAplikasi);
                jmlmenu++;
            }
        }

        if (akses.getadmin() == true) {
            if (btnAdmin.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnAdmin);
                jmlmenu++;
            }
        }

        if (akses.getsetup_pjlab() == true) {
            if (btnSetPenjab.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSetPenjab);
                jmlmenu++;
            }
        }

        if (akses.getsetup_otolokasi() == true) {
            if (btnSetupOtoLokasi.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSetupOtoLokasi);
                jmlmenu++;
            }
        }

        if (akses.getsetup_jam_kamin() == true) {
            if (btnSetupJamInap.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSetupJamInap);
                jmlmenu++;
            }
        }

        if (akses.getset_harga_kamar() == true) {
            if (btnSetHargaKamar.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSetHargaKamar);
                jmlmenu++;
            }
        }

        if (akses.getsetup_embalase() == true) {
            if (btnSetupEmbalase.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSetupEmbalase);
                jmlmenu++;
            }
        }

        if (akses.getuser() == true) {
            if (btnUser.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnUser);
                jmlmenu++;
            }
        }

        if (akses.gettracer_login() == true) {
            if (btnTracker.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnTracker);
                jmlmenu++;
            }
        }

        if (akses.getdisplay() == true) {
            if (btnAntrian.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnAntrian);
                jmlmenu++;
            }
        }

        if (akses.getset_harga_obat() == true) {
            if (btnSetupHarga.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSetupHarga);
                jmlmenu++;
            }
        }

        if (akses.getset_harga_obat_ralan() == true) {
            if (btnSetObatRalan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSetObatRalan);
                jmlmenu++;
            }
        }

        if (akses.getset_harga_obat_ranap() == true) {
            if (btnSetObatRanap.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSetObatRanap);
                jmlmenu++;
            }
        }

        if (akses.getset_penggunaan_tarif() == true) {
            if (btnSetupTarif.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSetupTarif);
                jmlmenu++;
            }
        }

        if (akses.getset_oto_ralan() == true) {
            if (btnSetOtoRalan.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSetOtoRalan);
                jmlmenu++;
            }
        }

        if (akses.getbiaya_harian() == true) {
            if (btnSetBiayaHarian.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSetBiayaHarian);
                jmlmenu++;
            }
        }

        if (akses.getbiaya_masuk_sekali() == true) {
            if (btnSetBiayaMasukSekali.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSetBiayaMasukSekali);
                jmlmenu++;
            }
        }

        if (akses.getset_no_rm() == true) {
            if (btnSetupRM.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSetupRM);
                jmlmenu++;
            }
        }

        if (akses.getset_nota() == true) {
            if (btnSetupNota.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnSetupNota);
                jmlmenu++;
            }
        }

        if (akses.getclosing_kasir() == true) {
            if (btnClosingKasir.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnClosingKasir);
                jmlmenu++;
            }
        }

        if (akses.getketerlambatan_presensi() == true) {
            if (btnKeterlambatanPresensi.getText().toLowerCase().trim().contains(TCari.getText().toLowerCase().trim())) {
                Panelmenu.add(btnKeterlambatanPresensi);
                jmlmenu++;
            }
        }
    }
    
    private void notifAlarmLain() {
        try {
            music = new BackgroundMusic("./suara/paman_pentol.mp3");
            music.start();
            Thread.sleep(700);            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    private void notifAlarmIGD() {
        try {
            music = new BackgroundMusic("./suara/resep_IGD.mp3");
            music.start();
            Thread.sleep(700);            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    private void notifAlarmResepRanap() {
        try {
            music = new BackgroundMusic("./suara/resep_rawat_inap.mp3");
            music.start();
            Thread.sleep(700);            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    private void notifAlarmResepRanapCito() {
        try {
            music = new BackgroundMusic("./suara/resep_cito_rawat_inap.mp3");
            music.start();
            Thread.sleep(700);            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    private void notifAlarmLab() {
        try {
            music = new BackgroundMusic("./suara/permintaan_periksa_laboratorium_diterima.mp3");
            music.start();
            Thread.sleep(700);            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    private void notifAlarmRad() {
        try {
            music = new BackgroundMusic("./suara/permintaan_periksa_radiologi_diterima.mp3");
            music.start();
            Thread.sleep(700);            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    private void otomatisRefreshNotifApt() {
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (akses.getNotifApotek().equals("yes")) {
                    //jika apotek sentral ranap
                    if (akses.getkdbangsal().equals("APT02")) {
                        if (Sequel.cariInteger("select count(-1) from catatan_resep_ranap where status='belum' and jenis_resep='CITO' and "
                                + "tgl_perawatan between DATE_SUB(DATE_FORMAT(NOW(),'%Y-%m-%d'), INTERVAL 1 DAY) and DATE_FORMAT(NOW(),'%Y-%m-%d')") > 0) {
                            notifAlarmResepRanapCito();
                        } else if (Sequel.cariInteger("select count(-1) from catatan_resep_ranap where status='belum' and "
                                + "tgl_perawatan between DATE_SUB(DATE_FORMAT(NOW(),'%Y-%m-%d'), INTERVAL 1 DAY) and DATE_FORMAT(NOW(),'%Y-%m-%d')") > 0) {
                            notifAlarmResepRanap();
                        }

                    //jika apotek igd
                    } else if (akses.getkdbangsal().equals("APT01")) {
                        if (Sequel.cariInteger("select count(-1) from catatan_resep c inner join reg_periksa r on r.no_rawat=c.no_rawat where "
                                + "r.status_lanjut='Ralan' and c.status='belum' and r.kd_poli='igdk' and "
                                + "c.tgl_perawatan between DATE_SUB(DATE_FORMAT(NOW(),'%Y-%m-%d'), INTERVAL 1 DAY) and DATE_FORMAT(NOW(),'%Y-%m-%d')") > 0) {
                            notifAlarmIGD();
                        } 
                        
                        if (Sequel.cariInteger("select count(-1) from catatan_resep_ranap where status='belum' and jenis_resep='CITO' and "
                                + "tgl_perawatan between DATE_SUB(DATE_FORMAT(NOW(),'%Y-%m-%d'), INTERVAL 1 DAY) and DATE_FORMAT(NOW(),'%Y-%m-%d')") > 0) {
                            notifAlarmResepRanapCito();
                        } else if (Sequel.cariInteger("select count(-1) from catatan_resep_ranap where status='belum' and "
                                + "tgl_perawatan between DATE_SUB(DATE_FORMAT(NOW(),'%Y-%m-%d'), INTERVAL 1 DAY) and DATE_FORMAT(NOW(),'%Y-%m-%d')") > 0) {
                            notifAlarmResepRanap();
                        }
                    }
                }
            }
        };
        // Timer
        //interval 1000 ms = 1 detik
        //interval 30000 ms = 30 detik atau setngah menit
        //interval 600000 ms = 10 menit atau setngah menit
        akses.tRefreshNotifApotek = new Timer(600000, taskPerformer);
    }
    
    private void otomatisRefreshNotifLab() {
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (akses.getNotifLab().equals("yes")) {
                    if (Sequel.cariInteger("SELECT count(-1) FROM permintaan_lab_raza where status_rawat='Ralan' and status_periksa='belum' and "
                            + "tgl_permintaan between DATE_SUB(DATE_FORMAT(NOW(),'%Y-%m-%d'), INTERVAL 1 DAY) and DATE_FORMAT(NOW(),'%Y-%m-%d')") > 0
                            || Sequel.cariInteger("SELECT count(-1) FROM permintaan_lab_raza where status_rawat='Ranap' and status_periksa='belum' and "
                                    + "tgl_permintaan between DATE_SUB(DATE_FORMAT(NOW(),'%Y-%m-%d'), INTERVAL 1 DAY) and DATE_FORMAT(NOW(),'%Y-%m-%d')") > 0) {
                        notifAlarmLab();
                    } 
                }
            }
        };
        // Timer
        //interval 1000 ms = 1 detik
        //interval 30000 ms = 30 detik atau setngah menit
        //interval 300000 ms = 5 menit atau setngah menit
        akses.tRefreshNotifLab = new Timer(300000, taskPerformer);
    }
    
    private void otomatisRefreshNotifRad() {
        ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (akses.getNotifRad().equals("yes")) {
                    if (Sequel.cariInteger("SELECT count(-1) FROM permintaan_radiologi where status='Belum' and "
                            + "tgl_permintaan between DATE_SUB(DATE_FORMAT(NOW(),'%Y-%m-%d'), INTERVAL 1 DAY) and DATE_FORMAT(NOW(),'%Y-%m-%d')") > 0) {
                        notifAlarmRad();
                    }
                }
            }
        };
        // Timer
        //interval 1000 ms = 1 detik
        //interval 30000 ms = 30 detik atau setngah menit
        //interval 300000 ms = 5 menit atau setngah menit
        akses.tRefreshNotifRad = new Timer(300000, taskPerformer);
    }
    
    private void cekNotifApotek() {
        cek = "";
        try {
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            cek = prop.getProperty("NOTIFAPOTEK").toString();
        } catch (Exception e) {
            System.out.println("Notifikasi : " + e);
        }        
        akses.setNotifApotek(cek);
    }
    
    private void cekNotifLab() {
        cek = "";
        try {
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            cek = prop.getProperty("NOTIFLABORATORIUM").toString();
        } catch (Exception e) {
            System.out.println("Notifikasi : " + e);
        }        
        akses.setNotifLab(cek);
    }
    
    private void cekNotifRad() {
        cek = "";
        try {
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            cek = prop.getProperty("NOTIFRADIOLOGI").toString();
        } catch (Exception e) {
            System.out.println("Notifikasi : " + e);
        }        
        akses.setNotifRad(cek);
    }

    private void cekApotek() {
        cekApt = "";
        try {
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            cekApt = prop.getProperty("APOTEK").toString();

        } catch (Exception e) {
            System.out.println("Notifikasi : " + e);
        }
        akses.setkdbangsal(cekApt);
    }

}
