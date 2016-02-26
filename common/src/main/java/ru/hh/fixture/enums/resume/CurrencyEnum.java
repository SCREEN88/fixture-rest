package ru.hh.fixture.enums.resume;

public enum CurrencyEnum {
  EUR(4),
  KZT(5),
  RUR(1),
  UAH(2),
  USD(3);

  private final int id;

  CurrencyEnum(int id) {
    this.id = id;
  }

  public int id() {
    return id;
  }
}
