package repository;

import controllers.db.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BorrowingHistoryRepository {
    Session session = HibernateUtil.getInstance().getSession();

    public ObservableList<Map<String, String>> getHistoryTbl() {

        ObservableList<Map<String, String>> borrowList = FXCollections.observableArrayList();
        String HQL = """
        SELECT
            m.member_id,
            b.book_title,
            i.issue_date,
            i.due_date,
            r.returned_date
        FROM issue_book i
        JOIN members m
            ON i.member_id = m.member_id
        JOIN books b
            ON i.book_id = b.book_id
        LEFT JOIN returned_books r
            ON r.member_id = i.member_id
            AND r.book_id = i.book_id
        ORDER BY i.issue_date ASC
        """;

        try {
            List<Object[]> resultList = session.createNamedSelectionQuery(HQL, Object[].class).getResultList();


            for (Object[] result : resultList) {
                Map<String, String> row = new HashMap<>();
                row.put("member_id", result[0] != null ? result[0].toString() : "");
                row.put("book_title", result[1] != null ? result[1].toString() : "");
                row.put("issue_date", result[2] != null ? result[2].toString() : "");
                row.put("due_date", result[3] != null ? result[3].toString() : "");
                row.put("returned_date", result[4] != null ? result[4].toString() : "");

                borrowList.add(row);

            }
//            while(resultList.next()){
//                Map<String, String> row = new HashMap<>();
//                row.put("member_id",resultList.getString("member_id") != null ? resultSet.getString("member_id") : "");
//                row.put("book_title", resultSet.getString("book_title") != null ? resultSet.getString("book_title") : "");
//                row.put("issue_date", resultSet.getString("issue_date") != null ? resultSet.getString("issue_date") : "");
//                row.put("due_date", resultSet.getString("due_date") != null ? resultSet.getString("due_date") : "");
//                row.put("returned_date", resultSet.getString("returned_date") != null ? resultSet.getString("returned_date") : "");
//
//                borrowList.add(row);
//            }
        }catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return borrowList;
    }
}
