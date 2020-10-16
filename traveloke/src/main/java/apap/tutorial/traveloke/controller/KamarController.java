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

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.ArrayList;

@Controller
public class KamarController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

    @GetMapping("/kamar/add/{idHotel}")
    public String addKamarFormPage(@PathVariable Long idHotel, Model model){
        List<KamarModel> temp = new ArrayList<KamarModel>();
        KamarModel kamar = new KamarModel();
        temp.add(kamar);
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        hotel.setListKamar(temp);
        model.addAttribute("hotel", hotel);
        return "form-add-kamar";
    }


    @PostMapping(value = "/kamar/add", params = {"addform"})
    public String addKamarTambahForm(@ModelAttribute HotelModel hotel, Model model){
        if(hotel.getListKamar().size() == 0){
            List<KamarModel> temp = new ArrayList<KamarModel>();
            hotel.setListKamar(temp);
        }
        KamarModel kamar = new KamarModel();
        hotel.getListKamar().add(kamar);
        model.addAttribute("hotel", hotel);
        return "form-add-kamar";
    }

    @PostMapping(value = "/kamar/add", params = {"deleteform"})
    public String addKamarHapusForm(@ModelAttribute HotelModel hotel, Model model, final HttpServletRequest httpreq){
        int noRowForm = Integer.valueOf(httpreq.getParameter("deleteform"));
        hotel.getListKamar().remove(noRowForm);
        model.addAttribute("hotel", hotel);
        return "form-add-kamar";
    }

    @PostMapping(value = "/kamar/add", params = {"simpan"})
    public String addMultiKamarSubmit(@ModelAttribute HotelModel hotel, Model model){
        for (KamarModel kamar : hotel.getListKamar()){
            kamar.setHotel(hotel);
            kamarService.addKamar(kamar);
        }
        model.addAttribute("kamarCount", hotel.getListKamar().size());
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
        return "change-kamar";
    }

    @PostMapping("/kamar/delete")
    public String deleteKamarFormSubmit(@ModelAttribute HotelModel hotel, Model model){
        model.addAttribute("kamarCount", hotel.getListKamar().size());
        for(KamarModel kamar : hotel.getListKamar()){
            kamarService.deleteKamar(kamar);
        }
        return "delete-kamar";
    }
}
