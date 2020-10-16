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
        return this.id;
    }

    public String getNamaHotel() {
        return  this.namaHotel;
    }

    public List<KamarModel> getListKamar() {
        return this.listKamar;
    }

    public String getAlamat() {
        return this.alamat;
    }

    public Integer getNomorTelepon() {
        return this.nomorTelepon;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNamaHotel(String namaHotel) {
        this.namaHotel = namaHotel;
    }

    public void setListKamar(List<KamarModel> listKamar) {
        this.listKamar = listKamar;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setNomorTelepon(Integer nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }
}
