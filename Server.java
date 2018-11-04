import java.io.*;
import java.net.*;
import java.util.*;
class Server
{DataInputStream din;
 DataOutputStream dout;
 Socket s;
 ServerSocket ss;
 DataInputStream input;
 String me;
 String client;
	Server()
	{try{
		ss=new ServerSocket(10);
        s=ss.accept();
        din=new DataInputStream(s.getInputStream());
        dout=new DataOutputStream(s.getOutputStream());
        input=new DataInputStream(System.in);
        PrintStream ps=new PrintStream(new FileOutputStream("conversation.txt"));
        do{
           client=din.readUTF();
           System.out.println("client : "+ client);
           ps.println(new Date().toString());
           ps.println("client :=> "+client);
           me=input.readLine();
           dout.writeUTF(me);
           ps.println("server :=> " +me);
           System.out.println("you : "+me); 


        } while(!client.equals("stop"));
	}
	catch(Exception e)
	{}

	}
	public static void main(String[] args) {
		new Server();
	}
}