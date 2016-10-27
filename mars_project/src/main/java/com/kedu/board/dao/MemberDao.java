package com.kedu.board.dao;

import java.util.Date;

import com.kedu.board.dto.LoginDto;
import com.kedu.board.dto.MemberDto;

public interface MemberDao {
	
	public MemberDto login(LoginDto dto)throws Exception;

	  public void keepLogin(String mid, String sessionId, Date next);

  public MemberDto checkMemberWithSessionKey(String value);	
}



