# FLINK-QA-TASK

### Project Dependencies

The project depends on the following components:
- Maven 3.5.x (Older version like 3.3 may also work)
- Groovy 2.4.x
- Geb 2.3.x
- Selenium 3.141.59

Run Cucumber tests:

    mvn clean test -Dgeb.env=chrome or mvn clean test -Dgeb.env=firefox