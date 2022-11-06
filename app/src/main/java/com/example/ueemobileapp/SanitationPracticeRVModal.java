package com.example.ueemobileapp;

import android.os.Parcel;
import android.os.Parcelable;

public class SanitationPracticeRVModal implements Parcelable {
    private String topicName;
    private String userName;
    private String refLink;
    private String imgLink;
    private String desc;
    private String practiceID;

    public SanitationPracticeRVModal() {

    }

    public SanitationPracticeRVModal(String topicName, String userName, String refLink, String imgLink, String desc, String practiceID) {
        this.topicName = topicName;
        this.userName = userName;
        this.refLink = refLink;
        this.imgLink = imgLink;
        this.desc = desc;
        this.practiceID = practiceID;
    }

    protected SanitationPracticeRVModal(Parcel in) {
        topicName = in.readString();
        userName = in.readString();
        refLink = in.readString();
        imgLink = in.readString();
        desc = in.readString();
        practiceID = in.readString();
    }

    public static final Creator<SanitationPracticeRVModal> CREATOR = new Creator<SanitationPracticeRVModal>() {
        @Override
        public SanitationPracticeRVModal createFromParcel(Parcel in) {
            return new SanitationPracticeRVModal(in);
        }

        @Override
        public SanitationPracticeRVModal[] newArray(int size) {
            return new SanitationPracticeRVModal[size];
        }
    };

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRefLink() {
        return refLink;
    }

    public void setRefLink(String refLink) {
        this.refLink = refLink;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPracticeID() {
        return practiceID;
    }

    public void setPracticeID(String practiceID) {
        this.practiceID = practiceID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(topicName);
        parcel.writeString(userName);
        parcel.writeString(refLink);
        parcel.writeString(imgLink);
        parcel.writeString(desc);
        parcel.writeString(practiceID);
    }
}
