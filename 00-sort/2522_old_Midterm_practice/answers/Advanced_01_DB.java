package org.bcit.comp2522.winter2023.midterm_takeup.answers;

public class Advanced_01_DB {
  private static Advanced_01_DB instance;

  private String dbVersion;
  private boolean isConnected;

  private Advanced_01_DB(String dbVersion) {
    this.dbVersion = dbVersion;
    this.isConnected = false;
  }

  public static Advanced_01_DB getInstance(String dbVersion) {
    if (instance == null) {
      instance = new Advanced_01_DB(dbVersion);
    }
    return instance;
  }

  public String getDbVersion() {
    return dbVersion;
  }

  public boolean isConnected() {
    return isConnected;
  }

  public void connect() {
    isConnected = true;
  }

  public void disconnect() {
    isConnected = false;
  }
}
