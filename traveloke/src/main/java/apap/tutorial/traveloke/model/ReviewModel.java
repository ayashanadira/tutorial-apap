package apap.tutorial.traveloke.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name="review")
public class ReviewModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReview;

    @NotNull
    @Size(max=10)
    @Column(name="nama_reviewer", nullable = false)
    private String nama_reviewer;

    @NotNull
    @Size(max=50)
    @Column(name="isi_review", nullable = false)
    private String isi_review;

    @Size(max=50)
    @Column(name="saran", nullable = false)
    private String saran;

    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "nomorKamar", referencedColumnName = "noKamar", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private KamarModel kamar;
}
