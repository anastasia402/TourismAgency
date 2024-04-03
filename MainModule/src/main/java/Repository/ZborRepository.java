package Repository;

import Domain.JDBCUtils;
import Domain.Zbor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class ZborRepository implements IZborRepository{

    private JDBCUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();

    public ZborRepository(Properties props) {
        logger.info("Initializing ZborRepository with properties: {} ",props);
        dbUtils=new JDBCUtils(props);
    }

    @Override
    public void add(Zbor elem) {
        logger.traceEntry("saving task {}", elem);
        Connection conn = dbUtils.getConnection();
        try(PreparedStatement ps = conn.prepareStatement("insert into Zboruri(Destinatie, Data, Ora, Aeroport, NrLocuri) values(?, ?, ?, ?, ?)")) {

            //ps.setInt(1, elem.getId());
            ps.setString(1, elem.getDestinatie());
            ps.setString(2, elem.getData());
            ps.setString(3, elem.getOra());
            ps.setString(4, elem.getAeroport());
            ps.setInt(5, elem.getNrLocuri());

            int result = ps.executeUpdate();
            logger.trace("Saved {} instaces", result);

        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB 3 "+e);
        }
        logger.traceExit();
    }

    @Override
    public void delete(Zbor elem) {
        logger.traceEntry("saving task {}", elem);
        Connection conn = dbUtils.getConnection();
        try(PreparedStatement ps = conn.prepareStatement("delete from Zboruri where id = ?")) {

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
    public void update(Zbor elem, Integer id) {
        logger.traceEntry("saving task {}", elem);
        Connection conn = dbUtils.getConnection();
        try(PreparedStatement ps = conn.prepareStatement("update Zboruri set Destinatie = ?, Data = ? , Ora = ?, Aeroport = ?, NrLocuri = ? where id = ?")) {

            ps.setString(1, elem.getDestinatie());
            ps.setString(2, elem.getData());
            ps.setString(3, elem.getOra());
            ps.setString(4, elem.getAeroport());
            ps.setInt(5, elem.getNrLocuri());
            ps.setInt(6, id);

            int result = ps.executeUpdate();
            logger.trace("Saved {} instaces", result);

        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB 4 "+e);
        }
        logger.traceExit();
    }

    @Override
    public Zbor findById(Integer id) {
        for (Zbor zbor: getAll()){
            if (Objects.equals(zbor.getId(), id)){
                return zbor;
            }
        }
        return null;
    }

    public Collection<Zbor> findZbor(String dest, String data, String ora){

        logger.traceEntry();
        Connection conn = dbUtils.getConnection();
        Collection<Zbor> zboruri = getAll();
        Collection<Zbor> zboruriFiltarte = new ArrayList<>();
        for (Zbor zbor: zboruri){
            if (zbor.getDestinatie().equals(dest) & zbor.getData().equals(data) & zbor.getOra().equals(ora)){
                zboruriFiltarte.add(zbor);
            }
        }
        logger.traceExit(zboruri);
        return zboruriFiltarte;
    }

    @Override
    public Collection<Zbor> getAll() {
        logger.traceEntry();
        Connection conn = dbUtils.getConnection();
        List<Zbor> zboruri = new ArrayList<>();
        try(PreparedStatement ps = conn.prepareStatement("select * from Zboruri")) {
            try (ResultSet result = ps.executeQuery()){
                while (result.next()){
                    int id = result.getInt("id");
                    String dest = result.getString("Destinatie");
                    String data = result.getString("Data");
                    String ora = result.getString("Ora");
                    String aeroport = result.getString("Aeroport");
                    int nrLoc = result.getInt("NrLocuri");

                    Zbor zbor = new Zbor(id, dest, data, ora, aeroport, nrLoc);

                    zboruri.add(zbor);
                }
            }
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB 5 "+e);
        }
        logger.traceExit(zboruri);
        return zboruri;
    }
}
