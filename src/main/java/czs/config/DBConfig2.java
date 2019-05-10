package czs.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * 将application.properties配置文件中配置自动封装到实体类字段中
 * @author Administrator
 */
@Data
@ConfigurationProperties(prefix = "spring.datasource.test2")// 注意这个前缀要和application.yml文件的前缀一样
public class DBConfig2 {
    //@Value("${spring.datasource.test2.jdbcurl}")
    //@Value("${jdbcurl}")
    //private String url;
    private String jdbcurl;
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