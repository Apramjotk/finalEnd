public class weatherDetails extends weather{

    private String location;
    private int  days;
    private boolean alerts;
    private boolean airqualty;

    public weatherDetails(String location, int days, boolean alerts, boolean airqualty){
       super(location, days);
        this.alerts= alerts;
        this.airqualty= airqualty;
    }

    public boolean isAirqualty() {
        return airqualty;
    }

    public boolean isAlerts() {
        return alerts;
    }


}
