package com.techmojo.twitter;

import java.util.List;
import java.util.Scanner;

import com.techmojo.twitter.service.HashtagService;
import com.techmojo.twitter.service.HashtagServiceImpl;
import com.techmojo.twitter.service.TweetService;
import com.techmojo.twitter.service.TweetServiceImpl;
import com.techmojo.twitter.util.AppUtil;

public class TwitterApplication {
    static TweetService tweetService = new TweetServiceImpl();
    static HashtagService hashtagService = new HashtagServiceImpl();

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");
        int option = 0;
        AppUtil.displayUserOperations();
        while (option != 2) {
            option = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            if (option == 1) {
                String tweet = tweetService.readTweet();
                tweetService.saveTweet(tweet);
                List<String> hashtags = hashtagService.extractHashTagsFromTweet(tweet);
                hashtagService.saveHashTag(hashtags);
            } else if (option == 2) {
                hashtagService.displayTopTenHashtags();
                System.exit(0);
            }
            AppUtil.displayUserOperations();
        }
    }
}
