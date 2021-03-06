package com.mini_tiktok.homework.mini_tiktok.utils;

import com.mini_tiktok.homework.mini_tiktok.bean.Chat;
import com.mini_tiktok.homework.mini_tiktok.bean.Content;
import com.mini_tiktok.homework.mini_tiktok.bean.FeedResponse;
import com.mini_tiktok.homework.mini_tiktok.bean.Recommend_Feed_Response;
import com.mini_tiktok.homework.mini_tiktok.bean.Upload_Response;
import com.mini_tiktok.homework.mini_tiktok.bean.User_Draw;
import com.mini_tiktok.homework.mini_tiktok.network.IMiniDouyinService;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Xavier.S
 * @date 2019.01.15 13:27
 */
public class NetworkUtils {
    //实现getResponseWithRetrofitAsync方法用来请求Feed数据
    public static void getResponseWithRetrofitAsync_Feed(Callback<FeedResponse> callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.108.10.39:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofit.create(IMiniDouyinService.class).allFeed().
                enqueue(callback);
    }

    //实现getResponseWithRetrofitAsync方法用来通过USERID请求Recommend_Feed数据
    public static void getResponseWithRetrofitAsync_Recommend_Feed_by_user_id(Callback<Recommend_Feed_Response> callback, String myID) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.1.0.195:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofit.create(IMiniDouyinService.class).Recommend_Feed_by_user_id(myID).
                enqueue(callback);
    }

    //实现getResponseWithRetrofitAsync方法用来通过VIDEO_URL请求Recommend_Feed数据
    public static void getResponseWithRetrofitAsync_Recommend_Feed_by_video_url(Callback<Recommend_Feed_Response> callback, String video_url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.1.0.195:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofit.create(IMiniDouyinService.class).Recommend_Feed_by_video_url(video_url).
                enqueue(callback);
    }
    //实现getResponseWithRetrofitAsync方法用来通过VIDEO_URL请求Recommend_Feed数据
    public static void getResponseWithRetrofitAsync_Content_by_video_url(Callback<Content> callback, String video_url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.1.0.195:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofit.create(IMiniDouyinService.class).videoContent(video_url).
                enqueue(callback);
    }

    //实现getResponseWithRetrofitAsync方法用来通过VIDEO_URL请求Recommend_Feed数据
    public static void getResponseWithRetrofitAsync_Submit_video_sequence(Callback<Upload_Response> callback, String video_url,
                                                                          String user_id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.1.0.195:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofit.create(IMiniDouyinService.class).video_sequence(video_url, user_id).
                enqueue(callback);
    }

    public static void getResponseWithRetrofitAsync_Chat(Callback<Chat> callback, String content) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.1.0.195:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofit.create(IMiniDouyinService.class).get_chat(content).
                enqueue(callback);
    }

    public static void getResponseWithRetrofitAsync_User_Draw(Callback<User_Draw> callback, String user_id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.1.0.195:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofit.create(IMiniDouyinService.class).user_draw(user_id).
                enqueue(callback);
    }

    private static String readStream(final InputStream inputStream) {
        final Scanner scanner = new Scanner(inputStream);
        scanner.useDelimiter("\\A");
        final String data = scanner.next();
        return data;
    }

    private static String readStreamBuffer(InputStream in) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String s;
            while ((s = reader.readLine()) != null) {
                result.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
