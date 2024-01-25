import java.util.*;
import java.io.*;

public class Runner{

  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[31m";
  public static final String ANSI_RESET = "\u001B[0m";

  public static void main(String[] args)  throws FileNotFoundException
  {
    Scanner input = new Scanner(new File("words.txt"));
    ArrayList<String> dictionary = new ArrayList<String>();
    while (input.hasNext()) {
        dictionary.add(input.next().toLowerCase());
    }
  }
}
