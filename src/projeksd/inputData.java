/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeksd;

import Remove.linkList;
import Remove.lisNode;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author jay
 */
public class inputData {

    public static String selectionSorting(linkList data) {
        Buku tampung;
        String tampungString = "";
        for (int i = 0; i <= data.getSize() - 2; i++) {
            int minIndexs = i;
            for (int j = i + 1; j <= data.getSize() - 1; j++) {
                if (((Buku) data.get(j).getData()).compareTo(data.get(minIndexs).getData()) < 1) {
                    minIndexs = j;
                }
            }
            tampung = data.get(i).getData();
            data.get(i).setData(data.get(minIndexs).getData());
            data.get(minIndexs).setData(tampung);
        }
        for (int j = 0; j < data.getSize(); j++) {
            System.out.println("");
            System.out.println("Judul Buku :" + ((Buku) data.get(j).getData()).getJudulBuku() + " ");
            System.out.println("Kode Buku :" + ((Buku) data.get(j).getData()).getKodeBuku() + " ");
            System.out.println("Pengarang Buku :" + ((Buku) data.get(j).getData()).getPengarangBuku() + " ");

            tampungString = tampungString + "\nJudul Buku :" + ((Buku) data.get(j).getData()).getJudulBuku()
                    + "\nKode Buku :" + ((Buku) data.get(j).getData()).getKodeBuku()
                    + "\nPengarang Buku :" + ((Buku) data.get(j).getData()).getPengarangBuku();
        }
        System.out.println(" ");
        return tampungString;
    }

}
