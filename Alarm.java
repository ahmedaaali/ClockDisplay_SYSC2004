//Ahmed Ali (101181126)
/**
 * Write a description of class Alarm here.
 *
 * @author Ahmed Ali (101181126)
 * @version 2022.01.29
 */
public class Alarm
{
    private ClockDisplay12 clock;
    private boolean alarmSet;    // used to check if alarm is set or unset
    
    /**
     * Constructor for Alarm objects. This consturctor initiates a new 
     * instance of Clock set at "12:00a.m." and makes sure its unset as
     * default
     */
    public Alarm()
    {
        clock = new ClockDisplay12();
        alarmSet = false;
    }
    
    /**
     * Constructor for Alarm objects. This constructor creates a new instance
     * of Clock set at the time specified by the parameters specified by the
     * user and whether the alarm is set or unset
     */
    public Alarm(int hour, int minute, String amPm, boolean alarmSet)
    {
        clock = new ClockDisplay12(hour, minute, amPm);
        this.alarmSet = alarmSet;
    }
    
    /**
     * This method sets the time of the alarm to the specified hour and
     * minute
     */
    public void setTime(int hour, int minute, String amPm)
    {
        clock.setTime(hour, minute, amPm);
    }
    
    /**
     * This method updates the alarm to be set: on.
     */
    public void turnOn()
    {
        alarmSet = true;
    }
    
    /**
     * This method updates the alarm to be unset: off.
     */
    public void turnOff()
    {
        alarmSet = false;
    }

    /**
     * Returns the current time of this display in the format HH:MM(a.m./p.m.)
     */
    public String getTime()
    {
        return clock.getTime();
    }
    
    /**
     * Returns true or false if the alarm is set or unset accordingly
     */
    public boolean isSet()
    {
        return alarmSet;
    }
}
