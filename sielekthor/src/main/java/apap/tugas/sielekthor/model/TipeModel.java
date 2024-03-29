package apap.tugas.sielekthor.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@Table(name = "tipe")

public class TipeModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipe;

    @NotNull
    @Size(max = 255)
    @Column(name="nama", nullable = false)
    private String namaTipe;

    @NotNull
    @Size(max = 255)
    @Column(name="deskripsi_tipe", nullable = false)
    private String deskripsiTipe;

    //Relasi FK dari BARANG
    @OneToMany(mappedBy = "id_tipe", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BarangModel> listBarang;

    public String get_nama_tipe(){
        return namaTipe;
    }

    public Long get_id_tipe(){
        return idTipe;
    }
}
