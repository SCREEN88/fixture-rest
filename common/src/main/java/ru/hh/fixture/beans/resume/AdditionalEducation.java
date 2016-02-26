package ru.hh.fixture.beans.resume;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AdditionalEducation implements Serializable {
  private List<AdditionalEducationRecord> records = new ArrayList<>();

  public AdditionalEducation() {
  }

  public AdditionalEducationRecord get(int index) {
    return records.get(index);
  }

  public AdditionalEducationRecord getFirst() {
    return records.get(0);
  }

  public List<AdditionalEducationRecord> getAll() {
    return records;
  }

  public void add(AdditionalEducationRecord record) {
    records.add(record);
  }

  public static AdditionalEducation oneRecord(String name, String organization, int endYear) {
    AdditionalEducation info = new AdditionalEducation();
    info.add(new AdditionalEducationRecord(name, organization, endYear));
    return info;
  }

  public static class AdditionalEducationRecord implements Serializable {
    private String name;
    private String organization;
    private String specialization;
    private int endYear;
    private int id;

    public AdditionalEducationRecord(String name, String organization, int endYear) {
      this.name = name;
      this.organization = organization;
      this.endYear = endYear;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public int getEndYear() {
      return endYear;
    }

    public String getName() {
      return name;
    }

    public String getOrganization() {
      return organization;
    }

    public String getSpecialization() {
      return specialization;
    }

    public void setSpecialization(String specialization) {
      this.specialization = specialization;
    }
  }
}
