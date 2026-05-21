import java.util.List;

public class TskMerkezKomutanligi implements PersonelObserver{
    private String merkezAdi = "Milli Savunma Bakanlığı - Personel Daire Başkanlığı";

    // 1. KURUMA ATAMA GÖREVİ
    public void kurumaAta(PersonelKimlik personel, Kurum yeniKurumAdi) {
        personel.setAtandigiKurum(yeniKurumAdi);
        System.out.println("ATAMA MERKEZİ: " + personel.getDetay().getRutbe() + " " +
                personel.getAd() + " " + personel.getSoyad() +
                ", " + yeniKurumAdi + " emrine atanmıştır.");
    }

    // 2. DURUM GÜNCELLEME GÖREVİ
    public void personelDurumBildir(PersonelKimlik personel, PersonelDurumu yeniDurum) {
        personel.setDurum(yeniDurum);
        System.out.println("BİLDİRİM: " + personel.getAd() + " isimli personelin durumu '" + yeniDurum + "' olarak güncellendi.");
    }

    // 3. PERSONELİN KURUMLA İLİŞKİSİNİ KESME
    public void kurumlaIliskisiniKes(PersonelKimlik personel) {
        personel.setDurum(PersonelDurumu.GOREVDEN_ATILMIS);
        System.out.println("BİLDİRİM: " + personel.getTamAd() + " isimli personelin kurumla ilişkisi kesilmiştir. ");
    }

    // 4. PERSONELİ BAŞKA BİR KURUMA TAYİN ET
    // kurum sınıfı oluşturulduktan sonra hazırlanacak

    // 4. MAAŞ GÜNCELLEME
    public void maaslariGuncelle(List<PersonelKimlik> personelListesi) {
        System.out.println("\n--- " + merkezAdi + ": Rütbelere Göre Maaş Güncellemeleri Yapılıyor ---");
        for (PersonelKimlik p : personelListesi) {
            String rutbe = p.getDetay().getRutbe();
            double yeniMaas = rutbeyeGoreMaasBelirle(rutbe);
            p.getDetay().setGuncelMaas(yeniMaas);
            System.out.println("GÜNCELLEME: " + p.getAd() + " (" + rutbe + ") güncel taban maaşı " + yeniMaas + " TL olarak atandı.");
        }
    }

    // 5. MAAŞ YATIRMA
    public void tumMaaslariYatir(List<PersonelKimlik> personelListesi) {
        System.out.println("\n--- " + merkezAdi + " Maaş Ödemelerini Başlattı ---");
        for (PersonelKimlik p : personelListesi) {
            if (p.getDurum() == PersonelDurumu.AKTIF_GOREVDE) {
                p.maasAl();
            }
        }
    }

    private double rutbeyeGoreMaasBelirle(String rutbe) {
        String r = rutbe.toUpperCase();
        if (r.equals("ALBAY")) return 85000.0;
        if (r.equals("YARBAY")) return 80000.0;
        if (r.equals("BİNBAŞI")) return 75000.0;
        if (r.equals("YÜZBAŞI")) return 70000.0;
        if (r.equals("ÜSTEĞMEN")) return 65000.0;
        if (r.equals("TEĞMEN")) return 60000.0;
        if (r.contains("ASTSUBAY")) return 55000.0;
        if (r.contains("UZMAN ÇAVUŞ")) return 50000.0;
        return 35000.0;
    }

    @Override
    public void durumGuncelle(String personelId, PersonelDurumu yeniDurum) {
        System.out.println("BİLDİRİM [" + merkezAdi + "]: " + personelId + " ID'li personelin durumu '" + yeniDurum + "' olarak güncellendi.");

        // Eğer durum ihraç veya şehit ise otomatik aksiyon al:
        if (yeniDurum == PersonelDurumu.GOREVDEN_ATILMIS || yeniDurum == PersonelDurumu.SEHIT) {
            System.out.println("SİSTEM: Personelin kurumla ilişiği ve maaş ödemeleri durdurulmuştur.");
        }
    }

    @Override
    public void sucKaydiIsle(String personelId, CezaTipi suc, String detay) {
        System.out.println("DİSİPLİN KURULU [" + merkezAdi + "]: " + personelId + " siciline suç işlendi: " + suc.getAciklama());

        // Ceza puanına göre otomatik aksiyon (Enum'daki cezaPuani gücünü burada kullanıyoruz)
        if (suc.getCezaPuani() >= 10) {
            System.out.println("KRİTİK UYARI: Ağır ceza tespit edildi. İhraç süreci başlatılıyor!");
            durumGuncelle(personelId, PersonelDurumu.GOREVDEN_ATILMIS);
        } else if (suc.getCezaPuani() >= 5) {
            System.out.println("UYARI: Personel maaşından ceza kesintisi uygulanacaktır.");
        }
    }

    @Override
    public void tayinGuncelle(String personelId, Kurum yeniKurum) {
        System.out.println("ATAMA MERKEZİ: " + personelId + " numaralı personel " +
                yeniKurum.getKurumAdi() + " emrine tayin edilmiştir.");
    }


}