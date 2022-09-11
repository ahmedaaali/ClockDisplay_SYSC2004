//Ahmed Ali (101181126)
/**
 * The ClockDisplay class implements a digital clock display 12 hour clock
 * with AM/PM to represent all 24 hours in a day
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Michael Kölling and David J. Barnes and Ahmed Ali (101181126)
 * @version 2022.01.29
 */
public class ClockDisplay12
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    static final String AM = "a.m.";    // constants used instead of rewriting
    static final String PM = "p.m.";
    private String amPm = AM;   // initialized as AM but can contain both
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at "12:00a.m."
     */
    public ClockDisplay12()
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters
     */
    public ClockDisplay12(int hour, int minute, String time)
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        setTime(hour, minute, time);    // sets time with AM/PM from time
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
            if (amPm.equals(AM)){   // changes between am and pm after roll
                amPm = PM;
            } else{
                amPm = AM;
            }
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute, String time)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        if (time.equals(PM)) {  // if time has the correct value
            amPm = PM;          // updating the am/pm value
        }
        if (time.equals(AM)) {
            amPm = AM;
        }
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM(a.m./p.m.)
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        if (hours.getValue() == 0) {    // when hours is 0, it means 12
            displayString = "12:" + minutes.getDisplayValue() + amPm;
        } else {
            displayString = hours.getDisplayValue() + ":" + 
                            minutes.getDisplayValue() + amPm;
        }
    }
}
