package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.repository.KamarDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class KamarRestServiceImpl implements KamarRestService{

    @Autowired
    private KamarDb kamarDb;

    @Override
    public KamarModel createKamar(KamarModel kamar){
        return kamarDb.save(kamar);
    }
    @Override
    public List<KamarModel> retrieveAllKamar(){
        return kamarDb.findAll();
    }

    @Override
    public KamarModel getKamarByNoKamar(Long noKamar){
        Optional<KamarModel> kamar = kamarDb.findByNoKamar(noKamar);
        if(kamar.isPresent()){
            return kamar.get();
        }
        else{
            throw new NoSuchElementException();
        }
    }

    @Override
    public KamarModel changeKamar(Long noKamar, KamarModel kamarUpdate){
        KamarModel kamar = getKamarByNoKamar(noKamar);
        kamar.setNamaKamar(kamarUpdate.getNamaKamar());
        kamar.setHotel(kamarUpdate.getHotel());
        kamar.setTipe(kamarUpdate.getTipe());
        kamar.setKapasitasKamar(kamarUpdate.getKapasitasKamar());
        return kamarDb.save(kamar);
    }

    @Override
    public void deleteKamar(Long noKamar){
        KamarModel kamar = kamarDb.findByNoKamar(noKamar).get();
        kamarDb.delete(kamar);
    }
}
