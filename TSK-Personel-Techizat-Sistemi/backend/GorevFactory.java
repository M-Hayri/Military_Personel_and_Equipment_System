public class GorevFactory {
    private static int sayac = 2000;

    public static Gorev createGorev(GorevTuru tur, PersonelKimlik p, Kurum k) {
        String yeniGorevId = "GRV-" + (++sayac);

        String rutbe = (p.getDetay() != null) ? p.getDetay().getRutbe() : "Personel";
        String gorevTanimi = rutbe + " rütbesiyle " + k.getKurumAdi() + " emrine atama.";

        // Fabrika gelen türe göre hangi nesneyi üreteceğine çalışma zamanında (Runtime) karar verir.
        switch (tur) {
            case GECICI:
                return new GeciciGorev(yeniGorevId, p.getSicilno(), k.getKurumId(), "[GEÇİCİ] " + gorevTanimi);
            case STANDART:
            default:
                return new StandartGorev(yeniGorevId, p.getSicilno(), k.getKurumId(), gorevTanimi);
        }
    }
}