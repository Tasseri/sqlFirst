package blog;

import java.time.LocalDateTime;

/**
 * Created by Administrator on 9/15/2016.
 */
public class BlogPost {

    private String title;
    private String body;
    private long authorID;
    private LocalDateTime postedOn;

    public BlogPost(String title, String body, long authorID, LocalDateTime postedOn) {
        this.title = title;
        this.body = body;
        this.authorID = authorID;
        this.postedOn = postedOn;
    }
}
