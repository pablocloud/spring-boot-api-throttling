package es.pabloverdugo.springbootapithrottling.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class ApiCall implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String apiKey;
    private Long timeStamp;

    public ApiCall() {

    }

    public ApiCall(String apiKey, Long timeStamp) {
        this.apiKey = apiKey;
        this.timeStamp = timeStamp;
    }

    public ApiCall(Long id, String apiKey, Long timeStamp) {
        this.id = id;
        this.apiKey = apiKey;
        this.timeStamp = timeStamp;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
