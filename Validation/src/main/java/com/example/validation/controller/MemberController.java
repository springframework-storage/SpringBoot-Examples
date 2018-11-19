package com.example.validation.controller;

import com.example.validation.domain.ErrorMessage;
import com.example.validation.domain.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("member")
public class MemberController {

  private static final int ZERO = 0;

  @GetMapping
  public String find() {
    return "Error";
  }

  /**
   * 검증하고자 하는 Entity 에 @Valid 를 붙이며,
   * 이에 대한 결과를 받기 위해 BindingResult 를 추가하여 사용
   *
   * @param member
   * @param bindingResult
   * @return
   */
  @PostMapping
  public ResponseEntity<?> add(@Valid @RequestBody Member member,
                               BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      String errorMsg = bindingResult.getAllErrors().get(ZERO).getDefaultMessage();
      return ResponseEntity.badRequest().body(new ErrorMessage(HttpStatus.BAD_REQUEST.value(), errorMsg));
    }
    return ResponseEntity.ok(member);
  }

}
