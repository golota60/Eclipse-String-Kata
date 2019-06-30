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

   //2

   @Test
   public void secondTask1() {
      StringCalculator calc = new StringCalculator();
      assertEquals(6,calc.Add("1,2,3"));
   }

   @Test
   public void secondTask2() {
      StringCalculator calc = new StringCalculator();
      assertEquals(10,calc.Add("1,2,3,4"));
   }

   //3

   @Test
   public void thirdTask1() {
      StringCalculator calc = new StringCalculator();
      assertEquals(10,calc.Add("1\n2,3\n4"));
   }

   @Test
   public void thirdTask2() {
      StringCalculator calc = new StringCalculator();
      assertEquals(15,calc.Add("1\n2,3\n4,5"));
   }

   //4

   @Test
   public void fourthTask1() {
      StringCalculator calc = new StringCalculator();
      assertEquals(15,calc.Add("//;\n1\n2;3\n4,5"));
   }

   @Test
   public void fourthTask2() {
      StringCalculator calc = new StringCalculator();
      assertEquals(15,calc.Add("//;\n1\n2;3,4;5"));
   }
}