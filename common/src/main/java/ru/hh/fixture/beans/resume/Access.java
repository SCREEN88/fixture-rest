package ru.hh.fixture.beans.resume;

import java.io.Serializable;
import java.util.ArrayList;
import ru.hh.fixture.enums.resume.ResumeAccessType;

public class Access implements Serializable {
  ResumeAccessType type;
  ArrayList<Integer> employerIds;

  public Access(ResumeAccessType type) {
    this.type = type;
    this.employerIds = new ArrayList<Integer>();
  }

  public Access(ResumeAccessType type, ArrayList<Integer> employerIds) {
    this(type);
    this.employerIds = employerIds;
  }

  public ResumeAccessType getType() {
    return type;
  }

  public ArrayList<Integer> getEmployerIds() {
    return employerIds;
  }
}
