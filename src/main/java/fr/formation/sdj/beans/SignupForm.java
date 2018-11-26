package fr.formation.sdj.beans;

import javax.validation.constraints.NotBlank;

public class SignupForm {

    @NotBlank
    private String login;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
