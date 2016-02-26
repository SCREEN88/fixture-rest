package ru.hh.fixture.beans.resume;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import ru.hh.fixture.enums.resume.BusinessTripReadiness;
import ru.hh.fixture.enums.resume.EducationLevel;
import ru.hh.fixture.enums.resume.Employment;
import ru.hh.fixture.enums.resume.Gender;
import ru.hh.fixture.enums.resume.RegionEnum;
import ru.hh.fixture.enums.resume.ResumeArea;
import ru.hh.fixture.enums.resume.ResumeSchedule;
import ru.hh.fixture.enums.resume.ResumeStatus;
import ru.hh.fixture.enums.resume.RoadTimeType;
import ru.hh.fixture.enums.resume.WorkExperience;

public class ResumeData implements Serializable {
  private int id;
  private String hash;
  private String title;
  private Money desirableCompensation;
  private LocalDateTime creationTime;
  private LocalDateTime lastChangeTime;
  private LocalDate birthdayDate;
  private RegionEnum area;
  private Metro nearestMetro;
  private BusinessTripReadiness businessTripsReadiness;
  private RoadTimeType roadTime;
  private RelocationInfo relocationInfo;
  private int[] specializationIds;
  private Gender gender;
  private ProfessionalExperience professionalExperience;
  private EducationLevel education;
  private EducationHistory educationHistory;
  private ResumeStatus resumeStatus;
  private ResumeLanguage languages;
  private ResumeArea[] citizenship;
  private ResumeArea[] workTickets;
  private Access access;
  private String keywords;
  private String[] keySkills;
  private RecommendationInfo recommendationInfo;
  private Set<ResumeSchedule> resumeSchedules;
  private WorkExperience workExperience;
  private Set<Employment> employments;
  private Set<ResumeCertificate> certificates;
  private int siteId;
  private UserImage userImage;
  private List<UserImage> userPortfolio;
  private ContactInformation contactInformation;
  private AdditionalEducation additionalEducation;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }

  public void setProfessionalExperience(ProfessionalExperience professionalExperience) {
    this.professionalExperience = professionalExperience;
  }

  public void setEducationHistory(EducationHistory educationHistory) {
    this.educationHistory = educationHistory;
  }

  public Metro getNearestMetro() {
    return nearestMetro;
  }

  public void setNearestMetro(Metro nearestMetro) {
    this.nearestMetro = nearestMetro;
  }

  public BusinessTripReadiness getBusinessTripsReadiness() {
    return businessTripsReadiness;
  }

  public void setBusinessTripsReadiness(BusinessTripReadiness businessTripsReadiness) {
    this.businessTripsReadiness = businessTripsReadiness;
  }

  public RoadTimeType getRoadTime() {
    return roadTime;
  }

  public void setRoadTime(RoadTimeType roadTime) {
    this.roadTime = roadTime;
  }

  public RelocationInfo getRelocationInfo() {
    return relocationInfo;
  }

  public void setRelocation(RelocationInfo info) {
    this.relocationInfo = info;
  }

  public String getKeywords() {
    return keywords;
  }

  public void setKeywords(String keywords) {
    this.keywords = keywords;
  }

  public String[] getKeySkills() {
    return keySkills;
  }

  public void setKeySkills(String[] keySkills) {
    this.keySkills = keySkills;
  }

  public EducationLevel getEducation() {
    return education;
  }

  public void setEducation(EducationLevel education) {
    this.education = education;
  }

  public EducationHistory getEducationHistory() {
    return educationHistory;
  }

  public LocalDate getBirthdayDate() {
    return birthdayDate;
  }

  public void setBirthdayDate(LocalDate birthdayDate) {
    this.birthdayDate = birthdayDate;
  }

  public RegionEnum getArea() {
    return area;
  }

  public void setArea(RegionEnum area) {
    this.area = area;
  }

  public int[] getSpecializationIds() {
    return specializationIds;
  }

  public void setSpecializationIds(int[] specializationIds) {
    this.specializationIds = Arrays.copyOf(specializationIds, specializationIds.length);
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public ResumeLanguage getLanguagesInfo() {
    return languages;
  }

  public void setLanguagesInfo(ResumeLanguage resumeLanguage) {
    languages = resumeLanguage;
  }

  public Access getAccess() {
    return access;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDesirableCompensation(Money compensation) {
    this.desirableCompensation = compensation;
  }

  public void setCreationTime(LocalDateTime creationTime) {
    this.creationTime = creationTime;
  }

  public void setLastChangeTime(LocalDateTime lastChangeTime) {
    this.lastChangeTime = lastChangeTime;
  }

  public void setAccess(Access access) {
    this.access = access;
  }

  public void setResumeStatus(ResumeStatus resumeStatus) {
    this.resumeStatus = resumeStatus;
  }

  public LocalDateTime getCreationTime() {
    return creationTime;
  }

  public Money getDesirableCompensation() {
    return desirableCompensation;
  }

  public LocalDateTime getLastChangeTime() {
    return lastChangeTime;
  }

  public ProfessionalExperience getProfessionalExperience() {
    return professionalExperience;
  }

  public String getTitle() {
    return title;
  }

  public ResumeStatus getResumeStatus() {
    return resumeStatus;
  }

  public ResumeArea[] getCitizenship() {
    return citizenship;
  }

  public void setCitizenship(ResumeArea[] citizenship) {
    this.citizenship = Arrays.copyOf(citizenship, citizenship.length);
  }

  public ResumeArea[] getWorkTickets() {
    return workTickets;
  }

  public void setWorkTickets(ResumeArea[] workTickets) {
    this.workTickets = Arrays.copyOf(workTickets, workTickets.length);
  }

  public RecommendationInfo getRecommendationInfo() {
    return recommendationInfo;
  }

  public void setRecommendationInfo(RecommendationInfo recommendationInfo) {
    this.recommendationInfo = recommendationInfo;
  }

  public Set<ResumeSchedule> getResumeSchedules() {
    return resumeSchedules;
  }

  public void setResumeSchedules(Set<ResumeSchedule> resumeSchedules) {
    this.resumeSchedules = resumeSchedules;
  }

  public WorkExperience getWorkExperience() {
    return workExperience;
  }

  public void setWorkExperience(WorkExperience workExperience) {
    this.workExperience = workExperience;
  }

  public Set<Employment> getEmployments() {
    return employments;
  }

  public void setEmployments(Set<Employment> employments) {
    this.employments = employments;
  }

  public int getSiteId() {
    return siteId;
  }

  public void setSiteId(int siteId) {
    this.siteId = siteId;
  }

  public Set<ResumeCertificate> getCertificates() {
    return certificates;
  }

  public void setCertificates(Set<ResumeCertificate> certificates) {
    this.certificates = certificates;
  }

  public void addCertificate(ResumeCertificate certificate) {
    if (this.certificates == null) {
      this.certificates = new HashSet<>();
    }
    this.certificates.add(certificate);
  }

  public void setResumePhoto(UserImage userImage) {
    this.userImage = userImage;
  }

  public UserImage getResumePhoto() {
    return userImage;
  }

  public void setResumePortfolio(List<UserImage> userPortfolio) {
    this.userPortfolio = userPortfolio;
  }

  public List<UserImage> getResumePortfolio() {
    return userPortfolio;
  }

  public ContactInformation getContactInformation() {
    return contactInformation;
  }

  public void setContactInformation(ContactInformation contactInformation) {
    this.contactInformation = contactInformation;
  }

  public AdditionalEducation getAdditionalEducation() {
    return additionalEducation;
  }

  public void setAdditionalEducation(AdditionalEducation additionalEducation) {
    this.additionalEducation = additionalEducation;
  }
}
