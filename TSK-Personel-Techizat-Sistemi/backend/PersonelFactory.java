import java.util.Date;

public class PersonelFactory {

    public static PersonelKimlik personelUret(String tc, String sicilno, String ad, String soyad,
                                              MedeniDurum medeniDurum, Date dogumTarihi, CinsiyetTur cinsiyet,
                                              KanGrubu kanGrubu, Personel detay, IOdemeSistemi odemeSistemi) {

        String rutbe = detay.getRutbe();
        PersonelKategori kategori = rutbeKategorisiBul(rutbe);

        switch (kategori) {
            case USTSUBAY:
            case SUBAY:
                return new Subay(tc, sicilno, ad, soyad, medeniDurum, dogumTarihi, cinsiyet, kanGrubu, detay, odemeSistemi);
            case ASTSUBAY:
                return new Astsubay(tc, sicilno, ad, soyad, medeniDurum, dogumTarihi, cinsiyet, kanGrubu, detay, odemeSistemi);
            case UZMAN_ERBAS:
                return new UzmanErbas(tc, sicilno, ad, soyad, medeniDurum, dogumTarihi, cinsiyet, kanGrubu, detay, odemeSistemi);
            default:
                throw new IllegalArgumentException("Tanımsız rütbe kategorisi: " + rutbe);
        }
    }

    private static PersonelKategori rutbeKategorisiBul(String rutbe) {
        String r = rutbe.toUpperCase();
        if (r.equals("ALBAY") || r.equals("YARBAY") || r.equals("BİNBAŞI")) return PersonelKategori.USTSUBAY;
        else if (r.contains("YÜZBAŞI") || r.contains("TEĞMEN")) return PersonelKategori.SUBAY;
        else if (r.contains("ASTSUBAY")) return PersonelKategori.ASTSUBAY;
        else if (r.contains("UZMAN")) return PersonelKategori.UZMAN_ERBAS;
        else return PersonelKategori.ERBAS_ER;
    }
}