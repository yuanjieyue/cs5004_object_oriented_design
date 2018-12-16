/**
 *  Represents a person with his first name and last name
 *
 *  @author yuanjie yue
 */
public class Person {
    private String first;
    private String last;

    /**
     * Create a new person given the person's first name and last name as strings
     *
     * @param first the person's first name
     * @param last the person's last name
     */
    public Person(String first, String last){
        this.first = first;
        this.last = last;
    }

    /**
     * @return the fisrt
     */
    public String getFirst(){
        return this.first;
    }

    /**
     * @return the last
     */
    public String getLast(){
        return this.last;
    }
}