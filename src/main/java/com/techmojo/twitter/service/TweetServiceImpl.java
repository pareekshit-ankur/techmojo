package com.techmojo.twitter.service;

import java.util.Scanner;

import com.techmojo.twitter.dao.TweetDao;
import com.techmojo.twitter.dao.TweetDaoImpl;

public class TweetServiceImpl implements TweetService {
    HashtagService hashtagService = new HashtagServiceImpl();
    private TweetDao tweetDao = new TweetDaoImpl();

    public String readTweet() {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        System.out.print("Enter your tweet: ");
        return scanner.nextLine();
    }

    public boolean saveTweet(String tweet) {
        return tweetDao.saveTweet(tweet);
    }


}
