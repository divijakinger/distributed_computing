import java.io.*;
import java.net.*;

class Client {
    public static void main(String[] args) {
        try {
            Socket sock = new Socket("127.0.0.1", 3000);
            BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
            OutputStream ostream = sock.getOutputStream();
            PrintWriter pwrite = new PrintWriter(ostream, true);
            InputStream istream = sock.getInputStream();
            BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));

            System.out.println("Client ready, type and press Enter key");
            String receiveMessage, sendMessage, temp;

            while (true) {
                System.out.println("\nEnter operation to perform (add, sub, mul, div)....");
                temp = keyRead.readLine();
                sendMessage = temp.toLowerCase();

                if (!isValidOperation(sendMessage)) {
                    System.out.println("Invalid operation. Please enter a valid operation.");
                    continue;
                }

                pwrite.println(sendMessage);
                if (sendMessage.equals("exit")) {
                    System.out.println("Client disconnected");
                    break;
                }

                System.out.println("Enter first parameter :");

                try {
                    sendMessage = keyRead.readLine();
                    int param1 = Integer.parseInt(sendMessage);
                    pwrite.println(param1);

                    System.out.println("Enter second parameter : ");
                    sendMessage = keyRead.readLine();
                    int param2 = Integer.parseInt(sendMessage);
                    pwrite.println(param2);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter valid numeric parameters.");
                    continue;
                }

                System.out.flush();

                if ((receiveMessage = receiveRead.readLine()) != null) {
                    System.out.println(receiveMessage);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidOperation(String operation) {
        return operation.equals("add") || operation.equals("sub") ||
                operation.equals("mul") || operation.equals("div")|| operation.equals("exit");
    }
}
