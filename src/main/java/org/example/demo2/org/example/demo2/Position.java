package org.example.demo2.org.example.demo2;

/**
 * @Auther: willson2008
 * @Date: 06/04/2024 - 04 - 06 - 22:17
 * @Description: org.example.demo2.org.example.demo2
 * @Version: 1.0
 */
public record Position(int row,int col) {
    @Override
    public String toString() {
        return String.format("(%d,%d)",row,col);
    }
}
