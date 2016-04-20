package service;

import java.util.Random;

import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.TaobaoResponse;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;

public class GetPhoneCode extends ActionSupport{
	
	private String phoneNumber;//短信接收号码手机号码
	
	private String message;//产生的验证码

	//发送验证码相关的变量设置
	private String url = "http://gw.api.taobao.com/router/rest";
	
	private String appkey = "23333713";
	
	private String secret = "1210907eeedd5481b2d3509360c02c6b";
	
	private String smsTemplateCode = "SMS_5004351";
	
	private String paramString = "{\"code\":\"";//21345\",\"product\":\"eFarm\"}";//验证码${code}，您正在注册成为${product}用户，感谢您的支持！
	
	private String freeSignName = "注册验证";//短信签名
	//end
	public String getCode() {
		
		setPhoneNumber(getPhoneNumber());//从请求中获取到手机号，并在本地设置变量属性
		
		System.out.println(phoneNumber);
		
		setMessage(getRandom());//设置随机数验证码
		
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
//		req.setExtend("123456");
		req.setSmsType("normal"); 
		req.setSmsFreeSignName(freeSignName);
		paramString += message + "\",\"product\":\"LifeWiki\"}";
		req.setSmsParamString(paramString);
		req.setRecNum(getPhoneNumber());
		req.setSmsTemplateCode(smsTemplateCode);
		TaobaoResponse rsp;
		try {
			rsp = client.execute(req);//.execute(req);
			System.out.println(rsp.getBody());
//			System.out.println(rsp.getErrorCode());
//			System.out.println(rsp.getMsg());
//			System.out.println(rsp.getSubCode());
//			System.out.println(rsp.getSubMsg());
			System.out.println(rsp.getParams().get("sms_param").toString());
			if(rsp.getErrorCode() == null) {
				JSONObject jsonObject = JSONObject.fromObject(rsp.getParams().get("sms_param").toString());
				setMessage(jsonObject.getString("code"));
				System.out.println(jsonObject.getString("code"));
			} else {
				setMessage("-1");
			}
			
		} catch (ApiException e) {
			e.printStackTrace();
		}
		
		return "success";
		
	}
	
	
	private String getRandom() {
		Random random = new Random();
		String result="";
		for(int i=0;i<6;i++){
			result+=random.nextInt(10);
		}
		return result;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
