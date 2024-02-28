package RestaurantRecommendation;

public class CuisineTracking implements Comparable<CuisineTracking>{
    private Cuisine type;
    private int noOfOrders;

    public CuisineTracking(Cuisine type, int noOfOrders) {
        this.type = type;
        this.noOfOrders = noOfOrders;
    }

    public Cuisine getType() {
        return type;
    }

    public void setType(Cuisine type) {
        this.type = type;
    }

    public int getNoOfOrders() {
        return noOfOrders;
    }

    public void setNoOfOrders(int noOfOrders) {
        this.noOfOrders = noOfOrders;
    }

    @Override
    public int compareTo(CuisineTracking o) {
        if(this.noOfOrders!=o.noOfOrders){
            return o.noOfOrders-this.noOfOrders;
        }
        return o.type.compareTo(this.type);
    }
}
