package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.model.PembelianBarangModel;
import apap.tugas.sielekthor.repository.BarangDB;
import apap.tugas.sielekthor.repository.PembelianBarangDB;
import apap.tugas.sielekthor.service.PembelianBarangService;
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
public class PembelianBarangServiceImpl implements PembelianBarangService{

    @Autowired
    PembelianBarangDB pembelianBarangDB;

    @Override
    public List<PembelianBarangModel> getListPembelianBarang() {
        return pembelianBarangDB.findAll();
    }

    @Override
    public void addPembelianBarang(PembelianBarangModel pembelianBarangModel){
        pembelianBarangDB.save(pembelianBarangModel);
    }





}
