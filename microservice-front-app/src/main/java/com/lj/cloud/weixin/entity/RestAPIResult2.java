
package com.lj.cloud.weixin.entity;

import java.io.Serializable;

/**
 * RestAPIResult2 <br/>
 * Function: REST API接口统一响应接口实体. <br/>
 * 
 */
public class RestAPIResult2 implements Serializable {

	/**
	 * serialVersionUID:
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private int respCode = 1;

    private String respMsg="成功！";
    
    private String dataCode;

    public int getRespCode() {
        return respCode;
    }

    public void setRespCode(int respCode) {
        this.respCode = respCode;
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg;
    }
}
