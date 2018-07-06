package wxgaly.springboot.vue.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import wxgaly.springboot.vue.pojo.JSONResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * wxgaly.springboot.vue.exception.ExceptionHandler
 *
 * @author Created by WXG on 2018/7/5 22:54.
 * @version V1.0
 */

@ControllerAdvice
public class ExceptionHandler {

    public static final String ERROR_VIEW = "err";

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object errorHandler(HttpServletRequest reqest,
                               HttpServletResponse response, Exception e) throws Exception {

        e.printStackTrace();

//        if (isAjax(reqest)) {
        return JSONResult.errorException(e.getMessage() + "----url: " + reqest.getRequestURL());
//        } else {
//            ModelAndView mav = new ModelAndView();
//            mav.addObject("exception", e);
//            mav.addObject("url", reqest.getRequestURL());
//            mav.setViewName(ERROR_VIEW);
//            return mav;
//        }
    }

    public static boolean isAjax(HttpServletRequest httpRequest) {
        return (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest"
                .equals(httpRequest.getHeader("X-Requested-With").toString()));
    }

}
