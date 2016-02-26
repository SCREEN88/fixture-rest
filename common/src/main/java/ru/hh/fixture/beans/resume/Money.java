package ru.hh.fixture.beans.resume;

import java.io.Serializable;
import java.math.BigDecimal;
import ru.hh.fixture.enums.resume.CurrencyEnum;

public class Money implements Serializable {
  BigDecimal ammount;
  CurrencyEnum currency;

  //for bean convention
  public Money() {
  }

  public Money(long ammount, CurrencyEnum currency) {
    this.ammount = BigDecimal.valueOf(ammount);
    this.currency = currency;
  }

  public static Money RUR(long ammount) {
    return new Money(ammount, CurrencyEnum.RUR);
  }

  public static Money USD(long ammount) {
    return new Money(ammount, CurrencyEnum.USD);
  }

  public static Money EUR(long ammount) {
    return new Money(ammount, CurrencyEnum.EUR);
  }

  public BigDecimal getAmmount() {
    return ammount;
  }

  public CurrencyEnum getCurrency() {
    return currency;
  }

  public void setAmmount(BigDecimal ammount) {
    this.ammount = ammount;
  }

  public void setCurrency(CurrencyEnum currency) {
    this.currency = currency;
  }

}
