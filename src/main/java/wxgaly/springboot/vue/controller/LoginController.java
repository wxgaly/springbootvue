package wxgaly.springboot.vue.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wxgaly.springboot.vue.pojo.JSONResult;
import wxgaly.springboot.vue.pojo.Status;
import wxgaly.springboot.vue.pojo.User;
import wxgaly.springboot.vue.service.UserService;
import wxgaly.springboot.vue.utils.IpUtil;
import wxgaly.springboot.vue.utils.JsonUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * wxgaly.springboot.vue.controller.LoginController
 *
 * @author Created by WXG on 2018/7/3 003 13:49.
 * @version V1.0
 */
@RestController
@RequestMapping(value = "/api")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    String login(HttpServletRequest request, User user) {//@RequestBody
        logger.info(user.toString());

        JSONResult result;

        User queryUser = userService.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
        // 判断用户名密码是否正确，匹配
        if (queryUser != null) {

            //记录登录ip地址以及登录时间
            //request,response还可以通过以下两种方式获取
            //ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            //HttpServletRequest request = requestAttributes.getRequest();
            //HttpServletResponse response = requestAttributes.getResponse();
            String ipAddr = IpUtil.getIpAddr(request);
            Date loginDate = new Date();
            queryUser.setLastLoginIp(ipAddr);
            queryUser.setLastLoginTime(loginDate);

            userService.updateUser(queryUser);
            result = JSONResult.ok(queryUser);
        } else {
            result = JSONResult.errorMessage(Status.USERNAME_OR_PASSWORD_ERROR.getCode(), "用户名或密码错误!");
        }

        return JsonUtils.objectToJson(result);
    }

//    @RequestMapping(value = "/login1", method = RequestMethod.POST)
//    User login1(@RequestBody User user) {
//        System.out.println(user.toString());
//        return user;
//    }

}
