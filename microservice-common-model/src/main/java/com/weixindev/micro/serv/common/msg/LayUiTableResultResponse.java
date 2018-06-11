package com.weixindev.micro.serv.common.msg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.github.pagehelper.PageInfo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "layui分页相应信息")
public class LayUiTableResultResponse<T> {
	 @ApiModelProperty(value = "编码")
	private String code;
	 @ApiModelProperty(value = "消息")
	private String msg;
	 @ApiModelProperty(value = "总数")
	private Long count;
	 @ApiModelProperty(value = "列表数据 ")
	private List data = new ArrayList();
	
	public LayUiTableResultResponse( Long count, List data) {
		this.code = "0";
		this.msg = "";
		this.count = count;
		this.data = data;
	}
	
	public LayUiTableResultResponse(String code, String msg, Long count, List data) {
		super();
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}
	
}
