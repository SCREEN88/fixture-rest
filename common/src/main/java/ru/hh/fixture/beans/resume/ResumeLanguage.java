package ru.hh.fixture.beans.resume;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import ru.hh.fixture.enums.resume.LanguageLevel;

public class ResumeLanguage implements Serializable {
  private Map<Integer, LanguageLevel> languageLevel = new HashMap<>(6);
  private int nativeLanguage;

  public ResumeLanguage(int id) {
    setNativeLanguage(id);
  }

  public void setNativeLanguage(int id) {
    languageLevel.remove(nativeLanguage);
    nativeLanguage = id;
    languageLevel.put(nativeLanguage, LanguageLevel.NATIVE);
  }

  public void addSpeakingLanguage(int id, LanguageLevel level) {
    if (id != nativeLanguage && level != LanguageLevel.NATIVE) {
      languageLevel.put(id, level);
    }
  }

  public void removeSpeakingLanguage(int id) {
    if (id != nativeLanguage) {
      languageLevel.remove(id);
    }
  }

  public void addSpeakingLanguages(Map<Integer, LanguageLevel> languageLevelMap) {
    languageLevelMap.entrySet().stream()//use stream, because if put immutable map, i get an error
        .filter(entry -> entry.getKey() != nativeLanguage)
        .forEach(entry -> languageLevel.put(entry.getKey(), entry.getValue()));
  }

  public Map<Integer, LanguageLevel> getAll() {
    return languageLevel;
  }
}
