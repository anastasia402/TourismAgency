package Repository;

import Domain.JDBCUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import Domain.Client;

public class ClientRepository implements IClientRepository{

    private JDBCUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();

    public ClientRepository(Properties props) {
        logger.info("Initializing ClientRepository with properties: {} ",props);
        dbUtils=new JDBCUtils(props);

    }

    @Override
    public void add(Client client) {
        logger.traceEntry("saving task {}", client);
        Connection conn = dbUtils.getConnection();
        try(PreparedStatement ps = conn.prepareStatement("insert into Client(Nume, Adresa) values(?, ?)")) {

            //ps.setInt(1, client.getId());
            ps.setString(1, client.getNume());
            ps.setString(2, client.getAdresa());

            int result = ps.executeUpdate();


            logger.trace("Saved {} instaces", result);
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB 3 "+e);
        }
        logger.traceExit();
    }


    @Override
    public void update(Client elem, Integer id) {
        logger.traceEntry("saving task {}", elem);
        Connection conn = dbUtils.getConnection();
        try(PreparedStatement ps = conn.prepareStatement("update Client set Nume = ?, Adresa = ? where id = "+id)) {

            ps.setString(1, elem.getNume());
            ps.setString(2, elem.getAdresa());

            int result = ps.executeUpdate();
            //repo.update(elem, id);
            logger.trace("Saved {} instaces", result);

        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB 4 "+e);
        }
        logger.traceExit();
    }

    @Override
    public Client findById(Integer id) {
        for (Client c: getAll()){
            if (c.getId() == id){
                return c;
            }
        }
        return null;
    }


    @Override
    public Collection<Client> getAll() {
        logger.traceEntry();
        Connection conn = dbUtils.getConnection();
        List<Client> clienti = new ArrayList<>();
        try(PreparedStatement ps = conn.prepareStatement("select * from Client")) {
            try (ResultSet result = ps.executeQuery()){
                while (result.next()){
                    int id = result.getInt("id");
                    String nume = result.getString("Nume");
                    String adresa = result.getString("Adresa");
                    Client client = new Client(id, nume, adresa);

                    clienti.add(client);
                }
            }
        } catch (SQLException e) {
            logger.error(e);
            System.err.println("Error DB 5 "+e);
        }
        logger.traceExit(clienti);
        return clienti;
    }

    @Override
    public void delete(Client elem) {
        logger.traceEntry("saving task {}", elem);
        Connection conn = dbUtils.getConnection();
        try(PreparedStatement ps = conn.prepareStatement("delete from Client where id = ?")) {

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

