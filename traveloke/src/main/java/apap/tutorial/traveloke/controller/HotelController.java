package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.HotelModel;
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