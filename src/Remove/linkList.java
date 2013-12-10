/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Remove;

import java.io.Serializable;
import java.util.Comparator;
import java.util.NoSuchElementException;
import projeksd.Buku;

/**
 *
 * @author admin
 */
public class linkList implements Serializable {

    lisNode head;
    private int size;

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public lisNode searchKode(int kode) {
        for (lisNode i = head.Kanan; i != head; i = i.Kanan) {
            if (i.getData().getKodeBuku() == kode) {
                return i;
            }
        }
        return null;
    }

    public lisNode searchJudul(String judul) {
        for (lisNode i = head.Kanan; i != head; i = i.Kanan) {
            if (judul.equals(i.getData().getJudulBuku())) {
                return i;
            }
        }
        return null;
    }

    public lisNode searchPengarang(String pengarang) {
        for (lisNode i = head.Kanan; i != head; i = i.Kanan) {
            if (pengarang.equals(i.getData().getPengarangBuku())) {
                return i;
            }
        }
        return null;
    }

    public linkList() {
        head = new lisNode();
        head.Kanan = head;
        head.preve = head;
        size = 0;

    }

    public void addPertama(Buku data) {
        addBefore(data, head.Kanan);
        setSize(getSize() + 1);

    }

    public Buku removeFirst() {
        return remove(head.Kanan);
    }

    public void addTerakhir(Buku data) {

        addBefore(data, head);

        setSize(getSize() + 1);
    }

    public Buku removelast() {
        return remove(head.preve);
    }

    public lisNode addBefore(Buku x, lisNode bantu) {

        lisNode baru = new lisNode(x);
        baru.Kanan = bantu;
        baru.preve = bantu.preve;
        bantu.preve.Kanan = baru;
        bantu.preve = baru;
        return baru;

    }

    public Buku remove(lisNode bantu) {
        if (!isEmpty()) {
            bantu.preve.Kanan = bantu.Kanan;
            bantu.Kanan.preve = bantu.preve;
            bantu.preve = null;
            bantu.Kanan = null;
            setSize(getSize() - 1);

        }

        return bantu.getData();
    }

    public void cetak() {
        lisNode bantu;
        bantu = head.Kanan;
        while (bantu != head) {
            System.out.println("");
            System.out.println("Judul Buku :" + bantu.getData().getJudulBuku() + " ");
            System.out.println("Kode Buku :" + bantu.getData().getKodeBuku() + " ");
            System.out.println("Pengarang Buku :" + bantu.getData().getPengarangBuku() + " ");
            bantu = bantu.getKanan();
        }
        System.out.println("");
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public lisNode get(int i) {
        if (i == 0) {
            return head.Kanan;
        } else if (i == getSize() - 1) {
            return head.preve;
        } else {
            lisNode temp = head.Kanan.Kanan;
            for (int j = 1; j < i; j++) {
                temp = temp.Kanan;
                if (j == i) {
                    break;
                }
            }
            return temp;
        }

    }

    public lisNode getPertama() {
        return head.Kanan;
    }

    public lisNode getHead() {
        return head;
    }

    public lisNode getTerakhir() {
        return head.preve;
    }
}
