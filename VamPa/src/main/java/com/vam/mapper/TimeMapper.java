package com.vam.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("SELECT sysdate FROM dual")
	public String getTime();
	
	public String getTime2();
	
	@Select("insert into test_tabe values('test1')")
	public String insertTest();
}
