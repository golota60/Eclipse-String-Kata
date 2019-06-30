import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {

//1
   @Test
   public void firstTask1() {
   StringCalculator calc = new StringCalculator();
      assertEquals(0,calc.Add(""));
   }

   @Test
   public void firstTask2() {
      StringCalculator calc = new StringCalculator();
      assertEquals(1,calc.Add("1"));
   }

   @Test
   public void firstTask3() {
      StringCalculator calc = new StringCalculator();
      assertEquals(3,calc.Add("1,2"));
   }
}