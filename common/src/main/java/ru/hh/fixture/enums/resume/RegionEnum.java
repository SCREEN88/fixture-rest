package ru.hh.fixture.enums.resume;

public enum RegionEnum {
  NONE(0, ""),
  MOSCOW(1, "Москва"),
  SANKT_PETERBURG(2, "Санкт-петербург"),
  PENZA(71, "Пенза"),
  RUSSIA(113, "Россия"),
  KIEV(115, "Киев"),
  ASTANA(159, "Астана"),
  MINSK(1002, "Минск"),
  NOVOSIBIRSK(4, "Новосибирск"),
  BAKU (2492, "Баку");

  private final int id;
  private final String readableName;

  RegionEnum(int id, String readableName) {
    this.id = id;
    this.readableName = readableName;
  }

  public int id() {
    return id;
  }

  public String getReadableName() {
    return readableName;
  }
}
