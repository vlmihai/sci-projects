import java.sql.*;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class BookingDAO {
    private Connection connection;

    BookingDAO(Connection connection) {
        this.connection = connection;
    }

    /**
     * This method creates a sequence and a table in the database.
     * @throws SQLException
     */
    void createTable () throws SQLException {

        try (Statement statement = connection.createStatement()) {

            //method 1 with sequence
            /*statement.executeUpdate("create sequence test_seq");
            statement.executeUpdate("create table test (id numeric primary key not null default nextval('accomodation_seq')," +
                    "type varchar(32),bed_type varchar(32),max_guests int,description varchar(512))");*/
            //methid 2 without sequence; id serial which does not require to insert and it's auto-incremental; using setAutoComit
            connection.setAutoCommit(false);
            statement.executeUpdate("create table test (id serial primary key, title varchar (100) not null, " +
                    "author varchar (100) not null)");
            statement.executeUpdate("create table accomodation (id serial primary key, type varchar(32) not null, " +
                    "bed_type varchar(32) not null, max_guests int, description varchar(512) not null)");
            statement.executeUpdate("create table room_fair (id serial primary key, value int not null, " +
                    "season varchar(32) not null)");
            statement.executeUpdate("create table accomodation_fair_relation (id serial primary key, " +
                    "id_accomodation int, CONSTRAINT fk_accomodation_id FOREIGN KEY (id_accomodation) REFERENCES accomodation (id),\n" +
                    "id_room_fair int, CONSTRAINT fk_room_fair_id FOREIGN KEY (id_room_fair) REFERENCES room_fair (id))");
            statement.executeUpdate("insert into  test (title, author) values ('the book', 'the author');");
            statement.executeUpdate("insert into  test (title, author) values ('the book1', 'the author1');");
            statement.executeUpdate("insert into  test (title, author) values ('the book2', 'the author2');");
            connection.commit();
            connection.setAutoCommit(true);

            System.out.println("Table Created");

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {

            if (connection != null) {
                connection.close();
            }
        }

    }

    /**
     * This method adds a given list of accommodations to the accommodation table from the database.
     * @param accomodation
     * @throws SQLException
     */
    public void addAccom (List<Accomodation> accomodation) throws SQLException {

        String sql = "insert into accomodation(/*id,*/type,bed_type,max_guests,description) values (/*?, */?, ?, ?, ?)";
        for (Accomodation acc : accomodation) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, acc.getId());
            preparedStatement.setString(2, acc.getType());
            preparedStatement.setString(3, acc.getBed_type());
            preparedStatement.setInt(4, acc.getMax_guests());
            preparedStatement.setString(5, acc.getDescription());

            preparedStatement.executeUpdate();
        }
    }

    /**
     * This method adds a given list of room fairs to the room fair table from the database.
     * @param roomFair
     * @throws SQLException
     */

    void addRoomFair (List<RoomFair> roomFair) throws SQLException {

        String sgl = "insert into room_fair(/*id,*/value,season) values (/*?, */? ,?)";
        for (RoomFair fair : roomFair) {
            PreparedStatement preparedStatement = connection.prepareStatement(sgl);
            preparedStatement.setInt(1, fair.getId());
            preparedStatement.setDouble(2, fair.getValue());
            preparedStatement.setString(3, fair.getSeason());

            preparedStatement.executeUpdate();
        }
    }

    /**
     * This method adds relations from both the accommodation and room fair table to a new table.
     * this new table is a link table between accommodation and room fair table.
     * @param accomodations
     * @param fairs
     * @throws SQLException
     */

    void addRelation (List<Accomodation> accomodations, List<RoomFair> fairs) throws SQLException {
        String sql = "insert into accomodation_fair_relation (id,id_accomodation,id_room_fair) values (?, ?, ?)";
        List<RoomFair> season = fairs
                .stream()
                .filter(x -> "season".equals(x.getSeason()))
                .collect(toList());
        List<RoomFair> offSeason = fairs
                .stream()
                .filter(x -> "off-season".equals(x.getSeason()))
                .collect(toList());

        int count = 0;
        for (int i = 0; i < accomodations.size(); i++) {
            PreparedStatement ps1 = connection.prepareStatement(sql);
            PreparedStatement ps2 = connection.prepareStatement(sql);
            ps1.setInt(1, i+count);
            ps1.setInt(2, accomodations.get(i).getId());
            ps1.setInt(3, season.get(i).getId());
            count ++;
            ps2.setInt(1,i+count);
            ps2.setInt(2,accomodations.get(i).getId());
            ps2.setInt(3, offSeason.get(i).getId());

            ps1.executeUpdate();
            ps2.executeUpdate();
        }
    }

    /**
     * This method clears all rows from all tables created.
     */

    void clearAllTables () {
        try {Statement statement = connection.createStatement();
            connection.setAutoCommit(false);
            statement.execute("truncate table accomodation cascade");
            statement.execute("truncate table room_fair cascade");
            statement.execute("truncate table accomodation_fair_relation cascade");
            connection.commit();
            connection.setAutoCommit(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method deletes all tables from the database.
     * @throws SQLException
     */
    void deleteAllTables () throws SQLException {
        try {
            Statement statement = connection.createStatement();
            connection.setAutoCommit(false);
            statement.execute("drop table accomodation");
            statement.execute("drop table room_fair");
            statement.execute("drop table accomodation_fair_relation");
            statement.execute("drop table test");
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method gets rooms types and prices from the database, based on the connection table between
     * the two tables: accomodation and room_fair.
     * @throws SQLException
     */

    void getAll() throws SQLException {
        Map<Accomodation, RoomFair> results = new LinkedHashMap<>();
        List<Accomodation> accom = new LinkedList<>();
        List<RoomFair> fairs = new LinkedList<>();

        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery("SELECT accomodation.id as id, accomodation.type as type," +
                "room_fair.value as value, room_fair.season as season " +
                "FROM accomodation_fair_relation " +
                "    INNER JOIN accomodation ON accomodation_fair_relation.id_accomodation = accomodation.id " +
                "    INNER JOIN room_fair ON accomodation_fair_relation.id_room_fair = room_fair.id");

        while (rs.next()) {

            Accomodation acc = new Accomodation();
            acc.setId(rs.getInt("id"));
            acc.setType(rs.getString("type"));
            accom.add(acc);

            RoomFair roomFair = new RoomFair();
            roomFair.setValue(rs.getDouble("value"));
            roomFair.setSeason(rs.getString("season"));
            fairs.add(roomFair);
        }
        rs.close();

        //am preferat aceasta metoda deoarece am aplicat ce am invatat la Java8 (Lambda, Method References & Streams)
        Map<Accomodation, RoomFair> fairMap = IntStream.range(0, accom.size())
                .sorted()
                .collect(
                        LinkedHashMap::new,
                        (m, i) -> m.put(accom.get(i), fairs.get(i)),
                        Map::putAll

                );
        fairMap.forEach((key, value) -> System.out.println("Id:" + key.getId() + " Type:" + key.getType() +
                " Price:" + value.getValue() + " Season:" + value.getSeason()));


        /*for (Map.Entry entry : fairMap.entrySet()) {
            System.out.println(entry.getKey() + "" + entry.getValue());
        }*/

        // o alta metoda de a combina cele doua liste
        /*for (int i=0; i<accom.size(); i++) {
            results.put(accom.get(i), fairs.get(i));
        }
        System.out.println(results);*/
    }

}
