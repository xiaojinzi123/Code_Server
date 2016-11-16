package com.xiaojinzi.code.app.interceptor;

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
        //目前先不拦截任何一个请求,都放过去
        return true;
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
