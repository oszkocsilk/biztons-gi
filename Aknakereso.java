package sample;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;


public class Aknakereso implements mezo{


    private static int buttonLayout= 50;
    private Akna Leteszi =new Akna();


    public Aknakereso() {

        for (int i=0;i<mezo[0].length;i++)
        {   for(int j=0;j<mezo[1].length;j++)
            {
                mezo[i][j] = new Button();
                mezo[i][j].setPrefSize(25,25);
                mezo[i][j].setLayoutX(25*i);
                mezo[i][j].setLayoutY(buttonLayout+25*j);
                table.getChildren().add(mezo[i][j]);

            }
        }
        Leteszi.aknák();
    }

    /**
     *
     * @return helps to get the link the empty slots
     */
    public Button[][] getMezo() {
        return mezo;
    }

    /**
     *
     * @return gives an orderd table with the slots
     */
    public AnchorPane getTable() {
        return table;
    }

}
