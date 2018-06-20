package com.zhongkexinli.cloud.secrity.service;

import java.util.List;
import java.util.Map;

import com.zhongkexinli.micro.serv.common.bean.secrity.SecGroups;
import com.zhongkexinli.micro.serv.common.msg.LayUiTableResultResponse;
import com.zhongkexinli.micro.serv.common.pagination.Query;


public interface SecGroupsService  {
	
	List<Map<String, Object>> selectGrouInfoByLogin(String login);
	
	

    int deleteByPrimaryKey(Integer id);

    int insert(SecGroups secGroups);

    int insertSelective(SecGroups secGroups);

    SecGroups selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SecGroups secGroups);

    int updateByPrimaryKey(SecGroups secGroups);

    public LayUiTableResultResponse	 selectByQuery(Query query) ;
    
   public  List<SecGroups> selectByExample(Query query);
   
    public List<Map<String, Object>> selectByInfoKey(Integer id);



	List<Map<String, Object>> selectByInfoKeyData();



	void updateByPrimaryKeySelective(Integer id, List<String> urlId,String remarks,String groupName);



	void addByPrimaryKeySelective(SecGroups secGrops, List<String> urids,Integer gid);

	
}
