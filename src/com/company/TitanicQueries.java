package com.company;

import com.company.models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TitanicQueries {
    final String DB_DATABASE = "titanicmanifest";
    final String DB_URL = "jdbc:mysql://localhost:3306/titanicmanifest";
    final String DB_USER = "MicheleSousa";
    final String DB_PASSWORD = "Rkd813518#";


    private PreparedStatement getPeopleByName;
    private PreparedStatement getPeopleByAge;
    private PreparedStatement getPeopleByGender;
    private PreparedStatement getPeopleByNameAndGender;

    public TitanicQueries() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);


            String sqlQueryName = "select name, age, gender from titanic WHERE name like ?";
            getPeopleByName = con.prepareStatement(sqlQueryName);


            String sqlQueryAge = "select name, age, gender from titanic WHERE age like ?";
            getPeopleByAge = con.prepareStatement(sqlQueryAge);


            String sqlQueryGender = "select name, age, gender from titanic WHERE gender like ?";
            getPeopleByGender = con.prepareStatement(sqlQueryGender);

            String sqlQueryNameAndGender = "select name, age, gender from titanic WHERE name like ? AND gender like ?";
            getPeopleByNameAndGender = con.prepareStatement(sqlQueryNameAndGender);


        } catch (SQLException e) {

        } catch (Exception e) {

        }

    }

    public List<Passenger> getPassengersByName(String name) {
        ResultSet resultSet = null;
        List<Passenger> results = null;
        try {
            getPeopleByName.setString(1, "%" + name + "%");

            resultSet = getPeopleByName.executeQuery();

            results = new ArrayList<Passenger>();

            while (resultSet.next()) {
                Passenger newPassenger = new Passenger();
                newPassenger.name = resultSet.getString("name");
                newPassenger.gender = resultSet.getString("gender");
                newPassenger.age = resultSet.getInt("age");
                results.add(newPassenger);

            }


        } catch (SQLException e) {

        } catch (Exception e) {

        }

        return results;
    }


    public List<Passenger> getPassengersByAge(String age) {
        ResultSet resultSet = null;
        List<Passenger> results = null;
        try {
            getPeopleByAge.setString(1, "%" + age + "%");

            resultSet = getPeopleByAge.executeQuery();

            results = new ArrayList<Passenger>();

            while (resultSet.next()) {
                Passenger newPassenger = new Passenger();
                newPassenger.name = resultSet.getString("name");
                newPassenger.gender = resultSet.getString("gender");
                newPassenger.age = resultSet.getInt("age");
                results.add(newPassenger);


            }


        } catch (SQLException e) {

        } catch (Exception e) {

        }

        return results;

    }

        public List<Passenger> getPassengersByGender (String gender){
            ResultSet resultSet = null;
            List<Passenger> results = null;
            try {
                getPeopleByGender.setString(1, "%" + gender + "%");

                resultSet = getPeopleByGender.executeQuery();

                results = new ArrayList<Passenger>();

                while (resultSet.next()) {
                    Passenger newPassenger = new Passenger();
                    newPassenger.name = resultSet.getString("name");
                    newPassenger.gender = resultSet.getString("gender");
                    newPassenger.age = resultSet.getInt("age");
                    results.add(newPassenger);


                }


            } catch (SQLException e) {

            } catch (Exception e) {

            }

            return results;

        }

    public List<Passenger> getPassengersByNameAndGender (String name, String gender){
        ResultSet resultSet = null;
        List<Passenger> results = null;

        try {
            getPeopleByNameAndGender.setString(1, "%" + name + "%");
            getPeopleByNameAndGender.setString(2, "%" + gender + "%");

            resultSet = getPeopleByNameAndGender.executeQuery();

            results = new ArrayList<Passenger>();

            while (resultSet.next()) {
                Passenger newPassenger = new Passenger();
                newPassenger.name = resultSet.getString("name");
                newPassenger.gender = resultSet.getString("gender");
                newPassenger.age = resultSet.getInt("age");
                results.add(newPassenger);


            }


        } catch (SQLException e) {

        } catch (Exception e) {

        }

        return results;


        }
    }
