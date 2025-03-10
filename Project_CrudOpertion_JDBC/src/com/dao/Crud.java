package com.dao;

public interface Crud {
	
	public String insert(String name,String phone,int salary);
	public String read(String phone);
	public String delete(int eid);
	public String update(int esal,int eid);

}
