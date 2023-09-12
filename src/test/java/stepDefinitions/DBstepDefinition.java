package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.ConfigReader;
import utilities.JDBCReusableMethods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class DBstepDefinition {

    Statement statement ;
    ResultSet resultSet;

    @Given("Database baglantisi kurulur.")
    public void database_baglantisi_kurulur() {

        JDBCReusableMethods.getConnection();
        statement = JDBCReusableMethods.getStatement();

    }
    @Given("Query hazirlanir ve calistirilir.")
    public void query_hazirlanir_ve_calistirilir() throws SQLException {

        String query = "SELECT COUNT(*) FROM wonderworld_qa2.chat_users WHERE create_staff_id = 1";

        resultSet = statement.executeQuery(query);

    }
    @Given("Query sonuclari dogrulanir.")
    public void query_sonuclari_dogrulanir() throws SQLException {

        resultSet.next();
        int expectedData = 11;
        int actualData = resultSet.getInt(1);

        assertEquals(expectedData,actualData);

    }
    @Given("Database baglantisi kapatilir.")
    public void database_baglantisi_kapatilir() {

        JDBCReusableMethods.closeConnection();

    }
    @Given("class_sections tablosundaki test icin query hazirlanir ve calistirilir.")
    public void class_sections_tablosundaki_test_icin_query_hazirlanir_ve_calistirilir() throws SQLException {

        String query = ConfigReader.getProperty("query02");

        resultSet = statement.executeQuery(query);

    }
    @Given("class_sections tablosundaki liste yazdirilir.")
    public void class_sections_tablosundaki_query_sonuclari_dogrulanir() throws SQLException {

        while (resultSet.next()){
            System.out.println(resultSet.getInt(1));
        }

    }
}
