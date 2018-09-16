Android coding challenge
================================
## About
This is a coding assignment for a job application. It follows Google's guide to app architecture and is very much inspired by this [codelab](https://codelabs.developers.google.com/codelabs/build-app-with-arch-components/index.html). Libraries used in this project include Room for data persistence, ViewModel and LiveData for implementing a Lifecycle aware observer pattern.

## Structure of the code
The code is divided into three packages

### `data` package
Contains all classes related to local and network app data.

##### `data.network` package
Contains `ProductNetworkDataSource` class is the one responsible for fetching data from the network, but in fact the list of products is stored in JSON format in the `ProductsReponse` class and the networking is simply simulated by a `Thread.sleep()`

##### `data.database` package
Contains all the classes needed for the Room library. Specifically, it needs a model class (aka Entity), a database class and a DAO interface. The `AppRepository` class is the API by which all ViewModels in the app manipulate data either from network or database classes.


### `ui` package
All activities and adapters - anything to do with display.

Besides `MainActivity`, there are two packages `productList` and `productDetails` each corresponds to a screen in the app, and each of which contains a ViewModel and a ViewModelFactory class

### `utils` package
* `AppExecutors` a global executor pool.
* `DescriptionConverter` A utility class for converting `Product.Description` to String and vice versa. It uses the `Gson` library for this.
* `InjectorUtils` Basic dependency injection utility class.
