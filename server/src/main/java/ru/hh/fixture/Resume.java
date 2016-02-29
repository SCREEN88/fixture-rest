package ru.hh.fixture;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import jersey.repackaged.com.google.common.base.Joiner;
import jersey.repackaged.com.google.common.base.MoreObjects;
import jersey.repackaged.com.google.common.collect.Lists;
import ru.hh.fixture.beans.UserData;
import ru.hh.fixture.beans.resume.Access;
import ru.hh.fixture.beans.resume.AdditionalEducation;
import ru.hh.fixture.beans.resume.Company;
import ru.hh.fixture.beans.resume.ContactInformation;
import ru.hh.fixture.beans.resume.EducationHistory;
import ru.hh.fixture.beans.resume.Metro;
import ru.hh.fixture.beans.resume.Money;
import ru.hh.fixture.beans.resume.Phone;
import ru.hh.fixture.beans.resume.ProfessionalExperience;
import ru.hh.fixture.beans.resume.RecommendationInfo;
import ru.hh.fixture.beans.resume.RelocationInfo;
import ru.hh.fixture.beans.resume.ResumeCertificate;
import ru.hh.fixture.beans.resume.ResumeData;
import ru.hh.fixture.beans.resume.ResumeLanguage;
import ru.hh.fixture.beans.resume.UserImage;
import ru.hh.fixture.enums.resume.BusinessTripReadiness;
import ru.hh.fixture.enums.resume.EducationLevel;
import ru.hh.fixture.enums.resume.Employment;
import ru.hh.fixture.enums.resume.Gender;
import ru.hh.fixture.enums.resume.RegionEnum;
import ru.hh.fixture.enums.resume.ResumeAccessType;
import ru.hh.fixture.enums.resume.ResumeArea;
import ru.hh.fixture.enums.resume.ResumePreferredLink;
import ru.hh.fixture.enums.resume.ResumeSchedule;
import ru.hh.fixture.enums.resume.ResumeStatus;
import ru.hh.fixture.enums.resume.RoadTimeType;
import ru.hh.fixture.enums.resume.WorkExperience;

public class Resume {
  private final LocalDateTime today = LocalDateTime.now();
  private ResumeData resumeData = new ResumeData();
  private String url;
  private String lastName;
  private String firstName;
  private String middleName;
  private String email;
  private String professionalArea;
  private String[] specializationNames;
  private String[] companyBranches;
  private String[] phone;
  private String preferredCommunicationType;
  private String region;
  private RoadTimeType roadTime;
  private String roadTimeNew;
  private BusinessTripReadiness businessTripReadiness;
  private String language;
  private String metroStation;
  private String photoAddress;
  private String workPermit;
  private String ICQ;
  private String skype;
  private String socialNetwork;
  private String industry;
  private String phoneComment;
  private UserData user;
  private Collection<WorkExperience> experienceLevels = EnumSet.noneOf(WorkExperience.class);
  private Collection<ResumeSchedule> schedules = EnumSet.noneOf(ResumeSchedule.class);
  private Collection<Employment> employments = EnumSet.noneOf(Employment.class);

  /**
   * Конструктор с инициализацией данных в резюме.
   * Заполняет основные поля при создании.
   *
   * @param isOptionals Если true то заполняет дополнительные
   */
  public Resume(UserData user, Boolean isOptionals) {
    this.user = user;
    initRequired();
    if (isOptionals) {
      initOptional();
    }
  }

  public Resume(Boolean isOptionals) {
    this(new UserData(), isOptionals);
  }

  private Resume(UserData user) {
    this.user = user;
  }

  public Resume(UserData user, ResumeData resumeData) {
    this(user, true);
    this.resumeData = resumeData;
  }

  public Resume(ResumeData resumeData) {
    this(new UserData(), false);
    this.resumeData = resumeData;
  }

