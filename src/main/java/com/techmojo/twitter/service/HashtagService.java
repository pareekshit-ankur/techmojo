package com.techmojo.twitter.service;

import java.util.List;
import java.util.Map;

public interface HashtagService {
    void displayTopTenHashtags();

    List<String> extractHashTagsFromTweet(String tweet) ;

    Map<String, Integer> saveHashTag(List<String> hashtags);
}
