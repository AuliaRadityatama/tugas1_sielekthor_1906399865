package apap.tugas.sielekthor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import apap.tugas.sielekthor.model.MemberModel;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface MemberDB extends JpaRepository<MemberModel, Long>{
    Optional<MemberModel> findByIdMember(Long idMember);
}
