/**
 * Problem Description: Given a image represented as a 2D array, with values in the 
 * array representing a color value, change the existing value of color to new color
 * value based in the input.
 **/

class PerformFloodFill {
    
    public int[][] floodFill(int[][] image, int originR, int originC, int newColor) 
    {
        int prevColor = image[originR][originC];
        if (prevColor == newColor)
            return image;
        dfs(image, originR, originC, prevColor, newColor);
        return image;
    }
    
    public void dfs(int[][] image, int r, int c, int prevC, int newColor) {
        
        if (!withinBoundary(image, r, c)) {
           return;
        }
        if (image[r][c] != prevC) {
            return;
        }
        
        image[r][c] = newColor;
        
        int[] xDirs =  new int[]{0, 0, -1, 1};
        int[] yDirs =  new int[]{1, -1, 0, 0};
        
        // try exploring all the 4 directions w.r.t to a given 
        // point in the matrix.
        for (int i = 0; i < 4; i++) {
            dfs(image, r + xDirs[i], c + yDirs[i], prevC, newColor);
        }
    }
    
    public boolean withinBoundary(int[][] image, int r, int c) {
        // Check if the current row and column value within the matrix bounds.
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) {
            return false;
        }
        return true;
    }
}
