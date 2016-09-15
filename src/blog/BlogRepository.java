package blog;

import java.util.List;

/**
 * Created by Administrator on 9/15/2016.
 */
public interface BlogRepository {
    List<BlogPost> getLatestPosts(long blogID, int amount);

}
