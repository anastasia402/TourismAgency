package Repository;

import Domain.Bilet;
import Domain.Client;
import Domain.JDBCUtils;
import Domain.Zbor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

public class BiletRepository implements IBiletRepository {
    private JDBCUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();

    public BiletRepository(Properties props) {
        logger.info("Initializing BiletRepository with properties: {} ",props);
        dbUtils=new JDBCUtils(props);

    }


    @Override
    public void add(Bilet elem) {
        logger.traceEntry("saving task {}", elem);
        Connection conn = dbUtils.getConnection();
        try(PreparedStatement ps = conn.prepareStatement("insert into Bilet(Zbor, Client, Turisti, NrLocuri) values(?, ?, ?, ?)")) {

            //ps.setInt(1, elem.getId());
            ps.setObject(1, elem.getZbor());
            ps.setObject(2, elem.getClient());
            ps.setString(3, elem.getListaTuristi());
            ps.setInt(4, elem.getNrLocuri());

            int result = ps.executeUpdate();


            logger.trace("Saved {} instaces", result);
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB 3 "+e);
        }
        logger.traceExit();
    }

    @Override
    public void update(Bilet elem, Integer id) {
        logger.traceEntry("saving task {}", elem);
        Connection conn = dbUtils.getConnection();
        try(PreparedStatement ps = conn.prepareStatement("update Bilet set Zbor = ?, Client = ? , Turisti = ? , NrLocuri = ? where id = "+id)) {


            ps.setObject(1, elem.getZbor());
            ps.setObject(2, elem.getClient());
            ps.setObject(3, elem.getListaTuristi());
            ps.setInt(4, elem.getNrLocuri());

            int result = ps.executeUpdate();


            logger.trace("Saved {} instaces", result);

        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB 4 "+e);
        }
        logger.traceExit();
    }

    @Override
    public Bilet findById(Integer id) {
        logger.traceEntry();
        Connection conn = dbUtils.getConnection();
        List<Bilet> bilete = new ArrayList<>();
        Bilet bilet = new Bilet();
        try(PreparedStatement ps = conn.prepareStatement("select * from Bilet where id ="+id)) {
            try (ResultSet result = ps.executeQuery()){
                    //int id = result.getInt("id");
                    int zbor = result.getInt("Zbor");
                    int client = result.getInt("Client");
                    String turisti = result.getString("Turisti");
                    int nrLocuri = result.getInt("NrLocuri");
                    bilet.setId(id);
                    bilet.setZbor(zbor);
                    bilet.setClient(client);
                    bilet.setNrLocuri(nrLocuri);
                    bilet.setListaTuristi(turisti);
            }
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB 5 "+e);
        }
        logger.traceExit(bilete);
        return bilet;
    }

    @Override
    public Collection<Bilet> getAll() {
        logger.traceEntry();
        Connection conn = dbUtils.getConnection();
        List<Bilet> bilete = new ArrayList<>();
        try(PreparedStatement ps = conn.prepareStatement("select * from Bilet")) {
            try (ResultSet result = ps.executeQuery()){
                while (result.next()){
                    int id = result.getInt("id");
                    int zbor = result.getInt("Zbor");
                    int client = result.getInt("Client");
                    String turisti = result.getString("Turisti");
                    int nrLocuri = result.getInt("NrLocuri");
                    Bilet bilet = new Bilet(id, zbor, client, turisti, nrLocuri);
                    //Zbor zbor1 = re;

                    bilete.add(bilet);
                }
            }
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB 5 "+e);
        }
        logger.traceExit(bilete);
        return bilete;
    }

    @Override
    public void delete(Bilet elem) {
        logger.traceEntry("saving task {}", elem);
        Connection conn = dbUtils.getConnection();
        try(PreparedStatement ps = conn.prepareStatement("delete from Bilet where id = ?")) {

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
}
