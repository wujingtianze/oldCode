/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.jinrl.powermodule.actionform;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * MyEclipse Struts Creation date: 05-12-2010
 *
 * XDoclet definition:
 *
 * @struts.form name="userForm"
 */
public class UserForm extends ActionForm {
	private String username;
	private String sex;
	private Timestamp birthday;
	private String userid;
	private String email;
	private String fGoogleDayUrl;
	private String fcustomUrl;


	public String getFcustomUrl() {
		return fcustomUrl;
	}

	public void setFcustomUrl(String fcustomUrl) {
		this.fcustomUrl = fcustomUrl;
	}

	public String getfGoogleDayUrl() {
		return fGoogleDayUrl;
	}

	public void setfGoogleDayUrl(String fGoogleDayUrl) {
		this.fGoogleDayUrl = fGoogleDayUrl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	/**
	 * Method validate
	 *
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Method reset
	 *
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("GB2312");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}