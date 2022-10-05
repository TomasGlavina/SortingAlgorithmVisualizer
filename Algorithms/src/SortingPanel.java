import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SortingPanel extends JPanel {
    private int[] array = new int[255];
    private Color[] colors = new Color[255];
    private final int SLEEP_TIME = 2500;

    public SortingPanel(){
        setArray();
    }
    private Random random = new Random();
    public void setArray(){
        for(int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(0, 60000);
            colors[i] = Color.WHITE;
        }
    }

    public int[] getArray(){
        return this.array;
    }

    public int getLength(){
        return this.array.length;
    }

    public int getValue(int index){
        return this.array[index];
    }
    public boolean isSorted(){
        for(int i = 0; i < this.array.length-1; i++){
            if(this.array[i] > this.array[i+1]) return false;
        }
        return true;
    }


    public void highlightSwap(int fIndex, int sIndex){
        colors[fIndex] = Color.ORANGE;
        colors[sIndex] = Color.ORANGE;
        revalidate();
        repaint(5);
    }
    public void swap(int fIndex, int sIndex, int value) {
        array[fIndex] = value;
        colors[fIndex] = Color.WHITE;
        colors[sIndex] = Color.WHITE;
        revalidate();
        repaint(5);
    }


    public static void sleepFor(long nanoseconds){
        long timeElapsed;
        final long startTime = System.nanoTime();
        do{
            timeElapsed = System.nanoTime() - startTime;
        } while(timeElapsed < nanoseconds);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D graphics = (Graphics2D)g;
        super.paintComponent(graphics);
        this.setBackground(Color.BLACK);


        for(int i = 0; i < this.array.length; i++) {
            g.setColor(colors[i]);
            g.drawRect(i*5, 710-(this.array[i]/100), 5, array[i]);
            g.fillRect(i*5, 710-(this.array[i]/100), 5, array[i]);
        }

    }
}
