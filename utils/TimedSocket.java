package utils;

public class TimedSocket {

    private int millis;
    private long lastTime;

    public TimedSocket(int millis) {
        this.millis = millis;
        lastTime = System.currentTimeMillis();
    }

    public boolean isDelayElapsed() {
        if (lastTime + millis <= System.currentTimeMillis()) {
            lastTime = System.currentTimeMillis();
            return true;
        }
        return false;
    }


}
