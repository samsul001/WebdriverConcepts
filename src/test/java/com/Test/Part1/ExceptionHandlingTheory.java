package com.Test.Part1;

//Exception:- Exception is an abnormal event which terminates the program unexpectedly, rest of the code will not execute.
//Exception Handling:- Exception handling is a process of handling exception which suppose to terminate program unexpectedly

//2 types of Exception:-
//1.Checked Exception, 2.Un-checked Exception

//Checked Exception:- Checked Exception which are identified by Java Compiler
//Example for Checked Exception :- IOException, FileNotFoundException, SQLException etc.,

//Un-checked Exception:- Un checked Exception which are not identified by Java Compiler
//Unchecked exceptions are known as Runtime exception
//Example for Unchecked Exception:- Arithmetic Exception, NullPointerexception, NumberFormatException, ArrayIndexOutofBoundException etc.,

//Methods of Exception handling
//try block - specify the statement which causes exception
//catch block - Handles the exception if any, always used for printing message from exception
//finally block - some code(not mandatory), it will have recovery code
//throw => This is used to throw an exception (obviously throw whether catch block handling the exception or not)
//throws => This used to handle exception in method level, Checked exception is mainly handled by this keyword.

//Use of finally block -> let me say Database connection example
//If we want to connect a db through java program , we will establish the connection to db. When will program establish connection ? If db is
//available, then will establish the connection or else it throws exception. In try block, we will put the connection details
//If connection is there , no issue. But if connection is  not there / suppose db is not available, then it throw an execption.
//before handling the exception, catch block just will print the exception type, it wont handle anything, in the finally block, some other
//db connection will be specified ,  that is the recovery step, If one db connection is failed to connect, use some other db connection



//Three scenarios is in try, catch and finally blocks working process
//1. Exception occurs, catch block handles, finally block also execute
//2. Exception occurs, catch block does not handle, finally block execute
//3. Exception not occurs, catch block will ignore, finally block execute

//Checked Exception:-
//1. Catch block always wont handle exception
//2. throws keyword only used for checked exception. throws keyword applied in method level where as try catch block applied in statement level

//Hierarchy of Selenium WebDriver Exception
//java.lang.Object -> java.lang.Throwable -> java.lang.Exception -> java.lang.RuntimeException -> org.openqa.selenium.WebDriverException




public class ExceptionHandlingTheory {

}
