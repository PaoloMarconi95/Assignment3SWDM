package org.sonar.samples.java.checks;
 
import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

 
public class TooManyArgumentsTest {
 
  @Test
  public void test() {
    JavaCheckVerifier.verify("src/test/files/TooManyArguments.java", new TooManyArguments());
  }
 
}