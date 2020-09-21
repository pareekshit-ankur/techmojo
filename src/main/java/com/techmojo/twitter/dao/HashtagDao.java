package com.techmojo.twitter.dao;

import java.util.Map;

public interface HashtagDao {

    Map<String, Integer> saveHashTag(String hashtag);

    Map<String, Integer> getAllHashtags();
}
