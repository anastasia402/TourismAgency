package Repository;

import Domain.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

public class AngajatRepository implements IAngajatRepsoitory {
    private JDBCUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();

    public AngajatRepository(Properties props) {
        logger.info("Initializing AngajatRepository with properties: {} ",props);
        dbUtils=new JDBCUtils(props);
    }

    @Override
    public void add(Angajat elem) {
        logger.traceEntry("saving task {}", elem);
        Connection conn = dbUtils.getConnection();
        try(PreparedStatement ps = conn.prepareStatement("insert into Angajati(Nume, Username, Password) values(?, ?, ?)")) {

            //ps.setInt(1, client.getId());
            ps.setString(1, elem.getNume());
            ps.setString(2, elem.getUsername());
            ps.setString(3, elem.getPassword());

            int result = ps.executeUpdate();


            logger.trace("Saved {} instaces", result);
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB 3 "+e);
        }
        logger.traceExit();
    }

    @Override
    public void update(Angajat elem, Integer id) {
        logger.traceEntry("saving task {}", elem);
        Connection conn = dbUtils.getConnection();
        try(PreparedStatement ps = conn.prepareStatement("update Angajati set Nume = ?, Username = ?, Password = ? where id = "+id)) {

            ps.setString(1, elem.getNume());
            ps.setString(2, elem.getUsername());
            ps.setString(3, elem.getPassword());

            int result = ps.executeUpdate();
            logger.trace("Saved {} instaces", result);

        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB 4 "+e);
        }
        logger.traceExit();
    }



    @Override
    public Angajat findById(Integer id) {
        for (Angajat a: getAll()){
            if (a.getId() == id)
                return a;
        }
        return null;
    }

    @Override
    public Collection<Angajat> getAll() {
        logger.traceEntry();
        Connection conn = dbUtils.getConnection();
        List<Angajat> anagajati = new ArrayList<>();
        try(PreparedStatement ps = conn.prepareStatement("select * from Angajati")) {
            try (ResultSet result = ps.executeQuery()){
                while (result.next()){
                    int id = result.getInt("id");
                    String  nume = result.getString("Nume");
                    String user = result.getString("Username");
                    String pass = result.getString("Password");
                    Angajat angajat = new Angajat(id, nume, user, pass);

                    anagajati.add(angajat);
                }
            }
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB 5 "+e);
        }
        logger.traceExit(anagajati);
        return anagajati;
    }

    @Override
    public void delete(Angajat elem) {
        logger.traceEntry("saving task {}", elem);
        Connection conn = dbUtils.getConnection();
        try(PreparedStatement ps = conn.prepareStatement("delete from Angajati where id = ?")) {

            //ps.setInt(1, elem.getId());
            ps.setInt(1, elem.getId());
            int result = ps.executeUpdate();

            logger.trace("Saved {} instaces", result);

        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB 3 "+e);
        }
        logger.traceExit();
    }

    @Override
    public boolean checkAngajat(Angajat angajat) {
        Collection<Angajat> angajati = getAll();
        for (Angajat angajat1 : angajati){
            if (angajat.getPassword().equals(angajat1.getPassword()) &&
                    angajat.getUsername().equals(angajat1.getUsername()))
                return true;
            else
                return false;
        }
        return false;
    }
}
