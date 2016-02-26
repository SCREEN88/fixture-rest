package ru.hh.fixture.enums.resume;

/**
 * This enumeration just a limited copy from hh-core.
 */
public enum ResumeAccessType {
  NO_ONE(0),
  WHITELIST(1, true),
  BLACKLIST(2, true),
  CLIENTS(3),
  EVERYONE(5),
  DIRECT(6);

  private int value;
  private boolean needIds = false;

  ResumeAccessType(final int value) {
    this.value = value;
  }

  ResumeAccessType(final int value, final boolean needIds) {
    this(value);
    this.needIds = needIds;
  }

  public Integer getValue() {
    return value;
  }

  public boolean needIds() {
    return needIds;
  }
}
