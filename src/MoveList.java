class MoveList implements All {

    int[] list = new int[256];
    int count;

    final void addMove(int from, int to, int piece, int... flags) {
        int result = 0;

        result |= from;
        result |= (to << 6);
        result |= (piece << 12);
        result |= (flags[0] << 16);
        result |= (flags[1] << 20);
        result |= (flags[2] << 21);
        result |= (flags[3] << 22);
        result |= (flags[4] << 23);

        list[count++] = result;
    }

    final void printMoveList() {
        System.out.print("╔═════╦═════════════╗\n");
        System.out.print("║ No. ║    Moves    ║\n");

        for (int i = 0; i < count; i++) {
            int move = list[i];
            System.out.print("╠═════╬═════════════╣\n");
            System.out.printf("║ %03d ║ %-11s ║\n", i+1, moveStr(move));
        }
        System.out.print("╚═════╩═════════════╝\n");
    }
}
