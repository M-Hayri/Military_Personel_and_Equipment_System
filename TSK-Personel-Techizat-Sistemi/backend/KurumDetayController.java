import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class KurumDetayController {

    @FXML private Label lblKurumAdi;
    @FXML private Label lblKurumTipi;
    @FXML private TextField txtMail;
    @FXML private TextField txtTel;
    @FXML private TextField txtIl;
    @FXML private TextField txtAdres;

    @FXML private Button btnDuzenle;
    @FXML private Button ButtonKaydet;
    @FXML private Button btnKaydet;
    @FXML private Button btnGeri;

    private Kurum aktifKurum;
    private Parent anaPanelRoot;

    @FXML
    public void initialize() {
        PersonelActionFacade.getInstance().gozlemciEkle(new TskMerkezKomutanligi());
    }

    public void verileriYukle(Kurum seciliKurum, Parent anaPanelRoot) {
        this.aktifKurum = seciliKurum;
        this.anaPanelRoot = anaPanelRoot;

        // Ekrana verileri basıyoruz
        lblKurumAdi.setText(aktifKurum.getKurumAdi());
        lblKurumTipi.setText(aktifKurum.getKurumTipi().toString());

        txtMail.setText(aktifKurum.getKurumMail() != null ? aktifKurum.getKurumMail() : "Belirtilmemiş");
        txtTel.setText(aktifKurum.getKurumTel() != null ? aktifKurum.getKurumTel() : "Belirtilmemiş");
        txtIl.setText(aktifKurum.getIl());
        txtAdres.setText(aktifKurum.getLokasyon());
    }

    // "Düzenle" butonuna tıklandığında çalışır
    @FXML
    public void duzenlemeModunuAc() {
        System.out.println("Düzenleme modu aktif edildi.");

        // Kutucukları yazılabilir hale getir
        kutulariDuzenlenebilirYap(txtMail, true);
        kutulariDuzenlenebilirYap(txtTel, true);
        kutulariDuzenlenebilirYap(txtIl, true);
        kutulariDuzenlenebilirYap(txtAdres, true);

        // Kaydet butonunu görünür yap, Düzenle butonunu gizle
        btnKaydet.setVisible(true);
        btnDuzenle.setVisible(false);
    }

    @FXML
    public void bilgileriKaydet() {
        System.out.println("Yeni bilgiler kaydediliyor...");

        aktifKurum.setKurumMail(txtMail.getText());
        aktifKurum.setKurumTel(txtTel.getText());
        aktifKurum.setIl(txtIl.getText());
        aktifKurum.setLokasyon(txtAdres.getText());

        kutulariDuzenlenebilirYap(txtMail, false);
        kutulariDuzenlenebilirYap(txtTel, false);
        kutulariDuzenlenebilirYap(txtIl, false);
        kutulariDuzenlenebilirYap(txtAdres, false);

        btnKaydet.setVisible(false);
        btnDuzenle.setVisible(true);

        System.out.println("Kayıt Başarılı! Yeni Şehir: " + aktifKurum.getIl());
    }

    @FXML
    public void listeyeGeriDon() {
        Scene mevcutSahne = btnGeri.getScene();
        mevcutSahne.setRoot(anaPanelRoot);
    }

    private void kutulariDuzenlenebilirYap(TextField txt, boolean durum) {
        txt.setEditable(durum);
        if (durum) {
            txt.setStyle("-fx-background-color: white; -fx-border-color: #3498db; -fx-border-radius: 3; -fx-font-size: 14px;");
        } else {
            txt.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-font-size: 14px;");
        }
    }
}