package apap.tugas.sielekthor.repository;

import apap.tugas.sielekthor.model.PembelianModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apap.tugas.sielekthor.model.TipeModel;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface TipeDB extends JpaRepository<TipeModel, Long>{
    Optional<TipeModel> findByIdTipe(Long idTipe);
}

