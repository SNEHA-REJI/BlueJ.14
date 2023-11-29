import javax.swing.*;
import java.awt.event.*;
class PerfectSwing extends JFrame implements ActionListener
{
JButton b;
JTextField input, output;
JLabel l1, l2;
PerfectSwing()
{
super("Perfect Number Checker");
setLayout(null);
setSize(500,300);
setVisible(true);
b=new JButton("Check");
input = new JTextField(10);
output = new JTextField(10);
l1 = new JLabel("Enter the Number");
l2 = new JLabel("Result");
add(b);
add(input);
add(output);
add(l1);
add(l2);
l1.setBounds(10,60,200,20);
input.setBounds(10, 90, 150, 20);
l2.setBounds(10,155,100,20);
b.setBounds(10, 120, 100, 25);
output.setBounds(10, 185, 150, 20);
b.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
Object source=ae.getSource();
int sum=0;
String num=input.getText();
int n=Integer.parseInt(num);
if(source==b)
{
for(int i=1;i<n;i++)
{
if(n%i==0)
{
sum=sum+i;
}
}
if(sum==n)
{
output.setText("Perfect Number");
}
else
{
int sumd=0,d,nm;
nm=n;
while(n>0)
{
d=n%10;
sumd=sumd+d;
n=n/10;
}
output.setText("Sum of digits of "+nm+" is "+sumd);
}
}
}
public static void main(String args[ ])
{
PerfectSwing p = new PerfectSwing();
}
} 

