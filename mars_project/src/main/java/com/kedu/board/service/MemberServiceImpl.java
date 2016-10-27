package com.kedu.board.service;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kedu.board.dto.LoginDto;
import com.kedu.board.dto.MemberDto;
import com.kedu.board.dao.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {

  @Inject
  private MemberDao dao;

  @Override
  public MemberDto login(LoginDto dto) throws Exception {

    return dao.login(dto);
  }
  
  @Override
  public void keepLogin(String mid, String sessionId, Date next)
      throws Exception {
    
    dao.keepLogin(mid, sessionId, next);
    
  }

  @Override
  public MemberDto checkLoginBefore(String value) {
    
    return dao.checkMemberWithSessionKey(value);
  }
}
