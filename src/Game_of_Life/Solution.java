package Game_of_Life;

public class Solution {
    public void gameOfLife(int[][] initialState){
        if(initialState == null || initialState.length==0){
            return;
        }

        int total_rows=initialState.length;
        int total_columns = initialState[0].length;
        for(int i=0;i<total_rows;i++){
            for(int j=0;j<total_columns;j++){
                int lives=liveNeighbors(initialState, total_rows, total_columns, i,j);
                if(initialState[i][j] == 1 && lives>=2 &&lives<=3){
                    initialState[i][j]=3;
                }
                if(initialState[i][j] == 0 && lives==3){
                    initialState[i][j]=2;
                }
            }
        }
        for(int i=0;i<total_rows;i++) {
            for (int j = 0; j < total_columns; j++) {
                initialState[i][j] >>= 1;
            }
        }
    }
    public int liveNeighbors(int[][] initialState, int total_rows, int total_columns, int i, int j) {
        int lives_around_me = 0;
        // traverse all elements around initialState, including itself
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, total_rows - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, total_columns - 1); y++) {
                lives_around_me += initialState[x][y] & 1;
            }
        }

        // if initialState was 1, then get rid of its life
        lives_around_me -= initialState[i][j] & 1;
        return lives_around_me;
    }
}
