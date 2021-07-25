/*
	Title:  Text.cpp
	Author:  Dev Chauhan
	Date:  11/7/2017
	About:  A structure version of the C++ string class
*/

#include "Text.h"

using namespace std;

Text::Text(const char* text)
{
	//dynamically allocate a new Text

	
	//get the length of the string passed to this function
	textLength = strlen(text);
	
	//dynamically allocate a new character array
	//the line below wont work because I need textArray to be const but I can't dynamically allocate a const char array 
	//myText->textArray = new char[(myText->textLength)+1];
	char* tempTextArray = new char[(textLength)+1];
	
	/*
		Now put text inside of tempTextArray
		I can either use the cstring function called strcpy OR
		I could have created a for loop and copy one character at a time.
	*/
	strcpy(tempTextArray, text); 
	
	//put the text sent to this function into the newly created array
	//I can do assignment because it is assigning a pointer (not a cstring)
	textArray = tempTextArray;	
	
}

void Text::destroyText()
{
	//create a temporary c-string to make the syntax easier to delete the array
	const char* tempTextArray = textArray;
	//delete the character array (c-string), which is inside the structure
	delete [] tempTextArray;
	//delete the entire structure
}

void Text::displayText()
{
	//print out the c-string
	cout << textArray;
}

const char* Text::getText()
{
	const char* textArray;
	return textArray;
}

int getLength()
{
	int textLength;
	return textLength;
}

int editText()
{
	const char* textArray;
	delete textArray;

}