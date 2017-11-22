package com.txc.mysql.mybatis.mapper;

import com.txc.mysql.mybatis.domain.User;
import org.apache.ibatis.annotations.Select;

/**
 * Created by tanxiaocan on 2017/11/3.
 */
public interface UserMapper {
    @Select("select uid,account_name,head_url from user where uid=#{param1} and status=#{param2}")
    User getUserByUid(long uid,Integer status);
}
