package sample;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class Controller implements mezo {


    public double timer=0.0;
    private Double score=0.0;
    private boolean lose=false;
    private Akna akna=new Akna();
    private Aknakereso aknakereso;
    private BlowedUp b;
    int disabled=0;
    private static EntityManager em;
    private Timer Timer=new Timer();
    ArrayList<Integer> toClear = new ArrayList<Integer>();
    NullBlower nullBlower = new NullBlower();


    EventHandler<MouseEvent> eventHandler = new EventHandler<>() {
        /**
         *
         * @param event az egér kattintásának eseméyne
         */
        @Override
        public void handle(MouseEvent event) {
            for (int i = 0; i < aknakereso.getMezo().length; i++) {
                for (int j = 0; j < aknakereso.getMezo().length; j++) {
                    if (event.getSource().equals(aknakereso.getMezo()[i][j])) {
                            disabled++;
                        if (counter[i][j] != 666) {

                            if (counter[i][j] == 0) {

                                aknakereso.getMezo()[i][j].setText(counter[i][j] + "");
                                aknakereso.getMezo()[i][j].setDisable(true);

                                toClear.add(i * 100 + j);
                                nullBlower.Blower(toClear);


                            } else {
                                aknakereso.getMezo()[i][j].setText(counter[i][j] + "");
                                aknakereso.getMezo()[i][j].setDisable(true);
                            }
                            disabled+=nullBlower.getDisabledCounter();
                            win();
                            nullBlower.setDisabledCounter(0);
                        } else {
                             b.Blowed();

                            b.display("LOSER","YOU LOST!");
                            lose=true;

                            }
                        }
                    }
                }
            }
        };
    private boolean win=false;

    public void win() {
        for (int i = 0; i < Aknakereso.counter[0].length; i++) {
            for (int j = 0; j < Aknakereso.counter.length; j++) {
                if (Aknakereso.counter[i][j] == BOMB && Aknakereso.mezo[i][j].isDisabled() == false) {
                    win = false;
                }
                else if(disabled==(all-akna.getNumberOfBombs()) ){
                    win=true;
                }
            }
        }
    }

    /**
     *
     * @param aknakereso a ltérehozott aknakeresőt hívja meg
     */
    public Controller(Aknakereso aknakereso) {
        this.aknakereso = aknakereso;
        this.b = new BlowedUp(aknakereso);

        new AnimationTimer(){
            @Override
            public void handle(long l) {

                    timer++;
                  //  System.out.println(timer / 60);

                if (win==true) {

                    score = ( akna.getNumberOfBombs() * 1000 )   /   ( timer / 60 );

                    System.out.println("score értéke:"+getScore());
                    b.display("WIN", "YOU WIN!\nYour score is: "+score);
                    data(score);
                    this.stop();

                }
                if (lose==true) {

                    this.stop();

                }
            }
        }.start();

        Timer.time((int)timer);

        for (int i = 0; i < aknakereso.getMezo().length; i++) {
            for (int j = 0; j < aknakereso.getMezo().length; j++) {
                aknakereso.getMezo()[i][j].addEventHandler(MouseEvent.MOUSE_CLICKED,eventHandler);
            }
        }
    }

    /**
     *
     * @param Score a jelenlegi játékos pontszáma feltöltéshez
     */
    private void data(double Score){


            EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-persistence-unit-1");
            em = emf.createEntityManager();
            createPlayer(Score);
            em.close();
            emf.close();
        }

    /**
     *
     * @param Score az aktuális játékos pontszáma
     */
    private static void createPlayer(double Score) {
        em.getTransaction().begin();
        Player emp = new Player(Score);
        em.persist(emp);
        em.getTransaction().commit();
    }
    public double getScore() {
        return score;
    }

}