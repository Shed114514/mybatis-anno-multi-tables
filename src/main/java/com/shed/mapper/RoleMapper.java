package com.shed.mapper;

import com.shed.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {

    @Select("SELECT * FROM t_role r,t_user_role ur WHERE r.rid=ur.rid AND ur.uid=#{uid}")
    List<Role> selectByUid(Integer uid);

}
