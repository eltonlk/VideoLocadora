package dao;

import framework.dao.DaoException;
import framework.dao.DaoHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Address;

public class AddressDao {

    private DaoHelper daoHelper;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rset = null;
    
    public AddressDao() {
        daoHelper = new DaoHelper();
    }
    
    public Address insert(Address address) throws DaoException {
        try {
            conn = daoHelper.getConnectionFromContext();
            
            pstmt = conn.prepareStatement("INSERT INTO addresses (district_id, person_id, address, location) VALUES ( ?, ?, ?, ? )", 
                    PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setLong(1, address.getDistrictId());
            pstmt.setLong(2, address.getPersonId());
            pstmt.setString(3, address.getAddress());
            pstmt.setString(4, address.getLocation());

            pstmt.executeUpdate();

            rset = pstmt.getGeneratedKeys();
            
            if (rset.next()) {
                address.setId(rset.getLong(1));
            }
        } catch (Exception e) {
           throw new DaoException("Não foi possivel realizar a tranzação.", e);
        } finally {
//           daoHelper.releaseAll(conn, pstmt);
        }
        
        return address;
    }    
    
}
