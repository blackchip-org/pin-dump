/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author mcgann
 */
public class DisplayPanel extends JPanel {

    private ImageFrame f = null;

    private Color[] colors = new Color[] {
         new Color(16, 16, 16),
         new Color(32, 32, 32),
         new Color(64, 64, 64),
         new Color(128, 128, 128)
    };

    public void setImageFrame(ImageFrame iframe) {
        this.f = iframe;
    }

    @Override
    public void paintComponent(Graphics g1) {
        if ( f == null ) { return; }
        
        Graphics2D g = (Graphics2D)g1;

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                           RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        int off = 10;
        for ( int x = 0; x < f.getWidth(); x++ ) {
            for ( int y = 0; y < f.getHeight(); y++ ) {
                int px = x * 6;
                int py = y * 6;
                int v = f.pixelAt(x, y);
                if ( v == 0 ) { 
                    g.setColor(colors[0]);
                } else {
                    g.setColor(colors[4 - v]);
                }
                g.fillOval(px + 1 + off, py + 1 + off, 4, 4);
            }
        }

    }
}
