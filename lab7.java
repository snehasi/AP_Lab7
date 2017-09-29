package lab7;

import static org.junit.Assert.*;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import org.junit.Test;
import lab7v1.*;

public class lab7 {

	@Test
	public void test() throws IOException, ClassNotFoundException {
		lab7v1 ooo = new lab7v1();
//		ObjectInputStream innn=null;
//		ArrayList<Song> playlist = new ArrayList<Song>();
//		try {
//			innn=new ObjectInputStream(new FileInputStream("//Users//snehasi//eclipse-workspace//lab7v1//"+"playlist"+".txt//"));
//			Song s = (Song)innn.readObject();
//			playlist.add(s);
//			while(s!=null)
//			{
//				s = (Song) innn.readObject();
//				playlist.add(s);
//			}
//		}
//		finally {
//			innn.close();
//		}
		String playli="";
		
		ArrayList<Song> playlist = new ArrayList<Song>();
		playlist = ooo.deserialize(playli);
		//Song ss = new Song("Sinha","ttt",5);
		//Song ss2= new Song("Sneha","tt",4);
		Song ss3 = new Song("Sister","me",12);
		//playlist.add(ss);
		//playlist.add(ss2);
		
		playlist.add(ss3);
		System.out.println(ooo.show(playlist));
		
		assertEquals("Sinha ttt 5Sneha tt 4Sister mee 12Sister me 12\n" + 
				"Sinha ttt 5Sneha tt 4Sister mee 12Sister me 12\n" + 
				"Sinha ttt 5Sneha tt 4Sister mee 12Sister me 12",ooo.show(playlist));
		//System.out.println(ooo.show(playlist));
		playlist.remove(ss3);
		assertEquals("Sinha ttt 5Sneha tt 4",ooo.show(playlist));
		assertEquals("Sneha tt 4",ooo.search("Sneha",playlist));
		
	}
	

}
