package com.example.social.login.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
@ConfigurationProperties(prefix = "social.kakao")
public class KakaoProperties {

  private String clientId;    // Rest API KEY
  private String redirectUrl;

}
