package ru.hh.fixture.beans.resume;

import java.io.Serializable;

public class Industry implements Serializable {
  private int id;
  private String name;

  public Industry(int id) {
    this.id = id;
  }

  public Industry(String name) {
    this.name = name;
  }

  public Industry(int industryId, String name) {
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