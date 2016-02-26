package ru.hh.fixture;

import ru.hh.fixture.beans.resume.Industry;

public class Industries<T> {
  public static final Industries<SubCulture> ISKUSSTVO_KULTURA = new Industries<>(52, "Искусство, культура", new SubCulture());

  private final int id;
  private final String text;
  private final T subCulture;

  private Industries(int id, String text, T subCulture) {
    this.id = id;
    this.text = text;
    this.subCulture = subCulture;
  }

  public int getId() {
    return id;
  }

  public String getText() {
    return text;
  }

  public T getSubIndustry() {
    return subCulture;
  }

  public Industry getIndustry(){
    return new Industry(id);
  }

  public static class SubCulture{
    public final SubIndustriesValues ARKHIV_BIBLIOTEKA_ISKUSSTVOVEDENIE = new SubIndustriesValues(623, "Музей, галерея, театр");
    public final SubIndustriesValues BOTANICHESKIJ_SAD_ZOOPARK_ZAPOVEDNIK = new SubIndustriesValues(624, "Ботанический сад, зоопарк, заповедник");
    public final SubIndustriesValues MUZEJ_GALEREYA_TEATR = new SubIndustriesValues(625, "Архив, библиотека, искусствоведение");
    private SubCulture() {}
  }

  public static class SubIndustriesValues {
    private final int id;
    private final String text;

    private SubIndustriesValues(int id, String text) {
      this.id = id;
      this.text = text;
    }

    public int getId(){
      return id;
    }

    public String getText() {
      return text;
    }

    public Industry getIndustry(){
      return new Industry(id, text);
    }
  }
}
