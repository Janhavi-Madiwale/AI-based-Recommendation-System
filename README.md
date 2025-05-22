# AI-based-Recommendation-System

COMPANY: CODETECH IT SOLUTIONS

NAME: JANHAVI KISHOR MADIWALE

INTERN ID: CT04DK899

DOMIAN: JAVA PROGRAMMING

DURATION: 4 WEEKS

MENTOR: NEELA SANTOSH

# 📊 AI-Based Recommendation System

A basic **user-based collaborative filtering** system in Java that recommends items to users based on similarity in preferences, using data from a `ratings.csv` file.

---

## 🔍 Overview

This AI-based recommendation system uses **cosine similarity** to analyze how similar users are based on their item ratings. It then recommends **top-2 unrated items** to a selected user.

---

## 📁 Dataset: `ratings.csv`

The input file `ratings.csv` contains user ratings for items. Each row represents a user, and each column an item.

### Example (`ratings.csv`):
5,3,0,1
4,0,2,1
1,1,5,5


- **Users:** 3  
- **Items:** 4  
- **Rating Scale:** 0–5  
- **0 means** the item was **not rated** by the user (candidate for recommendation).

---

## 🧠 How It Works

1. **Load ratings** from the CSV file.
2. **Compute cosine similarity** between the target user and all other users.
3. **Score unrated items** based on ratings of similar users.
4. **Recommend top-2** items with highest predicted scores.

---

## 💻 Technologies Used

- Java (Standard Edition)
- No external libraries – Pure Java
- AI Technique: **Collaborative Filtering** (User-Based)

---

## 🧪 How to Run

### 🧷 Requirements

- Java JDK 8 or above

### ▶️ Steps

1. **Ensure your file structure:**
    ```
    ├── RecommendationFromCSV.java
    └── ratings.csv
    ```

2. **Compile the Java program:**
    ```bash
    javac RecommendationFromCSV.java
    ```

3. **Run the program:**
    ```bash
    java RecommendationFromCSV
    ```

4. **Sample Output:**
    ```
![Screenshot 2025-05-14 131335](https://github.com/user-attachments/assets/462c30c0-b5e5-4f06-a179-6274df3fbeff)

---

## ⚙️ Project Logic Summary

- `loadRatingsFromCSV()` → Reads user-item ratings.
- `cosineSimilarity()` → Calculates similarity between two users.
- `getRecommendations()` → Scores unrated items and recommends top 2.

---

## 📌 Customization

| Feature                | How to Change                                     |
|------------------------|---------------------------------------------------|
| Number of recommendations | Modify `for (int i = 0; i < 2; i++)` in `getRecommendations()` |
| Input CSV path         | Edit `loadRatingsFromCSV("ratings.csv")`         |
| Similarity method      | Replace `cosineSimilarity()` with another metric |

---

## 🚀 Future Enhancements

- Switch to **item-based** collaborative filtering.
- Add support for real-time updates and larger datasets.
- Improve UI with a web frontend (JavaFX/Spring + REST API).
- Use **Pearson Correlation** or **machine learning models**.

---
