package sample;

import  javax.persistence.*;


@Entity
@Table(name = "Akna")
public class Player {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;
    private double Score;

    /**
     *
     * @return a játékos azonosítója
     */

    public Integer getID() {
        return ID;
    }

    /**
     *
     * @param ID a játékos azonosítója
     */

    public void setID(Integer ID) {
        this.ID = ID;
    }

    /**
     *
     * @return a játékos eredménye
     */

    public double getScore() {
        return Score;
    }

    /**
     *
     * @param Score játékos eredménye
     */

    public void Score(double Score) {
        Score = Score;
    }

    /**
     *
     * @param ID  a játékos azonosítója
     * @param Score a játékos eredménye
     */

    public Player(Integer ID, double Score) {
        this.ID = ID;
        this.Score = Score;
    }

    /**
     *
     * @param Score a játékos eredménye
     */
    public Player( double Score) {
        this.Score = Score;
    }

    /**
     *
     * @return a táblázat fejlécének szöveges formátuma és eredményei
     */
    @Override
    public String toString() {
        return "Player{" +
                "ID=" + ID +
                ", Score=" + Score +
                '}';
    }

    public Player() {
    }

}
