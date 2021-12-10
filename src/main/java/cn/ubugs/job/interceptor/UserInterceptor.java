package cn.ubugs.job.interceptor;


import cn.ubugs.job.domain.Role;
import cn.ubugs.job.domain.UserWithRoleWithInfo;
import cn.ubugs.job.resp.ReturnCode;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class UserInterceptor implements HandlerInterceptor {
    @Resource
    HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取session中的userInfo,判断用户是否登录
        UserWithRoleWithInfo userInfo = (UserWithRoleWithInfo) session.getAttribute("userInfo");
        if (userInfo == null) {
            JSONObject json = new JSONObject();
            json.put("status", ReturnCode.RC60000.getCode());
            json.put("message", ReturnCode.RC60000.getMsg());
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().write(json.toString());
            return false;
        }
        // 进行权限校验
        Auth auth = ((HandlerMethod) handler).getMethod().getAnnotation(Auth.class);
        if (auth == null) {
            // 未配置权限注解,进行跳过
            return true;
        }
        // 从参数中取出用户身份
        String permissions = auth.permissions();
        Role role = userInfo.getRole();
        if (permissions.equals("admin")) {
            // 管理员权限校验
            if (!(role.getId() == 1)) {
                JSONObject json = new JSONObject();
                json.put("status", ReturnCode.RC60001.getCode());
                json.put("message", ReturnCode.RC60001.getMsg());
                response.setContentType("application/json; charset=utf-8");
                response.getWriter().write(json.toString());
                return false;
            }
        } else if (permissions.equals("user")) {
            System.out.println(role.getId());
            System.out.println(!(role.getId() <= 2));
            // 用户权限校验
            if (!(role.getId() <= 2)) {
                JSONObject json = new JSONObject();
                json.put("status", ReturnCode.RC60001.getCode());
                json.put("message", ReturnCode.RC60001.getMsg());
                response.setContentType("application/json; charset=utf-8");
                response.getWriter().write(json.toString());
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
