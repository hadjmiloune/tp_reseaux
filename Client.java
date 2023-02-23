import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
  public static void main(String[] args) throws Exception {
    Socket cs = new Socket("127.0.0.1", 9999);

    ObjectOutputStream out = new ObjectOutputStream(cs.getOutputStream());
    out.writeObject(new SubStr(args[0], args[1]));
    out.flush();

    byte[] b = new byte[200];
    InputStream in = cs.getInputStream();

    in.read(b);

    System.out.println(new String(b));
    cs.close();
  }
}
