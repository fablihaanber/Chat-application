import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.*;

public class SpaceKey extends JPanel implements ActionListener
{
static final String st = "ABCDE";
JButton buttonList[];
String buffer = "";
JTextField text;
JButton backspace, spaceBar;

public void key() {
text = new JTextField(20);
text.setActionCommand(""+ buffer);
add(text);
int n = st.length();
buttonList = new JButton[n];
for (int i = 0; i < n; i++) {
buttonList[i] = new JButton( "" + st.charAt(i) );
add(buttonList[i]);
buttonList[i].addActionListener(this);
}
spaceBar = new JButton("Spacebar Key");
add(spaceBar);
spaceBar.addActionListener(this);

backspace = new JButton("BackSpace Key");
add(backspace);
backspace.addActionListener(this);
}
public void actionPerformed( ActionEvent e) {
int n = st.length();
if (e.getSource() == backspace) {
buffer = buffer.substring(0,buffer.length()-1);
text.setText("" + buffer);
}
else if (e.getSource() == spaceBar){
buffer += " ";
}
else{
for (int i = 0; i < n; i++){
if (e.getSource() == buttonList[i]){
buffer += st.toLowerCase().charAt(i);
text.setText(""+ buffer);
break;
}
}
}
}
public SpaceKey(){
JPanel pane = new JPanel();
add(pane);
}
public static void main(String s[])
{
JFrame frame = new JFrame();
SpaceKey keys= new SpaceKey();
frame.getContentPane().add(keys,"Center");
keys.key();
frame.setSize(500,100);
frame.setVisible(true);
}
}
