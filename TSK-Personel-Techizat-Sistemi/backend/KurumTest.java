import java.util.HashMap;
import java.util.Map;

public class KurumTest {
    private Map<String, Kurum> prototipler = new HashMap<>();
    KurumTest() {
        prototipleriYukle();
    }
    private void prototipleriYukle() {
        // 1. Şablon: Standart Hava Üssü
        Kurum havaUssu = new Kurum(
                "TMP-HV-00", "Standart Ana Jet Üssü", KurumTipi.ANA_JET_USSU,
                "iletisim@hvKK.tsk.tr", "03120000000", "Bilinmiyor",
                "Ankara", "Merkez", "Ana Cadde", "06000",
                500, "BOS_BAS_ID"
        );
        prototipler.put("HAVA_USSU", havaUssu);

        // 2. Şablon: Standart Kara Tugayı
        Kurum karaTugayi = new Kurum(
                "TMP-KR-00", "Standart Zırhlı Tugay", KurumTipi.TUGAY,
                "iletisim@krKK.tsk.tr", "03121111111", "Bilinmiyor",
                "Kayseri", "Merkez", "Ordu Cad.", "38000",
                1500, "BOS_BAS_ID"
        );
        prototipler.put("KARA_TUGAYI", karaTugayi);
    }

    public Kurum getKurumKopyasi(String sablonTipi) {
        Kurum sablon = prototipler.get(sablonTipi);
        if (sablon != null) {
            return sablon.clone(); // klonlama yap
        }
        return null;
    }
}
