package apap.tugas.sielekthor.service;

import java.util.List;

import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.model.PembelianBarangModel;
import java.time.*;

public interface PembelianBarangService {
    List<PembelianBarangModel> getListPembelianBarang();

    void addPembelianBarang(PembelianBarangModel pembelianBarangModel);

}
