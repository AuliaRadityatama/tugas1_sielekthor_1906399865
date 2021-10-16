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
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name="pembelian")
public class PembelianModel implements  Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPembelian;

    @NotNull
    @Column(name="total", nullable = false)
    private Integer totalPembelian;

    @NotNull
    @Column(name="tanggal_pembelian", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime tanggalPembelian;

    @NotNull
    @Size(max = 255)
    @Column(name="nama_admin", nullable = false)
    private String namaAdmin;

    @NotNull
    @Size(max = 255)
    @Column(name="no_invoice", nullable = false, unique = true)
    private String noInvoice;

    @NotNull
    @Column(name="is_cash", nullable = false)
    private Boolean isCash;

    //Foreign key ke tabel MEMBER
    @ManyToOne(fetch= FetchType.EAGER, optional = false)
    @JoinColumn(name="id_member", referencedColumnName = "idMember", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MemberModel id_member;

    //Relasi FK dari PEMBELIAN_BARANG
    @OneToMany(mappedBy = "id_pembelian", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PembelianBarangModel> listPembelianBarang;

    public String format_tanggal_pembelian(){
        LocalDateTime var = tanggalPembelian;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return var.format(formatter);
    }

    public int jumlah_barang(){
        return listPembelianBarang.size();
    }

    public String metode_bayar(){
        if(isCash){
            return "Cash";
        }
        else{
            return "Tunai";
        }
    }

    public List<PembelianBarangModel> list_pembelian_barang(){
        return listPembelianBarang;
    }

}
