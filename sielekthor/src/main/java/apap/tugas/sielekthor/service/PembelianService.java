package apap.tugas.sielekthor.service;
import java.util.List;

import apap.tugas.sielekthor.model.PembelianModel;
import java.time.*;

public interface PembelianService {
    List<PembelianModel> getListPembelian();

    PembelianModel getPembelianByIdPembelian(Long idPembelian);

    PembelianModel deletePembelian(PembelianModel pembelianModel);
}
