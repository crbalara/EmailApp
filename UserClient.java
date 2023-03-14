import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class UserClient {
    public static void main(String[] args) {

        try {
            Socket s = new Socket("localhost", 8080);
            System.out.println("Connected to Server!!!");
            while (true) {
                DataOutputStream dop = new DataOutputStream(s.getOutputStream());
                Scanner sc = new Scanner(System.in);
                DataInputStream dip = new DataInputStream(s.getInputStream());


                System.out.println("Type Your Name :");
                String name = sc.nextLine();
                dop.writeUTF(name);

                System.out.println("Type Your Email Address :");
                String mail = sc.nextLine();
                dop.writeUTF(mail);

                System.out.println("Type Your Department\n Press 1 for Java Doveloper\n Press 2 for Android Doveloper\n Press 3 for FullStack Doveloper ");
                int depid = sc.nextInt();
                dop.writeInt(depid);
            }

            }
                catch(Exception e){
                System.out.println(e);
            }

        }


    }


