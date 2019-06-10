# Ankur Mishra Test

This project is Android application which involves scraping web data, Library used are.

  - RxJava 2
  - RetroFit 2
  - Scalars Retrofit converter

# Features

  - It consist of a button which initiate the request and update the data in respective UI.


# Architecture and Overview

  - I have used MVVM architecture using RXJava 2 Observer Pattern.
  - Instead of making multiple API request because URL was same I made single API call,
    but if required with different API could have used Composite Disposables or zipwith function.

