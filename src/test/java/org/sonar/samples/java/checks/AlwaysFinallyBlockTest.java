package org.sonar.samples.java.checks;
 
import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

 
public class AlwaysFinallyBlockTest {
 
  @Test
  public void test() {
    JavaCheckVerifier.verify("src/test/files/AlwaysFinallyBlock.java", new AlwaysFinallyBlock());
  }
 
}