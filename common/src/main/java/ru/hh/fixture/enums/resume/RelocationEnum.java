package ru.hh.fixture.enums.resume;

public enum RelocationEnum {
  NO(0),
  POSSIBLY(1),
  DESIRABLE(2);

  private final int id;

  RelocationEnum(int id) {
    this.id = id;
  }

  public int id() {
    return id;
  }

  public Integer getValue() {
    return id;
  }
}
