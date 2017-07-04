package com.example.kaildyhoang.mycookbookapplication;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Microsoft Windows on 02/07/2017.
 */

public class Post {
    private String _idPost;
    private String title;
    private String likeBy;
    private String likeId;
    private String likeName;

    private String postAt;

    private String postBy;
    private String postById;
    private String postByName;

    private String illustrationPicture;
    private String description;
    private String ingredient;

    private String direction;
    private String directionImg;
    private String directionCont;

    public Post(String title, String likeBy, String postAt, String postBy, String illustrationPicture,
                String description, String ingredient, String direction, int countOfLikes,
                int eatPeopleCount, int cookTimeLimit, boolean isPublic) {
        this.title = title;
        this.likeBy = likeBy;
        this.postAt = postAt;
        this.postBy = postBy;
        this.illustrationPicture = illustrationPicture;
        this.description = description;
        this.ingredient = ingredient;
        this.direction = direction;
        this.countOfLikes = countOfLikes;
        this.eatPeopleCount = eatPeopleCount;
        this.cookTimeLimit = cookTimeLimit;
        this.isPublic = isPublic;
    }

    private int countOfLikes,eatPeopleCount,cookTimeLimit;
    private boolean isPublic;

    public Post(){
        //Defaul
    }

    public String getLikeId() {
        return likeId;
    }

    public void setLikeId(String likeId) {
        this.likeId = likeId;
    }

    public String getLikeName() {
        return likeName;
    }

    public void setLikeName(String likeName) {
        this.likeName = likeName;
    }

    public String getPostById() {
        return postById;
    }

    public void setPostById(String postById) {
        this.postById = postById;
    }

    public String getPostByName() {
        return postByName;
    }

    public void setPostByName(String postByName) {
        this.postByName = postByName;
    }

    public String getDirectionImg() {
        return directionImg;
    }

    public void setDirectionImg(String directionImg) {
        this.directionImg = directionImg;
    }

    public String getDirectionCont() {
        return directionCont;
    }

    public void setDirectionCont(String directionCont) {
        this.directionCont = directionCont;
    }

    public String getLikeBy() {
        return likeBy;
    }

    public void setLikeBy(String likeBy) {
        this.likeBy = likeBy;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getPostBy() {
        return postBy;
    }

    public void setPostBy(String postBy) {
        this.postBy = postBy;
    }

    public String getIdPost() {
        return _idPost;
    }

    public void setIdPost(String _idPost) {
        this._idPost = _idPost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostAt() {
        return postAt;
    }

    public void setPostAt(String postAt) {
        this.postAt = postAt;
    }

    public String getIllustrationPicture() {
        return illustrationPicture;
    }

    public void setIllustrationPicture(String illustrationPicture) {
        this.illustrationPicture = illustrationPicture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public int getCountOfLikes() {
        return countOfLikes;
    }

    public void setCountOfLikes(int countOfLikes) {
        this.countOfLikes = countOfLikes;
    }

    public int getEatPeopleCount() {
        return eatPeopleCount;
    }

    public void setEatPeopleCount(int eatPeopleCount) {
        this.eatPeopleCount = eatPeopleCount;
    }

    public int getCookTimeLimit() {
        return cookTimeLimit;
    }

    public void setCookTimeLimit(int cookTimeLimit) {
        this.cookTimeLimit = cookTimeLimit;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}


