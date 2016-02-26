package ru.hh.fixture.enums.resume;

public enum UserImageType {
  RESUME_PHOTO(1),
  PORTFOLIO(2);

  private int value;

  UserImageType(int value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }
}
