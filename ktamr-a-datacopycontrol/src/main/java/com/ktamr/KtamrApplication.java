package com.ktamr;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;


@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@MapperScan("com.ktamr.mapper")
public class KtamrApplication {

    public static void main(String args[]){

        SpringApplication.run(KtamrApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  自动抄表管理系统启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
