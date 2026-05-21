public enum MedeniDurum {
    EVLI("evli"),
    BEKAR("bekar"),
    BOSANMIS("bosanmis");

    private final String deger;

    MedeniDurum(String deger) {
        this.deger = deger;
    }

    public String getDeger() {
        return deger;
    }

    public static MedeniDurum fromString(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("HATA: Medeni durum verisi boş olamaz!");
        }

        for (MedeniDurum m : MedeniDurum.values()) {
            // trim() ile kazara girilmiş boşlukları (" bekar ") temizliyoruz
            if (m.deger.equalsIgnoreCase(text.trim())) {
                return m;
            }
        }
        throw new IllegalArgumentException("Sistemde tanımlı olmayan bir medeni durum girildi: " + text);
    }

    @Override
    public String toString() {
        return this.deger;
    }
}