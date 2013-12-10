/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeksd;

import Remove.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.*;
import javax.swing.event.*;

/**
 *
 * @author jay
 */
public class SortingGui extends JFrame {

    private JButton enter, Reset, sorting, tambahBuku,
            tambahPertama, tambahTerakhir, removeFirst, removeLast;
    private JDialog dialogJudul, dialogKode, dialogPengarang;
    JPanel layaout1, layaout2;
    JTextField textjumlh, textJudul, textKode, textPengarang;
    private JLabel lebelKosong, titikjmlh, totalBuku, masukanJudul,
            masukanKode, masukanPengarang, titikJudul, titikPengarang, titikKode;
    Container ContentPane;
    static linkList linklist = new linkList();
    String bantuSave = "";
    Buku buku = new Buku();

    public SortingGui() {
        linklist = SercingGui.read();
        setTitle("Inputan buku yang akan di sorting");
        setSize(450, 350);
        ContentPane = getContentPane();
        ContentPane.setLayout(new FlowLayout());
        layaout1 = new JPanel();
        layaout1.setLayout(new GridLayout(4, 1, 10, 20));
        layaout2 = new JPanel();
        layaout2.setLayout(new GridLayout(3, 6, 10, 10));
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

        totalBuku = new JLabel(" Daftar Buku ");
        layaout1.add(totalBuku);
        titikjmlh = new JLabel();
        layaout1.add(titikjmlh);
        lebelKosong = new JLabel();
        layaout1.add(lebelKosong);


        masukanJudul = new JLabel("Judul Buku ");
        layaout1.add(masukanJudul);
        titikJudul = new JLabel(":");
        layaout1.add(titikJudul);
        textJudul = new JTextField(10);
        layaout1.add(textJudul);


        masukanKode = new JLabel("Kode Buku ");
        layaout1.add(masukanKode);
        titikKode = new JLabel(":");
        layaout1.add(titikKode);
        textKode = new JTextField(5);
        layaout1.add(textKode);

        masukanPengarang = new JLabel("Pengarang Buku ");
        layaout1.add(masukanPengarang);
        titikPengarang = new JLabel(":");
        layaout1.add(titikPengarang);
        textPengarang = new JTextField(5);
        layaout1.add(textPengarang);

//        enter = new JButton("enter");
//        layaout2.add(enter);
//        enter.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                if (linklist.isEmpty()) {
//                    buku = new Buku();
//                    buku.setJudulBuku(textJudul.getText());
//                    buku.setKodeBuku(Integer.parseInt(textKode.getText()));
//                    buku.setPengarangBuku(textPengarang.getText());
//                    linklist.addPertama(buku);
//                    tampilEnter((Buku) linklist.getPertama().getData());
//                } else {
//                    try {
//                        buku = new Buku();
//                        buku.setJudulBuku(textJudul.getText());
//                        buku.setKodeBuku(Integer.parseInt(textKode.getText()));
//                        buku.setPengarangBuku(textPengarang.getText());
//                        linklist.addTerakhir(buku);
//                        tampilEnter((Buku) linklist.getTerakhir().getData());
//                    } catch (ArrayIndexOutOfBoundsException e) {
//                        System.err.println("data salah");
//                    }
//                }
//
//            }
//        });

        Reset = new JButton("Reset");
        layaout2.add(Reset);
        Reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                textJudul.setText(" ");
                textKode.setText("");
                textPengarang.setText(" ");
            }
        });

        sorting = new JButton("sorting");
        layaout2.add(sorting);
        sorting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Data Buku yang sudah di sorting Berdasarkan kode buku");
                sortingdata();
            }
        });
        tambahBuku = new JButton("Save");
        layaout2.add(tambahBuku);
        tambahBuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    SortingGui.save(linklist);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(SortingGui.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(SortingGui.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        tambahPertama = new JButton("addFirst");
        layaout2.add(tambahPertama);
        tambahPertama.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Data sudah di inputkan di urutan Pertama");
                buku = new Buku();
                buku.setJudulBuku(textJudul.getText());
                buku.setKodeBuku(Integer.parseInt(textKode.getText()));
                buku.setPengarangBuku(textPengarang.getText());
                linklist.addPertama(buku);
                tampilEnter((Buku) linklist.getPertama().getData());
            }
        });
        tambahTerakhir = new JButton("addLast");
        layaout2.add(tambahTerakhir);
        tambahTerakhir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Data sudah di inputkan di urutan rakhir");
                buku = new Buku();
                buku.setJudulBuku(textJudul.getText());
                buku.setKodeBuku(Integer.parseInt(textKode.getText()));
                buku.setPengarangBuku(textPengarang.getText());
                linklist.addTerakhir(buku);
                tampilEnter((Buku) linklist.getTerakhir().getData());

            }
        });
        removeFirst = new JButton("Remove First");
        layaout2.add(removeFirst);
        removeFirst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Data sudah di Hapus yang urutan Pertama");
                linklist.removeFirst();
                tampilEnter((Buku) linklist.getTerakhir().getData());
            }
        });

        removeLast = new JButton("Remove Last");
        layaout2.add(removeLast);
        removeLast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Data sudah di Hapus yang urutan terakhir");
                linklist.removelast();
                tampilEnter((Buku) linklist.getTerakhir().getData());
            }
        });

    }

    public static void save(linkList linklist) throws FileNotFoundException, IOException {
        File outFile = new File("DaftarFileBuku.txt");
        OutputStream outFileStream = new FileOutputStream(outFile);
        ObjectOutputStream outObjectStream = new ObjectOutputStream(outFileStream);
        outObjectStream.writeObject(linklist);

        JOptionPane.showMessageDialog(null, "Data sudah disipan didalam file Daftar file buku");
    }

    public void tampilEnter(Buku buku) {
        linklist.cetak();
    }

    public void sortingdata() {
        bantuSave = inputData.selectionSorting(linklist);
    }

    public static linkList getLinkList() {
        return linklist;
    }
}
