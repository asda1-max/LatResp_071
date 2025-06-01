package Controller;

import Model.Buku.*;
import View.Buku.View;
import java.util.List;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author rakha
 */

public class ControllerBuku {

    private View view;
    private InterfaceDAO dao;
    private List<ModelBuku> daftarBuku;

    public ControllerBuku(View view) {
        this.view = view;
        this.dao = new DAOBuku();

        loadTable();

        // Tombol Add
        view.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertBuku();
            }
        });

        // Tombol Clear
        view.getClearButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.clearFields();
            }
        });

        // Tombol Delete
        view.getDeleteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBuku();
            }
        });

        view.getUpdateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBuku();
            }
        });
        view.getTable().addMouseListener(new java.awt.event.MouseAdapter() {
            // ModelBuku buku = new ModelBuku();
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = view.getTable().getSelectedRow();
                if (row != -1) {
                    view.setJudul(view.getTable().getValueAt(row, 1).toString());
                    view.setPenulis(view.getTable().getValueAt(row, 2).toString());
                    view.setTahun(view.getTable().getValueAt(row, 3).toString());
                    view.setAlur(view.getTable().getValueAt(row, 4).toString());
                    view.setGaya(view.getTable().getValueAt(row, 5).toString());
                    view.setOrisinalitas(view.getTable().getValueAt(row, 6).toString());
                }
            }
        });
        
    }
    

    private void loadTable() {
        daftarBuku = dao.getAll();
        ModelTable modelTable = new ModelTable(daftarBuku);
        view.getTable().setModel(modelTable);
    }

private void updateBuku() {
    int confirm = JOptionPane.showConfirmDialog(
        view,
        "Apakah Anda yakin ingin mengupdate data ini?",
        "Konfirmasi Update",
        JOptionPane.YES_NO_OPTION
    );

    if(confirm==JOptionPane.YES_OPTION)
    {
            int selectedRow = view.getTable().getSelectedRow();
            if (selectedRow != -1) {
                try {
                    int id = (int) view.getTable().getValueAt(selectedRow, 0); // ambil id dari tabel

                    ModelBuku buku = new ModelBuku();
                    buku.setId(id); // penting!
                    buku.setJudul(view.getJudul());
                    buku.setPenulis(view.getPenulis());
                    buku.setTahun(Integer.parseInt(view.getTahun()));
                    buku.setAlur(Double.parseDouble(view.getAlur()));
                    buku.setBahasa(Double.parseDouble(view.getGaya()));
                    buku.setOrisinalitas(Double.parseDouble(view.getOrisinalitas()));

                    double rating = (buku.getAlur() + buku.getBahasa() + buku.getOrisinalitas()) / 3;
                    buku.setRating(rating);

                    dao.update(buku); // pastikan method ini ada di DAOBuku
                    loadTable();
                    view.clearFields();
                    System.out.println("Update berhasil!");
                } catch (NumberFormatException e) {
                    System.out.println("Format angka salah: " + e.getMessage());
                }
            } else {
                System.out.println("Pilih baris di tabel dulu buat update.");
            }
        }
    }

    private void insertBuku() {
        

        try {
            ModelBuku buku = new ModelBuku();
            buku.setJudul(view.getJudul());
            buku.setPenulis(view.getPenulis());
            buku.setTahun(Integer.parseInt(view.getTahun())); // Pastikan di View tahun dikembalikan String, jadi
                                                              // parseInt dibutuhkan
            buku.setAlur(Double.parseDouble(view.getAlur()));
            buku.setBahasa(Double.parseDouble(view.getGaya()));
            buku.setOrisinalitas(Double.parseDouble(view.getOrisinalitas()));
            double alurValue = Double.parseDouble(view.getAlur());
            double bahasaValue = Double.parseDouble(view.getGaya());
            double orisinalitasValue = Double.parseDouble(view.getOrisinalitas());
            double ratingValue = (alurValue + bahasaValue + orisinalitasValue)/3;
             buku.setRating(ratingValue);

            dao.insert(buku);
            loadTable();
            view.clearFields();
        } catch (NumberFormatException ex) {
            System.out.println("Format input salah: " + ex.getMessage());
        }
    }

    private void deleteBuku() {
        int confirm = JOptionPane.showConfirmDialog(
        view,
        "Apakah Anda yakin ingin menghapus data ini?",
        "Konfirmasi Update",
        JOptionPane.YES_NO_OPTION
        );
        if (confirm == JOptionPane.YES_OPTION) {
            


        int row = view.getTable().getSelectedRow();
        if (row != -1) {
            int id = (int) view.getTable().getValueAt(row, 0); // Kolom id pasti index 0
            dao.delete(id);
            loadTable();
        } else {
            System.out.println("Pilih baris terlebih dahulu");
        }
        }
    }

}
