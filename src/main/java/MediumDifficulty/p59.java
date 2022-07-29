package MediumDifficulty;


public class p59 {
    public static void main(String[] args) {
        p59 t = new p59();
        System.out.println(t.generateMatrix(0));
    }
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int flag = 1;
        int nowNum = 1;                         //填入矩阵的数从 1 开始
        int sarr = 0, earr = n - 1, scol = 0, ecol = n - 1;
        int nowx = 0, nowy = 0;
        while(flag == 1){
            flag = 0;                   //如果没有加入新元素，flag=0，则跳出循环
            /**
             *
             * 模拟写入。对于每一层外圈，按顺时针遍历各个点并写入对应元素。
             *
             * **/
            while(nowy <= earr){ //遍历外圈顶部行
                res[nowx][nowy] = nowNum ++;
                nowy ++;
                flag = 1;
            }
            scol += 1;          //起始行+1
            nowy --;            //指向右上角元素下方的元素
            nowx ++;
            while(nowx <= ecol){     //遍历外圈右部列
                res[nowx][nowy] = nowNum ++;
                nowx ++;
                flag = 1;
            }
            earr -= 1;          //终止列+1
            nowx --;            //指向右下角元素左方的元素
            nowy --;
            while(nowy >= sarr){ //遍历外圈底部行
                res[nowx][nowy] = nowNum ++;
                nowy --;
                flag = 1;
            }
            ecol -= 1;          //起始行-1
            nowy ++;            //指向左下角元素上方的元素
            nowx --;
            while (nowx >= scol){ //遍历外圈左部列
                res[nowx][nowy] = nowNum ++;
                nowx --;
                flag = 1;
            }
            sarr += 1;          //起始列-1
            nowx ++;            //指向内圈的左上角元素
            nowy ++;
        }
        for(int x = 0;x < n;x ++) {
            for (int y = 0; y < n; y++)
                System.out.print(res[x][y]);
            System.out.println();
        }
        return res;
    }
}

