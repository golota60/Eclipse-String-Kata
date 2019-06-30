public class StringCalculator {
      public int Add(String numbers){
         if (numbers.isEmpty()) {               // "" case
            return 0;
         } else if (numbers.contains(",")) {    //"number,number" case
            String split[]=numbers.split(",");
            int num1=Integer.valueOf(split[0]);
            int num2=Integer.valueOf(split[1]);
            return num1+num2;
         } else {                             //"number" case
            int num = Integer.valueOf(numbers);
            return num;
         }
      }
   }

