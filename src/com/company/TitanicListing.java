package com.company;

import com.company.models.Passenger;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.List;

public class TitanicListing extends JFrame {


    public TitanicListing() {

        String[] columns = new String[]{
                "Name", "Gender", "Age"
        };

        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columns);

        JTable table = new JTable(model);

        TitanicQueries tq = new TitanicQueries();
        List<Passenger> passengers =  tq.getPassengersByNameAndGender("Mary", "female");

        for(Passenger p : passengers) {

            model.addRow(new Object[]{p.name, p.gender, p.age});
        }




        this.add(new JScrollPane(table));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.BLACK);
        this.pack();
        this.setVisible(true);


    }


}
