package com.example.demo.controller;

import com.example.demo.repo.PasienRepo;
import com.example.demo.entity.Pasien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;

@Controller
public class WebController {
    
    @Autowired
    private PasienRepo psnRepo;
	
    @RequestMapping("/daftar-pasien")
    public void daftarPasien(Model model) {
        model.addAttribute("daftarPasien", 
                psnRepo.findAll());
    }

     @RequestMapping("/tambah-data")
     public void tambahData(
     	@ModelAttribute("psn") Pasien psn,
     	BindingResult result) {}

     @RequestMapping(value = "/tambah-data",
     	method = RequestMethod.POST) 
     public String simpanDataBaru(
     		@ModelAttribute("psn") Pasien psn,
     		BindingResult result) {
     	System.out.println(psn.getId());
     	psnRepo.save(psn);
 	return "redirect:/daftar-pasien";
}

     @RequestMapping("/edit")
     public void getEditForm(
     		@RequestParam("id") String id, 
     		Model model) {
     	Pasien result = psnRepo.findOne(id);
     	model.addAttribute("psn", result);
     }

     @RequestMapping(value = "/edit", method = RequestMethod.POST)
     public String simpanEditData(
     		@ModelAttribute("psn") Pasien psn,
     		BindingResult result) {
     	System.out.println("id : " + psn.getId());
     	psnRepo.save(psn);
     	return "redirect:/daftar-pasien";
     }
    
     @RequestMapping("/hapus")
     public String hapusData(@RequestParam("id") String id) {
         psnRepo.delete(id);
         return "redirect:/daftar-pasien";
     }
    
}
