# City Weather App 

![Weather App Logo](https://github.com/Parshuram-Behera/All-App-Images/assets/107804534/67c3895a-1cbe-4c42-a3c4-4411b73eb751
)

This Weather App is designed to provide real-time weather information for specific cities. It displays the weather details, cloud percentage, and weather icons for the chosen city. The app utilizes Retrofit for network calls and Gson Converter to convert the API response into Java objects. Moreover, it incorporates an SQLite database to store the last searched city weather.

## Features

- Get real-time weather details for specific cities
- Display cloud percentage and weather icons
- Store last searched city weather using SQLite database
- Developed entirely in Java and XML
- Utilizes WeatherAPI.com's API to fetch weather details

## Requirements

- Android Studio version X.X.X or later
- Minimum Android API level XX (XX% of devices currently support this)

## Installation

1. Clone the repository from [GitHub](https://github.com/yourusername/weather-app).
2. Open Android Studio.
3. Select "Open an existing Android Studio project."
4. Navigate to the location where you cloned the repository and click "OK."
5. Wait for the project to sync and build.
6. Connect your Android device or use an emulator.
7. Click on the "Run" button to install and launch the app on your device/emulator.

## How to Use

1. Upon launching the app, you'll see the home screen displaying a search bar and a button to initiate the search.
2. Enter the city name you want to check the weather for in the search bar.
3. Click on the "Search" button.
4. The app will fetch real-time weather details from WeatherAPI.com for the specified city.
5. Weather information, cloud percentage, and weather icons will be displayed on the screen.
6. The app will also store the last searched city's weather details in the SQLite database for future reference.

## Libraries Used

- Retrofit - [link to Retrofit](https://square.github.io/retrofit/)
- Gson Converter - [link to Gson Converter](https://github.com/square/retrofit/tree/master/retrofit-converters/gson)
- WeatherAPI.com API - [link to WeatherAPI](https://www.weatherapi.com/)

## Screenshots

Include some screenshots of your app here to showcase its features.

## Known Issues

- There might be occasional connectivity issues when fetching weather data due to network conditions.
- The app's UI could be enhanced and improved to provide a better user experience.

## Future Improvements

- Implement a more user-friendly UI with modern design principles.
- Add more features like weather forecasts for upcoming days.
- Allow users to save multiple cities and switch between them easily.
- Incorporate user settings to customize the app's behavior and appearance.

## Contributors

- [Your Name](https://github.com/yourusername) - Developer

## License

This project is licensed under the [MIT License](LICENSE). Feel free to use, modify, and distribute the code as per the terms of the license.

## Acknowledgments

- Thanks to WeatherAPI.com for providing the weather data API.
- Thanks to the developers of Retrofit and Gson Converter for their excellent libraries.
- Hat tip to anyone whose code was used as inspiration for this project.

---

_This readme template provides a basic structure to get you started. Feel free to customize it further based on your app's specific details and needs. Happy coding!_
