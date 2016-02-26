package ru.hh.fixture.enums.resume;

@Deprecated
public enum ResumeArea {
  RUSSIA("Россия"),
  BELARUS("Беларусь"),
  UKRAINE("Украина"),
  KAZAKHSTAN("Казахстан"),
  AZERBAIJAN("Азербайджан и Кавказ");

  private final String text;

  ResumeArea(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}
