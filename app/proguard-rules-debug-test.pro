-include proguard-rules-debug.pro

# Proguard rules that are applied to your test apk/code.
-ignorewarnings

-dontshrink

-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable

-dontnote junit.framework.**
-dontnote junit.runner.**

-dontwarn android.test.**
-dontwarn android.support.test.**
-dontwarn org.junit.**
-dontwarn org.hamcrest.**
-dontwarn com.squareup.javawriter.JavaWriter

-keep class androidx.work.** { *; }
# Uncomment this if you use Mockito
#-dontwarn org.mockito.**