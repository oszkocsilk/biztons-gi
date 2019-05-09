package sample;

import java.util.ArrayList;



public class Akna implements mezo{

    private ArrayList<Integer>list = new ArrayList<Integer>();
    private double NumberOfBombs=2.0;



    public void aknák() {
        for (int i = 0; i < counter[0].length; i++) {
            for (int j = 0; j < counter.length; j++) {
                list.add(i * 100 + j);
            }
        }


        for (int i = 0; i < NumberOfBombs; i++) {
            int bomb = (int) (Math.random() * list.size());
            counter[list.get(bomb) / 100][list.get(bomb) % 100] = BOMB;
            list.remove(bomb);


        }
        for (int i = 0; i < counter[0].length; i++) {
            for (int j = 0; j < counter.length; j++) {
                if (counter[i][j] != BOMB) {
                    int szomszed = 0;
                    if (i > 0 && j > 0 && counter[i - 1][j - 1] == BOMB)                                    //bal felső
                        szomszed++;
                    if (j > 0 && counter[i][j - 1] == BOMB)                                             //felső
                        szomszed++;
                    if (i > 0 && counter[i - 1][j] == BOMB)                                             //bal
                        szomszed++;
                    if (j < counter.length - 1 && counter[i][j + 1] == BOMB)                              //alsó
                        szomszed++;
                    if (i < counter[0].length - 1 && counter[i + 1][j] == BOMB)                           //jobb
                        szomszed++;
                    if (i < counter[0].length - 1 && j < counter.length - 1 && counter[i + 1][j + 1] == BOMB)   //jobb felső
                        szomszed++;
                    if (i > 0 && j < counter.length - 1 && counter[i - 1][j + 1] == BOMB)                     //bal alsó
                        szomszed++;
                    if (i < counter[0].length - 1 && j > 0 && counter[i + 1][j - 1] == BOMB)                  //jobb alsó
                        szomszed++;

                    counter[i][j] = szomszed;
                }
            }
        }
    }

    /**
     *
     * @return gives the number of bombs
     */
    public double getNumberOfBombs() {
        return NumberOfBombs;
    }
}

