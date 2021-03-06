package com.duyp.architecture.mvvm.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Kosh on 03 Apr 2017, 7:40 PM
 */

@Getter
@Setter
public class TeamsModel extends RealmObject implements Parcelable {
    @PrimaryKey
    private long id;
    private String url;
    private String name;
    private String slug;
    private String description;
    private String privacy;
    private String permission;
    private String membersUrl;
    private String repositoriesUrl;

    public TeamsModel() {}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.url);
        dest.writeString(this.name);
        dest.writeString(this.slug);
        dest.writeString(this.description);
        dest.writeString(this.privacy);
        dest.writeString(this.permission);
        dest.writeString(this.membersUrl);
        dest.writeString(this.repositoriesUrl);
    }

    protected TeamsModel(Parcel in) {
        this.id = in.readLong();
        this.url = in.readString();
        this.name = in.readString();
        this.slug = in.readString();
        this.description = in.readString();
        this.privacy = in.readString();
        this.permission = in.readString();
        this.membersUrl = in.readString();
        this.repositoriesUrl = in.readString();
    }

    public static final Parcelable.Creator<TeamsModel> CREATOR = new Parcelable.Creator<TeamsModel>() {
        @Override
        public TeamsModel createFromParcel(Parcel source) {
            return new TeamsModel(source);
        }

        @Override
        public TeamsModel[] newArray(int size) {
            return new TeamsModel[size];
        }
    };
}
