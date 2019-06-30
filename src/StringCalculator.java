public class StringCalculator {
   public StringCalculator() {
   }
   String delimiter;

   public int Add(String numbers){

      if (numbers.isEmpty()) {               // "" case
         return 0;
      } else if (numbers.contains("\n") || numbers.contains(",")) {    //"number,number,..." case
         int result=0;
         String split[]=numbers.split("\\n|,");
         for(int i=split.length-1;i>=0;i--){
            result+=Integer.valueOf(split[i]);
         }
         return result;
      } else {                             //"number" case
         int num = Integer.valueOf(numbers);
         return num;
      }
   }
}