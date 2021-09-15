# Development

This project requires Java 11 and a ENV variable pointing to the Java 11 directory.

Eg. 

```
export JAVA_11_HOME='/Library/Java/JavaVirtualMachines/adoptopenjdk-11.jdk/Contents/Home'
```

in your .zshrc.

This repository was bootstrapped using:

> mvn archetype:generate -DarchetypeGroupId=ru.stqa.selenium -DarchetypeArtifactId=webdriver-junit-archetype -DarchetypeVersion=4.5 -DgroupId=meteorite -DartifactId=automation

Run 

> ./bin/firefox-dev.sh

from the project directory to start the tests.

#before run automation

* Need a Database

* Open Mysql & run the server

* run the test
