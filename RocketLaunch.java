import java.awt.event.*;
import java.awt.*;
class RocketLaunch extends Frame implements ActionListener 
{
Button b;
TextField text1, text2;
Label l;
RocketLaunch() 
{
super("ROCKET LAUNCHER");
b=new Button("LAUNCH");
text1=new TextField(10);
text2=new TextField(10);
l=new Label("Counter");
//text1.setAlignment(JTextField.CENTER);
//text2.setAlignment(JTextField.CENTER);
add(b);
add(text1);
add(text2);
add(l);
setLayout(null);
b.setBounds(100,100,300,70);
text1.setBounds(150, 200, 200, 100);
text2.setBounds(100, 350, 300, 70);
l.setBounds(150, 180, 200, 20);
setSize(700, 400);
setVisible(true);
b.addActionListener(this);
}
public void actionPerformed(ActionEvent ae) 
{
Object source=ae.getSource();
if (source==b) 
{
Countdown c= new Countdown(text1,text2);
}
}
public static void main(String args[]) 
{
RocketLaunch obj = new RocketLaunch();
}
}
class Countdown extends Thread
{
TextField text1;
TextField text2;
Countdown(TextField text1,TextField text2)
{
this.text1=text1;
this.text2=text2;
start();
}
public void run() 
{
int i;
for(i=5;i>=0;i--) 
{
final int count=i;
EventQueue.invokeLater(new Runnable(){
public void run() 
{
text1.setText(Integer.toString(count));
if(count==5)
text1.setBackground(Color.BLUE);
if(count==4)
text1.setBackground(Color.GREEN);
if(count==3)
text1.setBackground(Color.YELLOW);
if(count==2)
text1.setBackground(Color.PINK);
if(count==1)
text1.setBackground(Color.ORANGE);
if(count==0){
text1.setBackground(Color.RED);
text2.setText("LAUNCH SUCCESSFUL!!");
text2.setBackground(Color.CYAN);
}
}
});
try
{
Thread.sleep(1000);
}
catch(InterruptedException e) 
{
System.out.println(e);
}
}
}
}
        
   
