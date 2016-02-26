package ru.hh.fixture.enums.resume;

public enum WorkExperience {
  NO_EXPERIENCE("Нет опыта", "не требуется", 0),
  FROM_1_TO_3_YEAR("1-3 года", "1-3 года", 1),
  FROM_3_TO_6_YEAR("3-6 лет", "3-6 лет", 2),
  MORE_THAN_6_YEAR("Более 6 лет", "более 6 лет", 3);

  public static final String WORK_EXPERIENCE_XPATH = "//input[@name='experience' and @value=%s)]";

  private String name;
  private String description;
  private int value;
  private String xpath;

  private WorkExperience(String name, String description, int value) {
    this.name = name;
    this.description = description;
    this.value = value;
    this.xpath = String.format(WORK_EXPERIENCE_XPATH, value);
  }

  public static WorkExperience getByText(String text) {
    for (WorkExperience experience : WorkExperience.values()) {
      if (experience.getName().equals(text) || experience.getDescription().equals(text)) {
        return experience;
      }
    }
    return null;
  }

  public String getName() {
    return name;
  }

  public int getResumeSearchValue(){
    return value;
  }

  public String getResumeSearchXpath(){
    return xpath;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getValue() {
    return value;
  }
}