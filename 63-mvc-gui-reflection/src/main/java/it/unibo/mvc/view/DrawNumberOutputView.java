package it.unibo.mvc.view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberOutputView implements DrawNumberView {

    private static final String OUT = "Test:";
    private final JFrame frame = new JFrame(OUT);

    public DrawNumberOutputView() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void setController(DrawNumberController observer) { }

    @Override
    public void start() {
        this.frame.setVisible(true);
    }

    @Override
    public void result(DrawResult res) {
        JOptionPane.showMessageDialog(frame, res, OUT, JOptionPane.PLAIN_MESSAGE);
    }
}
