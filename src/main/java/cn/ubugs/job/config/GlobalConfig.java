package cn.ubugs.job.config;

import cn.ubugs.job.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class GlobalConfig implements WebMvcConfigurer {
    @Resource
    UserInterceptor userInterceptor;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedHeaders(CorsConfiguration.ALL)
                .allowedMethods(CorsConfiguration.ALL)
                .allowCredentials(true)
                .maxAge(3600); // 1小时内不需要再预检（发OPTIONS请求）
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /* 只拦截user路径下 */
        registry.addInterceptor(userInterceptor)
                .addPathPatterns("/user/**");
    }
}
