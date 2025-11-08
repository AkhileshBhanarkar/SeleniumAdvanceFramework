# DemoQA Automation Framework (Selenium + TestNG)

This is a Selenium Test Automation Framework built with **Java**, **TestNG**, and **Maven**.  
It demonstrates key automation concepts such as **Page Object Model (POM)**, **cross-browser execution**, **headless mode**, **screenshots on failure**, **logging**, and **reporting with ExtentReports** using the demo site [https://demoqa.com](https://demoqa.com).

---

## 🚀 Features
- **TestNG + Maven based framework**
- **Page Object Model (POM)**
- **Multiple browser support** (Chrome, Firefox)
- **Headless mode support**
- **Screenshot capture on test failure**
- **ExtentReports integration**
- **Custom utilities for WebDriver (Helpers)**
- **Logging using Log4j**
- **File upload & download, frames, drag & drop, multi-window handling**

---

## 🛠️ Prerequisites
Make sure the following are installed on your system:

1. **Java JDK 8 or later**  
   Verify installation:  
   ```bash
   java -version
   ```

2. **Maven 3.6+**  
   Verify installation:  
   ```bash
   mvn -version
   ```

3. **IDE** (IntelliJ IDEA / Eclipse / VS Code) with Maven support.

---

## 📂 Project Structure
```
DemoQA_Assignment_Advance
│── pom.xml                         # Maven dependencies & plugins
│── src
│   ├── main
│   │   ├── java
│   │   │   ├── driver/             # Driver initialization
│   │   │   ├── pages/              # Page classes (POM)
│   │   │   └── utils/              # Helpers, ExtentManager, Screenshot
│   │   └── resources/              # Log4j config, properties
│   └── test
│       ├── java
│       │   ├── tests/              # Test classes
│       │   └── listeners/          # TestNG Listeners
│       ├── resources/              # Test resources (files for upload)
│       └── suite.xml               # TestNG suite file
```

---

## ⚙️ Configuration
You can configure browser and headless mode via `testng.xml` or suite file.

Example:
```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
<suite name="DemoQA Suite" parallel="false">
    <parameter name="browser" value="chrome"/>
    <parameter name="headless" value="false"/>
    <test name="DemoQA Tests">
        <classes>
            <class name="tests.BrowserWindowsTest"/>
            <class name="tests.FramesTest"/>
            <class name="tests.DraggableTest"/>
            <class name="tests.UploadDownloadTest"/>
        </classes>
    </test>
</suite>
```

---

## ▶️ Running the Tests

1. **Clean and build the project**
   ```bash
   mvn clean install
   ```

2. **Run all tests using the default suite**
   ```bash
   mvn test
   ```

3. **Run with a specific suite file**
   ```bash
   mvn test -DsuiteXmlFile=src/test/suite.xml
   ```

---

## 📊 Reports & Logs
- **Extent Report**: Generated under `test-output/ExtentReports/`  
- **Logs**: Generated as per `logging_configuration.xml`  

---

## 🔧 Extending the Framework
- Add new pages in `src/main/java/pages`
- Add corresponding tests in `src/test/java/tests`
- Update `suite.xml` to include new test classes
- Use `Helpers` utility class for waits, scrolling, window switching, etc.

---

## 👨‍💻 Author
Assignment framework created for **DemoQA Selenium Automation**.
