
package czs.mapper2;

import czs.mapper1.UserMapper1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author czs
 * @version
 */
@Service
public class ManyService2 {

    @Autowired
    private UserMapper2 userMapper2;

    @Transactional(transactionManager = "test2TransactionManager",rollbackFor = Exception.class)
    public int insert(String name, Integer age) {
        int i = userMapper2.insert(name, age);
        System.out.println("userMapper2.insert结束~ :" + null);
        int a = 1 / 0;//手动异常
        return i;
    }

}