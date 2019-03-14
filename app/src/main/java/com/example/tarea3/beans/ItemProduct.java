package com.example.tarea3.beans;

import android.content.ClipData;
import android.os.Parcel;
import android.os.Parcelable;

public class ItemProduct implements Parcelable {

    private int image;
    private int code;
    private String name;
    private String store;
    private String location;
    private String phone;
    private String description;

    public ItemProduct(){
        this.image = 0;
        this.name = "";
        this.store = "";
        this.location = "";
        this.phone = "";
        this.description = "";
    }

    public ItemProduct(Parcel in){
        image = in.readInt();
        code = in.readInt();
        name = in.readString();
        store = in.readString();
        location = in.readString();
        phone = in.readString();
        description = in.readString();
    }

    public ItemProduct(int image, String name, String store, String location,  String phone, String description){
        this.image = image;
        this.name = name;
        this.store = store;
        this.location = location;
        this.phone = phone;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ItemProduct{" +
                "image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", store='" + store + '\'' +
                ", location='" + location + '\'' +
                ", phone='" + phone + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(image);
        dest.writeInt(code);
        dest.writeString(name);
        dest.writeString(store);
        dest.writeString(location);
        dest.writeString(phone);
        dest.writeString(description);
    }

    public static final Parcelable.Creator<ItemProduct> CREATOR = new Parcelable.Creator<ItemProduct>(){

        @Override
        public ItemProduct createFromParcel(Parcel source) {
            return new ItemProduct(source);
        }

        public ItemProduct [] newArray(int size){
            return new ItemProduct[size];
        }
    };
}
