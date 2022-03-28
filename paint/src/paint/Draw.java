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


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Draw extends JPanel implements MouseListener, MouseMotionListener {
    Singleton ins=Singleton.getInstance();
    Color currentColor = Color.BLACK;
    //0 for line 1 for rect
    int x1, y1;
    boolean first = false;
    int x2, y2;
    int x3,y3;
   



    public Draw() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        try{
        super.paintComponent(g);
        for (int i = 0; i < ins.getX().size(); i++) {
            if (ins.getX().get(i) instanceof Line) {
                Line l = (Line) ins.getX().get(i);
                g.setColor(l.getColor());
              g.drawLine(l.getX1(), l.getY1(), l.getX2(), l.getY2());
                
            } else if (ins.getX().get(i) instanceof Rectangle) {
                Rectangle r = (Rectangle) ins.getX().get(i);
                g.setColor(r.getColor());
                if (r.getX1() < r.getX2() && r.getY1() < r.getY2()) {
                    g.fillRect(r.getX1(), r.getY1(), r.getX2() - r.getX1(), r.getY2() - r.getY1());
                } else if (r.getX1() > r.getX2() && r.getY1() > r.getY2()) {
                    g.fillRect(r.getX2(), r.getY2(), Math.abs(r.getX2() - r.getX1()), Math.abs(r.getY2() - r.getY1()));

                }else if (r.getX2() > r.getX1() && r.getY1() > r.getY2()) {
                    g.fillRect(r.getX1(), r.getY2(), Math.abs(r.getX2() - r.getX1()), Math.abs(r.getY2() - r.getY1()));

                }else if (r.getX1() > r.getX2() && r.getY2() > r.getY1()) {
                    g.fillRect(r.getX2(), r.getY1(), Math.abs(r.getX2() - r.getX1()),Math.abs(r.getY2() - r.getY1()));

                }
            }
            else if (ins.getX().get(i) instanceof Circle) {
                Circle c = (Circle) ins.getX().get(i);
                g.setColor(c.getColor());
                if (c.getX1() < c.getX2() && c.getY1() < c.getY2()) {
                   
                    g.fillOval(c.getX1(), c.getY1(), c.getX2() - c.getX1(), c.getX2() - c.getX1());
                    
                } else if (c.getX1() > c.getX2() && c.getY1() > c.getY2()) {
                    
                    g.fillOval(c.getX2(), c.getY2(), Math.abs(c.getX2() - c.getX1()), Math.abs(c.getX2() - c.getX1()));
                    
                }else if (c.getX2() > c.getX1() && c.getY1() > c.getY2()) {
                    
                    g.fillOval(c.getX1(), c.getY2(), Math.abs(c.getX2() - c.getX1()), Math.abs(c.getX2() - c.getX1()));
                    
                }else if (c.getX1() > c.getX2() && c.getY2() > c.getY1()) {
                    
                    g.fillOval(c.getX2(), c.getY1(), Math.abs(c.getX2() - c.getX1()), Math.abs(c.getX2() - c.getX1()));
                    

                }
            }else if (ins.getX().get(i) instanceof Square) {
                Square r = (Square) ins.getX().get(i);
                g.setColor(r.getColor());
                
                if (r.getX1() < r.getX2() && r.getY1() < r.getY2()) {
                    g.fillRect(r.getX1(), r.getY1(), r.getX2() - r.getX1(), r.getX2() - r.getX1());
                } else if (r.getX1() > r.getX2() && r.getY1() > r.getY2()) {
                    g.fillRect(r.getX2(), r.getY2(), Math.abs(r.getX2() - r.getX1()),Math.abs(r.getX2() - r.getX1()));

                }else if (r.getX2() > r.getX1() && r.getY1() > r.getY2()) {
                    g.fillRect(r.getX1(), r.getY2(), Math.abs(r.getX2() - r.getX1()), Math.abs(r.getX2() - r.getX1()));

                }else if (r.getX1() > r.getX2() && r.getY2() > r.getY1()) {
                    
                    g.fillRect(r.getX2(), r.getY1(), Math.abs(r.getX2() - r.getX1()),Math.abs(r.getX2() - r.getX1()));

                }
            }else if (ins.getX().get(i) instanceof Triangle) {
                Triangle r = (Triangle) ins.getX().get(i);
                int z[]={r.getX1(),r.getX2(),r.getX3()};
                int y []={r.getY1() ,r.getY2() ,r.getY3() };
                g.setColor(r.getColor());
                    g.fillPolygon(z,y,3);
               
            }else if (ins.getX().get(i) instanceof Right) {
               
                Right r = (Right) ins.getX().get(i);
                int z[]={r.getX1(),r.getX2(),r.getX3()};
                int y []={r.getY1() ,r.getY2() ,r.getY3() };
                g.setColor(r.getColor());
                    g.fillPolygon(z,y,3);
               
            }
        }
        if(ins.getMode()==7){
                         if (ins.getX().get(ins.getIndex()) instanceof Line) {
                Line l = (Line) ins.getX().get(ins.getIndex());
                g.setColor(l.getColor());
              g.drawLine(l.getX1(), l.getY1(), l.getX2(), l.getY2());
            }else if (ins.getX().get(ins.getIndex()) instanceof Rectangle) {
                Rectangle r = (Rectangle) ins.getX().get(ins.getIndex());
            g.setColor(r.getColor());
            g.fillRect(x1, y1,Math.abs(r.getX2() - r.getX1()),Math.abs(r.getY2() - r.getY1()));
            
            }else if (ins.getX().get(ins.getIndex()) instanceof Circle) {
                Circle c = (Circle) ins.getX().get(ins.getIndex());
                g.setColor(c.getColor());
                 g.fillOval(x1, y1, Math.abs(c.getX2() - c.getX1()), Math.abs(c.getX2() - c.getX1()));
                
                
            }else if (ins.getX().get(ins.getIndex()) instanceof Square) {
                Square r = (Square) ins.getX().get(ins.getIndex());
                g.setColor(r.getColor());
                g.fillRect(x1, y1, Math.abs(r.getX2() - r.getX1()),Math.abs(r.getX2() - r.getX1()));
               
            }else if (ins.getX().get(ins.getIndex()) instanceof Triangle) {
                Triangle r = (Triangle) ins.getX().get(ins.getIndex());
                
               int z[]={x1,x1-(Math.abs(r.getX1() - r.getX3())),x1+(Math.abs(r.getX1() - r.getX3()))};
                int y []={y1 ,y1+Math.abs(r.getY1() - r.getY2()) ,y1+Math.abs(r.getY1() - r.getY2()) };
                g.setColor(r.getColor());
                    g.fillPolygon(z,y,3);
                
               
                 
           }else if (ins.getX().get(ins.getIndex()) instanceof Right) {
                Right r = (Right) ins.getX().get(ins.getIndex());
                if(r.getX1()==r.getX2()){
                    int z[]={x1,x1,x1+(Math.abs(r.getX1() - r.getX3()))};
                    int y []={y1 ,y1+Math.abs(r.getY1() - r.getY2()) ,y1+Math.abs(r.getY1() - r.getY2()) };
                g.setColor(r.getColor());
                    g.fillPolygon(z,y,3);
                }
                 
           }
             ins.setIndex(0);           
        }if(ins.getMode()==9){
            if (ins.getX().get(ins.getIndexR()) instanceof Square) {
                Square r = (Square) ins.getX().get(ins.getIndexR());
                g.setColor(r.getColor());
                
                if (r.getX1() < r.getX2() && r.getY1() < r.getY2()) {
                    g.fillRect(r.getX1(), r.getY1(), r.getX2() - r.getX1(), r.getY2() - r.getY1());
                } else if (r.getX1() > r.getX2() && r.getY1() > r.getY2()) {
                    g.fillRect(r.getX2(), r.getY2(), Math.abs(r.getX2() - r.getX1()),Math.abs(r.getY2() - r.getY1()));

                }else if (r.getX2() > r.getX1() && r.getY1() > r.getY2()) {
                    g.fillRect(r.getX1(), r.getY2(), Math.abs(r.getX2() - r.getX1()), Math.abs(r.getY2() - r.getY1()));

                }else if (r.getX1() > r.getX2() && r.getY2() > r.getY1()) {
                    g.fillRect(r.getX2(), r.getY1(), Math.abs(r.getX2() - r.getX1()),Math.abs(r.getY2() - r.getY1()));

                }
            }else  if (ins.getX().get(ins.getIndexR()) instanceof Circle) {
                Circle c = (Circle) ins.getX().get(ins.getIndexR());
                g.setColor(c.getColor());
                if (c.getX1() < c.getX2() && c.getY1() < c.getY2()) {
                   
                    g.fillOval(c.getX1(), c.getY1(), c.getX2() - c.getX1(), c.getY2() - c.getY1());
                    
                } else if (c.getX1() > c.getX2() && c.getY1() > c.getY2()) {
                    
                    g.fillOval(c.getX2(), c.getY2(), Math.abs(c.getX2() - c.getX1()), Math.abs(c.getY2() - c.getY1()));
                    
                }else if (c.getX2() > c.getX1() && c.getY1() > c.getY2()) {
                    
                    g.fillOval(c.getX1(), c.getY2(), Math.abs(c.getX2() - c.getX1()), Math.abs(c.getY2() - c.getY1()));
                    
                }else if (c.getX1() > c.getX2() && c.getY2() > c.getY1()) {
                    
                    g.fillOval(c.getX2(), c.getY1(), Math.abs(c.getX2() - c.getX1()), Math.abs(c.getY2() - c.getY1()));
                    

                }
            }
        }

    }
    catch(Exception c){
        
    }
        }

    @Override
    public void mouseClicked(MouseEvent e) {
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        try{
        x1 = e.getX();
        y1 = e.getY();
        if (ins.getMode() == 0) {
            LineFactory lf=new LineFactory();
            Line l = (Line)lf.createShape(x1, y1, x1, y1, currentColor);
            ins.getX().add(l);
            repaint();
        } else if (ins.getMode() == 1) {
            QuadFactory lf=new QuadFactory();
            Rectangle r =(Rectangle)  lf.createShape(x1, y1, x1, y1, currentColor);
            ins.getX().add(r);
            repaint();
        }else if (ins.getMode() == 2) {
            CircleFactory lf=new CircleFactory();
            Circle r =  (Circle)lf.createShape(x1, y1, x1, y1, currentColor);
            ins.getX().add(r);
            repaint();
        }else if (ins.getMode() == 3) {
            QuadFactory lf=new QuadFactory();
            Square r =  (Square) lf.createShape(x1, y1, x1, y1, currentColor);
            ins.getX().add(r);
            repaint();
        }else if (ins.getMode() == 4) {
            TriFactory lf=new TriFactory();
            lf.setX3(x1);
            lf.setY3(y1);
            Triangle t =  (Triangle)lf.createShape(x1, y1, x1, y1, currentColor);
            ins.getX().add(t);
            repaint();
        }else if (ins.getMode() == 5) {
            
             TriFactory lf=new TriFactory();
             lf.setX3(x1);
            lf.setY3(y1);
            Right t = (Right)lf.createShape(x1, y1, x1, y1, currentColor);
            ins.getX().add(t);
            
            repaint();
        }
        else if (ins.getMode() == 6) {
            x1=e.getX();
            y1=e.getY();
           Copy c=new Copy();
           c.press(x1, y1, x2, y2);
            repaint();
            
        } else  if (ins.getMode() == 7) {

             repaint();
            Paste p = new Paste();
            p.press(x1, y1);
       
        }
        else if(ins.getMode()==8){
             x1=e.getX();
            y1=e.getY();
           Move m=new Move();
           m.press(x1, y1, x2, y2);
          
        }else if(ins.getMode()==9){
             x1=e.getX();
            y1=e.getY();
          Resize r=new Resize();
          r.press(x1, y1, x2, y2);
          repaint();
        }
         if(ins.getMode()==10){
          x1=e.getX();
            y1=e.getY();
           Delete d=new Delete();
           d.press(x1, y1, x2, y2);
          repaint();
     }
        }catch(Exception c){
              }  
         
     
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(ins.getMode()==8)
            repaint();
       
        ins.setMode(-1);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        try{
        if (ins.getMode() == 0) {
            x2 = e.getX();
            y2 = e.getY();
            Shape s = ins.getX().get(ins.getX().size() - 1);
            if (s instanceof Line) {
                Line l = (Line) s;
                l.setX2(x2);
                l.setY2(y2);
            }

            repaint();
            first = false;
        } else if (ins.getMode() == 1) {
            x2 = e.getX();
            y2 = e.getY();
            Shape s = ins.getX().get(ins.getX().size() - 1);
            if (s instanceof Rectangle) {
                Rectangle r = (Rectangle) s;
                r.setX2(x2);
                r.setY2(y2);
            }

            repaint();
            first = false;
        }else if (ins.getMode() == 2) {
            x2 = e.getX();
            y2 = e.getY();
            Shape s = ins.getX().get(ins.getX().size() - 1);
            if (s instanceof Circle) {
                Circle r = (Circle) s;
                r.setX2(x2);
                r.setY2(y2);
            }

            repaint();
            first = false;
        }else if (ins.getMode() == 3) {
            x2 = e.getX();
            y2 = e.getY();
            Shape s = ins.getX().get(ins.getX().size() - 1);
            if (s instanceof Square) {
                Square r = (Square) s;
                 
                r.setX2(x2);
                r.setY2(y2);
                
                 
            }

            repaint();
            first = false;
        }else if (ins.getMode() == 4) {
            x3=e.getX();
            y3=e.getY();
            y2=y3;
            if(x1<x3){
              x2=x3-2*(x3-x1);
            Shape s = ins.getX().get(ins.getX().size() - 1);
            if (s instanceof Triangle) {
                Triangle r = (Triangle) s;
                r.setX3(x3);
                r.setY3(y3);
                r.setX2(x2);
                r.setY2(y2);
            }
            repaint();
             first = false;
           }
            else if(x1>x3){
                x2=x3+2*(x1-x3);
                Shape s = ins.getX().get(ins.getX().size() - 1);
            if (s instanceof Triangle) {
                Triangle r = (Triangle) s;
                r.setX3(x3);
                r.setY3(y3);
                r.setX2(x2);
                r.setY2(y2);
            }
            repaint();
             first = false;
            }
        }else if (ins.getMode() == 5) {
            x3=e.getX();
            y3=e.getY();
            y2=y3;
              x2=x1;
              
            Shape s = ins.getX().get(ins.getX().size() - 1);
            if (s instanceof Right) {
                Right r = (Right) s;
                r.setX3(x3);
                r.setY3(y3);
                r.setX2(x2);
                r.setY2(y2);
            }
           
            repaint();
           
            first = false;
            
        }else if (ins.getMode() == 8) {
            x1 = e.getX();
            y1 = e.getY();
            Move m=new Move();
            m.drag(x1, y1);
        }else if (ins.getMode() == 9) {
            x2 = e.getX();
            y2 = e.getY();
            x3=e.getX();
            y3=e.getY();
            Resize r=new Resize();
            r.drag(x2, y2, x3, y3);
            repaint();
        }
    }catch(Exception c){
        
    }
    
    }
     
    @Override
    public void mouseMoved(MouseEvent e) {
    }
  
}
