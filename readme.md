# CoderSchool Final Project - *Fastfood Finder*

[![Build Status](https://travis-ci.org/HCMUSAssignmentWarehouse/FastFoodFinder.svg?branch=develop)](https://travis-ci.org/HCMUSAssignmentWarehouse/FastFoodFinder) 
[![codecov](https://codecov.io/gh/HCMUSAssignmentWarehouse/FastFoodFinder/branch/develop/graph/badge.svg)](https://codecov.io/gh/HCMUSAssignmentWarehouse/FastFoodFinder)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/5ae8369fb08c4d009d6fd95ce752b23c)](https://www.codacy.com/app/nhoxbypass/FastFoodFinder?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=HCMUS-AssignmentWarehouse/FastFoodFinder&amp;utm_campaign=Badge_Grade)

**Fastfood Finder** is an awesome android app that allows a users to find some fast food stores or convinient stores around where their standing. And with this app he can do the other fantastic things.

The source code is well-programmed with **MVP architecture, SOLID principle & lots of design patterns**.

Time spent: **180** hours spent in total

## User Stories

The basic **required** functionality:

* [x] Show the splash screen and do the robust check for Internet connection.
* [x] Locate current user's position by GPS or 3g, wifi. If can not detect, get user's past location.
* [x] Show top 10 nearest stores by marking on the maps in the first tab. 
* [x] Show list of 10 nearest store in bottom sheet below the map, sort ascending by the distance from user to this store. User can click on each item to show the way to this store (routing). 
* [x] Swipe to "recent" tab. Show recently tab that searched or selected by user.
* [ ] Have a button to quickly show the nearest store base on user settings
* [x] If user have logged in, user can swipe to the "Favourited" tab, to show list of stores that user visited and favourited.
* [ ] User can filter stores that display in map by pressing the filter icon in Toolbar, and fulfill the Filter dialog.
* [x] User can click on a store in the map to show the basic detail, overview of this store to determine to go or choose another store.
* [ ] User can navigate to other activity to see the list of district, and some advanced filter. User can select and see the list of stores fit user need.


The **extended** features are implemented:

* [x] User can toggle navigation drawer to see their profile. If user doesn't logged in. They can loggin by email, gmail or facebook.
* [x] User can toggle the navigation drawer to select "Last visit", "Profile Detail", "Favourite list", "Settings", etc,...
* [ ] Update to newest stores data, user can routing event dont have Internet
* [x] User can search for store name, addresses,... in the search view in toolbar

The **advance** features are implemented:

* [ ] User can add new place that they liked
* [x] Sort stores base on location. Type of store.
* [x] User can sit at home and choose a specified location (use pin of google maps or lat/long) to list the store nearest.
* [ ] User can orders and wait for their food to be shipped to their home. (If stores provided this services)

## Video Walkthrough

Here's a walkthrough of implemented user stories:

https://www.youtube.com/watch?v=QSXAEoJX9t8

## Notes

Describe any challenges encountered while building the app.

## Open-source libraries used

- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java
- [Glide](https://github.com/bumptech/glide) - An image loading and caching library for Android
- [Butter Knife](http://jakewharton.github.io/butterknife/) - Field and method binding for Android views

## License

    Copyright 2016 4TripleF

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
