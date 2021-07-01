package com.google;

import java.util.Arrays;
import java.util.List;

public class VideoPlayer {

  private final VideoLibrary videoLibrary;
  private boolean isPlaying;
  private Video videoPlaying;
  private boolean isPaused;

  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
    isPlaying = false;
    videoPlaying = null;
    isPaused = false;
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
    System.out.println("Here's a list of all available videos:");
    List<Video> videos = videoLibrary.getVideos();

    String[] videosID = new String[videos.size()];
    for (int i = 0; i < videos.size(); i++) {
      videosID[i] = videos.get(i).getVideoId();
    }
    Arrays.sort(videosID, String.CASE_INSENSITIVE_ORDER);

    for (int i = 0; i < videos.size(); i++) {
      System.out.println(videoLibrary.getVideo(videosID[i]));
    }
  }

  public void playVideo(String videoId) {
    if (!videoLibrary.hasVideo(videoId)) {
      System.out.println("Cannot play video: Video does not exist");
    }
    else if (videoLibrary.hasVideo(videoId) && isPlaying) {
      System.out.println("Stopping video: " + videoPlaying.getTitle());
      videoPlaying = videoLibrary.getVideo(videoId);
      System.out.println("Playing video: " + videoPlaying.getTitle());
      isPaused = false;
    }
    else {
      videoPlaying = videoLibrary.getVideo(videoId);
      isPlaying = true;
      System.out.println("Playing video: " + videoPlaying.getTitle());
      isPaused = false;
    }
  }

  public void stopVideo() {
    if (isPlaying) {
      System.out.println("Stopping video: " + videoPlaying.getTitle());
      isPlaying = false;
      videoPlaying = null;
    }
    else {
      System.out.println("Cannot stop video: No video is currently playing");
    }
  }

  public void playRandomVideo() {
    if (videoLibrary.getVideos().isEmpty()) {
      System.out.println("No videos available");
    }
    else if (isPlaying) {
      System.out.println("Stopping video: " + videoPlaying.getTitle());
      videoPlaying = videoLibrary.getRandomVideo();
      System.out.println("Playing video: " + videoPlaying.getTitle());
    }
    else {
      videoPlaying = videoLibrary.getRandomVideo();
      System.out.println("Playing video: " + videoPlaying.getTitle());
      isPlaying = true;
    }
  }

  public void pauseVideo() {
    if (!isPlaying) {
      System.out.println("Cannot pause video: No video is currently playing");
    }
    else if (isPaused) {
      System.out.println("Video already paused: " + videoPlaying.getTitle());
    }
    else {
      System.out.println("Pausing video: " + videoPlaying.getTitle());
      isPaused = true;
    }
  }

  public void continueVideo() {
    if (!isPlaying) {
      System.out.println("Cannot continue video: No video is currently playing");
    }
    else if (!isPaused) {
      System.out.println("Cannot continue video: Video is not paused");
    }
    else {
      System.out.println("Continuing video: " + videoPlaying.getTitle());
      isPaused= false;
    }
  }

  public void showPlaying() {
    if (!isPlaying) {
      System.out.println("No video is currently playing");
    }
    else if (isPaused) {
      System.out.println("Currently playing:" + videoPlaying.toString() + " - PAUSED");
    }
    else {
      System.out.println("Currently playing:" + videoPlaying.toString());
    }
  }

  public void createPlaylist(String playlistName) {
    if (videoLibrary.hasPlaylist(playlistName)) {
      System.out.println("Cannot create playlist: A playlist with the same name already exists");
    }
    else {
      videoLibrary.addPlaylist(new VideoPlaylist(playlistName));
      System.out.println("Successfully created new playlist: " + playlistName);
    }
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    if (!videoLibrary.hasPlaylist(playlistName)) {
      System.out.println("Cannot add video to " + playlistName + ": Playlist does not exist");
    }
    else if (!videoLibrary.hasVideo(videoId)) {
      System.out.println("Cannot add video to " + playlistName + ": Video does not exist");
    }
    else if (videoLibrary.getPlaylist(playlistName).hasVideoInPlaylist(videoId)) {
      System.out.println("Cannot add video to " + playlistName + ": Video already added");
    }
    else {
      Video videoToAdd = videoLibrary.getVideo(videoId);
      videoLibrary.getPlaylist(playlistName).addVideo(videoToAdd);
      System.out.println("Added video to " + playlistName + ": " + videoToAdd.getTitle());
    }
  }

  public void showAllPlaylists() {
    List<VideoPlaylist> playlists = videoLibrary.getPlaylists();
    if (playlists.isEmpty()) {
      System.out.println("No playlists exist yet");
    }
    else {
      System.out.println("Showing all playlists:");
      for (VideoPlaylist playlist : playlists) {
        System.out.println(" " + playlist.getName());
      }
    }
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}