public enum CezaTipi {

    // --- DİSİPLİN CEZALARI (Hafif ve Orta Dereceli Sicile İşlenenler) ---
    UYARMA("Uyarma Cezası", 1),
    KINAMA("Kınama Cezası", 2),
    HIZMETE_KISMI_SURELI_DEVAM("Hizmete Kısmi Süreli Devam", 3),
    AYLIKTAN_KESME("Aylıktan Kesme Cezası", 4),
    HIZMET_YERINI_TERK_ETMEME("Hizmet Yerini Terk Etmeme Cezası", 5), // Eski adıyla Oda Hapsi

    // --- ASKERİ SUÇLAR (Ağır Dereceli Sicile İşlenenler) ---
    IZIN_TECAVUZU("İzin Tecavüzü / Bakaya", 6),
    GOREVI_IHMAL("Görevi İhmal ve Kötüye Kullanma", 7),
    ASKERI_ESYAYA_ZARAR_VERME("Askeri Eşyayı Kasten Tahrip Etmek", 7),
    USTE_HAKARET_VE_ITAATSIZLIK("Amire veya Üste Hakaret ve İtaatsizlik", 8),
    EMRE_ITAATSIZLIKTE_ISRAR("Emre İtaatsizlikte Israr", 9),
    FIRAR("Firar", 10),
    VATANA_IHANET_CASUSLUK("Vatana İhanet ve Askeri Casusluk", 10),
    SILAHLI_KUVVETLERDEN_IHRAC("Silahlı Kuvvetlerden Ayırma / İhraç", 10);

    private final String aciklama;
    private final int cezaPuani; // Cezanın ağırlığını belirleyen kritik değişken

    // Enum Constructor
    CezaTipi(String aciklama, int cezaPuani) {
        this.aciklama = aciklama;
        this.cezaPuani = cezaPuani;
    }

    // Getter Metotları
    public String getAciklama() {
        return aciklama;
    }

    public int getCezaPuani() {
        return cezaPuani;
    }

    // Konsolda veya arayüzde temiz bir metin göstermek için
    @Override
    public String toString() {
        return aciklama + " (Ceza Ağırlığı: " + cezaPuani + ")";
    }
}