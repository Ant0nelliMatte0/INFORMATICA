public void settings(){
  size(600, 400);  //dimensione finestra 
}

public void setup(){
  background(255,0,0);

}
public void draw(){
fill(150,80,0);
rect(100, 300, 55, 55);
fill(0,255,0);
triangle(30, 300, 125, 200, 220, 300);
triangle(45, 250, 125, 150, 205, 250);
triangle(60, 200, 125, 100, 190, 200);
triangle(75, 150, 125, 85, 175, 150);

textSize(58);
text("Buon Natale",230,180);
}
