package com.google;

import java.util.Collections;
import java.util.List;

/** A class used to represent a video. */
class Video {

  private final String title;
  private final String videoId;
  private final List<String> tags;

  Video(String title, String videoId, List<String> tags) {
    this.title = title;
    this.videoId = videoId;
    this.tags = Collections.unmodifiableList(tags);
  }

  /**
   * Returns the title of the video.
   */
  String getTitle() {
    return title;
  }

  /**
   * Returns the video id of the video.
   */
  String getVideoId() {
    return videoId;
  }

  /**
   * Returns a readonly collection of the tags of the video.
   */
  List<String> getTags() {
    return tags;
  }

  /**
   * Returns an information of the video
   * @return String An information of the video
   */
  public String toString()
  {
    String text = " " + title + " (" + videoId + ") " + "[";
    if (!tags.isEmpty()) {
      for (int i = 0; i < tags.size() - 1; i++) {
        text = text + tags.get(i) + " ";
      }
      text = text + tags.get(tags.size()-1);
    }
    return text + "]";
  }
}
