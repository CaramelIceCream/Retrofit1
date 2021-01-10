package com.example.retrofit;


import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("id")
    private int id;

    @SerializedName("firstName")
    private String firstName;

    @SerializedName("lastName")
    private String lastName;

    @SerializedName("name")
    private String name;

    @SerializedName("role")
    private String role;



    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }


}