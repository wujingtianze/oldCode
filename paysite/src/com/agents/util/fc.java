package com.agents.util;

/*
 *  基本函数
 */

import javax.servlet.http.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.sql.*;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


/**
 *
 * @author not attributable
 * @version 1.0
 */

public final class fc {
	static int n = 0;

	/*
	 * 用Post方式发数据
	 */
	//随机数
public String getRandom(){
	Random r = new Random();
	  int i = 0;
	  String str = "";
	  String s = null;
	//32位随机数
	  while (i < 32) {    
	   switch (r.nextInt(63)) {
	    case (0): s = "0"; break;
	    case (1): s = "1"; break;
	    case (2): s = "2"; break;
	    case (3): s = "3"; break;
	    case (4): s = "4"; break;
	    case (5): s = "5"; break;
	    case (6): s = "6"; break;
	    case (7): s = "7"; break;
	    case (8): s = "8"; break;
	    case (9): s = "9"; break;
	    case (10): s = "a"; break;
	    case (11): s = "b"; break;
	    case (12): s = "c"; break;
	    case (13): s = "d"; break;
	    case (14): s = "e"; break;
	    case (15): s = "f"; break;
	    case (16): s = "g"; break;
	    case (17): s = "h"; break;
	    case (18): s = "i"; break;
	    case (19): s = "j"; break;
	    case (20): s = "k"; break;
	    case (21): s = "m"; break;
	    case (23): s = "n"; break;
	    case (24): s = "o"; break;
	    case (25): s = "p"; break;
	    case (26): s = "q"; break;
	    case (27): s = "r"; break;
	    case (28): s = "s"; break;
	    case (29): s = "t"; break;
	    case (30): s = "u"; break;
	    case (31): s = "v"; break;
	    case (32): s = "w"; break;
	    case (33): s = "l"; break;
	    case (34): s = "x"; break;
	    case (35): s = "y"; break;
	    case (36): s = "z"; break;
	    case (37): s = "A"; break;
	    case (38): s = "B"; break;
	    case (39): s = "C"; break;
	    case (40): s = "D"; break;
	    case (41): s = "E"; break;
	    case (42): s = "F"; break;
	    case (43): s = "G"; break;
	    case (44): s = "H"; break;
	    case (45): s = "I"; break;
	    case (46): s = "L"; break;
	    case (47): s = "J"; break;
	    case (48): s = "K"; break;
	    case (49): s = "M"; break;
	    case (50): s = "N"; break;
	    case (51): s = "O"; break;
	    case (52): s = "P"; break;
	    case (53): s = "Q"; break;
	    case (54): s = "R"; break;
	    case (55): s = "S"; break;
	    case (56): s = "T"; break;
	    case (57): s = "U"; break;
	    case (58): s = "V"; break;
	    case (59): s = "W"; break;
	    case (60): s = "X"; break;
	    case (61): s = "Y"; break;
	    case (62): s = "Z"; break;
	   }
	   i++;
	   str = s + str;
	  }
	  return str;
	 }


