/**
 * Represents a Time with its hours, minutes and seconds
 *
 * @author yuanjie yue
 *
 */
public class Time {

    private Integer hours;
    private Integer minutes;
    private Integer seconds;

    /**
     * Create a new Time given the time's hour, minute and second as Integer
     *
     * @param hours the hour of the time, which is between 0 and 23 inclusive
     * @param minutes the minute of the time, which is between 0 and 59 inclusive
     * @param seconds the second of the time, which is between 0 and 59 inclusive
     */
    public Time(Integer hours, Integer minutes, Integer seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /**
     * @return the hour
     */
    public Integer getHours(){
        return this.hours;
    }

    /**
     * @return the minute
     */
    public Integer getMinutes(){
        return this.minutes;
    }

    /**
     * @return the second
     */
    public Integer getSeconds(){
        return this.seconds;
    }
}
