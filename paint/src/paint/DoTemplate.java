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
public abstract class DoTemplate {
   paint.Draw draw1;
    
   final void choose(){
        if(undo1()){
     undo(draw1);
        }else if(redo1())
        {
        redo(draw1);
        }
    }
public abstract void undo(paint.Draw draw1);
public abstract void redo(paint.Draw draw1);
     boolean undo1(){return true;}
      boolean redo1(){return true;}
       
}
