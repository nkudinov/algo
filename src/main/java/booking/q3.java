package booking;

import java.util.*;

import java.io .*;
import java.math .*;
import java.security .*;
import java.text .*;
import java.util .*;
import java.util.concurrent .*;
import java.util.function .*;
import java.util.regex .*;
import java.util.stream .*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public    class q3 {

        public static int compare(int h1, int h2, Map<Integer, Integer> score) {
            int score1 = score.get(h1);
            int score2 = score.get(h2);
            if (score1 == score2) {
                return h1 - h2;
            }
            return score2 - score1;
        }

        public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords, List<Integer> hotelIds, List<String> reviews, int k) {
            // Write your code here

            Set<String> positiveSet = new HashSet<>();
            for (String word : positiveKeywords.replaceAll("[^a-zA-Z]", " ").toLowerCase().split("\\s+")) {
                if (word != null && word.length() != 0) {
                    positiveSet.add(word);
                }
            }

            Set<String> negativeSet = new HashSet<>();
            for (String word : negativeKeywords.replaceAll("[^a-zA-Z]", " ").toLowerCase().split("\\s+")) {
                if (word != null && word.length() != 0) {
                    negativeSet.add(word);
                }
            }
           // System.out.println(positiveSet);
            //System.out.println(negativeSet);
            Map<Integer, Integer> hotelsScore = new HashMap<>();
            for (int i = 0; i < reviews.size(); i++) {
                int hotelID = hotelIds.get(i);
                int score = 0;
                for (String word : reviews.get(i).replaceAll("[^a-zA-Z]", " ").toLowerCase().split("\\s+")) {
                    if (word != null && word.length() != 0) {
                        System.out.println("+"+word);
                        if (positiveSet.contains(word)) {
                            score = score + 3;
                        }

                        if (negativeSet.contains(word)) {
                            score = score - 1;
                        }
                    }
                }
                hotelsScore.merge(hotelID, score, (a, b) -> a + b);
            }
            Set<Integer> hotelsID = new HashSet<>(hotelIds);

            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> compare(a, b, hotelsScore));

            for (Integer id : hotelsID) {
                pq.add(id);
            }
            List<Integer> ans = new ArrayList<>();

            while (k >= 0 && !pq.isEmpty()) {
                ans.add(pq.poll());
                k--;
            }
            return ans;

        }


    public static void main(String[] args) {
       String positiveKeywords ="breakfast beach citycenter location metro view staff price";
       String negativeKeywords = "not";
       List<Integer> hotelIds = new ArrayList<>();
       hotelIds.add(1);
       hotelIds.add(2);
       hotelIds.add(1);
       hotelIds.add(1);
       hotelIds.add(2);

       List<String> reviews = new ArrayList<>();
       reviews.add("This hotel has a nice view of the citycenter. The location is perfect.\n");
       reviews.add("The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.");
       reviews.add("Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.");
       reviews.add("They said I couldn't take my dog and there were other guests with dogs! That is not fair.");
       reviews.add("Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.");

       for(int id: awardTopKHotels(positiveKeywords, negativeKeywords,hotelIds, reviews,2)){
           System.out.println(id);
       }
    }
}
