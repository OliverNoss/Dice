import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

Die daniel;
int sum;
int a = 4;
int j = 0;
int i = 0;
public void setup()
{
	noLoop();
	size(1024,768);
	strokeWeight(a);
}
public void draw()
{
	sum=0;
	background(255);
	j=0;
	while(j<736)
	{	
		i=0;
		while (i < 1024)  
		{
		
			daniel = new Die(i,j);
			daniel.roll();
			daniel.show();
			i+=a*8;
		}
		j+=a*8;
	}
	textSize(20);
text("Sum = " + sum, 20,765);
text("Number of Dice: " + 1024/(8*a)*736/(8*a), 300,765);
}
public void mousePressed()
{
	
	redraw();
	// System.out.println(i,j);

}
class Die 
{
	int value,dieX,dieY;
	Die(int x, int y) //constructor
	{
		dieX=x;
		dieY=y;
		
	}
	public void roll()
	{
		value = (int)(Math.random()*6+1);
	}
	public void show()
	{
		fill(255);
		rect(dieX,dieY,8*a,8*a);
		fill(0);
		if (value==1) {
			point(dieX+4*a,dieY+4*a);
			System.out.println(1);
			sum+=value;
		}
		if (value==2) {
			point(dieX+2*a,dieY+2*a);
			point(dieX+6*a,dieY+6*a);
			System.out.println(2);
			sum+=value;
		}
		if (value==3) {
			point(dieX+2*a,dieY+2*a);
			point(dieX+6*a,dieY+6*a);
			point(dieX+4*a,dieY+4*a);
			System.out.println(3);
			sum+=value;
		}
		if (value==4) {
			point(dieX+2*a,dieY+2*a); 
			point(dieX+6*a,dieY+6*a);
			point(dieX+2*a,dieY+6*a);
			point(dieX+6*a,dieY+2*a);
			System.out.println(4);
			sum+=value;
		}
		if (value==5) {
			point(dieX+2*a,dieY+2*a);
			point(dieX+4*a,dieY+4*a);
			point(dieX+6*a,dieY+6*a);
			point(dieX+2*a,dieY+6*a);
			point(dieX+6*a,dieY+2*a);
			System.out.println(5);
			sum+=value;	
		}
		if (value==6) {
			point(dieX+2*a,dieY+2*a);
			point(dieX+6*a,dieY+6*a);
			point(dieX+2*a,dieY+4*a);
			point(dieX+2*a,dieY+6*a);
			point(dieX+6*a,dieY+4*a);
			point(dieX+6*a,dieY+2*a);
			System.out.println(6);
			sum+=value;
		}
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
