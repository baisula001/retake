package org.example.demo2.gameService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: willson2008
 * @Date: 05/05/2024 - 05 - 05 - 14:11
 * @Description: org.example.demo2.gameService
 * @Version: 1.0
 */
public class GameService {
    private List<GameResult> gameResults;

    public GameService() {
        this.gameResults = new ArrayList<>();
    }

    // 保存游戏结果
    public void saveGameResult(GameResult gameResult) {
        gameResults.add(gameResult);
    }

    // 获取前10名的高分榜
    public List<GameResult> getTop10GameResults() {
        return gameResults.stream()
                .sorted(Comparator.comparing(GameResult::getMoves).thenComparing(GameResult::getGameTime))
                .limit(10)
                .collect(Collectors.toList());
    }
}