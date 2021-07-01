package com.google;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * A class used to represent a Video Library.
 */
class VideoLibrary {

  private final HashMap<String, Video> videos;
  private HashMap<String, VideoPlaylist> videoPlaylists;

  VideoLibrary() {
    this.videos = new HashMap<>();
    this.videoPlaylists = new HashMap<>();
    try {
      File file = new File(this.getClass().getResource("/videos.txt").getFile());

      Scanner scanner = new Scanner(file);
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] split = line.split("\\|");
        String title = split[0].strip();
        String id = split[1].strip();
        List<String> tags;
        if (split.length > 2) {
          tags = Arrays.stream(split[2].split(",")).map(String::strip).collect(
              Collectors.toList());
        } else {
          tags = new ArrayList<>();
        }
        this.videos.put(id, new Video(title, id, tags));
      }
    } catch (FileNotFoundException e) {
      System.out.println("Couldn't find videos.txt");
      e.printStackTrace();
    }
  }

  List<Video> getVideos() {
    return new ArrayList<>(this.videos.values());
  }

  /**
   * Get a video by id. Returns null if the video is not found.
   */
  Video getVideo(String videoId) {
    return this.videos.get(videoId);
  }

  /**
   * Returns a random video by shuffling the collection and returning the first video in the collection
   * @return Video A random video
   */
  Video getRandomVideo()
  {
    List<Video> allVideos = getVideos();
    Collections.shuffle(allVideos);
    return allVideos.get(0);
  }

  /**
   * Checks if the video is present in the library.
   * @param videoID A video to be checked if it exist in the library.
   * @return True if the video is present in the library, else false.
   */
  boolean hasVideo(String videoID)
  {
    return videos.containsKey(videoID);
  }

  /**
   * Add a playlist to the library.
   * @param playlist A playlist to be added.
   */
  void addPlaylist(VideoPlaylist playlist) {
    videoPlaylists.put(playlist.getName().toLowerCase(), playlist);
  }

  List<VideoPlaylist> getPlaylists() {
    return new ArrayList<>(this.videoPlaylists.values());
  }

  /**
   * Returns the playlist in the library.
   * @param playlistName A playlist in the library to be returned.
   * @return VideoPlaylist A playlist in the library
   */
  VideoPlaylist getPlaylist(String playlistName) {
    return videoPlaylists.get(playlistName.toLowerCase());
  }

  /**
   * Checks if the playlist in the library.
   * @param playlist A playlist to be checked if it exists in the library.
   * @return True if the playlist is in the library, else false.
   */
  boolean hasPlaylist(String playlist) {
    return videoPlaylists.containsKey(playlist.toLowerCase());
  }
}
