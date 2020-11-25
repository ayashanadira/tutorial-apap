package apap.tutorial.traveloke.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HotelDetail {
    private String status;

    @JsonProperty("hotel-license")
    private Integer hotelLicense;

    @JsonProperty("valid-until")
    private Date validUntil;

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setHotelLicense(Integer hotelLicense) {
        this.hotelLicense = hotelLicense;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    public Integer getHotelLicense() {
        return hotelLicense;
    }

    public Date getValidUntil() {
        return validUntil;
    }
}