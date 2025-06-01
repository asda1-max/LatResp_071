/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Buku;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rakha
 */
public class ModelTable extends AbstractTableModel{
    
    List<ModelBuku> daftarBuku;
    
    String kolom[] = {"id", "Judul", "Penulis", "Tahun", "Alur", "Bahasa", "Orisinalitas", "Rating"};
    
    public ModelTable(List<ModelBuku> daftarBuku){
        this.daftarBuku = daftarBuku;
    }

    @Override
    public int getRowCount() {
        return daftarBuku.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return daftarBuku.get(rowIndex).getId();
            case 1:
                return daftarBuku.get(rowIndex).getJudul();
            case 2:
                return daftarBuku.get(rowIndex).getPenulis();
            case 3:
                return daftarBuku.get(rowIndex).getTahun();
            case 4:
                return daftarBuku.get(rowIndex).getAlur();
            case 5:
                return daftarBuku.get(rowIndex).getBahasa();
            case 6:
                return daftarBuku.get(rowIndex).getOrisinalitas();
            case 7:
                return daftarBuku.get(rowIndex).getRating();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return kolom[columnIndex];
    }
}