  public static Resume makeShortResume(UserData user) {
    Resume shortResume = new Resume(user);
    shortResume.setCreationTime(LocalDateTime.now());
    shortResume.setLastChangeTime(LocalDateTime.now());
    shortResume.setTitle("TEST_RESUME_" + "1232353ewfs");
    shortResume.setEducationHistory(EducationHistory.oneRecord("МАИ", "Аэрокосмический", "Магистр", LocalDate.now().minusDays(1000)));
    shortResume.setAboutMe("Умею писать автотесты");
    shortResume.setEducation(EducationLevel.HIGHER);
    shortResume.setLastName(user.getLastName());
    shortResume.setFirstName(user.getFirstName());
    shortResume.setGender(Gender.MALE);
    shortResume.setEmail(user.getEmail());
    shortResume.setPhone(new String[]{"7", "123", "1234567"});
    shortResume.setRegion("Москва");
    shortResume.setSpecializationNames(new String[]{"Добыча сырья"});
    //shortResume.initOptional();
    return shortResume;
  }

  public String getHash() {
    return resumeData.getHash();
  }

  public void setHash(String hash) {
    resumeData.setHash(hash);
  }

  public void initRequired() {
    setTitle("TEST_RESUME_" + "wefqwef24");
    ProfessionalExperience experience = new ProfessionalExperience();
    ProfessionalExperience.ExperienceRecord record = new ProfessionalExperience.ExperienceRecord("Хэдхантер", "Тестировщик",
        "Тестирование сайта", LocalDate.now().minusDays(500), LocalDate.now());
    ProfessionalExperience.ExperienceCompany experienceCompany = new ProfessionalExperience.ExperienceCompany("DHL Express");
    experienceCompany.setAreaId(1);
    Industries<Industries.SubCulture> firstIndustry = Industries.ISKUSSTVO_KULTURA;
    experienceCompany.setIndustry(firstIndustry.getIndustry());
    //experienceCompany.setIndustries(firstIndustry.getSubIndustry().MUZEJ_GALEREYA_TEATR.getIndustry(),
    //firstIndustry.getSubIndustry().ARKHIV_BIBLIOTEKA_ISKUSSTVOVEDENIE.getIndustry());
    experienceCompany.setUrl("http://some-kind.ru");
    experienceCompany.setCompany(new Company(272));
    record.setExperienceCompany(experienceCompany);
    experience.add(record);
    //setProfessionalExperience(experience);
    //setEducationHistory(EducationHistory.oneRecord("МАИ", "Аэрокосмический", "Магистр", LocalDate.now().minusDays(1000)));
    setAboutMe("Умею писать автотесты");
    setKeySkills(new String[]{"Графика", "Дизайн"});
    setEducation(EducationLevel.HIGHER);
    setLastName(user.getLastName());
    setFirstName(user.getFirstName());
    setGender(Gender.MALE);
    setEmail(user.getEmail());
    setPhone(new String[]{"7", "123", "1234567"});
    setRegion("Москва");
    setArea(RegionEnum.MOSCOW);
    setProfessionalArea("Закупки");
    setSpecializationNames(new String[]{"Сертификация", "FMCG, Товары народного потребления", "Химическая продукция"});
    setSpecializationIds(new int[]{415, 437, 411});
    setCreationTime(today);
    setLastChangeTime(today);
    ContactInformation contactInformation = new ContactInformation(user.getEmail(), ResumePreferredLink.CELL_PHONE);
    contactInformation.addPhone(ContactInformation.PhoneType.CELL,
        new Phone("7", "926", "123456", "Мой новенький мобильный телефон"));
    //setContactInformation(contactInformation);
    //setAccess(new Access(ResumeAccessType.CLIENTS));
    setCitizenship(new ResumeArea[]{ResumeArea.RUSSIA});
    setWorkTickets(new ResumeArea[]{});
    setResumeStatus(ResumeStatus.APPROVED);
  }

