package com.hevendra.mycodebase.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Hevendra.Jadaun on 3/23/2018.
 */

public class ImageModel implements Parcelable{

    /* {
            "id": "910164",
            "width": "2000",
            "height": "1228",
            "file_type": "jpg",
            "file_size": "888843",
            "url_image": "https://images6.alphacoders.com/910/910164.jpg",
            "url_thumb": "https://images6.alphacoders.com/910/thumb-910164.jpg",
            "url_page": "https://wall.alphacoders.com/big.php?i=910164"
        }*/

    private String id;
    private String width;
    private String height;
    private String file_type;
    private String file_size;
    private String url_img;
    private String url_thumb;
    private String page_url;

    protected ImageModel(Parcel in) {
        id = in.readString();
        width = in.readString();
        height = in.readString();
        file_type = in.readString();
        file_size = in.readString();
        url_img = in.readString();
        url_thumb = in.readString();
        page_url = in.readString();
    }

    public static final Creator<ImageModel> CREATOR = new Creator<ImageModel>() {
        @Override
        public ImageModel createFromParcel(Parcel in) {
            return new ImageModel(in);
        }

        @Override
        public ImageModel[] newArray(int size) {
            return new ImageModel[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getFile_type() {
        return file_type;
    }

    public void setFile_type(String file_type) {
        this.file_type = file_type;
    }

    public String getFile_size() {
        return file_size;
    }

    public void setFile_size(String file_size) {
        this.file_size = file_size;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    public String getUrl_thumb() {
        return url_thumb;
    }

    public void setUrl_thumb(String url_thumb) {
        this.url_thumb = url_thumb;
    }

    public String getPage_url() {
        return page_url;
    }

    public void setPage_url(String page_url) {
        this.page_url = page_url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(width);
        dest.writeString(height);
        dest.writeString(file_type);
        dest.writeString(file_size);
        dest.writeString(url_img);
        dest.writeString(url_thumb);
        dest.writeString(page_url);
    }
}
