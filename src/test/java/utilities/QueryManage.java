package utilities;

public class QueryManage {

    private String Query05 = "SELECT mother_name, mother_occupation FROM wonderworld_qa2.students WHERE lastname LIKE 'T%';";

    public String getQuery05() {
        return Query05;
    }

    private String Query06 = "UPDATE wonderworld_qa2.topic SET name = 'Sophie' WHERE id = 13;";

    public String getQuery06() {
        return Query06;
    }

    private String Query08 = "DELETE FROM wonderworld_qa2.visitors_book WHERE id=17;";

    public String getQuery08() {
        return Query08;
    }
}

