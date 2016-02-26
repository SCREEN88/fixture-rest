package ru.hh.fixture.beans.resume;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import ru.hh.fixture.enums.resume.ResumePersonalSiteType;
import ru.hh.fixture.enums.resume.ResumePreferredLink;

public class ContactInformation implements Serializable {
  private final Map<ResumePersonalSiteType, String> personalSiteMap;
  private final Map<PhoneType, Phone> phone;
  private final String email;
  private final ResumePreferredLink preferredLink;

  public ContactInformation(String email, ResumePreferredLink preferredLink) {
    this.email = email;
    this.preferredLink = preferredLink;
    personalSiteMap = new HashMap<>();
    phone = new HashMap<>();
  }

  public Map<ResumePersonalSiteType, String> getPersonalSiteMap() {
    return personalSiteMap;
  }

  public String getPersonalSite(ResumePersonalSiteType type) {
    return personalSiteMap.get(type);
  }

  public void addPersonalSite(ResumePersonalSiteType type, String value) {
    personalSiteMap.put(type, value);
  }

  public Map<PhoneType, Phone> getPhoneMap() {
    return phone;
  }

  public Phone getPhone(PhoneType type) {
    return phone.get(type);
  }

  public void addPhone(PhoneType type, Phone phone) {
    this.phone.put(type, phone);
  }

  public String getEmail() {
    return email;
  }

  public ResumePreferredLink getPreferredLink() {
    return preferredLink;
  }

  public enum PhoneType {
    CELL, HOME, WORK
  }
}
