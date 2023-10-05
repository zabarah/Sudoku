# Sudoku Solver Program
## Running the Sudoku Solver Program

To use the Sudoku Solver program, follow these steps:

1. **Prepare a Sudoku Puzzle File**:
   - Create a text file containing the Sudoku puzzle you want to solve. Use spaces to separate each column, and start a new line for each row. See test1.txt as an file example. It should like the following:

     ```
0 0 2 0 0 0 0 4 1
0 0 0 0 8 2 0 7 0
0 0 0 0 4 0 0 0 9
2 0 0 0 7 9 3 0 0
0 1 0 0 0 0 0 8 0
0 0 6 8 1 0 0 0 4
1 0 0 0 9 0 0 0 0
0 6 0 4 3 0 0 0 0
8 5 0 0 0 0 4 0 0

     ```

   - Save this file.

2. **compile the Sudoku Solver**:
   - Open your command prompt or terminal.
   - Navigate to the directory where your Sudoku Solver Java code is located.
   - Compile the code using th following command"
     ```
     javac Sudoku.java
     ```

3. **Execute the Program**:
   - Run the program by executing the following command:
     ```
     java Sudoku your_sudoku_file.txt
     ```
     Replace `SudokuSolver` with the actual name of your Java program file and `your_sudoku_file.txt` with the name of the Sudoku puzzle file you created in step 1.

4. **View the Solution**:
   - The program will process the Sudoku puzzle and display the solved puzzle on the screen. You will see the solution in a grid format.

That's it! You have successfully run the Sudoku Solver program and obtained the solution for the provided puzzle file.

Make sure that you have Java installed on your system and that your Java program handles the command-line arguments correctly to read the puzzle file.



## Architecture Choices

## 1. Introduction

This document outlines the architectural choices and design decisions made during the implementation of the Sudoku Solver program. It elaborates on the selection of algorithms, data structures, and user interface components.

The Sudoku Solver program was implemented in Java, utilizing a Java 2D array for grid representation. Input is provided through text files containing the initial Sudoku puzzle, and the output is displayed on the screen. The primary solving algorithm is the Backtracking Algorithm, supported by recursion to traverse possible solutions.

## 2. Algorithm Selection

### 2.1 Sudoku Solving Algorithm

The core architectural choice for implementing the Sudoku Solver program was the selection of the **Backtracking Algorithm** combined with **Recursion**. Here's a more detailed explanation of this choice:

- **Backtracking Algorithm:** We chose the Backtracking Algorithm because it offers several advantages:

  - **Deterministic Solution:** Backtracking guarantees finding a solution if one exists. This is essential for Sudoku puzzles where a valid solution must be found or the puzzle declared unsolvable.

  - **Exploration of Solution Space:** It systematically explores possible solutions by iteratively filling cells with values and backtracking when a conflict or invalid solution is encountered.

  - **Avoidance of Complex Data Structures:** We considered an alternative iterative approach that required maintaining a hashmap of number combinations that didn't work. However, we opted for the Backtracking Algorithm with recursion due to its ability to navigate the solution space without the need for additional complex data structures.

- **Recursion:** To implement the Backtracking Algorithm, recursion was chosen as the design approach. This decision was made for the following reasons:

  - **Natural Representation:** Recursion naturally represents the depth-first exploration of possible Sudoku configurations. It mirrors the problem-solving process where choices are made sequentially, backtracking when necessary.

  - **Ease of Implementation:** A recursive approach simplified the code structure and avoided the need for complex data structures to track possibilities. It also aligns well with the nature of Sudoku puzzles.

## 3. Data Structures

### 3.1 Grid Representation

For representing the Sudoku grid, we utilized a **Java 2D Array**. This choice provides several advantages:

- **Efficiency:** Java 2D arrays offer efficient access to individual cells, which is crucial for Sudoku puzzle manipulation.

- **Clarity:** The 2D array representation aligns closely with the visual structure of Sudoku grids, making the code more readable and intuitive.

## 4. Input and Output

### 4.1 Puzzle Input

Puzzle input is achieved by providing a text file containing the initial Sudoku grid. The program reads the file, parses the numbers, and populates the 2D array accordingly. This approach allows for flexibility in puzzle input and supports both simple and complex puzzles.

### 4.2 Output

The solved Sudoku puzzle is printed on the screen, providing users with the solution in a readable grid format. This approach ensures a straightforward and accessible way for users to view the results.

## 5. Conclusion

The architecture choices made for the Sudoku Solver program in Java, including the Backtracking Algorithm with recursion, the use of a Java 2D array for grid representation, and the file-based input method, have been carefully considered to ensure accuracy, efficiency, ease of use, and a straightforward implementation. These choices align with the program's objectives of solving Sudoku puzzles effectively while maintaining clarity in code structure.

This architecture document serves as a reference for understanding the rationale behind these choices and their impact on the overall implementation of the Sudoku Solver program. It reinforces the decision to use Backtracking with recursion as the primary algorithmic approach and 2D arrays for grid representation.


## 6. Problems Faced

Throughout the development of the Sudoku Solver program, several challenges and problems were encountered. This section outlines some of the key difficulties faced and how they were addressed:

### 6.1 Row Checking

One initial challenge was related to the row-checking mechanism in the puzzle-solving algorithm. There was a difficulty in ensuring that each number appeared only once in each row of the Sudoku grid. This issue was addressed by refining the row-checking logic to correctly identify and handle conflicts.

### 6.2 3x3 Box Checking

Another challenge arose when implementing the algorithm to check the 3x3 boxes within the Sudoku grid. Ensuring that each number occurred only once within each 3x3 box initially required additional effort. The approach was refined, and the code was optimized to perform box checking efficiently.

### 6.3 Iterative Methods vs. Backtracking

During development, there was an exploration of alternative iterative methods for solving Sudoku puzzles. However, it became evident that such methods would complicate the backtracking approach and increase the complexity of the code. Moreover, an iterative approach would necessitate the maintenance of a hashmap to track combinations that didn't work, which would introduce unnecessary overhead.

### 6.4 Recursion and Depth-First Search

After experimenting with different solving strategies, it was concluded that recursion, combined with the Backtracking Algorithm, offered a more elegant and effective solution. This approach aligned with the depth-first search method, allowing the program to explore possible Sudoku configurations systematically. The recursive design simplified the code structure, enhanced readability, and proved to be a more suitable choice for solving Sudoku puzzles.

These challenges and the corresponding solutions played a significant role in shaping the final architecture and design of the Sudoku Solver program. They underscored the importance of iterative problem-solving and adaptation during the development process.
