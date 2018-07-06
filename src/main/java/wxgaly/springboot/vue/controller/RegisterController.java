package wxgaly.springboot.vue.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import wxgaly.springboot.vue.pojo.JSONResult;
import wxgaly.springboot.vue.pojo.Status;
import wxgaly.springboot.vue.pojo.User;
import wxgaly.springboot.vue.service.UserService;
import wxgaly.springboot.vue.utils.JsonUtils;
import wxgaly.springboot.vue.utils.StringUtil;

import java.util.Date;

/**
 * wxgaly.springboot.vue.controller.RegisterController
 *
 * @author Created by WXG on 2018/7/5 005 15:04.
 * @version V1.0
 */

@RestController
@RequestMapping(value = "/api")
public class RegisterController {

    private final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/queryUser", method = RequestMethod.GET)
    String queryUser(String id) {
        return JsonUtils.objectToJson(userService.queryUserById(id));
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    String registerUser(User user) {
        logger.info(user.toString());
        // 判断用户名密码是否为空
        if (StringUtil.isEmpty(user.getUsername()) || StringUtil.isEmpty(user.getPassword())) {
            return JsonUtils.objectToJson(JSONResult.errorMessage(Status.USERNAME_OR_PASSWORD_IS_NULL.getCode(),
                    "用户名或者密码为空!"));
        } else {
            // 判断用户名是否已存在
            if (userService.queryUserByUsername(user.getUsername()) != null) {
                return JsonUtils.objectToJson(JSONResult.errorMessage(Status.USERNAME_IS_REPEAT.getCode(), "用户名已存在"));
            } else {
                //成功创建用户
                User newUser = new User();
                newUser.setId(String.valueOf(System.currentTimeMillis()));
                newUser.setUsername(user.getUsername());
                newUser.setPassword(user.getPassword());
                newUser.setRegisterTime(new Date());
                newUser.setIsDelete(0);

                logger.info("create user success ---- " + newUser.toString());
                userService.saveUserTransactional(newUser);
                return JsonUtils.objectToJson(userService.queryUserByUsername(user.getUsername()));
            }

        }
    }

}
