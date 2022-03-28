/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Color;

/**
 *
 * @author hosam
 */
public class CircleFactory implements ShapeFactory{
    public Shape createShape(int x1, int y1, int x2, int y2, Color color){
        return new Circle( x1, y1,x2, y2,  color);
    }
}
