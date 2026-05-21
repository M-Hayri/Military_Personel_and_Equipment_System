import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class PersonelKimlik {
    // Değişmez (Immutable) Kimlik Bilgileri
    private final String tc;
    private final String sicilno;
    private final Date dogumTarihi;
    private final CinsiyetTur cinsiyet;
    private final KanGrubu kanGrubu;

    // Değişebilir Bilgiler
    private String ad;
    private String soyad;
    private MedeniDurum medeniDurum;

    private Personel detay;
    private PersonelDurumu durum;
    private Kurum atandigiKurum;

    protected IOdemeSistemi odemeSistemi;

    // Full Constructor
    public PersonelKimlik(String tc, String sicilno, String ad, String soyad,
                          MedeniDurum medenidurum, Date dogumtarihi, CinsiyetTur cinsiyet,
                          KanGrubu kanGrubu, Personel detay, IOdemeSistemi odemeSistemi) {
        this.tc = tc;
        this.sicilno = sicilno;
        this.ad = ad;
        this.soyad = soyad;
        this.medeniDurum = medenidurum;
        this.dogumTarihi = dogumtarihi;
        this.cinsiyet = cinsiyet;
        this.kanGrubu = kanGrubu;
        this.detay = detay;
        this.durum = PersonelDurumu.AKTIF_GOREVDE;
        this.odemeSistemi = odemeSistemi;
    }

    // 1. GÜNCELLENEN MAAŞ ALMA METODU ---------------VERİTABANINA BAĞLAMA YAPILACAK------------------
    public void maasAl() {
        if (this.odemeSistemi != null) {
            // Ödeme sistemini tetikle ve sonucu (true/false) al
            boolean islemBasarili = this.odemeSistemi.maasYatir(this);

            // Sonucu loglama metoduna gönder
            sistemeLogKaydet("Maaş Ödemesi", islemBasarili);

        } else {
            System.err.println("SİSTEM HATASI: " + this.getTamAd() + " için bir ödeme sistemi tanımlanmamış!");
            sistemeLogKaydet("Maaş Ödemesi - Sistem Hatası", false);
        }
    }

    // 2. LOGLAMA METODU ---------------VERİTABANINA BAĞLAMA YAPILACAK------------------
    private void sistemeLogKaydet(String islemTipi, boolean durum) {
        // O anki tarihi ve saati alıyoruz
        LocalDateTime simdi = LocalDateTime.now();
        // TSK standartlarına uygun bir tarih formatı oluşturuyoruz
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String zaman = simdi.format(format);

        // İşlem durumuna göre eklenecek mesajı belirliyoruz
        String durumMesaji = durum ? "[BAŞARILI]" : "[İPTAL/BAŞARISIZ]";

        // Log çıktısını konsola yazdırıyoruz
        System.out.println(">>> SİSTEM LOG [" + zaman + "] | TC: " + this.getTc() +
                " | Personel: " + this.getTamAd() +
                " | İşlem: " + islemTipi +
                " | Sonuç: " + durumMesaji);

    }

    public abstract void gorevTaniminiYazdir();

    public String getTc() { return tc; }
    public String getSicilno() { return sicilno; }
    public Date getDogumTarihi() { return dogumTarihi; }
    public CinsiyetTur getCinsiyet() { return cinsiyet; }
    public KanGrubu getKanGrubu() { return kanGrubu; } // Enum döndürüyor

    public String getAd() { return ad; }
    public void setAd(String ad) { this.ad = ad; }

    public String getSoyad() { return soyad; }
    public void setSoyad(String soyad) { this.soyad = soyad; }

    public String getTamAd() {return (this.ad + ' ' + this.soyad);}

    public MedeniDurum getMedeniDurum() { return medeniDurum; }
    public void setMedeniDurum(MedeniDurum medeniDurum) { this.medeniDurum = medeniDurum; }

    public Personel getDetay() { return detay; }
    public void setDetay(Personel detay) { this.detay = detay; }

    public PersonelDurumu getDurum() { return durum; }
    public void setDurum(PersonelDurumu durum) { this.durum = durum; }

    public Kurum getAtandigiKurum() { return this.atandigiKurum; }
    public void setAtandigiKurum(Kurum atandigiKurum) { this.atandigiKurum = atandigiKurum; }
}