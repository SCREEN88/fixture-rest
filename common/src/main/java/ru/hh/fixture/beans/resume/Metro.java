package ru.hh.fixture.beans.resume;

import java.io.Serializable;

public class Metro implements Serializable {

  private int metroId;
  private String metroName;

  public Metro(int metroId) {
    this.metroId = metroId;
  }

  public Metro(String metroName) {
    this.metroName = metroName;
  }

  public Metro(int metroId, String metroName) {
    this.metroId = metroId;
    this.metroName = metroName;
  }

  public int getMetroId() {
    return metroId;
  }

  public void setMetroId(int metroId) {
    this.metroId = metroId;
  }

  public String getMetroName() {
    return metroName;
  }

  public void setMetroName(String metroName) {
    this.metroName = metroName;
  }
}
