package dao;

import framework.dao.DaoException;
import framework.dao.DaoHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Person;
import model.Address;

public class PersonDao {
    
    private DaoHelper daoHelper;
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rset = null;
    
    public PersonDao() {
        daoHelper = new DaoHelper();
    }
    
    public Person insert(Person person) throws DaoException {
        try {
            daoHelper.begingTransaction();
            
            conn = daoHelper.getConnectionFromContext();
            
            pstmt = conn.prepareStatement("INSERT INTO people (name, legal_name, kind, document_1, document_2, email, phone, cel, status) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? )", 
                    PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, person.getName());
            pstmt.setString(2, person.getLegalName());
            pstmt.setString(3, person.getKind());
            pstmt.setString(4, person.getDocument1());
            pstmt.setString(5, person.getDocument2());
            pstmt.setString(6, person.getEmail());
            pstmt.setString(7, person.getPhone());
            pstmt.setString(8, person.getCel());
            pstmt.setString(9, person.getStatus());

            pstmt.executeUpdate();
            
            rset = pstmt.getGeneratedKeys();
            
            if (rset.next()) {
                person.setId(rset.getLong(1));
            } else {
                System.out.println("Erro ao salvar a pessoa.");
            }
            
            Address address = person.getAddress();
            
            person.setAddress( new AddressDao().insert(address) );
            
            daoHelper.endTransaction();          
        } catch (Exception e) {
           throw new DaoException("Não foi possivel realizar a tranzação.", e);
        } finally {
           daoHelper.releaseAll(conn, pstmt);
        }
        
        return person;
    }
    
}
