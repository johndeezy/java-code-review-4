# Band Tracker - Java Programming Code Review 4

###Author: John Dow

###Description: A web application that allows the user to input bands venues into a database.

###Download through GitHub

###URL: Download @ https://github.com/johndeezy/java-code-review-4.git

###Setup: Download through GitHub and run with gradle

###In PSQL:
CREATE DATABASE band_tracker;
CREATE TABLE bands (id serial PRIMARY KEY, name varchar, genre varchar);
CREATE TABLE venues (id serial PRIMARY KEY, venueName varchar, venueCity varchar, venueState varchar, venueCapacity int);

--OR--

CREATE DATABASE band_tracker;
psql band_tracker < band_tracker.sql 

###The MIT License (MIT)

Copyright (c) 2016 John Dow

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation
files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy,
modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
Software is furnished to do so, subject to the following conditions: The above copyright notice and this permission notice
shall be included in all copies or substantial portions of the Software. THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY
OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
