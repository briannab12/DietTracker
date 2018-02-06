public interface ITempSensor
{
    public final int MINREADING = 23315 ;
    public final int MAXREADING = 38315 ;
    public final int DEFAULT = 29315 ;

    public int currentReading = DEFAULT;         // current sensor reading
    public boolean increasing = true ;

    public int reading();
}