import java.time.LocalDate;

public interface AracObserver {
    // 1. Personele zimmetle
    void personeleZimmetle(String aracID, String personelID, LocalDate tarih);

    // 2. KurumBilgileriniGuncelle
    void kurumGuncelle(String aracID, String kurumID, LocalDate tarih);
}
