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

    @GetMapping("/")
    private String home(){
        return "home";
    }

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
    public String viewDetailHotel(@RequestParam(value = "idHotel") Long idHotel, Model model){
=======
import org.springframework.ui.Model;
import apap.tutorial.traveloke.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HotelController {
    @Autowired
    private HotelService hotelService;

    //Routing URL yang diinginkan
    @RequestMapping("/hotel/add")
    public String addHotel(
            //Request parameter yang ingin dibawa
            @RequestParam(value= "idHotel", required = true) String idHotel,
            @RequestParam(value= "namaHotel", required = true) String namaHotel,
            @RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "noTelepon", required = true) String noTelepon,
            Model model
    ) {
        // Membuat objek HotelModel
        HotelModel hotel = new HotelModel(idHotel, namaHotel, alamat, noTelepon);

        // Memanggil service addHotel
        hotelService.addHotel(hotel);

        // Add variabel id hotel ke 'idHotel' untuk dirender pada thymeleaf
        model.addAttribute("idHotel", idHotel);

        //Return view template yang digunakan
        return "add-hotel";
    }

    @RequestMapping("/hotel/viewall")
    public String listHotel(Model model){
        //Mendapatkan semua HotelModel
        List<HotelModel> listHotel = hotelService.getHotelList();

         // Add variabel semua HotelModel ke 'listHotel' untuk di render pada thymeleaf
        model.addAttribute("listHotel", listHotel);

        // Return view template yang diinginkan
        return "viewall-hotel";
    }

    @RequestMapping("/hotel/view")
    public String detailHotel(
            @RequestParam(value = "idHotel") String idHotel, Model model){

        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        if (hotel == null){
            return "hotel-not-found";
        }
        // Add variabel HotelModel ke 'hotel' untuk di render pada thymeleaf
        model.addAttribute("hotel", hotel);

        // Return view template yang diinginkan
        return "view-hotel";
    }
    @GetMapping(value = "/hotel/view/id-hotel/{idHotel}")
    public String detailHotelPathVar(@PathVariable String idHotel, Model model){

        //Mendapatkan HotelModel sesuai idHotel
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        if (hotel == null){
            return "hotel-not-found";
        }

        List<KamarModel> listKamar = kamarService.findAllKamarByIdHotel(idHotel);
        model.addAttribute("hotel", hotel);
        if (listKamar.isEmpty()) {
            return "view-hotel-no-kamar";
        }
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

        // Add variabel HotelModel ke 'hotel' untuk di render pada thymeleaf
        model.addAttribute("hotel", hotel);

        return "view-hotel";
    }

    @GetMapping(value = "/hotel/update/id-hotel/{idHotel}/no-telepon/{noTelepon}")
    public String updateTelepon(
            @PathVariable String idHotel,
            @PathVariable String noTelepon, Model model){

        //Mendapatkan HotelModel sesuai idHotel
        HotelModel hotel = hotelService.getHotelByIdHotel(idHotel);
        if (hotel == null){
            return "hotel-not-found";
        }
        hotel.setNoTelepon(noTelepon);

        // Add variabel HotelModel ke 'hotel' untuk di render pada thymeleaf
        model.addAttribute("hotel", hotel);

        return "update-phone-hotel";
    }

    @GetMapping(value = "/hotel/delete/id-hotel/{idHotel}")
    public String deleteHotel(@PathVariable String idHotel, Model model){

        int deletion = hotelService.deleteHotelByIdHotel(idHotel);
        if (deletion == 0)
            return "hotel-not-found";
        return "delete-success";
    }
}

