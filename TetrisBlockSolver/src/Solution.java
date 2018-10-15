import java.util.HashMap;

public class Solution {
	class TetrisPuzzleSolver {
		private static final char I = 'i', O = 'o', T = 't', J = 'j', L = 'l', S = 's', Z = 'z'; // used in the
																									// LinkedList to
																									// represent blocks
																									// left to add

		private int[][] board; // first index = row, second index = column; each cell contains the index of the
								// block that occupies that cell (0=empty, 1=first block, ...)
		private final char[] blocks; // list of blocks to place in the board
		private int blocksPtr = 0;

		private int nPieces;

		/**
		 *
		 * @param width   number of columns
		 * @param height  number of rows
		 * @param iBlocks number of I shaped blocks
		 * @param oBlocks number of 2x2 square blocks
		 * @param tBlocks number of T blocks
		 * @param jBlocks number of J blocks
		 * @param lBlocks number of L blocks
		 * @param sBlocks number of S blocks
		 * @param zBlocks number of Z blocks
		 */
		public TetrisPuzzleSolver(int width, int height, int iBlocks, int oBlocks, int tBlocks, int jBlocks,
				int lBlocks, int sBlocks, int zBlocks) {
			if (width <= 0 || height <= 0) {
				throw new IllegalArgumentException("Width and height must be >0");
			}
			if (iBlocks < 0 || oBlocks < 0 || tBlocks < 0 || jBlocks < 0 || lBlocks < 0 || sBlocks < 0 || zBlocks < 0) {
				throw new IllegalArgumentException("Number of blocks must be >=0");
			}
			board = new int[height][width];
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					board[y][x] = 0;
				}
			}
			nPieces = iBlocks + oBlocks + tBlocks + jBlocks + lBlocks + sBlocks + zBlocks;
			blocks = new char[nPieces];
			for (int i = 0; i < iBlocks; i++) {
				blocks[blocksPtr++] = I;
			}
			for (int i = 0; i < oBlocks; i++) {
				blocks[blocksPtr++] = O;
			}
			for (int i = 0; i < tBlocks; i++) {
				blocks[blocksPtr++] = T;
			}
			for (int i = 0; i < jBlocks; i++) {
				blocks[blocksPtr++] = J;
			}
			for (int i = 0; i < lBlocks; i++) {
				blocks[blocksPtr++] = L;
			}
			for (int i = 0; i < sBlocks; i++) {
				blocks[blocksPtr++] = S;
			}
			for (int i = 0; i < zBlocks; i++) {
				blocks[blocksPtr++] = Z;
			}
			blocksPtr = 0;
		}

		/**
		 * used by optimizations. tells how big is a group of adjacent empty cells
		 *
		 * @param y row
		 * @param x column
		 * @return number or adjacent empty cells
		 */
		private int group(int y, int x) {
			if (y >= 0 && y < board.length && x >= 0 && x < board[0].length && board[y][x] == 0) {
				board[y][x] = -1;
				return 1 + group(y, x + 1) + group(y, x - 1) + group(y + 1, x) + group(y - 1, x);
			}
			return 0;
		}

		private void clearGroups() {
			for (int y = 0; y < board.length; y++) {
				for (int x = 0; x < board[0].length; x++) {
					if (board[y][x] == -1) {
						board[y][x] = 0;
					}
				}
			}
		}

		private boolean isStupidConfig() {
			for (int y = 0; y < board.length; y++) {
				for (int x = 0; x < board[0].length; x++) {
					if (board[y][x] == 0) {
						if (group(y, x) % 4 != 0) {
							clearGroups();
							return true; // cannot be filled by tetraminos, stupid config
						}
					}
				}
			}
			clearGroups();
			return false;
		}

		private long iterations = 0; // used to measure performance. it tells the number of times the s method was
										// called

		public long getIterations() {
			return iterations;
		}

		/**
		 * this is the actual solver. It's a brute force, greedy, divide et impera
		 * algorithm.
		 *
		 * @param p call with 1 to start solving.
		 * @return true if solveable, false otherwise
		 */
		private boolean s(int p) {
			iterations++;
//			if (iterations > 1e5) {
//				return false;
//			}
//			System.out.println("iterations " + iterations);

			if (blocksPtr >= blocks.length) {
				return true; // puzzle is solved
			}
			// extract a block from blocks left to place
			char block = blocks[blocksPtr++];
			// find a place for this block
			if (block == I) {
				// I shaped block can have 2 rotations.
				/*
				 * # # # #
				 */
				for (int y = 0; y <= board.length - 4; y++) {
					for (int x = 0; x <= board[0].length - 1; x++) {
						if (board[y][x] == 0 && board[y + 1][x] == 0 && board[y + 2][x] == 0 && board[y + 3][x] == 0) {
							// we found a hole that fits this block, we'll place it here and see if the
							// puzzle can be solved
							board[y][x] = p;
							board[y + 1][x] = p;
							board[y + 2][x] = p;
							board[y + 3][x] = p;
							if (!isStupidConfig() && s(p + 1)) {
								return true; // this is the right place for this block
							}
							// otherwise, we need to find another place
							board[y][x] = 0;
							board[y + 1][x] = 0;
							board[y + 2][x] = 0;
							board[y + 3][x] = 0;
						}
					}
				}
				// ####
				for (int y = 0; y <= board.length - 1; y++) {
					for (int x = 0; x <= board[0].length - 4; x++) {
						if (board[y][x] == 0 && board[y][x + 1] == 0 && board[y][x + 2] == 0 && board[y][x + 3] == 0) {
							// we found a hole that fits this block, we'll place it here and see if the
							// puzzle can be solved
							board[y][x] = p;
							board[y][x + 1] = p;
							board[y][x + 2] = p;
							board[y][x + 3] = p;
							if (!isStupidConfig() && s(p + 1)) {
								return true; // this is the right place for this block
							} // otherwise, we need to find another place
							board[y][x] = 0;
							board[y][x + 1] = 0;
							board[y][x + 2] = 0;
							board[y][x + 3] = 0;
						}
					}
				}
				// we couldn't fina a suitable place for this block, that means that the puzzle
				// is either unsolveable or one of the pieces is in the wrong place
				// let's put the piece back in the list and continue searching
				blocksPtr--;
				return false; // 0=couldn't find a place for this block
			}
			if (block == O) {
				// 2x2 square block can have only 1 rotation
				for (int y = 0; y <= board.length - 2; y++) {
					for (int x = 0; x <= board[0].length - 2; x++) {
						if (board[y][x] == 0 && board[y + 1][x] == 0 && board[y][x + 1] == 0
								&& board[y + 1][x + 1] == 0) {
							// we found a hole that fits this block, we'll place it here and see if the
							// puzzle can be solved
							board[y][x] = p;
							board[y + 1][x] = p;
							board[y][x + 1] = p;
							board[y + 1][x + 1] = p;
							if (!isStupidConfig() && s(p + 1)) {
								return true; // this is the right place for this block
							} // otherwise, we need to find another place
							board[y][x] = 0;
							board[y + 1][x] = 0;
							board[y][x + 1] = 0;
							board[y + 1][x + 1] = 0;
						}
					}
				}
				// we couldn't fina a suitable place for this block, that means that the puzzle
				// is either unsolveable or one of the pieces is in the wrong place
				// let's put the piece back in the list and continue searching
				blocksPtr--;
				return false; // 0=couldn't find a place for this block
			}

			if (block == T) {
				// T shaped block can have 4 rotations
				/*
				 * ### _#
				 */
				for (int y = 0; y <= board.length - 2; y++) {
					for (int x = 0; x <= board[0].length - 3; x++) {
						if (board[y][x] == 0 && board[y][x + 1] == 0 && board[y + 1][x + 1] == 0
								&& board[y][x + 2] == 0) {
							// we found a hole that fits this block, we'll place it here and see if the
							// puzzle can be solved
							board[y][x] = p;
							board[y][x + 1] = p;
							board[y + 1][x + 1] = p;
							board[y][x + 2] = p;
							if (!isStupidConfig() && s(p + 1)) {
								return true; // this is the right place for this block
							} // otherwise, we need to find another place
							board[y][x] = 0;
							board[y][x + 1] = 0;
							board[y + 1][x + 1] = 0;
							board[y][x + 2] = 0;
						}
					}
				}
				/*
				 * # ## #
				 */
				for (int y = 0; y <= board.length - 3; y++) {
					for (int x = 0; x <= board[0].length - 2; x++) {
						if (board[y][x] == 0 && board[y + 1][x] == 0 && board[y + 1][x + 1] == 0
								&& board[y + 2][x] == 0) {
							// we found a hole that fits this block, we'll place it here and see if the
							// puzzle can be solved
							board[y][x] = p;
							board[y + 1][x] = p;
							board[y + 1][x + 1] = p;
							board[y + 2][x] = p;
							if (!isStupidConfig() && s(p + 1)) {
								return true; // this is the right place for this block
							} // otherwise, we need to find another place
							board[y][x] = 0;
							board[y + 1][x] = 0;
							board[y + 1][x + 1] = 0;
							board[y + 2][x] = 0;
						}
					}
				}
				/*
				 * _# ## _#
				 */
				for (int y = 0; y <= board.length - 3; y++) {
					for (int x = 0; x <= board[0].length - 2; x++) {
						if (board[y][x + 1] == 0 && board[y + 1][x] == 0 && board[y + 1][x + 1] == 0
								&& board[y + 2][x + 1] == 0) {
							// we found a hole that fits this block, we'll place it here and see if the
							// puzzle can be solved
							board[y][x + 1] = p;
							board[y + 1][x] = p;
							board[y + 1][x + 1] = p;
							board[y + 2][x + 1] = p;
							if (!isStupidConfig() && s(p + 1)) {
								return true; // this is the right place for this block
							} // otherwise, we need to find another place
							board[y][x + 1] = 0;
							board[y + 1][x] = 0;
							board[y + 1][x + 1] = 0;
							board[y + 2][x + 1] = 0;
						}
					}
				}
				/*
				 * _# ###
				 */
				for (int y = 0; y <= board.length - 2; y++) {
					for (int x = 0; x <= board[0].length - 3; x++) {
						if (board[y + 1][x] == 0 && board[y][x + 1] == 0 && board[y + 1][x + 1] == 0
								&& board[y + 1][x + 2] == 0) {
							// we found a hole that fits this block, we'll place it here and see if the
							// puzzle can be solved
							board[y + 1][x] = p;
							board[y][x + 1] = p;
							board[y + 1][x + 1] = p;
							board[y + 1][x + 2] = p;
							if (!isStupidConfig() && s(p + 1)) {
								return true; // this is the right place for this block
							} // otherwise, we need to find another place
							board[y + 1][x] = 0;
							board[y][x + 1] = 0;
							board[y + 1][x + 1] = 0;
							board[y + 1][x + 2] = 0;
						}
					}
				}
				// we couldn't fina a suitable place for this block, that means that the puzzle
				// is either unsolveable or one of the pieces is in the wrong place
				// let's put the piece back in the list and continue searching
				blocksPtr--;
				return false; // 0=couldn't find a place for this block
			}

			if (block == J) {
				// J shaped block can have 4 rotations
				/*
				 * ### __#
				 */
				for (int y = 0; y <= board.length - 2; y++) {
					for (int x = 0; x <= board[0].length - 3; x++) {
						if (board[y][x] == 0 && board[y][x + 1] == 0 && board[y + 1][x + 2] == 0
								&& board[y][x + 2] == 0) {
							// we found a hole that fits this block, we'll place it here and see if the
							// puzzle can be solved
							board[y][x] = p;
							board[y][x + 1] = p;
							board[y + 1][x + 2] = p;
							board[y][x + 2] = p;
							if (!isStupidConfig() && s(p + 1)) {
								return true; // this is the right place for this block
							} // otherwise, we need to find another place
							board[y][x] = 0;
							board[y][x + 1] = 0;
							board[y + 1][x + 2] = 0;
							board[y][x + 2] = 0;
						}
					}
				}
				/*
				 * # ###
				 */
				for (int y = 0; y <= board.length - 2; y++) {
					for (int x = 0; x <= board[0].length - 3; x++) {
						if (board[y + 1][x] == 0 && board[y][x] == 0 && board[y + 1][x + 1] == 0
								&& board[y + 1][x + 2] == 0) {
							// we found a hole that fits this block, we'll place it here and see if the
							// puzzle can be solved
							board[y + 1][x] = p;
							board[y][x] = p;
							board[y + 1][x + 1] = p;
							board[y + 1][x + 2] = p;
							if (!isStupidConfig() && s(p + 1)) {
								return true; // this is the right place for this block
							} // otherwise, we need to find another place
							board[y + 1][x] = 0;
							board[y][x] = 0;
							board[y + 1][x + 1] = 0;
							board[y + 1][x + 2] = 0;
						}
					}
				}
				/*
				 * ## # #
				 */
				for (int y = 0; y <= board.length - 3; y++) {
					for (int x = 0; x <= board[0].length - 2; x++) {
						if (board[y][x] == 0 && board[y + 1][x] == 0 && board[y][x + 1] == 0 && board[y + 2][x] == 0) {
							// we found a hole that fits this block, we'll place it here and see if the
							// puzzle can be solved
							board[y][x] = p;
							board[y + 1][x] = p;
							board[y][x + 1] = p;
							board[y + 2][x] = p;
							if (!isStupidConfig() && s(p + 1)) {
								return true; // this is the right place for this block
							} // otherwise, we need to find another place
							board[y][x] = 0;
							board[y + 1][x] = 0;
							board[y][x + 1] = 0;
							board[y + 2][x] = 0;
						}
					}
				}
				/*
				 * _# _# ##
				 */
				for (int y = 0; y <= board.length - 3; y++) {
					for (int x = 0; x <= board[0].length - 2; x++) {
						if (board[y][x + 1] == 0 && board[y + 2][x] == 0 && board[y + 1][x + 1] == 0
								&& board[y + 2][x + 1] == 0) {
							// we found a hole that fits this block, we'll place it here and see if the
							// puzzle can be solved
							board[y][x + 1] = p;
							board[y + 2][x] = p;
							board[y + 1][x + 1] = p;
							board[y + 2][x + 1] = p;
							if (!isStupidConfig() && s(p + 1)) {
								return true; // this is the right place for this block
							} // otherwise, we need to find another place
							board[y][x + 1] = 0;
							board[y + 2][x] = 0;
							board[y + 1][x + 1] = 0;
							board[y + 2][x + 1] = 0;
						}
					}
				}
				// we couldn't fina a suitable place for this block, that means that the puzzle
				// is either unsolveable or one of the pieces is in the wrong place
				// let's put the piece back in the list and continue searching
				blocksPtr--;
				return false; // 0=couldn't find a place for this block
			}

			if (block == L) {
				// L shaped block can have 4 rotations
				/*
				 * ### #
				 */
				for (int y = 0; y <= board.length - 2; y++) {
					for (int x = 0; x <= board[0].length - 3; x++) {
						if (board[y][x] == 0 && board[y][x + 1] == 0 && board[y + 1][x] == 0 && board[y][x + 2] == 0) {
							// we found a hole that fits this block, we'll place it here and see if the
							// puzzle can be solved
							board[y][x] = p;
							board[y][x + 1] = p;
							board[y + 1][x] = p;
							board[y][x + 2] = p;
							if (!isStupidConfig() && s(p + 1)) {
								return true; // this is the right place for this block
							} // otherwise, we need to find another place
							board[y][x] = 0;
							board[y][x + 1] = 0;
							board[y + 1][x] = 0;
							board[y][x + 2] = 0;
						}
					}
				}
				/*
				 * # # ##
				 */
				for (int y = 0; y <= board.length - 3; y++) {
					for (int x = 0; x <= board[0].length - 2; x++) {
						if (board[y][x] == 0 && board[y + 1][x] == 0 && board[y + 2][x + 1] == 0
								&& board[y + 2][x] == 0) {
							// we found a hole that fits this block, we'll place it here and see if the
							// puzzle can be solved
							board[y][x] = p;
							board[y + 1][x] = p;
							board[y + 2][x + 1] = p;
							board[y + 2][x] = p;
							if (!isStupidConfig() && s(p + 1)) {
								return true; // this is the right place for this block
							} // otherwise, we need to find another place
							board[y][x] = 0;
							board[y + 1][x] = 0;
							board[y + 2][x + 1] = 0;
							board[y + 2][x] = 0;
						}
					}
				}
				/*
				 * ## _# _#
				 */
				for (int y = 0; y <= board.length - 3; y++) {
					for (int x = 0; x <= board[0].length - 2; x++) {
						if (board[y][x + 1] == 0 && board[y][x] == 0 && board[y + 1][x + 1] == 0
								&& board[y + 2][x + 1] == 0) {
							// we found a hole that fits this block, we'll place it here and see if the
							// puzzle can be solved
							board[y][x + 1] = p;
							board[y][x] = p;
							board[y + 1][x + 1] = p;
							board[y + 2][x + 1] = p;
							if (!isStupidConfig() && s(p + 1)) {
								return true; // this is the right place for this block
							} // otherwise, we need to find another place
							board[y][x + 1] = 0;
							board[y][x] = 0;
							board[y + 1][x + 1] = 0;
							board[y + 2][x + 1] = 0;
						}
					}
				}
				/*
				 * __# ###
				 */
				for (int y = 0; y <= board.length - 2; y++) {
					for (int x = 0; x <= board[0].length - 3; x++) {
						if (board[y + 1][x] == 0 && board[y][x + 2] == 0 && board[y + 1][x + 1] == 0
								&& board[y + 1][x + 2] == 0) {
							// we found a hole that fits this block, we'll place it here and see if the
							// puzzle can be solved
							board[y + 1][x] = p;
							board[y][x + 2] = p;
							board[y + 1][x + 1] = p;
							board[y + 1][x + 2] = p;
							if (!isStupidConfig() && s(p + 1)) {
								return true; // this is the right place for this block
							} // otherwise, we need to find another place
							board[y + 1][x] = 0;
							board[y][x + 2] = 0;
							board[y + 1][x + 1] = 0;
							board[y + 1][x + 2] = 0;
						}
					}
				}
				// we couldn't fina a suitable place for this block, that means that the puzzle
				// is either unsolveable or one of the pieces is in the wrong place
				// let's put the piece back in the list and continue searching
				blocksPtr--;
				return false; // 0=couldn't find a place for this block
			}

			if (block == S) {
				// S shaped block can have 2 rotations
				/*
				 * # ## _#
				 */
				for (int y = 0; y <= board.length - 3; y++) {
					for (int x = 0; x <= board[0].length - 2; x++) {
						if (board[y][x] == 0 && board[y + 1][x] == 0 && board[y + 1][x + 1] == 0
								&& board[y + 2][x + 1] == 0) {
							// we found a hole that fits this block, we'll place it here and see if the
							// puzzle can be solved
							board[y][x] = p;
							board[y + 1][x] = p;
							board[y + 1][x + 1] = p;
							board[y + 2][x + 1] = p;
							if (!isStupidConfig() && s(p + 1)) {
								return true; // this is the right place for this block
							} // otherwise, we need to find another place
							board[y][x] = 0;
							board[y + 1][x] = 0;
							board[y + 1][x + 1] = 0;
							board[y + 2][x + 1] = 0;
						}
					}
				}
				/*
				 * _## ##
				 */
				for (int y = 0; y <= board.length - 2; y++) {
					for (int x = 0; x <= board[0].length - 3; x++) {
						if (board[y][x + 1] == 0 && board[y][x + 2] == 0 && board[y + 1][x] == 0
								&& board[y + 1][x + 1] == 0) {
							// we found a hole that fits this block, we'll place it here and see if the
							// puzzle can be solved
							board[y][x + 1] = p;
							board[y][x + 2] = p;
							board[y + 1][x] = p;
							board[y + 1][x + 1] = p;
							if (!isStupidConfig() && s(p + 1)) {
								return true; // this is the right place for this block
							} // otherwise, we need to find another place
							board[y][x + 1] = 0;
							board[y][x + 2] = 0;
							board[y + 1][x] = 0;
							board[y + 1][x + 1] = 0;
						}
					}
				}
				// we couldn't fina a suitable place for this block, that means that the puzzle
				// is either unsolveable or one of the pieces is in the wrong place
				// let's put the piece back in the list and continue searching
				blocksPtr--;
				return false; // 0=couldn't find a place for this block
			}

			if (block == Z) {
				// Z shaped block can have 2 rotations
				/*
				 **
				 * _**
				 */
				for (int y = 0; y <= board.length - 2; y++) {
					for (int x = 0; x <= board[0].length - 3; x++) {
						if (board[y][x] == 0 && board[y][x + 1] == 0 && board[y + 1][x + 1] == 0
								&& board[y + 1][x + 2] == 0) {
							// we found a hole that fits this block, we'll place it here and see if the
							// puzzle can be solved
							board[y][x] = p;
							board[y][x + 1] = p;
							board[y + 1][x + 1] = p;
							board[y + 1][x + 2] = p;
							if (!isStupidConfig() && s(p + 1)) {
								return true; // this is the right place for this block
							} // otherwise, we need to find another place
							board[y][x] = 0;
							board[y][x + 1] = 0;
							board[y + 1][x + 1] = 0;
							board[y + 1][x + 2] = 0;
						}
					}
				}
				/*
				 * _# ## #
				 */
				for (int y = 0; y <= board.length - 3; y++) {
					for (int x = 0; x <= board[0].length - 2; x++) {
						if (board[y][x + 1] == 0 && board[y + 1][x] == 0 && board[y + 1][x + 1] == 0
								&& board[y + 2][x] == 0) {
							// we found a hole that fits this block, we'll place it here and see if the
							// puzzle can be solved
							board[y][x + 1] = p;
							board[y + 1][x] = p;
							board[y + 1][x + 1] = p;
							board[y + 2][x] = p;
							if (!isStupidConfig() && s(p + 1)) {
								return true; // this is the right place for this block
							} // otherwise, we need to find another place
							board[y][x + 1] = 0;
							board[y + 1][x] = 0;
							board[y + 1][x + 1] = 0;
							board[y + 2][x] = 0;
						}
					}
				}
				// we couldn't fina a suitable place for this block, that means that the puzzle
				// is either unsolveable or one of the pieces is in the wrong place
				// let's put the piece back in the list and continue searching
				blocksPtr--;
				return false; // 0=couldn't find a place for this block
			}
			return false; // this instruction is not reachable, it's here because java complains that the
							// method may not have a return value
		}

		private boolean solved = false, solveable = false;

		/**
		 * call this method to start solving. may take some time
		 *
		 * @return true if solveable, false otherwise
		 */
		public boolean solve() {
			if (!solved) {
				solveable = (nPieces * 4 == board.length * board[0].length) && s(1); // solve it
				solved = true;
			}
			return solveable;
		}
	}

	boolean trySubset(int[] blocks, int numBlock) {
		int total = numBlock * 4;
//		System.out.println("Total " + total);
//		if (total % 16 == 0) {
//			TetrisPuzzleSolver solver16 = new TetrisPuzzleSolver(16, total / 16, blocks[0], blocks[1], blocks[6],
//					blocks[5], blocks[2], blocks[3], blocks[4]);
//
//			if (solver16.solve()) {
//				return true;
//			}
//		}
		if (total % 10 == 0) {
			TetrisPuzzleSolver solver10 = new TetrisPuzzleSolver(10, total / 10, blocks[0], blocks[1], blocks[6],
					blocks[5], blocks[2], blocks[3], blocks[4]);

			if (solver10.solve()) {
				return true;
			}
		}

		if (total % 12 == 0) {
			TetrisPuzzleSolver solver12 = new TetrisPuzzleSolver(12, total / 12, blocks[0], blocks[1], blocks[6],
					blocks[5], blocks[2], blocks[3], blocks[4]);

			if (solver12.solve()) {
				return true;
			}
		}
		if (total % 8 == 0) {
			TetrisPuzzleSolver solver3 = new TetrisPuzzleSolver(8, total / 8, blocks[0], blocks[1], blocks[6],
					blocks[5], blocks[2], blocks[3], blocks[4]);

			if (solver3.solve()) {
				return true;
			}
		}
		TetrisPuzzleSolver solver1 = new TetrisPuzzleSolver(4, total / 4, blocks[0], blocks[1], blocks[6], blocks[5],
				blocks[2], blocks[3], blocks[4]);

		if (solver1.solve()) {
			return true;
		}

		TetrisPuzzleSolver solver4 = new TetrisPuzzleSolver(2, total / 2, blocks[0], blocks[1], blocks[6], blocks[5],
				blocks[2], blocks[3], blocks[4]);

		if (solver4.solve()) {
			return true;
		}

		if (total % 6 == 0) {
			TetrisPuzzleSolver solver2 = new TetrisPuzzleSolver(6, total / 6, blocks[0], blocks[1], blocks[6],
					blocks[5], blocks[2], blocks[3], blocks[4]);

			if (solver2.solve()) {
				return true;
			}
		}

		return false;
	}

	HashMap<String, Integer> map = new HashMap<String, Integer>();

	String getKey(int[] blockNumber) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < blockNumber.length; i++) {
			sb.append(blockNumber[i] < 10 ? "0" + blockNumber[i] : blockNumber[i]);
		}
		return sb.toString();
	}

	int trySolve(int[] blockNumber, int numBlock) {
		if (numBlock == 0) {
			return 0;
		}
		String key = getKey(blockNumber);
		if (map.containsKey(key)) {
			return map.get(key);
		}
//		System.out.println("Solve " + numBlock + " key = " + key);

		if (trySubset(blockNumber, numBlock)) {
			map.put(key, numBlock);
			return numBlock;
		}
		for (int i = blockNumber.length - 1; i >= 0; i--) {
			if (blockNumber[i] > 0) {
				blockNumber[i] -= 1;
				int check = trySolve(blockNumber, numBlock - 1);
				if (check > 0) {
					String subkey = getKey(blockNumber);
					map.put(subkey, numBlock - 1);
					return numBlock - 1;
				}
				blockNumber[i] += 1;
			}
		}
		map.put(key, 0);
		return 0;
	}

	int biggestRectangle(int[] blockNumber) {
		int[] all2 = new int[] { 2, 2, 2, 2, 2, 2, 2 };
		map.put(getKey(all2), 14);
		map.put(getKey(new int[] { 3, 2, 2, 2, 2, 2, 2 }), 15);
		map.put(getKey(new int[] { 2, 3, 2, 2, 2, 2, 2 }), 15);
		map.put(getKey(new int[] { 2, 2, 3, 2, 2, 2, 2 }), 15);
		map.put(getKey(new int[] { 2, 2, 2, 3, 2, 2, 2 }), 15);
		map.put(getKey(new int[] { 2, 2, 2, 2, 3, 2, 2 }), 15);
		map.put(getKey(new int[] { 2, 2, 2, 2, 2, 3, 2 }), 15);

		if (blockNumber == null || blockNumber.length == 0) {
			return 0;
		}
		int totalNumber = 0;
		for (int i = 0; i < blockNumber.length; i++) {
			totalNumber += blockNumber[i];
		}

		int blockNum = trySolve(blockNumber, totalNumber);
		return blockNum * 4;
	}

	public static void main(String[] args) {

//		System.out.println(new Solution().biggestRectangle(new int[] { 2, 2, 2, 2, 2, 2, 2 }));
//		System.out.println(new Solution().biggestRectangle(new int[] { 1, 2, 3, 4, 5, 6, 7 }));

	}
}
