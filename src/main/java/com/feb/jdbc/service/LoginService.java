package com.feb.jdbc.service;

import java.util.HashMap;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.feb.jdbc.dao.LoginDao;
import com.feb.jdbc.util.Sha512Encoder;

@Service
public class LoginService {

	@Autowired
	private LoginDao loginDao;

	
	//아이디 검증
	public int join(HashMap<String, String> params) {
		//inputId 회원가입 폼에 입력한 id
		String inputId = params.get("memberId");
		
		//dbId db상 저장되어있는 id
		String dbId = loginDao.findSameId(params);
		
		//inputId과 dbId가 같으면 회원가입 실패
		if(Objects.equals(inputId, dbId)) {
			return 0;
		}
		
		//inputId가 6이하면 회원가입 실패
		else if(inputId.length() <= 6) {
			return 0;
		}
		
		Sha512Encoder encoder = Sha512Encoder.getInstance();
		String inputPw = params.get("passWd"); //사용자가 입력한 값
		// 사용자가 입력한 값을 암호화 한 것
		String encodePw = encoder.getSecurePassword(inputPw);
		params.put("passWd", encodePw);
		
		return loginDao.join(params);
	}

	//비밀번호 검증
	public boolean login(HashMap<String, String> params) {
		
		//로그인폼에 입력한 비밀번호
		String inputPw = params.get("passWd");
		//입력한 비밀번호 암호화
		Sha512Encoder encoder = Sha512Encoder.getInstance();
		String encodePw = encoder.getSecurePassword(inputPw);
		
		//db상 저장되어있는 비밀번호
		String dbPw = loginDao.findRealPw(params);

		
		//db상 비밀번호와 입력한 비밀번호가 같으면 true
		if(Objects.equals(encodePw, dbPw)) {
			return true;
		} else {
			return false;
		}
	}
}
