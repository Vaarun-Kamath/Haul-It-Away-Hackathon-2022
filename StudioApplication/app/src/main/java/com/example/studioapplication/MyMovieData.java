package com.example.studioapplication;

public class MyMovieData {
    private String videoDate;
    private String videoTime;
    private String videoLocation;
    private String videoHeartRate;
    private Integer movieImage;

    public MyMovieData(String videoDate, String videoTime, String videoLocation, String videoHeartRate, Integer movieImage) {
        this.videoDate = videoDate;
        this.videoTime = videoTime;
        this.videoLocation = videoLocation;
        this.videoHeartRate = videoHeartRate;
        this.movieImage = movieImage;
    }

    public String getVideoDate() {
        return videoDate;
    }

    public void setVideoDate(String videoDate) {
        this.videoDate = videoDate;
    }

    public String getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(String videoTime) {
        this.videoTime = videoTime;
    }

    public String getVideoLocation() {
        return videoLocation;
    }

    public void setVideoLocation(String videoLocation) {
        this.videoLocation = videoLocation;
    }

    public String getVideoHeartRate() {
        return videoHeartRate;
    }

    public void setVideoHeartRate(String videoHeartRate) {
        this.videoHeartRate = videoHeartRate;
    }

    public Integer getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(Integer movieImage) {
        this.movieImage = movieImage;
    }
}
