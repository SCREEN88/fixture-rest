package ru.hh.fixture.beans.resume;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProfessionalExperience implements Serializable {
  ArrayList<ExperienceRecord> history = new ArrayList<>(1);

  public ProfessionalExperience() {}

  public ExperienceRecord get(int index) {
    return history.get(index);
  }

  public ExperienceRecord getFirst() {
    return history.get(0);
  }

  public List<ExperienceRecord> getAll() {
    return history;
  }

  public void add(ExperienceRecord record) {
    history.add(record);
  }

  public static ProfessionalExperience oneRecord(String organization, String position, String description,
                                                 LocalDate startDate, LocalDate endDate) {
    ProfessionalExperience history = new ProfessionalExperience();
    history.add(new ExperienceRecord(organization, position, description, startDate, endDate));
    return history;
  }

  public static class ExperienceRecord implements Serializable {
    private int id;
    private String organization;
    private String position;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private ExperienceCompany experienceCompany;

    public ExperienceRecord(String organization, String position, String description, LocalDate startDate, LocalDate endDate) {
      this.organization = organization;
      this.position = position;
      this.description = description;
      this.startDate = startDate;
      this.endDate = endDate;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getOrganization() {
      return organization;
    }

    public void setOrganization(String organization) {
      this.organization = organization;
    }

    public String getPosition() {
      return position;
    }

    public void setPosition(String position) {
      this.position = position;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public LocalDate getStartDate() {
      return startDate;
    }

    public void setStartDate(LocalDate startDate) {
      this.startDate = startDate;
    }

    public LocalDate getEndDate() {
      return endDate;
    }

    public void setEndDate(LocalDate endDate) {
      this.endDate = endDate;
    }

    public ExperienceCompany getExperienceCompany() {
      return experienceCompany;
    }

    public void setExperienceCompany(ExperienceCompany experienceCompany) {
      this.experienceCompany = experienceCompany;
    }
  }

  public static class ExperienceCompany implements Serializable {
    private String organization;
    private Integer areaId;
    private String url;
    private Industry industry;
    //private Set<Industry> industries;
    private Company company;

    public ExperienceCompany(String organization){
      this.organization = organization;
    }

    public ExperienceCompany(String organization, Integer areaId, String url, Industry industry, /*Set<Industry> industries, */Company company) {
      this.url = url;
      this.areaId = areaId;
      this.industry = industry;
      //this.industries = industries;
      this.organization = organization;
      this.company = company;
    }

    public String getUrl() {
      return url;
    }

    public void setUrl(String url) {
      this.url = url;
    }

    public Integer getAreaId() {
      return areaId;
    }

    public void setAreaId(Integer areaId) {
      this.areaId = areaId;
    }

    public Industry getIndustry() {
      return industry;
    }

    public void setIndustry(Industry industry) {
      this.industry = industry;
    }

    /*public Set<Industry> getIndustries() {
      return industries;
    }

    public void setIndustries(Industry... industryArray) {
      industries = new HashSet<>();
      Collections.addAll(industries, industryArray);
    }

    public void setIndustries(Set<Industry> industrySet) {
      industries = industrySet;
    }*/

    public String getOrganization() {
      return organization;
    }

    public void setOrganization(String organization) {
      this.organization = organization;
    }

    public Company getCompany() {
      return company;
    }

    public void setCompany(Company company) {
      this.company = company;
    }
  }
}
