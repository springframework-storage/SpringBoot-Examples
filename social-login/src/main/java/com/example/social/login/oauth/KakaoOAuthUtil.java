package com.example.social.login.oauth;

import com.example.social.login.config.KakaoProperties;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class KakaoOAuthUtil {

  private KakaoProperties kakaoProperties;

  public KakaoOAuthUtil(KakaoProperties kakaoProperties) {
    this.kakaoProperties = kakaoProperties;
  }

  public String getAuthorizationUrl() {
    String kakaoUrl = "https://kauth.kakao.com/oauth/authorize?"
            + "client_id=" + kakaoProperties.getClientId()
            + "&redirect_uri=http://localhost:8080" + kakaoProperties.getRedirectUrl()
            + "&response_type=code";
    return kakaoUrl;
  }

  public String getAccessToken(String authorizeCode) {
    String requestUrl = "https://kauth.kakao.com/oauth/token";
    List<NameValuePair> postParams = new ArrayList<>();

    System.out.println("### " + authorizeCode);

    postParams.add(new BasicNameValuePair("grant_type", "authorization_code"));
    postParams.add(new BasicNameValuePair("client_id", kakaoProperties.getClientId()));
    postParams.add(new BasicNameValuePair("redirect_uri", "http://localhost:8080" + kakaoProperties.getRedirectUrl()));
    postParams.add(new BasicNameValuePair("code", authorizeCode));

    CloseableHttpClient client = HttpClientBuilder.create().build();
    HttpPost post = new HttpPost(requestUrl);
    JsonNode returnNode = null;

    try {
      post.setEntity(new UrlEncodedFormEntity(postParams));
      HttpResponse response = client.execute(post);
      int responseCode = response.getStatusLine().getStatusCode();

      System.out.println("Sending 'POST' request to URL: " + requestUrl);
      System.out.println("Post Parameters: " + postParams);
      System.out.println("ResponseCode: " + responseCode);

      ObjectMapper mapper = new ObjectMapper();
      returnNode = mapper.readTree(response.getEntity().getContent());

    } catch (UnsupportedEncodingException e) {
      log.error("UnsupportedEncodingException");
    } catch (ClientProtocolException e) {
      log.error("ClientProtocolException");
    } catch (IOException e) {
      log.error("IOException");
    }
    System.out.println(returnNode);

    return returnNode.get("access_token").toString();
  }

  public JsonNode getKakaoUserInfo(String authorizeCode) {
    String requestUrl = "https://kapi.kakao.com/v1/user/me";
    HttpClient client = HttpClientBuilder.create().build();
    HttpPost post = new HttpPost(requestUrl);
    String accessToken = this.getAccessToken(authorizeCode);

    System.out.println(accessToken);

    post.addHeader("Authorization", "Bearer " + accessToken);
    JsonNode returnNode = null;

    try {
      HttpResponse response = client.execute(post);
      int responseCode = response.getStatusLine().getStatusCode();

      log.info("Sending 'Post' request to URL: " + requestUrl);
      log.info("Response Code: " + responseCode);

      ObjectMapper mapper = new ObjectMapper();
      returnNode = mapper.readTree(response.getEntity().getContent());

    } catch (UnsupportedEncodingException e) {
      log.error("UnsupportedEncodingException");
    } catch (ClientProtocolException e) {
      log.error("ClientProtocolException");
    } catch (IOException e) {
      log.error("IOException");
    }
    return returnNode;
  }

}
