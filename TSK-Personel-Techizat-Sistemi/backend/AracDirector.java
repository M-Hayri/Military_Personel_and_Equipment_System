public class AracDirector {
    private final AracBuilder builder;

    // Director çalışmak için bir usta (builder) ister
    public AracDirector(AracBuilder builder) {
        this.builder = builder;
    }

    // Director nesnenin üretim algoritmasını/sırasını belirler
    public Arac askeriAracOlustur(String id, String marka, String model, String seriNo,
                                  motorTipi motor, yakitTuru yakit, int personel,
                                  int yukKapasitesi, boolean silahVarMi,
                                  techizatDurum durum, String kurum) {

        // Üretim adımlarının sırasını Director yönetir
        return builder.buildTemelBilgiler(id, marka, model, seriNo)
                .buildMotorVeYakit(motor, yakit)
                .buildKapasite(personel, yukKapasitesi)
                .buildAskeriSistemler(silahVarMi, durum, kurum)
                .build(); // Nesneyi teslim eder
    }
}