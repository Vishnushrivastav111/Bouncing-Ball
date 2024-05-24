import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class MyAnimations extends JFrame implements MouseMotionListener{
int x=0;
int y=0;
int width = 35;
int height = 35;
int stepsizeX = 10;
int stepsizeY = 10;
int max_x=760;
int max_y=560;
int count=0;
String s;
Color circleColor = Color.RED;
JLabel l1,l2,l3,l4,l5,l6,l7;
MyAnimations(){
setLayout(null);
setVisible(true);
setSize(800,600);
l1=new JLabel();
l1.setBounds(400,0,100,30);
add(l1);
l2=new JLabel();
l2.setBounds(700,520,20,30);
add(l2);
l3=new JLabel();
l3.setBounds(730,520,50,30);
add(l3);
l5=new JLabel();
l5.setBounds(270,0,120,30);
l5.setText("Ball hit the border =");
add(l5);
l6=new JLabel();
l6.setBounds(430,0,50,30);
l6.setText("Times");
add(l6);
l4=new JLabel();
l4.setBounds(270,80,600,400);
l4.setForeground(Color.RED);
Font currentFont = l4.getFont();
Font newFont = currentFont.deriveFont(currentFont.getStyle(),64f);
l4.setFont(newFont);
add(l4);
l7=new JLabel();
l7.setBounds(600,520,100,30);
add(l7);

}
public void mouseMoved(MouseEvent me){
	l7.setText("Cordinates =");

	x = me.getX();
	 y = me.getY();
	 String sx = String.valueOf(x);
	 String sy = String.valueOf(y);
	 l2.setText(sx);
	 l3.setText(sy); 
	 
}
public void mouseDragged(MouseEvent me){
	
l4.setText("Vishnu");
}
public void paint(Graphics g){
super.paint(g);
g.setColor(circleColor);
g.fillOval(x,y,width,height);
if(x>max_x || x<0){
	count++;
	stepsizeX = -stepsizeX;
	changeCircleColor();
}
if(y>max_y || y<0){
	count++;
	stepsizeY = -stepsizeY;
	changeCircleColor();
}

x=x+stepsizeX;
y=y+stepsizeY;
s = String.valueOf(count);
l1.setText(s);
repaint();
try{
Thread.sleep(10);
}catch(Exception e){
e.printStackTrace();
}	
}
void design(){
JPanel panel = new JPanel();
panel.setBounds(0,0,800,600);
//panel.setBackground(Color.BLACK);
add(panel);


addMouseMotionListener(this);
}
void changeCircleColor(){
 circleColor = new Color((int) (Math.random()*255),(int) (Math.random()*255),(int) (Math.random()*255));
}
}
class MyAnimation {
public static void main(String[] args){
MyAnimations animations =  new MyAnimations();
animations.design();
}
}