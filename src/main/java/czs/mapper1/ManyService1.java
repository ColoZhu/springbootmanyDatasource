
package czs.mapper1;

import czs.mapper2.UserMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xxx
 * @version
 */
@Service
public class ManyService1 {

    @Autowired
    private UserMapper1 userMapper1;
    @Autowired
    private UserMapper2 userMapper2;

 /*   @Transactional(transactionManager = "test1TransactionManager",rollbackFor = Exception.class)
    public int insert(String name, Integer age) {
        int i = userMapper1.insert(name, age);
        System.out.println("userMapper1.insert结束~ :" + i);
       // int a = 1 / 0;//手动异常
        return i;
    }*/

    // 开启事务，由于使用jta+atomikos解决分布式事务，所以此处不必再指定事务
    @Transactional
    public int insert(String name, Integer age) {
        int insert = userMapper1.insert(name, age);
        //int i = 1 / age;// 赋值age为0故意引发事务
        return insert;
    }

    //http://localhost:8080/manyDatasource/insertDb1AndDb2?name=tom3&age=2
    // 开启事务，由于使用jta+atomikos解决分布式事务，所以此处不必再指定事务
    @Transactional
    public int insertDb1AndDb2(String name, Integer age) {
        int insert = userMapper1.insert(name, age);
        int insert2 = userMapper2.insert(name, age);
        int i = 1 / age;// 赋值age为0故意引发事务
        return insert + insert2;
    }


}