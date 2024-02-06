Remote Procedure Call (RPC) in Distributed Systems

Introduction
This README provides an overview of the Remote Procedure Call (RPC) implementation in the given Java code for a distributed system. RPC is a communication protocol that allows a program to cause a procedure (subroutine) to execute in another address space, typically on another machine in a network.

Code Overview
The provided Java code consists of two main components: the Client and the Server.

Client
The client initiates a connection to the server using a socket and performs the following steps:

Establishes a connection to the server at IP address "127.0.0.1" and port 3000.
Sets up input and output streams for communication with the server.
Takes user input for the operation to perform (add, sub, mul, div), and two parameters.
Sends the operation and parameters to the server.
Receives the result from the server and prints it.
Server
The server waits for a connection from a client, then performs the following steps:

Listens for incoming connections on port 3000.
Accepts a connection from a client.
Sets up input and output streams for communication with the client.
Reads the operation and parameters sent by the client.
Performs the specified operation (add, sub, mul, div) on the parameters.
Sends the result back to the client.

RPC Operations
The supported operations in this example are addition, subtraction, multiplication, and division. The client sends the chosen operation and two parameters to the server, which performs the operation and returns the result.

How to Run
1. Compile both Client.java and Server.java files.
    javac Client.java
    javac Server.java
2. Run the Server program first using the command: java Server
3. Run the Client program using the command: java Client
4. Follow the on-screen instructions to choose an operation and input parameters.
5. View the result returned by the server.
6. Repeat steps 3-5 to perform additional operations.
7. Exit the client program by entering "exit" when prompted for an operation.
8. Exit the server program by pressing "Ctrl + C" in the terminal.
9. Note: The server must be running before the client can connect to it.

Conclusion