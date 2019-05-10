/*

package czs.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

*/
/**
 * 读取DataSource01数据源
 * 配置数据源、事务管理器。。。非常重要的一步，也是这个来分配数据源给哪些类包的
 * 注意类中@MapperScan注解中的basePackages的内容！
 * 第4步说过注意前缀，就是在下面的@ConfigurationProperties(prefix = "spring.datasource.test1")中，是根据这个来选择数据源的
 *//*

// DataSource01
@Configuration // 注册到springboot容器中
@MapperScan(basePackages = "czs.mapper1", sqlSessionFactoryRef = "test1SqlSessionFactory")
public class DataSource1Config {

    */
/**
     * @methodDesc: 功能描述:(配置test01数据库)
     *//*

    @Bean(name = "test1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    */
/**
     * @methodDesc: 功能描述:(test1 sql会话工厂)
     *//*

    @Bean(name = "test1SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test1DataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // bean.setMapperLocations(
        // new
        // PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/test1/*.xml"));
        return bean.getObject();
    }

    */
/**
     * @methodDesc: 功能描述:(test1 事物管理)
     *//*

    @Bean(name = "test1TransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("test1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "test1SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("test1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
*/
