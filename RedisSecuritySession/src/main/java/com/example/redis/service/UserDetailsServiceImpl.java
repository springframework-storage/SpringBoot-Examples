package com.example.redis.service;

import com.example.redis.component.UserDetailsImpl;
import com.example.redis.domain.Member;
import com.example.redis.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private MemberRepository memberRepository;

  @Override
  public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
    Member member = memberRepository.findById(id)
            .orElseThrow(() -> new UsernameNotFoundException(id));
    return new UserDetailsImpl(member);
  }

}
