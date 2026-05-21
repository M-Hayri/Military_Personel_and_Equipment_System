import java.util.Scanner;

public class AracTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Önce test aracımızı temiz bir şekilde üretiyoruz
        Arac testAraci = new Arac.AracConcreteBuilder()
                .buildTemelBilgiler("ALT-01", "BMC", "Altay", "SN-2026")
                .build();

        // 2. Takipçi mekanizmasını bağlıyoruz
        AracFollower lojistikTakip = new AracFollower("Harekat ve Lojistik Merkezi");
        testAraci.observerEkle(lojistikTakip);

        System.out.println("   TSK ENVANTER VE LOJİSTİK SİMÜLASYONU BAŞLADI      ");

        System.out.println("\n[SİSTEM]: Araç başarıyla üretildi. (Durum: " + testAraci.getDurum() + ")");
        System.out.println("Devam etmek için adımları sırayla takip edin.\n");

        // ADIM 1
        System.out.print("[ADIM 1]: Aracı '1. Ordu Komutanlığı'na atamak için 1'e basın: ");
        bekleVeKontrol(scanner, "1");
        testAraci.kurumuDegistir("1. Ordu Komutanlığı");
        anlikDurumYazdir(testAraci);

        // ADIM 2
        System.out.print("[ADIM 2]: Aracı 1. Ordu bünyesindeki 'PER-A-101' personeline zimmetlemek için 2'ye basın: ");
        bekleVeKontrol(scanner, "2");
        testAraci.personeleZimmetle("PER-A-101");
        anlikDurumYazdir(testAraci);

        // ADIM 3
        System.out.print("[ADIM 3]: Aracı '2. Ordu Komutanlığı'na kaydırmak (Eski zimmeti düşürmek) için 3'e basın: ");
        bekleVeKontrol(scanner, "3");
        testAraci.kurumuDegistir("2. Ordu Komutanlığı");
        anlikDurumYazdir(testAraci);

        // ADIM 4
        System.out.print("[ADIM 4]: Aracı 2. Ordu bünyesindeki yeni 'PER-B-202' personeline zimmetlemek için 4'e basın: ");
        bekleVeKontrol(scanner, "4");
        testAraci.personeleZimmetle("PER-B-202");
        anlikDurumYazdir(testAraci);

        System.out.println("   SİMÜLASYON BAŞARIYLA TAMAMLANDI. TÜM ADIMLAR DOĞRU! ");
        scanner.close();
    }

    // Kullanıcın yanlış tuşa basmasını engelleyen yardımcı metot
    private static void bekleVeKontrol(Scanner scanner, String beklenenTus) {
        while (true) {
            String girdi = scanner.nextLine().trim();
            if (girdi.equals(beklenenTus)) {
                break;
            }
            System.out.print("Yanlış tuş! Lütfen adımın gerektirdiği tuşa (" + beklenenTus + ") basın: ");
        }
    }

    // Her adımdan sonra aracın hafızasındaki son durumu gösteren tablo
    private static void anlikDurumYazdir(Arac arac) {
        System.out.println("\n-----------------------------------------------------");
        System.out.printf("| %-18s | %-26s |\n", "Özellik", "Mevcut Durum / Hafıza");
        System.out.println("-----------------------------------------------------");
        System.out.printf("| %-18s | %-26s |\n", "Bulunduğu Kurum", arac.getBulunduguKurum());
        System.out.printf("| %-18s | %-26s |\n", "Zimmetli Personel", (arac.getZimmetliPersonelID() == null ? "YOK (Zimmet Boşta)" : arac.getZimmetliPersonelID()));
        System.out.printf("| %-18s | %-26s |\n", "Teçhizat Durumu", arac.getDurum());
        System.out.println("-----------------------------------------------------\n");
    }
}