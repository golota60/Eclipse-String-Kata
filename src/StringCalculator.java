import java.util.regex.Pattern;

public class StringCalculator {
   public StringCalculator() {
   }

   //SYNTAX
   //default delimiters:"\n" or ","
   //ex."arg,arg\narg..."
   //SINGLE CHAR DELIMITER(stil supports default delimiters)
   //"//delimiter\narguments"
   //MULTIPLE DELIMITERS SYNTAX(still supports default delimiters)
   //"//[delimiter]...[delimiterN]\narguments"

   //in case anybody wanted to change syntax
   //    STARTING_SYNTAX are the first characters letting know that custom delimiter is going to be used
   //    STOPPER is the value that will stop the program from inputing more delimiters
   //    delimiter stoppers are the brackets you set the custom delimiters with ex.[***],{***}
   //    default delimiters are delimiters that will work even if you don't set any custom delimiters
   //    TO_IGNORE is the number that sets the bar for ignored numbers

   private static final String STARTING_SYNTAX = "//";
   private static final String DEFAULT_DELIMITER = "\n";
   private static final String DEFAULT_DELIMITER_2 = ",";
   private static final String STOPPER = "\n";
   private static final char DELIMITER_STOPPER = '[';
   private static final char DELIMITER_STOPPER_2 = ']';
   private static final int TO_IGNORE = 1000;

   String setDelimiter(String str) {
      String result = "";
      if (str.startsWith(STARTING_SYNTAX)) {
         if (str.contains(String.valueOf(DELIMITER_STOPPER_2))) { //multiple char delimiter
            String temp;
            String temp2 = "";
            temp = str.substring(2, str.indexOf(DEFAULT_DELIMITER));
            int j = (int) temp.chars().filter(c -> c == DELIMITER_STOPPER_2).count();
            for (int i = j; i > 0; i--) {
               temp2 += "|" + Pattern.quote(temp.substring(temp.indexOf(DELIMITER_STOPPER) + 1, temp.indexOf(DELIMITER_STOPPER_2)));
               temp = temp.replace(temp.substring(temp.indexOf(DELIMITER_STOPPER), temp.indexOf(DELIMITER_STOPPER_2) + 1), "");
            }
            result = temp2;
         } else {
            result = "|" + Pattern.quote(str.substring(STARTING_SYNTAX.length(), STARTING_SYNTAX.length() + 1));
         }
      }
      return result;
   }

   int calculate(String delimiter, String str) {
      int result = 0;
      String msg = "";
      int asInt;
      if (str.contains(STARTING_SYNTAX)) {
         str = str.replace(str.substring(0, str.indexOf(STOPPER) + 1), "");
      }
      String split[] = str.split(Pattern.quote(DEFAULT_DELIMITER) + "|" + Pattern.quote(DEFAULT_DELIMITER_2) + delimiter);
      for (int i = split.length - 1; i >= 0; i--) {
         asInt = Integer.valueOf(split[i]);
         if (asInt < TO_IGNORE) {
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
      String delimiter;
      if (numbers.isEmpty()) {
         return 0;
      }
      delimiter = setDelimiter(numbers);
      if (numbers.contains(DEFAULT_DELIMITER) || numbers.contains(DEFAULT_DELIMITER_2) || numbers.contains(delimiter)) {
         return calculate(delimiter, numbers);
      }
      int num = Integer.valueOf(numbers);
      return num;
   }
}