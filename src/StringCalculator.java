import java.util.regex.Pattern;

public class StringCalculator {
   public StringCalculator() {
   }


   String setDelimiter(String str) {
      String result = ",";
      if (str.startsWith("//")) {
         if (str.contains("]")) { //multiple char delimiter
            result=str.substring(str.indexOf("[")+1,str.indexOf("]"));
         } else { //single char delimiter
            result = str.substring(2, 3);
         }
      }
      return result;
   }

   int calculate(String delimiter, String str) {
      int result = 0;
      String msg = "";
      int asInt;
      if(str.contains("]")){ //multiple char delimiter check
         str=str.replace(str.substring(0,str.indexOf("]")+1)+"\n","");
      } else {
         str = str.replace("//" + delimiter + "\n", "");
      }

      String split[] = str.split("\\n|,|" + Pattern.quote(delimiter));
      for (int i = split.length - 1; i >= 0; i--) {
         asInt = Integer.valueOf(split[i]);
         if (asInt < 1000) {
            result += asInt;
         }
         if (asInt < 0) {
            msg += split[i] + " ";
         }
      }
      if (!msg.isEmpty()) {
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
            return calculate(delimiter, numbers);
      }
      int num = Integer.valueOf(numbers);
      return num;
   }
}