package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.HotelService;
import apap.tutorial.traveloke.service.KamarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//
@Controller
public class HotelController {
    @Qualifier("hotelServiceImpl")
    @Autowired
    private HotelService hotelService;

    @Autowired
    private KamarService kamarService;

//    @GetMapping("/")
//    private String home(){
//        return "home";
//    }

    @GetMapping("/hotel/add")
    public String addHotelFormPage(Model model){
        model.addAttribute("hotel", new HotelModel());
        return "form-add-hotel";
    }

    @PostMapping("/hotel/add")
    public String addHotelSubmit(@ModelAttribute HotelModel hotel, Model model){
        hotelService.addHotel(hotel);
        model.addAttribute("idHotel", hotel.getId());
        return "add-hotel";
    }

    @GetMapping("/hotel/change/{idHotel}")
    public String changeHotelFormPage(@PathVariable Long idHotel, Model model){
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        model.addAttribute("hotel", hotel);
        return "form-update-hotel";
    }

    @PostMapping("/hotel/change")
    public String changeHotelFormSubmit(@ModelAttribute HotelModel hotel, Model model){
        HotelModel hotelUpdated = hotelService.updateHotel(hotel);
        model.addAttribute("hotel", hotel);
        return "update-hotel";
    }

    @GetMapping("/hotel/delete/{idHotel}")
    public String deleteHotelSubmit(@PathVariable Long idHotel, Model model){
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(idHotel);
        if (listKamar.isEmpty()) {
            hotelService.deleteHotel(hotel);
            return "delete-hotel";
        }
        return "delete-failed";
    }

    @GetMapping("/hotel/view")
    public String viewDetailHotel(@RequestParam(value = "idHotel") Long idHotel, Model model) {
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        if (hotel == null) {
            return "hotel-not-found";
        }
        List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(idHotel);
        boolean hasKamar = listKamar.size() > 0;
        model.addAttribute("hotel", hotel);
        model.addAttribute("hasKamar", hasKamar);
        model.addAttribute("listKamar", listKamar);
        return "view-hotel";
    }


    @RequestMapping("/hotel/viewall")
    public String listHotel(Model model){
        //Mendapatkan semua HotelModel
        List<HotelModel> listHotel = hotelService.viewAllHotelDesc();

        // Add variabel semua HotelModel ke 'listHotel' untuk di render pada thymeleaf
        model.addAttribute("listHotel", listHotel);

        // Return view template yang diinginkan
        return "viewall-hotel";
    }

}