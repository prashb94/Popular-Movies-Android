# Popular-Movies-Android-2017

Part 1 of the Popular Movies project for the Associate Android Developer Google certification by Udacity. To test it I've added the apk file directly in the root folder. You can clone the repo or download just the movies.apk file and try it out.

# Popular Movies

This is part 1 of the project that performs the simple task of querying the movie db database with the endpoints /movie/popular and /movie/top_rated ([The Movie Database](https://www.themoviedb.org/documentation/api)) and displaying movie details.

# Concepts Covered so far

* Recycler View, Adapters, ViewHolders
* Asynchronous Tasks
* Parsing JSON's
* Intents/New Activities
* Layouts
* Permissions
* Click Handling

## Features

* Discover the most popular and top rated movies
* See details such as vote count, average rating and movie synopsis.

## How to use

You have to use your own API key. Paste your api key into /src/main/java/com/prashanth/popularmovies/NetworkUtils.java in the API_KEY string field.

Import into Android Studio and let it auto-generate other required source files. Then you can run it immediately.

## Libraries

* Picasso - For loading and caching images

## Screens

![screen](../master/pics/phone-movies.png)

![screen](../master/pics/phone-details-1.png)

![screen](../master/pics/phone-details-2.png)

## License

    Copyright 2017 Prashanth.B

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
