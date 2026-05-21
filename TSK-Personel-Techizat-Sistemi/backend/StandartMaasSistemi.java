public class StandartMaasSistemi implements IOdemeSistemi {

    @Override
    public double maasHesapla(PersonelKimlik personel) {
        // 1. Durum Kontrolü (İhraç edilmiş veya açığa alınmışsa maaş 0'dır)
        if (personel.getDurum() == PersonelDurumu.GOREVDEN_ATILMIS || personel.getDurum() == PersonelDurumu.ACIGA_ALINMIS) {
            return 0.0;
        }

        // 2. Taban Maaş Belirleme (Polimorfizm veya Detay üzerinden)
        double tabanMaas = 35000.0; // Varsayılan
        String rutbe = personel.getDetay().getRutbe().toUpperCase();

        if (rutbe.equals("ALBAY")) tabanMaas = 85000.0;
        else if (rutbe.equals("YARBAY")) tabanMaas = 80000.0;
        else if (rutbe.equals("BİNBAŞI")) tabanMaas = 75000.0;
        else if (rutbe.equals("YÜZBAŞI")) tabanMaas =  70000.0;
        else if (rutbe.equals("ÜSTEĞMEN")) tabanMaas =  65000.0;
        else if (rutbe.equals("TEĞMEN")) tabanMaas =  60000.0;
        else if (rutbe.contains("ASTSUBAY")) tabanMaas =  55000.0;
        else if (rutbe.contains("UZMAN ÇAVUŞ")) tabanMaas =  50000.0;

        return tabanMaas;
    }

    @Override
    public boolean maasYatir(PersonelKimlik personel) {
        double yatirilacakTutar = maasHesapla(personel);

        // Eğer tutar 0 ise (personel atılmışsa vs.) işlem yapmadan iptal et
        if (yatirilacakTutar <= 0) {
            System.out.println("ÖDEME İPTAL: " + personel.getTamAd() + " isimli personele durumundan dolayı ödeme yapılamaz.");
            return false;
        }

        // Burada gerçek hayatta banka API'sine istek atılır. Biz konsola yazdırıyoruz.
        System.out.println("-------------------------------------------------");
        System.out.println("BANKA SİSTEMİ: VakıfBank TSK Ödeme Ağı");
        System.out.println("ALICI: " + personel.getTamAd() + " (" + personel.getDetay().getRutbe() + ")");
        System.out.println("HESAPLANAN NET TUTAR: " + yatirilacakTutar + " TL");
        System.out.println("DURUM: İşlem Başarılı.");
        System.out.println("-------------------------------------------------");

        // İşlemin başarılı olduğunu bildiriyoruz
        return true;
    }
}