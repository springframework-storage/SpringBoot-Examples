package com.example.redis.component;

import com.example.redis.domain.Member;
import com.example.redis.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InitRunner implements ApplicationRunner {

  @Autowired
  private MemberRepository memberRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    memberRepository.save(new Member("mingood", passwordEncoder.encode("1234")));
    memberRepository.save(new Member("gitflow", passwordEncoder.encode("1234")));
    memberRepository.save(new Member("likelion", passwordEncoder.encode("1234")));

    for (Member member : memberRepository.findAll()) {
      System.out.println("### " + member.toString());
    }
  }

}
