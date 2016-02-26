package ru.hh.fixture.enums.resume;

public enum LanguageLevel {
  UNKNOWN(-1, ""),
  NONE(0, ""),
  BASIC(1, "базовые знания"),
  CAN_READ(2, "читаю профессиональную литературу"),
  CAN_PASS_INTERVIEW(3, "могу проходить интервью"),
  FLUENT(4, "свободно владею"),
  NATIVE(5, "родной");

  private final int id;
  private final String text;

  LanguageLevel(int id, String text) {
    this.id = id;
    this.text = text;
  }

  public int id() {
    return id;
  }

  public String getText() {
    return text;
  }

  public Integer getValue() {
    return id;
  }

  public static LanguageLevel getByText(String text) {
    for (LanguageLevel lg : LanguageLevel.values()) {
      if (lg.text.equals(text)){
        return lg;
      }
    }
    throw new IllegalArgumentException("LanguageLevel not found!");
  }
}
