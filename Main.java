import canvas.TileDrawer;
import core.GameUpdater;
import javax.swing.JFrame;
import utils.Config;
import utils.DrawingInformation;
import utils.TimedSocket;

public class Main {

    public static void main(String[] args) {
        //Setup
        JFrame window = new JFrame();
        TileDrawer drawer = new TileDrawer();
        window.add(drawer);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(0, 0, Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        window.setResizable(false);
        window.setTitle("Pacman!");
        window.setVisible(true);

        //Preparing things for game loop
        int updates = 0;
        int frames = 0;
        TimedSocket updateTimer = new TimedSocket(Config.UPDATE_DELAY);
        TimedSocket seconds = new TimedSocket(Config.DRAWING_RESET_COUNT_DELAY);
        GameUpdater updater = new GameUpdater();
        window.addKeyListener(updater);
        DrawingInformation[][] frame = null;

        //Game loop starts here
        while (true) {
            if(updateTimer.isDelayElapsed()){
                frame = updater.update();
                updates++;
            }

            if(frame == null)
                continue;

            drawer.sendFrame(frame);
            window.repaint();
            frames++;
            if(seconds.isDelayElapsed()){
                System.out.println("Updates: " + updates + "; Frames: " + frames + "; Player life: " + updater.getPlayerLife());
                updates = 0;
                frames = 0;
            }
        }

    }

}
