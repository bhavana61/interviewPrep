package FoodDelivery.Models;


public class Restaurant {
    int id;
    String name;
    int location_id;
    int rating;

    public Restaurant(int id, String name, int location_id, int rating) {
        this.id = id;
        this.name = name;
        this.location_id = location_id;
        this.rating = rating;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLocation_id() {
        return location_id;
    }
    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }  
}
