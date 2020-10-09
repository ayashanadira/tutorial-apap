package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class KamarController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

    @GetMapping("/kamar/add/{idHotel}")
    public String addKamarFormPage(@PathVariable Long idHotel, Model model){
        KamarModel kamar = new KamarModel();
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        kamar.setHotel(hotel);
        model.addAttribute("kamar", kamar);
        return "form-add-kamar";
    }

    @PostMapping("/kamar/add")
    public String addKamarSubmit(@ModelAttribute KamarModel kamar, Model model){
        kamarService.addKamar(kamar);
        model.addAttribute("kamar", kamar);
        return "add-kamar";
    }

    @GetMapping("/kamar/change/{noKamar}")
    public String changeKamarForm(@PathVariable Long noKamar, Model model){
        KamarModel kamar = kamarService.getKamarByNoKamar(noKamar);
        model.addAttribute("kamar", kamar);
        return "form-change-kamar";
    }

    @PostMapping("/kamar/change")
    public String changeKamarSubmit(@ModelAttribute KamarModel kamar, Model model){
        KamarModel updatedKamar = kamarService.updateKamar(kamar);
        model.addAttribute("kamar", kamar);
        return "add-kamar";
    }
    @GetMapping("/kamar/delete/{noKamar}")
    public String deleteKamarSubmit(@PathVariable Long noKamar, Model model){
        kamarService.deleteKamar(kamarService.getKamarByNoKamar(noKamar));
        return "delete-kamar";
    }
}
