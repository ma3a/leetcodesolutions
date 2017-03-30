package designTwitter;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class TwitterTest {

    @Test
    public void basicTest() {
        Twitter twitter = new Twitter();

        twitter.postTweet(1, 5);
        assertEquals(Collections.singletonList(5), twitter.getNewsFeed(1));

        twitter.follow(1, 2);
        twitter.postTweet(2, 6);

        assertEquals(Arrays.asList(6,5), twitter.getNewsFeed(1));

        twitter.unfollow(1, 2);
        twitter.getNewsFeed(1);
        assertEquals(Collections.singletonList(5), twitter.getNewsFeed(1));
    }

    @Test
    public void postTweet() throws Exception {
        Twitter twitter = new Twitter();

        twitter.postTweet(1, 5);
        twitter.postTweet(1, 3);
        twitter.postTweet(1, 101);
        twitter.postTweet(1, 13);
        twitter.postTweet(1, 10);
        twitter.postTweet(1, 2);
        twitter.postTweet(1, 94);
        twitter.postTweet(1, 505);
        twitter.postTweet(1, 333);
        twitter.postTweet(1, 22);
        twitter.postTweet(1, 11);

        assertEquals(Arrays.asList(11, 22, 333, 505, 94, 2, 10, 13, 101, 3), twitter.getNewsFeed(1));
    }

}