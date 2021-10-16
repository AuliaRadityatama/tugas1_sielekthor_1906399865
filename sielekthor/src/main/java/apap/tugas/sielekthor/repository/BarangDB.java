package apap.tugas.sielekthor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import apap.tugas.sielekthor.model.BarangModel;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface BarangDB extends JpaRepository<BarangModel, Long>{
    Optional<BarangModel> findByIdBarang(Long idBarang);
}
