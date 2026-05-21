public class Main {
    public static void main(String[] args) {
        AracBuilder builder = new Arac.AracConcreteBuilder();

        AracDirector sef = new AracDirector(builder);

        Arac yeniTank = sef.askeriAracOlustur(
                "ALT-01", "BMC", "Altay", "SN-2026",
                motorTipi.DIZEL, yakitTuru.MOTORIN,
                4, 65000, true, techizatDurum.AKTIF, "KKK0007"
        );

        System.out.println("Araç Oluşturuldu: " + yeniTank.getMarka());
    }
}