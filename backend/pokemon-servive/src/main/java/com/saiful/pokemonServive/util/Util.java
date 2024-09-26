/**
 * Author: Saiful Yaacob
 */
package com.saiful.pokemonServive.util;

import java.net.URI;
import java.net.URISyntaxException;

public class Util {

    public static String getLastPathSegment(String url){
        try {
            URI uri = new URI(url);
            String path = uri.getPath();
            String[] segments = path.split("/");
            String lastSegment = segments[segments.length - 1];
            return lastSegment;
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
