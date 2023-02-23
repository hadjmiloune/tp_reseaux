import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws Exception {
    ServerSocket serv = new ServerSocket(9999);
    System.out.println("Server started ... Listening on port 9999 ");

    while (true) {
      Socket client_response = serv.accept();
      ServerInstance new_server = new ServerInstance(client_response);
      new_server.start();
    }
  }

}
