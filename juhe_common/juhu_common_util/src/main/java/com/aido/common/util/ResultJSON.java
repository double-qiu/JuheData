/**  
 * Project Name:space  
 * File Name:ResultJSON.java  
 * Package Name:org.sipedu.space.vo  
 * Date:2015年12月31日上午11:08:47  
 * Copyright (c) 2015, FengYunTec All Rights Reserved.  
 *  
*/  
  
package com.aido.common.util;  

import java.util.Map;


/**  
 * ClassName: ResultJSON  
 * (ajax方法返回类)
 * @author Erik_Yim  
 * @version   
 */
public class ResultJSON {
	
	private int error_code;	
	private String reason;	
	private Map<String, Object> result;
	
	public ResultJSON() {
		
	}
	
	/**  
	 * Creates a new instance of ResultJSON.  
	 *  
	 * @param error_code
	 * @param reason
	 * @param result  
	 */  
	
	public ResultJSON(int error_code, String reason, Map<String, Object> result) {
		super();
		this.error_code = error_code;
		this.reason = reason;
		this.result = result;
	}
	/**  
	 * Creates a new instance of ResultJSON.  
	 *  
	 * @param error_code
	 */  
	
	public ResultJSON(int error_code) {
		super();
		this.error_code = error_code;
	}

	/**  
	 * Creates a new instance of ResultJSON.  
	 *  
	 * @param error_code
	 * @param reason  
	 */  
	
	public ResultJSON(String reason,Map<String, Object> result) {
		super();
		this.result = result;
		this.reason = reason;
	}
	/**  
	 * Creates a new instance of ResultJSON.  
	 *  
	 * @param reason  
	 */  
	
	public ResultJSON(String reason) {
		super();
		this.reason = reason;
	}

	/**  
	 * error_code.  
	 *  
	 * @return  the error_code  
	 */
	public int getError_code() {
		return error_code;
	}

	/**  
	 * error_code.  
	 *  
	 * @param   error_code    the error_code to set    
	 */
	public void setError_code(int error_code) {
		this.error_code = error_code;
	}
	/**  
	 * reason.  
	 *  
	 * @return  the reason  
	 */
	public String getReason() {
		return reason;
	}
	/**  
	 * reason.  
	 *  
	 * @param   reason    the reason to set    
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}
	/**  
	 * result.  
	 *  
	 * @return  the result  
	 */
	public Map<String, Object> getResult() {
		return result;
	}
	/**  
	 * result.  
	 *  
	 * @param   result    the result to set    
	 */
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public static ResultJSON getResultJSON(String reason, Map<String, Object> result)  {
		return new ResultJSON(reason, result);
	}
	
	public static ResultJSON getResultJSON(int error_code, String reason, Map<String, Object> result)  {
		return new ResultJSON(error_code, reason, result);
	}
	
	public static ResultJSON getSuccessResultJSON() {
		return new ResultJSON(0);
	}
	
	public static ResultJSON getFailedResultJSON() {
		return new ResultJSON(206301);
	}
}
  
