import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class ColorApp {
    // private var
    // frame and panel
    private JFrame frame;
    private JPanel panel;

    // labels
    private JLabel rLabel;
    private JLabel gLabel;
    private JLabel bLabel;

    // buttons
    private JButton save;
    private JButton reset;

    private JButton plusRed;
    private JButton minusRed;

    private JButton plusGreen;
    private JButton minusGreen;

    private JButton plusBlue;
    private JButton minusBlue;

    // text fields
    private JTextField red;
    private JTextField green;
    private JTextField blue;

    // selection list
    private String[] colors = { "red", "green", "blue" };
    private JList<String> colorsList;

    public ColorApp() {
        // set var
        frame = new JFrame();
        panel = new JPanel();

        rLabel = new JLabel("Red:");
        gLabel = new JLabel("Green:");
        bLabel = new JLabel("Blue:");

        save = new JButton("Save");
        reset = new JButton("Reset");

        plusRed = new JButton("+");
        minusRed = new JButton("-");

        plusGreen = new JButton("+");
        minusGreen = new JButton("-");

        plusBlue = new JButton("+");
        minusBlue = new JButton("-");

        red = new JTextField("");
        green = new JTextField("");
        blue = new JTextField("");

        colorsList = new JList<String>(colors);

        // create button trigger
        save.addActionListener(new ActionHandler());
        reset.addActionListener(new ActionHandler());

        plusRed.addActionListener(new ActionHandler());
        minusRed.addActionListener(new ActionHandler());

        plusGreen.addActionListener(new ActionHandler());
        minusGreen.addActionListener(new ActionHandler());

        plusBlue.addActionListener(new ActionHandler());
        minusBlue.addActionListener(new ActionHandler());

        // panel setup
        panel.setBorder(BorderFactory.createEmptyBorder(400, 400, 400, 400));
        panel.setLayout(new GridLayout(3, 0));

        panel.add(rLabel);
        panel.add(gLabel);
        panel.add(bLabel);

        panel.add(save);
        panel.add(reset);

        panel.add(plusRed);
        panel.add(minusRed);

        panel.add(plusGreen);
        panel.add(minusGreen);

        panel.add(plusBlue);
        panel.add(minusBlue);

        panel.add(red);
        panel.add(green);
        panel.add(blue);

        panel.add(colorsList);

        // frame setup
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Color Sampler");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] str) {
        new ColorApp();
    }

    private class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == save || e.getSource() == reset) {
                frame.setTitle("Color Sampler");
                if (e.getSource() == save) {

                }
            } else {
                frame.setTitle("Color Sampler*");
                if (e.getSource() == plusRed) {
                }
                if (e.getSource() == minusRed) {
                }
                if (e.getSource() == plusGreen) {
                }
                if (e.getSource() == minusGreen) {
                }
                if (e.getSource() == plusBlue) {
                }
                if (e.getSource() == minusBlue) {
                }
            }
        }
    }
}