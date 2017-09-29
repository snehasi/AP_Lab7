package lab7v1;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

//sneha sinha 2016098
public class lab7v1 {
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		System.out.println("Enter name of the music playlist");
		Scanner in = new Scanner(System.in);
		String playl = in.next();
		
		//System.out.println(n.next());
		//correct music playlist being read
		
		Song s1 = new Song("Sinha","ttt",5);
		Song s2 = new Song("Sneha","tt",4);
		//make arraylist playlist
		
		ArrayList<Song> playlist = new ArrayList<Song>();
		playlist.add(s1);
		playlist.add(s2);
		serialize(playlist);
		
		System.out.println("number of songs "+playlist.size());
		
		//menu
		//add method
		//menu(playlist);	
		//
		ArrayList<Song> playlist1= new ArrayList<Song>();
		playlist1 =deserialize(playl);
		//for(Song s0: playlist1)
//		{
//			System.out.println(s0.getsong());
//		}
		menu(playlist);
		//
		
	}
	
	public static void serialize(ArrayList<Song> playl) throws IOException {
		
		ObjectOutputStream out = null;
		try {
			out= new ObjectOutputStream(new FileOutputStream("//Users//snehasi//eclipse-workspace//lab7v1//playlist.txt//"));
			for(Song s: playl)
			    out.writeObject(s);
		}
		finally {
			out.close();
		}
	}
	
	
	public static ArrayList<Song> deserialize(String playl) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream innn=null;
		ArrayList<Song> playlist = new ArrayList<Song>();
		try {
			
			innn=new ObjectInputStream(new FileInputStream("//Users//snehasi//eclipse-workspace//lab7v1//"+"playlist"+".txt//"));
			Song s1 = (Song)innn.readObject();
			playlist.add(s1);
			while(s1!=null)
			{
				s1 = (Song) innn.readObject();
				playlist.add(s1);
			}
		}
		catch(EOFException a)
		{
			return playlist;
		}
		finally {
			innn.close();
		}
		return playlist;
	}
	
	public static String show(ArrayList<Song> playlist) throws ClassNotFoundException, IOException {
		int c = playlist.size();
		String ooops="";
		if(c==0) {
			ooops="No Song Exist";
		}
		else {
			for(int i=0;i<c;i++) {
				Song s = playlist.get(i);
				ooops+=(s.name+" "+s.artist+" "+s.duration);
			}
		}
		
		//System.out.println(ooops);
		return ooops;
		//menu(playlist);
		
		
	}
	public static String search(String sear,ArrayList<Song> playlist) throws ClassNotFoundException, IOException {
		//search for a song
		//Scanner in = new Scanner(System.in);
		String z="";
		//String sear = in.next();
		int c = playlist.size();
		if(c==0) {
			System.out.println("No Song Exist");
		}
		else {
			//String z;
			for(int i=0;i<c;i++) {
				Song s = playlist.get(i);
				if(s.getsong().equals(sear)) {
					z=s.name+" "+s.artist+" "+s.duration;
					break;
				}
				else {
					z="No Song Exist";
					
				}
			}
			System.out.println(z);
		}
		//menu(playlist);
		return z;
	}
	public static void menu(ArrayList<Song> playlist) throws IOException, ClassNotFoundException {
		Scanner in = new Scanner(System.in);
		System.out.println("enter 1-add/2-delete/3-search/4-show/5-back and show playlists/6-exit");
		int option= in.nextInt();
			//option = in.nextInt();
			if(option==6) {
				System.exit(0);
			}
			
			else if(option==5) {
				File f = new File("."); // current directory
			    File[] files = f.listFiles();
			    for (File file : files) {
			    		String filename =file.getName();
			    		if(filename.contains("txt")) {
			    			System.out.println(filename);
			    		}
			    }
			    String playl2 = in.next();
			    deserialize(playl2);
			    main(null);
			   
			}
			
			else if(option==4) {
				System.out.println(show(playlist));
				menu(playlist);
				
			}
			else if(option==3) {
				String sear = in.next();
				search(sear,playlist);
				menu(playlist);
			}
			else if(option==2) {
				//delete a song from the playlist
				int x=0;
				String sear = in.next();
				int c = playlist.size();
				if(c==0) {
					System.out.println("No Song Exist");
				}
				else {
					for(int i=0;i<c;i++) {
						Song s = playlist.get(i);
						//System.out.println(s.getsong());
						if(s.getsong().equals(sear)) {
							playlist.remove(s);
							x=playlist.size();
							break;
						}
						else {
							x=-3;
							//break;
						}
					}
					if(x<0) {
						System.out.println("No Song Exist");
					}
					else {
						System.out.println(x);
					}
					
				}
				serialize(playlist);
				menu(playlist);
				
				
			}
			else if(option ==1) {
				//add a new song in playlist
				String see = in.next();
				String seeartist = in.next();
				int seedurat = in.nextInt();
				Song f = new Song(see,seeartist,seedurat);
				playlist.add(f);
				System.out.println(playlist.size());	
				serialize(playlist);
				menu(playlist);
				
			}
		}
	
}
//song objects to be stored in playlist arraylist
//class Song implements Serializable{
//	public String name;
//	public String artist;
//	public int duration;
//	public Song(String n,String a,int ii) {
//		this.name=n;
//		this.artist=a;
//		this.duration=ii;
//	}
//	public String getsong() {
//		return this.name;
//	}
//
//	
//}
