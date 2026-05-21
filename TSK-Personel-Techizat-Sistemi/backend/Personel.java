public class Personel {
    private String[] telefon;
    private String[] eposta;
    private String[] bildigiDiller;
    private String bedenBilgileriJson;
    private KuvvetTuru kuvvet;
    private String rutbe;
    private double guncelMaas;

    // Constructor
    public Personel(String[] telefon, String[] eposta, String[] bildigiDiller,
                    String bedenBilgileriJson, KuvvetTuru kuvvet, String rutbe) {
        this.telefon = telefon;
        this.eposta = eposta;
        this.bildigiDiller = bildigiDiller;
        this.bedenBilgileriJson = bedenBilgileriJson;
        this.kuvvet = kuvvet;
        this.rutbe = rutbe;
    }

    // GETTER VE SETTER METOTLARI

    public String[] getTelefon() { return telefon; }
    public void setTelefon(String[] telefon) { this.telefon = telefon; }

    public String[] getEposta() { return eposta; }
    public void setEposta(String[] eposta) { this.eposta = eposta; }

    public String[] getBildigiDiller() { return bildigiDiller; }
    public void setBildigiDiller(String[] bildigiDiller) { this.bildigiDiller = bildigiDiller; }

    public String getBedenBilgileriJson() { return bedenBilgileriJson; }
    public void setBedenBilgileriJson(String bedenBilgileriJson) { this.bedenBilgileriJson = bedenBilgileriJson; }

    public KuvvetTuru getKuvvet() { return kuvvet; }
    public void setKuvvet(KuvvetTuru kuvvet) { this.kuvvet = kuvvet; }

    public String getRutbe() { return rutbe; }
    public void setRutbe(String rutbe) { this.rutbe = rutbe; }

    public double getGuncelMaas() { return guncelMaas; }
    public void setGuncelMaas(double guncelMaas) { this.guncelMaas = guncelMaas; }
}