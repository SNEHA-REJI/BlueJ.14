import java.awt.event.*;
import java.awt.*;
class AreaCalculator extends Frame implements ActionListener
{
Button CircleB,RectangleB,TriangleB;
TextField text;
Label l1;
AreaCalculator()
{
super("AREA CALCULATOR");
CircleB=new Button("Circle");
RectangleB=new Button("Rectangle");
TriangleB=new Button("Triangle");
text=new TextField(10);
l1=new Label("Enter the Dimensions");
add(CircleB);
add(RectangleB);
add(TriangleB);
add(text);
add(l1);
setLayout(null);
CircleB.setBounds(50,125,100,20);
RectangleB.setBounds(200,125,100,20);
TriangleB.setBounds(350,125,100,20);
text.setBounds(100,60,200,20);
l1.setBounds(100,30,200,20);
setSize(500, 300);
setVisible(true);
CircleB.addActionListener(this);
RectangleB.addActionListener(this);
TriangleB.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
Object source = ae.getSource();
try
{
if(source==CircleB)
{
double radius=Double.parseDouble(text.getText());
double area=3.14* Math.pow(radius,2);
text.setText("Area of Circle: " + area);
}
else if(source==RectangleB)
{
String inputs[]=text.getText().split(" ");
double length=Double.parseDouble(inputs[0]);
double breadth=Double.parseDouble(inputs[1]);
double area = length*breadth;
text.setText("Area of Rectangle: " + area);
}
else if(source==TriangleB)
{
String inputs[]=text.getText().split(" ");
double base = Double.parseDouble(inputs[0]);
double height = Double.parseDouble(inputs[1]);
double area = 0.5 * base * height;
text.setText("Area of Triangle: " + area);
}
}
catch (NumberFormatException e1)
{
text.setText("Invalid input");
}
catch (ArithmeticException e2)
{
text.setText("Error: " + e2);
}
}
public static void main(String args[])
{
AreaCalculator obj =new AreaCalculator();
}}

