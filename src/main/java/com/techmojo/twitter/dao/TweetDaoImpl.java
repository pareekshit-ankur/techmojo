package com.techmojo.twitter.dao;

import java.util.ArrayList;
import java.util.List;

public class TweetDaoImpl implements TweetDao {
    static List<String> tweets = new ArrayList<>();

    public boolean saveTweet(String tweet) {
        return tweets.add(tweet);
    }

    public List<String> getTweets() {
        return tweets;
    }
}
