package wxgaly.springboot.vue.pojo;

/**
 * wxgaly.springboot.vue.pojo.User
 *
 * @author Created by WXG on 2018/7/3 003 13:53.
 * @version V1.0
 */

public class User {

    private String username;

    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
