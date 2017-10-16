/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SerializationTT;

import Serialization.SinhVien;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vutuancong
 */
public class SinhVienDAO {

    boolean addSinhVien(SinhVien sv) {
        ArrayList<SinhVien> allSinhVien = getAllSinhVien();
        if (allSinhVien == null) {
            allSinhVien = new ArrayList<>();
        }
        allSinhVien.add(sv);
        return saveToFile(allSinhVien);
    }

    ArrayList<SinhVien> getAllSinhVien() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SinhVien.dat"));
            ArrayList<SinhVien> list = (ArrayList<SinhVien>) ois.readObject();
            ois.close();
            return list;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean saveToFile(ArrayList<SinhVien> allSinhVien) {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SinhVien.dat"));
            oos.writeObject(allSinhVien);
            oos.close();
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    ArrayList<SinhVien> sortByAge() {
        ArrayList<SinhVien> list = getAllSinhVien();
        if (list != null) {
            Collections.sort(list, new Comparator<SinhVien>() {
                @Override
                public int compare(SinhVien t, SinhVien t1) {
                    if (t.getTuoi() < t1.getTuoi()) {
                        return -1;
                    } else if (t.getTuoi() > t1.getTuoi()) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            });
        }
        return list;
    }

    public boolean removeByMaSV(int msv) {
        ArrayList<SinhVien> list = getAllSinhVien();
        Iterator<SinhVien> itr = list.iterator();
        while (itr.hasNext()) {
            if(itr.next().getMa() == msv){
                itr.remove();
            };
        }
        return saveToFile(list);
    }
}
