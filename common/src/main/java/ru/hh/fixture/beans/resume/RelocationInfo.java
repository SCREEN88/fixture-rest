package ru.hh.fixture.beans.resume;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ru.hh.fixture.enums.resume.RegionEnum;
import ru.hh.fixture.enums.resume.RelocationEnum;

public final class RelocationInfo implements Serializable {
  private RelocationEnum relocation;
  private ArrayList<Integer> regionIds;
  private List<RegionEnum> regions;

  private RelocationInfo(RelocationEnum relocation, List<RegionEnum> regions) {
    this.relocation = relocation;
    this.regions = regions;
    ArrayList<Integer> ids = new ArrayList<>(regions.size());
    for (RegionEnum each : regions) {
      ids.add(each.id());
    }
    this.regionIds = ids;
  }

  public List<RegionEnum> getRegionEnums() {
    return regions;
  }

  public RelocationEnum getRelocation() {
    return relocation;
  }

  public ArrayList<Integer> getRegionIds() {
    return regionIds;
  }

  public static RelocationInfo noRelocation() {
    return new RelocationInfo(RelocationEnum.NO, new ArrayList<RegionEnum>(0));
  }

  public static RelocationInfo possibly(RegionEnum... regions) {
    return new RelocationInfo(RelocationEnum.POSSIBLY, Arrays.asList(regions));
  }

  public static RelocationInfo desirable(RegionEnum... regions) {
    return new RelocationInfo(RelocationEnum.DESIRABLE, Arrays.asList(regions));
  }
}
