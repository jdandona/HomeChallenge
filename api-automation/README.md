# 🧪 Test Automation Framework

This is a test automation framework based on **Java** and **RestAssured** to automate RESTful APIs. Below are the details of the framework structure, setup, dependencies, and execution instructions. The tests target the **Swagger Petstore - OpenAPI 3.0** project for the **User** domain and are scalable for Pet, Store, or any additional domains.

---

## ⚙️ Setting Up the Test Automation Framework

### 1. Host Swagger Petstore - OpenAPI 3.0

- This framework runs against the locally hosted Swagger Petstore.
- Make sure Java 1.8 is installed. You can verify with:
  ```bash
  java -version
  ```

### 2. Install an IDE

Any Java IDE will work: **IntelliJ**, **Eclipse**, **VS Code**, etc.

### 3. Clone & Host the Petstore API

Clone the Swagger Petstore and run it on `localhost:8080` using:

```bash
mvn package jetty:run
```

### 4. Resolve Maven Dependencies

At the root of this project (where `pom.xml` exists), run:

```bash
mvn dependency:resolve
```

---

## ▶️ How to Run the Tests

Execute the following command:

```bash
mvn clean test -DsuiteXmlFile=src/test/resources/testng.xml
```

- There are two test classes containing 5 total tests (`@Test` methods).
- The tests are configured to run in **parallel** via `testng.xml`.
- The **ExtentReports** are generated at:

```
./api-automation/ExtentReport/Index.html
```

---

## 📁 Folder Structure

```plaintext
src/main/java/com/n26/
├── ApiActions/
│   ├── UserActions.java                  → CRUD operations on User domain.
├── ApiActionsManager/
│   ├── RequestSpecificationManager.java → Centralizes API request/response specs.
│   ├── RestAssuredActions.java          → Wrapper over RestAssured with logging/validation.
│   ├── UrlConstants.java                → Base and endpoint URLs.
├── CustomListener/
│   ├── TestngListener.java              → Hooks TestNG events into ExtentReports.
├── ExtentReportManager/
│   ├── ReportLogger.java                → Logging methods for ExtentReports.
│   ├── ReportManager.java               → Manages ExtentReports lifecycle using ThreadLocal.
├── TestInitiator/
│   ├── BaseTest.java                    → Initializes test context and core components.
│   ├── TestContext.java                 → Isolated test context for thread-safe execution.
├── enums/
│   ├── HeaderTypes.java                 → Enum for content-type headers.
│   ├── HttpStatusCode.java              → Enum for HTTP status codes.
├── UserApiModel/
│   ├── CreateUserRequest.java           → POJO for create user request.
│   ├── UpdateUserRequest.java           → POJO for update user request.
├── responseModel/
│   ├── CreateUserResponse.java          → POJO for create user response.
│   ├── GetUserResponse.java             → POJO for get user response.
│   ├── UpdateUserResponse.java          → POJO for update user response.

src/test/java/com/n26/
├── UserTests.java       → CRUD tests for User domain.
├── FailedUserTest.java  → Intentionally failing test for report visibility.
```

---

## 💡 Why This Tech Stack?

### ✅ Java

- Mature, widely adopted in enterprise environments.
- Seamless with **TestNG**, **RestAssured**, and **ExtentReports**.
- Strong typing, great structure, and modularity.

### ✅ RestAssured

- Designed for REST API testing in Java.
- Fluent, readable syntax for requests & assertions.
- Built-in serialization/deserialization.
- Integrated with request/response specs.
- Enhanced in this framework with `RestAssuredActions` for logging & validation.

### ✅ TestNG

- Robust test runner.
- Built-in support for parallel execution.
- Lifecycle annotations (`@BeforeMethod`, `@AfterMethod`).
- `ITestListener` hooks enable clean reporting.

### ✅ ExtentReports

- Visual, interactive test reports.
- Color-coded status, rich logs, stack traces.
- CI-friendly output, useful for both devs & stakeholders.

---

> This combination of technologies and architecture enables scalable, maintainable, and highly readable REST API test automation with a professional reporting output.
