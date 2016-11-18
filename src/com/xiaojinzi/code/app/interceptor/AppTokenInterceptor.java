package com.xiaojinzi.code.app.interceptor;

import com.xiaojinzi.code.app.DefultConstant;
import com.xiaojinzi.code.app.util.ResponseUtil;
import com.xiaojinzi.code.modular.user.pojo.User;
import com.xiaojinzi.code.modular.user.service.UserService;
import com.xiaojinzi.code.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 令牌的拦截器<br/>
 * 实现对用户请求的验证,验证不通过返回错误信息
 * 这里对clientToken和userId进行验证和匹配 <br/>
 *
 * @author cxj
 */
public class AppTokenInterceptor implements HandlerInterceptor {

    /**
     * 白名单
     */
    private static final String[] uris = new String[]{
            "/code/app/user/login",
            "/code/app/user/register"
    };

    @Autowired
    UserService userService;


    /**
     * 再请求被处理之前进行对请求的预处理,过滤掉一些恶意请求
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param controller          处理请求的控制器
     * @return
     * @throws Exception 可能抛出的异常
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object controller) throws Exception {

        //获取到访问的路径
        String requestURI = httpServletRequest.getRequestURI();

        for (int i = 0; i < uris.length; i++) {
            //白名单的路径
            String uri = uris[i];
            if (uri.equals(requestURI))
                return true;
        }

        //拿到token和userId
        String clientToken = httpServletRequest.getParameter(DefultConstant.USERCLIENTTOKEN_FLAG);
        String strUserId = httpServletRequest.getParameter(DefultConstant.CLIENTUSERID_FLAG);

        //如果token或者userId没有,就不响应
        if (!StringUtil.isEmpty(clientToken) && !StringUtil.isEmpty(strUserId)) {
            Integer userId = null;
            try {
                userId = Integer.parseInt(strUserId);
            } catch (Exception e) {
            }
            if (userId != null && userId > 0) {
                //拿到对象
                User user = userService.queryById(userId);
                if (user != null) {
                    if (clientToken.equals(user.getClientToken())) {
                        httpServletRequest.setAttribute(DefultConstant.CLIENT_USER_FLAG, user);
                        return true;
                    }
                }
            }
        }

        //返回错误信息
        ResponseUtil.setMsgInfo(false, "token无效", null, null, httpServletResponse);

        return false;

    }

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
    }

}
