# TransactionAnalyser
This project is a Java 8 + Gradle project. It can be built, ran and tested by gradle wrapper.


#### Run unit tests

To run all unit tests, run the following command:
`./gradlew test`

#### Build the project

To the project, run the following command:
`./gradlew build`
this command will run the unit tests as well.


#### Run the project

To run project with sample inputs, run the following command:
`./gradlew run`
This command will run the same example as in the assessment.

to run the project with other inputs:
`./gradlew run --args="ABSOLUTE_PATH_TO_CSV_FILE ACCOUNT_NUMBER 'FROM_DATE' 'TO_DATE'"`

for example:
`./gradlew run --args="/home/users/myuser/data/input2.csv ACC334455 '20/10/2018 12:00:00' '20/10/2018 19:00:00'"`


