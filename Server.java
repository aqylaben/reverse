import java.net.*;
import java.io.*;


public class Server 
{
	public static void main(String[] args)throws Exception
 	{
	   int count=1;
	   System.out.println("Server is running...................");
	   ServerSocket ss=new ServerSocket(8080);
	   while(true)
  	   {
		 new RevThread(ss.accept(),count).start();
		 System.out.println(count+" client connected");
		 count++;
           }
         }
}

class RevThread extends Thread
{
	 Socket s=null;
	 int n;
	 public RevThread(Socket socket,int count)
	 {
		s=socket;
		n=count;
	 }

 	 public void run()
 	{
  		try
  		{
   			while(true)
   			{
			    System.out.println("receiving from client "+n);
			    DataInputStream din=new DataInputStream(s.getInputStream());
			    String str=din.readUTF();
			    System.out.println("processing data of Client "+n);
			    StringBuffer rev=new StringBuffer();
			    rev=rev.append(str);
			    rev=rev.reverse();
			    String revStr=new String(rev);
			    System.out.println("sending to client "+n);
			    DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			    dout.writeUTF(revStr);

			    /*System.out.println("Enter String to reverse:");
			    DataInputStream in=new DataInputStream(System.in);
			    String str=in.readLine();
			    DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			    dout.writeUTF(str);

			    DataInputStream din=new DataInputStream(s.getInputStream());
			    String rev=din.readUTF();
			    System.out.println("Reversed String:\t"+rev);*/
			   }
  		}
  		catch(IOException e)
  		{
   			System.out.println(e);
  		}
 	}
}
