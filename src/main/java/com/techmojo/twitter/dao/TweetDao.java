package com.techmojo.twitter.dao;

import java.util.List;

public interface TweetDao {

    boolean saveTweet(String tweet);

    List<String> getTweets();
}
