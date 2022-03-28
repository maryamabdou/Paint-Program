/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.util.ArrayList;

/**
 *
 * @author hosam
 */
public class Singleton {

    public  ArrayList<Shape> getX() {
        return x;
    }

    public  void setX(ArrayList<Shape> x) {
        this.x = x;
    }

    public  ArrayList<Shape> getS() {
        return s;
    }

    public  void setS(ArrayList<Shape> s) {
        this.s = s;
    }


    public  int getIndex() {
        return index;
    }

    public  void setIndex(int index) {
        this.index = index;
    }

    public  int getIndexR() {
        return indexR;
    }

    public  void setIndexR(int indexR) {
        this.indexR = indexR;
    }

    public  int getMode() {
        return mode;
    }

    public  void setMode(int mode) {
        this.mode = mode;
    }
    private  ArrayList<Shape> x = new ArrayList<>();
    private  ArrayList<Shape> s = new ArrayList<>();
    private static  Singleton ins;
    private int index,indexR;
     private int mode = -1;
    private Singleton(){
        
    }
    public static Singleton getInstance(){
        if (ins==null)
            ins= new Singleton();
            return ins;
        
    }
}
