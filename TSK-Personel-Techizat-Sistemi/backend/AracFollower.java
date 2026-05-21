import java.time.LocalDate;

public class AracFollower implements AracObserver {
    private final String takipçiBirimAdi; // Örn: "Lojistik Takip Merkezi" veya Personel İsmi

    public AracFollower(String takipçiBirimAdi) {
        this.takipçiBirimAdi = takipçiBirimAdi;
    }

    @Override
    public void personeleZimmetle(String aracID, String personelID, LocalDate tarih) {
        System.out.println("[" + takipçiBirimAdi + " BİLDİRİMİ]: " +
                aracID + " id'li araç, " + tarih + " tarihinde " +
                personelID + " id'li personele zimmetlenmiştir!");
    }

    @Override
    public void kurumGuncelle(String aracID, String kurumID, LocalDate tarih) {
        System.out.println("[" + takipçiBirimAdi + " BİLDİRİMİ]: " +
                aracID + " id'li aracın bağlı olduğu kurum " +
                kurumID + " olarak güncellendi. İşlem Tarihi: " + tarih);
    }

}