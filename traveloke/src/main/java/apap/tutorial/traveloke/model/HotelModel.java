package apap.tutorial.traveloke.model;

public class HotelModel {

    private String alamat;
    private String noTelepon;
    private String idHotel;
    private String namaHotel;

    public HotelModel(String idHotel, String namaHotel, String alamat, String noTelepon) {
        this.idHotel = idHotel;
        this.namaHotel = namaHotel;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
    }

    public String getIdHotel() {
        return idHotel;
    }

    public String getNamaHotel() {
        return namaHotel;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setIdHotel(String idHotel) {
        this.idHotel = idHotel;
    }

    public void setNamaHotel(String namaHotel) {
        this.namaHotel = namaHotel;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

}
