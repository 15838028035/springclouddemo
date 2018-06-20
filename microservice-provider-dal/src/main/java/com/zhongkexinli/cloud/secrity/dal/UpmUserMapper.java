package com.zhongkexinli.cloud.secrity.dal;

import java.util.List;

import com.zhongkexinli.micro.serv.common.bean.secrity.UpmUser;

public interface UpmUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UpmUser record);

    int insertSelective(UpmUser record);

    UpmUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UpmUser record);

    int updateByPrimaryKey(UpmUser record);
    
    /**
     * 根据条件查询列表
     *
     * @param example
     */
    List<UpmUser> selectByExample(UpmUser upmUser);
}