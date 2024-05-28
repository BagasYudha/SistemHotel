/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package master;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author Asus
 */
public class koneksi {
    public static Connection connectionmysql;

    public static Connection ConnectionDB() {
        if (connectionmysql == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/db_hotel";
                String user = "root";
                String pass = "";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                connectionmysql = DriverManager.getConnection(url, user, pass);
//                JOptionPane.showConfirmDialog(null, "Koneksi Sukses!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Koneksi Gagal! Error: " + e.getMessage());
            }
        }
        return connectionmysql;
    }
}
