public interface IBarometer   {

    public final double MIN = 27.0 ;       // minimum reading
    public final double MAX = 32.0 ;       // maximum reading
    public final double DEFAULT = 29.92 ;  // default reading.

    public double currentPressure = DEFAULT;     // current sensor reading
    public boolean increasing = true ;  // TRUE if pressure increasing
    
    public double pressure();
    
    

}