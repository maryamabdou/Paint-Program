/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

/**
 *
 * @author hosam
 *
 */



public class Undo extends DoTemplate {
        Singleton ins=Singleton.getInstance();
  boolean redo1(){return false;}


    @Override
    public void undo(paint.Draw draw1) {
       if(ins.getX().size() >= 1)
        {
       int size =ins.getX().size();
         ins.getS().add(ins.getX().get(size - 1));
         
         
         draw1.remove(ins.getX().remove(size-1));
         
         
        }
    }

    @Override
    public void redo(paint.Draw draw1) {
        
    }
    
    }

