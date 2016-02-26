package ru.hh.fixture.beans.resume;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EducationHistory implements Serializable {
  private ArrayList<EducationRecord> history = new ArrayList<>(1);

  public EducationHistory() {
  }

  public EducationRecord get(int index) {
    return history.get(index);
  }

  public EducationRecord getFirst() {
    return history.get(0);
  }

  public List<EducationRecord> getAll() {
    return history;
  }

  public void add(EducationRecord record) {
    history.add(record);
  }

  public static EducationHistory oneRecord(String name, String faculty, String diploma, LocalDate endDate) {
    EducationHistory history = new EducationHistory();
    history.add(new EducationRecord(name, faculty, diploma, endDate));
    return history;
  }

  public static class EducationRecord implements Serializable {
    private int id;
    private String name;
    private String faculty;
    private String diploma;
    private LocalDate endDate;

    public EducationRecord(String name, String faculty, String diploma, LocalDate endDate) {
      this.name = name;
      this.faculty = faculty;
      this.diploma = diploma;
      this.endDate = endDate;
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

    public String getFaculty() {
      return faculty;
    }

    public String getDiploma() {
      return diploma;
    }

    public LocalDate getEndDate() {
      return endDate;
    }
  }
}
