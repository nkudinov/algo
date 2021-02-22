package l100;

import java.util.*;

public class Twitter {
    class Twitt {
        int id;
        int time;
        Twitt(int id){
            this.id = id;
            this.time =  ++clock;
        }
    }

    int clock;
    Map<Integer,List<Twitt>> posts;
    Map<Integer,List<Integer>> followers;

    public Twitter() {
        posts = new HashMap<>();
        followers = new HashMap<>();
        clock = 0;
    }


    public void postTweet(int userId, int tweetId) {
        posts.putIfAbsent(userId, new ArrayList<>());
        posts.get(userId).add(new Twitt(tweetId));
    }


    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Twitt> pq = new PriorityQueue<>( (a, b) -> b.time -a.time);
        for(Integer id:followers.getOrDefault(userId, new ArrayList<>())){
            for(Twitt t:posts.getOrDefault(id, new ArrayList<>())){
                pq.add(t);
            }
        }
        for(Twitt t:posts.getOrDefault(userId, new ArrayList<>())){
            pq.add(t);
        }
        int k = 0;
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll().id);
            k++;
            if ( k == 10){
                break;
            }
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId != followeeId ){
            followers.putIfAbsent( followerId, new ArrayList<>());
            if (!followers.get(followerId).contains(followeeId)){
                followers.get(followerId).add(followeeId);
            }
        }
    }

    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)){
            followers.get(followerId).remove((Integer)followeeId);
        }
    }
    public static void main(String[] args) {
        Twitter t = new Twitter();
        int[][] posts = new int[][]{ {1,6765},{5,671},{3,2868},{4,8148},{4,386},{3,6673},{3,7946},{3,1445},{4,4822},{1,3781},{4,9038},{1,9643},{3,5917} };
        for(int[] post: posts){
            t.postTweet(post[0],post[1]);
        }
        int[][] relations = new int[][]{{1,3},{1,4},{4,2},{4,1},{3,2},{3,5},{3,1},{2,3},{2,1},{2,5},{5,1},{5,2}};
        for(int[] rel:relations){
            t.follow(rel[0],rel[1]);
        }
        for(Integer tweet: t.getNewsFeed(1)){
            System.out.println(tweet);
        }
    }

}
