package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.MemberModel;
import apap.tugas.sielekthor.repository.MemberDB;
import apap.tugas.sielekthor.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

@Service
@Transactional
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberDB memberDB;

    public List<MemberModel> getListMember(){
        return memberDB.findAll();
    }

    public MemberModel getMemberByIdMember(Long idMember){
        Optional<MemberModel> member = memberDB.findByIdMember(idMember);
        if(member.isPresent()) return member.get();
        else return null;
    }

    public void addMember(MemberModel memberModel){
        memberDB.save(memberModel);
    }

    public MemberModel updateMember(MemberModel memberModel){
        memberDB.save(memberModel);
        return memberModel;
    }
}
