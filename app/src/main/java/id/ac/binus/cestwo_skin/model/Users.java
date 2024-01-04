package id.ac.binus.cestwo_skin.model;

public class Users {
    private String name;
    private String password;

    public Users(String name, String email, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
