package com.fsj.test;

public class test {
	public static void main(String[] args) {
		System.out.println(Boolean.parseBoolean(null));// false
		System.out.println(Boolean.parseBoolean("yes"));// false
		System.out.println(Boolean.parseBoolean("on"));// false
		System.out.println(Boolean.parseBoolean("true"));// true
		StringBuffer hql = new StringBuffer();
		hql.append("select count(*) from Recommended as recommended where 1=1 ");
		System.out.println(hql.substring(16));
		System.out.println("".length());
	}
}
