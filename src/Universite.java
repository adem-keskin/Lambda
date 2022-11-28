public class Universite {

    private String univercity;
    private String bolum;
    private int ogrSsayisi;
    private int notOrt;

    //Select None generate ettik..
    public Universite() {
    }

    // Parametreli sekilde otomatik Generate ettik..hepsini sectik
    public Universite(String univercity, String bolum, int ogrSsayisi, int notOrt) {
        this.univercity = univercity;
        this.bolum = bolum;
        this.ogrSsayisi = ogrSsayisi;
        this.notOrt = notOrt;
    }

    //Getter -- Setter
    public String getUnivercity() {
        return univercity;
    }

    public void setUnivercity(String univercity) {
        this.univercity = univercity;
    }

    public String getBolum() {
        return bolum;
    }

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    public int getOgrSsayisi() {
        return ogrSsayisi;
    }

    public void setOgrSsayisi(int ogrSsayisi) {
        this.ogrSsayisi = ogrSsayisi;
    }

    public int getNotOrt() {
        return notOrt;
    }

    public void setNotOrt(int notOrt) {
        this.notOrt = notOrt;
    }

    @Override
    public String toString() {
        return "Universite{" +
                "univercity='" + univercity + '\'' +
                ", bolum='" + bolum + '\'' +
                ", ogrSsayisi=" + ogrSsayisi +
                ", notOrt=" + notOrt +
                '}';
    }
}
