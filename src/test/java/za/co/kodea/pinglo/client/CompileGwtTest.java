package za.co.kodea.pinglo.client;

import com.google.gwt.junit.client.GWTTestCase;

public class CompileGwtTest extends GWTTestCase {
  
  @Override
  public String getModuleName() {
    return "za.co.kodea.pinglo.Project";
  }

  public void testSandbox() {
    assertTrue(true);
  }
  
}
