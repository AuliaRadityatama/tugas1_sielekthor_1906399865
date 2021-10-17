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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "member")
public class MemberModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMember;

    @NotNull
    @Column(name="jenis_kelamin", nullable = false)
    private Integer jenisKelamin;

    @NotNull
    @Size(max = 255)
    @Column(name="nama_member", nullable = false)
    private String namaMember;

    @NotNull
    @Column(name="tanggal_pendaftaran", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime tanggalPendaftaran;

    @NotNull
    @Column(name="tanggal_lahir", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tanggalLahir;

    //Relasi foreign key dari PEMBELIAN
    @OneToMany(mappedBy = "id_member", fetch= FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PembelianModel> listPembelian;

    public String format_tanggal_lahir(){
        DateFormat var = new SimpleDateFormat("dd/MM/yyyy");
        return var.format(tanggalLahir);
    }

    public String format_tanggal_pendaftaran(){
        LocalDateTime var = tanggalPendaftaran;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return var.format(formatter);
    }

    public int get_jumlah_pembelian(){
        return listPembelian.size();
    }
}
