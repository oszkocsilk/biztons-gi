package sample;

import java.util.ArrayList;

public class NullBlower implements mezo{

    private Akna akna= new Akna();
    private  int disabledCounter=0;

    /**
     *
     * @param toClear a letiltani kívánt gombok listája
     */
    public void Blower(ArrayList<Integer> toClear){

        if(toClear.size()==0)
        {
            return;
        }
        else
        {
            int i=toClear.get(0)/100;
            int j=toClear.get(0)%100;
            toClear.remove(0);
            if(counter[i][j]==0)
            {
                if(i>0 && j>0 && !mezo[i-1][j-1].isDisabled()) {                                                         //bal felső
                    mezo[i - 1][j - 1].setText(counter[i - 1][j - 1] + "");
                    if (counter[i - 1][j - 1] == 0) {
                        toClear.add((i - 1) * 100 + (j - 1));
                    }
                    if (mezo[i - 1][j - 1].isDisable() == false) {
                        disabledCounter++;
                        mezo[i - 1][j - 1].setDisable(true);
                    }

                }

                if(j>0 && !mezo[i][j-1].isDisabled()) {                                                                  //felső
                    mezo[i][j - 1].setText(counter[i][j - 1] + "");
                    if (counter[i][j - 1] == 0) {
                        toClear.add((i) * 100 + (j - 1));
                    }
                    if (mezo[i][j - 1].isDisable() == false) {
                        disabledCounter++;
                        mezo[i][j - 1].setDisable(true);
                    }
                }

                if(i>0 && !mezo[i-1][j].isDisabled()) {                                                                  //bal
                    mezo[i - 1][j].setText(counter[i - 1][j] + "");
                    if (counter[i - 1][j] == 0) {
                        toClear.add((i - 1) * 100 + (j));
                    }
                    if (mezo[i - 1][j].isDisable() == false) {
                        disabledCounter++;
                        mezo[i - 1][j].setDisable(true);
                    }
                }

                if(j<counter.length-1 && !mezo[i][j+1].isDisabled()) {                                                   //alsó
                    mezo[i][j + 1].setText(counter[i][j + 1] + "");
                    if (counter[i][j + 1] == 0) {
                        toClear.add((i) * 100 + (j + 1));
                    }
                    if (mezo[i][j + 1].isDisable() == false) {
                        disabledCounter++;
                        mezo[i][j + 1].setDisable(true);
                    }
                }

                if(i<counter[0].length-1 && !mezo[i+1][j].isDisabled()){                                                //jobb
                    mezo[i+1][j].setText(counter[i+1][j]+"");

                    if(counter[i+1][j]==0) {
                        toClear.add((i + 1) * 100 + (j));
                    }
                    if(mezo[i+1][j].isDisable()==false) {
                        disabledCounter++;
                        mezo[i + 1][j].setDisable(true);
                    }
                }

                if(i<counter[0].length-1 && j>0 && !mezo[i+1][j-1].isDisabled()) {                                       //jobb felső
                    mezo[i + 1][j - 1].setText(counter[i + 1][j - 1] + "");

                    if (counter[i + 1][j - 1] == 0) {
                        toClear.add((i + 1) * 100 + (j - 1));
                    }
                    if (mezo[i + 1][j - 1].isDisable() == false) {
                        disabledCounter++;
                        mezo[i + 1][j - 1].setDisable(true);
                    }
                }

                if(i>0 && j<counter.length-1 && !mezo[i-1][j+1].isDisabled()) {                                          //bal alsó
                    mezo[i - 1][j + 1].setText(counter[i - 1][j + 1] + "");

                    if (counter[i - 1][j + 1] == 0) {
                        toClear.add((i - 1) * 100 + (j + 1));
                    }
                    if (mezo[i - 1][j + 1].isDisable() == false) {
                        disabledCounter++;
                        mezo[i - 1][j + 1].setDisable(true);
                    }
                }

                if(i<counter[0].length-1 && j<counter.length-1 && !mezo[i+1][j+1].isDisabled()) {                        //jobb alsó
                    mezo[i + 1][j + 1].setText(counter[i + 1][j + 1] + "");

                    if (counter[i + 1][j + 1] == 0) {
                        toClear.add((i + 1) * 100 + (j + 1));
                    }
                    if (mezo[i + 1][j + 1].isDisable() == false) {
                        disabledCounter++;
                        mezo[i + 1][j + 1].setDisable(true);
                    }
                }
            }
            Blower(toClear);
        }
    }

    /**
     *
     * @return a deaktivált gombok száma
     */

    public int getDisabledCounter() {
        return disabledCounter;
    }

    /**
     *
     * @param disabledCounter a deaktivált gombok számának modosítása
     */
    public void setDisabledCounter(int disabledCounter) {
        this.disabledCounter = disabledCounter;
    }
}
