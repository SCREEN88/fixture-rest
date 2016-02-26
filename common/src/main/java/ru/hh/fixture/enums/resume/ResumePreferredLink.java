package ru.hh.fixture.enums.resume;

public enum ResumePreferredLink {
  CELL_PHONE(3),
  EMAIL(4),
  HOME_PHONE(1),
  NOTSET(0),
  UNKNOWN(-1),
  WORK_PHONE(2);

  private final int value;

  ResumePreferredLink(int value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }

  public static ResumePreferredLink getByInt(int value) {
    for (ResumePreferredLink rpl : ResumePreferredLink.values()) {
      if (rpl.value == value){
        return rpl;
      }
    }
    throw new IllegalArgumentException("ResumePreferredLink not found!");
  }
}