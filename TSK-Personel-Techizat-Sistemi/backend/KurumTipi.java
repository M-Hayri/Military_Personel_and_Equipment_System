public enum KurumTipi {
    GENELKURMAY("Genelkurmay Başkanlığı"),
    KUVVET_KOMUTANLIGI("Kuvvet Komutanlığı"),
    KARARGAH("Karargah"),
    KITA_BIRLIGI("Kıta / Birlik"),
    TUGAY("Tugay Komutanlığı"),
    TUMEN("Tümen Komutanlığı"),
    KOLORDU("Kolordu Komutanlığı"),
    ANA_JET_USSU("Ana Jet Üssü Komutanlığı"),
    TERSANE("Askeri Tersane Komutanlığı"),
    EGITIM_MERKEZI("Eğitim Merkezi ve Okul"),
    ASAL("Askerlik Şubesi Başkanlığı"),
    HASTANE("Askeri Hastane"),
    SOSYAL_TESIS("Orduevi ve Sosyal Tesisler");

    // Enum'ın ekranda düzgün görünmesini sağlayacak özel açıklama alanı
    private final String aciklama;

    // Enum Constructor'ı
    KurumTipi(String aciklama) {
        this.aciklama = aciklama;
    }

    // Açıklamayı okumak için Getter metodu
    public String getAciklama() {
        return aciklama;
    }

    // toString metodunu ezerek doğrudan temiz metni döndürmesini sağlıyoruz
    @Override
    public String toString() {
        return this.aciklama;
    }
}