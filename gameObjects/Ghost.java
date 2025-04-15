package gameObjects;

import abstracts.Drawable;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import utils.Coordinates;
import utils.Direction;
import utils.DrawingInformation;


public class Ghost extends Drawable {

    private ArrayList<Direction> availDirections; // Direzioni disponibili
    private final Coordinates initialPosition;
    private Direction lastDirection;              //variabile che tiene conto della direzione precedente

    public Ghost(Coordinates coords) {
        super(coords);
        this.initialPosition = coords; 
    }

    public void setAvailDirections(ArrayList<Direction> availDirections) {
        this.availDirections = availDirections;  //prendo le direzioni disponibili
    }

    private void move(Direction randomDirection){
        //sposto i fantasmi in base alla direzione uscita;
        switch (randomDirection) {
            case UP -> coordinates = new Coordinates(coordinates.getRow() - 1, coordinates.getCol());
            case DOWN -> coordinates = new Coordinates(coordinates.getRow() + 1, coordinates.getCol());
            case LEFT -> coordinates = new Coordinates(coordinates.getRow(), coordinates.getCol() - 1);
            case RIGHT -> coordinates = new Coordinates(coordinates.getRow(), coordinates.getCol() + 1);
            default -> throw new IllegalArgumentException("Unexpected direction");
        }
    }

    @Override
    public void update() {
        //genero un numero randomico in base a quante direzioni sono contenute nell'ArrayList e salvo il una variabile la direzione uscita in modo randomico
        Random rand = new Random();
        Direction randomDirection = availDirections.get(rand.nextInt(availDirections.size()));  //sortegio randomicamente una tra le direzioni disponibili in quel momento

        if(randomDirection != Direction.getOpposite(lastDirection)){
            //voglio che la direzione uscita sia diversa dalla direzione opposta alla precedente, senno torna indietro

            move(randomDirection);   //passo a move la direzione che gestirà il movimento del fantsma
            this.lastDirection = randomDirection;  //imposto la direzione nuova come ultima direzione 

        }else if(availDirections.size() == 1){ 
            //se il fantasma è in un vicolo chiuso con solo 1 strada disponibile, voglio che si muova dalla parte opposta

            move(randomDirection);
            this.lastDirection = randomDirection;
            
        }

    }
    
    public void resetPosition() {
        coordinates = this.initialPosition;
    }

    @Override
    public DrawingInformation draw() {
        
        //creo uno switch che in base al numero uscito genera un diverso colore nelle sfumature dell'azzurro 
        //per dare l'idea che i fantasmi stiano lampeggiando
        
        Random rand = new Random();
        int randomNum = rand.nextInt(4) + 1; //numero casuale da 1 a 4, ogni numero ha una sfumatura diversa

        switch(randomNum){

            case 1 -> {
                return new DrawingInformation('G', new Color(0, 191, 255)); 
            }
            case 2 -> {
                return new DrawingInformation('G', new Color(30, 161, 235)); 
            }
            case 3 -> {
                return new DrawingInformation('G', new Color(0, 135, 215)); 
            }
            case 4 -> {
                return new DrawingInformation('G', new Color(60, 211, 255)); 
            }
            default -> {
                return new DrawingInformation('G', new Color(0, 191, 255));
            }

        }
    }
        
}
