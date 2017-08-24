# Extension Modules for F.O.X Android SDK

## 1. Modules

* **supportEvents**<br>This module is the support library to measure In-App events by F.O.X Android SDK(Core)
<br><br>
* **supportCocos2dx**<br>This module is the wrapper code to call the functions of F.O.X Android SDK via JNI from Cocos2d-x.
<br><br>
* **supportUnity**<br>This module is the wrapper code to call the functions of F.O.X Android SDK via JNI from Unity.
<br><br>
* **supportUE**<br>This module is the wrapper code to call the functions of F.O.X Android SDK via JNI from UnrealEngine4.
<br><br>
* **supportUtil**<br>This module is the support library to extend the advertising measurement.

## 2. Integration

#### **Common**

```
repositories {
    maven {
        url "https://github.com/cyber-z/public-fox-android-sdk/raw/master/mavenRepo"
    }
}
```

### 2.1 supportEvents

**Dependency**
```
dependencies {
    compile 'co.cyberz.fox:track-core:4.x.x'
    compile `co.cyberz.fox.support:track-event:1.X.X`
}
```

### 2.2 supportCocos2dx

**Dependency**
```
dependencies {
    compile 'co.cyberz.fox:track-core:4.x.x'
    compile `co.cyberz.fox.support:track-cocos2dx:1.X.X`
}
```

### 2.3 supportUnity

**Dependency**
```
dependencies {
    compile 'co.cyberz.fox:track-core:4.x.x'
    compile `co.cyberz.fox.support:track-unity:1.X.X`
}
```

### 2.4 supportUE

**Dependency**
```
dependencies {
    compile 'co.cyberz.fox:track-core:4.x.x'
    compile `co.cyberz.fox.support:track-ue:1.X.X`
}
```

### 2.4 supportUtil

**Dependency**
```
dependencies {
    compile 'co.cyberz.fox:track-core:4.x.x'
    compile `co.cyberz.fox.support:util:1.X.X`
}
```