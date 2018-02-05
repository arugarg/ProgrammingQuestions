# ProgrammingQuestions - Problem Statement   

**Problem Statement***  
Here is an example sequence in an input file:  
add, 1, 5  
remove, 2, 3  
add, 6, 8  
remove, 4, 7  
add, 2, 7  
  
The output file would contain the state of the intervals at each step of the sequence.   
Assume that the output array is initially []. The following is the expected content of   
the output file for the above example input sequence.  

[[1, 5]]  
[[1, 2], [3, 5]]  
[[1, 2], [3, 5], [6, 8]]  
[[1, 2], [3, 4], [7, 8]]  
[[1, 8]]  

*** Running the code***  

1.All the source code is in src   
2.In src folder Run the Driver java class with 2 inputs one for input csv file the other for output text file  
  e.g. Compiling : javac Driver.java  
       Running   : Driver ./InputFiles/input.csv ./OutputFiles/output.txt  
3.Can run the test cases in test folder JunitTest cases
4.For creating random input file you can generate it from GenerateInput class.  

or Alternativel can run directly via runnable jar file via command line  
  e.g. java -jar disjoint.jar "InputFiles/input.csv" "OutputFiles/output.txt"  

************************************************************************************
