package com.spotify.pojo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class SpotifyPlaylistUtil {
    public static SpotifyPlaylist GetPlaylistFromJsonString(String json){
        SpotifyPlaylist pls = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            pls = mapper.readValue(json, SpotifyPlaylist.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pls;
    }

}
