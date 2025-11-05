public class Tank {
    private String[][] field = new String[3][3];
    private String currentPlayer;
    private boolean gameEnded;
    public Tank() {
        newGame();
    }
    public void newGame(){
        currentPlayer = "X";
        gameEnded = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = "-";
            }
        }

    }
    public String[][] getField(){
        return field;
    }
    public String checkGame(){
        if (field[0][0].equals("X") && field[1][0].equals("X") && field[2][0].equals("X")){
            return "X";
        }
        if (field[0][1].equals("X") && field[1][1].equals("X") && field[2][1].equals("X")){
            return "X";
        }
        if (field[0][2].equals("X") && field[1][2].equals("X") && field[2][2].equals("X")){
            return "X";
        }
        if (field[0][0].equals("X") && field[0][1].equals("X") && field[0][2].equals("X")){
            return "X";
        }
        if (field[1][0].equals("X") && field[1][1].equals("X") && field[1][2].equals("X")){
            return "X";
        }
        if (field[2][0].equals("X") && field[2][1].equals("X") && field[2][2].equals("X")){
            return "X";
        }
        if (field[0][0].equals("X") && field[1][1].equals("X") && field[2][2].equals("X")){
            return "X";
        }
        if (field[0][2].equals("X") && field[1][1].equals("X") && field[2][0].equals("X")){
            return "X";
        }
        if (field[0][0].equals("0") && field[1][0].equals("0") && field[2][0].equals("0")){
            return "0";
        }
        if (field[0][1].equals("0") && field[1][1].equals("0") && field[2][1].equals("0")){
            return "0";
        }
        if (field[0][2].equals("0") && field[1][2].equals("0") && field[2][2].equals("0")){
            return "0";
        }
        if (field[0][0].equals("0") && field[0][1].equals("0") && field[0][2].equals("0")){
            return "0";
        }
        if (field[1][0].equals("0") && field[1][1].equals("0") && field[1][2].equals("0")){
            return "0";
        }
        if (field[2][0].equals("0") && field[2][1].equals("0") && field[2][2].equals("0")){
            return "0";
        }
        if (field[0][0].equals("0") && field[1][1].equals("0") && field[2][2].equals("0")){
            return "0";
        }
        if (field[0][2].equals("0") && field[1][1].equals("0") && field[2][0].equals("0")){
            return "0";
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j].equals("-")) {
                    return null;
                }
            }
        }
        return "D";
    }
    public String makeMove(int x, int y){
        if (field == null) {
            newGame();
        }
        if (gameEnded){
            return "Game was ended";
        }
        x -= 1;
        y -= 1;
        if (field[x][y].equals("-")){
            field[x][y] = currentPlayer;
        } else {
            return "Cell "+ (x + 1) + ", " + (y + 1) + " is already occupied";
        }
        String result = checkGame();
        if (result != null) {
            if (result.equals("X")){
                gameEnded = true;
                return "Player X won";
            }
            if (result.equals("0")){
                gameEnded = true;
                return "Player 0 won";
            }
            if (result.equals("D")){
                gameEnded = true;
                return "Draw";
            }
        }
        currentPlayer = currentPlayer.equals("X") ? "0" : "X";
        return "Move completed";
    }
}
