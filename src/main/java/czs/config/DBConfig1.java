package czs.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * 将application.properties配置文件中配置自动封装到实体类字段中
 * @author Administrator
 */
@Data
@ConfigurationProperties(prefix = "spring.datasource.test1") // 注意这个前缀要和application.yml文件的前缀一样
public class DBConfig1 {
   // @Value("${mysql.datasource.test1.jdbcurl}")
   //@Value("${jdbcurl}")
    private String jdbcurl;
    //private String url;
    // 比如这个url在properties中是这样子的mysql.datasource.test1.username = root
    private String username;
    private String password;
    private int minPoolSize;
    private int maxPoolSize;
    private int maxLifetime;
    private int borrowConnectionTimeout;
    private int loginTimeout;
    private int maintenanceInterval;
    private int maxIdleTime;
    private String testQuery;
}
