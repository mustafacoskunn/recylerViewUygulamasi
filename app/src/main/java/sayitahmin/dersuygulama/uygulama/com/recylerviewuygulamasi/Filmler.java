package sayitahmin.dersuygulama.uygulama.com.recylerviewuygulamasi;

import java.io.Serializable;

public class Filmler implements Serializable { //serializable'ı claaslar içinde bilgi taşımak için kullandım
    private String filmAdi;
    private double filmFiyat;
    private String filmResim;

    public Filmler(String filmAdi, double filmFiyat, String filmResim) {
        this.filmAdi = filmAdi;
        this.filmFiyat = filmFiyat;
        this.filmResim = filmResim;
    }

    public String getFilmAdi() {
        return filmAdi;
    }

    public void setFilmAdi(String filmAdi) {
        this.filmAdi = filmAdi;
    }

    public double getFilmFiyat() {
        return filmFiyat;
    }

    public void setFilmFiyat(double filmFiyat) {
        this.filmFiyat = filmFiyat;
    }

    public String getFilmResim() {
        return filmResim;
    }

    public void setFilmResim(String filmResim) {
        this.filmResim = filmResim;
    }
}
