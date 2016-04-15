# Android-Firebase-Custom-Auth-Java
An android project which implements all java libraries and code required for Firebase auth with custom token.

## To build a similar project yourself from scratch:

* Create new android studio project.

* In your app `build.gradle` file under android add
```java
    packagingOptions {
      exclude 'META-INF/LICENSE'
      exclude 'META-INF/LICENSE-FIREBASE.txt'
      exclude 'META-INF/NOTICE'
    }
```

* In your app `build.gradle` file under dependencies add
```java
    compile 'com.firebase:firebase-client-android:2.5.2+'
```

* Sync project with gradle files (you may find a button to do so in andorid studio action bar)

* In your `AndroidManifest.xml` add
```java
    <uses-permission android:name="android.permission.INTERNET" />
```

* Under `MyApplication/app/libs` add
```java
    commons-codec-1.7.jar
    json-20090211.jar
```
    (You may find these files in the same location in this project)

* Under `MyApplication/app/src/java/<your_application>` add Folder
```java
    FirebaseTokenGenerator
```
    (You may find these files in the same location in this project

* Copy required code from MainActivity to your desired activity in your project

* Add your firebase link and secret in your strings.xml (or in some class if you are planning to better obfuscate these strings.)
