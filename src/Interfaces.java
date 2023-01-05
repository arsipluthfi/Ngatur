import java.util.SplittableRandom;

interface Constants {

    static long[][] pawnMasks = new long[2][64];
    static long[] knightMasks = new long[64];
    static long[] kingMasks = new long[64];
    static long[] bishopMasks = new long[64];
    static long[] rookMasks = new long[64];

    static long[][] bishopAttacks = new long[64][512];
    static long[][] rookAttacks = new long[64][4096];

    static String PIECES_ASCII = "PNBRQKpnbrqk";
    static String PIECES_UNICODE = "♙♘♗♖♕♔♟♞♝♜♛♚";

    static int ROOK = 0, BISHOP = 1;
    static int WHITE = 0, BLACK = 1, BOTH = 2;

    static int WING = 1, WEEN = 2, BING = 4, BEEN = 8;

    static int WP = 0x0, WN = 0x1, WB = 0x2, WR = 0x3, WQ = 0x4, WK = 0x5;
    static int BP = 0x6, BN = 0x7, BB = 0x8, BR = 0x9, BQ = 0xA, BK = 0xB;

    static int[] WHITES = { WP, WN, WB, WR, WQ, WK };
    static int[] BLACKS = { BP, BN, BB, BR, BQ, BK };

    static long A_FILE = 0x0101010101010101L;
    static long B_FILE = 0x0202020202020202L;
    static long G_FILE = 0x4040404040404040L;
    static long H_FILE = 0x8080808080808080L;
    static long RANK_2 = 0x00FF000000000000L;
    static long RANK_7 = 0x000000000000FF00L;

    static int ORIGIN = 0b000000000000000000111111;
    static int TARGET = 0b000000000000111111000000;
    static int PIECE = 0b000000001111000000000000;
    static int PROMOTED = 0b000011110000000000000000;
    static int CAPTURE = 0b000100000000000000000000;
    static int DOUBLE_PUSH = 0b001000000000000000000000;
    static int EN_PASSANT = 0b010000000000000000000000;
    static int CASTLING = 0b100000000000000000000000;

    static int[] PIECES_INDEX = {
        0x0, 0x2, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 
        0x0, 0x0, 0x5, 0x0, 0x0, 0x1, 0x0, 0x0, 
        0x4, 0x3, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 
        0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 
        0x0, 0x8, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 
        0x0, 0x0, 0xB, 0x0, 0x0, 0x7, 0x0, 0x6, 
        0xA, 0x9
    };

    static int[] CASTLE_RIGHTS = {
        0x7, 0xF, 0xF, 0xF, 0x3, 0xF, 0xF, 0xB, 
        0xF, 0xF, 0xF, 0xF, 0xF, 0xF, 0xF, 0xF, 
        0xF, 0xF, 0xF, 0xF, 0xF, 0xF, 0xF, 0xF, 
        0xF, 0xF, 0xF, 0xF, 0xF, 0xF, 0xF, 0xF, 
        0xF, 0xF, 0xF, 0xF, 0xF, 0xF, 0xF, 0xF, 
        0xF, 0xF, 0xF, 0xF, 0xF, 0xF, 0xF, 0xF, 
        0xF, 0xF, 0xF, 0xF, 0xF, 0xF, 0xF, 0xF, 
        0xD, 0xF, 0xF, 0xF, 0xC, 0xF, 0xF, 0xE, 
    };

    static long[] BAGICS = {
            0x0002040C28840100L, 0x8004100401002408L, 0x080404042042CC08L,
            0x0808228020400000L, 0x0002021000812000L, 0x1241042084008090L,
            0x8104490420200404L, 0x0040150108024080L, 0x0002200202820401L,
            0x8402200800A08080L, 0x0341101400802504L, 0x0803144404810000L,
            0x0000440420861308L, 0x000002C420201000L, 0xC10C140402021090L,
            0x0100020202520200L, 0x00C0060809014406L, 0x2C21000248010100L,
            0x0502020108050100L, 0x0210206104008002L, 0xD10C010201214100L,
            0x0080200310082008L, 0x0A42080118020282L, 0x1004228044040400L,
            0xA808600040222201L, 0x0114040B101040A8L, 0x0028010012040904L,
            0x0242040020110020L, 0x2101001001004008L, 0x14080A8001100080L,
            0x80840B310C008A00L, 0x0002048000242900L, 0x0A04040500409001L,
            0x1001182800421003L, 0x0090180400920400L, 0x0411400808008200L,
            0x0020008400408202L, 0x2000A40300009008L, 0x910E021410044420L,
            0x0101510220020600L, 0x0414101510002410L, 0xA0011C0144082000L,
            0x8A92022028000400L, 0x0401012018000101L, 0xC300100210110200L,
            0x4004100400400808L, 0x8008021814444208L, 0x0201880081020081L,
            0x8000841008840000L, 0x1082004412882008L, 0x1008022201108006L,
            0x00A3A06020880040L, 0x4000405320220020L, 0x2030200424082031L,
            0x0040080104088400L, 0x0C14080215620401L, 0x00224044100812C4L,
            0x8000050448040440L, 0x0080050200621825L, 0x204000005104A800L,
            0x0381040020204100L, 0x0110900960080080L, 0x000C400401040128L,
            0x0410441014004016L };

