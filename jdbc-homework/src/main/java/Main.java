import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        File f = new File ("accomodation.csv");
        if (!f.exists()) {
            System.out.println("File " + f.getName() + " does not exist.");
        }

        File f1 = new File ("room_fair.csv");
        if (!f1.exists()) {
            System.out.println("File " + f1.getName() + " does not exist.");
        }

        FileReader frAccom = new FileReader(f);
        List<Accomodation> accom = new Reader(frAccom).getAccomodation();

        FileReader frFairs = new FileReader(f1);
        List<RoomFair> roomFairs = new Reader(frFairs).getFairs();


        try { Connection connection = DBUtil.getConnection(DBType.POSTGRESQL);

            if (connection == null) {
                System.out.print("No connection");
            } else {
                BookingDAO bookingDAO = new BookingDAO(connection);
                //bookingDAO.createTable();
                //bookingDAO.addAccom(accom);
                //bookingDAO.addRoomFair(roomFairs);
                //bookingDAO.addRelation(accom,roomFairs);
                //bookingDAO.clearAllTables();
                //bookingDAO.deleteAllTables();
                bookingDAO.getAll();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}