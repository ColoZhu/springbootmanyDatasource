
package czs.web;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import czs.mapper1.ManyService1;
import czs.mapper2.ManyService2;

/**
 * @author czs
 * @version 创建时间：2018年8月12日 下午9:03:02
 */
@RestController
public class ManyController {

    @Autowired
    private ManyService1 manyService1;

    @Resource
    private ManyService2 manyService2;

    @RequestMapping(value = "datasource1")
    public int datasource1(String name, Integer age) {
        return manyService1.insert(name, age);
    }

    @RequestMapping(value = "datasource2")
    public int datasource2(String name, Integer age) {
        return manyService2.insert(name, age);
    }

    /**
     * @Param:
     * @Description: 这里测试两个service两个数据源的事务(不加上atomikos插件的情况下测试,
     *使用DataSource1Config和DataSource2Config 两个配置类, 关闭DBConfig1, DBConfig2和MyBatisConfig1, MyBatisConfig1两个类)
     * @Author: zyf    2019/5/10
     */
    //http://localhost:8080/manyDatasource/testManyTrans?name=tom4&age=2
    @RequestMapping(value = "testManyTrans")
    public int testManyTrans(String name, Integer age) {
        int i = 0;
        int i1 = manyService1.insert(name, age);
        System.out.println("manyService1.insert :" + i1);

        /*
        第二个事务中会手动造成一个异常~,
        但是第一个事务执行完毕了,保存到了数据库
        */
        int i2 = manyService2.insert(name, age);
        System.out.println("manyService2.insert :" + i2);
        return i;
    }


    /**
     * @Param:
     * @Description: 这里测试使用atomikos插件测试多数据源事务
     * @Author: zyf    2019/5/10
     */
    //http://localhost:8080/manyDatasource/insertDb1AndDb2?name=tom5&age=2
    //http://localhost:8080/manyDatasource/insertDb1AndDb2?name=tom6&age=0  //测试除数为0后的事务管理
    @RequestMapping(value = "insertDb1AndDb2")
    public int insertDb1AndDb2(String name, Integer age) {
        return manyService1.insertDb1AndDb2(name, age);
    }


}
