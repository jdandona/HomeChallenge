# 🧪 Monefy Mobile Automation

This is a test automation framework built using **Java**, **Appium**, and **TestNG** for automating mobile app testing of the Monefy expense tracker. The framework validates various user actions like adding/editing transactions, verifying balances, and updating categories.

---

## ⚙️ Setting Up the Mobile Test Framework

### 1. Install Prerequisites

Ensure the following tools are installed and properly configured:

- **Java 17+**
- **Maven**
- **Node.js + Appium**
- **Android SDK**
- **Android Emulator or Real Device**

Verify installation:

```bash
java -version
mvn -v
appium -v
```

---

### 2. Configure App & Device Settings

Edit the file:

```
src/test/resources/config/config.properties
```

Update the following as per your device/emulator:

- `platformVersion`
- `deviceName`
- `appPackage`
- `appActivity`

---

### 3. Resolve Maven Dependencies

At the root of this project, run:

```bash
mvn dependency:resolve
```

---

## ▶️ How to Run the Tests

Execute the tests via Maven with:

```bash
mvn test -DsuiteXmlFile=testng.xml
```

Or directly via your IDE using `testng.xml`.

---

## 📁 Folder Structure

```
Monefy-Mobile-Automation/
│
├── pom.xml                         → Maven project configuration
├── testng.xml                      → TestNG test suite
├── README.md                       → Project documentation
├── .gitignore
│
├── ServerLogs/
│   └── appiumLogs.log              → Appium server logs
│
├── Reports/
│   └── ExtentReport.html           → Rich HTML report generated after test execution
│
├── src/
│   ├── test/
│   │   ├── resources/
│   │   │   └── config/             → Config properties for device, platform, and app under test
│   │   └── java/tests/            → Test classes using TestNG
│   └── main/
│       ├── java/
│       │   ├── driver/            → Manages driver lifecycle (Driver, DriverFactory, DriverManager)
│       │   ├── constants/         → Global constants (FrameworkConstants.java)
│       │   ├── utils/             → Utilities like AppiumServer, Scroll, Interactions, Property reader
│       │   ├── pages/             → Page Object classes representing app screens
│       │   ├── base/              → Base classes for test and page logic
│       │   ├── listeners/         → TestNG listener for report integration
│       │   └── reports/           → ExtentReport setup and management
```

---

## 🧠 Component Overview

### 📄 Page Object Classes (`pages/`)

Implements the **Page Object Model (POM)** pattern. Each screen in the app is represented as a class with methods that define user interactions. Promotes clean separation of test logic and UI elements.

Classes include:

- `DashboardPage`, `BalancePage`, `NewExpensePage`, etc.

---

### 🧱 Base Classes (`base/`)

- `BasePage`: Shared mobile actions like click, type, scroll, wait.
- `BaseTest`: Common test setup and teardown logic (driver init, report config, etc.)

---

### ⚙️ Utility Classes (`utils/`)

Reusable helpers:

- `AppiumServer`: Starts and stops the Appium server programmatically.
- `AppInteractions`: Encapsulates interactions like tap, type, swipe.
- `PropertyUtils`: Reads configuration files.
- `Scroll`: Handles scroll gestures on mobile views.

---

### 🧷 Driver Management (`driver/`)

Handles Appium driver setup and lifecycle:

- `DriverFactory`, `DriverManager`, `Driver`

---

### 📢 Reporting & Listeners

- `ExtentReport`: Generates interactive HTML reports with logs and screenshots.
- `TestListener`: Implements `ITestListener` to capture test events and plug into reporting.

---

## 📊 Reports & Logs

- 🧾 HTML Report: `Reports/ExtentReport.html`
- 🧠 Appium Logs: `ServerLogs/appiumLogs.log`

---

## 💡 Why This Stack?

✅ **Java** – Robust, enterprise-ready, works seamlessly with Appium and TestNG.

✅ **Appium** – Industry-standard tool for automating Android/iOS apps.

✅ **TestNG** – Powerful test runner with parallel execution, annotations, and listeners.

✅ **ExtentReports** – Rich, interactive reporting framework integrated with listener support.

---
