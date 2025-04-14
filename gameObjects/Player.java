package gameObjects;

import abstracts.Controllable;
import java.awt.*;
import utils.Coordinates;
import utils.Direction;
import utils.DrawingInformation;

public class Player extends Controllable {

    private int life_left = 3;                            //imposto le vite del giocatore a 3
    private boolean winner = false;
    private boolean looser = false;
    private Direction currentDirection = Direction.STAY;  //direzione corrente
    private Coordinates previousCoordinates;              //variabile per tenere conto delle coordinate precedenti ad un possibile movimento non concesso
    private final Coordinates initialPosition;            // variabile per la posizione iniziale per il reset
    private String previousKey = "";                      //tiene memoria dell'ultimo tasto premuto


    public Player(Coordinates coordinates) {
        super(coordinates);
        this.initialPosition = coordinates; // setto la posizione iniziale quando parte il costruttore
    }

    @Override
    public void move(Direction direction) {
        //metto nella variabile currentDirection la direzione scelta dall'utente, cosi poi da gestire il movimento da update()
        this.currentDirection = direction;

    }

    @Override
    public void update() {

        this.previousCoordinates = coordinates; //salvo la cordinata precedente per poter fare il resetCordinates()

        int currentRow = coordinates.getRow();  //prendo riga corrente
        int currentCol = coordinates.getCol();  //prendo colonna corrente

        switch(this.currentDirection){  //faccio uno switch che in base alla direzione scelta muove il player

            case UP -> {
                coordinates = new Coordinates(currentRow - 1, currentCol);   //verso l'alto
                this.previousKey = "w";
            }
            case DOWN -> {
                coordinates = new Coordinates(currentRow + 1, currentCol);  //verso il basso
                this.previousKey = "s";
            }
            case LEFT -> {
                coordinates = new Coordinates(currentRow, currentCol - 1);  //verso sinistra
                this.previousKey = "a";
            }
            case RIGHT -> {
                coordinates = new Coordinates(currentRow, currentCol + 1); //verso destra
                this.previousKey = "d";
            }
            case STAY -> continueMovement(this.previousKey, currentCol, currentRow); //quando l'utente non clicca pulsanti deve andare dritto

            default -> {
            }

        }        
    }

    //questa funzione permette di continuare il movimento quando il player è in STAY
    //facendo uno switch dell'ultimo tasto premuto
    public void continueMovement(String k, int currentCol, int currentRow){

        switch(k){
            case "w" -> coordinates = new Coordinates(currentRow - 1, currentCol);  //verso l'alto
            case "s" -> coordinates = new Coordinates(currentRow + 1, currentCol);  //verso il basso
            case "d" -> coordinates = new Coordinates(currentRow, currentCol + 1);  //verso sinistra
            case "a" -> coordinates = new Coordinates(currentRow, currentCol - 1);  //verso destra
        }

    }

    public boolean isWinner() {
        return this.winner;
    }

    public boolean isLooser() {
        return this.looser;
    }

    public void markAsWinner() {
        this.winner = true;
    }

    public void handleDamage() {
        if(life_left > 0){
            life_left --;  //riduco le vite del giocatore
            this.currentDirection = Direction.STAY;  //metto la direzione del player alla rinascita su STAY
            this.previousKey = "";
            coordinates = this.initialPosition; //reimposto le coordinate del player a quelle iniziali 
        }
        if(this.life_left == 0){
            this.looser = true;  //imposto looser  a true se le vite sono terminate
        }   
    }

    @Override
    public DrawingInformation draw() {
        return new DrawingInformation('P', new Color(255,165,0)); //player di colore arancione chiaro
    }

    public void resetCoordinates() {
        //riporto il giocatore alla posizione precedente dopo che è andato in una posizione illegale
        coordinates = this.previousCoordinates;
    }

    public int getLife() {
        return this.life_left;  //restituisco il numero di vite rimaste
    }
}
