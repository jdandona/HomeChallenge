# **N26 Home Challenge – QA Test Report**

### **Overview**

This document outlines exploratory test charters, bugs, observations, and recommendations from a series of structured QA sessions focused on validating the core features of the N26 app. The goal was to identify functionality issues, usability flaws, and computational errors in various modules.

---

**All Charters in this report are listed in ascending order of priority, with the most critical Charter appearing first.**

---

## **Charter Overview & Exploration Timeline**

| **Charter** | **Focus Area**                                     | **Time Dedicated** |
| ----------- | -------------------------------------------------- | ------------------ |
| Charter 101 | Calculator Functionality                           | 30 Minutes         |
| Charter 102 | Add/Delete Income & Expense, Interval Calculations | 45 Minutes         |
| Charter 103 | Category Management (Edit, Merge, Delete)          | 30 Minutes         |
| Charter 104 | Account Management (Add, Edit, Merge)              | 45 Minutes         |
| Charter 105 | Settings & Language/Data Preferences               | 20 Minutes         |

---

## **Charter 101: Calculator Functionality**

### **Objective:**

Validate input handling, result computation, and overall UI functionality for the in-app calculator.

### **Bugs**

1. **Incorrect Calculation Result**
   - **Steps:**
     1. Go to **Add Expense**
     2. Enter: `50.05 + 100 =`
     3. Result: `150.05`
     4. Now type `55`
     5. Output: `15060` → ❌ **Incorrect**
   - **Expected:** Should update correctly based on the input expression.

### **Observations**

- Input and note keyboards overlap and remain simultaneously active.
- Users may unintentionally type in both input fields due to partial keyboard visibility.

---

## **Charter 102: Income/Expense & Time Interval Calculations**

### **Objective:**

Verify the addition/deletion of income/expenses and accurate categorization and time-based calculations.

### **Bugs**

1. **Total Percentage Exceeds 100%**

   - **Steps:**
     1. Go to **Add Expense**
     2. Enter an expense for multiple categories.
     3. Check the dashboard and calculate the total percentage.
     4. **Result:** Total percentage exceeds 100% (e.g., 101%).
   - **Expected:** Total percentage should not exceed 100%.

2. **Duplicate Interval Entries**
   - **Steps:**
     1. Go to the **Left panel**.
     2. Click on "interval" > Select interval > enter `15–25th` range > save.
     3. Repeat the above step.
     4. Click on the interval – two entries for the same interval are visible.
   - **Expected:** Should not allow duplicate entries.

### **Observations**

- **Issue with Interval Selection:**
  - User cannot delete or select previously saved intervals, leading to unexpected overwriting of intervals.

---

## **Charter 103: Category Management**

### **Objective:**

Test user ability to manage categories (enable/disable, edit, merge, delete) and ensure accurate calculation across them.

### **Bugs**

1. **Unable to Prevent Adding Amount to Disabled Category**
   - **Prerequisite:** A category with an amount should be present.
   - **Steps:**
     1. Go to the right panel and select **Categories**.
     2. Choose a category with an amount.
     3. Unselect the "Enable" checkbox.
     4. Go back to the categories list. The selected category should be grayed out.
     5. Navigate back to the dashboard. The category remains visible.
     6. Attempt to add an amount to the disabled category.
   - **Expected:** Disabled categories should not allow users to add an amount.

### **Observations**

- User should have an option to revert category merge changes.
- User should get a warning before performing a category merge.
- Disabled categories should be completely hidden in the dashboard, not just styled differently.

---

## **Charter 104: Account Management**

### **Objective:**

Explore adding, merging, and editing accounts, and verify their impact on balance calculations.

### **Bugs**

1. **No Way to Change Transfer or Add Notes After Entering Amount**

   - **Steps:**
     1. Open the app and navigate to **New Transfer**.
     2. Enter an amount in the first large green input field.
     3. After entering the amount, no option is available to edit the transfer details or add notes.
     4. The only available option is **Add Transfer**.
   - **Expected:** User should be able to go back and add notes or edit details before confirming the transfer.

2. **Default Account Name Missing**
   - **Steps:**
     1. Go to the right menu > Account > Add+.
     2. Select an icon from the options.
     3. The input field shows the placeholder text "Name," which doesn’t change upon selecting an icon.
   - **Expected:** The account name should automatically reflect the account's category when an icon is selected.

### **Observations**

- **"Account must be different" Error Message Appears Incorrectly:**
  This error should appear when both dropdown fields have the same account selected, not when the user clicks on the amount field.

- **Duplicate Account Name Allowed During Account Creation:**
  The app allows multiple accounts with the same name, which could create confusion. This needs validation to prevent duplicates.

---

## **Charter 105: Settings & Language/Data Preferences**

### **Objective:**

Evaluate settings, language preferences, and backup/restore functionalities.

### **Bugs**

1. **Language Change Not Applied to Number Formatting**
   - **Steps:**
     1. Open the app and navigate to **Settings**.
     2. Change the language to **Deutsch**.
     3. Go back to the **Dashboard**.
     4. Change the language to **English**.
     5. Return to the **Dashboard**.
   - **Expected:** Number formatting should update according to the selected language (e.g., decimal separators should switch between `,` and `.` as per locale).

---

## **Risk Mitigation & Recommendations**

- **Regression Suite:**
  Ensure all explored tests are added to the regression suite to avoid negatively affecting previously functioning features.

- **Automation Prioritization:**
  Automate critical tests identified during QA, ensuring they are run with every merge request to catch issues early.

- **Test Management Tool:**
  Report all discovered bugs in a test management tool (e.g., Jira) to ensure proper tracking and prevent bugs from being overlooked.

- **Communication:**
  Maintain strong communication between QA, PM, and EM to ensure alignment on bug prioritization, timelines, and acceptance criteria.

- **Future Enhancements:**
  For non-urgent bugs, consider them as potential future enhancements and prioritize them accordingly.

- **High-Risk Areas:**
  Focus on high-risk areas such as complex calculations and account management for thorough exploratory testing in future releases.

---
