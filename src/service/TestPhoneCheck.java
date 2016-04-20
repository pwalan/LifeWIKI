package service;

import com.opensymphony.xwork2.ActionSupport;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

public class TestPhoneCheck extends ActionSupport{
	
	private String url = "http://gw.api.taobao.com/router/rest";
	
	private String appkey = "23316245";
	
	private String secret = "0d5a16cb64db2aef68a06b06ad92e349";
	
	private String smsTemplateCode = "SMS_5004351";
	
	private String recNumber = "15201235540"; //短信接受号码
	
	
	
	private String freeSignName = "注册验证";//短信签名
	
	private String resp;
	
	public String getResp() {
		return resp;
	}

	public void setResp(String resp) {
		this.resp = resp;
	}

	public String getCheck() {
		setResp("error");
		String paramString = "{\"code\":\"21345\",\"product\":\"eFarm\"}";//验证码${code}，您正在注册成为${product}用户，感谢您的支持！
		System.out.println(paramString);
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
		req.setSmsType("normal"); 
		req.setSmsFreeSignName(freeSignName);
		req.setSmsParamString(paramString);
		req.setRecNum(recNumber);
		req.setSmsTemplateCode(smsTemplateCode);
		AlibabaAliqinFcSmsNumSendResponse rsp;
		try {
			rsp = client.execute(req);
			System.out.println(rsp.getBody());
			System.out.println(rsp.getErrorCode());
			System.out.println(rsp.getMsg());
			System.out.println(rsp.getSubCode());
			System.out.println(rsp.getSubMsg());
			System.out.println(rsp.getParams().get("sms_param").toString());
			setResp(rsp.getParams().get("sms_param").toString());
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "success";
	}
	
	

}
