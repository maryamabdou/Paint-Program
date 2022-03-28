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
public class Redo extends DoTemplate {
    Singleton ins=Singleton.getInstance();
    boolean undo1(){return false;}

    @Override
    public void undo(paint.Draw draw1) {
        
    }

    @Override
    public void redo(paint.Draw draw1) {
        if(ins.getS().size() >= 1)
        {
            draw1.add(ins.getS().get(ins.getS().size() - 1));
            ins.getX().add(ins.getS().get(ins.getS().size() - 1));
            ins.getS().remove(ins.getS().get(ins.getS().size() - 1));
           
        }
    }
}
