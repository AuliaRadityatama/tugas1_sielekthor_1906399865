package apap.tugas.sielekthor.service;

import java.math.BigInteger;
import java.util.List;
import apap.tugas.sielekthor.model.MemberModel;

import java.time.*;

public interface MemberService {
    List<MemberModel> getListMember();

    MemberModel getMemberByIdMember(Long idMember);

    void addMember(MemberModel memberModel);

    MemberModel updateMember(MemberModel memberModel);
}
