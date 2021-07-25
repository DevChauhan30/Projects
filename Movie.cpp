/*
	Title:  Movie.cpp
	Author:  Dev Chauhan
	Date:  11/7/2017
	Purpose:  Be able to create, manage, print & delete a single movie.
*/
#include "Movie.h"
#include "Text.h"

Movie::Movie(Text* title, int length)
{
	//assign parameter data to structure memebers
	movieTitle = title;
	movieLength = length;
	
}

Movie::Movie(Text* title, int length, int year, Text* genre, Text* rating, int nom, float stars) //all info is know
{
	
	//assign parameter data to structure members
	movieTitle = title;
	movieLength = length;
	movieYear = year;
	movieGenre = genre;
	movieRating = rating;
	movieOscars = nom;
	movieNumStars = stars;
	
}

Movie::~Movie()
{
	delete movieTitle;
	delete movieGenre;
	delete movieRating;
}

void Movie::printMovieDetails()
{
	cout << endl;
	cout << right << setw(30) << "Movie Title:  " << left;
	movieTitle->displayText();
	cout << endl;
	cout << right << setw(30) << "Length (minutes):  " << left << movieLength << endl;
	cout << right << setw(30) << "Year Released:  " << left << movieYear << endl;
	cout << right << setw(30) << "Genre:  " << left;
	movieGenre->displayText();
	cout << endl;
	cout << right << setw(30) << "Rating:  " << left;
	movieRating->displayText();
	cout << endl;
	cout << right << setw(30) << "Number of Oscars Won:  " << left << movieOscars << endl;
	cout << right << setw(30) << "Number of Stars:  " << left << movieNumStars << endl << endl;
}

void Movie::printMovieDetailsToFile( ofstream &outFile)
{
	char temp[1000];
	strncpy(temp, movieTitle->getText(), 1000);
	outFile << temp << endl;
	outFile << movieLength << endl;
	outFile << movieYear << endl;
	strncpy(temp, movieGenre->getText(), 1000);
	outFile << temp << endl;
	strncpy(temp, movieRating->getText(), 1000);
	outFile << temp << endl;
	outFile << movieOscars << endl;
	outFile << movieNumStars << endl;
}


void Movie::editMovie()
{
	int choice;
	Text* tempText;
	char temp[100];
	
	do
	{
		cout << "\n\nWhich detail do you wish to edit?\n";
		cout << "1.  Title\n";
		cout << "2.  Length\n";
		cout << "3.  Year\n";
		cout << "4.  Genre\n";
		cout << "5.  Rating\n";
		cout << "6.  Number of Oscars Won\n";
		cout << "7.  Number of Stars\n";
		cout << "8.  DONE EDITING\n";
		cout << "CHOOSE 1-8:  ";
		cin >> choice;
		while(choice < 1 || choice > 8)
		{
			cout << "\nOOPS!  Enter choice 1 through 8:  ";
			cin >> choice;
		}
		cin.ignore();
		
		switch(choice)
		{
			case 1: cout << "\nCurrent Title: ";
					movieTitle->displayText();
					cout << "\nNEW TITLE:  ";
					cin.getline(temp, 100);
					tempText = new Text(temp);
					movieTitle = tempText;
					break;
			
			case 2:	cout << "\nCurrent Length: " << movieLength;
					cout << "\nNEW LENGTH:  ";
					cin >> movieLength;
					break;
					
			case 3: cout << "\nCurrent Year: " << movieYear;
					cout << "\nNEW LENGTH:  ";
					cin >> movieYear;
					break;
					
			case 4:	cout << "\nCurrent Genre: ";
					movieGenre->displayText();
					cout << "\nNEW GENRE:  ";
					cin.getline(temp, 100);
					tempText = new Text(temp);
					movieGenre = tempText;
					break;
					
			case 5: cout << "\nCurrent Rating: ";
					movieRating->displayText();
					cout << "\nNEW GENRE:  ";
					cin.getline(temp, 100);
					tempText = new Text(temp);
					movieRating = tempText;
					break;
			
			case 6: cout << "\nCurrent Number of Oscars Won: " << movieOscars;
					cout << "\nNEW NUMBER OF OSCARS:  ";
					cin >> movieOscars;
					break;
					
			case 7:	cout << "\nCurrent Star Rating from IMDB: " << movieNumStars;
					cout << "\nNEW STAR RATING:  ";
					cin >> movieNumStars;
					break;
		}
	}while(choice != 8);
}

Text *Movie::getmovieTitle() const
{
	return this->movieTitle;
}

int Movie::getmovieLength() const
{
	return this->movieLength;
}

int Movie::getmovieYear() const
{
	return this->movieYear;
}

Text* Movie::getmovieGenre() const
{
	return this->movieGenre;
}

Text* Movie::getmovieRating()const
{
	return this->movieRating;
}

int Movie::getmovieOscars() const
{
	return this->movieOscars;
}

float Movie::getmovieNumStars() const
{
	return this->movieNumStars;
}

void Movie::setMovieTitle(Text* title)
{
	this->movieTitle = title;
}

void Movie::setMovieLength(int length)
{
	this->movieLength = length;
}

void Movie::setMovieYear(int year)
{
	this->movieYear = year;
}

void Movie::setMovieGenre(Text* genre)
{
	this->movieGenre = genre;
}

void Movie::setMovieRating(Text* rating)
{
	this->movieRating = rating;
}

void Movie::setMovieOscars(int oscars)
{
	this->movieOscars = oscars;
}

void Movie::setMovieNumStars(float stars)
{
	this->movieNumStars = stars;
}
