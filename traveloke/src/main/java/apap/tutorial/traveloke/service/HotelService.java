package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import java.util.List;

public interface HotelService {
    
    // Method untuk menambah hotel
    void addHotel(HotelModel hotel);
    
    // Method untuk mendapatkan daftar hotel yang telah tersimpan
    List<HotelModel> getHotelList();

    // Method untuk mendapatkan data sebuah hotel berdasarkan id hotel
    HotelModel getHotelByIdHotel(Long idHotel);

    // Method untuk update hotel
    HotelModel updateHotel(HotelModel hotel);

    // untuk menampilkan list hotel descending berdasarkan id
    List<HotelModel> viewAllHotelDesc();

    // Method untuk menghapus data sebuah hotel berdasarkan id hotel
    void deleteHotel(HotelModel hotel);
}
