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
    private String key;
    private Long timeStamp;

    public ApiCall() {

    }

    public ApiCall(String key, Long timeStamp) {
        this.key = key;
        this.timeStamp = timeStamp;
    }

    public ApiCall(Long id, String key, Long timeStamp) {
        this.id = id;
        this.key = key;
        this.timeStamp = timeStamp;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
