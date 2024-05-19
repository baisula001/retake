package org.example.demo2.gameService;

import java.util.BitSet;
import java.util.Date;
import java.util.List;

/**
 * @Auther: willson2008
 * @Date: 05/05/2024 - 05 - 05 - 14:12
 * @Description: org.example.demo2.gameService
 * @Version: 1.0
 */

public class GameResult {
    private String playerName; // 修改为 playerName，表示单个玩家的名称
    private int moves; // 修改为 moves，表示玩家在游戏中的移动步数
    private long gameTime; // 修改为 gameTime，表示游戏的持续时间
    private boolean solved; // 修改为 solved，表示游戏是否被解决

    // 其他属性和方法...

    public GameResult() {
    }

    public GameResult(String playerName, int moves, long gameTime, boolean solved) {
        this.playerName = playerName;
        this.moves = moves;
        this.gameTime = gameTime;
        this.solved = solved;
    }
    // 添加构造函数和 getter 方法


    public String getPlayerName() {
        return playerName;
    }

    public int getMoves() {
        return moves;
    }

    public long getGameTime() {
        return gameTime;
    }

    public boolean isSolved() {
        return solved;
    }
}