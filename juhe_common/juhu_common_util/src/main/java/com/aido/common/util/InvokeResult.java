package com.aido.common.util;
/**
 * ClassName: InvokeResult  
 * 返回结果
 * @author DOUBLE
 * @version
 */
public class InvokeResult implements JModel {

	private static final long serialVersionUID = 1L;

	private Object data;

    private String errorMessage;

    private boolean success=true;
    

    public static InvokeResult success(Object data) {
        InvokeResult result = new InvokeResult();
        result.data = data;
        return result;
    }

    @Deprecated
    public static InvokeResult success() {
        InvokeResult result = new InvokeResult();
        result.success = true;
        return result;
    }

    public static InvokeResult failure(String message) {
        InvokeResult result = new InvokeResult();
        result.success = false;
        result.errorMessage = message;
        return result;
    }

    public Object getData() {
        return data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
   
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
