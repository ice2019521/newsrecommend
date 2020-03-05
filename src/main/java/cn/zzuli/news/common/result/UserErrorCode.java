package cn.zzuli.news.common.result;
/**
 * 
 * 最好定义为枚举
 *
 */
public interface UserErrorCode extends ErrorCode{
  public static final String UserLoginErrorRetCode = "1001";
  public static final String UserLoginErrorRetInfo = "用户登录失败";

  public static final String UserNotExistForLoginErrorRetCode = "1002";
  public static final String UserNotExistErrorForLoginRetInfo = "用户不存在或密码错误";
  
  public static final String UserTypeNotExistErrorRetCode = "10021";
  public static final String UserTypeNotExistErrorRetInfo = "用户类型不存在";
  
  public static final String UserNotExistErrorForRefindRetCode = "10022";
  public static final String UserNotExistErrorForRefindRetInfo = "用户不存在";
  
  public static final String UserStatusDisableErrorRetCode = "10022";
  public static final String UserStatusDisableErrorRetInfo = "对不起，已被禁用，请您联系管理员";
  
  public static final String UserDriverClientIdErrorRetCode = "10023";
  public static final String UserDriverClientIdErrorRetInfo = "对不起，手机更换不能使用，请您联系管理员";
  
  public static final String UserPermissionDeniedErrorRetCode = "1003";
  public static final String UserPermissionDeniedErrorRetInfo = "用户没有权限";//未传递token
  public static final String UserLoginTimeOutRetCode = "1031";
  public static final String UserLoginTimeOutRetInfo = "登录超时，请重新登录";
  
  public static final String CaptchaErrorRetCode = "1004";
  public static final String CaptchaErrorRetInfo = "验证码错误";
  
  public static final String UserOrPassErrorRetCode = "1005";
  public static final String UserOrPassErrorRetInfo = "用户名或者密码错误";
  
  public static final String NeedStaffIDRetCode = "1006";
  public static final String NeedStaffIDRetInfo = "员工ID不能为空";
  
  public static final String NoMatchingTypeRetCode = "1007";
  public static final String NoMatchingTypeRetInfo = "修改类型不匹配";
  
  public static final String OverMaxLengthRetCode = "1008";
  public static final String OverMaxLengthRetInfo = "长度越过最大值30位";
  
  public static final String OldPwdErrorRetCode = "1009";
  public static final String OldPwdErrorRetInfo = "原密码错误";
  
  public static final String NewAndConfirmPwdDifferentRetCode = "1010";
  public static final String NewAndConfirmPwdDifferentRetInfo = "新密码和确认新密码不一致";
  
  public static final String PwdParamErrorRetCode = "1011";
  public static final String PwdParamErrorRetInfo = "密码应为6-20位，字母加数字";
  
  public static final String NeedConfirmPwdRetCode = "1012";
  public static final String NeedConfirmPwdRetInfo = "确认密码不能为空";
  
  public static final String RegisterCode = "1013";
  public static final String RegisterRetInfo = "账户已经存在";
  
  public static final String RegisterParentCode = "10131";
  public static final String RegisterParentRetInfo = "家长注册时必须与学生预留的家长手机号";
  
  public static final String OldPwdNewPwdErrorCode = "1014";
  public static final String OldPwdNewPwdErrorfo = "原密码和新密码不能相同";
  
  public static final String OldAcountKeyCode = "1015";
  public static final String OldAcountKeyInfo = "原秘钥错误";
  
  public static final String OldAcountKeyErrorCode = "1016";
  public static final String OldAcountKeyErrorfo = "原秘钥和新秘钥不能相同";
  
  public static final String PayPwdErrorCode = "1017";
  public static final String PayPwdErrorfo = "支付密码错误";
  
}
