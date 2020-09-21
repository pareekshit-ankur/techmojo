package com.techmojo.twitter.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.techmojo.twitter.dao.HashtagDao;
import com.techmojo.twitter.dao.HashtagDaoImpl;

public class HashtagServiceImpl implements HashtagService {
    HashtagDao hashtagDao = new HashtagDaoImpl();

    public List<String> extractHashTagsFromTweet(String tweet) {
        List<String> hashtags = new ArrayList<>();
        String[] words = tweet.split(" ");
        for (String word : words) {
            if (word.contains("#")) {
                char[] chars = word.toCharArray();
                int index = -1;
                extractHashTags(word, chars, index, hashtags);
            }
        }
        return hashtags;
    }

    private void extractHashTags(String word, char[] chars, int index, List<String> hashtags) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '#' && index == -1) {
                index = i;
            } else if (chars[i] == '#' && index != -1) {
                hashtags.add(word.substring(index, i));
                index = i;
            }
        }
        if (index < word.length()) {
            hashtags.add(word.substring(index));
        }
    }

    public Map<String, Integer> saveHashTag(List<String> hashtags) {
        for (String hashtag : hashtags) {
            hashtagDao.saveHashTag(hashtag);
        }
        return hashtagDao.getAllHashtags();
    }

    public void displayTopTenHashtags() {
        System.out.println("Top Ten Hashtags:");
        Comparator<Entry<String, Integer>> compareByValue = Comparator.comparing(
                Entry<String, Integer>::getValue).reversed().thenComparing(Entry::getKey);
        LinkedHashMap<String, Integer> topTweets = hashtagDao.getAllHashtags().entrySet().stream()
                .sorted(compareByValue).collect(Collectors.toMap(
                        Entry::getKey, Entry::getValue, (e1, e2) -> e1,
                        LinkedHashMap::new));
        int counter = 1;
        for (Entry<String, Integer> entry : topTweets.entrySet()) {
            if (counter > 10) {
                break;
            }
            System.out.println(entry);
            counter++;
        }
    }

}
