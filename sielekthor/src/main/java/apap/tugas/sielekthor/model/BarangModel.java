package apap.tugas.sielekthor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "barang")

public class BarangModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBarang;

    @NotNull
    @Size(max = 255)
    @Column(name="nama_barang", nullable = false)
    private String namaBarang;

    @NotNull
    @Column(name="stok", nullable = false)
    private Integer stok;

    @NotNull
    @Column(name="jumlah_garansi", nullable = false)
    private Integer jumlahGaransi;

    @NotNull
    @Size(max = 255)
    @Column(name="deskripsi_barang", nullable = false)
    private String deskripsiBarang;

    @NotNull
    @Size(min = 16, max = 16)
    @Column(name="kode_barang", nullable = false, unique = true)
    private String kodeBarang;

    @NotNull
    @Size(max = 255)
    @Column(name="merk_barang", nullable = false)
    private String merkBarang;

    @NotNull
    @Column(name="harga_barang", nullable = false)
    private Integer hargaBarang;

    //Foreign key ke tabel TIPE
    @ManyToOne(fetch= FetchType.EAGER, optional = false)
    @JoinColumn(name="id_tipe", referencedColumnName = "idTipe", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private TipeModel id_tipe;

    //Relasi FK dari PEMBELIAN_BARANG
    @OneToMany(mappedBy = "id_barang", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PembelianBarangModel> listPembelianBarang;
}
