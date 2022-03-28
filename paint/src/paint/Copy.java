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
public class Copy implements CopyInter {
    Singleton ins=Singleton.getInstance();
    @Override
    public void press(int x1,int y1,int x2,int y2){
         try{
           for (int i = 0; i < ins.getX().size(); i++) {
            if (ins.getX().get(i) instanceof Line) {
                Line l = (Line)(Shape) ins.getX().get(i).clone();
                Line2D lin = new Line2D.Double(l.getX1(), l.getY1(), l.getX2(), l.getY2());
                if(lin.intersectsLine(x1, y1, x2, y2)){
                ins.getX().add(l);
                 ins.setIndex(ins.getX().size()-1);
                 System.out.println("sam");
                 break;}
            }
            else if(ins.getX().get(i).contains(x1, y1)){
               Shape s = (Shape)ins.getX().get(i).clone();

             if (s instanceof Rectangle) {
                Rectangle r = (Rectangle) s;
            ins.getX().add(r);
             ins.setIndex(ins.getX().size()-1);
             
             break;
            }else if (s instanceof Circle) {
                Circle r = (Circle) s;
                ins.getX().add(r);
                ins.setIndex(ins.getX().size()-1);
                 
                 break;
            }else if (s instanceof Square) {
                Square r = (Square) s;
                ins.getX().add(r);
                ins.setIndex(ins.getX().size()-1);
                
                 break;
            }else if (s instanceof Triangle) {
                Triangle r = (Triangle) s;
                ins.getX().add(r);
                 ins.setIndex(ins.getX().size()-1);
                 
                break;
           }else if (s instanceof Right) {
                Right r = (Right) s;
                ins.getX().add(r);
                 ins.setIndex(ins.getX().size()-1);
                 
                break;
           }  
           }
           }
         }catch(Exception e){
             
         }
    }
}
