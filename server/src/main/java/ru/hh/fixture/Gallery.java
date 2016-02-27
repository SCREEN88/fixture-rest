package ru.hh.fixture;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import ru.hh.fixture.beans.UserData;
import ru.hh.fixture.beans.resume.UserImage;
import ru.hh.fixture.enums.resume.UserImageType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Gallery {
  private static final int MAX_FILE_SIZE = 6291456;
  private final int userId;
  private final List<UserImage> artifacts;

  public Gallery(int userId) {
    this.userId = userId;
    artifacts = new ArrayList<>();
  }

  public Gallery(UserData userData) {
    this(userData.getUserId());
  }

  public void addPhotoFromResources(String file) {
    addArtifact(file, UserImageType.RESUME_PHOTO, null);
  }

  public void addPortfolioFromResources(String file, String title) {
    addArtifact(file, UserImageType.PORTFOLIO, title);
  }

  public List<UserImage> getArtifacts() {
    return artifacts;
  }

  private void addArtifact(String fileName, UserImageType type, String title) {
    if (StringUtils.isEmpty(FilenameUtils.getExtension(fileName))) {
      throw new IllegalArgumentException("File has no extension!");
    }
    try {
      byte[] file = IOUtils.toByteArray(getClass().getClassLoader().getResourceAsStream(fileName));
      if (file.length > MAX_FILE_SIZE) {
        throw new IOException("File size must be less then " + MAX_FILE_SIZE + " bytes.");
      }
      artifacts.add(new UserImage(userId, file, fileName, type, title));
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException();
    }
  }
}
