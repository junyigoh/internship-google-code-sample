package com.google;

import java.util.HashMap;

/** A class used to represent a Playlist */
class VideoPlaylist {
    private String name;
    private HashMap<String, Video> videos;

    VideoPlaylist(String name)
    {
        this.videos = new HashMap<>();
        this.name = name;
    }

    /**
     * Returns the name of the playlist
     * @return String the name of the playlist
     */
    String getName() {
        return name;
    }

    /**
     * Add a video to the playlist
     * @param video A video to be added into the playlist
     */
    void addVideo(Video video) {
        videos.put(video.getVideoId(), video);
    }

    /**
     * Checks if the video is in the playlist.
     * @param videoId A video to be checked if it exist in the playlist
     * @return True if the video is present in the playlist, else false.
     */
    boolean hasVideoInPlaylist(String videoId) {
        return videos.containsKey(videoId);
    }
}
