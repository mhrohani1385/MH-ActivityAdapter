# MH-ActivityAdapter
Simple example kotlin Android Studio :: one adapter from run a task in transparent background activity from an service and more...
You can use this feature in Pending intent of Android Notifications

#H2 For download demo APK file [**Click here**](https://github.com/mhrohani1385/MH-ActivityAdapter/raw/7cf2eb5be2673147b69f5d75bce572b493154f05/app-debug.apk)

Add this lines to your project style.xml


```xml

    <!-- transparent style -->

    <style name="Theme.Transparent" parent="Theme.MaterialComponents.DayNight.NoActionBar">
        <item name="android:windowIsTranslucent">true</item>
        <item name="android:statusBarColor" tools:targetApi="lollipop">@android:color/transparent</item>
        <item name="android:windowBackground">@android:color/transparent</item>
    </style>

```
    
And add this lines in your AndroidManifest.xml 

```xml

<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="ir.zarin_android.runtaskinbackgroundacitivity">

    <application
        ...
        >
        
        <activity android:name...>
            ...
        </activity>



        <!-- add run task activity and set theme -->
        
        <activity android:name=".RunActivityTask"
            android:theme="@style/Theme.Transparent"
            />

    </application>

</manifest>

```

Example ActivityRunnable object for call 



```kotlin

   object : RunActivityTask.ActivityRunnable {
                    override fun run(activity: RunActivityTask) {
                    
                    
                    
                        // Run your task here .
                        Handler(Looper.getMainLooper()).postDelayed(
                                {



                                    // Show Toast For Test
                                    Toast.makeText(this@MainActivity,"Task runned",Toast.LENGTH_LONG).show()

                                    // Once you are sure that your task is done
                                    activity.closeActivity()




                                },1000
                        )




                     }
                 }
```

For more see the [MainActivity.kt](https://github.com/mhrohani1385/MH-ActivityAdapter/blob/main/app/src/main/java/ir/zarin_android/runtaskinbackgroundacitivity/MainActivity.kt)
 demo
