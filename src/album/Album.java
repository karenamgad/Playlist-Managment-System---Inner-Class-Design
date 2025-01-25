/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package album;

import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;  // Use the inner SongList class to hold songs

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();  // Initialize the SongList inner class
    }

    // Inner class to hold the list of songs
    public static class SongList {
        private LinkedList<Song> songs;

        private SongList() {
            songs = new LinkedList<>();
        }

        // Add a song to the list, return true if successful, false if the song already exists
        private boolean add(Song song) {
            if (findSong(song.getTitle()) != null) {
                return false;  // Song already exists in the list
            }
            songs.add(song);
            return true;
        }

        // Find a song by its title
        private Song findSong(String title) {
            for (Song song : songs) {
                if (song.getTitle().equals(title)) {
                    return song;
                }
            }
            return null;  // Song not found
        }

        // Find a song by its track number (index in the list)
        private Song findSong(int trackNumber) {
            if (trackNumber >= 1 && trackNumber <= songs.size()) {
                return songs.get(trackNumber - 1);
            }
            return null;  // Track not found
        }
    }

    // Add a song to the album
    public void addSong(String title, double duration) {
        Song song = new Song(title, duration);
        if (songs.add(song)) {
            System.out.println("Added song: " + title);
        } else {
            System.out.println("The song " + title + " is already in this album.");
        }
    }

    // Add a song to the playlist by track number
    public void addToPlayList(int trackNumber, LinkedList<Song> playList) {
        Song song = songs.findSong(trackNumber);
        if (song != null) {
            playList.add(song);
            System.out.println("Added song to playlist: " + song.getTitle());
        } else {
            System.out.println("This album does not have a track " + trackNumber);
        }
    }

    // Add a song to the playlist by title
    public void addToPlayList(String title, LinkedList<Song> playList) {
        Song song = songs.findSong(title);
        if (song != null) {
            playList.add(song);
            System.out.println("Added song to playlist: " + song.getTitle());
        } else {
            System.out.println("The song " + title + " is not in this album.");
        }
    }
}



