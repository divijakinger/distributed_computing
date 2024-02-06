import java.io.*;
import java.net.*;

class Server {
    public static void main(String[] args) {
        try {
            ServerSocket sersock = new ServerSocket(3000);
            System.out.println("Server ready");

            while (true) {
                Socket sock = sersock.accept();
                handleClient(sock);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket sock) {
        try (
                BufferedReader receiveRead = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                PrintWriter pwrite = new PrintWriter(sock.getOutputStream(), true)
        ) {
            String receiveMessage, fun;
            int a, b, c;

            while (true) {
                fun = receiveRead.readLine();
                if (fun.compareTo("exit") == 0) {
                    System.out.println("Client disconnected");
                    break;
                }
                if (!isValidOperation(fun)) {
                    System.out.println("Invalid operation received from client.");
                    continue;
                }
                System.out.println("Operation: " + fun);

                try {
                    a = Integer.parseInt(receiveRead.readLine());
                    System.out.println("Parameter 1: " + a);

                    b = Integer.parseInt(receiveRead.readLine());
                    System.out.println("Parameter 2: " + b);

                    if (fun.equals("div") && b == 0) {
                        pwrite.println("Error: Division by zero");
                        continue;
                    }

                    performOperation(fun, a, b, pwrite);
                } catch (NumberFormatException e) {
                    pwrite.println("Error: Invalid numeric parameters");
                    continue;
                }

                System.out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidOperation(String operation) {
        return operation.equals("add") || operation.equals("sub") ||
                operation.equals("mul") || operation.equals("div");
    }

    private static void performOperation(String operation, int a, int b, PrintWriter pwrite) {
        int result = 0;
        switch (operation) {
            case "add":
                result = a + b;
                break;
            case "sub":
                result = a - b;
                break;
            case "mul":
                result = a * b;
                break;
            case "div":
                result = a / b;
                break;
        }

        System.out.println("Result: " + result);
        pwrite.println("Result: " + result);
    }
}
