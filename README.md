# Backbase assignment

Manual Test cases file is saved in Assignment\test-sceanrios\Assignment_BB.xlsx

## Run project in OS window only
```
command is :
gradlew clean test aggregate -DtestData=test -Dcucumber.options="--tags @crud"

```
To run the project in mac or linux please add the browse binary file accordingly.
below is the command for mac and linux
gradle clean test aggregate -DtestData=test -Dcucumber.options="--tags @crud"

Report is saved in target folder and open the index.html file in browser
Assignment\target\site\serenity\index.html

## Intro
Serenity is an all in one solution for creating BDD tests. This repository 
is a seed project for implementing BDD without any additional platform specific
implementations.

All BDD test code (step definitions, runners) should be put in src/test/java and all helper code should be put in src/main/java.

#### Feature (for example coffee)
- Gherkin files (src/test/resources/features/)
- Feature runner with cucumber config (src/test/java nl.backbase.automation.runnner)
- Step definitions that implement the BDD steps (src/test/java nl.backbase.automation)
- Most features will also target StepDefinitions shared among all features (src/test/java nl.backbase.automation.shared)
```

@CucumberOptions(
        plugin = {"pretty"},
        /*
         * feature file or directory
        */
        features = "src/test/resources/features/",
        /*
         * packages that contain step definitions
        */
        glue = { "nl.backbase.automation"}
)

Here follows an example implementation:

First we need a json file that will contain a real value for each mocked value used in BDD.
The mock values in this example are "coffee" and "tea". 

src/test/resources/data/test.json
```json
{
  "foodItems": {
    "drinks": {
      "coffee": "Current coffee brand",
      "tea": "Current tea brand"
    }
  }
}
```


All data used in the BDD scenario's that are mocked should pass through a DataFactory implementation. By default
this DataFactory will return the passed mock value. 

```java
DataFactory.get("coffee", "foodItems.drinks.coffee");
// or
DataFactory.get("coffee", "foodItems", "drinks", "coffee");

// Both return "coffee"
```

The DataFactory can be activated by passing the following flag:
```bash
-DtestData=test.json
```

If the testData flag is set, the output will change:
```java
DataFactory.get("coffee", "foodItems.drinks.coffee");
// or
DataFactory.get("coffee", "foodItems", "drinks", "coffee");

// Both return "Current coffee brand"
```

To decouple the BDD implementation from the json structure a custom DataMapper should be created.

src/main/java/ FoodItemsMapper
```java
public String getDrink(String drink) {
    return (String) DataFactory.get(drink, "foodItems", "drinks", drink);
}
// Inside a BDD test:
getDrink("coffee");
// Returns either: "coffee" or "Current coffee brand" (based on flag)
```
To run only a particular feature or scenario and ignore others
    1.Add the tag to the feature or scenario in a feature
        Ex : 
        @feature=coffee
        Feature: Order a coffee
    2. Run the test by providing the feature tag
        Ex : gradle test aggregate -Dcucumber.options="--tags @feature=coffee" (Mac or Windows)
            ./gradlew test aggregate -Dcucumber.options="--tags @feature=coffee" (Linux)
    More Information can be found here : https://johnfergusonsmart.com/running-serenity-bdd-tests-with-tags/
