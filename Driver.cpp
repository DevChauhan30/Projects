/*
	Title:  Driver.cpp
	Author:  Dev Chauhan
	Date:  11/7/2017
	Purpose:  To demonstrate the Movies, Movie, and Text structure code working
	by allowing the user to add, save, delete, and edit movies to/from a library.
*/

#include "Movies.h"
#include "Movie.h"
#include "Text.h"
#include <iostream>
using namespace std;

int main()
{
	int menuChoice;
	int maxMovies;
	char filename[25];	
	
	cout << "\n\nWhat is the maximum number of movies you can have in your library?\n";
	cin >> maxMovies;
	while(maxMovies <= 0)
	{
		cout << "\n\nYou have to have at least one movie in your library.\n";
		cout << "What is the maximum number of movies you can have in your library.\n";
		cin >> maxMovies;
	}
	Movies* movieLibrary =  new Movies(maxMovies);
	
	do
	{
		cout << "\n\nWhat would you like to do?\n";
		cout << "1.  Read movies from file.\n";
		cout << "2.  Save movies to a file.\n";
		cout << "3.  Add a movie.\n";
		cout << "4.  Delete a movie.\n";
		cout << "5.  Edit a movie.\n";
		cout << "6.  Print all movies.\n";
		cout << "7.  Delete ALL movies and end the program.\n";
		cout << "CHOOSE 1-7:  ";
		cin >> menuChoice;
		while(menuChoice < 1 || menuChoice > 7)
		{
			cout << "That is not a valid choice.\n";
			cout << "CHOOSE 1-7:  ";
			cin >> menuChoice;
		}
		
		switch(menuChoice)
		{
			case 1:	cout << "\n\nWhat is the name of the file? (example.txt):  ";
					cin >> filename;
					movieLibrary->readMoviesFromFile(filename, movieLibrary); //function is in Movies.cpp
					break;
					
			case 2: cout << "\n\nWhat do you want to name the file? (example.txt):  ";
					cin >> filename;
					movieLibrary->saveToFile(filename); //function is in Movies.cpp
					 
					break;
					
			case 3:	//add a movie
					movieLibrary->addMovieToArray();
					break;
					
			case 4:	//remove a movie
					movieLibrary->removeMovieFromArray();					
					break;
					
			case 5: //edit a movie
					movieLibrary->editMovieInArray();					
					break;
					
			case 6: //print all movies
					movieLibrary->displayMovies();
					break;
					
			case 7: //delete all movies
					movieLibrary->~Movies();
					break;
					
		}
		
	} while(menuChoice != 7);
	
	cout << "\n\nGOODBYE!\n\n";
	
	return 0;
}
