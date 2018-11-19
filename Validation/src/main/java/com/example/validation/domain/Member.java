package com.example.validation.domain;

import com.example.validation.validator.Phone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @NotNull : null 검증
 * @Min, @Max : 최소값, 최대값 검증
 * @Size : 범위 검증
 * @Email : email 검증
 * @AssertTrue : true 검증
 * @NotEmpty : null 이나 size 가 0 검증 (String, Collection)
 * @NotBlank : null 이나 whitespace 검증 (String)
 * @Positive, @PositiveOrZero : 숫자 검증
 * @Negative, @NegativeOrZero : 숫자 검증
 * @Past, @PastOrPresent : 날짜 검증
 * @Future, @FutureOrPresent : 날짜 검증
 */

@Entity
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idx;

  @NotNull(message = "name null")
  private String name;

  @NotNull(message = "age null")
  @Min(value = 14, message = "min 14")
  private Integer age;

  @Phone
  private String phone;

  public Member() {}

  public Member(String name, Integer age, String phone) {
    this.name = name;
    this.age = age;
    this.phone = phone;
  }

  public Long getIdx() {
    return idx;
  }

  public void setIdx(Long idx) {
    this.idx = idx;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

}