    static long[] RAGICS = {
            0x2180002080400A10L, 0x0840084010002001L, 0x0F00104103200008L,
            0x1200081004220041L, 0x0980022400080080L, 0x06001008AA00110CL,
            0x0480020000800100L, 0x2280062240800100L, 0x1804800640008020L,
            0x0800804000200088L, 0xC100801000802000L, 0x0040800800801000L,
            0x8001001005000800L, 0xA082000410080200L, 0x0001010200010004L,
            0x1045000100108042L, 0x802420800A400080L, 0x4650084008402000L,
            0x0000110020010046L, 0x2435010008201000L, 0x20C8004004020040L,
            0x0080808002000400L, 0x0004040008010210L, 0x1000460000884403L,
            0x0240008080004020L, 0x4100200040005000L, 0x0200200080100080L,
            0x0510001080080080L, 0x0838040080800800L, 0x0040040080800200L,
            0x4002010400100208L, 0x0850288200004104L, 0x0050400088800020L,
            0x6010002000400042L, 0x1102821006802000L, 0x3000801002800800L,
            0x2301000801001004L, 0x8602000402001008L, 0x0408082224000190L,
            0x0800108102001054L, 0x4101400080A18010L, 0x2010065820004000L,
            0x00A0020400101000L, 0x4020100021010008L, 0x0008010188110004L,
            0x054E000410020008L, 0x0008020001008080L, 0x1281008902460004L,
            0x0100400080002080L, 0x0000884200210200L, 0x1000500180200180L,
            0x0222089042A20200L, 0x0514080080040080L, 0x0000800200040080L,
            0x000A08210A303400L, 0x0243000082004100L, 0x0420422070800901L,
            0x4012090080402012L, 0x0000088020401202L, 0x00C0080500201001L,
            0x0026002010288512L, 0x0021000A18040005L, 0x80000100B0024804L,
            0x0048640382A24902L };

    static int A8 = 0x00, B8 = 0x01, C8 = 0x02, D8 = 0x03;
    static int E8 = 0x04, F8 = 0x05, G8 = 0x06, H8 = 0x07;
    static int A7 = 0x08, B7 = 0x09, C7 = 0x0a, D7 = 0x0b;
    static int E7 = 0x0c, F7 = 0x0d, G7 = 0x0e, H7 = 0x0f;
    static int A6 = 0x10, B6 = 0x11, C6 = 0x12, D6 = 0x13;
    static int E6 = 0x14, F6 = 0x15, G6 = 0x16, H6 = 0x17;
    static int A5 = 0x18, B5 = 0x19, C5 = 0x1a, D5 = 0x1b;
    static int E5 = 0x1c, F5 = 0x1d, G5 = 0x1e, H5 = 0x1f;
    static int A4 = 0x20, B4 = 0x21, C4 = 0x22, D4 = 0x23;
    static int E4 = 0x24, F4 = 0x25, G4 = 0x26, H4 = 0x27;
    static int A3 = 0x28, B3 = 0x29, C3 = 0x2a, D3 = 0x2b;
    static int E3 = 0x2c, F3 = 0x2d, G3 = 0x2e, H3 = 0x2f;
    static int A2 = 0x30, B2 = 0x31, C2 = 0x32, D2 = 0x33;
    static int E2 = 0x34, F2 = 0x35, G2 = 0x36, H2 = 0x37;
    static int A1 = 0x38, B1 = 0x39, C1 = 0x3a, D1 = 0x3b;
    static int E1 = 0x3c, F1 = 0x3d, G1 = 0x3e, H1 = 0x3f;
    static int NO_SQ = 0x40;

    static String[] COORDINATES = {
            "a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8",
            "a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7",
            "a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6",
            "a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5",
            "a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4",
            "a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3",
            "a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2",
            "a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1" };

