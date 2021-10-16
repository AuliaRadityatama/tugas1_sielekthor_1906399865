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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "pembelian_barang")

public class PembelianBarangModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPembelianBarang;

    //Foreign key ke tabel BARANG
    @ManyToOne(fetch= FetchType.EAGER, optional = false)
    @JoinColumn(name="id_barang", referencedColumnName = "idBarang", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private BarangModel id_barang;

    //Foreign key ke tabel PEMBELIAN
    @ManyToOne(fetch= FetchType.EAGER, optional = false)
    @JoinColumn(name="id_pembelian", referencedColumnName = "idPembelian", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PembelianModel id_pembelian;

    @NotNull
    @Column(name="tanggal_garansi", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalGaransi;

    @NotNull
    @Column(name="quantity", nullable = false)
    private Integer quantity;

    public String format_tanggal_garansi(){
        DateFormat var = new SimpleDateFormat("dd/MM/yyyy");
        return var.format(tanggalGaransi);
    }
}
