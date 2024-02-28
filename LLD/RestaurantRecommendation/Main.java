package RestaurantRecommendation;

import java.util.Date;
import java.util.Random;

public class Main {
    public static void  main(String[] args){

        final long MILLIS_IN_A_DAY = 1000 * 60 * 60 * 24;

        Persuation p=new Persuation();
        User u=new User();

        for (int i=1;i<=15;i++){
           CostTracking costTracking=new CostTracking(i/3,i*3);
           u.costTrackingHashMap.put(costTracking.getType(),costTracking);
        }

        for (int i=1;i<=15;i++){
            Cuisine c;
            if(i%3 == 0)
                c=Cuisine.SouthIndian;
            else if(i%3 == 1)
                c=Cuisine.NorthIndian;
            else
                c=Cuisine.Chinese;
            CuisineTracking cuisineTracking=new CuisineTracking(c,i*3);
            u.cuisineTrackingMap.put(cuisineTracking.getType(),cuisineTracking);
        }

        u.sortCuisineTrackingMap();
        u.sortCostTrackingMap();

        Restaurant[] restaurants=new Restaurant[1000];
        for(int i=0; i<1000; i++)
        {
            Restaurant rest = new Restaurant();
            rest.setRestaurantId(String.valueOf(i));
            if(i%3 == 0)
                rest.setCuisine(Cuisine.SouthIndian);
            else if(i%3 == 1)
                rest.setCuisine(Cuisine.NorthIndian);
            else
                rest.setCuisine(Cuisine.Chinese);
            Random rand = new Random();
            rest.setCostBracket(rand.nextInt(5));
            rest.setRating(i/5);

            Date d = new Date();
            long dMilliSeconds = d.getTime();
            Date old_d = new Date(dMilliSeconds - MILLIS_IN_A_DAY*i);
            if(i%5 == 0)
                rest.setOnboardedTime(d);
            else
                rest.setOnboardedTime(old_d);

            rest.setRecommended(rest.getOnboardedTime() == d);
            restaurants[i]=rest;
        }

        Object[] answer=p.getRestaurantRecommendations(u,restaurants);
        System.out.println(answer.length);
        for(Object s:answer){
            System.out.println(s.toString());
        }
    }
}
