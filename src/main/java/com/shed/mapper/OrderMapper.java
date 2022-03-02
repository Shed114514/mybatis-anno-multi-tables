package com.shed.mapper;

import com.shed.domain.Member;
import com.shed.domain.Order;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {

    @Select("SELECT * FROM t_order WHERE mid=#{mid}")
    Order selectByMid(Integer mid);

    @Select("SELECT * FROM t_order")
    @Results({
            @Result(id = true,column = "oid",property = "oid"),
            @Result(column = "ordertime",property = "ordertime"),
            @Result(column = "total",property = "total"),
            @Result(column = "mid",property = "member",
                    javaType = Member.class,
                    one = @One(select = "com.shed.mapper.MemberMapper.selectByPrimaryKey")),
    })
    List<Order> selectOrderAndMember();
}
