/**  
 * Project Name:space  
 * File Name:ResultJSON.java  
 * Package Name:org.sipedu.space.vo  
 * Date:2015年12月31日上午11:08:47  
 * Copyright (c) 2015, FengYunTec All Rights Reserved.  
 *  
*/  
  
package com.aido.common.util;  

import java.util.List;


/**  
 * ClassName: ResultJSON  
 * (ajax方法返回类)
 * @author Erik_Yim  
 * @version   
 */
public class ResultListJSON {
	
	private int error_code;	
	private String reason;	
	private List<Object> result;
	
	public ResultListJSON() {
		
	}
	
	/**  
	 * Creates a new instance of ResultJSON.  
	 *  
	 * @param error_code
	 * @param reason
	 * @param result  
	 */  
	
	public ResultListJSON(int error_code, String reason, List<Object> result) {
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
	
	public ResultListJSON(int error_code) {
		super();
		this.error_code = error_code;
	}

	/**  
	 * Creates a new instance of ResultJSON.  
	 *  
	 * @param error_code
	 * @param reason  
	 */  
	
	public ResultListJSON(String reason,List<Object> result) {
		super();
		this.result = result;
		this.reason = reason;
	}
	/**  
	 * Creates a new instance of ResultJSON.  
	 *  
	 * @param reason  
	 */  
	
	public ResultListJSON(String reason) {
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
	public List<Object> getResult() {
		return result;
	}
	/**  
	 * result.  
	 *  
	 * @param   result    the result to set    
	 */
	public void setResult(List<Object> result) {
		this.result = result;
	}

	public static ResultListJSON getResultJSON(String reason, List<Object> result)  {
		return new ResultListJSON(reason, result);
	}
	
	public static ResultListJSON getResultJSON(int error_code, String reason, List<Object> result)  {
		return new ResultListJSON(error_code, reason, result);
	}
	
	public static ResultListJSON getSuccessResultJSON() {
		return new ResultListJSON(0);
	}
	
	public static ResultListJSON getFailedResultJSON() {
		return new ResultListJSON(206301);
	}
}
  
