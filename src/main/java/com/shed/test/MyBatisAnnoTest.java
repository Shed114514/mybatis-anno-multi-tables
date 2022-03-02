package com.shed.test;

import com.shed.domain.Member;
import com.shed.domain.Order;
import com.shed.domain.User;
import com.shed.mapper.MemberMapper;
import com.shed.mapper.OrderMapper;
import com.shed.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisAnnoTest {

    private OrderMapper orderMapper;
    private MemberMapper memberMapper;
    private UserMapper userMapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMappingConfig.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sessionFactory.openSession(true);
        orderMapper = sqlSession.getMapper(OrderMapper.class);
        memberMapper = sqlSession.getMapper(MemberMapper.class);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    // 一对一查询
    @Test
    public void testSelectOrderAndMember() {
        List<Order> orderList = orderMapper.selectOrderAndMember();
        for (Order order : orderList) {
            System.out.println(order);
        }
    }

    // 一对多查询
    @Test
    public void testSelectMemberAndOrders() {
        List<Member> memberList = memberMapper.selectMemberAndOrders();
        for (Member member : memberList) {
            System.out.println(member);
        }
    }

    // 多对多查询
    @Test
    public void testSelectUsersAndRoles() {
        List<User> userList = userMapper.selectUsersAndRoles();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
