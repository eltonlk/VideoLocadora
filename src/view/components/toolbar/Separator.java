package view.components.toolbar;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Separator extends JComponent {

    public Separator() {
        setMaximumSize(new Dimension(15, Integer.MAX_VALUE));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Dimension size = getSize();
        int pos = size.width / 2;
        g.setColor(new java.awt.Color(211, 211, 211));
        g.drawLine(pos, 3, pos, size.height - 5);

    }
    
}