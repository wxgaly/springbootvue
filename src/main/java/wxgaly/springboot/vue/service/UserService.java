package wxgaly.springboot.vue.service;


import wxgaly.springboot.vue.pojo.User;

import java.util.List;

public interface UserService {

    public void saveUser(User user) throws Exception;

    public void updateUser(User user);

    public void deleteUser(String userId);

    public User queryUserById(String userId);

    public User queryUserByUsername(String username);

    public User queryUserByUsernameAndPassword(String username, String password);

    public List<User> queryUserList(User user);

    public void saveUserTransactional(User user);
}