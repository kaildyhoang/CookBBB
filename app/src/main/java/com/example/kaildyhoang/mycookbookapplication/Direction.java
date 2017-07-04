package com.example.kaildyhoang.mycookbookapplication;

/**
 * Created by Microsoft Windows on 02/07/2017.
 */

public class Direction {
    private String directionContent;
    private String directionIllustrationPicture;
    private int directionOrdinalNumber;

    public Direction(int directionOrdinalNumber, String directionContent, String directionIllustrationPicture) {
        this.directionOrdinalNumber = directionOrdinalNumber;
        this.directionContent = directionContent;
        this.directionIllustrationPicture = directionIllustrationPicture;
    }

    public int getDirectionOrdinalNumber() {
        return directionOrdinalNumber;
    }

    public void setDirectionOrdinalNumber(int directionOrdinalNumber) {
        this.directionOrdinalNumber = directionOrdinalNumber;
    }

    public String getDirectionContent() {
        return directionContent;
    }

    public void setDirectionContent(String directionContent) {
        this.directionContent = directionContent;
    }

    public String getDirectionIllustrationPicture() {
        return directionIllustrationPicture;
    }

    public void setDirectionIllustrationPicture(String directionIllustrationPicture) {
        this.directionIllustrationPicture = directionIllustrationPicture;
    }

}
