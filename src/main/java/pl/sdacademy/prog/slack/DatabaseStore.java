package pl.sdacademy.prog.slack;

import java.util.ArrayList;
import java.util.List;

public class DatabaseStore {

  private DatabaseConnection databaseConnection;
  private List<String> data = new ArrayList<>();

  public DatabaseStore(final DatabaseConnection databaseConnection) {
    this.databaseConnection = databaseConnection;
  }

  public void add(final String value) {
    if (!databaseConnection.isOpen()) {
      databaseConnection.open();
    }

    if (databaseConnection.isOpen()) {
      data.add(value);
    }
  }

  public List<String> getData() {
    return data;
  }
}
