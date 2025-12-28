```# API Automation Framework – Cucumber BDD | Java | Rest Assured

This repository contains a **Cucumber BDD based API Automation Framework** built using **Java, Rest Assured, TestNG, and Maven**, with **Extent Reports** and **Log4j2 logging** integration.

The framework follows **industry-standard automation practices** and is designed for **scalability, reusability, and maintainability**.

---

## Tech Stack

- Programming Language: Java  
- API Automation: Rest Assured  
- BDD Framework: Cucumber  
- Test Runner: TestNG  
- Build Tool: Maven  
- Reporting: Extent Reports (Spark)  
- Logging: Log4j2  
- Version Control: Git & GitHub  

---

## Project Folder Structure

API-Automation-Framework
│
├── pom.xml
│
├── src
│ ├── main
│ │ └── resources
│ │ └── pojo
│ │ ├── Request POJO classes
│ │ └── Response POJO classes
│
│ └── test
│ ├── java
│ │ ├── Features
│ │ │ └── Feature files (.feature)
│ │ │
│ │ ├── stepDefinitions
│ │ │ └── Step definition classes
│ │ │
│ │ ├── Runners
│ │ │ └── Cucumber TestNG runner classes
│ │ │
│ │ ├── TestData
│ │ │ └── Test data builder classes
│ │ │
│ │ └── resources
│ │ └── Utility and helper classes
│ │
│ └── resources
│ ├── extent.properties
│ ├── extent-config.xml
│ └── log4j2.xml
│
├── logs
│ └── Execution logs
│
├── target
│ └── ExtentReports
│ └── ExtentReport.html
│
├── test-output
│ └── TestNG output files
│
├── logging.txt
│
└── README.md


---

## Key Features

- Cucumber BDD framework using Gherkin syntax  
- API automation using Rest Assured  
- POJO-based request and response handling  
- Reusable Request and Response Specifications  
- Extent Reports integration with detailed execution logs  
- Log4j2 logging for better debugging and traceability  
- Maven-based execution  
- Clean and modular framework design  
- CI/CD friendly structure  

---

## Test Implementation

### Feature Files
![Feature File](https://github.com/Sumit1694/bdd-api-automation-framework/raw/main/docs/FeatureFile.png)
- Written using Gherkin language  
- Location: src/test/java/Features


### Step Definitions
- Implements feature steps using Java  
- Uses Rest Assured for API execution  
- Location: src/test/java/stepDefinitions

### Test Runner
- Cucumber integrated with TestNG  
- Supports tag-based execution  
- Location: src/test/java/Runners
---

## Reporting – Extent Reports

- Extent Spark HTML report is generated after test execution  
- Includes scenario-level details, step logs, and execution status  
- Report location: target/ExtentReports/ExtentReport.html
---

## Logging – Log4j2

- Centralized logging using Log4j2  
- Configuration file: src/test/resources/log4j2.xml
- Logs generated under:

logs
---

## How to Execute Tests

### Using Maven

mvn clean test
---

### Using IDE (Eclipse / IntelliJ)

1. Navigate to: src/test/java/Runners
2. Right-click on the Test Runner class  
3. Select **Run as TestNG Test**

---

## pom.xml Dependencies

- Rest Assured  
- Cucumber Java  
- Cucumber TestNG  
- TestNG  
- Extent Reports  
- Log4j2  
- Jackson / Gson  

---

## .gitignore Recommendation

/target
/logs
/test-output
*.log
---

## Best Practices Followed

- BDD-driven automation approach  
- Clean code principles  
- Separation of concerns  
- Reusable utilities and components  
- Externalized configurations  
- Scalable framework architecture  

---

## Author

**Sumit Rane**  
Test Analyst | QA Automation Engineer  
4+ Years of Experience in Manual and Automation Testing  

---

## Support

If you find this project useful, feel free to ⭐ star the repository on GitHub.
```
