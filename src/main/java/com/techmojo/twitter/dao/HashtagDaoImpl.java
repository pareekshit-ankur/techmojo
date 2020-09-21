package com.techmojo.twitter.dao;

import java.util.HashMap;
import java.util.Map;

public class HashtagDaoImpl implements HashtagDao {

    static Map<String, Integer> hashtags = new HashMap<>();

    public Map<String, Integer> saveHashTag(String hashtag) {
        hashtags.computeIfPresent(hashtag, (key, value) -> value + 1);
        hashtags.putIfAbsent(hashtag, 1);
        return hashtags;
    }

    public Map<String, Integer> getAllHashtags() {
        return hashtags;
    }
}
