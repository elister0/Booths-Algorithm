# Booth's Algorithm Simulator

**Author:** Emily Lister  
**Course:** Computer Systems 
**Language:** Java  

---

## Project Description

This program simulates **Booth's multiplication algorithm** for signed 4-bit integers.  
Booth's algorithm is a technique used in computer architecture to perform efficient multiplication using **addition, subtraction, and arithmetic shifts**.

The program:

- Accepts two 4-bit binary numbers as input (multiplicand and multiplier)
- Performs step-by-step Booth multiplication
- Displays intermediate registers (`A`, `Q`, `Q-1`) and the decimal result
- Illustrates the arithmetic shift and addition/subtraction operations at each iteration

This project demonstrates concepts in:

- Low-level arithmetic operations
- Binary number representation
- Computer architecture and signed integer handling

---

## How to Compile

Use the Java compiler in your terminal:

java BoothAlgorithm

The program will prompt for:
- Multiplicand: 4-bit binary string (e.g., 0101)
- Multiplier: 4-bit binary string (e.g., 1100)

It will then output the state of the algorithm for each iteration, including:
- Multiplicand (M)
- Multiplier (Q)
- Accumulator (A)
- Q-1 register
- Decimal product

## Features
- Handles signed 4-bit integers
- Implements Booth’s addition/subtraction logic
- Provides step-by-step iteration output
- Demonstrates arithmetic right shifts and binary operations

## Notes
- Input must be exactly 4 bits.
- Program is for educational purposes to illustrate Booth’s algorithm.
- Overflow is not handled beyond 4-bit signed integers.
