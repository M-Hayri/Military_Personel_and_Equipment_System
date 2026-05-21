import java.util.Date;

public class UzmanErbas extends PersonelKimlik {

    public UzmanErbas(String tc, String sicilno, String ad, String soyad,
                      MedeniDurum medeniDurum, Date dogumTarihi, CinsiyetTur cinsiyet, KanGrubu kanGrubu,
                      Personel detay, IOdemeSistemi odemeSistemi) {
        super(tc, sicilno, ad, soyad, medeniDurum, dogumTarihi, cinsiyet, kanGrubu, detay, odemeSistemi);
    }

    @Override
    public void gorevTaniminiYazdir() {
        String kuvvetAdi = getDetay().getKuvvet().name();
        String rutbeAdi = getDetay().getRutbe();

        System.out.println(kuvvetAdi + " Kuvvetleri Uzman Personeli (" + rutbeAdi + ") - Operasyonel İcra yetkisi.");
    }
}