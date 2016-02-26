package ru.hh.fixture.beans.resume;

import java.io.Serializable;
import ru.hh.fixture.enums.resume.UserImageType;

public class UserImage implements Serializable {
  private int userId;
  private byte[] data;
  private String fileName;
  private UserImageType userImageType;
  private String title;
  private int id;

  public UserImage(int userId, byte[] data, String fileName, UserImageType userImageType, String title) {
    this.userId = userId;
    this.data = data;
    this.fileName = fileName;
    this.userImageType = userImageType;
    this.title = title;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getUserId() {
    return userId;
  }

  public void setData(byte[] data) {
    this.data = data;
  }

  public byte[] getData() {
    return data;
  }

  public String getFileName() {
    return fileName;
  }

  public UserImageType getUserImageType() {
    return userImageType;
  }

  public String getTitle() {
    return title;
  }
}
