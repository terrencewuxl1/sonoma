# sonoma exercise

> sonoma code challenge exercise

> exercise question:

	BACKGROUND
	Sometimes items cannot be shipped to certain zip codes, and the rules for these restrictions  
	 are stored as a series of ranges of 5 digit codes. 
	
	For example, if the ranges are:	[94133,94133] [94200,94299] [94600,94699]

	Then the item can be shipped to zip code 94199, 94300, and 65532, but cannot be shipped to   
	94133, 94650, 94230, 94600, or 94299.

	Any item might be restricted based on multiple sets of these ranges obtained from multiple sources.

	PROBLEM
	Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds  
	, provide an algorithm that produces the minimum number of ranges required
	to represent the same restrictions as the input.
	
	EXAMPLES:
	If the input = [94133,94133] [94200,94299] [94600,94699]
	Then the output should be = [94133,94133] [94200,94299] [94600,94699]

	If the input = [94133,94133] [94200,94299] [94226,94399] 
	Then the output should be = [94133,94133] [94200,94399]

## Features

	supply the function that given the ZIP code ranges, return the minimum number of ZIP  
	 code ranges still represent the same restrictions.

### Assumption
	
	1.zip range format is [xxxxx,xxxxx], the first number of range not larger than the second,
	  otherwise, should be processed as the range only contains the first zip code. example:
	  [95001,94001] -> [95001,95001]
	2.project supply a main method for running in the command environment, each arg as a range,
	  assumed the args no longer than the length command accept. 

## Tests

	includes 15 unit test cases specific cover difference ZIP code ranges situation.
	
## Installation
	
### Clone

- Clone this repo to your local machine using `https://github.com/terrencewuxl1/sonoma.git`

### Setup to project reference

	use maven deploy command deploy this project to the internal repository, or intall to local
	repository then configure dependency  
	
	<dependency>  
		<groupId>exercise</groupId>  
		<artifactId>zip-code</artifactId>  
		<version>1.0-SNAPSHOT</version>  
	<dependency>  

	in your project's pom.xml.
	
### How to use

	maven package to jar file, directory run in command environment 
	using java -jar <jar name> <zip range> <zip range>...  command

	configure maven dependency in maven project, new a ZipCodeRangeUtil object, call its function
	, see example in unit test cases.
	
	




