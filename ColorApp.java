import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;
import java.applet.Applet;

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
    private JTextField redText;
    private JTextField greenText;
    private JTextField blueText;

    // selection list
    private String[] colors = { "red", "green", "blue" };
    private JList<String> colorsList;

    // default color values
    protected int red = 255, green = 255, blue = 255;

    // JCustom
    protected ColorPallette pallette;

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

        redText = new JTextField("");
        greenText = new JTextField("");
        blueText = new JTextField("");

        colorsList = new JList<String>(colors);

        pallette = new ColorPallette();

        redText.setText(String.valueOf(red));
        greenText.setText(String.valueOf(green));
        blueText.setText(String.valueOf(blue));
        // set bounds for objects

        // create button triggers
        save.addActionListener(new ActionHandler());
        reset.addActionListener(new ActionHandler());

        plusRed.addActionListener(new ActionHandler());
        minusRed.addActionListener(new ActionHandler());

        plusGreen.addActionListener(new ActionHandler());
        minusGreen.addActionListener(new ActionHandler());

        plusBlue.addActionListener(new ActionHandler());
        minusBlue.addActionListener(new ActionHandler());

        colorsList.addListSelectionListener(new ListHandler());

        // panel setup
        panel.setLayout(null);

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

        panel.add(redText);
        panel.add(greenText);
        panel.add(blueText);

        panel.add(colorsList);

        panel.add(pallette);

        // locations and sizes
        rLabel.setLocation(10, 250);
        rLabel.setSize(40, 40);
        redText.setLocation(60, 250);
        redText.setSize(90, 40);
        plusRed.setLocation(160, 250);
        plusRed.setSize(90, 40);
        minusRed.setLocation(260, 250);
        minusRed.setSize(90, 40);

        gLabel.setLocation(10, 300);
        gLabel.setSize(40, 40);
        greenText.setLocation(60, 300);
        greenText.setSize(90, 40);
        plusGreen.setLocation(160, 300);
        plusGreen.setSize(90, 40);
        minusGreen.setLocation(260, 300);
        minusGreen.setSize(90, 40);

        bLabel.setLocation(10, 350);
        bLabel.setSize(40, 40);
        blueText.setLocation(60, 350);
        blueText.setSize(90, 40);
        plusBlue.setLocation(160, 350);
        plusBlue.setSize(90, 40);
        minusBlue.setLocation(260, 350);
        minusBlue.setSize(90, 40);

        save.setLocation(10, 420);
        save.setSize(90, 20);
        reset.setLocation(110, 420);
        reset.setSize(90, 20);
        colorsList.setLocation(400, 10);
        colorsList.setSize(90, 480);

        pallette.setLocation(10, 10);
        pallette.setSize(380, 230);

        // frame setup
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Color Sampler");
        // frame.pack(); figured out this is what was initially messing with my window
        frame.setVisible(true);
    }

    public static void main(String[] str) {
        new ColorApp();
    }

    private class ColorPallette extends JComponent {
        private static final long serialVersionUID = 1L;

        public void paint(Graphics graph) {
            Dimension d = getSize();
            graph.setColor(new Color(red, green, blue, 255));
            graph.fillRect(0, 0, d.width, d.height);
        }
    }

    // For button presses
    private class ActionHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == save || e.getSource() == reset) {
                frame.setTitle("Color Sampler");
                if (e.getSource() == save) {

                } else {

                }

            } else {
                frame.setTitle("Color Sampler*");
                if (e.getSource() == plusRed) {
                    if (red <= 250) {
                        red += 5;
                        redText.setText(String.valueOf(red));
                        pallette.repaint();
                    }
                }
                if (e.getSource() == minusRed) {
                    if (red >= 5) {
                        red -= 5;
                        redText.setText(String.valueOf(red));
                        pallette.repaint();
                    }
                }
                if (e.getSource() == plusGreen) {
                    if (green <= 250) {
                        green += 5;
                        greenText.setText(String.valueOf(green));
                        pallette.repaint();
                    }
                }
                if (e.getSource() == minusGreen) {
                    if (green >= 5) {
                        green -= 5;
                        greenText.setText(String.valueOf(green));
                        pallette.repaint();
                    }
                }
                if (e.getSource() == plusBlue) {
                    if (blue <= 250) {
                        blue += 5;
                        blueText.setText(String.valueOf(blue));
                        pallette.repaint();
                    }
                }
                if (e.getSource() == minusBlue) {
                    if (blue >= 5) {
                        blue -= 5;
                        blueText.setText(String.valueOf(blue));
                        pallette.repaint();
                    }
                }
            }
        }
    }

    // For list choices
    private class ListHandler implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            // TODO Auto-generated method stub
            if (e.getSource() == colorsList) {
                frame.setTitle("Color Sampler");
            }
        }
    }
}