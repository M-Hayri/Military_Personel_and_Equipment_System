public enum KanGrubu {
    A_POZITIF("A+"),
    A_NEGATIF("A-"),
    B_POZITIF("B+"),
    B_NEGATIF("B-"),
    AB_POZITIF("AB+"),
    AB_NEGATIF("AB-"),
    SIFIR_POZITIF("0+"),
    SIFIR_NEGATIF("0-");

    private final String deger;

    KanGrubu(String deger) {
        this.deger = deger;
    }

    public String getDeger() {
        return deger;
    }

    public static KanGrubu fromString(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("HATA: Kan grubu verisi boş olamaz!");
        }

        for (KanGrubu k : KanGrubu.values()) {
            // trim() ile kazara girilmiş boşlukları temizliyoruz
            if (k.deger.equalsIgnoreCase(text.trim())) {
                return k;
            }
        }
        throw new IllegalArgumentException("Sistemde tanımlı olmayan bir kan grubu girildi: " + text);
    }

    @Override
    public String toString() {
        return this.deger;
    }
}
