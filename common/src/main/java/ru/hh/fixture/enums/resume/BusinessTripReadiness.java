package ru.hh.fixture.enums.resume;

public enum BusinessTripReadiness {
  NEVER(0),
  READY(1),
  SOMETIMES(2);

  private int value;

  BusinessTripReadiness(int value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }
}
