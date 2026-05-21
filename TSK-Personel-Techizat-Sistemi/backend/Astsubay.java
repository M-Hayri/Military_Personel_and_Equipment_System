import java.util.Date;

public class Astsubay extends PersonelKimlik {

    public Astsubay(String tc, String sicilno, String ad, String soyad,
                    MedeniDurum medeniDurum, Date dogumTarihi, CinsiyetTur cinsiyet, KanGrubu kanGrubu,
                    Personel detay, IOdemeSistemi odemeSistemi) {
        super(tc, sicilno, ad, soyad, medeniDurum, dogumTarihi, cinsiyet, kanGrubu, detay, odemeSistemi);
    }

    @Override
    public void gorevTaniminiYazdir() {
        String kuvvetAdi = getDetay().getKuvvet().name();
        String rutbeAdi = getDetay().getRutbe();

        System.out.println(kuvvetAdi + " Kuvvetleri Astsubayı (" + rutbeAdi + ") - Teknik ve Taktik Operasyon yetkisi.");
    }
}