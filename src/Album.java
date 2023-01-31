import java.util.ArrayList;
import java.util.LinkedList;

public class Album
{
    private String artistName;
    private String albumName;
    private ArrayList<Song> songs = new ArrayList<>();

    public Album(String artistName, String albumName)
    {
        this.artistName = artistName;
        this.albumName = albumName;
    }

    public boolean newAlbum(String artist, String albumName)
    {
        Album newAlbum = new Album(artist, albumName);
        System.out.println("Album Created\nArtist: " + artist +"\nAlbum: " + albumName);
        return true;
    }

    public void addSongToAlbum(Song newSong)
    {
        if(!songExists(newSong.getTitle()))
            this.songs.add(newSong);
        else
            System.out.println("Song already on album");
    }

    public boolean songExists(String title)
    {
        for (int i = 0; i < this.songs.size(); i++)
        {
            if (songs.get(i).getTitle().equals(title))
            {
                return true;
            }
        }
        return false;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public Song findSong(String title)
    {
        if (songExists(title))
        {
            for (int i = 0; i < this.songs.size(); i++)
            {
                if (songs.get(i).getTitle().equals(title))
                {
                    return songs.get(i);
                }
            }
        }
        return null;
    }

    public boolean addSongToPlaylist(int trackNum, LinkedList<Song> playlist)
    {
        int index = trackNum - 1;

        if (index >= 0 && index <= this.songs.size())
        {
            playlist.add(this.songs.get(index));
            return true;
        }
//        for (int i = 1; i <= this.songs.size(); i++)
//        {
//            if (i == trackNum)
//            {
//                playlist.add(songs.get(i - 1));
//                return true;
//            }
//        }
        System.out.println("Track # not found");
       return false;
    }
}
