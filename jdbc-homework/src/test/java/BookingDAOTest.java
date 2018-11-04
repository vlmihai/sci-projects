import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

class BookingDAOTest {

    private File f = new File ("accomodation.csv");
    private File f1 = new File ("room_fair.csv");

    private FileReader frAccom = new FileReader(f);
    private FileReader frFairs = new FileReader(f1);

    private List<Accomodation> accom = new Reader(frAccom).getAccomodation();
    private List<RoomFair> roomFairs = new Reader(frFairs).getFairs();

    public List<Accomodation> getAccom() {
        return accom;
    }

    public List<RoomFair> getRoomFairs() {
        return roomFairs;
    }

    private Connection connection;

    BookingDAOTest() throws IOException {
    }

    @BeforeEach
    void setUp() throws SQLException {
        connection = DBUtil.getConnection(DBType.POSTGRESQL);
    }

    @AfterEach
    void tearDown () throws SQLException {
        connection.close();
    }

    @Test
    void addRelation() throws SQLException {
        getAccom().add(9,new Accomodation(9,"pool house","3 x king",6,"individual cabana " +
                "with pool and jacuzzi, 3 king size beds, full kitchen"));
        getRoomFairs().add(18,new RoomFair(18,1000,"season"));
        getRoomFairs().add(19,new RoomFair(19,800,"off-season"));
        BookingDAO test = new BookingDAO(connection);
        //test.clearAllTables();
        test.addAccom(getAccom());
        test.addRoomFair(getRoomFairs());
        test.addRelation(getAccom(),getRoomFairs());
    }

    @Test
    void getAll() throws SQLException {
        BookingDAO test = new BookingDAO(connection);
        test.getAll();
    }

    @Test
    void clearAllTables () {
        BookingDAO test = new BookingDAO(connection);
        test.clearAllTables();
    }
}