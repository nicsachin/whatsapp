import java.io.*;
import java.net.*;
class Client
{DataInputStream din;
 DataOutputStream dout;
 Socket s;
 DataInputStream input;
 String me;
 String server;
	Client()
	{
		try{
			s=new Socket("localhost",10);
			din=new DataInputStream(s.getInputStream());
			dout=new DataOutputStream(s.getOutputStream());
            input=new DataInputStream(System.in);
            do{
            	me=input.readLine();
            	dout.writeUTF(me);
            	System.out.println("you : "+me);
            	server=din.readUTF();
            	System.out.println("server : "+server);
            }
            while(!me.equals("stop"));
           
		  }
		  catch(Exception e){}
	}
	public static void main(String[] args) {
		new Client();
	}
}