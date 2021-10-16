package apap.tugas.sielekthor.service;

import java.math.BigInteger;
import java.util.List;
import apap.tugas.sielekthor.model.BarangModel;
import apap.tugas.sielekthor.model.PembelianBarangModel;
import apap.tugas.sielekthor.model.TipeModel;

import java.time.*;

public interface TipeService {
    List<TipeModel> getListTipe();

    TipeModel getTipeById(Long idTipe);
}
