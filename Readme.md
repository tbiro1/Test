# World wonder test application.

### About the app:

This application lists the world's wonders (name, image, and short info about the wonder).

### Requirements:
* Android Studio: Android Studio Dolphin | 2021.3.1
* Java: Java 11

### About the architecture:

The architecture is a simple three-layer architecture (Data, Domain, UI).

* **Data layer:** Responsible for reading and writing data in the persistence storage.
* **Domain layer:** Responsible for the business logic.
* **UI layer:** The presentation logic and MVVM.

### Techs and libraries:

* **DI:** Dagger/Hilt
* **Navigation:** Jetpack navigation components/Coroutines
* **Presentation:** Android lifecycle components and Android Views (Paging V3)
* **Serialization:** GSON for Json.
* **Image loading:** Glide
* **Testing:** Mockk, Turbine