    static int[] RAYS = {
            12, 11, 11, 11, 11, 11, 11, 12,
            11, 10, 10, 10, 10, 10, 10, 11,
            11, 10, 10, 10, 10, 10, 10, 11,
            11, 10, 10, 10, 10, 10, 10, 11,
            11, 10, 10, 10, 10, 10, 10, 11,
            11, 10, 10, 10, 10, 10, 10, 11,
            11, 10, 10, 10, 10, 10, 10, 11,
            12, 11, 11, 11, 11, 11, 11, 12 };

    static int[] BAYS = {
            6, 5, 5, 5, 5, 5, 5, 6,
            5, 5, 5, 5, 5, 5, 5, 5,
            5, 5, 7, 7, 7, 7, 5, 5,
            5, 5, 7, 9, 9, 7, 5, 5,
            5, 5, 7, 9, 9, 7, 5, 5,
            5, 5, 7, 7, 7, 7, 5, 5,
            5, 5, 5, 5, 5, 5, 5, 5,
            6, 5, 5, 5, 5, 5, 5, 6 };

    default int getOrigin(int move) {
        return move & ORIGIN;
    }

    default int getTarget(int move) {
        return (move & TARGET) >> 6;
    }

    default int getPiece(int move) {
        return (move & PIECE) >> 12;
    }

    default int getPromoted(int move) {
        return (move & PROMOTED) >> 16;
    }

    default boolean getCapture(int move) {
        return (move & CAPTURE) != 0;
    }

    default boolean getDouble(int move) {
        return (move & DOUBLE_PUSH) != 0;
    }

    default boolean getEnPassant(int move) {
        return (move & EN_PASSANT) != 0;
    }

    default boolean getCastling(int move) {
        return (move & CASTLING) != 0;
    }

    /*
    default void copyBoard() {
        
        long[] piecesCopy = new long[12];
        long[] occupancyCopy = new long[3];
        int sideCopy = BOTH;
        int castlingCopy = 0;
        int enPassantCopy = NO_SQ;

        for (int i = 0; i < 12; i++) {
            piecesCopy[i] = board.pieces[i];
        }
        
        for (int i = 0; i < 3; i++) {
            occupancyCopy[i] = board.occupancy[i];
        }

        sideCopy = board.side;
        castlingCopy = board.castling;
        enPassantCopy = board.enPassant;
    }

    default void restoreBoard() {
        Board board = (Board) this;

        board.pieces = piecesCopy;
        board.occupancy = occupancyCopy;
        board.side = sideCopy;
        board.castling = castlingCopy;
        board.enPassant = enPassantCopy;
    }
    */
}

interface BitHacks extends Constants {

    static long SHIFT[] = {
            1L, 2L, 4L, 8L, 16L, 32L
    };

    static long BITMASKS[] = {
            0x5555555555555555L, 0x3333333333333333L,
            0x0F0F0F0F0F0F0F0FL, 0x00FF00FF00FF00FFL,
            0x0000FFFF0000FFFFL, 0x00000000FFFFFFFFL
    };

    static int INDEX[] = {
            00, 01, 48, 02, 57, 49, 28, 03,
            61, 58, 50, 42, 38, 29, 17, 04,
            62, 55, 59, 36, 53, 51, 43, 22,
            45, 39, 33, 30, 24, 18, 12, 05,
            63, 47, 56, 27, 60, 41, 37, 16,
            54, 35, 52, 21, 44, 32, 23, 11,
            46, 26, 40, 15, 34, 20, 31, 10,
            25, 14, 19, 9, 13, 8, 7, 06
    };

    default long setBit(long board, int square) {
        return board | (1L << square);
    }

    default long delBit(long board, int square) {
        return board & ~(1L << square);
    }

    default boolean getBit(long board, int square) {
        return (board & (1L << square)) != 0;
    }

    default int bitCount(long n) {

        long c = n - ((n >>> SHIFT[0]) & BITMASKS[0]);
        c = ((c >> SHIFT[1]) & BITMASKS[1]) + (c & BITMASKS[1]);
        c = ((c >>> SHIFT[2]) + c) & BITMASKS[2];
        c = ((c >>> SHIFT[3]) + c) & BITMASKS[3];
        c = ((c >>> SHIFT[4]) + c) & BITMASKS[4];
        c = ((c >>> SHIFT[5]) + c) & BITMASKS[5];

        return (int) c;
    }

    default int lsbIndex(long n) {
        return INDEX[(int) (((n & -n) * 0x03F79D71B4CB0A89L) >>> 58)];
    }

