package POJOS;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeSuccessResponse {
    @JsonProperty("message")
    private String message ;

    @JsonProperty("employeeId")
    private String employeeId ;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
