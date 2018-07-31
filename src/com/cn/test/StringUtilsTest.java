package com.cn.test;

import org.apache.commons.lang3.StringUtils;

/**
 * StringUtils是apache提供的一个工具类
 * 在commons-lang3的jar包中
 * @author Ivan
 *
 */
public class StringUtilsTest {

	public static void main(String[] args) {
		String str1 = null;
		String str2 = "";
		String str3 = "     ";
		System.out.println(StringUtils.isEmpty(str1));//true
		System.out.println(StringUtils.isEmpty(str2));//true
		System.out.println(StringUtils.isEmpty(str3));//false

		System.out.println(StringUtils.isBlank(str1));//true
		System.out.println(StringUtils.isBlank(str2));//true
		System.out.println(StringUtils.isBlank(str3));//true
	}

}
