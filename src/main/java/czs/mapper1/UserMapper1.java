package czs.mapper1;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import czs.entity.User;

public interface UserMapper1 {
    // 查询语句
    @Select("SELECT * FROM users WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    // 添加
    @Insert("INSERT INTO users(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);
}