    default String moveStr(int move) {
        String result = "";

        int origin = getOrigin(move);
        int target = getTarget(move);
        int piece = getPiece(move);
        int promoted = getPromoted(move);
        
        boolean promote = promoted != 0;
        boolean enPassant = getEnPassant(move);
        boolean capture = getCapture(move);
        boolean castle = getCastling(move);

        if (castle) {
            return switch (target) {
                case G8, G1 -> {
                    yield "O-O";
                }
                default -> {
                    yield "O-O-O";
                }
            };
        }

        if (!(getPiece(move) == WP || getPiece(move) == BP)) {
            result += (char) (PIECES_ASCII.charAt(piece) & 0x5f);
        }

        result += COORDINATES[origin];
        result += capture ? "x" : "";
        result += COORDINATES[target];
        result += promote ? (char) (PIECES_ASCII.charAt(promoted) | 0x20) : "";
        result += enPassant ? " e.p." : "";

        return result;
    }

    default void printBitBoard(long board) {

        String result = "";
        String bits = "%64s".formatted(Long.toBinaryString(board));
        bits = bits.replace(' ', '0');

        for (int i = bits.length() - 1; i >= 0; i--) {

            if (i % 8 == 7) {
                result += "\n%d ".formatted(i / 8 + 1);
            }

            result += "%c ".formatted(bits.charAt(i));
        }

        result += "\n  A B C D E F G H\n\n";

        System.out.print(result);
    }
}

interface MoveMasks extends BitHacks {

    default void initializeAll() {
        leaperMasks();
        sliderMasks();
        sliderAttacks();
    }

    default void leaperMasks() {
        for (int s = 0; s < 64; s++) {
            pawnMasks[BLACK][s] = pawnMask(BLACK, s);
            pawnMasks[WHITE][s] = pawnMask(WHITE, s);
            knightMasks[s] = knightMask(s);
            kingMasks[s] = kingMask(s);
        }
    }

    default void sliderMasks() {
        for (int s = 0; s < 64; s++) {
            bishopMasks[s] = bishopMask(s);
            rookMasks[s] = rookMask(s);
        }
    }

    default void sliderAttacks() {
        for (int s = 0; s < 64; s++) {
            int rights = RAYS[s];
            int bights = BAYS[s];

            long rattack = rookMasks[s];
            long battack = bishopMasks[s];

            int rits = bitCount(rattack);
            int bits = bitCount(battack);

            int rindices = (1 << rits);
            int bindices = (1 << bits);

            for (int i = 0; i < bindices; i++) {
                long blocker = blockerMask(i, battack);

                int bindex = (int) ((BAGICS[s] * blocker) >>> (64 - bights));
                bishopAttacks[s][bindex] = bishopAttacks(s, blocker);
            }

            for (int i = 0; i < rindices; i++) {
                long blocker = blockerMask(i, rattack);

                int rindex = (int) ((RAGICS[s] * blocker) >>> (64 - rights));
                rookAttacks[s][rindex] = rookAttacks(s, blocker);
            }
        }
    }

    private long pawnMask(int side, int square) {

        long piece = 0L;
        long attack = 0L;

        piece = setBit(piece, square);

        if (side == WHITE) {
            attack |= (piece & ~H_FILE) != 0 ? piece >>> 7 : 0;
            attack |= (piece & ~A_FILE) != 0 ? piece >>> 9 : 0;
        } else {
            attack |= (piece & ~A_FILE) != 0 ? piece << 7 : 0;
            attack |= (piece & ~H_FILE) != 0 ? piece << 9 : 0;
        }

        return attack;

    }

    private long knightMask(int square) {

        long piece = 0L;
        long attack = 0L;

        piece = setBit(piece, square);

        long AB = ~(A_FILE | B_FILE);
        long GH = ~(G_FILE | H_FILE);

        attack |= (piece & AB) != 0 ? piece >>> 10 : 0;
        attack |= (piece & AB) != 0 ? piece << 6 : 0;
        attack |= (piece & GH) != 0 ? piece << 10 : 0;
        attack |= (piece & GH) != 0 ? piece >>> 6 : 0;

        attack |= (piece & ~A_FILE) != 0 ? piece << 15 : 0;
        attack |= (piece & ~A_FILE) != 0 ? piece >>> 17 : 0;
        attack |= (piece & ~H_FILE) != 0 ? piece >>> 15 : 0;
        attack |= (piece & ~H_FILE) != 0 ? piece << 17 : 0;

        return attack;
    }

    private long kingMask(int square) {

        long piece = 0L;
        long attack = 0L;

        piece = setBit(piece, square);

        attack |= (piece & ~H_FILE) != 0 ? piece >>> 7 : 0;
        attack |= (piece & ~H_FILE) != 0 ? piece << 1 : 0;
        attack |= (piece & ~H_FILE) != 0 ? piece << 9 : 0;

        attack |= (piece & ~A_FILE) != 0 ? piece << 7 : 0;
        attack |= (piece & ~A_FILE) != 0 ? piece >>> 1 : 0;
        attack |= (piece & ~A_FILE) != 0 ? piece >>> 9 : 0;

        attack |= piece != 0 ? piece << 8 : 0;
        attack |= piece != 0 ? piece >>> 8 : 0;

        return attack;
    }

