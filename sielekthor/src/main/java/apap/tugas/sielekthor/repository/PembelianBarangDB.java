package apap.tugas.sielekthor.repository;

import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.model.PembelianModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import apap.tugas.sielekthor.model.PembelianBarangModel;
import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface PembelianBarangDB extends JpaRepository<PembelianBarangModel, Long>{
    Optional<PembelianBarangModel> findByIdPembelianBarang(Long idPembelianBarang);
}
