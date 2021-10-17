package apap.tugas.sielekthor.controller;

import apap.tugas.sielekthor.model.*;
import apap.tugas.sielekthor.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

@Controller
public class BarangController {

    @Qualifier("barangServiceImpl")
    @Autowired
    private BarangService barangService;

    @Qualifier("pembelianBarangServiceImpl")
    @Autowired
    private PembelianBarangService pembelianBarangService;

    @Qualifier("tipeServiceImpl")
    @Autowired
    private TipeService tipeService;

    @Qualifier("pembelianServiceImpl")
    @Autowired
    private PembelianService pembelianService;

    @GetMapping("/barang")
    public String listBarang(Model model){
        List<BarangModel> listBarang = barangService.getListBarang();
        model.addAttribute("listBarang", listBarang);
        List<TipeModel> listTipe = tipeService.getListTipe();
        model.addAttribute("listTipe",listTipe);
        return "viewall-barang";
    }

    @GetMapping("/barang/tambah")
    public String addBarangFormPage(Model model){
        model.addAttribute("barang", new BarangModel());
        List<TipeModel> listTipe = tipeService.getListTipe();
        model.addAttribute("listTipe",listTipe);
        return "form-tambah-barang";
    }

    @PostMapping("/barang/tambah")
    public String addBarangSubmitPage(
            @ModelAttribute BarangModel barang,
            Model model
    ){
        barangService.addBarang(barang);
        model.addAttribute("kode", barang.getKodeBarang());
        return "tambah-barang";
    }

    @GetMapping("/barang/{idBarang}")
    public String lihatDetailBarang(
            @PathVariable Long idBarang,
            Model model
    ){
        BarangModel barang =barangService.getBarangByIdBarang(idBarang);
        model.addAttribute("barang", barang);
        List<TipeModel> listTipe = tipeService.getListTipe();
        model.addAttribute("listTipe",listTipe);
        return "view-barang";
    }

    @GetMapping("/barang/ubah/{idBarang}")
    public String updateBarangFormPage(
            @PathVariable Long idBarang,
            Model model
    ){
        BarangModel barang = barangService.getBarangByIdBarang(idBarang);
        model.addAttribute("barang", barang);
        List<TipeModel> listTipe = tipeService.getListTipe();
        model.addAttribute("listTipe",listTipe);
        return "form-update-barang";
    }

    @PostMapping("/barang/ubah")
    public String updateBarangSubmitPage(
            @ModelAttribute BarangModel barang,
            Model model
    ){
        BarangModel updatedBarang = barangService.updateBarang(barang);
        model.addAttribute("kode", updatedBarang.getKodeBarang());
        return "update-barang";
    }

    @GetMapping(value="/barang/cari")
    public String displayBarangHabisFormPage(
            @ModelAttribute BarangModel barang,
            Model model
    ){
        List<BarangModel> listBarang = barangService.getListBarang();
        model.addAttribute("listBarang", listBarang);

        List<TipeModel> listTipe = tipeService.getListTipe();
        model.addAttribute("listTipe", listTipe);

        return "form-barang-cari-stok-habis";
    }

    @GetMapping(value="/barang/tipe/stok")
    public String displayBarangHabisSubmitPage(
            @RequestParam Long idTipe,
            @RequestParam int stok,
            @ModelAttribute BarangModel barangModel,
            Model model) {
        List<BarangModel> listBarang = barangService.getListBarang();
        ArrayList<BarangModel> listBarangFinal = new ArrayList<>();
        for (BarangModel i : listBarang){
            if (i.get_stok_barang() == stok && i.get_id_tipe().equals(idTipe)){
                listBarangFinal.add(i);
            }
        }
        model.addAttribute("listBarang", listBarang);

        List<TipeModel> listTipe = tipeService.getListTipe();
        model.addAttribute("listTipe", listTipe);

        model.addAttribute("listBarangFinal", listBarangFinal);
        return "display-barang-cari-stok-habis";
    }
}
