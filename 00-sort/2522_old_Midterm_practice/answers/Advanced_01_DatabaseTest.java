package org.bcit.comp2522.winter2023.midterm_takeup.answers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class Advanced_01_DatabaseTest {

  @Test
  void testSingletonInstance() {
    Advanced_01_DB db1 = Advanced_01_DB.getInstance("1.0");
    Advanced_01_DB db2 = Advanced_01_DB.getInstance("2.0");

    assertSame(db1, db2);
    assertEquals("1.0", db1.getDbVersion());
    assertEquals("1.0", db2.getDbVersion());
  }

  @Test
  void testConnectAndDisconnect() {
    Advanced_01_DB db = Advanced_01_DB.getInstance("1.0");
    assertEquals(false, db.isConnected());

    db.connect();
    assertEquals(true, db.isConnected());

    db.disconnect();
    assertEquals(false, db.isConnected());
  }

  @Test
  void testDbVersion() {
    Advanced_01_DB db = Advanced_01_DB.getInstance("1.0");
    assertEquals("1.0", db.getDbVersion());
  }
}
