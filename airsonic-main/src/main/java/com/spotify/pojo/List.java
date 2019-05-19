
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
    "added_at",
    "added_by",
    "track",
    "is_local"
})
public class List {

    @JsonProperty("added_at")
    private String addedAt;
    @JsonProperty("added_by")
    private AddedBy addedBy;
    @JsonProperty("track")
    private Track track;
    @JsonProperty("is_local")
    private Boolean isLocal;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("added_at")
    public String getAddedAt() {
        return addedAt;
    }

    @JsonProperty("added_at")
    public void setAddedAt(String addedAt) {
        this.addedAt = addedAt;
    }

    @JsonProperty("added_by")
    public AddedBy getAddedBy() {
        return addedBy;
    }

    @JsonProperty("added_by")
    public void setAddedBy(AddedBy addedBy) {
        this.addedBy = addedBy;
    }

    @JsonProperty("track")
    public Track getTrack() {
        return track;
    }

    @JsonProperty("track")
    public void setTrack(Track track) {
        this.track = track;
    }

    @JsonProperty("is_local")
    public Boolean getIsLocal() {
        return isLocal;
    }

    @JsonProperty("is_local")
    public void setIsLocal(Boolean isLocal) {
        this.isLocal = isLocal;
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