  public void initOptional() {
    setRoadTime(RoadTimeType.LESS_THAN_HOUR);
    setRoadTimeNew("Не более часа");
    setBusinessTripReadiness(BusinessTripReadiness.READY);
    setICQ("143458537");
    setSkype("wefqwef24");
    setSocialNetwork("Linked In");
    setIndustry("Информационные технологии, системная интеграция, интернет");
    setCompanyBranches(new String[]{"Разработка программного обеспечения", "Интернет-провайдер"});
    setDesireableCompensation(Money.USD(1500));
    setBirthdayDate(LocalDate.of(1966, 10, 10));
    //setRelocation(RelocationInfo.noRelocation());
    //setLanguagesInfo(new ResumeLanguage(1));
    setMiddleName(user.getMiddleName());
    setWorkExperience(WorkExperience.FROM_1_TO_3_YEAR);
    setLanguage("Русский");
    setMetroStation("Марксистская");
    //setRecommendationInfo(RecommendationInfo.oneRecord("Name", "Organization", "Pozition", "ContactInfo"));
    setEmployments(new HashSet<>(Collections.singletonList(Employment.FULL_TIME)));
    setResumeSchedules(new HashSet<>(Collections.singletonList(ResumeSchedule.FULL_DAY)));
//    setCertification(new Certification("655074", "NeilMCSE"));
  }

  //Вспомогательный метод для toString(). Позволяет не падать на нулах, добавляет кавычки.
  private String line(Object value) {
    return Joiner.on("").useForNull("null").join(Arrays.asList(" \'", value, "\'\n"));
  }

  @Override
  public String toString() {
    MoreObjects.ToStringHelper l = //Список на вывод
        MoreObjects.toStringHelper(this)
            .addValue("\n======================================== \n")
            .addValue("       APPLICANT RESUME \n")
            .addValue("====================================== \n")
            .add("Title", line(getTitle()))
            .add("Hash", line(getHash()))
            .add("Email", line(getEmail()))
            .add("Key skills", line(getKeySkills()))
            .add("First name", line(getFirstName()))
            .add("Last name", line(getLastName()))
            .add("Middle name", line(getMiddleName()))
            .add("Professional area", line(getProfessionalArea()))
            .add("Region", line(getRegion()))
            .add("BirthdayDate", line(getBirthdayDate()))
            .add("Gender", line(getGender()))
            .add("Education", line(getEducation()));

    l.addValue("Опыт работы :\n");
    if (getProfessionalExperience() != null) {
      for (ProfessionalExperience.ExperienceRecord expRecord : getProfessionalExperience().getAll()) {
        l.add("\tFrom", line(expRecord.getStartDate() + "',\tTo '" + expRecord.getEndDate()));
        l.add("\tOrganization name", line(expRecord.getOrganization()));
        l.add("\tPosition", line(expRecord.getPosition()));
        l.add("\tDescription", line(expRecord.getDescription()));
        l.addValue("\t........................................\n");
      }
    } else {
      l.addValue("блок опыт работы = null(не задан) \n");
    }

    l.addValue("Проф. область: \n");
    if (getSpecializationNames() != null) {
      for (int i = 0; i < getSpecializationNames().length; i++) {
        l.addValue("\t'" + getSpecializationNames()[i] + "'\n");
      }
    } else {
      l.addValue("блок проф. область = null(не задан) \n");
    }

    l.addValue("Образование: \n");
    if (getEducationHistory() != null) {
      for (EducationHistory.EducationRecord eduRecord : getEducationHistory().getAll()) {
        l.add("\tНазвание учеб. заведения", line(eduRecord.getName()));
        l.add("\tСпециальность", line(eduRecord.getDiploma()));
        l.add("\tФакультет", line(eduRecord.getFaculty()));
        l.add("\tДата оконч.", line(eduRecord.getEndDate()));
        l.addValue("\t........................................\n");
      }
    } else {
      l.addValue("блок образования = null(не задан) \n");
    }

    l.addValue("\n===================end=================== \n");
    return l.toString();
  }

