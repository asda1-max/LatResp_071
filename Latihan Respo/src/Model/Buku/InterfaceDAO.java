/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Model.Buku;
import java.util.List;

/**
 *
 * @author Rakha
 */


public interface InterfaceDAO {
    
    public void insert(ModelBuku buku);
    public void update(ModelBuku buku);
    public void delete(int id);
    public List<ModelBuku> getAll();
    
}
