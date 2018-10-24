cd mobile
java -jar $EVOSUITE -class com.github.cseppento.gradle.evosuite.testprojects.simple.SimpleStaticSut -projectCP build/classes/java/main/ -Duse_separate_classloader=false
