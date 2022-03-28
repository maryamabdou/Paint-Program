/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.geom.Line2D;


/**
 *
 * @author hosam
 */
public class Delete {
    Singleton ins=Singleton.getInstance();
    public void press(int x1 ,int y1,int x2,int y2){
        try{
        for (int i = 0; i < ins.getX().size(); i++) {
               if (ins.getX().get(i) instanceof Line) {
                Line l = (Line) ins.getX().get(i);
                Line2D lin = new Line2D.Double(l.getX1(), l.getY1(), l.getX2(), l.getY2());
                if(lin.intersectsLine(x1, y1, x2, y2)){
               ins.getX().remove(i);
                 break;
                }
            }
               else if(ins.getX().get(i).contains(x1, y1)){
                 ins.getX().remove(i);
               
                 break;
               
            
           }
           }
        }catch(Exception e){
            
        }
    }
}
