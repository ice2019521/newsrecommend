package cn.zzuli.news.common.result;

public class UserTokenConstants {
	/**
	 * 登录令牌
	 */
	public final static String Token = "token";
	/**
	 * redis中缓存权限的键
	 */
	public final static String Permission_Key = "Permissions";

	/**
	 * 项目前缀
	 */
	public final static String appPreAllUrl = "/NewsRecommend";

	/**
	 * 用户账号被冻结
	 */
	public final static int UserStatusDisable = 0;
	/**
	 * 普通用户
	 */
	public final static int UserStatusOrdinary = 1;
	/**
	 * 管理员
	 */
	public final static int UserStatusSuper = 2;
}
