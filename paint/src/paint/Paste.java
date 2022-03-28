/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;




/**
 *
 * @author hosam
 */
public class Paste implements PasteInter {
        Singleton ins=Singleton.getInstance();
        @Override
    public void press(int x1,int y1){
        try{
        if (ins.getX().get(ins.getIndex()) instanceof Line) {
                Line l1 = (Line) ins.getX().get(ins.getIndex());
              
                if (l1.getX1() < l1.getX2() && l1.getY1() < l1.getY2()) {
                     LineFactory lf=new LineFactory();
            Line l = (Line)lf.createShape(x1, y1, x1+Math.abs(l1.getX2() - l1.getX1()), y1+Math.abs(l1.getY2() - l1.getY1()), l1.getColor());
                  
                  ins.getX().add(l);
                 ins.getX().remove(ins.getIndex());
               ins.setMode(-1);
                } else if (l1.getX1()>l1.getX2() && l1.getY1() > l1.getY2()) {
                    LineFactory lf=new LineFactory();
            Line l = (Line)lf.createShape(x1, y1, x1-Math.abs(l1.getX2() - l1.getX1()), y1-Math.abs(l1.getY2() - l1.getY1()), l1.getColor());
                    ins.getX().add(l);
                 ins.getX().remove(ins.getIndex());
                 ins.setMode(-1);
                }else if (l1.getX2() > l1.getX1() && l1.getY1() > l1.getY2()) {
                    LineFactory lf=new LineFactory();
            Line l = (Line)lf.createShape(x1, y1, x1+Math.abs(l1.getX2() - l1.getX1()), y1-Math.abs(l1.getY2() - l1.getY1()), l1.getColor());
                   ins.getX().add(l);
                 ins.getX().remove(ins.getIndex());
                  ins.setMode(-1);
                }else if (l1.getX1() > l1.getX2() && l1.getY2() > l1.getY1()) {
                   LineFactory lf=new LineFactory();
            Line l = (Line)lf.createShape(x1, y1, x1-Math.abs(l1.getX2() - l1.getX1()), y1+Math.abs(l1.getY2() - l1.getY1()), l1.getColor());
                 ins.getX().add(l);
                 ins.getX().remove(ins.getIndex());
                ins.setMode(-1);
                }
            }else if (ins.getX().get(ins.getIndex()) instanceof Rectangle) {
             Rectangle r1 = (Rectangle)ins.getX().get(ins.getIndex());
              QuadFactory lf=new QuadFactory();
            Rectangle r =(Rectangle)  lf.createShape(x1, y1, x1+(r1.getX2() - r1.getX1()), y1+(r1.getY2() - r1.getY1()), r1.getColor());
            ins.getX().add(r);
           ins.getX().remove(ins.getIndex());
              ins.setMode(-1);
            }else if (ins.getX().get(ins.getIndex()) instanceof Circle) {
                Circle r1 = (Circle) ins.getX().get(ins.getIndex());
       CircleFactory lf=new CircleFactory();
            Circle r =  (Circle)lf.createShape(x1, y1, x1+Math.abs(r1.getX2() - r1.getX1()), y1+Math.abs(r1.getX2() - r1.getX1()), r1.getColor());
                ins.getX().add(r);
                ins.getX().remove(ins.getIndex());
                 ins.setMode(-1);
            }else if (ins.getX().get(ins.getIndex()) instanceof Square) {
                Square r1 = (Square) ins.getX().get(ins.getIndex());
             QuadFactory lf=new QuadFactory();
            Square r =  (Square) lf.createShape(x1, y1, x1+(r1.getX2() - r1.getX1()), y1+(r1.getX2() - r1.getX1()), r1.getColor());
                ins.getX().add(r);
                ins.getX().remove(ins.getIndex());
               ins.setMode(-1);
            }else if (ins.getX().get(ins.getIndex()) instanceof Triangle) {
                Triangle r1 = (Triangle) ins.getX().get(ins.getIndex());
                if(r1.getY3()>r1.getY1()){
                TriFactory lf=new TriFactory();
            lf.setX3(x1+(Math.abs(r1.getX1() - r1.getX3())));
            lf.setY3(y1+Math.abs(r1.getY1() - r1.getY2()));
            Triangle t =  (Triangle)lf.createShape(x1, y1, x1-(Math.abs(r1.getX1() - r1.getX3())), y1+Math.abs(r1.getY1() - r1.getY2()),r1.getColor());
                ins.getX().add(t);
                ins.getX().remove(ins.getIndex());
              ins.setMode(-1);
                }else if(r1.getY1()>r1.getY3()){
                TriFactory lf=new TriFactory();
            lf.setX3(x1+(Math.abs(r1.getX1() - r1.getX3())));
            lf.setY3(y1-Math.abs(r1.getY1() - r1.getY2()));
            Triangle t =  (Triangle)lf.createShape(x1, y1, x1-(Math.abs(r1.getX1() - r1.getX3())), y1-Math.abs(r1.getY1() - r1.getY2()),r1.getColor());
                ins.getX().add(t);
                ins.getX().remove(ins.getIndex());
                  ins.setMode(-1);
                }
        
    }
        }catch(Exception e){
            
        }
         
}

}
