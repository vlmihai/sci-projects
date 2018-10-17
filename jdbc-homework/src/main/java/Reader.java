import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    private FileReader reader;

    Reader(FileReader reader) {
        this.reader = reader;
    }

    List<Accomodation> getAccomodation () throws IOException {
        try (BufferedReader br = new BufferedReader(reader)){
            ArrayList<Accomodation> accomodation = new ArrayList<>();
            String line = br.readLine();
            while (line != null) {
                accomodation.add(parseAccomodation(line));
                line = br.readLine();
            }
            return accomodation;
        }
    }

    List<RoomFair> getFairs () throws IOException {
        try (BufferedReader br = new BufferedReader(reader)){
            ArrayList<RoomFair> roomFairs = new ArrayList<>();
            String line = br.readLine();
            while (line != null) {
                roomFairs.add(parseRoomFair(line));
                line = br.readLine();
            }
            return roomFairs;
        }
    }


    private Accomodation parseAccomodation(String line) {
        String[] tokens = line.split(",");
        return new Accomodation(Integer.parseInt(tokens[0]), tokens[1], tokens[2], Integer.parseInt(tokens[3]), tokens[4]);
    }

    private RoomFair parseRoomFair(String line) {
        String[] tokens = line.split(",");
        return new RoomFair(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), tokens[2]);
    }

}
