
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class AlgorithmTest {
    public static final int  WINDOW_WIDTH = 1280;
    public static final int  WINDOW_HEIGHT = 720;

    private JFrame window;
    SortingPanel panel;
    JButton insertion;
    JButton merge;
    JButton reset;


    public AlgorithmTest(){
        window = new JFrame("Sorting Visualizer");
        window.getContentPane().setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        panel = new SortingPanel();
        window.getContentPane().add(panel);
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        insertion = new JButton("Insertion");
        insertion.setBackground(Color.WHITE);
        insertion.setFocusPainted(false);
        insertion.setBorderPainted(false);
        insertion.addActionListener(e -> {
            try {
                Insertion.insertSorting(panel);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        reset = new JButton("Reset");
        reset.setBackground(Color.WHITE);
        reset.setFocusPainted(false);
        reset.setBorderPainted(false);
        reset.addActionListener(e -> {
            panel.setArray();
            panel.repaint();
        });

        panel.add(insertion);
        panel.add(reset);

    }


    public static void main(String[] Args){
        SwingUtilities.invokeLater(() -> {
            AlgorithmTest test = new AlgorithmTest();
        });

        SortingPanel A = new SortingPanel();
        Insertion.insertSorting(A);

    }

}
