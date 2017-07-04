package com.example.kaildyhoang.mycookbookapplication;

public class User {
    private String idUser, name, email, password, address, description, avatar, gender, idFriendsList, idBookmarksList,birthday, createDay;
    private boolean isOnline;
    private int countOfPosts ,countOfFriends, countOfBookmarks;

    public User() {
//        Default
    }


    public User(String name, String email, String password, String address, String description,
                String avatar, String gender, String idFriendsList, String idBookmarksList,
                boolean isOnline, int countOfPosts, int countOfFriends, int countOfBookmarks, String birthday, String createDay) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.description = description;
        this.avatar = avatar;
        this.gender = gender;
        this.idFriendsList = idFriendsList;
        this.idBookmarksList = idBookmarksList;
        this.isOnline = isOnline;
        this.countOfPosts = countOfPosts;
        this.countOfFriends = countOfFriends;
        this.countOfBookmarks = countOfBookmarks;
        this.birthday = birthday;
        this.createDay = createDay;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdFriendsList() {
        return idFriendsList;
    }

    public void setIdFriendsList(String idFriendsList) {
        this.idFriendsList = idFriendsList;
    }

    public String getIdBookmarksList() {
        return idBookmarksList;
    }

    public void setIdBookmarksList(String idBookmarksList) {
        this.idBookmarksList = idBookmarksList;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public int getCountOfPosts() {
        return countOfPosts;
    }

    public void setCountOfPosts(int countOfPosts) {
        this.countOfPosts = countOfPosts;
    }

    public int getCountOfFriends() {
        return countOfFriends;
    }

    public void setCountOfFriends(int countOfFriends) {
        this.countOfFriends = countOfFriends;
    }

    public int getCountOfBookmarks() {
        return countOfBookmarks;
    }

    public void setCountOfBookmarks(int countOfBookmarks) {
        this.countOfBookmarks = countOfBookmarks;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCreateDay() {
        return createDay;
    }

    public void setCreateDay(String createDay) {
        this.createDay = createDay;
    }
}
