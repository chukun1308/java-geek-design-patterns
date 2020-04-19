package com.chukun.designer.pattern.structure.flyweight.v1;

import com.chukun.designer.pattern.structure.flyweight.Color;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chukun
 *  棋盘类
 *
 *  缺点:
 *    为了记录每个房间当前的棋局情况，我们需要给每个房间都创建一个 ChessBoard 棋局对象。
 *    因为游戏大厅中有成千上万的房间（实际上，百万人同时在线的游戏大厅也有很多），
 *    那保存这么多棋局对象就会消耗大量的内存。
 *
 *  解决:
 *    棋子是不变的，可以设计成享元类
 */
public class ChessBoardV1 {

    private Map<Integer,ChessPiece> chessPieceMap = new HashMap<>();

    public ChessBoardV1() {
        init();
    }

    private void init() {
        chessPieceMap.put(1, new ChessPiece(1, "車", Color.RED, 0, 0));
        chessPieceMap.put(2, new ChessPiece(2,"馬", Color.BLACK, 0, 1));
        //...省略摆放其他棋子的代码...
    }

    public void move(int chessPieceId,int toPositionX,int toPositionY) {
        // 棋子移动
    }
}
