package POJOS;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeRequestBody {

    @JsonProperty("firstName")
    private String firstName ;

    @JsonProperty("lastName")
    private String lastName ;

    @JsonProperty("designation")
    private String designation ;

    @JsonProperty("address")
    private EmployeeAddress address ;

    public EmployeeAddress getAddress() {
        return address;
    }

    public void setAddress(EmployeeAddress address) {
        this.address = address;
    }

    @JsonProperty("yearsOfExperience")
    private int yearsOfExperience ;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }



    }





