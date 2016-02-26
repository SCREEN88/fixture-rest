package ru.hh.fixture.beans.resume;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RecommendationInfo implements Serializable {
  private List<RecommendationInfoRecord> records = new ArrayList<>();

  public RecommendationInfo() {
  }

  public RecommendationInfoRecord get(int index) {
    return records.get(index);
  }

  public RecommendationInfoRecord getFirst() {
    return records.get(0);
  }

  public List<RecommendationInfoRecord> getAll() {
    return records;
  }

  public void add(RecommendationInfoRecord record) {
    records.add(record);
  }

  public static RecommendationInfo oneRecord(String name, String organization, String position, String contactInfo) {
    RecommendationInfo info = new RecommendationInfo();
    info.add(new RecommendationInfoRecord(name, organization, position, contactInfo));
    return info;
  }

  public static class RecommendationInfoRecord implements Serializable {
    private String name;
    private String organization;
    private String position;
    private String contactInfo;
    private int id;

    public RecommendationInfoRecord(String name, String organization, String position, String contactInfo) {
      this.name = name;
      this.organization = organization;
      this.position = position;
      this.contactInfo = contactInfo;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getContactInfo() {
      return contactInfo;
    }

    public String getName() {
      return name;
    }

    public String getOrganization() {
      return organization;
    }

    public String getPosition() {
      return position;
    }
  }
}
