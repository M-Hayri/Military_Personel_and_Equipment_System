public interface PersonelObserver {

    // 1. Durum Değişiklikleri
    void durumGuncelle(String personelId, PersonelDurumu yeniDurum);

    // 2. Disiplin ve Suç İşlemleri
    void sucKaydiIsle(String personelId, CezaTipi suc, String detay);

    // 3. Tayin / Atama İşlemleri
    void tayinGuncelle(String personelId, Kurum yeniKurum);
}