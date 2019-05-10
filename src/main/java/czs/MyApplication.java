package czs;

import czs.config.DBConfig1;
import czs.config.DBConfig2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}, scanBasePackages = {"czs",/*"com.am.ammq",*/})
@EnableScheduling
//开启扫描注册上面的两个配置文件类
@EnableConfigurationProperties(value = {DBConfig1.class, DBConfig2.class})
public class MyApplication extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MyApplication.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
