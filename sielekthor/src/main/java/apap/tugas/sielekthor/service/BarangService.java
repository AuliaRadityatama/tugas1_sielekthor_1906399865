package apap.tugas.sielekthor.service;
import java.math.BigInteger;
import java.util.List;
import apap.tugas.sielekthor.model.BarangModel;
import java.time.*;

public interface BarangService {

    List<BarangModel> getListBarang();


    void addBarang(BarangModel barangModel);


    BarangModel getBarangByIdBarang(Long idBarang);

    BarangModel updateBarang(BarangModel barangModel);
}
