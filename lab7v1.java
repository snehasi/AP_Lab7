package lab7v1;

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
	public static void main(String[] args) throws IOException{
		System.out.println("Enter name of the music playlist");
		Scanner in = new Scanner(System.in);
		String playl = in.next();
		File f = new File("//Users//snehasi//eclipse-workspace//lab7v1//"+playl+".txt//");
		Scanner n = new Scanner(f);	
		//System.out.println(n.next());
		//correct music playlist being read
		
		//make arraylist playlist
		String name_playlist = n.next();
		ArrayList<Song> playlist = new ArrayList<Song>();
		int num_songs = n.nextInt();
		System.out.println("number of songs "+num_songs);
		for(int i=0;i<num_songs;i++) {
			int ind = n.nextInt();
			String na = n.next();
			String ar = n.next();
			Song s = new Song(na,ar,ind);
			playlist.add(s);
			
		}
		//menu
		//add method
		menu(playlist);	
	}
	
	
	public static void serialize(String playl) throws IOException {
		Song s1 = new Song("Amy","Britney",9);
		ObjectOutputStream out = null;
		try {
			out= new ObjectOutputStream(new FileOutputStream(playl+".txt"));
			out.writeObject(s1);
		}
		finally {
			out.close();
		}
	}
	
	
	public static void deserialize(String playl) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in=null;
		try {
			in=new ObjectInputStream(new FileInputStream("out.txt"));
			Song s1 = (Song) in.readObject();
		}
		finally {
			in.close();
		}
	}
	
	
	public static void menu(ArrayList<Song> playlist) throws IOException {
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
			    File f2 = new File("//Users//snehasi//eclipse-workspace//lab7v1//"+playl2+".txt//");
				Scanner n2 = new Scanner(f2);	
				//System.out.println(n.next());
				//correct music playlist being read
				
				//make arraylist playlist
				String name_playlist = n2.next();
				ArrayList<Song> playlist2 = new ArrayList<Song>();
				int num_songs2 = n2.nextInt();
				System.out.println("number of songs "+num_songs2);
				for(int i=0;i<num_songs2;i++) {
					int ind2 = n2.nextInt();
					String na2 = n2.next();
					String ar2 = n2.next();
					Song s2 = new Song(na2,ar2,ind2);
					playlist.add(s2);
					
				}
			    menu(playlist2);
			}
			
			else if(option==4) {
				int c = playlist.size();
				if(c==0) {
					System.out.println("No Song Exist");
				}
				else {
					for(int i=0;i<c;i++) {
						Song s = playlist.get(i);
						System.out.println(s.name+" "+s.artist+" "+s.duration);
					}
				}
				menu(playlist);
			}
			else if(option==3) {
				//search for a song
				String z="";
				String sear = in.next();
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
				menu(playlist);
				
			}
			else if(option==2) {
				//delete a song from the playlist
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
							System.out.println(playlist.size());
							break;
						}
						else {
							System.out.println("No Song Exist");
							break;
						}
					}
				}
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
				menu(playlist);
			}
		}
	
}
//song objects to be stored in playlist arraylist
class Song implements Serializable{
	public String name;
	public String artist;
	public int duration;
	public Song(String n,String a,int ii) {
		this.name=n;
		this.artist=a;
		this.duration=ii;
	}
	public String getsong() {
		return this.name;
	}

	
}
