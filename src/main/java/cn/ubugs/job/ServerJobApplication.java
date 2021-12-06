package cn.ubugs.job;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 设置扫描Mapper持久层路径
@MapperScan("cn.ubugs.job.mapper")
@SpringBootApplication
public class ServerJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerJobApplication.class, args);
    }

}
