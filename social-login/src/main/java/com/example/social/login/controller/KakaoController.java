package com.example.social.login.controller;

import com.example.social.login.oauth.KakaoOAuthUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KakaoController {
  private KakaoOAuthUtil kakaoOAuthUtil;

  public KakaoController(KakaoOAuthUtil kakaoOAuthUtil) {
    this.kakaoOAuthUtil = kakaoOAuthUtil;
  }

  @GetMapping("/")
  public String getLogin(Model model) {
    String kakaoUrl = kakaoOAuthUtil.getAuthorizationUrl();
    model.addAttribute("kakaoUrl", kakaoUrl);
    return "redirect:" + kakaoUrl;
  }

  @GetMapping("/oauth")
  public String getKakaoSignIn(ModelMap modelMap,
                               @RequestParam("code") String code) {
    JsonNode userInfo = kakaoOAuthUtil.getKakaoUserInfo(code);
    System.out.println(userInfo);

    String id = userInfo.get("id").toString();
    String image = userInfo.get("properties").get("profile_image").toString();
    String nickname = userInfo.get("properties").get("nickname").toString();

    modelMap.addAttribute("k_userInfo", userInfo);
    modelMap.addAttribute("id", id);
    modelMap.addAttribute("nickname", nickname);
    modelMap.addAttribute("image", image);

    return "SUCCESS";
  }

}
