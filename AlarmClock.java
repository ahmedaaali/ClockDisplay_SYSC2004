//Ahmed Ali (101181126)
/**
 * Write a description of class AlarmClock here.
 *
 * @author Ahmed Ali (101181126)
 * @version 2022.01.29
 */
public class AlarmClock
{
    private ClockDisplay12 clock;
    private Alarm alarm;
    
    /**
     * Constructor for AlarmClock objects. This consturctor initiates a new
     * instance of Clock set to default and a new instance Alarm set to
     * default
     */
    public AlarmClock()
    {
        clock = new ClockDisplay12();
        alarm = new Alarm();
    }
    
    /**
     * Constructor for AlarmClock objects. This constructor creates a new
     * instance of Clock set at the time specified by the parameters specified
     * by the user as well as a new alarm
     */
    public AlarmClock(int cHr, int cMin, String cAmPm,int aHr, int aMin,
                      String aAmPm, boolean alarmSet)
    {
        clock = new ClockDisplay12(cHr, cMin, cAmPm);
        alarm = new Alarm(aHr, aMin, aAmPm, alarmSet);
    }
    
    /**
     * This method sets the time of the clock to the specified hour, minute,
     * and AM/PM
     */
    public void setTime(int hour, int minute, String amPm)
    {
        clock.setTime(hour, minute, amPm);
    }
    
    /**
     * This method sets the time of the alarm to the specified hour, minute,
     * and AM/PM
     */
    public void setAlarmTime(int hour, int minute, String amPm)
    {
        alarm.setTime(hour, minute, amPm);
    }
    
    /**This method should get called once every minute - it makes the clock
     * display go one minute forward. Rings when both the clock and alarm are
     * the same and the alarm is set: on
     */
    public void clockTick()
    {
        clock.timeTick();
        if (clock.getTime().equals(alarm.getTime()) && alarm.isSet()){
            System.out.println("RING RING RING");
            alarm.turnOff();    // can use unsetAlarm();
        }
    }
    
    /**
     * This method updates the alarm to be set: on.
     */
    public void setAlarm()
    {
        alarm.turnOn();
    }
    
    /**
     * This method updates the alarm to be unset: off.
     */
    public void unsetAlarm()
    {
        alarm.turnOff();
    }
    
    /**
     * Returns the current time of the clock display in the format
     * HH:MM(a.m./p.m.)
     */
    public String getTime()
    {
        return clock.getTime();
    }
    
    /**
     * Returns the current time of the alarm display in the format
     * HH:MM(a.m./p.m.)
     */
    public String getAlarmTime()
    {
        return alarm.getTime();
    }
    
    /**
     * Returns true or false if the alarm is set or unset accordingly
     */
    public boolean isAlarmSet()
    {
        return alarm.isSet();
    }
}
