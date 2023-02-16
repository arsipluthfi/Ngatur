class Game implements All {

    public static void main(String[] args) throws Exception {

        Board board = new Board();
        board.initializeAll();

        Perft perftTester = new Perft(board);
        perftTester.parsePerftFile(6);
    }
}
