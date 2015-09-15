# f15-android-pokedex-api
## Installation & Usage
### Install Retrofit
[Retrofit](http://square.github.io/retrofit/) is HTTP client for android that allows easy access to loads of JSON-based API calls and interact with how most modern apps are runned and powered by.

To install retrofit, simply include these libraries to your gradle file under the app folder:
```
compile 'com.squareup.retrofit:retrofit:1.9.0'
compile 'com.squareup.okhttp:okhttp-urlconnection:2.0.0'
compile 'com.squareup.okhttp:okhttp:2.0.0'
```
Note: Currently Retrofit is doing a major overhaul and is currently at version 2.00beta1. Once it becomes more stable this will be updated to teach the latest and greatest ways to access api calls.

### Using Retrofit & Pokedex API
To use retrofit, you must create a interface for the url and the type of data ( Java Object ) the api call will return.
