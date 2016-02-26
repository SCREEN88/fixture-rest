package ru.hh.fixture.enums.resume;

public enum ResumeSchedule {
  FULL_DAY(0),
  SHIFT(1),
  FLEXIBLE(2),
  REMOTE(3),
  FLY_IN_FLY_OUT(4),
  ;

  private int value;

  ResumeSchedule(int value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }
}
