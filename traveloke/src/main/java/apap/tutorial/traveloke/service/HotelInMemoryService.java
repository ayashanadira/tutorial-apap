package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class HotelInMemoryService implements HotelService{

    private List<HotelModel> listHotel;

    public HotelInMemoryService() {
        listHotel = new ArrayList<>();
    }

    @Override
    public void addHotel(HotelModel hotel){
        listHotel.add(hotel);
    }

    @Override
    public List<HotelModel> getHotelList(){
        return listHotel;
    }

    @Override
    public HotelModel getHotelByIdHotel(String idHotel){
        List<HotelModel> listy = getHotelList();
        for (int i = 0; listy.size() > i; i++){
            if (listy.get(i).getIdHotel().equalsIgnoreCase(idHotel)) {
                return listy.get(i);
            }
        }
        return null;
    }

    @Override
    public int deleteHotelByIdHotel(String idHotel){
        List<HotelModel> listy = getHotelList();
        for (int i = 0; listy.size() > i; i++){
            if (listy.get(i).getIdHotel().equalsIgnoreCase(idHotel)) {
                listy.remove(i);
                // 1 menandakan bahwa hotel dengan idHotel berhasil ditemukan dan dihapus
                return 1;
            }
        }
        //0 menandakan bahwa hotel dengan idHotel tidak dapat ditemukan
        return 0;
    }




}
