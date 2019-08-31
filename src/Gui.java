import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Gui {

  private static TextField output;
  private static String inputStr;
  private static String outputStr;
  
  public static void main(String[] args) {
    JFrame frame = new JFrame("Cipher Tool");
    Panel panel1 = new Panel();
    Panel panel2 = new Panel();
    Panel textBox = new Panel();
    Panel right = new Panel();
    
    frame.add(BorderLayout.CENTER, textBox);
    frame.add(BorderLayout.NORTH, panel1);
    frame.add(BorderLayout.SOUTH, panel2);
    frame.add(BorderLayout.EAST, right);
    
    textBox.setLayout(new GridLayout(0,2));
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600,300);
    
    JButton cipher = new JButton("Cipher");
    JButton decipher = new JButton("DeCipher");
    JButton flip = new JButton("Switch/Flip");
    
    TextField tb = new TextField("",50);
    output = new TextField("",50);
    output.setEditable(false);
    
    panel1.add(cipher); 
    panel2.add(decipher);
    right.add(flip);
    
    Label outLab = new Label("Output");
    Label inLab = new Label( "Input");
    
    textBox.add(inLab);
    textBox.add(tb);
    textBox.add(outLab);
    textBox.add(output);
    
    frame.setVisible(true);
    
    cipher.addActionListener( new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        inputStr = tb.getText();
        outputStr = Cipher.cipher(inputStr);
        output.setText(outputStr);
      }
    });
    
    decipher.addActionListener( new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        inputStr = tb.getText();
        outputStr = Cipher.deCipher(inputStr);
        output.setText(outputStr);
      }
    });
    
    flip.addActionListener( new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        tb.setText(outputStr);
        output.setText("");
      }
    });
  }

}
