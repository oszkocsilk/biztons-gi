package sample;

        import javafx.application.Application;
        import javafx.scene.Scene;
        import javafx.stage.Stage;

public class Main extends Application {

    /**
     * @param primaryStage first window,which you can see.
     * @throws Exception if exception occured.
     */

    @Override
    public void start(Stage primaryStage) throws Exception{


        primaryStage.setTitle("Aknakereső");
        Aknakereso aknakereso=new Aknakereso();
        new Controller(aknakereso);

        primaryStage.setScene(new Scene(aknakereso.getTable(), 750, 830));
        primaryStage.show();

    }

    /**
     * @param args is not used.
     */
    public static void main(String[] args) {
        launch(args);
    }

}
