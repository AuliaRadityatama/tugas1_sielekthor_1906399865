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
public class PembelianController {

    @Qualifier("pembelianServiceImpl")
    @Autowired
    private PembelianService pembelianService;

    @Qualifier("memberServiceImpl")
    @Autowired
    private MemberService memberService;

    @Qualifier("barangServiceImpl")
    @Autowired
    private BarangService barangService;

    @Qualifier("pembelianBarangServiceImpl")
    @Autowired
    private PembelianBarangService pembelianBarangService;

    @GetMapping("/pembelian")
    public String listPembelian(Model model){
        List<PembelianModel> listPembelian = pembelianService.getListPembelian();
        model.addAttribute("listPembelian", listPembelian);

        List<MemberModel> listMember = memberService.getListMember();
        model.addAttribute("listMember",listMember);

        List<PembelianBarangModel> listPembelianBarang = pembelianBarangService.getListPembelianBarang();
        model.addAttribute("listPembelianBarang",listPembelianBarang);

        return "viewall-pembelian";
    }

    @GetMapping("/pembelian/{idPembelian}")
    public String lihatDetailPembelian(
            @PathVariable Long idPembelian,
            Model model
    ){
        PembelianModel pembelian =pembelianService.getPembelianByIdPembelian(idPembelian);
        model.addAttribute("pembelian", pembelian);

        List<PembelianModel> listPembelian =pembelianService.getListPembelian();
        model.addAttribute("listPembelian",listPembelian);

        List<PembelianBarangModel> listPembelianBarang = pembelianBarangService.getListPembelianBarang();
        model.addAttribute("listPembelianBarang",listPembelianBarang);
        model.addAttribute("getListPembelianBarang", pembelian.list_pembelian_barang());

        List<MemberModel> listMember = memberService.getListMember();
        model.addAttribute("listMember",listMember);

        List<BarangModel> listBarang = barangService.getListBarang();
        model.addAttribute("listBarang",listBarang);

        return "view-pembelian";
    }

    @PostMapping("/pembelian/hapus/{idPembelian}")
    public String deletePembelianSubmit(
            @PathVariable Long idPembelian,
            Model model
    ){

            PembelianModel pembelian = pembelianService.getPembelianByIdPembelian(idPembelian);
            pembelianService.deletePembelian(pembelian);
            model.addAttribute("pembelian", pembelian);
            model.addAttribute("pembelian2", pembelian.getNoInvoice());
            return "hapus-pembelian";
    }

    @GetMapping(value="/pembelian/cari")
    public String displayPembelianByMemberDanTipeFormPage(
            @ModelAttribute MemberModel member,
            Model model
    ){
        List<MemberModel> listMember = memberService.getListMember();
        model.addAttribute("listMember", listMember);
        return "form-display-pembelian-by-member-tipe";
    }

    @GetMapping(value="/cari/pembelian")
    public String displayPembelianByMemberDanTipeSubmitPage(
            @RequestParam Long idMember,
            @RequestParam int tipePembayaran,
            @ModelAttribute MemberModel member,
            Model model) {
        List<PembelianModel> listPembelian = pembelianService.getListPembelian();
        ArrayList<PembelianModel> listPembelianFinal = new ArrayList<>();
        for (PembelianModel i : listPembelian){
            if (i.get_id_of_member() == idMember && i.get_id_of_metode_bayar() == tipePembayaran){
                listPembelianFinal.add(i);
            }
        }
        List<MemberModel> listMember = memberService.getListMember();
        model.addAttribute("listMember", listMember);

        model.addAttribute("listPembelianFinal", listPembelianFinal);
        return "display-pembelian-by-member-tipe";
    }
}
