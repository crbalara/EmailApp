import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import org.json.simple.*;

public class Department {
    public static void main(String[] args) {
        while (true) {
            try {

                File f0 = new File("C:\\Users\\91876\\Desktop\\MyEmailApp.txt");
                if(f0.createNewFile())
                {
                    System.out.println("File created Successfully");
                }
                else
                {
                    System.out.println("File Already Exists");
                }

                FileWriter fw = new FileWriter(f0,true);
                fw.write("RECORDS");


                ServerSocket ss = new ServerSocket(8080);
                System.out.println("Server Running....");

                Socket s = ss.accept();
                System.out.println("connected to User");
                while (true) {

                    DataInputStream dip = new DataInputStream(s.getInputStream());
                    Scanner sc = new Scanner(System.in);
                    DataOutputStream dop = new DataOutputStream(s.getOutputStream());


                    String name = dip.readUTF();
                    fw.write(name);


                    String mail = dip.readUTF();
                    fw.write(mail);

                    int depid = dip.readInt();
                    fw.write(depid);
                }


            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

