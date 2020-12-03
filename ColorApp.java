import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

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

    private int r = 255, g = 255, b = 255;

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

        red.setText(String.valueOf(r));
        green.setText(String.valueOf(g));
        blue.setText(String.valueOf(b));
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

        panel.add(red);
        panel.add(green);
        panel.add(blue);

        panel.add(colorsList);

        // locations and sizes
        rLabel.setLocation(10, 250);
        rLabel.setSize(40, 40);
        red.setLocation(60, 250);
        red.setSize(90, 40);
        plusRed.setLocation(160, 250);
        plusRed.setSize(90, 40);
        minusRed.setLocation(260, 250);
        minusRed.setSize(90, 40);

        gLabel.setLocation(10, 300);
        gLabel.setSize(40, 40);
        green.setLocation(60, 300);
        green.setSize(90, 40);
        plusGreen.setLocation(160, 300);
        plusGreen.setSize(90, 40);
        minusGreen.setLocation(260, 300);
        minusGreen.setSize(90, 40);

        bLabel.setLocation(10, 350);
        bLabel.setSize(40, 40);
        blue.setLocation(60, 350);
        blue.setSize(90, 40);
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

        // frame setup
        frame.add(panel);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Color Sampler");
        // frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] str) {
        new ColorApp();
    }

    private class ColorPallette extends JComponent {
        private static final long serialVersionUID = 1L;

        public void paint(Graphics graph) {
            Dimension d = getSize();
            graph.setColor(new Color(r, g, b, 255));
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
                    if (r <= 250) {
                        r += 5;
                        red.setText(String.valueOf(r));
                    }
                }
                if (e.getSource() == minusRed) {
                    if (r >= 5) {
                        r -= 5;
                        red.setText(String.valueOf(r));
                    }
                }
                if (e.getSource() == plusGreen) {
                    if (g <= 250) {
                        g += 5;
                        green.setText(String.valueOf(g));
                    }
                }
                if (e.getSource() == minusGreen) {
                    if (g >= 5) {
                        g -= 5;
                        green.setText(String.valueOf(g));
                    }
                }
                if (e.getSource() == plusBlue) {
                    if (b <= 250) {
                        b += 5;
                        blue.setText(String.valueOf(b));
                    }
                }
                if (e.getSource() == minusBlue) {
                    if (b >= 5) {
                        b -= 5;
                        blue.setText(String.valueOf(b));
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