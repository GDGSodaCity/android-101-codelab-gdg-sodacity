package io.github.sodacity.android101.model;

import java.util.Random;

/**
 * Created by r0adkll on 10/21/15.
 */
public class Placeholder {

    public static final String[] PLACEHOLDER_SITES = new String[]{
            "http://www.placecage.com/%d/%d",
            "https://placekitten.com/%d/%d",
            "http://lorempixel.com/%d/%d"
    };

    public static String generateRandomPlaceholder(){
        Random r = new Random(System.nanoTime());
        String base = PLACEHOLDER_SITES[r.nextInt(PLACEHOLDER_SITES.length)];
        int width = r.nextInt(100) + 300;
        int height = r.nextInt(100) + 300;
        return String.format(base, width, height);
    }

    private final String url;

    public Placeholder(){
        url = generateRandomPlaceholder();
    }

    public String getUrl() {
        return url;
    }

}
