package wxgaly.springboot.vue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import wxgaly.springboot.vue.mapper.UserMapper;
import wxgaly.springboot.vue.pojo.User;
import wxgaly.springboot.vue.service.UserService;
import wxgaly.springboot.vue.utils.StringUtil;

import java.util.List;


/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author WXGALY
 * @Date 2018-05-22 23:58
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser(User user) throws Exception {

//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        userMapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser(User user) {
//		userMapper.updateByPrimaryKeySelective(user);
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUser(String userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User queryUserById(String userId) {

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> queryUserList(User user) {

        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtil.isEmpty(user.getUsername())) {
//			criteria.andEqualTo("username", user.getUsername());
            criteria.andLike("username", "%" + user.getUsername() + "%");
        }

        if (!StringUtil.isEmpty(user.getNickname())) {
            criteria.andLike("nickname", "%" + user.getNickname() + "%");
        }

        List<User> userList = userMapper.selectByExample(example);

        return userList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUserTransactional(User user) {

        userMapper.insert(user);

        int a = 1 / 0;

        user.setIsDelete(1);
        userMapper.updateByPrimaryKeySelective(user);
    }

}
