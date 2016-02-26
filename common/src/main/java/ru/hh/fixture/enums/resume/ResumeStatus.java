package ru.hh.fixture.enums.resume;

/** This enum just a limited copy from hh-core. */
public enum ResumeStatus {
  /**
   * Approved by resume moderator - resume correct
   */
  APPROVED(2),
  /**
   * Blocked by resume moderator - resume not correct
   */
  BLOCKED(3),
  /**
   * Resume was modified after it was denied by moderator
   */
  CORRECTED(5),
  /**
   * Removed by resume moderator due resume is very bad.
   */
  DELETED(6),
  /**
   * Resume was modified after it was approved by moderator Old name is 'RECHECK'
   */
  MODIFIED(1),
  NEW(0),
  NOT_FINISHED(-1),
  UNKNOWN(Integer.MIN_VALUE);
  private int value;

  ResumeStatus(final int value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }

  public ResumeStatus getFallback() {
    return UNKNOWN;
  }
}
