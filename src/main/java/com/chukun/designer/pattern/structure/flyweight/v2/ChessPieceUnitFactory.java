package com.chukun.designer.pattern.structure.flyweight.v2;

import com.chukun.designer.pattern.structure.flyweight.Color;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chukun
 * 创建棋子的工厂类
 */
public class ChessPieceUnitFactory {

    private static final Map<Integer, ChessPieceUnit> pieces = new HashMap<>();

    static {
        pieces.put(1, new ChessPieceUnit.ChessPieceUnitBuilder().setId(1).setText("車").setColor(Color.BLACK).builder());
        pieces.put(2, new ChessPieceUnit.ChessPieceUnitBuilder().setId(2).setText("馬").setColor(Color.RED).builder());
        //...省略摆放其他棋子的代码...
    }

    /**
     * 获取棋子类
     * @param chessPieceId
     * @return
     */
    public static ChessPieceUnit getChessPiece(int chessPieceId) {
        return pieces.get(chessPieceId);
    }
}