    private long bishopMask(int square) {

        int rank = square / 8;
        int file = square % 8;
        long attack = 0L;

        for (int r = rank + 1, f = file + 1; r < 7 && f < 7; r++, f++) {
            attack |= 1L << (r * 8 + f);
        }
        for (int r = rank + 1, f = file - 1; r < 7 && f > 0; r++, f--) {
            attack |= 1L << (r * 8 + f);
        }
        for (int r = rank - 1, f = file + 1; r > 0 && f < 7; r--, f++) {
            attack |= 1L << (r * 8 + f);
        }
        for (int r = rank - 1, f = file - 1; r > 0 && f > 0; r--, f--) {
            attack |= 1L << (r * 8 + f);
        }

        return attack;
    }

    private long rookMask(int square) {

        int rank = square / 8;
        int file = square % 8;
        long attack = 0L;

        for (int r = rank + 1; r < 7; r++) {
            attack |= 1L << (r * 8 + file);
        }
        for (int f = file - 1; f > 0; f--) {
            attack |= 1L << (rank * 8 + f);
        }
        for (int f = file + 1; f < 7; f++) {
            attack |= 1L << (rank * 8 + f);
        }
        for (int r = rank - 1; r > 0; r--) {
            attack |= 1L << (r * 8 + file);
        }

        return attack;
    }

    default long bishopAttacks(int square, long blocker) {

        int rank = square / 8;
        int file = square % 8;
        long attack = 0L;

        for (int r = rank + 1, f = file + 1; r <= 7 && f <= 7; r++, f++) {
            attack |= 1L << (r * 8 + f);
            if (getBit(blocker, r * 8 + f)) {
                break;
            }
        }
        for (int r = rank + 1, f = file - 1; r <= 7 && f >= 0; r++, f--) {
            attack |= 1L << (r * 8 + f);
            if (getBit(blocker, r * 8 + f)) {
                break;
            }
        }
        for (int r = rank - 1, f = file + 1; r >= 0 && f <= 7; r--, f++) {
            attack |= 1L << (r * 8 + f);
            if (getBit(blocker, r * 8 + f)) {
                break;
            }
        }
        for (int r = rank - 1, f = file - 1; r >= 0 && f >= 0; r--, f--) {
            attack |= 1L << (r * 8 + f);
            if (getBit(blocker, r * 8 + f)) {
                break;
            }
        }

        return attack;
    }

    default long rookAttacks(int square, long blocker) {

        int rank = square / 8;
        int file = square % 8;
        long attack = 0L;

        for (int r = rank + 1; r <= 7; r++) {
            attack |= 1L << (r * 8 + file);
            if (getBit(blocker, r * 8 + file)) {
                break;
            }
        }
        for (int f = file - 1; f >= 0; f--) {
            attack |= 1L << (rank * 8 + f);
            if (getBit(blocker, rank * 8 + f)) {
                break;
            }
        }
        for (int f = file + 1; f <= 7; f++) {
            attack |= 1L << (rank * 8 + f);
            if (getBit(blocker, rank * 8 + f)) {
                break;
            }
        }
        for (int r = rank - 1; r >= 0; r--) {
            attack |= 1L << (r * 8 + file);
            if (getBit(blocker, r * 8 + file)) {
                break;
            }
        }

        return attack;
    }

    default long blockerMask(int index, long mask) {

        long blocker = 0L;
        int attackBits = bitCount(mask);

        for (int s = 0; s < attackBits; s++) {

            int nextSquare = lsbIndex(mask);

            if ((long) (index & 1 << s) != 0) {
                blocker = setBit(blocker, nextSquare);
            }

            mask = delBit(mask, nextSquare);
        }

        return blocker;
    }
}

interface MagicNumbers extends MoveMasks {

    default void generateNumbers() {
        for (int s = 0; s < 64; s++) {
            RAGICS[s] = findNumber(s, ROOK);
            BAGICS[s] = findNumber(s, BISHOP);
        }
    }

    private long generateMagic() {
        SplittableRandom rand = new SplittableRandom();
        return rand.nextLong() & rand.nextLong() & rand.nextLong();
    }

