/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projeksd;

import Remove.linkList;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class guiUtama extends JFrame {

    Container ContentPane;
    JPanel jp2 = new JPanel();
    private static final int lebar = 300;
    private static final int tinggi = 150;
    private static final int kordinatX = 150;
    private static final int kordinatY = 250;
    private linkList database;

    public linkList getDatabase() {
        return database;
    }

    public guiUtama() {
        setTitle("Aplikasi Perpustakaan");
        setSize(lebar, tinggi);
        setResizable(false);
        setLocation(kordinatX, kordinatY);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu1 = new JMenu("File");


        JMenuItem item4 = new JMenuItem("New");
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panelSorting();
                panelSercing();

            }
        });
        JMenuItem item5 = new JMenuItem("Simpan");

        JMenuItem item6 = new JMenuItem("Print");
        JMenuItem item7 = new JMenuItem("Loat");

        menuBar.add(fileMenu1);
        fileMenu1.add(item4);
        fileMenu1.add(item5);
        fileMenu1.add(item6);
        fileMenu1.add(item7);
//        item7.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                database = SercingGui.read();
//            }
//        });

        JMenu fileMenu2 = new JMenu("View");
        JMenu fileMenu = new JMenu("Edit");

        JMenuItem item1 = new JMenuItem("Input Data Buku");
        JMenuItem item2 = new JMenuItem("Pencarian Buku");
        JMenu Menu = new JMenu("Help");
        JMenuItem item3 = new JMenuItem("Pembuat projek");
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(null, "Nama : Stephanus Wijaya Nata Kusuma "
                        + "\nNim : 1253141315");
            }
        });

        this.setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        fileMenu.add(item1);
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panelSorting();
            }
        });
        fileMenu.add(item2);
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                panelSercing();
            }
        });

        this.setJMenuBar(menuBar);
        menuBar.add(fileMenu2);
        menuBar.add(Menu);
        Menu.add(item3);

        ContentPane = getContentPane();
        ContentPane.setLayout(new FlowLayout());
        jp2.setLayout(new GridLayout(2, 2, 10, 10));

        ContentPane.add(jp2);
        JButton inputBuku = new JButton("  Input Buku  ");
        jp2.add(inputBuku);
        inputBuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                SortingGui sorting = new SortingGui();
                sorting.setVisible(true);
            }
        });
        JButton Sercing = new JButton("  Pencarian Buku  ");
        jp2.add(Sercing);
        Sercing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                SercingGui Sercing = new SercingGui();
                Sercing.setVisible(true);
            }
        });

        JButton tampil = new JButton("  tampil  ");
        jp2.add(tampil);
        tampil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                Vector vec = new Vector();
                linkList listdata = SercingGui.read();
                for (int i = 0; i < listdata.getSize(); i++) {
                    vec.add("* Judul Buku : " + listdata.get(i).getData().getJudulBuku() + " *  "
                            + "Kode Buku : " + listdata.get(i).getData().getKodeBuku() + " *  "
                            + "Pengarang Buku : " + listdata.get(i).getData().getPengarangBuku());
                }
                JList list = new JList(vec);

                JDialog jd = new JDialog();
                jd.setSize(500, 500);
                jd.add(list);
                jd.setVisible(true);
            }
        });

    }

    public void panelSercing() {
        SercingGui Sercing = new SercingGui();
        Sercing.setVisible(true);
    }

    public void panelSorting() {
        SortingGui sorting = new SortingGui();
        sorting.setVisible(true);
    }
}
