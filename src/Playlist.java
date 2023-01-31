import java.util.*;

public class Playlist
{
    private static LinkedList<Song> playlist = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args)
    {
        //Create some albums
        Album soundSystem = new Album("311", "Soundsystem");
        Album californication = new Album("Red Hot Chilli Peppers", "Californication");
        Album hotFuss = new Album("The Killers", "Hot Fuss");
        //Add the songs to the albums
        Song freezeTime = new Song("Freeze Time", "3:22");
        Song comeOriginal = new Song("Come Original", "3:43");
        Song flowing = new Song("Flowing", "3:13");
        Song largeInTheMargin = new Song("Large in the Margin" , "3:29");
        Song cantFadeMe = new Song("Can't Fade Me", "2:10");
        soundSystem.addSongToAlbum(freezeTime);
        soundSystem.addSongToAlbum(comeOriginal);
        soundSystem.addSongToAlbum(largeInTheMargin);
        soundSystem.addSongToAlbum(flowing);
        soundSystem.addSongToAlbum(cantFadeMe);

        //create songs for californication
        Song aroundTheWorld = new Song("Around the World", "3:59");
        Song parallelUniverse = new Song("Parallel Universe", "4:29");
        Song scarTissue = new Song("Scar Tissue", "3:37");
        Song otherSide = new Song("Otherside", "4:16");
        Song getOnTop = new Song("Get On Top", "3:18");

        //add songs to californication
        californication.addSongToAlbum(aroundTheWorld);
        californication.addSongToAlbum(parallelUniverse);
        californication.addSongToAlbum(scarTissue);
        californication.addSongToAlbum(otherSide);
        californication.addSongToAlbum(getOnTop);

        //create songs for hot fuss
        Song jennyWasAFriend = new Song("Jenny Was a Friend of Mine", "4:04");
        Song mrBrightSide = new Song("Mr. Brightside" , "3:43");
        Song smileLikeYou = new Song("Smile Like You Mean It", "3:55");
        Song somebodyToldMe = new Song("Somebody Told Me", "3:18");
        Song allTheseThings = new Song("All These Things That I've Done", "5:02");

        //add songs to hotFuss album
        hotFuss.addSongToAlbum(jennyWasAFriend);
        hotFuss.addSongToAlbum(mrBrightSide);
        hotFuss.addSongToAlbum(smileLikeYou);
        hotFuss.addSongToAlbum(somebodyToldMe);
        hotFuss.addSongToAlbum(allTheseThings);

        //add albums to albums arraylist
        albums.add(soundSystem);
        albums.add(hotFuss);
        albums.add(californication);

        //manually add songs


        //or use addSongs to Playlist method
        addSongsToPlaylist();
        play(playlist);





    }

    public static void printOptions()
    {
        System.out.println("press: ");
        System.out.println("0 - view options\n1 - Next Song\n2 - Previous Song\n3 - Replay Current Song" +
                "\n4 - Remove Current Song from Playlist\n5 - View List of Songs\n6 - Quit");
    }

    public static void addSongsToPlaylist()
    {
        int choice = -1, track;
        boolean retry;
        boolean addSongs = true;
        String album;

        do
        {
            do
            {
                retry = false;
                try
                {
                    System.out.println("Do you want to add another song to the playlist? ");
                    System.out.println("1. yes | 2. no: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();
                }
                catch(InputMismatchException ex)
                {
                    System.out.println("Wrong input");
                    retry = true;
                    scanner.nextLine();
                }
            }while(retry);


            switch (choice)
            {
                case 1:
                    System.out.println("Enter Album: ");
                    album = scanner.nextLine().trim();
                    System.out.println("Enter Track #: ");
                    track = (scanner.nextInt());
                    scanner.nextLine();
                    addSong2Playlist(album, track);
                    break;
                case 2:
                    addSongs = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
        while(addSongs);
    }

    public static void play(LinkedList playlist)
    {
        int choice = -1;
        boolean goingForward = true,  quit = false;
        ListIterator<Song> listIterator = playlist.listIterator();

        if (playlist.isEmpty())
        {
            System.out.println("Playlist is empty");
        }
        else
        {
            Song firstSong = listIterator.next();
            System.out.println("Now Playing " + firstSong.getTitle() + "\nDuration " + firstSong.getDuration());
            printOptions();
        }

        do
        {
            System.out.println("Select Action: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice)
            {
                case 0:
                    printOptions();
                case 1:
                    if (!goingForward)
                    {
                        listIterator.next();
                        goingForward = true;
                    }
                    if (listIterator.hasNext())
                    {
                        Song song = listIterator.next(); //for the folowing outputs could alternatively override toSTring method for Song and output this info
                        System.out.println("Now Playing Song:" + song.getTitle() + "\nDuration: " + song.getDuration());
                    }
                    else
                    {
                        System.out.println("Reached end of playlist");
                        goingForward = false;
                    }


                    break;
                case 2:
                    if(goingForward)
                    {
                        listIterator.previous();
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious())
                    {
                        Song nextSong = listIterator.previous();
                        System.out.println("Now Playing Song:" + nextSong.getTitle() + "\nDuration: " + nextSong.getDuration());
                    }
                    else
                    {
                        System.out.println("Reached start of playlist");
                        goingForward = true;
                    }
                    break;

                case 3:
                    Song replaySong;
                    if(goingForward)
                    {
                        replaySong = listIterator.previous();
                        goingForward = false;

                    }
                    else
                    {
                        replaySong = listIterator.next();
                        goingForward = true;
                    }
                    System.out.println("Now Playing Song:" + replaySong.getTitle() + "\nDuration: " + replaySong.getDuration());
                    break;
                case 4:
                    Song nextSong;
                    if (playlist.size() > 0)
                    {
                        listIterator.remove();
                        System.out.println("Song removed from playlist");

                        if (listIterator.hasNext())
                        {
                             nextSong = listIterator.next();
                            System.out.println("Now Playing Song:" + nextSong.getTitle() + "\nDuration: " + nextSong.getDuration());
                            goingForward = true;
                        }
                        else if (listIterator.hasPrevious())
                        {
                            nextSong = listIterator.previous();
                            System.out.println("Now Playing Song:" + nextSong.getTitle() + "\nDuration: " + nextSong.getDuration());
                        }
                    }
                    else
                    {
                        System.out.println("Playlist is empty");
                    }
                    break;
                case 5:
                    printPlaylist();
                    break;
                case 6:
                    System.out.println("Goodbye");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
        while(!quit);
    }

    public static void printPlaylist()
    {
        Iterator<Song> songIterator = playlist.iterator();
        System.out.println("Playlist Songs: ");
        while(songIterator.hasNext())
        {
            System.out.println(songIterator.next().getTitle());
        }
    }

    public static void addSong2Playlist(String album, int trackNum)
    {
        if (albumExists(album))
        {
            if (getAlbum(album).addSongToPlaylist(trackNum, playlist))
                System.out.println("track added to playlist") ;
            else
                System.out.println("Error adding track");
        }
        else
        {
            System.out.println("Album not found");
        }
    }

    public static boolean albumExists(String name)
    {
        for (int i = 0; i < albums.size(); i++)
        {
            if (albums.get(i).getAlbumName().equals(name))
            {
                return true;
            }
        }
        System.out.println("Album does not exist");
        return false;
    }

    public static Album getAlbum(String name)
    {
        for (int i = 0; i < albums.size(); i++)
        {
            if (albums.get(i).getAlbumName().equals(name))
            {
                return albums.get(i);
            }
        }
        return null;
    }
}
