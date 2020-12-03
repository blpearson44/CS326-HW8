import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class ColorApp implements ActionListener {
    // private var
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JButton button = new JButton("Click me!");
    private JLabel label = new JLabel("Clicks: 0");
    private int count = 0;

    public ColorApp() {
        // create button trigger
        button.addActionListener(this);

        // panel setup
        panel.setBorder(BorderFactory.createEmptyBorder(400, 400, 400, 400));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);

        // frame setup
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ColorApp");
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] str) {
        new ColorApp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        count++;
        label.setText("Clicks: " + count);
    }
}