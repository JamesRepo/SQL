
JSON ----> SQL 
==============


---- Instructions ----

This program is used entirely through the command line.

Follow the instructions that appear. 

First enter the input file, make sure you have the '.json' on the end. 

Next type in the name of the table you wish to have.

Next choose whether to write the SQL to a file or to the console. Enter the number to pick an option (eg. 1):
1. Writes the SQL to a file. If you choose this option it will ask the you to specify a file name.
2. Prints the SQL to the console. 


---- Design choices ----

I created two tables to handle the parameters. I realised the parameters could conceivably have a lot more elements so it was neccesary. 

To query the database you would have to use a join like this:

SELECT Sites.*, Parameters.*
FROM Sites
INNER JOIN Parameters ON Sites.UniqueId = Parameters.SiteId