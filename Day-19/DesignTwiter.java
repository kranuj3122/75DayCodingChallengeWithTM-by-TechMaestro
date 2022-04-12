import java.util.*;

public class DesignTwiter {
    Map<Integer, Set<Integer>> followers;
    Map<Integer, Integer> tweets;
    List<Integer> feed;
    public Twitter() {
        followers = new HashMap<>();
        tweets = new HashMap<>();
        feed = new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.put(tweetId, userId);
        feed.add(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        for(int i = feed.size()-1; i >= 0 && ans.size() < 10; i--) {
            int twt = feed.get(i);
            if(tweets.get(twt) == userId) {
                ans.add(twt);
            }
            else if(followers.containsKey(userId) && followers.get(userId).contains(tweets.get(twt))) {
                ans.add(twt);
            }
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followers.containsKey(followerId)) {
            followers.put(followerId, new HashSet<>());
        }
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
    }
}
