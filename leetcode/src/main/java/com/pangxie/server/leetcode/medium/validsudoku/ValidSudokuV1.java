package com.pangxie.server.leetcode.medium.validsudoku;

/**
 * Create By fightingcrap On 2020/01/21
 * |  .--,       .--,
 * |( (  \.---./  ) )
 * | '.__/o   o\__.'
 * |    {=  ^  =}
 * |     >  -  <
 * |    /       \
 * |   //       \\
 * |  //|   .   |\\
 * |  "'\       /'"_.-~^`'-.
 * |     \  _  /--'         `
 * |   ___)( )(___
 * |  (((__) (__)))    程序镇压神兽，排查一切bug。
 * |
 * |
 * | ValidSudokuV1
 * |
 * | @author fightingcrap
 **/
public class ValidSudokuV1 {
    public boolean isValidSudoku(char[][] board) {
        //构建三个类型的数组
        boolean row[][] = new boolean[9][9];
        boolean col[][] = new boolean[9][9];
        boolean box[][] = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if ('.' == board[i][j]) {
                    continue;
                }

                int number = board[i][j] - '1';
                //先判断数列有没有被使用过
                if (row[i][number]) {
                    return false;
                }
                row[i][number] = true;

                //在判断列中 有没有被使用过这个数
                if (col[j][number]) {
                    return false;
                }
                col[j][number] = true;

                //计算属于9个格子中的格子是否存在使用;
                int gridNumber = (i / 3) * 3 + j / 3;
                if (box[gridNumber][number]) {
                    return false;
                }
                box[gridNumber][number] = true;
            }
        }

        return true;

    }
}
