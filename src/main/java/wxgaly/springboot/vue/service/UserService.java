package wxgaly.springboot.vue.service;


import wxgaly.springboot.vue.pojo.User;

import java.util.List;

public interface UserService {

    public void saveUser(User user) throws Exception;

    public void updateUser(User user);

    public void deleteUser(String userId);

    public User queryUserById(String userId);

    public List<User> queryUserList(User user);

    public void saveUserTransactional(User user);
}