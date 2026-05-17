# testapk

A starter Android app built with Kotlin + Jetpack Compose.

## Current Scope (MVP Skeleton)
This repository now includes:
- A simple Home screen
- A `HomeViewModel` with UI state (`StateFlow`)
- A primary action button that updates state
- Basic unit + UI test examples
- A GitHub Actions CI workflow

## Tech Stack
- Android Gradle Plugin 8.5.2
- Kotlin 2.0.21
- Jetpack Compose
- AndroidX Lifecycle
- JUnit4 / Compose UI Test

## Requirements
- Android Studio Koala or newer
- JDK 17
- Android SDK (compileSdk 35)

## Run Locally
1. Open project in Android Studio
2. Let Gradle sync complete
3. Run app on emulator/device

CLI:
```bash
chmod +x gradlew
./gradlew assembleDebug
```

## Project Structure
- `app/src/main/java/com/plx11/testapk/` - app UI and view model
- `app/src/test/` - local unit tests
- `app/src/androidTest/` - instrumentation / Compose UI tests
- `.github/workflows/` - CI workflows
- `docs/` - notes and planning docs

## Quality Checks
```bash
./gradlew lint
./gradlew test
./gradlew connectedAndroidTest
```

## Next Suggested Milestones
1. Add feature modules (`ui`, `domain`, `data`) as codebase grows
2. Add navigation + multiple screens
3. Introduce repository/data source layer
4. Add release signing + minify rules for production
