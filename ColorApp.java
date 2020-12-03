import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import java.util.*;

public class ColorApp {
    // default values
    private String filename = "colors.txt";
    private int numColors = 11;

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
    private NamedColor[] colors = new NamedColor[numColors];
    private JList<NamedColor> colorsList;

    // default color values
    protected int red = 255, green = 255, blue = 255;

    // JCustom
    protected ColorPallette pallette;

    public class NamedColor {
        public String name;
        public int rval, gval, bval;

        @Override
        public String toString() {
            return name;
        }
    }

    public void FileInput(NamedColor[] c) throws IOException {
        FileInputStream stream = new FileInputStream(filename);
        InputStreamReader reader = new InputStreamReader(stream);
        StreamTokenizer tokens = new StreamTokenizer(reader);
        int numColors = 0;

        while (tokens.nextToken() != StreamTokenizer.TT_EOF) // idk why the one from the lecture slides wont
        {
            c[numColors] = new NamedColor();
            c[numColors].name = (String) tokens.sval;
            tokens.nextToken();
            c[numColors].rval = (int) tokens.nval;
            tokens.nextToken();
            c[numColors].gval = (int) tokens.nval;
            tokens.nextToken();
            c[numColors].bval = (int) tokens.nval;
            numColors++;
        }
        stream.close();
    }

    public ColorApp() throws IOException {
        FileInput(colors);
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
        redText.setHorizontalAlignment(JTextField.CENTER);
        greenText = new JTextField("");
        greenText.setHorizontalAlignment(JTextField.CENTER);
        blueText = new JTextField("");
        blueText.setHorizontalAlignment(JTextField.CENTER);

        colorsList = new JList<NamedColor>(colors);

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
        minusRed.setLocation(70, 250);
        minusRed.setSize(90, 40);
        redText.setLocation(180, 250);
        redText.setSize(90, 40);
        plusRed.setLocation(290, 250);
        plusRed.setSize(90, 40);

        gLabel.setLocation(10, 300);
        gLabel.setSize(40, 40);
        minusGreen.setLocation(70, 300);
        minusGreen.setSize(90, 40);
        greenText.setLocation(180, 300);
        greenText.setSize(90, 40);
        plusGreen.setLocation(290, 300);
        plusGreen.setSize(90, 40);

        bLabel.setLocation(10, 350);
        bLabel.setSize(40, 40);
        minusBlue.setLocation(70, 350);
        minusBlue.setSize(90, 40);
        blueText.setLocation(180, 350);
        blueText.setSize(90, 40);
        plusBlue.setLocation(290, 350);
        plusBlue.setSize(90, 40);

        save.setLocation(110, 420);
        save.setSize(90, 20);
        reset.setLocation(210, 420);
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
        try {
            new ColorApp();
        } catch (Exception e) {
            System.out.println("Whoops");
        }
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
                    colorsList.getSelectedValue().rval = red;
                    colorsList.getSelectedValue().gval = green;
                    colorsList.getSelectedValue().bval = blue;
                    FileOut(colors);
                } else {
                    red = colorsList.getSelectedValue().rval;
                    green = colorsList.getSelectedValue().gval;
                    blue = colorsList.getSelectedValue().bval;
                    redText.setText(String.valueOf(red));
                    greenText.setText(String.valueOf(green));
                    blueText.setText(String.valueOf(blue));
                    pallette.repaint();
                }

            } else {
                if (e.getSource() == plusRed) {
                    if (red <= 250) {
                        frame.setTitle("Color Sampler*");
                        red += 5;
                        redText.setText(String.valueOf(red));
                        pallette.repaint();
                    }
                }
                if (e.getSource() == minusRed) {
                    if (red >= 5) {
                        frame.setTitle("Color Sampler*");
                        red -= 5;
                        redText.setText(String.valueOf(red));
                        pallette.repaint();
                    }
                }
                if (e.getSource() == plusGreen) {
                    if (green <= 250) {
                        frame.setTitle("Color Sampler*");
                        green += 5;
                        greenText.setText(String.valueOf(green));
                        pallette.repaint();
                    }
                }
                if (e.getSource() == minusGreen) {
                    if (green >= 5) {
                        frame.setTitle("Color Sampler*");
                        green -= 5;
                        greenText.setText(String.valueOf(green));
                        pallette.repaint();
                    }
                }
                if (e.getSource() == plusBlue) {
                    if (blue <= 250) {
                        frame.setTitle("Color Sampler*");
                        blue += 5;
                        blueText.setText(String.valueOf(blue));
                        pallette.repaint();
                    }
                }
                if (e.getSource() == minusBlue) {
                    if (blue >= 5) {
                        frame.setTitle("Color Sampler*");
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
            if (e.getSource() == colorsList) {
                frame.setTitle("Color Sampler");
                if (!e.getValueIsAdjusting()) {
                    NamedColor temp = (NamedColor) colorsList.getSelectedValue();
                    red = temp.rval;
                    green = temp.gval;
                    blue = temp.bval;
                    redText.setText(String.valueOf(red));
                    greenText.setText(String.valueOf(green));
                    blueText.setText(String.valueOf(blue));
                    pallette.repaint();
                }
            }
        }
    }

    public void FileOut(NamedColor[] c) {
        try {
            FileOutputStream ostream = new FileOutputStream(filename); // Save any changes on close
            PrintWriter writer = new PrintWriter(ostream);
            for (int i = 0; i < numColors; i++) {
                writer.println(c[i].name + " " + c[i].rval + " " + c[i].gval + " " + c[i].bval);
            }
            writer.flush();
            ostream.close();
        } catch (IOException f) {
            System.out.println("File write error");
        }
    }
}
