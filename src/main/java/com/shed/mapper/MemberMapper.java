package com.shed.mapper;

import com.shed.domain.Member;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MemberMapper {

    @Select("SELECT * FROM t_member WHERE mid=#{mid}")
    Member selectByPrimaryKey(Integer mid);

    @Select("SELECT * FROM t_member")
    @Results({
            @Result(id = true,column = "mid",property = "mid"),
            @Result(column = "name",property = "name"),
            @Result(column = "age",property = "age"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column = "mid",property = "orderList",
                    javaType = List.class,
                    many = @Many(select = "com.shed.mapper.OrderMapper.selectByMid")
            )
    })
    List<Member> selectMemberAndOrders();

}
