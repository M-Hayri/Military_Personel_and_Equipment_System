public class AltKurum {
    private String birlikAdi;
    private PersonelObserver ustMakam; // Observer'ımızı (Merkez Komutanlığı) burada tutuyoruz

    public AltKurum(String birlikAdi, PersonelObserver ustMakam) {
        this.birlikAdi = birlikAdi;
        this.ustMakam = ustMakam;
    }

    // Alt kurumda bir suç işlendiğinde üst makama fırlatılan olay
    public void sucRaporla(PersonelKimlik personel, CezaTipi ceza, String detay) {
        System.out.println("\n[YEREL BİRLİK - " + birlikAdi + "]: " + personel.getTamAd() + " hakkında tutanak tutuldu. Üst makama bildiriliyor...");
        ustMakam.sucKaydiIsle(personel.getTc(), ceza, detay);
    }

    // Şehitlik veya benzeri durum değişikliklerini fırlatan olay
    public void durumRaporla(PersonelKimlik personel, PersonelDurumu yeniDurum) {
        System.out.println("\n[YEREL BİRLİK - " + birlikAdi + "]: Personel durum değişikliği üst makama bildiriliyor...");
        ustMakam.durumGuncelle(personel.getTc(), yeniDurum);
    }
}