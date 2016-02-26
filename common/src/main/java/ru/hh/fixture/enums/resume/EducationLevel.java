package ru.hh.fixture.enums.resume;

public enum EducationLevel {
  HIGHER(1), // Высшее
  BACHELOR(2), // Высшее Бакалавр
  MASTER(3),   // Высшее Магистр
  CANDIDATE(4),  // Высшее Кандидат Наук
  DOCTOR(5),     // Высшее Доктор Наук
  UNFINISHED_HIGHER(6), // Незаконченное Высшее
  SECONDARY(7),      // Среднее
  SPECIAL_SECONDARY(8);   // Среднее Специальное

  private final int id;

  EducationLevel(int id) {
    this.id = id;
  }

  public int id() {
    return id;
  }

  public Integer getValue() {
    return id;
  }
}
