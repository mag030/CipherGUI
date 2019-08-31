
public class Main {
  public static void main( String[] args ) {
    if ( args.length != 2 ) {
      System.out.print("Wrong number of arguments, Expects text and 1/2 1 for cipher, 2 for decipher");
      System.exit(-1);
    }
    System.out.println("The input string is: " + args[0]);
    String input = args[0];
    String output = null;
    int option = Integer.parseInt(args[1]);
    /*if (option == 1)
      output = Cipher.cipher(input);
    else if (option ==2)
      output = Cipher.deCipher(input);
    else {
      System.out.print("Invalid option");
      System.exit(-1); 
    }
    System.out.print("Complete!, Your string is: " + output);*/
    output = Cipher.cipher(input);
    System.out.println("Ciphered string is: " + output);
    output = Cipher.deCipher(output);
    System.out.println("Deciphered string is: " + output);
    System.exit(0);
  }
}
