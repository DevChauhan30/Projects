/*
	Title:  Movies.h
	Author:  Dev Chauhan
	Date:  11/7/2017
	Purpose:  Be able to create, manage, print, save & delete a movie library
*/
#ifndef MOVIES_H
#define MOVIES_H

#include "Movie.h"
#include <iostream>
#include <fstream>
#include <iomanip>

using namespace std;

class Movies
{
	
	private:

		Movie** MoviesArray;
		int maxMovies;
		int numMovies;	
	
	public:

		Movies(int);
		void addMovieToArray(); 
		void editMovieInArray();

		// accessor Functions
		Movie** getMovieArray() const; //an array of pointers - each pointer points to a single Movie
		int getMaxMovies() const; //maximum number of elements in the array
		int getNumMovies() const; //current number of movies in the array

		//Mutator Functions
		void setMovieArray(Movies** array);
		void setMaxMovies(int movies);
		void setNumMovies(int movies);
		void setAMoviesFromArray(Movies** array);

	/*
	Function name:  createMovies 
	Parameters:  	An integer containing the maximum size of the movie library 
	Returns: 		A pointer to a new Movies structure
	Purpose:  		This function should be called when the user needs to create a library
				of movies.  The function will dynamically allocate a movies array based
					on the maximum size and will also set the current number of movies to zero.
	*/

	/*
	Function name:  addMovieToArray 
	Parameters:  	1) The movies structure (which contains the movie library) 
	Returns: 		none
	Purpose:  		This function should be called when you need to add a single movie to the
					movie library.
	*/

	/*
	Function name:  editMovieInArray 
	Parameters:  	The movies structure (which contains the movie library) 
	Returns: 		none
	Purpose:  		This function should be called when you need to edit a movie in the array
	*/

	/*
	Function name:  destroyMovies 
	Parameters:  	1) The movies structure (which contains the movie library) 
	Returns: 		none (void)
	Purpose:  		This function should be called when you need to remove all the single 
					movies in the movie library as well as the movie library.  This releases
					all the dynamically allocated space in memory.
	*/
	
	~Movies();

	/*
	Function name:  displayMovies 
	Parameters:  	1) The movies structure (which contains the movie library) 
	Returns: 		none (void)
	Purpose:  		This function should be called when the user wants to have all the movies
					in the library printed to the screen.
	*/
	void displayMovies();

	/*
	Function name:  displayMovieTitles 
	Parameters:  	1) The movies structure (which contains the movie library) 
	Returns: 		none (void)
	Purpose:  		This function should be called when you want to print only the movie titles
					out of the movie library
	*/
	void displayMovieTitles();

	/*
	Function name:  readMoviesFromFile 
	Parameters:  	1) A pointer to a character (c-string or string literal argument) containing the filename
					2) The movies structure (which contains the movie library) 
	Returns: 		none (void)
	Purpose:  		This function should be called when the user wants to read movie data from a file
					and add the movies to the movie library.  The file must have data in the following order:
					title, length, year, genre, rating, num oscars won, star rating
	*/
	void readMoviesFromFile(char* filename, Movies* myMovies);

	/*
	Function name:  removeMovieFromArray 
	Parameters:  	The movies structure (which contains the movie library) 
	Returns: 		none (void)
	Purpose:  		This function should be called when the user wants to remove one single movie
					from the movie library.  The function will list all the movie names and allow
					the user to select the movie that they wish to remove. Then this function removes the movie.
	*/
	void removeMovieFromArray();

	/*
	Function name:  saveToFile 
	Parameters:  	1) A pointer to a character (c-string or string literal argument) containing the filename
					2) The movies structure (which contains the movie library) 
	Returns: 		none (void)
	Purpose:  		This function should be called when the user wants to print all the movie data
					from the movie library to a file.  The data is printed in the following order (one piece
					of data per line):
					title, length, year, genre, rating, num oscars won, star rating
	*/
	void saveToFile(char *filename);

	/*
	Function name:  resizeMovieArray 
	Parameters:  	The movies structure (which contains the movie library) 
	Returns: 		none (void)
	Purpose:  		This function is called by addMovieToArray when the array size is not big enough
					to hold a new movie that needs to be added.  The function makes the array twice
					as big as it currently is and then moves all the movie pointers to this new array.
	*/
	void resizeMovieArray();
};

#endif