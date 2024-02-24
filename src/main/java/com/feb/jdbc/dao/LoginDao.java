package com.feb.jdbc.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.feb.jdbc.entity.Login;

@Repository
public interface LoginDao {
	
	//회원가입
	public int join(HashMap<String, String> params);
	
	//로그인 여부
	public Login login(HashMap<String, String> params);
	
	//아이디 중복검사
	public String findSameId(HashMap<String, String> params);
	
	//비밀번호 일치
	public String findRealPw(HashMap<String, String> params);
}
