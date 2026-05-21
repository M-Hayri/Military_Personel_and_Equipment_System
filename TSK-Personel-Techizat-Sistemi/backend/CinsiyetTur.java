public enum CinsiyetTur {
    ERKEK("erkek"),
    KADIN("kadın");
    private final String deger;

    CinsiyetTur(String deger) {
        this.deger = deger;
    }

    public String getDeger() {
        return deger;
    }

    public static CinsiyetTur fromString(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("HATA: Cinsiyet verisi boş olamaz!");
        }

        for (CinsiyetTur c : CinsiyetTur.values()) {
            if (c.deger.equalsIgnoreCase(text.trim())) {
                return c;
            }
        }
        throw new IllegalArgumentException("Sistemde tanımlı olmayan bir cinsiyet girildi: " + text);
    }

    @Override
    public String toString() {
        return this.deger;
    }
}