/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pin;

import java.util.ArrayList;

/**
 *
 * @author mcgann
 */
public class ImageFrame {

    int width = 128;
    int height = 32;
    int depth = 0;

    ArrayList<Byte> b;
    int pos = 0;

    public ImageFrame(ArrayList<Byte> b) {
        this.b = b;
    }

    public void setPosition(int pos) {
        this.pos = pos;
    }

    public void forward() {
        pos++;
    }

    public void backward() {
        pos--;
    }

    public int position() {
        return pos;
    }

    public void forwardRow() {
        pos += width;
    }

    public void backwardRow() {
        pos -= width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
         return this.height;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getDepth() {
        return this.depth;
    }

    public int pixelAt(int x, int y, int theDepth) {
        int idx = pos + (y * width) + x + (theDepth * width * height);
        return b.get(idx);
    }

    public int pixelAt(int x, int y) {
        int v = 0;
        for ( int i = 0; i <= depth; i++ ) {
            v += pixelAt(x, y, i);
        }
        return v;
    }

}
