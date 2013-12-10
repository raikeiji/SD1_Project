/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeksd;

import java.io.Serializable;

/**
 *
 * @author hp
 */
public class Buku implements Comparable, Serializable{
    private int kodeBuku;
    private String judulBuku, PengarangBuku;
    
    public int getKodeBuku() {
        return kodeBuku;
    }

    public void setKodeBuku(int kodeBuku) {
        this.kodeBuku = kodeBuku;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public String getPengarangBuku() {
        return PengarangBuku;
    }

    public void setPengarangBuku(String PengarangBuku) {
        this.PengarangBuku = PengarangBuku;
    }
     
    @Override
    public int compareTo(Object o) {
        if (getKodeBuku()== ((Buku) o).getKodeBuku()) {
            return 0;
        } else if (getKodeBuku()< ((Buku) o).getKodeBuku()) {
            return -1;
        } else {
            return 1;
        }
      
    }
    
    
}
    
