package com.dao;

import java.util.ArrayList;

public interface Crud {
	
	public String insert(String name,String phone,int salary);
	public ArrayList<Object> read();
	public String delete(int eid);
	public String update(int esal,int eid);

}
