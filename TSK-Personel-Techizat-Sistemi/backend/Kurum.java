public class Kurum implements Cloneable{
    private String kurumId;
    private String kurumAdi;
    private KurumTipi kurumTipi;
    private String kurumMail;
    private String kurumTel;
    private String lokasyon;
    private String il;
    private String ilce;
    private String sokakCadde;
    private String postaKodu;
    private int aktifPersonelSayisi;
    private String kurumBasID;

    public Kurum(String kurumId, String kurumAdi, KurumTipi kurumTipi, String kurumMail,
                 String kurumTel, String lokasyon, String il, String ilce, String sokakCadde, String postaKodu,
                 int aktifPersonelSayisi, String kurumBasID){
        this.kurumId = kurumId;
        this.kurumAdi = kurumAdi;
        this.kurumTipi = kurumTipi;
        this.kurumMail = kurumMail;
        this.kurumTel = kurumTel;
        this.lokasyon = lokasyon;
        this.il = il;
        this.ilce = ilce;
        this.sokakCadde = sokakCadde;
        this.postaKodu = postaKodu;
        this.aktifPersonelSayisi = aktifPersonelSayisi;
        this.kurumBasID = kurumBasID;
    }

    @Override
    public Kurum clone() {
        try {
            // String, int ve Enum kullandığımız için super.clone() bizim için yeterli ve güvenlidir.
            return (Kurum) super.clone();
        } catch (CloneNotSupportedException e) {
            System.err.println("Klonlama Hatası: " + e.getMessage());
            return null;
        }
    }

    // Kuruma yeni personel atandığında veya çıkarıldığında sayıyı güvenli şekilde yönetmek için
    public void personelEkle() {
        this.aktifPersonelSayisi++;
    }

    public void personelCikar() {
        if (this.aktifPersonelSayisi > 0) {
            this.aktifPersonelSayisi--;
        }
    }

    // Adres verilerini tek bir bütün olarak çekmek için (Raporlama veya DB kayıt kolaylığı)
    public String getTamAdres() {
        return sokakCadde + " " + ilce + " / " + il + " - PK: " + postaKodu;
    }

    // Getter ve Setter
    public String getKurumId() { return kurumId; }
    public void setKurumId(String kurumId) { this.kurumId = kurumId; }

    public String getKurumAdi() { return kurumAdi; }
    public void setKurumAdi(String kurumAdi) { this.kurumAdi = kurumAdi; }

    public KurumTipi getKurumTipi() { return kurumTipi; }
    public void setKurumTipi(KurumTipi kurumTipi) { this.kurumTipi = kurumTipi; }

    public String getKurumBasID() { return kurumBasID; }
    public void setKurumBasID(String kurumBasID) { this.kurumBasID = kurumBasID; }

    public int getAktifPersonelSayisi() { return aktifPersonelSayisi; }

    public String getIl() { return this.il; }
    public void setIl(String il) { this.il = il;}

    public String getIlce() { return this.ilce; }
    public void setIlce(String ilce) { this.ilce = ilce;}

    public String getSokakCadde() { return sokakCadde; }
    public void setSokakCadde(String sokakCadde) { this.sokakCadde = sokakCadde; }

    public String getKurumMail() { return kurumMail; }
    public void setKurumMail(String kurumMail) { this.kurumMail = kurumMail; }

    public String getKurumTel() { return kurumTel; }
    public void setKurumTel(String kurumTel) { this.kurumTel = kurumTel; }

    public String getLokasyon() { return lokasyon; }
    public void setLokasyon(String lokasyon) { this.lokasyon = lokasyon; }

    // Raporlama ve bilgi yazdımra
    @Override
    public String toString() {
        return "Kurum [" + kurumId + "] - " + kurumAdi +
                " | Tipi: " + kurumTipi +
                " | Personel: " + aktifPersonelSayisi +
                " | Adres: " + ilce + "/" + il;
    }
}
