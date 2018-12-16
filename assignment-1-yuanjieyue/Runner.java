/**
 * Represents a Runner with his name, start time and duration
 *
 * @author yuanjie yue
 *
 */
public class Runner {

    private String name;
    private Time startTime;
    private Time duration;

    /**
     * Create a new runner given his name as string, his start time and duration as time
     * @param name the runner's name
     * @param startTime the runner's start time
     * @param duration the runner's duration
     */
    public Runner(String name, Time startTime, Time duration){
        this.name = name;
        this.startTime = startTime;
        this.duration = duration;
    }

    /**
     * @return the name
     */
    public String getName(){
        return this.name;
    }

    /**
     * @return the start time
     */
    public Time getStartTime(){
        return this.startTime;
    }

    /**
     * @return the duration
     */
    public Time getDuration(){
        return this.duration;
    }

    public Time getEndTime(){
        Integer newSeconds = this.startTime.getSeconds() + this.duration.getSeconds();
        Integer incrementOnMinutes = newSeconds >= 60? 1 : 0;
        newSeconds = newSeconds >= 60 ? newSeconds - 60 : newSeconds;

        Integer newMinutes = this.startTime.getMinutes() + this.duration.getMinutes() + incrementOnMinutes;
        Integer incrementOnHours = newMinutes >= 60? 1 : 0;
        newMinutes = newMinutes >= 60 ? newMinutes - 60 : newMinutes;

        Integer newHours = this.startTime.getHours() + this.duration.getHours() + incrementOnHours;

        return new Time(newHours, newMinutes, newSeconds);

    }
}
