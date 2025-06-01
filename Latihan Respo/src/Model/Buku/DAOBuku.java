
package Model.Buku;
import Model.Connector;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Rakha
 */
public class DAOBuku implements InterfaceDAO {

    @Override
    public void insert(ModelBuku buku) {
        try{
            String query = "INSERT INTO buku (Judul, Penulis, Tahun, Alur, Tata_Bahasa, Orisinalitas, Rating) VALUES(?, ?, ?, ?, ?, ?, ?)";
            
            
            PreparedStatement statment;
            statment = Connector.connect().prepareStatement(query);
            statment.setString(1, buku.getJudul());
            statment.setString(2, buku.getPenulis());
            statment.setInt(3, buku.getTahun());
            statment.setDouble(4, buku.getAlur());
            statment.setDouble(5, buku.getBahasa());
            statment.setDouble(6, buku.getOrisinalitas());
            statment.setDouble(7, buku.getRating());
            
            statment.executeUpdate();
            statment.close();

        }
        catch(SQLException e){
            System.out.println("Input Failed: " + e.getLocalizedMessage());
        }
        
    }
    
     @Override
    public void update(ModelBuku buku) {
        try{
            String query = "UPDATE buku SET Judul= ?, Penulis=?, Tahun=?, Alur=?, Tata_Bahasa=?, Orisinalitas=?, Rating=? WHERE id=?";
            
            
            PreparedStatement statment;
            statment = Connector.connect().prepareStatement(query);
            statment.setString(1, buku.getJudul());
            statment.setString(2, buku.getPenulis());
            statment.setInt(3, buku.getTahun());
            statment.setDouble(4, buku.getAlur());
            statment.setDouble(5, buku.getBahasa());
            statment.setDouble(6, buku.getOrisinalitas());
            statment.setDouble(7, buku.getRating());
            statment.setInt(8,buku.getId());
            
            statment.executeUpdate();
            statment.close();

        }
        catch(SQLException e){
            System.out.println("Update Failed: " + e.getLocalizedMessage());
        }
        
    }

   

    @Override
    public void delete(int id) {
        try{
            String query = "DELETE FROM buku WHERE id=?";

            PreparedStatement statment;
            statment = Connector.connect().prepareStatement(query);
            statment.setInt(1, id);
            
            statment.executeUpdate();
            statment.close();

        }
        catch(SQLException e){
            System.out.println("Delete Failed: " + e.getLocalizedMessage());
        }
        
    }

    @Override
    public List<ModelBuku> getAll() {
        List<ModelBuku> listBuku = null;
        
        try{
            listBuku = new ArrayList<>();
            Statement statement = Connector.connect().createStatement();
            
            String query = "SELECT * FROM BUKU";
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                ModelBuku book = new ModelBuku();
                book.setId(resultSet.getInt("id"));
                book.setTahun(resultSet.getInt("Tahun"));
                book.setJudul(resultSet.getString("Judul"));
                book.setPenulis(resultSet.getString("Penulis"));
                book.setAlur(resultSet.getDouble("Alur"));
                book.setBahasa(resultSet.getDouble("Tata_Bahasa"));
                book.setOrisinalitas(resultSet.getDouble("Orisinalitas"));
                book.setRating(resultSet.getDouble("Rating"));
                
                listBuku.add(book);
            }
            statement.close();

            
        }
        catch(SQLException e){
            System.out.println("failed fetch data:" + e.getLocalizedMessage());
        }
        return listBuku;
    }
}
