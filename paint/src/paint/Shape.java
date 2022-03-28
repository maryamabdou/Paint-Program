/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;


import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author hosam
 */
public  class Shape extends  JPanel implements Cloneable {
    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    private int x1,y1;

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }
    public Shape(int x1,int y1,Color color){
        this.color=color;
        this.x1=x1;
        this.y1=y1;
    }
    @Override
    public Object clone() throws CloneNotSupportedException{
        Object clone = null;
        try{
            clone=super.clone();
        }catch(CloneNotSupportedException e){
            
        }
        return clone;
    }
}
