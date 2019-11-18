package org.sonar.samples.java.checks;
 
import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

 
public class SwitchControlTest {
 
  @Test
  public void test() {
    JavaCheckVerifier.verify("src/test/files/SwitchControl.java", new SwitchControl());
  }
 
}