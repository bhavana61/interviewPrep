package RestaurantRecommendation;

import java.util.*;

public class User {
    //private String userId;
    //private CuisineTracking[] cuisines;
    //private CostTracking[] costBracket;

    Cuisine[] priorityCuisines=new Cuisine[3];
    int[] priorityCosts=new int[3];

    Map<Cuisine,CuisineTracking> cuisineTrackingMap =new HashMap<>();
    Map<Integer,CostTracking> costTrackingHashMap=new HashMap<>();

    public User(){
    }

    public void sortCuisineTrackingMap(){
        Set<Map.Entry<Cuisine,CuisineTracking>> set= cuisineTrackingMap.entrySet();
        List<Map.Entry<Cuisine,CuisineTracking>> l=new ArrayList<>();
        for (Map.Entry<Cuisine,CuisineTracking> m:set){
            l.add(m);
        }
        Collections.sort(l, myCuisineComparator);
        priorityCuisines[0]=l.get(0).getKey();
        priorityCuisines[1]=l.get(1).getKey();
        priorityCuisines[2]=l.get(2).getKey();
    }


    Comparator<Map.Entry<Cuisine,CuisineTracking>> myCuisineComparator = new Comparator<Map.Entry<Cuisine,CuisineTracking>>(){

        @Override
        public int compare(Map.Entry<Cuisine, CuisineTracking> o1, Map.Entry<Cuisine, CuisineTracking> o2) {
            if(o2.getValue().getNoOfOrders()>o1.getValue().getNoOfOrders())
                return 1;
            else
                return -1;
        }
    };

    public void sortCostTrackingMap(){
        Set<Map.Entry<Integer,CostTracking>> set=costTrackingHashMap.entrySet();
        List<Map.Entry<Integer,CostTracking>> l=new ArrayList<>();
        for (Map.Entry<Integer,CostTracking> m:set){
            l.add(m);
        }
        Collections.sort(l, myCostComparator);
        priorityCosts[0]=l.get(0).getKey();
        priorityCosts[1]=l.get(1).getKey();
        priorityCosts[2]=l.get(2).getKey();
    }

    Comparator<Map.Entry<Integer,CostTracking>> myCostComparator = new Comparator<Map.Entry<Integer,CostTracking>>(){

        @Override
        public int compare(Map.Entry<Integer,CostTracking> o1, Map.Entry<Integer,CostTracking> o2) {
            if(o2.getValue().getNoOfOrders()>o1.getValue().getNoOfOrders())
                return 1;
            else
                return -1;
        }
    };


 /*   public PriorityQueue<CuisineTracking> cuisinesPQ=new PriorityQueue<>(new Comparator<CuisineTracking>() {
        @Override
        public int compare(CuisineTracking o1, CuisineTracking o2) {
            if(o2.getNoOfOrders()>o1.getNoOfOrders())
                return 1;
            if(o2.getNoOfOrders()<o1.getNoOfOrders())
                return -1;
            return 0;
        }
    });

    public boolean addCuisineTracking(CuisineTracking cuisineTracking){
        if(cuisineTracking==null){
            return false;
        }
        cuisinesPQ.add(cuisineTracking);
        CuisineTracking p1,p2,p3;
        if(!cuisinesPQ.isEmpty()) {
            p1=cuisinesPQ.poll();
            priorityCuisines[0]=p1.getType();
            if(!cuisinesPQ.isEmpty()){
                p2=cuisinesPQ.poll();
                priorityCuisines[1]=p2.getType();
                if(!cuisinesPQ.isEmpty()) {
                    p3 = cuisinesPQ.poll();
                    priorityCuisines[2] = p3.getType();
                    cuisinesPQ.add(p3);
                }
                cuisinesPQ.add(p2);
            }
            cuisinesPQ.add(p1);
        }
        return true;
    }

    PriorityQueue<CostTracking> costBracketPQ=new PriorityQueue<>(new Comparator<CostTracking>() {
        @Override
        public int compare(CostTracking o1, CostTracking o2) {
            if(o2.getNoOfOrders()>o1.getNoOfOrders())
                return 1;
            if(o2.getNoOfOrders()<o1.getNoOfOrders())
                return -1;
            return 0;
        }
    });

    public boolean addCostTracking(CostTracking costTracking){
        if(costTracking==null){
            return false;
        }
        costBracketPQ.add(costTracking);
        CostTracking p1,p2,p3;
        if(!costBracketPQ.isEmpty()) {
            p1=costBracketPQ.poll();
            priorityCosts[0]=p1.getType();
            if(!costBracketPQ.isEmpty()){
                p2=costBracketPQ.poll();
                priorityCosts[1]=p2.getType();
                if(!costBracketPQ.isEmpty()) {
                    p3 = costBracketPQ.poll();
                    priorityCosts[2] = p3.getType();
                    costBracketPQ.add(p3);
                }
                costBracketPQ.add(p2);
            }
            costBracketPQ.add(p1);
        }
        return true;
    }*/

}
