/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Remove;

import java.io.Serializable;
import projeksd.Buku;




/**
 *
 * @author admin
 */
public class lisNode implements Serializable{
  private Buku data;
  lisNode Kanan, preve;

    public lisNode() {
    }

  public lisNode(Buku data){
    this.data=data;  
  }
  
    public Buku getData() {
        return data;
    }

    public void setData(Buku data) {
        this.data = data;
    }

    public lisNode getKanan() {
        return Kanan;
    }

    public void setKanan(lisNode Kanan) {
        this.Kanan = Kanan;
    }

    public lisNode getPreve() {
        return preve;
    }

    public void setPreve(lisNode preve) {
        this.preve = preve;
    }
    
}
