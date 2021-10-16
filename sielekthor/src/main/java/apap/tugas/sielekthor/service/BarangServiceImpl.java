package apap.tugas.sielekthor.service;

import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.repository.BarangDB;
import apap.tugas.sielekthor.service.BarangService;
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
public class BarangServiceImpl implements BarangService{

    @Autowired
    BarangDB barangDB;

    @Override
    public List<BarangModel> getListBarang() {
        return barangDB.findAll();
    }

    @Override
    public void addBarang(BarangModel barangModel){
        barangDB.save(barangModel);
    }

    @Override
    public BarangModel getBarangByIdBarang(Long idBarang){
        Optional<BarangModel> barang = barangDB.findByIdBarang(idBarang);
        if(barang.isPresent()) return barang.get();
        else return null;
    }

    @Override
    public BarangModel updateBarang(BarangModel barangModel){
        barangDB.save(barangModel);
        return barangModel;
    }
}
