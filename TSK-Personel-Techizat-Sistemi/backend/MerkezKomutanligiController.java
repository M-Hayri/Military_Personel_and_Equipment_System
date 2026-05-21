import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MerkezKomutanligiController {
    @FXML private ImageView logoResmi;
    @FXML private TextField aramaKutusu;
    @FXML private TableView<Kurum> kurumTablosu;
    @FXML private TableColumn<Kurum, String> colAd;
    @FXML private TableColumn<Kurum, String> colSehir;
    @FXML private TableColumn<Kurum, String> colLokasyon;
    @FXML private Button btnDetayGor;

    private ObservableList<Kurum> masterData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        Image logo = new Image(getClass().getResourceAsStream("imgs/logoResmi.png"));
        logoResmi.setImage(logo);

        // Prototype Registry'den verileri alalım
        KurumTest registry = new KurumTest();
        masterData.add(registry.getKurumKopyasi("HAVA_USSU"));
        masterData.add(registry.getKurumKopyasi("KARA_TUGAYI"));

        // Sütunların Kurum modelindeki değişkenlerle eşleştirilmesi
        colAd.setCellValueFactory(new PropertyValueFactory<>("kurumAdi"));
        colSehir.setCellValueFactory(new PropertyValueFactory<>("il"));
        colLokasyon.setCellValueFactory(new PropertyValueFactory<>("lokasyon"));

        // Canlı Arama (Filtering) Mantığı
        FilteredList<Kurum> filteredData = new FilteredList<>(masterData, p -> true);

        aramaKutusu.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(kurum -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (kurum.getKurumAdi().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (kurum.getIl().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                return false;
            });
        });

        SortedList<Kurum> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(kurumTablosu.comparatorProperty());
        kurumTablosu.setItems(sortedData);

// 2. Tablo Satırlarına Çift Tıklama Özelliği Ekleme
        kurumTablosu.setRowFactory(tv -> {
            TableRow<Kurum> satir = new TableRow<>();
            satir.setOnMouseClicked(event -> {
                // Eğer çift tıklanmışsa ve satır boş değilse
                if (event.getClickCount() == 2 && (!satir.isEmpty())) {
                    Kurum seciliKurum = satir.getItem();
                    kurumDetayinaGit(seciliKurum);
                }
            });
            return satir;
        });
    }

    // Detay sayfasına geçişi yöneten merkezi metot
    private void kurumDetayinaGit(Kurum kurum) {
        try {
            // 1. Detay sayfasının FXML dosyasını yüklüyoruz
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/KurumDetayPaneli.fxml"));
            Parent detayRoot = loader.load();

            // 2. Tablo üzerinden mevcut sahneyi (Scene) yakalıyoruz
            Scene mevcutSahne = kurumTablosu.getScene();

            // 3. Geri dön butonu tıklandığında bu listeyi kaybetmemek için
            // ana panelin o anki görsel ağacını (Root) hafızaya alıyoruz
            Parent anaPanelRoot = mevcutSahne.getRoot();

            // 4. Detay sayfasının Controller sınıfına bağlanıyoruz
            KurumDetayController detayController = loader.getController();

            // Verileri ve geri dönüş için sakladığımız anaPanelRoot'u gönderiyoruz
            detayController.verileriYukle(kurum, anaPanelRoot);

            // 5. EN KRİTİK ADIM: Yeni sahne (Scene) oluşturup pencereyi sarsmıyoruz!
            // Mevcut sahnenin sadece içindeki resmi (Root) değiştiriyoruz.
            mevcutSahne.setRoot(detayRoot);

            System.out.println("SİSTEM LOG: " + kurum.getKurumAdi() + " detay sayfasına tam ekran modunu koruyarak geçiş yapıldı.");

        } catch (Exception e) {
            System.err.println("SİSTEM HATASI: Kurum detay sayfası FXML dosyası yüklenirken bir sorun oluştu!");
            System.err.println("Lütfen '/KurumDetayPaneli.fxml' dosyasının resources klasöründe olduğundan emin ol.");
            e.printStackTrace();
        }
    }
}