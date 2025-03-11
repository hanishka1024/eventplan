# Event Planner Android App

## 📌 Overview
The **Event Planner** app is an Android application that allows users to select an image, choose an event date, pick an event type, and select additional services like catering, photography, and live music. Users can submit their event details, and the app provides a summary of their selections.

## ✨ Features
- **Image Selection**: Users can select an image from their device gallery.
- **Date Picker**: Allows users to choose a date for the event.
- **Event Type Selection**: Users can select Wedding, Birthday, or Conference.
- **Additional Services**: Options to select Catering, Photography, and Live Music.
- **Form Submission**: Displays a summary of selected options via a toast message.

## 🛠 Tech Stack
- **Language**: Java
- **Framework**: Android SDK
- **UI Components**: LinearLayout, ImageButton, TextView, RadioGroup, CheckBox, Button

## 🚀 Setup & Installation
### Prerequisites
- Android Studio (latest version)
- Java Development Kit (JDK)
- Android Emulator or Physical Device

### Steps to Run the App
1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/event-planner.git
   ```
2. **Open in Android Studio**:
   - Open Android Studio and select `Open an Existing Project`.
   - Navigate to the cloned repository and open the project.
3. **Build & Run**:
   - Connect a physical device or start an emulator.
   - Click on **Run ▶️** to launch the application.

## 📂 Project Structure
```
EventPlanner/
│-- app/
│   │-- src/main/java/com/example/eventplan/
│   │   ├── MainActivity.java
│   │-- src/main/res/layout/
│   │   ├── activity_main.xml
│   │-- src/main/res/drawable/
│   │   ├── appbg2.png
│   │   ├── eventplanner2.png
│   │-- AndroidManifest.xml
│-- build.gradle
│-- README.md
```

## 📌 Usage Guide
1. **Select an image** by tapping on the image button.
2. **Pick an event date** using the "Pick Date" button.
3. **Choose the event type** from the available radio buttons.
4. **Select additional services** using checkboxes.
5. **Submit the form** to see a summary of selected options.

## 🐛 Troubleshooting
- Ensure you have **storage permissions** enabled for image selection.
- If the app crashes on launch, **rebuild the project** and check for missing dependencies.
- For emulator issues, ensure **Google Play Services** is installed.

## 🤝 Contributing
1. **Fork the repository**.
2. **Create a feature branch**:
   ```bash
   git checkout -b feature-branch
   ```
3. **Commit changes**:
   ```bash
   git commit -m "Added new feature"
   ```
4. **Push and create a pull request**:
   ```bash
   git push origin feature-branch
   ```

## 📜 License
This project is licensed under the MIT License.

