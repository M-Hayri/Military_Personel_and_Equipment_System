import java.time.LocalDate;
import java.util.ArrayList; // 1. BU İTHALATI EKLEDİK
import java.util.List;      // 2. BU İTHALATI EKLEDİK

public class Arac {
    private String techizatID, marka, model, seriNo, bulunduguKurum;
    private LocalDate uretimTarihi;
    private techizatDurum durum;
    private motorTipi motorTipi;
    private yakitTuru yakitTuru;
    private boolean silahSistemiVarMi;
    private int maxPersonelSayisi;
    private int faydaliYukKapasitesi;
    private static String zimmetliPersonelID;

    // 3. KRİTİK EKSİK: Takipçileri hafızada tutacak listeyi tanımladık
    private final List<AracObserver> observers = new ArrayList<>();

    // 4. KRİTİK EKSİK: Dışarıdan takipçi ekleyip çıkarmak için kancalar (Metotlar)
    public void observerEkle(AracObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    public void observerCikar(AracObserver observer) {
        observers.remove(observer);
    }

    public Arac(String techizatID, String marka, String model, String seriNo, LocalDate uretimTarihi,
                techizatDurum durum, motorTipi motorTipi, yakitTuru yakitTuru, boolean silahSistemiVarMi,
                int maxPersonelSayisi, int faydaliYukKapasitesi, String zimmetliPersonelID) {
        this.techizatID = techizatID;
        this.marka = marka;
        this.model = model;
        this.seriNo = seriNo;
        this.uretimTarihi = uretimTarihi;
        this.durum = techizatDurum.BOSTA;
        this.motorTipi = motorTipi;
        this.yakitTuru = yakitTuru;
        this.silahSistemiVarMi = silahSistemiVarMi;
        this.maxPersonelSayisi = maxPersonelSayisi;
        this.faydaliYukKapasitesi = faydaliYukKapasitesi;
        this.zimmetliPersonelID = zimmetliPersonelID;
    }

    public int getFaydaliYukKapasitesi() {
        return faydaliYukKapasitesi;
    }
    public int getMaxPersonelSayisi() {
        return maxPersonelSayisi;
    }
    public boolean isSilahSistemiVarMi() {
        return silahSistemiVarMi;
    }
    public yakitTuru getYakitTuru() {
        return yakitTuru;
    }
    public motorTipi getMotorTipi() {
        return motorTipi;
    }
    public techizatDurum getDurum() {
        return durum;
    }
    public LocalDate getUretimTarihi() {
        return uretimTarihi;
    }
    public String getBulunduguKurum() {
        return bulunduguKurum;
    }
    public String getSeriNo() {
        return seriNo;
    }
    public String getModel() {
        return model;
    }
    public String getMarka() {
        return marka;
    }
    public String getTechizatID() {
        return techizatID;
    }
    public String getZimmetliPersonelID() {
        return zimmetliPersonelID;
    }

    public void setTechizatID(String techizatID) {
        this.techizatID = techizatID;
    }
    public void setMarka(String marka) {
        this.marka = marka;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setSeriNo(String seriNo) {
        this.seriNo = seriNo;
    }
    public void setBulunduguKurum(String bulunduguKurum) {
        this.bulunduguKurum = bulunduguKurum; }
    public void setUretimTarihi(LocalDate uretimTarihi) { this.uretimTarihi = uretimTarihi;
    }
    public void setDurum(techizatDurum durum) {
        this.durum = durum;
    }
    public void setMotorTipi(motorTipi motorTipi) {
        this.motorTipi = motorTipi;
    }
    public void setYakitTuru(yakitTuru yakitTuru) {
        this.yakitTuru = yakitTuru;
    }
    public void setSilahSistemiVarMi(boolean silahSistemiVarMi) {
        this.silahSistemiVarMi = silahSistemiVarMi;
    }
    public void setMaxPersonelSayisi(int maxPersonelSayisi) {
        this.maxPersonelSayisi = maxPersonelSayisi;
    }
    public void setFaydaliYukKapasitesi(int faydaliYukKapasitesi) {
        this.faydaliYukKapasitesi = faydaliYukKapasitesi;
    }
    public void setZimmetliPersonelID(String zimmetliPersonelID) {
        this.zimmetliPersonelID = zimmetliPersonelID;
    }

    // 5. DÜZELTİLEN ZİMMETLE METODU
    public void personeleZimmetle(String personelID) {
        LocalDate bugun = LocalDate.now();

        this.zimmetliPersonelID = personelID;
        this.durum = techizatDurum.AKTIF;

        for (AracObserver obs : observers) {
            obs.personeleZimmetle(this.getTechizatID(), personelID, bugun);
        }
    }

    // 6. DÜZELTİLEN KURUM DEGISTIR METODU
    public void kurumuDegistir(String yeniKurum) {
        LocalDate bugun = LocalDate.now();
        this.bulunduguKurum = yeniKurum;
        this.durum = techizatDurum.BOSTA;

        // KURAL: Yeni kuruma atanınca eski kurumdaki personeldeki zimmet ortadan kalkar!
        if (this.zimmetliPersonelID != null) {
            System.out.println("[SİSTEM UYARISI]: Araç kurum değiştirdiği için " + this.zimmetliPersonelID + " üzerindeki eski zimmet düşürülüyor.");
            this.zimmetliPersonelID = null; // Zimmet boşa çıktı
            this.durum = techizatDurum.BOSTA; // Araç yeni kuruma ulaştı ama henüz kimseye zimmetlenmedi
        }

        for (AracObserver obs : observers) {
            obs.kurumGuncelle(this.getTechizatID(), yeniKurum, bugun);
        }
    }

    public static class AracConcreteBuilder implements AracBuilder {
        private String techizatID, marka, model, seriNo, bulunduguKurum;
        private LocalDate uretimTarihi = LocalDate.now();
        private techizatDurum durum;
        private motorTipi motorTipi;
        private yakitTuru yakitTuru;
        private boolean silahSistemiVarMi;
        private int maxPersonelSayisi;
        private int faydaliYukKapasitesi;

        @Override
        public AracBuilder buildTemelBilgiler(String id, String marka, String model, String seriNo) {
            this.techizatID = id;
            this.marka = marka;
            this.model = model;
            this.seriNo = seriNo;
            return this;
        }

        @Override
        public AracBuilder buildMotorVeYakit(motorTipi motor, yakitTuru yakit) {
            this.motorTipi = motor;
            this.yakitTuru = yakit;
            return this;
        }

        @Override
        public AracBuilder buildKapasite(int personel, int yukKapasitesi) {
            this.maxPersonelSayisi = personel;
            this.faydaliYukKapasitesi = yukKapasitesi;
            return this;
        }

        @Override
        public AracBuilder buildAskeriSistemler(boolean silahVarMi, techizatDurum durum, String kurum) {
            this.silahSistemiVarMi = silahVarMi;
            this.durum = durum;
            this.bulunduguKurum = kurum;
            return this;
        }

        @Override
        public Arac build() {
            // Artık yukarıda constructor tanımlı olduğu için bu satır hata vermez!
            Arac yeniArac = new Arac(
                    techizatID, marka, model, seriNo, uretimTarihi,
                    durum, motorTipi, yakitTuru, silahSistemiVarMi,
                    maxPersonelSayisi, faydaliYukKapasitesi, zimmetliPersonelID
            );
            yeniArac.setBulunduguKurum(this.bulunduguKurum);
            return yeniArac;
        }

    }
}