/**
 * Represents a Balance with its dollars and cents
 *
 * @author yuanjie yue
 */
public class Amount {
    private Integer dollars;
    private Integer cents;

    /**
     * Create a new balance given its dollars and cents as integers
     *
     * @param dollars the dollars of the balance, which is greater or equal than 0
     * @param cents the cents of the balance, which is between 0 and 99 inclusive
     */
    public Amount(Integer dollars, Integer cents){
        this.dollars = dollars;
        this.cents = cents;
    }

    /**
     * @return the dollars
     */
    public Integer getDollars(){
        return this.dollars;
    }

    /**
     * @return the cents
     */
    public Integer getCents(){
        return this.cents;
    }
}
