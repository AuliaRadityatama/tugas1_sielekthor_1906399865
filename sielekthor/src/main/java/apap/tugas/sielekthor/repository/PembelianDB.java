package apap.tugas.sielekthor.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import apap.tugas.sielekthor.model.PembelianModel;
import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface PembelianDB extends JpaRepository<PembelianModel, Long>{
    Optional<PembelianModel> findByIdPembelian(Long idPembelian);
}