    private long findNumber(int s, int p) {
        int INDICES = 1 << (p == BISHOP ? BAYS[s] : RAYS[s]);
        long ATTACK = p == BISHOP ? bishopMasks[s] : rookMasks[s];
        int BITS = p == BISHOP ? BAYS[s] : RAYS[s];

        long[] BLOCKERS = new long[INDICES];
        long[] ATTACKS = new long[INDICES];
        long[] USED = new long[INDICES];

        for (int i = 0; i < INDICES; i++) {
            BLOCKERS[i] = blockerMask(i, ATTACK);

            long b = BLOCKERS[i];
            ATTACKS[i] = p == BISHOP ? bishopAttacks(s, b) : rookAttacks(s, b);
        }

        for (int n = 0; n < 1000000000; n++) {
            long number = generateMagic();

            if (bitCount((number * ATTACK) & 0xFF00000000000000L) < 6) {
                continue;
            }

            boolean fail = false;

            for (int i = 0; i < INDICES && !fail; i++) {

                int magicIndex = (int) (BLOCKERS[i] * number >>> (64 - BITS));

                if (USED[magicIndex] == 0) {
                    USED[magicIndex] = ATTACKS[i];
                } else if (USED[magicIndex] != ATTACKS[i]) {
                    fail = true;
                }
            }

            if (!fail) {
                return number;
            }
        }

        return 0;
    }

}

interface MoveGeneration extends MoveMasks {

    private void pawnMoves(long pawnBoard, int pawn, MoveList moveList) {

        Board board = (Board) this;

        int side = board.side;
        int enPassant = board.enPassant;

        long occupancy = board.occupancy[BOTH];
        long enemies = board.occupancy[board.side ^ 1];

        while (pawnBoard != 0) {

            int from = lsbIndex(pawnBoard);
            int to = side == WHITE ? from - 8 : from + 8;
            int push = side == WHITE ? to - 8 : to + 8;

            boolean canPromote = side == WHITE ? from / 8 == 1 : from / 8 == 6;
            boolean canPush = side == WHITE ? from / 8 == 6 : from / 8 == 1;

            if (to <= H1 && to >= A8 && !((occupancy & (1L <<  to)) != 0)) {
                if (canPromote) {
                    moveList.addMove(from, to, pawn, pawn + 4, 0, 0, 0, 0);
                    moveList.addMove(from, to, pawn, pawn + 3, 0, 0, 0, 0);
                    moveList.addMove(from, to, pawn, pawn + 2, 0, 0, 0, 0);
                    moveList.addMove(from, to, pawn, pawn + 1, 0, 0, 0, 0);
                } else {
                    moveList.addMove(from, to, pawn, 0, 0, 0, 0, 0);
                }

                if (canPush && !((occupancy & (1L <<  push)) != 0)) {
                    moveList.addMove(from, push, pawn, 0, 0, 1, 0, 0);
                }
            }

            long epBoard = enPassant == NO_SQ ? 0 : setBit(0, enPassant);
            long attacks = pawnMasks[side][from];
            long captures = attacks & (enemies | epBoard);

            while (captures != 0) {
                int capture = lsbIndex(captures);

                if (canPromote) {
                    moveList.addMove(from, capture, pawn, pawn + 4, 1, 0, 0, 0);
                    moveList.addMove(from, capture, pawn, pawn + 3, 1, 0, 0, 0);
                    moveList.addMove(from, capture, pawn, pawn + 2, 1, 0, 0, 0);
                    moveList.addMove(from, capture, pawn, pawn + 1, 1, 0, 0, 0);
                } else if (enPassant == capture) {
                    moveList.addMove(from, enPassant, pawn, 0, 1, 0, 1, 0);
                } else {
                    moveList.addMove(from, capture, pawn, 0, 1, 0, 0, 0);
                } 

                captures &= ~(1L << capture);
            }

            pawnBoard = delBit(pawnBoard, from);
        }
    }

    private void leaperMoves(long pieceBoard, int piece, MoveList moveList) {

        Board board = (Board) this;

        long friendlies = board.occupancy[board.side];
        long enemies = board.occupancy[board.side ^ 1];

        while (pieceBoard != 0) {
            int from = lsbIndex(pieceBoard);
            long moves = switch (piece) {
                case WN, BN -> knightMasks[from] & ~friendlies;
                default -> kingMasks[from]  & ~friendlies;
            };

            while (moves != 0) {
                int to = lsbIndex(moves);

                if (getBit(enemies, to)) {
                    moveList.addMove(from, to, piece, 0, 1, 0, 0, 0);
                } else {
                    moveList.addMove(from, to, piece, 0, 0, 0, 0, 0);
                }

                moves = delBit(moves, to);
            }

            pieceBoard = delBit(pieceBoard, from);
        }

    }

