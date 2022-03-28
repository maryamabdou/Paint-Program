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
public class Move implements MoveInter{
        Singleton ins=Singleton.getInstance();
        @Override
   public void press(int x1,int y1,int x2,int y2){
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
                 break;
            
           }
           }
       }catch(Exception e){
           
       }
   }
        @Override
   public void drag(int x1,int y1){
       try{
        if (ins.getX().get(ins.getIndexR()) instanceof Line) {
               Line l1 = (Line) ins.getX().get(ins.getIndexR());
              
                if (l1.getX1() < l1.getX2() && l1.getY1() < l1.getY2()) {
                    LineFactory lf=new LineFactory();
            Line l = (Line)lf.createShape(x1, y1, x1+Math.abs(l1.getX2() - l1.getX1()), y1+Math.abs(l1.getY2() - l1.getY1()), l1.getColor());
                  ins.getX().set(ins.getIndexR(),l);
                } else if (l1.getX1()>l1.getX2() && l1.getY1() > l1.getY2()) {
                     LineFactory lf=new LineFactory();
            Line l = (Line)lf.createShape(x1, y1, x1-Math.abs(l1.getX2() - l1.getX1()), y1-Math.abs(l1.getY2() - l1.getY1()), l1.getColor());
                    ins.getX().set(ins.getIndexR(),l);
                }else if (l1.getX2() > l1.getX1() && l1.getY1() > l1.getY2()) {
                      LineFactory lf=new LineFactory();
            Line l = (Line)lf.createShape(x1, y1, x1+Math.abs(l1.getX2() - l1.getX1()), y1-Math.abs(l1.getY2() - l1.getY1()), l1.getColor());
                   ins.getX().set(ins.getIndexR(),l);
                }else if (l1.getX1() > l1.getX2() && l1.getY2() > l1.getY1()) {
                     LineFactory lf=new LineFactory();
            Line l = (Line)lf.createShape(x1, y1, x1-Math.abs(l1.getX2() - l1.getX1()), y1+Math.abs(l1.getY2() - l1.getY1()), l1.getColor());
                 ins.getX().set(ins.getIndexR(),l);
                }
            }else if (ins.getX().get(ins.getIndexR()) instanceof Rectangle) {
                
             Rectangle r1 = (Rectangle) ins.getX().get(ins.getIndexR());
             QuadFactory lf=new QuadFactory();
            Rectangle r =(Rectangle)  lf.createShape(x1, y1, x1+(r1.getX2() - r1.getX1()), y1+(r1.getY2() - r1.getY1()), r1.getColor());
            ins.getX().set(ins.getIndexR(),r);
            
            
            }else if (ins.getX().get(ins.getIndexR()) instanceof Circle) {
                Circle r1 = (Circle) ins.getX().get(ins.getIndexR());
      CircleFactory lf=new CircleFactory();
            Circle r =  (Circle)lf.createShape(x1, y1, x1+Math.abs(r1.getX2() - r1.getX1()), y1+Math.abs(r1.getX2() - r1.getX1()), r1.getColor());
                ins.getX().set(ins.getIndexR(),r);
                
                
            }else if (ins.getX().get(ins.getIndexR()) instanceof Square) {
                Square r1 = (Square) ins.getX().get(ins.getIndexR());
               QuadFactory lf=new QuadFactory();
            Square r =  (Square) lf.createShape(x1, y1, x1+(r1.getX2() - r1.getX1()), y1+(r1.getX2() - r1.getX1()), r1.getColor());
                ins.getX().set(ins.getIndexR(),r);
                
                
            }else if (ins.getX().get(ins.getIndexR()) instanceof Triangle) {
                Triangle r1 = (Triangle) ins.getX().get(ins.getIndexR());
                TriFactory lf=new TriFactory();
            lf.setX3(x1+(Math.abs(r1.getX1() - r1.getX3())));
            lf.setY3(y1+Math.abs(r1.getY1() - r1.getY2()));
            Triangle t =  (Triangle)lf.createShape(x1, y1, x1-(Math.abs(r1.getX1() - r1.getX3())), y1+Math.abs(r1.getY1() - r1.getY2()),r1.getColor());
                ins.getX().set(ins.getIndexR(),t);
                
                
                
                
           } else if (ins.getX().get(ins.getIndexR()) instanceof Right) {
                Right r1 = (Right) ins.getX().get(ins.getIndexR());
                if(r1.getX1()==r1.getX2()&&r1.getX3()>r1.getX1()){
                    TriFactory lf=new TriFactory();
             lf.setX3(x1+(Math.abs(r1.getX1() - r1.getX3())));
            lf.setY3(y1+Math.abs(r1.getY1() - r1.getY2()));
            Right t = (Right)lf.createShape(x1, y1, x1, y1+Math.abs(r1.getY1() - r1.getY2()),r1.getColor());
                ins.getX().set(ins.getIndexR(),t);
               
               
                }else if(r1.getX1()==r1.getX2()&&r1.getX3()<r1.getX1()){
                    TriFactory lf=new TriFactory();
             lf.setX3(x1-(Math.abs(r1.getX1() - r1.getX3())));
            lf.setY3(y1+Math.abs(r1.getY1() - r1.getY2()));
            Right t = (Right)lf.createShape(x1, y1, x1, y1+Math.abs(r1.getY1() - r1.getY2()),r1.getColor());
               ins.getX().set(ins.getIndexR(),t);
                
                }
              } 
       }
       catch(Exception e){
           
       }
        }
   }

