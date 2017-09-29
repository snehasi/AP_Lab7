package lab7v1;

import java.io.Serializable;

public class Song implements Serializable{
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