  public String getMetroStation() {
    return metroStation;
  }

  public void setMetroStation(String metroStation) {
    this.metroStation = metroStation;
  }

  public Metro getNearestMetroStation() {
    return resumeData.getNearestMetro();
  }

  public void setNearestMetroStation(int metroStation) {
    resumeData.setNearestMetro(new Metro(metroStation));
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public RoadTimeType getRoadTime() {
    return roadTime;
  }

  public void setRoadTime(RoadTimeType roadTime) {
    this.roadTime = roadTime;
    resumeData.setRoadTime(roadTime);
  }

  public String getRoadTimeNew() {
    return roadTimeNew;
  }

  public void setRoadTimeNew(String roadTimeNew) {
    this.roadTimeNew = roadTimeNew;
  }

  public BusinessTripReadiness getBusinessTripReadiness() {
    return businessTripReadiness;
  }

  public void setBusinessTripReadiness(BusinessTripReadiness businessTripReadiness) {
    this.businessTripReadiness = businessTripReadiness;
    resumeData.setBusinessTripsReadiness(businessTripReadiness);
  }

  public String getFullName() {
    return lastName + " " + firstName + " " + middleName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getPreferredCommunicationType() {
    return preferredCommunicationType;
  }

  public void setPreferredCommunicationType(String preferredCommunicationType) {
    this.preferredCommunicationType = preferredCommunicationType;
  }

  public String[] getPhone() {
    return phone;
  }

  public void setPhone(String[] phone) {
    this.phone = phone;
  }

  public String getICQ() {
    return ICQ;
  }

  public void setICQ(String ICQ) {
    this.ICQ = ICQ;
  }

  public String getSkype() {
    return skype;
  }

  public void setSkype(String skype) {
    this.skype = skype;
  }

  public String getSocialNetwork() {
    return socialNetwork;
  }

  public void setSocialNetwork(String socialNetwork) {
    this.socialNetwork = socialNetwork;
  }

  public String getProfessionalArea() {
    return professionalArea;
  }

  public void setProfessionalArea(String professionalArea) {
    this.professionalArea = professionalArea;
  }

  public String[] getSpecializationNames() {
    return specializationNames;
  }

  public void setSpecializationNames(String[] specializations) {
    this.specializationNames = specializations;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Collection<WorkExperience> getExperienceLevels() {
    return experienceLevels;
  }

  public AdditionalEducation getAdditionalEducation() {
    return resumeData.getAdditionalEducation();
  }

  public void setAdditionalEducation(AdditionalEducation additionalEducation) {
    resumeData.setAdditionalEducation(additionalEducation);
  }

  public void setExperienceLevels(Collection<WorkExperience> experienceLevels) {
    this.experienceLevels = experienceLevels;
    Iterator<WorkExperience> iterator = experienceLevels.iterator();
    if (iterator.hasNext()) {
      setWorkExperience(iterator.next());
    }
  }

  public Collection<Employment> getEmployments() {
    return employments;
  }

  public void setEmployments(Set<Employment> employments) {
    resumeData.setEmployments(employments);
  }

  public void setEmployments(Collection<Employment> employments) {
    this.employments = employments;
    Set<Employment> employmentSet = employments.stream().collect(Collectors.toSet());
    resumeData.setEmployments(employmentSet);
  }

  public Collection<ResumeSchedule> getWorkSchedules() {
    return schedules;
  }

  public void setWorkSchedules(Collection<ResumeSchedule> schedules) {
    this.schedules = schedules;
    Set<ResumeSchedule> resumeSchedules = schedules.stream().collect(Collectors.toSet());
    resumeData.setResumeSchedules(resumeSchedules);
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getPhotoAddress() {
    return photoAddress;
  }

  public void setPhotoAddress(String photoName) {
    if (photoName != null) {
      this.photoAddress = "picture" + photoName;
    }
  }

  public ResumeArea[] getCitizenship() {
    return resumeData.getCitizenship();
  }

  public void setCitizenship(ResumeArea[] citizenship) {
    resumeData.setCitizenship(citizenship);
  }

  public String getWorkPermit() {
    return workPermit;
  }

  public void setWorkPermit(String workPermit) {
    this.workPermit = workPermit;
  }

  public String getIndustry() {
    return industry;
  }

  public void setIndustry(String industry) {
    this.industry = industry;
  }

  public String getPhoneComment() {
    return phoneComment;
  }

  public void setPhoneComment(String phoneComment) {
    this.phoneComment = phoneComment;
  }

  public Set<ResumeCertificate> getCertificates() {
    return resumeData.getCertificates();
  }

  //Методы, мигрировавшие из com.headhunter.webapp.fixture.Resume

  public void addCertificate(ResumeCertificate certificate) {
    resumeData.addCertificate(certificate);
  }

  public int getId() {
    return resumeData.getId();
  }

  public void setId(int id) {
    this.resumeData.setId(id);
  }

  public String getCode() {
    return String.valueOf(getId());
  }

  public int getResumeId() {
    return getId();
  }

  public UserData getApplicant() {
    return user;
  }

  public ResumeData getResumeInfo() {
    return resumeData;
  }

  public EducationLevel getEducationLevel() {
    return getEducation();
  }

  public String getCompensationWithComma() {
    DecimalFormat df = new DecimalFormat("###,###.##");
    return df.format(getDesireableCompensation().getAmmount());
  }

  public int getIndexationId() {
    return getId();
  }

  public String describeYourself() {
    return "Резюме";
  }

  public void setRelocation(RelocationInfo info) {
    resumeData.setRelocation(info);
  }

  public Gender getGender() {
    return resumeData.getGender();
  }

  public void setGender(Gender gender) {
    resumeData.setGender(gender);
  }

  public Access getAccess() {
    return resumeData.getAccess();
  }

  public void setAccess(Access access) {
    resumeData.setAccess(access);
  }

  public RecommendationInfo getRecommendationInfo() {
    return resumeData.getRecommendationInfo();
  }

  public void setRecommendationInfo(RecommendationInfo recommendationInfo) {
    resumeData.setRecommendationInfo(recommendationInfo);
  }

  public String getTitle() {
    return resumeData.getTitle();
  }

  public void setTitle(String title) {
    resumeData.setTitle(title);
  }

  public EducationLevel getEducation() {
    return resumeData.getEducation();
  }

  public void setEducation(EducationLevel education) {
    resumeData.setEducation(education);
  }

  public RegionEnum getArea() {
    return resumeData.getArea();
  }

  public void setArea(RegionEnum area) {
    resumeData.setArea(area);
  }

  public LocalDateTime getCreationTime() {
    return resumeData.getCreationTime();
  }

  public void setCreationTime(LocalDateTime creationTime) {
    resumeData.setCreationTime(creationTime);
  }

  public LocalDate getBirthdayDate() {
    return resumeData.getBirthdayDate();
  }

  public void setBirthdayDate(LocalDate birthdayDate) {
    resumeData.setBirthdayDate(birthdayDate);
  }

  public List<String> getKeySkills() {
    if (resumeData.getKeySkills() == null) {
      return Collections.emptyList();
    }
    return Lists.newArrayList(Arrays.asList(resumeData.getKeySkills()));
  }

  public void setKeySkills(String[] keySkills) {
    resumeData.setKeySkills(keySkills);
  }

  public ProfessionalExperience getProfessionalExperience() {
    return resumeData.getProfessionalExperience();
  }

  public void setProfessionalExperience(ProfessionalExperience professionalExperience) {
    resumeData.setProfessionalExperience(professionalExperience);
  }

  public RelocationInfo getRelocationInfo() {
    return resumeData.getRelocationInfo();
  }

  public String getKeywords() {
    return resumeData.getKeywords();
  }

  public void setAboutMe(String keywords) {
    resumeData.setKeywords(keywords);
  }

  public String getAboutMe(){
    return resumeData.getKeywords();
  }

  public ResumeStatus getResumeStatus() {
    return resumeData.getResumeStatus();
  }

  public void setResumeStatus(ResumeStatus resumeStatus) {
    resumeData.setResumeStatus(resumeStatus);
  }

  public LocalDateTime getLastChangeTime() {
    return resumeData.getLastChangeTime();
  }

  public void setLastChangeTime(LocalDateTime lastChangeTime) {
    resumeData.setLastChangeTime(lastChangeTime);
  }

  public Money getDesireableCompensation() {
    return resumeData.getDesirableCompensation();
  }

  public void setDesireableCompensation(Money compensation) {
    resumeData.setDesirableCompensation(compensation);
  }

  public EducationHistory getEducationHistory() {
    return resumeData.getEducationHistory();
  }

  public void setEducationHistory(EducationHistory educationHistory) {
    resumeData.setEducationHistory(educationHistory);
  }

  public ResumeArea[] getWorkTickets() {
    return resumeData.getWorkTickets();
  }

  public void setWorkTickets(ResumeArea[] workTickets) {
    resumeData.setWorkTickets(workTickets);
  }

  public int[] getSpecializationIds() {
    return resumeData.getSpecializationIds();
  }

  public void setSpecializationIds(int[] specializationIds) {
    resumeData.setSpecializationIds(specializationIds);
  }

  public ResumeLanguage getLanguagesInfo() {
    return resumeData.getLanguagesInfo();
  }

  public void setLanguagesInfo(ResumeLanguage languagesInfo) {
    resumeData.setLanguagesInfo(languagesInfo);
  }

  public void setResumeSchedule(Set<ResumeSchedule> resumeSchedules) {
    resumeData.setResumeSchedules(resumeSchedules);
  }

  public Set<ResumeSchedule> getResumeSchedules() {
    return resumeData.getResumeSchedules();
  }

  public void setResumeSchedules(Set<ResumeSchedule> resumeSchedules) {
    resumeData.setResumeSchedules(resumeSchedules);
  }

  public WorkExperience getWorkExperience() {
    return resumeData.getWorkExperience();
  }

  public void setWorkExperience(WorkExperience workExperience) {
    resumeData.setWorkExperience(workExperience);
  }

  public Set<Employment> getEmployment() {
    return resumeData.getEmployments();
  }

  public void setResumeData(ResumeData resumeData) {
    this.resumeData = resumeData;
  }

  public String[] getCompanyBranches() {
    return companyBranches;
  }

  public void setCompanyBranches(String[] companyBranches) {
    this.companyBranches = companyBranches;
  }

  public int getSiteId() {
    return resumeData.getSiteId();
  }

  public void setSiteId(int siteId) {
    resumeData.setSiteId(siteId);
  }

  public void setResumePhoto(UserImage image) {
    resumeData.setResumePhoto(image);
  }

  public void setResumePhoto(String fileName) {
    Gallery gallery = new Gallery(user.getUserId());
    gallery.addPhotoFromResources(fileName);
    resumeData.setResumePhoto(gallery.getArtifacts().get(0));
  }

  public void setResumePortfolio(List<UserImage> artifacts) {
    resumeData.setResumePortfolio(artifacts);
  }

  public void setResumePortfolio(Gallery gallery) {
    resumeData.setResumePortfolio(gallery.getArtifacts());
  }

  public ContactInformation getContactInformation() {
    return resumeData.getContactInformation();
  }

  public void setContactInformation(ContactInformation contactInformation) {
    resumeData.setContactInformation(contactInformation);
  }

  public static Builder builder(UserData applicant) {
    return new Builder(applicant);
  }

  //------ билдер для создания резюме ---- \\
  public static final class Builder {
    private Resume resume;

    private Builder(UserData applicant) {
      resume = new Resume(applicant, true);
    }

    public Builder access(ResumeAccessType access) {
      this.resume.setAccess(new Access(access));
      return this;
    }

    public Builder access(Access access) {
      this.resume.setAccess(access);
      return this;
    }

    public Builder relocation(RelocationInfo info) {
      this.resume.setRelocation(info);
      return this;
    }

    public Builder url(String url) {
      this.resume.url = url;
      return this;
    }

    public Builder lastName(String lastName) {
      this.resume.lastName = lastName;
      return this;
    }

    public Builder firstName(String firstName) {
      this.resume.firstName = firstName;
      return this;
    }

    public Builder middleName(String middleName) {
      this.resume.middleName = middleName;
      return this;
    }

    public Builder email(String email) {
      this.resume.email = email;
      return this;
    }

    public Builder professionalArea(String profA) {
      this.resume.professionalArea = profA;
      return this;
    }

    public Builder specializationNames(String[] speciN) {
      this.resume.specializationNames = speciN;
      return this;
    }

    public Builder specializationsID(int[] spes) {
      this.resume.getResumeInfo().setSpecializationIds(spes);
      return this;
    }

    public Builder companyBranches(String[] compaB) {
      this.resume.companyBranches = compaB;
      return this;
    }

    public Builder phone(String[] pho) {
      this.resume.phone = pho;
      return this;
    }

    public Builder preferredCommunicationType(String preferredC) {
      this.resume.preferredCommunicationType = preferredC;
      return this;
    }

    public Builder region(String region) {
      this.resume.region = region;
      return this;
    }

    public Builder roadTimeNew(String roadTimeN) {
      this.resume.roadTimeNew = roadTimeN;
      return this;
    }

    public Builder businessTrips(BusinessTripReadiness businessT) {
      this.resume.businessTripReadiness = businessT;
      return this;
    }

    public Builder language(String lang) {
      this.resume.language = lang;
      return this;
    }

    public Builder metroStation(String photoA) {
      this.resume.photoAddress = photoA;
      return this;
    }

    public Builder workPermit(String workP) {
      this.resume.workPermit = workP;
      return this;
    }

    public Builder skype(String skype) {
      this.resume.skype = skype;
      return this;
    }

    public Builder socialNetwork(String socialN) {
      this.resume.socialNetwork = socialN;
      return this;
    }

    public Builder industry(String ind) {
      this.resume.industry = ind;
      return this;
    }

    public Builder phoneComment(String phoneCo) {
      this.resume.phoneComment = phoneCo;
      return this;
    }

    public Builder experienceLevels(Collection<WorkExperience> exp) {
      this.resume.experienceLevels = exp;
      return this;
    }

    public Builder schedules(Collection<ResumeSchedule> sch) {
      this.resume.schedules = sch;
      return this;
    }

    public Builder employments(Collection<Employment> emps) {
      this.resume.employments = emps;
      return this;
    }

    public Builder area(RegionEnum area) {
      this.resume.setArea(area);
      return this;
    }

    public Builder gender(Gender gender) {
      this.resume.getResumeInfo().setGender(gender);
      return this;
    }

    public Builder resumeStatus(ResumeStatus stat) {
      this.resume.getResumeInfo().setResumeStatus(stat);
      return this;
    }

    public Builder desireableMoney(Money mo) {
      this.resume.getResumeInfo().setDesirableCompensation(mo);
      return this;
    }

    public Builder keywords(String keywords) {
      this.resume.setAboutMe(keywords);
      return this;
    }

    public Builder title(String title) {
      this.resume.setTitle(title);
      return this;
    }

    public Resume build() {
      return resume;
    }
  }
}
