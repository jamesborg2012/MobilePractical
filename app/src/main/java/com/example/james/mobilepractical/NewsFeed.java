package com.example.james.mobilepractical;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "News")
public class NewsFeed extends Model
{
    @Column(name = "Title")
    public String title;

    @Column(name = "Description")
    public String desc;

    @Column(name = "Image")
    public String img;

    @Column(name = "Section")
    public String sect;

    public NewsFeed()
    {
        super();
    }

    public NewsFeed(String title, String desc, String img, String sect)
    {
        super();
        this.title = title;
        this.desc = desc;
        this.img = img;
        this.sect = sect;
    }


}
