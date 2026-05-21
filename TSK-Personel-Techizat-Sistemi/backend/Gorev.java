import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Gorev {
    private String gorevId;
    private String personelSicilNo;
    private String kurumId;
    private String baslangicTarihi;
    private String gorevTanimi;

    public Gorev(String gorevId, String personelSicilNo, String kurumId, String gorevTanimi) {
        this.gorevId = gorevId;
        this.personelSicilNo = personelSicilNo;
        this.kurumId = kurumId;
        this.gorevTanimi = gorevTanimi;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        this.baslangicTarihi = dtf.format(LocalDateTime.now());
    }

    // Polimorfizm sağlayacak olan soyut metodumuz
    public abstract String getGorevTipi();

    // Getter Metotları
    public String getGorevId() { return gorevId; }
    public String getPersonelSicilNo() { return personelSicilNo; }
    public String getKurumId() { return kurumId; }
    public String getBaslangicTarihi() { return baslangicTarihi; }
    public String getGorevTanimi() { return gorevTanimi; }

    @Override
    public String toString() {
        return "[" + getGorevTipi() + "] ID: " + gorevId + " | Personel: " + personelSicilNo +
                " | Kurum: " + kurumId + " | Tarih: " + baslangicTarihi;
    }
}