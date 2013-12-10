/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeksd;

import Remove.linkList;
import Remove.lisNode;
import javax.swing.*;
import java.awt.ActiveEvent.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jay
 */
public class SercingGui extends JFrame {

    private JLabel lebelKosong, titikjmlh, totalBuku, JudulBukuLebel, 
            kodeBukuLebel, PengerangBukuLebel, titik1, titik2, titik3;
    private JTextField judulText, kodeText, pengarangText;
    private JPanel layaout1, layaout2;
    private JButton Sercing, Reset, CariJudul, cariPengarang;
    Container ContentPane;
    linkList linklist = new linkList();
    inputData input = new inputData();
    lisNode hasil;

    public SercingGui() {
        setTitle("Sercing Buku");
        setLocation(100, 100);
        setSize(500, 300);
        linklist = read();

        ContentPane = getContentPane();
        ContentPane.setLayout(new FlowLayout());
        layaout1 = new JPanel();
        layaout1.setLayout(new GridLayout(4, 4, 10, 15));
        layaout2 = new JPanel();
        layaout2.setLayout(new GridLayout(2, 2, 10, 10));
        ContentPane.add(layaout1);
        ContentPane.add(layaout2);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu1 = new JMenu("file");
        JMenu fileMenu2 = new JMenu("View");
        JMenu fileMenu = new JMenu("Edit");
        this.setJMenuBar(menuBar);
        menuBar.add(fileMenu1);
        menuBar.add(fileMenu);
        menuBar.add(fileMenu2);

        totalBuku = new JLabel(" Daftar Pencarian Buku ");
        layaout1.add(totalBuku);
        titikjmlh = new JLabel();
        layaout1.add(titikjmlh);
        lebelKosong = new JLabel();
        layaout1.add(lebelKosong);

        JudulBukuLebel = new JLabel("Judul Buku");
        layaout1.add(JudulBukuLebel);
        titik1 = new JLabel(":");
        layaout1.add(titik1);
        judulText = new JTextField(5);
        layaout1.add(judulText);


        kodeBukuLebel = new JLabel("Kode buku");
        layaout1.add(kodeBukuLebel);
        titik2 = new JLabel(":");
        layaout1.add(titik2);
        kodeText = new JTextField(5);
        layaout1.add(kodeText);


        PengerangBukuLebel = new JLabel("Pengarang buku");
        layaout1.add(PengerangBukuLebel);
        titik3 = new JLabel(":");
        layaout1.add(titik3);
        pengarangText = new JTextField(5);
        layaout1.add(pengarangText);

        Reset = new JButton("Reset");
        layaout2.add(Reset);
        Reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                judulText.setText("");
                kodeText.setText("");
                pengarangText.setText("");
            }
        });

        CariJudul = new JButton("Cari Judul");
        layaout2.add(CariJudul);
        CariJudul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                linkList temp = read();
                lisNode hasil = temp.searchJudul(judulText.getText());
                if (hasil != null) {
                    judulText.setText(hasil.getData().getJudulBuku());
                    kodeText.setText(hasil.getData().getKodeBuku() + "");
                    pengarangText.setText(hasil.getData().getPengarangBuku());
                } else {
                    JOptionPane.showMessageDialog(Reset, "Buku yang anda cari tidak ada!!");
                }
            }
        });


        cariPengarang = new JButton("Cari Pengarang");
        layaout2.add(cariPengarang);
        cariPengarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                linkList temp = read();
                lisNode hasil = temp.searchPengarang(pengarangText.getText());
                if (hasil != null) {
                    judulText.setText(hasil.getData().getJudulBuku());
                    kodeText.setText(hasil.getData().getKodeBuku() + "");
                    pengarangText.setText(hasil.getData().getPengarangBuku());
                } else {
                    JOptionPane.showMessageDialog(Reset, "Buku yang anda cari tidak ada!!");
                }
            }
        });
        JButton save = new JButton("save");
        layaout2.add(save);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    hasil.getData().setJudulBuku(judulText.getText());
                    hasil.getData().setKodeBuku(Integer.parseInt(kodeText.getText()));
                    hasil.getData().setPengarangBuku(pengarangText.getText());
                    SortingGui.save(linklist);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(SercingGui.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(SercingGui.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Sercing = new JButton("Cari Kode");
        layaout2.add(Sercing);
        Sercing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int tam = Integer.parseInt(kodeText.getText());

                hasil = linklist.searchKode(tam);
                if (hasil != null) {
                    judulText.setText(hasil.getData().getJudulBuku());
                    kodeText.setText(hasil.getData().getKodeBuku() + "");
                    pengarangText.setText(hasil.getData().getPengarangBuku());

                } else {
                    JOptionPane.showMessageDialog(Reset, "Buku yang anda cari tidak ada!!");
                }

            }
        });
    }

    public static linkList read() {
        linkList bantu = new linkList();
        try {
            FileInputStream fis = new FileInputStream(new File("DaftarFileBuku.txt"));
            ObjectInputStream ois = new ObjectInputStream(fis);
            try {
                bantu = (linkList) ois.readObject();
     
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SercingGui.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(SercingGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bantu;
    }
}
