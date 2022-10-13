package POJOS;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeAddress {

    @JsonProperty("country")
    private String country ;

    @JsonProperty("district")
    private String district ;

    @JsonProperty("pincode")
    private int pincode ;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }
}
