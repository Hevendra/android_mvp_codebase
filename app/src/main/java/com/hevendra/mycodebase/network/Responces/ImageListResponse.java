package com.hevendra.mycodebase.network.Responces;

import android.os.Parcel;
import android.os.Parcelable;

import com.hevendra.mycodebase.base.BaseResponse;
import com.hevendra.mycodebase.models.ImageModel;

import java.util.ArrayList;

/**
 * Created by Hevendra.Jadaun on 3/23/2018.
 */

public class ImageListResponse implements Parcelable{
    private ArrayList<ImageModel> imagesList;
    private boolean success;

    protected ImageListResponse(Parcel in) {
        imagesList = in.createTypedArrayList(ImageModel.CREATOR);
        success = in.readByte() != 0;
    }

    public static final Creator<ImageListResponse> CREATOR = new Creator<ImageListResponse>() {
        @Override
        public ImageListResponse createFromParcel(Parcel in) {
            return new ImageListResponse(in);
        }

        @Override
        public ImageListResponse[] newArray(int size) {
            return new ImageListResponse[size];
        }
    };

    public ArrayList<ImageModel> getImagesList() {
        return imagesList;
    }

    public void setImagesList(ArrayList<ImageModel> imagesList) {
        this.imagesList = imagesList;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(imagesList);
        dest.writeByte((byte) (success ? 1 : 0));
    }
}
