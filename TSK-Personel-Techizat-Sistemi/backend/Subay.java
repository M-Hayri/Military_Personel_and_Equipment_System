import java.util.Date;

public class Subay extends PersonelKimlik {

    public Subay(String tc, String sicilno, String ad, String soyad,
                 MedeniDurum medeniDurum, Date dogumTarihi, CinsiyetTur cinsiyet, KanGrubu kanGrubu,
                 Personel detay, IOdemeSistemi odemeSistemi) {
        // Üst sınıfın (PersonelKimlik) constructor'ına verileri gönderiyoruz
        super(tc, sicilno, ad, soyad, medeniDurum, dogumTarihi, cinsiyet, kanGrubu, detay, odemeSistemi);
    }

    @Override
    public void gorevTaniminiYazdir() {
        // Rütbe ve Kuvvet bilgilerini 'detay' nesnesinden alıyoruz
        String kuvvetAdi = getDetay().getKuvvet().name();
        String rutbeAdi = getDetay().getRutbe();

        System.out.println(kuvvetAdi + " Kuvvetleri Subayı (" + rutbeAdi + ") - Birlik Sevk ve İdare yetkisi.");
    }
}