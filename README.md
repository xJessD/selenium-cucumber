## Learning Selenium Cucumber Framework
# 
Following [this Step by Step](https://www.youtube.com/watch?v=4e9vhX7ZuCw&list=PLhW3qG5bs-L_mFHirOLEYJ7X2rIXu8SR2&index=1)

#### Notes
# 
A feature can have multiple scenarios

Steps using Gerkin language:
- Given
- When 
- And 
- Then 

Where we want to parameterize our inputs, and want to run multiple sets of values, we can create a scenario outline, and use examples to list the sets of data.  

Step Definition / Glue Code - basically functions with annotations. Can be created from scratch

When we have multiple scenarios and feature files, we want to gave a runner class. 

We can annotate our test runner to have:
- the source folder for tests
- a more readable output (monochrome = true)
- automatically generate a report in desired format to a folder (pretty)
- tag to run only that specific feature / scenario

```@CucumberOptions(features="src/test/resources/Features",
glue={"StepDefinitions"},
monochrome = true,
plugin={"pretty", "html:target/HtmlReports"})
```
#### Reporting
# 
There was an error generating a HTML report using
```
html:target/htmlReports
```
where only a .file type was created, rather than the HTML report. So this has been fixed by specifying the file name and type as well:
```
html:target/cucumber-report/cucumber.html
```

#### Driver.get() vs Driver.naviagte().to()
# 
While both do essentially the same thing, `navigate().to()` navigates to the URL via forward / backwards navigation. `get()` does this by refreshing. Using `navigate()` we can keep the browser history. while we lost this with `get()`.