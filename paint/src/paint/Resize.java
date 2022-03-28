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
public class Resize implements ResizeInter{
        Singleton ins=Singleton.getInstance();
        @Override
    public void press(int x1,int y1,int x2, int y2){
        try{
         for (int i = 0; i < ins.getX().size(); i++) {
               if (ins.getX().get(i) instanceof Line) {
                Line l = (Line) ins.getX().get(i);
                Line2D lin = new Line2D.Double(l.getX1(), l.getY1(), l.getX2(), l.getY2());
                if(lin.intersectsLine(x1, y1, x2, y2)){
                ins.setIndexR(i);
                 break;}
            }
               else if(ins.getX().get(i).contains(x1, y1)){
                ins.setIndexR(i);
               System.out.println(ins.getX().get(i).getX1());
                 break;
               
            
           }
           }
        }catch(Exception e){
        
    }
    }
        @Override
    public void drag(int x2,int y2,int x3, int y3){
        try{
        if (ins.getX().get(ins.getIndexR()) instanceof Line) {
               Line l1 = (Line) ins.getX().get(ins.getIndexR());
                LineFactory lf=new LineFactory();
            Line l = (Line)lf.createShape(l1.getX1(),l1.getY1(), x2, y2 , l1.getColor());
              ins.getX().set(ins.getIndexR(),l);
            }else if (ins.getX().get(ins.getIndexR()) instanceof Rectangle) {
                
             Rectangle r1 = (Rectangle) ins.getX().get(ins.getIndexR());
             QuadFactory lf=new QuadFactory();
            Rectangle r =(Rectangle)  lf.createShape(r1.getX1(), r1.getY1(),x2, y2, r1.getColor());
            ins.getX().set(ins.getIndexR(),r);
            
            }else if (ins.getX().get(ins.getIndexR()) instanceof Circle) {
               
                Circle r = (Circle) ins.getX().get(ins.getIndexR());
               if(Math.abs(x2 - r.getX1())==Math.abs(y2 - r.getY1())){
                r.setX2(x2);
                r.setY2(y2);
                ins.getX().set(ins.getIndexR(),r);}
                
                
            }else if (ins.getX().get(ins.getIndexR()) instanceof Square) {
                Square r1 = (Square) ins.getX().get(ins.getIndexR());
              if(Math.abs(x2 - r1.getX1())==Math.abs(y2 - r1.getY1())){
                r1.setX2(x2);
                r1.setY2(y2);
                ins.getX().set(ins.getIndexR(),r1);}
                
                
            }else if (ins.getX().get(ins.getIndexR()) instanceof Triangle) {
                
                 Triangle r1 = (Triangle) ins.getX().get(ins.getIndexR());
                
                     if(r1.getX1()<x3)
              x2=x3-2*(x3-r1.getX1());
              else if(r1.getX1()>x3){
                x2=x3+2*(r1.getX1()-x3);
              }
               TriFactory lf=new TriFactory();
            lf.setX3(x3);
            lf.setY3(y2);
            Triangle t =  (Triangle)lf.createShape(r1.getX1(), r1.getY1(), x2, y2,r1.getColor());
                ins.getX().set(ins.getIndexR(),t);
            
            } else if (ins.getX().get(ins.getIndexR()) instanceof Right) {
                
               Right r1 = (Right) ins.getX().get(ins.getIndexR());
                if(r1.getX1()==r1.getX2()){
                    x2=r1.getX1();
                    y2=y3;
                    TriFactory lf=new TriFactory();
             lf.setX3(x3);
            lf.setY3(y3);
            Right t = (Right)lf.createShape(r1.getX1(), r1.getY1(),x2, y2,r1.getColor());
                ins.getX().set(ins.getIndexR(),t);
                }
                
           }
           
    }
    catch(Exception e){
    
}
    }
}
