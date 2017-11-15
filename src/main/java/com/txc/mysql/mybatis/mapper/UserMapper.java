package com.txc.mysql.mybatis.mapper;

import com.txc.mysql.mybatis.domain.User;
import org.apache.ibatis.annotations.Select;

/**
 * Created by tanxiaocan on 2017/11/3.
 */
public interface UserMapper {
    @Select("select uid,account_name as accountName,head_url as headUrl from user where uid=#{0}")
    User getUserByUid(long uid);
}
