import java.io.*;
import java.net.*;
public class Client 
{
	public static void main(String[] args) throws Exception
	{
  		Socket s=new Socket("127.0.0.1",8080);
  		if(s.isConnected())
  		{
   			System.out.println("Connected to Server....");
  		}

  		while(true)
  		{
   			System.out.println("Enter String to reverse:");
   			DataInputStream in=new DataInputStream(System.in);
   			String str=in.readLine();
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			dout.writeUTF(str);
   
			DataInputStream din=new DataInputStream(s.getInputStream());
			String rev=din.readUTF();
			System.out.println("Reversed String:\t"+rev);

			/*System.out.println("receiving from server "+n);
			DataInputStream din=new DataInputStream(s.getInputStream());
			String str=din.readUTF();
			System.out.println("processing data of server "+n);
			StringBuffer rev=new StringBuffer();
			rev=rev.append(str);
			rev=rev.reverse();
			String revStr=new String(rev);
			System.out.println("sending to server "+n);
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			dout.writeUTF(revStr);*/
  		}
 	} 
}

