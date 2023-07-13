import javax.swing.*;
import java.awt.*;

public class Main {
    private static boolean lightEnabled = false;
    private static void clickTurnOn(JFrame frame) {
        if (lightEnabled) {
            frame.dispose();
            frame.setExtendedState(JFrame.NORMAL);
            frame.setSize(250, 80);
            frame.setUndecorated(false);
            frame.setVisible(true);
        } else {
            frame.dispose();
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setUndecorated(true);
            frame.setVisible(true);
        }
        frame.getComponent()
        lightEnabled = !lightEnabled;
    }
    private static JFrame setupWindow() {
        JFrame frame = new JFrame("Screen Lamp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 80);
        frame.setVisible(true);
        return frame;
    }
    private static void createControls(JFrame frame) {
        JButton toggleButton = new JButton("Turn on lamp");
        JButton closeButton = new JButton("Close");
        JPanel panel = new JPanel();
        toggleButton.addActionListener(e -> { clickTurnOn(frame); toggleButton.setText("Turn off lamp"); });
        closeButton.addActionListener(e -> System.exit(0));
        panel.add(toggleButton);
        panel.add(closeButton);
        frame.getContentPane().add(panel);
    }

    public static void main(String[] args) {
        createControls(setupWindow());
    }
}