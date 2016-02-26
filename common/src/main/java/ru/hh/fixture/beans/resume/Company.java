package ru.hh.fixture.beans.resume;

import java.io.Serializable;

public class Company implements Serializable {
  private int id;
  private String name;

  public Company(int id) {
    this.id = id;
  }

  public Company(String name) {
    this.name = name;
  }

  public Company(int industryId, String name) {
    this.id = industryId;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
