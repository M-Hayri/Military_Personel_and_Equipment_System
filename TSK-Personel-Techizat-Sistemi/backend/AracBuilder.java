public interface AracBuilder {
    AracBuilder buildTemelBilgiler(String id, String marka, String model, String seriNo);
    AracBuilder buildMotorVeYakit(motorTipi motor, yakitTuru yakit);
    AracBuilder buildKapasite(int personel, int yukKapasitesi);
    AracBuilder buildAskeriSistemler(boolean silahVarMi, techizatDurum durum, String kurum);
    Arac build(); // En son nesneyi teslim eden method
}