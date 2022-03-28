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
public class Triangle extends Shape{
    private int x2,y2,x3,y3;
    public Triangle(int x1,int y1,int x2,int y2,int x3,int y3,Color color){
        super(x1,y1,color);
        this.x2=x2;
         this.y2=y2;
          this.x3=x3;
           this.y3=y3;
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

    public int getX3() {
        return x3;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public int getY3() {
        return y3;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }
     @Override
    public boolean contains(int x, int y) {
        int [] a = {super.getX1(),this.x2,this.x3};
        int [] b = {super.getY1(),this.y2,this.y3};
        java.awt.Polygon r = new java.awt.Polygon(a, b, 3);
        if (r.contains(x, y)) {
            return true;
        } else {
            return false;
        }
    }
    
}
