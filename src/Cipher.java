import java.util.Random;

public class Cipher {

  public static String cipher ( String str ) {
    //Convert input data
    char[] input = str.toCharArray(); 
    int size = input.length;
    
    //Generate random numbers
    Random rand = new Random();
    int rand_int1 = rand.nextInt(100);
    int rand_int2 = rand.nextInt(251);

    //Create output string with 2 extra characters
    char[] output = new char[size+2];
    
    output[0] = (char) rand_int1;
        
    int rangeMin = 0;
    if (rand_int1 <50 ){
      output[1] = (char) rand_int2;
      rangeMin = 2;
    }
    else {
      output[size+1] = (char) rand_int2;
      rangeMin = 1;
    }
    
    for (int i = 0; i < size; ++i) {
      output[rangeMin + i] = (char)((input[i]*105*rand_int1+rand_int2)%251);
    }
    return new String(output);
  }

  /* Method that returns modular inverse of input*/
  public static int modInv(int input) {
    for( int i = 0; i< 251; ++i ){
      if( (i*input)%251 == 1)
        return i;
    }
    return 0;
  }
  
  public static String deCipher ( String str ) {
    //Convert input data
    char[] input = str.toCharArray();
    int size = input.length-2;
    
    //Extract random int
    int rand_int1 = input[0];
    
    int rand_int2 = 0;
    int rangeMin = 0;

    if ( rand_int1 < 50 ) {
      rand_int2 = input[1];
      rangeMin = 2;
    }
    else {
      rand_int2 = input[size+1];
      rangeMin = 1;
    }
    
    //Find modular inverse
    int constInv = modInv(105);
    int int1Inv = modInv(rand_int1);
    
    char[] output = new char[size];

    for (int i = 0; i < size; ++i) {
      int calc = input[rangeMin+i]-rand_int2;
      if (calc < 0)
        calc+=251;
      
      output[i] = (char)((calc*int1Inv*constInv)%251);
    }
    return new String(output);
  }
}
