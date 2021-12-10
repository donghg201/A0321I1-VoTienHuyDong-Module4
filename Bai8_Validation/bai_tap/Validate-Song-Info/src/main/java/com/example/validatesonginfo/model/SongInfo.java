package com.example.validatesonginfo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class SongInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Ten khong duoc de trong")
    @Size(max = 800, message = "Ten bai hat khong qua 800 ky tu")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Ten khong duoc co ky tu dac biet")
    private String name;

    @NotBlank(message = "Ten ca si khong duoc de trong")
    @Size(max = 300, message = "Ten ca si khong duoc qua 300 ky tu")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Ten ca si khong duoc co ky tu dac biet")
    private String singer;

    @NotBlank(message = "The loai khong duoc de trong")
    @Size(max = 1000, message = "The loai khong duoc qua 1000 ky tu")
    @Pattern(regexp = "^[a-zA-Z0-9,]*$", message = "The loai khong duoc co ky tu dac biet ngoai tru dau ,")
    private String type;

    public SongInfo(int id, String name, String singer, String type) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.type = type;
    }

    public SongInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
