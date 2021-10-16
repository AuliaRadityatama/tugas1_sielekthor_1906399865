package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.model.TipeModel;
import apap.tugas.sielekthor.repository.PembelianDB;
import apap.tugas.sielekthor.repository.TipeDB;
import apap.tugas.sielekthor.service.TipeService;
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
public class TipeServiceImpl implements TipeService{

    @Autowired
    TipeDB tipeDB;

    @Override
    public List<TipeModel> getListTipe(){
        return tipeDB.findAll();
    }

    @Override
    public TipeModel getTipeById(Long idTipe){
        Optional<TipeModel> tipe = tipeDB.findByIdTipe(idTipe);
        if(tipe.isPresent()) return tipe.get();
        else return null;
    }
}
