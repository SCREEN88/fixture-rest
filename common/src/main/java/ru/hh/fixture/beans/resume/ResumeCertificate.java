package ru.hh.fixture.beans.resume;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ResumeCertificate implements Serializable {
  public enum Type {
    CUSTOM("custom"),
    MS("microsoft");

    private String typeId;

    Type(String typeId) {
      this.typeId = typeId;
    }

    public String getId() {
      return typeId;
    }
  }

  private Type type;
  private String ownerName;
  private String transcriptionId;
  private String accessCode;

  private String title;
  private LocalDate achievementDate;
  private String url;
  private boolean selected;

  private ResumeCertificate() {
  }

  public static ResumeCertificate createCustomCertificate(String title, LocalDate date, String url) {
    ResumeCertificate certificate = new ResumeCertificate();
    certificate.type = Type.CUSTOM;
    certificate.title = title;
    certificate.achievementDate = date;
    certificate.url = url;
    certificate.selected = true;
    return certificate;
  }

  public static ResumeCertificate createMSCertificate(String title, LocalDate date, String url, String owner, String id,
                                                      String accessCode, Boolean selected) {
    ResumeCertificate certificate = ResumeCertificate.createCustomCertificate(title, date, url);
    certificate.type = Type.MS;
    certificate.ownerName = owner;
    certificate.transcriptionId = id;
    certificate.accessCode = accessCode;
    certificate.selected = selected;
    return certificate;
  }

  public static ResumeCertificate createMSCertificate(String id, String accessCode) {
    ResumeCertificate certificate = new ResumeCertificate();
    certificate.type = Type.MS;
    certificate.transcriptionId = id;
    certificate.accessCode = accessCode;
    return certificate;
  }

  public Type getType() {
    return type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  public String getTranscriptionId() {
    return transcriptionId;
  }

  public void setTranscriptionId(String transcriptionId) {
    this.transcriptionId = transcriptionId;
  }

  public String getAccessCode() {
    return accessCode;
  }

  public void setAccessCode(String accessCode) {
    this.accessCode = accessCode;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public LocalDate getAchievementDate() {
    return achievementDate;
  }

  public void setAchievementDate(LocalDate achievementDate) {
    this.achievementDate = achievementDate;
  }

  public String getYear() {
    return this.achievementDate.format(DateTimeFormatter.ofPattern("yyyy"));
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public boolean isSelected() {
    return selected;
  }

  public void setSelected(boolean selected) {
    this.selected = selected;
  }
}
