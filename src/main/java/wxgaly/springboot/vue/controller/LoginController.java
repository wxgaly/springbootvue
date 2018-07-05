package wxgaly.springboot.vue.controller;

import org.springframework.web.bind.annotation.*;
import wxgaly.springboot.vue.pojo.User;
import wxgaly.springboot.vue.utils.JsonUtils;

/**
 * wxgaly.springboot.vue.controller.LoginController
 *
 * @author Created by WXG on 2018/7/3 003 13:49.
 * @version V1.0
 */
@RestController
@RequestMapping(value = "/api")
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    String login(User user) {
        System.out.println(user.toString());
        return JsonUtils.objectToJson(user);
    }

//    @RequestMapping(value = "/login1", method = RequestMethod.POST)
//    User login1(@RequestBody User user) {
//        System.out.println(user.toString());
//        return user;
//    }

}
