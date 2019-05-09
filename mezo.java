package sample;

import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public interface mezo {

    int width=30;
    int height=30;
    int all=width*height;

    Button[][] mezo= new Button[width][height];
    AnchorPane table = new AnchorPane();

    int[][] counter= new int[width][height];
    int BOMB=666;

}
