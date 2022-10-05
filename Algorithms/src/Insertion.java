import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class Insertion{
    public Insertion() {}

    public static void insertSorting(@NotNull SortingPanel A) {
        System.out.println("Insert sort called");
        new Thread(() -> {
            //Iterating every element, starting from the second key
            System.out.println("Thread started");
            for (int i = 1; i < A.getLength(); i++) {
                //storing the key for later insertion
                int key = A.getValue(i);
                //getting a new index to check the keys on the left (already sorted)
                int j = i-1;
                //while j is not negative, or the key at J index is not bigger than the current key
                //we move every key to the right
                while(j >= 0 && A.getValue(j) > key){
                    //moving the current J key to the right (J+1)
                    int finalJ = j;
                    SwingUtilities.invokeLater(() -> {
                        A.highlightSwap(finalJ+1, finalJ);
                    });
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    SwingUtilities.invokeLater(() -> {
                        A.swap(finalJ +1, finalJ, A.getValue(finalJ));
                    });
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    //decreasing J to continue
                    j--;
                }
                //Finally, the last J index will be the new key index
                int finalJ = j;
                int finalI = i;
                SwingUtilities.invokeLater(() -> {
                    A.highlightSwap(finalJ+1, finalI);
                });
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                SwingUtilities.invokeLater(() -> {
                    A.swap(finalJ+1, finalI, key);
                });
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}

