import java.util.Date;

public class KurumAtama {
    private String kurumAdi;
    private Date baslangicTarihi;
    private Date bitisTarihi;

    private boolean aktifGorevmi;

    public KurumAtama(String kurumAdi, Date baslangicTarihi, Date bitisTarihi) {
        this.kurumAdi = kurumAdi;
        this.baslangicTarihi = baslangicTarihi;
        this.bitisTarihi = bitisTarihi;

        // Bitiş tarihi yoksa aktif görevdedir
        this.aktifGorevmi = (bitisTarihi == null);
    }

    // Getter ve Setter Metotları
    public String getKurumAdi() { return kurumAdi; }
    public Date getBaslangicTarihi() { return baslangicTarihi; }
    public Date getBitisTarihi() { return bitisTarihi; }
    public boolean isAktifGorevmi() { return aktifGorevmi; }

    // Atamayı sonlandıran (Tayin çıkan) metot
    public void atamayiSonlandir(Date bitis) {
        this.bitisTarihi = bitis;
        this.aktifGorevmi = false;
    }
}