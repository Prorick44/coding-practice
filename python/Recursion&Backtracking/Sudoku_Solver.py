class Solution:
    def solveSudoku(self, board):

        def valid(row, col, num):

            for i in range(9):
                if board[row][i] == num:
                    return False

                if board[i][col] == num:
                    return False

            boxRow = (row // 3) * 3
            boxCol = (col // 3) * 3

            for i in range(boxRow, boxRow + 3):
                for j in range(boxCol, boxCol + 3):
                    if board[i][j] == num:
                        return False

            return True

        def solve():
            for i in range(9):
                for j in range(9):

                    if board[i][j] == ".":

                        for num in "123456789":

                            if valid(i, j, num):
                                board[i][j] = num

                                if solve():
                                    return True

                                board[i][j] = "."

                        return False

            return True

        solve()