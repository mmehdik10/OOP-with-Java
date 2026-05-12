import java.time.*;

public class Cursor
{
    LocalTime previous;
    LocalTime now;
    boolean active = true;
    double pastSecounds = 0.0;
    double tickRate= 3.5;


    public Cursor()
    {
        previous = LocalTime.now();
        beginTick();
    }


    private void beginTick()
    {
        while(active)
        {
            now = LocalTime.now();
            Duration dur = Duration.between(previous, now);
            tick(dur.toMillis());
            previous = now;
        }
    }


    private void tick(long deltaMillis)
    {
        pastSecounds += (deltaMillis / 1000.0);
        if (pastSecounds >= tickRate)
        {
            System.out.println("Die Uhr Tickt");
        }
        pastSecounds -= tickRate;
    }
}