    private void bishopMoves(long pieceBoard, int piece, MoveList moveList) {

        Board board = (Board) this;

        long friendlies = board.occupancy[board.side];
        long enemies = board.occupancy[board.side ^ 1];
        long occupancy = board.occupancy[BOTH];

        while (pieceBoard != 0) {
            int from = lsbIndex(pieceBoard);
            long moves = switch (piece) {
                case WB, BB -> getBishop(from, occupancy) & ~friendlies;
                case WR, BR -> getRook(from, occupancy) & ~friendlies;
                default -> getQueen(from, occupancy)  & ~friendlies;
            };

            while (moves != 0) {
                int to = lsbIndex(moves);

                if (getBit(enemies, to)) {
                    moveList.addMove(from, to, piece, 0, 1, 0, 0, 0);
                } else {
                    moveList.addMove(from, to, piece, 0, 0, 0, 0, 0);
                }

                moves = delBit(moves, to);
            }

            pieceBoard = delBit(pieceBoard, from);
        }

    }

    private void castlingMoves(MoveList moveList) {
        boolean c1 = false, c2 = false, c3 = false, c4 = false;
        boolean c5 = false, c6 = false, c7 = false, c8 = false, c9 = false;

        Board board = (Board) this;
        int side = board.side;
        int castling = board.castling;
        long occupancy = board.occupancy[BOTH];

        if ((castling & WING) != 0 && side == WHITE) {
            c1 = !getBit(occupancy, F1);
            c2 = !getBit(occupancy, G1);
            c3 = !squareAttacked(E1, BLACK);
            c4 = !squareAttacked(F1, BLACK);
        }

        if ((castling & WEEN) != 0 && side == WHITE) {
            c5 = !getBit(occupancy, D1);
            c6 = !getBit(occupancy, C1);
            c7 = !getBit(occupancy, B1);
            c8 = !squareAttacked(E1, BLACK);
            c9 = !squareAttacked(D1, BLACK);
        }

        if ((castling & BING) != 0 && side == BLACK) {
            c1 = !getBit(occupancy, F8);
            c2 = !getBit(occupancy, G8);
            c3 = !squareAttacked(E8, WHITE);
            c4 = !squareAttacked(F8, WHITE);
        }

        if ((castling & BEEN) != 0 && side == BLACK) {
            c5 = !getBit(occupancy, D8);
            c6 = !getBit(occupancy, C8);
            c7 = !getBit(occupancy, B8);
            c8 = !squareAttacked(E8, WHITE);
            c9 = !squareAttacked(D8, WHITE);
        }

        if (c1 && c2 && c3 && c4) {
            int from = side == WHITE ? E1 : E8;
            int to = side == WHITE ? G1 : G8;
            int piece = side == WHITE ? WK : BK;

            moveList.addMove(from, to, piece, 0, 0, 0, 0, 1);
        }

        if (c5 && c6 && c7 && c8 && c9) {
            int from = side == WHITE ? E1 : E8;
            int to = side == WHITE ? C1 : C8;
            int piece = side == WHITE ? WK : BK;

            moveList.addMove(from, to, piece, 0, 0, 0, 0, 1);
        }
    }

    default long getBishop(int square, long occupancy) {

        long block = bishopMasks[square] & occupancy;
        int magicIndex = (int) (block * BAGICS[square] >>> (64 - BAYS[square]));

        return bishopAttacks[square][magicIndex];
    }

    default long getRook(int square, long occupancy) {

        long block = rookMasks[square] & occupancy;
        int magicIndex = (int) (block * RAGICS[square] >>> (64 - RAYS[square]));

        return rookAttacks[square][magicIndex];
    }

    default long getQueen(int square, long occupancy) {
        return getBishop(square, occupancy) | getRook(square, occupancy);
    }

    default boolean squareAttacked(int square, int side) {

        Board board = (Board) this;
        long[] pieces = board.pieces;
        long fill = board.occupancy[BOTH];
        int enemy = side ^ 1;

        if ((kingMasks[square] & pieces[side == WHITE ? WK : BK]) != 0) {
            return true;
        }
        if ((knightMasks[square] & pieces[side == WHITE ? WN : BN]) != 0) {
            return true;
        }
        if ((pawnMasks[enemy][square] & pieces[side == WHITE ? WP : BP]) != 0) {
            return true;
        }
        if ((getBishop(square, fill) & pieces[side == WHITE ? WB : BB]) != 0) {
            return true;
        }
        if ((getRook(square, fill) & pieces[side == WHITE ? WR : BR]) != 0) {
            return true;
        }
        if ((getQueen(square, fill) & pieces[side == WHITE ? WQ : BQ]) != 0) {
            return true;
        }
        return false;
    }

