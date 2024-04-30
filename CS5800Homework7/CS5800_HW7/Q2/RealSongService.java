package Q2;

import java.util.ArrayList;
import java.util.List;

public class RealSongService implements SongService {
    private List<Song> songs;

    public RealSongService() {
        songs = new ArrayList<>();
        songs.add(new Song(1, "Imagine", "John Lennon", "Imagine", 183));
        songs.add(new Song(2, "Bohemian Rhapsody", "Queen", "A Night at the Opera", 355));
        // Add more songs...
    }

    @Override
    public Song searchById(Integer songID) {
        for (Song song : songs) {
            if (song.getId().equals(songID)) {
                return song;
            }
        }
        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        List<Song> results = new ArrayList<>();
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                results.add(song);
            }
        }
        return results;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        List<Song> results = new ArrayList<>();
        for (Song song : songs) {
            if (song.getAlbum().equalsIgnoreCase(album)) {
                results.add(song);
            }
        }
        return results;
    }
}
