package guru_qa.Models;

import lombok.Data;

@Data
public class LoginLombokModels {
    private String email;
    private String password;

    @Override
    public String toString() {
        return "email=" + email + "&password=" + password;
    }
}

