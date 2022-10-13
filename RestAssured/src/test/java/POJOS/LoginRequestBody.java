package POJOS;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequestBody {

    @JsonProperty("email")
    private String email ;
    @JsonProperty("password")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
