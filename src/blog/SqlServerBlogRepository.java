package blog;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 9/15/2016.
 */
public class SqlServerBlogRepository implements BlogRepository {

    private final Connection connection;

    public SqlServerBlogRepository(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<BlogPost> getLatestPosts(long blogID, int amount) {
        try (PreparedStatement ps2 = conn.prepareStatement("SELECT * " +
                "FROM Posts as P " +
                "INNER JOIN Blogg as B " +
                "ON B.BloggID = P.Blogg_ID " +
                "INNER JOIN Users as U " +
                "ON U.UserID = B.User_ID " +
                "WHERE PostID = ?; ");) {
            ps.setInt(1, amount);
            ps.setLong(2, blogID);
            try (ResultSet resultSet = ps.executeQuery()) {
                List<BlogPost> posts = new ArrayList<>();
                while (resultSet.next()) {
                    String title = resultSet.getString("PostTitle");
                    String body = resultSet.getString("PostTitle");
                    long authorID = resultSet.getLong("AuthorID");
                    Date sqlDate = resultSet.getDate("Created");
                    LocalDateTime postedOn = LocalDateTime.ofInstant(sqlDate.toInstant(), ZoneId.systemDefault());
                    posts.add(new BlogPost(title, body, authorID, postedOn));
                }
            }
        } catch (SQLException e) {
            throw new BlogRepositoryException(e);
        }
        return null;
    }
}