	public static void main(String[] args) {
		fc f=new fc();
		//String aa=f.SendDataViaGet("http://127.0.0.1:8080/ZfwebApi/ArticleReturn?sign=JFJ45F674WR7UDY6U547R6JY48D7F93&out_trade_no=1108231742547758-11122233&total_fee=555&trade_status=TRADE_FINISHED&memo=手工加款&opereateid=gai213");
//	   System.out.println(fc.getMd5Str("1111141539520052-caift1bDKEXX2IuMlFdho2"));
//		String s = "1111251054583237-gai21320HGlZfSk4gmir667o";
		String s = "1112021019125010-gai213"+"222"+"xqX3QD0aOhLDOz66";
		s = f.getMd5Str(s);
		System.out.println(s);
	}
	public static String SendDataViaGet(String sUrl) {
		String s = "", all = "";
		try { 
			URL url;
			url = new URL(sUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			try{
				con.setDoOutput(true); // POST方式
				con.setConnectTimeout(1000 * 10);
				con.setReadTimeout(1000 * 10);
				con.setRequestMethod("GET"); 
				OutputStream os = con.getOutputStream(); // 输出流，写数据
				BufferedReader reader = new BufferedReader(new InputStreamReader(
						con.getInputStream())); // 读取结果
				String line;
				while ((line = reader.readLine()) != null) {
					all = all + line;
				}
				//
				reader.close();
				os.close();
				con.disconnect();
			}catch(Exception e){
				con.disconnect();
				all = "";
			}
			
			//
			return all;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print(e.toString());
			return "";
		}
	}
	public static String SendDataViaPost(String sUrl, String sData, String sCharesCode) {
		String s = "", all = "";
		try {
			URL url;
			url = new URL(sUrl);  
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			try{
				con.setDoOutput(true); // POST方式
				con.setRequestMethod("POST");
				OutputStream os = con.getOutputStream(); // 输出流，写数
				//
				s = sData;
				//
//				System.out.println(s);
				if (sCharesCode.equals(""))
					os.write(s.getBytes());
				else
					os.write(s.getBytes(sCharesCode));
				BufferedReader reader = new BufferedReader(new InputStreamReader(
						con.getInputStream())); // 读取结果
				String line;
				while ((line = reader.readLine()) != null) {
					all = all + line;
				}
				
				//
				reader.close();
				os.close();
				con.disconnect();
			}catch(Exception e){
				System.out.println("catch<<<<<接口地址不存在");
				//e.printStackTrace();
				con.disconnect();
				all = "ERROR,接口地址不存在";
			}
			return all;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.print(e.toString());
			return "";
		}
	}


	/*
	 * 发邮
	 */
	public static String sendEmail(String to_mail, String to_title, String to_content){
		String email=Config.getAttributeValue("config", "email", "name");
		String pwd=Config.getAttributeValue("config", "email", "pwd");   
		try{
			//建立邮件会话
			Properties props=new Properties();//也可用Properties props = System.getProperties();
			props.put("mail.smtp.host","smtp.gmail.com");//存储邮件服务器的信息
			props.put("mail.smtp.auth","true");//同时通过验证
			//下面4行代码的添加，是因为使用了Google邮箱发送
			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.port", "465");
            props.setProperty("mail.smtp.socketFactory.port", "465");
			Session s=Session.getInstance(props);//根据邮件会话
			s.setDebug(false);

			//由邮件会话新建一个消息对
			MimeMessage message=new MimeMessage(s);//由邮件会话新建一个消息对

			//设置邮件
			InternetAddress from=new InternetAddress(email);
			message.setFrom(from);//设置发件
			InternetAddress to=new InternetAddress(to_mail);
			message.setRecipient(Message.RecipientType.TO,to);//设置收件并设置其接收类型为TO
			message.setSubject(to_title);//设置主题
		//	message.setText(to_content);//设置信件内容
			message.setSentDate(new Date());//设置发信时间

			message.setContent(to_content, "text/html;charset=utf-8");


			//发邮件
			message.saveChanges();//存储邮件信息
			Transport transport=s.getTransport("smtp");
			//以smtp方式登录邮箱,第一个参数是发邮件用的邮件服务器SMTP地址,第二个参数为用户第三个参数为密码
			transport.connect("smtp.gmail.com",email,pwd);
			transport.sendMessage(message,message.getAllRecipients());//发?邮件,其中第二个参数是已设好的收件人地
			transport.close();
		}catch(MessagingException e){
			System.out.println("发送失败"+e);
		}
		return "sucess";
	}
		

	/*
	 * 发邮
	 */
	public static String sendEmailQQ(String to_mail, String to_title, String to_content){
		try{
			//建立邮件会话
			Properties props=new Properties();//也可用Properties props = System.getProperties();
			props.put("mail.smtp.host","smtp.gmail.com");//存储发邮件服务器的信息
			props.put("mail.smtp.auth","true");//同时通过验证
			//下面4行代码的添加，是因为使用了Google邮箱发送
			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.port", "465");
            props.setProperty("mail.smtp.socketFactory.port", "465");
			Session s=Session.getInstance(props);//根据属新建邮件会话
			s.setDebug(false);

			//由邮件会话新建一个消息对
			MimeMessage message=new MimeMessage(s);//由邮件会话新建一个消息

			//设置邮件
			InternetAddress from=new InternetAddress("gaihl@jinrl.com");
			message.setFrom(from);//设置发件
			InternetAddress to=new InternetAddress(to_mail);
			message.setRecipient(Message.RecipientType.TO,to);//设置收件设置其接收类型为TO
			message.setSubject(to_title);//设置主题
			message.setText(to_content);//设置信件内容
			message.setSentDate(new Date());//设置发信时间

		    //发邮件
			message.saveChanges();//存储邮件信息
			Transport transport=s.getTransport("smtp");
			//以smtp方式登录邮箱,第一个参数是发邮件用的邮件服务器SMTP地址,第二个参数为用户第三个参数为密码
//			transport.connect("smtp.gmail.com","imp@jinrl.com","P@ssw0rd");  
			transport.connect("smtp.gmail.com","gaihl@jinrl.com","gai116");
			transport.sendMessage(message,message.getAllRecipients());//发邮件,其中第二个参数是已设好的收件人
			transport.close();
		}catch(MessagingException e){
			System.out.println("[gaihl@jinrl.com]发送失败"+e);
		}


		return "";
	}
	//报警(不太好用)
    public static String sendMessage(String sPhone, String sContent){
		String sUrl = "http://211.141.224.226/sendtask/sendsm.do";
		String sData = "loginname=hlllx&password=hlllx&tele=" + sPhone + "&msg=" + java.net.URLEncoder.encode(sContent);
		String s = SendDataViaPost(sUrl, sData, "utf-8");
		if (!s.equals("0")){
			sendEmail(sPhone + "@139.com", sContent, sContent);
		}
		return s;
    }

	//清除HTML标签
	public static String delHtml(String s) {
		String ss = fc.getString(s, "<", ">");
		while (!ss.equals("")){
			s = fc.replace(s, "<" + ss + ">", "");
			ss = fc.getString(s, "<", ">");
		}
		return s;
	}


	//返回�?��固定格式的xml�?
	public static String getResultStr(String sRoot, String sData, String sResult, String sMsg){
		return "<?xml version='1.0' encoding='GB2312' ?><" + sRoot + "><result>" + sResult + "</result><msg>" + sMsg + "</msg><data>" + sData + "</data></" + sRoot + ">";
	}

	//返回�?��固定格式的xml�?数据信息, 统计信息, 成功/失败, 中文信息)
	public static String getResultStr(String sRoot, String sData, String sStat, String sResult, String sMsg){
		return "<?xml version='1.0' encoding='GB2312' ?><" + sRoot + "><result>" + sResult + "</result><msg>" + sMsg + "</msg><stat>" + sStat + "</stat><data>" + sData + "</data></" + sRoot + ">";
	}

	//返回�?��固定格式的xml�?
	public static String getResultStr(String sRoot, String sResult, String sMsg){
		return "<?xml version='1.0' encoding='GB2312' ?><" + sRoot + "><result>" + sResult + "</result><msg>" + sMsg + "</msg></" + sRoot + ">";
	}

	//返回�?��固定格式的xml�?
	public static String gms(String sXmlData, String sNodeName){
		return getXmlString(sXmlData, sNodeName);
	}

	//返回�?��xml串中的指定节点的�?
	public static String getXmlString(String sXmlData, String sNodeName){
		//返回xml�?
		int n1 = sXmlData.toLowerCase().indexOf("<" + sNodeName.toLowerCase() + ">");
		int n2 = sXmlData.toLowerCase().indexOf("</" + sNodeName.toLowerCase() + ">");
		if ((n1 != -1) && (n2 != -1) && (n1 < n2))
			return sXmlData.substring(n1 + ("<" + sNodeName + ">").length(), n2);
		else
			return "";
	}

	// 字符串替�?新串=replace(原串,�?换成�?
	public static java.lang.String replace(String strSource, String strFrom,
			String strTo) {
		java.lang.String strDest = "";
		int intFromLen = strFrom.length();
		int intPos;
		while ((intPos = strSource.indexOf(strFrom)) != -1) {
			strDest = strDest + strSource.substring(0, intPos);
			strDest = strDest + strTo;
			strSource = strSource.substring(intPos + intFromLen);
		}
		strDest = strDest + strSource;

		return strDest;
	}

	// 处理中文问题的函�?
	public static String getBGK(String str) {
		try {
			String temp_p = str;
			byte[] temp_t = temp_p.getBytes("ISO8859-1");
			String temp = new String(temp_t);
			return temp;
		} catch (Exception e) {
		}
		return "";
	}

	// 处理中文问题的函�?
	public static String getUtf8(String str) {
		try {
			String temp_p = str;
			byte[] temp_t = temp_p.getBytes("utf-8");
			String temp = new String(temp_t);
			return temp;
		} catch (Exception e) {
		}
		return "";
	}

	// 取网页参�?不存在或有错误时返回默认�?
	public static int getInt(HttpServletRequest request, String s, int DefValue) {
		String str = "";
		//
		try {
			str = new String(request.getParameter(s).getBytes("ISO-8859-1"),
					"gbk");
			if (str == null) str = "";
		} catch (Exception e) {
		}
		int n = 0;
		try{
			n = Integer.valueOf(str).intValue();
		}catch(Exception e){
			n = DefValue;
		}
		return n;
	}

	// 取网页参�?不存在时返回""
	public static String getpv(HttpServletRequest request, String s) {
		String str = "";
		//
		try {
			str = new String(request.getParameter(s).getBytes("ISO-8859-1"),"gbk");
			if (str == null) str = "";
		} catch (Exception e) {
		}
		//在这理处�?不良参数过滤问题
		str = replace(str, "'", "");
		str = replace(str, ":", "");
		str = replace(str, ";", "");
		str = replace(str, ",", "");
		str = replace(str, " ", "");
		str = replace(str, "--", "");
		str = replace(str, "%", "");
		//
		return str.trim();
	}

	public static String getpv(HttpSession session, String s) {
		Object str = "";
		//
		try {
			str = session.getAttribute("username");			
			if (str == null) str = "";
		} catch (Exception e) {
			str = ""; 
		}
		//
		return str.toString();
	}

	public static String getpv2(HttpServletRequest request, String s) {
		String str = "";
		//
		try {
			str = new String(request.getParameter(s));
			if (str == null) str = "";
		} catch (Exception e) {
		}
		//在这理处�?不良参数过滤问题
		str = replace(str, "'", "");
		str = replace(str, ":", "");
		str = replace(str, ";", "");
		str = replace(str, ",", "");
		str = replace(str, " ", "");
		str = replace(str, "--", "");
		str = replace(str, "%", "");
		//
		return str;
	}
	//这个方法已经在程序中不再调用，因为所有提交方式先都已改为GET
	public static String getpve(HttpServletRequest request, String s, String f) {
		String str = "";
		//
		if(fc.getpv(request, f).equals("")){
			str = fc.getpv(request, s);
		} else {
			str = request.getParameter(s);
		}
		return str;
	}
	// 取字段容�?出错时返回自定义的s2
	public static String getrv(ResultSet rs, String s1, String s2) {
		// String str = "&nbsp;";
		String str = "";
		try {
			str = rs.getString(s1).trim();
		} catch (Exception e) {
			str = s2;
		}
		return str;
	}

	// 字串变数�?
	public static int toint(String s) {
		char t;
		int n = 0, i = 0, l = s.length(), j = 0;
		n = 0;
		i = 0;
		l = s.length();
		j = 0;
		if (l == 0)
			n = 1;
		while (i < l) {
			t = s.charAt(i);
			switch (t) {
			case '0':
				j = 0;
				break;
			case '1':
				j = 1;
				break;
			case '2':
				j = 2;
				break;
			case '3':
				j = 3;
				break;
			case '4':
				j = 4;
				break;
			case '5':
				j = 5;
				break;
			case '6':
				j = 6;
				break;
			case '7':
				j = 7;
				break;
			case '8':
				j = 8;
				break;
			case '9':
				j = 9;
				break;
			default:
				n = 1;
				break;
			}
			n = n * 10 + j;
			i++;
		}
		return n;
	}

	// 字串变数�?数小数点
	public static float toxs(String s) {
		char t;
		int f = 0, div = 1, i = 0, l = s.length(), j = 0;
		f = 0;
		div = 1;
		n = 0;
		i = 0;
		l = s.length();
		j = 0;
		float n = 0;
		if (l == 0)
			n = 1;
		while (i < l) {
			t = s.charAt(i);
			switch (t) {
			case '0':
				j = 0;
				break;
			case '1':
				j = 1;
				break;
			case '2':
				j = 2;
				break;
			case '3':
				j = 3;
				break;
			case '4':
				j = 4;
				break;
			case '5':
				j = 5;
				break;
			case '6':
				j = 6;
				break;
			case '7':
				j = 7;
				break;
			case '8':
				j = 8;
				break;
			case '9':
				j = 9;
				break;
			case '.':
				f = 1;
				break;
			default:
				n = 1;
				break;
			}
			if (t != '.')
				n = n * 10 + j;
			if (f == 1)
				div = div * 10;
			// System.err.println("---"+n+" "+div);
			i++;
		}
		if (f == 1)
			n = n / div * 10;
		return n;
	}

	// 操作日志:写入文件或显示后�?内容包括操做过程和错语信�?
	public static void log(String s) {
		// 显示到后�?
		System.err.println(s);
		// 写入到文�?
	}

	// 向前台显示出错信�?
	public static void error(HttpServletResponse response, String s) {
		response.setContentType("text/html; charset=GBK");
		try {
			PrintWriter out = response.getWriter();
			out.println(s);
		} catch (Exception e) {

		}
	}

	// 产生�?��随机�?
	public static int ran(int upLimit, int downLimit) {
		return (int) (Math.random() * (upLimit - downLimit)) + downLimit;
	}

	// 返回�?��ID
	public static String getGUID(String sPrefix) {
//		UUID uuid = UUID.randomUUID();
//		String sGUID = uuid.toString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		GregorianCalendar grc = new GregorianCalendar();
		grc.setTime(new Date());
		String sDate = sdf.format(grc.getTime());
		String s = sDate;
//		sGUID = sGUID.replace("-", "");
		String sGUID = (10000 + ran(1000, 9999)) + "";
		s = fc.getTime("yyMMddHHmmss") + "" + sPrefix + "" + sGUID.substring(sGUID.length() - 4);
		return s;
	}

	public static String getMd5Str(String s){
		md5 md5 = new md5();
		String s1 = md5.getMD5(s.getBytes());
		md5 = null;
		return s1;
	}

	public static String GetOrderID(String sPrefix) {
		String r = "" + (10000 + ran(0, 9999));
		return sPrefix + fc.getTime("yyMMddHHmmss") + r.substring(1);
	}
	
	/*
	 * 是否包含字符
	 */
	public static boolean IsComprise(String sData, String sValue){
		for (int i = 0; i < sData.length(); i ++)
			if (sValue.indexOf(sData.substring(i, 1)) == -1) {
				return false;
			}
		return true;
	}

	/*
	 * 是否在数�?
	 */
	public static boolean IsNmber(String sData){
		String sValue = "0123456789";
		for (int i = 0; i < sData.length(); i ++)
			if (sValue.indexOf(sData.substring(i, i + 1)) == -1) {
				return false;
			}
		return true;
	}

	public static String getTime(String sFormat){
		return getTime(sFormat, 0);
	}

	public static String getTime(String sFormat, int mm){
		if (sFormat.equals("")) sFormat = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(sFormat);
		GregorianCalendar grc = new GregorianCalendar();
		grc.setTime(new Date());
		String s = sdf.format(grc.getTime());
		//
		if (mm != 0){
			Date dt=sdf.parse(s,new ParsePosition(0));
			Calendar rightNow = Calendar.getInstance();
			rightNow.setTime(dt);
			rightNow.add(Calendar.MINUTE, mm);//要加�?���?
			dt = rightNow.getTime();
			s = sdf.format(dt);
		}
		//
		return s;
	}

	/*
	 * 是否不包含字�?
	 */
	public boolean IsNoComprise(String sData, String sValue){
		for (int i = 0; i < sData.length(); i ++)
			if (sValue.indexOf(sData.substring(i, 1)) > -1) {
				return false;
			}
		return true;
	}


	/*
	 * 被下面的替代，不再使用
	 * 原因是取结束字符有问题，可能是开始字符之前的
	 */
	public static String getString_NO(String sData, String sBeginStr, String sEndStr){
		int n1 = sData.toLowerCase().indexOf(sBeginStr.toLowerCase());
		int n2 = sData.toLowerCase().indexOf(sEndStr.toLowerCase());
		if ((n1 > -1) && (n2 > -1) && (n1 < n2)){
			String s = sData.substring(n1 + sBeginStr.length(), n2);
			if(s == null){
				return "";
			}
			return s;
		}else
			return "";
	}

	public static String getString(String sData, String sBeginStr, String sEndStr){
		int n1 = sData.toLowerCase().indexOf(sBeginStr.toLowerCase());

		String afterSData ="";
		if(n1 > -1){
			afterSData = sData.substring(n1);
		}else{
			return "";
		}

		int n2 = afterSData.toLowerCase().indexOf(sEndStr.toLowerCase());
		if (n2 > -1){
			String s = afterSData.substring(sBeginStr.length(), n2);
			if(s == null){
				return "";
			}
			return s;
		}else
			return "";
	}

	//为了解决嵌套时写的，后来没有使用
	public static String getString2(String sData, String sBeginStr, String sEndStr){
		int n2 = sData.toLowerCase().indexOf(sEndStr.toLowerCase());
		int slength = sData.length();
		int reversen2 = slength - n2 - 1;
		String newsData = fc.reverseStr(sData);
		int n1 = newsData.toLowerCase().indexOf(sBeginStr.toLowerCase());
		int in = 0;
		while(in < 20){
			if(n1 > reversen2){
				break;
			}else{
				n1 = newsData.toLowerCase().indexOf(sBeginStr.toLowerCase(),n1+sBeginStr.length());
			}
			in++;
		}
		if(reversen2 < slength && n1 > -1 && n1 > reversen2){
			String s = newsData.substring(reversen2 + sBeginStr.length(),n1);
			if(s == null){
				return "";
			}else{
				return fc.reverseStr(s);
			}
		}else{
			return "";
		}
	}


	//返回字符串的倒序
	public static String reverseStr(String s){
		if(s == null){return null;}
		String resultString = "";
		char[] charArray = s.toCharArray();
		for (int i = charArray.length-1; i>=0; i--){
		resultString +=charArray[i];
		}
		return resultString;
	}

	/*
	 * 返回xml行记录中的字段�?
	 */
	public static String getrd(String sRowData, int nRow, String sFieldName){
		String sRow = fc.getString(sRowData, "<row_" + nRow + ">", "</row_" + nRow + ">");
		return fc.getString(sRow, "<" + sFieldName + ">", "</" + sFieldName + ">");
	}

	public static String getstarttime(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nowtime = sdf.format(date)+" 00:00:00";
		return nowtime;
	}

	public static String getstarttime(Long days){
		if(days == null) days = 0l;
		Date date = new Date();
		Long mi = date.getTime();
		Long jg = new Long(days.longValue() * 24 * 60 * 60 * 1000);
		Date date2 = new Date(mi - jg);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nowtime = sdf.format(date2)+" 00:00:00";
		return nowtime;
	}

	public static String getendtime(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String nowtime = sdf.format(date)+" 23:59:59";
		return nowtime;
	}


	public static String GetNowTime(String sFormat) {
		if (sFormat ==null || sFormat.equals("")) sFormat = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(sFormat);
		String s = sdf.format(new Date());
		return s;
	}

	public static String GetDate(String sFormat,Date date) {
		if (sFormat ==null || sFormat.equals("")) sFormat = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(sFormat);
		String s = sdf.format(date);
		return s;
	}

	/**
	* 删除单个文件
	* @param fileName 要删除的文件的文件名
	* @return 单个文件删除成功返回true，否则返回false
	*/
	public static boolean deleteFile(String fileName) {
	   File file = new File(fileName);
	   // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
	   if(file.exists() && file.isFile()) {
	    if(file.delete()) {
//	     System.out.println("删除单个文件" + fileName + "成功！");
	       return true;
	    } else {
//	     System.out.println("删除单个文件" + fileName + "失败！");
	       return false;
	    }
	   } else {
//	    System.out.println("删除单个文件失败：" + fileName + "不存在！");
	      return false;
	   }
	}

	public static String changNull(String isnull){
		if(isnull == null){
			isnull = "";
		}
		return isnull;
	}

    //将字符串转换成二进制字符串
    public static String StrToBinstr(String str) {
        char[] strChar=str.toCharArray();
        String result="";
        for(int i=0;i<strChar.length;i++){
            result +=Integer.toBinaryString(strChar[i]);
        }
        return result;
    }

}