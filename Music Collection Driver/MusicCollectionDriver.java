import java.util.Scanner;

public class MusicCollectionDriver {

    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        Song song1 = new Song("Smells Like Teen Spirit", "Nirvana", "Grunge");
        Album album1 = new Album("Nevermind", song1);
        Song song2 = new Song("Bohemian Rhapsody", "Queen", "Rock");
        Album album2 = new Album("A Night at the Opera", song2);
        Song song3 = new Song("You Shook Me All Night Long", "ACDC", "Rock");
        Album album3 = new Album("Back in Black", song3);
        Album[] albumArray = {album1, album2, album3};

        int input = 0;

        while (input != -1) {
            System.out.println("\nMusic Collection:");
            for (int i = 0; i < 3; i++) {
                System.out.println("[" + i + "]: " + albumArray[i].getTitle());
            }

            System.out.println("Select an album (or -1 to quit): ");
            input = Integer.parseInt(keyboard.nextLine());
            if (input != -1) {
                albumOptions(albumArray[input]);
            }
        }
    }


    public static void albumOptions(Album albumName) {
        System.out.println("\n" + albumName.toString());
        System.out.print("[0]: Get favorite track\n[1]: Change genre\n[2]:"
+ " Add song\nYour choice (or -1 to quit): ");
        int input1 = Integer.parseInt(keyboard.nextLine());
        while (input1 != -1) {
            if (input1 == 0) {
                System.out.println("\nFavorite Song on "
                    + albumName.getTitle() + ":\n"
                    + albumName.getFavoriteTrack().toString());
            }
            if (input1 == 1) {
                System.out.println("\nNew genre:");
                String newGenre = keyboard.nextLine();
                albumName.setGenre(newGenre);
            }
            if (input1 == 2) {
                System.out.println("\nSong name?");
                String songName = keyboard.nextLine();
                System.out.println("\nIs this your favorite song"
                    + "on the album? (true/false)");
                boolean isFavorite = false;
                String favSongInput = keyboard.nextLine();
                Boolean favSongTest = Boolean.valueOf(favSongInput);
                if (favSongTest) {
                    isFavorite = true;
                }
                Song songObject = new Song(songName,
                    albumName.getFavoriteTrack().getArtist(),
                    albumName.getFavoriteTrack().getGenre());
                albumName.addSong(songObject, isFavorite);
            }
            System.out.print("\n" + albumName.toString());
            System.out.print("[0]: Get favorite track\n[1]: Change genre\n[2]:"
+ " Add song\nYour choice (or -1 to quit): ");
            input1 = Integer.parseInt(keyboard.nextLine());
        }
    }
}