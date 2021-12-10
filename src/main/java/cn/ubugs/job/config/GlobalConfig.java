package cn.ubugs.job.config;

import cn.ubugs.job.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class GlobalConfig implements WebMvcConfigurer {
    @Resource
    UserInterceptor userInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /* 只拦截user路径下 */
        registry.addInterceptor(userInterceptor)
                .addPathPatterns("/user/**");
    }
}
