// 2. Somut Ürün: Geçici Görevlendirme
public class GeciciGorev extends Gorev {
    public GeciciGorev(String gorevId, String personelSicilNo, String kurumId, String gorevTanimi) {
        super(gorevId, personelSicilNo, kurumId, gorevTanimi);
    }

    @Override
    public String getGorevTipi() {
        return "GECICI_GOREVLENDIRME";
    }
}
