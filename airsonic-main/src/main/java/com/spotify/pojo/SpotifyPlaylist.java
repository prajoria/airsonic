
package com.spotify.pojo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Playlist",
    "List"
})
public class SpotifyPlaylist {

    @JsonProperty("Playlist")
    private Playlist playlist;
    @JsonProperty("List")
    private java.util.List<com.spotify.pojo.List> list = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Playlist")
    public Playlist getPlaylist() {
        return playlist;
    }

    @JsonProperty("Playlist")
    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    @JsonProperty("List")
    public java.util.List<com.spotify.pojo.List> getList() {
        return list;
    }

    @JsonProperty("List")
    public void setList(java.util.List<com.spotify.pojo.List> list) {
        this.list = list;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
