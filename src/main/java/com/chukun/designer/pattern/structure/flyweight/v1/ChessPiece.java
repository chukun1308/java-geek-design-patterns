package com.chukun.designer.pattern.structure.flyweight.v1;

import com.chukun.designer.pattern.structure.flyweight.Color;
import com.chukun.designer.pattern.structure.flyweight.v2.ChessPieceUnit;

/**
 * @author chukun
 *   棋子类
 */
public class ChessPiece {

    private int id;
    private String text;
    private Color color;
    private int positionX;
    private int positionY;

    public ChessPiece(int id, String text, Color color, int positionX, int positionY) {
        this.id = id;
        this.text = text;
        this.color = color;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public ChessPiece(ChessPieceUnit unit,int positionX, int positionY) {
        this.id = unit.getId();
        this.text = unit.getText();
        this.color = unit.getColor();
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
