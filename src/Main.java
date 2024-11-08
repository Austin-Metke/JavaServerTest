import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // Server example

        Card card = new Card(Card.Suit.CLUBS, 8);

        // Sets up a server socket on port 5000
        ServerSocket serverSocket = new ServerSocket(5000);

        // Connect to client
        Socket socket = serverSocket.accept();


        //Setup IO stream
        ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

        //Serialize and send Card object
        outputStream.writeObject(card);
        System.out.println("Object sent :" + card);

        // Close the socket and streams
        outputStream.close();
        socket.close();
        serverSocket.close();
    }

}

class Card implements Serializable {

    private Suit suit;
    private int rank;

    public Card(Suit suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }


    public int getRank() {
        return rank;
    }


    public enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    }

    public String toString() {
        return "\nSUIT: " + this.suit + "\nRANK: " + this.rank;
    }
}


