<%@page contentType="text/html; charset=gb2312" language="java"%>
<%@ page import="pay_kuaiqian.MD5Util"%>
<%@ page import="pay_common.AcceptResult"%>
<%@ page import="common.*"%>
<%
/**  
 * @Description: 快钱人民币支付网关接口范例
 * @Copyright (c) 上海快钱信息服务有限公司
 * @version 2.0
 */

//获取人民币网关账户号
String merchantAcctId= "1002136583301"; //(String)request.getParameter("merchantAcctId").trim();

//设置人民币网关密钥
///区分大小写
String key="XDKHS78XC4HT72AA";

//获取网关版本.固定值
///快钱会根据版本号来调用对应的接口处理程序。
///本代码版本号固定为v2.0
String version=(String)request.getParameter("version").trim();

//获取语言种类.固定选择值。
///只能选择1、2、3
///1代表中文；2代表英文
///默认值为1
String language=(String)request.getParameter("language").trim();

//签名类型.固定值
///1代表MD5签名
///当前版本固定为1
String signType=(String)request.getParameter("signType").trim();

//获取支付方式
///值为：10、11、12、13、14
///00：组合支付（网关支付页面显示快钱支持的各种支付方式，推荐使用）10：银行卡支付（网关支付页面只显示银行卡支付）.11：电话银行支付（网关支付页面只显示电话支付）.12：快钱账户支付（网关支付页面只显示快钱账户支付）.13：线下支付（网关支付页面只显示线下支付方式）.14：B2B支付（网关支付页面只显示B2B支付，但需要向快钱申请开通才能使用）
String payType=(String)request.getParameter("payType").trim();

//获取银行代码
///参见银行代码列表
String bankId=(String)request.getParameter("bankId").trim();

//获取商户订单号
String orderId=(String)request.getParameter("orderId").trim();

//获取订单提交时间
///获取商户提交订单时的时间.14位数字。年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
///如：20080101010101
String orderTime=(String)request.getParameter("orderTime").trim();

//获取原始订单金额
///订单提交到快钱时的金额，单位为分。
///比方2 ，代表0.02元
String orderAmount=(String)request.getParameter("orderAmount").trim();

//获取快钱交易号
///获取该交易在快钱的交易号
String dealId=(String)request.getParameter("dealId").trim();

//获取银行交易号
///如果使用银行卡支付时，在银行的交易号。如不是通过银行支付，则为空
String bankDealId=(String)request.getParameter("bankDealId").trim();

//获取在快钱交易时间
///14位数字。年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
///如；20080101010101
String dealTime=(String)request.getParameter("dealTime").trim();

//获取实际支付金额
///单位为分
///比方 2 ，代表0.02元
String payAmount=(String)request.getParameter("payAmount").trim();

//获取交易手续费
///单位为分
///比方 2 ，代表0.02元
String fee=(String)request.getParameter("fee").trim();

//获取扩展字段1
String ext1= fc.getpv(request, "ext1");//(String)request.getParameter("ext1").trim();

//获取扩展字段2
String ext2= fc.getpv(request, "ext2"); //(String)request.getParameter("ext2").trim();

//获取处理结果
///10代表 成功11代表 失败
String payResult=(String)request.getParameter("payResult").trim();

//获取错误代码
///详细见文档错误代码列表
String errCode=(String)request.getParameter("errCode").trim();

//获取加密签名串
String signMsg=(String)request.getParameter("signMsg").trim();



//生成加密串。必须保持如下顺序。
	String merchantSignMsgVal="";
	merchantSignMsgVal=appendParam(merchantSignMsgVal,"merchantAcctId",merchantAcctId);
	merchantSignMsgVal=appendParam(merchantSignMsgVal,"version",version);
	merchantSignMsgVal=appendParam(merchantSignMsgVal,"language",language);
	merchantSignMsgVal=appendParam(merchantSignMsgVal,"signType",signType);
	merchantSignMsgVal=appendParam(merchantSignMsgVal,"payType",payType);
	merchantSignMsgVal=appendParam(merchantSignMsgVal,"bankId",bankId);
	merchantSignMsgVal=appendParam(merchantSignMsgVal,"orderId",orderId);
	merchantSignMsgVal=appendParam(merchantSignMsgVal,"orderTime",orderTime);
	merchantSignMsgVal=appendParam(merchantSignMsgVal,"orderAmount",orderAmount);
	merchantSignMsgVal=appendParam(merchantSignMsgVal,"dealId",dealId);
	merchantSignMsgVal=appendParam(merchantSignMsgVal,"bankDealId",bankDealId);
	merchantSignMsgVal=appendParam(merchantSignMsgVal,"dealTime",dealTime);
	merchantSignMsgVal=appendParam(merchantSignMsgVal,"payAmount",payAmount);
	merchantSignMsgVal=appendParam(merchantSignMsgVal,"fee",fee);
	merchantSignMsgVal=appendParam(merchantSignMsgVal,"ext1",ext1);
	merchantSignMsgVal=appendParam(merchantSignMsgVal,"ext2",ext2);
	merchantSignMsgVal=appendParam(merchantSignMsgVal,"payResult",payResult);
	merchantSignMsgVal=appendParam(merchantSignMsgVal,"errCode",errCode);
	merchantSignMsgVal=appendParam(merchantSignMsgVal,"key",key);

String merchantSignMsg=MD5Util.md5Hex(merchantSignMsgVal.getBytes("gb2312")).toUpperCase();


//初始化结果及地址
int rtnOk=0;
String s = "error,0";

//
//String path = request.getScheme() + "://" + request.getServerName()	+ ":" + request.getServerPort();	// "http://190.10.2.33:7001/"; 
//if (request.getServerPort() == 80) path = request.getScheme() + "://" + request.getServerName();
//path = path + "/ZfwebApi/kuaiqian_show.jsp"; 					//支付完成后跳转返回的网址URL

//if (ext2.indexOf("?") > -1) 
//	ext2 = ext2 + "&";
//else
//	ext2 = ext2 + "?";

System.out.print("[网银通知]快钱:" + payResult + "," + ext1 + "," + orderId + "," + payAmount);

//商家进行数据处理，并跳转会商家显示支付结果的页面
///首先进行签名字符串验证

if(signMsg.toUpperCase().equals(merchantSignMsg.toUpperCase())){

	AcceptResult ar = new AcceptResult();


	///接着进行支付结果判断
	s = ar.acceptResult(request, response);
	if (s.equals("success")){
		//报告给快钱处理结果，并提供将要重定向的地址。
		rtnOk=1;
	}else{
		rtnOk=0;
	}
}else{

	rtnOk=1;
	System.out.print("[网银返回]快钱:md5有误");
}
System.out.print("[网银返回]快钱:" + rtnOk);


%>
<%!
	//功能函数。将变量值不为空的参数组成字符串
	public String appendParam(String returnStr,String paramId,String paramValue)
	{
			if(!returnStr.equals(""))
			{
				if(!paramValue.equals(""))
				{
					returnStr=returnStr+"&"+paramId+"="+paramValue;
				}
			}
			else
			{
				if(!paramValue.equals(""))
				{
				returnStr=paramId+"="+paramValue; 
				}
			}	
			return returnStr;
	}
	//功能函数。将变量值不为空的参数组成字符串。结束


//以下报告给快钱处理结果，并提供将要重定向的地址 
%>
<result><%=rtnOk %></result><redirecturl>http://superapi.95588.tw:9180/busics/wynotice.jsp</redirecturl>