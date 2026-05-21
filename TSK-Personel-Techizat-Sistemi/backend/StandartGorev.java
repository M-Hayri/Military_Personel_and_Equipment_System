// 1. Somut Ürün: Standart Kalıcı Atama
public class StandartGorev extends Gorev {
    public StandartGorev(String gorevId, String personelSicilNo, String kurumId, String gorevTanimi) {
        super(gorevId, personelSicilNo, kurumId, gorevTanimi);
    }

    @Override
    public String getGorevTipi() {
        return "STANDART_ATAMA";
    }
}

