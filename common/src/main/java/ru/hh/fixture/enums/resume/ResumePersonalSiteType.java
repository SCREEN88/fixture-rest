package ru.hh.fixture.enums.resume;

public enum ResumePersonalSiteType {
  PERSONAL(0),
  LIVE_HH(1),
  MOI_KRUG(2),
  LIVEJOURNAL(3),
  LINKEDIN(4),
  FREELANCE(5),
  FACEBOOK(6),

  //messengers
  SKYPE(7),
  ICQ(8),
  JABBER(9);

  private int value;

  ResumePersonalSiteType(int value) {
    this.value = value;
  }

  public Integer getValue() {
    return value;
  }
}
