<h1>Remote Procedure Call (RPC) in Distributed Systems</h1>

<h2>Introduction</h2>
This README provides an overview of the Remote Procedure Call (RPC) implementation in the given Java code for a distributed system. RPC is a communication protocol that allows a program to cause a procedure (subroutine) to execute in another address space, typically on another machine in a network.

<h2>Code Overview</h2>
The provided Java code consists of two main components: the Client and the Server.

<h3>Client</h3>
The client initiates a connection to the server using a socket and performs the following steps:

Establishes a connection to the server at IP address "127.0.0.1" and port 3000.
Sets up input and output streams for communication with the server.
Takes user input for the operation to perform (add, sub, mul, div), and two parameters.
Sends the operation and parameters to the server.
Receives the result from the server and prints it.

<h3>Server</h3>
The server waits for a connection from a client, then performs the following steps:

Listens for incoming connections on port 3000.
Accepts a connection from a client.
Sets up input and output streams for communication with the client.
Reads the operation and parameters sent by the client.
Performs the specified operation (add, sub, mul, div) on the parameters.
Sends the result back to the client.

<h2>RPC Operations</h2>
The supported operations in this example are addition, subtraction, multiplication, and division. The client sends the chosen operation and two parameters to the server, which performs the operation and returns the result.

<h2>How to Run </h2>

1. Compile both Client.java and Server.java files.
    ```
    javac Client.java
    javac Server.java
    ```
2. Run the Server program first using the command:
    ```java Server```
4. Run the Client program using the command: 
    ```java Client```
5. Follow the on-screen instructions to choose an operation and input parameters.
6. View the result returned by the server.
7. Repeat steps 3-5 to perform additional operations.
8. Exit the client program by entering "exit" when prompted for an operation.
9. Exit the server program by pressing "Ctrl + C" in the terminal.
10. Note: The server must be running before the client can connect to it.

<h2>Conclusion</h2>
This README provides a brief overview of the RPC implementation in the given Java code for a distributed system. It serves as a guide for understanding the basic communication between a client and server using RPC.
