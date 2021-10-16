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
public class MemberController {

    @Qualifier("memberServiceImpl")
    @Autowired
    private MemberService memberService;

    @GetMapping("/member")
    public String listMember(Model model){
        List<MemberModel> listMember = memberService.getListMember();
        model.addAttribute("listMember", listMember);
        return "viewall-member";
    }

    @GetMapping("/member/tambah")
    public String addMemberFormPage(Model model){
        model.addAttribute("member", new MemberModel());
        return "form-tambah-member";
    }

    @PostMapping("/member/tambah")
    public String addMemberSubmitPage(
            @ModelAttribute MemberModel member,
            Model model
    ){
        memberService.addMember(member);
        model.addAttribute("member", member.getIdMember());
        return "tambah-member";
    }

    @GetMapping("/member/ubah/{idMember}")
    public String updateMemberFormPage(
            @PathVariable Long idMember,
            Model model
    ){
        MemberModel member = memberService.getMemberByIdMember(idMember);
        model.addAttribute("member", member);
        return "form-update-member";
    }

    @PostMapping("/member/ubah")
    public String updateBarangSubmitPage(
            @ModelAttribute MemberModel member,
            Model model
    ){
        MemberModel updatedMember = memberService.updateMember(member);
        model.addAttribute("member", updatedMember.getNamaMember());
        return "update-member";
    }
}
