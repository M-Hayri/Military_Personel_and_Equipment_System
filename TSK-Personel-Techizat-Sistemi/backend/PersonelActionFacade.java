import java.util.ArrayList;
import java.util.List;

public class PersonelActionFacade {

    private static PersonelActionFacade instance;

    // Senin tanımladığın PersonelObserver interface'ini kullanan liste
    private List<PersonelObserver> gozlemciler = new ArrayList<>();

    private PersonelActionFacade() {
        // Singleton constructor
    }

    public static synchronized PersonelActionFacade getInstance() {
        if (instance == null) {
            instance = new PersonelActionFacade();
        }
        return instance;
    }

    //Ana Facade
    public void personeliKurumaAta(PersonelKimlik personel, Kurum yeniKurum) {
        yeniKurum.personelEkle();
        personel.setAtandigiKurum(yeniKurum);

        // Fabrikadan soyut referansla nesneyi istiyoruz (Polimorfizm)
        Gorev yeniGorev = GorevFactory.createGorev(GorevTuru.STANDART, personel, yeniKurum);

        System.out.println("LOG: " + yeniGorev.toString()); // Çalışma zamanında ait olduğu sınıfın toString'i tetiklenir.
        bildirimGonder(personel, yeniKurum);
    }

    public void gozlemciEkle(PersonelObserver gozlemci) {
        this.gozlemciler.add(gozlemci);
    }

    private void bildirimGonder(PersonelKimlik p, Kurum k) {
        for (PersonelObserver observer : gozlemciler) {
            // Tayin bilgisini ilet
            observer.tayinGuncelle(p.getSicilno(), k);

            // Personel durumunu AKTIF_GOREVDE olarak güncelle
            observer.durumGuncelle(p.getSicilno(), PersonelDurumu.AKTIF_GOREVDE);
        }
    }
}