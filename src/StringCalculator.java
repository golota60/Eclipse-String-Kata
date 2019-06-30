public class StringCalculator {
   public StringCalculator() {
   }

   String setDelimiter(String str) {
      String result = ",";
      if (str.startsWith("//")) {
         result = str.substring(2, 3);
      }
      return result;
   }

   int calculate(String delimiter, String str) {
      int result = 0;
      String msg="";
      String split[] = str.split("\\n|,|" + delimiter); //using double backslash to detect \n
      for (int i = split.length - 1; i >= 0; i--) { //if i have to display all the negatives, i have to iterate through whole array anyway
         result += Integer.valueOf(split[i]);
         if(Integer.valueOf(split[i])<0){
            msg+=split[i] + " ";
         }
      }
      if(!msg.isEmpty()){
         throw new IllegalArgumentException("negatives not allowed: " + msg);
      }
      return result;
   }

   public int Add(String numbers) {
      //default delimiter : ",'
      String delimiter;

      if (numbers.isEmpty()) {               // "" case
         return 0;
      }
      delimiter = setDelimiter(numbers);
      if (numbers.contains("\n") || numbers.contains(",") || numbers.contains(delimiter)) {
         if (delimiter.isEmpty()) { //if there's no delimiter we go here
            return calculate(delimiter, numbers);
         } else {
            numbers = numbers.replace("//" + delimiter + "\n", "");
            return calculate(delimiter, numbers);
         }
      }
      int num = Integer.valueOf(numbers);
      return num;
   }
}