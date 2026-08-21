# LibMS - Library Management System

A lightweight, interactive Java console-based Library Management System built using Core Java and Object-Oriented Programming (OOP) principles.

---

## 📌 Features

- **Secure Login System:** Console password handling before entering the menu.
- **Interactive Menu:** Clean menu interface driven by `switch-case` logic.
- **Book Management:**
  - Add new books to the system library.
  - View all existing books with availability status.
  - Search books by title or ID.
  - Issue books to users.
  - Return issued books.

---

## 🏗 System Architecture
The project is structured following clean coding principles and modular design:

```text
LibMS/
├── Main.java            # Entry point & User Authentication
├── Menu.java            # UI Component & User Option Switching
├── Book.java            # Model Class (Encapsulation)
└── LibraryManager.java  # Business Logic (ArrayList Operations)
```

---

## 🛠 Class Breakdown

| Class | Purpose |
| :--- | :--- |
| **`Main.java`** | Handles program launch, console password checking, and initialization. |
| **`Menu.java`** | Displays options and routes requests using `switch-case`. |
| **`Book.java`** | Defines `id`, `title`, `author`, and `isAvailable` with getters, setters, and `toString()`. |
| **`LibraryManager.java`** | Manages the `ArrayList<Book>` data structure to perform search, add, issue, and return actions. |

---

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK 8 or higher) installed.

### How to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/YasithPraharshana/LibMS.git
   cd LibMS
   ```

2. **Compile the Java files:**
   ```bash
   javac Main.java
   ```

3. **Run the application:**
   ```bash
   java Main
   ```

4. **Default Credentials:**
   - Password: `Pass`

---

## ✨ Notes

- This project is for learning and practice purposes.
- You can extend it by adding file handling, database integration, or a GUI.
- Make sure all Java files are in the same folder when compiling.
```
