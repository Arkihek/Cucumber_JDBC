package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.ConfigReader;
import utilities.DB_utils;
import utilities.JDBCReusableMethods;
import utilities.QueryManage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class DBstepDefinition {

    Statement statement ;
    ResultSet resultSet;
    QueryManage queryManage = new QueryManage();

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

    @Given("Student tablosu icin query hazirlanir")
    public void student_tablosu_icin_query_hazirlanir() throws SQLException {

        String sql = queryManage.getQuery05();

        resultSet = statement.executeQuery(sql);

    }
    @Given("student tablosundan donen sonuclari listeleyiniz")
    public void student_tablosundan_donen_sonuclari_listeleyiniz() throws SQLException {
        while (resultSet.next()){
            System.out.println("Mother Name : "+resultSet.getString(1) + "        Mother Occopation : " + resultSet.getString(2));
        }
    }
    @Given("Update query`si hazirlanip calistirilir")
    public void update_query_si_hazirlanip_calistirilir() {
        DB_utils.updatePrepared(ConfigReader.getProperty("query06"),ConfigReader.getProperty("updateName"),ConfigReader.getProperty("updateID"));
    }
    @Given("Update isleminin yapildigi dogrulanir")
    public void update_isleminin_yapildigi_dogrulanir() {

    }

    @Given("Kayit ekleme query`si hazirlanir ve calistirilir.")
    public void kayit_ekleme_query_si_hazirlanir_ve_calistirilir() throws SQLException {

        String addQuery = ConfigReader.getProperty("query07");

        int rowAffected = statement.executeUpdate(addQuery);

        Assert.assertTrue(rowAffected>0);

    }
    @Given("Yeni kayit eklendigi dogrulanir.")
    public void yeni_kayit_eklendigi_dogrulanir() {
    }
    @Given("Delete query`si hazirlanir ve calistirilir")
    public void delete_query_si_hazirlanir_ve_calistirilir() throws SQLException {
        String deleteQuery = queryManage.getQuery08();

        int deleteRowCount = statement.executeUpdate(deleteQuery);

        assertTrue(deleteRowCount>0);
    }
}
