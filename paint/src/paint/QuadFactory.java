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
public class QuadFactory implements ShapeFactory{
 Singleton ins=Singleton.getInstance();
    public Shape createShape(int x1, int y1, int x2, int y2, Color color){
        if(ins.getMode()==1){
             return new Rectangle( x1, y1,x2, y2,  color);
        }  if(ins.getMode()==3){
         return new Square( x1, y1,x2, y2,  color);}
           if(ins.getIndex()!=0){
                if(ins.getX().get(ins.getIndex()) instanceof Rectangle)
                    return new Rectangle( x1, y1,x2, y2,  color);
                else if(ins.getX().get(ins.getIndex()) instanceof Square)
                    return new Square( x1, y1,x2, y2,  color);}
                    if(ins.getIndexR()!=0){
                if(ins.getX().get(ins.getIndexR()) instanceof Rectangle)
                    return new Rectangle( x1, y1,x2, y2,  color); 
                    else if(ins.getX().get(ins.getIndexR()) instanceof Square)
                    return new Square( x1, y1,x2, y2,  color);}
        
        return null;
        
     }
  
   
}
