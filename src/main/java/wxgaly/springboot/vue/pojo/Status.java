package wxgaly.springboot.vue.pojo;

/**
 * wxgaly.springboot.vue.pojo.Status
 *
 * @author Created by WXG on 2018/7/6 006 14:37.
 * @version V1.0
 */

public enum Status {

    /**
     *正常
     */
    OK(0),

    /**
     * 未知异常
     */
    EXECPTION(10000),

    /**
     * 用户名或密码错误
     */
    USERNAME_OR_PASSWORD_ERROR(10001),

    /**
     * 用户名重复
     */
    USERNAME_IS_REPEAT(10002),

    /**
     * 用户名密码为空
     */
    USERNAME_OR_PASSWORD_IS_NULL(10003),
    ;

    private int code;

//    public static final int USERNAME_OR_PASSWORD_ERROR = 10001;

    Status(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
