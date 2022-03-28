/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Color;



/**
 *
 * @author hosam
 */
public class Line extends Shape  {
 private int x2,y2;
    Line(int x1, int y1, int x2, int y2, Color color) {
        super(x1,y1,color);
        this.x2=x2;
        this.y2=y2;
        
    }
  
    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

   

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
   
 
}
