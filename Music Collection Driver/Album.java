public class Album {

    private String title;
    private String artist;
    private String genre;
    private Song[] songs;
    private Song favoriteTrack;

    public Album(String title, Song firstTrack) {
        artist = firstTrack.getArtist();
        genre = firstTrack.getGenre();
        this.songs = new Song[1];
        this.title = title;
        songs[0] = firstTrack;
        favoriteTrack = firstTrack;
    }

    public String getTitle() {
        return title;
    }

    public Song getFavoriteTrack() {
        return favoriteTrack;
    }

    public void setGenre(String genre) {
        this.genre = genre;
        for (Song song: songs) {
            song.setGenre(genre);
        }
    }

    public void addSong(Song s, boolean isFavorite) {
        boolean isFull = false;
        if (songs[songs.length - 1] != null) {
            isFull = true;
        }
        if (isFull) {
            int i = 0;
            Song[] arr = new Song[2 * songs.length];
            for (Song song: songs) {
                arr[i] = song;
                i++;
            }
            songs = arr;
            isFull = false;
        }
            int i = 0;
            boolean inserted = false;
            while (!inserted) {
                if (songs[i] == null) {
                    songs[i] = s;
                    inserted = true;
                }
                i++;
            }
        if (isFavorite) {
           favoriteTrack = s;
        }
        return;
    }

    public String toString() {
        String toString = title + ", Tracks:\n";
        int i = 0;
        while ((i < songs.length) && (songs[i] != null)) {
            toString = toString + songs[i].toString() + "\n";
            i++;
        }
        return toString;
    }

}