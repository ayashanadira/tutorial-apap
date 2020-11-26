package apap.tutorial.traveloke.restcontroller;
import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.KamarModel;
import apap.tutorial.traveloke.service.KamarRestService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class KamarRestController {

    @Autowired
    private KamarRestService kamarRestService;

    @PostMapping(value = "/kamar")
    private String createKamar(@Valid @RequestBody KamarModel kamar, BindingResult bindingResult) {
        if(bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field"
            );
        } else {
            kamarRestService.createKamar(kamar);
            return "Add kamar success";
        }
    }

    @GetMapping(value = "kamar/{kamarId}")
    private KamarModel retrieveKamar(@PathVariable("kamarId") Long noKamar){
        try{
            return kamarRestService.getKamarByNoKamar(noKamar);
        }
        catch(NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID Kamar "+String.valueOf(noKamar)+" Not Found");
        }
    }

    @DeleteMapping(value = "/kamar/{kamarId}")
    private ResponseEntity<String> deleteKamar(@PathVariable("kamarId") Long noKamar){
        try{
            kamarRestService.deleteKamar(noKamar);
            return ResponseEntity.ok("Kamar has been deleted");
        }
        catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Kamar with ID " + String.valueOf(noKamar) + " Not Found!");
        }
    }

    @PutMapping(value = "/kamar/{kamarId}")
    private ResponseEntity<String>  updateKamar(@PathVariable (value="kamarId") Long noKamar, @RequestBody KamarModel kamar){
        try{
            kamarRestService.changeKamar(noKamar, kamar);
            return ResponseEntity.ok("Update kamar success");
        }
        catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Kamar with ID " + String.valueOf(noKamar) + " Not Found!");
        }
    }

    @GetMapping(value = "/kamar-all")
    private List<KamarModel> retrieveListHotel(){
        return kamarRestService.retrieveAllKamar();
    }

}
