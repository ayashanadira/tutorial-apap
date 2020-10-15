package apap.tutorial.traveloke.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="hotel")
public class HotelModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max=30)
    @Column(name="namaHotel", nullable = false)
    private String namaHotel;

    @NotNull
    @Size(max=30)
    @Column(name="alamat", nullable = false)
    private String alamat;

    @NotNull
    @Column(name="nomorTelepon", nullable = false)
    private Integer nomorTelepon;

    @OneToMany(mappedBy = "hotel", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<KamarModel> listKamar;

    public Long getId() {
        return id;

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

    public List<KamarModel> getListKamar() {
        return listKamar;
    }


    public String getAlamat() {
        return alamat;
    }

    public Integer getNomorTelepon() {
        return nomorTelepon;
    }

    public void setId(Long id) {
        this.id = id;

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setIdHotel(String idHotel) {
        this.idHotel = idHotel;

    }

    public void setNamaHotel(String namaHotel) {
        this.namaHotel = namaHotel;
    }
    public void setListKamar(List<KamarModel> listKamar) {
        listKamar = listKamar;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }


    public void setNomorTelepon(Integer nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

}
