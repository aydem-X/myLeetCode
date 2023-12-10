package com.ayden.leet.code.杨辉三角;

import java.util.ArrayList;
import java.util.List;

/**
 * _118_PascalsTriangle
 *
 * @author: xwq
 * @Date: 2023-12-10
 * @description:
 **/
public class P118_PascalsTriangle {

    public static void main(String[] args) {
        System.out.println(new P118_PascalsTriangle().generate(5));
    }

    /**
     * 暴力逻辑：
     * 每次都取上一行的值，如果是首行直接返回[1]，第二行开始，值都是上一行的左右值和
     *          1
     *        1   1
     *      1   2   1
     *    1   3   3   1
     *  1   4   6   4   1
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; i++) {
            List<Integer> line = new ArrayList<>();
            if (i == 0) {
                line.add(1);
                result.add(line);
                continue;
            }
            // 取上一行
            List<Integer> preLine = result.get(i - 1);
            for (int j = 0; j <= i; j++) {
                // 首尾都是1
                if (j == 0 || j == i) {
                    line.add(1);
                } else {
                    line.add(preLine.get(j - 1) + preLine.get(j));
                }
            }
            result.add(line);
        }
        return result;
    }
}
