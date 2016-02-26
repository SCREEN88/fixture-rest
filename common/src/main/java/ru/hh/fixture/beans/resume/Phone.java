package ru.hh.fixture.beans.resume;

import java.io.Serializable;

public class Phone implements Serializable{
  private String city;
  private String country;
  private String number;
  private String comment;

  public Phone(String country, String city, String number, String comment) {
    this.city = city;
    this.country = country;
    this.number = number;
    this.comment = comment;
  }

  public String getCity() {
    return city;
  }

  public String getCountry() {
    return country;
  }

  public String getNumber() {
    return number;
  }

  public String getComment() {
    return comment;
  }

  /**
   * Returns international format of Phone without brackets and dashes BUT with plus symbol
   *
   * @return  phone, fg +74954562321, and for legacy phones simply returns local area number
   */
  public String asString() {
    if (isEmpty()) {
      return "";
    }
    return String.format("%1$s%2$s%3$s", this.getCountry(), this.getCity(), this.getNumber());
  }

  public boolean isEmpty() {
    return country == null && city == null && number == null;
  }

  @Override
  public String toString() {
    return "Phone{" +
        "country='" + country + '\'' +
        ", city='" + city + '\'' +
        ", number='" + number + '\'' +
        ", comment='" + comment + '\'' +
        '}';
  }
}
