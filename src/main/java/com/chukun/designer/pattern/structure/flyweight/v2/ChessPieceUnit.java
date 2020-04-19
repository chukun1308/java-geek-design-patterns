package com.chukun.designer.pattern.structure.flyweight.v2;

import com.chukun.designer.pattern.structure.flyweight.Color;

/**
 * 棋子享元类
 *
 * @author chukun
 */
public class ChessPieceUnit {

    private int id;
    private String text;
    private Color color;

    public ChessPieceUnit(ChessPieceUnitBuilder builder) {
        this.id = builder.id;
        this.text = builder.text;
        this.color = builder.color;
    }


    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Color getColor() {
        return color;
    }

    /**
     * @author 建造者模式
     */
    public static  class ChessPieceUnitBuilder  {
        private int id;
        private String text;
        private Color color;

        public ChessPieceUnit builder() {
            return new ChessPieceUnit(this);
        }

        public ChessPieceUnitBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public ChessPieceUnitBuilder setText(String text) {
            this.text = text;
            return this;
        }

        public ChessPieceUnitBuilder setColor(Color color) {
            this.color = color;
            return this;
        }
    }
}
