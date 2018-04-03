public class Config {

    private String url = "jdbc:mysql://localhost/adlister_db?useSSL=false&serverTimezone=UTC";
    private String user = "adUser";
    private String password = "codeup";

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
