package com.danimorenoduque.marvelousandroid.utils;

import com.danimorenoduque.marvelousandroid.BuildConfig;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by dmoreno on 03/07/18.
 */

public class NetworkUtils {
    private static String BASE_URL = "https://gateway.marvel.com:443/";
    private static String API_VERSION = "v1/public/";
    private static String API_PUBLIC_KEY = BuildConfig.API_KEY;

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
