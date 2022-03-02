package com.shed.mapper;

import com.shed.domain.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM t_user")
    @Results({
            @Result(id = true,column = "uid",property = "uid"),
            @Result(column = "name",property = "name"),
            @Result(column = "age",property = "age"),
            @Result(column = "password",property = "password"),
            @Result(column = "uid",property = "roleList",
                    javaType = List.class,
                    many = @Many(select = "com.shed.mapper.RoleMapper.selectByUid"))
    })
    List<User> selectUsersAndRoles();

}
