package RestaurantRecommendation;

import java.util.*;

public class Persuation {
    List<String> pCupCosGE;
    List<String> pCusCosGE;
    List<String> sCupCosGE;

    List<String> pCupCosL;
    List<String> pCusCosL;
    List<String> sCupCosL;

    public PriorityQueue<Restaurant> newRestaurantsByRating=new PriorityQueue<>(new Comparator<Restaurant>() {
        @Override
        public int compare(Restaurant o1, Restaurant o2) {
            if(o2.getRating()>o1.getRating())
                return 1;
            if(o2.getRating()<o1.getRating())
                return -1;
            return 0;
        }
    });

    public Persuation() {
        this.pCupCosGE = new ArrayList<>();
        this.pCusCosGE = new ArrayList<>();
        this.sCupCosGE = new ArrayList<>();
        this.pCupCosL = new ArrayList<>();
        this.pCusCosL = new ArrayList<>();
        this.sCupCosL = new ArrayList<>();
    }


    public Object[] getRestaurantRecommendations(User user, Restaurant[] availableRestaurants) {

        List<String> answer = new ArrayList<>();
        List<String> residualRestaurants = new ArrayList<>();
        long millisIn48Hours = 1000 * 60 * 60 * 48;

        for (Restaurant availableRestaurant : availableRestaurants) {
            {
                if (user.priorityCuisines[0] == availableRestaurant.getCuisine()) {
                    if (user.priorityCosts[0] == availableRestaurant.getCostBracket()) {
                        if (availableRestaurant.getRating() >= 4) {
                            pCupCosGE.add(availableRestaurant.getRestaurantId());
                        } else if ((newRestaurantsByRating.size()<4)&&(availableRestaurant.getOnboardedTime().getTime() > (new Date()).getTime() - millisIn48Hours)) {
                            newRestaurantsByRating.add(availableRestaurant);
                        } else {
                            pCupCosL.add(availableRestaurant.getRestaurantId());
                        }
                    }
                    else if (user.priorityCosts[1] == availableRestaurant.getCostBracket() ||
                            user.priorityCosts[2] == availableRestaurant.getCostBracket()) {
                        if (availableRestaurant.getRating() >= 4.5) {
                            pCusCosGE.add(availableRestaurant.getRestaurantId());
                        } else if ((newRestaurantsByRating.size()<4)&&(availableRestaurant.getOnboardedTime().getTime() > (new Date()).getTime() - millisIn48Hours)) {
                            newRestaurantsByRating.add(availableRestaurant);
                        } else {
                            pCusCosL.add(availableRestaurant.getRestaurantId());
                        }
                    }
                    else {
                        residualRestaurants.add(availableRestaurant.getRestaurantId());
                    }
                }
                else if (user.priorityCuisines[1] == availableRestaurant.getCuisine() ||
                        user.priorityCuisines[2] == availableRestaurant.getCuisine()) {
                    if (user.priorityCosts[0] == availableRestaurant.getCostBracket()) {
                        if (availableRestaurant.getRating() >= 4.5) {
                            sCupCosGE.add(availableRestaurant.getRestaurantId());
                        } else if ((newRestaurantsByRating.size()<4)&&(availableRestaurant.getOnboardedTime().getTime() > (new Date()).getTime() - millisIn48Hours)) {
                            newRestaurantsByRating.add(availableRestaurant);
                        } else {
                            sCupCosL.add(availableRestaurant.getRestaurantId());
                        }
                    }
                    else {
                        residualRestaurants.add(availableRestaurant.getRestaurantId());
                    }
                }
                else if ((newRestaurantsByRating.size()<4)&&(availableRestaurant.getOnboardedTime().getTime() > (new Date()).getTime() - millisIn48Hours)) {
                    newRestaurantsByRating.add(availableRestaurant);
                } else {
                    residualRestaurants.add(availableRestaurant.getRestaurantId());
                }
            }
        }
        answer.addAll(pCupCosGE);
        answer.addAll(pCusCosGE);
        answer.addAll(sCupCosGE);
        for(int i=0;i<newRestaurantsByRating.size();i++){
                answer.add(newRestaurantsByRating.poll().getRestaurantId());
        }
        answer.addAll(pCupCosL);
        answer.addAll(pCusCosL);
        answer.addAll(sCupCosL);

        /*for(Restaurant r:newRestaurantsByRating){
            answer.add(Objects.requireNonNull(newRestaurantsByRating.poll()).getRestaurantId());
        }*/
        answer.addAll(residualRestaurants);

        if(answer.size()>100){
            return answer.subList(0,100).toArray();
        }
        else{
            return answer.toArray();
        }
    }
}
/*
p p 4
p s 4.5
s p 4.5
top newly added restaurants based on rating
p p 4
p s 4.5
s p 4.5
 */
