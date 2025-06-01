/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Buku;

/**
 *
 * @author Rakha
 */
public class ModelBuku {
    private Integer id,tahun;
    private String judul, penulis;
    private double alur, bahasa, orisinalitas, rating;
    
    
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public Integer getTahun(){
        return tahun;
    }
    public void setTahun(Integer tahun){
        this.tahun = tahun;
    }
    public String getJudul(){
        return judul;
    }
    public void setJudul(String judul){
        this.judul = judul;
    }
    public String getPenulis(){
        return penulis;
    }
    public void setPenulis(String penulis){
        this.penulis = penulis;
    }
    public double getAlur(){
        return alur;
    }
    public void setAlur(double alur){
        this.alur = alur;
    }
    public double getBahasa(){
        return bahasa;
    }
    public void setBahasa(double bahasa){
        this.bahasa = bahasa;
    }
    public double getOrisinalitas(){
        return orisinalitas;
    }
    public void setOrisinalitas(double orisinalitas){
        this.orisinalitas = orisinalitas;
    }
    public double getRating(){
        return rating;
    }
    public void setRating(double rating){
        this.rating = rating;
    }
    
    
}