    default void generateMoves(MoveList movelist) {
        Board board = (Board) this;

        for (int piece : board.side == WHITE ? WHITES : BLACKS) {
            long pieceBoard = board.pieces[piece];

            switch (piece) {
                case WP, BP -> {
                    pawnMoves(pieceBoard, piece, movelist);
                }
                case WK, BK, WN, BN -> {
                    leaperMoves(pieceBoard, piece, movelist);
                }
                case WB, BB, WR, BR, WQ, BQ -> {
                    bishopMoves(pieceBoard, piece, movelist);
                }
            }
        }

        if (board.castling != 0) {
            castlingMoves(movelist);
        }
    }

}

interface MakeMove extends MoveGeneration {

    default boolean makeMove(int move) {
        Board board = (Board) this;
        
        long[] pieces = board.pieces;
        long[] occupancy = board.occupancy;
        int side = board.side;
            
        int origin = getOrigin(move);
        int target = getTarget(move);
        int piece = getPiece(move);
        int promoted = getPromoted(move);
        boolean doublePush = getDouble(move);
        boolean epCapture = getEnPassant(move);
        boolean castleMove = getCastling(move);

        long[] piecesCopy = new long[12];
        long[] occupancyCopy = new long[3];
        int sideCopy = BOTH;
        int castlingCopy = 0;
        int enPassantCopy = NO_SQ;

        for (int i = 0; i < 12; i++) {
            piecesCopy[i] = board.pieces[i];
        }
        
        for (int i = 0; i < 3; i++) {
            occupancyCopy[i] = board.occupancy[i];
        }

        sideCopy = board.side;
        castlingCopy = board.castling;
        enPassantCopy = board.enPassant;
        
        pieces[piece] = delBit(pieces[piece], origin);

        if (getCapture(move)) {

            for (int captured: side == WHITE ? BLACKS : WHITES) {
                if (getBit(pieces[captured], target)) {
                    pieces[captured] = delBit(pieces[captured], target);
                    break;
                }
            }

            if (promoted != 0) {
                pieces[promoted] = setBit(pieces[promoted], target);
            } else if (epCapture) {
                
                if (side == WHITE) {
                    pieces[WP] = setBit(pieces[WP], target);
                    pieces[BP] = delBit(pieces[BP], target + 8);
                } else {
                    pieces[BP] = setBit(pieces[BP], target);
                    pieces[WP] = delBit(pieces[WP], target - 8);
                }
                
            } else {
                pieces[piece] = setBit(pieces[piece], target);
            }

        } else if (promoted != 0) {
            pieces[promoted] = setBit(pieces[promoted], target);
        } else {
            pieces[piece] = setBit(pieces[piece], target);
        }

        if (!doublePush) {
            board.enPassant = NO_SQ;
        } else {
            
            if (side == WHITE) {
                board.enPassant = target + 8;
            } else {
                board.enPassant = target - 8;
            }
        }

        if (castleMove) {
            switch (target) {
                case G1 -> {
                    pieces[piece] = setBit(pieces[piece], target);
                    pieces[WR] = delBit(pieces[WR], H1);
                    pieces[WR] = setBit(pieces[WR], F1);
                }
                case C1 -> {
                    pieces[piece] = setBit(pieces[piece], target);
                    pieces[WR] = delBit(pieces[WR], A1);
                    pieces[WR] = setBit(pieces[WR], D1);
                }
                case G8 -> {
                    pieces[piece] = setBit(pieces[piece], target);
                    pieces[BR] = delBit(pieces[BR], H8);
                    pieces[BR] = setBit(pieces[BR], F8);
                }
                case C8 -> {
                    pieces[piece] = setBit(pieces[piece], target);
                    pieces[BR] = delBit(pieces[BR], A8);
                    pieces[BR] = setBit(pieces[BR], D8);
                }
            }
        }

        board.castling &= CASTLE_RIGHTS[origin] & CASTLE_RIGHTS[target];
        
        occupancy[BLACK] = 0;
        occupancy[WHITE] = 0;

        for (int whitePiece: WHITES) {
            occupancy[WHITE] |= pieces[whitePiece];
        }

        for (int blackPiece: BLACKS) {
            occupancy[BLACK] |= pieces[blackPiece];
        }

        occupancy[BOTH] = occupancy[WHITE] | occupancy[BLACK];
        board.side = side ^= 1;

        if (squareAttacked(lsbIndex(pieces[side == WHITE ? BK : WK]), side)) {
            board.pieces = piecesCopy;
            board.occupancy = occupancyCopy;
            board.side = sideCopy;
            board.castling = castlingCopy;
            board.enPassant = enPassantCopy;
            return false;
        }

        return true;

    }

    default void makeCaptures(int move) {
        if (getCapture(move)) {
            makeMove(move);
        }
    }
}

interface All extends MagicNumbers, MakeMove {}