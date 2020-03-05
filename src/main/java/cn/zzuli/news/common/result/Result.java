package cn.zzuli.news.common.result;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("deprecation")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Result implements Serializable {
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 * @date: 2016年2月25日 上午10:21:10
	 */
	private static final long serialVersionUID = 1L;
	private Object data;
	private String retCode;
	private String retMsg;

	public Result(String retCode, String retMsg, Object data) {
		this.data = data;
		this.retCode = retCode;
		this.retMsg = retMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public static Result success() {
		Result serviceResult = new Result(ErrorCode.SuccessRetCode, ErrorCode.SuccessRetInfo, null);
		return serviceResult;
	}

	public static Result success(Object obj) {
		Result serviceResult = new Result(ErrorCode.SuccessRetCode, ErrorCode.SuccessRetInfo, obj);
		return serviceResult;
	}

	public static Result success(Object rows, Object paginationInfo) {
		Map<Object, Object> obj = new HashMap<>();
		obj.put("rows", rows);
		obj.put("paginationInfo", paginationInfo);

		Result serviceResult = new Result(ErrorCode.SuccessRetCode, ErrorCode.SuccessRetInfo, obj);
		return serviceResult;
	}

	public static Result fail(String code, String info) {
		Result serviceResult = new Result(code, info, null);
		return serviceResult;
	}

	public static Result fail(String code, String info, Object object) {
		Result serviceResult = new Result(code, info, object);
		return serviceResult;
	}

	public static Result fail(String info) {
		Result serviceResult = new Result(ErrorCode.ParaCheckErrorRetCode, info, null);
		return serviceResult;
	}

	public static Result exception(String info) {
		Result serviceResult = new Result(ErrorCode.ExceptionRetCode, ErrorCode.ExceptionRetInfo + info, null);
		return serviceResult;
	}

	public static Result loginNameFail() {
		Result serviceResult = new Result(ErrorCode.LoginNameFailCode, ErrorCode.LoginNameFailInfo, null);
		return serviceResult;
	}
}
