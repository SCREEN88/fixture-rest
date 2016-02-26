package ru.hh.fixture.enums.resume;

public enum RoadTimeType {
  ANY(0),
  LESS_THAN_HOUR(1),
  FROM_HOUR_TO_ONE_AND_HALF(2);

  private int value;

  RoadTimeType(int value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }
}
