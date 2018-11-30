# jetbrains-scala-ex
This is a repository that solves certain puzzles
It contains solution to 2 problems specified in the assignment.


## Warm-Up
Please find the solution to this problem in the file
+ com
    + jetbrains
        + assignment
            + warmup
                + Exp2
                
The datatype of `x` is assumed to be Integer in this case.
The recursive version of the problem runs `2x` times. The non-recursive version
computes the exponent in one instruction execution. The time complexity of un-optimized
recursive version is `O(n)` while that of optimised non-recursive is `O(1)`.

## Using APIs and Testing: JSON serialization
Please find the solution to this problem in the package
+ com
    + jetbrains
        + assignment
            + JSONSerialization

`json4s` and pattern matching is used for serialization and deserialization. The serialization and deserialization both are
carried taking into consideration the boundary conditions that the type `BooleanExpression` specified in the problem impose.

## Testing
Both the problems are tested exhaustively using `ScalaTest` with `FunSuite`. Please find the tests in the package
+ com
    + jetbrains
        + assignment
            + test
              
  