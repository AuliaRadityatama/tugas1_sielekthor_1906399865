package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.PembelianModel;
import apap.tugas.sielekthor.repository.PembelianDB;
import apap.tugas.sielekthor.service.PembelianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
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
public class PembelianServiceImpl implements PembelianService{
    @Autowired
    PembelianDB pembelianDB;

    @Override
    public List<PembelianModel> getListPembelian(){
        return pembelianDB.findAll();
    }

    @Override
    public PembelianModel getPembelianByIdPembelian(Long idPembelian){
        Optional<PembelianModel> pembelian = pembelianDB.findByIdPembelian(idPembelian);
        if(pembelian.isPresent()) return pembelian.get();
        else return null;
    }

    @Override
    public PembelianModel deletePembelian(PembelianModel pembelianModel){
        pembelianDB.delete(pembelianModel);
        return pembelianModel;
    }
}
