package com.zhongkexinli.cloud.secrity.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhongkexinli.cloud.secrity.bean.SecGroupsTree;
import com.zhongkexinli.cloud.secrity.constant.SecrityCommonConstant;
import com.zhongkexinli.cloud.secrity.service.SecGroupsService;
import com.zhongkexinli.micro.serv.common.bean.RestAPIResult2;
import com.zhongkexinli.micro.serv.common.bean.secrity.SecGroups;
import com.zhongkexinli.micro.serv.common.msg.LayUiTableResultResponse;
import com.zhongkexinli.micro.serv.common.pagination.Query;
import com.zhongkexinli.micro.serv.common.util.DateUtil;
import com.zhongkexinli.micro.serv.common.util.TreeUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tk.mybatis.mapper.util.StringUtil;

/**
 *管理员分组管理
 */
@Api(value = "管理员分组服务", tags = "管理员分组服务接口")
@RestController
public class SecGroupsController extends BaseController{

    protected Logger logger = LoggerFactory.getLogger(SecGroupsController.class);
    @Autowired
    private SecGroupsService secGroupsService;
    
    @ApiOperation(value = "分页")
    @RequestMapping(value = "/api/SecGroups", method = RequestMethod.GET)
    public LayUiTableResultResponse page(@RequestParam(defaultValue = "10") int limit,
                                         @RequestParam(defaultValue = "1") int offset,String name, @RequestParam Map<String, Object> params) {
        Query query= new Query(params);
        LayUiTableResultResponse LayUiTableResultResponse=   secGroupsService.selectByQuery(query);
        return LayUiTableResultResponse;
    }

    /** 新增   */
    @ApiOperation(value = "新增")
    @RequestMapping(value = "/api/SecGroups",method=RequestMethod.POST)
    public RestAPIResult2 create(SecGroups secGroups)  {
        RestAPIResult2 restAPIResult = new RestAPIResult2();
        restAPIResult.setRespCode(1);
        restAPIResult.setRespMsg("操作成功");
        try {
            Integer createBy = getLoginId();
            secGroups.setCreateBy(createBy);
            secGroups.setCreateByUname(getUserName());
            secGroups.setCreateDate(DateUtil.getNowDateYYYYMMddHHMMSS());
            secGroupsService.insertSelective(secGroups);

        }catch(Exception e) {
            restAPIResult.setRespCode(0);
            restAPIResult.setRespMsg("失败成功:"+e.getMessage());
        }

        return restAPIResult;
    }
    
    @ApiOperation(value = "新增")
    @RequestMapping(value = "/api/SecGroupsAdd",method=RequestMethod.POST)
    public RestAPIResult2 create2(@ModelAttribute SecGroups secGroups)  {
        RestAPIResult2 restAPIResult = new RestAPIResult2();
        restAPIResult.setRespCode(1);
        restAPIResult.setRespMsg("操作成功");
        try {
        	if(StringUtil.isEmpty(secGroups.getGroupName())) {
        		 restAPIResult.setRespCode(0);
                 restAPIResult.setRespMsg("分组名称不为空");
                 return restAPIResult;
        	}
        	/*if(StringUtil.isEmpty(secGroups.getRemarks())) {
       		 restAPIResult.setRespCode(0);
                restAPIResult.setRespMsg("描述不为空");
                return restAPIResult;
       	     }*/
        	String data =DateUtil.getNowDateYYYYMMddHHMMSS();
        	secGroups.setCreateDate(data);
        	String str[] = secGroups.getUrids().split(",");
        	secGroupsService.insert(secGroups);
        	Integer gid=secGroups.getId();
        	secGroupsService.addByPrimaryKeySelective(secGroups,Arrays.asList(str),gid);

        }catch(Exception e) {
            restAPIResult.setRespCode(0);
            restAPIResult.setRespMsg("失败:"+e.getMessage());
        }

        return restAPIResult;
    }
    
    /** 保存更新  */
    @ApiOperation(value = "修改")
    @RequestMapping(value="/api/SecGroups/{id}",method=RequestMethod.PUT)
    public RestAPIResult2 update(@PathVariable("id") Integer id ,SecGroups secGroups)  {
        RestAPIResult2 restAPIResult = new RestAPIResult2();
        restAPIResult.setRespCode(1);
        restAPIResult.setRespMsg("操作成功");
        try {

        	if(secGroups.getId()==null){
        		secGroups.setId(id);
			}
        	
            Integer createBy = getLoginId();
            secGroups.setUpdateBy(createBy);
            secGroups.setUpdateByUname(getUserName());
            secGroups.setUpdateDate(DateUtil.getNowDateYYYYMMddHHMMSS());
            secGroupsService.updateByPrimaryKeySelective(secGroups);

        }catch(Exception e) {
            restAPIResult.setRespCode(0);
            restAPIResult.setRespMsg("失败成功:"+e.getMessage());
        }

        return restAPIResult;
    }

    /** 显示 */
    @ApiOperation(value = "显示")
    @RequestMapping(value="/api/SecGroups/{id}", method = RequestMethod.GET)
    public SecGroups show(@PathVariable("id") Integer id) throws Exception {
        SecGroups secGroups =secGroupsService.selectByPrimaryKey(id);
        if(secGroups==null){
        	secGroups = new SecGroups();
        }
        return secGroups;
    }

    /** 物理删除 */
    @ApiOperation(value = "删除分组")
    @RequestMapping(value="/api/SecGroups/{id}",method=RequestMethod.DELETE)
    public RestAPIResult2 delete(@PathVariable("id") Integer id) {
        RestAPIResult2 restAPIResult = new RestAPIResult2();
        restAPIResult.setRespCode(1);
        restAPIResult.setRespMsg("操作成功");
        
        if(id!=null && id<=1){
        	 restAPIResult.setRespCode(0);
             restAPIResult.setRespMsg("默认分组不可以删除");
             return restAPIResult;
    	}

        Map<String, Object> map =new HashMap<String,Object>();
        map.put("secGroupId", id);
        map.put("secGroupIdDefault", 1);//默认分组
        map.put("updateDate", DateUtil.getNowDateYYYYMMddHHMMSS());
		map.put("updateBy",getLoginId());
	    map.put("updateByUname",getUserName());
        
        secGroupsService.deleteByPrimaryKey(id);

        return restAPIResult;
    }

    @ApiOperation(value = "layui树")
    @RequestMapping(value = "/api/SecGroups/tree", method = RequestMethod.GET)
    public List<SecGroupsTree> tree( Map<String, Object> params) {
        Query query= new Query(params);
        return  getTree(secGroupsService.selectByExample(query), SecrityCommonConstant.ROOT);
    }

    private List<SecGroupsTree> getTree(List<SecGroups> groups,int root) {
        List<SecGroupsTree> trees = new ArrayList<SecGroupsTree>();
        SecGroupsTree node = null;
        for (SecGroups group : groups) {
            node = new SecGroupsTree();
            node.setLabel(group.getGroupName());
            node.setName(group.getGroupName());
            BeanUtils.copyProperties(group, node);
            trees.add(node);
        }
        return TreeUtil.bulid(trees,root) ;
    }
}

