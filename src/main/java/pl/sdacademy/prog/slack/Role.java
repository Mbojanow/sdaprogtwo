package pl.sdacademy.prog.slack;

import java.util.Arrays;
import java.util.List;

public enum Role {
  USER(AccessType.READ),
  ADMIN(AccessType.READ, AccessType.WRITE);

  private List<AccessType> accessTypes;
  //enum - konstruktor zawsze jest prywatny
  Role(AccessType ...accessTypes) {
    this.accessTypes = Arrays.asList(accessTypes);
  }

  public List<AccessType> getAccessTypes() {
    return accessTypes;
  }
}
