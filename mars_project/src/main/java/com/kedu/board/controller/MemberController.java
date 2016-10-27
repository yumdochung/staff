package com.kedu.board.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;
import com.kedu.board.dto.MemberDto;
import com.kedu.board.dto.LoginDto;
import com.kedu.board.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

  @Inject
  private MemberService service;

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public void loginGET(@ModelAttribute("dto") LoginDto dto) {

  }


  @RequestMapping(value = "/loginPost", method = RequestMethod.POST)
  public void loginPOST(LoginDto dto, HttpSession session, Model model) throws Exception {

    MemberDto vo = service.login(dto);

    if (vo == null) {
      return;
    }

    model.addAttribute("memberDto", vo);

    if (dto.ismCookie()) {

      int amount = 60 * 60 * 24 * 7;

      Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount));

      service.keepLogin(vo.getMid(), session.getId(), sessionLimit);
    }

  }

  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public void logout(HttpServletRequest request, 
      HttpServletResponse response, HttpSession session) throws Exception {

    Object obj = session.getAttribute("login");

    if (obj != null) {
      MemberDto dto = (MemberDto) obj;

      session.removeAttribute("login");
      session.invalidate();

      Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");

      if (loginCookie != null) {
        loginCookie.setPath("/");
        loginCookie.setMaxAge(0);
        response.addCookie(loginCookie);
        service.keepLogin(dto.getMid(), session.getId(), new Date());
      }
    }
  }

}
