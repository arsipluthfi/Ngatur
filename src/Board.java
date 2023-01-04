public class Board extends Game {

    public long[] pieces = new long[12];
    public long[] occupancy = new long[3];

    int side = BOTH;
    int castling = 0;
    int enPassant = NO_SQ;

    long[] piecesCopy = new long[12];
    long[] occupancyCopy = new long[3];
    int sideCopy = BOTH;
    int castlingCopy = 0;
    int enPassantCopy = NO_SQ;

    final void parseFen(String fen) {

        int square = 0;
        int pointer = 0;
        char c = fen.charAt(pointer);

        for (int i = 0; i < 12; i++) {
            pieces[i] = 0;
        }
        
        for (int i = 0; i < 3; i++) {
            occupancy[i] = 0;
        }

        side = BOTH;
        castling = 0;
        enPassant = 0;

        do {
            switch (c) {
                case '1', '2', '3', '4', '5', '6', '7', '8' -> {
                    square += c - '0';
                }
                case 'P', 'B', 'N', 'R', 'Q', 'K' -> {
                    int piece = PIECES_INDEX[c - 'A'];
                    pieces[piece] = ((pieces[piece]) |= (1L << ( square++)));
                }
                case 'p', 'b', 'n', 'r', 'q', 'k' -> { 
                    int piece = PIECES_INDEX[c - 'A'];                 
                    pieces[piece] = ((pieces[piece]) |= (1L << ( square++)));
                }
            }
            
            c = fen.charAt(++pointer);

        } while (c != ' ');

        pointer++;

        side = fen.charAt(pointer++) == 'w' ? WHITE : BLACK;
        c = fen.charAt(++pointer);

        while (c != ' ') {
            switch (c) {
                case 'K' -> castling |= WING;
                case 'Q' -> castling |= WEEN;
                case 'k' -> castling |= BING;
                case 'q' -> castling |= BEEN;
            }
            c = fen.charAt(++pointer);
        }
        
        c = fen.charAt(++pointer);

        while (c != ' ') {
            switch (c) {
                case 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' -> {
                    enPassant += c - 'a';
                }
                case '1', '2', '3', '4', '5', '6', '7', '8' -> {
                    enPassant += 8 * (8 - c + '0');
                }
                default -> enPassant = NO_SQ;
            }
            c = fen.charAt(++pointer);
        }

        for (int i = 0; i < 6; i++) {
            occupancy[BOTH] |= pieces[i];
            occupancy[WHITE] |= pieces[i];
        }

        for (int i = 6; i < 12; i++) {
            occupancy[BOTH] |= pieces[i];
            occupancy[BLACK] |= pieces[i];
        }

    }

    final void printBoard() {
        String result = "╔═══════════════════╗";

        for (int s = 0; s < 64; s++) {

            if (s % 8 == 0) {
                result += "\n%d  ".formatted(8 - s / 8);
            }

            boolean occupied = false;
            for (int i = 0; i < pieces.length && !occupied; i++) {
                if (((pieces[i] & (1L <<  s)) != 0)) {
                    result += "%c ".formatted(PIECES_UNICODE.charAt(i));
                    occupied = true;
                }
            }

            if (!occupied) {
                result += "• ";
            }

            if (s % 8 == 7) {
                result += " %d".formatted(8 - s / 8);
            }
        }

        result += "\n╚═ A B C D E F G H ═╝\n";
        result += "\nSide: %15s".formatted(sideStr());
        result += "\nCastling: %11s".formatted(castlingStr());
        result += "\nEn passant: %9s\n\n".formatted(enPassantStr());

        System.out.print(result);
    }

    private final String castlingStr() {
        String result = "";

        result += (castling & WING) != 0 ? "K" : "";
        result += (castling & WEEN) != 0 ? "Q" : "";
        result += (castling & BING) != 0 ? "k" : "";
        result += (castling & BEEN) != 0 ? "q" : "";

        return !result.equals("") ? result : "-";
    }

    private final String enPassantStr() {
        return enPassant != 64 ? COORDINATES[enPassant] : "-";
    }

    private final String sideStr() {
        return side == WHITE ? "White" : "Black";
    }

}


