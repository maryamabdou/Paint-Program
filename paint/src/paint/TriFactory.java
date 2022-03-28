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
public class TriFactory implements ShapeFactory {
     Singleton ins=Singleton.getInstance();
private int x3,y3;

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
    public Shape createShape(int x1, int y1, int x2, int y2, Color color) {
        
        if(ins.getMode()==5){
              return new Right( x1, y1, x2, y2, x3, y3, color);
        }  if(ins.getMode()==4){
         return new Triangle( x1, y1, x2, y2, x3, y3, color);}
           if(ins.getIndex()!=0){
                if(ins.getX().get(ins.getIndex()) instanceof Right)
                    return new Right( x1, y1, x2, y2, x3, y3, color); 
                else if(ins.getX().get(ins.getIndex()) instanceof Triangle)
                    return new Triangle( x1, y1, x2, y2, x3, y3, color);}
                    if(ins.getIndexR()!=0){
                if(ins.getX().get(ins.getIndexR()) instanceof Right)
                    return new Right( x1, y1, x2, y2, x3, y3, color); 
                    else if(ins.getX().get(ins.getIndexR()) instanceof Triangle)
                    return new Triangle( x1, y1, x2, y2, x3, y3, color);}
        
        return null;
    }
    
}
